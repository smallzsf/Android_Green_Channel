package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;

/**
 * @ClassName: PatientSumFragment
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/2 19:10
 */
public class PatientSumFragment extends BaseFragment {


    @BindView(R.id.es_title_select)
    EditSpinner esTitleSelect;
    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.ttb_confirm_time)
    TextTimeBar ttbConfirmTime;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rb_rg_heart_failure_yes)
    RadioButton rbRgHeartFailureYes;
    @BindView(R.id.rb_rg_heart_failure_no)
    RadioButton rbRgHeartFailureNo;
    @BindView(R.id.rg_heart_failure)
    RadioGroup rgHeartFailure;
    @BindView(R.id.cb_setmi_1)
    CheckBox cbSetmi1;
    @BindView(R.id.cb_setmi_2)
    CheckBox cbSetmi2;
    @BindView(R.id.cb_setmi_3)
    CheckBox cbSetmi3;
    @BindView(R.id.cb_setmi_4)
    CheckBox cbSetmi4;
    @BindView(R.id.cb_setmi_5)
    CheckBox cbSetmi5;
    @BindView(R.id.cb_setmi_6)
    CheckBox cbSetmi6;
    @BindView(R.id.cb_setmi_7)
    CheckBox cbSetmi7;
    @BindView(R.id.cb_setmi_8)
    CheckBox cbSetmi8;
    @BindView(R.id.cb_setmi_9)
    CheckBox cbSetmi9;
    @BindView(R.id.cb_setmi_10)
    CheckBox cbSetmi10;
    @BindView(R.id.cb_setmi_11)
    CheckBox cbSetmi11;
    @BindView(R.id.cb_setmi_12)
    CheckBox cbSetmi12;
    @BindView(R.id.ll_stemi)
    LinearLayout llStemi;
    @BindView(R.id.cb_non_acs_5)
    CheckBox cbNonAcs5;
    @BindView(R.id.cb_non_acs_6)
    CheckBox cbNonAcs6;
    @BindView(R.id.cb_non_acs_7)
    CheckBox cbNonAcs7;
    @BindView(R.id.cb_non_acs_8)
    CheckBox cbNonAcs8;
    @BindView(R.id.cb_non_acs_9)
    CheckBox cbNonAcs9;
    @BindView(R.id.cb_non_acs_24)
    CheckBox cbNonAcs24;
    @BindView(R.id.cb_non_acs_10)
    CheckBox cbNonAcs10;
    @BindView(R.id.cb_non_acs_11)
    CheckBox cbNonAcs11;
    @BindView(R.id.cb_non_acs_12)
    CheckBox cbNonAcs12;
    @BindView(R.id.cb_non_acs_13)
    CheckBox cbNonAcs13;
    @BindView(R.id.cb_non_acs_14)
    CheckBox cbNonAcs14;
    @BindView(R.id.cb_non_acs_15)
    CheckBox cbNonAcs15;
    @BindView(R.id.cb_non_acs_16)
    CheckBox cbNonAcs16;
    @BindView(R.id.cb_non_acs_17)
    CheckBox cbNonAcs17;
    @BindView(R.id.cb_non_acs_18)
    CheckBox cbNonAcs18;
    @BindView(R.id.cb_non_acs_19)
    CheckBox cbNonAcs19;
    @BindView(R.id.cb_non_acs_20)
    CheckBox cbNonAcs20;
    @BindView(R.id.cb_non_acs_23)
    CheckBox cbNonAcs23;
    @BindView(R.id.cb_non_acs_1)
    CheckBox cbNonAcs1;
    @BindView(R.id.cb_non_acs_2)
    CheckBox cbNonAcs2;
    @BindView(R.id.cb_non_acs_3)
    CheckBox cbNonAcs3;
    @BindView(R.id.cb_non_acs_4)
    CheckBox cbNonAcs4;
    @BindView(R.id.cb_non_acs_21)
    CheckBox cbNonAcs21;
    @BindView(R.id.cb_non_acs_22)
    CheckBox cbNonAcs22;
    @BindView(R.id.ll_non_acs)
    LinearLayout llNonAcs;
    @BindView(R.id.cb_non_heart_1)
    CheckBox cbNonHeart1;
    @BindView(R.id.cb_non_heart_2)
    CheckBox cbNonHeart2;
    @BindView(R.id.cb_non_heart_3)
    CheckBox cbNonHeart3;
    @BindView(R.id.cb_non_heart_4)
    CheckBox cbNonHeart4;
    @BindView(R.id.cb_non_heart_5)
    CheckBox cbNonHeart5;
    @BindView(R.id.cb_non_heart_6)
    CheckBox cbNonHeart6;
    @BindView(R.id.cb_non_heart_7)
    CheckBox cbNonHeart7;
    @BindView(R.id.ll_non_heart)
    LinearLayout llNonHeart;

    public static PatientSumFragment newInstance(String patientId, String docId) {
        PatientSumFragment fragment = new PatientSumFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_patient_sum;
    }

    @Override
    protected void initView(@NonNull View view) {
        esTitleSelect.setItemData(Arrays.asList(Constants.CHEST_PAIN_DIAGNOSE_CONTENT));
    }

    @Override
    protected void initListener() {
        esTitleSelect.setOnSelectIndexAndStringLitner(new EditSpinner.OnSelectIndexAndStringLitner() {
            @Override
            public void getSeletedStringAndIndex(String text, int position) {
                if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[0])
                        || TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[1])
                        || TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[2])) {
                    llStemi.setVisibility(View.VISIBLE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.GONE);
                } else if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[5])) {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.VISIBLE);
                    llNonHeart.setVisibility(View.GONE);
                } else if (TextUtils.equals(text, Constants.CHEST_PAIN_DIAGNOSE_CONTENT[6])) {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.VISIBLE);
                } else {
                    llStemi.setVisibility(View.GONE);
                    llNonAcs.setVisibility(View.GONE);
                    llNonHeart.setVisibility(View.GONE);
                }
            }
        });
    }

}
