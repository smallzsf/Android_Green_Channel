package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

/**
 * @Description: 动脉瘤
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokArterialAneurysmFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    public StrokArterialAneurysmFragment() {
        // Required empty public constructor
    }

    public static StrokArterialAneurysmFragment newInstance(String patientId, String docId) {
        StrokArterialAneurysmFragment fragment = new StrokArterialAneurysmFragment();
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
        return R.layout.fragment_arterial_aneurysm;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
