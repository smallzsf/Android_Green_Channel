package com.xyj.strokeaid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.PatientMenuBean;
import com.xyj.strokeaid.view.XyjCheckedTextView;

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
public class PatientMenuRvAdapter extends BaseQuickAdapter<PatientMenuBean, BaseViewHolder> {

    public PatientMenuRvAdapter(int layoutResId, @Nullable List<PatientMenuBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PatientMenuBean s) {
        XyjCheckedTextView view = baseViewHolder.getView(R.id.tv_title_adapter_gcm);
        view.setText(s.getTitle());
        view.setChecked(s.isChecked());
    }
}