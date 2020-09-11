package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.flyco.tablayout.SegmentTabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * @Description: ECA
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokEcaFragment extends BaseFragment {

    /**
     * 开始时间
     * */
    @BindView(R.id.ttb_start_time_fgm_cea)
    TextTimeBar mstartTime;

    /**
     * 是否有症状 单选 无
     * */
    @BindView(R.id.rb_symptom_no_fgm_cea)
    RadioButton rbSymptomNo;

    /**
     * 是否有症状 单选 有
     * */
    @BindView(R.id.rb_symptom_yes_fgm_cea)
    RadioButton rbSymptomNoYes;

    /**
     * 手术部位 多选 LICA
     * */
    @BindView(R.id.ck_local_lica_fgm_cea)
    CheckBox rbPositionLICA;

    /**
     * 手术部位 多选 RICA
     * */
    @BindView(R.id.ck_local_rica_fgm_cea)
    CheckBox rbPositionRICA;

    /**
     * 麻醉方式 单选 全麻
     * */
    @BindView(R.id.rb_all_anaesthesia_fgm_cea)
    RadioButton rbAnaesthesiaAll;

    /**
     * 麻醉方式 单选 全麻
     * */
    @BindView(R.id.rb_local_anaesthesia_fgm_cea)
    RadioButton rbAnaesthesiaLocal;

    /**
     * 实施监测手段 多选 TCD
     * */
    @BindView(R.id.ck_tcd_fgm_cea)
    CheckBox rbMonitorTCD;

    /**
     * 实施监测手段 多选 脑电图
     * */
    @BindView(R.id.ck_ndt_fgm_cea)
    CheckBox rbMonitorNDT;

    /**
     * 实施监测手段 多选 其他
     * */
    @BindView(R.id.ck_other_fgm_cea)
    CheckBox rbMonitorOther;

    /**
     * 手术采取方式 单选 标准式CEA
     * */
    @BindView(R.id.rb_bzcea_fgm_cea)
    RadioButton rbModestAndardCEA;

    /**
     * 手术采取方式 单选 外翻式CEA
     * */
    @BindView(R.id.rb_wfcea_fgm_cea)
    RadioButton rbModeValgusCEA;

    /**
     * 手术采取方式 单选 CES
     * */
    @BindView(R.id.rb_ces_fgm_cea)
    RadioButton rbModeCES;

    /**
     * 手术采取方式 单选 复合手术
     * */
    @BindView(R.id.rb_fhss_fgm_cea)
    RadioButton rbModeFHSS;


    /**
     * 是否采用补片 单选 是
     * */
    @BindView(R.id.rb_patch_yes_fgm_cea)
    RadioButton rbPatchYes;

    /**
     * 是否采用补片 单选 否
     * */
    @BindView(R.id.rb_patch_no_fgm_cea)
    RadioButton rbPatchNo;

    /**
     * 并发症 多选 无
     * */
    @BindView(R.id.ck_complication_no_fgm_cea)
    CheckBox ckComplicationNo;

    /**
     * 并发症 多选 脑梗死
     * */
    @BindView(R.id.ck_complication_ngs_fgm_cea)
    CheckBox ckComplicationNGS;

    /**
     * 并发症 多选 高灌注
     * */
    @BindView(R.id.ck_complication_ggz_fgm_cea)
    CheckBox ckComplicationGGZ;

    /**
     * 并发症 多选 脑出血
     * */
    @BindView(R.id.ck_complication_ncx_fgm_cea)
    CheckBox ckComplicationNCX;

    /**
     * 并发症 多选 周围神经损伤
     * */
    @BindView(R.id.ck_complication_zwsjss_fgm_cea)
    CheckBox ckComplicationZWSJ;

    /**
     * 并发症 多选 切口感染
     * */
    @BindView(R.id.ck_complication_qkgr_fgm_cea)
    CheckBox ckComplicationQKGR;

    /**
     * 并发症 多选 继发性癫痫
     * */
    @BindView(R.id.ck_complication_jfxdx_fgm_cea)
    CheckBox ckComplicationJFXDX;

    /**
     * 并发症 多选 肺部感染
     * */
    @BindView(R.id.ck_complication_fbgr_fgm_cea)
    CheckBox ckComplicationFBGR;

    /**
     * 并发症 多选 泌尿系统感染
     * */
    @BindView(R.id.ck_complication_mnxtgr_fgm_cea)
    CheckBox ckComplicationMNXT;

    /**
     * 并发症 多选 其他
     * */
    @BindView(R.id.ck_complication_other_fgm_cea)
    CheckBox ckComplicationOther;


    public StrokEcaFragment() {
        // Required empty public constructor
    }

    public static StrokEcaFragment newInstance(String recordId) {
        StrokEcaFragment fragment = new StrokEcaFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_eca;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
