package djy.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/8 0008.
 */
public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater mInflater;


    public final class ListItemView {                //构造方法
        public ImageView a;
        public TextView b;
        public ImageView c;

    }

    public MyCustomAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        mInflater = LayoutInflater.from(context);   //创建视图容器并设置上下文
        this.listItems = listItems;

    }


    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //自定义视图
        ListItemView listItemView = null;
        if (convertView == null) {
            //获取list_item布局文件的视图
            convertView = mInflater.inflate(R.layout.home_activity_item, null);//View未被实例化，缓冲池中也无缓存
        }
        {
            listItemView = new ListItemView();
            //获取控件对象
            listItemView.a = (ImageView)convertView.findViewById(R.id.pic);
            listItemView.b = (TextView)convertView.findViewById(R.id.text);
            listItemView.c = (ImageView)convertView.findViewById(R.id.pic1);


            listItemView.a.setImageResource((Integer) listItems.get(position).get("pic"));
            listItemView.b.setText((String) listItems.get(position).get("text"));
            listItemView.c.setImageResource((Integer) listItems.get(position).get("pic1"));


        }
        return convertView;
    }
}

