package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.trauma.TraumaImageCheckBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * TraumaImageCheckRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/11
 * email ：licy3051@qq.com
 */
public class TraumaImageCheckRvAdapter extends BaseQuickAdapter<TraumaImageCheckBean.TraumaImageCheckDetailBean, BaseViewHolder> {

    public TraumaImageCheckRvAdapter(int layoutResId, @Nullable List<TraumaImageCheckBean.TraumaImageCheckDetailBean> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.tv_detail_item_trauma_image, R.id.tv_delete_item_trauma_image);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TraumaImageCheckBean.TraumaImageCheckDetailBean bean) {
        baseViewHolder.setText(R.id.tv_check_item_trauma_image, getNameById(bean.getInspectionitem()));
    }

    /**
     * 1 CT平扫 2 增强CT 3 三维重建 4 CTA 5 CTP 6 MRI  7 彩超  8 DR  9 DSA 10 其他
     *
     * @param id
     * @return
     */
    private String getNameById(String id) {
        switch (id) {
            case "1":
                return "CT平扫";
            case "2":
                return "增强CT";
            case "3":
                return "三维重建";
            case "4":
                return "CTA";
            case "5":
                return "CTP";
            case "6":
                return "MRI";
            case "7":
                return "彩超";
            case "8":
                return "DR";
            case "9":
                return "DSA";
            case "10":
                return "其他";
            default:
                return "";
        }
    }
}

    
    
       
    