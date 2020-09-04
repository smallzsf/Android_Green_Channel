package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  心内会诊
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainIntraConsultFragment extends BaseFragment {


    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_auxiliary_exam)
    LinearLayout llAuxiliaryExam;
    @BindView(R.id.rb_on_site_consultation)
    RadioButton rbOnSiteConsultation;
    @BindView(R.id.rb_remote_consultation)
    RadioButton rbRemoteConsultation;
    @BindView(R.id.ttb_arrival_time)
    TextTimeBar ttbArrivalTime;
    @BindView(R.id.rg_consultation)
    RadioGroup rgConsultation;
    private String mPatientId;
    private String mDocId;

    public ChestPainIntraConsultFragment() {

    }

    public static ChestPainIntraConsultFragment newInstance(String patientId, String docId) {
        ChestPainIntraConsultFragment fragment = new ChestPainIntraConsultFragment();
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
        return R.layout.fragment_intrac_consult;
    }

    @Override
    protected void initView(@NonNull View view) {

        refrashArrivalTimeVis();
        loadData();
    }


    private void loadData() {

        ArrayList<String> itemData = new ArrayList<>();
        itemData.add("1");
        itemData.add("2");
        itemData.add("3");
        esVitalSignAware.setItemData(itemData);

    }


    @Override
    protected void initListener() {
        rgConsultation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                refrashArrivalTimeVis();
            }
        });
    }

    private void refrashArrivalTimeVis() {
        if (rbOnSiteConsultation.isChecked()) {
            ttbArrivalTime.setVisibility(View.VISIBLE);
        } else {
            ttbArrivalTime.setVisibility(View.GONE);
        }
    }

}