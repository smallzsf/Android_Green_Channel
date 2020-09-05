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
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class OriginalStatusFragment1 extends BaseFragment implements OnDateSetListener {


    List<String> office = new ArrayList<>();
    TimePickerDialog mDialogAll;
    @BindView(R.id.give_up_cure)
    TextView giveUpCure;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton rbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton rbCtFragAe;
    @BindView(R.id.rb_cta_frag_ae)
    RadioButton rbCtaFragAe;
    @BindView(R.id.rb_ctp_frag_ae)
    RadioButton rbCtpFragAe;
    @BindView(R.id.rb_mri_frag_ae)
    RadioButton rbMriFragAe;
    @BindView(R.id.rb_mra_frag_ae)
    RadioButton rbMraFragAe;
    @BindView(R.id.rb_cemra_frag_ae)
    RadioButton rbCemraFragAe;
    @BindView(R.id.rb_cvus_frag_ae)
    RadioButton rbCvusFragAe;
    @BindView(R.id.rb_tcd_frag_ae)
    RadioButton rbTcdFragAe;
    @BindView(R.id.tv_first_cure)
    TextView tvFirstCure;
    RadioButton mRbTcdFragAe;
    @BindView(R.id.tv_draw_blood_time)
    TextTimeBar tvDrawBloodTime;
    TextTimeBar mTvDrawBloodTime;
    @BindView(R.id.et_emergency_ward)
    EditText etEmergencyWard;
    @BindView(R.id.tv_emergency_ward)
    TextView tvEmergencyWard;
    @BindView(R.id.rb_level_1)
    RadioButton rbLevel1;
    @BindView(R.id.rb_level_2)
    RadioButton rbLevel2;
    @BindView(R.id.rb_level_3)
    RadioButton rbLevel3;
    @BindView(R.id.rb_level_4)
    RadioButton rbLevel4;
    @BindView(R.id.tv_detour)
    TextView tvDetour;
    @BindView(R.id.rb_detour_yes)
    RadioButton rbDetourYes;
    @BindView(R.id.rb_detour_no)
    RadioButton rbDetourNo;
    @BindView(R.id.tv_unit)
    TextView tvUnit;
    @BindView(R.id.es_vital_sign_aware_2)
    EditSpinner esVitalSignAware2;
    @BindView(R.id.tv_arrive_label)
    TextView tvArriveLabel;
    EditSpinner mEsVitalSignAware2;
    @BindView(R.id.tv_arrive_time)
    TextView tvArriveTime;
    TextTimeBar mTvArriveTime;
    @BindView(R.id.tv_detour_ccu)
    TextView tvDetourCcu;
    @BindView(R.id.rb_detour_ccu_yes)
    RadioButton rbDetourCcuYes;
    @BindView(R.id.rb_detour_ccu_no)
    RadioButton rbDetourCcuNo;
    @BindView(R.id.tv_into)
    TextView tvInto;
    @BindView(R.id.rb_into_yes)
    RadioButton rbIntoYes;
    @BindView(R.id.rb_into_no)
    RadioButton rbIntoNo;
    @BindView(R.id.rg_into)
    RadioGroup rgInto;
    @BindView(R.id.cb_text_1)
    CheckBox cbText1;
    @BindView(R.id.cb_text_2)
    CheckBox cbText2;
    @BindView(R.id.cb_text_3)
    CheckBox cbText3;
    @BindView(R.id.cb_text_4)
    CheckBox cbText4;
    @BindView(R.id.cb_text_5)
    CheckBox cbText5;
    @BindView(R.id.cb_text_6)
    CheckBox cbText6;
    @BindView(R.id.cb_text_7)
    CheckBox cbText7;
    @BindView(R.id.cb_text_8)
    CheckBox cbText8;
    @BindView(R.id.ll_into_no)
    LinearLayout llIntoNo;
    @BindView(R.id.rb_into_measure_level_1)
    RadioButton rbIntoMeasureLevel1;
    @BindView(R.id.rb_into_measure_level_2)
    RadioButton rbIntoMeasureLevel2;
    @BindView(R.id.rb_into_measure_level_3)
    RadioButton rbIntoMeasureLevel3;
    @BindView(R.id.rb_into_measure_level_4)
    RadioButton rbIntoMeasureLevel4;
    @BindView(R.id.ll_into_yes)
    LinearLayout llIntoYes;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton mBtnConfirm;
    @BindView(R.id.rg_into)
    RadioGroup mRgInto;
    @BindView(R.id.ll_into_no)
    LinearLayout mLlIntoNo;
    @BindView(R.id.ll_into_yes)
    LinearLayout mLlIntoYes;
    AppCompatButton btnConfirm;


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
        esVitalSignAware2.setItemData(office);
    }

    private void initEvent() {
        //选择科室
        esVitalSignAware2.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                // TODO: 2020/9/3 需要根据科室不同加载数据
            }
        });
        //显示再灌注
        rgInto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rbIntoNo.getId()) { //否
                    llIntoNo.setVisibility(View.VISIBLE);
                    llIntoYes.setVisibility(View.GONE);
                }

                if (checkedId == rbIntoYes.getId()) { //是
                   llIntoNo.setVisibility(View.GONE);
                    llIntoYes.setVisibility(View.VISIBLE);
                }
            }
        });

        //初诊时间
      tvDrawBloodTime.setOnClickListener(v -> {
            mDialogAll.show(getChildFragmentManager(), "All");
        });

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.give_up_cure, R.id.rb_blood_frag_ae, R.id.rb_ct_frag_ae, R.id.rb_cta_frag_ae, R.id.rb_ctp_frag_ae,
            R.id.rb_mri_frag_ae, R.id.rb_mra_frag_ae, R.id.rb_cemra_frag_ae, R.id.rb_cvus_frag_ae, R.id.rb_tcd_frag_ae,
            R.id.tv_draw_blood_time, R.id.et_emergency_ward, R.id.tv_emergency_ward, R.id.rb_level_1,
            R.id.rb_level_2, R.id.rb_level_3, R.id.rb_level_4, R.id.tv_detour, R.id.rb_detour_yes, R.id.rb_detour_no,
            R.id.tv_unit, R.id.es_vital_sign_aware_2, R.id.tv_arrive_time, R.id.tv_detour_ccu,
            R.id.rb_detour_ccu_yes, R.id.rb_detour_ccu_no, R.id.tv_into, R.id.rb_into_yes, R.id.rb_into_no, R.id.cb_text_1,
            R.id.cb_text_2, R.id.cb_text_3, R.id.cb_text_4, R.id.cb_text_5, R.id.cb_text_6, R.id.cb_text_7, R.id.cb_text_8,
            R.id.btn_get_data, R.id.btn_confirm})
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

        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        tvDrawBloodTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
    }
}
