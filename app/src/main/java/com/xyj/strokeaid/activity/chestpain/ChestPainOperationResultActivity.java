package com.xyj.strokeaid.activity.chestpain;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.GenderSelectBean;
import com.xyj.strokeaid.bean.dist.ChestPainOperationRsultBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.distutil.DistListUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainOperationInfoActivity
 * description: 手术信息
 *
 * @author : LiuTing
 * @date : 2020/9/2
 * email ：122724021@qq.com
 */
@Route(path = RouteUrl.ChestPain.CHEST_PAIN_OPERATION_RESULT)
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
    @BindView(R.id.rb_radial_artery_right)
    RadioButton rbRadialArteryRight;
    @BindView(R.id.rb_radial_artery_left)
    RadioButton rbRadialArteryLeft;
    @BindView(R.id.rb_arteria_femoralis)
    RadioButton rbArteriaFemoralis;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.rb_gender_diversity_IVUS)
    RadioButton rbGenderDiversityIVUS;
    @BindView(R.id.rb_gender_diversity_OCT)
    RadioButton rbGenderDiversityOCT;
    @BindView(R.id.rb_gender_diversity_other)
    RadioButton rbGenderDiversityOther;
    @BindView(R.id.rb_gender_diversity_no_doing)
    RadioButton rbGenderDiversityNoDoing;
    @BindView(R.id.rg_cpc_qnyx)
    RadioGroup rgCpcQnyx;
    @BindView(R.id.rb_function_FFR)
    RadioButton rbFunctionFFR;
    @BindView(R.id.rb_function_iFR)
    RadioButton rbFunctionIFR;
    @BindView(R.id.rb_function_IMR)
    RadioButton rbFunctionIMR;
    @BindView(R.id.rb_function_other)
    RadioButton rbFunctionOther;
    @BindView(R.id.rb_function_no_doing)
    RadioButton rbFunctionNoDoing;
    @BindView(R.id.rg_cpc_funcexam)
    RadioGroup rgCpcFuncexam;
    @BindView(R.id.et_doctor_input)
    EditText etDoctorInput;
    @BindView(R.id.tv_doctor_select)
    TextView tvDoctorSelect;
    @BindView(R.id.rb_IABP_false)
    RadioButton rbIABPFalse;
    @BindView(R.id.rb_IABP_true)
    RadioButton rbIABPTrue;
    @BindView(R.id.rg_iabp)
    RadioGroup rgIabp;
    @BindView(R.id.rb_pacesetter_true)
    RadioButton rbPacesetterTrue;
    @BindView(R.id.rb_pacesetter_false)
    RadioButton rbPacesetterFalse;
    @BindView(R.id.rg_temporary_pacemaker)
    RadioGroup rgTemporaryPacemaker;
    @BindView(R.id.rb_ECMO_true)
    RadioButton rbECMOTrue;
    @BindView(R.id.rb_ECMO_false)
    RadioButton rbECMOFalse;
    @BindView(R.id.rg_ecmo)
    RadioGroup rgEcmo;
    @BindView(R.id.rb_ventricular_assist_true)
    RadioButton rbVentricularAssistTrue;
    @BindView(R.id.rb_ventricular_assist_false)
    RadioButton rbVentricularAssistFalse;
    @BindView(R.id.rg_left_vent_assist_device)
    RadioGroup rgLeftVentAssistDevice;
    @BindView(R.id.idb_cpc_funcexam_value)
    ItemEditBar idbCpcFuncexamValue;

    private List<GenderSelectBean> selectList = new ArrayList<>();
    private List<String> intraoperativeList;
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
    private Map<String, ChestPainOperationRsultBean.CoronaryangiographyarrayBean>
            coronaryangiographyarrayBeanMap = new HashMap<>();

    /**
     * 界面管理bean 以及接口通信
     */
    private ChestPainOperationRsultBean bean;
    // 通过点击弹出 popupwindow 时设置
    private GenderSelectBean popGenderSelectBean;

    private DistListUtil chestUtil;
    private TagAdapter<String> tagIntraoAdapter;

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

        initData();
    }

    private void initData() {
        bean = new ChestPainOperationRsultBean();
        chestUtil = new DistListUtil(this);
        //显示前项
        chestUtil.initGenderMap(R.array.chest_pain_operation_gender_diversity);
        chestUtil.initGenderMap(R.array.chest_pain_operation_gender_diversity_more);
        chestUtil.initGenderMap(R.array.chest_pain_operation_intraoperative_complications);
        initFlowLayout();

        bean = resetShowNet();
//        resetShow();
    }

    private void resetShow() {

        String value = bean.getIsiabp();
        resetRadioButton(rgIabp, value);
        // 腔内影像
        resetRadioButton(rgCpcQnyx, bean.getIntracavitaryimaging());
        //功能检测
        resetRadioButton(rgCpcFuncexam, bean.getFunctiondetectionvalue());
        //临时起搏器
        resetRadioButton(rgTemporaryPacemaker, bean.getIstemporarypacemaker());
        // 设置ecmo
        resetRadioButton(rgEcmo, bean.getIsecmo());
        //左心室辅助装置
        resetRadioButton(rgLeftVentAssistDevice, bean.getIsleftventassistdevice());

        List<ChestPainOperationRsultBean.CoronaryangiographyarrayBean> data = bean.getCoronaryangiographyarray();
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                ChestPainOperationRsultBean.CoronaryangiographyarrayBean bean = data.get(i);
                for (int j = 0; j < genderList.size(); j++) {
                    String s = genderList.get(j);
                    if (TextUtils.equals(s, bean.getCoronaryangiographyX())) {
                        tagGenderAdapter.setSelected(j, s);
                    }
                }

                for (int j = 0; j < genderListMore.size(); j++) {
                    String s = genderListMore.get(j);
                    if (TextUtils.equals(s, bean.getCoronaryangiographyX())) {
                        tagGenderMoreAdapter.setSelected(j, s);
                    }
                }
            }
        }

