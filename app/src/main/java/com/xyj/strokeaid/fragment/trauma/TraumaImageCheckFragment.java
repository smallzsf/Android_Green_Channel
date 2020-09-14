package com.xyj.strokeaid.fragment.trauma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
import com.xyj.strokeaid.view.ActionSheet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 影像检查
 * 检查项目逗号隔开 1 CT平扫 2 增强CT 3 三维重建 4 CTA 5 CTP 6 MRI  7 彩超  8 DR  9 DSA 10 其他
 *
 * @author Licy
 */
public class TraumaImageCheckFragment extends BaseStrokeFragment {


    @BindView(R.id.rv_check_items)
    RecyclerView rvCheckItems;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.iv_add)
    ImageView ivAdd;

    private TraumaImageCheckBean mTraumaImageCheckBean;
    private List<TraumaImageCheckBean.TraumaImageCheckDetailBean> mDetailBeans;
    private TraumaImageCheckRvAdapter mCheckRvAdapter;
    private TraumaImageDetailActivity mImageDialogFragment;

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
    }


    @Override
    protected void initListener() {
        mCheckRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tv_detail_item_trauma_image) {
                    startActivity(new Intent(mActivity, TraumaImageDetailActivity.class));
                } else if (view.getId() == R.id.tv_delete_item_trauma_image) {
                    mDetailBeans.remove(position);
                    mCheckRvAdapter.notifyItemRemoved(position);
                }
            }
        });

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionSheet("CT平扫", "增强CT", "三维重建", "CTA", "CTP", "MRI", "彩超", "DR", "DSA", "其他");
            }
        });
    }

    private void showActionSheet(String... strings) {
        ActionSheet.createBuilder(mActivity, getFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles(strings)
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        startActivity(new Intent(mActivity, TraumaImageDetailActivity.class));
                    }
                }).show();
    }
}
