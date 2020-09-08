package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;

/**
 * @Description: 胸痛其他处置
 * @Date: 2020/9/4 20:05
 */
public class ChestPainOtherTretmentFragment extends BaseFragment {


    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rb_sugar_yes)
    RadioButton rbSugarYes;
    @BindView(R.id.rb_sugar_no)
    RadioButton rbSugarNo;
    @BindView(R.id.rg_sugar)
    RadioGroup rgSugar;
    @BindView(R.id.es_sugar)
    EditSpinner esSugar;
    @BindView(R.id.ll_blood_sugar_drug)
    LinearLayout llBloodSugarDrug;
    @BindView(R.id.rb_anticoagulant_yes)
    RadioButton rbAnticoagulantYes;
    @BindView(R.id.rb_anticoagulant_no)
    RadioButton rbAnticoagulantNo;
    @BindView(R.id.rg_anticoagulant)
    RadioGroup rgAnticoagulant;
    @BindView(R.id.es_anticoagulant)
    EditSpinner esAnticoagulant;
    @BindView(R.id.ll_anticoagulant_drug)
    LinearLayout llAnticoagulantDrug;
    @BindView(R.id.ieb_in_hos_days)
    ItemEditBar iebInHosDays;
    @BindView(R.id.ieb_in_hos_total_cost)
    ItemEditBar iebInHosTotalCost;
    @BindView(R.id.rb_patient_out_hos)
    RadioButton rbPatientOutHos;
    @BindView(R.id.rb_patient_out_other_hos)
    RadioButton rbPatientOutOtherHos;
    @BindView(R.id.rb_patient_out_other_depart)
    RadioButton rbPatientOutOtherDepart;
    @BindView(R.id.rb_patient_out_death)
    RadioButton rbPatientOutDeath;
    @BindView(R.id.rg_patient_out)
    MyRadioGroup rgPatientOut;
    @BindView(R.id.ll_leave_hospital_said)
    LinearLayout llLeaveHospitalSaid;
    @BindView(R.id.ttb_death_time)
    TextTimeBar ttbDeathTime;
    @BindView(R.id.rb_death_reason_heart)
    RadioButton rbDeathReasonHeart;
    @BindView(R.id.rb_death_reason_not_heart)
    RadioButton rbDeathReasonNotHeart;
    @BindView(R.id.rg_death_reason)
    RadioGroup rgDeathReason;
    @BindView(R.id.et_death_reason)
    EditText etDeathReason;
    @BindView(R.id.tv_death_reason_num)
    TextView tvDeathReasonNum;
    @BindView(R.id.ttb_out_hos_time)
    TextTimeBar ttbOutHosTime;
    @BindView(R.id.rb_treat_result_cure)
    RadioButton rbTreatResultCure;
    @BindView(R.id.rb_treat_result_better)
    RadioButton rbTreatResultBetter;
    @BindView(R.id.rb_treat_result_leave_self)
    RadioButton rbTreatResultLeaveSelf;
    @BindView(R.id.rb_treat_result_other)
    RadioButton rbTreatResultOther;
    @BindView(R.id.rg_treat_result)
    MyRadioGroup rgTreatResult;
    @BindView(R.id.ttb_transfer_time)
    TextTimeBar ttbTransferTime;
    @BindView(R.id.es_transfer_depart)
    EditSpinner esTransferDepart;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.tv_transfer_num)
    TextView tvTransferNum;
    @BindView(R.id.ttb_leave_own_hos_time)
    TextTimeBar ttbLeaveOwnHosTime;
    @BindView(R.id.et_transfer_hos_name)
    EditText etTransferHosName;
    @BindView(R.id.rb_net_hos_yes)
    RadioButton rbNetHosYes;
    @BindView(R.id.rb_net_hos_no)
    RadioButton rbNetHosNo;
    @BindView(R.id.rg_net_hos)
    RadioGroup rgNetHos;
    @BindView(R.id.rb_conduit_room_yes)
    RadioButton rbConduitRoomYes;
    @BindView(R.id.rb_conduit_room_no)
    RadioButton rbConduitRoomNo;
    @BindView(R.id.rg_conduit_room)
    RadioGroup rgConduitRoom;
    @BindView(R.id.ttb_real_pci_start_time)
    TextTimeBar ttbRealPciStartTime;
    @BindView(R.id.rb_remote_heart_yes)
    RadioButton rbRemoteHeartYes;
    @BindView(R.id.rb_remote_heart_no)
    RadioButton rbRemoteHeartNo;
    @BindView(R.id.rg_remote_heart)
    RadioGroup rgRemoteHeart;
    @BindView(R.id.ttb_remote_heart_time)
    TextTimeBar ttbRemoteHeartTime;
    @BindView(R.id.es_remote_heart_way)
    EditSpinner esRemoteHeartWay;
    @BindView(R.id.ll_remote_heart_yes)
    LinearLayout llRemoteHeartYes;
    @BindView(R.id.rb_image_24h_yes)
    RadioButton rbImage24hYes;
    @BindView(R.id.rb_image_24h_no)
    RadioButton rbImage24hNo;
    @BindView(R.id.rg_image_24h)
    RadioGroup rgImage24h;
    @BindView(R.id.ttb_image_24h_time)
    TextTimeBar ttbImage24hTime;
    @BindView(R.id.et_refuse_reason)
    EditText etRefuseReason;
    @BindView(R.id.tv_refuse_reason_num)
    TextView tvRefuseReasonNum;
    @BindView(R.id.ll_family_refuse_reason)
    LinearLayout llFamilyRefuseReason;
    @BindView(R.id.rb_transfer_pci_yes)
    RadioButton rbTransferPciYes;
    @BindView(R.id.rb_transfer_pci_no)
    RadioButton rbTransferPciNo;
    @BindView(R.id.rg_transfer_pci)
    RadioGroup rgTransferPci;

    LinearLayout mLinearLayoutOutHos;
    LinearLayout mLinearLayoutOutOtherHos;
    LinearLayout mLinearLayoutOutOtherDepart;
    LinearLayout mLinearLayoutOutDeath;

    public static ChestPainOtherTretmentFragment newInstance() {
        ChestPainOtherTretmentFragment fragment = new ChestPainOtherTretmentFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chest_pain;
    }

    @Override
    protected void initView(@NonNull View view) {
        mLinearLayoutOutDeath = view.findViewById(R.id.include_pain_in_dead);
        mLinearLayoutOutHos = view.findViewById(R.id.include_pain_in_leave_hospital);
        mLinearLayoutOutOtherHos = view.findViewById(R.id.include_pain_in_transfer_department);
        mLinearLayoutOutOtherDepart = view.findViewById(R.id.include_pain_in_transfer_hospital);
    }


    @Override
    protected void initListener() {
        rgSugar.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_sugar_yes) {
                llBloodSugarDrug.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_sugar_no) {
                llBloodSugarDrug.setVisibility(View.GONE);
            }
        });

        rgAnticoagulant.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_anticoagulant_yes) {
                llAnticoagulantDrug.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_anticoagulant_no) {
                llAnticoagulantDrug.setVisibility(View.GONE);
            }
        });

        rgPatientOut.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_patient_out_hos) {
                    mLinearLayoutOutHos.setVisibility(View.VISIBLE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_other_hos) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.VISIBLE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_other_depart) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.VISIBLE);
                    mLinearLayoutOutDeath.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_patient_out_death) {
                    mLinearLayoutOutHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherHos.setVisibility(View.GONE);
                    mLinearLayoutOutOtherDepart.setVisibility(View.GONE);
                    mLinearLayoutOutDeath.setVisibility(View.VISIBLE);
                }
            }
        });
    }


}
