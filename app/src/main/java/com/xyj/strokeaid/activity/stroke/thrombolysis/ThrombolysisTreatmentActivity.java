package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.StrokeThriveActivity;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.event.ScoreEvent;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;


/**
 * @Description: 溶栓治疗
 * @Author: ck
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_TREATMENT)
public class ThrombolysisTreatmentActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_treatment)
    BaseTitleBar titleBarActTreatment;

    @BindView(R.id.ieb_thrive)
    ItemEditBar iebThrive;


    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

    private ProgressDialog loading;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_thrombolysis;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        iebThrive.setOnClickListener(v -> {
            Intent intent = new Intent(this, StrokeThriveActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void initListener() {
        titleBarActTreatment.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 事件接收
     * @param event 事件通知
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveScoreEventBus(ScoreEvent event) {
        if (event == null) {
            return;
        }
        if (7 == event.getType()) {
            iebThrive.setEditContent(event.getScore() + "");
        }
    }
}
