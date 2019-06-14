package djy.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import djy.myapplication.MainActivity;
import djy.myapplication.R;

public class ClcokActivity extends Activity {
    private int time = 0, a = 0;
    private Chronometer meter = null;
    private TextView textiew_timeleft = null;
    private TextView textview_show = null;
    private TextView textview_ale = null;
    ProgressBar progressBar = null;
    private SoundPool sp;
    private int music1, music2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        time = bundle.getInt("sectime");
        sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 8);
        music1 = sp.load(this, R.raw.sound_ringer_normal, 1);
        music2 = sp.load(this, R.raw.click, 1);

        textiew_timeleft = (TextView) findViewById(R.id.textView_timeleft);
        textview_show = (TextView) findViewById(R.id.textView2);
        textview_ale = (TextView) findViewById(R.id.textView4);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setMax(time);

        meter = (Chronometer) findViewById(R.id.chronometer1);
        meter.setBase(SystemClock.elapsedRealtime());
        meter.start();
        meter.setOnChronometerTickListener(new OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                // TODO Auto-generated method stub
                if (time > 0) {
                    time--;
                    textiew_timeleft.setText(time + "s");
                    progressBar.setProgress(time);
                    sp.play(music2, 1, 1, 0, 0, 1);
                    if (time == 0) {
                        // meter.stop();
						textview_show.setText("时间到");
						textview_ale.setText("时间到！请点击菜单返回");
                        sp.play(music1, 1, 1, 0, 0, 1);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "返回").setIcon(
                R.drawable.ic_launcher);
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "退出").setIcon(
                R.drawable.ic_launcher);

        return true;
    }

    @SuppressLint("ShowToast")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {

            case Menu.FIRST + 1:
                Intent intent = new Intent();
                intent.setClass(ClcokActivity.this, MainActivity.class);
                startActivity(intent);
                ClcokActivity.this.finish();
                break;
            case Menu.FIRST + 2:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            dialog();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void doClick(View view){
        switch (view.getId()){
            case R.id.do1:
                dialog();
                break;

            case R.id.do2:
                Intent intent = new Intent(ClcokActivity.this,Home_ZiLiao.class);
                startActivity(intent);
                break;

            default:
                Intent intent1 = new Intent(ClcokActivity.this,Home_PaiZhaoTiWen.class);
                startActivity(intent1);
                break;
        }


    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ClcokActivity.this);
        builder.setMessage("确定要退出学习吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("取消",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        builder.setNegativeButton("确定",
                new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ClcokActivity.this.finish();
                    }
                });
        builder.create().show();
    }
}
