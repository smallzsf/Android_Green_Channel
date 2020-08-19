package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.fragment.stroke.StrokeDetectionFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeOutcomeFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeTreatmentFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeTriageFragment;
import com.xyj.strokeaid.view.BaseTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * StrokeMainActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/18
 * email ：licy3051@qq.com
 */
public class StrokeMainActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_main)
    BaseTitleBar titleBarActStrokeMain;
    @BindView(R.id.tl_title_act_stroke_main)
    TabLayout tlTitleActStrokeMain;
    @BindView(R.id.vp_content_act_stroke_main)
    ViewPager2 vpContentActStrokeMain;
    @BindView(R.id.tv_first_time_include_stroke_bottom)
    TextView tvFirstTimeIncludeStrokeBottom;
    @BindView(R.id.tv_first_time_desc_include_stroke_bottom)
    TextView tvFirstTimeDescIncludeStrokeBottom;
    @BindView(R.id.tv_second_time_include_stroke_bottom)
    TextView tvSecondTimeIncludeStrokeBottom;
    @BindView(R.id.tv_second_time_desc_include_stroke_bottom)
    TextView tvSecondTimeDescIncludeStrokeBottom;
    @BindView(R.id.tv_score_include_stroke_bottom)
    TextView tvScoreIncludeStrokeBottom;
    @BindView(R.id.tv_time_axis_include_stroke_bottom)
    TextView tvTimeAxisIncludeStrokeBottom;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_main;
    }

    @Override
    public void initView() {

        for (String strokeTabTitle : Constants.STROKE_TAB_TITLES) {
            tlTitleActStrokeMain.addTab(tlTitleActStrokeMain.newTab().setText(strokeTabTitle));
        }

        // 禁止滑动
        vpContentActStrokeMain.setUserInputEnabled(false);
        vpContentActStrokeMain.setOffscreenPageLimit(Constants.STROKE_TAB_TITLES.length);
        vpContentActStrokeMain.setAdapter(new StrokeViewPageAdapter(this));

    }

    @Override
    public void initListener() {

        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v -> {
                    // TODO: 2020/8/19  跳转该患者的个人信息页面（新建页面）
                });

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_time_axis_include_stroke_bottom)
    public void onViewClicked() {

    }


    private static class StrokeViewPageAdapter extends FragmentStateAdapter {

        public StrokeViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        public StrokeViewPageAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        public StrokeViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new StrokeTriageFragment();
                case 1:
                    return new StrokeDetectionFragment();
                case 2:
                    return new StrokeTreatmentFragment();
                case 3:
                default:
                    return new StrokeOutcomeFragment();
            }
        }


        @Override
        public int getItemCount() {
            return Constants.STROKE_TAB_TITLES.length;
        }

    }

}

    
    
       
    