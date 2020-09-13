package com.xyj.strokeaid.activity.stroke;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeTCRvAdapter;
import com.xyj.strokeaid.adapter.StrokeTCRvAdapterNew;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.SiscontraindicationBean;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.bean.score.MyindicationPo;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ThrombolysisContraindicationsActivity
 * description: 溶栓禁忌症
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS)
public class ThrombolysisContraindicationsActivity extends BaseActivity {

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.title_bar_act_tc)
    BaseTitleBar titleBarActTc;
    @BindView(R.id.rv_content_act_tc)
    ListView rvContentActTc;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private List<StrokeTCBean> mStrokeTCBeans;
    private StrokeTCRvAdapterNew mStrokeTCRvAdapter;

    private SiscontraindicationBean bean;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolysis_contraindications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mStrokeTCBeans = prepareData();
//
//        R.layout.adapter_header_single_text,
//                R.layout.adapter_rv_stroke_thrombolysis_symptom_item,
        refrashAdapter(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {

        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getMyindication(requestBody)
                .enqueue(new Callback<BaseObjectBean<MyindicationPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<MyindicationPo>> call, Response<BaseObjectBean<MyindicationPo>> response) {
                        if (response.body().getResult() == 1) {
                            // TODO: 2020/9/13 重现接口验证数据为null
//                            myindicationPo = response
//                                    .body().getData();

                            mStrokeTCBeans = prepareData();
                            refrashAdapter(true);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<MyindicationPo>> call, Throwable t) {

                    }
                });
    }


    public void refrashAdapter(boolean isReset) {
        if (mStrokeTCRvAdapter == null || isReset) {
            mStrokeTCRvAdapter = new StrokeTCRvAdapterNew(
                    mContext, mStrokeTCBeans);
            rvContentActTc.setAdapter(mStrokeTCRvAdapter);
            mStrokeTCRvAdapter.setOnSwitchClickListener(onSwitchChangeListener);
        } else {
            mStrokeTCRvAdapter.notifyDataSetChanged();
        }
    }


    StrokeTCRvAdapterNew.OnSwitchChangeListener onSwitchChangeListener = new StrokeTCRvAdapterNew.OnSwitchChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b, int position) {

            StrokeTCBean bean = mStrokeTCBeans.get(position);
            bean.setChecked(b);
            refrashAdapter(false);
        }
    };

    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());

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
         * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/siscontraindication/get
         * POST
         * 静脉溶栓禁忌症评估表-获取
         *
         *       thrombolysisContraindicationLrcx	1. 颅内出血（包括脑实质出血、脑室内出血、蛛网膜下腔出血、硬膜下/外血肿等）	是	[string]	查看
         *   	 thrombolysisContraindicationCzlrcx	2. 既往颅内出血史	是	[string]	查看
         *   	 thrombolysisContraindicationCzs	3. 近3个月有严重头颅外伤史或卒中史	是	[string]	查看
         *   	 thrombolysisContraindicationLrzr	4. 颅内肿瘤、巨大颅内动脉瘤	是	[string]	查看
         *   	 thrombolysisContraindicationJqss	5. 近期（3个月）有颅内或椎管内手术	是	[string]	查看
         *   	 thrombolysisContraindicationNzcx	6. 活动性内脏出血	是	[string]	查看
         *   	 thrombolysisContraindicationDmcc	7. 近1周内有在不易压迫止血部位的动脉穿刺	是	[string]	查看
         *   	 thrombolysisContraindicationXysg	8. 血压升高：收缩压≥180mmHg，或舒张压≥100 mmHg	是	[string]	查看
         *   	 thrombolysisContraindicationJxcxqx	9. 急性出血倾向，包括血小板计数低于100×109/L或其他情况	是	[string]	查看
         *   	 thrombolysisContraindicationDfzgszl	10. 48h内接受过肝素治疗（APTT超出正常范围上限）	是	[string]	查看
         *   	 thrombolysisContraindicationKfknj	11. 口服抗凝剂且INR＞1.7或PT＞15s	是	[string]	查看
         *   	 thrombolysisContraindicationJcyc	12. 目前正在使用凝血酶抑制剂或Xa因子抑制剂，各种敏感的实验室检查异常（如APTT,INR,血小板计数，ECT，TT或恰当的Xa因子活性测定等）	是	[string]	查看
         *   	 thrombolysisContraindicationXtd	13. 血糖＜2.7mmol/L	是	[string]	查看
         *   	 thrombolysisContraindicationDmjgs	14. 头部CT或MRI提示大面积梗死（梗死面积＞1/3大脑中动脉供血区）	是	[string]	查看
         *   	 thrombolysisContraindicationNone	15. 无以上禁忌症	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationGscz	1. 轻型非致残性卒中或症状迅速改善的卒中	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationSjgnsh	2. 惊厥发作后出现的神经功能损害（与此次卒中发生相关）	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationJqyzws	3. 近2周内有大型外科手术或严重外伤	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationJqxjgs	4. 近3个月内有心肌梗死	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationJqwccx	5. 近3周内有胃肠或泌尿系统出血	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationYcf	6 孕产妇	是	[string]	查看
         *   	 thrombolysisRelativecontraindicationNone	7. 无以上禁忌症
         */List<StrokeTCBean> strokeTCBeans = mStrokeTCBeans;
        for (int i = 0; i < strokeTCBeans.size(); i++) {
            StrokeTCBean strokeTCBean = strokeTCBeans.get(i);
            if (strokeTCBean == null) {
                continue;
            }
            boolean checked = strokeTCBean.getChecked();

            switch (i) {
                case 1:
//                thrombolysisContraindicationLrcx	1. 颅内出血（包括脑
                    break;
//                thrombolysisContraindicationCzlrcx	2. 既往颅内出血史
                case 2:
                    break;
//                thrombolysisContraindicationCzs	3. 近3个月有严重头
                case 3:
                    break;
//                thrombolysisContraindicationLrzr	4. 颅内肿瘤、巨大颅
                case 4:
                    break;
//                thrombolysisContraindicationJqss	5. 近期（3个月）有
                case 5:
                    break;
//                thrombolysisContraindicationNzcx	6. 活动性内脏出血
                case 6:
                    break;
//                thrombolysisContraindicationDmcc	7. 近1周内有在不易
                case 7:
                    break;
//                thrombolysisContraindicationXysg	8. 血压升高：收缩压
                case 8:
                    break;
//                thrombolysisContraindicationJxcxqx	9. 急性出血倾向，包
                case 9:
                    break;
//                thrombolysisContraindicationDfzgszl	10. 48h
                case 10:
                    break;
//                thrombolysisContraindicationKfknj	11. 口服抗凝剂且I
                case 11:
                    break;
//                thrombolysisContraindicationJcyc	12. 目前正在使用凝
                case 12:
                    break;
//                thrombolysisContraindicationXtd	13. 血糖＜2.7m
                case 13:
                    break;
//                thrombolysisContraindicationDmjgs	14. 头部CT或MR
                case 14:
                    break;
//                thrombolysisContraindicationNone	15. 无以上禁忌症
                case 15:
                    break;
//                thrombolysisRelativecontraindicationGscz	1.
                case 16 + 1:
                    break;
//                thrombolysisRelativecontraindicationSjgnsh	2.
                case 16 + 2:
                    break;
//                thrombolysisRelativecontraindicationJqyzws	3.
                case 16 + 3:
                    break;
//                thrombolysisRelativecontraindicationJqxjgs	4.
                case 16 + 4:
                    break;
//                thrombolysisRelativecontraindicationJqwccx	5.
                case 16 + 5:
                    break;
//                thrombolysisRelativecontraindicationYcf	6 孕
                case 16 + 6:
                    break;
//                thrombolysisRelativecontraindicationNone	7.
                case 16 + 7:
                    break;
            }
        }
        String request = GsonUtils.getGson().toJson(myindicationPo);
        saveNet(request);

    }

    private void saveNet(String request) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveMyindication(requestBody)
                .enqueue(new Callback<BaseObjectBean<MyindicationPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<MyindicationPo>> call, Response<BaseObjectBean<MyindicationPo>> response) {
                        BaseObjectBean<MyindicationPo> body = response.body();
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
                    public void onFailure(Call<BaseObjectBean<MyindicationPo>> call, Throwable t) {

                    }
                });
    }


    private List<StrokeTCBean> prepareData() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();

        list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        list.add(new StrokeTCBean(false, "1.颅内出血（包括脑实质出血、脑室内出血、蛛网膜下腔出血、硬膜下/外血肿等）", false, ""));
        list.add(new StrokeTCBean(false, "2.既往颅内出血史", false, ""));
        list.add(new StrokeTCBean(false, "3.近3个月有严重头颅外伤史或卒中史", false, ""));
        list.add(new StrokeTCBean(false, "4.颅内肿瘤、巨大颅内动脉瘤", false, ""));
        list.add(new StrokeTCBean(false, "5.近期（3个月）有颅内或椎管内手术", false, ""));
        list.add(new StrokeTCBean(false, "6.活动性内脏出血", false, ""));
        list.add(new StrokeTCBean(false, "7.近1周内有在不易压迫止血部位的动脉穿刺", false, ""));
        list.add(new StrokeTCBean(false, "8.血压升高：收缩压≥180mmHg，或舒张压≥100mmHg", false, ""));
        list.add(new StrokeTCBean(false, "9.急性出血倾向，包括血小板计数低于100x109/L或其他情况", false, ""));
        list.add(new StrokeTCBean(false, "10.48h内接受过肝素治疗（APTT超出正常范围上限）", false, ""));
        list.add(new StrokeTCBean(false, "11.口服抗凝剂且INR＞1.7或PT＞15s", false, ""));
        list.add(new StrokeTCBean(false, "12.目前正在使用凝血酶抑制器或Xa因子抑制剂，各种敏感的实验室检查异常（如APTT，INR，血小板计数，ECT，TT或恰当的Xa因子活性测定等）", false, ""));
        list.add(new StrokeTCBean(false, "13.血糖＜2.7mmol/L", false, ""));
        list.add(new StrokeTCBean(false, "14.头部CT或MRI提示大面积梗死（梗死面积＞1/3大脑中动脉供血区）", false, ""));
        list.add(new StrokeTCBean(false, "15.无以上禁忌症", false, ""));
        list.add(new StrokeTCBean(true, "相对禁忌症\n下列情况需谨慎考虑和权衡溶栓的分析和获益（即虽然存在一项或多项禁忌症，但并非绝对不能溶栓）", false, ""));
        list.add(new StrokeTCBean(false, "1.轻型非致残性卒中或症状迅速改善的卒中", false, ""));
        list.add(new StrokeTCBean(false, "2.惊厥发作后出现的神经功能损害（与此次卒中发生相关）", false, ""));
        list.add(new StrokeTCBean(false, "3.近2周内有大型外科手术或严重外伤", false, ""));
        list.add(new StrokeTCBean(false, "4.近3个月内有心肌梗死", false, ""));
        list.add(new StrokeTCBean(false, "5.近3周内有胃肠或泌尿系统出血", false, ""));
        list.add(new StrokeTCBean(false, "6.孕产妇", false, ""));
        list.add(new StrokeTCBean(false, "7.无以上禁忌症", false, ""));
        return list;
    }
}

    
    
       
    