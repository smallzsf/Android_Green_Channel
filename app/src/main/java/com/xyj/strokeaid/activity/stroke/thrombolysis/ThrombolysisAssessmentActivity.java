package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ThrombolysisAssessmentBean;
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
 * @Description: 溶栓评估
 * @Author: ck
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_ASSESSMENT)
public class ThrombolysisAssessmentActivity extends BaseActivity {

    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

    @BindView(R.id.title_bar_act_assessment)
    BaseTitleBar titleBarActAssessment;

    @BindView(R.id.btn_save_data)
    AppCompatButton btnSaveData;

    @BindView(R.id.ttb_doctor_receive_time)
    TextTimeBar ttbDoctorReceiveTime;
    @BindView(R.id.es_doctor_select)
    EditSpinner esDoctorSelect;
    @BindView(R.id.rb_exit)
    RadioButton rbExit;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.ttb_indication_time)
    TextTimeBar ttbIndicationTime;
    @BindView(R.id.tv_titlt_indication)
    TextView tvTitltIndication;
    @BindView(R.id.rb_indication_ok)
    RadioButton rbIndicationOk;
    @BindView(R.id.rb_indication_no)
    RadioButton rbIndicationNo;
    @BindView(R.id.iv_right_view_indication)
    ImageView ivRightViewIndication;
    @BindView(R.id.ttb_taboo)
    TextTimeBar ttbTaboo;
    @BindView(R.id.tv_titlt_taboo)
    TextView tvTitltTaboo;
    @BindView(R.id.rb_taboo_have)
    RadioButton rbTabooHave;
    @BindView(R.id.rb_taboo_nothing)
    RadioButton rbTabooNothing;
    @BindView(R.id.iv_right_view_taboo)
    ImageView ivRightViewTaboo;

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
        loadData(mRecordId);
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
            // 禁忌评估结果
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS)
                    .withString(IntentKey.RECORD_ID, mRecordId)
                    .navigation();
        }
    }

    /**
     * 加载数据
     */
    private void loadData(String recordId) {

        loading = ProgressDialog.show(mContext, "", "发送请求。。。", true, false);
        BaseRequestBean<ThrombolysisAssessmentBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 1, new ThrombolysisAssessmentBean());

        RetrofitClient.getInstance()
                .getApi()
                .getThrombolysisAssessment(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<ThrombolysisAssessmentBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<ThrombolysisAssessmentBean>> call,
                                           Response<BaseResponseBean<ThrombolysisAssessmentBean>> response) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }

//                        if (response.body() != null) {
//                            if (response.body().getResult() == 1) {
//                                viewInitData(response.body().getData().getData());
//                            } else {
//                                showToast(TextUtils.isEmpty(response.body().getMessage())
//                                        ? getString(R.string.http_tip_data_save_error)
//                                        : response.body().getMessage());
//                            }
//                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<ThrombolysisAssessmentBean>> call, Throwable t) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 保存
     */
    @OnClick(R.id.btn_save_data)
    public void onViewClicked() {

        ThrombolysisAssessmentBean thrombolysisAssessmentBean = new ThrombolysisAssessmentBean();
        thrombolysisAssessmentBean.setJmrsthrombolysisdoctorreceptiontime(ttbDoctorReceiveTime.getTime());
        // todo 溶栓医生 jmrsthrombolysisdoctor
        // 会诊地点
        if (rbExit.isChecked()) {
            thrombolysisAssessmentBean.setJmrsdepartment("cpc_jrzlhzdd_jzk");
        } else if (rbOther.isChecked()) {
            thrombolysisAssessmentBean.setJmrsdepartment("cpc_jrzlhzdd_qt");
        }
        //  适应症评估
        thrombolysisAssessmentBean.setJmrsindicationevalutetime(ttbIndicationTime.getTime());
        // 适应症评估结果
        if (rbIndicationOk.isChecked()) {
            thrombolysisAssessmentBean.setJmrsindicationevaluteresult("cpc_jrzlsyzpg_result_accord");
        } else if (rbIndicationNo.isChecked()) {
            thrombolysisAssessmentBean.setJmrsindicationevaluteresult("cpc_jrzlsyzpg_result_inconformity");
        }
        // 禁忌症评估
        thrombolysisAssessmentBean.setJmrscontraindicationsevalutetime(ttbTaboo.getTime());
        // 禁忌症评估结果
        if (rbTabooHave.isChecked()) {
            thrombolysisAssessmentBean.setJmrscontraindicationsevaluteresult("cpc_jrzljjzpg_result_inconformity");
        } else if (rbTabooNothing.isChecked()) {
            thrombolysisAssessmentBean.setJmrscontraindicationsevaluteresult("cpc_jrzljjzpg_result_accord");
        }

        saveData(thrombolysisAssessmentBean);
    }

    /**
     * 保存数据
     */
    private void saveData(ThrombolysisAssessmentBean thrombolysisAssessmentBean) {
        loading = ProgressDialog.show(mContext, "", "发送请求。。。", true, false);
        BaseRequestBean<ThrombolysisAssessmentBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 2, thrombolysisAssessmentBean);

        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainTriageInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {

                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }

                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                                finish();
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
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
