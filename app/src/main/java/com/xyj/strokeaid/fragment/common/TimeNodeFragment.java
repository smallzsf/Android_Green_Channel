package com.xyj.strokeaid.fragment.common;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.TimeNodeBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.http.PatientService;
import com.xyj.strokeaid.http.RetrofitClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        mTimeNodeRvAdapter = new TimeNodeRvAdapter(R.layout.adapter_rv_time_node_item, mTimeNodeBeans);

        rvContentFragTimeNode.setLayoutManager(new LinearLayoutManager(mActivity));
        rvContentFragTimeNode.setAdapter(mTimeNodeRvAdapter);
        mTimeNodeRvAdapter.setEmptyView(R.layout.view_empty_for_rv);

        if (!TextUtils.isEmpty(mRecordId)) {
            getTimeLine(mRecordId);
        }

    }

    @Override
    protected void initListener() {

        mTimeNodeRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tv_time_item_time_node) {
                    // 显示时间选择器
//                    showTimePickView(position);
                } else if (view.getId() == R.id.iv_refresh_item_time_node) {
                    String time = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, new Date());
//                    mTimeNodeBeans.get(position).setTime(time);
//                    mTimeNodeRvAdapter.notifyItemChanged(position);
                }
            }
        });
    }

    /**
     * 获取 主页 列表数据  1卒中、2胸痛、3创伤
     */
    private void getTimeLine(String recordId) {

        RecordIdBean timeLinePost = new RecordIdBean(recordId);

        RetrofitClient.getInstance()
                .create(PatientService.class)
                .getTimerLine(timeLinePost.getResuestBody(timeLinePost))
                .enqueue(new Callback<BaseObjectBean<List<TimeNodeBean>>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<List<TimeNodeBean>>> call, Response<BaseObjectBean<List<TimeNodeBean>>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {

                                if (response.body().getData() != null) {
                                    mTimeNodeBeans.addAll(response.body().getData());
                                    mTimeNodeRvAdapter.setList(mTimeNodeBeans);
                                }

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_result_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<List<TimeNodeBean>>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
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
//                            mTimeNodeBeans.get(position).setTime(time);
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