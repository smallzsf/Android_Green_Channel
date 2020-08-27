package com.xyj.strokeaid.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TransferFragment
 * description: 转归交接
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class TransferFragment extends BaseFragment {

    @BindView(R.id.es_transformation)
    EditSpinner esTransformation;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.tfl_transfer_reason)
    TagFlowLayout tflTransferReason;
    @BindView(R.id.et_state_of_illness_dispose)
    EditText etStateOfIllnessDispose;
    @BindView(R.id.tfl_state_of_illness_dispose)
    TagFlowLayout tflStateOfIllnessDispose;
    @BindView(R.id.sv_to_transfe_hospital)
    ScrollView svToTransfeHospital;
    @BindView(R.id.sv_leave_hospital)
    ScrollView svLeaveHospital;


    private String[] mVals = new String[]{"无溶栓能力", "无介入能力", "家属意愿"};
    private String[] mVals1 = new String[]{"未给溶栓药物", "已给溶栓药物"};


    private String mPatientId;
    private String mDocId;
    private ArrayList<String> list;

    public TransferFragment() {
        // Required empty public constructor
    }

    public static TransferFragment newInstance(String patientId, String docId) {
        TransferFragment fragment = new TransferFragment();
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
        return R.layout.fragment_transfer;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();


        esTransformation.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.contains("转院")) {
                    svToTransfeHospital.setVisibility(View.VISIBLE);
                    svLeaveHospital.setVisibility(View.GONE);
                } else if (text.contains("离院")) {
                    svToTransfeHospital.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.VISIBLE);
                }else{
                    svToTransfeHospital.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    protected void initListener() {
        //设置输入框值
        tflTransferReason.setAdapter(mAdapter);
        getEtTransferReason(tflTransferReason, etTransferReason, mVals);
        //设置输入框值
        tflStateOfIllnessDispose.setAdapter(mAdapter1);
        getEtTransferReason(tflStateOfIllnessDispose, etStateOfIllnessDispose, mVals1);
    }


    private void getEtTransferReason(TagFlowLayout tfl, EditText et, String[] mVals) {


        et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 解决scrollView中嵌套EditText导致不能上下滑动的问题
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                return false;
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 100) { //判断EditText中输入的字符数是不是已经大于6
                    et.setText(s.toString().substring(0, 100)); //设置EditText只显示前面6位字符
                    et.setSelection(100);
                    return;
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {

                if (!et.getText().toString().isEmpty()) {

                    et.setText(et.getText().toString() + "，" + mVals[position]);

                } else {
                    et.setText(mVals[position]);
                }

                return true;
            }
        });
    }


    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("急诊留观");
        list.add("收入急诊重症");
        list.add("收入急诊病房");
        list.add("收入神经重症");
        list.add("收入神经内科一病区");
        list.add("收入神经内科二病区");
        list.add("收入神经外科病区");
        list.add("转院");
        list.add("死亡");
        list.add("离院");
        list.add("其他");
        esTransformation.setItemData(list);
    }


    TagAdapter<String> mAdapter = new TagAdapter<String>(mVals) {
        @Override
        public View getView(FlowLayout parent, int position, String s) {
            TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                    tflTransferReason, false);
            tv.setText(s);
            return tv;
        }

    };

    TagAdapter<String> mAdapter1 = new TagAdapter<String>(mVals1) {
        @Override
        public View getView(FlowLayout parent, int position, String s) {
            TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                    tflTransferReason, false);
            tv.setText(s);
            return tv;
        }

    };

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                Toast.makeText(mActivity, esTransformation.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                break;
        }
    }
}