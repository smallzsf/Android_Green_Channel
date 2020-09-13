package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.TraumaImageCheckRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.trauma.TraumaImageCheckBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 心电检查
 *
 * @author Licy
 */
public class TraumaImageCheckFragment extends BaseStrokeFragment {


    @BindView(R.id.rv_check_items)
    RecyclerView rvCheckItems;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    private TraumaImageCheckBean mTraumaImageCheckBean;
    private List<TraumaImageCheckBean.TraumaImageCheckDetailBean> mDetailBeans;
    private TraumaImageCheckRvAdapter mCheckRvAdapter;
    private TraumaImageDialogFragment mImageDialogFragment;

    public static TraumaImageCheckFragment newInstance(String recordId) {
        TraumaImageCheckFragment fragment = new TraumaImageCheckFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_image_check;
    }

    @Override
    protected void initView(@NonNull View view) {

        mDetailBeans = new ArrayList<>();
        mDetailBeans.add(new TraumaImageCheckBean.TraumaImageCheckDetailBean("1"));
        mDetailBeans.add(new TraumaImageCheckBean.TraumaImageCheckDetailBean("2"));
        mDetailBeans.add(new TraumaImageCheckBean.TraumaImageCheckDetailBean("3"));
        mDetailBeans.add(new TraumaImageCheckBean.TraumaImageCheckDetailBean("4"));
        mDetailBeans.add(new TraumaImageCheckBean.TraumaImageCheckDetailBean("5"));
        mCheckRvAdapter = new TraumaImageCheckRvAdapter(R.layout.adapter_tuauma_image_check_item, mDetailBeans);
        rvCheckItems.setLayoutManager(new LinearLayoutManager(mActivity));
        rvCheckItems.setAdapter(mCheckRvAdapter);

        mImageDialogFragment = TraumaImageDialogFragment.newInstance(null);
    }


    @Override
    protected void initListener() {
        mCheckRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tv_detail_item_trauma_image) {
                    mImageDialogFragment.show(getChildFragmentManager(), mDetailBeans.get(position).getInspectionitem());
                } else if (view.getId() == R.id.tv_delete_item_trauma_image) {
                    mDetailBeans.remove(position);
                    mCheckRvAdapter.notifyItemRemoved(position);
                }
            }
        });
    }

}
