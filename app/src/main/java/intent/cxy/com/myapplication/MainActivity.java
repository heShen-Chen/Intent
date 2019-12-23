package intent.cxy.com.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
 * *- 小陈-*
 *  创建Intent  设置跳转的Acivity
 *  将参数存入Intent中
 *  使用startActivityForResult（Intent） 进行跳转
 *  也可以用startActivity（）
 *  区别在于 startActivity（）不能实现回传参数
 *  startActivityForResult（） 能实现参数回传
 *  会直接回传到onActivityResult（）方法中
 */

public class MainActivity extends AppCompatActivity {
    private EditText ed_one;
    private Button btn_play;
    private TextView tv_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play=findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent=new Intent();
                //设置跳转的Activity
                intent.setClass(MainActivity.this,Main2Activity.class);
                //获取EditText的数据
                ed_one=findViewById(R.id.et_one);
                String src=ed_one.getText().toString();
                //这里做一个判断看输入框是否有数据
                if(TextUtils.isEmpty(ed_one.getText())){
                    Toast.makeText(MainActivity.this,"请输入数据",Toast.LENGTH_LONG).show();
                }else{
                    //将数据存入到Intent中
                    intent.putExtra("name",src);
                    //开启跳转
                    startActivityForResult(intent,1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ed_one.setText("");
        tv_one=findViewById(R.id.tv_one);
        String src=data.getStringExtra("name");
        tv_one.setText(data.getStringExtra("name"));
    }
}
