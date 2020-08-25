package com.xyj.strokeaid.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.StrokeProcessBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 分诊条目
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class StrokeTriageAdapter extends BaseQuickAdapter<StrokeProcessBean, com.chad.library.adapter.base.viewholder.BaseViewHolder> {

    public StrokeTriageAdapter(int layoutResId, @Nullable List<StrokeProcessBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StrokeProcessBean strokeProcessBean) {
        baseViewHolder.setText(R.id.tv_path_name, strokeProcessBean.getName())
                .setText(R.id.tv_operation_path_show, strokeProcessBean.getDesc());
        TextView tvIsDone = baseViewHolder.getView(R.id.tv_is_done);

        // 填写状态
        if (strokeProcessBean.getStatus() == 2){
            // 部分完成

            tvIsDone.setBackgroundResource(R.drawable.shape_yellow_round);
        }else if (strokeProcessBean.getStatus() == 3){
            // 已完成
            tvIsDone.setBackgroundResource(R.drawable.shape_green_round);
        }else {
            // 未完成
            tvIsDone.setBackgroundResource(R.drawable.shape_red_round);
        }
    }

    /*@Override
    public int getItemViewType(int position) {
        return position;
    }*/


}

