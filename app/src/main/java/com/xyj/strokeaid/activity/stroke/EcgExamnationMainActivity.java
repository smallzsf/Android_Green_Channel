package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

public class EcgExamnationMainActivity extends BaseActivity implements OnDateSetListener {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.triage_time)
    LinearLayout triageTime;
    @BindView(R.id.doctor_name_line)
    View doctorNameLine;
    @BindView(R.id.app_et_ecg_result)
    EditText appEtEcgResult;
    @BindView(R.id.app_btn_ecg_examine_and_shot)
    Button appBtnEcgExamineAndShot;
    @BindView(R.id.btn_getdata)
    AppCompatButton btnGetdata;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private TimePickerDialog mDialogAll;
    private int position;
    private Bundle bundle;
    private Intent intent;


    @Override
    public int getLayoutId() {
        return R.layout.activityt_ecg_examination;
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
      //  btnGetdata.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {

    }



    @OnClick({R.id.titlebar, R.id.tv_name, R.id.app_tv_editSpinner_time, R.id.iv_refresh, R.id.triage_time, R.id.doctor_name_line, R.id.app_et_ecg_result, R.id.app_btn_ecg_examine_and_shot, R.id.btn_getdata, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar:

                break;
            case R.id.tv_name:
                break;
            case R.id.app_tv_editSpinner_time:
                mDialogAll.show(getSupportFragmentManager(), "All");

                break;
            case R.id.iv_refresh:

                appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date()));
                break;
            case R.id.triage_time:
                break;
            case R.id.doctor_name_line:
                break;
            case R.id.app_et_ecg_result:
                break;
            case R.id.app_btn_ecg_examine_and_shot:
                break;
            case R.id.btn_getdata:
                break;
            case R.id.btn_confirm:

                //把返回数据存入Intent
                intent.putExtra("result", appTvEditSpinnerTime.getText());
                intent.putExtra("position", position);
                //设置返回数据
                setResult(2, intent);
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