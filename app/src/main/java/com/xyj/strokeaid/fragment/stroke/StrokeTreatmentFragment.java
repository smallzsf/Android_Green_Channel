package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
 * 卒中绿道流程  -- 治疗
 *
 * @author Licy
 */
public class StrokeTreatmentFragment extends BaseFragment {


    @BindView(R.id.stl_frag_treat)
    SegmentTabLayout stlFragTreat;
    @BindView(R.id.vp_content_frag_treat)
    ViewPager2 vpContentFragTreat;

    private String mPatientId;
    private String mDocId;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patientId 患者ID
     * @param docId     医生id
     * @return A new instance of fragment StrokeAngioplastyFragment.
     */
    public static StrokeTreatmentFragment newInstance(String patientId, String docId) {
        StrokeTreatmentFragment fragment = new StrokeTreatmentFragment();
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
        stlFragTreat.setTabData(Constants.STROKE_TREATMENT_TAB_TITLES);

        vpContentFragTreat.setUserInputEnabled(false);
        vpContentFragTreat.setAdapter(new StrokeTreatPagerAdapter(this, mPatientId, mDocId));
        vpContentFragTreat.setCurrentItem(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_treatment;
    }

    @Override
    protected void initListener() {
        stlFragTreat.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpContentFragTreat.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    public static class StrokeTreatPagerAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public StrokeTreatPagerAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return StrokeThrombolyticFragment.newInstance(patientId, docId);
            } else {
                return StrokeAngioplastyFragment.newInstance(patientId, docId);
            }
        }

        @Override
        public int getItemCount() {
            return Constants.STROKE_TREATMENT_TAB_TITLES.length;
        }
    }
}