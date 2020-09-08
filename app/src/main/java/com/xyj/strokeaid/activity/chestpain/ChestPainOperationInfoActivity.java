package com.xyj.strokeaid.activity.chestpain;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.Guideline;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.Path;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * ChestPainOperationInfoActivity
 * description: 手术信息
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
@Route(path = RouteUrl.ChestPain.CHEST_PAIN_OPERATION_INFO)
public class ChestPainOperationInfoActivity extends BaseActivity {

    //    @BindView(R.id.iv_left_base_title_bar)
//    ImageView ivBack;
//    @BindView(R.id.tv_title_base_title_bar)
//    TextView tvTitle;
//    @BindView(R.id.tv_right_base_title_bar)
//    TextView tvSave;
    @BindView(R.id.title_bar_act_npmr)
    BaseTitleBar titleBarActNpmr;
    @BindView(R.id.tag_reason_delay)
    TagFlowLayout tagFlowLayout;

    @BindView(R.id.tv_activation_time_cath_lab)
    TextTimeBar tvActivationTime;       //导管室激活时间
    @BindView(R.id.tv_arrive_time_patient)
    TextTimeBar tvArriveTime;       //患者到达时间
    @BindView(R.id.tv_time_begin)
    TextTimeBar tvTimeBegin;       //手术开始时间
    @BindView(R.id.tv_time_puncture)
    TextTimeBar tvTimePuncture;       //开始穿刺时间
    @BindView(R.id.tv_success_time_puncture)
    TextTimeBar tvSuccessTimePuncture;       //穿刺成功时间
    @BindView(R.id.tv_time_anticoagulant_administration)
    TextTimeBar tvTimeAnticoagulantAdministration;       //抗凝给药时间
    @BindView(R.id.tv_time_radiography)
    TextTimeBar tvTimeRadiography;       //造影开始时间
    @BindView(R.id.tv_talk_time_again)
    TextTimeBar tvTalkTimeAgain;       //再次谈话时间
    @BindView(R.id.tv_through_time_guide_wire)
    TextTimeBar tvThroughTimeGuideWire;       //导丝通过时间
    @BindView(R.id.tv_over_time)
    TextTimeBar tvOverTime;       //手术结束时间

    @BindView(R.id.es_preliminary_diagnosis_doctor)
    EditSpinner es_preliminary_diagnosis_doctor;    //初步诊断
    @BindView(R.id.es_type)
    EditSpinner es_type;        //手术类型
    @BindView(R.id.es_medicinal_name)
    EditSpinner es_medicinal_name;  //药品名称

    @BindView(R.id.rb_delay_true)
    RadioButton rbTrue;
    @BindView(R.id.rb_delay_false)
    RadioButton rbFalse;
    private boolean delayType = false;
    //初步诊断
    private List<String> preliminaryDiagnosisList = new ArrayList<>();
    private List<String> STEMIList = new ArrayList<>();
    private List<String> NSTEMIlist = new ArrayList<>();
    private List<String> UAList = new ArrayList<>();

    @OnClick({R.id.iv_left_base_title_bar, R.id.tv_right_base_title_bar, R.id.tv_activation_time_cath_lab, R.id.tv_arrive_time_patient, R.id.tv_time_begin, R.id.tv_time_puncture,
            R.id.tv_success_time_puncture, R.id.tv_time_anticoagulant_administration, R.id.tv_time_radiography, R.id.tv_talk_time_again, R.id.tv_through_time_guide_wire, R.id.tv_over_time,
            R.id.rb_delay_false, R.id.rb_delay_true})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left_base_title_bar:
                finish();
                break;
            case R.id.tv_right_base_title_bar:  //保存
                break;
            case R.id.rb_delay_true:
                delayType = true;
                tagFlowLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_delay_false:
                delayType = false;
                tagFlowLayout.setVisibility(View.GONE);
                break;
            case R.id.tv_activation_time_cath_lab: //导管室激活时间
                TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvActivationTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_arrive_time_patient: //患者到达时间
                TimePickerDialog mDialogAll1 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvArriveTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll1.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_time_begin: //手术开始时间
                TimePickerDialog mDialogAll2 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvTimeBegin.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll2.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_time_puncture: //开始穿刺时间
                TimePickerDialog mDialogAll3 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvTimePuncture.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll3.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_success_time_puncture: //穿刺成功时间
                TimePickerDialog mDialogAll4 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvSuccessTimePuncture.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll4.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_time_anticoagulant_administration: //抗凝给药时间
                TimePickerDialog mDialogAll5 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvTimeAnticoagulantAdministration.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll5.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_time_radiography: //造影开始时间
                TimePickerDialog mDialogAll6 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvTimeRadiography.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll6.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_talk_time_again: //再次谈话时间
                TimePickerDialog mDialogAll7 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvTalkTimeAgain.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll7.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_through_time_guide_wire: //导丝通过时间
                TimePickerDialog mDialogAll8 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvThroughTimeGuideWire.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll8.show(getSupportFragmentManager(), "All");
                break;
            case R.id.tv_over_time: //手术结束时间
                TimePickerDialog mDialogAll9 = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tvOverTime.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll9.show(getSupportFragmentManager(), "All");
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_chest_pain_operation_info;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        titleBarActNpmr.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tagFlowLayout.setAdapter(new TagAdapter<String>(Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_delay_reason))) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        });

        List<String> list = Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_medicinal));
        es_medicinal_name.setItemData(list);
    }

    @Override
    public void initListener() {
        preliminaryDiagnosisList.add("STEMI");
        preliminaryDiagnosisList.add("NSTEMI");
        preliminaryDiagnosisList.add("UA");
        es_preliminary_diagnosis_doctor.setItemData(preliminaryDiagnosisList);

        STEMIList.add("直接PCI");
        STEMIList.add("溶栓后补救PCI");
        STEMIList.add("溶栓后介入");
        STEMIList.add("择期介入");
        STEMIList.add("转运PCI");

        NSTEMIlist.add("紧急介入治疗");
        NSTEMIlist.add("24H内介入治疗");
        NSTEMIlist.add("72H内介入治疗");
        NSTEMIlist.add("择期介入");

        UAList.add("紧急介入治疗");
        UAList.add("24H内介入治疗");
        UAList.add("72H内介入治疗");
        UAList.add("择期介入");

        es_preliminary_diagnosis_doctor.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.equals("STEMI")) {
                    es_type.setText("请选择");
                    es_type.setItemData(STEMIList);
                } else if (text.equals("NSTEMI")) {
                    es_type.setText("请选择");
                    es_type.setItemData(NSTEMIlist);
                } else if (text.equals("UA")) {
                    es_type.setText("请选择");
                    es_type.setItemData(UAList);
                }
            }
        });

    }
}
