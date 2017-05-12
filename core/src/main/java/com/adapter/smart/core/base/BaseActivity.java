package com.adapter.smart.core.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.adapter.smart.core.ui.BaseTitlebar;

/**
 * Created by smart on 2017/5/11.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

    //    这一部分是对屏幕的操作
    private boolean isSetStatusBar = false;//是否沉浸状态栏,默认情况下不沉浸
    private boolean mNoTitle = true;//是否允许全屏
    private boolean isAllowScreenRoate = false;//是否禁止旋转屏幕
    private BaseTitlebar mBaseTitlebar;//库里面内置的标题栏

    //这一步是对 Activity 操作
    private View mContentView = null;//当前 Activity 渲染的视图View
     //其他操作
    protected final String TAG = this.getClass().getSimpleName();//日志输出标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "BaseActivity-->onCreate()");
        //屏幕初始化流程
        initSystemUI();
        if (mNoTitle) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isSetStatusBar) {
            steepStatusBar();
        }
        //装载布局
        mContentView = LayoutInflater.from(this) .inflate(getContentView(), null);
        setContentView(mContentView);
        initTitleBar(mBaseTitlebar);//初始化title


        Bundle bundle = getIntent().getExtras();
        handleBundleData(bundle);

        if (!isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//只能是竖屏
        }
        initView(mContentView);
        setViewClickedListener();
    }

    /*
    * 屏幕初始化操作
    * 如 显示title ： setNoTitle(false)
    * */
    protected void initSystemUI() {}
    protected void initTitleBar(BaseTitlebar baseTitlebar) {}

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }



    /**
     * [是否允许全屏]
     *
     * @param noTitle
     */
    public void setNoTitle(boolean noTitle) {
        this.mNoTitle = noTitle;
    }

    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar
     */
    public void setsteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    /*是否允许屏幕旋转*/
    public void setScreenRotatable (boolean isAllowScreenRoate) {
        this.isAllowScreenRoate = isAllowScreenRoate;
    }

    public abstract int getContentView();//绑定布局
    public abstract void initView(final View contentView);//初始化控件

    /*View点击 */
    public void viewClicked(View view){};

    /**
     * [初始化参数]
     */
    public void handleBundleData(Bundle bundleData){};

    /**
     * [绑定控件]
     */
    protected    <T extends View> T getViewById(int resId) {
        return (T) super.findViewById(resId);
    }

    @Override
    public void onClick(View v) {
        viewClicked(v);
    }


    public abstract void setViewClickedListener();//设置监听

    /* 页面跳转 */
    public void startActivityWithNothing(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this,clz));
    }

    /* 携带数据的页面跳转 */
    public void startActivityWithBundle(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    /**
     * [简化Toast]
     * @param msg
     */
    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



}
