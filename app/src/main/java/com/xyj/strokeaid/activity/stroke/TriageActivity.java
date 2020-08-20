package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;


import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * https://blog.csdn.net/ss1168805219/article/details/53047343
 */
public class TriageActivity extends BaseActivity implements OnDateSetListener {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.triage_time)
    LinearLayout triageTime;
    @BindView(R.id.doctor_name_line)
    View doctorNameLine;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.tv_)
    TextView tv;
    private int position;
    private TimePickerDialog mDialogAll;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_triage_time;
    }

    @Override
    public void initView() {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
     /*   mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)//回调
                .setCancelStringId("Cancel")//取消按钮
                .setSureStringId("Sure")//确定按钮
                .setTitleStringId("TimePicker")//标题
                .setYearText("Year")//Year
                .setMonthText("Month")//Month
                .setDayText("Day")//Day
                .setHourText("Hour")//Hour
                .setMinuteText("Minute")//Minute
                .setCyclic(false)//是否可循环
                .setMinMillseconds(System.currentTimeMillis())//最小日期和时间
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)//最大日期和时间
                .setCurrentMillseconds(System.currentTimeMillis())
                .setType(Type.ALL)//类型
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))//未选中的文本颜色
                .setWheelItemTextSize(12)//字体大小
                .build();*/
        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setYearText("Year")//Year
                .setMonthText("Month")//Month
                .setDayText("Day")//Day
                .setHourText("Hour")//Hour
                .setMinuteText("Minute")//Minute
                .setToolBarTextColor(R.color.colorPrimary)
                .build();

    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.app_tv_editSpinner_time, R.id.iv_refresh, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_tv_editSpinner_time:
                mDialogAll.show(getSupportFragmentManager(), "All");
                break;
            case R.id.iv_refresh:

                break;

            case R.id.btn_confirm:
                Intent intent = new Intent();
                position = intent.getIntExtra("position", 0);
                //把返回数据存入Intent
                intent.putExtra("result", appTvEditSpinnerTime.getText());
                intent.putExtra("position", position);
                //设置返回数据
                setResult(0, intent);
                //关闭Activity
                finish();

                break;
            case R.id.btn_cancel:


                break;
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerDialog, long millseconds) {
        String text = getDateToString(millseconds);
        String substring = text.substring(0, text.length() - 3);
        appTvEditSpinnerTime.setText(substring);

    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }


}