package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ThrombolyticDocReceiveActivity
 * description: 溶栓医生接诊时间
 *
 * @author : Licy
 * @date : 2020-08-21 15:06:01
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_DOC_RECEIVE)
public class ThrombolysisDocReceiveActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_tdr)
    BaseTitleBar titleBarActTdr;
    @BindView(R.id.tv_time_include_time)
    TextView tvTimeIncludeTime;
    @BindView(R.id.iv_refresh_include_time)
    ImageView ivRefreshIncludeTime;
    @BindView(R.id.es_destination_act_tdr)
    EditSpinner esDestinationActTdr;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolytic_doc_receive;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        // TODO: 2020/8/21 拿到医生列表，填充数据
    }

    @Override
    public void initListener() {
        titleBarActTdr.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.tv_time_include_time, R.id.iv_refresh_include_time, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_time_include_time:
                showTimePickView(tvTimeIncludeTime);
                break;
            case R.id.iv_refresh_include_time:
                refreshTime(tvTimeIncludeTime);
                break;
            case R.id.btn_confirm:
                // TODO: 2020/8/21 保存信息
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

}