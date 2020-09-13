package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.InformedConsentBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;
import com.xyj.strokeaid.http.FileServiceImpl;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @Description: 介入知情同意
 * * @Author: crq
 * @CreateDate: 2020/8/29 14:21
 */
@Route(path = RouteUrl.Stroke.STROKE_GET_INVOLVED_INFORMED_CONSENT)
public class GetInvolvedInformedConsentActivity extends BaseActivity {

    @BindView(R.id.es_doc_act_tic)
    EditSpinner esDocActTic;
    @BindView(R.id.title_bar_act_tic)
    BaseTitleBar titleBarActTic;
    @BindView(R.id.rb_agree)
    RadioButton rbAgree;
    @BindView(R.id.rb_refuse)
    RadioButton rbRefuse;
    @BindView(R.id.iv_heart)
    ImageView ivHeart;
    @BindView(R.id.tv_ecg_examine_and_shot)
    TextView tvEcgExamineAndShot;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.tb_start_know)
    TextTimeBar tbStartKnow;
    @BindView(R.id.tb_sign_know)
    TextTimeBar tbSignKnow;
    @BindView(R.id.rg_family_opinion)
    RadioGroup rgFamilyOpinion;

    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;
    @BindView(R.id.look_informed_notice)
    LinearLayout lookInformedNotice;

    private InformedConsentBean informedConsentBean = new InformedConsentBean();

    private SparseArray<LocalMedia> mLocalMedias;
    private final int CT_PHOTO = 1;
    private final int CT_REPORT = 2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_get_involved_informed_consent;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mLocalMedias = new SparseArray<>();
        // TODO: 2020/9/13 测试代码
        mRecordId = "1111";
        loadData();

    }

    @Override
    public void initListener() {


    }

    private void loadData() {
        // 设置标题跳转
        titleBarActTic.setLeftLayoutClickListener(v -> finish());
        //急诊医生
        ArrayList<String> emergencyTreatmentDoctorList = new ArrayList<>();
        emergencyTreatmentDoctorList.add("请选择");
        emergencyTreatmentDoctorList.add("刘超");
        emergencyTreatmentDoctorList.add("原晋毅");
        emergencyTreatmentDoctorList.add("田郑恩");
        emergencyTreatmentDoctorList.add("刘敬玺");
        emergencyTreatmentDoctorList.add("束颖");
        emergencyTreatmentDoctorList.add("曹轮飞");
        emergencyTreatmentDoctorList.add("丁青梅");
        emergencyTreatmentDoctorList.add("刘蕾");
        emergencyTreatmentDoctorList.add("程亚辉");
        esDocActTic.setItemData(emergencyTreatmentDoctorList);
        //家属意见
//        ArrayList<String> familyOpinionDoctorList = new ArrayList<>();
//        familyOpinionDoctorList.add("同意");
//        familyOpinionDoctorList.add("拒绝");
//        esFamilyOpinion.setItemData(familyOpinionDoctorList);
        rgFamilyOpinion.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_agree:
                    informedConsentBean.setEmbolectomypatientopinion(rbAgree.getText().toString());
                    break;
                case R.id.rb_refuse:
                    informedConsentBean.setEmbolectomypatientopinion(rbRefuse.getText().toString());
                    break;
                default:
                    break;
            }
        });
        //确定
        btnConfirm.setOnClickListener(v -> {
            informedConsentBean.setTalkdoctorJrzt(esDocActTic.getText());
            informedConsentBean.setEmbolectomypatientcommunicationsbegintime(tbStartKnow.getTime());
            informedConsentBean.setEmbolectomypatientcommunicationsendtime(tbSignKnow.getTime());
            save();
        });
        //取消
        btnCancel.setOnClickListener(v -> {

        });

        lookInformedNotice.setOnClickListener(v -> {
            showPhotoSelector(new OnResultCallbackListener<LocalMedia>() {

                @Override
                public void onResult(List<LocalMedia> result) {
                    // 拍照
                    if (result != null && result.size() > 0) {
                        LocalMedia localMedia = result.get(0);
                        LogUtils.d(localMedia.toString());
                        mLocalMedias.put(CT_PHOTO, localMedia);
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
                        FileServiceImpl.uploadImage("emergency_center_chestpain_imaging_examination", localMedia.getPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
                            @Override
                            public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                                if (response.body() != null) {
                                    List<FileInfoBean> data = response.body().getData();
                                    if (response.body().getResult() == 1) {
                                        showToast("数据保存成功");
                                        if (data != null) {
                                            LogUtils.d(data.toString());
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
        });

        getFamilyOpinion();
    }

    /**
     * 填充界面
     */
    private void setView() {
        esDocActTic.setText(informedConsentBean.getTalkdoctorJrzt());
        tbStartKnow.setTime(informedConsentBean.getEmbolectomypatientcommunicationsbegintime());
        tbSignKnow.setTime(informedConsentBean.getEmbolectomypatientcommunicationsendtime());
        if (informedConsentBean.getEmbolectomypatientopinion() != null) {
            if (informedConsentBean.getEmbolectomypatientopinion().equals("同意")) {
                rgFamilyOpinion.check(R.id.rb_agree);
            } else if (informedConsentBean.getEmbolectomypatientopinion().equals("拒绝")) {
                rgFamilyOpinion.check(R.id.btn_cancel);
            }
        }
    }

    /**
     * 获取介入知情同意基础信息
     */
    private void getFamilyOpinion() {
        BaseRequestBean<ChestPainTriageInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new ChestPainTriageInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getFamilyOpinion(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean<InformedConsentBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<InformedConsentBean>> call,
                                           Response<BaseObjectBean<InformedConsentBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                informedConsentBean = response.body().getData();
                                if (informedConsentBean != null) {
                                    setView();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<InformedConsentBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    /**
     * 保存到网络
     */
    private void save() {
        BaseRequestBean<InformedConsentBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, informedConsentBean);

        RetrofitClient.getInstance()
                .getApi()
                .saveFamilyOpinion(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean> call,
                                           Response<BaseResponseBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

}

    
    
       
    