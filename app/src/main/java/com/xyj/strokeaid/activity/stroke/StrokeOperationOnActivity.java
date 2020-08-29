package com.xyj.strokeaid.activity.stroke;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;

/**
 * StrokeOperationAfterActivity
 * description: 卒中介入手术 术前准备
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_ON)
public class StrokeOperationOnActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_operation_on;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }
}