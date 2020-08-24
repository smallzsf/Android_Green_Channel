package com.xyj.strokeaid.adapter;

import android.content.Context;
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
public class StrokeTriageAdapter extends BaseQuickAdapter<String, com.chad.library.adapter.base.viewholder.BaseViewHolder> {

    public StrokeTriageAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv_path_name, s);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}




    /* extends BaseRecycAdapter<String> {


    @BindView(R.id.tv_is_done)
    TextView tvIsDone;
    @BindView(R.id.tv_path_name)
    TextView tvPathName;
    @BindView(R.id.app_iv_red_star)
    ImageView appIvRedStar;
    @BindView(R.id.tv_operation_path_show)
    TextView tvOperationPathShow;
    @BindView(R.id.ll_patient_path)
    LinearLayout llPatientPath;
    @BindView(R.id.recyclerView)
    LinearLayout recyclerView;

    public StrokeTriageAdapter(List<String> list, Context context) {
        super(list, context);
    }

    @Override
    protected int getContentView(int viewType) {
        return R.layout.adapter_stroke_path_item;
    }


    @Override
    protected void covert(BaseViewHolder holder, String data, int position) {
        ButterKnife.bind(this, holder.getView());
        tvPathName.setText(data);

    }


}*/