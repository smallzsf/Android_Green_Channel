package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.MainListBean;
import com.xyj.strokeaid.helper.CalendarUtils;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * BaseCommonActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/14
 * email ：licy3051@qq.com
 */
public abstract class BaseCommonActivity extends BaseActivity {

    long mAttackTime;
    long mArriveGateTime;
    ScheduledThreadPoolExecutor mExecutorService;
    Runnable myTask = null;
    String startTime = "--:--";
    String inHosTime = "--:--";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExecutorService = new ScheduledThreadPoolExecutor(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (myTask != null && mExecutorService != null) {
            mExecutorService.scheduleAtFixedRate(myTask, 0, 1, TimeUnit.SECONDS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mExecutorService != null) {
            mExecutorService.shutdown();
        }
    }

    public Runnable createTask(TextView tvStart, TextView tvInHos, MainListBean bean) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    String attacktime = bean.getAttacktime();
                    String arrivegatetime = bean.getArrivegatetime();
                    if (!TextUtils.isEmpty(attacktime)) {
                        Date date = CalendarUtils.parseTimeToDate(attacktime);
                        if (date != null) {
                            mAttackTime = date.getTime();
                            startTime = calTimeDelta(mAttackTime);
                        }
                    }
                    if (!TextUtils.isEmpty(arrivegatetime)) {
                        Date date = CalendarUtils.parseTimeToDate(arrivegatetime);
                        if (date != null) {
                            mArriveGateTime = date.getTime();
                            inHosTime = calTimeDelta(mArriveGateTime);
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvStart.setText(startTime);
                            tvInHos.setText(inHosTime);
                        }
                    });
                } catch (Exception e) {

                }
            }
        };
    }

    private String calTimeDelta(long startTime) {
        long current = System.currentTimeMillis();
        long deltaTime = current - startTime;
        long hours = deltaTime / (1000 * 60 * 60);
        long mins = (deltaTime - (hours * 1000 * 60 * 60)) / (1000 * 60);
        long seconds = (deltaTime - (hours * 1000 * 60 * 60) - (mins * 1000 * 60)) / 1000;
        StringBuilder stringBuilder = new StringBuilder();
        if (hours < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(hours);
        stringBuilder.append(":");
        if (mins < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(mins);
        stringBuilder.append(":");
        if (seconds < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(seconds);
        return stringBuilder.toString();
    }
}

    
    
       
    