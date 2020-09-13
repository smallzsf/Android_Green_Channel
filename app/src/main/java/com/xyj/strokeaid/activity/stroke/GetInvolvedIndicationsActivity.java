package com.xyj.strokeaid.activity.stroke;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
 * @Description: 介入适应症
 * * @Author: crq
 * @CreateDate: 2020/8/29 14:21
 */
@Route(path = RouteUrl.Stroke.STROKE_GET_INVOLVED_INDICATIONS)
public class GetInvolvedIndicationsActivity extends BaseActivity {

    private static final String TAG = GetInvolvedIndicationsActivity.class.getSimpleName();
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
    public List<StrokeTCBean> mStrokeTCBeans;
    private StrokeTCRvAdapterNew mStrokeTCRvAdapter;
    private MyindicationPo myindicationPo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_getinvolved_indications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mStrokeTCBeans = prepareData();
        refrashAdapter(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
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
            Log.e(TAG, b + " onCheckedChanged: " + position);

            StrokeTCBean bean = mStrokeTCBeans.get(position);
            bean.setChecked(b);
            refrashAdapter(false);
        }
    };

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
                            myindicationPo = response
                                    .body().getData();

                            mStrokeTCBeans = prepareData();
                            refrashAdapter(true);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<MyindicationPo>> call, Throwable t) {

                    }
                });
    }


    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());

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

    public void save() {
        myindicationPo = new MyindicationPo();
        List<StrokeTCBean> strokeTCBeans = mStrokeTCBeans;
        for (int i = 0; i < strokeTCBeans.size(); i++) {
            StrokeTCBean strokeTCBean = strokeTCBeans.get(i);
            if (strokeTCBean == null) {
                continue;
            }
            boolean checked = strokeTCBean.getChecked();

            switch (i) {
                case 1://embolectomyIndicationAge
                    myindicationPo.setEmbolectomyIndicationAge((checked ? "1" : "-1"));
                    break;
                case 2://embolectomyIndicationTime
                    myindicationPo.setEmbolectomyIndicationTime((checked ? "1" : "-1"));
                    break;
                case 3://embolectomyIndicationExclude
                    myindicationPo.setEmbolectomyIndicationExclude((checked ? "1" : "-1"));
                    break;
                case 4://embolectomyIndicationDxgbs
                    myindicationPo.setEmbolectomyIndicationDxgbs((checked ? "1" : "-1"));
                    break;
                case 5://embolectomyIndicationAgree
                    myindicationPo.setEmbolectomyIndicationAgree((checked ? "1" : "-1"));
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

    public List<StrokeTCBean> prepareData() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();
        //   list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        StrokeTCBean strokeTCBean = new StrokeTCBean(false, "1.年龄在18岁以上", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "2.大血管闭塞卒中患者应尽早实施血管内介入治疗。前循环闭塞发病6h以内，推荐血管介入治疗；前循环闭塞发病在6~24h，经过严格的影像学筛选，推荐血管介入治疗；后循环大血管闭塞发病在24h以内，可行血管介入治疗。", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "3.CT排除颅内出血、蛛网膜下腔出血。", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "4.急性缺血性脑卒中，影像学检查证实为大血管闭塞。", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "5.药物无法控制的严重高血压", false, "");
        list.add(strokeTCBean);
        strokeTCBean = new StrokeTCBean(false, "6.患者或法定代理人签署知情同意书", false, "");
        list.add(strokeTCBean);
        if (myindicationPo == null) {
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            StrokeTCBean bean = list.get(i);
            if (bean == null) {
                continue;
            }
            boolean checked = bean.getChecked();
            String netText = "";
            switch (i) {
                case 0://embolectomyIndicationAge
                    netText = myindicationPo.getEmbolectomyIndicationAge() ;
                    break;
                case 1://embolectomyIndicationTime
                    netText = myindicationPo.getEmbolectomyIndicationTime();
                    break;
                case 2://embolectomyIndicationExclude
                    netText = myindicationPo.getEmbolectomyIndicationExclude() ;
                    break;
                case 3://embolectomyIndicationDxgbs
                    netText = myindicationPo.getEmbolectomyIndicationDxgbs();
                    break;
                case 4://embolectomyIndicationAgree
                    netText = myindicationPo.getEmbolectomyIndicationAgree();
                    break;
            }
            checked = "1".equals(netText);
            bean.setChecked(checked);
        }
        return list;
    }
}

    
    
       
    