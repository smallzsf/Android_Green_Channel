package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
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

/**
 * @Description: HAS-BLED评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_HAS_BLED_SCORE)
public class StrokeHasBledScoreActivity extends BaseActivity {


    @BindView(R.id.nib_has_bled_frag_ss)
    NihssItemBar nibHasBledFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_has_bled_scores;
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


        // HAS-BLED评分
        List<NihssItemBar.ItemBean> hasBled = new ArrayList<>();
        hasBled.add(new NihssItemBar.ItemBean("高血压", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("肾功能异常", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("肝功能异常", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("先前有过卒中", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("有出血史或出血倾向", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("有过INR值不稳定历史", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("老年 年龄≥65岁", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("合用阿司匹林或NSAIDs药物", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("酗酒", 1, false));
        nibHasBledFragSs.setMultipleItemBeans(hasBled);

    }



}
