package com.xyj.strokeaid.fragment.stroke;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.StrokeMainActivity;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.BindView;

/**
 * @Description: 血液检查
 * @Author: crq
 * @CreateDate: 2020/8/25 14:07
 */
public class StrokeBloodExaminationFragment extends BaseFragment {

    @BindView(R.id.tl_title_act_stroke_main)
    TabLayout tlTitleActStrokeMain;
    @BindView(R.id.vp_content_act_stroke_main)
    ViewPager2 vpContentActStrokeMain;
    public static final String[] STROKE_TAB_TITLES = new String[]{"生物标识物", "凝血功能","血常规","血生化"};

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_blood_examination;
    }

    @Override
    protected void initView(@NonNull View view) {
        for (String strokeTabTitle :STROKE_TAB_TITLES) {
            tlTitleActStrokeMain.addTab(tlTitleActStrokeMain.newTab().setText(strokeTabTitle));
        }

        // 禁止滑动
        vpContentActStrokeMain.setUserInputEnabled(false);
        vpContentActStrokeMain.setOffscreenPageLimit(STROKE_TAB_TITLES.length);
        vpContentActStrokeMain.setAdapter(new StrokeViewPageAdapter(getActivity()));
    }

    @Override
    protected void initListener() {
        tlTitleActStrokeMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
                    return new StrokeBiologyTagFragment();
                case 1:
                    return new StrokeCruoragFunctionFragment();
                case 2:
                    return new StrokeBloodRoutineExaminationFragment();

                case 3:
                    return new StrokeBloodBiochemistryFragment();


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
