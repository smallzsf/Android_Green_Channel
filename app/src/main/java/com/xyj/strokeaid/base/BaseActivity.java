package com.xyj.strokeaid.base;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gyf.immersionbar.ImmersionBar;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.R;

import java.util.ArrayDeque;

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


    private ArrayDeque<BaseFragment> mFragments = new ArrayDeque<>();

    public void showContent(Class<? extends BaseFragment> target) {
        showContent(target, null);
    }

    public void showContent(Class<? extends BaseFragment> target, Bundle bundle) {
        try {
            BaseFragment fragment = target.newInstance();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragment);
            mFragments.push(fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (!mFragments.isEmpty()) {
            BaseFragment fragment = mFragments.getFirst();
            if (!fragment.onBackPressed()) {
                mFragments.removeFirst();
                super.onBackPressed();
                if (mFragments.isEmpty()) {
                    finish();
                }
            }
        } else {
            super.onBackPressed();
        }
    }

    public void doBack(BaseFragment fragment) {
        if (mFragments.contains(fragment)) {
            mFragments.remove(fragment);
            FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();
            if (mFragments.isEmpty()) {
                finish();
            }
        }
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

    
    
       
    