package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * StrokeOperationBeforeActivity
 * description: TODO
 *
 * @date : 2020/8/30
 */
@Route(path = RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_ON)
public class StrokeOperationOnActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_operation)
    BaseTitleBar titleBarActStrokeMain;

    @BindView(R.id.scrollView_act_stroke_operation)
    ScrollView mScrollView;

    /**
     * 手术过程 tile
     */
    @BindView(R.id.operation_process)
    LinearLayout operationProcess;

    @BindView(R.id.operation_process_line)
    View operationProcessLine;

    /**
     * 手术用药 tile
     */
    @BindView(R.id.surgical_medication)
    LinearLayout surgicalMedication;

    @BindView(R.id.surgical_medication_line)
    View surgicalMedicationLine;

    /**
     * 手术耗材 tile
     */
    @BindView(R.id.surgical_consumables)
    LinearLayout surgicalConsumables;

    @BindView(R.id.surgical_consumables_line)
    View surgicalConsumablesLine;


    /**
     * 血管闭塞部位 原因输入框
     * */
    @BindView(R.id.edit_xgbsbw_act_stroke_operation)
    EditText edVascularOcclusionSite;

    /**
     * 首次检查 单选 8F
     * */
    @BindView(R.id.rb_scjc_8f_act_stroke_operation)
    RadioButton rbFirstInspection8F;

    /**
     * 首次检查 单选 6F
     * */
    @BindView(R.id.rb_scjc_6f_act_stroke_operation)
    RadioButton rbFirstInspection6F;

    /**
     * 首次检查 单选 长鞘
     * */
    @BindView(R.id.rb_scjc_cs_act_stroke_operation)
    RadioButton rbFirstInspectionCS;



    /**
     * 串联病变 单选 是
     * */
    @BindView(R.id.rb_clbb_yes_act_stroke_operation)
    RadioButton rbTandemLesionsYes;


    /**
     * 串联病变 单选 否
     * */
    @BindView(R.id.rb_clbb_no_act_stroke_operation)
    RadioButton rbTandemLesionsNo;

    /**
     * 术前代偿（ACG） 单选 0
     * */
    @BindView(R.id.rb_sqdc0_act_stroke_operation)
    RadioButton rbACG0;

    /**
     * 术前代偿（ACG） 单选 1
     * */
    @BindView(R.id.rb_sqdc1_act_stroke_operation)
    RadioButton rbACG1;

    /**
     * 术前代偿（ACG） 单选 2
     * */
    @BindView(R.id.rb_sqdc2_act_stroke_operation)
    RadioButton rbACG2;

    /**
     * 术前代偿（ACG） 单选 3
     * */
    @BindView(R.id.rb_sqdc3_act_stroke_operation)
    RadioButton rbACG3;

    /**
     * 术前闭塞程度（AOL） 单选 0
     * */
    @BindView(R.id.rb_0_act_stroke_operation)
    RadioButton rbAOL0;

    /**
     * 术前闭塞程度（AOL） 单选 1
     * */
    @BindView(R.id.rb_1_act_stroke_operation)
    RadioButton rbAOL1;

    /**
     * 术前闭塞程度（AOL） 单选 2
     * */
    @BindView(R.id.rb_2_act_stroke_operation)
    RadioButton rbAOL2;

    /**
     * 术前闭塞程度（AOL） 单选 3
     * */
    @BindView(R.id.rb_3_act_stroke_operation)
    RadioButton rbAOL3;

    /**
     * 手术开始
     * */
    @BindView(R.id.ttb_ssks_act_stroke_operation)
    TextTimeBar ttbOperationBegins;

    /**
     * 穿刺完成时间
     * */
    @BindView(R.id.ttb_ccwcsj_act_stroke_operation)
    TextTimeBar ttbPunctureCompleted;

    /**
     * 造影开始
     * */
    @BindView(R.id.ttb_zyks_act_stroke_operation)
    TextTimeBar ttbBradiography;

    /**
     * 微导管通过C1
     * */
    @BindView(R.id.ttb_wdgtg_act_stroke_operation)
    TextTimeBar ttbMicrocatheterC1;

    /**
     * 保护伞到位
     * */
    @BindView(R.id.ttb_bhsdw_act_stroke_operation)
    TextTimeBar ttbUmbrella;

    /**
     * 球囊到位
     * */
    @BindView(R.id.ttb_qndw_act_stroke_operation)
    TextTimeBar ttbBalloon;

    /**
     * 导引导管到位
     * */
    @BindView(R.id.ttb_dydgdw_act_stroke_operation)
    TextTimeBar ttbGuideTube;

    /**
     * 抽吸管管到位
     * */
    @BindView(R.id.ttb_cxgdw_act_stroke_operation)
    TextTimeBar ttbSuctionTube;

    /**
     * 抽吸次数
     * */
    @BindView(R.id.tv_cxcs_act_stroke_operation)
    TextView tvAspirationTimes;

    /**
     * 抽吸时长
     * */
    @BindView(R.id.tv_cxsc_act_stroke_operation)
    TextView tvSuctionDuration;

    /**
     * 取栓次数
     * */
    @BindView(R.id.tv_qscs_act_stroke_operation)
    TextView tvEmbolectomyTimes;

    /**
     * 取栓历次停留时间
     * */
    @BindView(R.id.tv_cxtlsc_act_stroke_operation)
    TextView tvRetentionBoltRemoval;

    /**
     * 首次颅内微导管到位
     * */
    @BindView(R.id.ttb_sclnwdgdw_act_stroke_operation)
    TextTimeBar ttbIntracranialMicrocatheter;

    /**
     * 首次颅内支架到位
     * */
    @BindView(R.id.ttb_sclnzjdw_act_stroke_operation)
    TextTimeBar ttbIntracranialStent;

    /**
     * C1支架时间
     * */
    @BindView(R.id.ttb_c1zjsj_act_stroke_operation)
    TextTimeBar ttbStentTimeC1;

    /**
     * 首次开通等级
     * */
    @BindView(R.id.es_scktdj_act_stroke_operation)
    EditSpinner esFirstOpenLevel;


    /**
     * 首次开通时间
     * */
    @BindView(R.id.ttb_scktsj_act_stroke_operation)
    TextTimeBar ttbFirstOpenTime;

    /**
     * 造影结束
     * */
    @BindView(R.id.ttb_zyjssj_act_stroke_operation)
    TextTimeBar ttbEndAngiography;

    /**
     * 血管开通
     * */
    @BindView(R.id.ttb_xgkt_act_stroke_operation)
    TextTimeBar ttbVascularPatency;

    /**
     * 手术结束
     * */
    @BindView(R.id.ttb_ssjs_act_stroke_operation)
    TextTimeBar ttbOperationFinish;

    /**
     * 术前TICI分级 单选  0
     * */
    @BindView(R.id.rb_sqfj_0_act_stroke_operation)
    RadioButton rbBeforeTICI0;

    /**
     * 术前TICI分级 单选  1
     * */
    @BindView(R.id.rb_sqfj_1_act_stroke_operation)
    RadioButton rbBeforeTICI1;

    /**
     * 术前TICI分级 单选  2a
     * */
    @BindView(R.id.rb_sqfj_2a_act_stroke_operation)
    RadioButton rbBeforeTICI2a;

    /**
     * 术前TICI分级 单选  2b
     * */
    @BindView(R.id.rb_sqfj_2b_act_stroke_operation)
    RadioButton rbBeforeTICI2b;

    /**
     * 术前TICI分级 单选  2c
     * */
    @BindView(R.id.rb_sqfj_2c_act_stroke_operation)
    RadioButton rbBeforeTICI2c;

    /**
     * 术前TICI分级 单选  3
     * */
    @BindView(R.id.rb_sqfj_3_act_stroke_operation)
    RadioButton rbBeforeTICI3;




    /**
     * 术后TICI分级 单选  0
     * */
    @BindView(R.id.rb_a_sqfj_0_act_stroke_operation)
    RadioButton rbAfterTICI0;

    /**
     * 术后TICI分级 单选  1
     * */
    @BindView(R.id.rb_a_sqfj_1_act_stroke_operation)
    RadioButton rbAfterTICI1;

    /**
     * 术后TICI分级 单选  2a
     * */
    @BindView(R.id.rb_a_sqfj_2a_act_stroke_operation)
    RadioButton rbAfterTICI2a;

    /**
     * 术后TICI分级 单选  2b
     * */
    @BindView(R.id.rb_a_sqfj_2b_act_stroke_operation)
    RadioButton rbAfterTICI2b;

    /**
     * 术后TICI分级 单选  2c
     * */
    @BindView(R.id.rb_a_sqfj_2c_act_stroke_operation)
    RadioButton rbAfterTICI2c;

    /**
     * 术后TICI分级 单选  3
     * */
    @BindView(R.id.rb_a_sqfj_3_act_stroke_operation)
    RadioButton rbAfterTICI3;


    /**
     * 首选开通方法 多选 支架取栓
     * */
    @BindView(R.id.checkbox_zjqs_act_stroke_operation)
    CheckBox ckFirstRemovingBoltBracket;

    /**
     * 首选开通方法 多选 抽栓
     * */
    @BindView(R.id.checkbox_cs_act_stroke_operation)
    CheckBox ckFirstThrombusExtraction;

    /**
     * 首选开通方法 多选 球囊成型
     * */
    @BindView(R.id.checkbox_qncx_act_stroke_operation)
    CheckBox ckFirstBalloonMold;

    /**
     * 首选开通方法 多选 支架成型
     * */
    @BindView(R.id.checkbox_zjcx_act_stroke_operation)
    CheckBox ckFirstBracketForming;

    /**
     * 首选开通方法 多选 动脉溶栓
     * */
    @BindView(R.id.checkbox_dmrs_act_stroke_operation)
    CheckBox ckFirstArterialThrombolysis;

    /**
     * 首选开通方法 多选 机械碎栓
     * */
    @BindView(R.id.checkbox_jxss_act_stroke_operation)
    CheckBox ckFirstMechanicalBrokenBolt;

    /**
     * 首选开通方法 多选 其他
     * */
    @BindView(R.id.checkbox_qt_act_stroke_operation)
    CheckBox ckFirstOther;

    /**
     * 补救开通方法 多选 支架取栓
     * */
    @BindView(R.id.checkbox_remedy_zjqs_act_stroke_operation)
    CheckBox ckRemedyRemovingBoltBracket;

    /**
     * 补救开通方法 多选 抽栓
     * */
    @BindView(R.id.checkbox_remedy_cs_act_stroke_operation)
    CheckBox ckRemedyThrombusExtraction;

    /**
     * 补救开通方法 多选 球囊成型
     * */
    @BindView(R.id.checkbox_remedy_qncx_act_stroke_operation)
    CheckBox ckRemedyBalloonMold;

    /**
     * 补救开通方法 多选 支架成型
     * */
    @BindView(R.id.checkbox_remedy_zjcx_act_stroke_operation)
    CheckBox ckRemedyBracketForming;

    /**
     * 补救开通方法 多选 动脉溶栓
     * */
    @BindView(R.id.checkbox_remedy_dmrs_act_stroke_operation)
    CheckBox ckRemedyArterialThrombolysis;

    /**
     * 补救开通方法 多选 机械碎栓
     * */
    @BindView(R.id.checkbox_remedy_jxss_act_stroke_operation)
    CheckBox ckRemedyMechanicalBrokenBolt;

    /**
     * 补救开通方法 多选 其他
     * */
    @BindView(R.id.checkbox_remedy_qt_act_stroke_operation)
    CheckBox ckRemedyOther;

    /**
     * 术前即可HISS评分
     * */
    @BindView(R.id.hiss_score_act_stroke_operation)
    LinearLayout llHissScore;

    /**
     * 溶栓药物 单选  是
     * */
    @BindView(R.id.rb_rs_yes_act_stroke_after)
    RadioButton rbThrombolyticsYes;

    /**
     * 溶栓药物 单选  否
     * */
    @BindView(R.id.rb_rs_no_act_stroke_after)
    RadioButton rbThrombolyticsNo;

    /**
     * 溶栓药物名称
     * */
    @BindView(R.id.es_cath_act_stroke)
    EditSpinner esDrugName;

    /**
     * 溶栓药物使用剂量
     * */
    @BindView(R.id.et_rs_jl)
    EditText esDosage;

    /**
     * 溶栓药物使用部位
     * */
    @BindView(R.id.et_rs_bw)
    EditText esUseSite;

    /**
     * 抗血小板药物 单选 是
     * */
    @BindView(R.id.rb_xxb_yes_act_stroke_operation)
    RadioButton rbAntiplateletDrugsYes;

    /**
     * 抗血小板药物 单选 否
     * */
    @BindView(R.id.rb_xxb_no_act_stroke_operation)
    RadioButton rbAntiplateletDrugsNo;

    /**
     * 抗血小板药物名称
     * */
    @BindView(R.id.es_xxb_act_stroke_operation)
    EditSpinner esAntiplateletDrugName;

    /**
     * 抗血小板药物使用剂量
     * */
    @BindView(R.id.et_xxb_jl)
    EditText esAntiplateletDosage;


    /**
     * 抗血小板药物方式 单选  静脉
     * */
    @BindView(R.id.rb_jm_act_stroke_operation)
    RadioButton rbAntiplateletVein;

    /**
     * 抗血小板药物方式 单选  动脉
     * */
    @BindView(R.id.rb_dm_act_stroke_operation)
    RadioButton rbAntiplateletArtery;


    /**
     * 抗凝药物 单选  是
     * */
    @BindView(R.id.rb_kn_yes_act_stroke_operation)
    RadioButton rbAnticoagulantsYes;

    /**
     * 抗凝药物 单选  否
     * */
    @BindView(R.id.rb_kn_no_act_stroke_operation)
    RadioButton rbAnticoagulantsNo;

    /**
     * 抗凝药物名称
     * */
    @BindView(R.id.es_kn_act_stroke_operation)
    EditSpinner esAnticoagulantsName;

    /**
     * 抗凝药物使用剂量
     * */
    @BindView(R.id.et_kn_jl)
    EditText esAnticoagulantsDosage;

    /**
     * 抗凝药物给药时间
     * */
    @BindView(R.id.ttb_gy_act_stroke_operation)
    TextTimeBar esAnticoagulantsTime;


    /**
     * 麻醉方式 单选  局麻
     * */
    @BindView(R.id.rb_jbm_act_stroke_operation)
    RadioButton rbAnesthesiaLocal;

    /**
     * 麻醉方式 单选  全麻
     * */
    @BindView(R.id.rb_qbm_act_stroke_operation)
    RadioButton rbAnesthesiaAll;

    /**
     * 右美托咪定 单选  是
     * */
    @BindView(R.id.rb_ymtmd_yes_act_stroke_operation)
    RadioButton rbDexmedetomidineYes;

    /**
     * 右美托咪定 单选  否
     * */
    @BindView(R.id.rb_ymtmd_no_act_stroke_operation)
    RadioButton rbDexmedetomidineNo;

    /**
     * 鞘 单选  8F
     * */
    @BindView(R.id.rb_s_8f_act_stroke_operation)
    RadioButton rbSheath8F;

    /**
     * 鞘 单选  6F
     * */
    @BindView(R.id.rb_s_6f_act_stroke_operation)
    RadioButton rbSheath6F;

    /**
     * 鞘 单选  长鞘
     * */
    @BindView(R.id.rb_cs_act_stroke_operation)
    RadioButton rbSheathlong;


    /**
     * 中间导管  单选 5F
     * */
    @BindView(R.id.rb_zjdg_5f_act_stroke_operation)
    RadioButton rbIntermediateCatheter5F;

    /**
     * 中间导管  单选 6F
     * */
    @BindView(R.id.rb_zjdg_6f_act_stroke_operation)
    RadioButton rbIntermediateCatheter6F;

    /**
     * 中间导管  单选 7F
     * */
    @BindView(R.id.rb_zjdg_7f_act_stroke_operation)
    RadioButton rbIntermediateCatheter7F;

    /**
     * 中间导管  单选 8F
     * */
    @BindView(R.id.rb_zjdg_8f_act_stroke_operation)
    RadioButton rbIntermediateCatheter8F;

    /**
     * 中间导管  单选 非球囊导管
     * */
    @BindView(R.id.rb_zjdg_fqndg_act_stroke_operation)
    RadioButton rbIntermediateCatheterNon;

    /**
     * 微导丝  单选 Floopy
     * */
    @BindView(R.id.rb_floopy_act_stroke_operation)
    RadioButton rbMicrowireFloopy;

    /**
     * 微导丝  单选 Synchro
     * */
    @BindView(R.id.rb_synchro_act_stroke_operation)
    RadioButton rbMicrowireSynchro;

    /**
     * 微导丝  单选 Traxcess
     * */
    @BindView(R.id.rb_traxcess_act_stroke_operation)
    RadioButton rbMicrowireTraxcess;

    /**
     * 微导管  单选 Rebar18
     * */
    @BindView(R.id.rb_rebar18_act_stroke_operation)
    RadioButton rbMicrowireRebar18;

    /**
     * 微导管  单选 Rebar27
     * */
    @BindView(R.id.rb_rebar27_act_stroke_operation)
    RadioButton rbMicrowireRebar27;

    /**
     * 微导管  单选 Headway21
     * */
    @BindView(R.id.rb_headway_act_stroke_operation)
    RadioButton rbMicrowireHeadway21;

    /**
     * 取全支架  单选 SolitaireAB
     * */
    @BindView(R.id.rb_solitaireab_act_stroke_operation)
    RadioButton rbBracketSolitaireAB;

    /**
     * 取全支架  单选 Trevo
     * */
    @BindView(R.id.rb_trevo_act_stroke_operation)
    RadioButton rbBracketTrevo;

    /**
     * 取全支架  单选 Revive
     * */
    @BindView(R.id.rb_revive_act_stroke_operation)
    RadioButton rbBracketRevive;

    /**
     * 取全支架  单选 SolitaireFR
     * */
    @BindView(R.id.rb_solitairefr_act_stroke_operation)
    RadioButton rbBracketSolitaireFR;

    /**
     * 取全支架  单选 神通
     * */
    @BindView(R.id.rb_st_act_stroke_operation)
    RadioButton rbBracketST;

    /**
     * 规格  单选 4*15
     * */
    @BindView(R.id.rb_415_act_stroke_operation)
    RadioButton rbSpecifications415;

    /**
     * 规格  单选 4*20
     * */
    @BindView(R.id.rb_420_act_stroke_operation)
    RadioButton rbSpecifications420;

    /**
     * 规格  单选 6*20
     * */
    @BindView(R.id.rb_620_act_stroke_operation)
    RadioButton rbSpecifications620;

    /**
     * 规格  单选 6*30
     * */
    @BindView(R.id.rb_630_act_stroke_operation)
    RadioButton rbSpecifications630;

    /**
     * 规格  单选 4*25
     * */
    @BindView(R.id.rb_425_act_stroke_operation)
    RadioButton rbSpecifications425;


    private int[] location = new  int[2] ;

    private int[] locationAfter = new  int[2] ;



    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_operation;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        llHissScore.getLocationInWindow(location); //获取在当前窗口内的绝对坐标，含toolBar
        llHissScore.getLocationOnScreen(location); //获取在整个屏幕内的绝对坐标，含statusBar

        rbDexmedetomidineYes.getLocationInWindow(locationAfter); //获取在当前窗口内的绝对坐标，含toolBar
        rbDexmedetomidineYes.getLocationOnScreen(locationAfter); //获取在整个屏幕内的绝对坐标，含statusBar
    }

    @Override
    public void initListener() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v -> {

                });

        operationProcess.setOnClickListener(v -> {
            mScrollView.scrollTo(0,0);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
        });

        surgicalMedication.setOnClickListener(v -> {
            mScrollView.scrollTo(0,2800);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));

        });

        surgicalConsumables.setOnClickListener(v -> {
            mScrollView.scrollTo(0,3100);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));

        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


}




