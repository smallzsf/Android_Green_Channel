package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
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


    @BindView(R.id.rb_taboo_has)
    RadioButton rbTabooHas;
    @BindView(R.id.rb_taboo_none)
    RadioButton rbTabooNone;
    @BindView(R.id.ll_no_suitable)
    LinearLayout llNoSuitable;
    @BindView(R.id.edit_spinner_amoxicillin)
    EditSpinner editSpinnerAmoxicillin;
    @BindView(R.id.edit_spinner_clopidogrel)
    EditSpinner editSpinnerClopidogrel;
    @BindView(R.id.edit_spinner_ticagrelor)
    EditSpinner editSpinnerTicagrelor;
    @BindView(R.id.ll_antihemotherapy_data)
    LinearLayout llAntihemotherapyData;
    @BindView(R.id.ll_antihemotherapy_title)
    LinearLayout llAntihemotherapyTitle;
    @BindView(R.id.ll_preoperative_anticoagulation_title)
    LinearLayout llPreoperativeAnticoagulationTitle;
    @BindView(R.id.rb_preoperative_has)
    RadioButton rbPreoperativeHas;
    @BindView(R.id.rb_preoperative_none)
    RadioButton rbPreoperativeNone;
    @BindView(R.id.eds_preoperative_anticoagulation)
    EditSpinner edsPreoperativeAnticoagulation;
    @BindView(R.id.ll_preoperative_anticoagulation_data)
    LinearLayout llPreoperativeAnticoagulationData;
    @BindView(R.id.ll_statin_therapy_title)
    LinearLayout llStatinTherapyTitle;
    @BindView(R.id.rb_statin_has)
    RadioButton rbStatinHas;
    @BindView(R.id.rb_statin_none)
    RadioButton rbStatinNone;
    @BindView(R.id.eds_statin_therapy)
    EditSpinner edsStatinTherapy;
    @BindView(R.id.ll_statin_therapy_data)
    LinearLayout llStatinTherapyData;
    @BindView(R.id.ll_beta_blockers_title)
    LinearLayout llBetaBlockersTitle;
    @BindView(R.id.rb_block_has)
    RadioButton rbBlockHas;
    @BindView(R.id.rb_block_none)
    RadioButton rbBlockNone;
    @BindView(R.id.eds_beta_blockers)
    EditSpinner edsBetaBlockers;
    @BindView(R.id.ll_beta_blockers_data)
    LinearLayout llBetaBlockersData;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;
    @BindView(R.id.sv_antihemotherapy)
    SwitchCompat svAntihemotherapy;
    @BindView(R.id.sv_preoperative_anticoagulation)
    SwitchCompat svPreoperativeAnticoagulation;
    @BindView(R.id.sv_statin_therapy)
    SwitchCompat svStatinTherapy;
    @BindView(R.id.sv_beta_blockers)
    SwitchCompat svBetaBlockers;

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
        loadData();
    }


    private void loadData() {
        List<String> list = new ArrayList<>();
        list.add("0mg");
        list.add("100mg");
        list.add("300mg");
        list.add("其他剂量");
        editSpinnerAmoxicillin.setItemData(list);
        editSpinnerClopidogrel.setItemData(list);
        editSpinnerTicagrelor.setItemData(list);


        List<String> administrationDataList = new ArrayList<>();
        administrationDataList.add("药品类型");
        edsPreoperativeAnticoagulation.setItemData(administrationDataList);
        edsStatinTherapy.setItemData(administrationDataList);
        edsBetaBlockers.setItemData(administrationDataList);
    }


    @Override
    protected void initListener() {
 /*       llBetaBlockersTitle.setOnClickListener(this);
        llAntihemotherapyTitle.setOnClickListener(this);
        llStatinTherapyTitle.setOnClickListener(this);
        llPreoperativeAnticoagulationTitle.setOnClickListener(this);*/
        svAntihemotherapy.setOnClickListener(this);
        svPreoperativeAnticoagulation.setOnClickListener(this);
        svStatinTherapy.setOnClickListener(this);
        svBetaBlockers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
                refrashItemVis(llBetaBlockersData, svBetaBlockers);
                break;
        }
    }

    private void refrashItemVis(View view, SwitchCompat switchCompat) {
       /* if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.ic_arrow_up_blue);
        } else {
            view.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_arrow_down_blue);
        }*/
        if (switchCompat.isChecked()) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}