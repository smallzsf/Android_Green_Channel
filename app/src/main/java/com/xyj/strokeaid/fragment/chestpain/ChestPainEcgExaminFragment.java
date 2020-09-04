package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * ChestPainEcgExaminFragment
 * description:  心电检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainEcgExaminFragment extends BaseFragment {

    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_auxiliary_exam)
    LinearLayout llAuxiliaryExam;
    @BindView(R.id.tv_add_record)
    TextView tvAddRecord;
    @BindView(R.id.ll_ecg_record_one)
    LinearLayout llEcgRecordOne;
    @BindView(R.id.ll_ecg_record_two)
    LinearLayout llEcgRecordTwo;
    @BindView(R.id.ll_ecg_record_three)
    LinearLayout llEcgRecordThree;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.rb_ecg_transmission_120)
    RadioButton rbEcgTransmission120;
    @BindView(R.id.rb_ecg_transmission_none)
    RadioButton rbEcgTransmissionNone;
    @BindView(R.id.rg_ecg_transmission)
    RadioGroup rgEcgTransmission;
    @BindView(R.id.rb_electrocardiogram_has)
    RadioButton rbElectrocardiogramHas;
    @BindView(R.id.rb_electrocardiogram_none)
    RadioButton rbElectrocardiogramNone;
    @BindView(R.id.rg_electrocardiogram)
    RadioGroup rgElectrocardiogram;
    @BindView(R.id.iv_ecg_record_close_two)
    ImageView ivEcgRecordCloseTwo;
    @BindView(R.id.iv_ecg_record_close_three)
    ImageView ivEcgRecordCloseThree;
    private String mPatientId;
    private String mDocId;

    private int ecgRecordItem = 1;

    public ChestPainEcgExaminFragment() {

    }

    public static ChestPainEcgExaminFragment newInstance(String patientId, String docId) {
        ChestPainEcgExaminFragment fragment = new ChestPainEcgExaminFragment();
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
        return R.layout.fragment_ecg_examin;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
        refrashRecordItem();
    }

    private void refrashRecordItem() {
        refrashRecordItem(llEcgRecordOne, 1);
        refrashRecordItem(llEcgRecordTwo, 2);
        refrashRecordItem(llEcgRecordThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (ecgRecordItem >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }


    private void loadData() {


        btnConfirm.setText("保存");
        btnCancel.setText("一键启动绿色通道");

        ArrayList<String> itemData = new ArrayList<>();
        itemData.add("实时监控");
        itemData.add("微信群");
        itemData.add("其他");
        esVitalSignAware.setItemData(itemData);

    }


    @Override
    protected void initListener() {

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tv_add_record:
                        if (ecgRecordItem >= 3) {
                            Toast.makeText(context, "最多只能添加三条心电记录", Toast.LENGTH_LONG).show();
                            return;
                        }
                        ecgRecordItem++;
                        refrashRecordItem();
                        break;
                    case R.id.iv_ecg_record_close_three:
                    case R.id.iv_ecg_record_close_two:
                        ecgRecordItem--;
                        refrashRecordItem();
                        break;
                    case R.id.rb_electrocardiogram_none:
                    case R.id.rb_electrocardiogram_has:
                        if (rbElectrocardiogramHas.isChecked()){
                            ecgRecordItem = 1;
                        }else {
                            ecgRecordItem = 0;
                        }
                        refrashRecordItem();
                        break;
                }
            }
        };
        rbElectrocardiogramHas.setOnClickListener(onClickListener);
        rbElectrocardiogramNone.setOnClickListener(onClickListener);
        tvAddRecord.setOnClickListener(onClickListener);
        ivEcgRecordCloseTwo.setOnClickListener(onClickListener);
        ivEcgRecordCloseThree.setOnClickListener(onClickListener);


    }

}