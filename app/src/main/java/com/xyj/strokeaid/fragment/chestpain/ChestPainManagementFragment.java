package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import butterknife.BindView;

/**
 * @Description: 胸痛其他处置
 * @Date: 2020/9/4 20:05
 */
public class ChestPainManagementFragment extends BaseFragment implements OnDateSetListener {

    /**
     * 患者转归
     */
    @BindView(R.id.rg_outcome)
    RadioGroup mOutcome;

    /**
     * 患者转归 单选 出院
     */
    @BindView(R.id.rg_outcome_leave_hosptal)
    RadioButton mLeaveHosptal;

    /**
     * 患者转归 单选 出院
     */
    @BindView(R.id.rg_outcome_transfer_hospital)
    RadioButton mTransferHospital;

    /**
     * 患者转归 单选 转送其他科
     */
    @BindView(R.id.rg_outcome_transfer_department)
    RadioButton mTransferDepartment;

    /**
     * 患者转归 单选 死亡
     */
    @BindView(R.id.rg_outcome_transfer_dead)
    RadioButton mDead;

    /**
     * 出院
     */
    @BindView(R.id.include_pain_in_leave_hospital)
    LinearLayout mPainLeaveHospital;

    /**
     * 转送其他科
     */
    @BindView(R.id.include_pain_in_transfer_department)
    LinearLayout mPainTransferDepartment;

    /**
     * 转其他医院
     */
    @BindView(R.id.include_pain_in_transfer_hospital)
    LinearLayout mPainTransferHospital;

    /**
     * 死亡
     */
    @BindView(R.id.include_pain_in_dead)
    LinearLayout mPainTransferDead;

    /**
     * 离院宣传
     */
    @BindView(R.id.ll_leave_hospital_said)
    LinearLayout mLeaveHospitalSaid;

    /**
     * 降糖药物
     */
    @BindView(R.id.rg_hypoglycemic)
    RadioGroup rgHypoglycemic;

    /**
     * 降糖药物 单选 是
     */
    @BindView(R.id.rg_hypoglycemic_yes)
    RadioButton rbHypoglycemicYes;

    /**
     * 降糖药物 单选 否
     */
    @BindView(R.id.rg_hypoglycemic_no)
    RadioButton rbHypoglycemicNo;

    /**
     * 降糖药物 药物名称
     */
    @BindView(R.id.ll_hypoglycemic_name)
    LinearLayout llHypoglycemicName;

    /**
     * 口服抗凝药物
     */
    @BindView(R.id.rg_anticoagulation)
    RadioGroup rgAnticoagulation;

    /**
     * 口服抗凝药物 单选 是
     */
    @BindView(R.id.rb_anticoagulation_yes)
    RadioButton rbAnticoagulationYes;

    /**
     * 口服抗凝药物 单选 否
     */
    @BindView(R.id.rb_anticoagulation_no)
    RadioButton rbAnticoagulationNo;

    /**
     * 口服抗凝药物 药物名称
     */
    @BindView(R.id.ll_anticoagulation_name)
    LinearLayout llAnticoagulationName;


    public static ChestPainManagementFragment newInstance() {
        ChestPainManagementFragment fragment = new ChestPainManagementFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chest_pain;
    }

    @Override
    protected void initView(@NonNull View view) {
        initview();
        initData();
        initEvent();
    }

    private void initview() {
        mOutcome.setOnCheckedChangeListener(radioghange);

        rgHypoglycemic.setOnCheckedChangeListener(radioghangeHypoglycemic);

        rgAnticoagulation.setOnCheckedChangeListener(radioghangeAnticoagulation);
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


    private RadioGroup.OnCheckedChangeListener radioghange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId == mLeaveHosptal.getId()) {
                mPainTransferDepartment.setVisibility(View.GONE);
                mPainTransferHospital.setVisibility(View.GONE);

                mPainTransferDead.setVisibility(View.GONE);
                mPainLeaveHospital.setVisibility(View.VISIBLE);
                mLeaveHospitalSaid.setVisibility(View.VISIBLE);

            } else if (checkedId == mTransferDepartment.getId()) {
                mPainTransferDepartment.setVisibility(View.VISIBLE);
                mPainTransferHospital.setVisibility(View.GONE);

                mPainTransferDead.setVisibility(View.GONE);
                mPainLeaveHospital.setVisibility(View.GONE);
                mLeaveHospitalSaid.setVisibility(View.VISIBLE);

            } else if (checkedId == mTransferHospital.getId()) {
                mPainTransferDepartment.setVisibility(View.GONE);
                mPainTransferHospital.setVisibility(View.VISIBLE);

                mPainTransferDead.setVisibility(View.GONE);
                mPainLeaveHospital.setVisibility(View.GONE);
                mLeaveHospitalSaid.setVisibility(View.VISIBLE);

            } else if (checkedId == mDead.getId()) {
                mPainTransferDepartment.setVisibility(View.GONE);
                mPainTransferHospital.setVisibility(View.GONE);

                mPainTransferDead.setVisibility(View.VISIBLE);
                mPainLeaveHospital.setVisibility(View.GONE);
                mLeaveHospitalSaid.setVisibility(View.GONE);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioghangeHypoglycemic = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId == rbHypoglycemicYes.getId()) {
                llHypoglycemicName.setVisibility(View.VISIBLE);

            } else if (checkedId == rbHypoglycemicNo.getId()) {
                llHypoglycemicName.setVisibility(View.GONE);
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioghangeAnticoagulation = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId == rbAnticoagulationYes.getId()) {
                llAnticoagulationName.setVisibility(View.VISIBLE);

            } else if (checkedId == rbAnticoagulationNo.getId()) {
                llAnticoagulationName.setVisibility(View.GONE);
            }
        }
    };

}
