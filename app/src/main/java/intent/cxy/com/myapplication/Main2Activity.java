package intent.cxy.com.myapplication;

import android.content.Intent;
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
 *  接受上一个Activity传来的参数  这里的Intent并不是创建的 而是getIntent（） 得到的
 *  实现一个按钮来回传参数
 *  主要是setResult（）方法，
 *  后面加上finish（）  是因为setResult（）方法只是回传参数  但是当前Activity 并未被关闭
 */
public class Main2Activity extends AppCompatActivity {
    private EditText ed_two;
    private Button btn_end;
    private TextView tv_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_two=findViewById(R.id.tv_two);
        final Intent intent=getIntent();
        String src=intent.getStringExtra("name");
        tv_two.setText(src);
        ed_two=findViewById(R.id.et_two);
        btn_end=findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断输入框是否有数据
                if(TextUtils.isEmpty(ed_two.getText())){
                    Toast.makeText(Main2Activity.this,"请输入数据",Toast.LENGTH_LONG).show();
                }else{
                    String src1=ed_two.getText().toString();
                    //使用setResult（）进行回传
                    Intent intent1=new Intent();
                    intent1.putExtra("name",src1);
                    setResult(1,intent1);
                    finish();
                }
            }
        });
    }
}
