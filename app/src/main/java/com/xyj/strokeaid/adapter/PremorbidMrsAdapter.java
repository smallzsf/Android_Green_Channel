package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @Description: 分诊条目
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class PremorbidMrsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public PremorbidMrsAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv_item, s);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}


