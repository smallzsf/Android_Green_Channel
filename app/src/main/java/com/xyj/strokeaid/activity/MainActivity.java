package com.xyj.strokeaid.activity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.presenter.MainPresenter;

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


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

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
        ButterKnife.bind(this);
    }
}