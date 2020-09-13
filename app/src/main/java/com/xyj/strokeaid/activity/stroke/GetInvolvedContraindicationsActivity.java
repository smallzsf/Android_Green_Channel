package com.xyj.strokeaid.activity.stroke;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.bean.score.ContraindicationPo;
import com.xyj.strokeaid.bean.score.MyindicationPo;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 介入禁忌症
 * * @Author: crq
 * @CreateDate: 2020/8/29 14:21
 */
@Route(path = RouteUrl.Stroke.STROKE_GET_INVOLVED_CONTRAINDICATIONS)
public class GetInvolvedContraindicationsActivity extends GetInvolvedIndicationsActivity {
    private ContraindicationPo contraindicationPo;

    @Override
    public void initView() {
        super.initView();
//        title_bar_act_tc
        titleBarActTc.setTitle("介入禁忌症");
    }

    @Override
    public void loadData() {
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getContraindication(requestBody)
                .enqueue(new Callback<BaseObjectBean<ContraindicationPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<ContraindicationPo>> call, Response<BaseObjectBean<ContraindicationPo>> response) {
                        if (response.body().getResult() == 1) {
                            // TODO: 2020/9/13 重现接口返回数据为空  需要验证调试 
                            contraindicationPo = response.body().getData();
                            mStrokeTCBeans = prepareData();
                            refrashAdapter(true);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<ContraindicationPo>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void save() {
        contraindicationPo = new ContraindicationPo();

        List<StrokeTCBean> strokeTCBeans = mStrokeTCBeans;
        for (int i = 0; i < strokeTCBeans.size(); i++) {
            StrokeTCBean strokeTCBean = strokeTCBeans.get(i);
            if (strokeTCBean == null) {
                continue;
            }
            boolean checked = strokeTCBean.getChecked();
            switch (i) {
                case 0://embolectomyContraindicationReference
                    contraindicationPo.setEmbolectomyContraindicationReference((checked ? 1 : -1));
                    break;
                case 1://embolectomyContraindicationHemorrhage
                    contraindicationPo.setEmbolectomyContraindicationHemorrhage((checked ? 1 : -1));
                    break;
                case 2://embolectomyContraindicationDysfunction
                    contraindicationPo.setEmbolectomyContraindicationDysfunction((checked ? 1 : -1));
                    break;
                case 3://embolectomyContraindicationBloodsugar
                    contraindicationPo.setEmbolectomyContraindicationBloodsugar((checked ? 1 : -1));
                    break;
                case 4://embolectomyContraindicationUncontrol
                    contraindicationPo.setEmbolectomyContraindicationUncontrol((checked ? 1 : -1));
                    break;
                case 5://embolectomyContraindicationNone
                    contraindicationPo.setEmbolectomyContraindicationNone((checked ? 1 : -1));
                    break;

            }
        }
        String request = GsonUtils.getGson().toJson(contraindicationPo);
        saveNet(request);
    }

    public void saveNet(String request) {
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
                            finish();
                            // TODO: 2020/9/13 保存成功将结果值返回上一个页面 
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<MyindicationPo>> call, Throwable t) {

                    }
                });
    }


    public List<StrokeTCBean> prepareData() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();

        //   list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        StrokeTCBean strokeTCBean = new StrokeTCBean(false, "1.若进行动脉溶栓，参考静脉溶栓禁忌症标准", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "2.活动性出血或已知有明显出血倾向者", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "3.严重心、肝、肾功能不全", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "4.血糖<2.7mmol/L或>22.2mmol/L", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "5.药物无法控制的严重高血压", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "6.无以上禁忌症", false, "");
        list.add(strokeTCBean);

        if (contraindicationPo == null) {
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            StrokeTCBean bean = list.get(i);
            if (bean == null) {
                continue;
            }
            boolean checked = bean.getChecked();

            switch (i) {
                case 0://embolectomyContraindicationReference
                    checked = contraindicationPo.getEmbolectomyContraindicationReference() == 1;
                    break;
                case 1://embolectomyContraindicationHemorrhage
                    checked = contraindicationPo.getEmbolectomyContraindicationHemorrhage() == 1;
                    break;
                case 2://embolectomyContraindicationDysfunction
                    checked = contraindicationPo.getEmbolectomyContraindicationDysfunction() == 1;
                    break;
                case 3://embolectomyContraindicationBloodsugar
                    checked = contraindicationPo.getEmbolectomyContraindicationBloodsugar() == 1;
                    break;
                case 4://embolectomyContraindicationUncontrol
                    checked = contraindicationPo.getEmbolectomyContraindicationUncontrol() == 1;
                    break;
                case 5://embolectomyContraindicationNone
                    checked = contraindicationPo.getEmbolectomyContraindicationNone() == 1;
                    break;

            }
            bean.setChecked(checked);
        }


        return list;
    }
}

    
    
       
    