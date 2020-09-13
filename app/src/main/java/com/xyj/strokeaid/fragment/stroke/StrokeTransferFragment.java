package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * TransferFragment
 * description: 转归交接
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeTransferFragment extends BaseStrokeFragment {


    /* @BindView(R.id.es_diagnose_detail_result)
     EditSpinner esDiagnoseDetailResult;
     @BindView(R.id.ll_diagnose_detail_result)
     LinearLayout llDiagnoseDetailResult;*/
    @BindView(R.id.rb_patient_out_treating)
    RadioButton rbPatientOutTreating;
    @BindView(R.id.rb_patient_out_leave)
    RadioButton rbPatientOutLeave;
    @BindView(R.id.rb_patient_out_transfer)
    RadioButton rbPatientOutTransfer;
    @BindView(R.id.rb_patient_out_death)
    RadioButton rbPatientOutDeath;
    @BindView(R.id.rg_patient_out)
    MyRadioGroup rgPatientOut;
    @BindView(R.id.rb_leave_hospital)
    RadioButton rbLeaveHospital;
    @BindView(R.id.rb_transform_hospital)
    RadioButton rbTransformHospital;
    @BindView(R.id.rb_township_health_center)
    RadioButton rbTownshipHealthCenter;
    @BindView(R.id.rb_no_leave_hospital)
    RadioButton rbNoLeaveHospital;
    @BindView(R.id.rb_die)
    RadioButton rbDie;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.rg_departure_hospital)
    RadioGroup rgDepartureHospital;
    @BindView(R.id.rb_treat_result_cure)
    RadioButton rbTreatResultCure;
    @BindView(R.id.rb_treat_result_better)
    RadioButton rbTreatResultBetter;
    @BindView(R.id.rb_treat_result_head_death)
    RadioButton rbTreatResultHeadDeath;
    @BindView(R.id.rb_treat_result_other)
    RadioButton rbTreatResultOther;
    @BindView(R.id.rg_treat_result)
    RadioGroup rgTreatResult;
    @BindView(R.id.cb_cydy_jyy)
    CheckBox cbCydyJyy;
    @BindView(R.id.cb_cydy_jty)
    CheckBox cbCydyJty;
    @BindView(R.id.cb_cydy_tzy)
    CheckBox cbCydyTzy;
    @BindView(R.id.cb_cydy_kny)
    CheckBox cbCydyKny;
    @BindView(R.id.cb_cydy_kxxby)
    CheckBox cbCydyKxxby;
    @BindView(R.id.cb_cydy_zyzl)
    CheckBox cbCydyZyzl;
    @BindView(R.id.cb_cydy_qt)
    CheckBox cbCydyQt;
    @BindView(R.id.cb_cydy_wu)
    CheckBox cbCydyWu;
    @BindView(R.id.sv_leave_hospital)
    LinearLayout svLeaveHospital;
    @BindView(R.id.cb_swyy_hxxhsj)
    CheckBox cbSwyyHxxhsj;
    @BindView(R.id.cb_swyy_nxgb)
    CheckBox cbSwyyNxgb;
    @BindView(R.id.cb_swyy_fbgr)
    CheckBox cbSwyyFbgr;
    @BindView(R.id.cb_swyy_sxhdcx)
    CheckBox cbSwyySxhdcx;
    @BindView(R.id.cb_swyy_jxsgnsj)
    CheckBox cbSwyyJxsgnsj;
    @BindView(R.id.cb_swyy_sshzd)
    CheckBox cbSwyySshzd;
    @BindView(R.id.cb_swyy_qt)
    CheckBox cbSwyyQt;
    @BindView(R.id.cb_swyy_bx)
    CheckBox cbSwyyBx;
    @BindView(R.id.ll_death)
    LinearLayout llDeath;
    @BindView(R.id.es_receiving_department)
    EditSpinner esReceivingDepartment;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.ll_tranfer)
    LinearLayout llTranfer;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.es_diagnosis)
    EditSpinner esDiagnosis;
    @BindView(R.id.ll_diagnosis)
    LinearLayout llDiagnosis;
    @BindView(R.id.et_ischemic_stroke)
    EditSpinner etIschemicStroke;
    @BindView(R.id.et_nosogenesis)
    EditSpinner etNosogenesis;
    @BindView(R.id.ll_ischemic_stroke)
    LinearLayout llIschemicStroke;
    @BindView(R.id.es_hemorrhagic_apoplexy)
    EditSpinner esHemorrhagicApoplexy;
    @BindView(R.id.es_hemorrhagic_apoplexy2)
    EditSpinner esHemorrhagicApoplexy2;
    @BindView(R.id.ll_hemorrhagic_apoplexy)
    LinearLayout llHemorrhagicApoplexy;
    @BindView(R.id.et_input_weight)
    EditText etInputWeight;
    @BindView(R.id.ll_other_diagnostic)
    LinearLayout llOtherDiagnostic;
    private ArrayList<String> diagnosisList;
    private ArrayList<String> nosogenesisList;
    private ArrayList<String> hemorrhagicApoplexyList;
    private ArrayList<String> emergencyTreatmentDoctorList;
    private ArrayList<String> apoplexyDoctorList;


    public static StrokeTransferFragment newInstance(String recordId) {
        StrokeTransferFragment fragment = new StrokeTransferFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_transfer;
    }

    @Override
    protected void initView(@NonNull View view) {

    /*    if (TextUtils.isEmpty( RouteUrl.Stroke.STROKE_THRIVE_SCORE)) {
            showToast("地址不存在~");
        } else {
            RouterHelper.navWithPatient( RouteUrl.Stroke.STROKE_THRIVE_SCORE, "11");
        }*/

        loadData();
    }

    @Override
    protected void initListener() {

     //诊断结果
        esDiagnosis.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                if (text.contains("缺血性卒中")) {
                    llIschemicStroke.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                    llIschemicStroke.requestLayout();
                    if (etNosogenesis.getText().contains("其他原因所致的缺血性卒中（SOE）")) {
                        etNosogenesis.setItemData(nosogenesisList);
                    }
                } else if (text.contains("出血性卒中")) {
                    llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                } else if (text.contains("其它")) {
                    llOtherDiagnostic.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llIschemicStroke.setVisibility(View.GONE);
                } else {
                    llIschemicStroke.setVisibility(View.GONE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                }


            }
        });



    }

    private void loadData() {
        diagnosisList = new ArrayList<>();
        diagnosisList.add("请选择");
        diagnosisList.add("缺血性卒中");
        diagnosisList.add("出血性卒中");
        diagnosisList.add("非破裂动脉瘤");
        diagnosisList.add("颈部动脉狭窄或闭塞");
        diagnosisList.add("其它");
        esDiagnosis.setItemData(diagnosisList);

        ArrayList<String> ischemicStrokeList = new ArrayList<>();
        ischemicStrokeList.add("请选择");
        ischemicStrokeList.add("脑梗死");
        ischemicStrokeList.add("短暂性脑缺血(TIA)");
        etIschemicStroke.setItemData(ischemicStrokeList);

        nosogenesisList = new ArrayList<>();
        nosogenesisList.add("请选择");
        nosogenesisList.add("大动脉粥样硬化性卒中（LAA）");
        nosogenesisList.add("心源性脑栓塞（CE）");
        nosogenesisList.add("小动脉闭塞性卒中或腔隙性卒中（SAA）");
        nosogenesisList.add("其他原因所致的缺血性卒中（SOE）");
        nosogenesisList.add("不明原因的缺血性卒中（SUE）");
        etNosogenesis.setItemData(nosogenesisList);

        //急诊医生
        hemorrhagicApoplexyList = new ArrayList<>();
        hemorrhagicApoplexyList.add("请选择");
        hemorrhagicApoplexyList.add("动脉瘤破裂");
        hemorrhagicApoplexyList.add("非动脉瘤破裂");
        esHemorrhagicApoplexy.setItemData(hemorrhagicApoplexyList);


    }

}