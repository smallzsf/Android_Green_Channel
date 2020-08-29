package com.xyj.strokeaid.fragment;

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
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.stroke.StrokArterialAneurysmFragment;
import com.xyj.strokeaid.fragment.stroke.StrokEcaFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeGetInvolvedFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeSanguineousApoplexyFragment;

import butterknife.BindView;

/**
 * StrokeOperationFragment
 * description: 卒中 手术治疗（包含血管内开通、CEA/CAS、动脉瘤、脑出血）
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeOperationFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_stroke_medice)
    SegmentTabLayout stlTitleFragStrokeMedice;
    @BindView(R.id.vp_content_frag_stroke_medice)
    ViewPager2 vpContentFragStrokeMedice;
    public static final String[] STROKE_OPERATIVE_TREATEMENT = new String[]{"介入", "脑出血", "动脉瘤", "CEA"};
    private String mPatientId;
    private String mDocId;

    public StrokeOperationFragment() {
        // Required empty public constructor
    }

    public static StrokeOperationFragment newInstance(String patientId, String docId) {
        StrokeOperationFragment fragment = new StrokeOperationFragment();
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
        return R.layout.fragment_stroke_operation;
    }

    @Override
    protected void initView(@NonNull View view) {
        stlTitleFragStrokeMedice.setTabData(STROKE_OPERATIVE_TREATEMENT);

        vpContentFragStrokeMedice.setAdapter(new StrokeMedicationVpAdapter(this, mPatientId, mDocId));
    }

    @Override
    protected void initListener() {
        stlTitleFragStrokeMedice.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpContentFragStrokeMedice.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    private class StrokeMedicationVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public StrokeMedicationVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeMedicationVpAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeMedicationVpAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
            super(fragmentManager, lifecycle);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return StrokeGetInvolvedFragment.newInstance(patientId, docId);
            } else if (position == 1) {
                return StrokeSanguineousApoplexyFragment.newInstance(patientId, docId);
            } else if (position == 2) {
                return StrokArterialAneurysmFragment.newInstance(patientId, docId);
            } else {
                return StrokEcaFragment.newInstance(patientId, docId);
            }

        }


        @Override
        public int getItemCount() {
            return STROKE_OPERATIVE_TREATEMENT.length;
        }
    }

}