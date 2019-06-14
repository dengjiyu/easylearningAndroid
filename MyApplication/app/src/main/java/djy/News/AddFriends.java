package djy.News;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import djy.myapplication.R;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class AddFriends extends AppCompatActivity {

    private TextView t1;
    private EditText et1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_addfriend);

        t1 = (TextView) findViewById(R.id.friendSearch);
        et1 = (EditText) findViewById(R.id.AddFriend);




        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et1.length() ==0){
                    Toast.makeText(AddFriends.this, "输入不能为空", Toast.LENGTH_SHORT).show();

                }
                else{
                String str1 = et1.getText().toString();
                Toast.makeText(AddFriends.this, "您输入的ID是"+str1, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void tuihui3(View view){
        finish();
    }
}
