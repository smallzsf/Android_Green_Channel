package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import butterknife.BindView;

/**
 * @Description: 血液检查
 * @Author: crq
 * @CreateDate: 2020/8/25 14:07
 */
public class StrokeBloodExaminationFragment extends BaseFragment {

/*    @BindView(R.id.tl_title_act_stroke_main)
    TabLayout tlTitleActStrokeMain;*/
    @BindView(R.id.stl_title_frag_stroke_medice)
    SegmentTabLayout stlTitleFragStrokeMedice;
    @BindView(R.id.vp_content_act_stroke_main)
    ViewPager2 vpContentActStrokeMain;

    public static final String[] STROKE_TAB_TITLES = new String[]{"血糖", "血脂四项", "凝血功能", "其它"};
    public static final String[]  CHEST_PAIN_TAB_TITLES = new String[]{"生物标识物", "凝血功能", "血常规", "血生化"};

    private String mPatientId;
    private String mDocId;

    public StrokeBloodExaminationFragment() {
        // Required empty public constructor
    }

    public static StrokeBloodExaminationFragment newInstance(String patientId, String docId) {
        StrokeBloodExaminationFragment fragment = new StrokeBloodExaminationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_blood_examination;
    }

    @Override
    protected void initView(@NonNull View view) {
     /*   for (String strokeTabTitle : STROKE_TAB_TITLES) {
            tlTitleActStrokeMain.addTab(tlTitleActStrokeMain.newTab().setText(strokeTabTitle));
        }*/

        stlTitleFragStrokeMedice.setTabData(STROKE_TAB_TITLES);

        // 禁止滑动
        vpContentActStrokeMain.setUserInputEnabled(false);
        vpContentActStrokeMain.setOffscreenPageLimit(STROKE_TAB_TITLES.length);
        vpContentActStrokeMain.setAdapter(new StrokeViewPageAdapter(getActivity()));
    }

    @Override
    protected void initListener() {
    /*    tlTitleActStrokeMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpContentActStrokeMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

        stlTitleFragStrokeMedice.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpContentActStrokeMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }


    private static class StrokeViewPageAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public StrokeViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeViewPageAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
            super(fragmentManager, lifecycle);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    //胸痛 生物标识物
                   // return new StrokeBiologyTagFragment();
                    //卒中 血糖
                    return new StrokeBloodSugarFragment();
                case 1:
                    //胸痛 凝血功能
                    //return new StrokeCruoragFunctionFragment();
                    //卒中 血脂四项
                    return new StrokeBloodFatFragment();
                case 2:
                    //胸痛 血常规
                   // return new StrokeBloodRoutineExaminationFragment();
                    //卒中 凝血功能
                    return new StrokeCruoragFunctionFragment();
                case 3:
                    //胸痛 血生化
                    //return new StrokeBloodBiochemistryFragment();
                    //卒中 其它页面
                    return new StrokeOtherFragment();


                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return STROKE_TAB_TITLES.length;
        }

    }

}
