package com.xyj.strokeaid.fragment.stroke;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * @Description: 卒中血液检查其它页面
 * @Author: crq
 * @CreateDate: 2020/8/26 17:45
 */
public class StrokeOtherFragment extends BaseFragment {


    @BindView(R.id.ttb_awareness_time)
    TextTimeBar ttbAwarenessTime;
    @BindView(R.id.ttb_draw_blood_time)
    TextTimeBar ttbDrawBloodTime;
    @BindView(R.id.pulse)
    TextView pulse;
    @BindView(R.id.pulse_layout)
    LinearLayout pulseLayout;
    @BindView(R.id.et_pulse_content)
    EditText etPulseContent;
    @BindView(R.id.heart_rate)
    TextView heartRate;
    @BindView(R.id.heart_rate_layout)
    LinearLayout heartRateLayout;
    @BindView(R.id.et_heart_rate_content)
    EditText etHeartRateContent;
    @BindView(R.id.systolic_blood_pressure)
    TextView systolicBloodPressure;
    @BindView(R.id.systolic_blood_pressure_layout)
    LinearLayout systolicBloodPressureLayout;
    @BindView(R.id.et_systolic_blood_pressure_content)
    EditText etSystolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure)
    TextView diastolicBloodPressure;
    @BindView(R.id.diastolic_blood_pressure_layout)
    LinearLayout diastolicBloodPressureLayout;
    @BindView(R.id.et_diastolic_blood_pressure_content)
    EditText etDiastolicBloodPressureContent;
    @BindView(R.id.diastolic_blood_pressure_layout1)
    LinearLayout diastolicBloodPressureLayout1;
    @BindView(R.id.diastolic_blood_pressure_layout2)
    LinearLayout diastolicBloodPressureLayout2;
    @BindView(R.id.diastolic_blood_pressure_layout3)
    LinearLayout diastolicBloodPressureLayout3;
    @BindView(R.id.diastolic_blood_pressure_layout4)
    LinearLayout diastolicBloodPressureLayout4;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_stroke_other)
    LinearLayout llStrokeOther;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_other;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取数据");
        btnConfirm.setText("确定");
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onResume() {
        super.onResume();


        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llStrokeOther, llBottom);
    }

   /* @OnClick({R.id.tv_draw_blood_time, R.id.tv_draw_blood_result_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_draw_blood_time:
                TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvDrawBloodTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll.show(getActivity().getSupportFragmentManager(), "All");
                break;
            case R.id.tv_draw_blood_result_time:
                TimePickerDialog mDialogAll1 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvDrawBloodResultTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll1.show(getActivity().getSupportFragmentManager(), "All");
                break;
        }
    }*/
}

