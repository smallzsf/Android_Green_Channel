package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.chestpain.ReperfusionMeasuresBean;
import com.xyj.strokeaid.distutil.DistListUtil;
import com.xyj.strokeaid.distutil.RadioButtonDistUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * TreatmentDecisionFragment
 * description: 治疗策略
 *
 * @author : Licy
 * @date : 2020/9/6
 * email ：licy3051@qq.com
 */
public class TreatmentDecisionFragment extends BaseFragment {

    @BindView(R.id.rb_into_measure_level_1)
    RadioButton rbIntoMeasureLevel1;
    @BindView(R.id.rb_into_measure_level_2)
    RadioButton rbIntoMeasureLevel2;
    @BindView(R.id.rb_into_measure_level_3)
    RadioButton rbIntoMeasureLevel3;
    @BindView(R.id.rb_into_measure_level_4)
    RadioButton rbIntoMeasureLevel4;
    @BindView(R.id.rb_into_measure_level_5)
    RadioButton rbIntoMeasureLevel5;
    @BindView(R.id.ll_deal_way)
    LinearLayout llDealWay;
    @BindView(R.id.ttb_direct_decide_pci)
    TextTimeBar ttbDirectDecidePci;
    @BindView(R.id.es_direct_decide_doc)
    EditSpinner esDirectDecideDoc;
    @BindView(R.id.es_direct_talk_doc)
    EditSpinner esDirectTalkDoc;
    @BindView(R.id.rl_agree_time)
    TextTimeBar rlAgreeTime;
    @BindView(R.id.rl_sign_time)
    TextTimeBar rlSignTime;
    @BindView(R.id.rb_family_opinion_agree)
    RadioButton rbFamilyOpinionAgree;
    @BindView(R.id.rb_family_opinion_disagree)
    RadioButton rbFamilyOpinionDisagree;
    @BindView(R.id.rg_family_opinion)
    RadioGroup rgFamilyOpinion;
    @BindView(R.id.et_refuse_reason)
    EditText etRefuseReason;
    @BindView(R.id.tv_refuse_reason_num)
    TextView tvRefuseReasonNum;
    @BindView(R.id.ll_family_refuse_reason)
    LinearLayout llFamilyRefuseReason;
    @BindView(R.id.ttb_start_catheter_room)
    TextTimeBar ttbStartCatheterRoom;
    @BindView(R.id.sb_agree_photo)
    SettingBar sbAgreePhoto;
    @BindView(R.id.ll_direct_pci)
    LinearLayout llDirectPci;
    @BindView(R.id.rb_thrombolysis_way_1)
    RadioButton rbThrombolysisWay1;
    @BindView(R.id.rb_thrombolysis_way_2)
    RadioButton rbThrombolysisWay2;
    @BindView(R.id.rb_thrombolysis_way_3)
    RadioButton rbThrombolysisWay3;
    @BindView(R.id.rg_thrombolysis_way)
    RadioGroup rgThrombolysisWay;
    @BindView(R.id.ttb_thrombolysis_decide_pci)
    TextTimeBar ttbThrombolysisDecidePci;
    @BindView(R.id.ttb_select_decide_pci)
    TextTimeBar ttbSelectDecidePci;
    @BindView(R.id.ttb_select_start_image)
    TextTimeBar ttbSelectStartImage;
    @BindView(R.id.ll_select_pci)
    LinearLayout llSelectPci;
    @BindView(R.id.ttb_decide_cabg)
    TextTimeBar ttbDecideCabg;
    @BindView(R.id.ttb_start_cabg)
    TextTimeBar ttbStartCabg;
    @BindView(R.id.ll_cabg)
    LinearLayout llCabg;
    @BindView(R.id.rb_transfer_pci_out)
    RadioButton rbTransferPciOut;
    @BindView(R.id.rb_transfer_pci_in)
    RadioButton rbTransferPciIn;
    @BindView(R.id.rg_transfer_pci)
    RadioGroup rgTransferPci;
    @BindView(R.id.ll_transfer_pci)
    LinearLayout llTransferPci;
    @BindView(R.id.cb_into_no_1)
    CheckBox cbIntoNo1;
    @BindView(R.id.cb_into_no_2)
    CheckBox cbIntoNo2;
    @BindView(R.id.cb_into_no_3)
    CheckBox cbIntoNo3;
    @BindView(R.id.cb_into_no_4)
    CheckBox cbIntoNo4;
    @BindView(R.id.cb_into_no_5)
    CheckBox cbIntoNo5;
    @BindView(R.id.cb_into_no_6)
    CheckBox cbIntoNo6;
    @BindView(R.id.cb_into_no_7)
    CheckBox cbIntoNo7;
    @BindView(R.id.cb_into_no_8)
    CheckBox cbIntoNo8;
    @BindView(R.id.ll_into_no)
    LinearLayout llIntoNo;
    @BindView(R.id.rb_reperfusion_yes)
    RadioButton rbReperfusionYes;
    @BindView(R.id.rb_reperfusion_no)
    RadioButton rbReperfusionNo;
    @BindView(R.id.rg_reperfusion)
    RadioGroup rgReperfusion;
    @BindView(R.id.rg_reperfusion_ways)
    MyRadioGroup rgReperfusionWays;
    @BindView(R.id.ll_thrombolysis)
    LinearLayout llThrombolysis;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    private String mRecordId;

    DistListUtil distListUtil = new DistListUtil(context);

    RadioButtonDistUtil radioButtonDistUtil;
    RadioButtonDistUtil radioFamilDistUtil;

