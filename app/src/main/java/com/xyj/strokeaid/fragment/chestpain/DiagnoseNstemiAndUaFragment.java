package com.xyj.strokeaid.fragment.chestpain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBena;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

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
    @BindView(R.id.ll_detour_emergent)
    LinearLayout llDetourEmergent;
    @BindView(R.id.rg_my_nonstop_office)
    MyRadioGroup rgMyNonstopOffice;
    @BindView(R.id.ttb_arrive_emergency_time)
    TextTimeBar ttbArriveEmergencyTime;
    @BindView(R.id.ttb_leave_emergency_time)
    TextTimeBar ttbLeaveEmergencyTime;
    @BindView(R.id.es_person_go_where)
    EditSpinner esPersonGoWhere;
    @BindView(R.id.detour_ccu)
    LinearLayout detourCcu;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rb_sky_high_danger)
    RadioButton rbSkyHighDanger;
    @BindView(R.id.rb_high_danger)
    RadioButton rbHighDanger;
    @BindView(R.id.rb_center_danger)
    RadioButton rbCenterDanger;
    @BindView(R.id.rb_low_danger)
    RadioButton rbLowDanger;
    @BindView(R.id.ll_fdmss)
    LinearLayout llFdmss;
    @BindView(R.id.mrg)
    MyRadioGroup mrg;
    @BindView(R.id.ttb_re_risk_time)
    TextTimeBar ttbReRiskTime;
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

    private boolean isGetData = false;

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
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter && !isGetData) {
            isGetData = true;
            //   这里可以做网络请求或者需要的数据刷新操作

            /**
             * 胸痛--初始诊断--患者绕行--查询
             */
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).getChestPainDiagnosePatientsDetour(mRecordId);
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).setOnGetChestPainResponsePatientsDetourData(new OriginalDiagnoseFragment.OnGetChestPainResponsePatientsDetourData() {
                @Override
                public void getChestPainResponsePatientsDetourData(ChestPainPatientsDetourBena.ChestPainResponsePatientsDetourBean data) {

                    getPatientsDetourData(data);

                }
            });


            /**
             * 胸痛 初始诊断查询
             */
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
                @Override
                public void getChestPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
                    getPainDiagnoseData(data);
                }

            });


            /**
             * 胸痛--初始诊断--Grace--获取
             */
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).getChestPainDiagnoseGrace(mRecordId);
            ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).setOnGetChestPainDiagnoseGraceData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseGraceData() {
                @Override
                public void getChestPainDiagnoseGraceData(ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean data) {
                    getPainDiagnoseGraceData(data);
                }


            });
        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
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

    @OnClick(R.id.btn_save)
    public void onViewClicked() {
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
    }


    /**
     * 胸痛--初始诊断--Grace--获取
     */
    private void getPainDiagnoseGraceData(ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean data) {
        if (data != null) {
            String graceassess = data.getGraceassess();
            if (!TextUtils.isEmpty(graceassess)) {
                cbGraceJudge1.setChecked(graceassess.contains("cpc_graceassess_fbh"));
                cbGraceJudge2.setChecked(graceassess.contains("cpc_graceassess_xdtst"));
                cbGraceJudge3.setChecked(graceassess.contains("cpc_graceassess_xjhs"));

            }

            String gracehighriskcondition = data.getGracehighriskcondition();
            if (!TextUtils.isEmpty(gracehighriskcondition)) {
                cbGraceHigh1.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_jsxlsj"));
                cbGraceHigh2.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_wjsm"));
                cbGraceHigh3.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_xyxxk"));
                cbGraceHigh4.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_xjgs"));
                cbGraceHigh5.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_zfst"));
                cbGraceHigh6.setChecked(gracehighriskcondition.contains("cpc_gracehighriskcondition_ywzlwx"));

            }


            //危险分层

            if (!TextUtils.isEmpty(data.getGracerisklevel())) {
                if (data.getGracerisklevel().contains((String) rbSkyHighDanger.getTag())) {
                    rbSkyHighDanger.setChecked(true);
                } else if (data.getGracerisklevel().contains((String) rbHighDanger.getTag())) {
                    rbHighDanger.setChecked(true);
                } else if (data.getGracerisklevel().contains((String) rbCenterDanger.getTag())) {
                    rbCenterDanger.setChecked(true);
                } else if (data.getGracerisklevel().contains((String) rbLowDanger.getTag())) {
                    rbLowDanger.setChecked(true);
                }
            }

            //再次危险分层
            if (!TextUtils.isEmpty(data.getRegracerisklevel())) {
                if (data.getRegracerisklevel().contains((String) rbReRisk1.getTag())) {
                    rbReRisk1.setChecked(true);
                } else if (data.getRegracerisklevel().contains((String) rbReRisk2.getTag())) {
                    rbReRisk2.setChecked(true);
                } else if (data.getRegracerisklevel().contains((String) rbReRisk3.getTag())) {
                    rbReRisk3.setChecked(true);
                } else if (data.getRegracerisklevel().contains((String) rbReRisk4.getTag())) {
                    rbReRisk4.setChecked(true);
                } else if (data.getRegracerisklevel().contains((String) rbReRisk5.getTag())) {
                    rbReRisk5.setChecked(true);
                } else if (data.getRegracerisklevel().contains((String) rbReRisk6.getTag())) {
                    rbReRisk6.setChecked(true);
                }


            }
            //再次危险分层时间
            ttbReRiskTime.setTime(data.getRegraceriskleveltime());


        }
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
     * 胸痛--初始诊断--患者绕行--查询数据
     */
    private void getPatientsDetourData(ChestPainPatientsDetourBena.ChestPainResponsePatientsDetourBean data) {
        if (data != null) {

            if (!TextUtils.isEmpty(data.getIsskiper())) {
                if (data.getIsskiper().contains(Constants.BOOL_TRUE)) {
                    rbDetourEmergentYes.setChecked(true);
                } else {
                    rbDetourEmergentNo.setChecked(true);
                }
            }
            ttbArriveEmergencyTime.setTime(data.getArrivedertime());
            ttbLeaveEmergencyTime.setTime(data.getLeaveertime());
            ttbArriveEmergencyTime.setTime(data.getArrivedertime());
            String text = data.getPatientwhereabouts();
            esPersonGoWhere.setStringArrayNormalKey(text);

            if (!TextUtils.isEmpty(data.getThroughdepartment())) {
                if (data.getThroughdepartment().contains((String) rbArrivalCathLab.getTag())) {
                    rbArrivalCathLab.setChecked(true);
                } else if (data.getThroughdepartment().contains((String) rbCardiologyWard.getTag())) {
                    rbCardiologyWard.setChecked(true);
                } else if (data.getThroughdepartment().contains((String) rbArrivalCuu.getTag())) {
                    rbArrivalCuu.setChecked(true);
                } else if (data.getThroughdepartment().contains((String) rbOther.getTag())) {
                    rbOther.setChecked(true);
                }
            }

            tvArrivalTime.setTime(data.getArriveddepartmenttime());

            if (!TextUtils.isEmpty(data.getIsskipccu())) {
                if (data.getIsskipccu().contains(Constants.BOOL_TRUE)) {
                    rbDetourCcuYes.setChecked(true);
                } else {
                    rbDetourCcuNo.setChecked(true);
                }
            }

            tvArrivalCuuTime.setTime(data.getArrivedccutime());
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

        LogUtils.d(chestPainDiagnosisBean.toString());
        ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }


    /**
     * 保存胸痛--初始诊断--Grace
     */
    private void saveChestPainDiagnoseGrace() {
        ChestpainGraceScoreBean chestpainGraceScoreBean = new ChestpainGraceScoreBean();
        chestpainGraceScoreBean.setId("");
        chestpainGraceScoreBean.setRecordId(mRecordId);
        String checkBoxGraceJudgeValue = getCheckBoxValue(cbGraceJudge1, cbGraceJudge2, cbGraceJudge3);
        chestpainGraceScoreBean.setGraceassess(checkBoxGraceJudgeValue);
        String checkBoxGraceHighgeValue = getCheckBoxValue(cbGraceHigh1, cbGraceHigh2, cbGraceHigh3, cbGraceHigh4, cbGraceHigh5, cbGraceHigh6);
        chestpainGraceScoreBean.setGracehighriskcondition(checkBoxGraceHighgeValue);
        //危险分层
        if (rbSkyHighDanger.isChecked()) {
            String tag = (String) rbSkyHighDanger.getTag();
            chestpainGraceScoreBean.setGracerisklevel(tag);
        } else if (rbHighDanger.isChecked()) {
            String tag = (String) rbHighDanger.getTag();
            chestpainGraceScoreBean.setGracerisklevel(tag);
        } else if (rbCenterDanger.isChecked()) {
            String tag = (String) rbCenterDanger.getTag();
            chestpainGraceScoreBean.setGracerisklevel(tag);
        } else {
            String tag = (String) rbLowDanger.getTag();
            chestpainGraceScoreBean.setGracerisklevel(tag);
        }
        //再次危险分层
        if (rbReRisk1.isChecked()) {
            String tag = (String) rbReRisk1.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        } else if (rbReRisk2.isChecked()) {
            String tag = (String) rbReRisk2.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        } else if (rbReRisk3.isChecked()) {
            String tag = (String) rbReRisk3.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        } else if ((rbReRisk4.isChecked())) {
            String tag = (String) rbReRisk4.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        } else if ((rbReRisk5.isChecked())) {
            String tag = (String) rbReRisk5.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        } else if ((rbReRisk6.isChecked())) {
            String tag = (String) rbReRisk6.getTag();
            chestpainGraceScoreBean.setRegracerisklevel(tag);
        }

        chestpainGraceScoreBean.setRegraceriskleveltime(ttbReRiskTime.getTime());
        ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).saveChestPainDiagnoseGrace(chestpainGraceScoreBean);

    }


    /**
     * 保存胸痛患者绕行--编辑
     */
    private void saveChestPainPatientsDetour() {
        ChestPainPatientsDetourBena chestPainPatientsDetourBena = new ChestPainPatientsDetourBena();
        chestPainPatientsDetourBena.setRecordId(mRecordId);
        if (rgDetourEmergent.getCheckedRadioButtonId() == R.id.rb_detour_emergent_yes) {
            chestPainPatientsDetourBena.setIsskiper(Constants.BOOL_TRUE);
        } else {
            chestPainPatientsDetourBena.setIsskiper(Constants.BOOL_FALSE);
        }
        //no
        chestPainPatientsDetourBena.setArrivedertime(ttbArriveEmergencyTime.getTime());
        chestPainPatientsDetourBena.setLeaveertime(ttbLeaveEmergencyTime.getTime());
        String[] selectData = esPersonGoWhere.getSelectData();
        chestPainPatientsDetourBena.setPatientwhereabouts(selectData[1]);
        //yes

        if (rbArrivalCathLab.isChecked()) {
            String tag = (String) rbArrivalCathLab.getTag();
            chestPainPatientsDetourBena.setThroughdepartment(tag);
        } else if (rbCardiologyWard.isChecked()) {
            String tag = (String) rbCardiologyWard.getTag();
            chestPainPatientsDetourBena.setThroughdepartment(tag);
        } else if (rbArrivalCuu.isChecked()) {
            String tag = (String) rbArrivalCuu.getTag();
            chestPainPatientsDetourBena.setThroughdepartment(tag);
        } else {
            String tag = (String) rbOther.getTag();
            chestPainPatientsDetourBena.setThroughdepartment(tag);
        }


        chestPainPatientsDetourBena.setArriveddepartmenttime(tvArrivalTime.getTime());

        if (rgDetourCcu.getCheckedRadioButtonId() == R.id.rb_detour_ccu_yes) {
            chestPainPatientsDetourBena.setIsskipccu(Constants.BOOL_TRUE);
        } else {
            chestPainPatientsDetourBena.setIsskipccu(Constants.BOOL_FALSE);
        }
        chestPainPatientsDetourBena.setArrivedccutime(tvArrivalCuuTime.getTime());

        ((OriginalDiagnoseFragment) (DiagnoseNstemiAndUaFragment.this.getParentFragment())).saveChestPainDiagnosePatientsDetour(chestPainPatientsDetourBena);
    }


}
