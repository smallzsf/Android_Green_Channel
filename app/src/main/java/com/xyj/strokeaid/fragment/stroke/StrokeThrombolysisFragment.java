package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

/**
 * 治疗  --  静脉溶栓
 * @author Licy
 */
public class StrokeThrombolysisFragment extends BaseStrokeFragment {

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
        return R.layout.stroke_fragment_thrombolysis;
    }

    @Override
    protected void initListener() {

    }
}