package com.xyj.strokeaid.activity.chestpain;

import android.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.GenderSelectBean;
import com.xyj.strokeaid.bean.dist.ChestPainOperationRsultBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @BindView(R.id.title_bar_act_npmr)
    BaseTitleBar titleBarActNpmr;
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
    @BindView(R.id.rg_approach)
    RadioGroup rgApproach;

    private List<GenderSelectBean> selectList = new ArrayList<>();
    private List<String> genderList;
    private List<String> genderListMore;
    private TagAdapter<String> tagGenderAdapter;
    private TagAdapter<String> tagGenderMoreAdapter;
    private TagAdapter<GenderSelectBean> selectAdapter;
    private Set<Integer> selectGender;
    private Set<Integer> selectGenderMore;
    private View popupWindowView;
    private ChestPainOperationResultPop popWindow;


    /**
     * 选中的部位设置信息
     */
    private Map<String,ChestPainOperationRsultBean.CoronaryangiographyarrayBean>  coronaryangiographyarrayBeanMap = new HashMap<>();

    /**
     * 界面管理bean 以及接口通信
     */
    private ChestPainOperationRsultBean bean;
    // 通过点击弹出 popupwindow 时设置
    private GenderSelectBean popGenderSelectBean;

    private ChestPainOperationResultUtil chestUtil;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chest_pain_operation_result;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @OnClick({R.id.iv_left_base_title_bar, R.id.tv_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left_base_title_bar:
                finish();
                break;
            case R.id.tv_more:
                if (tagGenderDiversityMore.getVisibility() == View.VISIBLE) {
                    tagGenderDiversityMore.setVisibility(View.GONE);
                    tvMore.setText("更多");
                } else {
                    tagGenderDiversityMore.setVisibility(View.VISIBLE);
                    tvMore.setText("收起");
                }
                break;
        }
    }

    @Override
    public void initView() {


        //术中并发症流布局
        tagIntraoperativeComplications.setAdapter(new TagAdapter<String>(Arrays.asList(getResources().getStringArray(R.array.chest_pain_operation_intraoperative_complications))) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);
                return view;
            }
        });

        initData();
    }

    private void initData(){
        chestUtil = new ChestPainOperationResultUtil(this);
        //显示前项
        chestUtil.initGenderMap(R.array.chest_pain_operation_gender_diversity);
        chestUtil.initGenderMap(R.array.chest_pain_operation_gender_diversity_more);

        bean = resetShow();

        initFlowLayout();
    }

    private ChestPainOperationRsultBean resetShow() {
        return new ChestPainOperationRsultBean();
    }



    /**
     * 冠脉造影流布局
     */
    private void initFlowLayout() {

        genderList = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapKey(R.array.chest_pain_operation_gender_diversity));
        tagGenderAdapter = new TagAdapter<String>(genderList) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);

                List<String> strings = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_gender_diversity));
                String s = strings.get(position);
                view.setTag(s);
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
        genderListMore = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapKey(R.array.chest_pain_operation_gender_diversity_more));
        tagGenderMoreAdapter = new TagAdapter<String>(genderListMore) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                view.setText(o);

                List<String> strings = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_gender_diversity_more));
                String s = strings.get(position);
                view.setTag(s);
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

                    List<String> valueDataList = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_gender_diversity));
                    String value = valueDataList.get(i);
                    String name = genderList.get(i);
                    GenderSelectBean bean =
                            new GenderSelectBean(i, 0, name,value);
                    selectList.add(bean);
                }
            }
        }
        if (null != selectGenderMore && null != genderListMore) {
            for (int i = 0; i < genderListMore.size(); i++) {
                if (selectGenderMore.contains(i)) {

                    List<String> valueDataList = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_gender_diversity_more));
                    String value = valueDataList.get(i);
                    String name = genderListMore.get(i);
                    GenderSelectBean bean =
                            new GenderSelectBean(i, 0, name,value);
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
                        // TODO  取消选中效果
                        Log.e("zhangshifu", bean.toString());
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
                // 点击选中条目的 position
                popGenderSelectBean = selectList.get(position);

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

        }
    }


    /**
     * 弹窗样式
     */
    private void initPopupWindow() {
        popupWindowView = getLayoutInflater().inflate(R.layout.pop_gender_diversity_detail, null, false);
        popWindow = new ChestPainOperationResultPop(this,popupWindowView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popWindow.setFocusable(true);
        popupWindowView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popWindow.showAtLocation(tagGenderSelect, Gravity.CENTER, 0, 0);
        popWindow.backgroundAlpha(0.8f);
    }

    @Override
    public void initListener() {

        rgApproach.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                bean.setArterialapproach((String) radioButton.getTag());
            }
        });
        titleBarActNpmr.setRightLayoutClickListener(rightSaveClickListener);
    }

    /**
     * 点击右边保存按钮
     */
    View.OnClickListener rightSaveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            ChestPainOperationRsultBean
            save(bean);
        }
    };

    public void save(ChestPainOperationRsultBean bean) {

    }
}
