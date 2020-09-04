package com.xyj.strokeaid.fragment.stroke;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @Description: 卒中血糖页面
 * @Author: crq
 * @CreateDate: 2020/8/26 17:21
 */
public class StrokeBloodSugarFragment extends BaseFragment {


    @BindView(R.id.ttb_awareness_time)
    TextTimeBar ttbAwarenessTime;
    @BindView(R.id.ttb_draw_blood_time)
    TextTimeBar ttbDrawBloodTime;
    @BindView(R.id.pulse)
    TextView pulse;
    @BindView(R.id.et_blood_sugar)
    EditText etBloodSugar;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_stroke_blood_sugar)
    LinearLayout llStrokeBloodSugar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blood_sugar;
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
        HideBottonUtils.getInstance().getHideBotton(llStrokeBloodSugar, llBottom);
    }

 /*   @OnClick({R.id.tv_draw_blood_time, R.id.tv_draw_blood_result_time, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_draw_blood_time:
*//*

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
*//*

                break;
            case R.id.tv_draw_blood_result_time:
           *//*     TimePickerDialog mDialogAll1 = new TimePickerDialog.Builder()
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

                mDialogAll1.show(getActivity().getSupportFragmentManager(), "All");*//*

                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
        }
    }
*/

}