    public TreatmentDecisionFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recordId 记录ID
     * @return A new instance of fragment StrokeGetInvolvedFragment.
     */
    public static TreatmentDecisionFragment newInstance(String recordId) {
        TreatmentDecisionFragment fragment = new TreatmentDecisionFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_treatment_decision;
    }

    @Override
    protected void initView(@NonNull View view) {
        radioButtonDistUtil = new RadioButtonDistUtil(context);
        radioButtonDistUtil.addView(rgReperfusionWays);
        radioButtonDistUtil.setStringArrayId(R.array.chest_pain_treament_decision);

        radioFamilDistUtil = new RadioButtonDistUtil(context);
        radioFamilDistUtil.addView(rgFamilyOpinion);
        radioFamilDistUtil.setStringArrayId(R.array.treatment_decision_family);
//TODO 设置回显使用
//        radioFamilDistUtil.setStringArrayNormalKey();

    }

    @Override
    protected void initListener() {
        rgReperfusion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_reperfusion_yes) {
                    llDealWay.setVisibility(View.VISIBLE);
                    llIntoNo.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_reperfusion_no) {
                    llDealWay.setVisibility(View.GONE);
                    llIntoNo.setVisibility(View.VISIBLE);
                }
            }
        });

        rgReperfusionWays.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_into_measure_level_1) {
                    // 直接PCI
                    llDirectPci.setVisibility(View.VISIBLE);
                    llThrombolysis.setVisibility(View.GONE);
                    llSelectPci.setVisibility(View.GONE);
                    llCabg.setVisibility(View.GONE);
                    llTransferPci.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_into_measure_level_2) {
                    // 溶栓
                    llDirectPci.setVisibility(View.GONE);
                    llThrombolysis.setVisibility(View.VISIBLE);
                    llSelectPci.setVisibility(View.GONE);
                    llCabg.setVisibility(View.GONE);
                    llTransferPci.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_into_measure_level_3) {
                    // 择期介入
                    llDirectPci.setVisibility(View.GONE);
                    llThrombolysis.setVisibility(View.GONE);
                    llSelectPci.setVisibility(View.VISIBLE);
                    llCabg.setVisibility(View.GONE);
                    llTransferPci.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_into_measure_level_4) {
                    // CABG
                    llDirectPci.setVisibility(View.GONE);
                    llThrombolysis.setVisibility(View.GONE);
                    llSelectPci.setVisibility(View.GONE);
                    llCabg.setVisibility(View.VISIBLE);
                    llTransferPci.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_into_measure_level_5) {
                    // 转运PCI
                    llDirectPci.setVisibility(View.GONE);
                    llThrombolysis.setVisibility(View.GONE);
                    llSelectPci.setVisibility(View.GONE);
                    llCabg.setVisibility(View.GONE);
                    llTransferPci.setVisibility(View.VISIBLE);
                }
            }
        });

        rgFamilyOpinion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_family_opinion_agree) {
                    llFamilyRefuseReason.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_family_opinion_disagree) {
                    llFamilyRefuseReason.setVisibility(View.VISIBLE);
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void saveData() {
        ReperfusionMeasuresBean bean = new ReperfusionMeasuresBean();
//        rb_reperfusion_yes
        if (!rbReperfusionNo.isChecked() && !rbReperfusionYes.isChecked()) {
            showToast("保存失败，未设置信息");
            return;
        }
        if (rbReperfusionYes.isChecked()) {
//            rb_into_measure_level_1
            if (rbIntoMeasureLevel1.isChecked()) {
                // 直接PCI
                String selectViewKey = radioButtonDistUtil.getSelectViewKey();
                bean.setStemireperfusionmeasure(selectViewKey);
//                ttb_direct_decide_pci  // 介入时间
                String time = ttbDirectDecidePci.getTime();
                bean.setDecidepcitime(time);
//                es_direct_decide_doc 决定医生
                bean.setDecidedoctorid(esDirectDecideDoc.getSelectData()[1]);
//                zdmjpatientdoctorid 谈话医生
                bean.setZdmjpatientdoctorid(esDirectTalkDoc.getSelectData()[1]);
//pcipatientcommunicationsbegintime 知情时间
                bean.setPcipatientcommunicationsbegintime(rlAgreeTime.getTime());
//pcipatientcommunicationendtime	签署知情同意时间yyyy
                bean.setPcipatientcommunicationendtime(rlSignTime.getTime());
//zdmjpatientopinion	家属意见（"cpc_jsyj_ty
                bean.setZdmjpatientopinion(radioFamilDistUtil.getSelectViewKey());
//                rb_family_opinion_disagree// 拒绝建议
                if (rbFamilyOpinionDisagree.isChecked()) {
                    String trim = etRefuseReason.getText().toString().trim();
                    bean.setZdmjpatientrefusereason(trim);
                }
//                enabledsaroombegintime	启动导管室时间yyyy
                bean.setEnabledsaroombegintime(ttbStartCatheterRoom.getTime());
//                zdmjpatientrefusereason

            } else if (rbIntoMeasureLevel2.isChecked()) {
                // 溶栓
            } else if (rbIntoMeasureLevel2.isChecked()) {
                //  择期介入
            } else if (rbIntoMeasureLevel2.isChecked()) {
                // CABG
            } else if (rbIntoMeasureLevel2.isChecked()) {
                // 转运pci
            }
        }
        // 保存到网络
        save(bean);
    }

    /**
     * 保存到网络
     *
     * @param bean
     */
    private void save(ReperfusionMeasuresBean bean) {
        bean.setRecordId(mRecordId);
        showLoadingDialog();
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveReperfusionmeasures(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            BaseObjectBean body = response.body();
                            if (body.getResult() == 1) {
                                showToast("数据保存成功");
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


}

    
    
       
    