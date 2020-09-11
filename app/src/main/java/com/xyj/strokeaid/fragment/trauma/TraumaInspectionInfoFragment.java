package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import butterknife.BindView;

/**
 * 创伤检验信息页面  血液检查
 *
 * @author Licy
 */
public class TraumaInspectionInfoFragment extends BaseStrokeFragment {


    @BindView(R.id.cb_fluid_infusion)
    CheckBox cbFluidInfusion;
    @BindView(R.id.cb_chest_puncture)
    CheckBox cbChestPuncture;
    @BindView(R.id.cb_abdominal_puncture)
    CheckBox cbAbdominalPuncture;
    @BindView(R.id.cb_ventilation_way)
    CheckBox cbVentilationWay;
    @BindView(R.id.ll_jyxx_xcg)
    LinearLayout llJyxxXcg;
    @BindView(R.id.ll_jyxx_nxsx)
    LinearLayout llJyxxNxsx;
    @BindView(R.id.ll_jyxx_xsh)
    LinearLayout llJyxxXsh;
    @BindView(R.id.ll_jyxx_crb)
    LinearLayout llJyxxCrb;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    public static TraumaInspectionInfoFragment newInstance(String recordId) {
        TraumaInspectionInfoFragment fragment = new TraumaInspectionInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_inspection_information;
    }

    @Override
    protected void initView(@NonNull View view) {


    }


    @Override
    protected void initListener() {

    }


}
