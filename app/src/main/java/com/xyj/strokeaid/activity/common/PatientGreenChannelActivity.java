package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.view.View;
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

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.GreenChannelMenuRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.GreenChannelTabBean;
import com.xyj.strokeaid.fragment.BloodExamFragment;
import com.xyj.strokeaid.fragment.DiagnosticEvaluationFragment;
import com.xyj.strokeaid.fragment.DiseaseRecordFragment;
import com.xyj.strokeaid.fragment.EmptyFragment;
import com.xyj.strokeaid.fragment.ImageExamFragment;
import com.xyj.strokeaid.fragment.OtherDisposalFragment;
import com.xyj.strokeaid.fragment.StartGreenwayFragment;
import com.xyj.strokeaid.fragment.StrokeMedicationFragment;
import com.xyj.strokeaid.fragment.StrokeNihssFragment;
import com.xyj.strokeaid.fragment.StrokeOperationFragment;
import com.xyj.strokeaid.fragment.StrokeScoresFragment;
import com.xyj.strokeaid.fragment.TimeNodeFragment;
import com.xyj.strokeaid.fragment.TransferFragment;
import com.xyj.strokeaid.fragment.VitalSignsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * PatientGreenChannelActivity
 * description: 患者绿色通道流程页面
 * 1、 展示患者急诊绿色通道的全部检查和时间节点
 *
 * @author : Licy
 * @date : 2020/8/24
 * email ：licy3051@qq.com
 */
public class PatientGreenChannelActivity extends BaseActivity {


    @BindView(R.id.iv_back_act_pgc)
    ImageView ivBackActPgc;
    @BindView(R.id.tv_title_act_pgc)
    TextView tvTitleActPgc;
    @BindView(R.id.tv_subtitle_act_pgc)
    TextView tvSubtitleActPgc;
    @BindView(R.id.tv_menu_act_pgc)
    TextView tvMenuActPgc;
    @BindView(R.id.tv_start_dis_time_act_pgc)
    TextView tvStartDisTimeActPgc;
    @BindView(R.id.tv_in_hos_time_act_pgc)
    TextView tvInHosTimeActPgc;
    @BindView(R.id.rv_menu_act_pgc)
    RecyclerView rvMenuActPgc;
    @BindView(R.id.vp_content_act_pgc)
    ViewPager2 vpContentActPgc;

    private GreenChannelMenuRvAdapter mMenuRvAdapter;
    private List<GreenChannelTabBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_green_channel;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mMenuTitles = new ArrayList<>();
        for (String greenChannelTabTitle : Constants.GREEN_CHANNEL_STROKE_MENU_TITLES) {
            mMenuTitles.add(new GreenChannelTabBean(greenChannelTabTitle, false));
        }
        mMenuRvAdapter = new GreenChannelMenuRvAdapter(R.layout.adapter_green_channel_menu_item, mMenuTitles);

        rvMenuActPgc.setLayoutManager(new LinearLayoutManager(mContext));
        rvMenuActPgc.setAdapter(mMenuRvAdapter);

        vpContentActPgc.setUserInputEnabled(false);
        vpContentActPgc.setOffscreenPageLimit(1);
        vpContentActPgc.setAdapter(new GreenChannelVpAdapter(PatientGreenChannelActivity.this, "", ""));
    }

    @Override
    public void initListener() {
        mMenuRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mSelectedTab == position) {
                    // 选中相同的
                    mMenuTitles.get(position).setChecked(!mMenuTitles.get(position).isChecked());
                    mMenuRvAdapter.notifyItemChanged(position);
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
                vpContentActPgc.setCurrentItem(position);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.iv_back_act_pgc, R.id.tv_title_act_pgc, R.id.tv_subtitle_act_pgc, R.id.tv_menu_act_pgc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_act_pgc:
                finish();
                break;
            case R.id.tv_title_act_pgc:
            case R.id.tv_subtitle_act_pgc:
                // TODO: 2020/8/25 跳转用户信息页面
                break;
            case R.id.tv_menu_act_pgc:
                // TODO: 2020/8/25 待定
                break;
            default:
                break;
        }
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
                    return VitalSignsFragment.newInstance(patientId, docId);
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
                    return BloodExamFragment.newInstance(patientId, docId);
                case 5:
                    // 辅助检查
                    return ImageExamFragment.newInstance(patientId, docId);
                case 6:
                    // 评分工具
                    return StrokeScoresFragment.newInstance(patientId, docId);
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