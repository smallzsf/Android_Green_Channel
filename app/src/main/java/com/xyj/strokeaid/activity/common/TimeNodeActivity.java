package com.xyj.strokeaid.activity.common;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.fragment.common.TimeNodeFragment;
import com.xyj.strokeaid.view.BaseTitleBar;

import butterknife.BindView;

/**
 * TimeNodeActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/7
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.TIME_NODE_VIEW)
public class TimeNodeActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_time_node)
    BaseTitleBar titleBarActTimeNode;
    @BindView(R.id.fl_content_act_time_node)
    FrameLayout flContentActTimeNode;

    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;
    @Autowired(name = IntentKey.VIEW_TYPE)
    int mViewType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_time_node;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        TimeNodeFragment timeNodeFragment = TimeNodeFragment.newInstance(mRecordId, mViewType);
        fragmentTransaction.add(R.id.fl_content_act_time_node, timeNodeFragment, "TimeNodeFragment").commitNow();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void initListener() {
        titleBarActTimeNode.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

    
    
       
    