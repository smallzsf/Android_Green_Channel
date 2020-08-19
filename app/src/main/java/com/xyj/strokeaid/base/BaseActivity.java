package com.xyj.strokeaid.base;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.R;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected MMKV mDefaultMMKV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        ButterKnife.bind(this);
        initView();
        initListener();

        mContext = this;
        mDefaultMMKV = MMKV.defaultMMKV();

        // 初始化沉浸式状态栏
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .fitsSystemWindows(true)
                .keyboardEnable(true)
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

}

    
    
       
    