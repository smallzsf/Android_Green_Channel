package com.xyj.strokeaid.base;

import android.app.Activity;
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

import com.tencent.mmkv.MMKV;

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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
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
        mUnbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRootView != null) {
            mRootView = null;
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


}

    
    
       
    