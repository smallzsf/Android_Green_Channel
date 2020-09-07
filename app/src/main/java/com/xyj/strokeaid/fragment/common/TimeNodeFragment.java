package com.xyj.strokeaid.fragment.common;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.TimeNodeRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.TimeNodeBean;
import com.xyj.strokeaid.helper.CalendarUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TimeNodeFragment
 * description: 时间节点
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class TimeNodeFragment extends BaseFragment {

    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rv_content_frag_time_node)
    RecyclerView rvContentFragTimeNode;

    private String mRecordId;
    private int mDiseaseViewType;

    private TimeNodeRvAdapter mTimeNodeRvAdapter;
    private List<TimeNodeBean> mTimeNodeBeans;
    protected TimePickerView mTimePickerView;

    public TimeNodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param recordId        记录ID
     * @param diseaseViewType 疾病类型
     * @return A new instance of fragment StrokeGetInvolvedFragment.
     */
    public static TimeNodeFragment newInstance(String recordId, int diseaseViewType) {
        TimeNodeFragment fragment = new TimeNodeFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        args.putInt(IntentKey.DISEASE_VIEW_TYPE, diseaseViewType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
            mDiseaseViewType = getArguments().getInt(IntentKey.DISEASE_VIEW_TYPE, 1);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_time_node;
    }

    @Override
    protected void initView(@NonNull View view) {
        mTimeNodeBeans = new ArrayList<>();
        mTimeNodeBeans.add(new TimeNodeBean("发病时间", "2020-08-26 17:34:54"));
        mTimeNodeBeans.add(new TimeNodeBean("入院时间", "2020-08-26 17:44:54"));
        mTimeNodeBeans.add(new TimeNodeBean("接诊时间", "2020-08-26 17:54:54"));
        mTimeNodeRvAdapter = new TimeNodeRvAdapter(R.layout.adapter_rv_time_node_item, mTimeNodeBeans);

        rvContentFragTimeNode.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragTimeNode.setAdapter(mTimeNodeRvAdapter);
        mTimeNodeRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    protected void initListener() {
        mTimeNodeRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tv_time_item_time_node) {
                    // 显示时间选择器
                    showTimePickView(position);
                } else if (view.getId() == R.id.iv_refresh_item_time_node) {
                    String time = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, new Date());
                    mTimeNodeBeans.get(position).setTime(time);
                    mTimeNodeRvAdapter.notifyItemChanged(position);
                }
            }
        });
    }




    /**
     * 显示时间选择控件
     *
     * @param position 选中的时间节点的位置
     */
    protected void showTimePickView(int position) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    String time = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date);
                    if (mTimeNodeBeans != null && mTimeNodeRvAdapter != null) {
                        if (mTimeNodeBeans.get(position) != null) {
                            mTimeNodeBeans.get(position).setTime(time);
                            mTimeNodeRvAdapter.notifyItemChanged(position);
                        }
                    }
                }
            })
                    .isDialog(false)
                    .setType(new boolean[]{true, true, true, true, true, true})
                    .setOutSideCancelable(true)
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }


}