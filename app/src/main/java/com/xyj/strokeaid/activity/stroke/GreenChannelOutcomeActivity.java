package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TipsDialogFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.AutoSize;

/**
 * GreenChannelOutcomeActivity
 * description: 急诊绿道转归
 *
 * @author : Licy
 * @date : 2020/8/20
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_GREEN_CHANNEL_OUTCOME)
public class GreenChannelOutcomeActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_g_c_outcome)
    BaseTitleBar titleBarActGCOutcome;
    @BindView(R.id.es_destination_act_g_c_outcome)
    EditSpinner esDestinationActGCOutcome;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private String mSelectedDestination;

    @Override
    public int getLayoutId() {
        return R.layout.activity_green_channel_outcome;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        esDestinationActGCOutcome.setItemData(
                Arrays.asList(getResources().getStringArray(R.array.patient_destination)));
    }

    @Override
    public void initListener() {
        titleBarActGCOutcome.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                if (TextUtils.isEmpty(esDestinationActGCOutcome.getText())) {
                    // 不保存，直接退出
                    finish();
                } else {
                    TipsDialogFragment tipsDialogFragment = TipsDialogFragment.newInstance("确定将此患者转归？");
                    tipsDialogFragment.setOnButtonClickListener(new TipsDialogFragment.onButtonClickListener() {
                        @Override
                        public void onConfirmClicked() {
                            // TODO: 2020/8/20
                        }

                        @Override
                        public void onCancelClicked() {
                            // do nothing
                        }
                    });
                    AutoSize.autoConvertDensity(GreenChannelOutcomeActivity.this, 360, true);
                    tipsDialogFragment.show(getSupportFragmentManager(), "TipsDialogFragment");
                }
                break;
            case R.id.btn_cancel:
                // 不保存，直接退出
                finish();
                break;
            default:
                break;
        }
    }
}

    
    
       
    