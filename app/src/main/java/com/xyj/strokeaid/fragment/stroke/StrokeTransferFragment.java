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

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeBloodExaminationBean;
import com.xyj.strokeaid.bean.StrokeTransferBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;
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
        //其它诊断
        iebOtherDiagnostic.setVisibility(View.GONE);
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
                    iebOtherDiagnostic.setVisibility(View.GONE);
                    llIschemicStroke.requestLayout();

                } else if (text.contains("出血性卒中")) {
                    llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                    llIschemicStroke.setVisibility(View.GONE);
                    iebOtherDiagnostic.setVisibility(View.GONE);
                } else if (text.contains("其它")) {
                    iebOtherDiagnostic.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llIschemicStroke.setVisibility(View.GONE);
                } else {
                    llIschemicStroke.setVisibility(View.GONE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    iebOtherDiagnostic.setVisibility(View.GONE);
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

    /**
     * 出院诊断-诊断时间
     */
    private String diagnostictimeleave;


    /**
     * 出院诊断-住院时间
     */
    private String hospitalstaytime;



    /**
     * 出院诊断-出院时GCS
     */
    private String leavegcs;

    /**
     * 出院诊断-出院时GCS的评分关联Id
     */
    private String leavegcsrelationid;

    /**
     * 出院诊断-出院时mRS
     */
    private String leavemrs;

    /**
     * 出院诊断-出院时mRS的评分关联Id
     */
    private String leavemrsrelationid;

    /**
     * 出院诊断-出院NIHSS评分
     */
    private String leavenihss;

    /**
     * 出院诊断-出院NIHSS评分的评分关联Id
     */
    private String leavenihssrelationid;

    /**
     * 出院诊断-住院天数
     */
    private String numberofdaysinhospital;

    /**
     * 出院诊断-其他
     */
    private String otherdiagnosticresultleave;




    /**
     * 出院诊断-总费用
     */
    private String totalcostinhospital;

    private void saveStrokeTransferData() {

        if (strokeTransferBean == null) {
            strokeTransferBean = new StrokeTransferBean();
        }

        strokeTransferBean.setDiagnosticresultleave(esDiagnosis.getSelectData()[1]);
        strokeTransferBean.setIschemicstrokeleave(etIschemicStroke.getSelectData()[1]);
        strokeTransferBean.setHemorrhagicstrokeleave(esHemorrhagicApoplexy.getSelectData()[1]);
        strokeTransferBean.setRuptureofaneurysmleave(esRuptureOfAneurysms.getSelectData()[1]);
        strokeTransferBean.setRuptureofnonaneurysmleave(esNoRuptureOfAneurysms.getSelectData()[1]);
        strokeTransferBean.setDepartmenttransto(esReceivingDepartment.getSelectData()[1]);


        BaseRequestBean<StrokeTransferBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, strokeTransferBean);

        RetrofitClient
                .getInstance()
                .getApi()
                .saveBloodExaminationInfo(baseRequestBean.getResuestBody(baseRequestBean))
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

    private void loadBloodExaminationData() {

        BaseRequestBean<StrokeBloodExaminationBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeBloodExaminationBean());

        RetrofitClient.getInstance()
                .getApi()
                .getBloodExaminationInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeBloodExaminationBean>>() {


                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeBloodExaminationBean>> call,
                                           Response<BaseResponseBean<StrokeBloodExaminationBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                          /*      strokeBloodExaminationBean = response.body().getData().getData();
                                if (strokeBloodExaminationBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getStrokeBloodExaminationBean(strokeBloodExaminationBean);
                                }*/


                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeBloodExaminationBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


}