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
import com.xyj.strokeaid.fragment.stroke.EmptyFragment;
import com.xyj.strokeaid.fragment.trauma.ConsultationInfoFragment;
import com.xyj.strokeaid.fragment.trauma.DiseaseSceneFragment;
import com.xyj.strokeaid.fragment.trauma.DiseaseTreatmentFragment;
import com.xyj.strokeaid.fragment.trauma.ElectrocardiographCheckFragment;
import com.xyj.strokeaid.fragment.trauma.ImageCheckFragment;
import com.xyj.strokeaid.fragment.trauma.InspectionInformationFragment;
import com.xyj.strokeaid.fragment.trauma.OperationInfoFragment;
import com.xyj.strokeaid.fragment.trauma.OutcomeOfPatientsFragment;
import com.xyj.strokeaid.fragment.trauma.TraumaStrokeScoresFragment;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * PatientChestPainRecordActivity
 * description: 创伤患者救治流程页面
 *
 * @author : Licy
 * @date : 2020/9/1
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Trauma.TRAUMA_HOME)
public class TraumaPatientActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_tp)
    BaseTitleBar titleBarActTp;
    @BindView(R.id.tv_start_time_include_ct)
    Chronometer tvStartTimeIncludeCt;
    @BindView(R.id.tv_hos_time_include_ct)
    Chronometer tvHosTimeIncludeCt;
    @BindView(R.id.rv_menu_act_tp)
    RecyclerView rvMenuActTp;
    @BindView(R.id.vp_content_act_tp)
    ViewPager2 vpContentActTp;

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    private PatientMenuRvAdapter mMenuRvAdapter;
    private List<PatientMenuBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_trauma_patient;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        // set title
        SpannableString spannableString = new SpannableString("牛魔王（男-58-创伤）");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
        spannableString.setSpan(relativeSizeSpan, 3, spannableString.length() - 1, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleBarActTp.setTitle(spannableString);

        mMenuTitles = new ArrayList<>();
        for (String greenChannelTabTitle : Constants.GREEN_CHANNEL_TRAUMA_MENU_TITLES) {
            mMenuTitles.add(new PatientMenuBean(greenChannelTabTitle, false));
        }
        mMenuTitles.get(0).setChecked(true);
        mSelectedTab = 0;
        mMenuRvAdapter = new PatientMenuRvAdapter(R.layout.adapter_green_channel_menu_item, mMenuTitles);

        rvMenuActTp.setLayoutManager(new LinearLayoutManager(mContext));
        rvMenuActTp.setAdapter(mMenuRvAdapter);

        vpContentActTp.setUserInputEnabled(false);
        vpContentActTp.setAdapter(new TraumaMenuVpAdapter(TraumaPatientActivity.this, "", ""));

        tvStartTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvHosTimeIncludeCt.setBase(SystemClock.elapsedRealtime());
        tvStartTimeIncludeCt.start();
        tvHosTimeIncludeCt.start();
    }

    @Override
    public void initListener() {
        // 设置标题跳转
        titleBarActTp
                .setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v -> ARouter.getInstance().build(RouteUrl.NEW_PATIENT)
                .withInt(IntentKey.VIEW_TYPE, 2)
                .withString(IntentKey.PATIENT_ID, mPatientId)
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
                vpContentActTp.setCurrentItem(position);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private class TraumaMenuVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public TraumaMenuVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    // 发病现场
                    return DiseaseSceneFragment.newInstance(patientId, docId);
                case 1:
                    // 生命体征
                    return DiseaseTreatmentFragment.newInstance(patientId, docId);
                case 2:
                    //检验信息
                    return InspectionInformationFragment.newInstance(patientId, docId);
                case 3:
                    //心电检查
                    return ElectrocardiographCheckFragment.newInstance(patientId, docId);
                case 4:
                    //影像检查
                    return ImageCheckFragment.newInstance(patientId, docId);
                case 5:
                    //会诊信息
                    return ConsultationInfoFragment.newInstance(patientId, docId);
                case 6:
                    //手术信息
                    return OperationInfoFragment.newInstance(patientId, docId);
                case 7:
                    // 評分工具
                    return TraumaStrokeScoresFragment.newInstance(patientId, docId);
                case 8:
                    //患者转归
                    return OutcomeOfPatientsFragment.newInstance(patientId, docId);

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