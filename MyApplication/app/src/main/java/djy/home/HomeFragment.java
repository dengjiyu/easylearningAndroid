//package djy.home;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.ViewFlipper;
//
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/4/21 0021.
// */

//
//    private GridView gvHome;
//    //1.准备数据源
//    private String[] mItems = new String[]{"学习监督", "拍照问题", "资料", "推荐应用"};
//    private int[] mPics = new int[]{R.drawable.img_home1, R.drawable.img_home2, R.drawable.img_home3, R.drawable.img_home4};
//
//
//    //定义ViewFlipper，
//    private ViewFlipper flipper;
//    private int[] resId = {R.drawable.ad1, R.drawable.ad2, R.drawable.ad3};
//    private float starX;
//
//    private GridView gridView;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.home, container, false);
//
//        flipper = (ViewFlipper) view.findViewById(R.id.flipper);
//        //动态导入的方式为ViewFlipper加入子View
//        for (int i = 0; i < resId.length; i++) {
//            flipper.addView(getImageView(resId[i]));
//        }
//
//        //为ViewFlipper去添加动画效果
//        flipper.setInAnimation(getContext(), R.anim.left_in);
//        flipper.setOutAnimation(getContext(), R.anim.left_out);
//        //为ViewFlipper设定视图切换的时间间隔
//        flipper.setFlipInterval(2000);
//        //开始播放
//        flipper.startFlipping();
//
//
//        //将GridView(ID:gv_home)进行绑定
//        final GridView gvHome = (GridView) view.findViewById(R.id.gv_home);
//        //3.加载适配器
//        gvHome.setAdapter(new HomeAdpter());
//        //设置监听（根据position去选择要跳转到哪一个）
//        //注意：position的位置下标从0开始
//        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        //Fragment跳转Activity的使用，获得上下文用：getActivity()
//                        startActivity(new Intent(getActivity(),Home_XueXiJianDu.class));
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//                        break;
//
//                    default:
//                        break;
//                }
//            }
//        });
//
//
//        return view;
//
//    }
//
//    //添加图片信息
//    private ImageView getImageView(int resId) {
//        ImageView image = new ImageView(getContext());
//        //image.setImageResource(resId);
//        image.setBackgroundResource(resId);
//        return image;
//    }
//
//    //2.新建适配器
//    class HomeAdpter extends BaseAdapter {
//
//        //展示2行两列一共8个
//        @Override
//        public int getCount() {
//            return mItems.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mItems[position];
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        //先初始化好、然后一次一次往回回调
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View view = View.inflate(getContext(), R.layout.home_list_item, null);
//            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
//            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);
//
//            tvItem.setText(mItems[position]);
//            ivItem.setImageResource(mPics[position]);
//            return view;
//        }
//    }
//
//
//}


//
//package djy.home;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/4/21 0021.
// */

//
//
//
//
//
//
//    private GridView gvHome;
//    //1.准备数据源
//    private String[] mItems = new String[]{"学习监督", "拍照问题", "资料", "推荐应用"};
//    private int[] mPics = new int[]{R.drawable.img_home1, R.drawable.img_home2, R.drawable.img_home3, R.drawable.img_home4};
//
//    private GridView gridView;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.home, container, false);
//
//        //将GridView(ID:gv_home)进行绑定
//        final GridView gvHome = (GridView) view.findViewById(R.id.gv_home);
//        //3.加载适配器
//        gvHome.setAdapter(new HomeAdpter());
//        //设置监听（根据position去选择要跳转到哪一个）
//        //注意：position的位置下标从0开始
//        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        //Fragment跳转Activity的使用，获得上下文用：getActivity()
//                        startActivity(new Intent(getActivity(), Home_JiShiXueXi.class));
//                        break;
//                    case 1:
//
//                        break;
//                    case 2:
//                        break;
//
//                    default:
//                        break;
//                }
//            }
//        });
//
//
//
//
//        return view;
//
//    }
//
//
//
//
//
//    //2.新建适配器
//    class HomeAdpter extends BaseAdapter {
//
//        //展示2行两列一共8个
//        @Override
//        public int getCount() {
//            return mItems.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mItems[position];
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        //先初始化好、然后一次一次往回回调
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View view = View.inflate(getContext(), R.layout.home_list_item, null);
//            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
//            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);
//
//            tvItem.setText(mItems[position]);
//            ivItem.setImageResource(mPics[position]);
//            return view;
//        }
//    }
//
//
//}


