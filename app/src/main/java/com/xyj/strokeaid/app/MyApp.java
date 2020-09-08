package com.xyj.strokeaid.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.didichuxing.doraemonkit.DoraemonKit;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.xyj.strokeaid.BuildConfig;
import com.xyj.strokeaid.bean.DaoMaster;
import com.xyj.strokeaid.bean.DaoSession;
import com.xyj.strokeaid.helper.ActivityStackManager;

import cn.jpush.android.api.JPushInterface;

/**
 * MyApp
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public class MyApp extends Application implements Application.ActivityLifecycleCallbacks {

    private static MyApp mApp;
    private static DaoSession mDaoSession;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(this);

        initUtils();
        // bugly 统一 初始化
        initBugly();
        // 初始化路由工具
        ARouter.init(MyApp.this);
        // init MMKV 替代sp
        MMKV.initialize(this);
        // 配置数据库
        initGreenDao();
        // 友盟统计
        UMConfigure.setLogEnabled(BuildConfig.DEBUG);
        UMConfigure.init(this, AppConfig.YOUMENG_AK, "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        // 极光
        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(this);
        // 添加debug模式下的配置
        if (BuildConfig.DEBUG) {
            // DoraemonKit
            DoraemonKit.install(this);
            // 打印日志
            ARouter.openLog();
            ARouter.openDebug();
        }

    }

    private void initGreenDao() {
        //创建数据库mydb.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "xyjdb.db");
        //获取可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        mDaoSession = daoMaster.newSession();
    }

    private void initBugly(){
        /**
         * true表示app启动自动初始化升级模块；
         * false不好自动初始化
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
         * 在后面某个时刻手动调用
         */
        Beta.autoInit = true;

        /**
         * true表示初始化时自动检查升级
         * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
         */
        Beta.autoCheckUpgrade = true;
        Bugly.init(this, AppConfig.BUGLY_APP_ID, BuildConfig.DEBUG);
    }

    private void initUtils(){
        Utils.init(this);
        LogUtils.getConfig().setGlobalTag("xyjAid");
        LogUtils.getConfig().setLogSwitch(BuildConfig.DEBUG);
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
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

    
    
       
    