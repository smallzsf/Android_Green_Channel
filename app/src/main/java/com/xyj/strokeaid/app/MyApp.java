package com.xyj.strokeaid.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.didichuxing.doraemonkit.BuildConfig;
import com.didichuxing.doraemonkit.DoraemonKit;

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

        // DoraemonKit
        if (BuildConfig.DEBUG) {
            DoraemonKit.install(this);
        }
    }


    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

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

    }
}

    
    
       
    