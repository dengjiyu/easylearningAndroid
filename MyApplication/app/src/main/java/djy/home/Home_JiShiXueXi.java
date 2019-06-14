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

import android.app.Activity;
import android.os.Bundle;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Home_JiShiXueXi extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_jishixuexi);


    }

}
