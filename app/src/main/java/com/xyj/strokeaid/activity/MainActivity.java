package com.xyj.strokeaid.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.set.AccountActivity;
import com.xyj.strokeaid.adapter.HomePatientRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.MmkvKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.app.UserInfoCache;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.bean.TabEntity;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.helper.SpacesItemDecoration;
import com.xyj.strokeaid.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MainActivity
 * description: app 主页
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tv_user_act_main)
    TextView tvUserActMain;
    @BindView(R.id.rl_title_act_main)
    RelativeLayout rlTitleActMain;
    @BindView(R.id.et_search_view_search)
    EditText etSearchViewSearch;
    @BindView(R.id.ctl_title_act_main)
    CommonTabLayout tlTitleActMain;
    @BindView(R.id.rv_content_act_main)
    RecyclerView rvContentActMain;
    @BindView(R.id.srl_fresh_act_main)
    SwipeRefreshLayout srlFreshActMain;
    @BindView(R.id.tv_disease_view_search)
    TextView tvDiseaseViewSearch;
    @BindView(R.id.iv_search_view_search)
    ImageView ivSearchViewSearch;
    @BindView(R.id.tv_add_act_main)
    TextView tvAddActMain;

    private HomePatientRvAdapter mPatientRvAdapter;
    private List<HomePatientBean> mPatientBeans;
    private PopupWindow mDiseasePop;
    /**
     * 疾病类型（保存包mmkv中， 每次进入会读取当前的配置）
     * 1、 卒中（默认）
     * 2、 胸痛
     * 3、 创伤
     * 4、 危重孕产妇
     * 5、 危重儿童和新生儿
     */
    private int mDiseaseType = 3;
    /**
     * 患者类型（保存包mmkv中， 每次进入会读取当前的配置）
     * 0 ： 急救中 （默认）
     * 1 ： 已转归
     * 2 ： 已上报
     */
    private int mPatientType = 0;

    /**
     * 当前登录人的id
     */
    private String mDocId = "";
    private ArrayList<CustomTabEntity> mTabEntities;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        requestPerms("获取基础权限成功~", "获取基础权限失败~", Constants.BASIC_PERMISSIONS);

        // 设置 tab
        initTab();

        // 初始化用户信息
        if (UserInfoCache.getInstance().getUserInfo() != null) {
            tvUserActMain.setText(UserInfoCache.getInstance().getUserInfo().getName());
        }


        // 初始化rv数据
        mPatientBeans = new ArrayList<>();
        mPatientBeans.add(new HomePatientBean("张三", 58, 1, 1, "2020-08-20 09:53:14", "2020-08-20 10:53:31", "徐甜甜", "林柳", 1));
        mPatientRvAdapter = new HomePatientRvAdapter(mPatientBeans);
        // 设置rv
        rvContentActMain.setLayoutManager(new LinearLayoutManager(mContext));
        if (rvContentActMain.getItemDecorationCount() == 0) {
            rvContentActMain.addItemDecoration(new SpacesItemDecoration(10, 10, 10, 10, LinearLayout.VERTICAL));
        }
        rvContentActMain.setAdapter(mPatientRvAdapter);
        mPatientRvAdapter.setEmptyView(R.layout.view_empty_for_rv);

    }

    private void initTab() {
        mTabEntities = new ArrayList<>();
        for (int i = 0; i < Constants.HOME_TAB_TITLES.length; i++) {
            mTabEntities.add(new TabEntity(Constants.HOME_TAB_TITLES[i], 0, 0));
        }
        tlTitleActMain.setTabData(mTabEntities);
//        tlTitleActMain.showMsg(0, 8);
//        tlTitleActMain.showMsg(1, 22);
//        tlTitleActMain.showMsg(2, 16);
    }

    @Override
    public void initListener() {

        tvAddActMain.setOnClickListener(v ->
                ARouter.getInstance().build(RouteUrl.NEW_PATIENT)
                        .withString(IntentKey.DOC_ID, mDocId)
                        .navigation());

        etSearchViewSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tlTitleActMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });


        mPatientRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                String destination = "";
                if (mDiseaseType == 2) {
                    destination = RouteUrl.ChestPain.CHEST_PAIN_HOME;
                } else if (mDiseaseType == 3) {
                    destination = RouteUrl.Trauma.TRAUMA_HOME;
                } else if (mDiseaseType == 4) {
                    destination = RouteUrl.MaternalTreat.MATERNAL_TREAT_HOME;
                } else if (mDiseaseType == 5) {
                    destination = RouteUrl.ChildTreat.CHILD_TREAT_HOME;
                } else {
                    destination = RouteUrl.Stroke.STROKE_HOME;
                }
                ARouter.getInstance().build(destination)
                        .withInt(IntentKey.PATIENT_ID, mPatientBeans.get(position).getId())
                        .withString(IntentKey.DOC_ID, mDocId)
                        .navigation();
            }
        });

    }

    @OnClick({R.id.tv_user_act_main, R.id.tv_disease_view_search, R.id.iv_search_view_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_act_main:
                startActivity(new Intent(mContext, AccountActivity.class));
                break;
            case R.id.tv_disease_view_search:
                if (mDiseasePop == null) {
                    showPopWindow(mContext, tvDiseaseViewSearch);
                } else {
                    if (!mDiseasePop.isShowing()) {
                        showPopWindow(mContext, tvDiseaseViewSearch);
                    }
                }
                break;
            case R.id.iv_search_view_search:
                // TODO: 2020/8/20 查询
                break;
            default:
                break;
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String errMessage) {

    }

    @Override
    public void showData(BaseObjectBean<HomePatientBean> bean) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mDiseaseType = mDefaultMMKV.decodeInt(MmkvKey.HOME_DISEASE_TYPE);
        mDiseaseType = 3;
        mPatientType = mDefaultMMKV.decodeInt(MmkvKey.HOME_PATIENT_TYPE);
        tlTitleActMain.setCurrentTab(mPatientType);
        tvDiseaseViewSearch.setText(getDiseaseStringByType(mDiseaseType));
    }

    /**
     * 显示病种选择 pop
     */
    public void showPopWindow(@NonNull Context context, View anchor) {
        if (anchor == null) {
            return;
        }
        if (mDiseasePop == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.popwindow_home_diseases, null, false);
            TextView tvStroke = view.findViewById(R.id.tv_stroke_pop_diseases);
            tvStroke.setOnClickListener(v -> {
                mDiseaseType = 1;
                mDefaultMMKV.encode(MmkvKey.HOME_DISEASE_TYPE, mDiseaseType);
                tvDiseaseViewSearch.setText(getString(R.string.stroke));
                mPatientBeans.get(0).setDiseaseType(mDiseaseType);
                mPatientRvAdapter.notifyDataSetChanged();
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });
            TextView tvChestPain = view.findViewById(R.id.tv_chest_pain_pop_diseases);
            tvChestPain.setOnClickListener(v -> {
                mDiseaseType = 2;
                mDefaultMMKV.encode(MmkvKey.HOME_DISEASE_TYPE, mDiseaseType);
                tvDiseaseViewSearch.setText(getString(R.string.chest_pain));
                mPatientBeans.get(0).setDiseaseType(mDiseaseType);
                mPatientRvAdapter.notifyDataSetChanged();
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });

            TextView tvTrauma = view.findViewById(R.id.tv_trauma_pop_diseases);
            tvTrauma.setOnClickListener(v -> {
                mDiseaseType = 3;
                mDefaultMMKV.encode(MmkvKey.HOME_DISEASE_TYPE, mDiseaseType);
                tvDiseaseViewSearch.setText("创伤");
                mPatientBeans.get(0).setDiseaseType(mDiseaseType);
                mPatientRvAdapter.notifyDataSetChanged();
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });

            TextView tvMaternal = view.findViewById(R.id.tv_maternal_pop_diseases);
            tvMaternal.setOnClickListener(v -> {
                mDiseaseType = 4;
                mDefaultMMKV.encode(MmkvKey.HOME_DISEASE_TYPE, mDiseaseType);
                tvDiseaseViewSearch.setText("危重孕产妇");
                mPatientBeans.get(0).setDiseaseType(mDiseaseType);
                mPatientRvAdapter.notifyDataSetChanged();
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });

            TextView tvChild = view.findViewById(R.id.tv_child_pop_diseases);
            tvChild.setOnClickListener(v -> {
                mDiseaseType = 5;
                mDefaultMMKV.encode(MmkvKey.HOME_DISEASE_TYPE, mDiseaseType);
                tvDiseaseViewSearch.setText("危重儿童");
                mPatientBeans.get(0).setDiseaseType(mDiseaseType);
                mPatientRvAdapter.notifyDataSetChanged();
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });

            mDiseasePop = new PopupWindow(context);
            mDiseasePop.setContentView(view);
            mDiseasePop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mDiseasePop.setOutsideTouchable(true);
            mDiseasePop.setTouchable(true);
            mDiseasePop.setOnDismissListener(() -> {
                tvDiseaseViewSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.common_icon_white_arrow_down, 0);
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
                mDiseasePop.dismiss();
            });
        }
        if (mDiseasePop.isShowing()) {
            mDiseasePop.dismiss();
        } else {
            tvDiseaseViewSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.common_icon_white_arrow_up, 0);
            mDiseasePop.showAsDropDown(anchor);
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = 0.8f;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            getWindow().setAttributes(lp);
        }

    }

    private String getDiseaseStringByType(int diseaseType) {
        if (diseaseType == 2) {
            return "胸痛";
        } else if (diseaseType == 3) {
            return "创伤";
        } else if (diseaseType == 4) {
            return "危重孕产妇";
        } else if (diseaseType == 5) {
            return "危重儿童";
        } else {
            return "卒中";
        }
    }
}