//package djy.myapplication;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import djy.find.FindFragment;

//import djy.my.MyFragment;
//
///*
//    ViewPager：页面滑动
//    PagerAdapter：页面适配器
//    第一步：首先是在布局文件里添加viewPager布局。代码如下：
//    第二步：创建XML布局用于填充在ViefgwPager里，可以自定义也可以加载写好的xml布局文件。代码如下：
//    第三步：然后就是Activity了，主要写了左右滑动切换页面。代码如下：
//    第四步：是有关ViewPager的适配器的重写(四个方法)。代码如下：
//    第五步： ViewPager中加载Adapter： mViewPager.setAdapter(mAdapter);
// */
//
//public class MainActivity extends FragmentActivity implements View.OnClickListener {
//    private ViewPager mViewPager;
//
//    //ViewPager的初始化需要一个适配器
//    private FragmentPagerAdapter mAdapter;
//    private List<Fragment> mFragments = new ArrayList<>();
//
//
//    //对底部五个面板进行申明
//    private LinearLayout mTabHome;
//    private LinearLayout mTabFind;
//    private LinearLayout mTabStudent;
//    private LinearLayout mTabNews;
//    private LinearLayout mTabMy;
//
//    private ImageButton mHomeImg;
//    private ImageButton mFindImg;
//    private ImageButton mStudentImg;
//    private ImageButton mNewsImg;
//    private ImageButton mMyImg;
//
//    //通过Fragment实现
//    private Fragment mtTab01;
//    private Fragment mtTab02;
//    private Fragment mtTab03;
//    private Fragment mtTab04;
//    private Fragment mtTab05;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //控制登录用户名图标大小
//        intView();
//        initEvents();
//    }
//
//
//
//    private void initEvents() {
//        mTabHome.setOnClickListener(this);
//        mTabFind.setOnClickListener(this);
//        mTabStudent.setOnClickListener(this);
//        mTabNews.setOnClickListener(this);
//        mTabMy.setOnClickListener(this);
//
//        //监听页面变化的监听器：当页面滑动时，下方tab的图标由暗色的切换为有颜色的图标
//        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                int currentItem = mViewPager.getCurrentItem();
//                resetImg();
//                switch (currentItem) {
//                    case 0:
//                        mHomeImg.setImageResource(R.drawable.home_1);
//                        break;
//
//                    case 1:
//                        mFindImg.setImageResource(R.drawable.find_1);
//                        break;
//
//                    case 2:
//                        mStudentImg.setImageResource(R.drawable.studentcircle_1);
//                        break;
//
//                    case 3:
//                        mNewsImg.setImageResource(R.drawable.news_1);
//                        break;
//
//                    case 4:
//                        mMyImg.setImageResource(R.drawable.my_1);
//                        break;
//
//                    default:
//                        break;
//                }
//
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
//    //初始化所有的View
//    private void intView() {
//        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
//        //tabs
//        mTabHome = (LinearLayout) findViewById(R.id.id_tab_home);
//        mTabFind = (LinearLayout) findViewById(R.id.id_tab_find);
//        mTabStudent = (LinearLayout) findViewById(R.id.id_tab_student);
//        mTabNews = (LinearLayout) findViewById(R.id.id_tab_news);
//        mTabMy = (LinearLayout) findViewById(R.id.id_tab_my);
//        //ImageButton
//        mHomeImg = (ImageButton) findViewById(R.id.id_tab_home_img);
//        mFindImg = (ImageButton) findViewById(R.id.id_tab_find_img);
//        mStudentImg = (ImageButton) findViewById(R.id.id_tab_student_img);
//        mNewsImg = (ImageButton) findViewById(R.id.id_tab_news_img);
//        mMyImg = (ImageButton) findViewById(R.id.id_tab_my_img);
//
//
//        mFragments = new ArrayList<Fragment>();

//        Fragment mtab02 = new FindFragment();
//        Fragment mtab03 = new StudentCircleFragment();
//        Fragment mtab04 = new NewsFragment();
//        Fragment mtab05 = new MyFragment();
//
//        mFragments.add(mtab01);
//        mFragments.add(mtab02);
//        mFragments.add(mtab03);
//        mFragments.add(mtab04);
//        mFragments.add(mtab05);
//
//
//        //PagerAdapter的使用，首先继承pageradapter至少要重写以下四种方法
//        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//            // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
//            public int getCount() {
//                return mFragments.size();
//            }
//
//            public Fragment getItem(int arg0) {
//                return mFragments.get(arg0);
//            }
//
//        };
//
//        //为ViewPager设置Adapter
//        mViewPager.setAdapter(mAdapter);
//    }
//
//    /**
//     * Called when a view has been clicked.
//     *
//     * @param v The view that was clicked.
//     */
//    @Override
//    //点击事件：当点击对应ID时,切换为对应的页面，并将底部tab的暗图标转换为亮图标
//    public void onClick(View v) {
//        resetImg();
//
//        switch (v.getId()) {
//            case R.id.id_tab_home:
//                mViewPager.setCurrentItem(0);
//                mHomeImg.setImageResource(R.drawable.home_1);
//                break;
//
//            case R.id.id_tab_find:
//                mViewPager.setCurrentItem(1);
//                mFindImg.setImageResource(R.drawable.find_1);
//                break;
//
//            case R.id.id_tab_student:
//                mViewPager.setCurrentItem(2);
//                mStudentImg.setImageResource(R.drawable.studentcircle_1);
//                break;
//
//            case R.id.id_tab_news:
//                mViewPager.setCurrentItem(3);
//                mNewsImg.setImageResource(R.drawable.news_1);
//                break;
//
//            case R.id.id_tab_my:
//                mViewPager.setCurrentItem(4);
//                mMyImg.setImageResource(R.drawable.my_1);
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
//        mHomeImg.setImageResource(R.drawable.home_2);
//        mFindImg.setImageResource(R.drawable.find_2);
//        mStudentImg.setImageResource(R.drawable.studentcircle_2);
//        mNewsImg.setImageResource(R.drawable.news_2);
//        mMyImg.setImageResource(R.drawable.my_2);
//    }
//
//}


