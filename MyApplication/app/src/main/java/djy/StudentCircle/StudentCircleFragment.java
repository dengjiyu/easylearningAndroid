package djy.StudentCircle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class StudentCircleFragment extends Fragment {

    private GridView gvHome1;
    private String[] mItems1 = new String[]{"Java社", "篮球社", "轮滑社", "电竞社", "天文社", "电影社","动漫社","实践社","足球社","爱美术"};
    private String[] mNum = new String[]{"小白的聚集地", "Come Baby!", "你敢来吗", "可否一战？", "想和你数星星", "电影爱好者", "二次元的世界", "喜欢那个地方", "皇马？巴萨？", "用笔勾勒世界"};
    private int[] mPics1 = new int[]{R.drawable.s_java, R.drawable.s_lanqiu, R.drawable.s_lunhua, R.drawable.s_dianjin, R.drawable.s_tianwen, R.drawable.s_dianying, R.drawable.s_dongman, R.drawable.s_shijian, R.drawable.s_zuqiu, R.drawable.s_meishu    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.studentcircle, container, false);

        GridView gvHome1 = (GridView) view.findViewById(R.id.gv_home1);
        //3.加载适配器
        gvHome1.setAdapter(new HomeAdpter1());


        return view;
    }


    //第二个GridView的适配器
    class HomeAdpter1 extends BaseAdapter {

        //展示2行两列一共8个
        @Override
        public int getCount() {
            return mItems1.length;
        }

        @Override
        public Object getItem(int position) {
            return mItems1[position];
        }

        public long getItemId(int position) {
            return position;
        }

        //先初始化好、然后一次一次往回回调
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //getContext():HomeFragment.this不好使。
            View view = View.inflate(getContext(), R.layout.home_list_item2, null);
            ImageView ivItem1 = (ImageView) view.findViewById(R.id.iv_item1);
            TextView tvItem1 = (TextView) view.findViewById(R.id.tv_item1);
            TextView num = (TextView) view.findViewById(R.id.tv_item2);


            tvItem1.setText(mItems1[position]);
            num.setText(mNum[position]);
            ivItem1.setImageResource(mPics1[position]);
            return view;
        }
    }

}
