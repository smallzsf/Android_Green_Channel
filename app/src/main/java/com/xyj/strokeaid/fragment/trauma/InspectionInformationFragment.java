package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import butterknife.OnClick;

public class InspectionInformationFragment extends BaseFragment {
    @BindView(R.id.tv_collection_time)
    TextTimeBar tvCollectionTime;
    @BindView(R.id.tv_arrive_time)
    TextTimeBar tvArriveTime;
    @BindView(R.id.tv_report_time)
    TextTimeBar tvReportTime;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.tv_upload)
    TextView tvUpload;

    private String mPatientId;
    private String mDocId;

    public InspectionInformationFragment() {

    }

    public static InspectionInformationFragment newInstance(String patientId, String docId) {
        InspectionInformationFragment fragment = new InspectionInformationFragment();
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
        return R.layout.fragment_inspection_information;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取记录");
        btnConfirm.setText("保存");
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
