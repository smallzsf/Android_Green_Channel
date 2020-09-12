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


    @BindView(R.id.es_diagnose_result)
    EditSpinner esDiagnoseResult;
    @BindView(R.id.es_diagnose_detail_result)
    EditSpinner esDiagnoseDetailResult;
    @BindView(R.id.ll_diagnose_detail_result)
    LinearLayout llDiagnoseDetailResult;
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

    }

    @Override
    protected void initListener() {

    }
}