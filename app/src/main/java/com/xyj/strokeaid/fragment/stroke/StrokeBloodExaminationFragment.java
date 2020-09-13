package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 卒中血液检查
 * @Author: crq
 * @CreateDate: 2020/8/25 14:07
 */
public class StrokeBloodExaminationFragment extends BaseStrokeFragment {


    @BindView(R.id.rv_blood_text_details)
    RecyclerView rvBloodTextDetails;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.sb_blood_type)
    SettingBar sbBloodType;
    @BindView(R.id.ttb_blood_sampling_time)
    TextTimeBar ttbBloodSamplingTime;
    @BindView(R.id.ttb_blood_inspect_time)
    TextTimeBar ttbBloodInspectTime;
    @BindView(R.id.ttb_send_verify_lab_time)
    TextTimeBar ttbSendVerifyLabTime;
    @BindView(R.id.ttb_start_verify_time)
    TextTimeBar ttbStartVerifyTime;
    @BindView(R.id.ttb_blood_report_time)
    TextTimeBar ttbBloodReportTime;
    @BindView(R.id.ieb_fingertip_blood)
    ItemEditBar iebFingertipBlood;
    @BindView(R.id.ieb_vein_blood)
    ItemEditBar iebVeinBlood;
    @BindView(R.id.sb_blood_report)
    SettingBar sbBloodReport;

    public static StrokeBloodExaminationFragment newInstance(String recordId) {
        StrokeBloodExaminationFragment fragment = new StrokeBloodExaminationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_blood_examination;
    }

    @Override
    protected void initView(@NonNull View view) {
        sbBloodType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionSheet(sbBloodType, "A型", "B型", "AB型", "O型");
            }
        });

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.sb_blood_report, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_blood_report:
                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                saveBloodExaminationData();
                break;
        }
    }


    private void showActionSheet(SettingBar settingBar, String... strings) {
        ActionSheet.createBuilder(getActivity(), getActivity().getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles(strings)
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {

                        settingBar.setRightText(strings[index]);

                    }
                }).show();
    }


    private void saveBloodExaminationData() {

        BaseRequestBean<ChestPainTriageInfoBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 2, null);

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

    private void loadBloodExaminationData(String recordId) {

        BaseRequestBean<ChestPainTriageInfoBean> baseRequestBean = new BaseRequestBean<>(
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
                             /*   mStrokeTrigaeInfoBean = response.body().getData().getData();
                                if (mStrokeTrigaeInfoBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getDatatoStrokeViews(mStrokeTrigaeInfoBean);
                                }*/
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


}
