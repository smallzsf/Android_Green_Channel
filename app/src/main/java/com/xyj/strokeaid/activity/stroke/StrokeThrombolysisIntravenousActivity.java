package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.HideBottonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * StrokeIntravenousThrombolysisActivity
 * description: 静脉溶栓
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_INTRAVENOU)
public class StrokeThrombolysisIntravenousActivity extends BaseActivity {

    @BindView(R.id.rl_stroke_thrombolysis_intravenous)
    RelativeLayout rlStrokeThrombolysisIntravenous;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolysis_intravenou;
    }

    @Override
    protected void initInject() {

    }


    @Override
    public void onResume() {
        super.onResume();

        View llBottom = findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(rlStrokeThrombolysisIntravenous, llBottom);
    }


    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }


}

    
    
       
    