//        setIntraoperativecomplications
        Set<Integer> selectIntraoPosition = new HashSet<>();
        String intraoperativecomplications = bean.getIntraoperativecomplications();
        List<String> intraoValueList = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_intraoperative_complications));
        if (!TextUtils.isEmpty(intraoperativecomplications) && intraoValueList != null) {
            for (int i = 0; i < intraoValueList.size(); i++) {
                String s = intraoValueList.get(i);
                if (intraoperativecomplications.contains(s)) {
                    tagIntraoAdapter.setSelected(i, s);
                }
            }
        }
    }

    private void resetRadioButton(RadioGroup rg, String value) {
        int childCount = rg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioButton radioButton = (RadioButton) rg.getChildAt(i);
            if (TextUtils.equals(radioButton.getTag().toString(), value)) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    // TODO 通过网络请求得到这个javabean 自动回显数据
    private ChestPainOperationRsultBean resetShowNet() {
        RecordIdUtil src = new RecordIdUtil();
        src.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(src);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainOpeationResult(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {

                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        Log.e("zhangshifu", "onResponse");
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });
        return new ChestPainOperationRsultBean();
    }


    private void refrashIntraoAdapter(boolean isReset) {
        if (tagGenderAdapter == null || isReset) {
            tagIntraoAdapter = new TagAdapter<String>(intraoperativeList) {
                @Override
                public View getView(FlowLayout parent, int position, String o) {
                    TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.adapter_tag_item, parent, false);
                    view.setText(o);

                    List<String> strings = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_intraoperative_complications));
                    String s = strings.get(position);
                    view.setTag(s);

                    return view;
                }
            };
            tagIntraoperativeComplications.setAdapter(tagIntraoAdapter);
        } else {
            tagIntraoAdapter.notifyDataChanged();
        }

    }

    /**
     * 冠脉造影流布局
     */
    private void initFlowLayout() {
        intraoperativeList = chestUtil.getMapGenderDataList().get(chestUtil.getGenderMapKey(R.array.chest_pain_operation_intraoperative_complications));
        refrashIntraoAdapter(false);

        //术中并发症流布局
        tagIntraoperativeComplications.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                HashSet<Integer> selectPos = (HashSet<Integer>) selectPosSet;
                String genderMapValueKey = chestUtil.getGenderMapValueKey(R.array.chest_pain_operation_intraoperative_complications);
                List<String> strings = chestUtil.getMapGenderDataList().get(genderMapValueKey);
                String data = "";
                for (Integer selectPo : selectPos) {
                    String s = strings.get(selectPo);
                    if (TextUtils.isEmpty(data)) {
                        data += s;
                    } else {
                        data += ("," + s);
                    }
                }
//                intraoperativecomplications
                bean.setIntraoperativecomplications(data);
            }
        });

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
                            new GenderSelectBean(i, 0, name, value);
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
                            new GenderSelectBean(i, 0, name, value);
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
        popWindow = new ChestPainOperationResultPop(this, popupWindowView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popWindow.setFocusable(true);
        popupWindowView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popWindow.showAtLocation(tagGenderSelect, Gravity.CENTER, 0, 0);
        popWindow.backgroundAlpha(0.8f);
        popWindow.setCallBack(new ChestPainOperationResultPop.ICallBack() {
            @Override
            public void save(ChestPainOperationRsultBean.CoronaryangiographyarrayBean bean) {

//                coronaryangiography
                String netType = popGenderSelectBean.getNetType();
                bean.setCoronaryangiographyX(netType);
                coronaryangiographyarrayBeanMap.put(netType, bean);
            }
        });
    }

    @Override
    public void initListener() {

        rgApproach.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tag = getRadioButtonTag(radioGroup);
                bean.setArterialapproach(tag);
            }
        });
        titleBarActNpmr.setRightLayoutClickListener(rightSaveClickListener);
    }

    private String getRadioButtonTag(RadioGroup radioGroup) {
        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        if (radioButton == null) {
            return "";
        }
        return (String) radioButton.getTag();
    }

    /**
     * 点击右边保存按钮
     */
    View.OnClickListener rightSaveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ArrayList<ChestPainOperationRsultBean.CoronaryangiographyarrayBean> coronaryangiographyarray = new ArrayList<>();
            for (Map.Entry<String, ChestPainOperationRsultBean.CoronaryangiographyarrayBean> entry : coronaryangiographyarrayBeanMap.entrySet()) {
                coronaryangiographyarray.add(entry.getValue());
            }
            bean.setCoronaryangiographyarray(coronaryangiographyarray);

            // 设置iabp
            String value = getRadioButtonTag(rgIabp);
            bean.setIsiabp(value);
            // 腔内影像
            value = getRadioButtonTag(rgCpcQnyx);
            bean.setIntracavitaryimaging(value);
//          功能检测
            value = getRadioButtonTag(rgCpcFuncexam);
            bean.setFunctiondetectionvalue(value);

//        临时起搏器
            value = getRadioButtonTag(rgTemporaryPacemaker);
            bean.setIstemporarypacemaker(value);

            // 设置ecmo
            value = getRadioButtonTag(rgEcmo);
            bean.setIsecmo(value);
            //左心室辅助装置
            value = getRadioButtonTag(rgLeftVentAssistDevice);
            bean.setIsleftventassistdevice(value);

//            functiondetectionvalue
            String editContent = idbCpcFuncexamValue.getEditContent();
            bean.setFunctiondetectionvalue(editContent);
            save(bean);

        }
    };

    public void save(ChestPainOperationRsultBean bean) {
        bean.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(bean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainOpeationResult(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            BaseObjectBean body = response.body();
                            if (body.getResult() == 1) {
                                showToast("数据保存成功");
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });


    }

}
