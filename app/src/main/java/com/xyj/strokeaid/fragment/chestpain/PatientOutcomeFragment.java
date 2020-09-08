package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.chestpain.PatientOutcomeBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * PatientChestPainRecordActivity
 * description: 胸痛 -- 患者转归 -- 页面
 *
 * @author : Licy
 * @date : 2020/9/1
 * email ：licy3051@qq.com
 */
public class PatientOutcomeFragment extends BaseFragment {

    @BindView(R.id.es_title_select)
    EditSpinner esTitleSelect;
    @BindView(R.id.ttb_confirm_time)
    TextTimeBar ttbConfirmTime;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rb_rg_heart_failure_yes)
    RadioButton rbRgHeartFailureYes;
    @BindView(R.id.rb_rg_heart_failure_no)
    RadioButton rbRgHeartFailureNo;
    @BindView(R.id.rg_heart_failure)
    RadioGroup rgHeartFailure;
    @BindView(R.id.cb_setmi_1)
    CheckBox cbSetmi1;
    @BindView(R.id.cb_setmi_2)
    CheckBox cbSetmi2;
    @BindView(R.id.cb_setmi_3)
    CheckBox cbSetmi3;
    @BindView(R.id.cb_setmi_4)
    CheckBox cbSetmi4;
    @BindView(R.id.cb_setmi_5)
    CheckBox cbSetmi5;
    @BindView(R.id.cb_setmi_6)
    CheckBox cbSetmi6;
    @BindView(R.id.cb_setmi_7)
    CheckBox cbSetmi7;
    @BindView(R.id.cb_setmi_8)
    CheckBox cbSetmi8;
    @BindView(R.id.cb_setmi_9)
    CheckBox cbSetmi9;
    @BindView(R.id.cb_setmi_10)
    CheckBox cbSetmi10;
    @BindView(R.id.cb_setmi_11)
    CheckBox cbSetmi11;
    @BindView(R.id.cb_setmi_12)
    CheckBox cbSetmi12;
    @BindView(R.id.ll_stemi)
    LinearLayout llStemi;
    @BindView(R.id.cb_non_acs_5)
    CheckBox cbNonAcs5;
    @BindView(R.id.cb_non_acs_6)
    CheckBox cbNonAcs6;
    @BindView(R.id.cb_non_acs_7)
    CheckBox cbNonAcs7;
    @BindView(R.id.cb_non_acs_8)
    CheckBox cbNonAcs8;
    @BindView(R.id.cb_non_acs_9)
    CheckBox cbNonAcs9;
    @BindView(R.id.cb_non_acs_24)
    CheckBox cbNonAcs24;
    @BindView(R.id.cb_non_acs_10)
    CheckBox cbNonAcs10;
    @BindView(R.id.cb_non_acs_11)
    CheckBox cbNonAcs11;
    @BindView(R.id.cb_non_acs_12)
    CheckBox cbNonAcs12;
    @BindView(R.id.cb_non_acs_13)
    CheckBox cbNonAcs13;
    @BindView(R.id.cb_non_acs_14)
    CheckBox cbNonAcs14;
    @BindView(R.id.cb_non_acs_15)
    CheckBox cbNonAcs15;
    @BindView(R.id.cb_non_acs_16)
    CheckBox cbNonAcs16;
    @BindView(R.id.cb_non_acs_17)
    CheckBox cbNonAcs17;
    @BindView(R.id.cb_non_acs_18)
    CheckBox cbNonAcs18;
    @BindView(R.id.cb_non_acs_19)
    CheckBox cbNonAcs19;
    @BindView(R.id.cb_non_acs_20)
    CheckBox cbNonAcs20;
    @BindView(R.id.cb_non_acs_23)
    CheckBox cbNonAcs23;
    @BindView(R.id.cb_non_acs_1)
    CheckBox cbNonAcs1;
    @BindView(R.id.cb_non_acs_2)
    CheckBox cbNonAcs2;
    @BindView(R.id.cb_non_acs_3)
    CheckBox cbNonAcs3;
    @BindView(R.id.cb_non_acs_4)
    CheckBox cbNonAcs4;
    @BindView(R.id.cb_non_acs_21)
    CheckBox cbNonAcs21;
    @BindView(R.id.cb_non_acs_22)
    CheckBox cbNonAcs22;
    @BindView(R.id.ll_non_acs)
    LinearLayout llNonAcs;
    @BindView(R.id.cb_non_heart_1)
    CheckBox cbNonHeart1;
    @BindView(R.id.cb_non_heart_2)
    CheckBox cbNonHeart2;
    @BindView(R.id.cb_non_heart_3)
    CheckBox cbNonHeart3;
    @BindView(R.id.cb_non_heart_4)
    CheckBox cbNonHeart4;
    @BindView(R.id.cb_non_heart_5)
    CheckBox cbNonHeart5;
    @BindView(R.id.cb_non_heart_6)
    CheckBox cbNonHeart6;
    @BindView(R.id.cb_non_heart_7)
    CheckBox cbNonHeart7;
    @BindView(R.id.ll_non_heart)
    LinearLayout llNonHeart;

    private String mRecordId;
    private PatientOutcomeBean mOutcomeBean;
    private HashMap<String, String> mDiagnoseMap;
    private HashMap<String, String> mComplicationMap;

    public PatientOutcomeFragment() {

    }

    public static PatientOutcomeFragment newInstance(String recordId) {
        PatientOutcomeFragment fragment = new PatientOutcomeFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_patient_sum;
    }

    @Override
    protected void initView(@NonNull View view) {
        mDiagnoseMap = new HashMap<>();
        List<String> diagnoseStrings = Arrays.asList(getResources().getStringArray(R.array.confirm_diagnose));
        mDiagnoseMap.put(diagnoseStrings.get(0), "cpc_cyzdv2_stemi");
        mDiagnoseMap.put(diagnoseStrings.get(1), "cpc_cyzdv2_nstemi");
        mDiagnoseMap.put(diagnoseStrings.get(2), "cpc_cyzdv2_ua");
        mDiagnoseMap.put(diagnoseStrings.get(3), "cpc_cyzdv2_zdmjc");
        mDiagnoseMap.put(diagnoseStrings.get(4), "cpc_cyzdv2_fdmss");
        mDiagnoseMap.put(diagnoseStrings.get(5), "cpc_cyzdv2_facs");
        mDiagnoseMap.put(diagnoseStrings.get(6), "cpc_cyzdv2_otherxyxt");

//        mComplicationMap = new HashMap<>();
//        List<String> diagnoseStrings = Arrays.asList(getResources().getStringArray(R.array.confirm_diagnose));
//        mComplicationMap.put(diagnoseStrings.get(0), "cpc_cyzdv2_stemi");
//        mComplicationMap.put(diagnoseStrings.get(1), "cpc_cyzdv2_nstemi");

        esTitleSelect.setItemData(Arrays.asList(Constants.CHEST_PAIN_DIAGNOSE_CONTENT));
        loadViewData(mRecordId);
    }

    @Override
    protected void initListener() {
        esTitleSelect.setOnSelectIndexAndStringLitner(new EditSpinner.OnSelectIndexAndStringLitner() {
            @Override
            public void getSeletedStringAndIndex(String text, int position) {
                if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[0])
                        || TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[1])
                        || TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[2])) {
                    llStemi.setVisibility(View.VISIBLE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.GONE);
                } else if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[5])) {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.VISIBLE);
                    llNonHeart.setVisibility(View.GONE);
                } else if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[6])) {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.VISIBLE);
                } else {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.GONE);
                }
            }
        });
    }

    private void loadViewData(String recordId) {
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient.getInstance()
                .getApi().getChestPainPatientOutcome(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<PatientOutcomeBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<PatientOutcomeBean>> call, Response<BaseObjectBean<PatientOutcomeBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mOutcomeBean = response.body().getData();
                                if (mOutcomeBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    setViewData(mOutcomeBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<PatientOutcomeBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 默认 databean 不为null 且有数据
     */
    private void saveViewData() {
        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainPatientOutcome(mOutcomeBean.getResuestBody(mOutcomeBean))
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
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    private void setViewData(PatientOutcomeBean bean) {
        if (bean == null) {
            return;
        }

        // 诊断
        String dischargeddiagnosis = bean.getDischargeddiagnosis();
        if (!TextUtils.isEmpty(dischargeddiagnosis)) {
            if (dischargeddiagnosis.contains("cpc_cyzdv2_stemi")) {
                llStemi.setVisibility(View.VISIBLE);
                esTitleSelect.setText("STEMI");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_nstemi")) {
                llStemi.setVisibility(View.VISIBLE);
                esTitleSelect.setText("NSTEMI");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_ua")) {
                llStemi.setVisibility(View.VISIBLE);
                esTitleSelect.setText("UA");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_zdmjc")) {
                esTitleSelect.setText("主动脉夹层");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_fdmss")) {
                esTitleSelect.setText("肺动脉栓塞");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_facs")) {
                llNonAcs.setVisibility(View.VISIBLE);
                esTitleSelect.setText("非ACS心源性胸痛");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_otherxyxt")) {
                llNonHeart.setVisibility(View.VISIBLE);
                esTitleSelect.setText("其它非心源性胸痛");
            }
        }
        // 确诊时间
        ttbConfirmTime.setTime(bean.getDischargeddiagnosistime());
        //

    }

    private void getViewData() {
        if (mOutcomeBean == null) {
            mOutcomeBean = new PatientOutcomeBean();
        }
        mOutcomeBean.setRecordId(mRecordId);
        // 诊断
    }


}
