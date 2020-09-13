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
import com.xyj.strokeaid.bean.trauma.TraumaEcgCheckBean;
import com.xyj.strokeaid.bean.trauma.TraumaEcgCheckBean;
import com.xyj.strokeaid.bean.trauma.TraumaOperationInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 心电检查
 *
 * @author Licy
 */
public class TraumaEcgCheckFragment extends BaseStrokeFragment {


    @BindView(R.id.tv_check_time)
    TextTimeBar tvCheckTime;
    @BindView(R.id.tv_report_time)
    TextTimeBar tvReportTime;
    @BindView(R.id.tv_report)
    TextView tvReport;
    @BindView(R.id.et_report)
    EditText etReport;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    TraumaEcgCheckBean bean = new TraumaEcgCheckBean();

    public static TraumaEcgCheckFragment newInstance(String recordId) {
        TraumaEcgCheckFragment fragment = new TraumaEcgCheckFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_ecg_check;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
        queryData();
    }


    private void loadData() {
    }

    private void queryData() {
        BaseRequestBean<TraumaEcgCheckBean> requestBean = new BaseRequestBean<>(
                mRecordId, 3, new TraumaEcgCheckBean());
        RetrofitClient
                .getInstance()
                .getApi()
                .getTraumaEcgCheck(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseResponseBean<TraumaEcgCheckBean>>() {

                    @Override
                    public void onResponse(Call<BaseResponseBean<TraumaEcgCheckBean>> call, Response<BaseResponseBean<TraumaEcgCheckBean>> response) {
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
                    public void onFailure(Call<BaseResponseBean<TraumaEcgCheckBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }

    private void dataToView(TraumaEcgCheckBean bean) {
        String inecgexaminationtime = bean.getInecgexaminationtime();
        if (!TextUtils.isEmpty(inecgexaminationtime)){
            tvCheckTime.setTime(inecgexaminationtime);
        }
        String inecgreporttime = bean.getInecgreporttime();
        if (!TextUtils.isEmpty(inecgreporttime)){
            tvReportTime.setTime(inecgreporttime);
        }
        String inecgreport = bean.getInecgreport();
        if (!TextUtils.isEmpty(inecgreport)){
            etReport.setText(inecgreport);
        }
        String inecgreportfile = bean.getInecgreportfile();
        //todo
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

    private void getData(){
        bean.setInecgexaminationtime(tvCheckTime.getTime());
        bean.setInecgreporttime(tvReportTime.getTime());
        bean.setInecgreport(etReport.getText().toString().trim());
        bean.setInecgreportfile("1234");// todo
        saveData(bean);
    }

    private void saveData(TraumaEcgCheckBean bean) {
        BaseRequestBean<TraumaEcgCheckBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 3, bean);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveTraumaEcgCheck(baseRequestBean.getResuestBody(baseRequestBean))
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
