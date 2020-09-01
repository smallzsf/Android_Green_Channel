package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Set;

import butterknife.BindView;

/**
 * DiseaseRecordFragment
 * description: 病情记录
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class DiseaseRecordFragment extends BaseFragment {


    @BindView(R.id.et_major_complaint_frag)
    EditText etMajorComplaintFrag;
    @BindView(R.id.tfl_action_in_chief)
    TagFlowLayout tflActionInChief;
    @BindView(R.id.et_medical_history)
    EditText etMedicalHistory;
    @BindView(R.id.tfl_medical_history)
    TagFlowLayout tflMedicalHistory;
    @BindView(R.id.tfl_anticoagulant_drug)
    TagFlowLayout tflAnticoagulantDrug;
    @BindView(R.id.tfl_anticoagulant_drug1)
    TagFlowLayout tflAnticoagulantDrug1;
    @BindView(R.id.tfl_anticoagulant_drug2)
    TagFlowLayout tflAnticoagulantDrug2;
    @BindView(R.id.tfl_anticoagulant_drug3)
    TagFlowLayout tflAnticoagulantDrug3;
    @BindView(R.id.tfl_anticoagulant_drug4)
    TagFlowLayout tflAnticoagulantDrug4;
    private String mPatientId;
    private String mDocId;

    //主诉值
    private String[] mVals = new String[]{"发现", "突发", "被发现", "右侧肢体无力", "左侧肢体无力", "人事不清", "头晕、行走不稳", "言语障碍", "（）小时", "（）天", "加重（）小时"};
    //既往史值
    private String[] mVals1 = new String[]{"TIA（）", "脑梗死", "脑出血", "蛛网膜下腔出血", "高血压（）年", "血压最高（）mmHg", "糖尿病（）年", "血脂异常", "冠心病", "先天性心脏病", "瓣膜性心脏病", "扩张型心肌病", "心律失常", "心房纤颤", "外周动脉疾病", "手术史（）", "颅外伤史（）", "肿瘤病史（）", "生育史（）子女", "吸烟（ ）年", "（）包/天", "饮酒（ ）年", "白酒/啤酒", "（）两/瓶/天"};
    //既往病史值
    private String[] mVals2 = new String[]{"阿司匹林", "氯吡格雷", "替格普洛", "西洛他唑"};
    private String[] mVals3 = new String[]{"华法林", "利伐沙班", "达比加群"};
    private String[] mVals4 = new String[]{"利尿剂", "β受体阻滞剂", "钙拮抗剂", "ACEI", "ARB"};
    private String[] mVals5 = new String[]{"胰岛素", "磺酰脲类", "双胍类", "α糖苷酶抑制剂", "胰岛素增敏剂", "非磺酰脲类促胰岛素分泌剂"};
    private String[] mVals6 = new String[]{"他汀类", "烟酸及其衍生物", "贝特类", "胆固醇吸收抑制剂"};

    public DiseaseRecordFragment() {
        // Required empty public constructor
    }

    public static DiseaseRecordFragment newInstance(String patientId, String docId) {
        DiseaseRecordFragment fragment = new DiseaseRecordFragment();
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
    public int getLayoutId() {
        return R.layout.fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {

    }


    @Override
    public void initListener() {
        //设置主诉值
        getEtTransferReason(tflActionInChief, etMajorComplaintFrag, mVals);
        //设置既往值
        getEtTransferReason(tflMedicalHistory, etMedicalHistory, mVals1);
        //抗血小板药、抗凝药、降压药、降糖药、降脂药
        getEtTransferReason(tflAnticoagulantDrug, null, mVals2);
        getEtTransferReason(tflAnticoagulantDrug1, null, mVals3);
        getEtTransferReason(tflAnticoagulantDrug2, null, mVals4);
        getEtTransferReason(tflAnticoagulantDrug3, null, mVals5);
        getEtTransferReason(tflAnticoagulantDrug4, null, mVals6);

    }


    private void getEtTransferReason(TagFlowLayout tfl, EditText et, String[] mVals) {


        if (et != null) {
            tfl.setAdapter(new TagAdapter<String>(mVals) {

                private TextView tv;

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                            tfl, false);
                    tv.setText(s);
                    return tv;
                }

                @Override
                public void onSelected(int position, View view) {
                    super.onSelected(position, view);

                }

                @Override
                public void unSelected(int position, View view) {
                    super.unSelected(position, view);
                }
            });

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

            tfl.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
                @Override
                public void onSelected(Set<Integer> selectPosSet) {
                    getActivity().setTitle("choose:" + selectPosSet.toString());
                }
            });

        } else {


            tfl.setAdapter(new TagAdapter<String>(mVals) {

                private TextView tv;

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                            tfl, false);
                    tv.setText(s);
                    return tv;
                }

                @Override
                public void onSelected(int position, View view) {
                    super.onSelected(position, view);
                    //  view.setBackgroundColor(getResources().getColor(R.color.app_00aaff));
                    view.setBackground(getResources().getDrawable(R.drawable.selector_flow_layout_checked_bg));
                }

                @Override
                public void unSelected(int position, View view) {
                    super.unSelected(position, view);
                    view.setBackground(getResources().getDrawable(R.drawable.selector_flow_layout_nomal_bg));
                }
            });


        }

    }


}