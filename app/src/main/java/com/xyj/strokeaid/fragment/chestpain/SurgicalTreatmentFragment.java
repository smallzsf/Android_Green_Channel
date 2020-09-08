package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.RouterHelper;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * SurgicalTreatmentFragment
 * description: 手术治疗
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
public class SurgicalTreatmentFragment extends BaseFragment {

    @BindView(R.id.sb_operation_before)
    SettingBar sbOperationBefore;
    @BindView(R.id.sb_operation_info)
    SettingBar sbOperationInfo;
    @BindView(R.id.sb_operation_result)
    SettingBar sbOperationResult;

    private String mRecordId;

    private SurgicalTreatmentFragment() {

    }

    public static SurgicalTreatmentFragment newInstance(String recordId) {
        SurgicalTreatmentFragment fragment = new SurgicalTreatmentFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_surgical_treatment;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }


    @OnClick({R.id.sb_operation_before, R.id.sb_operation_info, R.id.sb_operation_result})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_operation_before:
                //术前准备
                RouterHelper.navWithRecordId(RouteUrl.ChestPain.CHEST_PAIN_OPERATION_BEFORE, mRecordId);
                break;
            case R.id.sb_operation_info:
                //手术信
                RouterHelper.navWithRecordId(RouteUrl.ChestPain.CHEST_PAIN_OPERATION_INFO, mRecordId);
                break;
            case R.id.sb_operation_result:
                //结果信息
                RouterHelper.navWithRecordId(RouteUrl.ChestPain.CHEST_PAIN_OPERATION_RESULT, mRecordId);
                break;
            default:
                break;
        }
    }
}
