package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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


    @BindView(R.id.rb_depart_emergency)
    RadioButton rbDepartEmergency;
    @BindView(R.id.rb_depart_eicu)
    RadioButton rbDepartEicu;
    @BindView(R.id.rg_depart_type)
    RadioGroup rgDepartType;
    @BindView(R.id.cb_jyxx_item_px)
    CheckBox cbJyxxItemPx;
    @BindView(R.id.cb_jyxx_item_nxgn)
    CheckBox cbJyxxItemNxgn;
    @BindView(R.id.cb_jyxx_item_xcg)
    CheckBox cbJyxxItemXcg;
    @BindView(R.id.cb_jyxx_item_xsh)
    CheckBox cbJyxxItemXsh;
    @BindView(R.id.cb_jyxx_item_gsgn)
    CheckBox cbJyxxItemGsgn;
    @BindView(R.id.cb_jyxx_item_xt)
    CheckBox cbJyxxItemXt;
    @BindView(R.id.cb_jyxx_item_crb)
    CheckBox cbJyxxItemCrb;
    @BindView(R.id.ll_jyxx_px)
    LinearLayout llJyxxPx;
    @BindView(R.id.ll_jyxx_nxgn)
    LinearLayout llJyxxNxgn;
    @BindView(R.id.ll_jyxx_xcg)
    LinearLayout llJyxxXcg;
    @BindView(R.id.ll_jyxx_xsh)
    LinearLayout llJyxxXsh;
    @BindView(R.id.ll_jyxx_gsgn)
    LinearLayout llJyxxGsgn;
    @BindView(R.id.ll_jyxx_xt)
    LinearLayout llJyxxXt;
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

        setCheckBoxAndLiner(cbJyxxItemCrb, llJyxxCrb);
        setCheckBoxAndLiner(cbJyxxItemGsgn, llJyxxGsgn);
        setCheckBoxAndLiner(cbJyxxItemNxgn, llJyxxNxgn);
        setCheckBoxAndLiner(cbJyxxItemPx, llJyxxPx);
        setCheckBoxAndLiner(cbJyxxItemXcg, llJyxxXcg);
        setCheckBoxAndLiner(cbJyxxItemXsh, llJyxxXsh);
        setCheckBoxAndLiner(cbJyxxItemXt, llJyxxXt);

    }

    private void setCheckBoxAndLiner( CheckBox cb, LinearLayout layout){
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                layout.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });
    }


}
