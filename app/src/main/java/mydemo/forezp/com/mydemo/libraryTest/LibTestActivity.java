package mydemo.forezp.com.mydemo.libraryTest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.trilink.androidlib.slideLibarary.SlidingMenu;
import com.trilink.androidlib.slideLibarary.app.SlidingFragmentActivity;
import com.trilink.androidlib.utils.T;
import com.trilink.androidlib.widget.EaseSwitchButton;
import com.trilink.androidlib.widget.EaseTitleBar;
import com.trilink.androidlib.widget.photoview.EasePhotoView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mydemo.forezp.com.mydemo.R;

/**
 * Created by b508a on 2016/1/20.
 */
public class LibTestActivity extends SlidingFragmentActivity {

    @Bind(R.id.title_bar)
    EaseTitleBar titleBar;
    @Bind(R.id.switch_button)
    EaseSwitchButton switchButton;
    @Bind(R.id.ease_imageview)
    EasePhotoView easeImageview;

    @OnClick(R.id.switch_button)
    public void switcher(View v) {
        T.show(getApplicationContext(), "ssssss");
        if (switchButton.isSwitchOpen()) {
            switchButton.closeSwitch();
          //  SVProgressHUD.showWithStatus(LibTestActivity.this, "加载中..");
        } else {
            switchButton.openSwitch();
           // SVProgressHUD.dismiss(LibTestActivity.this);

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_test);
        ButterKnife.bind(this);
        initRightMenu();
        titleBar.setBackgroundColor(getResources().getColor(R.color.black));
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    finish();
                                                }
                                            }
        );
        String url="http://artapp-dev-bucket.oss-cn-beijing.aliyuncs.com/exercise/a4.png";
        ImageLoader.getInstance().displayImage(url,easeImageview);

    }

    private void initRightMenu() {
        // TODO Auto-generated method stub
        Fragment leftMenuFragment = new MenuLeftFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //		menu.setBehindWidth()
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        // menu.setBehindScrollScale(1.0f);
        menu.setSecondaryShadowDrawable(R.drawable.shadow);
        //设置右边（二级）侧滑菜单
        menu.setSecondaryMenu(R.layout.right_menu_frame);
        Fragment rightMenuFragment = new MenuRightFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
    }

}
