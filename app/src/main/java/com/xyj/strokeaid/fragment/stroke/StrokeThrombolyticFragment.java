package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

/**
 * 治疗  --  溶栓
 *
 * @author Licy
 */
public class StrokeThrombolyticFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    private StrokeThrombolyticFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param patientId 患者ID
     * @param docId     医生id
     * @return A new instance of fragment StrokeAngioplastyFragment.
     */
    public static StrokeThrombolyticFragment newInstance(String patientId, String docId) {
        StrokeThrombolyticFragment fragment = new StrokeThrombolyticFragment();
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
    protected void initView(@NonNull View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_thrombolysis;
    }

    @Override
    protected void initListener() {

    }
}