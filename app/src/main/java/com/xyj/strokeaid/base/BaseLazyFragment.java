package com.xyj.strokeaid.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseLazyFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public abstract class BaseLazyFragment extends BaseFragment {


    public final String TAG = this.getClass().getSimpleName();

    /**
     * 是否初始化过布局
     */
    protected boolean isViewInitiated;
    /**
     * 当前界面是否可见
     */
    protected boolean isVisibleToUser;
    /**
     * 是否加载过数据
     */
    protected boolean isDataInitiated;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            prepareFetchData();
        }
    }

    private void prepareFetchData() {
        LogUtils.d(TAG, "isVisibleToUser is " + isVisibleToUser +
                "\nisViewInitiated is " + isViewInitiated +
                "\nisDataInitiated is " + isDataInitiated);
        if (isVisibleToUser && isViewInitiated && !isDataInitiated) {
            loadData();
            isDataInitiated = true;
        }
    }

    /**
     * 加载网络数据
     */
    protected abstract void loadData();

    /**
     * Fragment 返回键被按下时回调
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 默认不拦截按键事件，回传给 Activity
        return false;
    }

}

    
    
       
    