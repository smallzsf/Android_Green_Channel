package com.xyj.strokeaid.activity.stroke.thrombolysis;

import android.app.ProgressDialog;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;

import butterknife.BindView;


/**
 * @Description:  溶栓治疗
 * @Author: ck
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_TREATMENT)
public class ThrombolysisTreatmentActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_treatment)
    BaseTitleBar titleBarActTreatment;

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
//        loading = ProgressDialog.show(mContext, "", "数据获取。。。",true,false);

    }

    @Override
    public void initListener() {
        titleBarActTreatment.setLeftLayoutClickListener(v -> finish());
    }




}
