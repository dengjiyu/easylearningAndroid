package djy.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/14 0014.
 */
public class Home_XueXiJianDu extends AppCompatActivity{

    private List<String> list = new ArrayList<String>();
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home_xuexijiandu);

            // 第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
            list.add("自我监督");
            list.add("他人监督");
            mySpinner = (Spinner) findViewById(R.id.spinner);
            // 第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            // 第三步：为适配器设置下拉列表下拉时的菜单样式。
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // 第四步：将适配器添加到下拉列表上
            mySpinner.setAdapter(adapter);
            // 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
            mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    // TODO Auto-generated method stub
                        /* 将所选mySpinner 的值带入myTextView 中 */

                    //myTextView.setText("您选择的是：" + adapter.getItem(arg2));
                    //Toast.makeText(Home_XueXiJianDu.this, "您选择的是：" + adapter.getItem(arg2), Toast.LENGTH_SHORT).show();
                    if(adapter.getItem(arg2)=="他人监督"){
                        startActivity(new Intent(Home_XueXiJianDu.this, Home_TaRenJianDu.class));
                        //getFragmentManager().findFragmentById().getView().findViewById(id);


                    }

                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                    //myTextView.setText("NONE");
                    Toast.makeText(Home_XueXiJianDu.this, "您没有做任何操作", Toast.LENGTH_SHORT).show();
                }
            });

        }

    public void houtui1(View view){

        finish();
    }

    public void doClick(View view){
       startActivity(new Intent(Home_XueXiJianDu.this,Home_JiShiXueXi_ziyou.class));
    }

}
