package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.SendAddVitalSignsDataBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

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

    @BindView(R.id.ttbl_ecg_check_time)
    TextTimeBar rrbElectrocardTime;//心电检查时间

    @BindView(R.id.ttbl_ecg_diagnosis_time)
    TextTimeBar rrbElectrocardDiagnosisTime;//诊断时间

    @BindView(R.id.ed_ecg_diagnosis_conclusion)
    EditText rrbElectrocardDiagnosisConclusion;//请输入心电图诊断结论

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
        loadData();
        refrashRecordItem();
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


        ArrayList<String> itemData = new ArrayList<>();
        itemData.add("实时监控");
        itemData.add("微信群");
        itemData.add("其他");
        esVitalSignAware.setItemData(itemData);

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


    private void uploadFile(){

    }
}