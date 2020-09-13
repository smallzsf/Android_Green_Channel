package com.xyj.strokeaid.fragment.chestpain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
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
public class DiagnoseZdmjcFragment extends BaseFragment {

    @BindView(R.id.give_up_cure)
    TextView giveUpCure;
    @BindView(R.id.rb_give_up_yes)
    RadioButton rbGiveUpYes;
    @BindView(R.id.rb_give_up_no)
    RadioButton rbGiveUpNo;
    @BindView(R.id.ttb_first_diagnose_time)
    TextTimeBar ttbFirstDiagnoseTime;
    @BindView(R.id.es_diagnose_doc)
    EditSpinner esDiagnoseDoc;
    @BindView(R.id.rb_jclx_a)
    RadioButton rbJclxA;
    @BindView(R.id.rb_jclx_b)
    RadioButton rbJclxB;
    @BindView(R.id.rg_jclx)
    RadioGroup rgJclx;
    @BindView(R.id.ll_jclx)
    LinearLayout llJclx;
    @BindView(R.id.rb_treat_strategy_1)
    RadioButton rbTreatStrategy1;
    @BindView(R.id.rb_treat_strategy_2)
    RadioButton rbTreatStrategy2;
    @BindView(R.id.rb_treat_strategy_3)
    RadioButton rbTreatStrategy3;
    @BindView(R.id.rb_treat_strategy_4)
    RadioButton rbTreatStrategy4;
    @BindView(R.id.rb_treat_strategy_5)
    RadioButton rbTreatStrategy5;
    @BindView(R.id.rg_treat_strategy)
    MyRadioGroup rgTreatStrategy;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    private String mDiagnoseType;

    public DiagnoseZdmjcFragment() {
    }

    public static DiagnoseZdmjcFragment newInstance(String recordId, String diagnose) {
        DiagnoseZdmjcFragment fragment = new DiagnoseZdmjcFragment();
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
        return R.layout.fragment_original_diagnose_zdmjc;
    }

    @Override
    protected void initView(@NonNull View view) {

        /**
         * 胸痛 初始诊断查询
         */
        ((OriginalDiagnoseFragment) (DiagnoseZdmjcFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
        ((OriginalDiagnoseFragment) (DiagnoseZdmjcFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
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
            ttbFirstDiagnoseTime.setTime(data.getInitialdiagnostictime());
            //TODO 诊断医生没赋值
            esDiagnoseDoc.setText(esDiagnoseDoc.getText());

            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            if (!TextUtils.isEmpty(data.getZdmjctype())) {
                if (data.getZdmjctype().contains((String) rbJclxA.getTag())) {
                    rbJclxA.setChecked(true);
                } else {
                    rbJclxB.setChecked(true);
                }
            }

             //治疗策略（"cpc_zlcl_B_jjjr": "紧急介入治

            if (!TextUtils.isEmpty(data.getZdmjctreatmentmeasure())) {
                if (data.getZdmjctreatmentmeasure().contains((String) rbTreatStrategy1.getTag())) {
                    rbTreatStrategy1.setChecked(true);
                } else if (data.getZdmjctreatmentmeasure().contains((String) rbTreatStrategy2.getTag())) {
                    rbTreatStrategy2.setChecked(true);
                } else if (data.getZdmjctreatmentmeasure().contains((String) rbTreatStrategy3.getTag())) {
                    rbTreatStrategy3.setChecked(true);
                } else if (data.getZdmjctreatmentmeasure().contains((String) rbTreatStrategy4.getTag())) {
                    rbTreatStrategy4.setChecked(true);
                }else if (data.getZdmjctreatmentmeasure().contains((String) rbTreatStrategy5.getTag())) {
                    rbTreatStrategy5.setChecked(true);
                }
            }
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
        chestPainDiagnosisBean.setInitialdiagnostictime(ttbFirstDiagnoseTime.getTime());
        //TODO 诊断医生没赋值
        chestPainDiagnosisBean.setInitialdiagnosisdoctorid(esDiagnoseDoc.getText());

        if (rbJclxA.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbJclxA.getTag();
            chestPainDiagnosisBean.setZdmjctype(tag);
        }else {
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbJclxB.getTag();
            chestPainDiagnosisBean.setZdmjctype(tag);
        }

        //治疗策略（"cpc_zlcl_B_jjjr": "紧急介入治
        if (rbTreatStrategy1.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbTreatStrategy1.getTag();
            chestPainDiagnosisBean.setZdmjctreatmentmeasure(tag);
        }else if (rbTreatStrategy2.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbTreatStrategy2.getTag();
            chestPainDiagnosisBean.setZdmjctreatmentmeasure(tag);
        }else if (rbTreatStrategy3.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbTreatStrategy3.getTag();
            chestPainDiagnosisBean.setZdmjctreatmentmeasure(tag);
        }else if (rbTreatStrategy4.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbTreatStrategy4.getTag();
            chestPainDiagnosisBean.setZdmjctreatmentmeasure(tag);
        }else if (rbTreatStrategy5.isChecked()){
            // 初步诊断-（主动脉夹层、）-夹层类型 A B
            String tag = (String) rbTreatStrategy5.getTag();
            chestPainDiagnosisBean.setZdmjctreatmentmeasure(tag);
        }


        ((OriginalDiagnoseFragment) (DiagnoseZdmjcFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }
}
