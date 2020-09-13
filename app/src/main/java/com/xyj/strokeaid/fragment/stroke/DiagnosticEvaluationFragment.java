package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordRequest;
import com.xyj.strokeaid.bean.DiagnosticEvaluationBean;
import com.xyj.strokeaid.bean.DiagnosticEvaluationEntity;
import com.xyj.strokeaid.bean.StrokeInHosDrugBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    @BindView(R.id.rb_court)
    RadioButton rbCourt;
    @BindView(R.id.rb_lobby)
    RadioButton rbLobby;
    @BindView(R.id.rg_progress_site)
    RadioGroup rgProgressSite;
    //    @BindView(R.id.iv_refresh1)
//    ImageView ivRefresh1;
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
    //    @BindView(R.id.tv_name)
//    TextView tvName;
//    @BindView(R.id.app_tv_editSpinner_time)
//    TextView appTvEditSpinnerTime;
//    @BindView(R.id.iv_refresh)
//    ImageView ivRefresh;
    @BindView(R.id.sv_admitting_diagnosis)
    ScrollView svAdmittingDiagnosis;
    @BindView(R.id.sv_discharge_diagnosis)
    ScrollView svDischargeDiagnosis;
    //    @BindView(R.id.btn_get_data)
//    AppCompatButton btnGetData;
//    @BindView(R.id.btn_confirm)
//    AppCompatButton btnConfirm;
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
    @BindView(R.id.tv_time_diagnosis_progress)
    TextTimeBar ttbDiagnosisProgress;
    @BindView(R.id.tv_time_diagnosis)
    TextTimeBar ttbDiagnosis;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.cb_cpc_left1)
    CheckBox cbCpcLeft1;
    @BindView(R.id.cb_cpc_left2)
    CheckBox cbCpcLeft2;
    @BindView(R.id.cb_cpc_left3)
    CheckBox cbCpcLeft3;
    @BindView(R.id.cb_cpc_left4)
    CheckBox cbCpcLeft4;
    @BindView(R.id.cb_cpc_left5)
    CheckBox cbCpcLeft5;
    @BindView(R.id.cb_cpc_right1)
    CheckBox cbCpcRight1;
    @BindView(R.id.cb_cpc_right2)
    CheckBox cbCpcRight2;
    @BindView(R.id.cb_cpc_right3)
    CheckBox cbCpcRight3;
    @BindView(R.id.cb_cpc_right4)
    CheckBox cbCpcRight4;
    @BindView(R.id.cb_cpc_right5)
    CheckBox cbCpcRight5;
    @BindView(R.id.cpc_ll)
    LinearLayout llCpc;
    @BindView(R.id.ieb_hemorrhage_size)
    ItemEditBar iebHemorrhageSize;
    @BindView(R.id.rg_have_cerebral_hernia)
    RadioGroup rgHaveCerebralHernia;
    @BindView(R.id.es_dmlpl)
    EditSpinner esDmlpl;
    @BindView(R.id.rg_dmlpls)
    RadioGroup rgDmlpls;
    @BindView(R.id.ll_dmlpl)
    LinearLayout llDmlpl;
    @BindView(R.id.ll_dmlpl_unt)
    LinearLayout llDmlplUnt;
    @BindView(R.id.ieb_unt_Hess)
    ItemEditBar iebUntHess;
    @BindView(R.id.ieb_fisher)
    ItemEditBar iebFisher;
    @BindView(R.id.rg_nmdpzl)
    RadioGroup rgNmdpzl;
    @BindView(R.id.es_cxxcz)
    EditSpinner esCxxcz;
    @BindView(R.id.rg_symptom)
    RadioGroup rgSymptom;
    @BindView(R.id.rg_narrow)
    RadioGroup rgNarrow;
    @BindView(R.id.ll_symptom)
    LinearLayout llSymptom;

    @BindView(R.id.ll_diagnostic_evaluation)
    LinearLayout llDiagnosticEvaluation;

    private int isDmpl = -1; //1动脉破裂 0非动脉破裂

    private ArrayList<String> nosogenesisList;

    private DiagnosticEvaluationBean bean = new DiagnosticEvaluationBean();

    /**
     * 0 == 入院诊断
     * 1 == 出院诊断
     */
    private String mRecordId;

    public DiagnosticEvaluationFragment() {
    }

    public static DiagnosticEvaluationFragment newInstance(String recordId) {
        DiagnosticEvaluationFragment fragment = new DiagnosticEvaluationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }


    @Override
    public void onResume() {
        super.onResume();

//        View llBottom = getActivity().findViewById(R.id.ll_bottom);
//        HideBottonUtils.getInstance().getHideBotton(llDiagnosticEvaluation, llBottom);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_diagnostic_evaluation;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
        queryData();
    }


    @Override
    protected void initListener() {

        //起病方式
        rgHaveDiseaseWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_acute:
                        llProgressSite.setVisibility(View.GONE);
                        bean.setModeofonset("cpc_evolveaddress_jx");
                        break;

                    case R.id.rb_progressivity:
                        llProgressSite.setVisibility(View.VISIBLE);
                        //获取选中的radiobutton内容 group.getCheckedRadioButtonId()
                        bean.setModeofonset("cpc_evolveaddress_jzx");
                        break;
                }
            }
        });
        //是否右症状
        rgSymptom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_symptom_yes:
                        bean.setIshavesymptomincarotidarteryinit("cpc_hascas_true");
                        break;
                    case R.id.rb_symptom_no:
                        bean.setIshavesymptomincarotidarteryinit("cpc_hascas_false");
                        break;
                }
            }
        });
        //是否有狭窄
        rgNarrow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_narrow_yes:
                        bean.setIsnarrowinit("cpc_bool_true");
                        break;
                    case R.id.rb_narrow_no:
                        bean.setIsnarrowinit("cpc_bool_false");
                        break;
                }
            }
        });
        //进展地点
        rgProgressSite.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_court:
                        bean.setEvolveaddress("cpc_evolveaddress_yn");
                        break;

                    case R.id.rb_lobby:
                        //获取选中的radiobutton内容 group.getCheckedRadioButtonId()
                        bean.setEvolveaddress("cpc_evolveaddress_yw");
                        break;
                }
            }
        });

        //是否脑疝
        rgHaveCerebralHernia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_cerebral_hernia_ture:
                        bean.setIsherniainit("cpc_bool_true");
                        break;

                    case R.id.rb_cerebral_hernia_false:
                        bean.setIsherniainit("cpc_bool_true");
                        break;
                }
            }
        });

        //有无既往动脉瘤破裂史
        rgDmlpls.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_dmlpls_ture:
                        llProgressSite.setVisibility(View.GONE);
                        bean.setIshadruptureofaneurysminit("cpc_exist_true");
                        break;

                    case R.id.rb_dmlpls_false:
                        llProgressSite.setVisibility(View.VISIBLE);
                        bean.setIshadruptureofaneurysminit("cpc_exist_false");
                        break;
                }
            }
        });

        //尼莫地平治疗
        rgNmdpzl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_nmdpzl_ture:
                        bean.setIsusenimodipineinit("cpc_bool_true");
                        break;
                    case R.id.rb_nmdpzl_false:
                        bean.setIsusenimodipineinit("cpc_bool_false");
                        break;
                }
            }
        });
        //动脉瘤破裂
        esDmlpl.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.contains("蛛网膜下腔出血")) {
//                    llDmlpl.setVisibility(View.VISIBLE);
                    llDmlplUnt.setVisibility(View.VISIBLE);
                } else if (text.contains("蛛网膜下腔出血合并脑出血")) {
//                    llDmlpl.setVisibility(View.VISIBLE);
                    llDmlplUnt.setVisibility(View.VISIBLE);
                } else {
//                    llDmlpl.setVisibility(View.GONE);
                    llDmlplUnt.setVisibility(View.GONE);
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
                    llCpc.setVisibility(View.GONE);
                    llIschemicStroke.requestLayout();
                    if (etNosogenesis.getText().contains("其他原因所致的缺血性卒中（SOE）")) {
                        etNosogenesis.setItemData(nosogenesisList);
                    } else {
                        llMoyamoyaDisease.setVisibility(View.GONE);
                    }
                    llSymptom.setVisibility(View.GONE);
                    llDmlpl.setVisibility(View.GONE);
                } else if (text.contains("出血性卒中")) {
                    llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                    bean.setHemorrhagicstrokeinit(esHemorrhagicApoplexy.getSelectData()[1]);
                    llDmlpl.setVisibility(View.VISIBLE);
                    llCpc.setVisibility(View.VISIBLE);
                    llSymptom.setVisibility(View.GONE);
                } else if (text.contains("颈部动脉狭窄或闭塞")) {
                    llSymptom.setVisibility(View.VISIBLE);
                    llDmlpl.setVisibility(View.GONE);
                } else if (text.contains("其他")) {
                    llOtherDiagnostic.setVisibility(View.VISIBLE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llIschemicStroke.setVisibility(View.GONE);
                    llCpc.setVisibility(View.GONE);
                    llSymptom.setVisibility(View.GONE);
                    llDmlpl.setVisibility(View.GONE);
                } else {
                    llIschemicStroke.setVisibility(View.GONE);
                    llHemorrhagicApoplexy.setVisibility(View.GONE);
                    llOtherDiagnostic.setVisibility(View.GONE);
                    llCpc.setVisibility(View.GONE);
                    llSymptom.setVisibility(View.GONE);
                    llDmlpl.setVisibility(View.GONE);
                }

                llMoyamoyaDisease.setVisibility(View.GONE);
            }
        });
        esCxxcz.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.equals("动脉瘤破裂")) {
                    llDmlplUnt.setVisibility(View.VISIBLE);
                    //动脉瘤破裂
                    esDmlpl.setStringArrayId(R.array.rupturedAneurysm);
                    isDmpl = 1;
                } else if (text.equals("非动脉瘤破裂")) {
                    llDmlplUnt.setVisibility(View.GONE);
                    //非动脉瘤破裂
                    esDmlpl.setStringArrayId(R.array.ruptureofnonaneurysm);
                    isDmpl = 0;
                }
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
                        bean.setIsmoyamoyainit("cpc_bool_true");
                        break;

                    case R.id.rb_moyamoya_disease_no:
                        bean.setIsmoyamoyainit("cpc_bool_false");
                        break;
                }
            }
        });

        btnSave.setOnClickListener(v -> {
            getViewData();
        });

    }

    private void getViewData() {
        bean.setEvolvetime(ttbDiagnosisProgress.getTime());
        bean.setDiagnosticresultinit(esDiagnosis.getSelectData()[1]);
        bean.setIschemicstrokeinit(etIschemicStroke.getSelectData()[1]);
        bean.setPathogenesisinit(etNosogenesis.getSelectData()[1]);
        bean.setDiagnostictimeinit(ttbDiagnosis.getTime());
        bean.setEmergencydoctorCzzdinit(esEmergencyTreatmentDoctor.getText());
        bean.setStrokedoctorCzzdinit(esApoplexyDoctor.getText());
        /**
         * 卒中诊断 左 侧的出血部位
         */
        String checkBoxValueLeft = getCheckBoxValue(cbCpcLeft1, cbCpcLeft2, cbCpcLeft3, cbCpcLeft4, cbCpcLeft5);
        bean.setHemorrhageinleftinit(checkBoxValueLeft);
        /**
         * 卒中诊断 右 侧的出血部位
         */
        String checkBoxValueRight = getCheckBoxValue(cbCpcRight1, cbCpcRight2, cbCpcRight3, cbCpcRight4, cbCpcRight5);
        bean.setHemorrhageinrightinit(checkBoxValueRight);
        bean.setHemorrhageamountinit(iebHemorrhageSize.getEditContent());

        if (isDmpl == 1) {
            /**
             * 动脉瘤破裂
             */
            bean.setRuptureofaneurysminit(esDmlpl.getSelectData()[1]);
        } else if (isDmpl == 0) {
            /**
             * 非动脉瘤破裂
             */
            bean.setRuptureofnonaneurysminit(esDmlpl.getSelectData()[1]);
        }
        bean.setHunthesslevelinit(iebUntHess.getEditContent());
        bean.setFisherlevelinit(iebFisher.getEditContent());
        bean.setOtherdiagnosticresultinit(etInputWeight.getText().toString().trim());
        dataSave(bean);
    }

    private void dataSave(DiagnosticEvaluationBean bean) {
        BaseRequestBean<DiagnosticEvaluationBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 1, bean);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveDiagnosticEvaluation(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());
                    }
                });
    }

    //查询数据
    private void queryData() {
        //调用获取数据接口
//        DiagnosticEvaluationEntity p = new DiagnosticEvaluationEntity();
//        p.setRecordId(mRecordId);
//        String request = GsonUtils.getGson().toJson(p);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        BaseRequestBean<DiagnosticEvaluationBean> requestBean = new BaseRequestBean<>(
                mRecordId, 1, new DiagnosticEvaluationBean());
        RetrofitClient
                .getInstance()
                .getApi()
                .getDiagnosticEvaluation(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseResponseBean<DiagnosticEvaluationBean>>() {

                    @Override
                    public void onResponse(Call<BaseResponseBean<DiagnosticEvaluationBean>> call, Response<BaseResponseBean<DiagnosticEvaluationBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                bean = response.body().getData().getData();
                                dataToView(bean);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseResponseBean<DiagnosticEvaluationBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }

    private void dataToView(DiagnosticEvaluationBean bean) {
        ttbDiagnosisProgress.setTime(bean.getEvolvetime());
        ttbDiagnosis.setTime(bean.getDiagnostictimeinit());
        String ischemicstrokeinit = bean.getIschemicstrokeinit();
        if (!TextUtils.isEmpty(ischemicstrokeinit)){
            if (ischemicstrokeinit.equals("cpc_qxxncz_ngs")){
                etIschemicStroke.setText("脑梗死");
            }else if (ischemicstrokeinit.equals("cpc_qxxncz_dzxnqx")){
                etIschemicStroke.setText("短暂性脑缺血(TIA)");
            }
        }
//        esEmergencyTreatmentDoctor.setText(bean.getEmergencydoctorCzzdinit());
//        esApoplexyDoctor.setText(bean.getStrokedoctorCzzdinit());
        /**
         * 卒中诊断 左 侧的出血部位
         */
        String hemorrhageinleftinit = bean.getHemorrhageinleftinit();
        if (!TextUtils.isEmpty(hemorrhageinleftinit)) {
            cbCpcLeft1.setChecked(hemorrhageinleftinit.contains("cpc_leftsideofbleedingsite_jdyq"));
            cbCpcLeft2.setChecked(hemorrhageinleftinit.contains("cpc_leftsideofbleedingsite_msny"));
            cbCpcLeft3.setChecked(hemorrhageinleftinit.contains("cpc_leftsideofbleedingsite_xn"));
            cbCpcLeft4.setChecked(hemorrhageinleftinit.contains("cpc_leftsideofbleedingsite_ng"));
            cbCpcLeft5.setChecked(hemorrhageinleftinit.contains("cpc_leftsideofbleedingsite_ns"));
        }
        /**
         * 卒中诊断 右 侧的出血部位
         */
        String hemorrhageinrightinit = bean.getHemorrhageinrightinit();
        if (!TextUtils.isEmpty(hemorrhageinrightinit)) {
            cbCpcRight1.setChecked(hemorrhageinrightinit.contains("cpc_rightsideofbleedingsite_jdyq"));
            cbCpcRight2.setChecked(hemorrhageinrightinit.contains("cpc_rightsideofbleedingsite_msny"));
            cbCpcRight3.setChecked(hemorrhageinrightinit.contains("cpc_rightsideofbleedingsite_xn"));
            cbCpcRight4.setChecked(hemorrhageinrightinit.contains("cpc_rightsideofbleedingsite_ng"));
            cbCpcRight5.setChecked(hemorrhageinrightinit.contains("cpc_rightsideofbleedingsite_ns"));
        }

        iebHemorrhageSize.setEditContent(bean.getHemorrhageamountinit());
        iebUntHess.setEditContent(bean.getHunthesslevelinit());
        iebFisher.setEditContent(bean.getFisherlevelinit());
        etInputWeight.setText(bean.getOtherdiagnosticresultinit());

        String ruptureofaneurysminit = bean.getRuptureofaneurysminit();
        String ruptureofnonaneurysminit = bean.getRuptureofnonaneurysminit();
        if (!TextUtils.isEmpty(ruptureofaneurysminit)){
            if (ruptureofaneurysminit.equals("cpc_cxxncz_dmlpl")){
                isDmpl = 1;
                esCxxcz.setText("动脉瘤破裂");
                llDmlplUnt.setVisibility(View.VISIBLE);
                //动脉瘤破裂
                esDmlpl.setStringArrayId(R.array.rupturedAneurysm);
                if (ruptureofaneurysminit.equals("cpc_ruptureofaneurysm_zwmxqcx")){
                    llDmlplUnt.setVisibility(View.VISIBLE);
                    esDmlpl.setText("蛛网膜下腔出血");
                }else if (ruptureofaneurysminit.equals("cpc_ruptureofaneurysm_zwmxqcx")){
                    esDmlpl.setText("蛛网膜下腔出血合并脑出血");
                    llDmlplUnt.setVisibility(View.VISIBLE);
                }else {
                    esDmlpl.setText("其他");
                    llDmlplUnt.setVisibility(View.GONE);
                }
            }
        } else if (!TextUtils.isEmpty(ruptureofnonaneurysminit)){
            if (ruptureofnonaneurysminit.equals("cpc_cxxncz_fdmlpl")){
                isDmpl = 2;
                esCxxcz.setText("非动脉瘤破裂");
                llDmlplUnt.setVisibility(View.GONE);
                //非动脉瘤破裂
                esDmlpl.setStringArrayId(R.array.ruptureofnonaneurysm);
                if (ruptureofaneurysminit.equals("cpc_ruptureofnonaneurysm_gxyncx")){
                    esDmlpl.setText("高血压脑出血");
                }else if (ruptureofaneurysminit.equals("cpc_ruptureofnonaneurysm_hmzxgl")){
                    esDmlpl.setText("海绵状血管瘤");
                }else if (ruptureofaneurysminit.equals("cpc_ruptureofnonaneurysm_djmjx")){
                    esDmlpl.setText("动静脉畸形（AVM瘘）");
                }else if (ruptureofaneurysminit.equals("cpc_ruptureofnonaneurysm_jmdxsxc")){
                    esDmlpl.setText("静脉窦血栓形成");
                }else if (ruptureofaneurysminit.equals("cpc_ruptureofnonaneurysm_dfyb")){
                    esDmlpl.setText("淀粉样变");
                }else {
                    esDmlpl.setText("其他");
                }
            }
        }

        //起病方式
        String modeofonset = bean.getModeofonset();
        if (!TextUtils.isEmpty(modeofonset)){
            rgHaveDiseaseWay.check(modeofonset.equals("cpc_evolveaddress_jx") ? R.id.rb_acute : R.id.rb_progressivity);
            if (modeofonset.equals("cpc_evolveaddress_jx")){
                llProgressSite.setVisibility(View.GONE);
            }else if (modeofonset.equals("cpc_evolveaddress_jzx")){
                llProgressSite.setVisibility(View.VISIBLE);
            }
        }

        String ishavesymptomincarotidarteryinit = bean.getIshavesymptomincarotidarteryinit();
        if (!TextUtils.isEmpty(ishavesymptomincarotidarteryinit)){
            rgSymptom.check(ishavesymptomincarotidarteryinit.equals("cpc_hascas_true") ? R.id.rb_symptom_yes : R.id.rb_symptom_no );
        }

        String isnarrowinit = bean.getIsnarrowinit();
        if (!TextUtils.isEmpty(isnarrowinit)){
            rgNarrow.check(isnarrowinit.equals("cpc_bool_true") ? R.id.rb_narrow_yes : R.id.rb_narrow_no );
        }
        String evolveaddress = bean.getEvolveaddress();
        if (!TextUtils.isEmpty(evolveaddress)){
            rgProgressSite.check(evolveaddress.equals("cpc_evolveaddress_yn") ? R.id.rb_court : R.id.rb_lobby );
        }
        String isherniainit = bean.getIsherniainit();
        if (!TextUtils.isEmpty(isherniainit)){
            rgHaveCerebralHernia.check(isherniainit.equals("cpc_bool_true") ? R.id.rb_cerebral_hernia_ture : R.id.rb_cerebral_hernia_false );

        }
        String ishadruptureofaneurysminit = bean.getIshadruptureofaneurysminit();
        if (!TextUtils.isEmpty(ishadruptureofaneurysminit)){
            rgDmlpls.check(ishadruptureofaneurysminit.equals("cpc_exist_true") ? R.id.rb_dmlpls_ture : R.id.rb_dmlpls_false );

        }
        //尼莫地平治疗
        String isusenimodipineinit = bean.getIsusenimodipineinit();
        if (!TextUtils.isEmpty(isusenimodipineinit)){
            rgNmdpzl.check(isusenimodipineinit.equals("cpc_bool_true") ? R.id.rb_nmdpzl_ture : R.id.rb_nmdpzl_false );

        }
        String diagnosticresultinit = bean.getDiagnosticresultinit();
        if (!TextUtils.isEmpty(diagnosticresultinit)){
            if (diagnosticresultinit.equals("cpc_czzdjg_qxxncz")){
                esDiagnosis.setText("缺血性卒中");
                llIschemicStroke.setVisibility(View.VISIBLE);
                llHemorrhagicApoplexy.setVisibility(View.GONE);
                llOtherDiagnostic.setVisibility(View.GONE);
                llCpc.setVisibility(View.GONE);
                llIschemicStroke.requestLayout();
                if (etNosogenesis.getText().contains("其他原因所致的缺血性卒中（SOE）")) {
                    etNosogenesis.setItemData(nosogenesisList);
                } else {
                    llMoyamoyaDisease.setVisibility(View.GONE);
                }
                llSymptom.setVisibility(View.GONE);
                llDmlpl.setVisibility(View.GONE);
            }else if (diagnosticresultinit.equals("cpc_czzdjg_cxxncz")){
                esDiagnosis.setText("出血性卒中");
                llHemorrhagicApoplexy.setVisibility(View.VISIBLE);
                llIschemicStroke.setVisibility(View.GONE);
                llOtherDiagnostic.setVisibility(View.GONE);
                llDmlpl.setVisibility(View.VISIBLE);
                llCpc.setVisibility(View.VISIBLE);
                llSymptom.setVisibility(View.GONE);
            }else if (diagnosticresultinit.equals("cpc_czzdjg_fpldml")){
                esDiagnosis.setText("非破裂动脉瘤");
                llSymptom.setVisibility(View.VISIBLE);
                llDmlpl.setVisibility(View.GONE);
            }else if (diagnosticresultinit.equals("cpc_czzdjg_jbdmxzhbs")){
                esDiagnosis.setText("颈部动脉狭窄或闭塞");
                llOtherDiagnostic.setVisibility(View.VISIBLE);
                llHemorrhagicApoplexy.setVisibility(View.GONE);
                llIschemicStroke.setVisibility(View.GONE);
                llCpc.setVisibility(View.GONE);
                llSymptom.setVisibility(View.GONE);
                llDmlpl.setVisibility(View.GONE);
            }else if (diagnosticresultinit.equals("cpc_czzdjg_qtnb")){
                esDiagnosis.setText("其他");
                llIschemicStroke.setVisibility(View.GONE);
                llHemorrhagicApoplexy.setVisibility(View.GONE);
                llOtherDiagnostic.setVisibility(View.GONE);
                llCpc.setVisibility(View.GONE);
                llSymptom.setVisibility(View.GONE);
                llDmlpl.setVisibility(View.GONE);
            }
            llMoyamoyaDisease.setVisibility(View.GONE);
        }
        String pathogenesisinit = bean.getPathogenesisinit();
        if (!TextUtils.isEmpty(pathogenesisinit)){
            if (pathogenesisinit.equals("cpc_pathogenesis_laa")){
                etNosogenesis.setText("大动脉粥样硬化性卒中(LAA)");
                llMoyamoyaDisease.setVisibility(View.GONE);
            }else if (pathogenesisinit.equals("cpc_pathogenesis_ce")){
                etNosogenesis.setText("心源性脑栓塞(CE)");
                llMoyamoyaDisease.setVisibility(View.GONE);
            }else if (pathogenesisinit.equals("cpc_pathogenesis_saa")){
                etNosogenesis.setText("小动脉闭塞性卒中或腔隙性卒中(SAA)");
                llMoyamoyaDisease.setVisibility(View.GONE);
            }else if (pathogenesisinit.equals("cpc_pathogenesis_soe")){
                etNosogenesis.setText("其他原因所致的缺血性卒中(SOE)");
                llMoyamoyaDisease.setVisibility(View.VISIBLE);
            }else if (pathogenesisinit.equals("cpc_pathogenesis_sue")){
                etNosogenesis.setText("不明原因的缺血性卒中(SUE)");
                llMoyamoyaDisease.setVisibility(View.GONE);
            }
        }
        //烟雾病
        String ismoyamoyainit = bean.getIsmoyamoyainit();
        if (!TextUtils.isEmpty(ismoyamoyainit)){
            rgMoyamoyaDisease.check(ismoyamoyainit.equals("cpc_bool_true") ? R.id.rb_moyamoya_disease_yes : R.id.rb_moyamoya_disease_no );
        }
    }

    private void queryDataDiagnosticEvaluation(DiagnosticEvaluationBean entity) {

    }

    private void loadData() {
        esDiagnosis.setStringArrayId(R.array.diagnosisList);

        etIschemicStroke.setStringArrayId(R.array.ischemicStrokeList);

        etNosogenesis.setStringArrayId(R.array.nosogenesisList);

        esCxxcz.setStringArrayId(R.array.hemorrhagicApoplexyList);

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