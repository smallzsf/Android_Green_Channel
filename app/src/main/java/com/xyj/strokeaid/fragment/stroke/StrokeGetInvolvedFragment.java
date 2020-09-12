package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

/**
 * @Description: 介入
 * @Author: crq
 * @CreateDate: 2020/8/29 9:42
 */
public class StrokeGetInvolvedFragment extends BaseStrokeFragment {

    public static StrokeGetInvolvedFragment newInstance(String recordId) {
        StrokeGetInvolvedFragment fragment = new StrokeGetInvolvedFragment();
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
        return R.layout.stroke_fragment_interventional_therapy;
    }

    @Override
    protected void initListener() {

    }
}
