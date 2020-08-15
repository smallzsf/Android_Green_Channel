package com.xyj.strokeaid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.login.LoginActivity;

/**
 * SplashActivity
 * description: app 欢迎页
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}