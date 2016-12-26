package learn.com.nagavationlearn;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    NavigationView mNavigationView;
    DrawerLayout mDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationView = (NavigationView)findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new MyNavigationItemSelectedListener());
        mDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.app_name, R.string.app_name);
        toggle.syncState();

    }
    class MyNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.action_share){

            }
            DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        //按返回键时，判断一下navigation 的状态，如果是打开状态，则关闭
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
