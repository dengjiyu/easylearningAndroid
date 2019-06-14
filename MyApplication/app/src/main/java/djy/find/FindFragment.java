package djy.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class FindFragment extends Fragment {


    //1.准备数据源
    private String[] mItems = new String[]{"任务", "定时", "早起", "早睡", "全天监督", "倒数日", "电台", "休闲一刻"};
    private int[] mPics = new int[]{R.drawable.img_find1, R.drawable.img_find2, R.drawable.img_find3, R.drawable.img_find4, R.drawable.img_find5, R.drawable.img_find6, R.drawable.img_find7, R.drawable.img_find8};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.find, container, false);

        //将GridView(ID:gv_home)进行绑定
        final MyGridView gvFind = (MyGridView) view.findViewById(R.id.gv_find);
        //3.加载适配器
        gvFind.setAdapter(new HomeAdpter());
        //设置监听（根据position去选择要跳转到哪一个）
        gvFind.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        //Fragment跳转Activity的使用，获得上下文用：getActivity()
                        startActivity(new Intent(getContext(), Find_QuanTianJianDu.class));
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;

                    default:
                        break;
                }
            }
        });


        return view;


    }

    //2.新建适配器,重写BaseAdapter的四个方法
    class HomeAdpter extends BaseAdapter {

        //展示2行两列一共8个
        @Override
        public int getCount() {
            return mItems.length;
        }

        @Override
        public Object getItem(int position) {
            return mItems[position];
        }

        public long getItemId(int position) {
            return position;
        }

        //先初始化好、然后一次一次往回回调
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(getContext(), R.layout.home_list_item1, null);
            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);

            tvItem.setText(mItems[position]);
            ivItem.setImageResource(mPics[position]);
            return view;
        }
    }


}
