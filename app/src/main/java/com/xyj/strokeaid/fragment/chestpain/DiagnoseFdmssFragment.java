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
 * @Description: 肺动脉塞栓
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class DiagnoseFdmssFragment extends BaseFragment {

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
    @BindView(R.id.rb_heart_func_level_1)
    RadioButton rbHeartFuncLevel1;
    @BindView(R.id.rb_heart_func_level_2)
    RadioButton rbHeartFuncLevel2;
    @BindView(R.id.rb_heart_func_level_3)
    RadioButton rbHeartFuncLevel3;
    @BindView(R.id.rb_heart_func_level_4)
    RadioButton rbHeartFuncLevel4;
    @BindView(R.id.rg_heart_func)
    RadioGroup rgHeartFunc;
    @BindView(R.id.rb_detour_emergent_yes)
    RadioButton rbDetourEmergentYes;
    @BindView(R.id.rb_detour_emergent_no)
    RadioButton rbDetourEmergentNo;
    @BindView(R.id.rg_detour_emergent)
    RadioGroup rgDetourEmergent;
    @BindView(R.id.rb_arrival_cath_lab)
    RadioButton rbArrivalCathLab;
    @BindView(R.id.rb_cardiology_ward)
    RadioButton rbCardiologyWard;
    @BindView(R.id.rb_arrival_cuu)
    RadioButton rbArrivalCuu;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.tv_arrival_time)
    TextTimeBar tvArrivalTime;
    @BindView(R.id.es_detour_emergent_name)
    EditSpinner esDetourEmergentName;
    @BindView(R.id.ttb_arrive_time)
    TextTimeBar ttbArriveTime;
    @BindView(R.id.ll_detour_emergent_yes)
    LinearLayout llDetourEmergentYes;
    @BindView(R.id.ttb_arrive_emergent_time)
    TextTimeBar ttbArriveEmergentTime;
    @BindView(R.id.ttb_leave_emergent_time)
    TextTimeBar ttbLeaveEmergentTime;
    @BindView(R.id.es_emergent_leave_to)
    EditSpinner esEmergentLeaveTo;
    @BindView(R.id.ll_detour_emergent_no)
    LinearLayout llDetourEmergentNo;
    @BindView(R.id.rb_detour_ccu_yes)
    RadioButton rbDetourCcuYes;
    @BindView(R.id.rb_detour_ccu_no)
    RadioButton rbDetourCcuNo;
    @BindView(R.id.rg_detour_ccu)
    RadioGroup rgDetourCcu;
    @BindView(R.id.tv_arrival_cuu_time)
    TextTimeBar tvArrivalCuuTime;
    @BindView(R.id.ll_detour_emergent)
    LinearLayout llDetourEmergent;
    @BindView(R.id.detour_ccu)
    LinearLayout detourCcu;
    @BindView(R.id.rg_my_nonstop_office)
    MyRadioGroup rgMyNonstopOffice;
    @BindView(R.id.ttb_arrive_emergency_time)
    TextTimeBar ttbArriveEmergencyTime;
    @BindView(R.id.ttb_leave_emergency_time)
    TextTimeBar ttbLeaveEmergencyTime;
    @BindView(R.id.es_person_go_where)
    EditSpinner esPersonGoWhere;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    private String mRecordId;
    private String mDiagnoseType;
    private View view_patien_detour_emergency;

    public DiagnoseFdmssFragment() {
    }

    public static DiagnoseFdmssFragment newInstance(String recordId, String diagnose) {
        DiagnoseFdmssFragment fragment = new DiagnoseFdmssFragment();
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
        return R.layout.fragment_original_diagnose_stemi;
    }

    @Override
    protected void initView(@NonNull View view) {
        view_patien_detour_emergency = view.findViewById(R.id.ll_patien_detour_emergency);
        llDetourEmergent.setVisibility(View.GONE);
        detourCcu.setVisibility(View.GONE);

        /**
         * 胸痛 初始诊断查询
         */
        ((OriginalDiagnoseFragment) (DiagnoseFdmssFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
        ((OriginalDiagnoseFragment) (DiagnoseFdmssFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
            @Override
            public void getChestPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
                getPainDiagnoseData(data);
            }

        });


    }

    @Override
    protected void initListener() {

    }

    @OnClick(R.id.btn_save)
    public void onViewClicked() {

        /**
         * 胸痛 初始诊断保存
         */
        saveChestPainDiagnosis();

    }


    /**
     * 胸痛 初始诊断查询
     */
    private void getPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
        if (data != null) {

            EditSpinner esTitleSelect = ((OriginalDiagnoseFragment) (DiagnoseFdmssFragment.this.getParentFragment())).getView().findViewById(R.id.es_title_select);
            String initialdiagnosis = data.getInitialdiagnosis();
            esTitleSelect.setStringArrayNormalKey(initialdiagnosis);
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
            if (!TextUtils.isEmpty(data.getKillliplevel())) {
                if (data.getKillliplevel().equals((String) rbHeartFuncLevel1.getTag())) {
                    rbHeartFuncLevel1.setChecked(true);
                }
                if (data.getKillliplevel().equals((String) rbHeartFuncLevel2.getTag())) {
                    rbHeartFuncLevel2.setChecked(true);
                }
                if (data.getKillliplevel().equals((String) rbHeartFuncLevel3.getTag())) {
                    rbHeartFuncLevel3.setChecked(true);
                }

                if (data.getKillliplevel().equals((String) rbHeartFuncLevel4.getTag())) {
                    rbHeartFuncLevel4.setChecked(true);
                }


            }else {
                rbHeartFuncLevel1.setChecked(false);
                rbHeartFuncLevel2.setChecked(false);
                rbHeartFuncLevel3.setChecked(false);
                rbHeartFuncLevel4.setChecked(false);
            }
        }

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
        //心功能分级
        if (rbHeartFuncLevel1.isChecked()) {
            String tag = (String) rbHeartFuncLevel1.getTag();
            chestPainDiagnosisBean.setKillliplevel(tag);
        } else if (rbHeartFuncLevel2.isChecked()) {
            String tag = (String) rbHeartFuncLevel2.getTag();
            chestPainDiagnosisBean.setKillliplevel(tag);
        } else if (rbHeartFuncLevel3.isChecked()) {
            String tag = (String) rbHeartFuncLevel3.getTag();
            chestPainDiagnosisBean.setKillliplevel(tag);
        } else {
            String tag = (String) rbHeartFuncLevel4.getTag();
            chestPainDiagnosisBean.setKillliplevel(tag);
        }

        ((OriginalDiagnoseFragment) (DiagnoseFdmssFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }


}
