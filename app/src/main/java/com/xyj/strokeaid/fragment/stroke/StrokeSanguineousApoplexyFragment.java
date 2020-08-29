package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.StrokeOperationFragment;

/**
 * @Description: 脑出血
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokeSanguineousApoplexyFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    public StrokeSanguineousApoplexyFragment() {
        // Required empty public constructor
    }

    public static StrokeSanguineousApoplexyFragment newInstance(String patientId, String docId) {
        StrokeSanguineousApoplexyFragment fragment = new StrokeSanguineousApoplexyFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sanguineous_apoplexy;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
