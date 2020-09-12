package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.bean.MainListBean;

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
public class HomePatientRvAdapter extends BaseQuickAdapter<MainListBean, BaseViewHolder> implements LoadMoreModule {

    public HomePatientRvAdapter(@Nullable List<MainListBean> data) {
        super(R.layout.adapter_rv_home_patient_item, data);
        addChildClickViewIds(R.id.tv_detail_item_patient, R.id.tv_time_node_item_patient);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MainListBean mainListBean) {
        // TODO: 2020/9/12  设置数据

        baseViewHolder.setText(R.id.tv_name_item_patient, mainListBean.getFullname())
                .setText(R.id.tv_sex_and_age_item_patient,
                        getContext().getString(R.string.sex_and_age_with_para, getSexAndAgeString(mainListBean.getGender(), mainListBean.getAge())))
                .setText(R.id.tv_disease_type_item_patient, getDiseaseNameByType(mainListBean.getEmergencyType()))
                .setText(R.id.tv_start_time_item_patient, getContext().getString(R.string.patient_start_disease_time, mainListBean.getAttacktime()));
    }


    private String getDiseaseNameByType(String type) {
        if ("5".equals(type)) {
            return "危重儿童";
        } else if ("2".equals(type)) {
            return "胸痛";
        } else if ("3".equals(type)) {
            return "创伤";
        } else if ("4".equals(type)) {
            return "危重孕产妇";
        } else {
            return "卒中";
        }
    }


    private String getSexAndAgeString(String sex, String age) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("1".equals(sex)) {
            stringBuilder.append("男");
        } else if ("2".equals(sex)) {
            stringBuilder.append("女");
        } else {
            stringBuilder.append("未知");
        }
        return stringBuilder.append("-").append(age).append("岁").toString();

    }
}

    
    
       
    