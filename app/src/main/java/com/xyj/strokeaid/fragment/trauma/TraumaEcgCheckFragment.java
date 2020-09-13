package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * 心电检查
 *
 * @author Licy
 */
public class TraumaEcgCheckFragment extends BaseStrokeFragment {


    @BindView(R.id.tv_check_time)
    TextTimeBar tvCheckTime;
    @BindView(R.id.tv_report_time)
    TextTimeBar tvReportTime;
    @BindView(R.id.tv_report)
    TextView tvReport;
    @BindView(R.id.et_report)
    EditText etReport;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    public static TraumaEcgCheckFragment newInstance(String recordId) {
        TraumaEcgCheckFragment fragment = new TraumaEcgCheckFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_ecg_check;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();


    }


    private void loadData() {
    }


    @Override
    protected void initListener() {

    }

}
