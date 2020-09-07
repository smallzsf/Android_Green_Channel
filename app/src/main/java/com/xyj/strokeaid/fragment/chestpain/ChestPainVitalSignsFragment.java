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

import java.util.Arrays;

import butterknife.BindView;

/**
 * VitalSignsFragment
 * description: 生命体征
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainVitalSignsFragment extends BaseFragment {


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

    private String mRecordId;

    public ChestPainVitalSignsFragment() {

    }

    public static ChestPainVitalSignsFragment newInstance(String recordId) {
        ChestPainVitalSignsFragment fragment = new ChestPainVitalSignsFragment();
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
        return R.layout.fragment_vital_signs;
    }

    @Override
    protected void initView(@NonNull View view) {
        esVitalSignAware.setItemData(Arrays.asList(getResources().getStringArray(R.array.chest_pain_state_of_consciousness)));

    }

    @Override
    protected void initListener() {

    }

}