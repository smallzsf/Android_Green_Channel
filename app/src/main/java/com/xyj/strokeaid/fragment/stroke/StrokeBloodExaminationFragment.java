package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.photoview.PhotoView;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.PhotoViewActivity;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeBloodExaminationBean;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.FileServiceImpl;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

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

    private ChestPainImageExaminationBean.DataBean data;
    private SparseArray<LocalMedia> mLocalMedias;
    private final int CT_PHOTO = 1;
    private final int CT_REPORT = 2;
    private StrokeBloodExaminationBean strokeBloodExaminationBean;
    private List<FileInfoBean> data1;


    public static StrokeBloodExaminationFragment newInstance(String recordId) {
        StrokeBloodExaminationFragment fragment = new StrokeBloodExaminationFragment();
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
        return R.layout.stroke_fragment_blood_examination;
    }

    @Override
    protected void initView(@NonNull View view) {

        mLocalMedias = new SparseArray<>();
        sbBloodType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionSheet(sbBloodType, "A型", "B型", "AB型", "O型");
            }
        });

        //  Glide.with(getActivity()).load("http://ykj.yjjk366.com//upload/files/20200914/b0046459-6f67-457c-9ead-812e17de0e0f.jpg").into(ivPicture);
        loadBloodExaminationData();
        if (strokeBloodExaminationBean == null) {
            strokeBloodExaminationBean = new StrokeBloodExaminationBean();
        }
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.sb_blood_report, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_blood_report:
                //ct片子上传
                showPhotoSelector(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {

                        if (result != null && result.size() > 0) {
                            LocalMedia localMedia = result.get(0);

                            LogUtils.d(localMedia.toString());
                            mLocalMedias.put(CT_PHOTO, localMedia);
                            ToastUtils.showShort(localMedia.getRealPath());
                            FileServiceImpl.uploadImage("emergency_center_chestpain_imaging_examination",localMedia.getRealPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
                                @Override
                                public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                                    if (response.body() != null) {
                                        List<FileInfoBean> data = response.body().getData();
                                        ToastUtils.showShort(data.toString());

                                        if (response.body().getResult() == 1) {
                                            showToast("数据保存成功");
                                            if (data != null) {
                                                sbBloodReport.setRightText("查看");
                                                strokeBloodExaminationBean.setBloodreport(data.get(0).getPath());
                                                sbBloodReport.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        LogUtils.d(data.toString());
                                                        Intent intent = new Intent(getActivity(), PhotoViewActivity.class);
                                                        intent.putExtra("image", data.get(0).getPath());
                                                        startActivity(intent);
                                                    }
                                                });

                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<BaseArrayBean<FileInfoBean>> call, Throwable t) {
                                    LogUtils.d(t.getMessage());
                                }
                            });
                        }


                    }

                    @Override
                    public void onCancel() {

                    }
                }, new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {

                        // 相册
                        if (result != null && result.size() > 0) {
                            LocalMedia localMedia = result.get(0);
                            LogUtils.d(localMedia.toString());
                            mLocalMedias.put(CT_PHOTO, localMedia);

                            FileServiceImpl.uploadImage("emergency_center_chestpain_imaging_examination", localMedia.getRealPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
                                @Override
                                public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                                    if (response.body() != null) {
                                        data1 = response.body().getData();
                                        if (response.body().getResult() == 1) {
                                            showToast("数据保存成功");
                                            if (data1 != null) {
                                                if (!TextUtils.isEmpty(data1.get(0).getPath())) {
                                                    strokeBloodExaminationBean.setBloodreport(data1.get(0).getPath());
                                                    sbBloodReport.setRightText("查看");
                                                    sbBloodReport.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            LogUtils.d(data1.toString());

                                                            Intent intent = new Intent(getActivity(), PhotoViewActivity.class);
                                                            intent.putExtra("image", data1.get(0).getPath());
                                                            startActivity(intent);
                                                        }
                                                    });
                                                }

                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<BaseArrayBean<FileInfoBean>> call, Throwable t) {
                                    LogUtils.d(t.getMessage());
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
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


        strokeBloodExaminationBean.setBloodcollectiontime(ttbBloodSamplingTime.getTime());
        strokeBloodExaminationBean.setBloodsendbegintime(ttbBloodInspectTime.getTime());
        strokeBloodExaminationBean.setBloodarrivecheckdepartmenttime(ttbSendVerifyLabTime.getTime());
        strokeBloodExaminationBean.setBloodinspectionbegintime(ttbStartVerifyTime.getTime());
        strokeBloodExaminationBean.setBloodreporttime(ttbBloodReportTime.getTime());
        strokeBloodExaminationBean.setBloodgroup(sbBloodType.getRightText().toString());
        strokeBloodExaminationBean.setFingerbloodsugar(iebFingertipBlood.getEditContent());
        strokeBloodExaminationBean.setVenousbloodsugar(iebVeinBlood.getEditContent());


        BaseRequestBean<StrokeBloodExaminationBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, strokeBloodExaminationBean);

        RetrofitClient
                .getInstance()
                .getApi()
                .saveBloodExaminationInfo(baseRequestBean.getResuestBody(baseRequestBean))
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

    private void loadBloodExaminationData() {

        BaseRequestBean<StrokeBloodExaminationBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeBloodExaminationBean());

        RetrofitClient.getInstance()
                .getApi()
                .getBloodExaminationInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeBloodExaminationBean>>() {


                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeBloodExaminationBean>> call,
                                           Response<BaseResponseBean<StrokeBloodExaminationBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                strokeBloodExaminationBean = response.body().getData().getData();
                                if (strokeBloodExaminationBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    getStrokeBloodExaminationBean(strokeBloodExaminationBean);
                                }


                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeBloodExaminationBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    private void getStrokeBloodExaminationBean(StrokeBloodExaminationBean strokeBloodExaminationBean) {
        ttbBloodSamplingTime.setTime(strokeBloodExaminationBean.getBloodcollectiontime());
        ttbBloodInspectTime.setTime(strokeBloodExaminationBean.getBloodsendbegintime());
        ttbSendVerifyLabTime.setTime(strokeBloodExaminationBean.getBloodarrivecheckdepartmenttime());
        ttbStartVerifyTime.setTime(strokeBloodExaminationBean.getBloodinspectionbegintime());
        ttbBloodReportTime.setTime(strokeBloodExaminationBean.getBloodreporttime());
        sbBloodType.setRightText(strokeBloodExaminationBean.getBloodgroup());
        iebFingertipBlood.setEditContent(strokeBloodExaminationBean.getFingerbloodsugar());
        iebVeinBlood.setEditContent(strokeBloodExaminationBean.getVenousbloodsugar());
        if (!TextUtils.isEmpty(strokeBloodExaminationBean.getBloodreport())) {
            sbBloodReport.setRightText("查看");
            sbBloodReport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getActivity(), PhotoViewActivity.class);
                    intent.putExtra("image", strokeBloodExaminationBean.getBloodreport());
                    startActivity(intent);
                }
            });
        }

    }


}
