package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 评分内容
 *
 * @author Licy
 */
public class StrokeNewScoreContentFragment extends BaseFragment {

    @BindView(R.id.rv_content_frag_stoke_thrombolytic)
    RecyclerView rvContentFragStokeThrombolytic;
    @BindView(R.id.srl_fresh_frag_stoke_thrombolytic)
    SwipeRefreshLayout srlFreshFragStokeThrombolytic;

    private String mPatientId;
    private String mDocId;
    private StrokeProcessRvAdapter mProcessRvAdapter;
    private List<StrokeProcessBean> mStrokeProcessBeans;

    public StrokeNewScoreContentFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patientId 患者ID
     * @param docId     医生id
     * @return A new instance of fragment StrokeAngioplastyFragment.
     */
    public static StrokeNewScoreContentFragment newInstance(String patientId, String docId) {
        StrokeNewScoreContentFragment fragment = new StrokeNewScoreContentFragment();
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
     //   rvContentFragStokeThrombolytic.addItemDecoration(new SpacesItemDecoration(0, 0, 0, 1, LinearLayout.VERTICAL));
        rvContentFragStokeThrombolytic.setAdapter(mProcessRvAdapter);
        mProcessRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    private List<StrokeProcessBean> prepareData() {

        List<StrokeProcessBean> list = new ArrayList<>();
        list.add(new StrokeProcessBean("mRS评分", "STT01", 1, "", RouteUrl.Stroke.STROKE_MRS_SCORE, false));
        list.add(new StrokeProcessBean("GCS评分", "STT02", 1, "", RouteUrl.Stroke.STROKE_GCS_SCORE, false));
        list.add(new StrokeProcessBean("Fisher分级", "STT03", 1, "", RouteUrl.Stroke.STROKE_FiISHEER_SCORE, false));
        list.add(new StrokeProcessBean("Hunt-Hess评分", "STT04", 1, "", RouteUrl.Stroke.STROKE_HUNT_HESS_SCORE, false));
        list.add(new StrokeProcessBean("CHADS2评分", "STT05", 1, "", RouteUrl.Stroke.STROKE_CHADS2_SCORE, false));
        list.add(new StrokeProcessBean("HAS-BLED评分", "STT06", 1, "", RouteUrl.Stroke.STROKE_HAS_BLED_SCORE, false));
        list.add(new StrokeProcessBean("洼田吞咽评定", "STT07", 1, "", RouteUrl.Stroke.STROKE_FROG_FIELD_EVALUATE, false));
        list.add(new StrokeProcessBean("Spetzler-Marin评分", "STT08", 1, "", RouteUrl.Stroke.STROKE_SPETZLER_MARINSCORE, false));
        list.add(new StrokeProcessBean("THRIVE评分", "STT09", 1, "", RouteUrl.Stroke.STROKE_THRIVE_SCORE, false));
        list.add(new StrokeProcessBean("FAST-ED评分", "STT10", 1, "", RouteUrl.Stroke.STROKE_FAST_ED__SCORE, false));
        list.add(new StrokeProcessBean("ASPECT评分", "STT11", 1, "", RouteUrl.Stroke.STROKE_ASPECT_SCORE, false));
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