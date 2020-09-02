package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.BindView;

/**
 * @Description: 条目评分工具
 * @Author: crq
 * @CreateDate: 2020/9/2 11:31
 */
public class StrokeNewScoreFragment  extends BaseFragment {


    @BindView(R.id.vp_content_frag_stroke_medice)
    ViewPager2 vpContentFragStrokeMedice;

    private String mPatientId;
    private String mDocId;

    public StrokeNewScoreFragment() {
        // Required empty public constructor
    }

    public static StrokeNewScoreFragment newInstance(String patientId, String docId) {
        StrokeNewScoreFragment fragment = new StrokeNewScoreFragment();
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
        return R.layout.fragment_new_score;
    }

    @Override
    protected void initView(@NonNull View view) {

        // 禁止滑动
        vpContentFragStrokeMedice.setUserInputEnabled(false);
        vpContentFragStrokeMedice.setAdapter(new  StrokeNewScoreVpAdapter(this, mPatientId, mDocId));


    }

    @Override
    protected void initListener() {
      //  vpContentFragStrokeMedice.setCurrentItem(0);
    }

    private class  StrokeNewScoreVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public StrokeNewScoreVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeNewScoreVpAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeNewScoreVpAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
            super(fragmentManager, lifecycle);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

                return StrokeNewScoreContentFragment.newInstance(patientId, docId);

        }

        @Override
        public int getItemCount() {
            return  1;
        }
    }
}
