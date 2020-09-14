package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 急诊救治
 *
 * @author Licy
 */
public class TraumaEmergencyTreatmentFragment extends BaseStrokeFragment {

    @BindView(R.id.ieb_breath)
    ItemEditBar iebBreath;
    @BindView(R.id.ieb_pulse)
    ItemEditBar iebPulse;
    @BindView(R.id.ieb_heart_rate)
    ItemEditBar iebHeartRate;
    @BindView(R.id.ieb_high_pressure)
    ItemEditBar iebHighPressure;
    @BindView(R.id.ieb_low_pressure)
    ItemEditBar iebLowPressure;
    @BindView(R.id.ieb_spo2)
    ItemEditBar iebSpo2;
    @BindView(R.id.ieb_temperature)
    ItemEditBar iebTemperature;
    @BindView(R.id.cb_ventilation_bandage)
    CheckBox cbVentilationBandage;
    @BindView(R.id.cb_ventilation_limbs)
    CheckBox cbVentilationLimbs;
    @BindView(R.id.cb_ventilation_chest)
    CheckBox cbVentilationChest;
    @BindView(R.id.cb_ventilation_pelvis)
    CheckBox cbVentilationPelvis;
    @BindView(R.id.cb_ventilation_neck)
    CheckBox cbVentilationNeck;
    @BindView(R.id.cb_ventilation_vertebra)
    CheckBox cbVentilationVertebra;
    @BindView(R.id.cb_ventilation_fracture_out)
    CheckBox cbVentilationFractureOut;
    @BindView(R.id.cb_ventilation_suture)
    CheckBox cbVentilationSuture;
    @BindView(R.id.cb_ventilation_catheter)
    CheckBox cbVentilationCatheter;
    @BindView(R.id.cb_ventilation_other)
    CheckBox cbVentilationOther;
    @BindView(R.id.ll_fluid_infusion)
    LinearLayout llFluidInfusion;
    @BindView(R.id.rb_simple_respirator)
    RadioButton rbSimpleRespirator;
    @BindView(R.id.rb_ILMA)
    RadioButton rbILMA;
    @BindView(R.id.rb_nasal_catheter_ventilation)
    RadioButton rbNasalCatheterVentilation;
    @BindView(R.id.rb_oropharyngeal_ventilation)
    RadioButton rbOropharyngealVentilation;
    @BindView(R.id.rb_nasotracheal_tube)
    RadioButton rbNasotrachealTube;
    @BindView(R.id.rb_orotracheal_intubation)
    RadioButton rbOrotrachealIntubation;
    @BindView(R.id.rb_tracheotomy)
    RadioButton rbTracheotomy;
    @BindView(R.id.rb_ricothyroidotomy)
    RadioButton rbRicothyroidotomy;
    @BindView(R.id.et_other_deal_way)
    EditText etOtherDealWay;
    @BindView(R.id.rb_blood_transfusion)
    RadioButton rbBloodTransfusion;
    @BindView(R.id.rb_blood_transfusion_no)
    RadioButton rbBloodTransfusionNo;
    @BindView(R.id.rg_blood_transfusion)
    RadioGroup rgBloodTransfusion;
    @BindView(R.id.rb_artificial_to)
    RadioButton rbArtificialTo;
    @BindView(R.id.rb_artificial_to_no)
    RadioButton rbArtificialToNo;
    @BindView(R.id.rg_artificial_to)
    RadioGroup rgArtificialTo;
    @BindView(R.id.rb_closed_thoracic_drainage)
    RadioButton rbClosedThoracicDrainage;
    @BindView(R.id.rb_closed_thoracic_drainage_no)
    RadioButton rbClosedThoracicDrainageNo;
    @BindView(R.id.rg_closed_thoracic_drainage)
    RadioGroup rgClosedThoracicDrainage;
    @BindView(R.id.rb_pelvic_girdle)
    RadioButton rbPelvicGirdle;
    @BindView(R.id.rb_pelvic_girdle_no)
    RadioButton rbPelvicGirdleNo;
    @BindView(R.id.rg_pelvic_girdle)
    RadioGroup rgPelvicGirdle;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.es_conscious_state)
    EditSpinner esConsciousState;
    @BindView(R.id.cb_chest_puncture)
    CheckBox cbChestPuncture;
    @BindView(R.id.cb_abdominal_puncture)
    CheckBox cbAbdominalPuncture;
    @BindView(R.id.rb_chest_solidify_yes)
    RadioButton rbChestSolidifyYes;
    @BindView(R.id.rb_chest_solidify_no)
    RadioButton rbChestSolidifyNo;
    @BindView(R.id.rg_chest)
    RadioGroup rgChest;
    @BindView(R.id.ll_chest_puncture)
    LinearLayout llChestPuncture;
    @BindView(R.id.rb_abdominal_solidify_yes)
    RadioButton rbAbdominalSolidifyYes;
    @BindView(R.id.rb_abdominal_solidify_no)
    RadioButton rbAbdominalSolidifyNo;
    @BindView(R.id.rg_abdominal)
    RadioGroup rgAbdominal;
    @BindView(R.id.ll_abdominal_puncture)
    LinearLayout llAbdominalPuncture;
    @BindView(R.id.cb_fluid_infusion)
    CheckBox cbFluidInfusion;
    @BindView(R.id.cb_ventilation_way)
    CheckBox cbVentilationWay;
    @BindView(R.id.ll_ventilation_way)
    LinearLayout llVentilationWay;
    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_simple_respirator;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();


    public static TraumaEmergencyTreatmentFragment newInstance(String recordId) {
        TraumaEmergencyTreatmentFragment fragment = new TraumaEmergencyTreatmentFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_disease_treatment;
    }

    @Override
    protected void initView(@NonNull View view) {


        ventilationModeList.add(rbNasotrachealTube);
        ventilationModeList.add(rbILMA);
        ventilationModeList.add(rbNasalCatheterVentilation);
        ventilationModeList.add(rbOropharyngealVentilation);
        ventilationModeList.add(rbOrotrachealIntubation);
        ventilationModeList.add(rbRicothyroidotomy);
        ventilationModeList.add(rbTracheotomy);
        ventilationModeList.add(rbSimpleRespirator);

        for (int i = 0; i < ventilationModeList.size(); i++) {
            RadioButton radioButton = ventilationModeList.get(i);
            radioButton.setOnClickListener(onRadioClickListener);
        }
        refrashRadioStatus();


        loadData();


    }

    View.OnClickListener onRadioClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkRadioId = view.getId();
            refrashRadioStatus();
        }
    };

    private void refrashRadioStatus() {

        for (int i = 0; i < ventilationModeList.size(); i++) {
            RadioButton radioButton = ventilationModeList.get(i);
            if (radioButton == null) {
                continue;
            }
            if (radioButton.getId() == checkRadioId) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    private void loadData() {

        List<String> list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
        esConsciousState.setItemData(list);
    }


    @Override
    protected void initListener() {
        cbFluidInfusion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llFluidInfusion.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbVentilationWay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llVentilationWay.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbChestPuncture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llChestPuncture.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbAbdominalPuncture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llAbdominalPuncture.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbVentilationOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                etOtherDealWay.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
    }

}