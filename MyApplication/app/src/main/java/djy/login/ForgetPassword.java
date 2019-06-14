package djy.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.ResetPasswordByEmailListener;
import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public class ForgetPassword extends AppCompatActivity {
    private EditText mForgetPassword;
    private Button mforget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);

        mForgetPassword = (EditText) findViewById(R.id.Login_editText5);
        mforget = (Button) findViewById(R.id.forget);



        mforget.setOnClickListener(new View.OnClickListener() {
            @Override
            //方法一：内部类，邮箱的更改传值问题
            public void onClick(View v) {
                //以下三行代码应该再点击onClick方法里执行，否则在外边的话，就无法得到该值
                final String email = mForgetPassword.getText().toString();
                final BmobUser user = new BmobUser();
                user.setEmail(email);

                BmobUser.resetPasswordByEmail(ForgetPassword.this, email, new ResetPasswordByEmailListener(){
                    @Override

                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        Toast.makeText(ForgetPassword.this, "重置密码请求成功，请到" + email + "邮箱进行密码重置操作", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int code, String e) {
                        // TODO Auto-generated method stub
                        Toast.makeText(ForgetPassword.this, "重置密码失败:" + e, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

}



//
//package djy.myapplication;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import cn.bmob.v3.BmobUser;
//import cn.bmob.v3.listener.ResetPasswordByEmailListener;
//
///**
// * Created by Administrator on 2016/5/3 0003.
// */
//public class ForgetPassword extends AppCompatActivity {
//
//    private EditText mForgetPassword;
//    private Button mforget;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.forget);
//
//        mForgetPassword = (EditText) findViewById(R.id.Login_editText5);
//        mforget = (Button) findViewById(R.id.forget);
//
//
//    }
////方法二：
//    public void send(View view) {
//
//        final String email = mForgetPassword.getText().toString();
//        final BmobUser user = new BmobUser();
//        user.setEmail(email);
//
//        BmobUser.resetPasswordByEmail(ForgetPassword.this, email, new ResetPasswordByEmailListener() {
//            @Override
//
//            public void onSuccess() {
//                // TODO Auto-generated method stub
//                Toast.makeText(ForgetPassword.this, "重置密码请求成功，请到" + email + "邮箱进行密码重置操作", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int code, String e) {
//                // TODO Auto-generated method stub
//                Toast.makeText(ForgetPassword.this, "重置密码失败:" + e, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//
//
//}


