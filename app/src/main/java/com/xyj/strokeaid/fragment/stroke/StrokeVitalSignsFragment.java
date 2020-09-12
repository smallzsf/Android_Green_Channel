package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;

/**
 * VitalSignsFragment
 * description: 生命体征
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeVitalSignsFragment extends BaseStrokeFragment {

    @BindView(R.id.es_conscious_state)
    EditSpinner esConsciousState;
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
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;

    public static StrokeVitalSignsFragment newInstance(String recordId) {
        StrokeVitalSignsFragment fragment = new StrokeVitalSignsFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vital_signs;
    }

    @Override
    protected void initView(@NonNull View view) {
        esConsciousState.setStringArrayId(R.array.stroke_state_of_consciousness);
    }


    @Override
    public void onResume() {
        super.onResume();
        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llVitalSigns, llBottom);

    }


    @Override
    protected void initListener() {

    }


}