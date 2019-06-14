package djy.News;

//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//
//
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/5/21 0021.
// */
//public class haoyou extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.news_haoyou, container, false);
//        return view;
//    }
//}

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import djy.myapplication.R;

public class haoyou extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>> dataList;
    private int[] imageids = { R.drawable.head1, R.drawable.head3,
            R.drawable.head4, R.drawable.head5,R.drawable.head6,R.drawable.head7,R.drawable.head8,R.drawable.head9,R.drawable.head10,R.drawable.head11 };
    private String[] list_title = {"东软霸霸","鹏鹏","大神","天依旧蓝","小宝宝"};
    private String[] list_con ={"你好~~~","你好~~~","你好~~~","你好~~~","你好~~~"};
    private String[] list_time ={"5:30","7:00","12:45","14:00","15:54"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_haoyou, null);
        listView= (ListView) view.findViewById(R.id.msgListView);
        dataList=new ArrayList<Map<String,Object>>();
        //SimpleAdapter()
        /*
        * context:上下文
        * data:数据源 (List<? extends Map<String,?>>data) 一个map所组成的List集合
        * 每一个Map都会去对应ListView列表中的一行
        * 每一个Map(键-值对)中的键必须包含所有在from中所制定的键
        * resource:列表项的布局文件ID
        * from:Map中的键名
        * to:绑定数据视图中的ID，与from成对应关系
        * */
        simp_adapter=new SimpleAdapter(getActivity(),getData(),R.layout.l_msg_list_item,
                new String[] {"headListImage","msgListName","msgContent","msgListTime"},new int[]{R.id.headListImage,R.id.msgListName,R.id.msgContent,R.id.msgListTime});
        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    private List<Map<String, Object>> getData() {

        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("headListImage", imageids[i]);
            map.put("msgListName", list_title[i]);
            map.put("msgContent", list_con[i]);
            map.put("msgListTime", list_time[i]);
            dataList.add(map);
        }
        return dataList;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), ChatActivity.class);
                getActivity().startActivity(intent);
                break;
            case 1:
                intent.setClass(getActivity(), ChatActivity_1.class);
                getActivity().startActivity(intent);
                break;
            case 2:
                intent.setClass(getActivity(), ChatActivity_2.class);
                getActivity().startActivity(intent);
                break;
            case 3:
                intent.setClass(getActivity(), ChatActivity_3.class);
                getActivity().startActivity(intent);
                break;
            case 4:
                intent.setClass(getActivity(), ChatActivity_4.class);
                getActivity().startActivity(intent);
                break;
            default:
                break;
        }

    }
}
