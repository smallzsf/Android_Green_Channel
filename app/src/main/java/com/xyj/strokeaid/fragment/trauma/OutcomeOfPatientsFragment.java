package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 患者转归
 */
public class OutcomeOfPatientsFragment extends BaseFragment {


    @BindView(R.id.rb_leave_hospital)
    RadioButton rbLeaveHospital;
    @BindView(R.id.rb_transform_hospital)
    RadioButton rbTransformHospital;
    @BindView(R.id.rb_transform_department)
    RadioButton rbTransformDepartment;
    @BindView(R.id.rb_die)
    RadioButton rbDie;
    @BindView(R.id.et_hospitalization_day)
    EditText etHospitalizationDay;
    @BindView(R.id.et_ICU_day)
    EditText etICUDay;
    @BindView(R.id.et_respirator_timer)
    EditText etRespiratorTimer;
    @BindView(R.id.et_totalcost)
    EditText etTotalcost;
    @BindView(R.id.ttb_leave_hospital)
    TextTimeBar ttbLeaveHospital;
    @BindView(R.id.rb_result_ok)
    RadioButton rbResultOk;
    @BindView(R.id.rb_result_better)
    RadioButton rbResultBetter;
    @BindView(R.id.rb_leave_self)
    RadioButton rbLeaveSelf;
    @BindView(R.id.rb_result_other)
    RadioButton rbResultOther;
    @BindView(R.id.ll_leavehospital)
    LinearLayout llLeavehospital;
    @BindView(R.id.ttb_leave_hospital_door)
    TextTimeBar ttbLeaveHospitalDoor;
    @BindView(R.id.et_hospitalization_name)
    EditText etHospitalizationName;
    @BindView(R.id.rb_nethospital_true)
    RadioButton rbNethospitalTrue;
    @BindView(R.id.rb_nethospital_flase)
    RadioButton rbNethospitalFlase;
    @BindView(R.id.ll_transferhospital)
    LinearLayout llTransferhospital;
    @BindView(R.id.ttb_transfer_department)
    TextTimeBar ttbTransferDepartment;
    @BindView(R.id.et_reception_department)
    EditText etReceptionDepartment;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.ll_transferdepartment)
    LinearLayout llTransferdepartment;
    @BindView(R.id.et_die_location)
    EditText etDieLocation;
    @BindView(R.id.ttb_die_date)
    TextTimeBar ttbDieDate;
    @BindView(R.id.et_die_reason)
    EditText etDieReason;
    @BindView(R.id.ll_die)
    LinearLayout llDie;
    @BindView(R.id.rg_is_net)
    RadioGroup rgIsNet;
    private String mPatientId;
    private String mDocId;


    private List<RadioButton> outcomeList = new ArrayList();
    private int checkRadioId = R.id.rb_die;
    /**
     * 治疗结果
     */
    private List<RadioButton> resutList = new ArrayList();
    private int resutcheckRadioId = R.id.rb_result_ok;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();


    public OutcomeOfPatientsFragment() {

    }

    public static OutcomeOfPatientsFragment newInstance(String patientId, String docId) {
        OutcomeOfPatientsFragment fragment = new OutcomeOfPatientsFragment();
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
        return R.layout.fragment_trauma_outcomeofpatients;
    }

    @Override
    protected void initView(@NonNull View view) {
        outcomeList.add(rbLeaveHospital);
        outcomeList.add(rbTransformHospital);
        outcomeList.add(rbTransformDepartment);
        outcomeList.add(rbDie);
        for (int i = 0; i < outcomeList.size(); i++) {
            RadioButton radioButton = outcomeList.get(i);
            radioButton.setOnClickListener(onRadioClickListener);
        }
        resutList.add(rbResultOk);
        resutList.add(rbResultBetter);
        resutList.add(rbLeaveSelf);
        resutList.add(rbResultOther);
        for (int i = 0; i < resutList.size(); i++) {
            RadioButton radioButton = resutList.get(i);
            radioButton.setOnClickListener(resultClickListener);
        }
        rgIsNet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });

        loadData();


    }

    View.OnClickListener onRadioClickListener = view -> {
        checkRadioId = view.getId();
        refrashRadioStatus();
    };
    View.OnClickListener resultClickListener = view -> {
        resutcheckRadioId = view.getId();
        refrashresultStatus();
    };

    private void refrashresultStatus() {
        for (int i = 0; i < resutList.size(); i++) {
            RadioButton radioButton = resutList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == resutcheckRadioId) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    /**
     * 主页面回复状态
     */
    private void refrashRadioStatus() {
        for (int i = 0; i < outcomeList.size(); i++) {
            RadioButton radioButton = outcomeList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == checkRadioId) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        llDie.setVisibility(View.GONE);
        llLeavehospital.setVisibility(View.GONE);
        llTransferdepartment.setVisibility(View.GONE);
        llTransferhospital.setVisibility(View.GONE);
        switch (checkRadioId) {
            case R.id.rb_leave_hospital:
                llLeavehospital.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_transform_hospital:
                llTransferhospital.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_transform_department:
                llTransferdepartment.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_die:
                llDie.setVisibility(View.VISIBLE);
                break;
        }

    }

    private void loadData() {
//        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {

    }

    @OnClick({R.id.rb_leave_hospital, R.id.rb_transform_hospital, R.id.rb_transform_department, R.id.rb_die})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_leave_hospital:
                break;
            case R.id.rb_transform_hospital:
                break;
            case R.id.rb_transform_department:
                break;
            case R.id.rb_die:
                break;
        }
    }
}