package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.HomePatientBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * HomePatientRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/17
 * email ：licy3051@qq.com
 */
public class HomePatientRvAdapter extends BaseQuickAdapter<HomePatientBean, BaseViewHolder> {

    public HomePatientRvAdapter(@Nullable List<HomePatientBean> data) {
        super(R.layout.adapter_rv_home_patient_item, data);
        addChildClickViewIds(R.id.tv_detail_item_patient, R.id.tv_time_node_item_patient);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, HomePatientBean homePatientBean) {
        baseViewHolder.setText(R.id.tv_name_item_patient, homePatientBean.getName())
                .setText(R.id.tv_sex_and_age_item_patient,
                        getContext().getString(R.string.sex_and_age_with_para, getSexAndAgeString(homePatientBean.getSex(), homePatientBean.getAge())))
                .setText(R.id.tv_disease_type_item_patient, getDiseaseNameByType(homePatientBean.getDiseaseType()))
                .setText(R.id.tv_start_time_item_patient, getContext().getString(R.string.patient_start_disease_time, homePatientBean.getStartDiseaseTime()))
                .setText(R.id.tv_end_time_item_patient, getContext().getString(R.string.patient_start_green_channel, homePatientBean.getStartGreenChannelTime()));
    }


    private String getDiseaseNameByType(int type) {
        if (type == 5) {
            return "危重儿童";
        } else if (type == 2) {
            return "胸痛";
        } else if (type == 3) {
            return "创伤";
        } else if (type == 4) {
            return "危重孕产妇";
        } else {
            return "卒中";
        }
    }


    private String getSexAndAgeString(int sex, int age) {
        StringBuilder stringBuilder = new StringBuilder();
        if (sex == 1) {
            stringBuilder.append("男");
        } else if (sex == 2) {
            stringBuilder.append("女");
        } else {
            stringBuilder.append("未知");
        }
        return stringBuilder.append("-").append(age).append("岁").toString();

    }
}

    
    
       
    