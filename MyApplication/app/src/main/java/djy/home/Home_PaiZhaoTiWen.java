package djy.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class Home_PaiZhaoTiWen extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //1.新建适配器
    private MyCustomAdapter listViewAdapter;
    private List<Map<String, Object>> listItems;

    private int[] imageids = {R.drawable.t_shuxue1, R.drawable.t_yingyu1,
            R.drawable.t_huaxue1, R.drawable.t_wuli1, R.drawable.t_zhengzhi1};
    private String[] list_title = {"高中数学", "初中英语", "高中化学", "高中物理", "高中政治"};
    private String[] list_con = {"求这道题的解法，谢谢机制的小伙伴啦!!!", "必采纳，求学霸帮忙...", "在线等学霸解答、挺急的、谢谢!", "浓浓情意，丝丝柔情",
            "有人会吗?", "大神在哪里，速求!"};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_paizhaotiwen);



        // 绑定ListView
        ListView listView = (ListView) findViewById(R.id.listView);

        //2.适配器加载数据源
        listItems = getListItems();//循环遍历
        listViewAdapter = new MyCustomAdapter(this, listItems);

        //3.SimpleAdapter方法：视图（ListView）加载适配器
        listView.setAdapter(listViewAdapter);

        //列表监听器方法
        listView.setOnItemClickListener(this);

    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //控件ID,集合名
            map.put("pic", imageids[i]);//控件ID,集合名
            map.put("text", list_title[i]);
            map.put("text1", list_con[i]);
            listItems.add(map);
        }
        return listItems;
    }

    /*
        1.点击ListView的响应事件
        2.Activity向Activity中传递数据
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                break;
            case 1:
                Toast.makeText(Home_PaiZhaoTiWen.this, "快点开发服务端！！！", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }

        public void houtui4(View view){
        finish();
    }

    /*
        启动相机功能
     */
//    public void paizhao(View view){
//        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
//        if (state.equals(Environment.MEDIA_MOUNTED)){   //如果可用
//            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//            startActivity(intent);
//        }else {
//            Toast.makeText(Home_PaiZhaoTiWen.this,"sdcard不可用",Toast.LENGTH_SHORT).show();
//        }
//    }

    public void paizhao(View view){
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)){   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
        }else {
            Toast.makeText(Home_PaiZhaoTiWen.this,"sdcard不可用",Toast.LENGTH_SHORT).show();
        }
    }

//    public void doClick3(View view){
//        Intent intent = new Intent(Home_PaiZhaoTiWen.this, NewsFragment.class);
//        startActivity(intent);
//        finish();
//    }

}


