package com.xyj.strokeaid.activity.score;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ISSActivity extends BaseActivity {

    private Context context;
    @BindView(R.id.listview)
    ListView listview;
    private List<String[]> dataList = new ArrayList<>();
    private List<String> titleDataList = new ArrayList<>();

    Map<Integer, Boolean> mapOpenData = new HashMap<>();

    private int selectItemClickPosition = -1;
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
            if (mapOpenData.containsKey(i) ) {
                isOpen = mapOpenData.get(i);
            }
            String text = titleDataList.get(i);
            if(isOpen){
                text =  text+ "  " + (selectItemClickPosition + 1) + "分";
            }
            viewHolder.tvTitle.setText(text);
            viewHolder.rlTitle.setOnClickListener(new MyClickListener(i,true));
            if (isOpen) {
                viewHolder.ivTroponin.setImageResource(R.drawable.ic_arrow_up_blue);
            } else {
                viewHolder.ivTroponin.setImageResource(R.drawable.ic_arrow_down_blue);
            }

            checkOpen(strings, strings.length > 0 && isOpen, viewHolder.tvText1, 0);
            checkOpen(strings, strings.length > 1 && isOpen, viewHolder.tvText2, 1);
            checkOpen(strings, strings.length > 2 && isOpen, viewHolder.tvText3, 2);
            checkOpen(strings, strings.length > 3 && isOpen, viewHolder.tvText4, 3);
            checkOpen(strings, strings.length > 4 && isOpen, viewHolder.tvText5, 4);
            checkOpen(strings, strings.length > 5 && isOpen, viewHolder.tvText6, 5);
            return view;
        }

        private void checkOpen(String[] strings, boolean isOpen, TextView textView, int position) {
            if (isOpen) {
                textView.setOnClickListener(new MyClickListener(position,false));
                textView.setText(strings[position]);
                textView.setVisibility(View.VISIBLE);

                if (selectItemClickPosition == position){
                    textView.setBackgroundResource(R.drawable.shape_edittext_bg_blue);
                }else {
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
        public MyClickListener(int position,boolean title) {
            this.position = position;
            this.isTitle = title;
        }

        @Override
        public void onClick(View view) {
            if (!isTitle){

                selectItemClickPosition = position;
                myAdapter.notifyDataSetChanged();
            }else {
                if (mapOpenData.containsKey(position) && mapOpenData.get(position)) {
                    mapOpenData.put(position,false);
                }else {
                    mapOpenData.put(position,true);
                }
                selectItemClickPosition = 0;
                myAdapter.notifyDataSetChanged();
            }
        }
    }


}