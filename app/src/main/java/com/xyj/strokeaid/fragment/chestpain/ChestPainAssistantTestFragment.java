package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.google.gson.Gson;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextTimeBar;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

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

    /*   @BindView(R.id.stl_title_frag_od)
       SegmentTabLayout stlTitleFragOd;*/
    @BindView(R.id.tfl_action_in_chief)
    TagFlowLayout tflActionInChief;
    @BindView(R.id.ll_emergency_ct)
    LinearLayout llEmergencyCt;
    @BindView(R.id.ll_ultrasound_color)
    LinearLayout llUltrasoundColor;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;
    @BindView(R.id.rg_chest_pain_diseaseRecord)
    RadioGroup rgChestPainDiseaseRecord;
    @BindView(R.id.sv_emergency_ct)
    ScrollView svEmergencyCt;
    @BindView(R.id.rb_emergency_ct)
    RadioButton rbEmergencyCt;
    @BindView(R.id.rb_color_ultrasound)
    RadioButton rbColorUltrasound;
    @BindView(R.id.rb_not_done)
    RadioButton rbNotDone;
    @BindView(R.id.et_ct_place)
    EditText etCtPlace;
    @BindView(R.id.ttb_notice)
    TextTimeBar ttbNotice;
    @BindView(R.id.ttb_getready)
    TextTimeBar ttbGetready;
    @BindView(R.id.ttb_arrival)
    TextTimeBar ttbArrival;
    @BindView(R.id.ttb_check)
    TextTimeBar ttbCheck;
    @BindView(R.id.et_check_result)
    EditText etCheckResult;
    @BindView(R.id.tv_ct_check_post)
    TextView tvCtCheckPost;
    @BindView(R.id.tv_ct_result_post)
    TextView tvCtResultPost;
    @BindView(R.id.et_color_ct_place)
    EditText etColorCtPlace;
    @BindView(R.id.ttb_color_ct_notice)
    TextTimeBar ttbColorCtNotice;
    @BindView(R.id.ttb_color_ct_check)
    TextTimeBar ttbColorCtCheck;
    @BindView(R.id.ttb_color_ct_result)
    TextTimeBar ttbColorCtResult;
    @BindView(R.id.btn_get_data_color_ct)
    AppCompatButton btnGetDataColorCt;
    @BindView(R.id.btn_confirm_color_ct)
    AppCompatButton btnConfirmColorCt;
    @BindView(R.id.ttb_ct_report)
    TextTimeBar ttbCtReport;

    private String mPatientId;
    private String mDocId;
    private List<String> list;

    private int titlePosition = 0;
    private ChestPainImageExaminationBean.DataBean data;


    public ChestPainAssistantTestFragment() {

    }

    public static ChestPainAssistantTestFragment newInstance(String patientId, String docId) {
        ChestPainAssistantTestFragment fragment = new ChestPainAssistantTestFragment();
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
        return R.layout.fragment_assistant_test;
    }

    @Override
    protected void initView(@NonNull View view) {


        loadData();

        //  refrashTitleData();

    }

    private void refrashTitleData() {
        if (titlePosition == 0) {
            llEmergencyCt.setVisibility(View.VISIBLE);
            llUltrasoundColor.setVisibility(View.GONE);
        } else {
            llEmergencyCt.setVisibility(View.GONE);
            llUltrasoundColor.setVisibility(View.VISIBLE);
        }
    }


    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
//        esVitalSignAware.setItemData(list);

        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainImageExamination(requestBody)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        Gson gson = new Gson();
                        ChestPainImageExaminationBean chestPainImageExaminationBean = gson.fromJson(response.toString(), ChestPainImageExaminationBean.class);
                        if (chestPainImageExaminationBean != null) {

                            data = chestPainImageExaminationBean.getData();
                            checkviews();
                        }


                    }


                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });


    }

    /**
     * 根据数据处理页面
     */
    private void checkviews() {
        if (data == null) {
            return;
        }
        switch (data.getImageexam()) {
            case "cpc_imageexam_ct":
                //急诊ct
                rbEmergencyCt.setChecked(true);
                break;
            case "cpc_imageexam_cdu":
                //彩超
                rbColorUltrasound.setChecked(true);
                break;
            case "cpc_imageexam_none":
                //未做
                rbNotDone.setChecked(true);
                break;
            default:
                rbNotDone.setChecked(true);
                break;
        }
        if (!TextUtils.isEmpty(data.getCtexamdepartment())) {
            etCtPlace.setText(data.getCtexamdepartment());
            etColorCtPlace.setText(data.getCtexamdepartment());
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
      /*  stlTitleFragOd.setTabData(Constants.CHEST_OTHER_DISPOSAL_TITLES);
        stlTitleFragOd.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Log.e("zhangshifu", "" + position);
                titlePosition = position;
                refrashTitleData();
            }

            @Override
            public void onTabReselect(int position) {

            }
        });*/

        rgChestPainDiseaseRecord.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_emergency_ct:
                        svEmergencyCt.setVisibility(View.VISIBLE);
                        llUltrasoundColor.setVisibility(View.GONE);
                        break;
                    case R.id.rb_color_ultrasound:
                        svEmergencyCt.setVisibility(View.GONE);
                        llUltrasoundColor.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_not_done:
                        svEmergencyCt.setVisibility(View.GONE);
                        llUltrasoundColor.setVisibility(View.GONE);
                        break;

                }
            }
        });
    }

    @OnClick({R.id.tv_ct_check_post, R.id.tv_ct_result_post, R.id.ttb_color_ct_result, R.id.btn_confirm_color_ct, R.id.btn_get_data_color_ct, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_ct_check_post:
                //ct片子上传
                break;
            case R.id.tv_ct_result_post:
                //ct报告上传
                break;
            case R.id.btn_confirm:
            case R.id.btn_confirm_color_ct:
                saveddata();
                break;
            case R.id.btn_get_data:
            case R.id.btn_get_data_color_ct:
                loadData();
                break;

        }
    }

    /**
     * 保存数据
     */
    private void saveddata() {
        if (data == null) {
            data = new ChestPainImageExaminationBean.DataBean();
        }
        if (rbEmergencyCt.isChecked()) {
            data.setImageexam("cpc_imageexam_ct");
            if (!TextUtils.isEmpty(etCtPlace.getText().toString().trim())) {
                data.setCtexamdepartment(etCtPlace.getText().toString().trim());
            }
        }
        if (rbColorUltrasound.isChecked()) {
            data.setImageexam("cpc_imageexam_cdu");
            if (!TextUtils.isEmpty(etColorCtPlace.getText().toString().trim())) {
                data.setCtexamdepartment(etColorCtPlace.getText().toString().trim());
            }
        }
        if (rbNotDone.isChecked()) {
            data.setImageexam("cpc_imageexam_none");
        }
        if (!TextUtils.isEmpty(ttbNotice.getTime())) {
            data.setCtexamnoticetime(ttbNotice.getTime());
        }


        String request = GsonUtils.getGson().toJson(data);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainImageExamination(requestBody)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        Gson gson = new Gson();
                        ChestPainImageExaminationBean chestPainImageExaminationBean = gson.fromJson(response.toString(), ChestPainImageExaminationBean.class);
                        if (chestPainImageExaminationBean != null) {

                            data = chestPainImageExaminationBean.getData();
                            checkviews();
                        }


                    }


                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });

    }
}