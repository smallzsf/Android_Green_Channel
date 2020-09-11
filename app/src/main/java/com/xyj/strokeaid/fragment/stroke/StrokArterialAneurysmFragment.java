package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * @Description: 动脉瘤
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokArterialAneurysmFragment extends BaseStrokeFragment {

    /**
     * 颅内血管检查方式 多选 CTA
     * */
    @BindView(R.id.ck_stroke_cta_no_aneurysm)
    CheckBox ckIntracranialVascularCTA;

    /**
     * 颅内血管检查方式 多选 MRA
     * */
    @BindView(R.id.ck_stroke_mra_no_aneurysm)
    CheckBox ckIntracranialVascularMRA;

    /**
     * 颅内血管检查方式 多选 DSA
     * */
    @BindView(R.id.ck_stroke_dsa_no_aneurysm)
    CheckBox ckIntracranialVascularDSA;

    /**
     * 颅内血管检查方式 多选 未查
     * */
    @BindView(R.id.ck_stroke_not_checked_no_aneurysm)
    CheckBox ckIntracranialVascularWC;

    /**
     * 动脉瘤个数
     * */
    @BindView(R.id.ed_stroke_count_aneurysm)
    EditText edAneurysm;

    /**
     * 动脉瘤责任血管部位 新增
     * */
    @BindView(R.id.tv_add_aneurysm)
    TextView tvAneurysmAdd;

    /**
     * 动脉瘤责任血管部位 新增 EditText
     * */
    @BindView(R.id.ed_stroke_count_content_aneurysm)
    EditText edAneurysmAdd;

    /**
     * 是否手术 单选 是
     * */
    @BindView(R.id.rb_stroke_yes_aneurysm)
    RadioButton rbOperationYes;

    /**
     * 是否手术 单选 否
     * */
    @BindView(R.id.rb_stroke_no_aneurysm)
    RadioButton rbOperationNo;

    /**
     *  开始时间
     * */
    @BindView(R.id.ttb_start_time_aneurysm)
    TextTimeBar ttbStartTime;

    /**
     * 手术类型 RadioGroup
     * */
    @BindView(R.id.rp_stroke_mode_aneurysm)
    RadioGroup ckStrokeMode;

    /**
     * 手术类型 单选 介入栓塞术
     * */
    @BindView(R.id.rb_stroke_intervention_aneurysm)
    RadioButton rbInterventionAneurysm;

    /**
     * 手术类型 单选 夹闭术
     * */
    @BindView(R.id.rb_stroke_clipping_aneurysm)
    RadioButton rbInterventionClipping;

    /**
     * 手术类型 单选 复合手术
     * */
    @BindView(R.id.rb_stroke_compound_aneurysm)
    RadioButton rbInterventionCompound;

    /**
     * 动脉瘤治疗结果 单选 完全闭塞
     * */
    @BindView(R.id.rb_stroke_wqbs_aneurysm)
    RadioButton rbAneurysmWQBS;

    /**
     * 动脉瘤治疗结果 单选 瘤径残留
     * */
    @BindView(R.id.rb_stroke_ljcl_aneurysm)
    RadioButton rbAneurysmLJCL;

    /**
     * 动脉瘤治疗结果 单选 部分瘤体残留
     * */
    @BindView(R.id.rb_stroke_bfltcl_aneurysm)
    RadioButton rbAneurysmBFLTCL;

    /**
     * 动脉瘤治疗结果 单选 瘤体残留
     * */
    @BindView(R.id.rb_stroke_ltcl_aneurysm)
    RadioButton rbAneurysmLTCL;

    /**
     * 夹闭后在瘤动脉情况 单选 通畅
     * */
    @BindView(R.id.rb_stroke_tc_aneurysm)
    RadioButton rbAneurysmTC;

    /**
     * 夹闭后在瘤动脉情况 单选 轻度狭窄（<50%)
     * */
    @BindView(R.id.rb_stroke_jdxz_aneurysm)
    RadioButton rbAneurysmQD50;

    /**
     * 夹闭后在瘤动脉情况 单选 严重狭窄（>50%)
     * */
    @BindView(R.id.rb_stroke_yzxz_aneurysm)
    RadioButton rbAneurysmZD50;

    /**
     * 夹闭后在瘤动脉情况 单选 完全闭塞
     * */
    @BindView(R.id.rb_stroke_wqbsxz_aneurysm)
    RadioButton rbAneurysmWQBS100;

    /**
     * 夹闭术过程中并发症
     * */
    @BindView(R.id.rb_clipping_complication_frm_clipping)
    RadioGroup rbClipping;

    /**
     * 夹闭术过程中并发症 单选 无
     * */
    @BindView(R.id.rb_clipping_complication_no_frm_clipping)
    RadioButton rbClippingNO;

    /**
     * 夹闭术过程中并发症 单选 有
     * */
    @BindView(R.id.rb_clipping_complication_yes_frm_clipping)
    RadioButton rbClippingYes;


    /**
     * 并发症 多选 载瘤动脉闭塞口术中动脉瘤破裂
     * */
    @BindView(R.id.ck_clipping_zldmbskszdmpl_frm_clipping)
    CheckBox ckClippingDMLPL;

    /**
     * 并发症 多选 动脉瘤附近穿支血管闭塞
     * */
    @BindView(R.id.ck_clipping_dmlfjczxgbs_frm_clipping)
    CheckBox ckClippingDMLXGBS;

    /**
     * 并发症 多选 其他术中并发症
     * */
    @BindView(R.id.ck_clipping_qtszbfz_frm_clipping)
    CheckBox ckClippingQTBFZ;

    /**
     * 并发症 多选 其他术中并发症 EditText
     * */
    @BindView(R.id.ed_clipping_qtszbfz_frm_clipping)
    EditText edClippingContentQTBFZ;

    /**
     * 介入途径
     * */
    @BindView(R.id.rb_channelfrm_intervention)
    RadioGroup rbIntervention;

    /**
     * 介入途径 单选 股动脉
     * */
    @BindView(R.id.rb_channel_gdm_frm_intervention)
    RadioButton rbInterventionGDM;

    /**
     * 介入途径 单选 桡动脉
     * */
    @BindView(R.id.rb_channel_rdm_frm_intervention)
    RadioButton rbInterventionRDM;

    /**
     * 弹簧圈 单选 无
     * */
    @BindView(R.id.rb_th_no_frm_intervention)
    RadioButton rbInterventionNoTH;

    /**
     * 弹簧圈 单选 有
     * */
    @BindView(R.id.rb_th_yes_frm_intervention)
    RadioButton rbInterventionYesTH;

    /**
     * 弹簧圈 EditText
     * */
    @BindView(R.id.ed_th_yes_content_frm_intervention)
    EditText rbInterventionContentTH;

    /**
     * 支架
     * */
    @BindView(R.id.rb_zj_frm_intervention)
    RadioGroup rbInterventionBracket;

    /**
     * 支架 单选 无
     * */
    @BindView(R.id.rb_zj_no_frm_intervention)
    RadioButton rbInterventionBracketNo;


    /**
     * 支架 单选 有
     * */
    @BindView(R.id.rb_zj_yes_frm_intervention)
    RadioButton rbInterventionBracketYes;

    /**
     * 支架名称 多选 Wingspan
     * */
    @BindView(R.id.ck_zj_wingspan_frm_intervention)
    CheckBox rbInterventionBracketWingspan;

    /**
     * 支架名称 多选 solitaire
     * */
    @BindView(R.id.ck_zj_solitaire_frm_intervention)
    CheckBox rbInterventionBracketSolitaire;

    /**
     * 支架名称 多选 EnterPrise
     * */
    @BindView(R.id.ck_zj_enterPrise_frm_intervention)
    CheckBox rbInterventionBracketPrise;

    /**
     * 支架名称 多选 Lvis
     * */
    @BindView(R.id.ck_zj_lvisfrm_intervention)
    CheckBox rbInterventionBracketLvis;

    /**
     * 支架名称 多选 neuroform
     * */
    @BindView(R.id.ck_zj_neuroform_intervention)
    CheckBox rbInterventionBrackerNeuroform;

    /**
     * 支架名称 多选 Pipeline
     * */
    @BindView(R.id.ck_zj_pipeline_intervention)
    CheckBox rbInterventionBracketPipeline;

    /**
     * 支架名称 多选 turbirdge
     * */
    @BindView(R.id.ck_zj_turbirdge_intervention)
    CheckBox rbInterventionBracketTurbirdge;

    /**
     * 支架名称 多选 其他
     * */
    @BindView(R.id.ck_zj_qita_intervention)
    CheckBox rbInterventionBracketOther;

    /**
     * 支架名称 多选 其他名称
     * */
    @BindView(R.id.ed_zj_qita_content_intervention)
    EditText edInterventionBracketOtherName;


    /**
     * 球囊
     * */
    @BindView(R.id.rb_channel_qn_intervention)
    RadioGroup rbBalloon;

    /**
     * 球囊 单选 无
     * */
    @BindView(R.id.rb_channel_qn_no_intervention)
    RadioButton rbBalloonNo;

    /**
     * 球囊 单选 有
     * */
    @BindView(R.id.rb_qn_yes_intervention)
    RadioButton rbBalloonYes;

    /**
     * 球囊 名称
     * */
    @BindView(R.id.ed_qn_yes_content_intervention)
    EditText edBalloonName;


    /**
     * 其他栓塞材料 多选 无
     * */
    @BindView(R.id.ck_qtcscl_no_intervention)
    CheckBox ckEmbolicMaterialNo;

    /**
     * 其他栓塞材料 多选 Glubran
     * */
    @BindView(R.id.ck_qtcscl_glubran_intervention)
    CheckBox ckEmbolicMaterialGlubran;

    /**
     * 其他栓塞材料 多选 onyx
     * */
    @BindView(R.id.ck_qtcscl_onyx_intervention)
    CheckBox ckEmbolicMaterialOnyx;

    /**
     * 其他栓塞材料 多选 其他
     * */
    @BindView(R.id.ck_qtcscl_intervention)
    CheckBox ckEmbolicMaterialOther;

    /**
     * 其他栓塞材料 多选 名称
     * */
    @BindView(R.id.ed_qtcscl_content_intervention)
    EditText edEmbolicMaterialName;

    /**
     * 动脉瘤治疗结果 单选 完全闭塞
     * */
    @BindView(R.id.rb_wqbs_intervention)
    RadioButton rbResultsAneurysmWQBS;

    /**
     * 动脉瘤治疗结果 单选 瘤颈残留
     * */
    @BindView(R.id.rb_ljcl_intervention)
    RadioButton rbResultsAneurysmLJCL;

    /**
     * 动脉瘤治疗结果 单选 部分瘤体残留
     * */
    @BindView(R.id.rb_bfljcl_intervention)
    RadioButton rbResultsAneurysmBFLTCL;

    /**
     * 动脉瘤治疗结果 单选 瘤体残留
     * */
    @BindView(R.id.rb_ltcl_intervention)
    RadioButton rbResultsAneurysmLTCL;

    /**
     * 载瘤治疗情况 单选 无弹簧圈突出
     * */
    @BindView(R.id.rb_wthqtc_intervention)
    RadioButton rbTumorBearWTHQTC;

    /**
     * 载瘤治疗情况 单选 有弹簧圈突出
     * */
    @BindView(R.id.rb_ythqtc_intervention)
    RadioButton rbTumorBearYTHQTC;

    /**
     * 载瘤治疗情况 单选 载瘤动脉闭塞
     * */
    @BindView(R.id.rb_zldmbs_intervention)
    RadioButton rbTumorBearDMBS;

    /**
     * 栓塞术过程中并发症 单选 无
     * */
    @BindView(R.id.rb_ssbfz_no_intervention)
    RadioButton rbEmbolizationComplicationNo;

    /**
     * 栓塞术过程中并发症 单选 有
     * */
    @BindView(R.id.rb_ssbfz_yes_intervention)
    RadioButton rbEmbolizationComplicationYes;

    /**
     * 急性血栓形成部位 多选 动脉瘤颈附近
     * */
    @BindView(R.id.ck_dmljfj_intervention)
    CheckBox ckAneurysmNeckNear;

    /**
     * 急性血栓形成部位 多选 载瘤动脉瘤颈以远
     * */
    @BindView(R.id.ck_zldmljyy_intervention)
    CheckBox ckAneurysmNeckFar;

    /**
     * 急性血栓形成部位 多选 非载瘤动脉流域的血管
     * */
    @BindView(R.id.ck_fzdmlydxg_intervention)
    CheckBox ckAneurysmFZDMLYXG;

    /**
     * 急性血栓形成部位 多选 动脉瘤破裂
     * */
    @BindView(R.id.ck_dmlpl_intervention)
    CheckBox ckAneurysmDMLPL;

    /**
     * 急性血栓形成部位 多选 动脉瘤附近穿支血管闭塞
     * */
    @BindView(R.id.ck_dmlxgbs_intervention)
    CheckBox ckAneurysmDMLFJBS;

    /**
     * 急性血栓形成部位 多选 动脉夹层，部位
     * */
    @BindView(R.id.ck_dmjcbw_intervention)
    CheckBox ckAneurysmPosition;

    /**
     * 急性血栓形成部位 多选 动脉夹层，部位描述
     * */
    @BindView(R.id.ed_dmjcbw_content_intervention)
    EditText ckAneurysmPositionContent;

    /**
     * 急性血栓形成部位 多选 其他术中并发症，说明:
     * */
    @BindView(R.id.ck_qtbfz_intervention)
    CheckBox ckAneurysmBFZ;

    /**
     * 急性血栓形成部位 多选 其他术中并发症，说明:
     * */
    @BindView(R.id.ed_qtbfz_content_intervention)
    EditText ckAneurysmContentBFZ;

    @BindView(R.id.include_clipping)
    LinearLayout ckAneurysmClipping;

    @BindView(R.id.include_intervention)
    LinearLayout ckAneurysmIntervention;


    public StrokArterialAneurysmFragment() {
        // Required empty public constructor
    }

    public static StrokArterialAneurysmFragment newInstance(String recordId) {
        StrokArterialAneurysmFragment fragment = new StrokArterialAneurysmFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_arterial_aneurysm;
    }

    @Override
    protected void initView(@NonNull View view) {
        ckStrokeMode.setOnCheckedChangeListener(radioghange);

    }


    private RadioGroup.OnCheckedChangeListener radioghange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == rbInterventionAneurysm.getId()) {

                ckAneurysmIntervention.setVisibility(View.GONE);
                ckAneurysmClipping.setVisibility(View.GONE);
            } else if (checkedId == rbInterventionClipping.getId()) {
                ckAneurysmClipping.setVisibility(View.VISIBLE);
                ckAneurysmIntervention.setVisibility(View.GONE);
            } else if (checkedId == rbInterventionCompound.getId()) {
                ckAneurysmIntervention.setVisibility(View.VISIBLE);
                ckAneurysmClipping.setVisibility(View.GONE);
            }
        }
    };


    @Override
    protected void initListener() {

    }
}
