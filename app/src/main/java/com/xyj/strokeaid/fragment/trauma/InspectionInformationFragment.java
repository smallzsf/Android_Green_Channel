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
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class InspectionInformationFragment extends BaseFragment {
    @BindView(R.id.tv_collection_time)
    TextTimeBar tvCollectionTime;
    @BindView(R.id.tv_arrive_time)
    TextTimeBar tvArriveTime;
    @BindView(R.id.et_blood_type)
    EditText etBloodType;
    @BindView(R.id.et_blood_suger)
    EditText etBloodSuger;
    @BindView(R.id.tv_emergency_ward)
    TextView tvEmergencyWard;
    @BindView(R.id.tv_upload)
    TextView tvUpload;
    @BindView(R.id.tv_time_1)
    TextView tvTime1;
    @BindView(R.id.tv_check_1)
    TextView tvCheck1;
    @BindView(R.id.tv_delete_1)
    TextView tvDelete1;
    @BindView(R.id.ll_sheet_1)
    LinearLayout llSheet1;
    @BindView(R.id.tv_time_2)
    TextView tvTime2;
    @BindView(R.id.tv_check_2)
    TextView tvCheck2;
    @BindView(R.id.tv_delete_2)
    TextView tvDelete2;
    @BindView(R.id.ll_sheet_2)
    LinearLayout llSheet2;
    @BindView(R.id.tv_time_3)
    TextView tvTime3;
    @BindView(R.id.tv_check_3)
    TextView tvCheck3;
    @BindView(R.id.tv_delete_3)
    TextView tvDelete3;
    @BindView(R.id.ll_sheet_3)
    LinearLayout llSheet3;
    @BindView(R.id.tv_time_4)
    TextView tvTime4;
    @BindView(R.id.tv_check_4)
    TextView tvCheck4;
    @BindView(R.id.tv_delete_4)
    TextView tvDelete4;
    @BindView(R.id.ll_sheet_4)
    LinearLayout llSheet4;
    @BindView(R.id.rb_chest)
    RadioButton rbChest;
    @BindView(R.id.rb_belly)
    RadioButton rbBelly;
    @BindView(R.id.et_blood)
    EditText etBlood;
    @BindView(R.id.tv_blood)
    TextView tvBlood;
    @BindView(R.id.rb_solidify_yes)
    RadioButton rbSolidifyYes;
    @BindView(R.id.rb_solidify_no)
    RadioButton rbSolidifyNo;
    @BindView(R.id.rb_gas_yes)
    RadioButton rbGasYes;
    @BindView(R.id.rb_gas_no)
    RadioButton rbGasNo;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;


    private String mPatientId;
    private String mDocId;
    private String[] reportTypes = {"传染病9项", "凝血四项", "血常规", "血生化"};
    private Map<Integer, String> uploadList = new HashMap<>();
    private LinearLayout[] linearLayouts;
    private TextView[] tvTimes;

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
        linearLayouts = new LinearLayout[]{llSheet1, llSheet2, llSheet3, llSheet4};
        tvTimes = new TextView[]{tvTime1, tvTime2, tvTime3, tvTime4};
        loadData();


    }


    private void loadData() {
    }


    @Override
    protected void initListener() {

    }


    private void showActionSheet() {
        ActionSheet.createBuilder(context, getFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles(reportTypes)
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        refreshReport(index);
                    }
                }).show();
    }

    private void refreshReport(int index) {
        linearLayouts[index].setVisibility(View.VISIBLE);
        tvTimes[index].setText(CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, new Date()));
    }


    @OnClick({R.id.tv_upload, R.id.tv_check_1, R.id.tv_delete_1, R.id.tv_check_2, R.id.tv_delete_2, R.id.tv_check_3, R.id.tv_delete_3, R.id.tv_check_4, R.id.tv_delete_4, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_upload:
                showActionSheet();
                break;
            case R.id.tv_check_1:
                showToast("查看传染病9项");
                break;
            case R.id.tv_check_2:
                showToast("查看凝血四项");
                break;
            case R.id.tv_check_3:
                showToast("查看血常规");
                break;
            case R.id.tv_check_4:
                showToast("查看血生化");
                break;
            case R.id.tv_delete_1:
                llSheet1.setVisibility(View.GONE);
                break;
            case R.id.tv_delete_2:
                llSheet2.setVisibility(View.GONE);
                break;
            case R.id.tv_delete_3:
                llSheet3.setVisibility(View.GONE);
                break;
            case R.id.tv_delete_4:
                llSheet4.setVisibility(View.GONE);
                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
        }
    }
}
