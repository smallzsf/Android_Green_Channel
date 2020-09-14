package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

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
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ChildTreatCenterActivity
 * description: 危重儿童和新生儿救治流程页面
 *
 * @author : Licy
 * @date : 2020/9/1
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.ChildTreat.CHILD_TREAT_HOME)
public class ChildTreatCenterActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_ctc)
    BaseTitleBar titleBarActCtc;
    @BindView(R.id.tv_start_time_include_ct)
    TextView tvStartTimeIncludeCt;
    @BindView(R.id.tv_hos_time_include_ct)
    TextView tvHosTimeIncludeCt;
    @BindView(R.id.rv_menu_act_ctc)
    RecyclerView rvMenuActCtc;
    @BindView(R.id.vp_content_act_ctc)
    ViewPager2 vpContentActCtc;

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    private PatientMenuRvAdapter mMenuRvAdapter;
    private List<PatientMenuBean> mMenuTitles;
    private int mSelectedTab = -1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_child_treat_center;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        // set title
        SpannableString spannableString = new SpannableString("红孩儿（男-6-儿童）");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
        spannableString.setSpan(relativeSizeSpan, 3, spannableString.length() - 1, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleBarActCtc.setTitle(spannableString);

        mMenuTitles = new ArrayList<>();
        for (String greenChannelTabTitle : Constants.GREEN_CHANNEL_CHILD_MENU_TITLES) {
            mMenuTitles.add(new PatientMenuBean(greenChannelTabTitle, false));
        }
        mMenuTitles.get(0).setChecked(true);
        mSelectedTab = 0;
        mMenuRvAdapter = new PatientMenuRvAdapter(R.layout.adapter_green_channel_menu_item, mMenuTitles);

        rvMenuActCtc.setLayoutManager(new LinearLayoutManager(mContext));
        rvMenuActCtc.setAdapter(mMenuRvAdapter);

        vpContentActCtc.setUserInputEnabled(false);
        vpContentActCtc.setAdapter(new ChildMenuVpAdapter(ChildTreatCenterActivity.this, "", ""));

    }

    @Override
    public void initListener() {
        // 设置标题跳转
        titleBarActCtc.setLeftLayoutClickListener(v -> finish());

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
                vpContentActCtc.setCurrentItem(position,false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private class ChildMenuVpAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public ChildMenuVpAdapter(@NonNull FragmentActivity fragmentActivity, String patientId, String docId) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
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