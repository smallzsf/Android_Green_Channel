package com.xyj.strokeaid.activity.stroke;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.StrokeProcessBean;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.annotations.NonNull;

/**
 * @Description: FAST-ED评分
 * @Author: crq
 * @CreateDate: 2020/8/24 9:59
 */
public class FastEdActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    private int position;
    private Bundle bundle;
    private Intent intent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_fast_ed;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        intent = getIntent();
        bundle = intent.getExtras();
        String arrayList = bundle.getString("arrayList");
        List<StrokeProcessBean> list= new Gson().fromJson(arrayList, new TypeToken<List<StrokeProcessBean>>() {
        }.getType());
        position = bundle.getInt("position", 0);
        titlebar.setTitle(list.get(position).getName());


    }

    @Override
    public void initListener() {

    }


    private void init() {



    }



}
