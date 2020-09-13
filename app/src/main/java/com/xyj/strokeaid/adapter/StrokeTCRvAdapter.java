package com.xyj.strokeaid.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.CompoundButton;

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
public class StrokeTCRvAdapter extends
        BaseSectionQuickAdapter<StrokeTCBean, BaseViewHolder> {

    private static final String TAG = StrokeTCRvAdapter.class.getSimpleName();

    public StrokeTCRvAdapter(int sectionHeadResId, @Nullable List<StrokeTCBean> data) {
        super(sectionHeadResId, data);
    }

    public StrokeTCRvAdapter(int sectionHeadResId) {
        super(sectionHeadResId);
    }

    public StrokeTCRvAdapter(int sectionHeadResId, int layoutResId, @Nullable List<StrokeTCBean> data) {
        super(sectionHeadResId, layoutResId, data);
        addChildClickViewIds(R.id.tsb_root);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StrokeTCBean strokeTCBean) {

        TextSwitchBar view = baseViewHolder.getView(R.id.tsb_root);
        // 设置背景色
        if (baseViewHolder.getLayoutPosition() % 2 == 0) {
            view.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.color_EEEEEE)));
        } else {
            view.setBackground(new ColorDrawable(Color.WHITE));
        }
        boolean checked = strokeTCBean.getChecked();
        Log.e(TAG, baseViewHolder.getLayoutPosition()+"convert: "+checked );
        view.setSelected(checked);
        view.setSwitchClickListener(new OnSwitchClickListener(baseViewHolder.getLayoutPosition()));

        // 设置内容
        view.setContent(strokeTCBean.getContent());
    }

    @Override
    protected void convertHeader(@NotNull BaseViewHolder baseViewHolder, @NotNull StrokeTCBean strokeTCBean) {
        baseViewHolder.setText(R.id.tv_header_single_text, strokeTCBean.getContent());
    }


    private class OnSwitchClickListener implements CompoundButton.OnCheckedChangeListener{
        private final int position;

        private OnSwitchClickListener(int position){
            this.position = position;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (onSwitchClickListener != null) {
                onSwitchClickListener.onCheckedChanged(compoundButton,b,position);
            }
        }
    }



    private OnSwitchChangeListener onSwitchClickListener;

    public void setOnSwitchClickListener(OnSwitchChangeListener onSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener;
    }

    public interface OnSwitchChangeListener {
        void onCheckedChanged(CompoundButton compoundButton, boolean b, int position);
    }


}

    
    
       
    