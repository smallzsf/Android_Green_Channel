package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class DiseaseTreatmentFragment extends BaseFragment {


    @BindView(R.id.awareness)
    TextView awareness;
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.breath)
    TextView breath;
    @BindView(R.id.breath_layout)
    LinearLayout breathLayout;
    @BindView(R.id.et_breath_rate_content)
    EditText etBreathRateContent;
    @BindView(R.id.unit_times_minute)
    TextView unitTimesMinute;
    @BindView(R.id.pulse)
    TextView pulse;
    @BindView(R.id.pulse_layout)
    LinearLayout pulseLayout;
    @BindView(R.id.et_pulse_content)
    EditText etPulseContent;
    @BindView(R.id.pulse_unit_times_minute)
    TextView pulseUnitTimesMinute;
    @BindView(R.id.heart_rate)
    TextView heartRate;
    @BindView(R.id.heart_rate_layout)
    LinearLayout heartRateLayout;
    @BindView(R.id.et_heart_rate_content)
    EditText etHeartRateContent;
    @BindView(R.id.heart_rate_unit_times_minute)
    TextView heartRateUnitTimesMinute;
    @BindView(R.id.systolic_blood_pressure)
    TextView systolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;
    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent;
    @BindView(R.id.systolic_blood_pressure_unit_mm_hg)
    TextView systolicBloodPressureUnitMmHg;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;
    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure_unit_mm_hg)
    TextView diastolicBloodPressureUnitMmHg;
    @BindView(R.id.blood_oxygen_saturation)
    TextView bloodOxygenSaturation;
    @BindView(R.id.blood_oxygen_saturation_layout)
    LinearLayout bloodOxygenSaturationLayout;
    @BindView(R.id.et_blood_oxygen_saturation_content)
    EditText etBloodOxygenSaturationContent;
    @BindView(R.id.blood_oxygen_saturation_unit_percent)
    TextView bloodOxygenSaturationUnitPercent;
    @BindView(R.id.body_temperature)
    TextView bodyTemperature;
    @BindView(R.id.body_temperature_layout)
    LinearLayout bodyTemperatureLayout;
    @BindView(R.id.et_body_temperature_content)
    EditText etBodyTemperatureContent;
    @BindView(R.id.body_temperature_unit_celsius)
    TextView bodyTemperatureUnitCelsius;
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
    @BindView(R.id.btn_start_frag_sg)
    AppCompatButton btnStartFragSg;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;
    private String mPatientId;
    private String mDocId;


    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_simple_respirator;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();


    public DiseaseTreatmentFragment() {

    }

    public static DiseaseTreatmentFragment newInstance(String patientId, String docId) {
        DiseaseTreatmentFragment fragment = new DiseaseTreatmentFragment();
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


//        mapVentilationSelected.put(R.id.cb_ventilation_bandage,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_neck,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_catheter,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_chest,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_fracture_out,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_limbs,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_other,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_pelvis,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_suture,false);
//        mapVentilationSelected.put(R.id.cb_ventilation_vertebra,false);


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
//        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {

    }

}