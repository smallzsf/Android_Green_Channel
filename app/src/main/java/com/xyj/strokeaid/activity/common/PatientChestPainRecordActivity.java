package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.PatientMenuRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.PatientMenuBean;
import com.xyj.strokeaid.fragment.chestpain.ChestPainVitalSignsFragment;
import com.xyj.strokeaid.fragment.chestpain.SurgicalTreatmentFragment;
import com.xyj.strokeaid.fragment.stroke.AuxiliaryExamFragment;
import com.xyj.strokeaid.fragment.stroke.DiagnosticEvaluationFragment;
import com.xyj.strokeaid.fragment.stroke.DiseaseRecordFragment;
import com.xyj.strokeaid.fragment.stroke.EmptyFragment;
import com.xyj.strokeaid.fragment.stroke.OtherDisposalFragment;
import com.xyj.strokeaid.fragment.stroke.StartGreenwayFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodExaminationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeMedicationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeNihssFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeOperationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeScoresFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeVitalSignsFragment;
import com.xyj.strokeaid.fragment.stroke.TimeNodeFragment;
import com.xyj.strokeaid.fragment.stroke.TransferFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * PatientChestPainRecordActivity
 * description: 胸痛通道流程页面
 *
 * @author : Licy
 * @date : 2020/9/1
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.ChestPain.CHEST_PAIN_HOME)
public class PatientChestPainRecordActivity extends BaseActivity {

    @BindView(R.id.iv_back_act_pcpr)
    ImageView ivBackActPcpr;
    @BindView(R.id.tv_title_act_pcpr)
    TextView tvTitleActPcpr;
    @BindView(R.id.tv_subtitle_act_pcpr)
    TextView tvSubtitleActPcpr;
    @BindView(R.id.tv_start_dis_time_act_pcpr)
    Chronometer tvStartDisTimeActPcpr;
    @BindView(R.id.tv_in_hos_time_act_pcpr)
    Chronometer tvInHosTimeActPcpr;
    @BindView(R.id.rv_menu_act_pcpr)
    RecyclerView rvMenuActPcpr;
    @BindView(R.id.vp_content_act_pcpr)
    ViewPager2 vpContentActPcpr;

    private PatientMenuRvAdapter mMenuRvAdapter;
    private List<PatientMenuBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_chest_pain_record;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mMenuTitles = new ArrayList<>();
        for (String greenChannelTabTitle : Constants.GREEN_CHANNEL_CHEST_PAIN_MENU_TITLES) {
            mMenuTitles.add(new PatientMenuBean(greenChannelTabTitle, false));
        }
        mMenuTitles.get(0).setChecked(true);
        mSelectedTab = 0;
        mMenuRvAdapter = new PatientMenuRvAdapter(R.layout.adapter_green_channel_menu_item, mMenuTitles);

        rvMenuActPcpr.setLayoutManager(new LinearLayoutManager(mContext));
        rvMenuActPcpr.setAdapter(mMenuRvAdapter);

        vpContentActPcpr.setUserInputEnabled(false);
        vpContentActPcpr.setOffscreenPageLimit(4);
        vpContentActPcpr.setAdapter(new ChestPainRecordVpAdapter(PatientChestPainRecordActivity.this, "", ""));

        tvStartDisTimeActPcpr.setBase(SystemClock.elapsedRealtime());
        tvInHosTimeActPcpr.setBase(SystemClock.elapsedRealtime());
        tvStartDisTimeActPcpr.start();
        tvInHosTimeActPcpr.start();
    }

    @Override
    public void initListener() {
        mMenuRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mSelectedTab == position) {
                    // 选中相同的
                    return;
                } else {
                    // 切换
                    for (int i = 0; i < mMenuTitles.size(); i++) {
                        if (i == position) {
                            mMenuTitles.get(i).setChecked(true);
                        } else {
                            mMenuTitles.get(i).setChecked(false);
                        }
                    }
                    mMenuRvAdapter.notifyItemChanged(mSelectedTab);
                    mMenuRvAdapter.notifyItemChanged(position);
                    mSelectedTab = position;
                }
                vpContentActPcpr.setCurrentItem(position);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.iv_back_act_pcpr, R.id.tv_title_act_pcpr, R.id.tv_subtitle_act_pcpr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_act_pcpr:
                finish();
                break;
            case R.id.tv_title_act_pcpr:
            case R.id.tv_subtitle_act_pcpr:
                // TODO: 2020/8/25 跳转用户信息页面
                break;
            default:
                break;
        }
    }

    private class ChestPainRecordVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public ChestPainRecordVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public ChestPainRecordVpAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public ChestPainRecordVpAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
            super(fragmentManager, lifecycle);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    // 生命体征
                    return ChestPainVitalSignsFragment.newInstance(patientId, docId);
                case 10:

                    return SurgicalTreatmentFragment.newInstance(patientId, docId);
                default:
                    return EmptyFragment.newInstance();
            }
        }

        @Override
        public int getItemCount() {
            return mMenuTitles.size();
        }
    }

}

    
    
       
    