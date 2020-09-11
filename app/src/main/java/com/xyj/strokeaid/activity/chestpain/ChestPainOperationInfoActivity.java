package com.xyj.strokeaid.activity.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.chestpain.OperationInfoBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @BindView(R.id.title_bar_act_npmr)
    BaseTitleBar titleBarActNpmr;
 /*   @BindView(R.id.tag_reason_delay)
    TagFlowLayout tagFlowLayout;
*/
    @BindView(R.id.tv_activation_time_cath_lab)
    TextTimeBar tvActivationTime;       //导管室激活时间
    @BindView(R.id.tv_arrive_time_patient)
    TextTimeBar tvArriveTime;       //患者到达时间
/*    @BindView(R.id.tv_time_begin)
    TextTimeBar tvTimeBegin;       *///手术开始时间
    @BindView(R.id.tv_time_puncture)
    TextTimeBar tvTimePuncture;       //开始穿刺时间

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

    @BindView(R.id.es_medicinal_name)
    EditSpinner es_medicinal_name;  //药品名称

/*    @BindView(R.id.rb_delay_true)
    RadioButton rbTrue;
    @BindView(R.id.rb_delay_false)
    RadioButton rbFalse;*/
    @BindView(R.id.et_doctor_input)
    EditText etDoctorInput;
    @BindView(R.id.et_recorder_input)
    EditText etRecorderInput;
    @BindView(R.id.et_dosage)
    EditText etDosage;
    @BindView(R.id.et_unit)
    EditText etUnit;
    private boolean delayType = false;
    //初步诊断
    private List<String> preliminaryDiagnosisList = new ArrayList<>();
    private List<String> STEMIList = new ArrayList<>();
    private List<String> NSTEMIlist = new ArrayList<>();
    private List<String> UAList = new ArrayList<>();
    private OperationInfoBean operationInfoBean = null;
    HashMap<String, String> medicinalHashMap = null;
    private HashMap<String, String> delayHashMap = null;
    private List<String> intraoperativeList;
    private DistListUtil distListUtil;

    @OnClick({R.id.iv_left_base_title_bar, R.id.tv_right_base_title_bar,
            R.id.tv_activation_time_cath_lab, R.id.tv_arrive_time_patient, R.id.tv_time_puncture,
            R.id.tv_time_anticoagulant_administration, R.id.tv_time_radiography,
            R.id.tv_talk_time_again, R.id.tv_through_time_guide_wire, R.id.tv_over_time,
           })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left_base_title_bar:
                finish();
                break;
            case R.id.tv_right_base_title_bar:  //保存
                saveData();
                break;
      /*      case R.id.rb_delay_true:
                delayType = true;
                tagFlowLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_delay_false:
                delayType = false;
                tagFlowLayout.setVisibility(View.GONE);
                break;*/
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
        /*    case R.id.tv_time_begin: //手术开始时间
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
                break;*/
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


    /**
     * 保存胸痛手术信息数据
     */
    private void saveData() {
        if (operationInfoBean == null) {
            operationInfoBean = new OperationInfoBean();
            return;
        }
        //调用获取数据接口
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId("213242341");
        operationInfoBean.setRecordId(p.getRecordId());
        //介入医师 pcimedicalstaffid
        String etDoctor = etDoctorInput.getText().toString().trim();
        operationInfoBean.setPcimedicalstaffid(etDoctor);
        //手术记录人 operationfillerid
        String etRecorder = etRecorderInput.getText().toString().trim();
        operationInfoBean.setOperationfillerid(etRecorder);


        //time 9
        String time1 = tvActivationTime.getTime();//导管室激活时间
        String time2 = tvArriveTime.getTime();  //患者到达时间
       // String time3 = tvTimeBegin.getTime(); //手术开始时间
        String time4 = tvTimePuncture.getTime();//开始穿刺时间
        String time5 = tvTimeAnticoagulantAdministration.getTime(); //抗凝给药时间
        String time6 = tvTimeRadiography.getTime();//造影开始时间
        String time7 = tvTalkTimeAgain.getTime();//再次谈话时间
        String time8 = tvThroughTimeGuideWire.getTime();  //导丝通过时间
        String time9 = tvOverTime.getTime();//手术结束时间
        operationInfoBean.setPcipatientcommunicationagainendtime(time7);//再次谈话时间  再次知情同意
        operationInfoBean.setActivedsaroomtime(time1);//导管室激活时间
        operationInfoBean.setPatientarriveddsaroomtime(time2);//患者到达导管室
        operationInfoBean.setPuncturebegintime(time4);//开始穿刺时间
        operationInfoBean.setCagbegintime(time6);//造影开始时间
        operationInfoBean.setSiroperationguidewirepasstime(time8);//导丝通过时间
        operationInfoBean.setPciendtime(time9);//手术结束时间
        operationInfoBean.setSsanticoagulantmedicinetime(time5);//抗凝给药时间


        /**术中抗凝药物（"cpc_knyw_ptgs": "普 ssanticoagulationdrug
         *  "cpc_knyw_ptgs": "普通肝素",
         *                 "cpc_knyw_dfzgs": "低分子肝素",
         *                 "cpc_knyw_bfrd": "比伐卢定",
         *                 "cpc_knyw_hdgkn": "磺达肝癸钠"
         */

        String[] selectData = es_medicinal_name.getSelectData();
        operationInfoBean.setSsanticoagulationdrug(selectData[1]);


        //中抗凝药物剂量  sssanticoagulationdrugdosage
        operationInfoBean.setSssanticoagulationdrugdosage(etDosage.getText().toString().trim());
        //术中抗凝药物剂量(单位) sssanticoagulationdrugunit
        operationInfoBean.setSssanticoagulationdrugunit(etUnit.getText().toString().trim());


        //术中并发症流布局

       /* tagFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                HashSet<Integer> selectPos = (HashSet<Integer>) selectPosSet;
                String genderMapValueKey = distListUtil.getGenderMapValueKey(R.array.chest_pain_operation_delay_reason);
                List<String> strings = distListUtil.getMapGenderDataList().get(genderMapValueKey);
                String data = "";
                for (Integer selectPo : selectPos) {
                    String s = strings.get(selectPo);
                    if (TextUtils.isEmpty(data)) {
                        data += s;
                    } else {
                        data += ("," + s);
                    }
                }
                LogUtils.d(data);
            //    intraoperativecomplications
             //   operationInfoBean.setIntraoperativecomplications(data);
            }
        });*/

        chestPainChestPainOperationInfoSave(operationInfoBean);

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
        //术中抗凝药物
   /*

        //**
         *是否延误
         *//*
        delayHashMap = new HashMap<>();
        */


        titleBarActNpmr.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
  /*      distListUtil = new DistListUtil(this.mContext);
        distListUtil.initGenderMap(R.array.chest_pain_operation_delay_reason);

        intraoperativeList = distListUtil.getMapGenderDataList().get(distListUtil.getGenderMapKey(R.array.chest_pain_operation_delay_reason));
        tagFlowLayout.setAdapter(new TagAdapter<String>(intraoperativeList) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        });*/



        /**
         * editSpinner设置数据
         */

        es_medicinal_name.setStringArrayId(R.array.chest_pain_operation_medicinal);
      /*  List<String> list = Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_medicinal));
        es_medicinal_name.setItemData(list);*/
        /**
         * 获取手术信息数据
         */
        chestPainChestPainOperationInfoGet();
    }


    @Override
    public void initListener() {

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


    }

    /**
     * 胸痛 手术信息保存
     */
    private void chestPainChestPainOperationInfoSave(OperationInfoBean operationInfoBean) {


        String request = GsonUtils.getGson().toJson(operationInfoBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .saveChestPainOperationInfo(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());

                    }
                });
    }


    /**
     * 胸痛 手术信息获取
     */
    private void chestPainChestPainOperationInfoGet() {

        //调用获取数据接口
        RecordIdUtil p = new RecordIdUtil();
        p.setRecordId("213242341");
        String request = GsonUtils.getGson().toJson(p);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainOperationInfo(requestBody)
                .enqueue(new Callback<BaseObjectBean<OperationInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<OperationInfoBean>> call, Response<BaseObjectBean<OperationInfoBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                if (response.body().getData() != null) {
                                    showToast("获取数据成功");
                                    OperationInfoBean data = response.body().getData();
                                    getOperationInfo(data);
                                }

                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean<OperationInfoBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                    }
                });
    }

    /**
     * 获取数据
     *
     * @param data
     */
    private void getOperationInfo(OperationInfoBean data) {
        //介入医师 pcimedicalstaffid
        etDoctorInput.setText(data.getPcimedicalstaffid());
        //手术记录人 operationfillerid
        etRecorderInput.setText(data.getOperationfillerid());

        tvTalkTimeAgain.setTime(data.getPcipatientcommunicationagainendtime());//再次谈话时间  再次知情同意
        tvActivationTime.setTime(data.getActivedsaroomtime());//导管室激活时间
        tvArriveTime.setTime(data.getPatientarriveddsaroomtime());//患者到达导管室
        tvTimePuncture.setTime(data.getPuncturebegintime());//开始穿刺时间
        tvTimeRadiography.setTime(data.getCagbegintime());//造影开始时间
        tvThroughTimeGuideWire.setTime(data.getSiroperationguidewirepasstime());//导丝通过时间
        tvOverTime.setTime(data.getPciendtime());//手术结束时间
        tvTimeAnticoagulantAdministration.setTime(data.getSsanticoagulantmedicinetime());
        ;//抗凝给药时间

        // ssanticoagulationdrug
        String text = data.getSsanticoagulationdrug();
        es_medicinal_name.setStringArrayNormalKey(text);
        //中抗凝药物剂量  sssanticoagulationdrugdosage
        etDosage.setText(data.getSssanticoagulationdrugdosage());
        //术中抗凝药物剂量(单位) sssanticoagulationdrugunit
        etUnit.setText(data.getSssanticoagulationdrugunit());

    }


}
