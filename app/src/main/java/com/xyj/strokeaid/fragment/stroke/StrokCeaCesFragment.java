package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * @Description: ECA
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokCeaCesFragment extends BaseFragment {


    @BindView(R.id.rb_symptom_no_fgm_cea)
    RadioButton rbSymptomNoFgmCea;
    @BindView(R.id.rb_symptom_yes_fgm_cea)
    RadioButton rbSymptomYesFgmCea;
    @BindView(R.id.ttb_start_time_fgm_cea)
    TextTimeBar ttbStartTimeFgmCea;
    @BindView(R.id.ck_local_lica_fgm_cea)
    CheckBox ckLocalLicaFgmCea;
    @BindView(R.id.ck_local_rica_fgm_cea)
    CheckBox ckLocalRicaFgmCea;
    @BindView(R.id.rb_all_anaesthesia_fgm_cea)
    RadioButton rbAllAnaesthesiaFgmCea;
    @BindView(R.id.rb_local_anaesthesia_fgm_cea)
    RadioButton rbLocalAnaesthesiaFgmCea;
    @BindView(R.id.ck_tcd_fgm_cea)
    CheckBox ckTcdFgmCea;
    @BindView(R.id.ck_ndt_fgm_cea)
    CheckBox ckNdtFgmCea;
    @BindView(R.id.ck_other_fgm_cea)
    CheckBox ckOtherFgmCea;
    @BindView(R.id.rb_bzcea_fgm_cea)
    RadioButton rbBzceaFgmCea;
    @BindView(R.id.rb_wfcea_fgm_cea)
    RadioButton rbWfceaFgmCea;
    @BindView(R.id.rb_ces_fgm_cea)
    RadioButton rbCesFgmCea;
    @BindView(R.id.rb_fhss_fgm_cea)
    RadioButton rbFhssFgmCea;
    @BindView(R.id.rb_sfcybp_yes)
    RadioButton rbSfcybpYes;
    @BindView(R.id.rb_sfcybp_no)
    RadioButton rbSfcybpNo;
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
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    public StrokCeaCesFragment() {
        // Required empty public constructor
    }

    public static StrokCeaCesFragment newInstance(String recordId) {
        StrokCeaCesFragment fragment = new StrokCeaCesFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_cea_ces;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
