package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 生命体征
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class VitalSignsActivity extends BaseActivity {
    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.awareness)
    TextView awareness;
    @BindView(R.id.single_ill_type_spinner)
    EditSpinner singleIllTypeSpinner;
    @BindView(R.id.breath)
    TextView breath;
    @BindView(R.id.breath_layout)
    LinearLayout breathLayout;
    @BindView(R.id.breath_rate_content)
    EditText breathRateContent;
    @BindView(R.id.unit_times_minute)
    TextView unitTimesMinute;
    @BindView(R.id.pulse)
    TextView pulse;
    @BindView(R.id.pulse_layout)
    LinearLayout pulseLayout;
    @BindView(R.id.pulse_content)
    EditText pulseContent;
    @BindView(R.id.pulse_unit_times_minute)
    TextView pulseUnitTimesMinute;
    @BindView(R.id.heart_rate)
    TextView heartRate;
    @BindView(R.id.heart_rate_layout)
    LinearLayout heartRateLayout;
    @BindView(R.id.heart_rate_content)
    EditText heartRateContent;
    @BindView(R.id.heart_rate_unit_times_minute)
    TextView heartRateUnitTimesMinute;
    @BindView(R.id.systolic_blood_pressure)
    TextView systolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;
    @BindView(R.id.systolic_blood_pressure_content)
    EditText systolicBloodPressureContent;
    @BindView(R.id.systolic_blood_pressure_unit_mm_hg)
    TextView systolicBloodPressureUnitMmHg;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;
    @BindView(R.id.diastolic_blood_pressure_content)
    EditText diastolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure_unit_mm_hg)
    TextView diastolicBloodPressureUnitMmHg;
    @BindView(R.id.blood_oxygen_saturation)
    TextView bloodOxygenSaturation;
    @BindView(R.id.blood_oxygen_saturation_layout)
    LinearLayout bloodOxygenSaturationLayout;
    @BindView(R.id.blood_oxygen_saturation_content)
    EditText bloodOxygenSaturationContent;
    @BindView(R.id.blood_oxygen_saturation_unit_percent)
    TextView bloodOxygenSaturationUnitPercent;
    @BindView(R.id.body_temperature)
    TextView bodyTemperature;
    @BindView(R.id.body_temperature_layout)
    LinearLayout bodyTemperatureLayout;
    @BindView(R.id.body_temperature_content)
    EditText bodyTemperatureContent;
    @BindView(R.id.body_temperature_unit_celsius)
    TextView bodyTemperatureUnitCelsius;
    @BindView(R.id.btn_getdata)
    AppCompatButton btnGetdata;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private TimePickerDialog mDialogAll;
    private int position;
    private Bundle bundle;
    private Intent intent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_vital_sign;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

        intent = getIntent();
        bundle = intent.getExtras();
        ArrayList<String> list = ((ArrayList<String>) bundle.getSerializable("arrayList"));
        position = bundle.getInt("position", 0);
        titlebar.setTitle(list.get(position));



    }

    @Override
    public void initListener() {

    }


}
