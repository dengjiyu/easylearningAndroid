package djy.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import djy.myapplication.MainActivity;
import djy.myapplication.R;

public class Home_JiShiXueXi_ziyou extends Activity {
    private NumberPicker numberpicker_hour = null;
    private NumberPicker numberpicker_min = null;
    private NumberPicker numberpicker_sec = null;
    private Button Button_start = null;
    private Toast toast = null;
    private int hour = 0, min = 0, sec = 0, time = 0;
    private int music1;
    private SoundPool sp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_jishixuexi_ziyou);
        sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 8);
        music1 = sp.load(this, R.raw.sound_view_focused_or_selected, 1);

        numberpicker_hour = (NumberPicker) findViewById(R.id.numberPicker1);
        numberpicker_hour
                .setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal,
                                              int newVal) {
                        // TODO Auto-generated method stub
                        hour = numberpicker_hour.getValue();
                        sp.play(music1, 1, 1, 0, 0, 1);
                    }
                });
        numberpicker_hour.setOnScrollListener(new NumberPicker.OnScrollListener() {

            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                // TODO Auto-generated method stub
                // sp.play(music1, 1, 1, 0, 0, 1);
            }
        });
        numberpicker_hour.setMaxValue(10);
        numberpicker_hour.setMinValue(0);
        numberpicker_hour.setValue(0);

        numberpicker_min = (NumberPicker) findViewById(R.id.numberPicker2);
        numberpicker_min.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                // TODO Auto-generated method stub
                min = numberpicker_min.getValue();
                sp.play(music1, 1, 1, 0, 0, 1);
            }
        });
        numberpicker_min.setOnScrollListener(new NumberPicker.OnScrollListener() {

            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                // TODO Auto-generated method stub
                // sp.play(music1, 1, 1, 0, 0, 1);
            }
        });
        numberpicker_min.setMaxValue(59);
        numberpicker_min.setMinValue(0);
        numberpicker_min.setValue(0);

        numberpicker_sec = (NumberPicker) findViewById(R.id.numberPicker3);
        numberpicker_sec.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                // TODO Auto-generated method stub
                sec = numberpicker_sec.getValue();
                sp.play(music1, 1, 1, 0, 0, 1);
            }
        });
        numberpicker_sec.setOnScrollListener(new NumberPicker.OnScrollListener() {

            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                // TODO Auto-generated method stub
                // sp.play(music1, 1, 1, 0, 0, 1);
            }
        });
        numberpicker_sec.setMaxValue(59);
        numberpicker_sec.setMinValue(0);
        numberpicker_sec.setValue(0);

        Button_start = (Button) findViewById(R.id.button1);
        Button_start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                time = hour * 60 * 60 + min * 60 + sec;
                Intent intent = new Intent();
                intent.setClass(Home_JiShiXueXi_ziyou.this, ClcokActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("sectime", time);
                intent.putExtras(bundle);
                startActivity(intent);
                Home_JiShiXueXi_ziyou.this.finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "关于").setIcon(
                R.drawable.ic_launcher);
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "退出").setIcon(
                R.drawable.ic_launcher);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {

            case Menu.FIRST + 1:
                toast = Toast.makeText(this,
                        "This is a countdown program @copyright by HenryHoo", 5000);
                toast.show();
                break;
            case Menu.FIRST + 2:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

public void doClick(View view){
    switch (view.getId()){
        case R.id.do4:
            finish();
            break;
        default:

            break;
    }

}

}
