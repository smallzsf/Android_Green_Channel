package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ChestpainEcgDetailBean;
import com.xyj.strokeaid.bean.SendAddVitalSignsDataBean;
import com.xyj.strokeaid.bean.dist.ChestPainOperationRsultBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextTimeBar;
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
 * ChestPainEcgExaminFragment
 * description:  心电检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainEcgExaminFragment extends BaseFragment {

    @BindView(R.id.rb_electrocardiogram_has) //有
            RadioButton rbElectrocardiogramHas;
    @BindView(R.id.rb_electrocardiogram_none)
    RadioButton rbElectrocardiogramNone;//无
    @BindView(R.id.rg_electrocardiogram)
    RadioGroup rgElectrocardiogram;//心电图
    @BindView(R.id.iv_add_ecg_record)
    ImageView ivAddRecord;//新增心电记录

    @BindView(R.id.ll_ecg_record_one)
    LinearLayout llEcgRecordOne;
    @BindView(R.id.iv_ecg_record_close_two)
    ImageView ivEcgRecordCloseTwo;
    @BindView(R.id.ll_ecg_record_two)
    LinearLayout llEcgRecordTwo;
    @BindView(R.id.iv_ecg_record_close_three)
    ImageView ivEcgRecordCloseThree;
    @BindView(R.id.ll_ecg_record_three)
    LinearLayout llEcgRecordThree;
    @BindView(R.id.rb_ecg_transmission_120)
    RadioButton rbEcgTransmission120;//接收120/网络医院心电图"
    @BindView(R.id.rb_ecg_transmission_none)
    RadioButton rbEcgTransmissionNone;//未传输
    @BindView(R.id.rg_ecg_transmission)
    RadioGroup rgEcgTransmission;//远程心电传输
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;//传输方式
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_auxiliary_exam)
    LinearLayout llAuxiliaryExam;
    @BindView(R.id.ttbl_ecg_check_time1)
    TextTimeBar ttblEcgCheckTime1;
    @BindView(R.id.ttbl_ecg_diagnosis_time1)
    TextTimeBar ttblEcgDiagnosisTime1;
    @BindView(R.id.ed_ecg_diagnosis_conclusion1)
    EditText edEcgDiagnosisConclusion1;
    @BindView(R.id.ttbl_ecg_check_time2)
    TextTimeBar ttblEcgCheckTime2;
    @BindView(R.id.ttbl_ecg_diagnosis_time2)
    TextTimeBar ttblEcgDiagnosisTime2;
    @BindView(R.id.ed_ecg_diagnosis_conclusion2)
    EditText edEcgDiagnosisConclusion2;
    @BindView(R.id.rtb_ecg_receiving_time)
    TextTimeBar rtbEcgReceivingTime;
    @BindView(R.id.ttbl_ecg_check_time)
    TextTimeBar ttblEcgCheckTime;
    @BindView(R.id.ttbl_ecg_diagnosis_time)
    TextTimeBar ttblEcgDiagnosisTime;
    @BindView(R.id.ed_ecg_diagnosis_conclusion)
    EditText edEcgDiagnosisConclusion;

    private int ecgRecordItem = 1;

    private String mRecordId;

    public ChestPainEcgExaminFragment() {

    }

    public static ChestPainEcgExaminFragment newInstance(String recordId) {
        ChestPainEcgExaminFragment fragment = new ChestPainEcgExaminFragment();
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
        return R.layout.fragment_ecg_examin;
    }

    @Override
    protected void initView(@NonNull View view) {
        refrashRecordItem();
    }


    @Override
    public void onResume() {
        super.onResume();
        loadData();
        resetShowData();
    }

    private void resetShowData() {
        RecordIdUtil src = new RecordIdUtil();
        src.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(src);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainsuEcgDetail(requestBody)
                .enqueue(new Callback<BaseObjectBean<ChestpainEcgDetailBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<ChestpainEcgDetailBean>> call, Response<BaseObjectBean<ChestpainEcgDetailBean>> response) {
                        Log.e("zhangshifu", "onResponse: " + response.toString());
                        if (response.body() == null) {
                            return;
                        }
                        if (response.body().getResult() != 1) {
                            return;
                        }
                        resetShowData(response.body().getData());
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<ChestpainEcgDetailBean>> call, Throwable t) {

                    }
                });

    }

    /**
     * 重新绘制界面使用
     *
     */
    private void resetShowData(ChestpainEcgDetailBean bean) {


//         设置远程心电传输
//        rb_ecg_transmission_120
        if ("cpc_ycxdtcsfs_120".equals(bean.getEcgisremotetransmission())){
            rbEcgTransmission120.setChecked(true);
        }else {
            rbEcgTransmissionNone.setChecked(true);
        }
        rtbEcgReceivingTime.setTime( bean.getEcgremotetransmissiontime());
        esVitalSignAware.setStringArrayNormalKey(bean.getEcgremotetransmissionway());

        // 设置心电图
        if (Constants.BOOL_TRUE.equals(  bean.getEcgisexist())){
            rbElectrocardiogramHas.setChecked(true);
        }else {
            rbElectrocardiogramNone.setChecked(true);
        }


        List<ChestpainEcgDetailBean.EcgarrayBean> ecgarray = bean.getEcgarray();
        if (ecgarray!= null){
            ecgRecordItem = ecgarray.size();
        }
        ChestpainEcgDetailBean.EcgarrayBean ecgarrayBean = null;
        if (ecgRecordItem > 0) {
            ecgarrayBean =  ecgarray.get(0);
            ttblEcgCheckTime.setTime(ecgarrayBean.getEcgtime());
            ttblEcgDiagnosisTime.setTime(ecgarrayBean.getEcgdiagnosistime());
            edEcgDiagnosisConclusion.setText(ecgarrayBean.getEcgdiagnosed());
        }

        if (ecgRecordItem > 1) {
            ecgarrayBean =  ecgarray.get(1);
            ttblEcgCheckTime1.setTime(ecgarrayBean.getEcgtime());
            ttblEcgDiagnosisTime1.setTime(ecgarrayBean.getEcgdiagnosistime());
            edEcgDiagnosisConclusion1.setText(ecgarrayBean.getEcgdiagnosed());
        }

        if (ecgRecordItem > 2) {
            ecgarrayBean =  ecgarray.get(2);
            ttblEcgCheckTime2.setTime(ecgarrayBean.getEcgtime());
            ttblEcgDiagnosisTime2.setTime(ecgarrayBean.getEcgdiagnosistime());
            edEcgDiagnosisConclusion2.setText(ecgarrayBean.getEcgdiagnosed());
        }
    }

    private void refrashRecordItem() {
        refrashRecordItem(llEcgRecordOne, 1);
        refrashRecordItem(llEcgRecordTwo, 2);
        refrashRecordItem(llEcgRecordThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (ecgRecordItem >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }


    private void loadData() {

        esVitalSignAware.setStringArrayId(R.array.chest_pain_heart_tansfer_way);

    }


    @Override
    protected void initListener() {
        rgElectrocardiogram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_electrocardiogram_none) {
                    ecgRecordItem = 0;
                    ivAddRecord.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_electrocardiogram_has) {
                    ivAddRecord.setVisibility(View.VISIBLE);
                    ecgRecordItem = 1;
                }
                refrashRecordItem();
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.iv_add_ecg_record:
                        if (ecgRecordItem >= 3) {
                            showToast("最多只能添加三条心电记录");
                            return;
                        }
                        ecgRecordItem++;
                        refrashRecordItem();
                        break;
                    case R.id.iv_ecg_record_close_three:
                    case R.id.iv_ecg_record_close_two:
                        ecgRecordItem--;
                        refrashRecordItem();
                        break;
                    case R.id.btn_confirm:
                        save();
                        break;
                    default:
                        break;
                }
            }
        };
        rbElectrocardiogramHas.setOnClickListener(onClickListener);
        rbElectrocardiogramNone.setOnClickListener(onClickListener);
        ivAddRecord.setOnClickListener(onClickListener);
        ivEcgRecordCloseTwo.setOnClickListener(onClickListener);
        ivEcgRecordCloseThree.setOnClickListener(onClickListener);

        btnConfirm.setOnClickListener(onClickListener);
    }

    private void save() {

//        ttbl_ecg_check_time
        ChestpainEcgDetailBean bean = new ChestpainEcgDetailBean();

//         设置远程心电传输
//        rb_ecg_transmission_120
        if (rbEcgTransmission120.isChecked()) {
            bean.setEcgisremotetransmission("cpc_ycxdtcsfs_120");
        }else {
            bean.setEcgisremotetransmission("cpc_ycxdtcsfs_wcs");
        }
//        es_vital_sign_aware
//        rtb_ecg_receiving_time
        bean.setEcgremotetransmissiontime(rtbEcgReceivingTime.getTime());
        String[] selectData = esVitalSignAware.getSelectData();
        bean.setEcgremotetransmissionway(selectData[1]);

        // 设置心电图
        if (!rbElectrocardiogramHas.isChecked()){
            bean.setEcgisexist(Constants.BOOL_FALSE);
            return;
        }

        bean.setEcgisexist(Constants.BOOL_TRUE);

        List<ChestpainEcgDetailBean.EcgarrayBean> ecgarray = bean.getEcgarray();
        if (ecgarray == null) {
            ecgarray = new ArrayList<>();
            bean.setEcgarray(ecgarray);
        }
        ChestpainEcgDetailBean.EcgarrayBean ecgarrayBean = null;
        if (ecgRecordItem > 0) {
            ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
            String time = ttblEcgCheckTime.getTime();
            ecgarrayBean.setEcgtime(time);
            String diagnosisTimeTime = ttblEcgDiagnosisTime.getTime();
            ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
            String trim = edEcgDiagnosisConclusion.getText().toString().trim();
            ecgarrayBean.setEcgdiagnosed(trim);
            ecgarray.add(ecgarrayBean);
        }

        if (ecgRecordItem > 1) {
            ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
            String time = ttblEcgCheckTime1.getTime();
            ecgarrayBean.setEcgtime(time);
            String diagnosisTimeTime = ttblEcgDiagnosisTime1.getTime();
            ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
            String trim = edEcgDiagnosisConclusion1.getText().toString().trim();
            ecgarrayBean.setEcgdiagnosed(trim);
            ecgarray.add(ecgarrayBean);
        }

        if (ecgRecordItem > 2) {
            ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
            String time = ttblEcgCheckTime2.getTime();
            ecgarrayBean.setEcgtime(time);
            String diagnosisTimeTime = ttblEcgDiagnosisTime2.getTime();
            ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
            String trim = edEcgDiagnosisConclusion2.getText().toString().trim();
            ecgarrayBean.setEcgdiagnosed(trim);
            ecgarray.add(ecgarrayBean);
        }
        save(bean);

    }


    public void save(ChestpainEcgDetailBean bean) {
        bean.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(bean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainsuEcgDetail(requestBody)
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


    private void uploadFile() {

    }
}