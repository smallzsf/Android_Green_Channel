package com.xyj.strokeaid.activity.chestpain;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.GenderSelectBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.TextTimeBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * ChestPainOperationInfoActivity
 * description: 手术信息
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
public class ChestPainOperationResultActivity extends BaseActivity {

    @BindView(R.id.tag_gender_diversity)
    TagFlowLayout tagGenderDiversity;
    @BindView(R.id.tag_gender_diversity_more)
    TagFlowLayout tagGenderDiversityMore;
    @BindView(R.id.tv_more)
    TextView tvMore;

    @BindView(R.id.tag_intraoperative_complications)
    TagFlowLayout tagIntraoperativeComplications;

    @BindView(R.id.tag_gender_select)
    TagFlowLayout tagGenderSelect;

    private List<GenderSelectBean> selectList = new ArrayList<>();
    private List<String> genderList;
    private List<String> genderListMore;
    private TagAdapter<String> tagGenderAdapter;
    private TagAdapter<String> tagGenderMoreAdapter;
    private TagAdapter<GenderSelectBean> selectAdapter;
    private Set<Integer> selectGender;
    private Set<Integer> selectGenderMore;
    private View popupWindowView;
    private PopupWindow popWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chest_pain_operation_result;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @OnClick({R.id.iv_left_base_title_bar, R.id.tv_more})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_left_base_title_bar:
                finish();
                break;
            case R.id.tv_more:
                if(tagGenderDiversityMore.getVisibility()==View.VISIBLE){
                    tagGenderDiversityMore.setVisibility(View.GONE);
                    tvMore.setText("更多");
                }else{
                    tagGenderDiversityMore.setVisibility(View.VISIBLE);
                    tvMore.setText("收起");
                }
                break;
        }
    }

    @Override
    public void initView() {

        initFlowLayout();

        //术中并发症流布局
        tagIntraoperativeComplications.setAdapter(new TagAdapter<String>(Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_intraoperative_complications))) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        });

    }

    /**
     *冠脉造影流布局
     */
    private void initFlowLayout() {
        //显示前项
        genderList = Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_gender_diversity));
        tagGenderAdapter = new TagAdapter<String>(genderList) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        };
        tagGenderDiversity.setAdapter(tagGenderAdapter);
        tagGenderDiversity.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                selectGender = selectPosSet;
                setSelectFlowLayout();
            }
        });

        //显示前项
        genderListMore = Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_gender_diversity_more));
        tagGenderMoreAdapter = new TagAdapter<String>(genderListMore) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        };
        tagGenderDiversityMore.setAdapter(tagGenderMoreAdapter);
        tagGenderDiversityMore.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                selectGenderMore = selectPosSet;
                setSelectFlowLayout();
            }
        });
    }

    /**
     * 选中的流布局
     */
    private void setSelectFlowLayout() {
        selectList.clear();
        if (null != selectGender && null != genderListMore) {
            for (int i = 0; i < genderList.size(); i++) {
                if (selectGender.contains(i)) {
                    GenderSelectBean bean = new GenderSelectBean(i, 0, genderList.get(i));
                    selectList.add(bean);
                }
            }
        }
        if (null != selectGenderMore && null != genderListMore) {
            for (int i = 0; i < genderListMore.size(); i++) {
                if (selectGenderMore.contains(i)) {
                    GenderSelectBean bean = new GenderSelectBean(i, 1, genderListMore.get(i));
                    selectList.add(bean);
                }
            }
        }

        selectAdapter = new TagAdapter<GenderSelectBean>(selectList) {
            @Override
            public View getView(FlowLayout parent, int position, GenderSelectBean o) {
                View view = (View) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_select, parent, false);
                TextView tvTag = view.findViewById(R.id.tvTag);
                ImageView ivDelete = view.findViewById(R.id.iv_delete);
                ivDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //关联清除选中效果
                        GenderSelectBean bean = (GenderSelectBean) tagGenderSelect.getAdapter().getItem(position);
                        if (bean.getType() == 0) {
                            selectGender.remove(bean.getPosition());
                            tagGenderAdapter.setSelectedList(selectGender);
                        } else if (bean.getType() == 1) {
                            selectGenderMore.remove(bean.getPosition());
                            tagGenderMoreAdapter.setSelectedList(selectGenderMore);
                        }
                        selectList.remove(bean);
                        selectAdapter.notifyDataChanged();
                    }
                });
                tvTag.setText(o.getName());
                return view;
            }
        };

        tagGenderSelect.setAdapter(selectAdapter);

        tagGenderSelect.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                showPopupWindow();
                return false;
            }
        });
    }

    private void showPopupWindow() {
        if (null != popWindow && popWindow.isShowing()) {
            popWindow.dismiss();
        } else {
            initPopupWindow();
            backgroundAlpha(0.8f);
        }
    }
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
    /**
     * 弹窗样式
     */
    private void initPopupWindow() {
        popupWindowView = getLayoutInflater().inflate(R.layout.pop_gender_diversity_detail, null, false);
        popWindow = new PopupWindow(popupWindowView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popWindow.setFocusable(true);
        popupWindowView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popWindow.showAtLocation(tagGenderSelect, Gravity.CENTER, 0, 0);

        TagFlowLayout operation_process = popupWindowView.findViewById(R.id.operation_process);

        //术中处理流布局
        operation_process.setAdapter(new TagAdapter<String>(Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_process))) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
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
                        .setThemeColor(getResources().getColor(R.color.colorPrimary))
                        //当前文本颜色
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))
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

                mDialogAll.show(getSupportFragmentManager(), "All");
            }
        });
        //销毁popupwindow
        ImageView ivDelete = popupWindowView.findViewById(R.id.iv_delete);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();
            }
        });

        //PCI
        LinearLayout linearPCI = popupWindowView.findViewById(R.id.linearPCI);
        RadioButton rbPCIFalse = popupWindowView.findViewById(R.id.rb_PCI_false);
        RadioButton rbPCITrue = popupWindowView.findViewById(R.id.rb_PCI_true);
        rbPCIFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearPCI.setVisibility(View.GONE);
            }
        });
        rbPCITrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearPCI.setVisibility(View.VISIBLE);
            }
        });


        //保存
        AppCompatButton btSave = popupWindowView.findViewById(R.id.btn_save_diversity_detail);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

    @Override
    public void initListener() {

    }
}
