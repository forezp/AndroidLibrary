package mydemo.forezp.com.mydemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by b508a on 2016/1/4.
 */
public class LoginDemoActivity extends Activity implements View.OnClickListener, Handler.Callback, EditTextHolder.OnEditTextFocusChangeListener{

    private static final String TAG = "LoginActivity";
    /**
     * �û��˻�
     */
    private EditText mUserNameEt;
    /**
     * ����
     */
    private EditText mPassWordEt;
    /**
     * ��¼button
     */
    private Button mSignInBt;
    /**
     * �豸id
     */
    private String mDeviceId;
    /**
     * �������
     */
    private TextView mFogotPassWord;
    /**
     * ע��
     */
    private TextView mRegister;
    /**
     * �����û���ɾ��ť
     */
    private FrameLayout mFrUserNameDelete;
    /**
     * ��������ɾ��ť
     */
    private FrameLayout mFrPasswordDelete;
    /**
     * logo
     */
    private ImageView mLoginImg;
    /**
     * ����̵Ŀ���
     */
    private InputMethodManager mSoftManager;
    /**
     * �Ƿ�չʾtitle
     */
    private RelativeLayout mIsShowTitle;
    /**
     * ���title
     */
    private TextView mLeftTitle;
    /**
     * �Ҳ�title
     */
    private TextView mRightTitle;


    private static final int REQUEST_CODE_REGISTER = 200;
    public static final String INTENT_IMAIL = "intent_email";
    public static final String INTENT_PASSWORD = "intent_password";
    private static final int HANDLER_LOGIN_SUCCESS = 1;
    private static final int HANDLER_LOGIN_FAILURE = 2;
    private static final int HANDLER_LOGIN_HAS_FOCUS = 3;
    private static final int HANDLER_LOGIN_HAS_NO_FOCUS = 4;


    private Handler mHandler;
    private ImageView mImgBackgroud;
    EditTextHolder mEditUserNameEt;
    EditTextHolder mEditPassWordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de_ac_login);
        initView();
        initData();
    }


    protected void initData() {



//        TelephonyManager mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        mDeviceId = mTelephonyManager.getDeviceId();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mUserNameEt.setOnClickListener(LoginDemoActivity.this);
                mPassWordEt.setOnClickListener(LoginDemoActivity.this);
                mEditPassWordEt.setmOnEditTextFocusChangeListener(LoginDemoActivity.this);
                mEditUserNameEt.setmOnEditTextFocusChangeListener(LoginDemoActivity.this);
            }
        }, 200);

    }


    private void initView(){

        mSoftManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mLoginImg = (ImageView) findViewById(R.id.de_login_logo);
        mUserNameEt = (EditText) findViewById(R.id.app_username_et);
        mPassWordEt = (EditText) findViewById(R.id.app_password_et);
        mSignInBt = (Button) findViewById(R.id.app_sign_in_bt);
        mRegister = (TextView) findViewById(R.id.de_login_register);
        mFogotPassWord = (TextView) findViewById(R.id.de_login_forgot);
        mImgBackgroud = (ImageView) findViewById(R.id.de_img_backgroud);
        mFrUserNameDelete = (FrameLayout) findViewById(R.id.fr_username_delete);
        mFrPasswordDelete = (FrameLayout) findViewById(R.id.fr_pass_delete);
        mIsShowTitle = (RelativeLayout) findViewById(R.id.de_merge_rel);
        mLeftTitle = (TextView) findViewById(R.id.de_left);
        mRightTitle = (TextView) findViewById(R.id.de_right);
        mSignInBt.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mLeftTitle.setOnClickListener(this);
        mRightTitle.setOnClickListener(this);
        mHandler = new Handler(this);
        mEditUserNameEt = new EditTextHolder(mUserNameEt, mFrUserNameDelete, null);
        mEditPassWordEt = new EditTextHolder(mPassWordEt, mFrPasswordDelete, null);

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginDemoActivity.this, R.anim.translate_anim);
                mImgBackgroud.startAnimation(animation);
            }
        });

    }
    

    @Override
    public boolean handleMessage(Message msg) {

        if (msg.what == HANDLER_LOGIN_FAILURE) {


//            startActivity(new Intent(this, MainActivity.class));
//
//            finish();

        } else if (msg.what == HANDLER_LOGIN_SUCCESS) {
//            if (mDialog != null)
//                mDialog.dismiss();
//            WinToast.toast(LoginActivity.this, R.string.login_success);
//
//            startActivity(new Intent(this, MainActivity.class));
//
//            finish();

        } else if (msg.what == HANDLER_LOGIN_HAS_FOCUS) {
            mLoginImg.setVisibility(View.GONE);
            mRegister.setVisibility(View.GONE);
            mFogotPassWord.setVisibility(View.GONE);
            mIsShowTitle.setVisibility(View.VISIBLE);
            mLeftTitle.setText("zhuce");
            mRightTitle.setText("wjmi");
        } else if (msg.what == HANDLER_LOGIN_HAS_NO_FOCUS) {
            mLoginImg.setVisibility(View.VISIBLE);
            mRegister.setVisibility(View.VISIBLE);
            mFogotPassWord.setVisibility(View.VISIBLE);
            mIsShowTitle.setVisibility(View.GONE);
        }


        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_username_et:
            case R.id.app_password_et:
                Message mess = Message.obtain();
                mess.what = HANDLER_LOGIN_HAS_FOCUS;
                mHandler.sendMessage(mess);
                break;
        }
    }


    @Override
    public void onEditTextFocusChange(View v, boolean hasFocus) {
        Message mess = Message.obtain();
        switch (v.getId()) {
            case R.id.app_username_et:
            case R.id.app_password_et:
                if (hasFocus) {
                    mess.what = HANDLER_LOGIN_HAS_FOCUS;
                }
                mHandler.sendMessage(mess);
                break;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                mSoftManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                Message mess = Message.obtain();
                mess.what = HANDLER_LOGIN_HAS_NO_FOCUS;
                mHandler.sendMessage(mess);
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        event.getKeyCode();
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_ESCAPE:
                Message mess = Message.obtain();
                mess.what = HANDLER_LOGIN_HAS_NO_FOCUS;
                mHandler.sendMessage(mess);
                break;
        }
        return super.dispatchKeyEvent(event);
    }



    protected void onPause() {
        super.onPause();
        if (mSoftManager == null) {
            mSoftManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        if (getCurrentFocus() != null) {
            mSoftManager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), 0);// ���������
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (KeyEvent.KEYCODE_BACK == event.getKeyCode()) {


            final AlertDialog.Builder alterDialog = new AlertDialog.Builder(this);
            alterDialog.setMessage("do you want exit");
            alterDialog.setCancelable(true);

           alterDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

                   android.os.Process.killProcess(android.os.Process.myPid());
               }
           });
            alterDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alterDialog.show();
        }

        return false;
    }
}
