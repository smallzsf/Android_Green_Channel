package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.RequestGetVitalSigns;
import com.xyj.strokeaid.bean.trauma.TraumaOutcomeBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 患者转归
 *
 * @author Licy
 */
public class TraumaPatientOutcomeFragment extends BaseStrokeFragment {


    @BindView(R.id.rb_leave_hospital)
    RadioButton rbLeaveHospital;
    @BindView(R.id.rb_transform_hospital)
    RadioButton rbTransformHospital;
    @BindView(R.id.rb_transform_department)
    RadioButton rbTransformDepartment;
    @BindView(R.id.rb_die)
    RadioButton rbDie;
    @BindView(R.id.ieb_live_hos_days)
    ItemEditBar iebLiveHosDays;
    @BindView(R.id.ieb_live_icu_days)
    ItemEditBar iebLiveIcuDays;
    @BindView(R.id.ieb_breath_machine_times)
    ItemEditBar iebBreathMachineTimes;
    @BindView(R.id.ieb_total_cost)
    ItemEditBar iebTotalCost;
    @BindView(R.id.ttb_leave_hospital)
    TextTimeBar ttbLeaveHospital;
    @BindView(R.id.rb_result_ok)
    RadioButton rbResultOk;
    @BindView(R.id.rb_result_better)
    RadioButton rbResultBetter;
    @BindView(R.id.rb_leave_self)
    RadioButton rbLeaveSelf;
    @BindView(R.id.rb_result_other)
    RadioButton rbResultOther;
    @BindView(R.id.ll_leavehospital)
    LinearLayout llLeavehospital;
    @BindView(R.id.ttb_leave_hospital_door)
    TextTimeBar ttbLeaveHospitalDoor;
    @BindView(R.id.ieb_hos_name)
    ItemEditBar iebHosName;
    @BindView(R.id.rb_nethospital_true)
    RadioButton rbNethospitalTrue;
    @BindView(R.id.rb_nethospital_flase)
    RadioButton rbNethospitalFlase;
    @BindView(R.id.rg_is_net)
    RadioGroup rgIsNet;
    @BindView(R.id.ll_transferhospital)
    LinearLayout llTransferhospital;
    @BindView(R.id.ttb_transfer_department)
    TextTimeBar ttbTransferDepartment;
    @BindView(R.id.ll_transferdepartment)
    LinearLayout llTransferdepartment;
    @BindView(R.id.ttb_die_date)
    TextTimeBar ttbDieDate;
    @BindView(R.id.ll_die)
    LinearLayout llDie;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.ieb_receiving_department)
    ItemEditBar iebReceivingDepartment;
    @BindView(R.id.ieb_reason)
    ItemEditBar iebReason;
    @BindView(R.id.ieb_place_death)
    ItemEditBar iebPlaceDeath;
    @BindView(R.id.ieb_death_reason)
    ItemEditBar iebDeathReason;
    private List<RadioButton> outcomeList = new ArrayList();
    private int checkRadioId = R.id.rb_die;
    /**
     * 治疗结果
     */
    private List<RadioButton> resutList = new ArrayList();
    private int resutcheckRadioId = R.id.rb_result_ok;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();

    private List<RadioButton> netList = new ArrayList();
    private int netcheckRadioId = R.id.rb_net_hos_yes;
    private String mRecordId;

    private TraumaOutcomeBean traumaOutcomeBean;

    public TraumaPatientOutcomeFragment() {

    }

    public static TraumaPatientOutcomeFragment newInstance(String recordId) {
        TraumaPatientOutcomeFragment fragment = new TraumaPatientOutcomeFragment();
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
            traumaOutcomeBean = new TraumaOutcomeBean();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_patient_outcome;
    }

    @Override
    protected void initView(@NonNull View view) {
        outcomeList.add(rbLeaveHospital);
        outcomeList.add(rbTransformHospital);
        outcomeList.add(rbTransformDepartment);
        outcomeList.add(rbDie);
        for (int i = 0; i < outcomeList.size(); i++) {
            RadioButton radioButton = outcomeList.get(i);
            radioButton.setOnClickListener(onRadioClickListener);
        }
        resutList.add(rbResultOk);
        resutList.add(rbResultBetter);
        resutList.add(rbLeaveSelf);
        resutList.add(rbResultOther);
        for (int i = 0; i < resutList.size(); i++) {
            RadioButton radioButton = resutList.get(i);
            radioButton.setOnClickListener(resultClickListener);
        }
        netList.add(rbNethospitalTrue);
        netList.add(rbNethospitalFlase);
        for (int i = 0; i < netList.size(); i++) {
            RadioButton radioButton = netList.get(i);
            radioButton.setOnClickListener(netClickListener);
        }

        loadData();
    }

    View.OnClickListener onRadioClickListener = view -> {
        checkRadioId = view.getId();
        refrashRadioStatus();
    };
    View.OnClickListener resultClickListener = view -> {
        resutcheckRadioId = view.getId();
        refrashresultStatus();
    };
    View.OnClickListener netClickListener = view -> {
        netcheckRadioId = view.getId();
    };
    private void refrashresultStatus() {
        for (int i = 0; i < resutList.size(); i++) {
            RadioButton radioButton = resutList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == resutcheckRadioId) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    /**
     * 主页面回复状态
     */
    private void refrashRadioStatus() {
        for (int i = 0; i < outcomeList.size(); i++) {
            RadioButton radioButton = outcomeList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == checkRadioId) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        llDie.setVisibility(View.GONE);
        llLeavehospital.setVisibility(View.GONE);
        llTransferdepartment.setVisibility(View.GONE);
        llTransferhospital.setVisibility(View.GONE);
        switch (checkRadioId) {
            case R.id.rb_leave_hospital:
                llLeavehospital.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_transform_hospital:
                llTransferhospital.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_transform_department:
                llTransferdepartment.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_die:
                llDie.setVisibility(View.VISIBLE);
                break;
        }

    }

    private void loadData() {
        showLoadingDialog();
        BaseRequestBean<TraumaOutcomeBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 3, new TraumaOutcomeBean());

        RetrofitClient.getInstance()
                .getApi()
                .getStrokeVitalSignsInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<RequestGetVitalSigns>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<RequestGetVitalSigns>> call,
                                           Response<BaseResponseBean<RequestGetVitalSigns>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<RequestGetVitalSigns>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    @Override
    protected void initListener() {
        btnSave.setOnClickListener(view -> {
            getTraumaOutcomeData();
        });
    }

    private void getTraumaOutcomeData() {


        traumaOutcomeBean.setOutcomelengthstay(iebLiveHosDays.getEditContent());
        traumaOutcomeBean.setOutcomeicudays(iebLiveIcuDays.getEditContent());
        traumaOutcomeBean.setOutcomerespiratorduration(iebBreathMachineTimes.getEditContent());
        traumaOutcomeBean.setOutcomeallincost(iebTotalCost.getEditContent());
        traumaOutcomeBean.setOutcomedischargetime(ttbLeaveHospital.getTime());
        traumaOutcomeBean.setOutcometransferleaveourcollegetime(ttbLeaveHospitalDoor.getTime());
        traumaOutcomeBean.setOutcometransferhospitalname(iebHosName.getEditContent());
        traumaOutcomeBean.setOutcometransferdepartmenttime(ttbTransferDepartment.getTime());
        traumaOutcomeBean.setOutcomereceivingdepartment(iebReceivingDepartment.getEditContent());
        traumaOutcomeBean.setTransferdepartmentreason(iebReason.getEditContent());
        traumaOutcomeBean.setOutcomeplacedeath(iebPlaceDeath.getEditContent());
        traumaOutcomeBean.setOutcomedeathtime(ttbDieDate.getTime());
        traumaOutcomeBean.setOutcomedeathreason(iebDeathReason.getEditContent());
        Log.e("TAG", "getTraumaOutcomeData: "+new Gson().toJson(traumaOutcomeBean));
        saveTraumaOutcome();
    }

    private void saveTraumaOutcome() {
        BaseRequestBean<TraumaOutcomeBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 3, traumaOutcomeBean);

        RetrofitClient.getInstance().getApi()
                .saveStrokeTrigaeInfo(baseRequestBean.getResuestBody(baseRequestBean))
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

    @OnClick({R.id.rb_leave_hospital, R.id.rb_transform_hospital, R.id.rb_transform_department, R.id.rb_die
            , R.id.rb_result_ok, R.id.rb_result_better, R.id.rb_leave_self, R.id.rb_result_other, R.id.rb_nethospital_true, R.id.rb_nethospital_flase})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_leave_hospital:
                traumaOutcomeBean.setOutcomepatients("1");
                break;
            case R.id.rb_transform_hospital:
                traumaOutcomeBean.setOutcomepatients("2");
                break;
            case R.id.rb_transform_department:
                traumaOutcomeBean.setOutcomepatients("3");
                break;
            case R.id.rb_die:
                traumaOutcomeBean.setOutcomepatients("4");
                break;
            case R.id.rb_result_ok:
                traumaOutcomeBean.setOutcometherapeuticoutcome("1");
                break;
            case R.id.rb_result_better:
                traumaOutcomeBean.setOutcometherapeuticoutcome("2");
                break;
            case R.id.rb_leave_self:
                traumaOutcomeBean.setOutcometherapeuticoutcome("3");
                break;
            case R.id.rb_result_other:
                traumaOutcomeBean.setOutcometherapeuticoutcome("4");
                break;
            case R.id.rb_nethospital_true:
                traumaOutcomeBean.setOutcomenetworkhospital("1");
                break;
            case R.id.rb_nethospital_flase:
                traumaOutcomeBean.setOutcomenetworkhospital("2");
                break;
        }
    }


}