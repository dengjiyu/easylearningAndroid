package djy.News;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import djy.myapplication.R;

public class SysNotifyActivity extends AppCompatActivity {

    private ListView listView;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>> dataList;
    private String[] list_title = {"【公告】欢迎加入这个大家庭,我相信你们会度过有意义的时光","【公告】今天也要努力学习，珍惜宝贵的时间哦~"};
    private String[] list_time ={"5:30","7:00"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();

        setContentView(R.layout.l_activity_sys_notify);
        listView= (ListView) findViewById(R.id.sysNotifyList);
        dataList=new ArrayList<Map<String,Object>>();
        simp_adapter=new SimpleAdapter(SysNotifyActivity.this,getData(), R.layout.l_sys_notify_list_item,
                new String[] {"sysNotifyListTitle","sysNotifyListTime"},new int[]{R.id.sysNotifyListTitle,R.id.sysNotifyListTime});
        listView.setAdapter(simp_adapter);
    }
    private List<Map<String, Object>> getData() {

        for (int i = 0; i < 2; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sysNotifyListTitle", list_title[i]);
            map.put("sysNotifyListTime", list_time[i]);
            dataList.add(map);
        }
        return dataList;
    }
}
