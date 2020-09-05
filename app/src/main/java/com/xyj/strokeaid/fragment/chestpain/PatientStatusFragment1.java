package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class PatientStatusFragment1 extends BaseFragment implements OnDateSetListener {
    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;
    @BindView(R.id.tv_draw_blood_time)
    TextTimeBar mTvDrawBloodTime;
    @BindView(R.id.give_up_cure)
    TextView mGiveUpCure;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton mRbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton mRbCtFragAe;
    @BindView(R.id.rb_cta_frag_ae)
    RadioButton mRbCtaFragAe;
    @BindView(R.id.rb_ctp_frag_ae)
    RadioButton mRbCtpFragAe;
    @BindView(R.id.rb_mri_frag_ae)
    RadioButton mRbMriFragAe;
    @BindView(R.id.rb_mra_frag_ae)
    RadioButton mRbMraFragAe;
    @BindView(R.id.rb_cemra_frag_ae)
    RadioButton mRbCemraFragAe;
    @BindView(R.id.rb_cvus_frag_ae)
    RadioButton mRbCvusFragAe;
    @BindView(R.id.rb_tcd_frag_ae)
    RadioButton mRbTcdFragAe;
    @BindView(R.id.rg_yn)
    RadioGroup mRgYn;
    @BindView(R.id.tv_nyha_label)
    TextView mTvNyhaLabel;
    @BindView(R.id.rb_nyha_1)
    RadioButton mRbNyha1;
    @BindView(R.id.rb_nyha_2)
    RadioButton mRbNyha2;
    @BindView(R.id.rb_nyha_3)
    RadioButton mRbNyha3;
    @BindView(R.id.rb_nyha_4)
    RadioButton mRbNyha4;
    @BindView(R.id.ll_nyha)
    LinearLayout mLlNyha;
    @BindView(R.id.cb_text_1)
    CheckBox mCbText1;
    @BindView(R.id.cb_text_2)
    CheckBox mCbText2;
    @BindView(R.id.cb_text_3)
    CheckBox mCbText3;
    @BindView(R.id.cb_text_4)
    CheckBox mCbText4;
    @BindView(R.id.cb_text_5)
    CheckBox mCbText5;
    @BindView(R.id.cb_text_6)
    CheckBox mCbText6;
    @BindView(R.id.cb_text_7)
    CheckBox mCbText7;
    @BindView(R.id.cb_text_8)
    CheckBox mCbText8;
    @BindView(R.id.cb_text_9)
    CheckBox mCbText9;
    @BindView(R.id.cb_text_10)
    CheckBox mCbText10;
    @BindView(R.id.cb_text_11)
    CheckBox mCbText11;
    @BindView(R.id.cb_text_12)
    CheckBox mCbText12;
    @BindView(R.id.tv_bp_label)
    TextView mTvBpLabel;
    @BindView(R.id.tv_bp_no)
    RadioButton mTvBpNo;
    @BindView(R.id.tv_bp_yes)
    RadioButton mTvBpYes;
    @BindView(R.id.tv_bf_label)
    TextView mTvBfLabel;
    @BindView(R.id.tv_bf_no)
    RadioButton mTvBfNo;
    @BindView(R.id.tv_bf_yes)
    RadioButton mTvBfYes;
    @BindView(R.id.tv_diabetic_label)
    TextView mTvDiabeticLabel;
    @BindView(R.id.tv_diabetic_no)
    RadioButton mTvDiabeticNo;
    @BindView(R.id.tv_diabetic_yes)
    RadioButton mTvDiabeticYes;
    @BindView(R.id.tv_smoke_label)
    TextView mTvSmokeLabel;
    @BindView(R.id.tv_smoke_no)
    RadioButton mTvSmokeNo;
    @BindView(R.id.tv_smoke_yes)
    RadioButton mTvSmokeYes;
    @BindView(R.id.tv_smoke_status_label)
    TextView mTvSmokeStatusLabel;
    @BindView(R.id.tv_smoke_status_yes)
    RadioButton mTvSmokeStatusYes;
    @BindView(R.id.tv_smoke_status_no)
    RadioButton mTvSmokeStatusNo;
    @BindView(R.id.tv_fat_label)
    TextView mTvFatLabel;
    @BindView(R.id.tv_fat_no)
    RadioButton mTvFatNo;
    @BindView(R.id.tv_fat_yes)
    RadioButton mTvFatYes;
    @BindView(R.id.tv_cvd_label)
    TextView mTvCvdLabel;
    @BindView(R.id.tv_cvd_no)
    RadioButton mTvCvdNo;
    @BindView(R.id.tv_cvd_yes)
    RadioButton mTvCvdYes;
    @BindView(R.id.tv_chd_label)
    TextView mTvChdLabel;
    @BindView(R.id.tv_chd_no)
    RadioButton mTvChdNo;
    @BindView(R.id.tv_chd_yes)
    RadioButton mTvChdYes;
    @BindView(R.id.rg_chd)
    RadioGroup mRgChd;
    @BindView(R.id.tv_xy_label)
    TextView mTvXyLabel;
    @BindView(R.id.tv_xy_no)
    RadioButton mTvXyNo;
    @BindView(R.id.tv_xy_yes)
    RadioButton mTvXyYes;
    @BindView(R.id.rg_xy)
    RadioGroup mRgXy;
    @BindView(R.id.ll_xy)
    LinearLayout mLlXy;
    @BindView(R.id.tv_xf_label)
    TextView mTvXfLabel;
    @BindView(R.id.tv_xf_no)
    RadioButton mTvXfNo;
    @BindView(R.id.tv_xf_yes)
    RadioButton mTvXfYes;
    @BindView(R.id.rg_xf)
    RadioGroup mRgXf;
    @BindView(R.id.ll_xf)
    LinearLayout mLlXf;
    @BindView(R.id.tv_fx_label)
    TextView mTvFxLabel;
    @BindView(R.id.tv_fx_1)
    RadioButton mTvFx1;
    @BindView(R.id.tv_fx_2)
    RadioButton mTvFx2;
    @BindView(R.id.tv_fx_3)
    RadioButton mTvFx3;
    @BindView(R.id.tv_fx_4)
    RadioButton mTvFx4;
    @BindView(R.id.ll_fx)
    LinearLayout mLlFx;
    @BindView(R.id.tv_slow_label)
    TextView mTvSlowLabel;
    @BindView(R.id.tv_slow_no)
    RadioButton mTvSlowNo;
    @BindView(R.id.tv_slow_yes)
    RadioButton mTvSlowYes;
    @BindView(R.id.rg_slow)
    RadioGroup mRgSlow;
    @BindView(R.id.tv_factor_nyha_label)
    TextView mTvFactorNyhaLabel;
    @BindView(R.id.rb_factor_nyha_1)
    RadioButton mRbFactorNyha1;
    @BindView(R.id.rb_factor_nyha_2)
    RadioButton mRbFactorNyha2;
    @BindView(R.id.rb_factor_nyha_3)
    RadioButton mRbFactorNyha3;
    @BindView(R.id.rb_factor_nyha_4)
    RadioButton mRbFactorNyha4;
    @BindView(R.id.ll_factor_nyha)
    LinearLayout mLlFactorNyha;
    @BindView(R.id.tv_bm_label)
    TextView mTvBmLabel;
    @BindView(R.id.tv_bm_no)
    RadioButton mTvBmNo;
    @BindView(R.id.tv_bm_yes)
    RadioButton mTvBmYes;
    @BindView(R.id.tv_stroke_label)
    TextView mTvStrokeLabel;
    @BindView(R.id.tv_stroke_no)
    RadioButton mTvStrokeNo;
    @BindView(R.id.tv_stroke_yes)
    RadioButton mTvStrokeYes;
    @BindView(R.id.rg_stroke)
    RadioGroup mRgStroke;
    @BindView(R.id.tv_desc_label)
    TextView mTvDescLabel;
    @BindView(R.id.tv_desc_no)
    RadioButton mTvDescNo;
    @BindView(R.id.tv_desc_yes)
    RadioButton mTvDescYes;
    @BindView(R.id.ll_desc)
    LinearLayout mLlDesc;
    @BindView(R.id.tv_pa_label)
    TextView mTvPaLabel;
    @BindView(R.id.tv_pa_no)
    RadioButton mTvPaNo;
    @BindView(R.id.tv_pa_yes)
    RadioButton mTvPaYes;
    @BindView(R.id.tv_aa_label)
    TextView mTvAaLabel;
    @BindView(R.id.tv_aa_no)
    RadioButton mTvAaNo;
    @BindView(R.id.tv_aa_yes)
    RadioButton mTvAaYes;
    @BindView(R.id.tv_copd_label)
    TextView mTvCopdLabel;
    @BindView(R.id.tv_copd_no)
    RadioButton mTvCopdNo;
    @BindView(R.id.tv_copd_yes)
    RadioButton mTvCopdYes;
    @BindView(R.id.tv_ss_label)
    TextView mTvSsLabel;
    @BindView(R.id.tv_ss_no)
    RadioButton mTvSsNo;
    @BindView(R.id.tv_ss_yes)
    RadioButton mTvSsYes;
    @BindView(R.id.tv_px_label)
    TextView mTvPxLabel;
    @BindView(R.id.tv_px_no)
    RadioButton mTvPxNo;
    @BindView(R.id.tv_px_yes)
    RadioButton mTvPxYes;
    @BindView(R.id.tv_pu_label)
    TextView mTvPuLabel;
    @BindView(R.id.tv_pu_no)
    RadioButton mTvPuNo;
    @BindView(R.id.tv_pu_yes)
    RadioButton mTvPuYes;
    @BindView(R.id.tv_ta_label)
    TextView mTvTaLabel;
    @BindView(R.id.tv_ta_no)
    RadioButton mTvTaNo;
    @BindView(R.id.tv_ta_yes)
    RadioButton mTvTaYes;
    @BindView(R.id.tv_mc_label)
    TextView mTvMcLabel;
    @BindView(R.id.tv_mc_no)
    RadioButton mTvMcNo;
    @BindView(R.id.tv_mc_yes)
    RadioButton mTvMcYes;
    @BindView(R.id.tv_end_label)
    TextView mTvEndLabel;
    @BindView(R.id.tv_end_no)
    RadioButton mTvEndNo;
    @BindView(R.id.tv_end_yes)
    RadioButton mTvEndYes;
    @BindView(R.id.es_left)
    EditSpinner mEsLeft;
    @BindView(R.id.et_emergency_ward)
    EditText mEtEmergencyWard;
    @BindView(R.id.es_right)
    EditSpinner mEsRight;
    @BindView(R.id.tv_bnp_label)
    TextView mTvBnpLabel;
    @BindView(R.id.rb_bnp_no)
    RadioButton mRbBnpNo;
    @BindView(R.id.rb_bnp_yes)
    RadioButton mRbBnpYes;
    @BindView(R.id.es_bnp_left)
    EditSpinner mEsBnpLeft;
    @BindView(R.id.et_bnp)
    EditText mEtBnp;
    @BindView(R.id.tv_tc_label)
    TextView mTvTcLabel;
    @BindView(R.id.rb_tc_no)
    RadioButton mRbTcNo;
    @BindView(R.id.rb_tc_yes)
    RadioButton mRbTcYes;
    @BindView(R.id.et_tc)
    EditText mEtTc;
    @BindView(R.id.tv_tg_label)
    TextView mTvTgLabel;
    @BindView(R.id.rb_tg_no)
    RadioButton mRbTgNo;
    @BindView(R.id.rb_tg_yes)
    RadioButton mRbTgYes;
    @BindView(R.id.et_tg)
    EditText mEtTg;
    @BindView(R.id.tv_hdl_label)
    TextView mTvHdlLabel;
    @BindView(R.id.rb_hdl_no)
    RadioButton mRbHdlNo;
    @BindView(R.id.rb_hdl_yes)
    RadioButton mRbHdlYes;
    @BindView(R.id.et_hdl)
    EditText mEtHdl;
    @BindView(R.id.tv_ldl_label)
    TextView mTvLdlLabel;
    @BindView(R.id.rb_ldl_no)
    RadioButton mRbLdlNo;
    @BindView(R.id.rb_ldl_yes)
    RadioButton mRbLdlYes;
    @BindView(R.id.et_ldl)
    EditText mEtLdl;
    @BindView(R.id.tv_uc_label)
    TextView mTvUcLabel;
    @BindView(R.id.rb_uc_no)
    RadioButton mRbUcNo;
    @BindView(R.id.rb_uc_yes)
    RadioButton mRbUcYes;
    @BindView(R.id.et_lvef)
    EditText mEtLvef;
    @BindView(R.id.tv_va_label)
    TextView mTvVaLabel;
    @BindView(R.id.rb_va_no)
    RadioButton mRbVaNo;
    @BindView(R.id.rb_va_yes)
    RadioButton mRbVaYes;
    @BindView(R.id.tv_lva_label)
    TextView mTvLvaLabel;
    @BindView(R.id.rb_lva_no)
    RadioButton mRbLvaNo;
    @BindView(R.id.rb_lva_yes)
    RadioButton mRbLvaYes;
    @BindView(R.id.btn_get_data)
    AppCompatButton mBtnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton mBtnConfirm;


    public static PatientStatusFragment1 newInstance(String keyword) {
        PatientStatusFragment1 fragment = new PatientStatusFragment1();
//        Bundle args = new Bundle();
//        args.putString(IntentKey.PATIENT_ID, patientId);
//        args.putString(IntentKey.DOC_ID, docId);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_patient_status_1;
    }


    @Override
    protected void initView(@NonNull View view) {
        initview();
        initData();
        initEvent();
    }

    private void initview() {

        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setCyclic(false)//是否可循环
                .setToolBarTextColor(R.color.colorPrimary)
                .build();


    }

    private void initData() {

    }

    private void initEvent() {


    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

    }
}
