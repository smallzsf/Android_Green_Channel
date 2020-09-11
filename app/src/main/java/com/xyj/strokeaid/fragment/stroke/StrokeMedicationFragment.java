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
 * StrokeMedicationFragment
 * description: 卒中 药物治疗（包含静脉溶栓、住院用药、出院带药）
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeMedicationFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_stroke_medice)
    SegmentTabLayout stlTitleFragStrokeMedice;
    @BindView(R.id.vp_content_frag_stroke_medice)
    ViewPager2 vpContentFragStrokeMedice;

    private String mRecordId;

    public StrokeMedicationFragment() {
    }

    public static StrokeMedicationFragment newInstance(String recordId) {
        StrokeMedicationFragment fragment = new StrokeMedicationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_medication;
    }

    @Override
    protected void initView(@NonNull View view) {
        stlTitleFragStrokeMedice.setTabData(Constants.STROKE_MEDICATION_TITLES);
        // 禁止滑动
        vpContentFragStrokeMedice.setUserInputEnabled(false);
        vpContentFragStrokeMedice.setOffscreenPageLimit(Constants.STROKE_MEDICATION_TITLES.length);

        vpContentFragStrokeMedice.setAdapter(new StrokeMedicationVpAdapter(this, mRecordId));


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

        String recordId;


        public StrokeMedicationVpAdapter(@NonNull Fragment fragment, String recordId) {
            super(fragment);
            this.recordId = recordId;
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position == 0) {
                return StrokeThrombolysisFragment.newInstance(recordId);
            } else if (position == 1) {
                return StrokeInHosDrugFragment.newInstance(recordId);
            } else {
                return StrokeOutHosDrugFragment.newInstance(recordId);
            }
        }

        @Override
        public int getItemCount() {
            return Constants.STROKE_MEDICATION_TITLES.length;
        }
    }
}