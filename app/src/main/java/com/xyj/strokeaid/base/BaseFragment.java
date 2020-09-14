package com.xyj.strokeaid.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.app.UserInfoCache;
import com.xyj.strokeaid.helper.PictureSelectorImageEngine;
import com.xyj.strokeaid.view.ActionSheet;

import org.greenrobot.eventbus.EventBus;

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
    protected BaseActivity mActivity;
    protected View mRootView;
    protected Unbinder mUnbinder;
    public Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
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

    @Override
    public void onResume() {
        super.onResume();
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


    protected boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideLoadingDialog();
        if (mUnbinder != null) {
            mUnbinder.unbind();
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
        if (mActivity != null) {
            mActivity.showLoadingDialog();
        }
    }

    public void hideLoadingDialog() {
        if (mActivity != null) {
            mActivity.hideLoadingDialog();
        }
    }


    public String getUserId() {
        return UserInfoCache.getInstance().getUserInfo().getId();
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


    /**
     * 显示 相机和相册 的action sheet
     *
     * @param listeners
     */
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

    /**
     * 打开相册
     *
     * @param listener
     */
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

    /**
     * 打开相机
     *
     * @param listener
     */
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

    
    
       
    