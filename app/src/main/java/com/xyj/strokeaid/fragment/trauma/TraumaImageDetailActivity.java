package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TraumaImageDialogFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/11
 * email ：licy3051@qq.com
 */
public class TraumaImageDetailActivity extends BaseActivity {

    @BindView(R.id.ttb_doctor_advice_time)
    TextTimeBar ttbDoctorAdviceTime;
    @BindView(R.id.ttb_patient_arrive_time)
    TextTimeBar ttbPatientArriveTime;
    @BindView(R.id.ttb_patient_leave_time)
    TextTimeBar ttbPatientLeaveTime;
    @BindView(R.id.ttb_check_finish_time)
    TextTimeBar ttbCheckFinishTime;
    @BindView(R.id.ttb_check_report_time)
    TextTimeBar ttbCheckReportTime;
    @BindView(R.id.et_report)
    EditText etReport;
    @BindView(R.id.sb_check_photo)
    SettingBar sbCheckPhoto;
    @BindView(R.id.sb_check_report)
    SettingBar sbCheckReport;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.title_bar_act_ticd)
    BaseTitleBar titleBarActTicd;

    @Override
    public int getLayoutId() {
        return R.layout.trauma_act_image_check_detail;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarActTicd.setLeftLayoutClickListener(v -> finish());

    }


    @OnClick({R.id.sb_check_photo, R.id.sb_check_report, R.id.btn_get_data, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_check_photo:
                break;
            case R.id.sb_check_report:
                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_save:
                // TODO: 2020/9/14 通过eventbus 传递数据，这里保存不调用接口
                break;
            default:
                break;
        }
    }

}

    
    
       
    