package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class PatientStatusFragment1 extends BaseFragment implements OnDateSetListener {
    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;
    @BindView(R.id.awareness)
    TextView awareness;
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.tv_first_cure)
    TextView tvFirstCure;
    @BindView(R.id.tv_draw_blood_time)
    TextView tvDrawBloodTime;
    @BindView(R.id.give_up_cure)
    TextView giveUpCure;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton rbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton rbCtFragAe;
    @BindView(R.id.rb_cta_frag_ae)
    RadioButton rbCtaFragAe;
    @BindView(R.id.rb_ctp_frag_ae)
    RadioButton rbCtpFragAe;
    @BindView(R.id.rb_mri_frag_ae)
    RadioButton rbMriFragAe;
    @BindView(R.id.rb_mra_frag_ae)
    RadioButton rbMraFragAe;
    @BindView(R.id.rb_cemra_frag_ae)
    RadioButton rbCemraFragAe;
    @BindView(R.id.rb_cvus_frag_ae)
    RadioButton rbCvusFragAe;
    @BindView(R.id.rb_tcd_frag_ae)
    RadioButton rbTcdFragAe;
    @BindView(R.id.rg_yn)
    RadioGroup rgYn;
    @BindView(R.id.tv_nyha_label)
    TextView tvNyhaLabel;
    @BindView(R.id.rb_nyha_1)
    RadioButton rbNyha1;
    @BindView(R.id.rb_nyha_2)
    RadioButton rbNyha2;
    @BindView(R.id.rb_nyha_3)
    RadioButton rbNyha3;
    @BindView(R.id.rb_nyha_4)
    RadioButton rbNyha4;
    @BindView(R.id.ll_nyha)
    LinearLayout llNyha;
    @BindView(R.id.tv_bp_label)
    TextView tvBpLabel;
    @BindView(R.id.tv_bp_no)
    RadioButton tvBpNo;
    @BindView(R.id.tv_bp_yes)
    RadioButton tvBpYes;
    @BindView(R.id.tv_bf_label)
    TextView tvBfLabel;
    @BindView(R.id.tv_bf_no)
    RadioButton tvBfNo;
    @BindView(R.id.tv_bf_yes)
    RadioButton tvBfYes;
    @BindView(R.id.tv_diabetic_label)
    TextView tvDiabeticLabel;
    @BindView(R.id.tv_diabetic_no)
    RadioButton tvDiabeticNo;
    @BindView(R.id.tv_diabetic_yes)
    RadioButton tvDiabeticYes;
    @BindView(R.id.tv_smoke_label)
    TextView tvSmokeLabel;
    @BindView(R.id.tv_smoke_no)
    RadioButton tvSmokeNo;
    @BindView(R.id.tv_smoke_yes)
    RadioButton tvSmokeYes;
    @BindView(R.id.tv_smoke_status_label)
    TextView tvSmokeStatusLabel;
    @BindView(R.id.tv_smoke_status_yes)
    RadioButton tvSmokeStatusYes;
    @BindView(R.id.tv_smoke_status_no)
    RadioButton tvSmokeStatusNo;
    @BindView(R.id.tv_fat_label)
    TextView tvFatLabel;
    @BindView(R.id.tv_fat_no)
    RadioButton tvFatNo;
    @BindView(R.id.tv_fat_yes)
    RadioButton tvFatYes;
    @BindView(R.id.tv_cvd_label)
    TextView tvCvdLabel;
    @BindView(R.id.tv_cvd_no)
    RadioButton tvCvdNo;
    @BindView(R.id.tv_cvd_yes)
    RadioButton tvCvdYes;
    @BindView(R.id.tv_chd_label)
    TextView tvChdLabel;
    @BindView(R.id.tv_chd_no)
    RadioButton tvChdNo;
    @BindView(R.id.tv_chd_yes)
    RadioButton tvChdYes;
    @BindView(R.id.rg_chd)
    RadioGroup rgChd;
    @BindView(R.id.tv_xy_label)
    TextView tvXyLabel;
    @BindView(R.id.tv_xy_no)
    RadioButton tvXyNo;
    @BindView(R.id.tv_xy_yes)
    RadioButton tvXyYes;
    @BindView(R.id.rg_xy)
    RadioGroup rgXy;
    @BindView(R.id.ll_xy)
    LinearLayout llXy;
    @BindView(R.id.tv_xf_label)
    TextView tvXfLabel;
    @BindView(R.id.tv_xf_no)
    RadioButton tvXfNo;
    @BindView(R.id.tv_xf_yes)
    RadioButton tvXfYes;
    @BindView(R.id.rg_xf)
    RadioGroup rgXf;
    @BindView(R.id.ll_xf)
    LinearLayout llXf;
    @BindView(R.id.tv_fx_label)
    TextView tvFxLabel;
    @BindView(R.id.tv_fx_1)
    RadioButton tvFx1;
    @BindView(R.id.tv_fx_2)
    RadioButton tvFx2;
    @BindView(R.id.tv_fx_3)
    RadioButton tvFx3;
    @BindView(R.id.tv_fx_4)
    RadioButton tvFx4;
    @BindView(R.id.ll_fx)
    LinearLayout llFx;
    @BindView(R.id.tv_slow_label)
    TextView tvSlowLabel;
    @BindView(R.id.tv_slow_no)
    RadioButton tvSlowNo;
    @BindView(R.id.tv_slow_yes)
    RadioButton tvSlowYes;
    @BindView(R.id.rg_slow)
    RadioGroup rgSlow;
    @BindView(R.id.tv_factor_nyha_label)
    TextView tvFactorNyhaLabel;
    @BindView(R.id.rb_factor_nyha_1)
    RadioButton rbFactorNyha1;
    @BindView(R.id.rb_factor_nyha_2)
    RadioButton rbFactorNyha2;
    @BindView(R.id.rb_factor_nyha_3)
    RadioButton rbFactorNyha3;
    @BindView(R.id.rb_factor_nyha_4)
    RadioButton rbFactorNyha4;
    @BindView(R.id.ll_factor_nyha)
    LinearLayout llFactorNyha;
    @BindView(R.id.tv_bm_label)
    TextView tvBmLabel;
    @BindView(R.id.tv_bm_no)
    RadioButton tvBmNo;
    @BindView(R.id.tv_bm_yes)
    RadioButton tvBmYes;
    @BindView(R.id.tv_stroke_label)
    TextView tvStrokeLabel;
    @BindView(R.id.tv_stroke_no)
    RadioButton tvStrokeNo;
    @BindView(R.id.tv_stroke_yes)
    RadioButton tvStrokeYes;
    @BindView(R.id.rg_stroke)
    RadioGroup rgStroke;
    @BindView(R.id.tv_desc_label)
    TextView tvDescLabel;
    @BindView(R.id.tv_desc_no)
    RadioButton tvDescNo;
    @BindView(R.id.tv_desc_yes)
    RadioButton tvDescYes;
    @BindView(R.id.ll_desc)
    LinearLayout llDesc;
    @BindView(R.id.tv_pa_label)
    TextView tvPaLabel;
    @BindView(R.id.tv_pa_no)
    RadioButton tvPaNo;
    @BindView(R.id.tv_pa_yes)
    RadioButton tvPaYes;
    @BindView(R.id.tv_aa_label)
    TextView tvAaLabel;
    @BindView(R.id.tv_aa_no)
    RadioButton tvAaNo;
    @BindView(R.id.tv_aa_yes)
    RadioButton tvAaYes;
    @BindView(R.id.tv_copd_label)
    TextView tvCopdLabel;
    @BindView(R.id.tv_copd_no)
    RadioButton tvCopdNo;
    @BindView(R.id.tv_copd_yes)
    RadioButton tvCopdYes;
    @BindView(R.id.tv_ss_label)
    TextView tvSsLabel;
    @BindView(R.id.tv_ss_no)
    RadioButton tvSsNo;
    @BindView(R.id.tv_ss_yes)
    RadioButton tvSsYes;
    @BindView(R.id.tv_px_label)
    TextView tvPxLabel;
    @BindView(R.id.tv_px_no)
    RadioButton tvPxNo;
    @BindView(R.id.tv_px_yes)
    RadioButton tvPxYes;
    @BindView(R.id.tv_pu_label)
    TextView tvPuLabel;
    @BindView(R.id.tv_pu_no)
    RadioButton tvPuNo;
    @BindView(R.id.tv_pu_yes)
    RadioButton tvPuYes;
    @BindView(R.id.tv_ta_label)
    TextView tvTaLabel;
    @BindView(R.id.tv_ta_no)
    RadioButton tvTaNo;
    @BindView(R.id.tv_ta_yes)
    RadioButton tvTaYes;
    @BindView(R.id.tv_mc_label)
    TextView tvMcLabel;
    @BindView(R.id.tv_mc_no)
    RadioButton tvMcNo;
    @BindView(R.id.tv_mc_yes)
    RadioButton tvMcYes;
    @BindView(R.id.tv_end_label)
    TextView tvEndLabel;
    @BindView(R.id.tv_end_no)
    RadioButton tvEndNo;
    @BindView(R.id.tv_end_yes)
    RadioButton tvEndYes;
    @BindView(R.id.es_left)
    EditSpinner esLeft;
    @BindView(R.id.et_emergency_ward)
    EditText etEmergencyWard;
    @BindView(R.id.es_right)
    EditSpinner esRight;
    @BindView(R.id.tv_bnp_label)
    TextView tvBnpLabel;
    @BindView(R.id.rb_bnp_no)
    RadioButton rbBnpNo;
    @BindView(R.id.rb_bnp_yes)
    RadioButton rbBnpYes;
    @BindView(R.id.es_bnp_left)
    EditSpinner esBnpLeft;
    @BindView(R.id.et_bnp)
    EditText etBnp;
    @BindView(R.id.tv_tc_label)
    TextView tvTcLabel;
    @BindView(R.id.rb_tc_no)
    RadioButton rbTcNo;
    @BindView(R.id.rb_tc_yes)
    RadioButton rbTcYes;
    @BindView(R.id.et_tc)
    EditText etTc;
    @BindView(R.id.tv_tg_label)
    TextView tvTgLabel;
    @BindView(R.id.rb_tg_no)
    RadioButton rbTgNo;
    @BindView(R.id.rb_tg_yes)
    RadioButton rbTgYes;
    @BindView(R.id.et_tg)
    EditText etTg;
    @BindView(R.id.tv_hdl_label)
    TextView tvHdlLabel;
    @BindView(R.id.rb_hdl_no)
    RadioButton rbHdlNo;
    @BindView(R.id.rb_hdl_yes)
    RadioButton rbHdlYes;
    @BindView(R.id.et_hdl)
    EditText etHdl;
    @BindView(R.id.tv_ldl_label)
    TextView tvLdlLabel;
    @BindView(R.id.rb_ldl_no)
    RadioButton rbLdlNo;
    @BindView(R.id.rb_ldl_yes)
    RadioButton rbLdlYes;
    @BindView(R.id.et_ldl)
    EditText etLdl;
    @BindView(R.id.tv_uc_label)
    TextView tvUcLabel;
    @BindView(R.id.rb_uc_no)
    RadioButton rbUcNo;
    @BindView(R.id.rb_uc_yes)
    RadioButton rbUcYes;
    @BindView(R.id.et_lvef)
    EditText etLvef;
    @BindView(R.id.tv_va_label)
    TextView tvVaLabel;
    @BindView(R.id.rb_va_no)
    RadioButton rbVaNo;
    @BindView(R.id.rb_va_yes)
    RadioButton rbVaYes;
    @BindView(R.id.tv_lva_label)
    TextView tvLvaLabel;
    @BindView(R.id.rb_lva_no)
    RadioButton rbLvaNo;
    @BindView(R.id.rb_lva_yes)
    RadioButton rbLvaYes;


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
