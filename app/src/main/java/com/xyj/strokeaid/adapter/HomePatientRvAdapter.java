package com.xyj.strokeaid.adapter;

import android.widget.ImageView;

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

    /**
     * 代表当前显示的内容状态
     */
    int mDiseaseType;
    int mPatientType;

    public HomePatientRvAdapter(@Nullable List<HomePatientBean> data, int diseaseType, int patientType) {
        super(R.layout.adapter_rv_home_patient_item, data);
        this.mDiseaseType = diseaseType;
        this.mPatientType = patientType;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, HomePatientBean homePatientBean) {
        baseViewHolder.setText(R.id.tv_name_item_patient, homePatientBean.getName())
                .setText(R.id.tv_age_item_patient, getContext().getString(R.string.patient_age_with_para, homePatientBean.getAge()))
                .setText(R.id.tv_disease_type_item_patient, getDiseaseNameByType(homePatientBean.getDiseaseType()))
                .setText(R.id.tv_start_time_item_patient, getContext().getString(R.string.patient_start_disease_time, homePatientBean.getStartDiseaseTime()))
                .setText(R.id.tv_end_time_item_patient, getContext().getString(R.string.patient_start_green_channel, homePatientBean.getStartGreenChannelTime()))
                .setText(R.id.tv_nurse_time_item_patient, getContext().getString(R.string.patient_receiver_nurse, homePatientBean.getNurseName()))
                .setText(R.id.tv_doctor_time_item_patient, getContext().getString(R.string.patient_stroke_doc, homePatientBean.getDocName()));

        ImageView imageView = baseViewHolder.getView(R.id.iv_sex_item_patient);
        if (homePatientBean.getSex() == 1) {
            imageView.setImageResource(R.drawable.icon_sex_man);
        } else {
            imageView.setImageResource(R.drawable.icon_sex_woman);
        }
    }


    private String getDiseaseNameByType(int type) {
        if (type == 1) {
            return "卒中";
        } else if (type == 2) {
            return "胸痛";
        } else {
            return "";
        }
    }
}

    
    
       
    