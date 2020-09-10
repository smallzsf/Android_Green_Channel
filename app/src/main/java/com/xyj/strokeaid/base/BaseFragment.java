package com.xyj.strokeaid.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.UserInfoCache;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.PictureSelectorImageEngine;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.LoadingDialogFragment;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public abstract class BaseFragment extends Fragment {

    protected MMKV mDefaultMMKV;
    protected Activity mActivity;
    protected View mRootView;
    protected Unbinder mUnbinder;
    public Context context;
    protected LoadingDialogFragment mLoadingDialogFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        int id = getLayoutId();
        if (id > 0) {
            mRootView = inflater.inflate(id, container, false);
        }
        if (mRootView == null) {
            mRootView = onCreateView(savedInstanceState);
        }
        if (interceptTouchEvents()) {
            if (mRootView != null) {
                mRootView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
        }
        mDefaultMMKV = MMKV.defaultMMKV();
        mUnbinder = ButterKnife.bind(this, mRootView);
        initView(mRootView);
        initListener();
        return mRootView;
    }

    protected View onCreateView(Bundle savedInstanceState) {
        return mRootView;
    }

    protected boolean interceptTouchEvents() {
        return false;
    }

    public void showToast(CharSequence msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int res) {
        Toast.makeText(getContext(), res, Toast.LENGTH_SHORT).show();
    }

    public void showContent(Class<? extends BaseFragment> fragmentClass) {
        showContent(fragmentClass, null);
    }

    public void showContent(Class<? extends BaseFragment> fragmentClass, Bundle bundle) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null) {
            activity.showContent(fragmentClass, bundle);
        }
    }

    public void finish() {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity != null) {
            activity.doBack(this);
        }
    }

    protected boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mLoadingDialogFragment != null) {
            mLoadingDialogFragment.dismiss();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRootView != null) {
            mRootView = null;
        }
    }

    public void showLoadingDialog() {
        if (mLoadingDialogFragment == null) {
            mLoadingDialogFragment = new LoadingDialogFragment();
        }
        if (mLoadingDialogFragment.isVisible()) {
            return;
        }
        mLoadingDialogFragment.show(getChildFragmentManager(), "loading");
    }

    public void hideLoadingDialog() {
        if (mLoadingDialogFragment != null) {
            mLoadingDialogFragment.dismiss();
        }
    }


    protected TimePickerView mTimePickerView;

    /**
     * 显示时间选择控件
     *
     * @param tvShowTime 显示时间的 TextView
     */
    protected void showTimePickView(TextView tvShowTime) {
        Calendar startTime = Calendar.getInstance();
        startTime.set(1900, 0, 1);
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(tvShowTime, date);
                }
            })
                    .isDialog(false)
                    .setRangDate(startTime, Calendar.getInstance())
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
        Calendar startTime = Calendar.getInstance();
        startTime.set(1900, 0, 1);
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(textTimeBar, date);
                }
            })
                    .isDialog(false)
                    .setRangDate(startTime, Calendar.getInstance())
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
        Calendar startTime = Calendar.getInstance();
        startTime.set(1900, 0, 1);
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    refreshTime(tvShowTime, date);
                }
            })
                    .isDialog(false)
                    .setRangDate(startTime, Calendar.getInstance())
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
            textView.setTextColor(getResources().getColor(R.color.color_222222));
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

    public String getUserId() {
        return UserInfoCache.getInstance().getUserInfo().getId();
    }

    public String getCheckBoxValue(CheckBox... checkBoxes) {
        if (checkBoxes != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked()) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(checkBox.getTag().toString());
                }
            }
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

    /**
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void initView(@NonNull View view);

    /**
     * @return
     */
    protected abstract void initListener();


    protected void showPhotoSelector(OnResultCallbackListener<LocalMedia>... listeners) {
        ActionSheet.createBuilder(mActivity, getChildFragmentManager())
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
                                if (listeners != null && listeners.length > 0) {
                                    openCamera(listeners[0]);
                                }

                                break;
                            case 1:
                                if (listeners != null && listeners.length > 1) {
                                    openPhotoAlbum(listeners[1]);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }).show();
    }

    protected void openPhotoAlbum(OnResultCallbackListener<LocalMedia> listener) {
        if (listener == null) {
            return;
        }
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .maxSelectNum(1)
                .minSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.SINGLE)
                .imageEngine(PictureSelectorImageEngine.createGlideEngine())
                .forResult(listener);
    }

    protected void openCamera(OnResultCallbackListener<LocalMedia> listener) {
        if (listener == null) {
            return;
        }
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .imageEngine(PictureSelectorImageEngine.createGlideEngine())
                .forResult(listener);
    }
}

    
    
       
    