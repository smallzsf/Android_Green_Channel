package com.xyj.strokeaid.fragment.chestpain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.chestpain.ChestPainOperationInfoActivity;
import com.xyj.strokeaid.activity.chestpain.ChestPainOperationResultActivity;
import com.xyj.strokeaid.activity.chestpain.SurgicalPreparationActivtty;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.BindView;

/**
 * SurgicalTreatmentFragment
 * description: 手术治疗
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
public class SurgicalTreatmentFragment extends BaseFragment implements View.OnClickListener {
    private String mPatientId;
    private String mDocId;

    @BindView(R.id.rl_operation_before)
    RelativeLayout rl_operation_before;
    @BindView(R.id.rl_operation_info)
    RelativeLayout rl_operation_info;
    @BindView(R.id.rl_operation_result)
    RelativeLayout rl_operation_result;


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
        rl_operation_before.setOnClickListener(this);
        rl_operation_info.setOnClickListener(this);
        rl_operation_result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_operation_before:
                //术前准备
                Intent intentOperationBefore = new Intent(getActivity(), SurgicalPreparationActivtty.class);
                startActivity(intentOperationBefore);
                break;
            case R.id.rl_operation_info:
                //手术信
                Intent intentInfo = new Intent(getContext(), ChestPainOperationInfoActivity.class);
                startActivity(intentInfo);
                break;
            case R.id.rl_operation_result:
                //结果信息
                Intent intentResult = new Intent(getContext(), ChestPainOperationResultActivity.class);
                startActivity(intentResult);
                break;
        }
    }
}
