package com.xyj.strokeaid.fragment.chestpain;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBena;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @ClassName: OriginalDiagnoseFragment
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/2 19:09
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

        esTitleSelect.setItemData(Arrays.asList(getResources().getStringArray(R.array.original_diagnose)));
    }

    @Override
    protected void initListener() {
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
                            mNonHeartPainFragment = DiagnoseNonHeartPainFragment.newInstance(mRecordId, "cpc_cbzdv2_facsxyxxt");
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
    public  void saveChestPainDiagnosis(ChestPainDiagnosisBean chestPainDiagnosisBean) {

        ToastUtils.showShort("1");
        String request = GsonUtils.getGson().toJson(chestPainDiagnosisBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseSave(requestBody)
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


    /**
     * 胸痛 初始诊断查询
     */
    public  void getChestPainDiagnoseGet() {

        //调用获取数据接口
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(mRecordId);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGet(requestBody)
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



    /**
     * 胸痛--初始诊断--患者绕行--编辑
     */
    public  void saveChestPainDiagnosePatientsDetour(ChestPainPatientsDetourBena chestPainPatientsDetourBena) {
        ToastUtils.showShort("2");
        String request = GsonUtils.getGson().toJson(chestPainPatientsDetourBena);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnosePatientsDetourEdit(requestBody)
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


    /**
     * 胸痛--初始诊断--患者绕行--查询
     */
    public  void getChestPainDiagnosePatientsDetour() {
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(mRecordId);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnosePatientsDetourGet(requestBody)
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



    /**
     * 胸痛--初始诊断--Grace--保存
     */
    public  void saveChestPainDiagnoseGrace(ChestpainGraceScoreBean chestpainGraceScoreBean) {
        ToastUtils.showShort("3");
        String request = GsonUtils.getGson().toJson(chestpainGraceScoreBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGraceSave(requestBody)
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


    /**
     *胸痛--初始诊断--Grace--获取
     */
    public  void getChestPainDiagnoseGrace() {
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(mRecordId);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiagnoseGraceGet(requestBody)
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
