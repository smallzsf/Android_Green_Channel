package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeOtherDisposalBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextSwitchBar;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * OtherDisposalFragment
 * description: 其他处置
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class OtherDisposalFragment extends BaseFragment {


    @BindView(R.id.tsb_accept_recovery_frag_od)
    TextSwitchBar tsbAcceptRecoveryFragOd;
    @BindView(R.id.cb_tradition_frag_od)
    CheckBox cbTraditionFragOd;
    @BindView(R.id.cb_pt_frag_od)
    CheckBox cbPtFragOd;
    @BindView(R.id.cb_ot_frag_od)
    CheckBox cbOtFragOd;
    @BindView(R.id.cb_st_frag_od)
    CheckBox cbStFragOd;
    @BindView(R.id.cb_other_recovery_frag_od)
    CheckBox cbOtherRecoveryFragOd;
    @BindView(R.id.cb_bedside_frag_od)
    CheckBox cbBedsideFragOd;
    @BindView(R.id.cb_recovery_depart_frag_od)
    CheckBox cbRecoveryDepartFragOd;
    @BindView(R.id.ll_recovery_type_frag_od)
    LinearLayout llRecoveryTypeFragOd;
    @BindView(R.id.ll_recovery_frag_od)
    LinearLayout llRecoveryFragOd;
    @BindView(R.id.tsb_edu_frag_od)
    TextSwitchBar tsbEduFragOd;
    @BindView(R.id.cb_group_frag_od)
    CheckBox cbGroupFragOd;
    @BindView(R.id.cb_one_frag_od)
    CheckBox cbOneFragOd;
    @BindView(R.id.cb_other_edu_frag_od)
    CheckBox cbOtherEduFragOd;
    @BindView(R.id.ll_edu_type_frag_od)
    LinearLayout llEduTypeFragOd;
    @BindView(R.id.ll_edu_frag_od)
    LinearLayout llEduFragOd;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    private String mRecordId;
    StrokeOtherDisposalBean strokeOtherDisposalBean = null;

    public static OtherDisposalFragment newInstance(String recordId) {
        OtherDisposalFragment fragment = new OtherDisposalFragment();
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
        return R.layout.stroke_fragment_other_disposal;
    }

    @Override
    protected void initView(@NonNull View view) {

        // scAcceptRecoveryViewTsb.setOnClickListener(this);
        llRecoveryTypeFragOd.setVisibility(View.GONE);
        llEduTypeFragOd.setVisibility(View.GONE);
        tsbAcceptRecoveryFragOd.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llRecoveryTypeFragOd.setVisibility(View.VISIBLE);
                } else {
                    llRecoveryTypeFragOd.setVisibility(View.GONE);
                }

            }
        });
        tsbEduFragOd.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llEduTypeFragOd.setVisibility(View.VISIBLE);
                } else {
                    llEduTypeFragOd.setVisibility(View.GONE);
                }

            }
        });

        loadOtherDisposalData();


    }

    @Override
    protected void initListener() {

    }


    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        if (strokeOtherDisposalBean == null) {
            strokeOtherDisposalBean = new StrokeOtherDisposalBean();
        }

        SwitchCompat switchCompat = tsbAcceptRecoveryFragOd.findViewById(R.id.sc_view_tsb);
        if ( switchCompat.isChecked()){
            strokeOtherDisposalBean.setRecoveringtreatmentisaccept(Constants.BOOL_TRUE);
        }else {
            strokeOtherDisposalBean.setRecoveringtreatmentisaccept(Constants.BOOL_FALSE);
        }

        String recoverIngtreatmentWaysValue = getCheckBoxValue(cbTraditionFragOd, cbPtFragOd, cbOtFragOd, cbStFragOd, cbOtherRecoveryFragOd);
        strokeOtherDisposalBean.setRecoveringtreatmentways(recoverIngtreatmentWaysValue);
        String recoverIngtreatmentPlaceValue = getCheckBoxValue(cbBedsideFragOd, cbRecoveryDepartFragOd);
        strokeOtherDisposalBean.setRecoveringtreatmentplace(recoverIngtreatmentPlaceValue);

        SwitchCompat switchCompat1 = tsbEduFragOd.findViewById(R.id.sc_view_tsb);
        if ( switchCompat1.isChecked()){
            strokeOtherDisposalBean.setEducationway(Constants.BOOL_TRUE);
        }else {
            strokeOtherDisposalBean.setEducationway(Constants.BOOL_FALSE);
        }


        String healtheducationValue = getCheckBoxValue(cbGroupFragOd, cbOneFragOd,cbOtherEduFragOd);
        strokeOtherDisposalBean.setHealtheducation(healtheducationValue);
        saveOtherDisposalData(strokeOtherDisposalBean);
    }


    private void saveOtherDisposalData(StrokeOtherDisposalBean strokeOtherDisposalBean) {

        BaseRequestBean<StrokeOtherDisposalBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, strokeOtherDisposalBean);

       RetrofitClient
                .getInstance()
                .getApi()
                .saveOtherDisposalData(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
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
                        showToast(call.toString());
                    }
                });

    }

    private void loadOtherDisposalData() {


        BaseRequestBean<StrokeOtherDisposalBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeOtherDisposalBean());

        RetrofitClient.getInstance()
                .getApi()
                .getOtherDisposalData(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeOtherDisposalBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeOtherDisposalBean>> call,
                                           Response<BaseResponseBean<StrokeOtherDisposalBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                strokeOtherDisposalBean = response.body().getData().getData();
                                if (strokeOtherDisposalBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getOtherDisposalData(strokeOtherDisposalBean);
                                }


                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }



                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeOtherDisposalBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    private void getOtherDisposalData(StrokeOtherDisposalBean strokeOtherDisposalBean) {
      //  strokeOtherDisposalBean.getEducationway();


       if(strokeOtherDisposalBean.getRecoveringtreatmentisaccept().equals(Constants.BOOL_TRUE)){
           tsbAcceptRecoveryFragOd.setSwitch(true);
       }else {
           tsbAcceptRecoveryFragOd.setSwitch(false);
       }

        String recoveringtreatmentways = strokeOtherDisposalBean.getRecoveringtreatmentways();
        if (!TextUtils.isEmpty(recoveringtreatmentways)) {
            cbTraditionFragOd.setChecked(recoveringtreatmentways.contains(cbTraditionFragOd.getTag().toString()));
            cbPtFragOd.setChecked(recoveringtreatmentways.contains(cbPtFragOd.getTag().toString()));
            cbOtFragOd.setChecked(recoveringtreatmentways.contains(cbOtFragOd.getTag().toString()));
            cbStFragOd.setChecked(recoveringtreatmentways.contains(cbStFragOd.getTag().toString()));
            cbOtherRecoveryFragOd.setChecked(recoveringtreatmentways.contains(cbOtherRecoveryFragOd.getTag().toString()));
        }
        String recoveringtreatmentplace = strokeOtherDisposalBean.getRecoveringtreatmentplace();
        if (!TextUtils.isEmpty(recoveringtreatmentplace)) {
            cbBedsideFragOd.setChecked(recoveringtreatmentplace.contains(cbBedsideFragOd.getTag().toString()));
            cbRecoveryDepartFragOd.setChecked(recoveringtreatmentplace.contains(cbRecoveryDepartFragOd.getTag().toString()));

        }

        if(strokeOtherDisposalBean.getEducationway().equals(Constants.BOOL_TRUE)){
            tsbEduFragOd.setSwitch(true);
        }else {
            tsbEduFragOd.setSwitch(false);
        }
        String healtheducation = strokeOtherDisposalBean.getHealtheducation();
        if (!TextUtils.isEmpty(healtheducation)) {
            cbGroupFragOd.setChecked(healtheducation.contains(cbGroupFragOd.getTag().toString()));
            cbOneFragOd.setChecked(healtheducation.contains(cbOneFragOd.getTag().toString()));
            cbOtherEduFragOd.setChecked(healtheducation.contains(cbOtherEduFragOd.getTag().toString()));

        }



    }


}