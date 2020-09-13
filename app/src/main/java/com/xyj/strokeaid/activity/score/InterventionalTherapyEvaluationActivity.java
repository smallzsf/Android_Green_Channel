package com.xyj.strokeaid.activity.score;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 介入评估治疗activity
 *
 * @author zhang
 */
public class InterventionalTherapyEvaluationActivity extends BaseActivity {
    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActNihss;
    @BindView(R.id.ttb_operation_warning_time)
    TextTimeBar ttbOperationWarningTime;
    @BindView(R.id.ttb_interventional_doctors)
    TextTimeBar ttbInterventionalDoctors;
    @BindView(R.id.eds_yin_yang_first)
    EditSpinner edsYinYangFirst;
    @BindView(R.id.rb_contraindication_result_true)
    RadioButton rbContraindicationResultTrue;
    @BindView(R.id.rb_contraindication_result_false)
    RadioButton rbContraindicationResultFalse;
    @BindView(R.id.rg_contraindication_result)
    RadioGroup rgContraindicationResult;
    @BindView(R.id.rb_indication_result_true)
    RadioButton rbIndicationResultTrue;
    @BindView(R.id.rb_indication_result_false)
    RadioButton rbIndicationResultFalse;
    @BindView(R.id.rg_indication_result)
    RadioGroup rgIndicationResult;
    @BindView(R.id.ttb_before_emergency_surgery)
    TextTimeBar ttbBeforeEmergencySurgery;
    @BindView(R.id.btn_contraindication_result)
    Button btnContraindicationResult;
    @BindView(R.id.btn_indication_result)
    Button btnIndicationResult;

    @Override
    public int getLayoutId() {
        return R.layout.activity_interventional_therapy_evaluation;
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
    @OnClick({R.id.btn_indication_result,R.id.btn_contraindication_result})
    public void onClickLinstener(View view){
        if (R.id.btn_indication_result == view.getId()){
            // 适应症
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GET_INVOLVED_INDICATIONS)
                    .navigation();

        }else  if (R.id.btn_contraindication_result == view.getId()){
            // 禁忌症
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GET_INVOLVED_CONTRAINDICATIONS)
                    .navigation();
        }
    }
}
