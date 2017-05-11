package com.adapter.smart.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.adapter.smart.core.base.BaseActivity;
import com.adapter.smart.core.ui.BaseTitlebar;

import static com.adapter.smart.myapplication.R.id.tv;

public class MainActivity extends BaseActivity {
    private TextView mTextView;
    @Override
    protected void initScreen() {
        super.initScreen();
        setNoTitle(true);
        setsteepStatusBar(false);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitleBar(BaseTitlebar baseTitlebar) {
        super.initTitleBar(baseTitlebar);
        baseTitlebar = getViewById(com.adapter.smart.core.R.id.base_title_bar);
        baseTitlebar.setTitle("黎明");
        baseTitlebar.setRightText("右侧",null);
    }

    @Override
    public void initView(View view) {
        mTextView = getViewById(R.id.tv);
    }

    @Override
    public void handleBundleData(Bundle bundleData) {
        if (bundleData == null) {
            return;
        }
        Log.i("xxx", "handleBundleData" +bundleData.getString("ss"));
    }


    @Override
    public void setListener() {
        mTextView.setOnClickListener(this);
    }

    @Override
    public void viewClicked(View v) {
        super.viewClicked(v);
        int id = v.getId();
        switch (id){
            case tv:
                startActivityWithNothing(Main2Activity.class);
                break;
        }
        Log.i("xxx", "viewClicked" +v.getId());
    }
}
