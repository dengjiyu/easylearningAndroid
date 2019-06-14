package djy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import djy.login.Login;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class SplashActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final Intent intent=new Intent();
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                intent.setClass(SplashActivity.this,Login.class);
                SplashActivity.this.startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, 1000 * 3);
    }
}
