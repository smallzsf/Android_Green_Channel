package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 心电检查
 */
public class ImageCheckFragment extends BaseFragment {


    @BindView(R.id.rb_ct_scan)
    RadioButton rbCtScan;
    @BindView(R.id.rb_ct_raise)
    RadioButton rbCtRaise;
    @BindView(R.id.rb_three_rebuild)
    RadioButton rbThreeRebuild;
    @BindView(R.id.rb_cta)
    RadioButton rbCta;
    @BindView(R.id.rb_ctp)
    RadioButton rbCtp;
    @BindView(R.id.rb_mri)
    RadioButton rbMri;
    @BindView(R.id.rb_color_ultrasound)
    RadioButton rbColorUltrasound;
    @BindView(R.id.rb_dr)
    RadioButton rbDr;
    @BindView(R.id.rb_dsa)
    RadioButton rbDsa;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.tv_doctor_advice_time)
    TextTimeBar tvDoctorAdviceTime;
    @BindView(R.id.tv_patient_arrive_time)
    TextTimeBar tvPatientArriveTime;
    @BindView(R.id.tv_patient_leave_time)
    TextTimeBar tvPatientLeaveTime;
    @BindView(R.id.tv_check_finish_time)
    TextTimeBar tvCheckFinishTime;
    @BindView(R.id.tv_check_report_time)
    TextTimeBar tvCheckReportTime;
    @BindView(R.id.tv_report)
    TextView tvReport;
    @BindView(R.id.et_report)
    EditText etReport;
    @BindView(R.id.tv_check_image)
    TextView tvCheckImage;
    @BindView(R.id.tv_upload_image)
    TextView tvUploadImage;
    @BindView(R.id.tv_check_report)
    TextView tvCheckReport;
    @BindView(R.id.tv_upload_report)
    TextView tvUploadReport;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;

    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_ct_scan;
    private String mPatientId;
    private String mDocId;

    public ImageCheckFragment() {

    }

    public static ImageCheckFragment newInstance(String patientId, String docId) {
        ImageCheckFragment fragment = new ImageCheckFragment();
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
        return R.layout.fragment_image_check;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取记录");
        btnConfirm.setText("保存");
        String image = "检查CT平扫片子";
        String report = "检查CT平扫报告";
        tvCheckImage.setText(image);
        tvCheckReport.setText(report);

        ventilationModeList.add(rbCtScan);
        ventilationModeList.add(rbCtRaise);
        ventilationModeList.add(rbThreeRebuild);
        ventilationModeList.add(rbCta);
        ventilationModeList.add(rbCtp);
        ventilationModeList.add(rbMri);
        ventilationModeList.add(rbColorUltrasound);
        ventilationModeList.add(rbDr);
        ventilationModeList.add(rbDsa);
        ventilationModeList.add(rbOther);

        for (int i = 0; i < ventilationModeList.size(); i++) {
            RadioButton radioButton = ventilationModeList.get(i);
            radioButton.setOnClickListener(onRadioClickListener);
        }
        refrashRadioStatus();

        loadData();

    }
    View.OnClickListener onRadioClickListener = view -> {
        checkRadioId = view.getId();
        RadioButton radioButton = (RadioButton) view;
        String image = "检查"+radioButton.getText().toString()+"片子";
        String report = "检查"+radioButton.getText().toString()+"报告";
        tvCheckImage.setText(image);
        tvCheckReport.setText(report);
        refrashRadioStatus();
    };
    private void refrashRadioStatus() {
        for (int i = 0; i < ventilationModeList.size(); i++) {
            RadioButton radioButton = ventilationModeList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == checkRadioId) {
                radioButton.setChecked(true);
            }else {
                radioButton.setChecked(false);
            }
        }
    }
    private void loadData() {
    }


    @Override
    protected void initListener() {

    }

    @OnClick({R.id.tv_upload_image, R.id.tv_upload_report, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_upload_image:
                showToast("上传片子");
                break;
            case R.id.tv_upload_report:
                showToast("上传报告");
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