package djy.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import djy.News.NewsFragment;
import djy.StudentCircle.StudentCircleFragment;
import djy.find.FindFragment;
import djy.home.HomeFragment;
import djy.my.MyFragment;

/*
    ViewPager：页面滑动
    PagerAdapter：页面适配器
    第一步：首先是在布局文件里添加viewPager布局。代码如下：
    第二步：创建XML布局用于填充在ViefgwPager里，可以自定义也可以加载写好的xml布局文件。代码如下：
    第三步：然后就是Activity了，主要写了左右滑动切换页面。代码如下：
    第四步：是有关ViewPager的适配器的重写(四个方法)。代码如下：
    第五步： ViewPager中加载Adapter： mViewPager.setAdapter(mAdapter);
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener {



    //对底部五个面板进行申明
    private LinearLayout mTabHome;
    private LinearLayout mTabFind;
    private LinearLayout mTabStudent;
    private LinearLayout mTabNews;
    private LinearLayout mTabMy;

    private ImageButton mHomeImg;
    private ImageButton mFindImg;
    private ImageButton mStudentImg;
    private ImageButton mNewsImg;
    private ImageButton mMyImg;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;
    private Fragment mTab05;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intView();
        initEvents();
        setSelect(0);
    }

    //手机退出时弹出提示：是否退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            dialog();
        }
        return false;
    }
    private void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(android.R.drawable.ic_menu_info_details);
        dialog.setTitle("提示");
        dialog.setMessage("您确定要退出吗？");
        dialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "好的、您没退出本程序。", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();

            }
        }).create();

        dialog.show();

    }


    //初始化所有的View
    private void intView() {
        //tabs
        mTabHome = (LinearLayout) findViewById(R.id.id_tab_home);
        mTabFind = (LinearLayout) findViewById(R.id.id_tab_find);
        mTabStudent = (LinearLayout) findViewById(R.id.id_tab_student);
        mTabNews = (LinearLayout) findViewById(R.id.id_tab_news);
        mTabMy = (LinearLayout) findViewById(R.id.id_tab_my);
        //ImageButton
        mHomeImg = (ImageButton) findViewById(R.id.id_tab_home_img);
        mFindImg = (ImageButton) findViewById(R.id.id_tab_find_img);
        mStudentImg = (ImageButton) findViewById(R.id.id_tab_student_img);
        mNewsImg = (ImageButton) findViewById(R.id.id_tab_news_img);
        mMyImg = (ImageButton) findViewById(R.id.id_tab_my_img);

    }

    //底部五个面板的点击事件
    private void initEvents() {
        mTabHome.setOnClickListener(this);
        mTabFind.setOnClickListener(this);
        mTabStudent.setOnClickListener(this);
        mTabNews.setOnClickListener(this);
        mTabMy.setOnClickListener(this);

    }

    /*
        在FragmentManager事务下、根据switch显示对应的Fragment
     */
    private void setSelect(int i) {
        //开启事务的格式
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
       //根据选择显示对应的Fragemnt
        switch (i) {
            case 0:
                //Fragment mTab01 是否初始化
                if (mTab01 == null)//如果没有初始化、我们就初始化并且添加
                {
                    mTab01 = new HomeFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }
                mHomeImg.setImageResource(R.drawable.home_1);
                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new FindFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);

                }
                mFindImg.setImageResource(R.drawable.find_1);
                break;
            case 2:
                if (mTab03 == null) {
                    mTab03 = new StudentCircleFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                mStudentImg.setImageResource(R.drawable.studentcircle_1);
                break;
            case 3:
                if (mTab04 == null) {
                    mTab04 = new NewsFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                mNewsImg.setImageResource(R.drawable.news_1);
                break;
            case 4:
                if (mTab05 == null) {
                    mTab05 = new MyFragment();
                    transaction.add(R.id.id_content, mTab05);
                } else {
                    transaction.show(mTab05);
                }
                mMyImg.setImageResource(R.drawable.my_1);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    /*
      先隐藏起所有的Fragment
     */
    private void hideFragment(FragmentTransaction transaction) {
        //Fragment 都没有初始化、所以都会隐藏
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
        if (mTab05 != null) {
            transaction.hide(mTab05);
        }
    }

    /*
    将所有的图片切换为暗色
     */
    private void resetImg() {
        mHomeImg.setImageResource(R.drawable.home_2);
        mFindImg.setImageResource(R.drawable.find_2);
        mStudentImg.setImageResource(R.drawable.studentcircle_2);
        mNewsImg.setImageResource(R.drawable.news_2);
        mMyImg.setImageResource(R.drawable.my_2);
    }

    /*
        点击Bottom下端对应的Linearlayout
     */
    @Override
    public void onClick(View v) {
        //切换图片至暗色
        resetImg();
        switch (v.getId()) {
            case R.id.id_tab_home:
                setSelect(0);
                break;
            case R.id.id_tab_find:
                setSelect(1);
                break;
            case R.id.id_tab_student:
                setSelect(2);
                break;
            case R.id.id_tab_news:
                setSelect(3);
                break;

            case R.id.id_tab_my:
                setSelect(4);
                break;

            default:
                break;
        }

    }


}
