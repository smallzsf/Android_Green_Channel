package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * StrokeMedicationFragment
 * description: 卒中 药物治疗 -- 出院带药
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeOutHosDrugFragment extends BaseStrokeFragment {

    @BindView(R.id.cb_pressure_frag_sohd)
    CheckBox cbPressureFragSohd;
    @BindView(R.id.et_pressure_frag_sohd)
    EditText etPressureFragSohd;
    @BindView(R.id.cb_sugar_frag_sohd)
    CheckBox cbSugarFragSohd;
    @BindView(R.id.et_sugar_frag_sohd)
    EditText etSugarFragSohd;
    @BindView(R.id.cb_fat_frag_sohd)
    CheckBox cbFatFragSohd;
    @BindView(R.id.et_fat_frag_sohd)
    EditText etFatFragSohd;
    @BindView(R.id.cb_anticoagulants_frag_sohd)
    CheckBox cbAnticoagulantsFragSohd;
    @BindView(R.id.et_anticoagulants_frag_sohd)
    EditText etAnticoagulantsFragSohd;
    @BindView(R.id.cb_antiplatelet_frag_sohd)
    CheckBox cbAntiplateletFragSohd;
    @BindView(R.id.et_antiplatelet_frag_sohd)
    EditText etAntiplateletFragSohd;
    @BindView(R.id.cb_chinese_medicine_frag_sohd)
    CheckBox cbChineseMedicineFragSohd;
    @BindView(R.id.et_chinese_medicine_frag_sohd)
    EditText etChineseMedicineFragSohd;
    @BindView(R.id.cb_other_drug_frag_sohd)
    CheckBox cbOtherDrugFragSohd;
    @BindView(R.id.et_other_drug_frag_sohd)
    EditText etOtherDrugFragSohd;
    @BindView(R.id.cb_none_frag_sohd)
    CheckBox cbNoneFragSohd;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    public StrokeOutHosDrugFragment() {
        // Required empty public constructor
    }

    public static StrokeOutHosDrugFragment newInstance(String recordId) {
        StrokeOutHosDrugFragment fragment = new StrokeOutHosDrugFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_out_hos_drug;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {
        setDrugCheckBoxListener(cbPressureFragSohd);
        setDrugCheckBoxListener(cbSugarFragSohd);
        setDrugCheckBoxListener(cbFatFragSohd);
        setDrugCheckBoxListener(cbAnticoagulantsFragSohd);
        setDrugCheckBoxListener(cbAntiplateletFragSohd);
        setDrugCheckBoxListener(cbChineseMedicineFragSohd);
        setDrugCheckBoxListener(cbOtherDrugFragSohd);
        cbNoneFragSohd.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // 清除其他选项和内容
                // 降压
                cbPressureFragSohd.setChecked(false);
                etPressureFragSohd.setText("");
                // 降糖
                cbSugarFragSohd.setChecked(false);
                etSugarFragSohd.setText("");
                // 调脂药
                cbFatFragSohd.setChecked(false);
                etFatFragSohd.setText("");
                // 抗凝
                cbAnticoagulantsFragSohd.setChecked(false);
                etAnticoagulantsFragSohd.setText("");
                // 抗血小板
                cbAntiplateletFragSohd.setChecked(false);
                etAntiplateletFragSohd.setText("");
                // 中药
                cbChineseMedicineFragSohd.setChecked(false);
                etChineseMedicineFragSohd.setText("");
                // 其他
                cbOtherDrugFragSohd.setChecked(false);
                etOtherDrugFragSohd.setText("");
            }
        });
    }

    private void setDrugCheckBoxListener(CheckBox checkBox) {
        if (checkBox == null) {
            return;
        }
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbNoneFragSohd.setChecked(false);
            }
        });
    }

    @OnClick({R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                String data = getData();
                showToast(data);
                break;
            default:
                break;
        }
    }

    private String getData() {
        if (cbNoneFragSohd.isChecked()) {
            return "选择无";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (cbPressureFragSohd.isChecked()) {
                stringBuilder.append("选择了降压药");
            }
            if (cbSugarFragSohd.isChecked()) {
                stringBuilder.append("选择了降糖药");
            }
            if (cbFatFragSohd.isChecked()) {
                stringBuilder.append("选择了调脂药");
            }
            if (cbAnticoagulantsFragSohd.isChecked()) {
                stringBuilder.append("选择了抗凝药");
            }
            if (cbAntiplateletFragSohd.isChecked()) {
                stringBuilder.append("选择了抗血小板药");
            }
            if (cbChineseMedicineFragSohd.isChecked()) {
                stringBuilder.append("选择了中药");
            }
            if (cbOtherDrugFragSohd.isChecked()) {
                stringBuilder.append("选择了其他药");
            }
            return stringBuilder.toString();
        }
    }
}