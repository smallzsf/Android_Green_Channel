package com.xyj.strokeaid.fragment.common;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;

/**
 * TriageInfoFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/5
 * email ：licy3051@qq.com
 */
public class TriageInfoFragment extends BaseFragment {

    @BindView(R.id.ttb_patient_arrival_frag_ti)
    TextTimeBar ttbPatientArrivalFragTi;
    @BindView(R.id.ttb_patient_emergency_frag_ti)
    TextTimeBar ttbPatientEmergencyFragTi;
    @BindView(R.id.ttb_emergency_triage_frag_ti)
    TextTimeBar ttbEmergencyTriageFragTi;
    @BindView(R.id.es_emergency_nurse_frag_ti)
    EditSpinner esEmergencyNurseFragTi;
    @BindView(R.id.es_emergency_addr_frag_ti)
    EditSpinner esEmergencyAddrFragTi;
    @BindView(R.id.ttb_emergency_doc_time_frag_ti)
    TextTimeBar ttbEmergencyDocTimeFragTi;
    @BindView(R.id.es_emergency_doc_frag_ti)
    EditSpinner esEmergencyDocFragTi;
    @BindView(R.id.ttb_stroke_doc_time_frag_ti)
    TextTimeBar ttbStrokeDocTimeFragTi;
    @BindView(R.id.es_stroke_doc_frag_ti)
    EditSpinner esStrokeDocFragTi;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.stroke_fragment_triage)
    LinearLayout strokeFragmentTriage;
    @BindView(R.id.ll_stroke_doc_frag_ti)
    LinearLayout llStrokeDocFragTi;

    private String mRecordId;
    private int mDiseaseViewType;

    public TriageInfoFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recordId        记录ID
     * @param diseaseViewType 疾病类型
     * @return A new instance of fragment StrokeGetInvolvedFragment.
     */
    public static TriageInfoFragment newInstance(String recordId, int diseaseViewType) {
        TriageInfoFragment fragment = new TriageInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        args.putInt(IntentKey.DISEASE_VIEW_TYPE, diseaseViewType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
            mDiseaseViewType = getArguments().getInt(IntentKey.DISEASE_VIEW_TYPE, 1);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_triage_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        if (mDiseaseViewType == 2) {
            // 胸痛不显示卒中医生信息
            llStrokeDocFragTi.setVisibility(View.GONE);
            ttbStrokeDocTimeFragTi.setVisibility(View.GONE);
        } else {
            llStrokeDocFragTi.setVisibility(View.VISIBLE);
            ttbStrokeDocTimeFragTi.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initListener() {
        btnSave.setOnClickListener(v -> {
            if (mDiseaseViewType == 2) {
                saveDataToChestPain();
            } else {
                saveDataToStroke();
            }
        });
    }

    private void setView() {
        // 患者到院
        ttbPatientArrivalFragTi.setTime("");
        // 患者到达急诊
        ttbPatientEmergencyFragTi.setTime("");
        // 急诊分诊
        ttbEmergencyTriageFragTi.setTime("");
        // 分诊护士
        esEmergencyNurseFragTi.setText("");
        // 接诊地点
        esEmergencyAddrFragTi.setText("");
        // 急诊医生接诊
        ttbEmergencyDocTimeFragTi.setTime("");
        // 急诊医生
        esEmergencyDocFragTi.setText("");
        if (mDiseaseViewType == 1){
            // 卒中医生接诊
            ttbStrokeDocTimeFragTi.setTime("");
            // 卒中医生
            esStrokeDocFragTi.setText("");
        }

    }

    private void getDataBeforeSave() {

    }

    private void getDataToChestPain() {

    }

    private void getDatatoStroke() {

    }

    private void saveDataToStroke() {
    }

    private void saveDataToChestPain() {

    }


}

    
    
       
    