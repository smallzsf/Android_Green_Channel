package com.xyj.strokeaid.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.StrokeMainActivity;
import com.xyj.strokeaid.adapter.HomePatientRvAdapter;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.iv_exit_act_main)
    ImageView ivExitActMain;
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
        mPatientRvAdapter = new HomePatientRvAdapter(mPatientBeans, 1, 1);
        // 设置rv
        rvContentActMain.setLayoutManager(new LinearLayoutManager(mContext));
        rvContentActMain.setAdapter(mPatientRvAdapter);
        mPatientRvAdapter.setEmptyView(R.layout.view_empty_for_rv);

    }

    @Override
    public void initListener() {

        tvDiseaseTypeActMain.setOnClickListener(v -> {
            startActivity(new Intent(mContext, StrokeMainActivity.class));
        });
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
}