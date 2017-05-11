package com.adapter.smart.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.adapter.smart.core.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    private TextView tv1;
    @Override
    public int bindLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView(View contentView) {
        tv1 = getViewById(R.id.tv2);
    }

    @Override
    public void handleBundleData(Bundle bundleData) {

    }


    @Override
    public void setListener() {
        tv1.setOnClickListener(this);
    }

    @Override
    public void viewClicked(View v) {
        super.viewClicked(v);
        int id = v.getId();
        switch (id){
            case R.id.tv2:
                Bundle bundle = new Bundle();
                bundle.putString("ss","333");
                startActivityWithBundle(MainActivity.class,bundle);
                break;
        }
    }
}
