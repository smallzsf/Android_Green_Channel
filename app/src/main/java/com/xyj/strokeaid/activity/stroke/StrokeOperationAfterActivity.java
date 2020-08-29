package com.xyj.strokeaid.activity.stroke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;

/**
 * StrokeOperationAfterActivity
 * description: 卒中介入手术 术后信息
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_AFTER)
public class StrokeOperationAfterActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_operation_after;
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