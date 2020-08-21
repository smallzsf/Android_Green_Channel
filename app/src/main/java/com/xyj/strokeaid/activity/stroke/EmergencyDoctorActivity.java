package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

public class EmergencyDoctorActivity extends BaseActivity implements OnDateSetListener {


    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.editSpinner1)
    EditSpinner editSpinner1;
    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.tv_name)
    TextView tvName;
    private List<String> list;
    private TimePickerDialog mDialogAll;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private int position;
    private Bundle bundle;
    private Intent intent;

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_emergency_doctor_time;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

        intent = getIntent();
        bundle = intent.getExtras();
        ArrayList<String> list = ((ArrayList<String>) bundle.getSerializable("arrayList"));
        position = bundle.getInt("position", 0);
        titlebar.setTitle(list.get(position));
        tvName.setText(list.get(position));

        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setCyclic(false)//是否可循环
                .setToolBarTextColor(R.color.colorPrimary)
                .build();
        loadData();
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add("Hello World");
        list.add("EditSpinner");
        list.add("WrBug");
        list.add("Test");
        list.add("123456789");
        list.add("123456788");
        list.add("123456777");
        list.add("123456666");
        list.add("123455555");
        list.add("123444444");
        list.add("123333333");
        list.add("122222222");
        editSpinner1.setItemData(list);
    }

    @Override
    public void initListener() {

    }


    @OnClick({R.id.app_tv_editSpinner_time, R.id.iv_refresh, R.id.editSpinner1, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_tv_editSpinner_time:
                mDialogAll.show(getSupportFragmentManager(), "All");
                break;
            case R.id.iv_refresh:

                appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date()));
                break;
            case R.id.editSpinner1:
                break;

            case R.id.btn_confirm:

                position = bundle.getInt("position", 0);
                //把返回数据存入Intent
                intent.putExtra("result", appTvEditSpinnerTime.getText());
                intent.putExtra("position", position);
                //设置返回数据
                setResult(1, intent);
                //关闭Activity
                finish();

                break;
            case R.id.btn_cancel:

                //关闭Activity
                finish();

                break;
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

        appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));

    }

}