package com.xyj.strokeaid.activity.detection;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Set;

/**
  * @Package:        com.xyj.strokeaid.activity.detection
  * @ClassName:      IllnessRecordActivity
  * @Description:    病情记录页面Activity
  * @Autho:          王水雷
  * @Time:           2020/8/24
 */
@Route(path = RouteUrl.Detection.ILLNESS_RECORD)
public class IllnessRecordActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View  {


    @BindView(R.id.id_flow_layout)
    TagFlowLayout flowLayout;
    @BindView(R.id.id_flow_layout2)
    TagFlowLayout flowLayout2;

    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView","Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN|
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_illness_record;
    }
    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        flowLayout.setAdapter(mAdapter);
        flowLayout2.setAdapter(mAdapter2);
    }

    @Override
    public void initListener() {
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                Toast.makeText(mContext, mVals[position], Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        flowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener()
        {
            @Override
            public void onSelected(Set<Integer> selectPosSet)
            {
                //Toast.makeText(mContext, selectPosSet.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void showData(BaseObjectBean<NewAppplexyInfoBean> bean) {

    }

    @Override
    public void onLoadSaveSuccess(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String errMessage) {

    }
    TagAdapter<String> mAdapter=new TagAdapter<String>(mVals)
    {
        @Override
        public View getView(FlowLayout parent, int position, String s)
        {
            TextView tv = (TextView) LayoutInflater.from(IllnessRecordActivity.this).inflate(R.layout.adpter_flow_layout_tv_tag,
                    flowLayout, false);
            tv.setText(s);
            return tv;
        }

    };
    TagAdapter<String> mAdapter2=new TagAdapter<String>(mVals)
    {
        @Override
        public View getView(FlowLayout parent, int position, String s)
        {
            TextView tv = (TextView) LayoutInflater.from(IllnessRecordActivity.this).inflate(R.layout.adpter_flow_layout_tv_tag2,
                    flowLayout, false);
            tv.setText(s);
            return tv;
        }

    };
}