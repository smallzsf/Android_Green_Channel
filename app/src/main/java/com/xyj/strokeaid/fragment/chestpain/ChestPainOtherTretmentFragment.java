package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.chestpain.OtherTreatmentBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.KeyValueHelper;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 胸痛其他处置
 * @Date: 2020/9/4 20:05
 */
public class ChestPainOtherTretmentFragment extends BaseStrokeFragment {

    @BindView(R.id.rb_sugar_yes)
    RadioButton rbSugarYes;
    @BindView(R.id.rb_sugar_no)
    RadioButton rbSugarNo;
    @BindView(R.id.rg_sugar)
    RadioGroup rgSugar;
    @BindView(R.id.es_sugar)
    EditSpinner esSugar;
    @BindView(R.id.ll_blood_sugar_drug)
    LinearLayout llBloodSugarDrug;
    @BindView(R.id.rb_anticoagulant_yes)
    RadioButton rbAnticoagulantYes;
    @BindView(R.id.rb_anticoagulant_no)
    RadioButton rbAnticoagulantNo;
    @BindView(R.id.rg_anticoagulant)
    RadioGroup rgAnticoagulant;
    @BindView(R.id.es_anticoagulant)
    EditSpinner esAnticoagulant;
    @BindView(R.id.ll_anticoagulant_drug)
    LinearLayout llAnticoagulantDrug;
    @BindView(R.id.rb_pcsk9_yes)
    RadioButton rbPcsk9Yes;
    @BindView(R.id.rb_pcsk9_no)
    RadioButton rbPcsk9No;
    @BindView(R.id.rg_pcsk9)
    RadioGroup rgPcsk9;
    @BindView(R.id.es_pcsk9_drug_name)
    EditSpinner esPcsk9DrugName;
    @BindView(R.id.ll_pcks9_drug)
    LinearLayout llPcks9Drug;
    @BindView(R.id.ieb_pcsk9_dose)
    ItemEditBar iebPcsk9Dose;
    @BindView(R.id.ieb_in_hos_days)
    ItemEditBar iebInHosDays;
    @BindView(R.id.ieb_in_hos_total_cost)
    ItemEditBar iebInHosTotalCost;
    @BindView(R.id.rb_patient_out_hos)
    RadioButton rbPatientOutHos;
    @BindView(R.id.rb_patient_out_other_hos)
    RadioButton rbPatientOutOtherHos;
    @BindView(R.id.rb_patient_out_other_depart)
    RadioButton rbPatientOutOtherDepart;
    @BindView(R.id.rb_patient_out_death)
    RadioButton rbPatientOutDeath;
    @BindView(R.id.rg_patient_out)
    MyRadioGroup rgPatientOut;
    @BindView(R.id.ll_leave_hospital_said)
    LinearLayout llLeaveHospitalSaid;
    @BindView(R.id.ttb_death_time)
    TextTimeBar ttbDeathTime;
    @BindView(R.id.rb_death_reason_heart)
    RadioButton rbDeathReasonHeart;
    @BindView(R.id.rb_death_reason_not_heart)
    RadioButton rbDeathReasonNotHeart;
    @BindView(R.id.rg_death_reason)
    RadioGroup rgDeathReason;
    @BindView(R.id.et_death_reason)
    EditText etDeathReason;
    @BindView(R.id.ttb_out_hos_time)
    TextTimeBar ttbOutHosTime;
    @BindView(R.id.rb_treat_result_cure)
    RadioButton rbTreatResultCure;
    @BindView(R.id.rb_treat_result_better)
    RadioButton rbTreatResultBetter;
    @BindView(R.id.rb_treat_result_leave_self)
    RadioButton rbTreatResultLeaveSelf;
    @BindView(R.id.rb_treat_result_other)
    RadioButton rbTreatResultOther;
    @BindView(R.id.rg_treat_result)
    MyRadioGroup rgTreatResult;
    @BindView(R.id.ttb_transfer_time)
    TextTimeBar ttbTransferTime;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.tv_transfer_num)
    TextView tvTransferNum;
    @BindView(R.id.ttb_leave_own_hos_time)
    TextTimeBar ttbLeaveOwnHosTime;
    @BindView(R.id.rb_net_hos_yes)
    RadioButton rbNetHosYes;
    @BindView(R.id.rb_net_hos_no)
    RadioButton rbNetHosNo;
    @BindView(R.id.rg_net_hos)
    RadioGroup rgNetHos;
    @BindView(R.id.rb_transfer_pci_yes)
    RadioButton rbTransferPciYes;
    @BindView(R.id.rb_transfer_pci_no)
    RadioButton rbTransferPciNo;
    @BindView(R.id.rg_transfer_pci)
    RadioGroup rgTransferPci;
    @BindView(R.id.rb_conduit_room_yes)
    RadioButton rbConduitRoomYes;
    @BindView(R.id.rb_conduit_room_no)
    RadioButton rbConduitRoomNo;
    @BindView(R.id.rg_conduit_room)
    RadioGroup rgConduitRoom;
    @BindView(R.id.ttb_real_pci_start_time)
    TextTimeBar ttbRealPciStartTime;
    @BindView(R.id.rb_remote_heart_yes)
    RadioButton rbRemoteHeartYes;
    @BindView(R.id.rb_remote_heart_no)
    RadioButton rbRemoteHeartNo;
    @BindView(R.id.rg_remote_heart)
    RadioGroup rgRemoteHeart;
    @BindView(R.id.ttb_remote_heart_time)
    TextTimeBar ttbRemoteHeartTime;
    @BindView(R.id.es_remote_heart_way)
    EditSpinner esRemoteHeartWay;
    @BindView(R.id.ll_remote_heart_yes)
    LinearLayout llRemoteHeartYes;
    @BindView(R.id.rb_image_24h_yes)
    RadioButton rbImage24hYes;
    @BindView(R.id.rb_image_24h_no)
    RadioButton rbImage24hNo;
    @BindView(R.id.rg_image_24h)
    RadioGroup rgImage24h;
    @BindView(R.id.ttb_image_24h_time)
    TextTimeBar ttbImage24hTime;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.cb_lyxc_jy)
    CheckBox cbLyxcJy;
    @BindView(R.id.cb_lyxc_gljcfy)
    CheckBox cbLyxcGljcfy;
    @BindView(R.id.cb_lyxc_jyzsfzl)
    CheckBox cbLyxcJyzsfzl;
    @BindView(R.id.cb_lyxc_shqjth)
    CheckBox cbLyxcShqjth;
    @BindView(R.id.cb_lyxc_xxgwxyskz)
    CheckBox cbLyxcXxgwxyskz;
    @BindView(R.id.cb_lyxc_wxj)
    CheckBox cbLyxcWxj;
    @BindView(R.id.ieb_transfer_depart_name)
    ItemEditBar iebTransferDepartName;
    @BindView(R.id.ieb_transfer_hos_name)
    ItemEditBar iebTransferHosName;
    private OtherTreatmentBean mOtherTreatmentBean;
    private HashMap<String, String> mSuagrDrugMap;
    private HashMap<String, String> mAntiDrugMap;
    private HashMap<String, String> mPcsk9DrugMap;
    private HashMap<String, String> mTreatmentResultMap;
    private List<String> sugarKey;
    private List<String> sugarValue;
    private List<String> antiKey;
    private List<String> antiValue;
    private List<String> pcskKey;
    private List<String> pcskValue;
    private List<String> prognosisResultKey;
    private List<String> prognosisResultValue;
    private List<String> treatmentResultKey;
    private List<String> treatmentResultValue;

    private LinearLayout mLinearLayoutOutHos;
    private LinearLayout mLinearLayoutOutOtherHos;
    private LinearLayout mLinearLayoutOutOtherDepart;
    private LinearLayout mLinearLayoutOutDeath;


    public static ChestPainOtherTretmentFragment newInstance(String recordId) {
        ChestPainOtherTretmentFragment fragment = new ChestPainOtherTretmentFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadViewData(mRecordId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chest_pain_other_treatment;
    }

    @Override
    protected void initView(@NonNull View view) {
        mLinearLayoutOutDeath = view.findViewById(R.id.include_pain_in_dead);
        mLinearLayoutOutHos = view.findViewById(R.id.include_pain_in_leave_hospital);
        mLinearLayoutOutOtherHos = view.findViewById(R.id.include_pain_in_transfer_hospital);
        mLinearLayoutOutOtherDepart = view.findViewById(R.id.include_pain_in_transfer_department);

        // 设置输入框输入类型
        iebInHosDays.getEtRoot().setInputType(InputType.TYPE_CLASS_NUMBER);
        iebInHosTotalCost.getEtRoot().setInputType(InputType.TYPE_CLASS_NUMBER);

        initLocalData();
    }

    private void initLocalData() {
        // 降糖药
        sugarKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_sugar_key));
        sugarValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_sugar_value));
        mSuagrDrugMap = new HashMap<>(sugarKey.size());
        for (int i = 0; i < sugarKey.size(); i++) {
            mSuagrDrugMap.put(sugarValue.get(i), sugarKey.get(i));
        }
        esSugar.setItemData(sugarValue);
        // 抗凝药
        antiKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_anticoagulant_key));
        antiValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_anticoagulant_value));
        mAntiDrugMap = new HashMap<>(antiKey.size());
        for (int i = 0; i < antiKey.size(); i++) {
            mAntiDrugMap.put(antiValue.get(i), antiKey.get(i));
        }
        esAnticoagulant.setItemData(antiValue);
        // pcsk9
        pcskKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_pcsk9_key));
        pcskValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_pcsk9_value));
        mPcsk9DrugMap = new HashMap<>(pcskKey.size());
        for (int i = 0; i < pcskKey.size(); i++) {
            mPcsk9DrugMap.put(pcskValue.get(i), pcskKey.get(i));
        }
        esPcsk9DrugName.setItemData(pcskValue);

        prognosisResultKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_prognosis_result_key));
        prognosisResultValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_prognosis_result_value));

        treatmentResultKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_treatment_result_key));
        treatmentResultValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_treatment_result_value));
