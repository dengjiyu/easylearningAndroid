//package djy.login;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import cn.bmob.v3.Bmob;
//import cn.bmob.v3.BmobUser;
//import cn.bmob.v3.listener.SaveListener;
//import djy.myapplication.MainActivity;
//import djy.myapplication.R;
//
///**
// * Created by Administrator on 2016/4/21 0021.
// */
//public class Login extends AppCompatActivity {
//    private EditText et3, et4;//账号密码
//
//    private EditText username;
//    private EditText userpassword;
//    private CheckBox remember;
//    private CheckBox autologin;
//    private Button login;
//    private SharedPreferences sp;
//    private String userNameValue, passwordValue;
//
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//        Bmob.initialize(this, "9a01f3cb335c8e1e7dbe4f9ab96d81bb");
//
//        et3 = (EditText) findViewById(R.id.Login_editText3);
//        et4 = (EditText) findViewById(R.id.Login_editText4);
//
//
//        //跳转注册页面
//        TextView t1 = (TextView) findViewById(R.id.Login_register);
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Login.this, Register.class);
//                startActivity(intent);
//
//
//            }
//        });
//    }
//
//    //跳转注册页面
//    public void forget(View view) {
//        Intent intent = new Intent(Login.this, ForgetPassword.class);
//        startActivity(intent);
//    }
//
//    public void login(View view) {
//        String str1 = et3.getText().toString();
//        String str2 = et4.getText().toString();
//
//        final BmobUser user = new BmobUser();
//        user.setUsername(str1);
//        user.setPassword(str2);
//
//        user.login(this, new SaveListener() {
//            @Override
//
//            public void onSuccess() {
//                if (user.getEmailVerified()) {
//                    Intent intent = new Intent(Login.this, MainActivity.class);
//                    startActivity(intent);
//                    //登录到主界面后销毁登录页面
//                    finish();
//                } else {
//                    Toast.makeText(Login.this, "请先前去邮箱中进行验证", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Toast.makeText(Login.this, "登录失败：" + s, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//}


package djy.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import djy.myapplication.MainActivity;
import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class Login extends AppCompatActivity {
    private EditText et3, et4;//账号密码

    private CheckBox remember;
    private CheckBox autologin;

    private SharedPreferences sp;
    private String userNameValue, passwordValue;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Bmob.initialize(this, "9a01f3cb335c8e1e7dbe4f9ab96d81bb");

        et3 = (EditText) findViewById(R.id.Login_editText3);//et3
        et4 = (EditText) findViewById(R.id.Login_editText4);
        remember = (CheckBox) findViewById(R.id.remember);
        autologin = (CheckBox) findViewById(R.id.autologin);


        //定义输入框状态并给键值，键的名字要前后一致、不能随便写
        sp = getSharedPreferences("userInfo", 0);
        String name = sp.getString("USER_NAME", "");
        String pass = sp.getString("PASSWORD", "");

        //定义多选框状态并给键值，键的名字要前后一致、不能随便写
        boolean choseRemember = sp.getBoolean("remember", false);
        boolean choseAutoLogin = sp.getBoolean("autologin", false);

        //判断记住密码多选框的状态
        if (sp.getBoolean("remember", false)) {
            //设置默认是记录密码状态
            remember.setChecked(true);
            et3.setText(sp.getString("USER_NAME", ""));
            et4.setText(sp.getString("PASSWORD", ""));
            //判断自动登陆多选框状态
            if (sp.getBoolean("autologin", false)) {
                //设置默认是自动登录状态
                autologin.setChecked(true);
                //跳转界面
                Intent intent = new Intent(Login.this, MainActivity.class);
                Login.this.startActivity(intent);
                finish();


            }
        }


        //跳转注册页面
        TextView t1 = (TextView) findViewById(R.id.Login_register);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);


            }
        });
    }

    //跳转注册页面
    public void forget(View view) {
        Intent intent = new Intent(Login.this, ForgetPassword.class);
        startActivity(intent);
    }

    public void login(View view) {
        String str1 = et3.getText().toString();
        String str2 = et4.getText().toString();

        final BmobUser user = new BmobUser();
        user.setUsername(str1);
        user.setPassword(str2);

        userNameValue = et3.getText().toString();
        passwordValue = et4.getText().toString();
        final SharedPreferences.Editor editor = sp.edit();

        user.login(this, new SaveListener() {

            @Override

            public void onSuccess() {
                if (user.getEmailVerified()) {
                    //保存用户名和密码
                    editor.putString("USER_NAME", userNameValue);
                    editor.putString("PASSWORD", passwordValue);


                    //是否记住密码
                    if (remember.isChecked()) {
                        editor.putBoolean("remember", true);
                    } else {
                        editor.putBoolean("remember", false);
                    }


                    //是否自动登录
                    if (autologin.isChecked()) {
                        editor.putBoolean("autologin", true);

                    } else {
                        editor.putBoolean("autologin", false);
                    }
                    editor.commit();

                    //跳转
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "请先前去邮箱中进行验证", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(Login.this, "登录失败：" + s, Toast.LENGTH_SHORT).show();
            }
        });

    }

}


