package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
public class PatientStatusFragment4 extends BaseFragment implements OnDateSetListener {
    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;
    @BindView(R.id.tv_draw_blood_time)
    TextTimeBar mTvDrawBloodTime;
    @BindView(R.id.cb_text_1)
    CheckBox mCbText1;
    @BindView(R.id.cb_text_2)
    CheckBox mCbText2;
    @BindView(R.id.cb_text_3)
    CheckBox mCbText3;
    @BindView(R.id.cb_text_4)
    CheckBox mCbText4;
    @BindView(R.id.cb_text_5)
    CheckBox mCbText5;
    @BindView(R.id.cb_text_6)
    CheckBox mCbText6;
    @BindView(R.id.cb_text_7)
    CheckBox mCbText7;
    @BindView(R.id.ll_heart_type)
    LinearLayout mLlHeartType;
    @BindView(R.id.tv_strategy)
    TextView mTvStrategy;
    @BindView(R.id.rb_step_1)
    RadioButton mRbStep1;
    @BindView(R.id.rb_step_2)
    RadioButton mRbStep2;
    @BindView(R.id.rb_step_3)
    RadioButton mRbStep3;
    @BindView(R.id.rb_step_4)
    RadioButton mRbStep4;
    @BindView(R.id.ll_deal)
    LinearLayout mLlDeal;
    @BindView(R.id.tv_note)
    TextView mTvNote;
    @BindView(R.id.et_note)
    EditText mEtNote;
    @BindView(R.id.btn_get_data)
    AppCompatButton mBtnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton mBtnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;


    public static PatientStatusFragment4 newInstance(String keyword) {
        PatientStatusFragment4 fragment = new PatientStatusFragment4();
//        Bundle args = new Bundle();
//        args.putString(IntentKey.PATIENT_ID, patientId);
//        args.putString(IntentKey.DOC_ID, docId);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_patient_status_4;
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

        mLlDeal.setVisibility(View.GONE);
        mTvNote.setVisibility(View.GONE);
        mEtNote.setVisibility(View.GONE);
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
        mTvDrawBloodTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
    }

}
