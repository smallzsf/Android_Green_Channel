package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeBloodExaminationBean;
import com.xyj.strokeaid.bean.StrokeTransferBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.KeyValueHelper;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * TransferFragment
 * description: 转归交接
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeTransferFragment extends BaseStrokeFragment {


    @BindView(R.id.es_diagnosis)
    EditSpinner esDiagnosis;
    @BindView(R.id.ll_diagnosis)
    LinearLayout llDiagnosis;
    @BindView(R.id.et_ischemic_stroke)
    EditSpinner etIschemicStroke;
    @BindView(R.id.ll_ischemic_stroke)
    LinearLayout llIschemicStroke;
    @BindView(R.id.es_hemorrhagic_apoplexy)
    EditSpinner esHemorrhagicApoplexy;
    @BindView(R.id.ll_hemorrhagic_apoplexy)
    LinearLayout llHemorrhagicApoplexy;
    @BindView(R.id.es_rupture_of_aneurysms)
    EditSpinner esRuptureOfAneurysms;
    @BindView(R.id.ll_rupture_of_aneurysms)
    LinearLayout llRuptureOfAneurysms;
    @BindView(R.id.es_no_rupture_of_aneurysms)
    EditSpinner esNoRuptureOfAneurysms;
    @BindView(R.id.ll_no_rupture_of_aneurysms)
    LinearLayout llNoRuptureOfAneurysms;
    @BindView(R.id.ieb_other_diagnostic)
    ItemEditBar iebOtherDiagnostic;
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
    @BindView(R.id.ll_other_diagnostic)
    LinearLayout llOtherDiagnostic;
    @BindView(R.id.ieb_leave_hospital_nihss)
    ItemEditBar iebLeaveHospitalNihss;
    @BindView(R.id.ieb_leave_hospital_mrs)
    ItemEditBar iebLeaveHospitalMrs;
    @BindView(R.id.ieb_leave_hospital_gcs)
    ItemEditBar iebLeaveHospitalGcs;
    @BindView(R.id.ttb_diagnosis_of_time)
    TextTimeBar ttbDiagnosisOfTime;
    @BindView(R.id.ttb_in_hospital_time)
    TextTimeBar ttbInHospitalTime;
    @BindView(R.id.ttb_in_hospital_days)
    ItemEditBar ttbInHospitalDays;
    @BindView(R.id.ieb_all_money)
    ItemEditBar iebAllMoney;
    @BindView(R.id.ttb_leave_hospital_time)
    TextTimeBar ttbLeaveHospitalTime;
    @BindView(R.id.ttb_transfer_class_time)
    TextTimeBar ttbTransferClassTime;
    @BindView(R.id.ttb_death_time)
    TextTimeBar ttbDeathTime;
    private ArrayList<String> diagnosisList;
    private ArrayList<String> nosogenesisList;

    private ArrayList<String> emergencyTreatmentDoctorList;
    private ArrayList<String> apoplexyDoctorList;
    private ArrayList<String> ruptureOfAneurysmsList;
    private StrokeTransferBean strokeTransferBean;


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

        //缺血性卒中
        llIschemicStroke.setVisibility(View.GONE);
        //出血性卒中
        llHemorrhagicApoplexy.setVisibility(View.GONE);
        //动脉瘤破裂
        llRuptureOfAneurysms.setVisibility(View.GONE);
        //非动脉瘤破裂
        llNoRuptureOfAneurysms.setVisibility(View.GONE);
        //其它
        llOtherDiagnostic.setVisibility(View.GONE);
        //mrs gcs
        iebLeaveHospitalMrs.setVisibility(View.GONE);
        iebLeaveHospitalGcs.setVisibility(View.GONE);

        //出院
        svLeaveHospital.setVisibility(View.GONE);
        //死亡
        llDeath.setVisibility(View.GONE);
        //转科
        llTranfer.setVisibility(View.GONE);

        rgPatientOut.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_patient_out_treating:
                        //出院
                        svLeaveHospital.setVisibility(View.GONE);
                        //死亡
                        llDeath.setVisibility(View.GONE);
                        //转科
                        llTranfer.setVisibility(View.GONE);
                        break;
                    case R.id.rb_patient_out_leave:
                        //出院
                        svLeaveHospital.setVisibility(View.VISIBLE);
                        //死亡
                        llDeath.setVisibility(View.GONE);
                        //转科
                        llTranfer.setVisibility(View.GONE);
                        break;
                    case R.id.rb_patient_out_transfer:
                        //出院
                        svLeaveHospital.setVisibility(View.GONE);
                        //死亡
                        llDeath.setVisibility(View.GONE);
                        //转科
                        llTranfer.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_patient_out_death:
                        //出院
                        svLeaveHospital.setVisibility(View.GONE);
                        //死亡
                        llDeath.setVisibility(View.VISIBLE);
                        //转科
                        llTranfer.setVisibility(View.GONE);
                        break;
                }
            }
        });


        loadStrokeTransferData();
    }

    @Override
    protected void initListener() {


        iebLeaveHospitalNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_NIHSS)
                    .navigation();
        });

        iebLeaveHospitalMrs.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_MRS_SCORE)
                    .navigation();
        });

        iebLeaveHospitalGcs.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GCS_SCORE)
                    .navigation();
        });


        //诊断结果
        esDiagnosis.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.equals("缺血性卒中")) {
                    llIschemicStroke.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                } else if (text.equals("出血性卒中")) {
                    llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                    iebLeaveHospitalMrs.setVisibility(View.VISIBLE);
                    iebLeaveHospitalGcs.setVisibility(View.VISIBLE);
                } else if (text.equals("其它")) {
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.VISIBLE);
                } else {
                    llIschemicStroke.setVisibility(View.GONE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                }


            }
        });


        //出血性卒中
        esHemorrhagicApoplexy.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                if (text.equals("动脉瘤破裂")) {
                    llNoRuptureOfAneurysms.setVisibility(View.GONE);
                    llRuptureOfAneurysms.setVisibility(View.VISIBLE);
                } else if (text.equals("非动脉瘤破裂")) {
                    llRuptureOfAneurysms.setVisibility(View.GONE);
                    llNoRuptureOfAneurysms.setVisibility(View.VISIBLE);
                } else {
                    llRuptureOfAneurysms.setVisibility(View.GONE);
                    llNoRuptureOfAneurysms.setVisibility(View.GONE);
                }


            }
        });


    }

    private void loadData() {
        esDiagnosis.setStringArrayId(R.array.diagnosisList);
        etIschemicStroke.setStringArrayId(R.array.ischemicStrokeList);
        esHemorrhagicApoplexy.setStringArrayId(R.array.hemorrhagicApoplexyList);
        esRuptureOfAneurysms.setStringArrayId(R.array.rupturedAneurysm);
        esNoRuptureOfAneurysms.setStringArrayId(R.array.ruptureofnonaneurysm);
        esReceivingDepartment.setStringArrayId(R.array.stroke_transfer_ks);
    }


    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        saveStrokeTransferData();
    }


    private void saveStrokeTransferData() {

        if (strokeTransferBean == null) {
            strokeTransferBean = new StrokeTransferBean();
        }

        strokeTransferBean.setDiagnosticresultleave(esDiagnosis.getSelectData()[1]);
        strokeTransferBean.setIschemicstrokeleave(etIschemicStroke.getSelectData()[1]);
        strokeTransferBean.setHemorrhagicstrokeleave(esHemorrhagicApoplexy.getSelectData()[1]);
        strokeTransferBean.setRuptureofaneurysmleave(esRuptureOfAneurysms.getSelectData()[1]);
        strokeTransferBean.setRuptureofnonaneurysmleave(esNoRuptureOfAneurysms.getSelectData()[1]);


        //	出院诊断-诊断时间
        strokeTransferBean.setDiagnostictimeleave(ttbDiagnosisOfTime.getTime());
        //出院诊断-住院时间
        strokeTransferBean.setHospitalstaytime(ttbInHospitalTime.getTime());
        //出院诊断-住院天数
        strokeTransferBean.setNumberofdaysinhospital(ttbInHospitalDays.getEditContent());
        //总费用
        strokeTransferBean.setTotalcostinhospital(iebAllMoney.getEditContent());
        //出院诊断-出院NIHSS评分
        strokeTransferBean.setLeavenihss(iebLeaveHospitalNihss.getEditContent());
        //出院诊断-出院时mRS
        strokeTransferBean.setLeavemrs(iebLeaveHospitalMrs.getEditContent());
        //出院诊断-出院时GCS
        strokeTransferBean.setLeavegcs(iebLeaveHospitalGcs.getEditContent());

        //患者转归
        if (rbPatientOutTreating.isChecked()) {
            strokeTransferBean.setPrognosisresult(rbPatientOutTreating.getTag().toString());
        } else if (rbPatientOutLeave.isChecked()) {
            strokeTransferBean.setPrognosisresult(rbPatientOutLeave.getTag().toString());
        } else if (rbPatientOutTransfer.isChecked()) {
            strokeTransferBean.setPrognosisresult(rbPatientOutTransfer.getTag().toString());
        } else {
            strokeTransferBean.setPrognosisresult(rbPatientOutDeath.getTag().toString());
        }

        //出院 出院时间 后台返回有问题

        strokeTransferBean.setDischargedtime(ttbLeaveHospitalTime.getTime());
        //离院方式
        if (rbLeaveHospital.isChecked()) {
            String tag = (String) rbLeaveHospital.getTag();
            strokeTransferBean.setLeaveway(tag);
        } else if (rbTransformHospital.isChecked()) {
            String tag = (String) rbTransformHospital.getTag();
            strokeTransferBean.setLeaveway(tag);
        } else if (rbTownshipHealthCenter.isChecked()) {
            String tag = (String) rbTownshipHealthCenter.getTag();
            strokeTransferBean.setLeaveway(tag);
        } else if (rbNoLeaveHospital.isChecked()) {
            String tag = (String) rbNoLeaveHospital.getTag();
            strokeTransferBean.setLeaveway(tag);
        } else {
            String tag = (String) rbOther.getTag();
            strokeTransferBean.setLeaveway(tag);
        }

        //治疗效果
        if (rbTreatResultCure.isChecked()) {
            String tag = (String) rbTreatResultCure.getTag();
            strokeTransferBean.setTreatmentresult(tag);
        } else if (rbTreatResultBetter.isChecked()) {
            String tag = (String) rbTreatResultBetter.getTag();
            strokeTransferBean.setTreatmentresult(tag);
        } else if (rbTreatResultHeadDeath.isChecked()) {
            String tag = (String) rbTreatResultHeadDeath.getTag();
            strokeTransferBean.setTreatmentresult(tag);
        } else if (rbTreatResultOther.isChecked()) {
            String tag = (String) rbTreatResultOther.getTag();
            strokeTransferBean.setTreatmentresult(tag);
        }


        //出院带药
        String checkBoxCydyValue = KeyValueHelper.getCheckboxsKey(cbCydyJyy, cbCydyJty, cbCydyTzy, cbCydyKny, cbCydyKxxby, cbCydyZyzl, cbCydyQt, cbCydyWu);
        strokeTransferBean.setLeavewithmedicine(checkBoxCydyValue);

        strokeTransferBean.setLeavegcs(iebLeaveHospitalGcs.getEditContent());

        //转科时间
        strokeTransferBean.setTransdepartmenttime(ttbTransferClassTime.getTime());
        //接诊科室
        strokeTransferBean.setDepartmenttransto(esReceivingDepartment.getSelectData()[1]);
        //转科原因描述
        strokeTransferBean.setTransdepartmentreason(etTransferReason.getText().toString());

        //死亡时间
        strokeTransferBean.setDeathtime(ttbDeathTime.getTime());
        //死亡原因
        String checkBoxSwyyValue = KeyValueHelper.getCheckboxsKey(cbSwyyHxxhsj, cbSwyyNxgb, cbSwyyFbgr, cbSwyySxhdcx, cbSwyyJxsgnsj, cbSwyySshzd, cbSwyyQt, cbSwyyBx);
        strokeTransferBean.setDeathreason(checkBoxSwyyValue);


        BaseRequestBean<StrokeTransferBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, strokeTransferBean);

        RetrofitClient
                .getInstance()
                .getApi()
                .saveStrokeTransferInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());
                    }
                });


    }

    private void loadStrokeTransferData() {

        BaseRequestBean<StrokeTransferBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeTransferBean());

        RetrofitClient.getInstance()
                .getApi()
                .getStrokeTransferInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeTransferBean>>() {


                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeTransferBean>> call,
                                           Response<BaseResponseBean<StrokeTransferBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                strokeTransferBean = response.body().getData().getData();
                                if (strokeTransferBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getStrokeTransferBean(strokeTransferBean);
                                }


                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeTransferBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    private void getStrokeTransferBean(StrokeTransferBean strokeTransferBean) {
        String diagnosticresultleave = strokeTransferBean.getDiagnosticresultleave();
        String ischemicstrokeleave = strokeTransferBean.getIschemicstrokeleave();
        String hemorrhagicstrokeleave = strokeTransferBean.getHemorrhagicstrokeleave();
        String ruptureofaneurysmleave = strokeTransferBean.getRuptureofaneurysmleave();
        String ruptureofnonaneurysmleave = strokeTransferBean.getRuptureofnonaneurysmleave();
        esDiagnosis.setStringArrayNormalKey(diagnosticresultleave);
        etIschemicStroke.setStringArrayNormalKey(ischemicstrokeleave);
        esHemorrhagicApoplexy.setStringArrayNormalKey(hemorrhagicstrokeleave);
        esRuptureOfAneurysms.setStringArrayNormalKey(ruptureofaneurysmleave);
        esNoRuptureOfAneurysms.setStringArrayNormalKey(ruptureofnonaneurysmleave);
        //	出院诊断-诊断时间
        ttbDiagnosisOfTime.setTime(strokeTransferBean.getDiagnostictimeleave());
        //出院诊断-住院时间
        ttbInHospitalTime.setTime(strokeTransferBean.getHospitalstaytime());
        //出院诊断-住院天数
        ttbInHospitalDays.setEditContent(strokeTransferBean.getNumberofdaysinhospital());
        //总费用
        iebAllMoney.setEditContent(strokeTransferBean.getTotalcostinhospital());
        //出院诊断-出院NIHSS评分
        iebLeaveHospitalNihss.setEditContent(strokeTransferBean.getLeavenihss());
        //出院诊断-出院时mRS
        iebLeaveHospitalMrs.setEditContent(strokeTransferBean.getLeavemrs());
        //出院诊断-出院时GCS
        iebLeaveHospitalGcs.setEditContent(strokeTransferBean.getLeavegcs());
        //患者转归
        rbPatientOutTreating.setChecked(strokeTransferBean.getPrognosisresult().equals(rbPatientOutTreating.getTag().toString()));
        rbPatientOutLeave.setChecked(strokeTransferBean.getPrognosisresult().equals(rbPatientOutLeave.getTag().toString()));
        rbPatientOutTransfer.setChecked(strokeTransferBean.getPrognosisresult().equals(rbPatientOutTransfer.getTag().toString()));
        rbPatientOutDeath.setChecked(strokeTransferBean.getPrognosisresult().equals(rbPatientOutDeath.getTag().toString()));
        //出院 出院时间
        ttbLeaveHospitalTime.setTime(strokeTransferBean.getDischargedtime());
        //离院方式
        rbLeaveHospital.setChecked(strokeTransferBean.getLeaveway().equals(rbLeaveHospital.getTag().toString()));
        rbTransformHospital.setChecked(strokeTransferBean.getLeaveway().equals(rbTransformHospital.getTag().toString()));
        rbTownshipHealthCenter.setChecked(strokeTransferBean.getLeaveway().equals(rbTownshipHealthCenter.getTag().toString()));
        rbNoLeaveHospital.setChecked(strokeTransferBean.getLeaveway().equals(rbNoLeaveHospital.getTag().toString()));
        rbOther.setChecked(strokeTransferBean.getLeaveway().equals(rbOther.getTag().toString()));

        //治疗效果
        rbTreatResultCure.setChecked(strokeTransferBean.getTreatmentresult().equals(rbTreatResultCure.getTag().toString()));
        rbTreatResultBetter.setChecked(strokeTransferBean.getTreatmentresult().equals(rbTreatResultBetter.getTag().toString()));
        rbTreatResultHeadDeath.setChecked(strokeTransferBean.getTreatmentresult().equals(rbTreatResultHeadDeath.getTag().toString()));
        rbTreatResultOther.setChecked(strokeTransferBean.getTreatmentresult().equals(rbTreatResultOther.getTag().toString()));


        //出院带药
        String leavewithmedicine = strokeTransferBean.getLeavewithmedicine();
        cbCydyJyy.setChecked(leavewithmedicine.contains(cbCydyJyy.getTag().toString()));
        cbCydyJty.setChecked(leavewithmedicine.contains(cbCydyJty.getTag().toString()));
        cbCydyTzy.setChecked(leavewithmedicine.contains(cbCydyTzy.getTag().toString()));
        cbCydyKny.setChecked(leavewithmedicine.contains(cbCydyKny.getTag().toString()));
        cbCydyKxxby.setChecked(leavewithmedicine.contains(cbCydyKxxby.getTag().toString()));
        cbCydyZyzl.setChecked(leavewithmedicine.contains(cbCydyZyzl.getTag().toString()));
        cbCydyQt.setChecked(leavewithmedicine.contains(cbCydyQt.getTag().toString()));
        cbCydyWu.setChecked(leavewithmedicine.contains(cbCydyWu.getTag().toString()));


        //转科时间
        ttbTransferClassTime.setTime(strokeTransferBean.getTransdepartmenttime());
        //接诊科室
        esReceivingDepartment.setStringArrayNormalKey(strokeTransferBean.getDepartmenttransto());
        //转科原因描述
        etTransferReason.setText(strokeTransferBean.getTransdepartmentreason());

        //死亡时间
        ttbDeathTime.setTime(strokeTransferBean.getDeathtime());
        //死亡原因
        String deathreason = strokeTransferBean.getDeathreason();
        cbSwyyHxxhsj.setChecked(deathreason.contains(cbSwyyHxxhsj.getTag().toString()));
        cbSwyyNxgb.setChecked(deathreason.contains(cbSwyyNxgb.getTag().toString()));
        cbSwyyFbgr.setChecked(deathreason.contains(cbSwyyFbgr.getTag().toString()));
        cbSwyySxhdcx.setChecked(deathreason.contains(cbSwyySxhdcx.getTag().toString()));
        cbSwyyJxsgnsj.setChecked(deathreason.contains(cbSwyyJxsgnsj.getTag().toString()));
        cbSwyySshzd.setChecked(deathreason.contains(cbSwyySshzd.getTag().toString()));
        cbSwyyQt.setChecked(deathreason.contains(cbSwyyQt.getTag().toString()));
        cbSwyyBx.setChecked(deathreason.contains(cbSwyyBx.getTag().toString()));


    }


}