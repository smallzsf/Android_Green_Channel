package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.xyj.strokeaid.bean.ThrombolysisTreatmentBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;
import com.xyj.strokeaid.event.ScoreEvent;
import com.xyj.strokeaid.http.FileServiceImpl;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @Description: 溶栓治疗
 * @Author: ck
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_TREATMENT)
public class ThrombolysisTreatmentActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_treatment)
    BaseTitleBar titleBarActTreatment;
    /**
     * 谈话医生
     */
    @BindView(R.id.es_talk_doctor)
    EditSpinner esTalkDoctor;
    /**
     * 开始知情同意
     */
    @BindView(R.id.ttb_begin_know_time)
    TextTimeBar ttbBeginKnowTime;
    /**
     * 签署知情同意
     */
    @BindView(R.id.ttb_sign_know_time)
    TextTimeBar ttbSignKnowTime;
    /**
     * 家属意见
     */
    @BindView(R.id.rb_family_opinion_agree)
    RadioButton rbFamilyOpinionAgree;
    @BindView(R.id.rb_family_opinion_disagree)
    RadioButton rbFamilyOpinionDisagree;
    /**
     *  查看知情同意书
     */
    @BindView(R.id.tv_book_upload)
    TextView tvBookUpload;
    /**
     * THRIVE评分
     */
    @BindView(R.id.ieb_thrive)
    ItemEditBar iebThrive;
    /**
     * 溶栓前NIHSS
     */
    @BindView(R.id.itb_brfor_nihss)
    ItemEditBar itbBrforNihss;
    @BindView(R.id.es_thrombolysis_address)
    EditSpinner esThrombolysisAddress;
    @BindView(R.id.es_thrombolysis_doctor)
    EditSpinner esThrombolysisDoctor;
    /**
     * 静脉溶栓静推时间
     */
    @BindView(R.id.ttb_begin_jmrs_time)
    TextTimeBar ttbBeginJmrsTime;
    /**
     * 发病至溶栓时间时间差
     */
    @BindView(R.id.ieb_fbzrs)
    ItemEditBar iebFbzrs;
    /**
     * 入门至溶栓时间时间差
     */
    @BindView(R.id.ieb_dyzrs)
    ItemEditBar iebDyzrs;
    /**
     * 溶栓药物  rt-PA  尿激酶
     */
    @BindView(R.id.rb_medicine_pa)
    RadioButton rbMedicinePa;
    @BindView(R.id.rb_medicine_njm)
    RadioButton rbMedicineNjm;

    /**
     * 剂量类型
     */
    @BindView(R.id.rg_medicine)
    RadioGroup rgMedicine;
    @BindView(R.id.rb_dose_type_nine)
    RadioButton rbDoseTypeNine;
    @BindView(R.id.rb_dose_type_six)
    RadioButton rbDoseTypeSix;

    /**
     *  rt-PA ------
     */
    @BindView(R.id.rg_dose_type)
    RadioGroup rgDoseType;
    @BindView(R.id.ieb_yjjl)
    ItemEditBar iebYjjl;
    @BindView(R.id.ieb_sjjtjl)
    ItemEditBar iebSjjtjl;
    @BindView(R.id.ieb_sjdzjl)
    ItemEditBar iebSjdzjl;
    @BindView(R.id.sjyyjl)
    ItemEditBar sjyyjl;
    @BindView(R.id.ieb_sjjlbz)
    ItemEditBar iebSjjlbz;
    @BindView(R.id.ll_rtpa_layout)
    LinearLayout llRtpaLayout;

    /**
     * 尿激酶 ----
     */
    @BindView(R.id.rg_use_dose)
    RadioGroup rgUseDose;
    @BindView(R.id.ll_njm_layout)
    LinearLayout llNjmLayout;
    @BindView(R.id.rb_dose_100)
    RadioButton rbDose100;
    @BindView(R.id.rb_dose_125)
    RadioButton rbDose125;
    @BindView(R.id.rb_dose_150)
    RadioButton rbDose150;

    /**
     * 血管再通
     */
    @BindView(R.id.rb_vessel_yes)
    RadioButton rbVesselYes;
    @BindView(R.id.rb_vessel_no)
    RadioButton rbVesselNo;
    @BindView(R.id.rg_vessel)
    RadioGroup rgVessel;
    /**
     * 血管再通  选项
     */
    @BindView(R.id.cpc_jmrsbfz_lncx)
    CheckBox cpcJmrsbfzLncx;
    @BindView(R.id.cpc_jmrsbfz_xhdcx)
    CheckBox cpcJmrsbfzXhdcx;
    @BindView(R.id.cpc_jmrsbfz_yycx)
    CheckBox cpcJmrsbfzYycx;
    @BindView(R.id.cpc_jmrsbfz_otherbwcx)
    CheckBox cpcJmrsbfzOtherbwcx;
    @BindView(R.id.cpc_jmrsbfz_zgzss)
    CheckBox cpcJmrsbfzZgzss;
    @BindView(R.id.cpc_jmrsbfz_xgyxcssz)
    CheckBox cpcJmrsbfzXgyxcssz;
    @BindView(R.id.cpc_jmrsbfz_qt)
    CheckBox cpcJmrsbfzQt;
    @BindView(R.id.cpc_jmrsbfz_w)
    CheckBox cpcJmrsbfzW;

    /**
     * 其他溶栓并发症
     */
    @BindView(R.id.itb_vessel_other)
    ItemEditBar itbVesselOther;

    /**
     * 溶栓结束后即刻NIHSS
     */
    @BindView(R.id.ieb_now_nihss)
    ItemEditBar iebNowNihss;
    @BindView(R.id.ieb_day_nihss)
    ItemEditBar iebDayNihss;
    @BindView(R.id.ieb_weak_nihss)
    ItemEditBar iebWeakNihss;

    /**
     *  静脉溶栓延误原因
     */
    @BindView(R.id.cpc_wjyxgnzldyy_fdxgbb)
    CheckBox cpcWjyxgnzldyyFdxgbb;
    @BindView(R.id.cpc_wjyxgnzldyy_csjc)
    CheckBox cpcWjyxgnzldyyCsjc;
    @BindView(R.id.cpc_wjyxgnzldyy_jjz)
    CheckBox cpcWjyxgnzldyyJjz;
    @BindView(R.id.cpc_wjyxgnzldyy_jsjj)
    CheckBox cpcWjyxgnzldyyJsjj;
    @BindView(R.id.cpc_wjyxgnzldyy_qt)
    CheckBox cpcWjyxgnzldyyQt;
    /**
     *  保存
     */
    @BindView(R.id.btn_save_data)
    AppCompatButton btnSaveData;

    /**
     * 家属不同意 原因
     */
    @BindView(R.id.rb_family_unagree_one)
    RadioButton rbFamilyUnagreeOne;
    @BindView(R.id.rb_family_unagree_two)
    RadioButton rbFamilyUnagreeTwo;
    @BindView(R.id.rb_family_unagree_three)
    RadioButton rbFamilyUnagreeThree;
    @BindView(R.id.ll_family_unagree_layout)
    LinearLayout llFamilyUnagreeLayout;
    // 其他原因 text
    @BindView(R.id.ieb_family_unagree_remark)
    ItemEditBar iebFamilyUnagreeRemark;

    private ProgressDialog loading;
    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

    /**
     * 家属拒绝原因
     */
    private String familyReason = "";
    /**
     * 知情同意书
     */
    private String pathUrl = "";
    /**
     * 溶栓药物 code
     */
    private String medicineCode = "";
    /**
     * 剂量类型 code
     */
    private String doseType = "";
    /**
     *  使用剂量 code
     */
    private String doseNumCode = "";

    /**
     *  溶栓并发症 code
     */
    private String thrombolyticCode = "";

    /**
     * 静脉溶栓延误原因  code
     */
    private String delayReasonCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_thrombolysis;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        loadLocalData();
        loadData(mRecordId);
    }

    @Override
    public void initListener() {
        // 返回
        titleBarActTreatment.setLeftLayoutClickListener(v -> finish());

        // THRIVE评分
        iebThrive.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THRIVE_SCORE)
                    .navigation();
        });

        // 溶栓前NIHSS
        itbBrforNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
                    .navigation();
        });

        // 溶栓后即刻NIHSS
        iebNowNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
                    .navigation();
        });

        // 溶栓后24hNIHSS
        iebDayNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
                    .navigation();
        });

        // 7±2天 NIHSS
        iebWeakNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
                    .navigation();
        });


    }

    /**
     * 溶栓并发症
     *
     * @param view
     * @param isChecked
     */
    @OnCheckedChanged({R.id.cpc_jmrsbfz_lncx, R.id.cpc_jmrsbfz_xhdcx, R.id.cpc_jmrsbfz_yycx, R.id.cpc_jmrsbfz_otherbwcx,
            R.id.cpc_jmrsbfz_zgzss, R.id.cpc_jmrsbfz_xgyxcssz, R.id.cpc_jmrsbfz_qt, R.id.cpc_jmrsbfz_w})
    public void onViewCheckedChanged(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.cpc_jmrsbfz_lncx:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_xhdcx:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_yycx:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_otherbwcx:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_zgzss:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_xgyxcssz:
                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                }
                break;
            case R.id.cpc_jmrsbfz_qt:

                if (isChecked) {
                    cpcJmrsbfzW.setChecked(false);
                    itbVesselOther.setVisibility(View.VISIBLE);
                } else {
                    itbVesselOther.setVisibility(View.GONE);
                }

                break;
            case R.id.cpc_jmrsbfz_w: // 无

                if (isChecked) {
                    itbVesselOther.setVisibility(View.GONE);
                    cpcJmrsbfzLncx.setChecked(false);
                    cpcJmrsbfzXhdcx.setChecked(false);
                    cpcJmrsbfzYycx.setChecked(false);
                    cpcJmrsbfzOtherbwcx.setChecked(false);
                    cpcJmrsbfzZgzss.setChecked(false);
                    cpcJmrsbfzXgyxcssz.setChecked(false);
                    cpcJmrsbfzQt.setChecked(false);
                }

                break;
        }
    }

    /**
     * 本地数据加载
     */
    private void loadLocalData() {
        esThrombolysisAddress.setStringArrayId(R.array.stroke_thrombolysis_address);

    }

    /**
     * 点击事件处理
     */
    @OnClick(R.id.tv_book_upload)
    public void viewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_book_upload: // 查看知情同意书

                showPhotoSelector(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        // 拍照
                        if (result != null && result.size() > 0) {

                            loading = ProgressDialog.show(mContext, "", "图片上传中。。。", true, false);
                            LocalMedia localMedia = result.get(0);
//                            LogUtils.d(localMedia.toString());
                            FileServiceImpl.uploadImage("emergency_center_chestpain_imaging_examination", localMedia.getPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
                                @Override
                                public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                                    if (loading != null && loading.isShowing()) {
                                        loading.dismiss();
                                    }
                                    if (response.body() != null) {
                                        List<FileInfoBean> data = response.body().getData();
                                        if (response.body().getResult() == 1) {
                                            if (data != null && data.size() > 0) {
                                                pathUrl = data.get(0).getPath();
                                                showToast("数据保存成功");
                                            } else {
                                                showToast("请重试");
                                            }
                                        } else {
                                            showToast(TextUtils.isEmpty(response.body().getMessage())
                                                    ? getString(R.string.http_tip_data_save_error)
                                                    : response.body().getMessage());
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<BaseArrayBean<FileInfoBean>> call, Throwable t) {
                                    if (loading != null && loading.isShowing()) {
                                        loading.dismiss();
                                    }
                                    showToast(R.string.http_tip_server_error);
                                }
                            });

                        }
                    }

                    @Override
                    public void onCancel() {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                    }
                }, new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        // 相册
                        if (result != null && result.size() > 0) {

                            loading = ProgressDialog.show(mContext, "", "图片上传中。。。", true, false);

                            LocalMedia localMedia = result.get(0);
//                            LogUtils.d(localMedia.toString());
                            FileServiceImpl.uploadImage("emergency_center_chestpain_imaging_examination", localMedia.getPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
                                @Override
                                public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                                    if (loading != null && loading.isShowing()) {
                                        loading.dismiss();
                                    }

                                    if (response.body() != null) {
                                        List<FileInfoBean> data = response.body().getData();
                                        if (response.body().getResult() == 1) {
                                            if (data != null && data.size() > 0) {
                                                pathUrl = data.get(0).getPath();
                                                showToast("数据保存成功");
                                            } else {
                                                showToast("请重试");
                                            }
                                        } else {
                                            showToast(TextUtils.isEmpty(response.body().getMessage())
                                                    ? getString(R.string.http_tip_data_save_error)
                                                    : response.body().getMessage());
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<BaseArrayBean<FileInfoBean>> call, Throwable t) {
                                    if (loading != null && loading.isShowing()) {
                                        loading.dismiss();
                                    }
                                    showToast(R.string.http_tip_server_error);
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancel() {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                    }
                });

                break;
        }

    }

    /**
     * 保存
     */
    @OnClick(R.id.btn_save_data)
    public void onViewClicked() {

        ThrombolysisTreatmentBean thrombolysisTreatmentBean = new ThrombolysisTreatmentBean();
        // TODO: 2020/9/14 谈话医生

        // 静脉溶栓开始知情同意时间
        thrombolysisTreatmentBean.setThrombolyticpatientcommunicationsbegintime(ttbBeginKnowTime.getTime());
        // 静脉溶栓签署知情同意时间
        thrombolysisTreatmentBean.setThrombolyticpatientcommunicationsendtime(ttbSignKnowTime.getTime());
        // 静脉溶栓-静脉溶栓家属意见
        if (rbFamilyOpinionAgree.isChecked()) {
            // 家属意见
            thrombolysisTreatmentBean.setThrombolyticpatientopinion("1");
        } else if (rbFamilyOpinionDisagree.isChecked()) {
            // 家属意见
            thrombolysisTreatmentBean.setThrombolyticpatientopinion("-1");
            // 拒绝原因
            thrombolysisTreatmentBean.setThrombolyticpatientrefusereason(familyReason);

            // 其他拒绝原因
            if (rbFamilyUnagreeThree.isChecked()) {
                thrombolysisTreatmentBean.setThrombolyticotherrefusereason(iebFamilyUnagreeRemark.getEditContent());
            }

        } else {
            //  不传 or ""
        }

        // 知情同意书
        thrombolysisTreatmentBean.setThrombolyticinformedconsent(pathUrl);
        // THRIVE评分
        thrombolysisTreatmentBean.setThrive(iebThrive.getEditContent());
        // 溶栓前NIHSS
        thrombolysisTreatmentBean.setPrethrombolyticnihss(itbBrforNihss.getEditContent());
        // 溶栓地点
        thrombolysisTreatmentBean.setThrombolyticaddress(esThrombolysisAddress.getSelectData()[1]);
        // todo  溶栓护士  setEmergencynurseJmrs();

        // 静脉溶栓静推时间
        thrombolysisTreatmentBean.setThrombolyticstaticpushtime(ttbBeginJmrsTime.getTime());
        // 发病至溶栓时间时间差
        thrombolysisTreatmentBean.setThrombolyticont(iebFbzrs.getEditContent());
        // 入门至溶栓时间时间差
        thrombolysisTreatmentBean.setThrombolyticdnt(iebDyzrs.getEditContent());
        // 静脉溶栓溶栓药物
        thrombolysisTreatmentBean.setThrombolyticdrug(medicineCode);
        // 对应药物处理
        if (rbMedicinePa.isChecked()) { // rt-PA

            // 剂量类型
            thrombolysisTreatmentBean.setThrombolyticdosetype(doseType);
            // 预计剂量
            thrombolysisTreatmentBean.setTHROMBOLYSISESTIMATEDDRUGDOSE(iebYjjl.getEditContent());
            // 实际静推剂量
            thrombolysisTreatmentBean.setThrombolyticactualintravenousdose(iebSjjtjl.getEditContent());
            // 实际滴注剂量
            thrombolysisTreatmentBean.setThrombolyticactualinfusiondose(iebSjdzjl.getEditContent());
            // 实际用药总量
            thrombolysisTreatmentBean.setActualtotalmedication(sjyyjl.getEditContent());
            // 实际剂量标准
            thrombolysisTreatmentBean.setThrombolyticactualdosestandard(iebSjjlbz.getEditContent());

        } else if (rbMedicineNjm.isChecked()) { // 尿激酶
            // 使用剂量
            thrombolysisTreatmentBean.setThrombolysisdrugdose(doseNumCode);
        }

        // 血管再通
        if (rbVesselYes.isChecked()) {
            thrombolysisTreatmentBean.setIsthrombolyticrecanalization("1");
        } else if (rbVesselNo.isChecked()){
            thrombolysisTreatmentBean.setIsthrombolyticrecanalization("-1");
        }

        // 溶栓并发症 thrombolyticCode
        if (cpcJmrsbfzLncx.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_lncx,";
        }
        if (cpcJmrsbfzXhdcx.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_xhdcx,";
        }
        if (cpcJmrsbfzYycx.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_yycx,";
        }
        if (cpcJmrsbfzOtherbwcx.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_otherbwcx,";
        }
        if (cpcJmrsbfzZgzss.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_zgzss,";
        }
        if (cpcJmrsbfzXgyxcssz.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_xgyxcssz,";
        }
        if (cpcJmrsbfzQt.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_qt,";
        }
        if (cpcJmrsbfzW.isChecked()) {
            thrombolyticCode = thrombolyticCode + "cpc_jmrsbfz_w";
        }

        String thCodse;
        if (thrombolyticCode.endsWith(",")) {
            thCodse = thrombolyticCode.substring(0, thrombolyticCode.length()-1);
        } else {
            thCodse = thrombolyticCode;
        }
        // 溶栓并发症
        thrombolysisTreatmentBean.setThrombolyticcomplication(thCodse);
        // 其他溶栓并发症 otherthrombolyticcomplication
        if (cpcJmrsbfzQt.isChecked()) {
            thrombolysisTreatmentBean.setOtherthrombolyticcomplication(itbVesselOther.getEditContent());
        }

        // 溶栓结束后即刻NIHSS
        thrombolysisTreatmentBean.setPostthrombolyticnihss(iebNowNihss.getEditContent());
        // 溶栓后24h NIHSS
        thrombolysisTreatmentBean.setAfterdaythrombolyticnihss(iebDayNihss.getEditContent());
        // 7±2天 NIHSS
        thrombolysisTreatmentBean.setAfterweekthrombolyticnihss(iebWeakNihss.getEditContent());
        // 未给予血管内治疗的原因
        if (cpcWjyxgnzldyyFdxgbb.isChecked()) {
            delayReasonCode = delayReasonCode + "cpc_wjyxgnzldyy_fdxgbb,";
        }
        if (cpcWjyxgnzldyyCsjc.isChecked()) {
            delayReasonCode = delayReasonCode + "cpc_wjyxgnzldyy_csjc,";
        }
        if (cpcWjyxgnzldyyJjz.isChecked()) {
            delayReasonCode = delayReasonCode + "cpc_wjyxgnzldyy_jjz,";
        }
        if (cpcWjyxgnzldyyJsjj.isChecked()) {
            delayReasonCode = delayReasonCode + "cpc_wjyxgnzldyy_jsjj,";
        }
        if (cpcWjyxgnzldyyQt.isChecked()) {
            delayReasonCode = delayReasonCode + "cpc_wjyxgnzldyy_qt";
        }

        String reCodse;
        if (delayReasonCode.endsWith(",")) {
            reCodse = delayReasonCode.substring(0, delayReasonCode.length()-1);
        } else {
            reCodse = delayReasonCode;
        }
        thrombolysisTreatmentBean.setNotembolectomyreason(reCodse);

        // 提交保存
        saveData(thrombolysisTreatmentBean);
    }


    /**
     * 保存数据
     */
    private void saveData(ThrombolysisTreatmentBean thrombolysisTreatmentBean) {
        loading = ProgressDialog.show(mContext, "", "发送请求。。。", true, false);
        BaseRequestBean<ThrombolysisTreatmentBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 2, thrombolysisTreatmentBean);

        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainTriageInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {

                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }

                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                                finish();
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    /**
     * 加载数据
     */
    private void loadData(String recordId) {

        loading = ProgressDialog.show(mContext, "", "发送请求。。。", true, false);
        BaseRequestBean<ThrombolysisTreatmentBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 1, new ThrombolysisTreatmentBean());

        RetrofitClient.getInstance()
                .getApi()
                .getThrombolysisTreatmentInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<ThrombolysisTreatmentBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<ThrombolysisTreatmentBean>> call,
                                           Response<BaseResponseBean<ThrombolysisTreatmentBean>> response) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }

                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                viewInitData(response.body().getData().getData());
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<ThrombolysisTreatmentBean>> call, Throwable t) {
                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     *  填充数据
     */
    private void viewInitData(ThrombolysisTreatmentBean treatmentBean) {

        // TODO: 2020/9/14 谈话医生

        // 静脉溶栓开始知情同意时间
        ttbBeginKnowTime.setTime(treatmentBean.getThrombolyticpatientcommunicationsbegintime());
        // 静脉溶栓签署知情同意时间
        ttbSignKnowTime.setTime(treatmentBean.getThrombolyticpatientcommunicationsendtime());

        // 静脉溶栓-静脉溶栓家属意见
        if (treatmentBean.getThrombolyticpatientopinion().equals("1")) {
            rbFamilyOpinionAgree.setChecked(true);
        } else if (treatmentBean.getThrombolyticpatientopinion().equals("-1")){
            rbFamilyOpinionDisagree.setChecked(true);

            // 拒绝原因
            switch (treatmentBean.getThrombolyticpatientrefusereason()) {
                case "cpc_strokjjyy_bycdfy":
                    rbFamilyUnagreeOne.setChecked(true);
                    break;
                case "cpc_strokjjyy_jjyy":
                    rbFamilyUnagreeTwo.setChecked(true);
                    llFamilyUnagreeLayout.setVisibility(View.VISIBLE);
                    break;
                case "cpc_strokjjyy_qt":
                    rbFamilyUnagreeThree.setChecked(true);
                    llFamilyUnagreeLayout.setVisibility(View.VISIBLE);
                    iebFamilyUnagreeRemark.setVisibility(View.VISIBLE);
                    break;
            }

            // 其他拒绝原因
            iebFamilyUnagreeRemark.setEditContent(treatmentBean.getThrombolyticotherrefusereason());
        }

        // 知情同意书
        pathUrl = treatmentBean.getThrombolyticinformedconsent();
        // THRIVE评分
        iebThrive.setEditContent(treatmentBean.getThrive());
        // 溶栓前NIHSS
        itbBrforNihss.setEditContent(treatmentBean.getPrethrombolyticnihss());
        // 溶栓地点
        switch (treatmentBean.getThrombolyticaddress()) {
            case "cpc_rsdd_jzk":
                esThrombolysisAddress.setText("急诊科");
                break;
            case "cpc_rsdd_ct":
                esThrombolysisAddress.setText("CT室");
                break;
            case "cpc_rsdd_sjnk":
                esThrombolysisAddress.setText("神经内科");
                break;
            case "cpc_rsdd_jrs":
                esThrombolysisAddress.setText("介入室");
                break;
            case "cpc_rsdd_byjjs":
                esThrombolysisAddress.setText("本院急救车");
                break;
            case "cpc_rsdd_bybf":
                esThrombolysisAddress.setText("本院病房");
                break;
            case "cpc_rsdd_wy":
                esThrombolysisAddress.setText("外院");
                break;
        }

        // todo  溶栓护士  setEmergencynurseJmrs();

        // 静脉溶栓静推时间
        ttbBeginJmrsTime.setTime(treatmentBean.getThrombolyticstaticpushtime());
        // 发病至溶栓时间时间差
        iebFbzrs.setEditContent(treatmentBean.getThrombolyticont());
        // 入门至溶栓时间时间差
        iebDyzrs.setEditContent(treatmentBean.getThrombolyticdnt());
        // 静脉溶栓溶栓药物
        if (treatmentBean.getThrombolyticdrug().equals("cpc_strokersyw_rtpa")) {
            medicineCode = "cpc_strokersyw_rtpa";
            rbMedicinePa.setChecked(true);
            llRtpaLayout.setVisibility(View.VISIBLE);
            llNjmLayout.setVisibility(View.GONE);
        } else if (treatmentBean.getThrombolyticdrug().equals("cpc_strokersyw_njm")){
            medicineCode = "cpc_strokersyw_njm";
            rbMedicineNjm.setChecked(true);
            llRtpaLayout.setVisibility(View.GONE);
            llNjmLayout.setVisibility(View.VISIBLE);
        }

        // 对应药物处理
        if (rbMedicinePa.isChecked()) { // rt-PA

            // 剂量类型
            if (treatmentBean.getThrombolyticdosetype().equals("cpc_rtpajllx_09")) {
                doseType = "cpc_rtpajllx_09";
                rbDoseTypeNine.setChecked(true);
            } else if (treatmentBean.getThrombolyticdosetype().equals("cpc_rtpajllx_06")) {
                doseType = "cpc_rtpajllx_06";
                rbDoseTypeSix.setChecked(true);
            }
            // 预计剂量
            iebYjjl.setEditContent(treatmentBean.getTHROMBOLYSISESTIMATEDDRUGDOSE());
            // 实际静推剂量
            iebSjjtjl.setEditContent(treatmentBean.getThrombolyticactualintravenousdose());
            // 实际滴注剂量
            iebSjdzjl.setEditContent(treatmentBean.getThrombolyticactualinfusiondose());
            // 实际用药总量
            sjyyjl.setEditContent(treatmentBean.getActualtotalmedication());
            // 实际剂量标准
            iebSjjlbz.setEditContent(treatmentBean.getThrombolyticactualdosestandard());

        } else if (rbMedicineNjm.isChecked()) { // 尿激酶
            // 使用剂量
            if (treatmentBean.getThrombolysisdrugdose().equals("cpc_njm_100w")) {
                doseNumCode = "cpc_njm_100w";
                rbDose100.setChecked(true);
            } else if (treatmentBean.getThrombolysisdrugdose().equals("cpc_njm_125w")) {
                doseNumCode = "cpc_njm_125w";
                rbDose125.setChecked(true);
            } else if (treatmentBean.getThrombolysisdrugdose().equals("cpc_njm_150w")) {
                doseNumCode = "cpc_njm_150w";
                rbDose150.setChecked(true);
            }
        }

        // 血管再通
        if (treatmentBean.getIsthrombolyticrecanalization().equals("1")) {
            rbVesselYes.setChecked(true);
        } else if (treatmentBean.getIsthrombolyticrecanalization().equals("-1")){
            rbVesselYes.setChecked(false);
        }

        // 溶栓并发症
        String[] bStrings = treatmentBean.getThrombolyticcomplication().split(",");
        if (bStrings.length > 0) {
            for (int i = 0; i < bStrings.length; i++) {
                switch (bStrings[i]) {
                    case "cpc_jmrsbfz_lncx":
                        cpcJmrsbfzLncx.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_xhdcx":
                        cpcJmrsbfzXhdcx.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_yycx":
                        cpcJmrsbfzYycx.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_otherbwcx":
                        cpcJmrsbfzOtherbwcx.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_zgzss":
                        cpcJmrsbfzZgzss.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_xgyxcssz":
                        cpcJmrsbfzXgyxcssz.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_qt":
                        cpcJmrsbfzQt.setChecked(true);
                        break;
                    case "cpc_jmrsbfz_w":
                        cpcJmrsbfzW.setChecked(true);
                        break;
                }
            }
        }

        // 其他溶栓并发症
        if (cpcJmrsbfzQt.isChecked()) {
            itbVesselOther.setEditContent(treatmentBean.getOtherthrombolyticcomplication());
        }

        // 溶栓结束后即刻NIHSS
        iebNowNihss.setEditContent(treatmentBean.getPostthrombolyticnihss());
        // 溶栓后24h NIHSS
        iebDayNihss.setEditContent(treatmentBean.getAfterdaythrombolyticnihss());
        // 7±2天 NIHSS
        iebWeakNihss.setEditContent(treatmentBean.getAfterweekthrombolyticnihss());

        // 未给予血管内治疗的原因
        String[] NoteStrings = treatmentBean.getNotembolectomyreason().split(",");
        if (NoteStrings.length > 0) {
            for (int i = 0; i < NoteStrings.length; i++) {
                switch (NoteStrings[i]) {
                    case "cpc_wjyxgnzldyy_fdxgbb":
                        cpcWjyxgnzldyyFdxgbb.setChecked(true);
                        break;
                    case "cpc_wjyxgnzldyy_csjc":
                        cpcWjyxgnzldyyCsjc.setChecked(true);
                        break;
                    case "cpc_wjyxgnzldyy_jjz":
                        cpcWjyxgnzldyyJjz.setChecked(true);
                        break;
                    case "cpc_wjyxgnzldyy_jsjj":
                        cpcWjyxgnzldyyJsjj.setChecked(true);
                        break;
                    case "cpc_wjyxgnzldyy_qt":
                        cpcWjyxgnzldyyQt.setChecked(true);
                        break;
                }
            }
        }

    }

    /**
     * 溶栓药物 类型
     */
    @OnClick({R.id.rb_medicine_pa, R.id.rb_medicine_njm, R.id.rb_dose_type_nine, R.id.rb_dose_type_six,
            R.id.rb_dose_100, R.id.rb_dose_125, R.id.rb_dose_150})
    public void onViewClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.rb_medicine_pa: // rt-PA
                if (checked) {
                    medicineCode = "cpc_strokersyw_rtpa";
                    llRtpaLayout.setVisibility(View.VISIBLE);
                    llNjmLayout.setVisibility(View.GONE);
                }
                break;
            case R.id.rb_medicine_njm: // 尿激酶
                if (checked) {
                    medicineCode = "cpc_strokersyw_njm";
                    llRtpaLayout.setVisibility(View.GONE);
                    llNjmLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.rb_dose_type_nine: // 剂量类型
                if (checked) {
                    doseType = "cpc_rtpajllx_09";
                }
                break;
            case R.id.rb_dose_type_six: // 剂量类型
                if (checked) {
                    doseType = "cpc_rtpajllx_06";
                }
                break;
            case R.id.rb_dose_100:
                if (checked) {
                    doseNumCode = "cpc_njm_100w";
                }
                break;
            case R.id.rb_dose_125:
                if (checked) {
                    doseNumCode = "cpc_njm_125w";
                }
                break;
            case R.id.rb_dose_150:
                if (checked) {
                    doseNumCode = "cpc_njm_150w";
                }
                break;
        }
    }


    /**
     * 家属意见 - 同意 拒绝
     *  拒绝原因
     */
    @OnClick({R.id.rb_family_opinion_agree, R.id.rb_family_opinion_disagree, R.id.rb_family_unagree_one, R.id.rb_family_unagree_two, R.id.rb_family_unagree_three})
    public void familyReasonViewClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.rb_family_opinion_agree:
                if (checked) {
                    llFamilyUnagreeLayout.setVisibility(View.GONE);
                    iebFamilyUnagreeRemark.setVisibility(View.GONE);
                    familyReason = "";
                }
                break;
            case R.id.rb_family_opinion_disagree:
                if (checked) {
                    llFamilyUnagreeLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.rb_family_unagree_one:
                // cpc_strokjjyy_bycdfy
                if (checked) {
                    iebFamilyUnagreeRemark.setVisibility(View.GONE);
                    familyReason = "cpc_strokjjyy_bycdfy";
                }
                break;
            case R.id.rb_family_unagree_two:
                //cpc_strokjjyy_jjyy
                if (checked) {
                    iebFamilyUnagreeRemark.setVisibility(View.GONE);
                    familyReason = "cpc_strokjjyy_jjyy";
                }

                break;
            case R.id.rb_family_unagree_three:
                // cpc_strokjjyy_qt
                if (checked) {
                    iebFamilyUnagreeRemark.setVisibility(View.VISIBLE);
                    familyReason = "cpc_strokjjyy_qt";
                }
                break;
        }
    }

    /**
     * 事件接收
     *
     * @param event 事件通知
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveScoreEventBus(ScoreEvent event) {
        if (event == null) {
            return;
        }
        if (7 == event.getType()) {
            iebThrive.setEditContent(event.getScore() + "");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
        EventBus.getDefault().unregister(this);
    }
}
