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
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.chestpain.EmergencyCenterChestpainDrugPo;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

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
public class ChestPainInitDrugFragment extends BaseStrokeFragment implements View.OnClickListener {

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


    public static ChestPainInitDrugFragment newInstance(String recordId) {
        ChestPainInitDrugFragment fragment = new ChestPainInitDrugFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
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
        refrashViewOpen();
    }

    public void refrashViewOpen(){

        refrashItemVis(llAntihemotherapyData, svAntihemotherapy);
        refrashItemVis(llPreoperativeAnticoagulationData, svPreoperativeAnticoagulation);
        refrashItemVis(llStatinTherapyData, svStatinTherapy);
        refrashOtherView();
    }

    private void refrashOtherView(){
        if (editSpinnerAmoxicillin.checkLastItem()){
            iebAntihemotherapyValue.setVisibility(View.VISIBLE);
        }else {
            iebAntihemotherapyValue.setVisibility(View.GONE);
        }

        if (editSpinnerTicagrelor.checkLastItem()) {
            iebTicagrelorValue.setVisibility(View.VISIBLE);
        }else {
            iebTicagrelorValue.setVisibility(View.GONE);
        }
        if (editSpinnerClopidogrel.checkLastItem()) {
            iebClopidogrelValue.setVisibility(View.VISIBLE);
        }else {
            iebClopidogrelValue.setVisibility(View.GONE);
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void resetShowData() {
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(mRecordId);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainsuEmergencyCenter(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<EmergencyCenterChestpainDrugPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<EmergencyCenterChestpainDrugPo>> call, Response<BaseObjectBean<EmergencyCenterChestpainDrugPo>> response) {
                       hideLoadingDialog();
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
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    private void resetShowView(EmergencyCenterChestpainDrugPo bean) {
        if (bean == null) {
            return;
        }
        boolean isOpen = false;
        String time = "";
        if (!TextUtils.isEmpty(bean.getAcsaspirintime())) {
            time = bean.getAcsaspirintime();
        } else if (!TextUtils.isEmpty(bean.getAcstigrilotime())) {
            time = bean.getAcstigrilotime();
        } else if (!TextUtils.isEmpty(bean.getAcstigrilotime())) {
            time = bean.getAcstigrilotime();
        }
//        ttb_antihemotherapy_time
        if (!TextUtils.isEmpty(time)) {
            isOpen = true;
        }
        ttbAntihemotherapyTime.setTime(time);
        // 设置阿莫西林
        String text = bean.getAcsaspirindosage();
        if (!TextUtils.isEmpty(text)) {
            isOpen = true;
        }
        editSpinnerAmoxicillin.setStringArrayNormalKey(text);

        String otheracstigrilodosage = bean.getOtheracstigrilodosage();

        if (!TextUtils.isEmpty(otheracstigrilodosage)) {
            isOpen = true;
        }
        iebAntihemotherapyValue.setEditContent(otheracstigrilodosage);
//
//        // 表示选中抗血小板治疗
        //edit_spinner_amoxicillin 阿莫西林
        text = bean.getAcsaspirindosage();

        if (!TextUtils.isEmpty(text)) {
            isOpen = true;
        }
        editSpinnerAmoxicillin.setStringArrayNormalKey(text);
        iebAntihemotherapyValue.setEditContent(bean.getOtheracstigrilodosage());
//
//        //edit_spinner_clopidogrel 氯呲格雷g
        String clopidogrelText = bean.getAcschlorpyridindosage();

        if (!TextUtils.isEmpty(clopidogrelText)) {
            isOpen = true;
        }
        editSpinnerClopidogrel.setStringArrayNormalKey(clopidogrelText);
        iebClopidogrelValue.setEditContent(bean.getOtheracschlorpyridindosage());
//
//        //替格瑞洛  edit_spinner_ticagrelor
        String acstigrilodosage = bean.getAcstigrilodosage();

        if (!TextUtils.isEmpty(acstigrilodosage)) {
            isOpen = true;
        }
        editSpinnerTicagrelor.setStringArrayNormalKey(acstigrilodosage);
        iebTicagrelorValue.setEditContent(bean.getOtheracstigrilodosage());
        svAntihemotherapy.setChecked(isOpen);
//        bean.setAcstigrilotime(time);
//-------------  抗血小板治疗完成

        String acsanticoagulantmedicinetime = bean.getAcsanticoagulantmedicinetime();
        ttbPreoperativeAnticoagulationTime.setTime(acsanticoagulantmedicinetime);

        String acsanticoagulationdrugdosage = bean.getAcsanticoagulationdrugdosage();
        etPreoperativeAnticoagulationDose.setText(acsanticoagulationdrugdosage);

        String acsanticoagulationdrugunit = bean.getAcsanticoagulationdrugunit();
        etPreoperativeAnticoagulationUnit.setText(acsanticoagulationdrugunit);
        if (!TextUtils.isEmpty(acsanticoagulantmedicinetime)
                || !TextUtils.isEmpty(acsanticoagulationdrugdosage)
                || !TextUtils.isEmpty(acsanticoagulationdrugunit)) {
            svPreoperativeAnticoagulation.setChecked(true);
        }else {
            svPreoperativeAnticoagulation.setChecked(false);
        }
        String acsanticoagulationdrug = bean.getAcsanticoagulationdrug();
        edsPreoperativeAnticoagulation.setStringArrayNormalKey(acsanticoagulationdrug);

        isOpen = false;
        String acsatorvastatindosage = bean.getAcsatorvastatindosage();
        if (!TextUtils.isEmpty(acsatorvastatindosage)) {
            isOpen = true;
        }
        iebAtorvastatinValue.setEditContent(acsatorvastatindosage);
        String acsrosuvastatindosage = bean.getAcsrosuvastatindosage();
        if (!TextUtils.isEmpty(acsrosuvastatindosage)) {
            isOpen = true;
        }
        iebRosuvastatinValue.setEditContent(acsrosuvastatindosage);
        svStatinTherapy.setChecked(isOpen);
        //sv_beta_blockers
        // 表示选中了受阻滞剂
        if (Constants.BOOL_TRUE.equals(bean.getIsusebetablocker())) {
            svBetaBlockers.setChecked(true);
        } else {
            svBetaBlockers.setChecked(false);
        }

        if (Constants.BOOL_TRUE.equals(bean.getAcsisaceiarb())) {
            svAceiArb.setChecked(true);
        } else {
            svAceiArb.setChecked(false);
        }
        refrashViewOpen();
    }

    private void loadData() {
        editSpinnerAmoxicillin.setStringArrayId(R.array.cpc_aspirindosage);
        editSpinnerClopidogrel.setStringArrayId(R.array.cpc_chlorpyridindosage);
        editSpinnerTicagrelor.setStringArrayId(R.array.cpc_tigrilodosage);
        edsPreoperativeAnticoagulation.setStringArrayId(R.array.cpc_knyw);

        resetShowData();
    }


    @Override
    protected void initListener() {
        svAntihemotherapy.setOnClickListener(this);
        svPreoperativeAnticoagulation.setOnClickListener(this);
        svStatinTherapy.setOnClickListener(this);
        svBetaBlockers.setOnClickListener(this);

        EditSpinner.OnSelectStringLitner onSelectStringLitner = new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                refrashOtherView();
            }
        };
        editSpinnerTicagrelor.setOnSelectStringLitner(onSelectStringLitner);
        editSpinnerAmoxicillin.setOnSelectStringLitner(onSelectStringLitner);
        editSpinnerClopidogrel.setOnSelectStringLitner(onSelectStringLitner);
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
            String time = ttbAntihemotherapyTime.getTime();
            bean.setAcsaspirintime(time);
            String[] selectData = editSpinnerAmoxicillin.getSelectData();
            bean.setAcsaspirindosage(selectData[1]);
            if (editSpinnerAmoxicillin.checkLastItem()) {
                // 表示选中最后一个
                bean.setOtheracstigrilodosage(iebAntihemotherapyValue.getEditContent());
            } else {
                bean.setOtheracstigrilodosage("");
            }
            selectData = editSpinnerClopidogrel.getSelectData();
            bean.setAcschlorpyridindosage(selectData[1]);
//氯呲格雷
            bean.setAcschlorpyridintime(time);
            if (editSpinnerClopidogrel.checkLastItem()) {
                // 表示选中最后一个
                bean.setOtheracschlorpyridindosage(iebClopidogrelValue.getEditContent());
            } else {
                bean.setOtheracschlorpyridindosage("");
            }

//替格瑞洛
            selectData = editSpinnerTicagrelor.getSelectData();
            bean.setAcstigrilodosage(selectData[1]);
//氯呲格雷
            bean.setAcschlorpyridintime(time);
            if (editSpinnerTicagrelor.checkLastItem()) {
                // 表示选中最后一个
                bean.setOtheracstigrilodosage(iebTicagrelorValue.getEditContent());
            } else {
                bean.setOtheracstigrilodosage("");
            }
//
        }
        //sv_preoperative_anticoagulation
        if (svPreoperativeAnticoagulation.isChecked()) {
            // 表示选中了术前抗凝
//            acsisanticoagulantmedicine
            bean.setAcsisanticoagulantmedicine(Constants.BOOL_TRUE);
            String time = ttbPreoperativeAnticoagulationTime.getTime();
            String acsanticoagulationdrug = "";
            String[] selectData = edsPreoperativeAnticoagulation.getSelectData();
            bean.setAcsanticoagulationdrug(selectData[1]);

            if (edsPreoperativeAnticoagulation.checkLastItem()) {
                // 表示选中最后一个
                bean.setOtheracstigrilodosage(iebTicagrelorValue.getEditContent());
            } else {
                bean.setOtheracstigrilodosage("");
            }
            bean.setAcsanticoagulantmedicinetime(time);
            // 设置剂量 值
            String dose = etPreoperativeAnticoagulationDose.getText().toString().trim();
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
        if (bean == null)
        {
            return;
        }
        showLoadingDialog();
        bean.setRecordId(mRecordId);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainsuEmergencyCenter(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                       hideLoadingDialog();
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
                      hideLoadingDialog();
                      showToast(R.string.http_tip_server_error);
                    }
                });


    }


}