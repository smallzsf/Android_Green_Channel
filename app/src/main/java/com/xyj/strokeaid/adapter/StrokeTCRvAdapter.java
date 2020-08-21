package com.xyj.strokeaid.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.view.TextSwitchBar;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * StrokeTCRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
public class StrokeTCRvAdapter extends BaseSectionQuickAdapter<StrokeTCBean , BaseViewHolder> {

    public StrokeTCRvAdapter(int sectionHeadResId, @Nullable List<StrokeTCBean> data) {
        super(sectionHeadResId, data);
    }

    public StrokeTCRvAdapter(int sectionHeadResId) {
        super(sectionHeadResId);
    }

    public StrokeTCRvAdapter(int sectionHeadResId, int layoutResId, @Nullable List<StrokeTCBean> data) {
        super(sectionHeadResId, layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StrokeTCBean strokeTCBean) {

        TextSwitchBar view = baseViewHolder.getView(R.id.tsb_root);
        // 设置背景色
        if (baseViewHolder.getLayoutPosition() % 2 == 0) {
            view.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.color_EEEEEE)));
        }else {
            view.setBackground(new ColorDrawable(Color.WHITE));
        }
        // 设置内容
        view.setContent(strokeTCBean.getContent());
    }

    @Override
    protected void convertHeader(@NotNull BaseViewHolder baseViewHolder, @NotNull StrokeTCBean strokeTCBean) {
        baseViewHolder.setText(R.id.tv_header_single_text, strokeTCBean.getContent());
    }
}

    
    
       
    