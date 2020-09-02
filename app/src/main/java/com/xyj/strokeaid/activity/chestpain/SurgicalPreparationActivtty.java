package com.xyj.strokeaid.activity.chestpain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * SurgicalPreparationActivtty
 * description: 术前准备
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
public class SurgicalPreparationActivtty extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.tv_save)
    TextView tv_save;

    @BindView(R.id.et_doctor_name)
    EditText et_doctor_name;
    @BindView(R.id.tv_start_time)
    TextView tv_start_time;
    @BindView(R.id.es_room)
    EditSpinner es_room;
    @BindView(R.id.tv_catheter_room_time)
    TextView tv_catheter_room_time;
    @BindView(R.id.tv_cagree_time)
    TextView tv_cagree_time;
    @BindView(R.id.tv_sign_time)
    TextView tv_sign_time;
    @BindView(R.id.rg_agree)
    RadioGroup rg_agree;
    private List<String> list;
    //家属是否同意
    private Boolean familyState;

    @Override
    public int getLayoutId() {
        return R.layout.activity_surgical_preparation_activtty;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("手术室1");
        list.add("手术室2");
        list.add("手术室3");
        list.add("手术室4");
        es_room.setItemData(list);
    }

    @Override
    public void initListener() {
        rl_back.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        tv_start_time.setOnClickListener(this);
        //es_room.
        tv_catheter_room_time.setOnClickListener(this);
        tv_cagree_time.setOnClickListener(this);
        tv_sign_time.setOnClickListener(this);
        rg_agree.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_save:
                //保存
                break;
            case R.id.tv_start_time:
                //决定介入手术时间
                TimePickerDialog mDialogAllstart_time = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tv_start_time.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllstart_time.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.tv_catheter_room_time:
                //启动导管室时间
                TimePickerDialog mDialogAllCatheterRoomTime = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tv_catheter_room_time.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllCatheterRoomTime.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.tv_cagree_time:
                //开始知情时间
                TimePickerDialog mDialogAllcatheterAgreeTime = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tv_cagree_time.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllcatheterAgreeTime.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.tv_sign_time:
                //签署知情时间
                TimePickerDialog mDialogAllSign = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tv_sign_time.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllSign.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == 0) {
            //家属同意
            familyState = true;

        } else {
            //家属拒绝
            familyState = false;
        }
    }
}
