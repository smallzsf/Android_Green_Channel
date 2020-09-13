package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.trauma.TraumaImageCheckBean;
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
public class TraumaImageDialogFragment extends DialogFragment {

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
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private TraumaImageCheckBean.TraumaImageCheckDetailBean mImageCheckDetailBean;

    public static TraumaImageDialogFragment newInstance(TraumaImageCheckBean.TraumaImageCheckDetailBean bean) {
        TraumaImageDialogFragment fragment = new TraumaImageDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(IntentKey.TRAUMA_IMAGE_CHECK_DETAIL_BEAN, bean);
        fragment.setArguments(args);
        return fragment;
    }

    public void setImageCheckDetailBean(TraumaImageCheckBean.TraumaImageCheckDetailBean imageCheckDetailBean) {
        mImageCheckDetailBean = imageCheckDetailBean;
        refreshView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImageCheckDetailBean = getArguments().getParcelable(IntentKey.TRAUMA_IMAGE_CHECK_DETAIL_BEAN);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.trauma_dialog_image_check, container, false);
        ButterKnife.bind(this, inflate);
        initListener();
        return inflate;
    }

    private void initListener() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @OnClick({R.id.sb_check_photo, R.id.sb_check_report, R.id.btn_save, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_check_photo:
                break;
            case R.id.sb_check_report:
                break;
            case R.id.btn_save:
                getViewData();
                dismiss();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

    private void refreshView() {

    }

    private void getViewData() {

    }
}

    
    
       
    