package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextSwitchBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * OtherDisposalFragment
 * description: 其他处置
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class OtherDisposalFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_od)
    SegmentTabLayout stlTitleFragOd;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.tsb_accept_recovery_frag_od)
    TextSwitchBar tsbAcceptRecoveryFragOd;
    @BindView(R.id.cb_tradition_frag_od)
    CheckBox cbTraditionFragOd;
    @BindView(R.id.cb_pt_frag_od)
    CheckBox cbPtFragOd;
    @BindView(R.id.cb_ot_frag_od)
    CheckBox cbOtFragOd;
    @BindView(R.id.cb_st_frag_od)
    CheckBox cbStFragOd;
    @BindView(R.id.cb_other_recovery_frag_od)
    CheckBox cbOtherRecoveryFragOd;
    @BindView(R.id.cb_bedside_frag_od)
    CheckBox cbBedsideFragOd;
    @BindView(R.id.cb_recovery_depart_frag_od)
    CheckBox cbRecoveryDepartFragOd;
    @BindView(R.id.ll_recovery_type_frag_od)
    LinearLayout llRecoveryTypeFragOd;
    @BindView(R.id.ll_recovery_frag_od)
    LinearLayout llRecoveryFragOd;
    @BindView(R.id.tsb_edu_frag_od)
    TextSwitchBar tsbEduFragOd;
    @BindView(R.id.cb_group_frag_od)
    CheckBox cbGroupFragOd;
    @BindView(R.id.cb_one_frag_od)
    CheckBox cbOneFragOd;
    @BindView(R.id.cb_other_edu_frag_od)
    CheckBox cbOtherEduFragOd;
    @BindView(R.id.ll_edu_type_frag_od)
    LinearLayout llEduTypeFragOd;
    @BindView(R.id.ll_edu_frag_od)
    LinearLayout llEduFragOd;

    /**
     * 0 == 康复治疗
     * 1 == 健康教育
     */
    private int mPageType = 0;


    public static OtherDisposalFragment newInstance(String recordId) {
        OtherDisposalFragment fragment = new OtherDisposalFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_other_disposal;
    }

    @Override
    protected void initView(@NonNull View view) {
        stlTitleFragOd.setTabData(Constants.STROKE_OTHER_DISPOSAL_TITLES);
    }

    @Override
    protected void initListener() {
        stlTitleFragOd.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 1) {
                    // 健康教育
                    llRecoveryFragOd.setVisibility(View.GONE);
                    llEduFragOd.setVisibility(View.VISIBLE);
                } else {
                    // 康复治疗
                    llRecoveryFragOd.setVisibility(View.VISIBLE);
                    llEduFragOd.setVisibility(View.GONE);
                }
                mPageType = position;
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        tsbAcceptRecoveryFragOd.setSwitchClickListener(
                (buttonView, isChecked) -> llRecoveryTypeFragOd.setVisibility(isChecked ? View.VISIBLE : View.GONE));

        tsbEduFragOd.setSwitchClickListener(
                (buttonView, isChecked) -> llEduTypeFragOd.setVisibility(isChecked ? View.VISIBLE : View.GONE));
    }

    @OnClick({R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
            default:
                break;
        }
    }


}