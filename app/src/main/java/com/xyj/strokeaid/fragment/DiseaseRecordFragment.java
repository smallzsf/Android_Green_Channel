package com.xyj.strokeaid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Set;

import butterknife.BindView;

/**
 * DiseaseRecordFragment
 * description: 病情记录
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class DiseaseRecordFragment extends BaseFragment {

    @BindView(R.id.id_flow_layout)
    TagFlowLayout flowLayout;
    @BindView(R.id.id_flow_layout2)
    TagFlowLayout flowLayout2;

    private String mPatientId;
    private String mDocId;

    public DiseaseRecordFragment() {
        // Required empty public constructor
    }

    public static DiseaseRecordFragment newInstance(String patientId, String docId) {
        DiseaseRecordFragment fragment = new DiseaseRecordFragment();
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
    public int getLayoutId() {
        return R.layout.fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {
    }


    @Override
    public void initListener() {


    }
}