package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeProcessRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.RouterHelper;
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Description: 介入
 * @Author: crq
 * @CreateDate: 2020/8/29 9:42
 */
public class StrokeGetInvolvedFragment extends BaseStrokeFragment {

    @BindView(R.id.rv_content_frag_stoke_thrombolytic)
    RecyclerView rvContentFragStokeThrombolytic;
    @BindView(R.id.srl_fresh_frag_stoke_thrombolytic)
    SwipeRefreshLayout srlFreshFragStokeThrombolytic;

    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;

    public StrokeGetInvolvedFragment() {
    }

    public static StrokeGetInvolvedFragment newInstance(String recordId) {
        StrokeGetInvolvedFragment fragment = new StrokeGetInvolvedFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView(@NonNull View view) {

        mStrokeProcessBeans = prepareData();
        mProcessRvAdapter = new StrokeProcessRvAdapter(R.layout.adapter_rv_stroke_path_item, mStrokeProcessBeans);

        rvContentFragStokeThrombolytic.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragStokeThrombolytic.addItemDecoration(new SpacesItemDecoration(0, 0, 0, 1, LinearLayout.VERTICAL));
        rvContentFragStokeThrombolytic.setAdapter(mProcessRvAdapter);
        mProcessRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    private List<StrokeProcessBean> prepareData() {

        List<StrokeProcessBean> list = new ArrayList<>();
        list.add(new StrokeProcessBean("介入适应症", "STT01", 1, "", RouteUrl.Stroke.STROKE_GET_INVOLVED_INDICATIONS, false));
        list.add(new StrokeProcessBean("介入禁忌症", "STT02", 1, "", RouteUrl.Stroke.STROKE_GET_INVOLVED_CONTRAINDICATIONS, false));
        list.add(new StrokeProcessBean("介入知情同意", "STT03", 1, "", RouteUrl.Stroke.STROKE_GET_INVOLVED_INFORMED_CONSENT, false));
        list.add(new StrokeProcessBean("术前准备", "STT04", 1, "", RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_BEFORE, false));
        list.add(new StrokeProcessBean("术中准备", "STT05", 1, "", RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_ON, false));
        list.add(new StrokeProcessBean("术后准备", "STT06", 1, "",RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_AFTER, false));
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_get_involved;
    }

    @Override
    protected void initListener() {

        srlFreshFragStokeThrombolytic.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
                    RouterHelper.navWithPatient(mStrokeProcessBeans.get(position).getDestination(), "11");
                }
            }
        });
    }
}
