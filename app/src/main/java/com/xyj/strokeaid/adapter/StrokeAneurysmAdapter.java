package com.xyj.strokeaid.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.EmergencyCenterStrokeAneurysmSurgeryPoBean;
import com.xyj.strokeaid.bean.PatientMenuBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StrokeAneurysmAdapter extends BaseQuickAdapter<EmergencyCenterStrokeAneurysmSurgeryPoBean, BaseViewHolder> {
    public StrokeAneurysmAdapter(int layoutResId, @Nullable List<EmergencyCenterStrokeAneurysmSurgeryPoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, EmergencyCenterStrokeAneurysmSurgeryPoBean emergencyCenterStrokeAneurysmSurgeryPoBean) {
        TextView tvStrokeAneurysm = baseViewHolder.getView(R.id.tv_stroke_aneurysm);
        int position = baseViewHolder.getLayoutPosition()+1;
        tvStrokeAneurysm.setText("瘤"+position);
    }
}
