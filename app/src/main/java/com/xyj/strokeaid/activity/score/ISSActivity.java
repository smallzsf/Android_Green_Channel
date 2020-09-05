package com.xyj.strokeaid.activity.score;

import android.os.Bundle;
import android.widget.ListView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ISSActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listview;

    private List<String[]> dataList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_score_iss;
    }

    @Override
    protected void initInject() {

//        listview.setAdapter(new MyAdapter());
        initData();
    }

    private void initData() {
        dataList = ISSCommon.getData();


    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }




}