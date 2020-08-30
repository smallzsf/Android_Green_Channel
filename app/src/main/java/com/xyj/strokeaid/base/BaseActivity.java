package com.xyj.strokeaid.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.immersionbar.ImmersionBar;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.KeyboardUtils;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;

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
        initImmersionBar();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mContext = this;
        mDefaultMMKV = MMKV.defaultMMKV();
        int id = getLayoutId();
        if (id > 0) {
            setContentView(id);
        } else {
            throw new Resources.NotFoundException();
        }
        initInject();
        ButterKnife.bind(this);
        initView();
        initListener();


    }

    protected void initImmersionBar(){
        // 初始化沉浸式状态栏
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .fitsSystemWindows(true)
                .keyboardEnable(true)
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
                .init();
    }


    @Override
    protected void onResume() {
        super.onResume();
        KeyboardUtils.hideKeyboard(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        KeyboardUtils.hideKeyboard(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
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
     * 初始化注入框架
     */
    protected abstract void initInject();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

    protected TimePickerView mTimePickerView;

    /**
     * 显示时间选择控件
     *
     * @param tvShowTime 显示时间的 TextView
     */
    protected void showTimePickView(TextView tvShowTime) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(tvShowTime);
                }
            })
                    .isDialog(false)
                    .setOutSideCancelable(true)
                    .setRangDate(CalendarUtils.getPastWeek(1, new Date()), Calendar.getInstance())
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }

    /**
     * 刷新对应view中显示的时间
     *
     * @param textView
     */
    protected void refreshTime(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setTextColor(getColor(R.color.color_222222));
            } else {
                textView.setTextColor(getResources().getColor(R.color.color_222222));
            }
            textView.setText(CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, new Date()));
        }
    }

    public void showToast(CharSequence msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int res) {
        Toast.makeText(mContext, res, Toast.LENGTH_SHORT).show();
    }
}

    
    
       
    