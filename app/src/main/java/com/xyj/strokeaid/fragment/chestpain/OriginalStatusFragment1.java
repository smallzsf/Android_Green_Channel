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
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class OriginalStatusFragment1 extends BaseFragment implements OnDateSetListener {


    @BindView(R.id.give_up_cure)
    TextView mGiveUpCure;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton mRbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton mRbCtFragAe;
    @BindView(R.id.rb_cta_frag_ae)
    RadioButton mRbCtaFragAe;
    @BindView(R.id.rb_ctp_frag_ae)
    RadioButton mRbCtpFragAe;
    @BindView(R.id.rb_mri_frag_ae)
    RadioButton mRbMriFragAe;
    @BindView(R.id.rb_mra_frag_ae)
    RadioButton mRbMraFragAe;
    @BindView(R.id.rb_cemra_frag_ae)
    RadioButton mRbCemraFragAe;
    @BindView(R.id.rb_cvus_frag_ae)
    RadioButton mRbCvusFragAe;
    @BindView(R.id.rb_tcd_frag_ae)
    RadioButton mRbTcdFragAe;
    @BindView(R.id.tv_first_cure)
    TextView mTvFirstCure;
    @BindView(R.id.tv_draw_blood_time)
    TextView mTvDrawBloodTime;
    @BindView(R.id.et_emergency_ward)
    EditText mEtEmergencyWard;
    @BindView(R.id.tv_emergency_ward)
    TextView mTvEmergencyWard;
    @BindView(R.id.rb_level_1)
    RadioButton mRbLevel1;
    @BindView(R.id.rb_level_2)
    RadioButton mRbLevel2;
    @BindView(R.id.rb_level_3)
    RadioButton mRbLevel3;
    @BindView(R.id.rb_level_4)
    RadioButton mRbLevel4;
    @BindView(R.id.tv_detour)
    TextView mTvDetour;
    @BindView(R.id.rb_detour_yes)
    RadioButton mRbDetourYes;
    @BindView(R.id.rb_detour_no)
    RadioButton mRbDetourNo;
    @BindView(R.id.tv_unit)
    TextView mTvUnit;
    @BindView(R.id.es_vital_sign_aware_2)
    EditSpinner mEsVitalSignAware2;
    @BindView(R.id.tv_arrive_label)
    TextView mTvArriveLabel;
    @BindView(R.id.tv_arrive_time)
    TextView mTvArriveTime;
    @BindView(R.id.tv_detour_ccu)
    TextView mTvDetourCcu;
    @BindView(R.id.rb_detour_ccu_yes)
    RadioButton mRbDetourCcuYes;
    @BindView(R.id.rb_detour_ccu_no)
    RadioButton mRbDetourCcuNo;
    @BindView(R.id.tv_into)
    TextView mTvInto;
    @BindView(R.id.rb_into_yes)
    RadioButton mRbIntoYes;
    @BindView(R.id.rb_into_no)
    RadioButton mRbIntoNo;
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
    @BindView(R.id.cb_text_8)
    CheckBox mCbText8;
    @BindView(R.id.btn_get_data)
    AppCompatButton mBtnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton mBtnConfirm;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;
    @BindView(R.id.rg_into)
    RadioGroup mRgInto;
    @BindView(R.id.ll_into_no)
    LinearLayout mLlIntoNo;
    @BindView(R.id.ll_into_yes)
    LinearLayout mLlIntoYes;

    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;

    public static OriginalStatusFragment1 newInstance(String keyword) {
        OriginalStatusFragment1 fragment = new OriginalStatusFragment1();
//        Bundle args = new Bundle();
//        args.putString(IntentKey.PATIENT_ID, patientId);
//        args.putString(IntentKey.DOC_ID, docId);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_status_1;
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
        office.add("科室一");
        office.add("科室二");
        office.add("科室三");
        office.add("科室四");
        mEsVitalSignAware2.setItemData(office);
    }

    private void initEvent() {
        //选择科室
        mEsVitalSignAware2.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                // TODO: 2020/9/3 需要根据科室不同加载数据
            }
        });
        //显示再灌注
        mRgInto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRbIntoNo.getId()) { //否
                    mLlIntoNo.setVisibility(View.VISIBLE);
                    mLlIntoYes.setVisibility(View.GONE);
                }

                if (checkedId == mRbIntoYes.getId()) { //是
                    mLlIntoNo.setVisibility(View.GONE);
                    mLlIntoYes.setVisibility(View.VISIBLE);
                }
            }
        });

        //初诊时间
        mTvDrawBloodTime.setOnClickListener(v -> {
            mDialogAll.show(getChildFragmentManager(), "All");
        });

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.give_up_cure, R.id.rb_blood_frag_ae, R.id.rb_ct_frag_ae, R.id.rb_cta_frag_ae, R.id.rb_ctp_frag_ae,
            R.id.rb_mri_frag_ae, R.id.rb_mra_frag_ae, R.id.rb_cemra_frag_ae, R.id.rb_cvus_frag_ae, R.id.rb_tcd_frag_ae,
            R.id.tv_first_cure, R.id.tv_draw_blood_time, R.id.et_emergency_ward, R.id.tv_emergency_ward, R.id.rb_level_1,
            R.id.rb_level_2, R.id.rb_level_3, R.id.rb_level_4, R.id.tv_detour, R.id.rb_detour_yes, R.id.rb_detour_no,
            R.id.tv_unit, R.id.es_vital_sign_aware_2, R.id.tv_arrive_label, R.id.tv_arrive_time, R.id.tv_detour_ccu,
            R.id.rb_detour_ccu_yes, R.id.rb_detour_ccu_no, R.id.tv_into, R.id.rb_into_yes, R.id.rb_into_no, R.id.cb_text_1,
            R.id.cb_text_2, R.id.cb_text_3, R.id.cb_text_4, R.id.cb_text_5, R.id.cb_text_6, R.id.cb_text_7, R.id.cb_text_8,
            R.id.btn_get_data, R.id.btn_confirm, R.id.ll_bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.give_up_cure:
                break;
            case R.id.rb_blood_frag_ae:
                break;
            case R.id.rb_ct_frag_ae:
                break;
            case R.id.rb_cta_frag_ae:
                break;
            case R.id.rb_ctp_frag_ae:
                break;
            case R.id.rb_mri_frag_ae:
                break;
            case R.id.rb_mra_frag_ae:
                break;
            case R.id.rb_cemra_frag_ae:
                break;
            case R.id.rb_cvus_frag_ae:
                break;
            case R.id.rb_tcd_frag_ae:
                break;
            case R.id.tv_first_cure:
                break;
            case R.id.tv_draw_blood_time:

                break;
            case R.id.et_emergency_ward:
                break;
            case R.id.tv_emergency_ward:
                break;
            case R.id.rb_level_1:
                break;
            case R.id.rb_level_2:
                break;
            case R.id.rb_level_3:
                break;
            case R.id.rb_level_4:
                break;
            case R.id.tv_detour:
                break;
            case R.id.rb_detour_yes:
                break;
            case R.id.rb_detour_no:
                break;
            case R.id.tv_unit:
                break;
            case R.id.es_vital_sign_aware_2:
                break;
            case R.id.tv_arrive_label:
                break;
            case R.id.tv_arrive_time:
                break;
            case R.id.tv_detour_ccu:
                break;
            case R.id.rb_detour_ccu_yes:
                break;
            case R.id.rb_detour_ccu_no:
                break;
            case R.id.tv_into:
                break;
            case R.id.rb_into_yes:
                break;
            case R.id.rb_into_no:
                break;
            case R.id.cb_text_1:
                break;
            case R.id.cb_text_2:
                break;
            case R.id.cb_text_3:
                break;
            case R.id.cb_text_4:
                break;
            case R.id.cb_text_5:
                break;
            case R.id.cb_text_6:
                break;
            case R.id.cb_text_7:
                break;
            case R.id.cb_text_8:
                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
            case R.id.ll_bottom:
                break;
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        mTvDrawBloodTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
    }
}
