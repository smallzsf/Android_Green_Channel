package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.score.InterventionalTherapyEvaluationActivity;
import com.xyj.strokeaid.activity.stroke.GetInvolvedInformedConsentActivity;
import com.xyj.strokeaid.activity.stroke.StrokeOperationAfterActivity;
import com.xyj.strokeaid.activity.stroke.StrokeOperationBeforeActivity;
import com.xyj.strokeaid.activity.stroke.StrokeOperationOnActivity;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Description: 介入
 * @Author: crq
 * @CreateDate: 2020/8/29 9:42
 */
public class StrokeGetInvolvedFragment extends BaseStrokeFragment {

    @BindView(R.id.sb_interventional_therapy_evaluation)
    SettingBar sbInterventionalTherapyEvaluation;

    @BindView(R.id.sb_jrzt_jrzqty)
    SettingBar sbJrztJrzqty;
    @BindView(R.id.sb_jrzt_sqzbxx)
    SettingBar sbJrztSqzbxx;
    @BindView(R.id.sb_jrzt_szzlxx)
    SettingBar sbJrztSzzlxx;
    @BindView(R.id.sb_jrzt_shjgxx)
    SettingBar sbJrztShjgxx;

    public static StrokeGetInvolvedFragment newInstance(String recordId) {
        StrokeGetInvolvedFragment fragment = new StrokeGetInvolvedFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.sb_interventional_therapy_evaluation){
                startActivity(new Intent(context, InterventionalTherapyEvaluationActivity.class));
                return;
            }
        }
    };

    @Override
    protected void initView(@NonNull View view) {
        sbInterventionalTherapyEvaluation.setOnClickListener(onClickListener);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_interventional_therapy;
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.sb_jrzt_jrzlpg, R.id.sb_jrzt_jrzqty, R.id.sb_jrzt_sqzbxx, R.id.sb_jrzt_szzlxx, R.id.sb_jrzt_shjgxx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_jrzt_jrzlpg:
                // 介入治疗评估
//                startActivity(new Intent(mActivity, GetInvolvedInformedConsentActivity.class));
                break;
            case R.id.sb_jrzt_jrzqty:
                // 介入知情同意
                startActivity(new Intent(mActivity, GetInvolvedInformedConsentActivity.class));
                break;
            case R.id.sb_jrzt_sqzbxx:
                // 介入术前信息
                startActivity(new Intent(mActivity, StrokeOperationBeforeActivity.class));
                break;
            case R.id.sb_jrzt_szzlxx:
                // 介入手术术中治疗信息
                startActivity(new Intent(mActivity, StrokeOperationOnActivity.class));
                break;
            case R.id.sb_jrzt_shjgxx:
                // 介入手术结果信息
                startActivity(new Intent(mActivity, StrokeOperationAfterActivity.class));
                break;
            default:
                break;
        }
    }
}
