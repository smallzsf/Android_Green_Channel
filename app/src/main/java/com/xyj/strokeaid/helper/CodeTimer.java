package com.xyj.strokeaid.helper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * @Description:验证码
 * @Author: crq
 * @CreateDate: 2020/8/26 11:30
 */
public class CodeTimer {
    private TextView mTextView;

    private final long mMillisInFuture;

    private final long mCountdownInterval;

    private long mStopTimeInFuture;

    private boolean mCancelled = false;

    public CodeTimer(TextView textView, long millisInFuture, long countDownInterval) {
        mMillisInFuture = millisInFuture;
        mCountdownInterval = countDownInterval;
        this.mTextView = textView;
    }

    public synchronized final void cancel() {
        mCancelled = true;
        mHandler.removeMessages(MSG);
    }

    public synchronized final CodeTimer start() {
        mCancelled = false;
        if (mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
        mHandler.sendMessage(mHandler.obtainMessage(MSG));
        return this;
    }

    private static final int MSG = 1;

    // handles counting down
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            synchronized (CodeTimer.this) {
                if (mCancelled) {
                    return;
                }

                final long millisLeft = mStopTimeInFuture - SystemClock.elapsedRealtime();

                if (millisLeft <= 0) {
                    onFinish();
                } else {
                    long lastTickStart = SystemClock.elapsedRealtime();
                    onTick(millisLeft);

                    // take into account user's onTick taking time to execute
                    long lastTickDuration = SystemClock.elapsedRealtime() - lastTickStart;
                    long delay;

                    if (millisLeft < mCountdownInterval) {
                        // just delay until done
                        delay = millisLeft - lastTickDuration;

                        // special case: user's onTick took more than interval to
                        // complete, trigger onFinish without delay
                        if (delay < 0) {
                            delay = 0;
                        }
                    } else {
                        delay = mCountdownInterval - lastTickDuration;

                        // special case: user's onTick took more than interval to
                        // complete, skip to next interval
                        while (delay < 0) {
                            delay += mCountdownInterval;
                        }
                    }

                    sendMessageDelayed(obtainMessage(MSG), delay);
                }
            }
        }
    };

    @SuppressLint("DefaultLocale")
    public void onTick(long millisUntilFinished) {
        int second = Math.round(millisUntilFinished / 1000f);
        mTextView.setText(String.format("%02d秒后重试", second));
    }

    public void onFinish() {
        mTextView.setText("获取验证码");
        //重新获得点击
        mTextView.setClickable(true);
    }
}