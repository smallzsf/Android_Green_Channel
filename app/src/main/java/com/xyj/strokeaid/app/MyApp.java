package com.xyj.strokeaid.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.didichuxing.doraemonkit.DoraemonKit;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.BuildConfig;
import com.xyj.strokeaid.helper.ActivityStackManager;

/**
 * MyApp
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public class MyApp extends Application implements Application.ActivityLifecycleCallbacks {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);

        // 添加debug模式下的配置
        if (BuildConfig.DEBUG) {
            // DoraemonKit
//            DoraemonKit.install(this);
            // 打印日志
            ARouter.openLog();
            ARouter.openDebug();

            LogUtils.getConfig().setLogSwitch(true);
        } else {
            LogUtils.getConfig().setLogSwitch(false);
        }
        // 初始化路由工具
        ARouter.init(MyApp.this);
        // init MMKV 替代sp
        MMKV.initialize(this);
        // android utils
        Utils.init(this);
    }


    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        ActivityStackManager.getInstance().onActivityCreated(activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        ActivityStackManager.getInstance().onActivityDestroyed(activity);
    }
}

    
    
       
    