package djy.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/25 0025.
 */
public class NewsFragment extends Fragment implements View.OnClickListener {
    private ImageButton bt1;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news, container, false);

        mViewPager0 = (ViewPager) view.findViewById(R.id.id_viewpager2);
        //tabs
        mTabHome0 = (LinearLayout) view.findViewById(R.id.id_tab_home2);
        mTabCart0 = (LinearLayout) view.findViewById(R.id.id_tab_cart2);
        mTabClassify0 = (LinearLayout)view.findViewById(R.id.id_tab_classify2);

        //ImageButton
        mHomeImg0 = (ImageButton)view.findViewById(R.id.id_tab_home_img2);
        mCartImg0 = (ImageButton) view.findViewById(R.id.id_tab_cart_img2);
        mClassifyImg0 = (ImageButton)view.findViewById(R.id.id_tab_classify_img2);

        intView();//1.初始化View  2.使用PagerAdapter 3.加载适配器
        initEvents();//底部5个面板的点击事件

        //添加好友
        bt1 = (ImageButton) view.findViewById(R.id.tianjiahoayou);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddFriends.class);
                startActivity(intent);
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
                        mHomeImg0.setImageResource(R.drawable.zhitiao1);
                        break;

                    case 1:
                        mCartImg0.setImageResource(R.drawable.quanzi1);
                        break;

                    case 2:
                        mClassifyImg0.setImageResource(R.drawable.haoyou1);
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

        mFragments0 = new ArrayList<Fragment>();
        Fragment mtab01 = new zhitiao();
        Fragment mtab02 = new quanzi();
        Fragment  mtab03 = new haoyou();

        mFragments0.add(mtab01);
        mFragments0.add(mtab02);
        mFragments0.add(mtab03);

        //PagerAdapter的使用，首先继承pageradapter至少要重写以下四种方法
        //当Fragment相互嵌套时，应使用getChildFragmentManager()替换getSupportFragmentManager()
        mAdapter0 = new FragmentPagerAdapter(getChildFragmentManager() ) {
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
            case R.id.id_tab_home2:
                mViewPager0.setCurrentItem(0);
                mHomeImg0.setImageResource(R.drawable.zhitiao1);
                break;

            case R.id.id_tab_cart2:
                mViewPager0.setCurrentItem(1);
                mCartImg0.setImageResource(R.drawable.quanzi1);
                break;

            case R.id.id_tab_classify2:
                mViewPager0.setCurrentItem(2);
                mClassifyImg0.setImageResource(R.drawable.haoyou1);
                break;

            default:
                break;
        }

    }

    /*
    将所有的图片切换为暗色
     */
    private void resetImg() {
        mHomeImg0.setImageResource(R.drawable.zhitiao2);
        mCartImg0.setImageResource(R.drawable.quanzi2);
        mClassifyImg0.setImageResource(R.drawable.haoyou2);

    }



}
