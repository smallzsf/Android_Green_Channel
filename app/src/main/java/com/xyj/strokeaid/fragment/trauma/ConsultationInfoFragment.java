package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.SelectDataDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 会诊信息
 * @author Licy
 */
public class ConsultationInfoFragment extends BaseStrokeFragment {

    @BindView(R.id.et_trauma)
    EditText etTrauma;
    @BindView(R.id.tv_trauma_select)
    TextView tvTraumaSelect;
    @BindView(R.id.et_neurosurgery)
    EditText etNeurosurgery;
    @BindView(R.id.tv_neurosurgery_select)
    TextView tvNeurosurgerySelect;
    @BindView(R.id.et_orthopaedics)
    EditText etOrthopaedics;
    @BindView(R.id.tv_orthopaedics_select)
    TextView tvOrthopaedicsSelect;
    @BindView(R.id.et_chestsurgery)
    EditText etChestsurgery;
    @BindView(R.id.tv_chestsurgery_select)
    TextView tvChestsurgerySelect;
    @BindView(R.id.et_generalsurgery)
    EditText etGeneralsurgery;
    @BindView(R.id.tv_generalsurgery_select)
    TextView tvGeneralsurgerySelect;
    @BindView(R.id.et_urology)
    EditText etUrology;
    @BindView(R.id.tv_urology_select)
    TextView tvUrologySelect;
    @BindView(R.id.btn)
    AppCompatButton btn;


    public ConsultationInfoFragment() {

    }

    public static ConsultationInfoFragment newInstance(String recordId) {
        ConsultationInfoFragment fragment = new ConsultationInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_consultation_info;
    }

    @Override
    protected void initView(@NonNull View view) {
        btn.setText("一键启动绿色通道");
        loadData();


    }


    private void loadData() {
    }


    @Override
    protected void initListener() {

    }


    @OnClick({R.id.tv_trauma_select, R.id.tv_neurosurgery_select, R.id.tv_orthopaedics_select, R.id.tv_chestsurgery_select, R.id.tv_generalsurgery_select, R.id.tv_urology_select, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_trauma_select:
                //创伤科选择
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etTrauma.setText(data);
                    }
                }).showDialog();
                break;
            case R.id.tv_neurosurgery_select:
                //神经外科
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etNeurosurgery.setText(data);
                    }
                }).showDialog();
                break;
            case R.id.tv_orthopaedics_select:
//                骨科
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etOrthopaedics.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.tv_chestsurgery_select:
//                胸外科
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etChestsurgery.setText(data);
                    }
                }).showDialog();
                break;
            case R.id.tv_generalsurgery_select:
//                普外科
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etGeneralsurgery.setText(data);
                    }
                }).showDialog();
                break;
            case R.id.tv_urology_select:
//                泌尿外科
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etUrology.setText(data);
                    }
                }).showDialog();
                break;
            case R.id.btn:
                break;
        }
    }


}
