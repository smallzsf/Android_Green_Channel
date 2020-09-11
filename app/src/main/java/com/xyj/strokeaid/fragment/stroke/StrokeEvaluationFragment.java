package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import butterknife.BindView;

/**
 * NihssFragment
 * description: 卒中评估
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
public class StrokeEvaluationFragment extends BaseStrokeFragment {

    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    public static StrokeEvaluationFragment newInstance(String recordId) {
        StrokeEvaluationFragment fragment = new StrokeEvaluationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_evaluation;
    }

    @Override
    protected void initListener() {

    }

}