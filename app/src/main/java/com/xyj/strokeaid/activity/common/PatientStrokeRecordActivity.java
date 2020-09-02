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
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
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
import com.xyj.strokeaid.fragment.stroke.AuxiliaryExamFragment;
import com.xyj.strokeaid.fragment.stroke.DiagnosticEvaluationFragment;
import com.xyj.strokeaid.fragment.stroke.DiseaseRecordFragment;
import com.xyj.strokeaid.fragment.stroke.EmptyFragment;
import com.xyj.strokeaid.fragment.stroke.OtherDisposalFragment;
import com.xyj.strokeaid.fragment.stroke.StartGreenwayFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodExaminationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeMedicationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeNewScoreFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeNihssFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeOperationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeScoresFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeVitalSignsFragment;
import com.xyj.strokeaid.fragment.stroke.TimeNodeFragment;
import com.xyj.strokeaid.fragment.stroke.TransferFragment;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * PatientGreenChannelActivity
 * description: 患者绿色通道流程页面
 * 1、 展示患者急诊绿色通道的全部检查和时间节点
 *
 * @author : Licy
 * @date : 2020/8/24
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_HOME)
public class PatientStrokeRecordActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_psr)
    BaseTitleBar titleBarActPsr;
    @BindView(R.id.tv_start_time_include_ct)
    Chronometer tvStartTimeIncludeCt;
    @BindView(R.id.tv_hos_time_include_ct)
    Chronometer tvHosTimeIncludeCt;
    @BindView(R.id.rv_menu_act_psr)
    RecyclerView rvMenuActPsr;
    @BindView(R.id.vp_content_act_psr)
    ViewPager2 vpContentActPsr;
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    private PatientMenuRvAdapter mMenuRvAdapter;
    private List<PatientMenuBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_stroke_record;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        // set title
        SpannableString spannableString = new SpannableString("霸波奔（男-58-卒中）");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
        spannableString.setSpan(relativeSizeSpan, 3, spannableString.length() - 1, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleBarActPsr.setTitle(spannableString);

        mMenuTitles = new ArrayList<>();
        for (String greenChannelTabTitle : Constants.GREEN_CHANNEL_STROKE_MENU_TITLES) {
            mMenuTitles.add(new PatientMenuBean(greenChannelTabTitle, false));
        }
        mMenuTitles.get(0).setChecked(true);
        mSelectedTab = 0;
        mMenuRvAdapter = new PatientMenuRvAdapter(R.layout.adapter_green_channel_menu_item, mMenuTitles);

        rvMenuActPsr.setLayoutManager(new LinearLayoutManager(mContext));
        rvMenuActPsr.setAdapter(mMenuRvAdapter);

        vpContentActPsr.setUserInputEnabled(false);
        vpContentActPsr.setAdapter(new GreenChannelVpAdapter(PatientStrokeRecordActivity.this, "", ""));

        tvStartTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvHosTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvStartTimeIncludeCt.start();
        tvHosTimeIncludeCt.start();
    }

    @Override
    public void initListener() {

        titleBarActPsr.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).setOnTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouteUrl.NEW_PATIENT)
                        .withInt(IntentKey.VIEW_TYPE, 2)
                        .withString(IntentKey.PATIENT_ID, mPatientId)
                        .navigation();
            }
        });

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
                vpContentActPsr.setCurrentItem(position, false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private class GreenChannelVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public GreenChannelVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public GreenChannelVpAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public GreenChannelVpAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
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
                    return StrokeVitalSignsFragment.newInstance(patientId, docId);
                case 1:
                    // 病情记录
                    return DiseaseRecordFragment.newInstance(patientId, docId);
                case 2:
                    // NIHSS评分
                    return StrokeNihssFragment.newInstance(patientId, docId);
                case 3:
                    // 启动绿道
                    return StartGreenwayFragment.newInstance(patientId, docId);
                case 4:
                    // 血液检查
                    //  return BloodExamFragment.newInstance(patientId, docId);
                    return StrokeBloodExaminationFragment.newInstance(patientId, docId);
                case 5:
                    // 辅助检查
                    return AuxiliaryExamFragment.newInstance(patientId, docId);
                case 6:
                    // 评分工具
                //    return StrokeScoresFragment.newInstance(patientId, docId);
                    return StrokeNewScoreFragment.newInstance(patientId, docId);
                case 7:
                    // 诊断评估
                    return DiagnosticEvaluationFragment.newInstance(patientId, docId);
                case 8:
                    // 药物治疗
                    return StrokeMedicationFragment.newInstance(patientId, docId);
                case 9:
                    // 手术治疗
                    return StrokeOperationFragment.newInstance(patientId, docId);
                case 10:
                    // 其他处置
                    return OtherDisposalFragment.newInstance(patientId, docId);
                case 11:
                    // 转归交接
                    return TransferFragment.newInstance(patientId, docId);
                case 12:
                    // 时间节点
                    return TimeNodeFragment.newInstance(patientId, docId);
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