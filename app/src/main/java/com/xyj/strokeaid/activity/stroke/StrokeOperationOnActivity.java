package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * StrokeOperationBeforeActivity
 * description: TODO
 *
 * @date : 2020/8/30
 */
public class StrokeOperationOnActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_operation)
    BaseTitleBar titleBarActStrokeMain;

    /**
     * 手术过程 tile
     */
    @BindView(R.id.operation_process)
    LinearLayout operationProcess;

    @BindView(R.id.operation_process_line)
    View operationProcessLine;

    /**
     * 手术用药 tile
     */
    @BindView(R.id.surgical_medication)
    LinearLayout surgicalMedication;

    @BindView(R.id.surgical_medication_line)
    View surgicalMedicationLine;

    /**
     * 手术耗材 tile
     */
    @BindView(R.id.surgical_consumables)
    LinearLayout surgicalConsumables;

    @BindView(R.id.surgical_consumables_line)
    View surgicalConsumablesLine;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_operation;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setOnTitleClickListener(v -> {

                });

        operationProcess.setOnClickListener(v -> {
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));


        });

        surgicalMedication.setOnClickListener(v -> {
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));

        });

        surgicalConsumables.setOnClickListener(v -> {
            operationProcessLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalMedicationLine.setBackgroundColor(ContextCompat.getColor(this, R.color.color_FFFFFF));
            surgicalConsumablesLine.setBackgroundColor(ContextCompat.getColor(this, R.color.app_00aaff));

        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


}

    
    
       
    