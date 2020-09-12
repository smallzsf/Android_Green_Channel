package com.xyj.strokeaid.adapter;

import android.view.View;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.SizeUtils;
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

        baseViewHolder.setText(R.id.tv_desc_item_time_node, "")
                .setText(R.id.tv_time_item_time_node, "");

        View view = baseViewHolder.getView(R.id.view_middle);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (getItemPosition(timeNodeBean) == 0) {
            layoutParams.setMargins(0, SizeUtils.dp2px(8), 0, 0);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }


    }
}

    
    
       
    