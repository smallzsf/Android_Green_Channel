package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @Description: 分诊条目的通用布局
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class TriageActivity extends BaseActivity implements OnDateSetListener {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.ll_triage_time)
    LinearLayout llTriageTime;

    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @BindView(R.id.btn_getdata)
    AppCompatButton btnGetdata;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_tall)
    LinearLayout llTall;
    @BindView(R.id.ll_weight)
    LinearLayout llWeight;
    @BindView(R.id.ll_triage_doctor)
    LinearLayout llTriagellDoctor;
    @BindView(R.id.et_input_tall)
    EditText etInputTall;
    @BindView(R.id.et_input_weight)
    EditText etInputWeight;
    @BindView(R.id.ll_fast_blood_sugar)
    LinearLayout llFastBloodSugar;
    @BindView(R.id.tv_triage_doctor)
    TextView tvTriageDoctor;

    private TimePickerDialog mDialogAll;
    private int position;
    private Bundle bundle;
    private Intent intent;
    private List<StrokeProcessBean> list;


    @Override
    public int getLayoutId() {
        return R.layout.app_activity_triage_time;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {


        intent = getIntent();
        bundle = intent.getExtras();
        String arrayList = bundle.getString("arrayList");
        list = new Gson().fromJson(arrayList, new TypeToken<List<StrokeProcessBean>>() {
        }.getType());
        position = bundle.getInt("position", 0);

        titlebar.setTitle(list.get(position).getName());
        tvName.setText(list.get(position).getName());
        if (position == 0 || position == 2 || position == 11 || position == 12 || position == 13) {
            // llTriageTime.setVisibility(View.GONE);
            llTriagellDoctor.setVisibility(View.GONE);
            llFastBloodSugar.setVisibility(View.GONE);
            llTall.setVisibility(View.GONE);
            llWeight.setVisibility(View.GONE);
        }
        if (position == 1) {
            llTriageTime.setVisibility(View.GONE);
            //   llTriagellDoctor.setVisibility(View.GONE);
            llFastBloodSugar.setVisibility(View.GONE);
            llTall.setVisibility(View.GONE);
            llWeight.setVisibility(View.GONE);
            tvTriageDoctor.setText(list.get(position).getName());
        }

        if (position == 8) {

        }

        if (position == 9) {
            llTriageTime.setVisibility(View.GONE);
            llTriagellDoctor.setVisibility(View.GONE);
            // llFastBloodSugar.setVisibility(View.GONE);
            llTall.setVisibility(View.GONE);
            llWeight.setVisibility(View.GONE);
        }


        if (position == 14) {
            llTriageTime.setVisibility(View.GONE);
            llTriagellDoctor.setVisibility(View.GONE);
            llTall.setVisibility(View.GONE);
            llFastBloodSugar.setVisibility(View.GONE);
        }
        if (position == 15) {
            llTriageTime.setVisibility(View.GONE);
            llTriagellDoctor.setVisibility(View.GONE);
            llFastBloodSugar.setVisibility(View.GONE);
            llWeight.setVisibility(View.GONE);

        }
        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setCyclic(false)//是否可循环
                .setToolBarTextColor(R.color.colorPrimary)
                .build();
        btnGetdata.setVisibility(View.GONE);

    }

    @Override
    public void initListener() {
        titlebar.setLeftLayoutClickListener(v -> finish());
    }

    @OnClick({R.id.app_tv_editSpinner_time, R.id.iv_refresh, R.id.btn_getdata, R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_tv_editSpinner_time:
                mDialogAll.show(getSupportFragmentManager(), "All");

                break;
            case R.id.iv_refresh:

                appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date()));
                break;

            case R.id.btn_confirm:
                String s = etInputWeight.getText().toString();
                if (position == 0 || position == 2 || position == 11 || position == 12 || position == 13) {

                    intent.putExtra("result", appTvEditSpinnerTime.getText());
                    intent.putExtra("tall", etInputTall.getText().toString());
                    intent.putExtra("weight", s);
                    intent.putExtra("position", position);
                    //设置返回数据
                    setResult(0, intent);
                    //关闭Activity
                    finish();
                }

                if (position == 1) {

                }

                if (position == 8) {

                }

                if (position == 9) {

                }


                if (position == 14) {

                }
                if (position == 15) {

                }


                break;
            case R.id.btn_cancel:

                //关闭Activity
                finish();

                break;
            case R.id.btn_getdata:

                break;

        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerDialog, long millseconds) {

        appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));

    }


}