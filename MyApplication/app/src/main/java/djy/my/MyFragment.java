package djy.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class MyFragment extends Fragment implements AdapterView.OnItemClickListener {

    //1.新建适配器
    private MyCustomAdapter listViewAdapter;
    private List<Map<String, Object>> listItems;

//    private int[] imageids = {R.drawable.my_xuebiduihuan, R.drawable.my_xuexiqingkuang,
//            R.drawable.my_zuoyewenda, R.drawable.my_shouchang, R.drawable.my_yejianmoshi, R.drawable.my_shezhi};
    private int[] imageids = {R.drawable.my__1, R.drawable.my__2,
            R.drawable.my__3, R.drawable.my__4, R.drawable.my__5, R.drawable.my__6};
    private String[] list_title = {"学币兑换", "学习情况", "作业问答", "我的收藏", "夜间模式",
            "应用设置"};
    private int[] imageids1 = {R.drawable.my_jiantou, R.drawable.my_jiantou,
            R.drawable.my_jiantou, R.drawable.my_jiantou, R.drawable.my_jiantou, R.drawable.my_jiantou};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my, container, false);


        // 绑定ListView
        ListView listView = (ListView) view.findViewById(R.id.listView);

        //2.适配器加载数据源
        listItems = getListItems();//循环遍历
        listViewAdapter = new MyCustomAdapter(getContext(), listItems);//调用自己写的MyCustomAdapter重写BaseAdpter

        //3.SimpleAdapter方法：视图（ListView）加载适配器
        listView.setAdapter(listViewAdapter);

        //醉了...不管在Activity中还是在Fragment中设施ListView，都得先注册监听器啊...
        listView.setOnItemClickListener(this);

        return view;
    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 6; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //控件ID,集合名
            map.put("pic", imageids[i]);//控件ID,集合名
            map.put("text", list_title[i]);
            map.put("pic1", imageids1[i]);
            listItems.add(map);
        }
        return listItems;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Toast.makeText(getContext(), "开发中...", Toast.LENGTH_SHORT).show();
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;

            default:
                Intent intent = new Intent(getContext(),SheZhi.class);
                startActivity(intent);


                break;
        }
    }
}




