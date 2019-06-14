//package djy.myapplication;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import cn.bmob.v3.listener.SaveListener;
//
///**
// * Created by Administrator on 2016/4/26 0026.
// */
//public class Register extends Activity  {
//    private EditText mName, mPassword;
//
//    @Nullable
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.register);
//
//
//        //初始化Bmob的SDK，加载到我们的Bmob服务器上
//        //Bmob.initialize(this, "9a01f3cb335c8e1e7dbe4f9ab96d81bb");
//
//        mName = (EditText) findViewById(R.id.Login_editText);
//        mPassword = (EditText) findViewById(R.id.Login_editText2);
//
//    }
//    public void submit(View view) {
//        String name = mName.getText().toString();
//        String password = mPassword.getText().toString();
//        Login_Password user = new Login_Password();
//        user.setUsername(name);
//        user.setPassword(password);
//        user.signUp(this, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Toast.makeText(Register.this,"注册失败"+s,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//
//
//
//    }
//
//
//
//
//
//}
package djy.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.EmailVerifyListener;
import cn.bmob.v3.listener.SaveListener;
import djy.myapplication.R;

/**
 * Created by Administrator on 2016/4/26 0026.
 */
public class Register extends Activity {
    private EditText mName, mPassword, mPassword2, mEmail;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        //初始化Bmob的SDK，加载到我们的Bmob服务器上
        Bmob.initialize(this, "9a01f3cb335c8e1e7dbe4f9ab96d81bb");

        mName = (EditText) findViewById(R.id.Login_editText);
        mPassword = (EditText) findViewById(R.id.Login_editText2);
        mEmail = (EditText) findViewById(R.id.Login_editText3);
        mPassword2 = (EditText) findViewById(R.id.Login_editText4);

    }

    public void submit(View view) {
        String name = mName.getText().toString();
        String password = mPassword.getText().toString();
        final String email = mEmail.getText().toString();
        String password2 = mPassword2.getText().toString();
        //造一个对象、对象中包含name,password,email;
        Login_Password user = new Login_Password();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPassword(password2);
        if (password2.equals(password)) {
            user.signUp(this, new SaveListener() {
                @Override
                public void onSuccess() {
                    //邮箱验证后才可登录
                    //注意：一个邮箱只能用于一个账号激活
                    BmobUser.requestEmailVerify(Register.this, email, new EmailVerifyListener() {
                        @Override
                        public void onSuccess() {
                            // TODO Auto-generated method stub
                            Toast.makeText(Register.this, "请求验证邮件成功，请到" + email + "邮箱中进行激活", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int code, String e) {
                            // TODO Auto-generated method stub
                            Toast.makeText(Register.this, "请求验证邮件失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onFailure(int i, String s) {
                    Toast.makeText(Register.this, "注册失败" + s, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(Register.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
        }


    }


}

