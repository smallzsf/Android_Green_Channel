package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBena;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ClassName: OriginalStatus1
 * @Description: STEMI
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class DiagnoseStemiFragment extends BaseFragment {

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
    @BindView(R.id.tv_arrival_cuu_time)
    TextTimeBar tvArrivalCuuTime;
    @BindView(R.id.ll_detour_emergent)
    LinearLayout llDetourEmergent;
    @BindView(R.id.detour_ccu)
    LinearLayout detourCcu;
    @BindView(R.id.rb_low_danger)
    RadioButton rbLowDanger;
    @BindView(R.id.rb_center_danger)
    RadioButton rbCenterDanger;
    @BindView(R.id.rb_high_danger)
    RadioButton rbHighDanger;
    @BindView(R.id.mrg)
    MyRadioGroup mrg;
    @BindView(R.id.rb_suitable)
    RadioButton rbSuitable;
    @BindView(R.id.rb_unsuitable)
    RadioButton rbUnsuitable;
    @BindView(R.id.rb_no_screening)
    RadioButton rbNoScreening;
    @BindView(R.id.mrg1)
    MyRadioGroup mrg1;
    @BindView(R.id.rb_hava)
    RadioButton rbHava;
    @BindView(R.id.rb_no)
    RadioButton rbNo;
    @BindView(R.id.mrg2)
    MyRadioGroup mrg2;
    @BindView(R.id.ll_fdmss)
    LinearLayout llFdmss;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    private String mDiagnoseType;
    private View view_patien_detour_emergency;
    private View view_patien_detour_emergency_no;


    public DiagnoseStemiFragment() {
    }

    public static DiagnoseStemiFragment newInstance(String recordId, String diagnose) {
        DiagnoseStemiFragment fragment = new DiagnoseStemiFragment();
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
        ToastUtils.showShort(mRecordId);
        view_patien_detour_emergency = view.findViewById(R.id.ll_patien_detour_emergency);
        view_patien_detour_emergency_no = view.findViewById(R.id.ll_patien_detour_emergency_no);
    }

    @Override
    protected void initListener() {
        rgDetourEmergent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_detour_emergent_yes:
                        view_patien_detour_emergency.setVisibility(View.VISIBLE);
                        view_patien_detour_emergency_no.setVisibility(View.GONE);
                        break;
                    case R.id.rb_detour_emergent_no:
                        view_patien_detour_emergency.setVisibility(View.GONE);
                        view_patien_detour_emergency_no.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        rgDetourCcu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_detour_ccu_yes:
                        tvArrivalCuuTime.setVisibility(View.GONE);
                        break;
                    case R.id.rb_detour_ccu_no:
                        tvArrivalCuuTime.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });


    }


    @OnClick({R.id.rb_no_screening, R.id.mrg1, R.id.rb_hava, R.id.rb_no, R.id.mrg2, R.id.ll_fdmss, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_no_screening:

                break;
            case R.id.mrg1:

                break;
            case R.id.rb_hava:

                break;
            case R.id.rb_no:

                break;
            case R.id.mrg2:

                break;
            case R.id.ll_fdmss:

                break;
            case R.id.btn_save:
                /**
                 * 保存胸痛患者绕行--编辑
                 */
                saveChestPainPatientsDetour();

                /**
                 * 保存胸痛--初始诊断--Grace
                 */
                saveChestPainDiagnoseGrace();

                /**
                 * 胸痛 初始诊断保存
                 */
                saveChestPainDiagnosis();


                break;
        }
    }

    private void saveChestPainDiagnosis() {
        ChestPainDiagnosisBean chestPainDiagnosisBean =new ChestPainDiagnosisBean();
        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }

    private void saveChestPainDiagnoseGrace() {
        ChestpainGraceScoreBean chestpainGraceScoreBean = new ChestpainGraceScoreBean();
        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnoseGrace(chestpainGraceScoreBean);

    }

    private void saveChestPainPatientsDetour() {
        ChestPainPatientsDetourBena chestPainPatientsDetourBena = new ChestPainPatientsDetourBena();
        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnosePatientsDetour(chestPainPatientsDetourBena);
    }
}
