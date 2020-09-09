package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.dist.ChestPainOperationRsultBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.TextTimeBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

public class ChestPainOperationResultPop extends PopupWindow {
    @BindView(R.id.rb_smaller_half)
    RadioButton rbSmallerHalf;
    @BindView(R.id.rb_smaller_seventy)
    RadioButton rbSmallerSeventy;
    @BindView(R.id.rb_smaller_ninety)
    RadioButton rbSmallerNinety;
    @BindView(R.id.rb_smaller_hundred)
    RadioButton rbSmallerHundred;
    @BindView(R.id.rb_hundred)
    RadioButton rbHundred;
    @BindView(R.id.rb_gender_level_zero)
    RadioButton rbGenderLevelZero;
    @BindView(R.id.rb_gender_level_first)
    RadioButton rbGenderLevelFirst;
    @BindView(R.id.rb_gender_level_second)
    RadioButton rbGenderLevelSecond;
    @BindView(R.id.rb_gender_level_third)
    RadioButton rbGenderLevelThird;
    @BindView(R.id.rb_stent_thrombosis_false)
    RadioButton rbStentThrombosisFalse;
    @BindView(R.id.rb_stent_thrombosis_true)
    RadioButton rbStentThrombosisTrue;
    @BindView(R.id.rb_bifurcation_false)
    RadioButton rbBifurcationFalse;
    @BindView(R.id.rb_bifurcation_true)
    RadioButton rbBifurcationTrue;
    @BindView(R.id.rb_CTO_false)
    RadioButton rbCTOFalse;
    @BindView(R.id.rb_CTO_true)
    RadioButton rbCTOTrue;
    @BindView(R.id.rb_calcification_false)
    RadioButton rbCalcificationFalse;
    @BindView(R.id.rb_calcification_true)
    RadioButton rbCalcificationTrue;
    @BindView(R.id.rb_culprit_lesion_false)
    RadioButton rbCulpritLesionFalse;
    @BindView(R.id.rb_culprit_lesion_true)
    RadioButton rbCulpritLesionTrue;
    @BindView(R.id.rb_PCI_false)
    RadioButton rbPCIFalse;
    @BindView(R.id.rb_PCI_true)
    RadioButton rbPCITrue;
    @BindView(R.id.operation_process)
    TagFlowLayout operationProcess;
    @BindView(R.id.tv_through_time_guide_wire)
    TextTimeBar tvThroughTimeGuideWire;
    @BindView(R.id.rb_postoperative_level_zero)
    RadioButton rbPostoperativeLevelZero;
    @BindView(R.id.rb_postoperative_level_first)
    RadioButton rbPostoperativeLevelFirst;
    @BindView(R.id.rb_postoperative_level_second)
    RadioButton rbPostoperativeLevelSecond;
    @BindView(R.id.rb_postoperative_level_third)
    RadioButton rbPostoperativeLevelThird;
    @BindView(R.id.rb_support_zero)
    RadioButton rbSupportZero;
    @BindView(R.id.rb_support_first)
    RadioButton rbSupportFirst;
    @BindView(R.id.rb_support_second)
    RadioButton rbSupportSecond;
    @BindView(R.id.rb_support_third)
    RadioButton rbSupportThird;
    @BindView(R.id.rb_support_category_BMS)
    RadioButton rbSupportCategoryBMS;
    @BindView(R.id.rb_support_category_DES)
    RadioButton rbSupportCategoryDES;
    @BindView(R.id.rb_support_category_biodegradable)
    RadioButton rbSupportCategoryBiodegradable;
    @BindView(R.id.rb_support_category_other)
    RadioButton rbSupportCategoryOther;
    @BindView(R.id.linearPCI)
    LinearLayout linearPCI;
    @BindView(R.id.btn_save_diversity_detail)
    AppCompatButton btnSaveDiversityDetail;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.rg_narrow)
    RadioGroup rgNarrow;

    @BindView(R.id.rb_gender_timi)
    RadioGroup rgGenderTimi;


    @BindView(R.id.rb_is_thrombosis_in_stent)
    RadioGroup rbIsThrombosisInStent;
    @BindView(R.id.rg_is_bifurcation)
    RadioGroup rgIsBifurcation;
    @BindView(R.id.rg_is_cto)
    RadioGroup rgIsCto;
    @BindView(R.id.rg_is_calcified)
    RadioGroup rgIsCalcified;
    @BindView(R.id.rg_criminal)
    RadioGroup rgCriminal;
    @BindView(R.id.rg_pci)
    RadioGroup rgPci;

    DistListUtil resultUtil;
    @BindView(R.id.rg_timi_after)
    RadioGroup rgTimiAfter;
    @BindView(R.id.rg_stents_implanted_num)
    RadioGroup rgStentsImplantedNum;
    @BindView(R.id.rg_stent_type)
    RadioGroup rgStentType;
    private View popupWindowView;
    private Context context;

    private ChestPainOperationRsultBean.CoronaryangiographyarrayBean bean;


    public ChestPainOperationResultPop(Context context, View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
        this.context = context;
        popupWindowView = contentView;
        resultUtil = new DistListUtil(context);

//        popupWindowView = getLayoutInflater().inflate(R.layout.pop_gender_diversity_detail, null, false);
        ButterKnife.bind(this, popupWindowView);
        bean = new ChestPainOperationRsultBean.CoronaryangiographyarrayBean();
        initPopupWindow();
    }

    /**
     * 弹窗样式
     */
    private void initPopupWindow() {
        resultUtil.initGenderMap(R.array.chest_pain_operation_process);
        TagFlowLayout operation_process = popupWindowView.findViewById(R.id.operation_process);


        String genderMapKey = resultUtil.getGenderMapKey(R.array.chest_pain_operation_process);

        List<String> dataList = resultUtil.getMapGenderDataList().get(genderMapKey);

        //术中处理流布局
        operation_process.setAdapter(new TagAdapter<String>(dataList) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(context).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);

                return view;
            }
        });
        operation_process.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                Log.e("zhangshifu", selectPosSet.toString());
                HashSet<Integer> selectPos = (HashSet<Integer>) selectPosSet;
                String genderMapValueKey = resultUtil.getGenderMapValueKey(R.array.chest_pain_operation_process);
                List<String> strings = resultUtil.getMapGenderDataList().get(genderMapValueKey);
                String data = "";
                for (Integer selectPo : selectPos) {
                    String s = strings.get(selectPo);
                    if (TextUtils.isEmpty(data)) {
                        data += s;
                    } else {
                        data += ("," + s);
                    }
                }
                bean.setIntraoperativemanagement(data);

            }
        });
        //选择时间

        TextTimeBar tv_through_time_guide_wire = popupWindowView.findViewById(R.id.tv_through_time_guide_wire);
        tv_through_time_guide_wire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                        .setType(Type.ALL)
                        .setTitleStringId("选择时间")
                        .setThemeColor(context.getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.colorPrimary))
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                tv_through_time_guide_wire.setTime(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
                            }
                        })
                        //是否可循环
                        .setCyclic(false)
                        .setToolBarTextColor(R.color.colorPrimary)
                        .build();

                mDialogAll.show(((AppCompatActivity) context).getSupportFragmentManager(), "All");
            }
        });
        //销毁popupwindow
        ImageView ivDelete = popupWindowView.findViewById(R.id.iv_delete);
        ivDelete.setOnClickListener(clickListener);

        //PCI
        LinearLayout linearPCI = popupWindowView.findViewById(R.id.linearPCI);
        RadioButton rbPCIFalse = popupWindowView.findViewById(R.id.rb_PCI_false);
        RadioButton rbPCITrue = popupWindowView.findViewById(R.id.rb_PCI_true);

        rbPCIFalse.setOnClickListener(clickListener);
        rbPCITrue.setOnClickListener(clickListener);

        //保存
        AppCompatButton btSave = popupWindowView.findViewById(R.id.btn_save_diversity_detail);
        btSave.setOnClickListener(clickListener);

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_delete:
                    ChestPainOperationResultPop.this.dismiss();
                    break;
                case R.id.rb_PCI_false:
                    linearPCI.setVisibility(View.GONE);
                    break;
                case R.id.rb_PCI_true:
                    linearPCI.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_save_diversity_detail:
                    // TODO save
                    saveData();
                    ChestPainOperationResultPop.this.dismiss();
                    break;
            }
        }
    };

    private void saveData() {

        // 设置狭窄程度
        String value = getRadioButtonTag(rgNarrow);
        bean.setDegreeofarterystenosis(value);
        // 设置造影时TIMI血流
        value = getRadioButtonTag(rgGenderTimi);
        bean.setTimibefore(value);
        // 设置支架内血栓
        value = getRadioButtonTag(rbIsThrombosisInStent);
        bean.setIntraoperativemanagement(value);
        // 设置分叉病变
        value = getRadioButtonTag(rgIsBifurcation);
        bean.setIntraoperativemanagement(value);
        // 设置CTO
        value = getRadioButtonTag(rgIsCto);
        bean.setIscto(value);
        // 设置钙化病变
        value = getRadioButtonTag(rgIsCalcified);
        bean.setIscto(value);
        // 设置罪犯病变
        value = getRadioButtonTag(rgCriminal);
        bean.setIscto(value);
        // 设置PCI
        value = getRadioButtonTag(rgPci);
        bean.setIspci(value);
        // 此段代码必须先放在设置PCI之后
        if (TextUtils.equals("cpc_bool_true", value)) {
            bean.setOperationguidewirepasstime(tvThroughTimeGuideWire.getTime());
            // 设置支架个数
            value = getRadioButtonTag(rgTimiAfter);
            bean.setTimiafter(value);
            // 设置支架个数
            value = getRadioButtonTag(rgStentsImplantedNum);
            bean.setNumberofstentsimplanted(value);
            // 设置支架种类
            value = getRadioButtonTag(rgStentType);
            bean.setStenttype(value);

        } else {
            bean.setIntraoperativemanagement("");
        }

        if (callBack != null){
            callBack.save(bean);
        }
    }

    @NotNull
    private String getRadioButtonTag(RadioGroup rgGenderTimi) {
        RadioButton radioButton = popupWindowView.findViewById(rgGenderTimi.getCheckedRadioButtonId());
        if (radioButton == null) {
            return "";
        }
        return String.valueOf(radioButton.getTag());
    }

    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((AppCompatActivity) context).getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        ((AppCompatActivity) context).getWindow().setAttributes(lp);
    }

    private ICallBack callBack;

    public void setCallBack(ICallBack callBack){
        this.callBack = callBack;
    }

    public interface ICallBack{
        void save(ChestPainOperationRsultBean.CoronaryangiographyarrayBean bean);
    }


}
