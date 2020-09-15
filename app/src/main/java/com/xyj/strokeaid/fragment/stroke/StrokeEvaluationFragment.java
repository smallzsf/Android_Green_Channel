package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.event.ScoreEvent;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.ItemEditBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        EventBus.getDefault().register(this);
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
                    .withInt(IntentKey.NIHSS_TYPE, ScoreEvent.TYPE_FAST_ED)
                    .navigation();
        });
        iebNihss.setRightIvOnClickerListener(v -> {
            ARouter.getInstance().build(RouteUrl.Stroke.STROKE_NIHSS)
                    .withInt(IntentKey.NIHSS_TYPE, ScoreEvent.TYPE_NIHSS_FIRST)
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


    /**
     * 事件接收
     *
     * @param event 事件通知
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveScoreEventBus(ScoreEvent event) {
        if (event == null) {
            return;
        }
        if (ScoreEvent.TYPE_NIHSS_FIRST == event.getType()) {
            iebNihss.setEditContent(event.getScore() + "");
            iebNihss.setTag(event.getId() + "");
        }else if (ScoreEvent.TYPE_FAST_ED == event.getType()) {
            iebFastEd.setEditContent(event.getScore() + "");
            iebFastEd.setTag(event.getId() + "");
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}