package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.IndicationBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.SiscontraindicationBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextSwitchBar;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ThrombolysisIndicationsActivity
 * description: 溶栓适应症
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_INDICATIONS)
public class ThrombolysisIndicationsActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_ti)
    BaseTitleBar titleBarActTi;
    @BindView(R.id.tsb_age_act_ti)
    TextSwitchBar tsbAgeActTi;
    @BindView(R.id.tsb_duration_act_ti)
    TextSwitchBar tsbDurationActTi;
    @BindView(R.id.tsb_symptom_act_ti)
    TextSwitchBar tsbSymptomActTi;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    String mRecordId;
    private IndicationBean bean;


    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolysis_indications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(mRecordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getIndication(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<IndicationBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<IndicationBean>> call, Response<BaseObjectBean<IndicationBean>> response) {
                        if (response.body() !=null && response.body().getResult() == 1){
                            IndicationBean data = response.body().getData();
                            resetView(data);
                        }
                        hideLoadingDialog();
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean<IndicationBean>> call, Throwable t) {
                        hideLoadingDialog();
                    }
                });
    }

    private void resetView(IndicationBean bean) {
        tsbAgeActTi.setSelected("1".equals(bean.thrombolysisIndicationAge));
        tsbDurationActTi.setSelected("1".equals(bean.thrombolysisIndicationTime));
        tsbSymptomActTi.setSelected("1".equals(bean.thrombolysisIndicationSymptom));
    }

    @Override
    public void initListener() {
        titleBarActTi.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                save();

                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    private void save() {
        /**
         *
         @BindView(R.id.tsb_age_act_ti) TextSwitchBar tsbAgeActTi;
         @BindView(R.id.tsb_duration_act_ti) TextSwitchBar tsbDurationActTi;
         @BindView(R.id.tsb_symptom_act_ti) TextSwitchBar tsbSymptomActTi;

         thrombolysisIndicationAge	年龄≥18岁	是	[string]	查看
         13	 thrombolysisIndicationTime	症状出现≤4.5h	是	[string]	查看
         14	 thrombolysisIndicationSymptom	有缺血性脑卒中导致的神经功能缺损症状	是	[string]
         */
        bean = new IndicationBean();
        bean.thrombolysisIndicationAge = tsbAgeActTi.isClickable() ? "1" : "-1";
        bean.thrombolysisIndicationTime = tsbDurationActTi.isClickable() ? "1" : "-1";
        bean.thrombolysisIndicationSymptom = tsbSymptomActTi.isClickable() ? "1" : "-1";

        String request = GsonUtils.getGson().toJson(bean);
        saveNet(request);

    }


    private void saveNet(String request) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveIndication(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        BaseObjectBean body = response.body();
                        if (body == null) {
                            return;
                        }
                        if (body.getResult() == 1) {
                            showToast("保存成功");
                            // TODO: 2020/9/13  接口未返回评分结果 需要返回将评分结果返回打开页面
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }


}

    
    
       
    