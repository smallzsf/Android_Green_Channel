package com.xyj.strokeaid.activity.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;

/**
  * @Package:        com.xyj.strokeaid.activity.detection
  * @ClassName:      ImagingCheckActivity
  * @Description:    影像检查
  * @Autho:          王水雷
  * @Time:           2020/8/24
 */
public class ImagingCheckActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View  {
    @Override
    public int getLayoutId() {
        return R.layout.activity_imaging_check;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showData(BaseObjectBean<NewAppplexyInfoBean> bean) {

    }

    @Override
    public void onLoadSaveSuccess(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String errMessage) {

    }
}