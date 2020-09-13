package com.xyj.strokeaid.fragment.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.score.InterventionalTherapyEvaluationActivity;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;

/**
 * @Description: 介入
 * @Author: crq
 * @CreateDate: 2020/8/29 9:42
 */
public class StrokeGetInvolvedFragment extends BaseStrokeFragment {

    @BindView(R.id.sb_interventional_therapy_evaluation)
    SettingBar sbInterventionalTherapyEvaluation;

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
}
