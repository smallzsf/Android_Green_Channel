package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.PremorbidMrsAdapter;
import com.xyj.strokeaid.adapter.StrokeTriageAdapter;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 发病前mRS评分
 * @Author: crq
 * @CreateDate: 2020/8/24 10:17
 */
public class PremorbidMrsActivity extends BaseActivity {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.rv_premorbid_mrs)
    RecyclerView rvPremorbidMrs;
    private int position;
    private Bundle bundle;
    private Intent intent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_premobid_mrs;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        intent = getIntent();
        bundle = intent.getExtras();
        ArrayList<String> list = ((ArrayList<String>) bundle.getSerializable("arrayList"));
        position = bundle.getInt("position", 0);
        titlebar.setTitle(list.get(position));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("患者到院时间");
        strings.add("来院方式");
        strings.add("发病时间");
        strings.add("急诊分诊时间");
        strings.add("急诊医生接诊时间");
        strings.add("卒中医生急诊时间");
        strings.add("FAST-ED评分");
        strings.add("发病前mRS评分");
        strings.add("生命体征");
        strings.add("快速血糖");
        strings.add("心电图检查");
        strings.add("采血时间");
        strings.add("血样送检时间");
        strings.add("血样送达检验科时间");
        strings.add("体重");
        strings.add("身高");
        rvPremorbidMrs.setLayoutManager(new LinearLayoutManager(this));
        PremorbidMrsAdapter premorbidMrsAdapter = new PremorbidMrsAdapter(R.layout.layout_item, strings);
        rvPremorbidMrs.setAdapter(premorbidMrsAdapter);

    }

    @Override
    public void initListener() {

    }



}
