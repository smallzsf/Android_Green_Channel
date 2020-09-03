package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
 * description:  血液检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainBloodTestFragment extends BaseFragment {


    @BindView(R.id.awareness)
    TextView awareness;
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.breath)
    TextView breath;
    @BindView(R.id.breath_layout)
    LinearLayout breathLayout;
    @BindView(R.id.et_breath_rate_content)
    EditText etBreathRateContent;
    @BindView(R.id.unit_times_minute)
    TextView unitTimesMinute;
    @BindView(R.id.pulse)
    TextView pulse;
    @BindView(R.id.pulse_layout)
    LinearLayout pulseLayout;
    @BindView(R.id.et_pulse_content)
    EditText etPulseContent;
    @BindView(R.id.pulse_unit_times_minute)
    TextView pulseUnitTimesMinute;
    @BindView(R.id.heart_rate)
    TextView heartRate;
    @BindView(R.id.heart_rate_layout)
    LinearLayout heartRateLayout;
    @BindView(R.id.et_heart_rate_content)
    EditText etHeartRateContent;
    @BindView(R.id.heart_rate_unit_times_minute)
    TextView heartRateUnitTimesMinute;
    @BindView(R.id.systolic_blood_pressure)
    TextView systolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;
    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent;
    @BindView(R.id.systolic_blood_pressure_unit_mm_hg)
    TextView systolicBloodPressureUnitMmHg;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;
    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure_unit_mm_hg)
    TextView diastolicBloodPressureUnitMmHg;
    @BindView(R.id.blood_oxygen_saturation)
    TextView bloodOxygenSaturation;
    @BindView(R.id.blood_oxygen_saturation_layout)
    LinearLayout bloodOxygenSaturationLayout;
    @BindView(R.id.et_blood_oxygen_saturation_content)
    EditText etBloodOxygenSaturationContent;
    @BindView(R.id.blood_oxygen_saturation_unit_percent)
    TextView bloodOxygenSaturationUnitPercent;
    @BindView(R.id.body_temperature)
    TextView bodyTemperature;
    @BindView(R.id.body_temperature_layout)
    LinearLayout bodyTemperatureLayout;
    @BindView(R.id.et_body_temperature_content)
    EditText etBodyTemperatureContent;
    @BindView(R.id.body_temperature_unit_celsius)
    TextView bodyTemperatureUnitCelsius;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    private String mPatientId;
    private String mDocId;
    private List<String> list;

    public ChestPainBloodTestFragment() {

    }

    public static ChestPainBloodTestFragment newInstance(String patientId, String docId) {
        ChestPainBloodTestFragment fragment = new ChestPainBloodTestFragment();
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
        return R.layout.fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取数据");
        btnConfirm.setText("确定");
        loadData();


    }


    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {

    }

}