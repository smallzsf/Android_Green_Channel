package com.xyj.strokeaid.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.BindView;

/**
 * DiagnosticEvaluationFragment
 * description: 诊断评估
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class DiagnosticEvaluationFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_diagnostic_evaluation)
    SegmentTabLayout stlTitleFragDiagnosticEvaluation;
    private String mPatientId;
    private String mDocId;
    public static final String[] STROKE_DIAGNOSTIC_EVALUATIONva_TITLES = new String[]{"入院诊断", "出院诊断"};

    /**
     * 0 == 入院诊断
     * 1 == 出院诊断
     */

    public DiagnosticEvaluationFragment() {
        // Required empty public constructor
    }

    public static DiagnosticEvaluationFragment newInstance(String patientId, String docId) {
        DiagnosticEvaluationFragment fragment = new DiagnosticEvaluationFragment();
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
        return R.layout.fragment_diagnostic_evaluation;
    }

    @Override
    protected void initView(@NonNull View view) {
        stlTitleFragDiagnosticEvaluation.setTabData(STROKE_DIAGNOSTIC_EVALUATIONva_TITLES);
    }


    @Override
    protected void initListener() {
        stlTitleFragDiagnosticEvaluation.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 1) {
                    //入院诊断

                } else {
                    //出院诊断

                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

}