package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeProcessRvAdapter;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.helper.RouterHelper;
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
  * @Package:        com.xyj.strokeaid.fragment.stroke
  * @ClassName:      StrokeDetectionFragment
  * @Description:    检珍Fragment
  * @Autho:          王水雷
  * @Time:           2020/8/22
 */
public class StrokeDetectionFragment extends BaseFragment {

    @BindView(R.id.rv_content_frag_stoke )
    RecyclerView rvContentFragStoke ;
    @BindView(R.id.srl_fresh_frag_stoke)
    SwipeRefreshLayout srlFreshFragStoke;
    private String mPatientId;
    private String mDocId;
    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;
    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_detection;
    }
    @Override
    protected void initView(@NonNull View view) {
        mStrokeProcessBeans = prepareData();
        mProcessRvAdapter = new StrokeProcessRvAdapter(R.layout.adapter_rv_stroke_path_item, mStrokeProcessBeans);

        rvContentFragStoke.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragStoke.addItemDecoration(new SpacesItemDecoration(0, 0, 0, 1, LinearLayout.VERTICAL));
        rvContentFragStoke.setAdapter(mProcessRvAdapter);
        mProcessRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }
    private List<StrokeProcessBean> prepareData() {

        List<StrokeProcessBean> list = new ArrayList<>();
        list.add(new StrokeProcessBean("病情记录", "STT01", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYTIC_DOC_RECEIVE, false));
        list.add(new StrokeProcessBean("首次NIHSS评分", "STT02", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_INDICATIONS, false));
        list.add(new StrokeProcessBean("首次GCS评分", "STT03", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS, false));
        list.add(new StrokeProcessBean("患者到达CT室", "STT04", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("影像检查", "STT05", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("ASPECT评分", "STT06", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("实验室检查", "STT07", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("初步诊断", "STT08", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("治疗方案", "STT09", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("参与临床试验", "STT10", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        return list;
    }
    @Override
    protected void initListener() {
        srlFreshFragStoke.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        mProcessRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (TextUtils.isEmpty(mStrokeProcessBeans.get(position).getDestination())) {
                    showToast("地址不存在~");
                } else {
                    //RouterHelper.navWithPatient(mStrokeProcessBeans.get(position).getDestination(), "11");
                }
            }
        });
    }
}