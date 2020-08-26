package com.xyj.strokeaid.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.StrokeHosBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * StrokeHosRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeHosRvAdapter extends BaseQuickAdapter<StrokeHosBean, BaseViewHolder> {
    public StrokeHosRvAdapter(int layoutResId, @Nullable List<StrokeHosBean> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.iv_call_item_stroke_hos);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StrokeHosBean strokeHosBean) {
        baseViewHolder.setText(R.id.tv_name_item_stroke_hos, strokeHosBean.getName())
                .setText(R.id.tv_phone_item_stroke_hos, strokeHosBean.getPhone());

        if (strokeHosBean.isChecked()) {
            int color = getContext().getResources().getColor(R.color.colorPrimary);
            baseViewHolder.setTextColor(R.id.tv_name_item_stroke_hos, Color.WHITE)
                    .setTextColor(R.id.tv_phone_item_stroke_hos, Color.WHITE)
                    .setBackgroundColor(R.id.rl_root_item_stroke_hos, color)
                    .setImageResource(R.id.iv_call_item_stroke_hos, R.drawable.icon_call_white);
        } else {
            int textColor66 = getContext().getResources().getColor(R.color.color_666666);
            int textColor22 = getContext().getResources().getColor(R.color.color_222222);
            baseViewHolder.setTextColor(R.id.tv_name_item_stroke_hos, textColor22)
                    .setTextColor(R.id.tv_phone_item_stroke_hos, textColor66)
                    .setBackgroundColor(R.id.rl_root_item_stroke_hos, 0)
                    .setImageResource(R.id.iv_call_item_stroke_hos, R.drawable.icon_call);
        }
    }
}

    
    
       
    