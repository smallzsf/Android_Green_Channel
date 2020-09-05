package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  血液检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainBloodTestFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.ll_troponin_title)
    LinearLayout llTroponinTitle;
    @BindView(R.id.rb_troponin_has)
    RadioButton rbTroponinHas;
    @BindView(R.id.rb_troponin_none)
    RadioButton rbTroponinNone;
    @BindView(R.id.tv_add_troponin)
    TextView tvAddTroponin;
    @BindView(R.id.rb_troponin_tnt_first)
    RadioButton rbTroponinTntFirst;
    @BindView(R.id.rb_troponin_tnl_first)
    RadioButton rbTroponinTnlFirst;
    @BindView(R.id.rb_troponin_tnt_two)
    RadioButton rbTroponinTntTwo;
    @BindView(R.id.rb_troponin_tnl_two)
    RadioButton rbTroponinTnlTwo;
    @BindView(R.id.ll_troponin_two)
    LinearLayout llTroponinTwo;
    @BindView(R.id.rb_troponin_tnt_three)
    RadioButton rbTroponinTntThree;
    @BindView(R.id.rb_troponin_tnl_three)
    RadioButton rbTroponinTnlThree;
    @BindView(R.id.ll_troponin_three)
    LinearLayout llTroponinThree;
    @BindView(R.id.iv_preoperative_anticoagulation)
    ImageView ivPreoperativeAnticoagulation;
    @BindView(R.id.ll_preoperative_anticoagulation_title)
    LinearLayout llPreoperativeAnticoagulationTitle;
    @BindView(R.id.eds_preoperative_anticoagulation)
    EditSpinner edsPreoperativeAnticoagulation;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;
    @BindView(R.id.ll_troponin_first)
    LinearLayout llTroponinFirst;
    @BindView(R.id.ll_preoperative_anticoagulation_data)
    LinearLayout llPreoperativeAnticoagulationData;
    @BindView(R.id.ll_dimer_title)
    LinearLayout llDimerTitle;
    @BindView(R.id.ll_dimer_data)
    LinearLayout llDimerData;
    @BindView(R.id.ll_bnp_title)
    LinearLayout llBnpTitle;
    @BindView(R.id.ll_bnp_data)
    LinearLayout llBnpData;
    @BindView(R.id.ll_nt_probnp_title)
    LinearLayout llNtProbnpTitle;
    @BindView(R.id.ll_nt_probnp_data)
    LinearLayout llNtProbnpData;
    @BindView(R.id.ll_myo_title)
    LinearLayout llMyoTitle;
    @BindView(R.id.ll_myo_data)
    LinearLayout llMyoData;
    @BindView(R.id.ll_troponin_data)
    LinearLayout llTroponinData;
    @BindView(R.id.iv_troponin)
    ImageView ivTroponin;
    @BindView(R.id.iv_dimer)
    ImageView ivDimer;
    @BindView(R.id.iv_bnp)
    ImageView ivBnp;
    @BindView(R.id.iv_nt_probnp)
    ImageView ivNtProbnp;
    @BindView(R.id.iv_myo)
    ImageView ivMyo;
    @BindView(R.id.iv_ckmb)
    ImageView ivCkmb;
    @BindView(R.id.ll_ckmb_title)
    LinearLayout llCkmbTitle;
    @BindView(R.id.ll_ckmb_data)
    LinearLayout llCkmbData;
    private String mPatientId;
    private String mDocId;
    private List<String> list;

    private int troponinDataNum = 0;

    public ChestPainBloodTestFragment() {

    }

    public static ChestPainBloodTestFragment newInstance(String patientId, String docId) {
        ChestPainBloodTestFragment fragment = new ChestPainBloodTestFragment();
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
        return R.layout.fragment_chest_pain_blood_test;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
    }


    private void loadData() {

    }


    @Override
    protected void initListener() {
        tvAddTroponin.setOnClickListener(this);

        llPreoperativeAnticoagulationTitle.setOnClickListener(this);
        llTroponinTitle.setOnClickListener(this);
        llBnpTitle.setOnClickListener(this);
        llMyoTitle.setOnClickListener(this);
        llNtProbnpTitle.setOnClickListener(this);
        llDimerTitle.setOnClickListener(this);
        llCkmbTitle.setOnClickListener(this);
        rbTroponinHas.setOnClickListener(this);
        rbTroponinNone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.rb_troponin_has:
            case R.id.rb_troponin_none:
                if (rbTroponinHas.isChecked()) {
                    troponinDataNum = 1;
                    refrashRecordItem();
                } else {
                    troponinDataNum = 0;
                    refrashRecordItem();
                }
                break;
            case R.id.tv_add_troponin:
                troponinDataNum++;
                refrashRecordItem();
                break;
            case R.id.ll_preoperative_anticoagulation_title:
                refrashItemVis(llPreoperativeAnticoagulationData, ivPreoperativeAnticoagulation);
                break;
            case R.id.ll_troponin_title:
                refrashItemVis(llTroponinData, ivTroponin);
                break;
            case R.id.ll_bnp_title:
                refrashItemVis(llBnpData, ivBnp);
                break;
            case R.id.ll_myo_title:
                refrashItemVis(llMyoData, ivMyo);
                break;
            case R.id.ll_nt_probnp_title:
                refrashItemVis(llNtProbnpData, ivNtProbnp);
                break;
            case R.id.ll_dimer_title:
                refrashItemVis(llDimerData, ivDimer);
                break;
            case R.id.ll_ckmb_title:
                refrashItemVis(llCkmbData, ivCkmb);
                break;
        }
    }

    private void refrashItemVis(View view, ImageView imageView) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.ic_arrow_up_blue);
        } else {
            view.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_arrow_down_blue);
        }
    }

    private void refrashRecordItem() {
        refrashRecordItem(llTroponinFirst, 1);
        refrashRecordItem(llTroponinTwo, 2);
        refrashRecordItem(llTroponinThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (troponinDataNum >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}