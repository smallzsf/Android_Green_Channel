package com.xyj.strokeaid.fragment.stroke;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @Description: 卒中血脂四项页面
 * @Author: crq
 * @CreateDate: 2020/8/26 17:21
 */
public class StrokeBloodFatFragment extends BaseFragment {
    @BindView(R.id.tv_draw_blood_time)
    TextView tvDrawBloodTime;
    @BindView(R.id.tv_draw_blood_result_time)
    TextView tvDrawBloodResultTime;
    @BindView(R.id.et_triglyceride)
    EditText etTriglyceride;
    @BindView(R.id.et_cholesterol)
    EditText etCholesterol;
    @BindView(R.id.et_low_density_lipoprotein_cholesterin)
    EditText etLowDensityLipoproteinCholesterin;
    @BindView(R.id.et_high_density_lipoprotein_cholesterol)
    EditText etHighDensityLipoproteinCholesterol;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blood_fat;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.tv_draw_blood_time, R.id.tv_draw_blood_result_time, R.id.btn_get_data, R.id.btn_confirm})
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
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvDrawBloodResultTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll1.show(getActivity().getSupportFragmentManager(), "All");

                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
        }
    }
}

