package com.xyj.strokeaid.fragment.common;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.google.gson.reflect.TypeToken;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * TriageInfoFragment
 * description: 卒中分诊信息
 *
 * @author : Licy
 * @date : 2020/9/5
 * email ：licy3051@qq.com
 */
public class TriageInfoFragment extends BaseFragment {

    @BindView(R.id.ttb_patient_arrival_frag_ti)
    TextTimeBar ttbPatientArrivalFragTi;
    @BindView(R.id.ttb_patient_emergency_frag_ti)
    TextTimeBar ttbPatientEmergencyFragTi;
    @BindView(R.id.ttb_emergency_triage_frag_ti)
    TextTimeBar ttbEmergencyTriageFragTi;
    @BindView(R.id.es_emergency_nurse_frag_ti)
    EditSpinner esEmergencyNurseFragTi;
    @BindView(R.id.es_emergency_addr_frag_ti)
    EditSpinner esEmergencyAddrFragTi;
    @BindView(R.id.ttb_emergency_doc_time_frag_ti)
    TextTimeBar ttbEmergencyDocTimeFragTi;
    @BindView(R.id.es_emergency_doc_frag_ti)
    EditSpinner esEmergencyDocFragTi;
    @BindView(R.id.ttb_stroke_doc_time_frag_ti)
    TextTimeBar ttbStrokeDocTimeFragTi;
    @BindView(R.id.es_stroke_doc_frag_ti)
    EditSpinner esStrokeDocFragTi;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.stroke_fragment_triage)
    LinearLayout strokeFragmentTriage;
    @BindView(R.id.ll_stroke_doc_frag_ti)
    LinearLayout llStrokeDocFragTi;

    private String mRecordId;
    private int mDiseaseViewType;
    private ChestPainTriageInfoBean mChestPainTriageInfoBean;
    private StrokeTrigaeInfoBean mStrokeTrigaeInfoBean;


    public TriageInfoFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recordId        记录ID
     * @param diseaseViewType 疾病类型
     * @return A new instance of fragment StrokeGetInvolvedFragment.
     */
    public static TriageInfoFragment newInstance(String recordId, int diseaseViewType) {
        TriageInfoFragment fragment = new TriageInfoFragment();
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
        return R.layout.fragment_triage_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        if (mDiseaseViewType == 2) {
            // 胸痛不显示卒中医生信息
            llStrokeDocFragTi.setVisibility(View.GONE);
            ttbStrokeDocTimeFragTi.setVisibility(View.GONE);
        } else {
            llStrokeDocFragTi.setVisibility(View.VISIBLE);
            ttbStrokeDocTimeFragTi.setVisibility(View.VISIBLE);
        }
        // 接诊地点
        esEmergencyAddrFragTi.setItemData(Arrays.asList(getResources().getStringArray(R.array.accepts_location)));
        // 接诊医生
        ArrayList<String> list = new ArrayList<String>();
        list.add("露露");
        list.add("安琪拉");
        list.add("小熊");
        esEmergencyNurseFragTi.setItemData(list);
        // 接诊护士
        esEmergencyDocFragTi.setItemData(list);
        // 接诊卒中医生
        esStrokeDocFragTi.setItemData(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        showLoadingDialog();
        if (mDiseaseViewType == 2) {
            loadDataForChestPain(mRecordId);
        } else if (mDiseaseViewType == 1) {
            loadDataForStroke(mRecordId);
        }
    }

    @Override
    protected void initListener() {
        btnSave.setOnClickListener(v -> {
            if (mDiseaseViewType == 2) {
                getChestDataBeforeSave();
            } else if (mDiseaseViewType == 1) {
                getStrokeDataBeforeSave();
            }
        });
    }

    private void getDataToChestPainViews(ChestPainTriageInfoBean bean) {
        if (bean == null) {
            return;
        }
        // 患者到院
        ttbPatientArrivalFragTi.setTime(bean.getArrivehospitaltime());
        // 患者到达急诊
        ttbPatientEmergencyFragTi.setTime(bean.getArrivedertime());
        // 急诊分诊
        ttbEmergencyTriageFragTi.setTime(bean.getReceptiontime());
        // 分诊护士
        esEmergencyNurseFragTi.setText(bean.getEmergencynursereception());
        // 接诊地点
        esEmergencyAddrFragTi.setText(bean.getReceptionlocation());
        // 急诊医生接诊
        ttbEmergencyDocTimeFragTi.setTime(bean.getEmergencydoctorreceptiontime());
        // 急诊医生
        esEmergencyDocFragTi.setText(bean.getEmergencydoctorreception());
    }

    private void getDatatoStrokeViews(StrokeTrigaeInfoBean bean) {
        // 患者到院
        ttbPatientArrivalFragTi.setTime(bean.getArrivehospitaltime());
        // 患者到达急诊
        ttbPatientEmergencyFragTi.setTime(bean.getArrivedertime());
        // 急诊分诊
        ttbEmergencyTriageFragTi.setTime(bean.getReceptiontime());
        // 分诊护士
        esEmergencyNurseFragTi.setText(bean.getEmergencynursereception());
        // 接诊地点
        esEmergencyAddrFragTi.setText(bean.getReceptionlocation());
        // 急诊医生接诊
        ttbEmergencyDocTimeFragTi.setTime(bean.getEmergencydoctorreceptiontime());
        // 急诊医生
        esEmergencyDocFragTi.setText(bean.getEmergencydoctorreception());
        // 卒中医生接诊
        ttbStrokeDocTimeFragTi.setTime(bean.getStrokedoctorreceptiontime());
        // 卒中医生
        esStrokeDocFragTi.setText(bean.getStrokedoctorreception());
    }

    private void getChestDataBeforeSave() {
        showLoadingDialog();
        if (mChestPainTriageInfoBean == null) {
            mChestPainTriageInfoBean = new ChestPainTriageInfoBean();
        }
        // 患者到院
        mChestPainTriageInfoBean.setArrivehospitaltime(ttbPatientArrivalFragTi.getTime());
        // 患者到达急诊
        mChestPainTriageInfoBean.setArrivedertime(ttbPatientEmergencyFragTi.getTime());
        // 急诊分诊
        mChestPainTriageInfoBean.setReceptiontime(ttbEmergencyTriageFragTi.getTime());
        // 分诊护士
        mChestPainTriageInfoBean.setEmergencynursereception(esEmergencyNurseFragTi.getText());
        // 接诊地点
        mChestPainTriageInfoBean.setReceptionlocation(esEmergencyAddrFragTi.getText());
        // 急诊医生接诊
        mChestPainTriageInfoBean.setEmergencydoctorreceptiontime(ttbEmergencyDocTimeFragTi.getTime());
        // 急诊医生
        mChestPainTriageInfoBean.setEmergencydoctorreception(esEmergencyDocFragTi.getText());
        saveDataToChestPain();
    }

    private void getStrokeDataBeforeSave() {

        if (mStrokeTrigaeInfoBean == null) {
            mStrokeTrigaeInfoBean = new StrokeTrigaeInfoBean();
        }
        // 患者到院
        mStrokeTrigaeInfoBean.setArrivehospitaltime(ttbPatientArrivalFragTi.getTime());
        // 患者到达急诊
        mStrokeTrigaeInfoBean.setArrivedertime(ttbPatientEmergencyFragTi.getTime());
        // 急诊分诊
        mStrokeTrigaeInfoBean.setReceptiontime(ttbEmergencyTriageFragTi.getTime());
        // 分诊护士
        mStrokeTrigaeInfoBean.setEmergencynursereception(esEmergencyNurseFragTi.getText());
        // 接诊地点
        mStrokeTrigaeInfoBean.setReceptionlocation(esEmergencyAddrFragTi.getText());
        // 急诊医生接诊
        mStrokeTrigaeInfoBean.setEmergencydoctorreceptiontime(ttbEmergencyDocTimeFragTi.getTime());
        // 急诊医生
        mStrokeTrigaeInfoBean.setEmergencydoctorreception(esEmergencyDocFragTi.getText());
        // 卒中医生接诊
        mStrokeTrigaeInfoBean.setStrokedoctorreceptiontime(ttbStrokeDocTimeFragTi.getTime());
        // 卒中医生
        mStrokeTrigaeInfoBean.setStrokedoctorreception(esStrokeDocFragTi.getText());
        saveDataToStroke();
    }

    private void saveDataToStroke() {

        BaseRequestBean<StrokeTrigaeInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, mStrokeTrigaeInfoBean);

        RetrofitClient.getInstance().getApi()
                .saveStrokeTrigaeInfo(baseRequestBean.getResuestBody(baseRequestBean))
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

    private void saveDataToChestPain() {

        BaseRequestBean<ChestPainTriageInfoBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 2, mChestPainTriageInfoBean);

        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainTriageInfo(baseRequestBean.getResuestBody(baseRequestBean))
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

    private void loadDataForStroke(String recordId) {
        showLoadingDialog();
        BaseRequestBean<StrokeTrigaeInfoBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 1, new StrokeTrigaeInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getStrokeTrigaeInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeTrigaeInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeTrigaeInfoBean>> call,
                                           Response<BaseResponseBean<StrokeTrigaeInfoBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mStrokeTrigaeInfoBean = response.body().getData().getData();
                                if (mStrokeTrigaeInfoBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getDatatoStrokeViews(mStrokeTrigaeInfoBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeTrigaeInfoBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    private void loadDataForChestPain(String recordId) {

        BaseRequestBean<ChestPainTriageInfoBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 2, new ChestPainTriageInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getChestPainTriageInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<ChestPainTriageInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<ChestPainTriageInfoBean>> call,
                                           Response<BaseResponseBean<ChestPainTriageInfoBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mChestPainTriageInfoBean = response.body().getData().getData();
                                if (mChestPainTriageInfoBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getDataToChestPainViews(mChestPainTriageInfoBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<ChestPainTriageInfoBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }


}

    
    
       
    