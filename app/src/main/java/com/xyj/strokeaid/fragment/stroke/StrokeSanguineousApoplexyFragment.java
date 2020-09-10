package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;

/**
 * @Description: 脑出血
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokeSanguineousApoplexyFragment extends BaseStrokeFragment {


    /**
     * 开始时间
     */
    @BindView(R.id.ttb_start_time_fgm_apoplexy)
    TextTimeBar mStartTime;

    /**
     * 麻醉方式
     */
    @BindView(R.id.es_mzfs_fgm_apoplexy)
    EditSpinner esAnesthesiaMode;

    /**
     * 手术方式 多选  开颅血肿清除术
     */
    @BindView(R.id.ck_klxzqcs_fgm_apoplexy)
    CheckBox ckRemovalHematom;

    /**
     * 手术方式 多选  去骨瓣减压术
     */
    @BindView(R.id.ck_qgbjys_fgm_apoplexy)
    CheckBox ckDecompressiveCraniectomy;

    /**
     * 手术方式 多选  脑室镜下血肿抽吸术
     */
    @BindView(R.id.ck_nsjxxzcxs_fgm_apoplexy)
    CheckBox ckIntraventricularAspiration;

    /**
     * 手术方式 多选  钻孔血肿抽吸术
     */
    @BindView(R.id.ck_zkxzcxs_fgm_apoplexy)
    CheckBox ckAspirationHematoma;

    /**
     * 手术方式 多选  其他
     */
    @BindView(R.id.ck_qt_fgm_apoplexy)
    CheckBox ckAspirationOther;

    /**
     * 手术方式 多选  其他 输入
     */
    @BindView(R.id.ck_qt_content_fgm_apoplexy)
    EditText edAspirationOther;

    /**
     * 脑部并发症 多选  无
     */
    @BindView(R.id.ck_nothing_fgm_apoplexy)
    CheckBox ckNothing;

    /**
     * 脑部并发症 多选  手术部位再次脑出血
     */
    @BindView(R.id.ck_ssbwzcncx_fgm_apoplexy)
    CheckBox ckRegionHemorrhage;

    /**
     * 脑部并发症 多选  手术远离部位再次血
     */
    @BindView(R.id.ck_ssylbwzccx_fgm_apoplexy)
    CheckBox ckFarRegionHemorrhage;

    /**
     * 脑部并发症 多选  脑梗死
     */
    @BindView(R.id.ck_ngs_fgm_apoplexy)
    CheckBox ckCerebralInfarction;

    /**
     * 脑部并发症 多选  继发性癫痫
     */
    @BindView(R.id.ck_jfxdx_fgm_apoplexy)
    CheckBox ckSecondaryEpilepsy;

    /**
     * 脑部并发症 多选  颅内感染
     */
    @BindView(R.id.ck_lngr_fgm_apoplexy)
    CheckBox ckIntracranialInfection;


    /**
     * 脑部并发症 多选  其他
     */
    @BindView(R.id.ck_nb_qt_fgm_apoplexy)
    CheckBox ckHeadOther;

    /**
     * 脑部并发症 多选  其他 输入
     */
    @BindView(R.id.ck_nb_qt_content_fgm_apoplexy)
    EditText edHeadOther;


    /**
     * 预后 单选  其他 治愈
     */
    @BindView(R.id.rb_zy_fgm_apoplexy)
    RadioButton rbCure;

    /**
     * 预后 单选  其他 好转
     */
    @BindView(R.id.rb_hz_fgm_apoplexy)
    RadioButton rbBecomeBetter;

    /**
     * 预后 单选  其他 加重
     */
    @BindView(R.id.rb_jz_fgm_apoplexy)
    RadioButton rbAggravate;

    /**
     * 预后 单选  其他 死亡
     */
    @BindView(R.id.rb_sw_fgm_apoplexy)
    RadioButton rbDeath;


    public StrokeSanguineousApoplexyFragment() {
        // Required empty public constructor
    }

    public static StrokeSanguineousApoplexyFragment newInstance(String recordId) {
        StrokeSanguineousApoplexyFragment fragment = new StrokeSanguineousApoplexyFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sanguineous_apoplexy;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
