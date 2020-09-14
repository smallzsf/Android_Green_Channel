package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 发病现场
 *
 * @author Licy
 */
public class TraumaDiseaseSceneFragment extends BaseStrokeFragment {


    @BindView(R.id.rb_reason_traffic_accident)
    RadioButton rbReasonTrafficAccident;
    @BindView(R.id.rb_reason_produce_accident)
    RadioButton rbReasonProduceAccident;
    @BindView(R.id.rb_reason_height_fall)
    RadioButton rbReasonHeightFall;
    @BindView(R.id.rb_reason_suicide)
    RadioButton rbReasonSuicide;
    @BindView(R.id.rb_reason_murder)
    RadioButton rbReasonMurder;
    @BindView(R.id.rb_reason_fight)
    RadioButton rbReasonFight;
    @BindView(R.id.rb_reason_fight_group)
    RadioButton rbReasonFightGroup;
    @BindView(R.id.rb_reason_knife)
    RadioButton rbReasonKnife;
    @BindView(R.id.rb_reason_gun)
    RadioButton rbReasonGun;
    @BindView(R.id.rb_reason_other)
    RadioButton rbReasonOther;
    @BindView(R.id.et_reason_trauma_reason)
    EditText etReasonTraumaReason;
    @BindView(R.id.cb_position_head)
    CheckBox cbPositionHead;
    @BindView(R.id.cb_position_face)
    CheckBox cbPositionFace;
    @BindView(R.id.cb_position_chest)
    CheckBox cbPositionChest;
    @BindView(R.id.cb_position_belly)
    CheckBox cbPositionBelly;
    @BindView(R.id.cb_position_limb)
    CheckBox cbPositionLimb;
    @BindView(R.id.cb_position_body)
    CheckBox cbPositionBody;
    @BindView(R.id.cb_position_pelvis)
    CheckBox cbPositionPelvis;
    @BindView(R.id.cb_position_spine)
    CheckBox cbPositionSpine;
    @BindView(R.id.cb_position_other)
    CheckBox cbPositionOther;
    @BindView(R.id.et_position_trauma_part)
    EditText etPositionTraumaPart;
    @BindView(R.id.cb_injury_laceration)
    CheckBox cbInjuryLaceration;
    @BindView(R.id.cb_injury_stab)
    CheckBox cbInjuryStab;
    @BindView(R.id.cb_injury_fall)
    CheckBox cbInjuryFall;
    @BindView(R.id.cb_injury_impact)
    CheckBox cbInjuryImpact;
    @BindView(R.id.cb_injury_tumble)
    CheckBox cbInjuryTumble;
    @BindView(R.id.cb_injury_trample)
    CheckBox cbInjuryTrample;
    @BindView(R.id.cb_intrury_other)
    CheckBox cbIntruryOther;
    @BindView(R.id.et_nature_of_injury_other)
    EditText etNatureOfInjuryOther;
    @BindView(R.id.ttb_diagnose_time)
    TextTimeBar ttbDiagnoseTime;
    @BindView(R.id.et_major_complaint_frag)
    EditText etMajorComplaintFrag;

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
    @BindView(R.id.cb_fluid_infusion)
    CheckBox cbFluidInfusion;
    @BindView(R.id.cb_ventilation_way)
    CheckBox cbVentilationWay;
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
    @BindView(R.id.rb_ricothyroidotomy)
    RadioButton rbRicothyroidotomy;
    @BindView(R.id.fl_ventilation_way)
    FlowLayout flVentilationWay;
    @BindView(R.id.et_other_deal_way)
    EditText etOtherDealWay;
    @BindView(R.id.eds_treating_jie)
    EditSpinner edsTreatingJie;
    @BindView(R.id.rb_department_emergency)
    RadioButton rbDepartmentEmergency;
    @BindView(R.id.rb_department_icu)
    RadioButton rbDepartmentIcu;
    @BindView(R.id.rb_department_operation)
    RadioButton rbDepartmentOperation;
    @BindView(R.id.rb_department_specialist)
    RadioButton rbDepartmentSpecialist;
    @BindView(R.id.ll_tallransferred_to_department)
    LinearLayout llTallransferredToDepartment;
    @BindView(R.id.ll_death)
    LinearLayout llDeath;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.es_conscious_state)
    EditSpinner esConsciousState;

    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();
    private Map<String, Integer> mapNormalRadioIds = new HashMap<>();
    private Map<String, List<RadioButton>> mapRadioList = new HashMap<>();


    public static TraumaDiseaseSceneFragment newInstance(String recordId) {
        TraumaDiseaseSceneFragment fragment = new TraumaDiseaseSceneFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_disease_scene;
    }

    @Override
    protected void initView(@NonNull View view) {

        List<RadioButton> ventilationModeList = new ArrayList();

        ventilationModeList.add(rbILMA);
        ventilationModeList.add(rbNasalCatheterVentilation);
        ventilationModeList.add(rbOropharyngealVentilation);
        ventilationModeList.add(rbRicothyroidotomy);
        ventilationModeList.add(rbSimpleRespirator);

        mapRadioList.put("urgent", ventilationModeList);

        refrashRadioStatus();


        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(rbReasonKnife);
        radioButtons.add(rbReasonSuicide);
        radioButtons.add(rbReasonFight);
        radioButtons.add(rbReasonFightGroup);
        radioButtons.add(rbReasonGun);
        radioButtons.add(rbReasonHeightFall);
        radioButtons.add(rbReasonMurder);
        radioButtons.add(rbReasonOther);
        radioButtons.add(rbReasonProduceAccident);
        radioButtons.add(rbReasonTrafficAccident);
        mapRadioList.put("reason", radioButtons);

        radioButtons = new ArrayList<>();
        radioButtons.add(rbDepartmentIcu);
        radioButtons.add(rbDepartmentEmergency);
        radioButtons.add(rbDepartmentOperation);
        radioButtons.add(rbDepartmentSpecialist);
        mapRadioList.put("department", radioButtons);

        for (Map.Entry<String, List<RadioButton>> entry : mapRadioList.entrySet()) {
            List<RadioButton> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                RadioButton radioButton = value.get(i);
                radioButton.setOnClickListener(onRadioClickListener);
            }
        }
        loadData();


    }

    View.OnClickListener onRadioClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String checkKey = "";
            for (Map.Entry<String, List<RadioButton>> entry : mapRadioList.entrySet()) {
                List<RadioButton> ventilationModeList = entry.getValue();
                String key = entry.getKey();
                int checkRadioId = 0;
                boolean isChecked = false;
                for (int i = 0; i < ventilationModeList.size(); i++) {
                    RadioButton radioButton = ventilationModeList.get(i);
                    if (radioButton == null) {
                        continue;
                    }
                    if (radioButton.getId() == view.getId()) {
                        isChecked = true;
                        break;
                    }
                }
                if (isChecked) {
                    checkKey = key;
                    break;
                }
            }
            mapNormalRadioIds.put(checkKey, view.getId());

            refrashRadioStatus();
        }
    };

    private void refrashRadioStatus() {

        for (Map.Entry<String, List<RadioButton>> entry : mapRadioList.entrySet()) {
            List<RadioButton> ventilationModeList = entry.getValue();
            String key = entry.getKey();
            int checkRadioId = 0;
            if (mapNormalRadioIds.containsKey(key)) {
                checkRadioId = mapNormalRadioIds.get(key);
            }
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


    }

    private void loadData() {

        ArrayList<String> data = new ArrayList<>();
        data.add("转入本院");
        data.add("转入其它医院");
        data.add("死亡");
        edsTreatingJie.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                refrashEdsTreatingJieStatus(text);
            }
        });
        refrashEdsTreatingJieStatus("转入本院");
        edsTreatingJie.setItemData(data);
    }

    private void refrashEdsTreatingJieStatus(String text) {
        llDeath.setVisibility(View.VISIBLE);
        llTallransferredToDepartment.setVisibility(View.VISIBLE);
        if (TextUtils.equals("转入本院", text)) {
            llDeath.setVisibility(View.GONE);
        } else if (TextUtils.equals("转入其它医院", text)) {
            llDeath.setVisibility(View.GONE);
            llTallransferredToDepartment.setVisibility(View.GONE);
        } else {
            llTallransferredToDepartment.setVisibility(View.GONE);
        }
    }


    @Override
    protected void initListener() {
        rbReasonOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                etReasonTraumaReason.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbIntruryOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                etNatureOfInjuryOther.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        cbPositionOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                etPositionTraumaPart.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
    }

}