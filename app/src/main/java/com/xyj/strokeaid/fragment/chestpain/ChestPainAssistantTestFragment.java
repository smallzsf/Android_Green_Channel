package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  辅助检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainAssistantTestFragment extends BaseFragment {

    @BindView(R.id.tv_title_frag_at)
    TextView tvTitleFragAt;
    @BindView(R.id.cb_emergency_ct)
    CheckBox cbEmergencyCt;
    @BindView(R.id.cb_color_ultrasound)
    CheckBox cbColorUltrasound;
    @BindView(R.id.cb_not_done)
    CheckBox cbNotDone;
    @BindView(R.id.ll_image_check_types)
    LinearLayout llImageCheckTypes;
    @BindView(R.id.rb_non_emergency_room)
    RadioButton rbNonEmergencyRoom;
    @BindView(R.id.rb_other_place)
    RadioButton rbOtherPlace;
    @BindView(R.id.ttb_notice)
    TextTimeBar ttbNotice;
    @BindView(R.id.ttb_getready)
    TextTimeBar ttbGetready;
    @BindView(R.id.ttb_arrival)
    TextTimeBar ttbArrival;
    @BindView(R.id.ttb_check)
    TextTimeBar ttbCheck;
    @BindView(R.id.ttb_ct_report)
    TextTimeBar ttbCtReport;
    @BindView(R.id.et_check_result)
    EditText etCheckResult;
    @BindView(R.id.tv_ct_check_post)
    TextView tvCtCheckPost;
    @BindView(R.id.tv_ct_result_post)
    TextView tvCtResultPost;
    @BindView(R.id.ll_emergency_ct)
    LinearLayout llEmergencyCt;
    @BindView(R.id.ttb_color_ct_notice)
    TextTimeBar ttbColorCtNotice;
    @BindView(R.id.ttb_color_ct_check)
    TextTimeBar ttbColorCtCheck;
    @BindView(R.id.ttb_color_ct_result)
    TextTimeBar ttbColorCtResult;
    @BindView(R.id.ll_ultrasound_color)
    LinearLayout llUltrasoundColor;
    @BindView(R.id.rb_emergency_room)
    RadioButton rbEmergencyRoom;
    @BindView(R.id.rg_emergency_ct_place)
    RadioGroup rgEmergencyCtPlace;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    private ChestPainImageExaminationBean.DataBean data;
    private String mRecordId;

    public ChestPainAssistantTestFragment() {

    }

    public static ChestPainAssistantTestFragment newInstance(String recordId) {
        ChestPainAssistantTestFragment fragment = new ChestPainAssistantTestFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.PATIENT_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_assistant_test;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
    }


    private void loadData() {

        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainImageExamination(requestBody)
                .enqueue(new Callback<ChestPainImageExaminationBean>() {
                    @Override
                    public void onResponse(Call<ChestPainImageExaminationBean> call, Response<ChestPainImageExaminationBean> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            ChestPainImageExaminationBean body = response.body();
                            data = body.getData();
                            checkViews();
                        }


                    }


                    @Override
                    public void onFailure(Call<ChestPainImageExaminationBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });


    }

    /**
     * 根据数据处理页面
     */
    private void checkViews() {
        if (data == null) {
            return;
        }
        if (data.getImageexam().contains("cpc_imageexam_none")) {
            cbNotDone.setChecked(true);
        } else {
            if (data.getImageexam().contains("cpc_imageexam_ct")) {
                cbEmergencyCt.setChecked(true);
            }
            if (data.getImageexam().contains("cpc_imageexam_cdu")) {
                cbColorUltrasound.setChecked(true);
            }
        }
        String ctexamdepartment = data.getCtexamdepartment();
        if (TextUtils.equals("cpc_ctjcdd_jz", ctexamdepartment)) {
            rgEmergencyCtPlace.check(R.id.rb_emergency_room);
        } else if (TextUtils.equals("cpc_ctjcdd_fjz", ctexamdepartment)) {
            rgEmergencyCtPlace.check(R.id.rb_non_emergency_room);
        } else if (TextUtils.equals("cpc_ctjcdd_qt", ctexamdepartment)) {
            rgEmergencyCtPlace.check(R.id.rb_other_place);
        }

        if (!TextUtils.isEmpty(data.getCduexamnoticetime())) {
            ttbNotice.setTime(data.getCduexamnoticetime());
        }
        if (!TextUtils.isEmpty(data.getCtexamreadytime())) {
            ttbGetready.setTime(data.getCtexamreadytime());
        }
        if (!TextUtils.isEmpty(data.getCtexampatientarrivaltime())) {
            ttbArrival.setTime(data.getCtexampatientarrivaltime());
        }
        if (!TextUtils.isEmpty(data.getCtexambegintime())) {
            ttbCheck.setTime(data.getCtexambegintime());
        }
        if (!TextUtils.isEmpty(data.getCtexamreporttime())) {
            ttbCtReport.setTime(data.getCtexamreporttime());
        }
        if (!TextUtils.isEmpty(data.getCtresult())) {
            etCheckResult.setText(data.getCtresult());
        }
        if (!TextUtils.isEmpty(data.getCduexamnoticetime())) {
            ttbColorCtNotice.setTime(data.getCduexamnoticetime());
        }
        if (!TextUtils.isEmpty(data.getCduexambegintime())) {
            ttbColorCtCheck.setTime(data.getCduexambegintime());
        }
        if (!TextUtils.isEmpty(data.getCduexamreporttime())) {
            ttbColorCtResult.setTime(data.getCduexamreporttime());
        }


    }


    @Override
    protected void initListener() {
        cbNotDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llEmergencyCt.setVisibility(isChecked ? View.GONE : View.VISIBLE);
                llUltrasoundColor.setVisibility(isChecked ? View.GONE : View.VISIBLE);
                if (isChecked) {
                    cbColorUltrasound.setChecked(false);
                    cbEmergencyCt.setChecked(false);
                }
            }
        });
        cbEmergencyCt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llEmergencyCt.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                if (isChecked) {
                    cbNotDone.setChecked(false);
                }
            }
        });
        cbColorUltrasound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llUltrasoundColor.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                if (isChecked) {
                    cbNotDone.setChecked(false);
                }
            }
        });
    }

    @OnClick({R.id.tv_ct_check_post, R.id.tv_ct_result_post, R.id.ttb_color_ct_result
            , R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ct_check_post:
                //ct片子上传
                break;
            case R.id.tv_ct_result_post:
                //ct报告上传
                break;
            case R.id.btn_confirm:
                preSave();
                break;
            case R.id.btn_get_data:
                data = GsonUtils.getGson().fromJson(mDefaultMMKV.decodeString("影像页面数据"), ChestPainImageExaminationBean.DataBean.class);
                if (data != null) {
                    checkViews();
                }
                break;
            default:
                break;

        }
    }

    private void preSave() {
        if (data == null) {
            data = new ChestPainImageExaminationBean.DataBean();
        }
        data.setRecordId(RecordIdUtil.RECORD_ID);

        if (cbNotDone.isChecked()) {
            data.setImageexam("cpc_imageexam_none");
            saveData();
            return;
        } else {
            StringBuilder imageexam = new StringBuilder();
            if (cbEmergencyCt.isChecked()) {
                imageexam.append("cpc_imageexam_ct");
            }
            if (cbColorUltrasound.isChecked()) {
                if (imageexam.length() > 0) {
                    imageexam.append(",");
                }
                imageexam.append("cpc_imageexam_cdu");
            }
            data.setImageexam(imageexam.toString());
        }
        if (rgEmergencyCtPlace.getCheckedRadioButtonId() == R.id.rb_emergency_room) {
            data.setCtexamdepartment("cpc_ctjcdd_jz");
        } else if (rgEmergencyCtPlace.getCheckedRadioButtonId() == R.id.rb_non_emergency_room) {
            data.setCtexamdepartment("cpc_ctjcdd_fjz");
        } else if (rgEmergencyCtPlace.getCheckedRadioButtonId() == R.id.rb_other_place) {
            data.setCtexamdepartment("cpc_ctjcdd_qt");
        }
        if (!TextUtils.isEmpty(ttbNotice.getTime())) {
            data.setCtexamnoticetime(ttbNotice.getTime());
        }
        if (!TextUtils.isEmpty(ttbGetready.getTime())) {
            data.setCtexamreadytime(ttbGetready.getTime());
        }
        if (!TextUtils.isEmpty(ttbArrival.getTime())) {
            data.setCtexampatientarrivaltime(ttbArrival.getTime());
        }
        if (!TextUtils.isEmpty(ttbCheck.getTime())) {
            data.setCduexambegintime(ttbCheck.getTime());
        }
        if (!TextUtils.isEmpty(ttbCtReport.getTime())) {
            data.setCtexamreporttime(ttbCtReport.getTime());
        }
        if (!TextUtils.isEmpty(etCheckResult.getText().toString().trim())) {
            data.setCtresult(etCheckResult.getText().toString().trim());
        }
        if (!TextUtils.isEmpty(ttbColorCtNotice.getTime())) {
            data.setCduexamnoticetime(ttbColorCtNotice.getTime());
        }
        if (!TextUtils.isEmpty(ttbColorCtCheck.getTime())) {
            data.setCduexambegintime(ttbColorCtCheck.getTime());
        }
        if (!TextUtils.isEmpty(ttbColorCtResult.getTime())) {
            data.setCduexamreporttime(ttbColorCtResult.getTime());
        }
        mDefaultMMKV.encode("影像页面数据", GsonUtils.getGson().toJson(data));
        Log.d("数据保存", "影像页面保存数据: " + data.toString());
        saveData();
    }

    /**
     * 保存数据
     */
    private void saveData() {
        String request = GsonUtils.getGson().toJson(data);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainImageExamination(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            BaseObjectBean body = response.body();
                            if (body.getResult() == 1) {
                                showToast("数据保存成功");
                            }
                        }

                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });

    }
}