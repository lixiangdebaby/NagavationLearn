package learn.com.ui.newone;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import learn.com.nagavationlearn.R;

/**
 * Created by lixiang on 2017/1/7.
 */

public class FragmentNewOne extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newonefragment,container,false);
        return view;
    }
}
