package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.EmergencyCenterChestpainHospitalData;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.RequestEmergencyCenterChestpainDataBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  静脉溶栓
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainIntraThromFragment extends BaseStrokeFragment implements View.OnClickListener {


    @BindView(R.id.rb_suitable)
    RadioButton rbSuitable;
    @BindView(R.id.rb_no_suitable)
    RadioButton rbNoSuitable;
    @BindView(R.id.rb_not_screened)
    RadioButton rbNotScreened;
    @BindView(R.id.rb_taboo_has)
    RadioButton rbTabooHas;
    @BindView(R.id.rb_taboo_none)
    RadioButton rbTabooNone;
    @BindView(R.id.ll_no_suitable)
    LinearLayout llNoSuitable;
    @BindView(R.id.rb_thrombolytic_therapy_has)
    RadioButton rbThrombolyticTherapyHas;
    @BindView(R.id.rb_thrombolytic_therapy_none)
    RadioButton rbThrombolyticTherapyNone;
    @BindView(R.id.rb_thrombolytic_site_has)
    RadioButton rbThrombolyticSiteHas;
    @BindView(R.id.rb_thrombolytic_site_none)
    RadioButton rbThrombolyticSiteNone;
    @BindView(R.id.rb_emergency_department)
    RadioButton rbEmergencyDepartment;
    @BindView(R.id.rb_heart_department)
    RadioButton rbHeartDepartment;
    @BindView(R.id.rb_other_department)
    RadioButton rbOtherDepartment;
    @BindView(R.id.edit_spinner_medicine)
    EditSpinner editSpinnerMedicine;
    @BindView(R.id.edit_spinner_dose)
    EditSpinner editSpinnerDose;
    @BindView(R.id.rb_intrac_has)
    RadioButton rbIntracHas;
    @BindView(R.id.rb_intrac_none)
    RadioButton rbIntracNone;
    @BindView(R.id.ll_suitable)
    LinearLayout llSuitable;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    @BindView(R.id.rrb_start_talk)
    TextTimeBar ttbStartTalk;

    @BindView(R.id.rrb_sign_agreement)
    TextTimeBar ttbSignAgreement;

    @BindView(R.id.rrb_start_thrombolysis)
    TextTimeBar ttbStartThrombolysis;

    @BindView(R.id.rrb_start_thrombolysis_finish)
    TextTimeBar ttbStartThrombolysisFinish;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recordId 记录ID
     * @return A new instance of fragment StrokeGetInvolvedFragment.
     */
    public static ChestPainIntraThromFragment newInstance(String recordId) {
        ChestPainIntraThromFragment fragment = new ChestPainIntraThromFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_intrac_throm;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
    }

    private void loadData() {
        // 溶栓药物种类
        editSpinnerMedicine.setItemData(Arrays.asList(getResources().getStringArray(R.array.thrombolytic_drug)));
        //剂量
        editSpinnerDose.setItemData(Arrays.asList(getResources().getStringArray(R.array.thrombolytic_drug_dose)));
    }

    @Override
    public void onResume() {
        super.onResume();
        loadRecordData(mRecordId);
    }

    @Override
    protected void initListener() {

        rbSuitable.setOnClickListener(this);
        rbNoSuitable.setOnClickListener(this);
        rbOtherDepartment.setOnClickListener(this);
        rbIntracHas.setOnClickListener(this);
        rbIntracNone.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_intrac_has:
                // 溶栓通道点击是
                break;

            case R.id.rb_intrac_none:
                // 溶栓通道点击否
                break;
            case R.id.rb_suitable:
                // 溶栓筛查合适
                llNoSuitable.setVisibility(View.GONE);
                llSuitable.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_no_suitable:
                // 溶栓筛查不合适
                llNoSuitable.setVisibility(View.VISIBLE);
                llSuitable.setVisibility(View.GONE);
                break;
            case R.id.rb_not_screened:
                // 溶栓其他筛查
                llNoSuitable.setVisibility(View.GONE);
                llSuitable.setVisibility(View.GONE);
                break;

            case R.id.rb_thrombolytic_therapy_has:
                // 溶栓治疗点击是
                break;

            case R.id.rb_thrombolytic_therapy_none:
                // 溶栓治疗点击否
                break;

            case R.id.rb_thrombolytic_site_has:
                // 直达溶栓场所点击是
                break;

            case R.id.rb_thrombolytic_site_none:
                // 直达溶栓场所点击否
                break;
            case R.id.btn_confirm:
                // 保存
                EmergencyCenterChestpainHospitalData emergencyCenterChestpainHospitalData = new EmergencyCenterChestpainHospitalData();
                emergencyCenterChestpainHospitalData.setRecordId(mRecordId);
                if (rbSuitable.isChecked()) {
                    emergencyCenterChestpainHospitalData.setThrombolysisscreenresult("cpc_rsscjg_hs");
                }
                if (rbNoSuitable.isChecked()) {
                    emergencyCenterChestpainHospitalData.setThrombolysisscreenresult("cpc_rsscjg_bhs");
                }
                if (rbNotScreened.isChecked()) {
                    emergencyCenterChestpainHospitalData.setThrombolysisscreenresult("cpc_rsscjg_wsc");
                }
                if (rbIntracHas.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisreuslt("cpc_bool_true");
                }
                if (rbIntracNone.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisreuslt("cpc_bool_false");
                }

                if (rbThrombolyticTherapyHas.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysiscontraindication("cpc_bool_true");
                }
                if (rbThrombolyticTherapyNone.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysiscontraindication("cpc_bool_false");
                }
                if (rbEmergencyDepartment.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisroom("cpc_ynrscs_byjzk");
                }
                if (rbHeartDepartment.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisroom("cpc_ynrscs_byxnk");
                }
                if (rbOtherDepartment.isChecked()) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisroom("cpc_ynrscs_qtks");
                }
                emergencyCenterChestpainHospitalData.setAfterthrombolysisbegintime(ttbStartThrombolysis.getTime());
                emergencyCenterChestpainHospitalData.setAfterthrombolysisendtime(ttbStartThrombolysisFinish.getTime());
                emergencyCenterChestpainHospitalData.setAfterthrombolysispatientcommunicationsbegintime(ttbStartTalk.getTime());
                emergencyCenterChestpainHospitalData.setAfterthrombolysispatientcommunicationsendtime(ttbSignAgreement.getTime());


                if (TextUtils.equals(editSpinnerMedicine.getText(), "第一代")) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisdrug("cpc_rsywv2_dyd");
                }
                if (TextUtils.equals(editSpinnerMedicine.getText(), "第二代")) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisdrug("cpc_rsywv2_ded");
                }
                if (TextUtils.equals(editSpinnerMedicine.getText(), "第三代")) {
                    emergencyCenterChestpainHospitalData.setAfterthrombolysisdrug("cpc_rsywv2_dsd");
                }

                emergencyCenterChestpainHospitalData.setAfterthrombolysisdrugdosage(editSpinnerDose.getText());
                saveRecordData(emergencyCenterChestpainHospitalData);
                break;

            case R.id.btn_get_data:
                loadRecordData(mRecordId);
            default:
                break;
        }
    }


    private void loadRecordData(String recordId) {
        if (TextUtils.isEmpty(recordId)) {
            return;
        }
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient.getInstance()
                .getApi()
                .getIntravenousThrombolysis(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<RequestEmergencyCenterChestpainDataBean>() {
                    @Override
                    public void onResponse(Call<RequestEmergencyCenterChestpainDataBean> call, Response<RequestEmergencyCenterChestpainDataBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                EmergencyCenterChestpainHospitalData mIntraConsultBean = response.body().getData();
                                if (mIntraConsultBean != null) {
                                    // 请求成功
                                    showToast("获取数据成功");
                                    setDataToView(mIntraConsultBean);
                                } else {
                                    showToast("数据异常");
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestEmergencyCenterChestpainDataBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }


    private void saveRecordData(EmergencyCenterChestpainHospitalData data) {
        if (data == null) {
            return;
        }
        showLoadingDialog();
        RetrofitClient.getInstance()
                .getApi()
                .saveIntravenousThrombolysis(data.getResuestBody(data))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存成功");
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }


    private void setDataToView(EmergencyCenterChestpainHospitalData data) {

        if (TextUtils.equals(data.getThrombolysisscreenresult(), "cpc_rsscjg_hs")) {
            rbSuitable.setChecked(true);
        }

        if (TextUtils.equals(data.getThrombolysisscreenresult(), "cpc_rsscjg_bhs")) {
            rbSuitable.setChecked(true);
        }
        if (TextUtils.equals(data.getThrombolysisscreenresult(), "cpc_rsscjg_wsc")) {
            rbNotScreened.setChecked(true);
        }

        if (TextUtils.equals(data.getAfterthrombolysisreuslt(), "cpc_bool_true")) {
            rbIntracHas.setChecked(true);
        }
        if (TextUtils.equals(data.getAfterthrombolysisreuslt(), "cpc_bool_false")) {
            rbIntracNone.setChecked(true);
        }

        if (TextUtils.equals(data.getAfterthrombolysiscontraindication(), "cpc_bool_true")) {
            rbThrombolyticTherapyHas.setChecked(true);
        }

        if (TextUtils.equals(data.getAfterthrombolysiscontraindication(), "cpc_bool_false")) {
            rbThrombolyticTherapyNone.setChecked(true);
        }


        if (TextUtils.equals(data.getAfterthrombolysisroom(), "cpc_ynrscs_byjzk")) {
            rbEmergencyDepartment.setChecked(true);
        }

        if (TextUtils.equals(data.getAfterthrombolysisroom(), "cpc_ynrscs_byxnk")) {
            rbHeartDepartment.setChecked(true);
        }
        if (TextUtils.equals(data.getAfterthrombolysisroom(), "cpc_ynrscs_qtks")) {
            rbOtherDepartment.setChecked(true);
        }

        ttbStartThrombolysis.setTime(data.getAfterthrombolysisendtime());

        ttbStartThrombolysisFinish.setTime(data.getAfterthrombolysisendtime());

        ttbStartTalk.setTime(data.getAfterthrombolysispatientcommunicationsbegintime());

        ttbSignAgreement.setTime(data.getAfterthrombolysispatientcommunicationsendtime());
        if (TextUtils.equals(data.getAfterthrombolysisdrug(), "cpc_rsywv2_dyd")) {
            editSpinnerMedicine.setText("第一代");
        }
        if (TextUtils.equals(data.getAfterthrombolysisdrug(), "cpc_rsywv2_ded")) {
            editSpinnerMedicine.setText("第二代");
        }
        if (TextUtils.equals(data.getAfterthrombolysisdrug(), "cpc_rsywv2_dsd")) {
            editSpinnerMedicine.setText("第三代");
        }
        editSpinnerDose.setText(data.getAfterthrombolysisdrugdosage());
    }


}