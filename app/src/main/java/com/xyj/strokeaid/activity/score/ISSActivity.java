package com.xyj.strokeaid.activity.score;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ISSActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActNihss;
    @BindView(R.id.tv_result_score)
    TextView tvResultScore;
    @BindView(R.id.ll_score_act_nihss)
    LinearLayout llScoreActNihss;
    private Context context;
    @BindView(R.id.listview)
    ListView listview;
    private List<String[]> dataList = new ArrayList<>();
    private List<String> titleDataList = new ArrayList<>();

    Map<Integer, Boolean> mapOpenData = new HashMap<>();

    private int[][] selectItemClickPosition = new int[6][1];
    private MyAdapter myAdapter;

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
        titleDataList = ISSCommon.getTitleData();

        myAdapter = new MyAdapter();
        listview.setAdapter(myAdapter);

        mapOpenData.put(0,true);
        for (int i = 0; i < selectItemClickPosition.length; i++) {
            selectItemClickPosition[i][0] = -1;
        }
        refrashScore();
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
            boolean isOpen = false;
            if (mapOpenData.containsKey(i)) {
                isOpen = mapOpenData.get(i);
            }
            String text = titleDataList.get(i);
            viewHolder.tvTitle.setText(text);
            viewHolder.rlTitle.setOnClickListener(new MyClickListener(i, 0,true));
            if (isOpen) {
                viewHolder.ivTroponin.setImageResource(R.drawable.ic_arrow_up_blue);
            } else {
                viewHolder.ivTroponin.setImageResource(R.drawable.ic_arrow_down_blue);
            }

            checkOpen(strings, strings.length > 0 && isOpen, viewHolder.tvText1, i, 0);
            checkOpen(strings, strings.length > 1 && isOpen, viewHolder.tvText2, i, 1);
            checkOpen(strings, strings.length > 2 && isOpen, viewHolder.tvText3, i, 2);
            checkOpen(strings, strings.length > 3 && isOpen, viewHolder.tvText4, i, 3);
            checkOpen(strings, strings.length > 4 && isOpen, viewHolder.tvText5, i, 4);
            checkOpen(strings, strings.length > 5 && isOpen, viewHolder.tvText6, i, 5);
            return view;
        }

        private void checkOpen(String[] strings, boolean isOpen, TextView textView, int groupPosition, int position) {
            if (isOpen) {
                textView.setOnClickListener(new MyClickListener(groupPosition, position, false));
                textView.setText(strings[position]);
                textView.setVisibility(View.VISIBLE);

                if (selectItemClickPosition[groupPosition][0] == position) {
                    textView.setBackgroundResource(R.drawable.shape_edittext_bg_blue);
                } else {
                    textView.setBackgroundResource(R.drawable.shape_edittext_bg);
                }


            } else {
                textView.setVisibility(View.GONE);
            }
        }


    }

    static class ViewHolder {
        @BindView(R.id.iv_troponin)
        ImageView ivTroponin;
        @BindView(R.id.rl_title)
        RelativeLayout rlTitle;
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
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class MyClickListener implements View.OnClickListener {
        private int position;
        private boolean isTitle;
        private int groupPosition;

        public MyClickListener(int position, boolean title) {
            this.position = position;
            this.isTitle = title;
        }

        public MyClickListener(int groupPosition, int position, boolean title) {
            this.position = position;
            this.groupPosition = groupPosition;
            this.isTitle = title;
        }

        @Override
        public void onClick(View view) {
            if (!isTitle) {
                selectItemClickPosition[groupPosition][0] = position;
                myAdapter.notifyDataSetChanged();
            } else {
                if (mapOpenData.containsKey(groupPosition) && mapOpenData.get(groupPosition)) {
                    mapOpenData.put(groupPosition, false);
                } else {
                    mapOpenData.put(groupPosition, true);
                }
                myAdapter.notifyDataSetChanged();
            }
            refrashScore();
        }
    }

    private void refrashScore() {
        int sumScore = 0;
        for (int i = 0; i < selectItemClickPosition.length; i++) {
            int score = selectItemClickPosition[i][0] + 1;
            sumScore += score;
        }

        tvResultScore.setText("评分结果：" + sumScore + "分");
    }


}