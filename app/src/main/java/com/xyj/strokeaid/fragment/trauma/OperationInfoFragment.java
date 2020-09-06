package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class OperationInfoFragment extends BaseFragment {


    @BindView(R.id.tv_preoperative_awareness)
    TextView tvPreoperativeAwareness;
    @BindView(R.id.es_preoperative_vital_sign_aware)
    EditSpinner esPreoperativeVitalSignAware;
    @BindView(R.id.tv_preoperative_breath)
    TextView tvPreoperativeBreath;
    @BindView(R.id.ll_preoperative_breath_layout)
    LinearLayout llPreoperativeBreathLayout;
    @BindView(R.id.et_preoperative_breath_rate_content)
    EditText etPreoperativeBreathRateContent;
    @BindView(R.id.tv_preoperative_unit_times_minute)
    TextView tvPreoperativeUnitTimesMinute;
    @BindView(R.id.tv_preoperative_pulse)
    TextView tvPreoperativePulse;
    @BindView(R.id.ll_preoperative_pulse_layout)
    LinearLayout llPreoperativePulseLayout;
    @BindView(R.id.et_preoperative_pulse_content)
    EditText etPreoperativePulseContent;
    @BindView(R.id.tv_preoperative_pulse_unit_times_minute)
    TextView tvPreoperativePulseUnitTimesMinute;
    @BindView(R.id.tv_preoperative_heart_rate)
    TextView tvPreoperativeHeartRate;
    @BindView(R.id.ll_preoperative_heart_rate_layout)
    LinearLayout llPreoperativeHeartRateLayout;
    @BindView(R.id.et_preoperative_heart_rate_content)
    EditText etPreoperativeHeartRateContent;
    @BindView(R.id.tv_preoperative_heart_rate_unit_times_minute)
    TextView tvPreoperativeHeartRateUnitTimesMinute;
    @BindView(R.id.tv_preoperative_systolic_blood_pressure)
    TextView tvPreoperativeSystolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;
    @BindView(R.id.et_preoperative_systolic_blood_pressure_content)
    EditText etPreoperativeSystolicBloodPressureContent;
    @BindView(R.id.tv_preoperative_systolic_blood_pressure_unit_mm_hg)
    TextView tvPreoperativeSystolicBloodPressureUnitMmHg;
    @BindView(R.id.tv_preoperative_diastolic_blood_pressure)
    TextView tvPreoperativeDiastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;
    @BindView(R.id.et_preoperative_diastolic_blood_pressure_content)
    EditText etPreoperativeDiastolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure_unit_mm_hg)
    TextView diastolicBloodPressureUnitMmHg;
    @BindView(R.id.tv_preoperative_blood_oxygen_saturation)
    TextView tvPreoperativeBloodOxygenSaturation;
    @BindView(R.id.blood_oxygen_saturation_layout)
    LinearLayout bloodOxygenSaturationLayout;
    @BindView(R.id.et_preoperative_blood_oxygen_saturation_content)
    EditText etPreoperativeBloodOxygenSaturationContent;
    @BindView(R.id.blood_oxygen_saturation_unit_percent)
    TextView bloodOxygenSaturationUnitPercent;
    @BindView(R.id.tv_preoperative_body_temperature)
    TextView tvPreoperativeBodyTemperature;
    @BindView(R.id.body_temperature_layout)
    LinearLayout bodyTemperatureLayout;
    @BindView(R.id.et_preoperative_body_temperature_content)
    EditText etPreoperativeBodyTemperatureContent;
    @BindView(R.id.tv_preoperative_body_temperature_unit_celsius)
    TextView tvPreoperativeBodyTemperatureUnitCelsius;
    @BindView(R.id.tv_note)
    TextView tvNote;
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
    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent;
    @BindView(R.id.systolic_blood_pressure_unit_mm_hg)
    TextView systolicBloodPressureUnitMmHg;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;
    @BindView(R.id.blood_oxygen_saturation)
    TextView bloodOxygenSaturation;
    @BindView(R.id.et_blood_oxygen_saturation_content)
    EditText etBloodOxygenSaturationContent;
    @BindView(R.id.body_temperature)
    TextView bodyTemperature;
    @BindView(R.id.et_body_temperature_content)
    EditText etBodyTemperatureContent;
    @BindView(R.id.body_temperature_unit_celsius)
    TextView bodyTemperatureUnitCelsius;
    @BindView(R.id.btn_start_frag_sg)
    AppCompatButton btnStartFragSg;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;
    private String mPatientId;
    private String mDocId;


    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_simple_respirator;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();


    public OperationInfoFragment() {

    }

    public static OperationInfoFragment newInstance(String patientId, String docId) {
        OperationInfoFragment fragment = new OperationInfoFragment();
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
        return R.layout.fragment_trauma_operation_info;
    }

    @Override
    protected void initView(@NonNull View view) {


        loadData();


    }

    private void loadData() {
        List<String> list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
        esPreoperativeVitalSignAware.setItemData(list);
        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {

    }

}