//        mTreatmentResultMap = new HashMap<>(treatmentResultKey.size());
//        for (int i = 0; i < treatmentResultKey.size(); i++) {
//            mTreatmentResultMap.put(treatmentResultKey.get(i), treatmentResultValue.get(i));
//        }


    }


    @Override
    protected void initListener() {

        btnSave.setOnClickListener(v -> getViewData());

        rgSugar.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_sugar_yes) {
                llBloodSugarDrug.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_sugar_no) {
                llBloodSugarDrug.setVisibility(View.GONE);
            }
        });

        rgAnticoagulant.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_anticoagulant_yes) {
                llAnticoagulantDrug.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_anticoagulant_no) {
                llAnticoagulantDrug.setVisibility(View.GONE);
            }
        });

        rgPcsk9.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_pcsk9_yes) {
                llPcks9Drug.setVisibility(View.VISIBLE);
                iebPcsk9Dose.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_pcsk9_no) {
                llPcks9Drug.setVisibility(View.GONE);
                iebPcsk9Dose.setVisibility(View.GONE);
            }
        });

        rgPatientOut.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_patient_out_hos) {
                    mLinearLayoutOutHos.setVisibility(View.VISIBLE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_other_hos) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.VISIBLE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_other_depart) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.VISIBLE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_death) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.VISIBLE);
                }
            }
        });

        cbLyxcWxj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbLyxcJy.setChecked(false);
                    cbLyxcGljcfy.setChecked(false);
                    cbLyxcJyzsfzl.setChecked(false);
                    cbLyxcShqjth.setChecked(false);
                    cbLyxcXxgwxyskz.setChecked(false);
                }
            }
        });

        CompoundButton.OnCheckedChangeListener onWxjListener = (buttonView, isChecked) -> {
            if (isChecked) {
                cbLyxcWxj.setChecked(false);
            }
        };
        cbLyxcJy.setOnCheckedChangeListener(onWxjListener);
        cbLyxcGljcfy.setOnCheckedChangeListener(onWxjListener);
        cbLyxcJyzsfzl.setOnCheckedChangeListener(onWxjListener);
        cbLyxcShqjth.setOnCheckedChangeListener(onWxjListener);
        cbLyxcXxgwxyskz.setOnCheckedChangeListener(onWxjListener);
    }

    private void loadViewData(String recordId) {
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient.getInstance()
                .getApi()
                .getChestPainOtherTreatment(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<OtherTreatmentBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<OtherTreatmentBean>> call, Response<BaseObjectBean<OtherTreatmentBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mOtherTreatmentBean = response.body().getData();
                                if (mOtherTreatmentBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    setViewData(mOtherTreatmentBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<OtherTreatmentBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 默认 databean 不为null 且有数据
     */
    private void saveViewData() {
        showLoadingDialog();
        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainOtherTreatment(mOtherTreatmentBean.getResuestBody(mOtherTreatmentBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    private void setViewData(OtherTreatmentBean bean) {
        if (bean == null) {
            return;
        }
        // 住院用药
        setDrugViews(bean);
        // 出院信息
        setLeaveHosViews(bean);

    }

    private void setDrugViews(OtherTreatmentBean bean) {
        // 降糖
        String isinhospitalhypoglycemicdrug = bean.getIsinhospitalhypoglycemicdrug();
        if (!TextUtils.isEmpty(isinhospitalhypoglycemicdrug)) {
            if (TextUtils.equals(isinhospitalhypoglycemicdrug, Constants.BOOL_TRUE)) {
                rgSugar.check(R.id.rb_sugar_yes);
                llBloodSugarDrug.setVisibility(View.VISIBLE);
                // 降糖用药
                String inhospitalhypoglycemicdrugname = bean.getInhospitalhypoglycemicdrugname();
                if (!TextUtils.isEmpty(inhospitalhypoglycemicdrugname)) {
                    String valueByKey = KeyValueHelper.getValueByKey(sugarKey, sugarValue, inhospitalhypoglycemicdrugname);
                    esSugar.setText(valueByKey);
                }
            } else if (TextUtils.equals(isinhospitalhypoglycemicdrug, Constants.BOOL_FALSE)) {
                rgSugar.check(R.id.rb_sugar_no);
            }
        }
        // 抗凝
        String isinhospitaloralanticoagulant = bean.getIsinhospitaloralanticoagulant();
        if (!TextUtils.isEmpty(isinhospitaloralanticoagulant)) {
            if (TextUtils.equals(isinhospitaloralanticoagulant, Constants.BOOL_TRUE)) {
                rgAnticoagulant.check(R.id.rb_anticoagulant_yes);
                llAnticoagulantDrug.setVisibility(View.VISIBLE);
                // 抗凝用药
                String inhospitaloralanticoagulantname = bean.getInhospitaloralanticoagulantname();
                if (!TextUtils.isEmpty(inhospitaloralanticoagulantname)) {
                    String valueByKey = KeyValueHelper.getValueByKey(antiKey, antiValue, inhospitaloralanticoagulantname);
                    esAnticoagulant.setText(valueByKey);
                }
            } else if (TextUtils.equals(isinhospitaloralanticoagulant, Constants.BOOL_FALSE)) {
                rgAnticoagulant.check(R.id.rb_anticoagulant_no);
            }
        }
        // pcsk9
        String isinhospitalpcsk9 = bean.getIsinhospitalpcsk9();
        if (!TextUtils.isEmpty(isinhospitalpcsk9)) {
            if (TextUtils.equals(isinhospitalpcsk9, Constants.BOOL_TRUE)) {
                rgPcsk9.check(R.id.rb_pcsk9_yes);
                llPcks9Drug.setVisibility(View.VISIBLE);
                // pcsk9用药
                String inhospitalpcsk9name = bean.getInhospitalpcsk9name();
                if (!TextUtils.isEmpty(inhospitalpcsk9name)) {
                    String valueByKey = KeyValueHelper.getValueByKey(pcskKey, pcskValue, inhospitalpcsk9name);
                    esPcsk9DrugName.setText(valueByKey);
                }
                // 剂量
                iebPcsk9Dose.setEditContent(bean.getInhospitalpcsk9singledose());
            } else if (TextUtils.equals(isinhospitalpcsk9, Constants.BOOL_FALSE)) {
                rgPcsk9.check(R.id.rb_pcsk9_no);
            }
        }
    }

    private void setLeaveHosViews(OtherTreatmentBean bean) {
        // 住院天数
        iebInHosDays.setEditContent(bean.getNumberofdaysinhospital());
        // 总费用
        iebInHosTotalCost.setEditContent(bean.getTotalcostinhospital());
        // 离院宣传
        String missioneducation = bean.getMissioneducation();
        if (!TextUtils.isEmpty(missioneducation)) {
            if (missioneducation.contains(cbLyxcWxj.getTag().toString())) {
                cbLyxcWxj.setChecked(true);
            } else {
                cbLyxcJy.setChecked(missioneducation.contains(cbLyxcJy.getTag().toString()));
                cbLyxcGljcfy.setChecked(missioneducation.contains(cbLyxcGljcfy.getTag().toString()));
                cbLyxcJyzsfzl.setChecked(missioneducation.contains(cbLyxcJyzsfzl.getTag().toString()));
                cbLyxcShqjth.setChecked(missioneducation.contains(cbLyxcShqjth.getTag().toString()));
                cbLyxcXxgwxyskz.setChecked(missioneducation.contains(cbLyxcXxgwxyskz.getTag().toString()));
            }
        }
        // 患者转归
        String prognosisresult = bean.getPrognosisresult();
        if (!TextUtils.isEmpty(prognosisresult)) {
            for (int i = 0; i < prognosisResultKey.size(); i++) {
                if (TextUtils.equals(prognosisresult, prognosisResultKey.get(i))) {
                    if (i == 0) {
                        rgPatientOut.check(R.id.rb_patient_out_hos);
                        setpatientOutHosViews(bean);
                    } else if (i == 1) {
                        rgPatientOut.check(R.id.rb_patient_out_other_hos);
                        setpatientOutOtherHosViews(bean);
                    } else if (i == 2) {
                        rgPatientOut.check(R.id.rb_patient_out_other_depart);
                        setpatientOutOtherDepartViews(bean);
                    } else if (i == 3) {
                        rgPatientOut.check(R.id.rb_patient_out_death);
                        setpatientOutDeathViews(bean);
                    }
                    break;
                }
            }
        }
    }

    /**
     * 转归 -- 出院
     *
     * @param bean
     */
    private void setpatientOutHosViews(OtherTreatmentBean bean) {
        // 出院时间
        ttbOutHosTime.setTime(bean.getLeavehospitaltime());
        // 治疗结果
        String treatmentresult = bean.getTreatmentresult();
        if (!TextUtils.isEmpty(treatmentresult)) {
            for (int i = 0; i < treatmentResultKey.size(); i++) {
                if (TextUtils.equals(treatmentresult, treatmentResultKey.get(i))) {
                    if (i == 0) {
                        rgTreatResult.check(R.id.rb_treat_result_cure);
                    } else if (i == 1) {
                        rgTreatResult.check(R.id.rb_treat_result_better);
                    } else if (i == 2) {
                        rgTreatResult.check(R.id.rb_treat_result_leave_self);
                    } else if (i == 3) {
                        rgTreatResult.check(R.id.rb_treat_result_other);
                    }
                    break;
                }
            }
        }

    }

    /**
     * 转归 -- 转院
     *
     * @param bean
     */
    private void setpatientOutOtherHosViews(OtherTreatmentBean bean) {
        // 离开本院时间
        ttbLeaveOwnHosTime.setTime(bean.getLeavehospitaltime());
        // 医院名称
        iebTransferHosName.setEditContent(bean.getHospitalnametransto());
        // 网络医院
        String isgriddinghospitaltransto = bean.getIsgriddinghospitaltransto();
        if (!TextUtils.isEmpty(isgriddinghospitaltransto)) {
            if (TextUtils.equals(isgriddinghospitaltransto, Constants.BOOL_TRUE)) {
                rgNetHos.check(R.id.rb_net_hos_yes);
            } else if (TextUtils.equals(isgriddinghospitaltransto, Constants.BOOL_FALSE)) {
                rgNetHos.check(R.id.rb_net_hos_no);
            }
        }
        // 转运PCI
        String istransforpci = bean.getIstransforpci();
        if (!TextUtils.isEmpty(istransforpci)) {
            if (TextUtils.equals(istransforpci, Constants.BOOL_TRUE)) {
                rgTransferPci.check(R.id.rb_transfer_pci_yes);
                // 直达导管室
                String istranstopciroom = bean.getIstranstopciroom();
                if (!TextUtils.isEmpty(istranstopciroom)) {
                    if (TextUtils.equals(istranstopciroom, Constants.BOOL_TRUE)) {
                        rgConduitRoom.check(R.id.rb_conduit_room_yes);
                    } else if (TextUtils.equals(istranstopciroom, Constants.BOOL_FALSE)) {
                        rgConduitRoom.check(R.id.rb_conduit_room_no);
                    }
                }
                // 实际介入开始时间
                ttbRealPciStartTime.setTime(bean.getZypcibegintime());
            } else if (TextUtils.equals(istransforpci, Constants.BOOL_FALSE)) {
                rgTransferPci.check(R.id.rb_transfer_pci_no);
            }
        }
        // 远程心电
        String remoteecgtrans = bean.getRemoteecgtrans();
        if (!TextUtils.isEmpty(remoteecgtrans)) {
            if (TextUtils.equals(remoteecgtrans, "cpc_remoteecgtrans_xzdw")) {
                rgRemoteHeart.check(R.id.rb_remote_heart_yes);
                // 传输心电图至协作单位时间
                ttbRemoteHeartTime.setTime(bean.getZypciremotetransmissiontime());
                // 传输方式
                String zypciremotetransmissionwaynew = bean.getZypciremotetransmissionwaynew();
                if (!TextUtils.isEmpty(zypciremotetransmissionwaynew)) {
                    if (zypciremotetransmissionwaynew.contains("cpc_transway_timemonitor")) {
                        esRemoteHeartWay.setText("实时监控");
                    } else if (zypciremotetransmissionwaynew.contains("cpc_transway_wechat")) {
                        esRemoteHeartWay.setText("微信群");
                    } else if (zypciremotetransmissionwaynew.contains("cpc_transway_other")) {
                        esRemoteHeartWay.setText("其他");
                    }
                }
            } else if (TextUtils.equals(remoteecgtrans, "cpc_remoteecgtrans_none")) {
                rgRemoteHeart.check(R.id.rb_remote_heart_no);
            }
        }
        // 溶栓后24h造影
        String angiographyafter24hthrombolysis = bean.getAngiographyafter24hthrombolysis();
        if (!TextUtils.isEmpty(angiographyafter24hthrombolysis)) {
            if (TextUtils.equals(angiographyafter24hthrombolysis, Constants.BOOL_TRUE)) {
                rgImage24h.check(R.id.rb_image_24h_yes);
            } else if (TextUtils.equals(angiographyafter24hthrombolysis, Constants.BOOL_FALSE)) {
                rgImage24h.check(R.id.rb_image_24h_no);
            }
        }
        // 造影开始时间
        ttbImage24hTime.setTime(bean.getAngiographybegintime());

    }

    /**
     * 转归 -- 转科
     *
     * @param bean
     */
    private void setpatientOutOtherDepartViews(OtherTreatmentBean bean) {
        // 转科时间
        ttbTransferTime.setTime(bean.getTransdepartmenttime());
        // 接诊科室
        iebTransferDepartName.setEditContent(bean.getTreatmentresult());
        // 转科原因
        etTransferReason.setText(bean.getTransdepartmentreason());
    }

    /**
     * 转归 -- 死亡
     *
     * @param bean
     */
    private void setpatientOutDeathViews(OtherTreatmentBean bean) {
        // 死亡时间
        ttbDeathTime.setTime(bean.getDeathtime());
        // 死亡原因
        String deathreason = bean.getDeathreason();
        if (TextUtils.isEmpty(deathreason)) {
            if (deathreason.equals("cpc_swyy_xyx")) {
                rgDeathReason.check(R.id.rb_death_reason_heart);
            } else if (deathreason.equals("cpc_swyy_fxyx")) {
                rgDeathReason.check(R.id.rb_death_reason_not_heart);
            }
        }
        // 死亡
        etDeathReason.setText(bean.getDeathdecriptioin());
    }

    private void getViewData() {
        if (mOtherTreatmentBean == null) {
            mOtherTreatmentBean = new OtherTreatmentBean();
        }
        mOtherTreatmentBean.setRecordId(mRecordId);
        // 用药
        // 降糖
        if (rgSugar.getCheckedRadioButtonId() == R.id.rb_sugar_yes) {
            mOtherTreatmentBean.setIsinhospitalhypoglycemicdrug(Constants.BOOL_TRUE);
            String keyByValue = KeyValueHelper.getKeyByValue(sugarKey, sugarValue, esSugar.getText());
            mOtherTreatmentBean.setInhospitalhypoglycemicdrugname(keyByValue);
        } else {
            mOtherTreatmentBean.setIsinhospitalhypoglycemicdrug(Constants.BOOL_FALSE);
        }
        // 抗凝
        if (rgAnticoagulant.getCheckedRadioButtonId() == R.id.rb_anticoagulant_yes) {
            mOtherTreatmentBean.setIsinhospitaloralanticoagulant(Constants.BOOL_TRUE);
            String keyByValue = KeyValueHelper.getKeyByValue(antiKey, antiValue, esAnticoagulant.getText());
            mOtherTreatmentBean.setInhospitaloralanticoagulantname(keyByValue);
        } else {
            mOtherTreatmentBean.setIsinhospitaloralanticoagulant(Constants.BOOL_FALSE);
        }
        // pcsk9
        if (rgPcsk9.getCheckedRadioButtonId() == R.id.rb_pcsk9_yes) {
            mOtherTreatmentBean.setIsinhospitalpcsk9(Constants.BOOL_TRUE);
            String keyByValue = KeyValueHelper.getKeyByValue(pcskKey, pcskValue, esPcsk9DrugName.getText());
            mOtherTreatmentBean.setInhospitalpcsk9name(keyByValue);
            mOtherTreatmentBean.setInhospitalpcsk9singledose(iebPcsk9Dose.getEditContent());
        } else {
            mOtherTreatmentBean.setIsinhospitalpcsk9(Constants.BOOL_FALSE);
        }
        // 出院信息
        // 住院天数
        mOtherTreatmentBean.setNumberofdaysinhospital(iebInHosDays.getEditContent());
        // 总费用
        mOtherTreatmentBean.setTotalcostinhospital(iebInHosTotalCost.getEditContent());
        // 离院宣教
        if (cbLyxcWxj.isChecked()) {
            mOtherTreatmentBean.setMissioneducation("cpc_missioneducation_wxj");
        } else {
            String checkBoxValue = KeyValueHelper.getCheckboxsKey(cbLyxcXxgwxyskz, cbLyxcShqjth, cbLyxcGljcfy, cbLyxcJy, cbLyxcJyzsfzl);
            mOtherTreatmentBean.setMissioneducation(checkBoxValue);
        }
        // 患者转归
        if (rgPatientOut.getCheckedRadioButtonId() == R.id.rb_patient_out_hos) {
            // 出院
            mOtherTreatmentBean.setPrognosisresult(prognosisResultKey.get(0));
            mOtherTreatmentBean.setDischargedtime(ttbOutHosTime.getTime());
            int checkedRadioButtonId = rgTreatResult.getCheckedRadioButtonId();
            RadioButton viewById = mActivity.findViewById(checkedRadioButtonId);
            mOtherTreatmentBean.setTreatmentresult(viewById.getTag().toString());
        } else if (rgPatientOut.getCheckedRadioButtonId() == R.id.rb_patient_out_other_hos) {
            // 转其他医院
            mOtherTreatmentBean.setPrognosisresult(prognosisResultKey.get(1));
            mOtherTreatmentBean.setLeavehospitaltime(ttbLeaveOwnHosTime.getTime());
            mOtherTreatmentBean.setHospitalnametransto(iebTransferHosName.getEditContent());
            mOtherTreatmentBean.setIsgriddinghospitaltransto(
                    rgNetHos.getCheckedRadioButtonId() == R.id.rb_net_hos_yes ? Constants.BOOL_TRUE : Constants.BOOL_FALSE);
            mOtherTreatmentBean.setIstransforpci(
                    rgTransferPci.getCheckedRadioButtonId() == R.id.rb_transfer_pci_yes ? Constants.BOOL_TRUE : Constants.BOOL_FALSE);
            mOtherTreatmentBean.setIstranstopciroom(
                    rgConduitRoom.getCheckedRadioButtonId() == R.id.rb_conduit_room_yes ? Constants.BOOL_TRUE : Constants.BOOL_FALSE);
            mOtherTreatmentBean.setZypcibegintime(ttbRealPciStartTime.getTime());
            mOtherTreatmentBean.setRemoteecgtrans(
                    rgRemoteHeart.getCheckedRadioButtonId() == R.id.rb_remote_heart_yes ? "cpc_remoteecgtrans_xzdw" : "cpc_remoteecgtrans_none");
            mOtherTreatmentBean.setZypciremotetransmissiontime(ttbRemoteHeartTime.getTime());
            if (TextUtils.equals(esRemoteHeartWay.getText(), "实时监控")) {
                mOtherTreatmentBean.setZypciremotetransmissionwaynew("cpc_transway_timemonitor");
            } else if (TextUtils.equals(esRemoteHeartWay.getText(), "微信群")) {
                mOtherTreatmentBean.setZypciremotetransmissionwaynew("cpc_transway_wechat");
            } else if (TextUtils.equals(esRemoteHeartWay.getText(), "其他")) {
                mOtherTreatmentBean.setZypciremotetransmissionwaynew("cpc_transway_other");
            }
            mOtherTreatmentBean.setAngiographyafter24hthrombolysis(
                    rgImage24h.getCheckedRadioButtonId() == R.id.rb_image_24h_yes ? Constants.BOOL_TRUE : Constants.BOOL_FALSE);
            mOtherTreatmentBean.setAngiographybegintime(ttbImage24hTime.getTime());
        } else if (rgPatientOut.getCheckedRadioButtonId() == R.id.rb_patient_out_other_depart) {
            // 转其他科
            mOtherTreatmentBean.setPrognosisresult(prognosisResultKey.get(2));
            mOtherTreatmentBean.setTransdepartmenttime(ttbTransferTime.getTime());
            mOtherTreatmentBean.setDepartmenttransto(iebTransferDepartName.getEditContent());
            mOtherTreatmentBean.setTransdepartmentreason(etTransferReason.getText().toString());
        } else if (rgPatientOut.getCheckedRadioButtonId() == R.id.rb_patient_out_death) {
            // 死亡
            mOtherTreatmentBean.setPrognosisresult(prognosisResultKey.get(3));
            mOtherTreatmentBean.setDeathtime(ttbDeathTime.getTime());
            mOtherTreatmentBean.setDeathdecriptioin(etDeathReason.getText().toString());
            mOtherTreatmentBean.setDeathreason(rgDeathReason.getCheckedRadioButtonId() == R.id.rb_death_reason_heart
                    ? "cpc_swyy_xyx" : "cpc_swyy_fxyx");
        }
        saveViewData();
    }


}
