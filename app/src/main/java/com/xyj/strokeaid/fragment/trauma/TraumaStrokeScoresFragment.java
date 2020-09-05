package com.xyj.strokeaid.fragment.trauma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.score.ISSActivity;
import com.xyj.strokeaid.activity.score.PHIActivity;
import com.xyj.strokeaid.activity.score.TIActivity;
import com.xyj.strokeaid.activity.score.TSActivity;
import com.xyj.strokeaid.activity.stroke.StrokeGcsScoreActivity;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * StrokeScoresFragment
 * description: 卒中 评分工具
 *
 * @author : Licy
 * @date : 2020/8/25
 * email ：licy3051@qq.com
 */
public class TraumaStrokeScoresFragment extends BaseFragment {

    @BindView(R.id.listview)
    ListView listView;
    private String mPatientId;
    private String mDocId;
    private String[] data = {"PHI评分 ", "TI评分", "TS评分", "GCS评分", "ISS评分"};

    public TraumaStrokeScoresFragment() {
        // Required empty public constructor
    }

    public static TraumaStrokeScoresFragment newInstance(String patientId, String docId) {
        TraumaStrokeScoresFragment fragment = new TraumaStrokeScoresFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    protected void initView(@NonNull View view) {
        listView.setAdapter(new MyAdapter());
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.length;
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
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.adapter_rv_stroke_path_item, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tvNameAdapterStrokePath.setText(data[position]);
            MyClickListener onClickListener = new MyClickListener(position);
            viewHolder.tvDescAdapterStrokePath.setOnClickListener(onClickListener);
            viewHolder.tvNameAdapterStrokePath.setOnClickListener(onClickListener);
            return view;
        }


    }

    static class ViewHolder {
        @BindView(R.id.tv_name_adapter_stroke_path)
        TextView tvNameAdapterStrokePath;
        @BindView(R.id.tv_desc_adapter_stroke_path)
        TextView tvDescAdapterStrokePath;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class MyClickListener implements View.OnClickListener {
        private int position;

        public MyClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (position == 0) {
                startActivity(new Intent(context, PHIActivity.class));
            } else if (position == 1) {
                startActivity(new Intent(context, TIActivity.class));
            } else if (position == 2) {
                startActivity(new Intent(context, TSActivity.class));
            } else if (position == 3) {
                startActivity(new Intent(context, StrokeGcsScoreActivity.class));
            } else if (position == 4) {
                startActivity(new Intent(context, ISSActivity.class));
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_stroke_scores;
    }

    @Override
    protected void initListener() {

    }


}

    
    
       
    