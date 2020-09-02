package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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
 * description:  病情信息
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainDiseaseRecordFragment extends BaseFragment {


    private String mPatientId;
    private String mDocId;

    public ChestPainDiseaseRecordFragment() {

    }

    public static ChestPainDiseaseRecordFragment newInstance(String patientId, String docId) {
        ChestPainDiseaseRecordFragment fragment = new ChestPainDiseaseRecordFragment();
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
        return R.layout.chest_pain_fragment_disease_record;
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

}