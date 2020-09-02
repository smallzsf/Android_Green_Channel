package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: Spetzler-Marin评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_CHADS2_SCORE)
public class StrokeChadsActivity extends BaseActivity {

    @BindView(R.id.nib_live_chads2_frag_ss)
    NihssItemBar nibLiveChads2FragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_chads2_scores;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        initNihssBars();
    }

    @Override
    public void initListener() {

    }



    /**
     * 初始化评分选项
     */
    private void initNihssBars() {

        // 住院CHADS2评分
        List<NihssItemBar.ItemBean> chads = new ArrayList<>();
        chads.add(new NihssItemBar.ItemBean("既往充血性心力衰竭（CHF）病史", 1, false));
        chads.add(new NihssItemBar.ItemBean("高血压", 1, false));
        chads.add(new NihssItemBar.ItemBean("年龄≥75岁", 1, false));
        chads.add(new NihssItemBar.ItemBean("糖尿病", 1, false));
        chads.add(new NihssItemBar.ItemBean("TIA或卒中病史", 2, false));
        nibLiveChads2FragSs.setMultipleItemBeans(chads);

    }

}
