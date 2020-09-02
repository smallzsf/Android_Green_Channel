package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: mrs评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_MRS_SCORE)
public class StrokeMrsScoreActivity extends BaseActivity {
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.nib_before_disease_mrs_frag_ss)
    NihssItemBar nibBeforeDiseaseMrsFragSs;
    @BindView(R.id.nib_in_hos_mrs_frag_ss)
    NihssItemBar nibInHosMrsFragSs;
    @BindView(R.id.nib_24_mrs_frag_ss)
    NihssItemBar nib24MrsFragSs;
    @BindView(R.id.rg)
    RadioGroup rg;


    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_mrs_scores;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        initNihssBars();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_before_disease_mrs_frag_ss:
                        TextView tv_title_view_nib = nibBeforeDiseaseMrsFragSs.findViewById(R.id.tv_title_view_nib);
                        tv_title_view_nib.setText("发病前mRS评分");
                        //执行具体操作
                   /*     nibBeforeDiseaseMrsFragSs.setVisibility(View.VISIBLE);
                        nibInHosMrsFragSs.setVisibility(View.GONE);
                        nib24MrsFragSs.setVisibility(View.GONE);*/
                        break;

                    case R.id.rb_in_hos_mrs_frag_ss:
                        TextView tv_title_view_nib1 = nibBeforeDiseaseMrsFragSs.findViewById(R.id.tv_title_view_nib);
                        tv_title_view_nib1.setText("入院mRS评分");
                        //执行具体操作
                    /*    nibBeforeDiseaseMrsFragSs.setVisibility(View.GONE);
                        nibInHosMrsFragSs.setVisibility(View.VISIBLE);
                        nib24MrsFragSs.setVisibility(View.GONE);*/
                        break;

                    case R.id.rb_24_mrs_frag_ss:
                        TextView tv_title_view_nib2= nibBeforeDiseaseMrsFragSs.findViewById(R.id.tv_title_view_nib);
                        tv_title_view_nib2.setText("溶栓后24hmRS评分");
                        //执行具体操作
                  /*      nibBeforeDiseaseMrsFragSs.setVisibility(View.GONE);
                        nibInHosMrsFragSs.setVisibility(View.GONE);
                        nib24MrsFragSs.setVisibility(View.VISIBLE);*/
                        break;

                }
            }
        });
    }

    @Override
    public void initListener() {

    }


    /**
     * 初始化评分选项
     */
    private void initNihssBars() {
        // 发病前mRS评分
        List<NihssItemBar.ItemBean> beforeDisMrs = new ArrayList<>();
        beforeDisMrs.add(new NihssItemBar.ItemBean("完全无症状", 0, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("尽管有症状，但未见明显残障；能完成所有经常从事的职责和活动", 1, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("轻度残障；不能完成所有以前从事的活动，但能处理个人事务而不需要帮助", 2, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("中度残障；需要一些协助，但行动不需要协助", 3, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("重度残障；离开他人协助不能行走，以及不能照顾自己的身体需要", 4, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("严重残障；卧床不起、大小便失禁、须持续护理和照顾", 5, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("死亡", 6, false));
        nibBeforeDiseaseMrsFragSs.setItemBeans(beforeDisMrs);
        // 入院mRS评分
        //List<NihssItemBar.ItemBean> inHosMrs = new ArrayList<>(beforeDisMrs);
        nibInHosMrsFragSs.setItemBeans(beforeDisMrs);
        // 溶栓后24hmRS评分
    //    List<NihssItemBar.ItemBean> after24Mrs = new ArrayList<>(beforeDisMrs);
        nib24MrsFragSs.setItemBeans(beforeDisMrs);

    }


}
