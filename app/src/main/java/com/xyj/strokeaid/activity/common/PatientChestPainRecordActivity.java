package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.PatientMenuRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.PatientMenuBean;
import com.xyj.strokeaid.fragment.chestpain.ChestPainAssistantTestFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainBloodTestFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainDiseaseRecordFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainEcgExaminFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainInitDrugFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainIntraConsultFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainIntraThromFragment;
import com.xyj.strokeaid.fragment.chestpain.ChestPainOtherTretmentFragment;
import com.xyj.strokeaid.fragment.chestpain.OriginalDiagnoseFragment;
import com.xyj.strokeaid.fragment.chestpain.PatientOutcomeFragment;
import com.xyj.strokeaid.fragment.chestpain.SurgicalTreatmentFragment;
import com.xyj.strokeaid.fragment.chestpain.TreatmentDecisionFragment;
import com.xyj.strokeaid.fragment.common.TimeNodeFragment;
import com.xyj.strokeaid.fragment.common.TriageInfoFragment;
import com.xyj.strokeaid.fragment.common.VitalSignsFragment;
import com.xyj.strokeaid.fragment.stroke.EmptyFragment;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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

    @BindView(R.id.rv_menu_act_pcpr)
    RecyclerView rvMenuActPcpr;
    @BindView(R.id.vp_content_act_pcpr)
    ViewPager2 vpContentActPcpr;
    @BindView(R.id.title_bar_act_pcpr)
    BaseTitleBar titleBarActPcpr;
    @BindView(R.id.tv_start_time_include_ct)
    Chronometer tvStartTimeIncludeCt;
    @BindView(R.id.tv_hos_time_include_ct)
    Chronometer tvHosTimeIncludeCt;

    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

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
        // set title
        SpannableString spannableString = new SpannableString("奔波霸（男-58-胸痛）");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
        spannableString.setSpan(relativeSizeSpan, 3, spannableString.length() - 1, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleBarActPcpr.setTitle(spannableString);

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
        vpContentActPcpr.setAdapter(new ChestPainRecordVpAdapter(PatientChestPainRecordActivity.this, "752594697788198912"));

        tvStartTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvHosTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvStartTimeIncludeCt.start();
        tvHosTimeIncludeCt.start();
    }

    @Override
    public void initListener() {

        titleBarActPcpr.setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v ->
                        ARouter.getInstance().build(RouteUrl.NEW_PATIENT)
                                .withInt(IntentKey.VIEW_TYPE, 2)
                                .withInt(IntentKey.DISEASE_VIEW_TYPE, 2)
                                .withString(IntentKey.RECORD_ID, mRecordId)
                                .navigation());

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
                vpContentActPcpr.setCurrentItem(position, false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private class ChestPainRecordVpAdapter extends FragmentStateAdapter {

        String recordId;

        public ChestPainRecordVpAdapter(@NonNull FragmentActivity fragmentActivity, String recordId) {
            super(fragmentActivity);
            this.recordId = recordId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    // 分诊信息
                    return TriageInfoFragment.newInstance(recordId, 2);
                case 1:
                    // 生命体征
                    return VitalSignsFragment.newInstance(recordId, 2);
                case 2:
                    //  病情信息
                    return ChestPainDiseaseRecordFragment.newInstance(recordId);
                case 3:
                    //  心电检查
                    return ChestPainEcgExaminFragment.newInstance(recordId);
                case 4:
                    // 会诊信息
                    return ChestPainIntraConsultFragment.newInstance(recordId);
                case 5:
                    // 血液检查
                    return ChestPainBloodTestFragment.newInstance(recordId);
                case 6:
                    //  影像检查
                    return ChestPainAssistantTestFragment.newInstance(recordId);
                case 7:
                    // 初始诊断
                    return OriginalDiagnoseFragment.newInstance(recordId);
                case 8:
                    // 初始药物
                    return ChestPainInitDrugFragment.newInstance(recordId);
                case 9:
                    // 治疗决策
                    return TreatmentDecisionFragment.newInstance(recordId);
                case 10:
                    // 静脉溶栓
                    return ChestPainIntraThromFragment.newInstance(recordId);
                case 11:
                    // 手术治疗
                    return SurgicalTreatmentFragment.newInstance(recordId);
                case 12:
                    // 其他处置
                    return ChestPainOtherTretmentFragment.newInstance(recordId);
                case 13:
                    // 患者转归
                    return PatientOutcomeFragment.newInstance(recordId);
                case 14:
                    // 时间节点
                    return TimeNodeFragment.newInstance(recordId, 2);
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

    
    
       
    