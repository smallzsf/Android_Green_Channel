package com.xyj.strokeaid.activity.chestpain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
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
@Route(path = RouteUrl.ChestPain.CHEST_PAIN_OPERATION_BEFORE)
public class SurgicalPreparationActivtty extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.title_bar_act_npmr)
    BaseTitleBar titleBarActNpmr;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_save)
    TextView tvSave;

    @BindView(R.id.et_doctor_name)
    EditText etDoctorName;
    @BindView(R.id.ttb_dis_start_act_npmr)
    TextTimeBar tvStartTime;
    @BindView(R.id.es_room)
    EditSpinner esRoom;
    @BindView(R.id.rl_catheter_room)
    TextTimeBar tvCatheterRoomTime;
    @BindView(R.id.rl_agree_time)
    TextTimeBar tvCagreeTime;
    @BindView(R.id.rl_sign_time)
    TextTimeBar tvSignTime;
    @BindView(R.id.rg_agree)
    RadioGroup rgAgree;

    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

    private List<String> list;
    //家属是否同意
    private Boolean familyState;

    @Override
    public int getLayoutId() {
        return R.layout.activity_surgical_preparation_activtty;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("手术室1");
        list.add("手术室2");
        list.add("手术室3");
        list.add("手术室4");
        esRoom.setItemData(list);
    }

    @Override
    public void initListener() {
        rlBack.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        tvStartTime.setOnClickListener(this);
        //es_room.
        tvCatheterRoomTime.setOnClickListener(this);
        tvCagreeTime.setOnClickListener(this);
        tvSignTime.setOnClickListener(this);
        rgAgree.setOnCheckedChangeListener(this);
        titleBarActNpmr.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
            case R.id.ttb_dis_start_act_npmr:
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

                                tvStartTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllstart_time.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.rl_catheter_room:
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
                                tvCatheterRoomTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllCatheterRoomTime.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.rl_agree_time:
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
                                tvCagreeTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAllcatheterAgreeTime.show(SurgicalPreparationActivtty.this.getSupportFragmentManager(), "All");
                break;
            case R.id.rl_sign_time:
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
                                tvSignTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
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
