package djy.my;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import djy.login.Login;
import djy.myapplication.R;

/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class SheZhi extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_shezhi);


    }

    public void doClick1(View view){
        SharedPreferences spout = SheZhi.this.getSharedPreferences("userInfo", 0);
        SharedPreferences.Editor ed = spout.edit();
        ed.clear();
        ed.commit();

        //点击退出登录、返回到登录页面
        Intent intent = new Intent(SheZhi.this, Login.class);
        startActivity(intent);
       finish();
    }

    public void houtui5(View view){
        finish();
    }
}
