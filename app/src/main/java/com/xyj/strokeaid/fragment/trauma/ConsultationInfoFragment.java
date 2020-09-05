package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.OnClick;

/**
 * 会诊信息
 */
public class ConsultationInfoFragment extends BaseFragment {

    private String mPatientId;
    private String mDocId;

    public ConsultationInfoFragment() {

    }

    public static ConsultationInfoFragment newInstance(String patientId, String docId) {
        ConsultationInfoFragment fragment = new ConsultationInfoFragment();
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
        return R.layout.fragment_consultation_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();


    }


    private void loadData() {
    }


    @Override
    protected void initListener() {

    }

    @OnClick({R.id.tv_upload, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_upload:
                showToast("上传");
                break;
            case R.id.btn_get_data:
                showToast("获取记录");
                break;
            case R.id.btn_confirm:
                showToast("保存");
                break;
        }
    }
}
