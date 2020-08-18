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

    /**
     * 代表当前显示的内容状态
     */
    int mDiseaseType;
    int mPatientType;

    public HomePatientRvAdapter( @Nullable List<HomePatientBean> data, int diseaseType, int patientType) {
        super(R.layout.item_rv_home_patient, data);
        this.mDiseaseType = diseaseType;
        this.mPatientType = patientType;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, HomePatientBean homePatientBean) {

    }
}

    
    
       
    