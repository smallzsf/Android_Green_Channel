package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @Description: 介入知情同意
 * * @Author: crq
 * @CreateDate: 2020/8/29 14:21
 */
@Route(path = RouteUrl.Stroke.STROKE_GET_INVOLVED_INFORMED_CONSENT)
public class GetInvolvedInformedConsentActivity extends BaseActivity {

    @BindView(R.id.es_doc_act_tic)
    EditSpinner esDocActTic;
    @BindView(R.id.es_family_opinion)
    EditSpinner esFamilyOpinion;

    @Override
    public int getLayoutId() {
        return R.layout.activity_get_involved_informed_consent;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        loadData();
    }

    @Override
    public void initListener() {


    }

    private void loadData() {

        //急诊医生
        ArrayList<String> emergencyTreatmentDoctorList = new ArrayList<>();
        emergencyTreatmentDoctorList.add("请选择");
        emergencyTreatmentDoctorList.add("刘超");
        emergencyTreatmentDoctorList.add("原晋毅");
        emergencyTreatmentDoctorList.add("田郑恩");
        emergencyTreatmentDoctorList.add("刘敬玺");
        emergencyTreatmentDoctorList.add("束颖");
        emergencyTreatmentDoctorList.add("曹轮飞");
        emergencyTreatmentDoctorList.add("丁青梅");
        emergencyTreatmentDoctorList.add("刘蕾");
        emergencyTreatmentDoctorList.add("程亚辉");
        esDocActTic.setItemData(emergencyTreatmentDoctorList);
        //家属意见
        ArrayList<String> familyOpinionDoctorList = new ArrayList<>();
        familyOpinionDoctorList.add("同意");
        familyOpinionDoctorList.add("拒绝");
        esFamilyOpinion.setItemData(familyOpinionDoctorList);


    }


}

    
    
       
    