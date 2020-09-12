package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import butterknife.BindView;

/**
 * @Description: 血液检查
 * @Author: crq
 * @CreateDate: 2020/8/25 14:07
 */
public class StrokeBloodExaminationFragment extends BaseStrokeFragment {


    @BindView(R.id.rv_blood_text_details)
    RecyclerView rvBloodTextDetails;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    public static StrokeBloodExaminationFragment newInstance(String recordId) {
        StrokeBloodExaminationFragment fragment = new StrokeBloodExaminationFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_blood_examination;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }

}
