package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
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
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.StrokeThriveActivity;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.event.ScoreEvent;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.ThrombolysisTreatmentBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

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
    @BindView(R.id.es_talk_doctor)
    EditSpinner esTalkDoctor;
    @BindView(R.id.ttb_begin_know_time)
    TextTimeBar ttbBeginKnowTime;
    @BindView(R.id.ttb_sign_know_time)
    TextTimeBar ttbSignKnowTime;
    @BindView(R.id.rb_family_opinion_agree)
    RadioButton rbFamilyOpinionAgree;
    @BindView(R.id.rb_family_opinion_disagree)
    RadioButton rbFamilyOpinionDisagree;
    @BindView(R.id.tv_book_upload)
    TextView tvBookUpload;
    @BindView(R.id.ieb_thrive)
    ItemEditBar iebThrive;
    @BindView(R.id.itb_brfor_nihss)
    ItemEditBar itbBrforNihss;
    @BindView(R.id.es_thrombolysis_address)
    EditSpinner esThrombolysisAddress;
    @BindView(R.id.es_thrombolysis_doctor)
    EditSpinner esThrombolysisDoctor;
    @BindView(R.id.ttb_begin_jmrs_time)
    TextTimeBar ttbBeginJmrsTime;
    @BindView(R.id.ieb_fbzrs)
    ItemEditBar iebFbzrs;
    @BindView(R.id.ieb_dyzrs)
    ItemEditBar iebDyzrs;
    @BindView(R.id.rb_medicine_pa)
    RadioButton rbMedicinePa;
    @BindView(R.id.rb_medicine_njm)
    RadioButton rbMedicineNjm;
    @BindView(R.id.rg_medicine)
    RadioGroup rgMedicine;
    @BindView(R.id.rb_dose_type_nine)
    RadioButton rbDoseTypeNine;
    @BindView(R.id.rb_dose_type_six)
    RadioButton rbDoseTypeSix;
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
    @BindView(R.id.rb_dose_100)
    RadioButton rbDose100;
    @BindView(R.id.rb_dose_125)
    RadioButton rbDose125;
    @BindView(R.id.rb_dose_150)
    RadioButton rbDose150;
    @BindView(R.id.rg_use_dose)
    RadioGroup rgUseDose;
    @BindView(R.id.ll_njm_layout)
    LinearLayout llNjmLayout;
    @BindView(R.id.rb_vessel_yes)
    RadioButton rbVesselYes;
    @BindView(R.id.rb_vessel_no)
    RadioButton rbVesselNo;
    @BindView(R.id.rg_vessel)
    RadioGroup rgVessel;
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
    @BindView(R.id.itb_vessel_other)
    ItemEditBar itbVesselOther;
    @BindView(R.id.ieb_now_nihss)
    ItemEditBar iebNowNihss;
    @BindView(R.id.ieb_day_nihss)
    ItemEditBar iebDayNihss;
    @BindView(R.id.ieb_weak_nihss)
    ItemEditBar iebWeakNihss;
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
    @BindView(R.id.btn_save_data)
    AppCompatButton btnSaveData;

    @BindView(R.id.ieb_thrive)
    ItemEditBar iebThrive;


    private ProgressDialog loading;
    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

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
        iebThrive.setOnClickListener(v -> {
            Intent intent = new Intent(this, StrokeThriveActivity.class);
            startActivity(intent);
        });

        loadData(mRecordId);
    }

    @Override
    public void initListener() {
        // 返回
        titleBarActTreatment.setLeftLayoutClickListener(v -> finish());

        // THRIVE评分
        iebThrive.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
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
                    showToast("cpc_jmrsbfz_lncx");
                }
                break;
            case R.id.cpc_jmrsbfz_xhdcx:
                break;
            case R.id.cpc_jmrsbfz_yycx:
                break;
            case R.id.cpc_jmrsbfz_otherbwcx:
                break;
            case R.id.cpc_jmrsbfz_zgzss:
                break;
            case R.id.cpc_jmrsbfz_xgyxcssz:
                break;
            case R.id.cpc_jmrsbfz_qt:
                if (isChecked) {
                    itbVesselOther.setVisibility(View.VISIBLE);
                } else {
                    itbVesselOther.setVisibility(View.GONE);
                }

                break;
            case R.id.cpc_jmrsbfz_w:
                itbVesselOther.setVisibility(View.GONE);

                break;
        }
    }

    /**
     * 保存
     */
    @OnClick(R.id.btn_save_data)
    public void onViewClicked() {

        ThrombolysisTreatmentBean thrombolysisTreatmentBean = new ThrombolysisTreatmentBean();


        saveData(thrombolysisTreatmentBean);
    }

    /**
     * 保存数据
     */
    private void saveData(ThrombolysisTreatmentBean thrombolysisTreatmentBean) {
        loading = ProgressDialog.show(mContext, "", "发送请求。。。",true,false);
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

        loading = ProgressDialog.show(mContext, "", "发送请求。。。",true,false);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {

//                                mStrokeTrigaeInfoBean = response.body().getData().getData();
//                                if (mStrokeTrigaeInfoBean != null) {
//                                    // 请求成功
//                                    // 填充页面
//                                    getDatatoStrokeViews(mStrokeTrigaeInfoBean);
//                                }

    /**
     * 事件接收
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
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<ThrombolysisTreatmentBean>> call, Throwable t) {

                        Log.e("Throwable", t.getMessage().toString());

                        if (loading != null && loading.isShowing()) {
                            loading.dismiss();
                        }
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 溶栓药物 类型
     *
     *  rb_medicine_pa = rt-PA
     *  rb_medicine_njm = 尿激酶
     */
    @OnClick({R.id.rb_medicine_pa, R.id.rb_medicine_njm})
    public void onViewClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();
        switch (radioButton.getId()) {
            case R.id.rb_medicine_pa:
                if (checked) {
                    llRtpaLayout.setVisibility(View.VISIBLE);
                    llNjmLayout.setVisibility(View.GONE);
                }
                break;
            case R.id.rb_medicine_njm:
                if (checked) {
                    llRtpaLayout.setVisibility(View.GONE);
                    llNjmLayout.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loading != null && loading.isShowing()) {
            loading.dismiss();
        }
    }
}
