package com.xyj.strokeaid.activity.score;

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
 * @Description: Fisherc分级
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_FiISHEER_SCORE)
public class StrokeFishercCassificationActivity extends BaseActivity {

    @BindView(R.id.nib_in_hos_fisher_frag_ss)
    NihssItemBar nibInHosFisherFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_fisherc_scores;
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


        // 入院Fisher分级
        List<NihssItemBar.ItemBean> fisher = new ArrayList<>();
        fisher.add(new NihssItemBar.ItemBean("0级：未见出血或仅脑室内出血或实质内出血（3%）", 0, "0级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅰ级：仅见基底池出血（14%）", 1, "Ⅰ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅱ级：仅见周边脑池或侧裂池出血（38%）", 2, "Ⅱ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅲ级：广泛蛛网膜下腔出血伴脑实质内血肿（57%）", 3, "Ⅲ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅳ级：基底池和周边脑池、侧裂池较厚积血（57%）", 4, "Ⅳ级", false));
        nibInHosFisherFragSs.setItemBeans(fisher);

    }


}
