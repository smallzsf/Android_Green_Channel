package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 药物治疗
 * @author ck
 */
public class StrokeThrombolysisFragment extends BaseStrokeFragment {

    @BindView(R.id.view_stb_assessment)
    SettingBar stbAssessment; // 静脉溶栓评估
    @BindView(R.id.view_stb_treatment)
    SettingBar stbTreatment; // 静脉溶栓治疗

    private String mRecordId;

    public static StrokeThrombolysisFragment newInstance(String recordId) {
        StrokeThrombolysisFragment fragment = new StrokeThrombolysisFragment();
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
    protected void initView(@NonNull View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_thrombolysis;
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.view_stb_assessment, R.id.view_stb_treatment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_stb_assessment: // 静脉溶栓评估
                ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THROMBOLYSIS_ASSESSMENT)
                        .withString(IntentKey.RECORD_ID, mRecordId)
                        .navigation();
                break;
            case R.id.view_stb_treatment: // 静脉溶栓治疗
                ARouter.getInstance().build(RouteUrl.Stroke.STROKE_THROMBOLYSIS_TREATMENT)
                        .withString(IntentKey.RECORD_ID, mRecordId)
                        .navigation();
                break;
            default:
                break;
        }
    }
}