package com.xyj.strokeaid.activity.stroke;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

public class EmergencyDoctorActivity extends BaseActivity {

    EditSpinner spinner1;
    @Override
    public int getLayoutId() {
        return R.layout.app_activity_emergency_doctor_time;
    }

    @Override
    public void initView() {
        spinner1 = (EditSpinner) findViewById(R.id.editSpinner1);
        loadData();
    }

    private void loadData() {
        List<String> list = new ArrayList<>();
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
        spinner1.setItemData(list);

    }

    @Override
    public void initListener() {

    }
}