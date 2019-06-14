//package djy.home;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/5/20 0020.
// */
//public class Home_TaRenJianDu extends Fragment implements View.OnClickListener  {
//
//    private ViewPager mViewPager0;
//    //ViewPager的初始化需要一个适配器
//    private FragmentPagerAdapter mAdapter0;
//    private List<Fragment> mFragments0 = new ArrayList<>();
//
//    //对底部五个面板进行申明
//    private LinearLayout mTabHome0;
//    private LinearLayout mTabCart0;
//    private LinearLayout mTabClassify0;
//
//    private ImageButton mHomeImg0;
//    private ImageButton mCartImg0;
//    private ImageButton mClassifyImg0;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.home_tarenjiandu, container, false);
//
//
//        mViewPager0 = (ViewPager) view.findViewById(R.id.id_viewpager3);
//        //tabs
//        mTabHome0 = (LinearLayout) view.findViewById(R.id.id_tab_home2);
//        mTabCart0 = (LinearLayout) view.findViewById(R.id.id_tab_cart2);
//        mTabClassify0 = (LinearLayout)view.findViewById(R.id.id_tab_classify2);
//
//        //ImageButton
//        mHomeImg0 = (ImageButton)view.findViewById(R.id.id_tab_home_img2);
//        mCartImg0 = (ImageButton)view.findViewById(R.id.id_tab_cart_img2);
//        mClassifyImg0 = (ImageButton)view.findViewById(R.id.id_tab_classify_img2);
//
//
//        intView();//1.初始化View  2.使用PagerAdapter 3.加载适配器
//        initEvents();//底部5个面板的点击事件
//
//
////        int i = this.getIntent().getIntExtra("flag",0);
////        if()
//        return view;
//
//
//    }
//
//    private void initEvents() {
//        mTabHome0.setOnClickListener(this);
//        mTabCart0.setOnClickListener(this);
//        mTabClassify0.setOnClickListener(this);
//
//        //监听页面变化的监听器：当页面滑动时，下方tab的图标由暗色的切换为有颜色的图标
//        //必须重写三个方法、这里只需要用到第二个方法：进行页面滑动时，图标的变化
//        mViewPager0.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                int currentItem = mViewPager0.getCurrentItem();
//                resetImg();
//                switch (currentItem) {
//                    case 0:
//                        mHomeImg0.setImageResource(R.drawable.t_haoyou1);
//                        break;
//
//                    case 1:
//                        mCartImg0.setImageResource(R.drawable.t_banji1);
//                        break;
//
//                    case 2:
//                        mClassifyImg0.setImageResource(R.drawable.t_jiating1);
//                        break;
//
//
//                    default:
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }
//
//    private void intView() {
//
//        mFragments0 = new ArrayList<Fragment>();
//        Fragment mtab01 = new TRJD_haoyou();
//        Fragment mtab02 = new TRJD_jiating();
//        Fragment  mtab03 = new TRJD_banji();
//
//        mFragments0.add(mtab01);
//        mFragments0.add(mtab02);
//        mFragments0.add(mtab03);
//
//        //PagerAdapter的使用，首先继承pageradapter至少要重写以下四种方法
//        //当Fragment相互嵌套时，应使用getChildFragmentManager()替换getSupportFragmentManager()
//        mAdapter0 = new FragmentPagerAdapter(getChildFragmentManager()) {
//            // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
//            public int getCount() {
//                return mFragments0.size();
//            }
//
//            public Fragment getItem(int arg0) {
//                return mFragments0.get(arg0);
//            }
//
//        };
//
//        //为ViewPager设置Adapter
//        mViewPager0.setAdapter(mAdapter0);
//    }
//
//    @Override
//    //点击事件：当点击对应的布局时（底部的5个布局，而不是单纯的点击一个图片或者文字）时,切换为对应的页面，并将底部tab的暗图标转换为亮图标
//    public void onClick(View v) {
//        resetImg();
//
//        switch (v.getId()) {
//            case R.id.id_tab_home3:
//                mViewPager0.setCurrentItem(0);
//                mHomeImg0.setImageResource(R.drawable.t_haoyou1);
//                break;
//
//            case R.id.id_tab_cart3:
//                mViewPager0.setCurrentItem(1);
//                mCartImg0.setImageResource(R.drawable.t_jiating1);
//                break;
//
//            case R.id.id_tab_classify3:
//                mViewPager0.setCurrentItem(2);
//                mClassifyImg0.setImageResource(R.drawable.t_banji1);
//                break;
//
//            default:
//                break;
//        }
//
//    }
//
//    /*
//    将所有的图片切换为暗色
//     */
//    private void resetImg() {
//        mHomeImg0.setImageResource(R.drawable.t_haoyou2);
//        mCartImg0.setImageResource(R.drawable.t_jiating2);
//        mClassifyImg0.setImageResource(R.drawable.t_banji2);
//
//    }
//
//}
//package djy.home;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.View;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.SimpleAdapter;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/5/20 0020.
// */
//public class Home_JiShiXueXi extends Activity {
//
//    AlertDialog menuDialog;// menu菜单Dialog
//    GridView menuGrid;
//    View menuView;
//
//    String[] menu_name_array = {"白名单", "监督模式", "学习监督说明", "学习方式说明"};
//    String[] menu_name_array2 = {"学习中可以使用的应用", "剽悍模式", "使用说明", "使用说明"};
//
//
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_jishixuexi);
//
//        ImageView view = (ImageView)findViewById(R.id.shezhi1);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                menuView = View.inflate(Home_JiShiXueXi.this, R.layout.gridview_menu, null);
//                // 创建AlertDialog
//                menuDialog = new AlertDialog.Builder(getApplication()).create();
//                menuDialog.setView(menuView);
//
//                menuGrid = (GridView) menuView.findViewById(R.id.gridview);
//                menuGrid.setAdapter(getMenuAdapter(menu_name_array, menu_name_array2));
//                /** 监听menu选项 **/
//            }
//        });
//
//
//    }
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add("menu");// 必须创建一项
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    private SimpleAdapter getMenuAdapter(String[] menuNameArray,
//                                         String[] imageResourceArray) {
//        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
//        for (int i = 0; i < menuNameArray.length; i++) {
//            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("itemImage", imageResourceArray[i]);
//            map.put("itemText", menuNameArray[i]);
//            data.add(map);
//        }
//        SimpleAdapter simperAdapter = new SimpleAdapter(this, data,
//                R.layout.item_menu, new String[]{"itemImage", "itemText"},
//                new int[]{R.id.item_image, R.id.item_text});
//        return simperAdapter;
//    }
//
//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (menuDialog == null) {
//            menuDialog = new AlertDialog.Builder(this).setView(menuView).show();
//        } else {
//            menuDialog.show();
//        }
//        return false;// 返回为true 则显示系统menu
//    }
//
//
//}


package djy.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Home_TaRenJianDu extends FragmentActivity implements View.OnClickListener {

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

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tarenjiandu);

        intView();//1.初始化View  2.使用PagerAdapter 3.加载适配器
        initEvents();//底部5个面板的点击事件


    }


    private void intView() {


        mViewPager0 = (ViewPager) findViewById(R.id.id_viewpager3);
        //tabs
        mTabHome0 = (LinearLayout) findViewById(R.id.id_tab_home3);
        mTabCart0 = (LinearLayout) findViewById(R.id.id_tab_cart3);
        mTabClassify0 = (LinearLayout) findViewById(R.id.id_tab_classify3);

        //ImageButton
        mHomeImg0 = (ImageButton) findViewById(R.id.id_tab_home_img3);
        mCartImg0 = (ImageButton) findViewById(R.id.id_tab_cart_img3);
        mClassifyImg0 = (ImageButton) findViewById(R.id.id_tab_classify_img3);

        mFragments0 = new ArrayList<Fragment>();
        Fragment mtab01 = new TRJD_haoyou();
        Fragment mtab02 = new TRJD_jiating();
        Fragment mtab03 = new TRJD_banji();

        mFragments0.add(mtab01);
        mFragments0.add(mtab02);
        mFragments0.add(mtab03);

        //PagerAdapter的使用，首先继承pageradapter至少要重写以下四种方法
        //当Fragment相互嵌套时，应使用getChildFragmentManager()替换getSupportFragmentManager()
        mAdapter0 = new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                        mHomeImg0.setImageResource(R.drawable.t_haoyou1);
                        break;

                    case 1:
                        mCartImg0.setImageResource(R.drawable.t_jiating1);
                        break;

                    case 2:
                        mClassifyImg0.setImageResource(R.drawable.t_banji1);
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

    @Override
    //点击事件：当点击对应的布局时（底部的5个布局，而不是单纯的点击一个图片或者文字）时,切换为对应的页面，并将底部tab的暗图标转换为亮图标
    public void onClick(View v) {
        resetImg();

        switch (v.getId()) {
            case R.id.id_tab_home3:
                mViewPager0.setCurrentItem(0);
                mHomeImg0.setImageResource(R.drawable.t_haoyou1);
                break;

            case R.id.id_tab_cart3:
                mViewPager0.setCurrentItem(1);
                mCartImg0.setImageResource(R.drawable.t_jiating1);
                break;

            case R.id.id_tab_classify3:
                mViewPager0.setCurrentItem(2);
                mClassifyImg0.setImageResource(R.drawable.t_banji1);
                break;

            default:
                break;
        }

    }

    /*
    将所有的图片切换为暗色
     */
    private void resetImg() {
        mHomeImg0.setImageResource(R.drawable.t_haoyou2);
        mCartImg0.setImageResource(R.drawable.t_jiating2);
        mClassifyImg0.setImageResource(R.drawable.t_banji2);

    }

    public void houtui2(View view){
        finish();
    }

}


