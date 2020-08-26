package com.xyj.strokeaid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

/**
 * StrokeMedicationFragment
 * description: 卒中 药物治疗（包含静脉溶栓、住院用药、出院带药）
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeMedicationFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    public StrokeMedicationFragment() {
        // Required empty public constructor
    }

    public static StrokeMedicationFragment newInstance(String patientId, String docId) {
        StrokeMedicationFragment fragment = new StrokeMedicationFragment();
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
        return R.layout.fragment_medication;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}