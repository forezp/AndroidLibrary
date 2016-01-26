package mydemo.forezp.com.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by b508a on 2016/1/7.
 */
public class ButterknifActivity extends Activity {


    @Bind(R.id.btn_test)
    Button btnTest;
    @Bind(R.id.btn_test2)
    Button btnTest2;
    @Bind(R.id.btn_test3)
    Button btnTest3;
    @Bind(R.id.tv_test)
    TextView tvTest;
    @OnClick(R.id.btn_test)
    void btn_test(){
        tvTest.setText("你点击了btn1");
    }
    @OnClick (R.id.btn_test2)  void hhhhh(){
        Toast.makeText(this,"jjjjjjjjj",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);


    }
}
