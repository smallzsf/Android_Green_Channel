package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeTCRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.StrokeTCBean;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ThrombolysisContraindicationsActivity
 * description: 溶栓禁忌症
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_CONTRAINDICATIONS)
public class ThrombolysisContraindicationsActivity extends BaseActivity {

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.title_bar_act_tc)
    BaseTitleBar titleBarActTc;
    @BindView(R.id.rv_content_act_tc)
    RecyclerView rvContentActTc;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private List<StrokeTCBean> mStrokeTCBeans;
    private StrokeTCRvAdapter mStrokeTCRvAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolytic_contraindications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mStrokeTCBeans = prepareData();
        mStrokeTCRvAdapter = new StrokeTCRvAdapter(R.layout.adapter_header_single_text,R.layout.adapter_rv_stroke_thrombolysis_symptom_item, mStrokeTCBeans);

        rvContentActTc.setLayoutManager(new LinearLayoutManager(mContext));
        rvContentActTc.setAdapter(mStrokeTCRvAdapter);
        mStrokeTCRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());
    }

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                // TODO: 2020/8/21 保存信息
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private List<StrokeTCBean> prepareData() {
        ArrayList<StrokeTCBean> list = new ArrayList<>();

        list.add(new StrokeTCBean(true, "静脉溶栓禁忌症", false, ""));
        list.add(new StrokeTCBean(false, "1.颅内出血（包括脑实质出血、脑室内出血、蛛网膜下腔出血、硬膜下/外血肿等）", false, ""));
        list.add(new StrokeTCBean(false, "2.既往颅内出血史", false, ""));
        list.add(new StrokeTCBean(false, "3.近3个月有严重头颅外伤史或卒中史", false, ""));
        list.add(new StrokeTCBean(false, "4.颅内肿瘤、巨大颅内动脉瘤", false, ""));
        list.add(new StrokeTCBean(false, "5.近期（3个月）", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        list.add(new StrokeTCBean(false, "4.", false, ""));
        return list;
    }
}

    
    
       
    