package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;

/**
 * @ClassName: OriginalStatus1
 * @Description: NSTEMI and  UA
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class DiagnoseNstemiAndUaFragment extends BaseFragment {

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
    @BindView(R.id.cb_grace_judge_1)
    CheckBox cbGraceJudge1;
    @BindView(R.id.cb_grace_judge_2)
    CheckBox cbGraceJudge2;
    @BindView(R.id.cb_grace_judge_3)
    CheckBox cbGraceJudge3;
    @BindView(R.id.cb_grace_high_1)
    CheckBox cbGraceHigh1;
    @BindView(R.id.cb_grace_high_2)
    CheckBox cbGraceHigh2;
    @BindView(R.id.cb_grace_high_3)
    CheckBox cbGraceHigh3;
    @BindView(R.id.cb_grace_high_4)
    CheckBox cbGraceHigh4;
    @BindView(R.id.cb_grace_high_5)
    CheckBox cbGraceHigh5;
    @BindView(R.id.cb_grace_high_6)
    CheckBox cbGraceHigh6;
    @BindView(R.id.sb_grace_score)
    SettingBar sbGraceScore;
    @BindView(R.id.rb_re_risk_1)
    RadioButton rbReRisk1;
    @BindView(R.id.rb_re_risk_2)
    RadioButton rbReRisk2;
    @BindView(R.id.rb_re_risk_3)
    RadioButton rbReRisk3;
    @BindView(R.id.rb_re_risk_4)
    RadioButton rbReRisk4;
    @BindView(R.id.rb_re_risk_5)
    RadioButton rbReRisk5;
    @BindView(R.id.rb_re_risk_6)
    RadioButton rbReRisk6;
    @BindView(R.id.rg_re_risk)
    MyRadioGroup rgReRisk;
  /*  @BindView(R.id.rb_treatment_strategy_1)
    RadioButton rbTreatmentStrategy1;
    @BindView(R.id.rb_treatment_strategy_2)
    RadioButton rbTreatmentStrategy2;
    @BindView(R.id.rg_treatment_strategy)
    RadioGroup rgTreatmentStrategy;
    @BindView(R.id.rb_invasive_strategy_1)
    RadioButton rbInvasiveStrategy1;
    @BindView(R.id.rb_invasive_strategy_2)
    RadioButton rbInvasiveStrategy2;
    @BindView(R.id.rb_invasive_strategy_3)
    RadioButton rbInvasiveStrategy3;
    @BindView(R.id.rb_invasive_strategy_4)
    RadioButton rbInvasiveStrategy4;
    @BindView(R.id.rb_invasive_strategy_5)
    RadioButton rbInvasiveStrategy5;
    @BindView(R.id.rg_invasive_strategy)
    MyRadioGroup rgInvasiveStrategy;
    @BindView(R.id.ll_treatment_strategy)
    LinearLayout llTreatmentStrategy;*/
    private String mRecordId;
    private String mDiagnoseType;
    private View view_patien_detour_emergency;

    public DiagnoseNstemiAndUaFragment() {
    }

    public static DiagnoseNstemiAndUaFragment newInstance(String recordId, String diagnose) {
        DiagnoseNstemiAndUaFragment fragment = new DiagnoseNstemiAndUaFragment();
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
        return R.layout.fragment_original_diagnose_nstemi_and_ua;
    }

    @Override
    protected void initView(@NonNull View view) {
        view_patien_detour_emergency = view.findViewById(R.id.ll_patien_detour_emergency);
    }

    @Override
    protected void initListener() {
        rgDetourEmergent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_detour_emergent_yes:
                        view_patien_detour_emergency.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_detour_emergent_no:
                        view_patien_detour_emergency.setVisibility(View.GONE);
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
}
