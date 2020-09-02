package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

@Route(path = RouteUrl.Stroke.STROKE_SPETZLER_MARINSCORE)
public class StrokeSpetzlerMarinActivity extends BaseActivity {

    @BindView(R.id.tv_sm_title_frag_ss)
    TextView tvSmTitleFragSs;
    @BindView(R.id.tv_sm_score_title_frag_ss)
    TextView tvSmScoreTitleFragSs;
    @BindView(R.id.iv_sm_arrow_frag_ss)
    ImageView ivSmArrowFragSs;
    @BindView(R.id.nib_sm_volume_frag_ss)
    NihssItemBar nibSmVolumeFragSs;
    @BindView(R.id.nib_sm_position_frag_ss)
    NihssItemBar nibSmPositionFragSs;
    @BindView(R.id.nib_sm_deep_frag_ss)
    NihssItemBar nibSmDeepFragSs;
    @BindView(R.id.ll_sm_contain_frag_ss)
    LinearLayout llSmContainFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_spetzler_marin_scores;
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


    @OnClick({R.id.iv_sm_arrow_frag_ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
             case R.id.iv_sm_arrow_frag_ss:
                parseHasSubItemScores(llSmContainFragSs, ivSmArrowFragSs);
                break;
            default:
                break;
        }
    }

    /**
     * 处理含有子项目的评分项
     *
     * @param linearLayout
     * @param imageView
     */
    private void parseHasSubItemScores(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView) {
        if (linearLayout.getVisibility() == View.VISIBLE) {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.ic_arrow_down_blue);
        } else {
            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.ic_arrow_up_blue);
        }
    }


    /**
     * 初始化评分选项
     */
    private void initNihssBars() {

        // Spetzler-Marin评分   体积
        List<NihssItemBar.ItemBean> SpetzlerMarinVolume = new ArrayList<>();
        SpetzlerMarinVolume.add(new NihssItemBar.ItemBean("0-3.0cm", 1, false));
        SpetzlerMarinVolume.add(new NihssItemBar.ItemBean("3.1-6.0cm", 2, false));
        SpetzlerMarinVolume.add(new NihssItemBar.ItemBean("＞6.0cm", 3, false));
        nibSmVolumeFragSs.setItemBeans(SpetzlerMarinVolume);
        // Spetzler-Marin评分   位置
        List<NihssItemBar.ItemBean> SpetzlerMarinPosition = new ArrayList<>();
        SpetzlerMarinPosition.add(new NihssItemBar.ItemBean("非语言区", 0, false));
        SpetzlerMarinPosition.add(new NihssItemBar.ItemBean("语言区", 1, false));
        nibSmPositionFragSs.setItemBeans(SpetzlerMarinPosition);
        // Spetzler-Marin评分   深静脉引流
        List<NihssItemBar.ItemBean> SpetzlerMarinDeep = new ArrayList<>();
        SpetzlerMarinDeep.add(new NihssItemBar.ItemBean("无", 0, false));
        SpetzlerMarinDeep.add(new NihssItemBar.ItemBean("有", 1, false));
        nibSmDeepFragSs.setItemBeans(SpetzlerMarinDeep);
    }


}
