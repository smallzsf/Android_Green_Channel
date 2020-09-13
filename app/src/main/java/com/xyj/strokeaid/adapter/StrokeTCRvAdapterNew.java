package com.xyj.strokeaid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.view.TextSwitchBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * StrokeTCRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
public class StrokeTCRvAdapterNew extends BaseAdapter {

    private Context context;
    private List<StrokeTCBean> data;

    public StrokeTCRvAdapterNew(Context context, List<StrokeTCBean> strokeTCBeans) {
        this.context = context;
        this.data = strokeTCBeans;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.adapter_stroke_tcrv_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        StrokeTCBean bean = data.get(i);
        // 设置背景色
        if (i % 2 == 0) {
            viewHolder.llItem.setBackground(new ColorDrawable(context.getResources().getColor(R.color.color_EEEEEE)));
        } else {
            viewHolder.llItem.setBackground(new ColorDrawable(Color.WHITE));
        }

        viewHolder.tsbRoot.setSwitchClickListener(new OnSwitchClickListener(i));

        viewHolder.tvHeaderSingleText.setText(bean.getContent());
        viewHolder.tsbRoot.setSelected(bean.getChecked());
        return view;
    }



    static
    class ViewHolder {
        @BindView(R.id.tv_header_single_text)
        TextView tvHeaderSingleText;
        @BindView(R.id.tsb_root)
        TextSwitchBar tsbRoot;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private class OnSwitchClickListener implements CompoundButton.OnCheckedChangeListener {
        private final int position;

        private OnSwitchClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (onSwitchClickListener != null) {
                onSwitchClickListener.onCheckedChanged(compoundButton, b, position);
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

    