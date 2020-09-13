package com.xyj.strokeaid.activity.score;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Description: Spetzler-Marin评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */

@Route(path = RouteUrl.Stroke.STROKE_HUNT_HESS_SCORE)
public class StrokeHuntHessActivity extends BaseActivity {

    @BindView(R.id.nib_live_hunt_hess_frag_ss)
    NihssItemBar nibLiveHuntHessFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_hunt_hess_scores;
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
        // 住院Hunt-Hess评分
        List<NihssItemBar.ItemBean> huntHess = new ArrayList<>();
        huntHess.add(new NihssItemBar.ItemBean("未破裂动脉瘤", 0, "0级", false));
        huntHess.add(new NihssItemBar.ItemBean("无症状或轻微头痛", 1, "Ⅰ级", false));
        huntHess.add(new NihssItemBar.ItemBean("中一重度头痛，脑膜刺激征，颅神经麻痹", 2, "Ⅱ级", false));
        huntHess.add(new NihssItemBar.ItemBean("嗜睡，意识浑浊，轻度局灶神经体征", 3, "Ⅲ级", false));
        huntHess.add(new NihssItemBar.ItemBean("昏迷，中或重度偏瘫，有早起去脑强直或自主神经功能紊乱", 4, "Ⅳ级", false));
        huntHess.add(new NihssItemBar.ItemBean("深昏迷，去大脑强直，濒死状态", 5, "Ⅴ级", false));
        nibLiveHuntHessFragSs.setItemBeans(huntHess);

    }

}
