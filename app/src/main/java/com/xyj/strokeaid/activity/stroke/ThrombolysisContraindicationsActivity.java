package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
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
        return R.layout.stroke_act_thrombolysis_contraindications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mStrokeTCBeans = prepareData();
        mStrokeTCRvAdapter = new StrokeTCRvAdapter(R.layout.adapter_header_single_text, R.layout.adapter_rv_stroke_thrombolysis_symptom_item, mStrokeTCBeans);

        rvContentActTc.setLayoutManager(new LinearLayoutManager(mContext));
        rvContentActTc.setAdapter(mStrokeTCRvAdapter);
        mStrokeTCRvAdapter.setEmptyView(R.layout.view_empty_for_rv);
    }

    @Override
    public void initListener() {
        titleBarActTc.setLeftLayoutClickListener(v -> finish());

        mStrokeTCRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.tsb_root) {
                   final boolean checked = mStrokeTCBeans.get(position).getChecked();
                    if (!mStrokeTCBeans.get(position).isHeader()) {
                        mStrokeTCBeans.get(position).setChecked(!checked);
                        mStrokeTCRvAdapter.notifyItemChanged(position);
                    }
                    if (position == 15) {
                        // 清除1~14项的选中状态
                        if (!checked) {
                            mStrokeTCBeans.get(position).setChecked(true);
                            for (int i = 1; i < 15; i++) {
                                mStrokeTCBeans.get(i).setChecked(false);
                            }
                        }
                    }else if (position == mStrokeTCBeans.size() - 1) {
                        // 清除相对禁忌症中1~6项的选中状态
                        if (!checked) {
                            mStrokeTCBeans.get(position).setChecked(true);
                            for (int i = 17; i < mStrokeTCBeans.size() - 1; i++) {
                                mStrokeTCBeans.get(i).setChecked(false);
                            }
                        }
                    }
                    mStrokeTCRvAdapter.notifyDataSetChanged();
                }
            }
        });
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
        list.add(new StrokeTCBean(false, "5.近期（3个月）有颅内或椎管内手术", false, ""));
        list.add(new StrokeTCBean(false, "6.活动性内脏出血", false, ""));
        list.add(new StrokeTCBean(false, "7.近1周内有在不易压迫止血部位的动脉穿刺", false, ""));
        list.add(new StrokeTCBean(false, "8.血压升高：收缩压≥180mmHg，或舒张压≥100mmHg", false, ""));
        list.add(new StrokeTCBean(false, "9.急性出血倾向，包括血小板计数低于100x109/L或其他情况", false, ""));
        list.add(new StrokeTCBean(false, "10.48h内接受过肝素治疗（APTT超出正常范围上限）", false, ""));
        list.add(new StrokeTCBean(false, "11.口服抗凝剂且INR＞1.7或PT＞15s", false, ""));
        list.add(new StrokeTCBean(false, "12.目前正在使用凝血酶抑制器或Xa因子抑制剂，各种敏感的实验室检查异常（如APTT，INR，血小板计数，ECT，TT或恰当的Xa因子活性测定等）", false, ""));
        list.add(new StrokeTCBean(false, "13.血糖＜2.7mmol/L", false, ""));
        list.add(new StrokeTCBean(false, "14.头部CT或MRI提示大面积梗死（梗死面积＞1/3大脑中动脉供血区）", false, ""));
        list.add(new StrokeTCBean(false, "15.无以上禁忌症", false, ""));
        list.add(new StrokeTCBean(true, "相对禁忌症\n下列情况需谨慎考虑和权衡溶栓的分析和获益（即虽然存在一项或多项禁忌症，但并非绝对不能溶栓）", false, ""));
        list.add(new StrokeTCBean(false, "1.轻型非致残性卒中或症状迅速改善的卒中", false, ""));
        list.add(new StrokeTCBean(false, "2.惊厥发作后出现的神经功能损害（与此次卒中发生相关）", false, ""));
        list.add(new StrokeTCBean(false, "3.近2周内有大型外科手术或严重外伤", false, ""));
        list.add(new StrokeTCBean(false, "4.近3个月内有心肌梗死", false, ""));
        list.add(new StrokeTCBean(false, "5.近3周内有胃肠或泌尿系统出血", false, ""));
        list.add(new StrokeTCBean(false, "6.孕产妇", false, ""));
        list.add(new StrokeTCBean(false, "7.无以上禁忌症", false, ""));
        return list;
    }
}

    
    
       
    