package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class OriginalStatusFragment3 extends BaseFragment implements OnDateSetListener {

    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;
    @BindView(R.id.give_up_cure)
    TextView mGiveUpCure;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton mRbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton mRbCtFragAe;
    @BindView(R.id.tv_first_cure)
    TextView mTvFirstCure;
    @BindView(R.id.tv_draw_blood_time)
    TextView mTvDrawBloodTime;
    @BindView(R.id.et_emergency_ward)
    EditText mEtEmergencyWard;
    @BindView(R.id.tv_emergency_ward)
    TextView mTvEmergencyWard;
    @BindView(R.id.cb_shadow_text_1)
    CheckBox mCbShadowText1;
    @BindView(R.id.cb_shadow_text_2)
    CheckBox mCbShadowText2;
    @BindView(R.id.cb_shadow_text_3)
    CheckBox mCbShadowText3;
    @BindView(R.id.cb_shadow_text_4)
    CheckBox mCbShadowText4;
    @BindView(R.id.tv_ct_notify_label)
    TextView mTvCtNotifyLabel;
    @BindView(R.id.tv_ct_notify_time)
    TextTimeBar mTvCtNotifyTime;
    @BindView(R.id.tv_ct_finish_label)
    TextView mTvCtFinishLabel;
    @BindView(R.id.tv_ct_finish_time)
    TextTimeBar mTvCtFinishTime;
    @BindView(R.id.tv_ct_start_label)
    TextView mTvCtStartLabel;
    @BindView(R.id.tv_ct_start_time)
    TextTimeBar mTvCtStartTime;
    @BindView(R.id.tv_ct_report_label)
    TextView mTvCtReportLabel;
    @BindView(R.id.tv_ct_report_time)
    TextTimeBar mTvCtReportTime;
    @BindView(R.id.tv_cc_notify_label)
    TextView mTvCcNotifyLabel;
    @BindView(R.id.tv_cc_notify_time)
    TextTimeBar mTvCcNotifyTime;
    @BindView(R.id.tv_cc_finish_label)
    TextView mTvCcFinishLabel;
    @BindView(R.id.tv_cc_finish_time)
    TextTimeBar mTvCcFinishTime;
    @BindView(R.id.tv_cc_start_label)
    TextView mTvCcStartLabel;
    @BindView(R.id.tv_cc_start_time)
    TextTimeBar mTvCcStartTime;
    @BindView(R.id.tv_cc_report_label)
    TextView mTvCcReportLabel;
    @BindView(R.id.tv_report_time)
    TextTimeBar mTvReportTime;
    @BindView(R.id.tv_cc_heart_label)
    TextView mTvCcHeartLabel;
    @BindView(R.id.tv_cc_heart_time)
    TextTimeBar mTvCcHeartTime;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.rb_type_yes)
    RadioButton mRbTypeYes;
    @BindView(R.id.rb_type_no)
    RadioButton mRbTypeNo;
    @BindView(R.id.tv_strategy)
    TextView mTvStrategy;
    @BindView(R.id.rb_strategy_3)
    RadioButton mRbStrategy3;
    @BindView(R.id.rb_strategy_4)
    RadioButton mRbStrategy4;
    @BindView(R.id.rb_strategy_5)
    RadioButton mRbStrategy5;
    @BindView(R.id.rb_strategy_6)
    RadioButton mRbStrategy6;
    @BindView(R.id.rb_strategy_1)
    RadioButton mRbStrategy1;
    @BindView(R.id.btn_get_data)
    AppCompatButton mBtnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton mBtnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;


    public static OriginalStatusFragment3 newInstance(String keyword) {
        OriginalStatusFragment3 fragment = new OriginalStatusFragment3();
//        Bundle args = new Bundle();
//        args.putString(IntentKey.PATIENT_ID, patientId);
//        args.putString(IntentKey.DOC_ID, docId);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_status_3;
    }

    @Override
    protected void initView(@NonNull View view) {
        initview();
        initData();
        initEvent();
    }

    private void initview() {

        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setCyclic(false)//是否可循环
                .setToolBarTextColor(R.color.colorPrimary)
                .build();

    }

    private void initData() {

    }

    private void initEvent() {
        //初诊时间
        mTvDrawBloodTime.setOnClickListener(v -> {
            mDialogAll.show(getChildFragmentManager(), "All");
        });

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        mTvDrawBloodTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
    }
}
