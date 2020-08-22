package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ThrombolysisInformedConsentActivity
 * description: 溶栓知情同意
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_INFORMED_CONSENT)
public class ThrombolysisInformedConsentActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_tic)
    BaseTitleBar titleBarActTic;
    @BindView(R.id.es_doc_act_tic)
    EditSpinner esDocActTic;
    @BindView(R.id.ttb_start_talk_act_tic)
    TextTimeBar ttbStartTalkActTic;
    @BindView(R.id.ttb_stop_talk_act_tic)
    TextTimeBar ttbStopTalkActTic;
    @BindView(R.id.es_opinion_act_tic)
    EditSpinner esOpinionActTic;
    @BindView(R.id.app_btn_ecg_examine_and_shot)
    Button appBtnEcgExamineAndShot;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolytic_informed_consent;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

        titleBarActTic.setLeftLayoutClickListener(v -> finish());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

    
    
       
    