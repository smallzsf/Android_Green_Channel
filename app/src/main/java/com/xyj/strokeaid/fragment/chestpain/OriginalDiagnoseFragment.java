package com.xyj.strokeaid.fragment.chestpain;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBean;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * OriginalDiagnoseFragment
 * description: 初始诊断
 *
 * @author : Licy
 * @date : 2020/9/6
 * email ：licy3051@qq.com
 */
public class OriginalDiagnoseFragment extends BaseFragment {

    @BindView(R.id.es_title_select)
    EditSpinner esTitleSelect;
    @BindView(R.id.fl_content_frag_od)
    FrameLayout flContentFragOd;

    private DiagnoseStemiFragment mStemiFragment;
    private DiagnoseNstemiAndUaFragment mNstemiFragment;
    private DiagnoseNstemiAndUaFragment mUaFragment;
    private DiagnoseZdmjcFragment mZdmjcFragment;
    private DiagnoseFdmssFragment mFdmssFragment;
    private DiagnoseNonAcsFragment mNonAcsFragment;
    private DiagnoseNonHeartPainFragment mNonHeartPainFragment;
    private DiagnoseWaitDiagnoseFragment mWaitDiagnoseFragment;
    private BaseFragment mCurrentFragment;

    private String mRecordId;
    private int selectTitlePosition = 0;


    public OriginalDiagnoseFragment() {

    }

    public static OriginalDiagnoseFragment newInstance(String recordId) {
        OriginalDiagnoseFragment fragment = new OriginalDiagnoseFragment();
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
        return R.layout.fragment_original_diagnose;
    }

