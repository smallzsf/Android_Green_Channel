package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.PatientMenuRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.MainListBean;
import com.xyj.strokeaid.bean.PatientMenuBean;
import com.xyj.strokeaid.fragment.common.TimeNodeFragment;
import com.xyj.strokeaid.fragment.common.TriageInfoFragment;
import com.xyj.strokeaid.fragment.common.VitalSignsFragment;
import com.xyj.strokeaid.fragment.stroke.AuxiliaryExamFragment;
import com.xyj.strokeaid.fragment.stroke.DiagnosticEvaluationFragment;
import com.xyj.strokeaid.fragment.stroke.DiseaseRecordFragment;
import com.xyj.strokeaid.fragment.stroke.EmptyFragment;
import com.xyj.strokeaid.fragment.stroke.OtherDisposalFragment;
import com.xyj.strokeaid.fragment.stroke.StartGreenwayFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodExaminationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeEvaluationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeMedicationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeOperationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeTransferFragment;
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
public class PatientStrokeRecordActivity extends BaseCommonActivity {

    @BindView(R.id.title_bar_act_psr)
    BaseTitleBar titleBarActPsr;
    @BindView(R.id.tv_start_time_include_ct)
    TextView tvStartTimeIncludeCt;
    @BindView(R.id.tv_hos_time_include_ct)
    TextView tvHosTimeIncludeCt;
    @BindView(R.id.rv_menu_act_psr)
    RecyclerView rvMenuActPsr;
    @BindView(R.id.vp_content_act_psr)
    ViewPager2 vpContentActPsr;

    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;
    @Autowired(name = IntentKey.PATIENT_INFO)
    MainListBean mPatientInfo;

    private PatientMenuRvAdapter mMenuRvAdapter;
    private List<PatientMenuBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
        if (mPatientInfo != null) {
            String fullname = mPatientInfo.getFullname();
            String age = mPatientInfo.getAge();
            String gender = TextUtils.equals(mPatientInfo.getGender(), "1") ? "男" : "女";
            if (fullname.length() > 5) {
                fullname = fullname.substring(0, 5);
            }
            SpannableString spannableString = new SpannableString(fullname + "(" + gender + "-" + age + "-胸痛)");
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
            spannableString.setSpan(relativeSizeSpan, fullname.length(), spannableString.length() - 1, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            titleBarActPsr.setTitle(spannableString);
        } else {
            titleBarActPsr.setTitle("胸痛患者");
        }

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
        vpContentActPsr.setAdapter(new GreenChannelVpAdapter(PatientStrokeRecordActivity.this, mRecordId));

        myTask = createTask(tvStartTimeIncludeCt, tvHosTimeIncludeCt, mPatientInfo);
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
                        .withInt(IntentKey.DISEASE_VIEW_TYPE, 1)
                        .withString(IntentKey.RECORD_ID, mRecordId)
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

    private class GreenChannelVpAdapter extends FragmentStateAdapter {

        String recordId;

        public GreenChannelVpAdapter(@NonNull FragmentActivity fragmentActivity, String recordId) {
            super(fragmentActivity);
            this.recordId = recordId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            LogUtils.d(" + " + position);
            switch (position) {
                case 0:
                    // 分诊信息
                    return TriageInfoFragment.newInstance(recordId, 1);
                case 1:
                    // 生命体征
                    return VitalSignsFragment.newInstance(recordId, 1);
                case 2:
                    // 病情记录
                    return DiseaseRecordFragment.newInstance(recordId);
                case 3:
                    // 卒中评估
                    return StrokeEvaluationFragment.newInstance(recordId);
                case 4:
                    // 启动绿道
                    return StartGreenwayFragment.newInstance(recordId);
                case 5:
                    // 血液检查
                    return StrokeBloodExaminationFragment.newInstance(recordId);
                case 6:
                    // 辅助检查
                    return AuxiliaryExamFragment.newInstance(recordId);
                case 7:
                    // 诊断评估
                    return DiagnosticEvaluationFragment.newInstance(recordId);
                case 8:
                    // 药物治疗
                    return StrokeMedicationFragment.newInstance(recordId);
                case 9:
                    // 手术治疗
                    return StrokeOperationFragment.newInstance(recordId);
                case 10:
                    // 其他处置
                    return OtherDisposalFragment.newInstance(recordId);
                case 11:
                    // 转归交接
                    return StrokeTransferFragment.newInstance(recordId);
                case 12:
                    // 时间节点
                    return TimeNodeFragment.newInstance(recordId, 1);
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