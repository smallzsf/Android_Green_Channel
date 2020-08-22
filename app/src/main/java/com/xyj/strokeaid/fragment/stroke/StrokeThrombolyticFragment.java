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
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.helper.RouterHelper;
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 治疗  --  溶栓
 *
 * @author Licy
 */
public class StrokeThrombolyticFragment extends BaseFragment {

    @BindView(R.id.rv_content_frag_stoke_thrombolytic)
    RecyclerView rvContentFragStokeThrombolytic;
    @BindView(R.id.srl_fresh_frag_stoke_thrombolytic)
    SwipeRefreshLayout srlFreshFragStokeThrombolytic;

    private String mPatientId;
    private String mDocId;
    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;

    private StrokeThrombolyticFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patientId 患者ID
     * @param docId     医生id
     * @return A new instance of fragment StrokeAngioplastyFragment.
     */
    public static StrokeThrombolyticFragment newInstance(String patientId, String docId) {
        StrokeThrombolyticFragment fragment = new StrokeThrombolyticFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
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
        list.add(new StrokeProcessBean("溶栓医生接诊时间", "STT01", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_DOC_RECEIVE, false));
        list.add(new StrokeProcessBean("溶栓适应症", "STT02", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_INDICATIONS, false));
        list.add(new StrokeProcessBean("溶栓禁忌症", "STT03", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS, false));
        list.add(new StrokeProcessBean("溶栓知情同意", "STT04", 1, "", RouteUrl.Stroke.STROKE_THROMBOLYSIS_INFORMED_CONSENT, false));
        list.add(new StrokeProcessBean("溶栓前NIHSS评分", "STT05", 1, "", RouteUrl.Stroke.STROKE_NIHSS, false));
        list.add(new StrokeProcessBean("THRIVE评分", "STT06", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("静脉溶栓", "STT07", 1, "", RouteUrl.Stroke.STROKE_INTRAVENOU_THROMBOLYSIS, false));
        list.add(new StrokeProcessBean("溶栓后即刻NIHSS评分", "STT08", 1, "", RouteUrl.Stroke.STROKE_NIHSS, false));
        list.add(new StrokeProcessBean("溶栓并发症", "STT09", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        list.add(new StrokeProcessBean("延误分析", "STT10", 1, "", RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME, false));
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_thrombolysis;
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