package com.xyj.strokeaid.fragment.common;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.GetVitalSignsBean;
import com.xyj.strokeaid.bean.RequestGetVitalSigns;
import com.xyj.strokeaid.bean.RequestGetVitalSignsBean;
import com.xyj.strokeaid.bean.SendAddVitalSignsDataBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

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
public class VitalSignsFragment extends BaseFragment {


    @BindView(R.id.es_conscious_state)
    EditSpinner esConsciousState;
    @BindView(R.id.ieb_breath)
    ItemEditBar iebBreath;
    @BindView(R.id.ieb_pulse)
    ItemEditBar iebPulse;
    @BindView(R.id.ieb_heart_rate)
    ItemEditBar iebHeartRate;
    @BindView(R.id.ieb_high_pressure)
    ItemEditBar iebHighPressure;
    @BindView(R.id.ieb_low_pressure)
    ItemEditBar iebLowPressure;
    @BindView(R.id.ieb_spo2)
    ItemEditBar iebSpo2;
    @BindView(R.id.ieb_temperature)
    ItemEditBar iebTemperature;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;

    private String mRecordId;
    private int mDiseaseViewType;

    public static VitalSignsFragment newInstance(String recordId, int diseaseViewType) {
        VitalSignsFragment fragment = new VitalSignsFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        args.putInt(IntentKey.DISEASE_VIEW_TYPE, diseaseViewType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
            mDiseaseViewType = getArguments().getInt(IntentKey.DISEASE_VIEW_TYPE, 1);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vital_signs;
    }

    @Override
    protected void initView(@NonNull View view) {
        esConsciousState.setStringArrayId(R.array.stroke_state_of_consciousness);

        loadData();
    }


    private void loadData() {
        getVitalSigns(mRecordId);
    }


    @Override
    protected void initListener() {

        btnGetData.setOnClickListener(v -> {
            getVitalSigns(mRecordId);
        });
        btnConfirm.setOnClickListener(v -> {
            SendAddVitalSignsDataBean sendAddVitalSignsDataBean = new SendAddVitalSignsDataBean();
            sendAddVitalSignsDataBean.setRecordId("1111");
            sendAddVitalSignsDataBean.setConsciousness(esConsciousState.getSelectData()[0]);
            sendAddVitalSignsDataBean.setBloodpressure(iebLowPressure.getEditContent());
            sendAddVitalSignsDataBean.setBreathrate(iebBreath.getEditContent());
            sendAddVitalSignsDataBean.setHeartrate(iebHeartRate.getEditContent());
            sendAddVitalSignsDataBean.setPulserate(iebPulse.getEditContent());
            sendAddVitalSignsDataBean.setRightbloodpressure(iebHighPressure.getEditContent());
            sendAddVitalSignsDataBean.setTemperature(iebTemperature.getEditContent());
            sendAddVitalSignsDataBean.setPercentageofoxygensaturation(iebSpo2.getEditContent());
            editVitalSigns(sendAddVitalSignsDataBean);
        });
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
                                    esConsciousState.setStringArrayNormalKey(requestGetVitalSigns.getConsciousness());
                                    iebBreath.setEditContent(requestGetVitalSigns.getBreathrate());
                                    iebPulse.setEditContent(requestGetVitalSigns.getPulserate());
                                    iebHeartRate.setEditContent(requestGetVitalSigns.getHeartrate());
                                    iebLowPressure.setEditContent(requestGetVitalSigns.getBloodpressure());
                                    iebHighPressure.setEditContent(requestGetVitalSigns.getRightbloodpressure());
                                    iebSpo2.setEditContent(requestGetVitalSigns.getPercentageofoxygensaturation());
                                    iebTemperature.setEditContent(requestGetVitalSigns.getTemperature());
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