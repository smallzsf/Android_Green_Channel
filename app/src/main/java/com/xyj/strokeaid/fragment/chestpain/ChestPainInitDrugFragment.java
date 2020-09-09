package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.chestpain.EmergencyCenterChestpainDrugPo;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  初始药物
 *
 * @author : 张世福
 * email ：licy3051@qq.com
 */
public class ChestPainInitDrugFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.sv_antihemotherapy)
    SwitchCompat svAntihemotherapy;
    @BindView(R.id.ttb_antihemotherapy_time)
    TextTimeBar ttbAntihemotherapyTime;
    @BindView(R.id.edit_spinner_amoxicillin)
    EditSpinner editSpinnerAmoxicillin;
    @BindView(R.id.ieb_antihemotherapy_value)
    ItemEditBar iebAntihemotherapyValue;
    @BindView(R.id.edit_spinner_clopidogrel)
    EditSpinner editSpinnerClopidogrel;
    @BindView(R.id.ieb_clopidogrel_value)
    ItemEditBar iebClopidogrelValue;
    @BindView(R.id.edit_spinner_ticagrelor)
    EditSpinner editSpinnerTicagrelor;
    @BindView(R.id.ieb_ticagrelor_value)
    ItemEditBar iebTicagrelorValue;
    @BindView(R.id.ll_antihemotherapy_data)
    LinearLayout llAntihemotherapyData;
    @BindView(R.id.ll_antihemotherapy_title)
    LinearLayout llAntihemotherapyTitle;
    @BindView(R.id.sv_preoperative_anticoagulation)
    SwitchCompat svPreoperativeAnticoagulation;
    @BindView(R.id.ll_preoperative_anticoagulation_title)
    LinearLayout llPreoperativeAnticoagulationTitle;
    @BindView(R.id.ttb_preoperative_anticoagulation_time)
    TextTimeBar ttbPreoperativeAnticoagulationTime;
    @BindView(R.id.eds_preoperative_anticoagulation)
    EditSpinner edsPreoperativeAnticoagulation;
    @BindView(R.id.et_preoperative_anticoagulation_dose)
    EditText etPreoperativeAnticoagulationDose;
    @BindView(R.id.et_preoperative_anticoagulation_unit)
    EditText etPreoperativeAnticoagulationUnit;
    @BindView(R.id.ll_preoperative_anticoagulation_data)
    LinearLayout llPreoperativeAnticoagulationData;
    @BindView(R.id.sv_statin_therapy)
    SwitchCompat svStatinTherapy;
    @BindView(R.id.ll_statin_therapy_title)
    LinearLayout llStatinTherapyTitle;
    @BindView(R.id.ieb_atorvastatin_value)
    ItemEditBar iebAtorvastatinValue;
    @BindView(R.id.ieb_rosuvastatin_value)
    ItemEditBar iebRosuvastatinValue;
    @BindView(R.id.ll_statin_therapy_data)
    LinearLayout llStatinTherapyData;
    @BindView(R.id.sv_beta_blockers)
    SwitchCompat svBetaBlockers;
    @BindView(R.id.ll_beta_blockers_title)
    LinearLayout llBetaBlockersTitle;
    @BindView(R.id.sv_acei_arb)
    SwitchCompat svAceiArb;
    @BindView(R.id.ll_acei_arb)
    LinearLayout llAceiArb;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    private String mRecordId;

    public ChestPainInitDrugFragment() {

    }

    public static ChestPainInitDrugFragment newInstance(String recordId) {
        ChestPainInitDrugFragment fragment = new ChestPainInitDrugFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_init_drug;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取记录");
        btnConfirm.setText("确定");
        btnGetData.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        loadData();
    }


    @Override
    public void onResume() {
        super.onResume();
        resetShowData();
    }

    private void resetShowData() {
        RecordIdUtil src = new RecordIdUtil();
        src.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(src);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainsuEmergencyCenter(requestBody)
                .enqueue(new Callback<BaseObjectBean<EmergencyCenterChestpainDrugPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<EmergencyCenterChestpainDrugPo>> call, Response<BaseObjectBean<EmergencyCenterChestpainDrugPo>> response) {
                        Log.e("zhangshifu", "onResponse: " + response.toString());
                        if (response.body() == null) {
                            return;
                        }
                        if (response.body().getResult() != 1) {
                            return;
                        }
                        resetShowView(response.body().getData());
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<EmergencyCenterChestpainDrugPo>> call, Throwable t) {

                    }
                });

    }

    private void resetShowView(EmergencyCenterChestpainDrugPo bean) {
        if (bean == null) {
            return;
        }
        String acsaspirintime = bean.getAcsaspirintime();
        if (TextUtils.isEmpty(acsaspirintime)) {
            ttbAntihemotherapyTime.setTime(acsaspirintime);
        }
        String text = bean.getAcsaspirindosage();
        iebAntihemotherapyValue.setEditContent("");
//        if (TextUtils.equals(DOSE_0, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(0);
//        } else if (TextUtils.equals(DOSE_100, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(1);
//        } else if (TextUtils.equals(DOSE_300, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(2);
//        } else if (TextUtils.equals(otherDoses, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(3);
//            String otheracstigrilodosage = bean.getOtheracstigrilodosage();
//            iebAntihemotherapyValue.setEditContent(otheracstigrilodosage);
//        }
//
//        // 表示选中抗血小板治疗
//        //edit_spinner_amoxicillin 阿莫西林
//        text = bean.getAcstigrilodosage();
//        iebAntihemotherapyValue.setEditContent("");
//        if (TextUtils.equals(DOSE_0, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(0);
//        } else if (TextUtils.equals(DOSE_100, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(1);
//        } else if (TextUtils.equals(DOSE_300, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(2);
//        } else if (TextUtils.equals(otherDoses, text)) {
//            editSpinnerAmoxicillin.setSelectPosition(3);
//            iebAntihemotherapyValue.setEditContent(bean.getOtheracstigrilodosage());
//        }
//
//        //edit_spinner_clopidogrel 氯呲格雷g
////        String clopidogrelText = editSpinnerClopidogrel.getText().trim();
//        String clopidogrelText = bean.getAcschlorpyridindosage();
//        iebClopidogrelValue.setEditContent("");
//        if (TextUtils.equals(DOSE_0, clopidogrelText)) {
//            editSpinnerClopidogrel.setSelectPosition(0);
//        } else if (TextUtils.equals(DOSE_300, clopidogrelText)) {
//            editSpinnerClopidogrel.setSelectPosition(1);
//        } else if (TextUtils.equals(DOSE_600, clopidogrelText)) {
//            editSpinnerClopidogrel.setSelectPosition(2);
//        } else if (TextUtils.equals(otherDoses, clopidogrelText)) {
//            editSpinnerClopidogrel.setSelectPosition(3);
//            iebClopidogrelValue.setEditContent(bean.getOtheracschlorpyridindosage());
//        }
//
//        //替格瑞洛  edit_spinner_ticagrelor
//        String ticagrelorText = editSpinnerTicagrelor.getText().trim();
//        bean.setAcstigrilotime(time);
//        if (TextUtils.equals(DOSE_0, ticagrelorText)) {
//            bean.setAcstigrilodosage("cpc_tigrilodosage_0mg");
//        } else if (TextUtils.equals(DOSE_90, ticagrelorText)) {
//            bean.setAcstigrilodosage("cpc_tigrilodosage_90mg");
//        } else if (TextUtils.equals(DOSE_180, ticagrelorText)) {
//            bean.setAcstigrilodosage("cpc_tigrilodosage_180mg");
//        } else if (TextUtils.equals(otherDoses, ticagrelorText)) {
//            bean.setAcstigrilodosage("cpc_tigrilodosage_other");
//            bean.setOtheracstigrilodosage(iebTicagrelorValue.getEditContent());
//        } else {
//            bean.setAcstigrilotime("");
//        }
//        //sv_preoperative_anticoagulation
//        if (svPreoperativeAnticoagulation.isChecked()) {
//            // 表示选中了术前抗凝
////            acsisanticoagulantmedicine
//            bean.setAcsisanticoagulantmedicine(Constants.BOOL_TRUE);
//            String time = ttbPreoperativeAnticoagulationTime.getTime();
//            String acsanticoagulationdrug = "";
//            String text = edsPreoperativeAnticoagulation.getText();
//            if (TextUtils.equals(cpc_knyw_ptgs, text)) {
//                acsanticoagulationdrug = "cpc_knyw_ptgs";
//            } else if (TextUtils.equals(cpc_knyw_dfzgs, text)) {
//                acsanticoagulationdrug = "cpc_knyw_dfzgs";
//            } else if (TextUtils.equals(cpc_knyw_bfrd, text)) {
//                acsanticoagulationdrug = "cpc_knyw_bfrd";
//            } else if (TextUtils.equals(cpc_knyw_hdgkn, text)) {
//                acsanticoagulationdrug = "cpc_knyw_hdgkn";
//            } else {
//                time = "";
//            }
//            bean.setAcsanticoagulantmedicinetime(time);
//            bean.setAcsanticoagulationdrug(acsanticoagulationdrug);
//            // 设置剂量 值
////            et_preoperative_anticoagulation_dose.
//            String dose = etPreoperativeAnticoagulationDose.getText().toString().trim();
//
////                    et_preoperative_anticoagulation_unit
//            String unit = etPreoperativeAnticoagulationUnit.getText().toString()
//                    .trim();
//            bean.setAcsanticoagulationdrugdosage(dose);
//            bean.setAcsanticoagulationdrugunit(unit);
//
//        } else {
//            bean.setAcsisanticoagulantmedicine(Constants.BOOL_FALSE);
//        }
        //sv_statin_therapy
        if (svStatinTherapy.isChecked()) {
            // 表示选中了他定治疗
            bean.setAcsatorvastatindosage(iebAtorvastatinValue.getEditContent());
            bean.setAcsrosuvastatindosage(iebRosuvastatinValue.getEditContent());
            bean.setIs24intensivestatin(Constants.BOOL_TRUE);
        } else {
            bean.setIs24intensivestatin(Constants.BOOL_FALSE);
        }
        //sv_beta_blockers
        if (svBetaBlockers.isChecked()) {
            // 表示选中了受阻滞剂
            bean.setIsusebetablocker(Constants.BOOL_TRUE);
        } else {
            bean.setIsusebetablocker(Constants.BOOL_FALSE);
        }
        if (svAceiArb.isChecked()) {
            // 表示选中了acei
            bean.setAcsisaceiarb(Constants.BOOL_TRUE);
        } else {
            bean.setAcsisaceiarb(Constants.BOOL_FALSE);
        }
    }

    private void loadData() {
        editSpinnerAmoxicillin.setStringArrayId(R.array.cpc_aspirindosage);
        editSpinnerClopidogrel.setStringArrayId(R.array.cpc_chlorpyridindosage);
        editSpinnerTicagrelor.setStringArrayId(R.array.cpc_tigrilodosage);
        edsPreoperativeAnticoagulation.setStringArrayId(R.array.cpc_knyw);
    }


    @Override
    protected void initListener() {
        svAntihemotherapy.setOnClickListener(this);
        svPreoperativeAnticoagulation.setOnClickListener(this);
        svStatinTherapy.setOnClickListener(this);
        svBetaBlockers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:// 确定
                save();
                break;
            case R.id.btn_get_data:// 获取数据

                break;
            case R.id.sv_antihemotherapy:
                refrashItemVis(llAntihemotherapyData, svAntihemotherapy);
                break;
            case R.id.sv_preoperative_anticoagulation:
                refrashItemVis(llPreoperativeAnticoagulationData, svPreoperativeAnticoagulation);
                break;
            case R.id.sv_statin_therapy:
                refrashItemVis(llStatinTherapyData, svStatinTherapy);
                break;
            case R.id.sv_beta_blockers:
                break;
        }
    }

    private void refrashItemVis(View view, SwitchCompat switchCompat) {
        if (switchCompat.isChecked()) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    public void save() {
        EmergencyCenterChestpainDrugPo bean = new EmergencyCenterChestpainDrugPo();
        if (svAntihemotherapy.isChecked()) {
            // 表示选中抗血小板治疗
            //edit_spinner_amoxicillin 阿莫西林
            String text = editSpinnerAmoxicillin.getText().trim();
            String time = ttbAntihemotherapyTime.getTime();
            bean.setAcsaspirintime(time);
//            if (TextUtils.equals(DOSE_0, text)) {
//                bean.setAcsaspirindosage("cpc_aspirindosage_0mg");
//            } else if (TextUtils.equals(DOSE_100, text)) {
//                bean.setAcsaspirindosage("cpc_aspirindosage_100mg");
//            } else if (TextUtils.equals(DOSE_300, text)) {
//                bean.setAcsaspirindosage("cpc_aspirindosage_300mg");
//            } else if (TextUtils.equals(otherDoses, text)) {
//                bean.setAcsaspirindosage("cpc_aspirindosage_other");
//                bean.setOtheracstigrilodosage(iebAntihemotherapyValue.getEditContent());
//            } else {
//                bean.setAcsaspirintime("");
//            }
//
//            //edit_spinner_clopidogrel 氯呲格雷
//            String clopidogrelText = editSpinnerClopidogrel.getText().trim();
//            bean.setAcschlorpyridintime(time);
//            if (TextUtils.equals(DOSE_0, clopidogrelText)) {
//                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_0mg");
//            } else if (TextUtils.equals(DOSE_300, clopidogrelText)) {
//                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_300mg");
//            } else if (TextUtils.equals(DOSE_600, clopidogrelText)) {
//                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_600mg");
//            } else if (TextUtils.equals(otherDoses, clopidogrelText)) {
//                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_other");
////                ieb_clopidogrel_value
//                bean.setOtheracschlorpyridindosage(iebClopidogrelValue.getEditContent());
//            } else {
//                bean.setAcschlorpyridintime("");
//            }
//
//            //替格瑞洛  edit_spinner_ticagrelor
//            String ticagrelorText = editSpinnerTicagrelor.getText().trim();
//            bean.setAcstigrilotime(time);
//            if (TextUtils.equals(DOSE_0, ticagrelorText)) {
//                bean.setAcstigrilodosage("cpc_tigrilodosage_0mg");
//            } else if (TextUtils.equals(DOSE_90, ticagrelorText)) {
//                bean.setAcstigrilodosage("cpc_tigrilodosage_90mg");
//            } else if (TextUtils.equals(DOSE_180, ticagrelorText)) {
//                bean.setAcstigrilodosage("cpc_tigrilodosage_180mg");
//            } else if (TextUtils.equals(otherDoses, ticagrelorText)) {
//                bean.setAcstigrilodosage("cpc_tigrilodosage_other");
//                bean.setOtheracstigrilodosage(iebTicagrelorValue.getEditContent());
//            } else {
//                bean.setAcstigrilotime("");
//            }
        }
        //sv_preoperative_anticoagulation
        if (svPreoperativeAnticoagulation.isChecked()) {
            // 表示选中了术前抗凝
//            acsisanticoagulantmedicine
            bean.setAcsisanticoagulantmedicine(Constants.BOOL_TRUE);
            String time = ttbPreoperativeAnticoagulationTime.getTime();
            String acsanticoagulationdrug = "";
            String text = edsPreoperativeAnticoagulation.getText();
            String[] selectData = edsPreoperativeAnticoagulation.getSelectData();
//            if (TextUtils.equals(cpc_knyw_ptgs, text)) {
//                acsanticoagulationdrug = "cpc_knyw_ptgs";
//            } else if (TextUtils.equals(cpc_knyw_dfzgs, text)) {
//                acsanticoagulationdrug = "cpc_knyw_dfzgs";
//            } else if (TextUtils.equals(cpc_knyw_bfrd, text)) {
//                acsanticoagulationdrug = "cpc_knyw_bfrd";
//            } else if (TextUtils.equals(cpc_knyw_hdgkn, text)) {
//                acsanticoagulationdrug = "cpc_knyw_hdgkn";
//            } else {
//                time = "";
//            }
            bean.setAcsanticoagulantmedicinetime(time);
            bean.setAcsanticoagulationdrug(acsanticoagulationdrug);
            // 设置剂量 值
//            et_preoperative_anticoagulation_dose.
            String dose = etPreoperativeAnticoagulationDose.getText().toString().trim();

//                    et_preoperative_anticoagulation_unit
            String unit = etPreoperativeAnticoagulationUnit.getText().toString()
                    .trim();
            bean.setAcsanticoagulationdrugdosage(dose);
            bean.setAcsanticoagulationdrugunit(unit);

        } else {
            bean.setAcsisanticoagulantmedicine(Constants.BOOL_FALSE);
        }
        //sv_statin_therapy
        if (svStatinTherapy.isChecked()) {
            // 表示选中了他定治疗
            bean.setAcsatorvastatindosage(iebAtorvastatinValue.getEditContent());
            bean.setAcsrosuvastatindosage(iebRosuvastatinValue.getEditContent());
            bean.setIs24intensivestatin(Constants.BOOL_TRUE);
        } else {
            bean.setIs24intensivestatin(Constants.BOOL_FALSE);
        }
        //sv_beta_blockers
        if (svBetaBlockers.isChecked()) {
            // 表示选中了受阻滞剂
            bean.setIsusebetablocker(Constants.BOOL_TRUE);
        } else {
            bean.setIsusebetablocker(Constants.BOOL_FALSE);
        }
        if (svAceiArb.isChecked()) {
            // 表示选中了acei
            bean.setAcsisaceiarb(Constants.BOOL_TRUE);
        } else {
            bean.setAcsisaceiarb(Constants.BOOL_FALSE);
        }
        save(bean);

    }

    /**
     * 保存数据接口调用成功
     *
     * @param bean
     */
    public void save(EmergencyCenterChestpainDrugPo bean) {
        bean.setRecordId(RecordIdUtil.RECORD_ID);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainsuEmergencyCenter(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            BaseObjectBean body = response.body();
                            if (body.getResult() == 1) {
                                showToast("数据保存成功");
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });


    }


}