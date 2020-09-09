package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
public class ChestPainOtherTretmentFragment extends BaseFragment {


    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
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
    @BindView(R.id.tv_death_reason_num)
    TextView tvDeathReasonNum;
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
    @BindView(R.id.es_transfer_depart)
    EditSpinner esTransferDepart;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.tv_transfer_num)
    TextView tvTransferNum;
    @BindView(R.id.ttb_leave_own_hos_time)
    TextTimeBar ttbLeaveOwnHosTime;
    @BindView(R.id.et_transfer_hos_name)
    EditText etTransferHosName;
    @BindView(R.id.rb_net_hos_yes)
    RadioButton rbNetHosYes;
    @BindView(R.id.rb_net_hos_no)
    RadioButton rbNetHosNo;
    @BindView(R.id.rg_net_hos)
    RadioGroup rgNetHos;
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
    @BindView(R.id.et_refuse_reason)
    EditText etRefuseReason;
    @BindView(R.id.tv_refuse_reason_num)
    TextView tvRefuseReasonNum;
    @BindView(R.id.ll_family_refuse_reason)
    LinearLayout llFamilyRefuseReason;
    @BindView(R.id.rb_transfer_pci_yes)
    RadioButton rbTransferPciYes;
    @BindView(R.id.rb_transfer_pci_no)
    RadioButton rbTransferPciNo;
    @BindView(R.id.rg_transfer_pci)
    RadioGroup rgTransferPci;

    LinearLayout mLinearLayoutOutHos;
    LinearLayout mLinearLayoutOutOtherHos;
    LinearLayout mLinearLayoutOutOtherDepart;
    LinearLayout mLinearLayoutOutDeath;

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

    private OtherTreatmentBean mOtherTreatmentBean;
    private String mRecordId;
    private HashMap<String, String> mSuagrDrugMap;
    private HashMap<String, String> mAntiDrugMap;
    private HashMap<String, String> mPcsk9DrugMap;
    List<String> sugarKey;
    List<String> sugarValue;

    public ChestPainOtherTretmentFragment() {

    }

    public static ChestPainOtherTretmentFragment newInstance(String recordId) {
        ChestPainOtherTretmentFragment fragment = new ChestPainOtherTretmentFragment();
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
        List<String> antiKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_anticoagulant_key));
        List<String> antiValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_anticoagulant_value));
        mAntiDrugMap = new HashMap<>(antiKey.size());
        for (int i = 0; i < antiKey.size(); i++) {
            mAntiDrugMap.put(antiValue.get(i), antiKey.get(i));
        }
        esAnticoagulant.setItemData(antiValue);
        // pcsk9
        List<String> pcskKey = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_pcsk9_key));
        List<String> pcskValue = Arrays.asList(getResources().getStringArray(R.array.chest_pain_in_hos_usage_drug_pcsk9_value));
        mPcsk9DrugMap = new HashMap<>(pcskKey.size());
        for (int i = 0; i < pcskKey.size(); i++) {
            mPcsk9DrugMap.put(pcskValue.get(i), pcskKey.get(i));
        }
        esPcsk9DrugName.setItemData(pcskValue);
    }


    @Override
    protected void initListener() {
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
        String isinhospitalhypoglycemicdrug = bean.getIsinhospitalhypoglycemicdrug();
        if (!TextUtils.isEmpty(isinhospitalhypoglycemicdrug)) {
            if (TextUtils.equals(isinhospitalhypoglycemicdrug, Constants.BOOL_TRUE)) {
                rgSugar.check(R.id.rb_sugar_yes);
                llBloodSugarDrug.setVisibility(View.VISIBLE);

                String inhospitalhypoglycemicdrugname = bean.getInhospitalhypoglycemicdrugname();
                if (!TextUtils.isEmpty(inhospitalhypoglycemicdrugname)) {

                }


            } else if (TextUtils.equals(isinhospitalhypoglycemicdrug, Constants.BOOL_FALSE)) {
                rgSugar.check(R.id.rb_sugar_no);
            }
        }

    }

    private void getViewData() {
        if (mOtherTreatmentBean == null) {
            mOtherTreatmentBean = new OtherTreatmentBean();
        }
        mOtherTreatmentBean.setRecordId(mRecordId);


        saveViewData();
    }


}
