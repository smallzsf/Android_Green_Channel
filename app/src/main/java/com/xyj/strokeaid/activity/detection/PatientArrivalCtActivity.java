package com.xyj.strokeaid.activity.detection;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;
import com.xyj.strokeaid.view.BaseTitleBar;

import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Package: com.xyj.strokeaid.activity.detection
 * @ClassName: PatientArrivalCtActivity
 * @Description: 患者到达CT室
 * @Autho: 王水雷
 * @Time: 2020/8/24
 */
@Route(path = RouteUrl.Detection.PATIENT_ARRIVAL)
public class PatientArrivalCtActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View {

    @BindView(R.id.title_bar_patient_arr)
    BaseTitleBar titleBarPatientArr;
    @BindView(R.id.tv_time_include_time)
    TextView tvTimeIncludeTime;
    @BindView(R.id.iv_refresh_include_time)
    ImageView ivRefreshIncludeTime;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_arrival_ct;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarPatientArr.setLeftLayoutClickListener(v -> finish());
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

    @OnClick({R.id.tv_time_include_time,R.id.iv_refresh_include_time, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_time_include_time:
                showTimePickView(tvTimeIncludeTime);
                break;
            case R.id.iv_refresh_include_time:
                refreshTime(tvTimeIncludeTime);
                break;
            case R.id.btn_confirm:
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }
}