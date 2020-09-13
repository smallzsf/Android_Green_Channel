package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.DiagnosticEvaluationBean;
import com.xyj.strokeaid.bean.trauma.TraumaOperationInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 手术信息
 *
 * @author Licy
 */
public class TraumaOperationInfoFragment extends BaseStrokeFragment {

    @BindView(R.id.ttb_arrive_time)
    TextTimeBar ttbArriveTime;
    @BindView(R.id.ttb_leave_time)
    TextTimeBar ttbLeaveTime;
    @BindView(R.id.es_pre_conscious_state)
    EditSpinner esPreConsciousState;
    @BindView(R.id.ieb_pre_breath)
    ItemEditBar iebPreBreath;
    @BindView(R.id.ieb_pre_pulse)
    ItemEditBar iebPrePulse;
    @BindView(R.id.ieb_pre_heart_rate)
    ItemEditBar iebPreHeartRate;
    @BindView(R.id.ieb_pre_high_pressure)
    ItemEditBar iebPreHighPressure;
    @BindView(R.id.ieb_pre_low_pressure)
    ItemEditBar iebPreLowPressure;
    @BindView(R.id.ieb_pre_spo2)
    ItemEditBar iebPreSpo2;
    @BindView(R.id.ieb_pre_temperature)
    ItemEditBar iebPreTemperature;
    @BindView(R.id.es_after_conscious_state)
    EditSpinner esAfterConsciousState;
    @BindView(R.id.ieb_after_breath)
    ItemEditBar iebAfterBreath;
    @BindView(R.id.ieb_after_pulse)
    ItemEditBar iebAfterPulse;
    @BindView(R.id.ieb_after_heart_rate)
    ItemEditBar iebAfterHeartRate;
    @BindView(R.id.ieb_after_high_pressure)
    ItemEditBar iebAfterHighPressure;
    @BindView(R.id.ieb_after_low_pressure)
    ItemEditBar iebAfterLowPressure;
    @BindView(R.id.ieb_after_spo2)
    ItemEditBar iebAfterSpo2;
    @BindView(R.id.ieb_after_temperature)
    ItemEditBar iebAfterTemperature;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.ttb_mzkssj)
    TextTimeBar ttbMzkssj;
    @BindView(R.id.ttb_mzjssj)
    TextTimeBar ttbMzjssj;
    @BindView(R.id.ttb_sskssj)
    TextTimeBar ttbSskssj;
    @BindView(R.id.ttb_ssjssj)
    TextTimeBar ttbSsjssj;
    @BindView(R.id.ttb_sdsj)
    TextTimeBar ttbSdsj;
    @BindView(R.id.ieb_cxl)
    ItemEditBar iebCxl;
    @BindView(R.id.ieb_nl)
    ItemEditBar iebNl;
    @BindView(R.id.ieb_jty)
    ItemEditBar iebJty;
    @BindView(R.id.ieb_jiaoty)
    ItemEditBar iebJiaoty;
    @BindView(R.id.ieb_RBC)
    ItemEditBar iebRBC;
    @BindView(R.id.ieb_xj)
    ItemEditBar iebXj;
    @BindView(R.id.ieb_lcd)
    ItemEditBar iebLcd;
    @BindView(R.id.ieb_xxb)
    ItemEditBar iebXxb;

    TraumaOperationInfoBean bean = new TraumaOperationInfoBean();

    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_simple_respirator;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();

    public static TraumaOperationInfoFragment newInstance(String recordId) {
        TraumaOperationInfoFragment fragment = new TraumaOperationInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_operation_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
        queryData();
    }

    private void queryData() {
        BaseRequestBean<TraumaOperationInfoBean> requestBean = new BaseRequestBean<>(
                mRecordId, 3, new TraumaOperationInfoBean());
        RetrofitClient
                .getInstance()
                .getApi()
                .getTraumaOperationInfo(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseResponseBean<TraumaOperationInfoBean>>() {

                    @Override
                    public void onResponse(Call<BaseResponseBean<TraumaOperationInfoBean>> call, Response<BaseResponseBean<TraumaOperationInfoBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                bean = response.body().getData().getData();
                                dataToView(bean);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseResponseBean<TraumaOperationInfoBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }

    private void dataToView(TraumaOperationInfoBean bean) {
        String beforeoperationvitalsigns = bean.getBeforeoperationvitalsigns();
        if (!TextUtils.isEmpty(beforeoperationvitalsigns)){
            if (beforeoperationvitalsigns.equals("1")){
                esPreConsciousState.setText("清醒");
            }else if (beforeoperationvitalsigns.equals("2")){
                esPreConsciousState.setText("模糊");
            }else if (beforeoperationvitalsigns.equals("3")){
                esPreConsciousState.setText("嗜睡");
            }else if (beforeoperationvitalsigns.equals("4")){
                esPreConsciousState.setText("昏睡");
            }else if (beforeoperationvitalsigns.equals("5")){
                esPreConsciousState.setText("浅昏迷");
            }else if (beforeoperationvitalsigns.equals("6")){
                esPreConsciousState.setText("中昏迷");
            }else if (beforeoperationvitalsigns.equals("7")){
                esPreConsciousState.setText("深昏迷");
            }
        }

        String operationpatientarrivaltime = bean.getOperationpatientarrivaltime();
        if (!TextUtils.isEmpty(operationpatientarrivaltime)){
            ttbArriveTime.setTime(operationpatientarrivaltime);
        }
        String beforeoperationbreathe = bean.getBeforeoperationbreathe();
        if (!TextUtils.isEmpty(beforeoperationbreathe)){
            iebPreBreath.setEditContent(beforeoperationbreathe);
        }
        String beforeoperationsphygmus = bean.getBeforeoperationsphygmus();
        if (!TextUtils.isEmpty(beforeoperationsphygmus)){
            iebPrePulse.setEditContent(beforeoperationsphygmus);
        }
        String beforeoperationheartrate = bean.getBeforeoperationheartrate();
        if (!TextUtils.isEmpty(beforeoperationheartrate)){
            iebPreHeartRate.setEditContent(beforeoperationheartrate);
        }
        String beforeoperationsystolicpressure = bean.getBeforeoperationsystolicpressure();
        if (!TextUtils.isEmpty(beforeoperationsystolicpressure)){
            iebPreHighPressure.setEditContent(beforeoperationsystolicpressure);
        }
        String beforeoperationdiastolicpressure = bean.getBeforeoperationdiastolicpressure();
        if (!TextUtils.isEmpty(beforeoperationdiastolicpressure)){
            iebPreLowPressure.setEditContent(beforeoperationdiastolicpressure);
        }
        String beforeoperationoxyhemoglobinsaturation = bean.getBeforeoperationoxyhemoglobinsaturation();
        if (!TextUtils.isEmpty(beforeoperationoxyhemoglobinsaturation)){
            iebPreSpo2.setEditContent(beforeoperationoxyhemoglobinsaturation);
        }
        String beforeoperationanimalheat = bean.getBeforeoperationanimalheat();
        if (!TextUtils.isEmpty(beforeoperationanimalheat)){
            iebPreTemperature.setEditContent(beforeoperationanimalheat);
        }
        String operationanesthesiabegintime = bean.getOperationanesthesiabegintime();
        if (!TextUtils.isEmpty(operationanesthesiabegintime)){
            ttbMzkssj.setTime(operationanesthesiabegintime);
        }
        String operationanesthesiaendtime = bean.getOperationanesthesiaendtime();
        if (!TextUtils.isEmpty(operationanesthesiaendtime)){
            ttbMzjssj.setTime(operationanesthesiaendtime);
        }
        String operationbegintime = bean.getOperationbegintime();
        if (!TextUtils.isEmpty(operationbegintime)){
            ttbSskssj.setTime(operationbegintime);
        }
        String operationendtime = bean.getOperationendtime();
        if (!TextUtils.isEmpty(operationendtime)){
            ttbSsjssj.setTime(operationendtime);
        }
        String operationdeliverytime = bean.getOperationdeliverytime();
        if (!TextUtils.isEmpty(operationdeliverytime)){
            ttbSdsj.setTime(operationdeliverytime);
        }
        String operationamountbleeding = bean.getOperationamountbleeding();
        if (!TextUtils.isEmpty(operationamountbleeding)){
            iebCxl.setEditContent(operationdeliverytime);
        }
        String operationurinevolume = bean.getOperationurinevolume();
        if (!TextUtils.isEmpty(operationurinevolume)){
            iebNl.setEditContent(operationurinevolume);
        }
        String operationcrystalloidsolution = bean.getOperationcrystalloidsolution();
        if (!TextUtils.isEmpty(operationcrystalloidsolution)){
            iebJty.setEditContent(operationcrystalloidsolution);
        }
        String operationcolloidalsolution = bean.getOperationcolloidalsolution();
        if (!TextUtils.isEmpty(operationcolloidalsolution)){
            iebJiaoty.setEditContent(operationcolloidalsolution);
        }
        String operationrbc = bean.getOperationrbc();
        if (!TextUtils.isEmpty(operationrbc)){
            iebRBC.setEditContent(operationrbc);
        }
        String operationadtevak = bean.getOperationadtevak();
        if (!TextUtils.isEmpty(operationadtevak)){
            iebXj.setEditContent(operationadtevak);
        }
        String operationcryoprecipitate = bean.getOperationcryoprecipitate();
        if (!TextUtils.isEmpty(operationcryoprecipitate)){
            iebLcd.setEditContent(operationcryoprecipitate);
        }
        String operationsoterocyte = bean.getOperationsoterocyte();
        if (!TextUtils.isEmpty(operationsoterocyte)){
            iebLcd.setEditContent(operationsoterocyte);
        }
        String afteroperationvitalsigns = bean.getAfteroperationvitalsigns();
        if (!TextUtils.isEmpty(afteroperationvitalsigns)){
            if (afteroperationvitalsigns.equals("1")){
                esAfterConsciousState.setText("清醒");
            }else if (afteroperationvitalsigns.equals("2")){
                esAfterConsciousState.setText("模糊");
            }else if (afteroperationvitalsigns.equals("3")){
                esAfterConsciousState.setText("嗜睡");
            }else if (afteroperationvitalsigns.equals("4")){
                esAfterConsciousState.setText("昏睡");
            }else if (afteroperationvitalsigns.equals("5")){
                esAfterConsciousState.setText("浅昏迷");
            }else if (afteroperationvitalsigns.equals("6")){
                esAfterConsciousState.setText("中昏迷");
            }else if (afteroperationvitalsigns.equals("7")){
                esAfterConsciousState.setText("深昏迷");
            }
        }
        String afteroperationbreathe = bean.getAfteroperationbreathe();
        if (!TextUtils.isEmpty(afteroperationbreathe)){
            iebAfterBreath.setEditContent(afteroperationbreathe);
        }
        String afteroperationsphygmus = bean.getAfteroperationsphygmus();
        if (!TextUtils.isEmpty(afteroperationsphygmus)){
            iebAfterPulse.setEditContent(afteroperationsphygmus);
        }
        String afteroperationheartrate = bean.getAfteroperationheartrate();
        if (!TextUtils.isEmpty(afteroperationheartrate)){
            iebAfterHeartRate.setEditContent(afteroperationheartrate);
        }
        String afteroperationdiastolicpressure = bean.getAfteroperationdiastolicpressure();
        if (!TextUtils.isEmpty(afteroperationdiastolicpressure)){
            iebAfterLowPressure.setEditContent(afteroperationdiastolicpressure);
        }
        String afteroperationoxyhemoglobinsaturation = bean.getAfteroperationoxyhemoglobinsaturation();
        if (!TextUtils.isEmpty(afteroperationoxyhemoglobinsaturation)){
            iebAfterSpo2.setEditContent(afteroperationoxyhemoglobinsaturation);
        }
        String afteroperationanimalheat = bean.getAfteroperationanimalheat();
        if (!TextUtils.isEmpty(afteroperationanimalheat)){
            iebAfterTemperature.setEditContent(afteroperationanimalheat);
        }
        String operationpatientleavetime = bean.getOperationpatientleavetime();
        if (!TextUtils.isEmpty(operationpatientleavetime)){
            ttbLeaveTime.setTime(operationpatientleavetime);
        }
        String afteroperationsystolicpressure = bean.getAfteroperationsystolicpressure();
        if (!TextUtils.isEmpty(afteroperationsystolicpressure)){
            iebAfterHighPressure.setEditContent(afteroperationsystolicpressure);
        }

    }

    private void loadData() {
        esPreConsciousState.setStringArrayId(R.array.beforeoperationvitalsigns);
        esAfterConsciousState.setStringArrayId(R.array.afteroperationvitalsigns);
    }


    @Override
    protected void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        bean.setBeforeoperationvitalsigns(esPreConsciousState.getSelectData()[1]);
        bean.setOperationpatientarrivaltime(ttbArriveTime.getTime());
        bean.setBeforeoperationbreathe(iebPreBreath.getEditContent());
        bean.setBeforeoperationsphygmus(iebPrePulse.getEditContent());
        bean.setBeforeoperationheartrate(iebPreHeartRate.getEditContent());
        bean.setBeforeoperationsystolicpressure(iebPreHighPressure.getEditContent());
        bean.setBeforeoperationdiastolicpressure(iebPreLowPressure.getEditContent());
        bean.setBeforeoperationoxyhemoglobinsaturation(iebPreSpo2.getEditContent());
        bean.setBeforeoperationanimalheat(iebPreTemperature.getEditContent());
        bean.setOperationanesthesiabegintime(ttbMzkssj.getTime());
        bean.setOperationanesthesiaendtime(ttbMzjssj.getTime());
        bean.setOperationbegintime(ttbSskssj.getTime());
        bean.setOperationendtime(ttbSsjssj.getTime());
        bean.setOperationdeliverytime(ttbSdsj.getTime());
        bean.setOperationamountbleeding(iebCxl.getEditContent());
        bean.setOperationurinevolume(iebNl.getEditContent());
        bean.setOperationcrystalloidsolution(iebJty.getEditContent());
        bean.setOperationcolloidalsolution(iebJiaoty.getEditContent());
        bean.setOperationrbc(iebRBC.getEditContent());
        bean.setOperationadtevak(iebXj.getEditContent());
        bean.setOperationcryoprecipitate(iebLcd.getEditContent());
        bean.setOperationsoterocyte(iebXxb.getEditContent());
        bean.setAfteroperationvitalsigns(esAfterConsciousState.getSelectData()[1]);
        bean.setAfteroperationbreathe(iebAfterBreath.getEditContent());
        bean.setAfteroperationsphygmus(iebAfterPulse.getEditContent());
        bean.setAfteroperationheartrate(iebAfterHeartRate.getEditContent());
        bean.setAfteroperationsystolicpressure(iebAfterHighPressure.getEditContent());
        bean.setAfteroperationdiastolicpressure(iebAfterLowPressure.getEditContent());
        bean.setAfteroperationoxyhemoglobinsaturation(iebAfterSpo2.getEditContent());
        bean.setAfteroperationanimalheat(iebAfterTemperature.getEditContent());
        bean.setOperationpatientleavetime(ttbLeaveTime.getTime());
        saveData(bean);
    }

    private void saveData(TraumaOperationInfoBean bean) {
        BaseRequestBean<TraumaOperationInfoBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 3, bean);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveTraumaOperationInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());
                    }
                });
    }

}