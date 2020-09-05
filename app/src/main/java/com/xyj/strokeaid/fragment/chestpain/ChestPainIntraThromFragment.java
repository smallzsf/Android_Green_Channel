package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  静脉溶栓
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainIntraThromFragment extends BaseFragment implements View.OnClickListener {


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
    @BindView(R.id.rb_intrac_has)
    RadioButton rbIntracHas;
    @BindView(R.id.rb_intrac_none)
    RadioButton rbIntracNone;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;
    @BindView(R.id.ll_no_suitable)
    LinearLayout llNoSuitable;
    @BindView(R.id.ll_suitable)
    LinearLayout llSuitable;
    @BindView(R.id.edit_spinner_medicine)
    EditSpinner editSpinnerMedicine;
    @BindView(R.id.edit_spinner_dose)
    EditSpinner editSpinnerDose;
    private String mPatientId;
    private String mDocId;

    public ChestPainIntraThromFragment() {

    }

    public static ChestPainIntraThromFragment newInstance(String patientId, String docId) {
        ChestPainIntraThromFragment fragment = new ChestPainIntraThromFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_intrac_throm;
    }

    @Override
    protected void initView(@NonNull View view) {
//        btnGetData.setText("获取数据");
//        btnConfirm.setText("确定");
        loadData();


    }


    private void loadData() {
        List<String> medicineList = new ArrayList<>();
        medicineList.add("第一代");
        editSpinnerMedicine.setItemData(medicineList);

//        esVitalSignAware.setItemData(list);
        //剂量
        List<String> doseList = new ArrayList<>();
        doseList.add("全量");
        editSpinnerDose.setItemData(doseList);

    }


    @Override
    protected void initListener() {

        rbSuitable.setOnClickListener(this);
        rbNoSuitable.setOnClickListener(this);
        rbOtherDepartment.setOnClickListener(this);
        rbIntracHas.setOnClickListener(this);
        rbIntracNone.setOnClickListener(this);
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
        }
    }
}