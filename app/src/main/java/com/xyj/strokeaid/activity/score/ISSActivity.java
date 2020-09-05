package com.xyj.strokeaid.activity.score;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ISSActivity extends BaseActivity {

    private Context context;
    @BindView(R.id.listview)
    ListView listview;
    private List<String[]> dataList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_score_iss;
    }

    @Override
    protected void initInject() {

    }


    @Override
    public void initView() {
        context = this;
        dataList = ISSCommon.getData();

        listview.setAdapter(new MyAdapter());
    }

    @Override
    public void initListener() {

    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.adapter_iss, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            String[] strings = dataList.get(i);
            if (strings.length > 0) {
                viewHolder.tvText1.setText(strings[0]);
                viewHolder.tvText1.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText1.setVisibility(View.GONE);
            }
            if (strings.length > 1) {
                viewHolder.tvText2.setText(strings[1]);
                viewHolder.tvText2.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText2.setVisibility(View.GONE);
            }
            if (strings.length > 2) {
                viewHolder.tvText3.setText(strings[2]);
                viewHolder.tvText3.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText3.setVisibility(View.GONE);
            }
            if (strings.length > 3) {
                viewHolder.tvText4.setText(strings[3]);
                viewHolder.tvText4.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText4.setVisibility(View.GONE);
            }
            if (strings.length > 4) {
                viewHolder.tvText5.setText(strings[4]);
                viewHolder.tvText5.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText5.setVisibility(View.GONE);
            }
            if (strings.length > 5) {
                viewHolder.tvText6.setText(strings[5]);
                viewHolder.tvText6.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvText6.setVisibility(View.GONE);
            }
            return view;
        }


    }

    static class ViewHolder {
        @BindView(R.id.iv_troponin)
        ImageView ivTroponin;
        @BindView(R.id.tv_text_1)
        TextView tvText1;
        @BindView(R.id.tv_text_2)
        TextView tvText2;
        @BindView(R.id.tv_text_3)
        TextView tvText3;
        @BindView(R.id.tv_text_4)
        TextView tvText4;
        @BindView(R.id.tv_text_5)
        TextView tvText5;
        @BindView(R.id.tv_text_6)
        TextView tvText6;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}