package learn.com.viewdrag;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * PackageName:learn.com.viewdraghelper.view
 * Author：carlos created on 2016/12/26 16:11
 * Mail: lixiangdebaby@gmail.com
 */

public class CustomerViewDragHelp extends LinearLayout{
    /*
    * ViewDragHelper 类是用来实现一个类的拖动，这个类提供了一些供用户拖动和重新置位一个view的方法。
    * 使用工厂类来创建它的实例.
    * ViewDragHelper.Callback 这个类是ViewDragHelper用来与其父View进行通信的
    * */
    ViewDragHelper mViewDragHelper;
    View mDragView;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    public CustomerViewDragHelp(Context context, AttributeSet attrs){
        super(context,attrs);
        /*this表示当前ViewGroup*/
        /*1.0f,灵敏度，数越大越灵敏*/
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            //这个方法是必须重写的方法，如果允许拖动child 这个view,则返回true，直接返回true,则所有的view都允许拖动
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }
            /*这个方法是限制在水平方向上的拖动。child 是要拖动的view,left是沿着x轴想要拖动的距离。dx是最后拖动的距离
            * 在这个方法中控制水平方向上拖拽的边界
            * */
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                final  int leftBound = getPaddingLeft();
                final  int rightBound = getWidth()-leftBound - child.getWidth();
                final  int dragLeft = Math.min(Math.max(left,leftBound),rightBound);
                return dragLeft;
            }
            /*限制在垂直方向上的拖动,这个方法控制垂直方向上的拖拽范围*/
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                final  int topBound = getPaddingTop();
                final  int bottomBound = getHeight() - topBound - child.getHeight();
                final  int dragTop = Math.min(Math.max(top,topBound),bottomBound);
                return dragTop;
            }
        });

    }
    @Override
    protected  void onFinishInflate(){
        super.onFinishInflate();
        mDragView = getChildAt(0);
    }
}
