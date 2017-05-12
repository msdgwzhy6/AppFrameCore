package com.adapter.smart.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adapter.smart.core.R;
/**
 * 自定义Titlebar
 */
public class BaseTitlebar extends RelativeLayout {

    private Context mContext;
    /**
     * titleBar文字标题显示
     */
    private TextView titleText;

    /**
     * 图片标题显示
     */
    private ImageView titleImg;

    /**
     * 图标左返回按钮
     */
    private ImageButton backButton;
    /**
     * 左返回文字按钮
     */
    private TextView leftTextButton;
    /**
     * 右侧图标按钮
     */
    private ImageButton rightButton;
    /**
     * 右侧文字按钮
     */
    private TextView rightTextButton;

    private RelativeLayout title_center_line;

    public BaseTitlebar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public BaseTitlebar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public BaseTitlebar(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        backButton = (ImageButton) findViewById(R.id.base_back_button);//返回按钮
        titleText = (TextView) findViewById(R.id.base_title);
        rightButton = (ImageButton) findViewById(R.id.base_right_button);
        rightTextButton = (TextView) findViewById(R.id.base_right_text);
        title_center_line = (RelativeLayout) findViewById(R.id.base_title_center_line);
        titleImg = (ImageView) findViewById(R.id.base_title_img);
        rightButton.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);
        leftTextButton=(TextView) findViewById(R.id.base_left_text);

    }

    /**
     * 设置文字标题
     */
    public void setTitle(CharSequence title) {
        if (titleText == null)
            return;
        titleText.setText(title);
        titleText.setVisibility(View.VISIBLE);
    }

    /**
     * 设置图片标题
     *
     * @param resId
     */
    public void setTitleImg(int resId) {

        titleImg.setImageResource(resId);
        titleImg.setVisibility(View.VISIBLE);
        titleText.setVisibility(View.VISIBLE);

    }

    /**
     * 设置返回按钮
     *
     * @param resId
     */

    public void setBackButton(int resId, OnClickListener listener) {
        backButton.setImageResource(resId);
        backButton.setVisibility(View.VISIBLE);
        this.backButton.setOnClickListener(listener);
    }
    /**
     * 设置左侧文字按钮按钮
     *
     */

    public void setLeftTextButton(String str, OnClickListener listener) {
        leftTextButton.setText("  ");
        leftTextButton.setVisibility(View.VISIBLE);
        this.leftTextButton.setOnClickListener(listener);
    }

    /**
     * 设置右侧按钮
     *
     * @param resId
     */
    public void setRightButton(int resId, OnClickListener listener) {
        rightButton.setImageResource(resId);
        rightButton.setOnClickListener(listener);
        rightButton.setVisibility(View.VISIBLE);

    }

    /**
     * 右侧文字按钮
     *
     * @param title
     * @param listener
     */
    public void setRightText(String title, OnClickListener listener) {

        rightTextButton.setText(title);
        rightTextButton.setOnClickListener(listener);
        if (listener == null) {
            Log.i("xxx", "setRightText" +"您未设置监听事件");
        }
        rightTextButton.setVisibility(View.VISIBLE);

    }


    public TextView getRightTextButton() {
        return rightTextButton;
    }

    public ImageButton getBackButton() {
        return backButton;
    }

    public ImageButton getRightTitleButton() {
        return rightButton;
    }

    public RelativeLayout getCenterTitleLine() {
        return title_center_line;
    }

    public TextView getTitle() {
        return titleText;
    }

    public ImageView getImageCenter() {
        return titleImg;
    }

}
