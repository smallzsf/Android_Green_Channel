package com.xyj.strokeaid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;

/**
 * NewPatientMedicalRecordActivity
 * description: 新建患者病历  （卒中 、 胸痛 、 创伤）
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.NEW_PATIENT)
public class NewPatientMedicalRecordActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_new_patient_medical_record;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }
}