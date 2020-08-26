package com.xyj.strokeaid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.View;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

/**
 * ScoreToolsFragment
 * description: 评分工具
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainToolsFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    public ChestPainToolsFragment() {
        // Required empty public constructor
    }

    public static ChestPainToolsFragment newInstance(String patientId, String docId) {
        ChestPainToolsFragment fragment = new ChestPainToolsFragment();
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
        return R.layout.fragment_chest_pain_score_tools;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}