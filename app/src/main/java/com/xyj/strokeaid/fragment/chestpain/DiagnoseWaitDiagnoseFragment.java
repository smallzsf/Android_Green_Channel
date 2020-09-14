package com.xyj.strokeaid.fragment.chestpain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
 * DiagnoseWaitDiagnoseFragment
 * description: 初始诊断 -- 待查
 *
 * @author : Licy
 * @date : 2020/9/6
 * email ：licy3051@qq.com
 */
public class DiagnoseWaitDiagnoseFragment extends BaseFragment {

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

    public DiagnoseWaitDiagnoseFragment() {
    }


    public static DiagnoseWaitDiagnoseFragment newInstance(String recordId, String diagnose) {
        DiagnoseWaitDiagnoseFragment fragment = new DiagnoseWaitDiagnoseFragment();
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
        return R.layout.fragment_original_diagnose_wait;
    }

    @Override
    protected void initView(@NonNull View view) {

        /**
         * 胸痛 初始诊断查询
         */
        ((OriginalDiagnoseFragment) (DiagnoseWaitDiagnoseFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
        ((OriginalDiagnoseFragment) (DiagnoseWaitDiagnoseFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
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
                    tvPatientStatusRemarkNum.setText(content.length() + "/"+300);
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


        ((OriginalDiagnoseFragment) (DiagnoseWaitDiagnoseFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }

}
