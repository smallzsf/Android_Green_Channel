package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.TimeNodeBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * TimeNodeRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class TimeNodeRvAdapter extends BaseQuickAdapter<TimeNodeBean, BaseViewHolder> {
    public TimeNodeRvAdapter(int layoutResId, @Nullable List<TimeNodeBean> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.iv_refresh_item_time_node, R.id.tv_time_item_time_node);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TimeNodeBean timeNodeBean) {
        baseViewHolder.setText(R.id.tv_desc_item_time_node, timeNodeBean.getDesc())
                .setText(R.id.tv_time_item_time_node, timeNodeBean.getTime());

    }
}

    
    
       
    