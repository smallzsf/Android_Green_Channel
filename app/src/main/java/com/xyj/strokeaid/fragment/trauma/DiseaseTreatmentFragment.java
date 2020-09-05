package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class DiseaseTreatmentFragment  extends BaseFragment {


    private String mPatientId;
    private String mDocId;
    private List<String> list;

    public DiseaseTreatmentFragment() {

    }

    public static DiseaseTreatmentFragment newInstance(String patientId, String docId) {
        DiseaseTreatmentFragment fragment = new DiseaseTreatmentFragment();
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
        return R.layout.fragment_trauma_disease_treatment;
    }

    @Override
    protected void initView(@NonNull View view) {
//        btnGetData.setText("获取数据");
//        btnConfirm.setText("确定");
        loadData();


    }


    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
//        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {

    }

}