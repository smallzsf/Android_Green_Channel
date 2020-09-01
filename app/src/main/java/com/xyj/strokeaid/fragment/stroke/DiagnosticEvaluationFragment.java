package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * DiagnosticEvaluationFragment
 * description: 诊断评估
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class DiagnosticEvaluationFragment extends BaseFragment {


    @BindView(R.id.rb_acute)
    RadioButton rbAcute;
    @BindView(R.id.rb_progressivity)
    RadioButton rbProgressivity;
    @BindView(R.id.rg_have_disease_way)
    RadioGroup rgHaveDiseaseWay;
    /* @BindView(R.id.doctor_name_line)
     View doctorNameLine;*/
    @BindView(R.id.rb_court)
    RadioButton rbCourt;
    @BindView(R.id.rb_lobby)
    RadioButton rbLobby;
    @BindView(R.id.rg_progress_site)
    RadioGroup rgProgressSite;
    @BindView(R.id.iv_refresh1)
    ImageView ivRefresh1;
    @BindView(R.id.ll_progress_site)
    LinearLayout llProgressSite;
    @BindView(R.id.es_diagnosis)
    EditSpinner esDiagnosis;
    @BindView(R.id.ll_diagnosis)
    LinearLayout llDiagnosis;
    @BindView(R.id.es_hemorrhagic_apoplexy)
    EditSpinner esHemorrhagicApoplexy;
    @BindView(R.id.es_hemorrhagic_apoplexy2)
    EditSpinner esHemorrhagicApoplexy2;
    @BindView(R.id.ll_hemorrhagic_apoplexy)
    LinearLayout llHemorrhagicApoplexy;
    @BindView(R.id.et_ischemic_stroke)
    EditSpinner etIschemicStroke;
    @BindView(R.id.et_nosogenesis)
    EditSpinner etNosogenesis;
    @BindView(R.id.ll_ischemic_stroke)
    LinearLayout llIschemicStroke;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.sv_admitting_diagnosis)
    ScrollView svAdmittingDiagnosis;
    @BindView(R.id.sv_discharge_diagnosis)
    ScrollView svDischargeDiagnosis;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.rb_moyamoya_disease_yes)
    RadioButton rbMoyamoyaDiseaseYes;
    @BindView(R.id.rb_moyamoya_disease_no)
    RadioButton rbMoyamoyaDiseaseNo;
    @BindView(R.id.rg_moyamoya_disease)
    RadioGroup rgMoyamoyaDisease;
    @BindView(R.id.ll_moyamoya_disease)
    LinearLayout llMoyamoyaDisease;
    @BindView(R.id.ll_other_diagnostic)
    LinearLayout llOtherDiagnostic;
    @BindView(R.id.es_emergency_treatment_doctor)
    EditSpinner esEmergencyTreatmentDoctor;
    @BindView(R.id.es_apoplexy_doctor)
    EditSpinner esApoplexyDoctor;
    @BindView(R.id.et_input_weight)
    EditText etInputWeight;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_diagnostic_evaluation)
    LinearLayout llDiagnosticEvaluation;
    private String mPatientId;
    private String mDocId;

    private ArrayList<String> nosogenesisList;

    /**
     * 0 == 入院诊断
     * 1 == 出院诊断
     */

    public DiagnosticEvaluationFragment() {
        // Required empty public constructor
    }

    public static DiagnosticEvaluationFragment newInstance(String patientId, String docId) {
        DiagnosticEvaluationFragment fragment = new DiagnosticEvaluationFragment();
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
    public void onResume() {
        super.onResume();

        HideBottonUtils.getInstance().getHideBotton(llDiagnosticEvaluation, llBottom);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_diagnostic_evaluation;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
    }


    @Override
    protected void initListener() {

        //起病方式
        rgHaveDiseaseWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobutton = (RadioButton) group.findViewById(group.getCheckedRadioButtonId());
                //  Toast.makeText(getActivity(),"选中的内容是"+ radiobutton.getText().toString(),Toast.LENGTH_LONG).show();
                switch (checkedId) {
                    case R.id.rb_acute:
                        llProgressSite.setVisibility(View.GONE);
                        break;

                    case R.id.rb_progressivity:
                        llProgressSite.setVisibility(View.VISIBLE);
                        //获取选中的radiobutton内容 group.getCheckedRadioButtonId()

                        break;
                }
            }
        });

        //诊断结果
        esDiagnosis.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                if (text.contains("缺血性卒中")) {
                    llIschemicStroke.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                    llIschemicStroke.requestLayout();
                    if (etNosogenesis.getText().contains("其他原因所致的缺血性卒中（SOE）")) {
                        etNosogenesis.setItemData(nosogenesisList);
                    } else {
                        llMoyamoyaDisease.setVisibility(View.GONE);
                    }
                } else if (text.contains("出血性卒中")) {
                    llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                } else if (text.contains("其它")) {
                    llOtherDiagnostic.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llIschemicStroke.setVisibility(View.GONE);
                } else {
                    llIschemicStroke.setVisibility(View.GONE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                }

                llMoyamoyaDisease.setVisibility(View.GONE);
            }
        });

        //发病机制
        etNosogenesis.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                if (text.contains("其他原因所致的缺血性卒中（SOE）")) {
                    llMoyamoyaDisease.setVisibility(View.VISIBLE);
                } else {
                    llMoyamoyaDisease.setVisibility(View.GONE);
                }
            }
        });

        //烟雾病
        rgMoyamoyaDisease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobutton = (RadioButton) group.findViewById(group.getCheckedRadioButtonId());
                // Toast.makeText(getActivity(), "选中的内容是" + radiobutton.getText().toString(), Toast.LENGTH_LONG).show();
                switch (checkedId) {
                    case R.id.rb_moyamoya_disease_yes:

                        break;

                    case R.id.rb_moyamoya_disease_no:


                        break;
                }
            }
        });

    }


    private void loadData() {
        ArrayList<String> diagnosisList = new ArrayList<>();
        diagnosisList.add("请选择");
        diagnosisList.add("缺血性卒中");
        diagnosisList.add("出血性卒中");
        diagnosisList.add("非破裂动脉瘤");
        diagnosisList.add("颈部动脉狭窄或闭塞");
        diagnosisList.add("其它");
        esDiagnosis.setItemData(diagnosisList);

        ArrayList<String> ischemicStrokeList = new ArrayList<>();
        ischemicStrokeList.add("请选择");
        ischemicStrokeList.add("脑梗死");
        ischemicStrokeList.add("短暂性脑缺血(TIA)");
        etIschemicStroke.setItemData(ischemicStrokeList);

        nosogenesisList = new ArrayList<>();
        nosogenesisList.add("请选择");
        nosogenesisList.add("大动脉粥样硬化性卒中（LAA）");
        nosogenesisList.add("心源性脑栓塞（CE）");
        nosogenesisList.add("小动脉闭塞性卒中或腔隙性卒中（SAA）");
        nosogenesisList.add("其他原因所致的缺血性卒中（SOE）");
        nosogenesisList.add("不明原因的缺血性卒中（SUE）");
        etNosogenesis.setItemData(nosogenesisList);

        //急诊医生
        ArrayList<String> hemorrhagicApoplexyList = new ArrayList<>();
        hemorrhagicApoplexyList.add("请选择");
        hemorrhagicApoplexyList.add("动脉瘤破裂");
        hemorrhagicApoplexyList.add("非动脉瘤破裂");
        esHemorrhagicApoplexy.setItemData(hemorrhagicApoplexyList);
        //急诊医生
        ArrayList<String> emergencyTreatmentDoctorList = new ArrayList<>();
        emergencyTreatmentDoctorList.add("请选择");
        emergencyTreatmentDoctorList.add("刘超");
        emergencyTreatmentDoctorList.add("原晋毅");
        emergencyTreatmentDoctorList.add("田郑恩");
        emergencyTreatmentDoctorList.add("刘敬玺");
        emergencyTreatmentDoctorList.add("束颖");
        emergencyTreatmentDoctorList.add("曹轮飞");
        emergencyTreatmentDoctorList.add("丁青梅");
        emergencyTreatmentDoctorList.add("刘蕾");
        emergencyTreatmentDoctorList.add("程亚辉");
        esEmergencyTreatmentDoctor.setItemData(emergencyTreatmentDoctorList);
        //卒中医生
        ArrayList<String> apoplexyDoctorList = new ArrayList<>();
        apoplexyDoctorList.add("请选择");
        apoplexyDoctorList.add("姜树志");
        apoplexyDoctorList.add("孙超艳");
        apoplexyDoctorList.add("赵振东");
        apoplexyDoctorList.add("陈苗苗");
        apoplexyDoctorList.add("王一鸣");
        apoplexyDoctorList.add("张霄");
        apoplexyDoctorList.add("谭兰婷");
        apoplexyDoctorList.add("张艳");
        apoplexyDoctorList.add("李彪");
        apoplexyDoctorList.add("赵送会");
        apoplexyDoctorList.add("李建华");
        esApoplexyDoctor.setItemData(apoplexyDoctorList);


    }


}