package djy.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    //好友圈子动态适配器
    private ViewPager mViewPager0;
    //ViewPager的初始化需要一个适配器
    private FragmentPagerAdapter mAdapter0;
    private List<Fragment> mFragments0 = new ArrayList<>();

    //对底部五个面板进行申明
    private LinearLayout mTabHome0;
    private LinearLayout mTabCart0;
    private LinearLayout mTabClassify0;

    private ImageButton mHomeImg0;
    private ImageButton mCartImg0;
    private ImageButton mClassifyImg0;


    //1.准备数据源
    private String[] mItems = new String[]{"学习监督", "拍照问题", "资料", "推荐应用"};
    private int[] mPics = new int[]{R.drawable.img_home1, R.drawable.img_home2, R.drawable.img_home3, R.drawable.img_home4};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        mViewPager0 = (ViewPager) view.findViewById(R.id.id_viewpager0);
        //tabs
        mTabHome0 = (LinearLayout) view.findViewById(R.id.id_tab_home0);
        mTabCart0 = (LinearLayout) view.findViewById(R.id.id_tab_cart0);
        mTabClassify0 = (LinearLayout) view.findViewById(R.id.id_tab_classify0);

        //ImageButton
        mHomeImg0 = (ImageButton) view.findViewById(R.id.id_tab_home_img0);
        mCartImg0 = (ImageButton) view.findViewById(R.id.id_tab_cart_img0);
        mClassifyImg0 = (ImageButton) view.findViewById(R.id.id_tab_classify_img0);


        intView();//1.初始化View  2.使用PagerAdapter 3.加载适配器
        initEvents();//底部5个面板的点击事件

        //将GridView(ID:gv_home)进行绑定
        final GridView gvHome = (GridView) view.findViewById(R.id.gv_home);
        //3.加载适配器
        gvHome.setAdapter(new HomeAdpter());
        //设置监听（根据position去选择要跳转到哪一个）
        //注意：position的位置下标从0开始
        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //Fragment跳转Activity的使用，获得上下文用：getActivity()
                        startActivity(new Intent(getActivity(), Home_XueXiJianDu.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), Home_PaiZhaoTiWen.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), Home_ZiLiao.class));
                        break;

                    default:
                        break;
                }
            }
        });


        return view;

    }

    private void initEvents() {

        mTabHome0.setOnClickListener(this);
        mTabCart0.setOnClickListener(this);
        mTabClassify0.setOnClickListener(this);

        //监听页面变化的监听器：当页面滑动时，下方tab的图标由暗色的切换为有颜色的图标
        //必须重写三个方法、这里只需要用到第二个方法：进行页面滑动时，图标的变化
        mViewPager0.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager0.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mHomeImg0.setImageResource(R.drawable.dongtai_1);
                        break;

                    case 1:
                        mCartImg0.setImageResource(R.drawable.xuexi_1);
                        break;

                    case 2:
                        mClassifyImg0.setImageResource(R.drawable.yule_1);
                        break;

                    default:
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void intView() {
        //    final GridView gvHome = (GridView) view.findViewById(R.id.gv_home);


        mFragments0 = new ArrayList<Fragment>();
        Fragment mtab01 = new dongtai();
        Fragment mtab02 = new xuexi();
        Fragment mtab03 = new yule();

        mFragments0.add(mtab01);
        mFragments0.add(mtab02);
        mFragments0.add(mtab03);

        //PagerAdapter的使用，首先继承pageradapter至少要重写以下四种方法
        //当Fragment相互嵌套时，应使用getChildFragmentManager()替换getSupportFragmentManager()
        mAdapter0 = new FragmentPagerAdapter(getChildFragmentManager()) {
            // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
            public int getCount() {
                return mFragments0.size();
            }

            public Fragment getItem(int arg0) {
                return mFragments0.get(arg0);
            }

        };

        //为ViewPager设置Adapter
        mViewPager0.setAdapter(mAdapter0);
    }

    @Override
    //点击事件：当点击对应的布局时（底部的5个布局，而不是单纯的点击一个图片或者文字）时,切换为对应的页面，并将底部tab的暗图标转换为亮图标
    public void onClick(View v) {
        resetImg();

        switch (v.getId()) {
            case R.id.id_tab_home0:
                mViewPager0.setCurrentItem(0);
                mHomeImg0.setImageResource(R.drawable.dongtai_1);
                break;

            case R.id.id_tab_cart0:
                mViewPager0.setCurrentItem(1);
                mCartImg0.setImageResource(R.drawable.xuexi_1);
                break;

            case R.id.id_tab_classify0:
                mViewPager0.setCurrentItem(2);
                mClassifyImg0.setImageResource(R.drawable.yule_1);
                break;


            default:
                break;
        }

    }

    /*
    将所有的图片切换为暗色
     */
    private void resetImg() {
        mHomeImg0.setImageResource(R.drawable.dongtai_2);
        mCartImg0.setImageResource(R.drawable.xuexi_2);
        mClassifyImg0.setImageResource(R.drawable.yule_2);
    }



    //2.新建适配器
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

            View view = View.inflate(getContext(), R.layout.home_list_item, null);
            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);

            tvItem.setText(mItems[position]);
            ivItem.setImageResource(mPics[position]);
            return view;
        }
    }


}
