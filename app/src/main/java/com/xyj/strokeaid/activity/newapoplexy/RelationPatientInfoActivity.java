package com.xyj.strokeaid.activity.newapoplexy;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.HomePatientRvAdapter;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.helper.SpacesItemDecoration;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Package: com.xyj.strokeaid.activity.newapoplexy
 * @ClassName: RelationPatientInfoActivity
 * @Description: 关联患者信息页面
 * @Autho: 王水雷
 * @Time: 2020/8/21
 */
public class RelationPatientInfoActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View {


    @BindView(R.id.bt_relation_info)
    BaseTitleBar btRelationInfo;
    @BindView(R.id.rv_patient_info)
    RecyclerView rvPatientInfo;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    private HomePatientRvAdapter mPatientRvAdapter;
    private List<HomePatientBean> mPatientBeans;
    @Override
    public int getLayoutId() {
        return R.layout.activity_relation_patient_info;
    }

    @Override
    public void initView() {

        // 初始化rv数据
        mPatientBeans = new ArrayList<>();
        mPatientBeans.add(new HomePatientBean("张三", 58, 1, 1, "2020-08-20 09:53:14", "2020-08-20 10:53:31", "徐甜甜", "林柳", 1));
        mPatientBeans.add(new HomePatientBean("李东冬冬", 59, 1, 1, "2020-08-20 09:53:14", "2020-08-20 10:53:31", "徐甜甜", "林柳", 1));
        mPatientBeans.add(new HomePatientBean("王文", 60, 1, 1, "2020-08-20 09:53:14", "2020-08-20 10:53:31", "徐甜甜", "林柳", 1));
        mPatientRvAdapter = new HomePatientRvAdapter(mPatientBeans, 1, 1);
        // 设置rv
        rvPatientInfo.setLayoutManager(new LinearLayoutManager(mContext));
        if (rvPatientInfo.getItemDecorationCount() == 0) {
            rvPatientInfo.addItemDecoration(new SpacesItemDecoration(12, 5, 12, 5, LinearLayout.VERTICAL));
        }
        rvPatientInfo.setAdapter(mPatientRvAdapter);
        mPatientRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    public void initListener() {

        btRelationInfo.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    @Override
    public void showData(BaseObjectBean<NewAppplexyInfoBean> bean) {
    }
    @Override
    public void onLoadSaveSuccess(String msg) {
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
    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //保存
            case R.id.btn_confirm:
                ToastUtils.showLong("保存");
                break;
            //取消
            case R.id.btn_cancel:
                ToastUtils.showLong("取消");
                break;
        }
    }
}