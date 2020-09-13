package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.EmergencyCenterStrokeAneurysmSurgeryData;
import com.xyj.strokeaid.activity.stroke.EmergencyCenterStrokeAneurysmSurgeryPoBean;
import com.xyj.strokeaid.adapter.StrokeAneurysmAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 动脉瘤
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokArterialAneurysmFragment extends BaseStrokeFragment {
    protected static final int REUEST_CODDE_ADD = 0;
    protected static final int REUEST_CODDE_EDIT = 1;
    /**
     * 动脉瘤责任血管部位 新增
     */
    @BindView(R.id.tv_add_aneurysm)
    TextView tvAneurysmAdd;
    @BindView(R.id.rl_add_aneurysm)
    RelativeLayout rlAddAneurysm;
    @BindView(R.id.rv_aneurysm)
    RecyclerView rvAneurysm;
    private String mRecordId;
    private StrokeAneurysmAddDialogFragment strokeAneurysmAddDialogFragment;
    List<EmergencyCenterStrokeAneurysmSurgeryPoBean> dataList;//新增动脉瘤
    StrokeAneurysmAdapter strokeAneurysmAdapter;
    private EmergencyCenterStrokeAneurysmSurgeryData emergencyCenterStrokeAneurysmSurgeryData;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    //当前点击
    private int currentPosition = -1;

    public StrokArterialAneurysmFragment() {
        // Required empty public constructor
    }

    public static StrokArterialAneurysmFragment newInstance(String recordId) {
        StrokArterialAneurysmFragment fragment = new StrokArterialAneurysmFragment();
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
            Log.e("TAG", "onCreate: "+mRecordId );
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_arterial_aneurysm;
    }


    @Override
    protected void initView(@NonNull View view) {
        dataList = new ArrayList<>();
        strokeAneurysmAdapter = new StrokeAneurysmAdapter(R.layout.adapter_stroke_aneurysm, dataList);
        rvAneurysm.setLayoutManager(new LinearLayoutManager(context));
        rvAneurysm.setAdapter(strokeAneurysmAdapter);
        getAneurysm(mRecordId);
    }

    @Override
    protected void initListener() {
        rlAddAneurysm.setOnClickListener(v -> {
            if (dataList.size()<4){
                strokeAneurysmAddDialogFragment = new StrokeAneurysmAddDialogFragment().newInstance(mRecordId, "add",null);
                strokeAneurysmAddDialogFragment.setTargetFragment(StrokArterialAneurysmFragment.this,REUEST_CODDE_ADD);
                strokeAneurysmAddDialogFragment.show(getFragmentManager(), "add_dialog");
            }else {
                showToast("动脉瘤数量最多4个");
            }
        });
        strokeAneurysmAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                currentPosition = position;
                strokeAneurysmAddDialogFragment = new StrokeAneurysmAddDialogFragment().newInstance(mRecordId,"edit",dataList.get(position));
                strokeAneurysmAddDialogFragment.setTargetFragment(StrokArterialAneurysmFragment.this,REUEST_CODDE_EDIT);
                strokeAneurysmAddDialogFragment.show(getFragmentManager(), "edit_dialog");
            }
        });
        btnGetData.setOnClickListener(v -> {
            getAneurysm(mRecordId);
        });
        btnConfirm.setOnClickListener(v -> {
            emergencyCenterStrokeAneurysmSurgeryData = new EmergencyCenterStrokeAneurysmSurgeryData();
            emergencyCenterStrokeAneurysmSurgeryData.setAneurysmoperationpartarray(dataList);
            Log.e("TAG", "initListener: "+new Gson().toJson(emergencyCenterStrokeAneurysmSurgeryData) );
            saveAneurysm(emergencyCenterStrokeAneurysmSurgeryData);
        });

    }

    private void getAneurysm(String mRecordId) {
        showLoadingDialog();
        BaseRequestBean<EmergencyCenterStrokeAneurysmSurgeryData> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new EmergencyCenterStrokeAneurysmSurgeryData());

        RetrofitClient.getInstance()
                .getApi()
                .getAneurysm(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<EmergencyCenterStrokeAneurysmSurgeryData>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<EmergencyCenterStrokeAneurysmSurgeryData>> call,
                                           Response<BaseResponseBean<EmergencyCenterStrokeAneurysmSurgeryData>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                if ( response.body().getData().getData().getAneurysmoperationpartarray()!=null){
                                    if (!dataList.isEmpty()){
                                        dataList.clear();
                                    }
                                    dataList.addAll(response.body().getData().getData().getAneurysmoperationpartarray())  ;
                                    Log.e("TAG", "onResponse: "+new Gson().toJson(dataList) );
                                    strokeAneurysmAdapter.notifyDataSetChanged();
                                }

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<EmergencyCenterStrokeAneurysmSurgeryData>> call, Throwable t) {
                        hideLoadingDialog();
                        Log.e("TAG", "onFailure: "+t.getMessage().toString());
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 动脉瘤
     * @param emergencyCenterStrokeAneurysmSurgeryData
     */
    private void saveAneurysm(EmergencyCenterStrokeAneurysmSurgeryData emergencyCenterStrokeAneurysmSurgeryData) {
        BaseRequestBean<EmergencyCenterStrokeAneurysmSurgeryData> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 1, emergencyCenterStrokeAneurysmSurgeryData);

        RetrofitClient.getInstance()
                .getApi()
                .saveAneurysm(baseRequestBean.getResuestBody(baseRequestBean))
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REUEST_CODDE_ADD) {
            SparseArray<EmergencyCenterStrokeAneurysmSurgeryData> sss = new SparseArray<>();

            dataList.add((EmergencyCenterStrokeAneurysmSurgeryPoBean) data.getExtras().get("ADD"));
            strokeAneurysmAdapter.notifyDataSetChanged();
        }else if (requestCode==REUEST_CODDE_EDIT){
            dataList.set(currentPosition,(EmergencyCenterStrokeAneurysmSurgeryPoBean) data.getExtras().get("EDIT"));
            strokeAneurysmAdapter.notifyDataSetChanged();
        }
    }
}
