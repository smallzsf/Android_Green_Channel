package com.xyj.strokeaid.fragment.chestpain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class DiagnoseNonAcsFragment extends BaseFragment {

    @BindView(R.id.give_up_cure)
    TextView giveUpCure;
    @BindView(R.id.rb_give_up_yes)
    RadioButton rbGiveUpYes;
    @BindView(R.id.rb_give_up_no)
    RadioButton rbGiveUpNo;
    @BindView(R.id.ttb_diagnose_time)
    TextTimeBar ttbDiagnoseTime;
    @BindView(R.id.es_diagnose_doc)
    EditSpinner esDiagnoseDoc;
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
    @BindView(R.id.rb_treat_strategy_1)
    RadioButton rbTreatStrategy1;
    @BindView(R.id.rb_treat_strategy_2)
    RadioButton rbTreatStrategy2;
    @BindView(R.id.rb_treat_strategy_3)
    RadioButton rbTreatStrategy3;
    @BindView(R.id.rb_treat_strategy_4)
    RadioButton rbTreatStrategy4;
    @BindView(R.id.rg_treatment_measure)
    MyRadioGroup rgTreatmentMeasure;
    @BindView(R.id.et_patient_status_remark)
    EditText etPatientStatusRemark;
    @BindView(R.id.tv_patient_status_remark_num)
    TextView tvPatientStatusRemarkNum;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    private String mDiagnoseType;

    public DiagnoseNonAcsFragment() {
    }


    public static DiagnoseNonAcsFragment newInstance(String recordId, String diagnose) {
        DiagnoseNonAcsFragment fragment = new DiagnoseNonAcsFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        args.putString(IntentKey.DIAGNOSE_TYPE, diagnose);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
            mDiagnoseType = getArguments().getString(IntentKey.DIAGNOSE_TYPE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_diagnose_non_acs;
    }

    @Override
    protected void initView(@NonNull View view) {

        /**
         * 胸痛 初始诊断查询
         */
        ((OriginalDiagnoseFragment) (DiagnoseNonAcsFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
        ((OriginalDiagnoseFragment) (DiagnoseNonAcsFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
            @Override
            public void getChestPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
                getPainDiagnoseData(data);
            }

        });
    }

    @Override
    protected void initListener() {

    }

    /**
     * 胸痛 初始诊断查询
     */
    private void getPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
        if (data != null) {

            if (!TextUtils.isEmpty(data.getGiveuptreatment())) {
                if (data.getGiveuptreatment().contains(Constants.BOOL_TRUE)) {
                    rbGiveUpYes.setChecked(true);
                } else {
                    rbGiveUpNo.setChecked(true);
                }
            }
            ttbDiagnoseTime.setTime(data.getInitialdiagnostictime());
            //TODO 诊断医生没赋值
            esDiagnoseDoc.setText(esDiagnoseDoc.getText());


            if (!TextUtils.isEmpty(data.getDiagnosisunacs())) {
                cbNonAcs1.setChecked(data.getDiagnosisunacs().contains(cbNonAcs1.getTag().toString()));
                cbNonAcs2.setChecked(data.getDiagnosisunacs().contains(cbNonAcs2.getTag().toString()));
                cbNonAcs3.setChecked(data.getDiagnosisunacs().contains(cbNonAcs3.getTag().toString()));
                cbNonAcs4.setChecked(data.getDiagnosisunacs().contains(cbNonAcs4.getTag().toString()));
                cbNonAcs5.setChecked(data.getDiagnosisunacs().contains(cbNonAcs5.getTag().toString()));
                cbNonAcs6.setChecked(data.getDiagnosisunacs().contains(cbNonAcs6.getTag().toString()));
                cbNonAcs7.setChecked(data.getDiagnosisunacs().contains(cbNonAcs7.getTag().toString()));
                cbNonAcs8.setChecked(data.getDiagnosisunacs().contains(cbNonAcs8.getTag().toString()));
                cbNonAcs9.setChecked(data.getDiagnosisunacs().contains(cbNonAcs9.getTag().toString()));
                cbNonAcs10.setChecked(data.getDiagnosisunacs().contains(cbNonAcs10.getTag().toString()));
                cbNonAcs11.setChecked(data.getDiagnosisunacs().contains(cbNonAcs11.getTag().toString()));
                cbNonAcs12.setChecked(data.getDiagnosisunacs().contains(cbNonAcs12.getTag().toString()));
                cbNonAcs13.setChecked(data.getDiagnosisunacs().contains(cbNonAcs13.getTag().toString()));
                cbNonAcs14.setChecked(data.getDiagnosisunacs().contains(cbNonAcs14.getTag().toString()));
                cbNonAcs15.setChecked(data.getDiagnosisunacs().contains(cbNonAcs15.getTag().toString()));
                cbNonAcs16.setChecked(data.getDiagnosisunacs().contains(cbNonAcs16.getTag().toString()));
                cbNonAcs17.setChecked(data.getDiagnosisunacs().contains(cbNonAcs17.getTag().toString()));
                cbNonAcs18.setChecked(data.getDiagnosisunacs().contains(cbNonAcs18.getTag().toString()));
                cbNonAcs19.setChecked(data.getDiagnosisunacs().contains(cbNonAcs19.getTag().toString()));
                cbNonAcs20.setChecked(data.getDiagnosisunacs().contains(cbNonAcs20.getTag().toString()));
                cbNonAcs21.setChecked(data.getDiagnosisunacs().contains(cbNonAcs21.getTag().toString()));
                cbNonAcs22.setChecked(data.getDiagnosisunacs().contains(cbNonAcs22.getTag().toString()));
                cbNonAcs23.setChecked(data.getDiagnosisunacs().contains(cbNonAcs23.getTag().toString()));
                cbNonAcs24.setChecked(data.getDiagnosisunacs().contains(cbNonAcs24.getTag().toString()));
            }

            if (!TextUtils.isEmpty(data.getNacstreatmenttype())) {
                rbTreatStrategy1.setChecked(data.getNacstreatmenttype().contains(rbTreatStrategy1.getTag().toString()));
                rbTreatStrategy2.setChecked(data.getNacstreatmenttype().contains(rbTreatStrategy2.getTag().toString()));
                rbTreatStrategy3.setChecked(data.getNacstreatmenttype().contains(rbTreatStrategy3.getTag().toString()));
                rbTreatStrategy4.setChecked(data.getNacstreatmenttype().contains(rbTreatStrategy4.getTag().toString()));

            }


            etPatientStatusRemark.setText(data.getPatientremarkdiagnosed());
            etPatientStatusRemark.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {
                    String content = etPatientStatusRemark.getText().toString();
                    tvPatientStatusRemarkNum.setText(content.length() + "/" + 300);
                }
            });
        }

    }

    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        /**
         * 胸痛 初始诊断保存
         */
        saveChestPainDiagnosis();

    }


    /**
     * 胸痛 初始诊断保存
     */
    private void saveChestPainDiagnosis() {
        ChestPainDiagnosisBean chestPainDiagnosisBean = new ChestPainDiagnosisBean();
        //id
        chestPainDiagnosisBean.setId("");
        chestPainDiagnosisBean.setRecordId(mRecordId);
        //	initialdiagnosis	初步诊断("cpc_cbzdv2_stemi": "STEM
        chestPainDiagnosisBean.setInitialdiagnosis(mDiagnoseType);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("initialdiagnosis",mDiagnoseType);
        editor.commit();
        if (rbGiveUpYes.isChecked()) {
            chestPainDiagnosisBean.setGiveuptreatment(Constants.BOOL_TRUE);
        } else {
            chestPainDiagnosisBean.setGiveuptreatment(Constants.BOOL_FALSE);
        }
        chestPainDiagnosisBean.setInitialdiagnostictime(ttbDiagnoseTime.getTime());
        //TODO 诊断医生没赋值
        chestPainDiagnosisBean.setInitialdiagnosisdoctorid(esDiagnoseDoc.getText());

        String checkBoxNonAcsValue = getCheckBoxValue(cbNonAcs1, cbNonAcs2, cbNonAcs3, cbNonAcs4, cbNonAcs5, cbNonAcs6, cbNonAcs7, cbNonAcs8, cbNonAcs9, cbNonAcs10, cbNonAcs11, cbNonAcs12, cbNonAcs13, cbNonAcs14, cbNonAcs15, cbNonAcs16, cbNonAcs17, cbNonAcs18, cbNonAcs19, cbNonAcs20, cbNonAcs21, cbNonAcs22, cbNonAcs23, cbNonAcs24);
        chestPainDiagnosisBean.setDiagnosisunacs(checkBoxNonAcsValue);

        if (rbTreatStrategy1.isChecked()) {
            String tag = (String) rbTreatStrategy1.getTag();
            chestPainDiagnosisBean.setNacstreatmenttype(tag);
        } else if (rbTreatStrategy2.isChecked()) {
            String tag = (String) rbTreatStrategy2.getTag();
            chestPainDiagnosisBean.setNacstreatmenttype(tag);
        } else if (rbTreatStrategy3.isChecked()) {
            String tag = (String) rbTreatStrategy3.getTag();
            chestPainDiagnosisBean.setNacstreatmenttype(tag);
        } else if (rbTreatStrategy4.isChecked()) {
            String tag = (String) rbTreatStrategy4.getTag();
            chestPainDiagnosisBean.setNacstreatmenttype(tag);
        }


        chestPainDiagnosisBean.setPatientremarkdiagnosed(etPatientStatusRemark.getText().toString().trim());


        ((OriginalDiagnoseFragment) (DiagnoseNonAcsFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }


}
