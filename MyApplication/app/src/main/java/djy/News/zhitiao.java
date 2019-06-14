package djy.News;
//
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
//public class zhitiao extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.news_zhitiao, container, false);
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

public class zhitiao extends Fragment implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>> dataList;
    private int[] imageids = { R.drawable.head22};
    private String[] list_title = {"系统通知"};
    private String[] list_con ={"欢迎加入这个大家庭，我相信你们..."};
    private String[] list_time ={"5:30"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_zhitiao, null);
        listView= (ListView) view.findViewById(R.id.msgListView1);
        dataList=new ArrayList<Map<String,Object>>();
        simp_adapter=new SimpleAdapter(getActivity(),getData(),R.layout.l_msg_list_item1,
                new String[] {"headListImage","msgListName","msgContent","msgListTime"},new int[]{R.id.headListImage1,R.id.msgListName1,R.id.msgContent1,R.id.msgListTime1});
        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    private List<Map<String, Object>> getData() {

        for (int i = 0; i < 1; i++) {
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
                intent.setClass(getActivity(), SysNotifyActivity.class);
                getActivity().startActivity(intent);
                break;
            default:
                break;
        }

    }
}
