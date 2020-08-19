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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.set.AccountActivity;
import com.xyj.strokeaid.adapter.HomePatientRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
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
    @BindView(R.id.iv_add_act_main)
    ImageView ivAddActMain;
    @BindView(R.id.rl_title_act_main)
    RelativeLayout rlTitleActMain;
    @BindView(R.id.et_search_view_search)
    EditText etSearchViewSearch;
    @BindView(R.id.tv_disease_type_act_main)
    TextView tvDiseaseTypeActMain;
    @BindView(R.id.tl_title_act_main)
    TabLayout tlTitleActMain;
    @BindView(R.id.rv_content_act_main)
    RecyclerView rvContentActMain;
    @BindView(R.id.srl_fresh_act_main)
    SwipeRefreshLayout srlFreshActMain;

    private HomePatientRvAdapter mPatientRvAdapter;
    private List<HomePatientBean> mPatientBeans;
    private PopupWindow mDiseasePop;
    /**
     * 1 :  卒中
     * 2 :  胸痛
     */
    private int mDiseaseType;
    /**
     * 患者类型
     * 1 ： 入径患者
     * 2 ： 绿道转归患者
     */
    private int mPatientType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        // 设置 tab
        for (String homeTabTitle : Constants.HOME_TAB_TITLES) {
            tlTitleActMain.addTab(tlTitleActMain.newTab().setText(homeTabTitle));
        }
        // 初始化rv数据
        mPatientBeans = new ArrayList<>();
        mPatientBeans.add(new HomePatientBean());
        mPatientBeans.add(new HomePatientBean());
        mPatientBeans.add(new HomePatientBean());
        mPatientRvAdapter = new HomePatientRvAdapter(mPatientBeans, 1, 1);
        // 设置rv
        rvContentActMain.setLayoutManager(new LinearLayoutManager(mContext));
        if (rvContentActMain.getItemDecorationCount() == 0) {
            rvContentActMain.addItemDecoration(new SpacesItemDecoration(12, 5, 12, 5, LinearLayout.VERTICAL));
        }
        rvContentActMain.setAdapter(mPatientRvAdapter);
        mPatientRvAdapter.setEmptyView(R.layout.view_empty_for_rv);

    }

    @Override
    public void initListener() {

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

        tlTitleActMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mPatientRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

            }
        });

    }

    @OnClick({R.id.tv_user_act_main, R.id.iv_add_act_main, R.id.tv_disease_type_act_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_act_main:
                startActivity(new Intent(mContext, AccountActivity.class));
                break;
            case R.id.iv_add_act_main:
                // TODO: 2020/8/19 跳转添加页面
                break;
            case R.id.tv_disease_type_act_main:
                showPopWindow(mContext, tvDiseaseTypeActMain);
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
                tvDiseaseTypeActMain.setText(getString(R.string.stroke));
                if (mDiseasePop != null) {
                    mDiseasePop.dismiss();
                }
            });
            TextView tvChestPain = view.findViewById(R.id.tv_chest_pain_pop_diseases);
            tvChestPain.setOnClickListener(v -> {
                mDiseaseType = 2;
                tvDiseaseTypeActMain.setText(getString(R.string.chest_pain));
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
                tvDiseaseTypeActMain.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.common_icon_white_arrow_down, 0);
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
            tvDiseaseTypeActMain.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.common_icon_white_arrow_up, 0);
            mDiseasePop.showAsDropDown(anchor);
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = 0.3f;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            getWindow().setAttributes(lp);
        }

    }

}