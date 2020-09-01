package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeHosRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.StrokeHosBean;
import com.xyj.strokeaid.helper.CallUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * StartGreenwayFragment
 * description: 启动绿道
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StartGreenwayFragment extends BaseFragment {

    @BindView(R.id.rv_hos_frag_sg)
    RecyclerView rvHosFragSg;
    @BindView(R.id.btn_start_frag_sg)
    AppCompatButton btnStart;

    private String mPatientId;
    private String mDocId;

    private StrokeHosRvAdapter mStrokeHosRvAdapter;
    private List<StrokeHosBean> mStrokeHosBeans;

    public StartGreenwayFragment() {
        // Required empty public constructor
    }

    public static StartGreenwayFragment newInstance(String patientId, String docId) {
        StartGreenwayFragment fragment = new StartGreenwayFragment();
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
    protected int getLayoutId() {
        return R.layout.fragment_start_greenway;
    }

    @Override
    protected void initView(@NonNull View view) {
        mStrokeHosBeans = new ArrayList<>();
        mStrokeHosBeans.add(new StrokeHosBean("郑州卒中中心医院", "0371-99986666"));
        mStrokeHosBeans.add(new StrokeHosBean("安阳卒中中心医院", "0372-99986666"));
        mStrokeHosBeans.add(new StrokeHosBean("新乡卒中中心医院", "0373-99986666"));

        mStrokeHosRvAdapter = new StrokeHosRvAdapter(R.layout.adapter_rv_stroke_hos_item, mStrokeHosBeans);

        rvHosFragSg.setLayoutManager(new LinearLayoutManager(mActivity));
        rvHosFragSg.setAdapter(mStrokeHosRvAdapter);
        mStrokeHosRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    protected void initListener() {
        btnStart.setOnClickListener(v -> {
            showToast("发送成功~");
        });

        mStrokeHosRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.iv_call_item_stroke_hos) {
                    CallUtils.callPhone(mStrokeHosBeans.get(position).getPhone(), mActivity);
                }
            }
        });

        mStrokeHosRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                for (StrokeHosBean strokeHosBean : mStrokeHosBeans) {
                    strokeHosBean.setChecked(false);
                }
                mStrokeHosBeans.get(position).setChecked(!mStrokeHosBeans.get(position).isChecked());
                mStrokeHosRvAdapter.notifyDataSetChanged();
            }
        });
    }

}