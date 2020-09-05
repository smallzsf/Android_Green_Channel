package com.xyj.strokeaid.activity.score;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TSActivity extends BaseActivity implements NihssItemBar.OnScoreChangedListener {

    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActNihss;
    @BindView(R.id.tv_result_score)
    TextView tvResultScore;
    @BindView(R.id.ll_score_act_nihss)
    LinearLayout llScoreActNihss;
    @BindView(R.id.nib_1)
    NihssItemBar nib1;
    @BindView(R.id.nib_2)
    NihssItemBar nib2;
    @BindView(R.id.nib_3)
    NihssItemBar nib3;
    @BindView(R.id.nib_4)
    NihssItemBar nib4;
    @BindView(R.id.nib_5)
    NihssItemBar nib5;
    /**
     * 总分
     */
    private int mTotalScore = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_score_ts;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        titleBarActNihss.setTitle("TS评分");
        tvResultScore.setText("评分结果：0分");
        initNihssBars();
        ArrayList<NihssItemBar> nihssItemBars = new ArrayList<>();
        nihssItemBars.add(nib1);
        nihssItemBars.add(nib2);
        nihssItemBars.add(nib3);
        nihssItemBars.add(nib4);
        nihssItemBars.add(nib5);
        initVisibleGone(nihssItemBars);
    }

    private void initVisibleGone(ArrayList<NihssItemBar> nihssItemBars) {
        for (int i = 0; i < nihssItemBars.size(); i++) {
            nihssItemBars.get(i).findViewById(R.id.rv_scores_view_nib).setVisibility(View.GONE);
            nihssItemBars.get(i).findViewById(R.id.rv_content_view_nib).setVisibility(View.VISIBLE);
        }
    }

    private void initNihssBars() {
        List<NihssItemBar.ItemBean> oneA = new ArrayList<>();
        oneA.add(new NihssItemBar.ItemBean("正常", 1, false));
        oneA.add(new NihssItemBar.ItemBean("浅、困难", 0, false));
        nib1.setItemBeans(oneA);
        nib1.setOnScoreChangedListener(this);
        List<NihssItemBar.ItemBean> oneB = new ArrayList<>();
        oneB.add(new NihssItemBar.ItemBean("正常（＞2′）", 2, false));
        oneB.add(new NihssItemBar.ItemBean("迟缓（＜2′）", 1, false));
        oneB.add(new NihssItemBar.ItemBean("无", 0, false));
        nib2.setItemBeans(oneB);
        nib2.setOnScoreChangedListener(this);
        List<NihssItemBar.ItemBean> oneC = new ArrayList<>();
        oneC.add(new NihssItemBar.ItemBean("＞35", 2, false));
        oneC.add(new NihssItemBar.ItemBean("25~35", 3, false));
        oneC.add(new NihssItemBar.ItemBean("10~24", 4, false));
        oneC.add(new NihssItemBar.ItemBean("1~9", 1, false));
        oneC.add(new NihssItemBar.ItemBean("无", 0, false));
        nib3.setItemBeans(oneC);
        nib3.setOnScoreChangedListener(this);
        List<NihssItemBar.ItemBean> oneD = new ArrayList<>();
        oneD.add(new NihssItemBar.ItemBean("≥90", 4, false));
        oneD.add(new NihssItemBar.ItemBean("70~89", 3, false));
        oneD.add(new NihssItemBar.ItemBean("50~69", 2, false));
        oneD.add(new NihssItemBar.ItemBean("＜50", 1, false));
        oneD.add(new NihssItemBar.ItemBean("0", 0, false));
        nib4.setItemBeans(oneD);
        nib4.setOnScoreChangedListener(this);
        List<NihssItemBar.ItemBean> oneE = new ArrayList<>();
        oneE.add(new NihssItemBar.ItemBean("14~15", 5, false));
        oneE.add(new NihssItemBar.ItemBean("11~13", 4, false));
        oneE.add(new NihssItemBar.ItemBean("8~10", 3, false));
        oneE.add(new NihssItemBar.ItemBean("5~7", 2, false));
        oneE.add(new NihssItemBar.ItemBean("3~4", 1, false));
        nib5.setItemBeans(oneE);
        nib5.setOnScoreChangedListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void addScore(int newScore, int oldScore) {
        mTotalScore = mTotalScore - oldScore + newScore;
        tvResultScore.setText("评分结果：" + mTotalScore + "分");
    }

    @Override
    public void subScore(int score) {
        mTotalScore = mTotalScore - score;
        tvResultScore.setText("评分结果：" + mTotalScore + "分");
    }
}
