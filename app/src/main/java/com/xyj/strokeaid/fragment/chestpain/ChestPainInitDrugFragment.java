package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.xyj.strokeaid.bean.chestpain.EmergencyCenterChestpainDrugPo;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  初始药物
 *
 * @author : 张世福
 * @date : 2020/8/26
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
    private String DOSE_0 = "0mg";
    private String DOSE_90 = "90mg";
    private String DOSE_100 = "100mg";
    private String DOSE_180 = "180mg";
    private String DOSE_300 = "300mg";
    private String DOSE_600 = "600mg";
    private String otherDoses = "其他剂量";

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


    private void loadData() {
        List<String> list = new ArrayList<>();
        list.add(DOSE_0);
        list.add(DOSE_100);
        list.add(DOSE_300);
        list.add(otherDoses);
        editSpinnerAmoxicillin.setItemData(list);
        list = new ArrayList<>();
        list.add(DOSE_0);
        list.add(DOSE_300);
        list.add(DOSE_600);
        list.add(otherDoses);
        editSpinnerClopidogrel.setItemData(list);
        list = new ArrayList<>();
        list.add(DOSE_0);
        list.add(DOSE_90);
        list.add(DOSE_180);
        list.add(otherDoses);
        editSpinnerTicagrelor.setItemData(list);


        List<String> administrationDataList = new ArrayList<>();
        administrationDataList.add("药品类型");
        edsPreoperativeAnticoagulation.setItemData(administrationDataList);
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
            if (TextUtils.equals(DOSE_0, text)) {
                bean.setAcsaspirindosage("cpc_aspirindosage_0mg");
            } else if (TextUtils.equals(DOSE_100, text)) {
                bean.setAcsaspirindosage("cpc_aspirindosage_100mg");
            } else if (TextUtils.equals(DOSE_300, text)) {
                bean.setAcsaspirindosage("cpc_aspirindosage_300mg");
            } else if (TextUtils.equals(otherDoses, text)) {
                bean.setAcsaspirindosage("cpc_aspirindosage_other");
                bean.setOtheracstigrilodosage(iebAntihemotherapyValue.getEditContent());
            }

            //edit_spinner_clopidogrel 氯呲格雷
            String clopidogrelText = editSpinnerClopidogrel.getText().trim();
            if (TextUtils.equals(DOSE_0, clopidogrelText)) {
                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_0mg");
            } else if (TextUtils.equals(DOSE_300, clopidogrelText)) {
                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_300mg");
            } else if (TextUtils.equals(DOSE_600, clopidogrelText)) {
                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_600mg");
            } else if (TextUtils.equals(otherDoses, clopidogrelText)) {
                bean.setAcschlorpyridindosage("cpc_chlorpyridindosage_other");
//                ieb_clopidogrel_value
                bean.setOtheracschlorpyridindosage(iebClopidogrelValue.getEditContent());
            }

            //替格瑞洛  edit_spinner_ticagrelor
            String ticagrelorText = editSpinnerTicagrelor.getText().trim();
            if (TextUtils.equals(DOSE_0, ticagrelorText)) {
                bean.setAcstigrilodosage("cpc_tigrilodosage_0mg");
            } else if (TextUtils.equals(DOSE_90, ticagrelorText)) {
                bean.setAcstigrilodosage("cpc_tigrilodosage_90mg");
            } else if (TextUtils.equals(DOSE_180, ticagrelorText)) {
                bean.setAcstigrilodosage("cpc_tigrilodosage_180mg");
            } else if (TextUtils.equals(otherDoses, ticagrelorText)) {
                bean.setAcstigrilodosage("cpc_tigrilodosage_other");
                bean.setOtheracstigrilodosage(iebTicagrelorValue.getEditContent());
            }
        }
        //sv_preoperative_anticoagulation
        if (svPreoperativeAnticoagulation.isChecked()) {
            // 表示选中了术前抗凝
//            acsisanticoagulantmedicine
            bean.setAcsisanticoagulantmedicine(Constants.);
        }
        //sv_statin_therapy
        if (svStatinTherapy.isChecked()) {
            // 表示选中了他定治疗
//            ieb_atorvastatin_value  阿托伐他汀
//            ieb_rosuvastatin_value  瑞舒伐他汀
        }
        //sv_beta_blockers
        if (svBetaBlockers.isChecked()) {
            // 表示选中了受阻滞剂

        }

        //sv_acei_arb
        if (svAceiArb.isChecked()) {
            // 表示选中了acei
        }

    }


}