package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextSwitchBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ThrombolysisIndicationsActivity
 * description: 溶栓适应症
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_INDICATIONS)
public class ThrombolysisIndicationsActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_ti)
    BaseTitleBar titleBarActTi;
    @BindView(R.id.tsb_age_act_ti)
    TextSwitchBar tsbAgeActTi;
    @BindView(R.id.tsb_duration_act_ti)
    TextSwitchBar tsbDurationActTi;
    @BindView(R.id.tsb_symptom_act_ti)
    TextSwitchBar tsbSymptomActTi;
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
        return R.layout.stroke_act_thrombolysis_indications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarActTi.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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

    
    
       
    