    @Override
    protected void initView(@NonNull View view) {

        /**
         * editSpinner设置数据
         */
        esTitleSelect.setStringArrayId(R.array.original_diagnose);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sp", MODE_PRIVATE);
        String initialdiagnosis = sharedPreferences.getString("initialdiagnosis", "");
        if (!TextUtils.isEmpty(initialdiagnosis)) {
            esTitleSelect.setStringArrayNormalKey(initialdiagnosis);
            int selectPosition = esTitleSelect.getSelectPosition();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            if (mCurrentFragment != null) {
                fragmentTransaction.hide(mCurrentFragment);
            }
            switch (selectPosition) {
                case 0:
                    // STEMI
                    if (mStemiFragment == null) {
                        mStemiFragment = DiagnoseStemiFragment.newInstance(mRecordId, "cpc_cbzdv2_stemi");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mStemiFragment);
                    break;
                case 1:
                    // NSTEMI
                    if (mNstemiFragment == null) {
                        mNstemiFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_nstemi");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mNstemiFragment);
                    break;
                case 2:
                    // UA
                    if (mUaFragment == null) {
                        mUaFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_ua");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mUaFragment);
                    break;
                case 3:
                    // 主动脉夹层
                    if (mZdmjcFragment == null) {
                        mZdmjcFragment = DiagnoseZdmjcFragment.newInstance(mRecordId, "cpc_cbzdv2_zdmjc");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mZdmjcFragment);
                    break;
                case 4:
                    // 肺动脉塞栓
                    if (mFdmssFragment == null) {
                        mFdmssFragment = DiagnoseFdmssFragment.newInstance(mRecordId, "cpc_cbzdv2_fdmss");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mFdmssFragment);
                    break;
                case 5:
                    // 非ACS心源性胸痛
                    if (mNonAcsFragment == null) {
                        mNonAcsFragment = DiagnoseNonAcsFragment.newInstance(mRecordId, "cpc_cbzdv2_facsxyxxt");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mNonAcsFragment);
                    break;
                case 6:
                    // 其它非心源性胸痛
                    if (mNonHeartPainFragment == null) {
                        mNonHeartPainFragment = DiagnoseNonHeartPainFragment.newInstance(mRecordId, "cpc_cbzdv2_qtfxyxxt");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mNonHeartPainFragment);
                    break;
                case 7:
                    // 待查
                    if (mWaitDiagnoseFragment == null) {
                        mWaitDiagnoseFragment = DiagnoseWaitDiagnoseFragment.newInstance(mRecordId, "cpc_cbzdv2_dc");
                    }
                    fragmentTransaction.replace(R.id.fl_content_frag_od, mWaitDiagnoseFragment);
                    break;
                default:
                    break;
            }
            fragmentTransaction.commitAllowingStateLoss();
        }

  /*      es_medicinal_name.setStringArrayId(R.array.chest_pain_operation_medicinal);
  *         String text = data.getSsanticoagulationdrug();
        es_medicinal_name.setStringArrayNormalKey(text);*/


    }


    @Override
    protected void initListener() {

/*
        UsingFragment usingFragment = (UsingFragment)getChildFragmentManager()
        usingFragment.initData2(false);    //调用子Fragment UsingFragment中的initData2()*/


        esTitleSelect.setOnSelectIndexAndStringLitner(new EditSpinner.OnSelectIndexAndStringLitner() {
            @Override
            public void getSeletedStringAndIndex(String text, int position) {
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                if (mCurrentFragment != null) {
                    fragmentTransaction.hide(mCurrentFragment);
                }
                switch (position) {
                    case 0:
                        // STEMI
                        if (mStemiFragment == null) {
                            mStemiFragment = DiagnoseStemiFragment.newInstance(mRecordId, "cpc_cbzdv2_stemi");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mStemiFragment);
                        break;
                    case 1:
                        // NSTEMI
                        if (mNstemiFragment == null) {
                            mNstemiFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_nstemi");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNstemiFragment);
                        break;
                    case 2:
                        // UA
                        if (mUaFragment == null) {
                            mUaFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_ua");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mUaFragment);
                        break;
                    case 3:
                        // 主动脉夹层
                        if (mZdmjcFragment == null) {
                            mZdmjcFragment = DiagnoseZdmjcFragment.newInstance(mRecordId, "cpc_cbzdv2_zdmjc");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mZdmjcFragment);
                        break;
                    case 4:
                        // 肺动脉塞栓
                        if (mFdmssFragment == null) {
                            mFdmssFragment = DiagnoseFdmssFragment.newInstance(mRecordId, "cpc_cbzdv2_fdmss");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mFdmssFragment);
                        break;
                    case 5:
                        // 非ACS心源性胸痛
                        if (mNonAcsFragment == null) {
                            mNonAcsFragment = DiagnoseNonAcsFragment.newInstance(mRecordId, "cpc_cbzdv2_facsxyxxt");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNonAcsFragment);
                        break;
                    case 6:
                        // 其它非心源性胸痛
                        if (mNonHeartPainFragment == null) {
                            mNonHeartPainFragment = DiagnoseNonHeartPainFragment.newInstance(mRecordId, "cpc_cbzdv2_qtfxyxxt");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNonHeartPainFragment);
                        break;
                    case 7:
                        // 待查
                        if (mWaitDiagnoseFragment == null) {
                            mWaitDiagnoseFragment = DiagnoseWaitDiagnoseFragment.newInstance(mRecordId, "cpc_cbzdv2_dc");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mWaitDiagnoseFragment);
                        break;
                    default:
                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }


    /**
     * 胸痛 初始诊断保存
     */
    public void saveChestPainDiagnosis(ChestPainDiagnosisBean chestPainDiagnosisBean) {

        showLoadingDialog();
        String request = GsonUtils.getGson().toJson(chestPainDiagnosisBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseSave(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
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
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    /**
     * 胸痛 初始诊断查询
     */
    public void getChestPainDiagnoseGet(String recordId) {
        showLoadingDialog();
        //调用获取数据接口
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGet(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<ChestPainDiagnosisBean.ChestPainResponseBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<ChestPainDiagnosisBean.ChestPainResponseBean>> call, Response<BaseObjectBean<ChestPainDiagnosisBean.ChestPainResponseBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                if (response.body().getData() != null) {
                                    showToast("查询数据成功");
                                    ChestPainDiagnosisBean.ChestPainResponseBean data = response.body().getData();

                                    if (onGetChestPainDiagnoseData != null) {
                                        onGetChestPainDiagnoseData.getChestPainDiagnoseData(data);
                                    }
                                }
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<ChestPainDiagnosisBean.ChestPainResponseBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    /**
     * 胸痛--初始诊断--患者绕行--编辑
     */
    public void saveChestPainDiagnosePatientsDetour(ChestPainPatientsDetourBean bean) {
        if (bean == null) {
            return;
        }
        showLoadingDialog();
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnosePatientsDetourEdit(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {

                            } else {
                                showToast(response.body().getMessage());
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


    /**
     * 胸痛--初始诊断--患者绕行--查询
     */
    public void getChestPainDiagnosePatientsDetour(String recordId) {
        showLoadingDialog();
        //调用获取数据接口
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnosePatientsDetourGet(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean>> call, Response<BaseObjectBean<ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                if (response.body().getData() != null) {

                                    ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean data = response.body().getData();
                                    if (onGetChestPainResponsePatientsDetourData != null) {
                                        onGetChestPainResponsePatientsDetourData.getChestPainResponsePatientsDetourData(data);
                                    }
                                }

                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    /**
     * 胸痛--初始诊断--Grace--保存
     */
    public void saveChestPainDiagnoseGrace(ChestpainGraceScoreBean bean) {
        if (bean == null) {
            return;
        }
        showLoadingDialog();
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGraceSave(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {

                            } else {
                                showToast(response.body().getMessage());
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


    /**
     * 胸痛--初始诊断--Grace--获取
     */
    public void getChestPainDiagnoseGrace(String recordId) {
        showLoadingDialog();
        //调用获取数据接口
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGraceGet(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean>> call, Response<BaseObjectBean<ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean data = response.body().getData();
                                if (onGetChestPainDiagnoseGraceData != null) {
                                    onGetChestPainDiagnoseGraceData.getChestPainDiagnoseGraceData(data);
                                }
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    //返回胸痛--初始诊断--Grace--
    public interface OnGetChestPainDiagnoseGraceData {
        void getChestPainDiagnoseGraceData(ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean data);
    }

    private OnGetChestPainDiagnoseGraceData onGetChestPainDiagnoseGraceData;

    public void setOnGetChestPainDiagnoseGraceData(OnGetChestPainDiagnoseGraceData onGetChestPainDiagnoseGraceData) {
        this.onGetChestPainDiagnoseGraceData = onGetChestPainDiagnoseGraceData;
    }


    //返回胸痛--初始诊断-获取bean
    public interface OnGetChestPainDiagnoseData {
        void getChestPainDiagnoseData(ChestPainDiagnosisBean.ChestPainResponseBean data);
    }

    private OnGetChestPainDiagnoseData onGetChestPainDiagnoseData;


    public void setOnGetChestPainDiagnoseData(OnGetChestPainDiagnoseData onGetChestPainDiagnoseData) {
        this.onGetChestPainDiagnoseData = onGetChestPainDiagnoseData;
    }

    //返回胸痛--初始诊断--患者绕行获取bean
    public interface OnGetChestPainResponsePatientsDetourData {
        void getChestPainResponsePatientsDetourData(ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean data);
    }

    private OnGetChestPainResponsePatientsDetourData onGetChestPainResponsePatientsDetourData;

    public void setOnGetChestPainResponsePatientsDetourData(OnGetChestPainResponsePatientsDetourData onGetChestPainResponsePatientsDetourData) {
        this.onGetChestPainResponsePatientsDetourData = onGetChestPainResponsePatientsDetourData;
    }


}
