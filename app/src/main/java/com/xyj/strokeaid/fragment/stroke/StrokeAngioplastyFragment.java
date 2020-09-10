package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeProcessRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 治疗  --  介入
 *
 * @author Licy
 */
public class StrokeAngioplastyFragment extends BaseStrokeFragment {

    @BindView(R.id.rv_content_frag_stoke_ang)
    RecyclerView rvContentFragStokeAng;
    @BindView(R.id.srl_fresh_frag_stoke_ang)
    SwipeRefreshLayout srlFreshFragStokeAng;

    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;

    private StrokeAngioplastyFragment() {
    }

    public static StrokeAngioplastyFragment newInstance(String recordId) {
        StrokeAngioplastyFragment fragment = new StrokeAngioplastyFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView(@NonNull View view) {

        mStrokeProcessBeans = prepareData();
        mProcessRvAdapter = new StrokeProcessRvAdapter(R.layout.adapter_rv_stroke_path_item, mStrokeProcessBeans);

        rvContentFragStokeAng.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragStokeAng.addItemDecoration(new SpacesItemDecoration(0, 0, 0, 1, LinearLayout.VERTICAL));
        rvContentFragStokeAng.setAdapter(mProcessRvAdapter);
        mProcessRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    private List<StrokeProcessBean> prepareData() {

        List<StrokeProcessBean> list = new ArrayList<>();
        list.add(new StrokeProcessBean("介入医生接诊时间", "STA01", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("介入适应症", "STA02", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("介入禁忌症", "STA03", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("介入知情同意", "STA04", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("启动导管室", "STA05", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("急诊术前准备完成时间", "STA06", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("延误分析", "STA07", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_angioplasty;
    }

    @Override
    protected void initListener() {

        srlFreshFragStokeAng.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
                    ARouter.getInstance()
                            .build(mStrokeProcessBeans.get(position).getDestination())
                            .navigation();
                }
            }
        });
    }
}