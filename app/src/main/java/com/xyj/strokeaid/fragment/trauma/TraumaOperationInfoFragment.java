package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

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
 * 手术信息
 *
 * @author Licy
 */
public class TraumaOperationInfoFragment extends BaseStrokeFragment {


    @BindView(R.id.es_pre_conscious_state)
    EditSpinner esPreConsciousState;
    @BindView(R.id.ieb_pre_breath)
    ItemEditBar iebPreBreath;
    @BindView(R.id.ieb_pre_pulse)
    ItemEditBar iebPrePulse;
    @BindView(R.id.ieb_pre_heart_rate)
    ItemEditBar iebPreHeartRate;
    @BindView(R.id.ieb_pre_high_pressure)
    ItemEditBar iebPreHighPressure;
    @BindView(R.id.ieb_pre_low_pressure)
    ItemEditBar iebPreLowPressure;
    @BindView(R.id.ieb_pre_spo2)
    ItemEditBar iebPreSpo2;
    @BindView(R.id.ieb_pre_temperature)
    ItemEditBar iebPreTemperature;
    @BindView(R.id.es_after_conscious_state)
    EditSpinner esAfterConsciousState;
    @BindView(R.id.ieb_after_breath)
    ItemEditBar iebAfterBreath;
    @BindView(R.id.ieb_after_pulse)
    ItemEditBar iebAfterPulse;
    @BindView(R.id.ieb_after_heart_rate)
    ItemEditBar iebAfterHeartRate;
    @BindView(R.id.ieb_after_high_pressure)
    ItemEditBar iebAfterHighPressure;
    @BindView(R.id.ieb_after_low_pressure)
    ItemEditBar iebAfterLowPressure;
    @BindView(R.id.ieb_after_spo2)
    ItemEditBar iebAfterSpo2;
    @BindView(R.id.ieb_after_temperature)
    ItemEditBar iebAfterTemperature;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;


    private List<RadioButton> ventilationModeList = new ArrayList();
    private int checkRadioId = R.id.rb_simple_respirator;
    private Map<Integer, Boolean> mapVentilationSelected = new HashMap<>();

    public static TraumaOperationInfoFragment newInstance(String recordId) {
        TraumaOperationInfoFragment fragment = new TraumaOperationInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_operation_info;
    }

    @Override
    protected void initView(@NonNull View view) {


        loadData();


    }

    private void loadData() {

    }


    @Override
    protected void initListener() {

    }

}