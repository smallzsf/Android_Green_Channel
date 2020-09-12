package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
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
    @BindView(R.id.ll_detour_emergent)
    LinearLayout llDetourEmergent;
    @BindView(R.id.rb_arrival_cath_lab)
    RadioButton rbArrivalCathLab;
    @BindView(R.id.rb_cardiology_ward)
    RadioButton rbCardiologyWard;
    @BindView(R.id.rb_arrival_cuu)
    RadioButton rbArrivalCuu;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.rg_my_nonstop_office)
    MyRadioGroup rgMyNonstopOffice;
    @BindView(R.id.tv_arrival_time)
    TextTimeBar tvArrivalTime;
    @BindView(R.id.ttb_arrive_emergency_time)
    TextTimeBar ttbArriveEmergencyTime;
    @BindView(R.id.ttb_leave_emergency_time)
    TextTimeBar ttbLeaveEmergencyTime;
    @BindView(R.id.es_person_go_where)
    EditSpinner esPersonGoWhere;
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
    @BindView(R.id.detour_ccu)
    LinearLayout detourCcu;
    @BindView(R.id.tv_arrival_cuu_time)
    TextTimeBar tvArrivalCuuTime;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    private String mDiagnoseType;
    private View view_patien_detour_emergency;
    private View view_patien_detour_emergency_no;

    private boolean isGetData = false;

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
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter && !isGetData) {
            isGetData = true;
            //   这里可以做网络请求
            /**
             * 胸痛--初始诊断--患者绕行--查询
             */
            ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).getChestPainDiagnosePatientsDetour(mRecordId);
            ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).setOnGetChestPainResponsePatientsDetourData(new OriginalDiagnoseFragment.OnGetChestPainResponsePatientsDetourData() {
                @Override
                public void getChestPainResponsePatientsDetourData(ChestPainPatientsDetourBena.ChestPainResponsePatientsDetourBean data) {

                    getPatientsDetourData(data);

                }
            });


            /**
             * 胸痛 初始诊断查询
             */
            ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).getChestPainDiagnoseGet(mRecordId);
            ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).setOnGetChestPainDiagnoseData(new OriginalDiagnoseFragment.OnGetChestPainDiagnoseData() {
                @Override
                public void getChestPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data) {
                    getPainDiagnoseData(data);
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
        view_patien_detour_emergency_no = view.findViewById(R.id.ll_patien_detour_emergency_no);
        esPersonGoWhere.setStringArrayId(R.array.chest_pain_diagnose_patients_detour);



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


    @OnClick({R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                /**
                 * 保存胸痛患者绕行--编辑
                 */
                saveChestPainPatientsDetour();
                /**
                 * 保存胸痛--初始诊断--Grace
                 */
                //   saveChestPainDiagnoseGrace();

                /**
                 * 胸痛 初始诊断保存
                 */
                saveChestPainDiagnosis();


                break;
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

                if (data.getKillliplevel().equals("")) {
                    rbHeartFuncLevel1.setChecked(false);
                    rbHeartFuncLevel2.setChecked(false);
                    rbHeartFuncLevel3.setChecked(false);
                    rbHeartFuncLevel4.setChecked(false);
                }
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

        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnosis(chestPainDiagnosisBean);
    }

    private void saveChestPainDiagnoseGrace() {
        ChestpainGraceScoreBean chestpainGraceScoreBean = new ChestpainGraceScoreBean();
        chestpainGraceScoreBean.setId("");
        chestpainGraceScoreBean.setRecordId(mRecordId);
        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnoseGrace(chestpainGraceScoreBean);

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

        ((OriginalDiagnoseFragment) (DiagnoseStemiFragment.this.getParentFragment())).saveChestPainDiagnosePatientsDetour(chestPainPatientsDetourBena);
    }
}
