package djy.find;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/14 0014.
 */
public class Find_QuanTianJianDu extends Activity {
    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_quantianjiandu);
    }
    public void doClick(View view){
        finish();
    }
}
