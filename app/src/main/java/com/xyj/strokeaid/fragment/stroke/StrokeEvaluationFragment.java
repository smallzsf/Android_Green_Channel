package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.ItemEditBar;

import butterknife.BindView;

/**
 * NihssFragment
 * description: 卒中评估
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
public class StrokeEvaluationFragment extends BaseStrokeFragment {

    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.ieb_fast_ed)
    ItemEditBar iebFastEd;
    @BindView(R.id.ieb_nihss)
    ItemEditBar iebNihss;
    @BindView(R.id.ibe_gcs)
    ItemEditBar ibeGcs;
    @BindView(R.id.ieb_mrs)
    ItemEditBar iebMrs;
    @BindView(R.id.ieb_aspect_ct)
    ItemEditBar iebAspectCt;
    @BindView(R.id.ieb_aspect_mri)
    ItemEditBar iebAspectMri;
    @BindView(R.id.ieb_swallowingassessment)
    ItemEditBar iebSwallowingassessment;

    private String mRecordId;

    public static StrokeEvaluationFragment newInstance(String recordId) {
        StrokeEvaluationFragment fragment = new StrokeEvaluationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(@NonNull View view) {

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
        return R.layout.stroke_fragment_evaluation;
    }

    @Override
    protected void initListener() {
        iebFastEd.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
                    .navigation();
        });
        iebNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_NIHSS)
                    .navigation();
        });
        ibeGcs.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_GCS_SCORE)
                    .navigation();
        });
        iebMrs.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_MRS_SCORE)
                    .navigation();
        });
        iebAspectCt.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_ASPECT_SCORE)
                    .navigation();
        });
        iebAspectMri.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_ASPECT_SCORE)
                    .navigation();
        });
        iebAspectMri.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_SPETZLER_MARINSCORE)
                    .navigation();
        });
        iebSwallowingassessment.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_FROG_FIELD_EVALUATE)
                    .navigation();
        });
    }

}