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
    @BindView(R.id.rb_heart_failure_yes)
    RadioButton rbHeartFailureYes;
    @BindView(R.id.rb_heart_failure_no)
    RadioButton rbHeartFailureNo;
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
    @BindView(R.id.cb_setmi_13)
    CheckBox cbSetmi13;
    @BindView(R.id.ll_stemi)
    LinearLayout llStemi;
    @BindView(R.id.cb_non_acs_1)
    CheckBox cbNonAcs1;
    @BindView(R.id.cb_non_acs_2)
    CheckBox cbNonAcs2;
    @BindView(R.id.cb_non_acs_3)
    CheckBox cbNonAcs3;
    @BindView(R.id.cb_non_acs_4)
    CheckBox cbNonAcs4;
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
    @BindView(R.id.cb_non_acs_21)
    CheckBox cbNonAcs21;
    @BindView(R.id.cb_non_acs_22)
    CheckBox cbNonAcs22;
    @BindView(R.id.cb_non_acs_23)
    CheckBox cbNonAcs23;
    @BindView(R.id.cb_non_acs_24)
    CheckBox cbNonAcs24;
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
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    private PatientOutcomeBean mOutcomeBean;
    private HashMap<String, String> mDiagnoseMap;
    private HashMap<String, String> mComplicationMap;
    private HashMap<String, String> mUnacsMap;
    private HashMap<String, String> mOtherunacsMap;

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
        mDiagnoseMap = new HashMap<>(7);
        List<String> diagnoseStrings = Arrays.asList(getResources().getStringArray(R.array.confirm_diagnose));
        mDiagnoseMap.put(diagnoseStrings.get(0), "cpc_cyzdv2_stemi");
        mDiagnoseMap.put(diagnoseStrings.get(1), "cpc_cyzdv2_nstemi");
        mDiagnoseMap.put(diagnoseStrings.get(2), "cpc_cyzdv2_ua");
        mDiagnoseMap.put(diagnoseStrings.get(3), "cpc_cyzdv2_zdmjc");
        mDiagnoseMap.put(diagnoseStrings.get(4), "cpc_cyzdv2_fdmss");
        mDiagnoseMap.put(diagnoseStrings.get(5), "cpc_cyzdv2_facs");
        mDiagnoseMap.put(diagnoseStrings.get(6), "cpc_cyzdv2_otherxyxt");

        mComplicationMap = new HashMap<>(13);
        List<String> complicationStrings = Arrays.asList(getResources().getStringArray(R.array.chest_pain_non_acs_complication));
        mComplicationMap.put(complicationStrings.get(0), "cpc_complication_xk");
        mComplicationMap.put(complicationStrings.get(1), "cpc_complication_jxxbfz");
        mComplicationMap.put(complicationStrings.get(2), "cpc_complication_gr");
        mComplicationMap.put(complicationStrings.get(3), "cpc_complication_zfxg");
        mComplicationMap.put(complicationStrings.get(4), "cpc_complication_xs");
        mComplicationMap.put(complicationStrings.get(5), "cpc_complication_cz");
        mComplicationMap.put(complicationStrings.get(6), "cpc_complication_tia");
        mComplicationMap.put(complicationStrings.get(7), "cpc_complication_cx");
        mComplicationMap.put(complicationStrings.get(8), "cpc_complication_hxsj");
        mComplicationMap.put(complicationStrings.get(9), "cpc_complication_ssj");
        mComplicationMap.put(complicationStrings.get(10), "cpc_complication_sw");
        mComplicationMap.put(complicationStrings.get(11), "cpc_complication_exxlsc");
        mComplicationMap.put(complicationStrings.get(12), "cpc_complication_wu");

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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewData();
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
                setStemiView(bean);
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_nstemi")) {
                llStemi.setVisibility(View.VISIBLE);
                esTitleSelect.setText("NSTEMI");
                setStemiView(bean);
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_ua")) {
                llStemi.setVisibility(View.VISIBLE);
                esTitleSelect.setText("UA");
                setStemiView(bean);
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_zdmjc")) {
                esTitleSelect.setText("主动脉夹层");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_fdmss")) {
                esTitleSelect.setText("肺动脉栓塞");
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_facs")) {
                llNonAcs.setVisibility(View.VISIBLE);
                esTitleSelect.setText("非ACS心源性胸痛");
                setUnacsView(bean);
            } else if (dischargeddiagnosis.contains("cpc_cyzdv2_otherxyxt")) {
                llNonHeart.setVisibility(View.VISIBLE);
                esTitleSelect.setText("其它非心源性胸痛");
                setOtherHeartView(bean);
            }
        }
        // 确诊时间
        ttbConfirmTime.setTime(bean.getDischargeddiagnosistime());

    }

    private void setStemiView(PatientOutcomeBean bean) {
        // 院内新发心力衰竭
        String isheartfailureinhospital = bean.getIsheartfailureinhospital();
        if (!TextUtils.isEmpty(isheartfailureinhospital)) {
            if (isheartfailureinhospital.contains("cpc_bool_true")) {
                rgHeartFailure.check(R.id.rb_heart_failure_yes);
            } else if (isheartfailureinhospital.contains("cpc_bool_false")) {
                rgHeartFailure.check(R.id.rb_heart_failure_no);
            }
        }
        // 住院期间并发症
        String complication = bean.getComplication();
        if (!TextUtils.isEmpty(complication)) {
            if (complication.contains("cpc_complication_wu")) {
                cbSetmi13.setChecked(true);
            } else {
                cbSetmi1.setChecked(complication.contains("cpc_complication_xk"));
                cbSetmi2.setChecked(complication.contains("cpc_complication_jxxbfz"));
                cbSetmi3.setChecked(complication.contains("cpc_complication_gr"));
                cbSetmi4.setChecked(complication.contains("cpc_complication_zfxg"));
                cbSetmi5.setChecked(complication.contains("cpc_complication_xs"));
                cbSetmi6.setChecked(complication.contains("cpc_complication_cz"));
                cbSetmi7.setChecked(complication.contains("cpc_complication_tia"));
                cbSetmi8.setChecked(complication.contains("cpc_complication_cx"));
                cbSetmi9.setChecked(complication.contains("cpc_complication_hxsj"));
                cbSetmi10.setChecked(complication.contains("cpc_complication_ssj"));
                cbSetmi11.setChecked(complication.contains("cpc_complication_sw"));
                cbSetmi12.setChecked(complication.contains("cpc_complication_exxlsc"));
            }
        }
    }

    /**
     * 非ACS心源性胸痛类型
     *
     * @param bean
     */
    private void setUnacsView(PatientOutcomeBean bean) {
        String dischargedunacs = bean.getDischargedunacs();
        if (!TextUtils.isEmpty(dischargedunacs)) {
            cbNonAcs1.setChecked(dischargedunacs.contains("cpc_unacs_xlsc"));
            cbNonAcs2.setChecked(dischargedunacs.contains("cpc_unacs_kzxxjb"));
            cbNonAcs3.setChecked(dischargedunacs.contains("cpc_unacs_qxxxjb"));
            cbNonAcs4.setChecked(dischargedunacs.contains("cpc_unacs_fhxxjb"));
            cbNonAcs5.setChecked(dischargedunacs.contains("cpc_unacs_xjb"));
            cbNonAcs6.setChecked(dischargedunacs.contains("cpc_unacs_gxb"));
            cbNonAcs7.setChecked(dischargedunacs.contains("cpc_unacs_bmxxjb"));
            cbNonAcs8.setChecked(dischargedunacs.contains("cpc_unacs_cjxxjgs"));
            cbNonAcs9.setChecked(dischargedunacs.contains("cpc_unacs_xjt"));
            cbNonAcs10.setChecked(dischargedunacs.contains("cpc_unacs_xj"));
            cbNonAcs11.setChecked(dischargedunacs.contains("cpc_unacs_fc"));
            cbNonAcs12.setChecked(dischargedunacs.contains("cpc_unacs_gxy"));
            cbNonAcs13.setChecked(dischargedunacs.contains("cpc_unacs_xs"));
            cbNonAcs14.setChecked(dischargedunacs.contains("cpc_unacs_fp"));
            cbNonAcs15.setChecked(dischargedunacs.contains("cpc_unacs_sz"));
            cbNonAcs16.setChecked(dischargedunacs.contains("cpc_unacs_fz"));
            cbNonAcs17.setChecked(dischargedunacs.contains("cpc_unacs_sss"));
            cbNonAcs18.setChecked(dischargedunacs.contains("cpc_unacs_xby"));
            cbNonAcs19.setChecked(dischargedunacs.contains("cpc_unacs_xjq"));
            cbNonAcs20.setChecked(dischargedunacs.contains("cpc_unacs_xbjy"));
            cbNonAcs21.setChecked(dischargedunacs.contains("cpc_unacs_zdmgbjxz"));
            cbNonAcs22.setChecked(dischargedunacs.contains("cpc_unacs_tbxdmzyyhxky"));
            cbNonAcs23.setChecked(dischargedunacs.contains("cpc_unacs_zdml"));
            cbNonAcs24.setChecked(dischargedunacs.contains("cpc_unacs_zlxqx"));
        }
    }

    /**
     * 其它非心源性胸痛类型
     *
     * @param bean
     */
    private void setOtherHeartView(PatientOutcomeBean bean) {
        String dischargedotheracs = bean.getDischargedotheracs();
        if (!TextUtils.isEmpty(dischargedotheracs)) {
            cbNonHeart1.setChecked(dischargedotheracs.contains("cpc_otherunacs_hxxtb"));
            cbNonHeart2.setChecked(dischargedotheracs.contains("cpc_otherunacs_xhxtb"));
            cbNonHeart3.setChecked(dischargedotheracs.contains("cpc_otherunacs_sjxtb"));
            cbNonHeart4.setChecked(dischargedotheracs.contains("cpc_otherunacs_jsxtb"));
            cbNonHeart5.setChecked(dischargedotheracs.contains("cpc_otherunacs_jrggb"));
            cbNonHeart6.setChecked(dischargedotheracs.contains("cpc_otherunacs_pfxtb"));
            cbNonHeart7.setChecked(dischargedotheracs.contains("cpc_otherunacs_qt"));
        }
    }

    private void getViewData() {
        if (mOutcomeBean == null) {
            mOutcomeBean = new PatientOutcomeBean();
        }
        mOutcomeBean.setRecordId(mRecordId);
        // 诊断
        String diagnose = esTitleSelect.getText();
        List<String> diagnoseStrings = Arrays.asList(getResources().getStringArray(R.array.confirm_diagnose));
        for (int i = 0; i < diagnoseStrings.size(); i++) {
            if (TextUtils.equals(diagnose, diagnoseStrings.get(i))) {
                mOutcomeBean.setDischargeddiagnosis(mDiagnoseMap.get(diagnose));
            }
        }
        // 确诊时间
        mOutcomeBean.setDischargeddiagnosistime(ttbConfirmTime.getTime());
        if (TextUtils.equals(diagnose, "STEMI")
                || TextUtils.equals(diagnose, "NSTEMI")
                || TextUtils.equals(diagnose, "UA")) {
            if (rgHeartFailure.getCheckedRadioButtonId() == R.id.rb_heart_failure_yes) {
                mOutcomeBean.setIsheartfailureinhospital("cpc_bool_true");
            } else if (rgHeartFailure.getCheckedRadioButtonId() == R.id.rb_heart_failure_no) {
                mOutcomeBean.setIsheartfailureinhospital("cpc_bool_false");
            }
            String checkBoxValue = getCheckBoxValue(cbSetmi1, cbSetmi2, cbSetmi3, cbSetmi4, cbSetmi5,
                    cbSetmi6, cbSetmi7, cbSetmi8, cbSetmi9, cbSetmi10, cbSetmi11, cbSetmi12, cbSetmi13);
            mOutcomeBean.setComplication(checkBoxValue);
        } else if (TextUtils.equals(diagnose, "非ACS心源性胸痛")) {
            String checkBoxValue = getCheckBoxValue(cbNonAcs1, cbNonAcs2, cbNonAcs3, cbNonAcs4, cbNonAcs5,
                    cbNonAcs6, cbNonAcs7, cbNonAcs8, cbNonAcs9, cbNonAcs10, cbNonAcs11, cbNonAcs12, cbNonAcs13
                    , cbNonAcs14, cbNonAcs15, cbNonAcs16, cbNonAcs17, cbNonAcs18, cbNonAcs19, cbNonAcs20
                    , cbNonAcs21, cbNonAcs22, cbNonAcs23, cbNonAcs24);
            mOutcomeBean.setDischargedunacs(checkBoxValue);
        } else if (TextUtils.equals(diagnose, "其它非心源性胸痛")) {
            String checkBoxValue = getCheckBoxValue(cbNonHeart1, cbNonHeart2, cbNonHeart3, cbNonHeart4, cbNonHeart5,
                    cbNonHeart6, cbNonHeart7);
            mOutcomeBean.setDischargedotheracs(checkBoxValue);
        }
        saveViewData();
    }

}
