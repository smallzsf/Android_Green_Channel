package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.RequestTraumaConsultationInfoBean;
import com.xyj.strokeaid.bean.RequestTraumaConsultationInfoBean;
import com.xyj.strokeaid.bean.TraumaConsultationInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 会诊信息
 *
 * @author Licy
 */
public class TraumaConsultationInfoFragment extends BaseStrokeFragment {


    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.ttb_arrive_time_1)
    TextTimeBar ttbArriveTime1;
    @BindView(R.id.et_doctor_name_1)
    EditText etDoctorName1;
    @BindView(R.id.ttb_arrive_time_2)
    TextTimeBar ttbArriveTime2;
    @BindView(R.id.et_doctor_name_2)
    EditText etDoctorName2;
    @BindView(R.id.ttb_arrive_time_3)
    TextTimeBar ttbArriveTime3;
    @BindView(R.id.et_doctor_name_3)
    EditText etDoctorName3;
    @BindView(R.id.ttb_arrive_time_4)
    TextTimeBar ttbArriveTime4;
    @BindView(R.id.et_doctor_name_4)
    EditText etDoctorName4;
    @BindView(R.id.ttb_arrive_time_5)
    TextTimeBar ttbArriveTime5;
    @BindView(R.id.et_doctor_name_5)
    EditText etDoctorName5;
    @BindView(R.id.ttb_arrive_time_6)
    TextTimeBar ttbArriveTime6;
    @BindView(R.id.et_doctor_name_6)
    EditText etDoctorName6;
    @BindView(R.id.ttb_arrive_time_7)
    TextTimeBar ttbArriveTime7;
    @BindView(R.id.et_doctor_name_7)
    EditText etDoctorName7;
    @BindView(R.id.tv_doctor_select_7)
    TextView tvDoctorSelect7;
    @BindView(R.id.ttb_arrive_time_8)
    TextTimeBar ttbArriveTime8;
    @BindView(R.id.et_doctor_name_8)
    EditText etDoctorName8;
    private String mRecordId;
    private RequestTraumaConsultationInfoBean data;

    public TraumaConsultationInfoFragment() {

    }

    public static TraumaConsultationInfoFragment newInstance(String recordId) {
        TraumaConsultationInfoFragment fragment = new TraumaConsultationInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_consultation_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        //TODO recordId默认值1111去掉
        mRecordId = getArguments().getString(IntentKey.RECORD_ID, "1111");
        getTraumaConsultationInfo();
    }


    private void loadData() {
    }


    @Override
    protected void initListener() {
    }


    @Override
    public void onResume() {
        super.onResume();
        //TODO  OnResume 调试用 ，删除onresume
        getTraumaConsultationInfo();
    }

    private void showData() {
        if (data == null || data.getEicuicuconsultationdetailarray() == null) {
            return;
        }
        List<TraumaConsultationInfoBean> list = data.getEicuicuconsultationdetailarray();
        for (TraumaConsultationInfoBean item : list) {
            String consultationdepartmentid = item.getConsultationdepartmentid();
            String time = item.getConsultationdoctorarrivetime();
            String doctorId = item.getConsultationdoctorid();
            switch (consultationdepartmentid) {
                case "1":
                    ttbArriveTime1.setTime(time);
                    etDoctorName1.setText(doctorId);
                    break;
                case "2":
                    ttbArriveTime2.setTime(time);
                    etDoctorName2.setText(doctorId);
                    break;
                case "3":
                    ttbArriveTime3.setTime(time);
                    etDoctorName3.setText(doctorId);
                    break;
                case "4":
                    ttbArriveTime4.setTime(time);
                    etDoctorName4.setText(doctorId);
                    break;
                case "5":
                    ttbArriveTime5.setTime(time);
                    etDoctorName5.setText(doctorId);
                    break;
                case "6":
                    ttbArriveTime6.setTime(time);
                    etDoctorName6.setText(doctorId);
                    break;
                case "7":
                    ttbArriveTime7.setTime(time);
                    etDoctorName7.setText(doctorId);
                    break;
                case "8":
                    ttbArriveTime8.setTime(time);
                    etDoctorName8.setText(doctorId);
                    break;


            }
        }

    }

    private RequestTraumaConsultationInfoBean getSavedData() {
        RequestTraumaConsultationInfoBean savedData = new RequestTraumaConsultationInfoBean();

        //TODO 医生姓名是否换成医生ID
        List<TraumaConsultationInfoBean> list = new ArrayList<>();
        list.add(new TraumaConsultationInfoBean("1", etDoctorName1.getText().toString().trim(), ttbArriveTime1.getTime()));
        list.add(new TraumaConsultationInfoBean("2", etDoctorName2.getText().toString().trim(), ttbArriveTime2.getTime()));
        list.add(new TraumaConsultationInfoBean("3", etDoctorName3.getText().toString().trim(), ttbArriveTime3.getTime()));
        list.add(new TraumaConsultationInfoBean("4", etDoctorName4.getText().toString().trim(), ttbArriveTime4.getTime()));
        list.add(new TraumaConsultationInfoBean("5", etDoctorName5.getText().toString().trim(), ttbArriveTime5.getTime()));
        list.add(new TraumaConsultationInfoBean("6", etDoctorName6.getText().toString().trim(), ttbArriveTime6.getTime()));
        list.add(new TraumaConsultationInfoBean("7", etDoctorName7.getText().toString().trim(), ttbArriveTime7.getTime()));
        list.add(new TraumaConsultationInfoBean("8", etDoctorName8.getText().toString().trim(), ttbArriveTime8.getTime()));

        savedData.setEicuicuconsultationdetailarray(list);
        return savedData;
    }

    private void saveTraumaConsultationInfo() {
        BaseRequestBean<RequestTraumaConsultationInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, getSavedData());

        RetrofitClient.getInstance().getApi()
                .saveTraumaConsultationInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    private void getTraumaConsultationInfo() {
        BaseRequestBean<RequestTraumaConsultationInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new RequestTraumaConsultationInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getTraumaConsultationInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<RequestTraumaConsultationInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<RequestTraumaConsultationInfoBean>> call, Response<BaseResponseBean<RequestTraumaConsultationInfoBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("获取数据成功");
                                if (response.body().getData() != null) {
                                    data = response.body().getData().getData();
                                    showData();
                                }

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<RequestTraumaConsultationInfoBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }

    @OnClick({R.id.tv_doctor_select_1, R.id.tv_doctor_select_2, R.id.tv_doctor_select_3, R.id.tv_doctor_select_4,
            R.id.tv_doctor_select_5, R.id.tv_doctor_select_6, R.id.tv_doctor_select_7, R.id.tv_doctor_select_8, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //TODO 选择医生
            case R.id.tv_doctor_select_1:
                break;
            case R.id.tv_doctor_select_2:
                break;
            case R.id.tv_doctor_select_3:
                break;
            case R.id.tv_doctor_select_4:
                break;
            case R.id.tv_doctor_select_5:
                break;
            case R.id.tv_doctor_select_6:
                break;
            case R.id.tv_doctor_select_7:
                break;
            case R.id.tv_doctor_select_8:
                break;
            case R.id.btn_save:
                saveTraumaConsultationInfo();
                break;
        }
    }
}
