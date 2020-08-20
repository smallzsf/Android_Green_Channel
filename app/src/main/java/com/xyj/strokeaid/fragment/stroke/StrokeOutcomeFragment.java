package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
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
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 卒中抢救流程  --  转归
 *
 * @author Licy
 */
public class StrokeOutcomeFragment extends BaseFragment {

    @BindView(R.id.rv_content_frag_outcome)
    RecyclerView rvContentFragOutcome;
    @BindView(R.id.srl_fresh_frag_outcome)
    SwipeRefreshLayout srlFreshFragOutcome;

    private String mPatientId;
    private String mDocId;

    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;

    private StrokeOutcomeFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patientId 患者ID
     * @param docId     医生id
     * @return A new instance of fragment StrokeAngioplastyFragment.
     */
    public static StrokeOutcomeFragment newInstance(String patientId, String docId) {
        StrokeOutcomeFragment fragment = new StrokeOutcomeFragment();
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
    protected int getLayoutId() {
        return R.layout.stroke_fragment_outcome;
    }

    @Override
    protected void initView(@NonNull View view) {

        mStrokeProcessBeans = new ArrayList<>();
        mStrokeProcessBeans.add(new StrokeProcessBean("急诊绿道转归", 1, "", RouteUrl.GREEN_CHANNEL_OUTCOME, false));
        mProcessRvAdapter = new StrokeProcessRvAdapter(R.layout.adapter_rv_stroke_path_item, mStrokeProcessBeans);

        rvContentFragOutcome.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragOutcome.addItemDecoration(new SpacesItemDecoration(0, 0, 0, 1, LinearLayout.VERTICAL));
        rvContentFragOutcome.setAdapter(mProcessRvAdapter);
        mProcessRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    protected void initListener() {

        srlFreshFragOutcome.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        mProcessRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                ARouter.getInstance().build(RouteUrl.GREEN_CHANNEL_OUTCOME).navigation();
            }
        });
    }
}