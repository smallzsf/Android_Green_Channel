package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.xyj.strokeaid.R;
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
public class StrokeOperationAfterActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_after)
    BaseTitleBar titleBarActStrokeMain;


    /**
     * 手术终止 是否终止  yes
     */
    @BindView(R.id.rb_yes_act_stroke_after)
    RadioButton rbStopYse;

    /**
     * 手术终止 是否终止  no
     */
    @BindView(R.id.rb_no_act_stroke_after)
    RadioButton rbStopNO;


    /**
     * 是否延误  yes
     */
    @BindView(R.id.rb_delay_yes_act_stroke_after)
    RadioButton rbDelayYse;

    /**
     * 是否延误  no
     */
    @BindView(R.id.rb_delay_no_act_stroke_after)
    RadioButton rbDelayNo;

    /**
     * 手术终止原因
     */
    @BindView(R.id.edit_zzyy_act_stroke_after)
    EditText edTerminationReasons;

    /**
     * 并发症 无
     */
    @BindView(R.id.checkbox_no_act_stroke_after)
    CheckBox tvNothing;

    /**
     * 并发症 脑梗死
     */
    @BindView(R.id.checkbox_ngs_act_stroke_after)
    CheckBox ckCerebralInfarction;

    /**
     * 并发症 高灌注
     */
    @BindView(R.id.checkbox_ggz_act_stroke_after)
    CheckBox tvStartCatheter;

    /**
     * 并发症 脑出血
     */
    @BindView(R.id.checkbox_ncx_act_stroke_after)
    CheckBox ckHighPerfusion;

    /**
     * 并发症 周围神经损伤
     */
    @BindView(R.id.checkbox_zwsjss_act_stroke_after)
    CheckBox ckPeripheralNerveInjury;

    /**
     * 并发症 切口感染
     */
    @BindView(R.id.checkbox_qkgr_act_stroke_after)
    CheckBox ckIncisionInfection;


    /**
     * 并发症 继发性癫痫
     */
    @BindView(R.id.checkbox_jfxdx_act_stroke_after)
    CheckBox ckSecondaryEpilepsy;


    /**
     * 并发症 肺部感染
     */
    @BindView(R.id.checkbox_fbgr_act_stroke_after)
    CheckBox ckPulmonaryInfection;


    /**
     * 并发症 泌尿系统感染
     */
    @BindView(R.id.checkbox_mnxtgr_act_stroke_after)
    CheckBox ckUrinaryInfection;

    /**
     * 并发症 其他
     */
    @BindView(R.id.checkbox_qt_act_stroke_after)
    CheckBox ckOther;

    //<-------------以下延误原因选项 ------------------>


    /**
     * 无
     */
    @BindView(R.id.checkbox_delay_no_act_stroke_after)
    CheckBox tvDelayNothing;

    /**
     * 脑梗死
     */
    @BindView(R.id.checkbox_delay_ngs_act_stroke_after)
    CheckBox ckDelayCerebralInfarction;

    /**
     * 高灌注
     */
    @BindView(R.id.checkbox_delay_ggz_act_stroke_after)
    CheckBox tvDelayStartCatheter;

    /**
     * 脑出血
     */
    @BindView(R.id.checkbox_delay_ncx_act_stroke_after)
    CheckBox ckDelayHighPerfusion;

    /**
     * 周围神经损伤
     */
    @BindView(R.id.checkbox_delay_zwsjss_act_stroke_after)
    CheckBox ckDelayPeripheralNerveInjury;

    /**
     * 切口感染
     */
    @BindView(R.id.checkbox_delay_qkgr_act_stroke_after)
    CheckBox ckDelayIncisionInfection;


    /**
     * 继发性癫痫
     */
    @BindView(R.id.checkbox_delay_jfxdx_act_stroke_after)
    CheckBox ckDelaySecondaryEpilepsy;


    /**
     * 肺部感染
     */
    @BindView(R.id.checkbox_delay_fbgr_act_stroke_after)
    CheckBox ckDelayPulmonaryInfection;


    /**
     * 泌尿系统感染
     */
    @BindView(R.id.checkbox_delay_mnxtgr_act_stroke_after)
    CheckBox ckDelayUrinaryInfection;

    /**
     * 其他
     */
    @BindView(R.id.checkbox_delay_qt_act_stroke_after)
    CheckBox ckDelayOther;


    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_after;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v -> {

                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


}

    
    
       
    