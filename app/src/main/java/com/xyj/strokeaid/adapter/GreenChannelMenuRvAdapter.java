package com.xyj.strokeaid.adapter;

import android.widget.CheckedTextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.GreenChannelTabBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * GreenChannelMenuRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/24
 * email ：licy3051@qq.com
 */
public class GreenChannelMenuRvAdapter extends BaseQuickAdapter<GreenChannelTabBean, BaseViewHolder> {

    public GreenChannelMenuRvAdapter(int layoutResId, @Nullable List<GreenChannelTabBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, GreenChannelTabBean s) {
        CheckedTextView view = baseViewHolder.getView(R.id.tv_title_adapter_gcm);
        view.setText(s.getTitle());
        view.setChecked(s.isChecked());
    }
}