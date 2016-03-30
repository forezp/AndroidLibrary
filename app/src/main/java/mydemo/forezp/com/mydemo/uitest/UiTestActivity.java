package mydemo.forezp.com.mydemo.uitest;

import android.os.Bundle;
import android.view.View;

import com.trilink.androidlib.base.BaseActivity;
import com.trilink.androidlib.widget.EaseSwitchButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mydemo.forezp.com.mydemo.R;

/**
 * Created by b508a on 2016/2/3.
 */
public class UiTestActivity extends BaseActivity {


    @Bind(R.id.switch_button2)
    EaseSwitchButton switchButton;


    @OnClick(R.id.switch_button2)
     void swwwww(View v) {

        if (switchButton.isSwitchOpen()) {
            switchButton.closeSwitch();

        } else {
            switchButton.openSwitch();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_ui_test);
        ButterKnife.bind(this);
    }


}
