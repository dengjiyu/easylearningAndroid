package djy.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
//import android.support.v4.app.Fragment;这个包对于Fragment有时候系统会导错、记得检查
public class xuexi extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_xuexi, container, false);
        return view;
    }
}
