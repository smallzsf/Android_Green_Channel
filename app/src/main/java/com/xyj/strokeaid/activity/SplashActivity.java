package com.xyj.strokeaid.activity;

import android.content.Intent;
import android.text.TextUtils;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.login.LoginActivity;
import com.xyj.strokeaid.app.MmkvKey;
import com.xyj.strokeaid.base.BaseActivity;

/**
 * SplashActivity
 * description: app 欢迎页
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String token = mDefaultMMKV.decodeString(MmkvKey.TOKEN);
        if (TextUtils.isEmpty(token)) {
            startActivity(new Intent(mContext, LoginActivity.class));
        } else {
            startActivity(new Intent(mContext, MainActivity.class));
        }
        finish();
    }
}