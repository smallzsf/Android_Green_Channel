package com.xyj.strokeaid.activity.stroke;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: 生命体征
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class VitalSignsActivity extends BaseActivity {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.et_breath_rate_content)
    EditText etBreathRateContent;
    @BindView(R.id.et_pulse_content)
    EditText etPulseContent;
    @BindView(R.id.et_heart_rate_content)
    EditText etHeartRateContent;
    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent;
    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;
    @BindView(R.id.et_blood_oxygen_saturation_content)
    EditText etBloodOxygenSaturationContent;
    @BindView(R.id.et_body_temperature_content)
    EditText etBodyTemperatureContent;
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
    private List<String> list;
    private SharedPreferences sp;


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
        loadData();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            //对uname 和 upswd 的操作
            if (sp.getBoolean("checkboxBoolean", false)) {
                //  esVitalSignAware.setText(sp.getString("esVitalSignAware", null));
                esVitalSignAware.setHint(sp.getString("esVitalSignAware", null));
                esVitalSignAware.clearAnimation();
                etBreathRateContent.setText(sp.getString("etBreathRateContent", null));
                etPulseContent.setText(sp.getString("etPulseContent", null));
                etHeartRateContent.setText(sp.getString("etHeartRateContent", null));
                etSystolicBloodPressureContent.setText(sp.getString("etSystolicBloodPressureContent", null));
                etDiastolicBloodPressureContent.setText(sp.getString("etDiastolicBloodPressureContent", null));
                etBloodOxygenSaturationContent.setText(sp.getString("etBloodOxygenSaturationContent", null));
                etBodyTemperatureContent.setText(sp.getString("etBodyTemperatureContent", null));


            }
        }
    }

    @Override
    public void initListener() {
        titlebar.setLeftLayoutClickListener(v -> finish());
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


    @OnClick({R.id.btn_getdata, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getdata:
                break;
            case R.id.btn_confirm:


                SharedPreferences.Editor editor = sp.edit();


                if (esVitalSignAware.getText() != null) {
                    editor.putString("esVitalSignAware", esVitalSignAware.getText());

                }
                if (etBreathRateContent.getText().toString() != null) {
                    editor.putString("etBreathRateContent", etBreathRateContent.getText().toString());
                }
                if (etPulseContent.getText().toString() != null) {
                    editor.putString("etPulseContent", etPulseContent.getText().toString());
                }
                if (etHeartRateContent.getText().toString() != null) {
                    editor.putString("etHeartRateContent", etPulseContent.getText().toString());
                }
                if (etSystolicBloodPressureContent.getText().toString() != null) {
                    editor.putString("etSystolicBloodPressureContent", etSystolicBloodPressureContent.getText().toString());
                }
                if (etDiastolicBloodPressureContent.getText().toString() != null) {
                    editor.putString("etDiastolicBloodPressureContent", etDiastolicBloodPressureContent.getText().toString());
                }
                if (etBloodOxygenSaturationContent.getText().toString() != null) {
                    editor.putString("etBloodOxygenSaturationContent", etBloodOxygenSaturationContent.getText().toString());
                }
                if (etBodyTemperatureContent.getText().toString() != null) {
                    editor.putString("etBodyTemperatureContent", etBodyTemperatureContent.getText().toString());
                }
                editor.putBoolean("checkboxBoolean", true);
                editor.commit();

                //设置返回数据
                intent.putExtra("position", position);
                setResult(2, intent);
                //关闭Activity
                finish();
                break;
            case R.id.btn_cancel:
                break;
        }
    }
}
