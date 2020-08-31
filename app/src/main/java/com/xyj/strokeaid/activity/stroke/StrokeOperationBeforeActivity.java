package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
public class StrokeOperationBeforeActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_before)
    BaseTitleBar titleBarActStrokeMain;

    /**
     * 启动导室管
     */
    @BindView(R.id.ttb_start_cath_act_stroke)
    TextTimeBar tvStartCatheter;

    /**
     * 选择导室管
     */
    @BindView(R.id.es_cath_act_stroke)
    EditSpinner tvSelectCatheter;

    /**
     * 介入医生
     */
    @BindView(R.id.et_intervene_doctor)
    EditText tvInterveneDoctor;

    /**
     * 选择医生
     */
    @BindView(R.id.tv_intervene_doctor)
    TextView tvISelectDoctor;

    /**
     * 介入护士
     */
    @BindView(R.id.et_intervene_nurse)
    EditText tvInterveneNurse;

    /**
     * 选择护士
     */
    @BindView(R.id.tv_intervene_nurse)
    TextView tvSelectDoctor;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_before;
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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


}

    
    
       
