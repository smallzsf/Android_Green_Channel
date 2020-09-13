package com.xyj.strokeaid.activity.score;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.EmergencyCenterStrokeInterventionalTherapyPo;
import com.xyj.strokeaid.distutil.RadioGroupDistUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    @BindView(R.id.consultation_location)
    EditSpinner consultationLocation;
    private String mRecordId = "752594697788198912";
    //
//
    RadioGroupDistUtil rgContraindicationResultUtil;
    RadioGroupDistUtil rgIndicationResultUtil;

    EmergencyCenterStrokeInterventionalTherapyPo netBean = new EmergencyCenterStrokeInterventionalTherapyPo();

    @Override
    public int getLayoutId() {
        return R.layout.activity_interventional_therapy_evaluation;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

        rgContraindicationResultUtil = new RadioGroupDistUtil(mContext);
        rgIndicationResultUtil = new RadioGroupDistUtil(mContext);

        rgContraindicationResultUtil.setStringArrayId(R.array.contraindication_result);
        rgIndicationResultUtil.setStringArrayId(R.array.indication_result);

        edsYinYangFirst.setStringArrayId(R.array.doctor_test);
        consultationLocation.setStringArrayId(R.array.consultation_location);

    }

    @Override
    public void initListener() {
//        title_bar_act_nihss
        titleBarActNihss.setRightLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();

            }
        });
    }

    @OnClick({R.id.btn_indication_result, R.id.btn_contraindication_result})
    public void onClickLinstener(View view) {
        if (R.id.btn_indication_result == view.getId()) {
            // 适应症
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GET_INVOLVED_INDICATIONS)
                    .navigation();

        } else if (R.id.btn_contraindication_result == view.getId()) {
            // 禁忌症
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GET_INVOLVED_CONTRAINDICATIONS)
                    .navigation();
        }
    }


    private void save() {
        netBean = new EmergencyCenterStrokeInterventionalTherapyPo();
//        jrzlinterventdoctorreceptiontime	介入医生接诊	是	[datetime]		查看
        netBean.setJrzlinterventdoctorreceptiontime(ttbInterventionalDoctors.getTime());
//3	jrzlinterventdoctor	介入医生	是	[string]		查看

        // 医生列表
        netBean.setJrzlinterventdoctorreceptiontime(edsYinYangFirst.getSelectData()[1]);

//4	jrzldepartment	会诊地点	是	[string]		查看
        netBean.setJrzldepartment(consultationLocation.getSelectData()[1]);
//5	jrzlindicationevalutetime	适应症评估	是	[datetime]		查看
//6	jrzlindicationevaluteresult	适应症评估结果	是	[string]		查看
        netBean.setJrzlindicationevaluteresultrelationid(rgIndicationResultUtil.getSelectViewKey());
//7	jrzlindicationevaluteresultrelationid	适应症评估结果的评分关联Id	是	[string]		查看
//8	jrzlcontraindicationsevalutetime	禁忌症评估	是	[datetime]		查看
//9	jrzlcontraindicationsevaluteresult	禁忌症评估结果	是	[string]		查看
        netBean.setJrzlcontraindicationsevaluteresultrelationid(rgContraindicationResultUtil.getSelectViewKey());
//10	jrzlcontraindicationsevaluteresultrelationid	禁忌症评估结果的评分关联Id	是	[string]		查看
//11	jrzlalerttime	手术预警时间	是	[datetime]		查看
        netBean.setJrzlalerttime(ttbOperationWarningTime.getTime());
//12	jrzloperationprecompletedtime	急诊术前准备完成	是	[datetime]
        netBean.setJrzloperationprecompletedtime(ttbBeforeEmergencySurgery.getTime());

        saveDataToStroke();
    }


    private void saveDataToStroke() {

        BaseRequestBean<EmergencyCenterStrokeInterventionalTherapyPo> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, netBean);

        RetrofitClient.getInstance().getApi()
                .saveEcsitherapy(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
