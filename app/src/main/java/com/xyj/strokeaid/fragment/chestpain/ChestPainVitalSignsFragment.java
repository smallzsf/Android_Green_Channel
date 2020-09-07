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
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ChangePasswordPostBean;
import com.xyj.strokeaid.bean.GetVitalSignsBean;
import com.xyj.strokeaid.bean.RequestGetVitalSigns;
import com.xyj.strokeaid.bean.RequestGetVitalSignsBean;
import com.xyj.strokeaid.bean.SendAddVitalSignsDataBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
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
    EditSpinner esVitalSignAware; //意识

    @BindView(R.id.breath)
    TextView breath;

    @BindView(R.id.breath_layout)
    LinearLayout breathLayout;

    @BindView(R.id.et_breath_rate_content)
    EditText etBreathRateContent; //呼吸

    @BindView(R.id.unit_times_minute)
    TextView unitTimesMinute;

    @BindView(R.id.pulse)
    TextView pulse;

    @BindView(R.id.pulse_layout)
    LinearLayout pulseLayout;

    @BindView(R.id.et_pulse_content)
    EditText etPulseContent; //脉搏

    @BindView(R.id.pulse_unit_times_minute)
    TextView pulseUnitTimesMinute;
    @BindView(R.id.heart_rate)
    TextView heartRate;
    @BindView(R.id.heart_rate_layout)
    LinearLayout heartRateLayout;

    @BindView(R.id.et_heart_rate_content)
    EditText etHeartRateContent;//心率

    @BindView(R.id.heart_rate_unit_times_minute)
    TextView heartRateUnitTimesMinute;
    @BindView(R.id.systolic_blood_pressure)
    TextView systolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;

    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent; //收缩压

    @BindView(R.id.systolic_blood_pressure_unit_mm_hg)
    TextView systolicBloodPressureUnitMmHg;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;

    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;//舒张压

    @BindView(R.id.diastolic_blood_pressure_unit_mm_hg)
    TextView diastolicBloodPressureUnitMmHg;
    @BindView(R.id.blood_oxygen_saturation)
    TextView bloodOxygenSaturation;
    @BindView(R.id.blood_oxygen_saturation_layout)
    LinearLayout bloodOxygenSaturationLayout;

    @BindView(R.id.et_blood_oxygen_saturation_content)
    EditText etBloodOxygenSaturationContent;//血氧饱和度

    @BindView(R.id.blood_oxygen_saturation_unit_percent)
    TextView bloodOxygenSaturationUnitPercent;
    @BindView(R.id.body_temperature)
    TextView bodyTemperature;
    @BindView(R.id.body_temperature_layout)
    LinearLayout bodyTemperatureLayout;

    @BindView(R.id.et_body_temperature_content)
    EditText etBodyTemperatureContent;//体温
    @BindView(R.id.body_temperature_unit_celsius)
    TextView bodyTemperatureUnitCelsius;
    @BindView(R.id.btn_get_data)

    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    private String mPatientId;
    private String mDocId;
    private List<String> list;

    public ChestPainVitalSignsFragment() {

    }

    public static ChestPainVitalSignsFragment newInstance(String patientId, String docId) {
        ChestPainVitalSignsFragment fragment = new ChestPainVitalSignsFragment();
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
        return R.layout.fragment_vital_signs;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取数据");
        btnConfirm.setText("保存");
        btnGetData.setOnClickListener(v -> {
            getVitalSigns("1111");
        });
        btnConfirm.setOnClickListener(v -> {
            SendAddVitalSignsDataBean sendAddVitalSignsDataBean = new SendAddVitalSignsDataBean();
            sendAddVitalSignsDataBean.setRecordId("1111");
            sendAddVitalSignsDataBean.setConsciousness( esVitalSignAware.getText());
            sendAddVitalSignsDataBean.setBloodpressure(etSystolicBloodPressureContent.getText().toString());
            sendAddVitalSignsDataBean.setBreathrate(etBreathRateContent.getText().toString());
            sendAddVitalSignsDataBean.setHeartrate(etHeartRateContent.getText().toString());
            sendAddVitalSignsDataBean.setPulserate(etPulseContent.getText().toString());
            sendAddVitalSignsDataBean.setRightbloodpressure(etDiastolicBloodPressureContent.getText().toString());
            sendAddVitalSignsDataBean.setTemperature(etBodyTemperatureContent.getText().toString());
            sendAddVitalSignsDataBean.setPercentageofoxygensaturation(etBloodOxygenSaturationContent.getText().toString());
            editVitalSigns(sendAddVitalSignsDataBean);
        });
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
        getVitalSigns("1111");
    }


    @Override
    protected void initListener() {

    }


    /**
     * 生命体征查询
     */
    private void getVitalSigns(String id) {
        GetVitalSignsBean getVitalSignsBean = new GetVitalSignsBean();
        getVitalSignsBean.setRecordId(id);
        String request = GsonUtils.getGson().toJson(getVitalSignsBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getVitalSigns(requestBody)
                .enqueue(new Callback<RequestGetVitalSignsBean>() {
                    @Override
                    public void onResponse(Call<RequestGetVitalSignsBean> call, Response<RequestGetVitalSignsBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                RequestGetVitalSigns requestGetVitalSigns = response.body().getData();
                                if (requestGetVitalSigns != null) {
                                    esVitalSignAware.setText(requestGetVitalSigns.getConsciousness());
                                    etBreathRateContent.setText(requestGetVitalSigns.getBreathrate());
                                    etPulseContent.setText(requestGetVitalSigns.getPulserate());
                                    etHeartRateContent.setText(requestGetVitalSigns.getHeartrate());
                                    etSystolicBloodPressureContent.setText(requestGetVitalSigns.getBloodpressure());
                                    etDiastolicBloodPressureContent.setText(requestGetVitalSigns.getRightbloodpressure());
                                    etBloodOxygenSaturationContent.setText(requestGetVitalSigns.getPercentageofoxygensaturation());
                                    etBodyTemperatureContent.setText(requestGetVitalSigns.getTemperature());
                                }
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestGetVitalSignsBean> call, Throwable t) {

                    }
                });
    }

    /**
     * 生命体征编辑
     */
    private void editVitalSigns(SendAddVitalSignsDataBean sendAddVitalSignsDataBean) {
        String request = GsonUtils.getGson().toJson(sendAddVitalSignsDataBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .editVitalSigns(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存成功");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }

}