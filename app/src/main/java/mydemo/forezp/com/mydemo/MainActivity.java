package mydemo.forezp.com.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mydemo.forezp.com.mydemo.libraryTest.LibTestActivity;
import mydemo.forezp.com.mydemo.vedio.VedioPlayActivity;

public class MainActivity extends Activity {

  //  private TextView tv;
    private Button btnClick;
    private Button btnLogin;
    private Button btnOkhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // tv = (TextView) findViewById(R.id.tv_show);
        btnOkhttp = (Button) findViewById(R.id.btn_okhttp);
        btnOkhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OKTestActivity.class);
                startActivity(intent);
            }
        });
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginDemoActivity.class);
                startActivity(intent);
            }
        });
        btnClick = (Button) findViewById(R.id.btn_test);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GreenDActivity_.class);
                startActivity(intent);
            }
        });


//        String url = "http://www.csdn.net/";
//        OkHttpUtils
//                .get()
//                .url(url)
//                .addParams("username", "hyman")
//                .addParams("password", "123")
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response) {
//                        tv.setText(response);
//                    }
//                });
    }
    public void fresco(View v){
        startActivity(new Intent(MainActivity.this,FrescoActivity.class));

    }

    public  void aaTest(View v){
        startActivity(new Intent(MainActivity.this,AATestActivity_.class));
    }


    public void butter(View v){
        startActivity(new Intent(MainActivity.this,ButterknifActivity.class));
    }

    public void vedioPlay(View v){
        startActivity(new Intent(MainActivity.this,VedioPlayActivity.class));
    }

    public void libTest(View v){
        startActivity(new Intent(MainActivity.this,LibTestActivity.class));
    }
}
