package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import butterknife.BindView;

/**
 * 会诊信息
 *
 * @author Licy
 */
public class TraumaConsultationInfoFragment extends BaseStrokeFragment {


    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    public TraumaConsultationInfoFragment() {

    }

    public static TraumaConsultationInfoFragment newInstance(String recordId) {
        TraumaConsultationInfoFragment fragment = new TraumaConsultationInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_consultation_info;
    }

    @Override
    protected void initView(@NonNull View view) {


    }


    private void loadData() {
    }


    @Override
    protected void initListener() {

    }


}
