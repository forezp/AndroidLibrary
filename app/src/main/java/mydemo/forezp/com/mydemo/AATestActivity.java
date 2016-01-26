package mydemo.forezp.com.mydemo;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by b508a on 2016/1/7.
 */

@EActivity(R.layout.activity_aa_test)
public class AATestActivity extends Activity{


    @ViewById(R.id.btnTest)
    Button btnTest;
    @ViewById
    TextView tvContent;
    @ViewById
    Button btnSss;
    @ViewById
    EditText etInput;


    @AfterViews
    void init(){
        tvContent.setText("ssss");
    }
    @AfterViews
    void initB(){

        btnSss.setText("SSSSSS112S");
    }


}
