package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    RecyclerView rvContentActTc;
    @BindView(R.id.stl_title_frag_stroke_medice)
    SegmentTabLayout stlTitleFragStrokeMedice;
    @BindView(R.id.ll_before_loop)
    LinearLayout llBeforeLoop;
    @BindView(R.id.rv_back_loop)
    RecyclerView rvBackLoop;
    @BindView(R.id.ll_back_loop)
    LinearLayout llBackLoop;

    private List<StrokeTCBean> mStrokeTCBeans;
    private StrokeTCRvAdapter mStrokeTCRvAdapter;
    public static final String[] STROKE_TAB_TITLES = new String[]{"前循环", "后循环"};
    private List<StrokeTCBean> mStrokeTCBeans1;
    private StrokeTCRvAdapter mStrokeTCRvAdapter1;

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

        mStrokeTCBeans = prepareData();
        mStrokeTCRvAdapter = new StrokeTCRvAdapter(R.layout.adapter_header_single_text, R.layout.adapter_rv_stroke_thrombolysis_symptom_item, mStrokeTCBeans);

        rvContentActTc.setLayoutManager(new LinearLayoutManager(mContext));
        rvContentActTc.setAdapter(mStrokeTCRvAdapter);
        mStrokeTCRvAdapter.setEmptyView(R.layout.view_empty_for_rv);


        mStrokeTCBeans1 = prepareData1();
        mStrokeTCRvAdapter1 = new StrokeTCRvAdapter(R.layout.adapter_header_single_text, R.layout.adapter_rv_stroke_thrombolysis_symptom_item, mStrokeTCBeans1);

        rvBackLoop.setLayoutManager(new LinearLayoutManager(mContext));
        rvBackLoop.setAdapter(mStrokeTCRvAdapter1);
        mStrokeTCRvAdapter1.setEmptyView(R.layout.view_empty_for_rv);

    }

    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());

        mStrokeTCRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tsb_root) {
                    final boolean checked = mStrokeTCBeans.get(position).getChecked();
                    if (!mStrokeTCBeans.get(position).isHeader()) {
                        mStrokeTCBeans.get(position).setChecked(!checked);
                        mStrokeTCRvAdapter.notifyItemChanged(position);
                    }
                    if (position == 15) {
                        // 清除1~14项的选中状态
                        if (!checked) {
                            mStrokeTCBeans.get(position).setChecked(true);
                            for (int i = 1; i < 15; i++) {
                                mStrokeTCBeans.get(i).setChecked(false);
                            }
                        }
                    } else if (position == mStrokeTCBeans.size() - 1) {
                        // 清除相对禁忌症中1~6项的选中状态
                        if (!checked) {
                            mStrokeTCBeans.get(position).setChecked(true);
                            for (int i = 17; i < mStrokeTCBeans.size() - 1; i++) {
                                mStrokeTCBeans.get(i).setChecked(false);
                            }
                        }
                    }
                    mStrokeTCRvAdapter.notifyDataSetChanged();
                }
            }
        });

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
        list.add(new StrokeTCBean(false, "1=（9）M2上方的大脑中动脉皮层（M5）", false, ""));
        list.add(new StrokeTCBean(false, "0=（9）以上区域均无异常", false, ""));
        return list;
    }
}
