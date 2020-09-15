package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.AfterOperationDrugRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.AfterOperationDrugBean;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.DiagnosticEvaluationBean;
import com.xyj.strokeaid.bean.StrokeInHosDrugBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.helper.KeyValueHelper;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.TextSwitchBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * StrokeMedicationFragment
 * description: 卒中 药物治疗 -- 住院用药
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeInHosDrugFragment extends BaseStrokeFragment {

    @BindView(R.id.tsb_antiplatelet_frag_sihd)
    TextSwitchBar tsbAntiplateletFragSihd;
    @BindView(R.id.cb_antiplatelet_1)
    CheckBox cbAntiplatelet1;
    @BindView(R.id.cb_antiplatelet_2)
    CheckBox cbAntiplatelet2;
    @BindView(R.id.cb_antiplatelet_3)
    CheckBox cbAntiplatelet3;
    @BindView(R.id.cb_antiplatelet_4)
    CheckBox cbAntiplatelet4;
    @BindView(R.id.cb_antiplatelet_5)
    CheckBox cbAntiplatelet5;
    @BindView(R.id.cb_antiplatelet_6)
    CheckBox cbAntiplatelet6;
    @BindView(R.id.cb_antiplatelet_7)
    CheckBox cbAntiplatelet7;
    @BindView(R.id.rg_antiplatelet_frag_sihd)
    RadioGroup rgrgAntiplatelet;

    @BindView(R.id.cb_anticoagulation_1)
    CheckBox cbAnticoagulation1;
    @BindView(R.id.cb_anticoagulation_2)
    CheckBox cbAnticoagulation2;
    @BindView(R.id.cb_anticoagulation_3)
    CheckBox cbAnticoagulation3;
    @BindView(R.id.cb_anticoagulation_4)
    CheckBox cbAnticoagulation4;
    @BindView(R.id.cb_anticoagulation_5)
    CheckBox cbAnticoagulation5;
    @BindView(R.id.cb_anticoagulation_6)
    CheckBox cbAnticoagulation6;
    @BindView(R.id.cb_anticoagulation_7)
    CheckBox cbAnticoagulation7;
    @BindView(R.id.cb_anticoagulation_8)
    CheckBox cbAnticoagulation8;
    @BindView(R.id.rg_anticoagulation_frag_sihd)
    RadioGroup rgAnticoagulation;

    @BindView(R.id.cb_stepdown_1)
    CheckBox cbStepdown1;
    @BindView(R.id.cb_stepdown_2)
    CheckBox cbStepdown2;
    @BindView(R.id.cb_stepdown_3)
    CheckBox cbStepdown3;
    @BindView(R.id.cb_stepdown_4)
    CheckBox cbStepdown4;
    @BindView(R.id.cb_stepdown_5)
    CheckBox cbStepdown5;
    @BindView(R.id.cb_stepdown_6)
    CheckBox cbStepdown6;

    @BindView(R.id.cb_lipid_1)
    CheckBox cbLipid1;
    @BindView(R.id.cb_lipid_2)
    CheckBox cbLipid2;
    @BindView(R.id.cb_lipid_3)
    CheckBox cbLipid3;
    @BindView(R.id.cb_lipid_4)
    CheckBox cbLipid4;
    @BindView(R.id.cb_lipid_5)
    CheckBox cbLipid5;

    @BindView(R.id.cb_sugar_1)
    CheckBox cbSugar1;
    @BindView(R.id.cb_sugar_2)
    CheckBox cbSugar2;
    @BindView(R.id.cb_sugar_3)
    CheckBox cbSugar3;
    @BindView(R.id.cb_sugar_4)
    CheckBox cbSugar4;
    @BindView(R.id.cb_sugar_5)
    CheckBox cbSugar5;
    @BindView(R.id.cb_sugar_6)
    CheckBox cbSugar6;
    @BindView(R.id.cb_sugar_7)
    CheckBox cbSugar7;

    @BindView(R.id.ll_antiplatelet_frag_sihd)
    LinearLayout llAntiplateletFragSihd;
    @BindView(R.id.tsb_anticoagulation_frag_sihd)
    TextSwitchBar tsbAnticoagulationFragSihd;
    @BindView(R.id.ll_anticoagulation_frag_sihd)
    LinearLayout llAnticoagulationFragSihd;
    @BindView(R.id.tsb_stepdown_frag_sihd)
    TextSwitchBar tsbStepDown;
    @BindView(R.id.ll_stepdown_frag_sihd)
    LinearLayout llStepDown;
    @BindView(R.id.tsb_lipid_frag_sihd)
    TextSwitchBar tsbLipid;
    @BindView(R.id.ll_lipid_frag_sihd)
    LinearLayout llLipid;
    @BindView(R.id.tsb_sugar_frag_sihd)
    TextSwitchBar tsbSugar;
    @BindView(R.id.ll_sugar_frag_sihd)
    LinearLayout llSugar;

    @BindView(R.id.rl_stroke_in_hos_drug)
    RelativeLayout rlStrokeInHosDrug;

    private StrokeInHosDrugBean bean = new StrokeInHosDrugBean();

    public StrokeInHosDrugFragment() {
        // Required empty public constructor
    }

    public static StrokeInHosDrugFragment newInstance(String recordId) {
        StrokeInHosDrugFragment fragment = new StrokeInHosDrugFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume() {
        super.onResume();

        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(rlStrokeInHosDrug, llBottom);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_in_hos_drug;
    }

    @Override
    protected void initView(@NonNull View view) {
        getAllData();
    }

    @Override
    protected void initListener() {
        rgrgAntiplatelet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_antiplatelet_frag_sihd_yes:
                        bean.setHospitalmedicationanticoagulationis48hourdose("1");
                        break;
                    case R.id.rb_antiplatelet_frag_sihd_no:
                        bean.setHospitalmedicationanticoagulationis48hourdose("-1");
                        break;
                }
            }
        });

        rgAnticoagulation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_anticoagulation_frag_sihd_yes:
                        bean.setHospitalmedicationantiplateletis48hourdose("1");
                        break;
                    case R.id.rb_anticoagulation_frag_sihd_no:
                        bean.setHospitalmedicationantiplateletis48hourdose("-1");
                        break;
                }
            }
        });

        tsbAntiplateletFragSihd.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llAntiplateletFragSihd.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                bean.setHospitalmedicationisantiplatelet(isChecked ? "1" : "-1");
            }
        });
        tsbAnticoagulationFragSihd.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llAnticoagulationFragSihd.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                bean.setHospitalmedicationisanticoagulation(isChecked ? "1" : "-1");
            }
        });

        tsbStepDown.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llStepDown.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                bean.setHospitalmedicationisbloodpressure(isChecked ? "1" : "-1");
            }
        });

        tsbLipid.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llLipid.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                bean.setHospitalmedicationislipid(isChecked ? "1" : "-1");
            }
        });


        tsbSugar.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llSugar.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                bean.setHospitalmedicationissugar(isChecked ? "1" : "-1");
            }
        });
    }

    @OnClick({
            R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                getViewData();
                break;
            default:
                break;
        }
    }

    private void getViewData() {
        /**
         * 卒中诊断 抗血小板 药物治疗
         */
        String cbAntiplatelet = KeyValueHelper.getCheckboxsKey(cbAntiplatelet1, cbAntiplatelet2, cbAntiplatelet3, cbAntiplatelet4, cbAntiplatelet5,cbAntiplatelet6,cbAntiplatelet7);
        bean.setHospitalmedicationanticoagulationdrugs(cbAntiplatelet);
        /**
         * 卒中诊断 抗凝 药物治疗
         */
        String cbAnticoagulation = KeyValueHelper.getCheckboxsKey(cbAnticoagulation1, cbAnticoagulation2, cbAnticoagulation3, cbAnticoagulation4, cbAnticoagulation5,cbAnticoagulation6,cbAnticoagulation7,cbAnticoagulation8);
        bean.setHospitalmedicationantiplateletdrugs(cbAnticoagulation);
        /**
         * 卒中诊断 降压 药物治疗
         */
        String cbStepdown = KeyValueHelper.getCheckboxsKey(cbStepdown1, cbStepdown2, cbStepdown3, cbStepdown4, cbStepdown5,cbStepdown6);
        bean.setHospitalmedicationbloodpressuredrugs(cbStepdown);
        /**
         * 卒中诊断 调指 药物治疗
         */
        String cbLipid = KeyValueHelper.getCheckboxsKey(cbLipid1, cbLipid2, cbLipid3, cbLipid4, cbLipid5);
        bean.setHospitalmedicationlipiddrugs(cbLipid);
        /**
         * 卒中诊断 降糖 药物治疗
         */
        String cbSugar = KeyValueHelper.getCheckboxsKey(cbSugar1, cbSugar2, cbSugar3, cbSugar4, cbSugar5,cbSugar6,cbSugar7);
        bean.setHospitalmedicationsugardrugs(cbSugar);
        saveData(bean);
    }

    private void saveData(StrokeInHosDrugBean bean) {
        BaseRequestBean<StrokeInHosDrugBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 1, bean);

        RequestBody resuestBody = baseRequestBean.getResuestBody(baseRequestBean);
        showLoadingDialog();
        RetrofitClient
                .getInstance()
                .getApi()
                .saveDiagnosticEvaluation(resuestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
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
                        hideLoadingDialog();
                        showToast(call.toString());
                    }
                });
    }

    private void getAllData() {
        BaseRequestBean<StrokeInHosDrugBean> requestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeInHosDrugBean());
        RetrofitClient
                .getInstance()
                .getApi()
                .getStrokeInHosDrug(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeInHosDrugBean>>() {

                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeInHosDrugBean>> call, Response<BaseResponseBean<StrokeInHosDrugBean>> response) {
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
                    public void onFailure(Call<BaseResponseBean<StrokeInHosDrugBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }

    private void dataToView(StrokeInHosDrugBean bean) {
        /**
         * 卒中诊断 抗血小板 药物治疗
         */
        String hospitalmedicationanticoagulationdrugs = bean.getHospitalmedicationanticoagulationdrugs();
        if (!TextUtils.isEmpty(hospitalmedicationanticoagulationdrugs)) {
            cbAntiplatelet1.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_aspl"));
            cbAntiplatelet2.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_lbgl"));
            cbAntiplatelet3.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_ozgl"));
            cbAntiplatelet4.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_smdm"));
            cbAntiplatelet5.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_slbd"));
            cbAntiplatelet6.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_xltc"));
            cbAntiplatelet7.setChecked(hospitalmedicationanticoagulationdrugs.contains("cpc_hospitalAntiplateletDrug_qt"));
        }
        /**
         * 卒中诊断 抗凝 药物治疗
         */
        String hospitalmedicationantiplateletdrugs = bean.getHospitalmedicationantiplateletdrugs();
        if (!TextUtils.isEmpty(hospitalmedicationantiplateletdrugs)) {
            cbAnticoagulation1.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_ffl"));
            cbAnticoagulation2.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_lfsb"));
            cbAnticoagulation3.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_dbjq"));
            cbAnticoagulation4.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_apsb"));
            cbAnticoagulation5.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_ydsb"));
            cbAnticoagulation6.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_dfzsg"));
            cbAnticoagulation7.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_ptgs"));
            cbAnticoagulation8.setChecked(hospitalmedicationantiplateletdrugs.contains("cpc_hospitalAnticoagulationDrug_qt"));
        }
        /**
         * 卒中诊断 降压 药物治疗
         */
        String hospitalmedicationbloodpressuredrugs = bean.getHospitalmedicationbloodpressuredrugs();
        if (!TextUtils.isEmpty(hospitalmedicationbloodpressuredrugs)) {
            cbStepdown1.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_acei"));
            cbStepdown2.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_arb"));
            cbStepdown3.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_lnj"));
            cbStepdown4.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_btstzzj"));
            cbStepdown5.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_gjkj"));
            cbStepdown6.setChecked(hospitalmedicationbloodpressuredrugs.contains("cpc_hospitalBloodPressureDrug_qt"));
        }
        /**
         * 卒中诊断 调指 药物治疗
         */
        String hospitalmedicationlipiddrugs = bean.getHospitalmedicationlipiddrugs();
        if (!TextUtils.isEmpty(hospitalmedicationlipiddrugs)) {
            cbLipid1.setChecked(hospitalmedicationlipiddrugs.contains("cpc_hospitalLipidDrug_tdl"));
            cbLipid2.setChecked(hospitalmedicationlipiddrugs.contains("cpc_hospitalLipidDrug_ysjqysw"));
            cbLipid3.setChecked(hospitalmedicationlipiddrugs.contains("cpc_hospitalLipidDrug_btl"));
            cbLipid4.setChecked(hospitalmedicationlipiddrugs.contains("cpc_hospitalLipidDrug_dgcxsyzj"));
            cbLipid5.setChecked(hospitalmedicationlipiddrugs.contains("cpc_hospitalLipidDrug_qt"));
        }
        /**
         * 卒中诊断 降糖 药物治疗
         */
        String hospitalmedicationsugardrugs = bean.getHospitalmedicationsugardrugs();
        if (!TextUtils.isEmpty(hospitalmedicationsugardrugs)) {
            cbSugar1.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_yds"));
            cbSugar2.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_hxnl"));
            cbSugar3.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_sgl"));
            cbSugar4.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_atgmyzj"));
            cbSugar5.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_ydszmj"));
            cbSugar6.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_fhxnlcydsfmj"));
            cbSugar7.setChecked(hospitalmedicationsugardrugs.contains("cpc_hospitalSugarDrug_qt"));
        }
        String hospitalmedicationanticoagulationis48hourdose = bean.getHospitalmedicationanticoagulationis48hourdose();
        if (!TextUtils.isEmpty(hospitalmedicationanticoagulationis48hourdose)){
            rgrgAntiplatelet.check(hospitalmedicationanticoagulationis48hourdose.equals("1") ? R.id.rb_antiplatelet_frag_sihd_yes : R.id.rb_antiplatelet_frag_sihd_no);
        }

        String hospitalmedicationantiplateletis48hourdose = bean.getHospitalmedicationantiplateletis48hourdose();
        if (!TextUtils.isEmpty(hospitalmedicationantiplateletis48hourdose)){
            rgAnticoagulation.check(hospitalmedicationantiplateletis48hourdose.equals("1") ? R.id.rb_anticoagulation_frag_sihd_yes : R.id.rb_anticoagulation_frag_sihd_no);
        }

        String hospitalmedicationisantiplatelet = bean.getHospitalmedicationisantiplatelet();
        if (!TextUtils.isEmpty(hospitalmedicationisantiplatelet)){
            boolean isChecked = hospitalmedicationisantiplatelet.equals("1");
            llAntiplateletFragSihd.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tsbAntiplateletFragSihd.setSwitch(isChecked);
        }

        String hospitalmedicationisanticoagulation = bean.getHospitalmedicationisanticoagulation();
        if (!TextUtils.isEmpty(hospitalmedicationisanticoagulation)){
            boolean isChecked = hospitalmedicationisanticoagulation.equals("1");
            llAnticoagulationFragSihd.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tsbAnticoagulationFragSihd.setSwitch(isChecked);
        }

        String hospitalmedicationisbloodpressure = bean.getHospitalmedicationisbloodpressure();
        if (!TextUtils.isEmpty(hospitalmedicationisbloodpressure)){
            boolean isChecked = hospitalmedicationisbloodpressure.equals("1");
            llStepDown.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tsbStepDown.setSwitch(isChecked);
        }

        String hospitalmedicationislipid = bean.getHospitalmedicationislipid();
        if (!TextUtils.isEmpty(hospitalmedicationislipid)){
            boolean isChecked = hospitalmedicationislipid.equals("1");
            llLipid.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tsbLipid.setSwitch(isChecked);
        }

        String hospitalmedicationissugar = bean.getHospitalmedicationissugar();
        if (!TextUtils.isEmpty(hospitalmedicationissugar)){
            boolean isChecked = hospitalmedicationissugar.equals("1");
            llSugar.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tsbSugar.setSwitch(isChecked);
        }
    }

}