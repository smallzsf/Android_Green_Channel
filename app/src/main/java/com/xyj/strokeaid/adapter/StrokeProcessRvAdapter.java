package com.xyj.strokeaid.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.StrokeProcessBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * StrokeProcessRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/20
 * email ：licy3051@qq.com
 */
public class StrokeProcessRvAdapter extends BaseQuickAdapter<StrokeProcessBean, BaseViewHolder> {

    public StrokeProcessRvAdapter(int layoutResId, @Nullable List<StrokeProcessBean> data) {
        super(layoutResId, data);
    }

    public StrokeProcessRvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StrokeProcessBean strokeProcessBean) {
        baseViewHolder.setText(R.id.tv_name_adapter_stroke_path, strokeProcessBean.getName())
                .setText(R.id.tv_desc_adapter_stroke_path, strokeProcessBean.getDesc());
        TextView tvPathName = baseViewHolder.getView(R.id.tv_name_adapter_stroke_path);

        // 填写状态
        if (strokeProcessBean.getStatus() == 2){
            // 部分完成
            tvPathName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shape_yellow_round, 0, 0, 0);
        }else if (strokeProcessBean.getStatus() == 3){
            // 已完成
            tvPathName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shape_green_round, 0, 0, 0);
        }else {
            // 未完成
            tvPathName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shape_red_round, 0, 0, 0);
        }
        // 是否必填

    }
}

    
    
       
    