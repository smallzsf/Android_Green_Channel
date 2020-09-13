package com.xyj.strokeaid.base;

import android.content.Context;
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
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.UserInfoCache;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.KeyboardUtils;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.LoadingDialogFragment;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.List;

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
    protected LoadingDialogFragment mLoadingDialogFragment;

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

    protected void initImmersionBar() {
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
        if (mLoadingDialogFragment != null) {
            mLoadingDialogFragment.dismiss();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }

//    @Override
//    public Resources getResources() {
//        return super.getResources();
//        Resources resources = super.getResources();
//        Configuration configuration = new Configuration();
//        configuration.setToDefaults();
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//        return resources;
//    }

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
                    refreshTime(tvShowTime, date);
                }
            })
                    .isDialog(false)
                    .setOutSideCancelable(true)
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }


    /**
     * 显示时间选择控件
     *
     * @param textTimeBar 显示时间的 TextView
     */
    protected void showTimePickView(TextTimeBar textTimeBar) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(textTimeBar, date);
                }
            })
                    .isDialog(false)
                    .setOutSideCancelable(true)
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }

    /**
     * 显示时间选择控件
     *
     * @param tvShowTime 显示时间的 TextView
     */
    protected void showTimePickView(SettingBar tvShowTime) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(tvShowTime, date);
                }
            })
                    .isDialog(false)
                    .setOutSideCancelable(true)
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }

    /**
     * 显示时间选择控件
     *
     * @param settingBar 显示时间的 TextView
     */
    protected void showBirthPickView(SettingBar settingBar) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    String birth = CalendarUtils.parseDate(CalendarUtils.TYPE_YEAR_MONTH_DAY, date);
                    settingBar.setRightText(birth);
                }
            })
                    .isDialog(false)
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .setOutSideCancelable(true)
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
    protected void refreshTime(TextView textView, Date date) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setTextColor(getColor(R.color.color_222222));
            } else {
                textView.setTextColor(getResources().getColor(R.color.color_222222));
            }
            textView.setText(CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date));
        }
    }

    /**
     * 刷新对应view中显示的时间
     *
     * @param textTimeBar
     */
    protected void refreshTime(TextTimeBar textTimeBar, Date date) {
        if (textTimeBar != null) {
            textTimeBar.setTime(CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date));
        }
    }

    /**
     * 刷新对应view中显示的时间
     *
     * @param settingBar
     */
    protected void refreshTime(SettingBar settingBar, Date date) {
        if (settingBar != null) {
            settingBar.setRightTextColor(getResources().getColor(R.color.color_222222));
            settingBar.setRightText(CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date));
        }
    }

    public void showToast(CharSequence msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int res) {
        Toast.makeText(mContext, res, Toast.LENGTH_SHORT).show();
    }

    public String getUserId() {
        return UserInfoCache.getInstance().getUserInfo().getId();
    }

    public void showLoadingDialog() {
        if (mLoadingDialogFragment == null) {
            mLoadingDialogFragment = new LoadingDialogFragment();
        }
        if (mLoadingDialogFragment.isVisible()) {
            return;
        }
        mLoadingDialogFragment.show(getSupportFragmentManager(), "loading");
    }

    public void hideLoadingDialog() {
        if (mLoadingDialogFragment != null) {
            mLoadingDialogFragment.dismiss();
        }
    }

    protected void requestPerm(String permission) {
        if (XXPermissions.hasPermission(mContext, permission)) {
            // 已经获取权限，无须再申请
            return;
        }
        XXPermissions.with(this)
                .permission(permission)
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean all) {
                        if (all) {
                            showToast("获取权限成功");
                        } else {
                            showToast("获取权限成功，部分权限未正常授予");
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean never) {
                        if (never) {
                            showToast("被永久拒绝授权，请手动授予权限");
                            // 如果是被永久拒绝就跳转到应用权限系统设置页面
                            XXPermissions.startPermissionActivity(mContext, denied);
                        } else {
                            showToast("获取权限失败");
                        }
                    }
                });
    }

    protected void requestPerms(String correctString, String deniedString, String... permission) {

        if (XXPermissions.hasPermission(mContext, permission)) {
            // 已经获取权限，无须再申请
            return;
        }
        XXPermissions.with(this)
                .permission(permission)
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean all) {
                        if (all) {
                            showToast(correctString);
                        } else {
                            showToast("部分权限未正常授予");
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean never) {
                        if (never) {
                            showToast("被永久拒绝授权，请手动授予权限");
                            // 如果是被永久拒绝就跳转到应用权限系统设置页面
                            XXPermissions.startPermissionActivity(mContext, denied);
                        } else {
                            showToast(deniedString);
                        }
                    }
                });
    }

    protected void showPhotoSelector(OnResultCallbackListener<LocalMedia>... listeners) {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("拍照", "相册")
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        switch (index) {
                            case 0:
                                openCamera(listeners[0]);
                                break;
                            case 1:
                                openPhotoAlbum(listeners[1]);
                                break;
                            default:
                                break;
                        }
                    }
                }).show();
    }

    protected void openPhotoAlbum(OnResultCallbackListener<LocalMedia> listener) {
        if (listener == null){
            return;
        }
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .maxSelectNum(1)
                .minSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.SINGLE)
                .forResult(listener);
    }

    protected void openCamera(OnResultCallbackListener<LocalMedia> listener) {
        if (listener == null){
            return;
        }
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .forResult(listener);
    }
}

    
    
       
    