package com.xyj.strokeaid.activity.stroke;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.PatientCache;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.PreoperativePreparationInfoRequestBean;
import com.xyj.strokeaid.bean.StrokeOperationOnInfoBean;
import com.xyj.strokeaid.distutil.RadioGroupDistUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
     */
    @BindView(R.id.edit_xgbsbw_act_stroke_operation)
    EditText edVascularOcclusionSite;

    /**
     * 手术开始
     */
    @BindView(R.id.ttb_ssks_act_stroke_operation)
    TextTimeBar ttbOperationBegins;

    /**
     * 穿刺完成时间
     */
    @BindView(R.id.ttb_ccwcsj_act_stroke_operation)
    TextTimeBar ttbPunctureCompleted;

    /**
     * 造影开始
     */
    @BindView(R.id.ttb_zyks_act_stroke_operation)
    TextTimeBar ttbBradiography;

    /**
     * 微导管通过C1
     */
    @BindView(R.id.ttb_wdgtg_act_stroke_operation)
    TextTimeBar ttbMicrocatheterC1;

    /**
     * 保护伞到位
     */
    @BindView(R.id.ttb_bhsdw_act_stroke_operation)
    TextTimeBar ttbUmbrella;

    /**
     * 球囊到位
     */
    @BindView(R.id.ttb_qndw_act_stroke_operation)
    TextTimeBar ttbBalloon;

    /**
     * 导引导管到位
     */
    @BindView(R.id.ttb_dydgdw_act_stroke_operation)
    TextTimeBar ttbGuideTube;

    /**
     * 抽吸管管到位
     */
    @BindView(R.id.ttb_cxgdw_act_stroke_operation)
    TextTimeBar ttbSuctionTube;

    /**
     * 抽吸次数
     */
    @BindView(R.id.ieb_cxcs_act_stroke_operation)
    ItemEditBar iebAspirationTimes;

    /**
     * 抽吸时长
     */
    @BindView(R.id.ieb_cxsc_act_stroke_operation)
    ItemEditBar iebSuctionDuration;

    /**
     * 取栓次数
     */
    @BindView(R.id.ieb_qscs_act_stroke_operation)
    ItemEditBar iebEmbolectomyTimes;

    /**
     * 取栓历次停留时间
     */
    @BindView(R.id.ieb_cxtlsc_act_stroke_operation)
    ItemEditBar iebRetentionBoltRemoval;

    /**
     * 首次颅内微导管到位
     */
    @BindView(R.id.ttb_sclnwdgdw_act_stroke_operation)
    TextTimeBar ttbIntracranialMicrocatheter;

    /**
     * 首次颅内支架到位
     */
    @BindView(R.id.ttb_sclnzjdw_act_stroke_operation)
    TextTimeBar ttbIntracranialStent;

    /**
     * C1支架时间
     */
    @BindView(R.id.ttb_c1zjsj_act_stroke_operation)
    TextTimeBar ttbStentTimeC1;

    /**
     * 首次开通等级
     */
    @BindView(R.id.es_scktdj_act_stroke_operation)
    EditSpinner esFirstOpenLevel;


    /**
     * 首次开通时间
     */
    @BindView(R.id.ttb_scktsj_act_stroke_operation)
    TextTimeBar ttbFirstOpenTime;

    /**
     * 造影结束
     */
    @BindView(R.id.ttb_zyjssj_act_stroke_operation)
    TextTimeBar ttbEndAngiography;

    /**
     * 血管开通
     */
    @BindView(R.id.ttb_xgkt_act_stroke_operation)
    TextTimeBar ttbVascularPatency;

    /**
     * 手术结束
     */
    @BindView(R.id.ttb_ssjs_act_stroke_operation)
    TextTimeBar ttbOperationFinish;

    /**
     * 首选开通方法 多选 支架取栓
     */
    @BindView(R.id.checkbox_zjqs_act_stroke_operation)
    CheckBox ckFirstRemovingBoltBracket;

    /**
     * 首选开通方法 多选 抽栓
     */
    @BindView(R.id.checkbox_cs_act_stroke_operation)
    CheckBox ckFirstThrombusExtraction;

    /**
     * 首选开通方法 多选 球囊成型
     */
    @BindView(R.id.checkbox_qncx_act_stroke_operation)
    CheckBox ckFirstBalloonMold;

    /**
     * 首选开通方法 多选 支架成型
     */
    @BindView(R.id.checkbox_zjcx_act_stroke_operation)
    CheckBox ckFirstBracketForming;

    /**
     * 首选开通方法 多选 动脉溶栓
     */
    @BindView(R.id.checkbox_dmrs_act_stroke_operation)
    CheckBox ckFirstArterialThrombolysis;

    /**
     * 首选开通方法 多选 机械碎栓
     */
    @BindView(R.id.checkbox_jxss_act_stroke_operation)
    CheckBox ckFirstMechanicalBrokenBolt;

    /**
     * 首选开通方法 多选 其他
     */
    @BindView(R.id.checkbox_qt_act_stroke_operation)
    CheckBox ckFirstOther;

    /**
     * 补救开通方法 多选 支架取栓
     */
    @BindView(R.id.checkbox_remedy_zjqs_act_stroke_operation)
    CheckBox ckRemedyRemovingBoltBracket;

    /**
     * 补救开通方法 多选 抽栓
     */
    @BindView(R.id.checkbox_remedy_cs_act_stroke_operation)
    CheckBox ckRemedyThrombusExtraction;

    /**
     * 补救开通方法 多选 球囊成型
     */
    @BindView(R.id.checkbox_remedy_qncx_act_stroke_operation)
    CheckBox ckRemedyBalloonMold;

    /**
     * 补救开通方法 多选 支架成型
     */
    @BindView(R.id.checkbox_remedy_zjcx_act_stroke_operation)
    CheckBox ckRemedyBracketForming;

    /**
     * 补救开通方法 多选 动脉溶栓
     */
    @BindView(R.id.checkbox_remedy_dmrs_act_stroke_operation)
    CheckBox ckRemedyArterialThrombolysis;

    /**
     * 补救开通方法 多选 机械碎栓
     */
    @BindView(R.id.checkbox_remedy_jxss_act_stroke_operation)
    CheckBox ckRemedyMechanicalBrokenBolt;

    /**
     * 补救开通方法 多选 其他
     */
    @BindView(R.id.checkbox_remedy_qt_act_stroke_operation)
    CheckBox ckRemedyOther;

    /**
     * 术前即可HISS评分
     */
    @BindView(R.id.hiss_score_act_stroke_operation)
    LinearLayout llHissScore;

    /**
     * 溶栓药物名称
     */
    @BindView(R.id.es_cath_act_stroke)
    EditSpinner esDrugName;

    /**
     * 溶栓药物使用剂量
     */
    @BindView(R.id.ieb_rs_jl)
    ItemEditBar iebRsJl;

    /**
     * 溶栓药物使用部位
     */
    @BindView(R.id.ieb_rs_bw)
    ItemEditBar iebRsBw;

    /**
     * 抗血小板药物名称
     */
    @BindView(R.id.es_xxb_act_stroke_operation)
    EditSpinner esAntiplateletDrugName;

    /**
     * 抗血小板药物使用剂量
     */
    @BindView(R.id.ieb_xbb_jl)
    ItemEditBar iebXbbJl;

    /**
     * 抗凝药物名称
     */
    @BindView(R.id.es_kn_act_stroke_operation)
    EditSpinner esAnticoagulantsName;

    /**
     * 抗凝药物使用剂量
     */
    @BindView(R.id.ieb_kn_jl)
    ItemEditBar iebKnJl;

    /**
     * 抗凝药物给药时间
     */
    @BindView(R.id.ttb_gy_act_stroke_operation)
    TextTimeBar esAnticoagulantsTime;

    @BindView(R.id.rg_first_check)
    MyRadioGroup rgFirstCheck;
    @BindView(R.id.rg_clbb)
    MyRadioGroup rgClbb;
    @BindView(R.id.rg_sqdc)
    MyRadioGroup rgSqdc;
    @BindView(R.id.rg_sqbscd)
    MyRadioGroup rgSqbscd;
    @BindView(R.id.rg_shbscd)
    MyRadioGroup rgShbscd;
    @BindView(R.id.rg_sqfj)
    MyRadioGroup rgSqfj;
    @BindView(R.id.rg_shfj)
    MyRadioGroup rgShfj;
    @BindView(R.id.rg_rsyw)
    MyRadioGroup rgRsyw;
    @BindView(R.id.rg_kxxbyw)
    MyRadioGroup rgKxxbyw;
    @BindView(R.id.rg_ywfs)
    MyRadioGroup rgYwfs;
    @BindView(R.id.rg_knyw)
    MyRadioGroup rgKnyw;
    @BindView(R.id.rg_mzfs)
    MyRadioGroup rgMzfs;
    @BindView(R.id.rg_ymtmd)
    MyRadioGroup rgYmtmd;
    @BindView(R.id.rg_qiao)
    MyRadioGroup rgQiao;
    @BindView(R.id.rg_zjdg)
    MyRadioGroup rgZjdg;
    @BindView(R.id.rg_wds)
    MyRadioGroup rgWds;
    @BindView(R.id.rg_wdg)
    MyRadioGroup rgWdg;
    @BindView(R.id.rg_qqzj)
    MyRadioGroup rgQqzj;
    @BindView(R.id.rg_gg)
    MyRadioGroup rgGg;
    @BindView(R.id.rg_dydg)
    MyRadioGroup rgDydg;


    private int location = 0;

    private int locationAfter = 0;

    private LinkedHashMap<CheckBox, String> bjkkffMap;
    private LinkedHashMap<CheckBox, String> sxktffMap;

    private StrokeOperationOnInfoBean data;
    //TODO 修改mRecordId
    private String mRecordId = "1111";

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_operation;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        mRecordId = PatientCache.getRecordId();
        bindRadioGroupMap();
        initCheckBoxMap();
        initES();
        location = llHissScore.getTop();
        locationAfter = llHissScore.getTop();
        getData();
    }

    @Override
    public void initListener() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    saveData();
                });

        operationProcess.setOnClickListener(v -> {
            mScrollView.scrollTo(0, 0);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
        });

        surgicalMedication.setOnClickListener(v -> {
            mScrollView.scrollTo(0, 2500);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
        });

        surgicalConsumables.setOnClickListener(v -> {
            mScrollView.scrollTo(0, 3000);
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
        });

    }

    private void bindRadioGroupMap() {
        Map<String, String> firstCheckMap = new HashMap<>();
        firstCheckMap.put("cpc_sgjc_negative", "阴性");
        firstCheckMap.put("cpc_sgjc_positive", "阳性");
        firstCheckMap.put("cpc_sgjc_wz", "未做");
        rgFirstCheck.setTag(firstCheckMap);

        Map<String, String> clbbMap = new HashMap<>();
        clbbMap.put("cpc_bool_true", "是");
        clbbMap.put("cpc_bool_false", "否");
        rgClbb.setTag(clbbMap);

        Map<String, String> sqdcMap = new HashMap<>();
        sqdcMap.put("cpc_acg_0", "0");
        sqdcMap.put("cpc_acg_1", "1");
        sqdcMap.put("cpc_acg_2", "2");
        sqdcMap.put("cpc_acg_3", "3");
        sqdcMap.put("cpc_acg_4", "4");
        rgSqdc.setTag(sqdcMap);

        Map<String, String> sqbscdMap = new HashMap<>();
        sqbscdMap.put("cpc_aol_0", "0");
        sqbscdMap.put("cpc_aol_1", "1");
        sqbscdMap.put("cpc_aol_2", "2");
        sqbscdMap.put("cpc_aol_3", "3");
        rgSqbscd.setTag(sqbscdMap);

        Map<String, String> rgShbscdMap = new HashMap<>();
        rgShbscdMap.put("cpc_aol_0", "0");
        rgShbscdMap.put("cpc_aol_1", "1");
        rgShbscdMap.put("cpc_aol_2", "2");
        rgShbscdMap.put("cpc_aol_3", "3");
        rgShbscd.setTag(rgShbscdMap);

        Map<String, String> sqfjMap = new HashMap<>();
        sqfjMap.put("cpc_tici_zero", "0");
        sqfjMap.put("cpc_tici_one", "1");
        sqfjMap.put("cpc_tici_twoa", "2a");
        sqfjMap.put("cpc_tici_twob", "2b");
        sqfjMap.put("cpc_tici_twoc", "2c");
        sqfjMap.put("cpc_tici_three", "3");
        rgSqfj.setTag(sqfjMap);

        Map<String, String> rgShfjMap = new HashMap<>();
        rgShfjMap.put("cpc_tici_zero", "0");
        rgShfjMap.put("cpc_tici_one", "1");
        rgShfjMap.put("cpc_tici_twoa", "2a");
        rgShfjMap.put("cpc_tici_twob", "2b");
        rgShfjMap.put("cpc_tici_twoc", "2c");
        rgShfjMap.put("cpc_tici_three", "3");
        rgShfj.setTag(rgShfjMap);

        Map<String, String> rgRsywMap = new HashMap<>();
        rgRsywMap.put("cpc_bool_true", "是");
        rgRsywMap.put("cpc_bool_false", "否");
        rgRsyw.setTag(rgRsywMap);


        Map<String, String> rgKxxbywMap = new HashMap<>();
        rgKxxbywMap.put("cpc_bool_true", "是");
        rgKxxbywMap.put("cpc_bool_false", "否");
        rgKxxbyw.setTag(rgKxxbywMap);

        Map<String, String> rgYwfsMap = new HashMap<>();
        rgYwfsMap.put("cpc_strokkxxbfs_jm", "静脉");
        rgYwfsMap.put("cpc_strokkxxbfs_dm", "动脉");
        rgYwfs.setTag(rgYwfsMap);


        Map<String, String> rgKnywMap = new HashMap<>();
        rgKxxbywMap.put("cpc_bool_true", "是");
        rgKxxbywMap.put("cpc_bool_false", "否");
        rgKnyw.setTag(rgKnywMap);


        Map<String, String> rgMzfsMap = new HashMap<>();
        rgMzfsMap.put("cpc_jrmzfs_qm", "全麻");
        rgMzfsMap.put("cpc_jrmzfs_gcmz", "颈从麻醉");
        rgMzfsMap.put("cpc_jrmzfs_jxfhmz", "静吸复合麻醉");
        rgMzfsMap.put("cpc_jrmzfs_qgmz", "气管麻醉");
        rgMzfsMap.put("cpc_jrmzfs_cgqm", "插管全麻");
        rgMzfsMap.put("cpc_jrmzfs_xrmz", "吸入麻醉");
        rgMzfsMap.put("cpc_jrmzfs_bm", "表麻");
        rgMzfsMap.put("cpc_jrmzfs_jm", "局麻");
        rgMzfsMap.put("cpc_jrmzfs_ym", "腰麻");
        rgMzfsMap.put("cpc_jrmzfs_jmmz", "静脉麻醉");
        rgMzfsMap.put("cpc_jrmzfs_jcmz", "基础麻醉");
        rgMzfsMap.put("cpc_jrmzfs_jcmzjm", "基础麻醉+局麻");
        rgMzfsMap.put("cpc_jrmzfs_dm", "骶麻");
        rgMzfsMap.put("cpc_jrmzfs_bcmz", "臂丛麻醉");
        rgMzfsMap.put("cpc_jrmzfs_yylhmz", "腰硬联合麻醉");
        rgMzfsMap.put("cpc_jrmzfs_wmz", "未麻醉");
        rgMzfsMap.put("cpc_jrmzfs_qt", "其他");
        rgMzfsMap.put("cpc_jrmzfs_w", "无");
        rgMzfs.setTag(rgMzfsMap);

        Map<String, String> rgYmtmdMap = new HashMap<>();
        rgYmtmdMap.put("cpc_bool_true", "是");
        rgYmtmdMap.put("cpc_bool_false", "否");
        rgYmtmd.setTag(rgYmtmdMap);

        Map<String, String> rgQiaoMap = new HashMap<>();
        rgQiaoMap.put("cpc_bool_true", "是");
        rgQiaoMap.put("cpc_bool_false", "否");
        rgQiao.setTag(rgQiaoMap);

        Map<String, String> rgZjdgMap = new HashMap<>();
        rgZjdgMap.put("cpc_hczjdg_navein", "Navein");
        rgZjdgMap.put("cpc_hczjdg_dac", "DAC");
        rgZjdgMap.put("cpc_hczjdg_cat5", "CAT5");
        rgZjdgMap.put("cpc_hczjdg_cat6", "CAT6");
        rgZjdgMap.put("cpc_hczjdg_sofia", "Sofia");
        rgZjdgMap.put("cpc_hczjdg_qt", "其他");
        rgZjdg.setTag(rgZjdgMap);

        Map<String, String> rgDydgMap = new HashMap<>();
        rgDydgMap.put("cpc_hcdydg_5f","5F");
        rgDydgMap.put("cpc_hcdydg_6f","6F");
        rgDydgMap.put("cpc_hcdydg_7f","7F");
        rgDydgMap.put("cpc_hcdydg_8f","8F");
        rgDydgMap.put("cpc_hcdydg_fqndg","非球囊导管");
        rgDydg.setTag(rgDydgMap);

        Map<String, String> rgWdsMap = new HashMap<>();
        rgWdsMap.put("cpc_hcwds_floppy", "Floppy");
        rgWdsMap.put("cpc_hcwds_synchro", "Synchro");
        rgWdsMap.put("cpc_hcwds_traxcess", "Traxcess");
        rgWds.setTag(rgWdsMap);

        Map<String, String> rgWdgMap = new HashMap<>();
        rgWdgMap.put("cpc_hcwdg_rebar18", "Rebar18");
        rgWdgMap.put("cpc_hcwdg_rebar27", "Rebar27");
        rgWdgMap.put("cpc_hcwdg_headway21", "Headway21");
        rgWdgMap.put("cpc_hcwdg_frepass", "Frepass");
        rgWdg.setTag(rgWdgMap);

        Map<String, String> rgQqzjMap = new HashMap<>();
        rgQqzjMap.put("cpc_qszj_ab", "SolitaireAB");
        rgQqzjMap.put("cpc_qszj_trevo", "Trevo");
        rgQqzjMap.put("cpc_qszj_reco", "Reco");
        rgQqzjMap.put("cpc_qszj_revive", "Revive");
        rgQqzjMap.put("cpc_qszj_solitairefr", "SolitaireFR");
        rgQqzjMap.put("cpc_qszj_st", "神通");
        rgQqzj.setTag(rgQqzjMap);

        Map<String, String> rgGgMap = new HashMap<>();
        rgGgMap.put("cpc_spec_60", "4*15");
        rgGgMap.put("cpc_spec_80", "4*20");
        rgGgMap.put("cpc_spec_120", "6*20");
        rgGgMap.put("cpc_spec_180", "6*30");
        rgGgMap.put("cpc_spec_100", "4*25");
        rgGg.setTag(rgGgMap);

    }

    private void initCheckBoxMap() {

        sxktffMap = new LinkedHashMap<>();
        sxktffMap.put(ckFirstRemovingBoltBracket, "cpc_xgktff_zjqs");
        sxktffMap.put(ckFirstThrombusExtraction, "cpc_xgktff_cs");
        sxktffMap.put(ckFirstBalloonMold, "cpc_xgktff_qncx");
        sxktffMap.put(ckFirstBracketForming, "cpc_xgktff_zjcx");
        sxktffMap.put(ckFirstArterialThrombolysis, "cpc_xgktff_dmrs");
        sxktffMap.put(ckFirstMechanicalBrokenBolt, "cpc_xgktff_jxss");
        sxktffMap.put(ckFirstOther, "cpc_xgktff_qt");

        bjkkffMap = new LinkedHashMap<>();
        bjkkffMap.put(ckRemedyRemovingBoltBracket, "cpc_xgktff_zjqs");
        bjkkffMap.put(ckRemedyThrombusExtraction, "cpc_xgktff_cs");
        bjkkffMap.put(ckRemedyBalloonMold, "cpc_xgktff_qncx");
        bjkkffMap.put(ckRemedyBracketForming, "cpc_xgktff_zjcx");
        bjkkffMap.put(ckRemedyArterialThrombolysis, "cpc_xgktff_dmrs");
        bjkkffMap.put(ckRemedyMechanicalBrokenBolt, "cpc_xgktff_jxss");
        bjkkffMap.put(ckRemedyOther, "cpc_xgktff_qt");
    }

    private void initES() {
        List<EditSpinner.ESItem> firstOpenLevel = new ArrayList<>();
        firstOpenLevel.add(new EditSpinner.ESItem("cpc_scktdj_sc2b", "首次2b"));
        firstOpenLevel.add(new EditSpinner.ESItem("cpc_scktdj_sc2c", "首次2c"));
        firstOpenLevel.add(new EditSpinner.ESItem("cpc_scktdj_sc3j", "首次3级"));
        esFirstOpenLevel.setESItemData(firstOpenLevel);
        esFirstOpenLevel.setTag(firstOpenLevel);

        List<EditSpinner.ESItem> esAntiplateletDrugNameValue = new ArrayList<>();
        esAntiplateletDrugNameValue.add(new EditSpinner.ESItem("cpc_strokkxxbyw_tlfb", "替罗非班"));
        esAntiplateletDrugNameValue.add(new EditSpinner.ESItem("cpc_strokkxxbyw_ytbt", "依替巴肽"));
        esAntiplateletDrugName.setESItemData(esAntiplateletDrugNameValue);
        esAntiplateletDrugName.setTag(esAntiplateletDrugNameValue);


        List<EditSpinner.ESItem> esDrugNameList = new ArrayList<>();
        esDrugNameList.add(new EditSpinner.ESItem("cpc_strokersyw_rtpa", "rt-PA"));
        esDrugNameList.add(new EditSpinner.ESItem("cpc_strokersyw_njm", "尿激酶"));
        esDrugName.setESItemData(esDrugNameList);
        esDrugName.setTag(esDrugNameList);


        List<EditSpinner.ESItem> esAnticoagulantsNameValue = new ArrayList<>();
        esAnticoagulantsNameValue.add(new EditSpinner.ESItem("cpc_sckngy_ptgs", "普通肝素"));
        esAnticoagulantsNameValue.add(new EditSpinner.ESItem("cpc_sckngy_dfzgs", "低分子肝素"));
        esAnticoagulantsName.setESItemData(esAnticoagulantsNameValue);
        esAnticoagulantsName.setTag(esAnticoagulantsNameValue);

    }

    private String getSelectCheckBoxTxt(LinkedHashMap<CheckBox, String> map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<CheckBox, String> entry : map.entrySet()) {
            if (entry.getKey().isChecked()) {
                stringBuilder.append(entry.getValue()).append(",");
            }
        }

        String text = stringBuilder.toString();
        return TextUtils.isEmpty(text) ?  "" : text.substring(0, text.length() - 1) ;
    }

    private void selectCheckBoxTxt(LinkedHashMap<CheckBox, String> map, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        String[] split = text.split(",");
        List<String> valueList = Arrays.asList(split);

        for (Map.Entry<CheckBox, String> entry : map.entrySet()) {
            if (valueList.contains(entry.getValue())) {
                entry.getKey().setChecked(true);
            }
        }
    }

    private void setEsText(EditSpinner es, String key) {
        List<EditSpinner.ESItem> list = (List<EditSpinner.ESItem>) es.getTag();
        for (EditSpinner.ESItem esItem : list) {
            if (esItem.value.equals(key)) {
                es.setText(esItem.value);
                return;
            }
        }
    }

    private void showData() {
        if (data == null) {
            return;
        }
        edVascularOcclusionSite.setText(data.getVesselocclusivesite());
        RadioGroupDistUtil.selectRadioButtonByMap(rgFirstCheck,data.getEmbolectomyfirstexamine(), (Map<String, String>) rgFirstCheck.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgClbb,data.getIstandemlesion(), (Map<String, String>) rgClbb.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgSqdc,data.getPreembolectomyacg(), (Map<String, String>) rgSqdc.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgSqbscd,data.getPreembolectomyaol(), (Map<String, String>) rgSqbscd.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgShbscd,data.getAfterembolectomyaol(), (Map<String, String>) rgShbscd.getTag());
        //手术开始时间
        ttbOperationBegins.setTime(data.getOperationbegintime());
        //穿刺结束时间
        ttbPunctureCompleted.setTime(data.getPunctureendtime());
        //造影开始
        ttbBradiography.setTime(data.getCagbegintime());
        //	微导管通过C1
        ttbMicrocatheterC1.setTime(data.getPassconetime());
        //	保护伞到位
        ttbUmbrella.setTime(data.getUmbrellareadytime());
        //	球囊到位
        ttbBalloon.setTime(data.getBalloonreadytime());
        //	导引导管到位
        ttbGuideTube.setTime(data.getLeadcatheterreadytime());
        //抽吸管到位
        ttbSuctionTube.setTime(data.getSuctionpipereadytime());
        //抽吸次数
        iebAspirationTimes.setEditContent(data.getSuctioncount());
        //抽吸时长
        iebSuctionDuration.setEditContent(data.getSuctiontimespan());
        //取栓次数
        iebEmbolectomyTimes.setEditContent(data.getEmbolectomycount());
        //取栓历次停留时长
        iebRetentionBoltRemoval.setEditContent(data.getEmbolectomytotaltimespan());
        ttbIntracranialMicrocatheter.setTime(data.getFirstmicrocatheterintracranialready());
        ttbIntracranialStent.setTime(data.getFirstplugintracranialready());
        ttbStentTimeC1.setTime(data.getC1brackettime());
        //首次开通等级
        esFirstOpenLevel.setText(data.getFirstvascularopeninglevel());
        ttbFirstOpenTime.setTime(data.getFirstvascularopeningtime());
        ttbEndAngiography.setTime(data.getCagendtime());
        ttbVascularPatency.setTime(data.getVascularopeningtime());
        ttbOperationFinish.setTime(data.getOperationendtime());
        RadioGroupDistUtil.selectRadioButtonByMap(rgSqfj,data.getPreoperativetici(), (Map<String, String>) rgSqfj.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgShfj,data.getPostoperativetici(), (Map<String, String>) rgShfj.getTag());
        //首选开通方法
        selectCheckBoxTxt(sxktffMap,data.getVascularopeningway());
        selectCheckBoxTxt(bjkkffMap,data.getRemedyvascularopeningway());
        RadioGroupDistUtil.selectRadioButtonByMap(rgQiao,data.getSheath(), (Map<String, String>) rgQiao.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgZjdg,data.getMiddlecatheter(), (Map<String, String>) rgZjdg.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgDydg,data.getLeadcatheter(), (Map<String, String>) rgDydg.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgWds,data.getMicroguidewire(), (Map<String, String>) rgWds.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgWdg,data.getMicrocatheter(), (Map<String, String>) rgWdg.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgQqzj,data.getPlugtype(), (Map<String, String>) rgQqzj.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgGg,data.getSpecifications(), (Map<String, String>) rgGg.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgRsyw,data.getIsusethrombolyticdrug(), (Map<String, String>) rgRsyw.getTag());
        esDrugName.setText(data.getEmbolectomythrombolyticdrug());
        iebRsJl.setEditContent(data.getEmbolectomythrombolyticdrugdosage());
        iebRsBw.setEditContent(data.getEmbolectomythrombolyticsite());

        RadioGroupDistUtil.selectRadioButtonByMap(rgKxxbyw,data.getIsuseantiplateletdrug(), (Map<String, String>) rgKxxbyw.getTag());

        esAntiplateletDrugName.setText(data.getEmbolectomyantiplateletdrug());
        iebXbbJl.setEditContent(data.getEmbolectomyantiplateletdrugdosage());
        RadioGroupDistUtil.selectRadioButtonByMap(rgYwfs,data.getEmbolectomyantiplateletway(), (Map<String, String>) rgYwfs.getTag());

        RadioGroupDistUtil.selectRadioButtonByMap(rgKnyw,data.getIsuseanticoagulantdrug(), (Map<String, String>) rgKnyw.getTag());
        esAnticoagulantsName.setText(data.getEmbolectomyanticoagulantdrug());
        esAnticoagulantsTime.setTime(data.getAnticoagulantmedicinetime());
        RadioGroupDistUtil.selectRadioButtonByMap(rgMzfs,data.getEmbolectomyanesthesiamode(), (Map<String, String>) rgMzfs.getTag());
        RadioGroupDistUtil.selectRadioButtonByMap(rgYmtmd,data.getIsusedexmedetomidine(), (Map<String, String>) rgYmtmd.getTag());

    }

    private StrokeOperationOnInfoBean getSavedData() {
        StrokeOperationOnInfoBean savedData = new StrokeOperationOnInfoBean();
        savedData.setVesselocclusivesite(edVascularOcclusionSite.getText().toString());
        savedData.setEmbolectomyfirstexamine(RadioGroupDistUtil.getSelectRadioButtonTag(rgFirstCheck, (Map<String, String>) rgFirstCheck.getTag()));
        savedData.setIstandemlesion(RadioGroupDistUtil.getSelectRadioButtonTag(rgClbb, (Map<String, String>) rgClbb.getTag()));
        savedData.setPreembolectomyacg(RadioGroupDistUtil.getSelectRadioButtonTag(rgSqdc, (Map<String, String>) rgSqdc.getTag()));
        savedData.setPreembolectomyaol(RadioGroupDistUtil.getSelectRadioButtonTag(rgSqbscd, (Map<String, String>) rgSqbscd.getTag()));
        savedData.setAfterembolectomyaol(RadioGroupDistUtil.getSelectRadioButtonTag(rgShbscd, (Map<String, String>) rgShbscd.getTag()));
        //手术开始时间
        savedData.setOperationbegintime(ttbOperationBegins.getTime());
        //穿刺结束时间
        savedData.setPunctureendtime(ttbPunctureCompleted.getTime());
        //造影开始
        savedData.setCagbegintime(ttbBradiography.getTime());
        //	微导管通过C1
        savedData.setPassconetime(ttbMicrocatheterC1.getTime());
        //	保护伞到位
        savedData.setUmbrellareadytime(ttbUmbrella.getTime());
        //	球囊到位
        savedData.setBalloonreadytime(ttbBalloon.getTime());
        //	导引导管到位
        savedData.setLeadcatheterreadytime(ttbGuideTube.getTime());
        //抽吸管到位
        savedData.setSuctionpipereadytime(ttbSuctionTube.getTime());
        //抽吸次数
        savedData.setSuctioncount(iebAspirationTimes.getEditContent());
        //抽吸时长
        savedData.setSuctiontimespan(iebSuctionDuration.getEditContent());
        //取栓次数
        savedData.setEmbolectomycount(iebEmbolectomyTimes.getEditContent());
        //取栓历次停留时长
        savedData.setEmbolectomytotaltimespan(iebRetentionBoltRemoval.getEditContent());
        savedData.setFirstmicrocatheterintracranialready(ttbIntracranialMicrocatheter.getTime());
        savedData.setFirstplugintracranialready(ttbIntracranialStent.getTime());
        savedData.setC1brackettime(ttbStentTimeC1.getTime());
        //首次开通等级
        savedData.setFirstvascularopeninglevel(esFirstOpenLevel.getText());
        savedData.setFirstvascularopeningtime(ttbFirstOpenTime.getTime());
        savedData.setCagendtime(ttbEndAngiography.getTime());
        savedData.setVascularopeningtime(ttbVascularPatency.getTime());
        savedData.setVascularopeningtime(ttbVascularPatency.getTime());
        savedData.setOperationendtime(ttbOperationFinish.getTime());
        savedData.setPreoperativetici(RadioGroupDistUtil.getSelectRadioButtonTag(rgSqfj, (Map<String, String>) rgSqfj.getTag()));
        savedData.setPostoperativetici(RadioGroupDistUtil.getSelectRadioButtonTag(rgShfj, (Map<String, String>) rgShfj.getTag()));
        //首选开通方法
        savedData.setVascularopeningway(getSelectCheckBoxTxt(sxktffMap));
        savedData.setRemedyvascularopeningway(getSelectCheckBoxTxt(bjkkffMap));
        savedData.setSheath(RadioGroupDistUtil.getSelectRadioButtonTag(rgQiao, (Map<String, String>) rgQiao.getTag()));
        savedData.setMiddlecatheter(RadioGroupDistUtil.getSelectRadioButtonTag(rgZjdg, (Map<String, String>) rgZjdg.getTag()));
        savedData.setLeadcatheter(RadioGroupDistUtil.getSelectRadioButtonTag(rgDydg, (Map<String, String>) rgDydg.getTag()));
        savedData.setMicroguidewire(RadioGroupDistUtil.getSelectRadioButtonTag(rgWds, (Map<String, String>) rgWds.getTag()));
        savedData.setMicrocatheter(RadioGroupDistUtil.getSelectRadioButtonTag(rgWdg, (Map<String, String>) rgWdg.getTag()));
        savedData.setPlugtype(RadioGroupDistUtil.getSelectRadioButtonTag(rgQqzj, (Map<String, String>) rgQqzj.getTag()));
        savedData.setSpecifications(RadioGroupDistUtil.getSelectRadioButtonTag(rgGg, (Map<String, String>) rgGg.getTag()));
        savedData.setIsusethrombolyticdrug(RadioGroupDistUtil.getSelectRadioButtonTag(rgRsyw, (Map<String, String>) rgRsyw.getTag()));
        savedData.setEmbolectomythrombolyticdrug(esDrugName.getText());
        savedData.setEmbolectomythrombolyticdrugdosage(iebRsJl.getEditContent());
        savedData.setEmbolectomythrombolyticsite(iebRsBw.getEditContent());

        savedData.setIsuseantiplateletdrug(RadioGroupDistUtil.getSelectRadioButtonTag(rgKxxbyw, (Map<String, String>) rgKxxbyw.getTag()));
        savedData.setEmbolectomythrombolyticdrug(esAntiplateletDrugName.getText());
        savedData.setEmbolectomyantiplateletdrugdosage(iebXbbJl.getEditContent());
        savedData.setEmbolectomyantiplateletway(RadioGroupDistUtil.getSelectRadioButtonTag(rgYwfs, (Map<String, String>) rgYwfs.getTag()));

        savedData.setIsuseanticoagulantdrug(RadioGroupDistUtil.getSelectRadioButtonTag(rgKnyw, (Map<String, String>) rgKxxbyw.getTag()));
        savedData.setEmbolectomyanticoagulantdrug(esAnticoagulantsName.getText());
        savedData.setAnticoagulantmedicinetime(esAnticoagulantsTime.getTime());
        savedData.setEmbolectomyanesthesiamode(RadioGroupDistUtil.getSelectRadioButtonTag(rgMzfs, (Map<String, String>) rgMzfs.getTag()));
        savedData.setIsusedexmedetomidine(RadioGroupDistUtil.getSelectRadioButtonTag(rgYmtmd, (Map<String, String>) rgYmtmd.getTag()));

        return savedData;
    }

    private void saveData() {
        BaseRequestBean<StrokeOperationOnInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, getSavedData());

        RetrofitClient.getInstance().getApi()
                .saveStrokeOperationOnInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    private void getData() {
        BaseRequestBean<StrokeOperationOnInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new StrokeOperationOnInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getStrokeOperationOnInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeOperationOnInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeOperationOnInfoBean>> call, Response<BaseResponseBean<StrokeOperationOnInfoBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("获取数据成功");
                                if (response.body().getData() != null) {
                                    data = response.body().getData().getData();
                                    showData();
                                }

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeOperationOnInfoBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }


}




