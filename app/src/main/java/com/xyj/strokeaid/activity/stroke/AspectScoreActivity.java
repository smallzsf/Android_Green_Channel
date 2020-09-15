package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
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
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeTCRvAdapter;
import com.xyj.strokeaid.adapter.StrokeTCRvAdapterNew;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.PatientCache;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.AspectPo;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;
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
 * @Description: ASPECT评分
 * @Author: crq
 * @CreateDate: 2020/8/30 12:02
 */
@Route(path = RouteUrl.Stroke.STROKE_ASPECT_SCORE)
public class AspectScoreActivity extends BaseActivity {
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.title_bar_act_tc)
    BaseTitleBar titleBarActTc;
    @BindView(R.id.rv_content_act_tc)
    ListView rvContentActTc;
    @BindView(R.id.stl_title_frag_stroke_medice)
    SegmentTabLayout stlTitleFragStrokeMedice;
    @BindView(R.id.ll_before_loop)
    LinearLayout llBeforeLoop;
    @BindView(R.id.rv_back_loop)
    ListView rvBackLoop;
    @BindView(R.id.ll_back_loop)
    LinearLayout llBackLoop;

    private List<StrokeTCBean> mStrokeTCBeans;
    private StrokeTCRvAdapterNew mStrokeTCRvAdapter;
    public static final String[] STROKE_TAB_TITLES = new String[]{"前循环", "后循环"};
    private List<StrokeTCBean> mStrokeTCBeans1;
    private StrokeTCRvAdapterNew mStrokeTCRvAdapter1;

    private AspectPo aspectPo;


    @Override
    public int getLayoutId() {
        return R.layout.activity_aspect_score;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        stlTitleFragStrokeMedice.setTabData(STROKE_TAB_TITLES);

        initData();

        loadData();


    }

    private void initData() {
        mStrokeTCBeans = prepareData();
        refrashAdapter(true);

        mStrokeTCBeans1 = prepareData1();
        refrashAdapter1(true);
    }


    private void loadData() {
        showLoadingDialog();

        RecordIdBean recordIdBean = new RecordIdBean(PatientCache.getRecordId());
        String request = GsonUtils.getGson().toJson(recordIdBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getAspect(requestBody)
                .enqueue(new Callback<BaseObjectBean<AspectPo>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<AspectPo>> call, Response<BaseObjectBean<AspectPo>> response) {
                        BaseObjectBean<AspectPo> body = response.body();
                        if (body.getResult() == 1){
                            aspectPo = body.getData();
                            initData();
                        }
                        hideLoadingDialog();
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<AspectPo>> call, Throwable t) {
                        hideLoadingDialog();
                    }
                });
    }

    private void refrashAdapter(boolean b) {
        if (mStrokeTCRvAdapter == null || b) {
            mStrokeTCRvAdapter = new StrokeTCRvAdapterNew(this, mStrokeTCBeans);
            mStrokeTCRvAdapter.setOnSwitchClickListener(onSwitchClickListener);
            rvContentActTc.setAdapter(mStrokeTCRvAdapter);
        } else {
            mStrokeTCRvAdapter.notifyDataSetChanged();
        }
    }

    StrokeTCRvAdapterNew.OnSwitchChangeListener onSwitchClickListener = new StrokeTCRvAdapterNew.OnSwitchChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b, int position) {
            StrokeTCBean bean = mStrokeTCBeans.get(position);
            bean.setChecked(true);
            if (position == mStrokeTCBeans.size() - 1) {
                for (int i = 0; i < mStrokeTCBeans.size(); i++) {
                    StrokeTCBean bean1 = mStrokeTCBeans.get(i);
                    if (bean1 == null) {
                        continue;
                    }
                    if (i == position) {
                        continue;
                    }
                    bean1.setChecked(false);
                }
            }
            refrashAdapter(false);
        }
    };
    private void refrashAdapter1(boolean b) {
        if (mStrokeTCRvAdapter1 == null || b) {
            mStrokeTCRvAdapter1 = new StrokeTCRvAdapterNew(this, mStrokeTCBeans1);

            mStrokeTCRvAdapter1.setOnSwitchClickListener(onSwitchClickListener1);
            rvBackLoop.setAdapter(mStrokeTCRvAdapter1);
        } else {
            mStrokeTCRvAdapter1.notifyDataSetChanged();
        }
    }
    StrokeTCRvAdapterNew.OnSwitchChangeListener onSwitchClickListener1 = new StrokeTCRvAdapterNew.OnSwitchChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b, int position) {
            StrokeTCBean bean = mStrokeTCBeans1.get(position);
            bean.setChecked(true);
            for (int i = 0; i < mStrokeTCBeans1.size(); i++) {
                StrokeTCBean bean1 = mStrokeTCBeans1.get(i);
                if (bean1 == null) {
                    continue;
                }
                if (i == position) {
                    continue;
                }
                bean1.setChecked(false);
            }
            refrashAdapter1(false);
        }
    };
    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());

        stlTitleFragStrokeMedice.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    llBeforeLoop.setVisibility(View.VISIBLE);
                    llBackLoop.setVisibility(View.GONE);
                } else {
                    llBeforeLoop.setVisibility(View.GONE);
                    llBackLoop.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private List<StrokeTCBean> prepareData() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();
        //   list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        list.add(new StrokeTCBean(false, "1=（1）尾状核（C）", false, ""));
        list.add(new StrokeTCBean(false, "1=（2）豆状核（L）", false, ""));
        list.add(new StrokeTCBean(false, "1=（3）内囊（IC）", false, ""));
        list.add(new StrokeTCBean(false, "1=（4）大脑中动脉前皮质区（M1）", false, ""));
        list.add(new StrokeTCBean(false, "1=（5）岛叶皮质（I）", false, ""));
        list.add(new StrokeTCBean(false, "1=（6）大脑中动脉岛叶外侧皮质区（M2）", false, ""));
        list.add(new StrokeTCBean(false, "1=（7）大脑中动脉后皮层区（M3）", false, ""));
        list.add(new StrokeTCBean(false, "1=（8）M1上方的大脑中动脉皮层（M4）", false, ""));
        list.add(new StrokeTCBean(false, "1=（9）M2上方的大脑中动脉皮层（M5）", false, ""));
        list.add(new StrokeTCBean(false, "1=（10）M3上方的大脑中动脉皮层（M6）", false, ""));
        list.add(new StrokeTCBean(false, "0=（11）以上区域均无异常", false, ""));

        if (aspectPo == null){
            return list;
        }
        list.get(0).setChecked(aspectPo.aspectBeforeC.equals("1"));
        list.get(1).setChecked(aspectPo.aspectBeforeL.equals("1"));
        list.get(2).setChecked(aspectPo.aspectBeforeIc.equals("1"));
        list.get(3).setChecked(aspectPo.aspectBeforeM1.equals("1"));
        list.get(4).setChecked(aspectPo.aspectBeforeI.equals("1"));
        list.get(5).setChecked(aspectPo.aspectBeforeM2.equals("1"));
        list.get(6).setChecked(aspectPo.aspectBeforeM3.equals("1"));
        list.get(7).setChecked(aspectPo.aspectBeforeM4.equals("1"));
        list.get(8).setChecked(aspectPo.aspectBeforeM5.equals("1"));
        list.get(9).setChecked(aspectPo.aspectBeforeM6.equals("1"));
        list.get(10).setChecked(aspectPo.aspectBeforeNone.equals("1"));
        return list;
    }

    private List<StrokeTCBean> prepareData1() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();
        //   list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        list.add(new StrokeTCBean(false, "2=（1）脑桥任何部位", false, ""));
        list.add(new StrokeTCBean(false, "2=（2）中脑任何部位", false, ""));
        list.add(new StrokeTCBean(false, "1=（3）左侧小脑", false, ""));
        list.add(new StrokeTCBean(false, "1=（4）右侧小脑", false, ""));
        list.add(new StrokeTCBean(false, "1=（5）左侧丘脑", false, ""));
        list.add(new StrokeTCBean(false, "1=（6）右侧丘脑", false, ""));
        list.add(new StrokeTCBean(false, "1=（7）左侧大脑后动脉供血区", false, ""));
        list.add(new StrokeTCBean(false, "1=（8）右侧大脑后动脉供血区", false, ""));
        list.add(new StrokeTCBean(false, "0=（9）以上区域均无异常", false, ""));

        if (aspectPo == null){
            return list;
        }
        list.get(0).setChecked(aspectPo.aspectAfterPons.equals("2"));
        list.get(1).setChecked(aspectPo.aspectAfterMidbrain.equals("2"));
        list.get(2).setChecked(aspectPo.aspectAfterCerebellumleft.equals("1"));
        list.get(3).setChecked(aspectPo.aspectAfterCerebellumright.equals("1"));
        list.get(4).setChecked(aspectPo.aspectAfterMidbrainleft.equals("1"));
        list.get(5).setChecked(aspectPo.aspectAfterMidbrainright.equals("1"));
        list.get(6).setChecked(aspectPo.aspectAfterBrainarteryleft.equals("1"));
        list.get(7).setChecked(aspectPo.aspectAfterBrainarteryright.equals("1"));
        list.get(8).setChecked(aspectPo.aspectAfterNone.equals("1"));
        return list;
    }
}
