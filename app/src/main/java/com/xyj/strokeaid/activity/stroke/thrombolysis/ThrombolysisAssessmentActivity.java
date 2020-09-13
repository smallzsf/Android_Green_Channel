package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
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
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @Description: 溶栓评估
 * @Author: ck
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_ASSESSMENT)
public class ThrombolysisAssessmentActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_assessment)
    BaseTitleBar titleBarActAssessment;

    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;
    @BindView(R.id.es_emergency_nurse_frag_ti)
    EditSpinner esEmergencyNurseFragTi;
    @BindView(R.id.rb_exit)
    RadioButton rbExit;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.tv_titlt_indication)
    TextView tvTitltIndication;
    @BindView(R.id.rb_indication_ok)
    RadioButton rbIndicationOk;
    @BindView(R.id.rb_indication_no)
    RadioButton rbIndicationNo;
    @BindView(R.id.iv_right_view_indication)
    ImageView ivRightViewIndication;
    @BindView(R.id.tv_titlt_taboo)
    TextView tvTitltTaboo;
    @BindView(R.id.rb_taboo_have)
    RadioButton rbTabooHave;
    @BindView(R.id.rb_taboo_nothing)
    RadioButton rbTabooNothing;
    @BindView(R.id.iv_right_view_taboo)
    ImageView ivRightViewTaboo;
    @BindView(R.id.btn_save_data)
    AppCompatButton btnSaveData;

    private ProgressDialog loading;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_thrombolysis_assessment;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
//        loading = ProgressDialog.show(mContext, "", "数据获取。。。",true,false);

    }

    @Override
    public void initListener() {
        titleBarActAssessment.setLeftLayoutClickListener(v -> finish());
    }

    @OnClick({R.id.iv_right_view_indication, R.id.iv_right_view_taboo})
    public void onClickImage(View view) {
        if (view.getId() == R.id.iv_right_view_indication) {
            // 适应症评估结果
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THROMBOLYSIS_INDICATIONS)
                    .withString(IntentKey.RECORD_ID, mRecordId)
                    .navigation();
        } else if (view.getId() == R.id.iv_right_view_taboo) {
//             禁忌评估结果
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS)
                    .withString(IntentKey.RECORD_ID, mRecordId)
                    .navigation();
        }
    }


}
