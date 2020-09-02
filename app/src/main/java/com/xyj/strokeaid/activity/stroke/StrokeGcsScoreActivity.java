package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

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
 * @Description: Gcs评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_GCS_SCORE)
public class StrokeGcsScoreActivity extends BaseActivity {


    @BindView(R.id.tv_ih_title_frag_ss)
    TextView tvIhTitleFragSs;
    @BindView(R.id.tv_ih_score_title_frag_ss)
    TextView tvIhScoreTitleFragSs;
    @BindView(R.id.iv_ih_arrow_frag_ss)
    ImageView ivIhArrowFragSs;
    @BindView(R.id.nib_ih_gcs_eye_frag_ss)
    NihssItemBar nibIhGcsEyeFragSs;
    @BindView(R.id.nib_ih_gcs_speak_frag_ss)
    NihssItemBar nibIhGcsSpeakFragSs;
    @BindView(R.id.nib_ih_gcs_sport_frag_ss)
    NihssItemBar nibIhGcsSportFragSs;
    @BindView(R.id.ll_ih_contain_frag_ss)
    LinearLayout llIhContainFragSs;
    @BindView(R.id.tv_lh_title_frag_ss)
    TextView tvLhTitleFragSs;
    @BindView(R.id.tv_lh_score_title_frag_ss)
    TextView tvLhScoreTitleFragSs;
    @BindView(R.id.iv_lh_arrow_frag_ss)
    ImageView ivLhArrowFragSs;
    @BindView(R.id.nib_lh_gcs_eye_frag_ss)
    NihssItemBar nibLhGcsEyeFragSs;
    @BindView(R.id.nib_lh_gcs_speak_frag_ss)
    NihssItemBar nibLhGcsSpeakFragSs;
    @BindView(R.id.nib_lh_gcs_sport_frag_ss)
    NihssItemBar nibLhGcsSportFragSs;
    @BindView(R.id.ll_lh_contain_frag_ss)
    LinearLayout llLhContainFragSs;
    @BindView(R.id.nib_sm_volume_frag_ss)
    NihssItemBar nibSmVolumeFragSs;
    @BindView(R.id.nib_sm_position_frag_ss)
    NihssItemBar nibSmPositionFragSs;
    @BindView(R.id.nib_sm_deep_frag_ss)
    NihssItemBar nibSmDeepFragSs;
    @BindView(R.id.ll_sm_contain_frag_ss)
    LinearLayout llSmContainFragSs;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.ll_ih_title_frag_ss)
    LinearLayout llIhTitleFragSs;
    @BindView(R.id.ll_lh_title_frag_ss)
    LinearLayout llLhTitleFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_gcs_scores;
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
                    case R.id.rb_ih_title_frag_ss:
                        //执行具体操作
                        llIhTitleFragSs.setVisibility(View.VISIBLE);
                        llLhTitleFragSs.setVisibility(View.GONE);
                        break;

                    case R.id.rb_lh_title_frag_ss:
                        //执行具体操作
                        llIhTitleFragSs.setVisibility(View.GONE);
                        llLhTitleFragSs.setVisibility(View.VISIBLE);
                        break;


                }
            }
        });
    }

    @Override
    public void initListener() {

    }


    @OnClick({R.id.iv_ih_arrow_frag_ss, R.id.iv_lh_arrow_frag_ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_ih_arrow_frag_ss:
                parseHasSubItemScores(llIhContainFragSs, ivIhArrowFragSs);
                break;
            case R.id.iv_lh_arrow_frag_ss:
                parseHasSubItemScores(llLhContainFragSs, ivLhArrowFragSs);
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

        // 入院GCS评分  睁眼反应
        List<NihssItemBar.ItemBean> inHosGcsEye = new ArrayList<>();
        inHosGcsEye.add(new NihssItemBar.ItemBean("不能睁眼", 1, false));
        inHosGcsEye.add(new NihssItemBar.ItemBean("刺痛能睁眼", 2, false));
        inHosGcsEye.add(new NihssItemBar.ItemBean("语言命令睁眼", 3, false));
        inHosGcsEye.add(new NihssItemBar.ItemBean("自然睁眼", 4, false));
        nibIhGcsEyeFragSs.setItemBeans(inHosGcsEye);
        // 入院GCS评分  语言反应
        List<NihssItemBar.ItemBean> inHosGcsSpeak = new ArrayList<>();
        inHosGcsSpeak.add(new NihssItemBar.ItemBean("无语言反应", 1, false));
        inHosGcsSpeak.add(new NihssItemBar.ItemBean("有音无语", 2, false));
        inHosGcsSpeak.add(new NihssItemBar.ItemBean("言语错乱", 3, false));
        inHosGcsSpeak.add(new NihssItemBar.ItemBean("语言含糊/不当", 4, false));
        inHosGcsSpeak.add(new NihssItemBar.ItemBean("定向力好", 5, false));
        nibIhGcsSpeakFragSs.setItemBeans(inHosGcsSpeak);
        // 入院GCS评分  运动反应
        List<NihssItemBar.ItemBean> inHosGcsSport = new ArrayList<>();
        inHosGcsSport.add(new NihssItemBar.ItemBean("无运动反应", 1, false));
        inHosGcsSport.add(new NihssItemBar.ItemBean("疼痛刺激伸直", 2, false));
        inHosGcsSport.add(new NihssItemBar.ItemBean("疼痛刺激屈曲", 3, false));
        inHosGcsSport.add(new NihssItemBar.ItemBean("逃避疼痛", 4, false));
        inHosGcsSport.add(new NihssItemBar.ItemBean("疼痛定位", 5, false));
        inHosGcsSport.add(new NihssItemBar.ItemBean("遵嘱运动", 6, false));
        nibIhGcsSportFragSs.setItemBeans(inHosGcsSport);

        // 住院GCS评分  睁眼反应
        List<NihssItemBar.ItemBean> lnHosGcsEye = new ArrayList<>(inHosGcsEye);
        nibLhGcsEyeFragSs.setItemBeans(lnHosGcsEye);
        // 住院GCS评分  语言反应
        List<NihssItemBar.ItemBean> lnHosGcsSpeak = new ArrayList<>(inHosGcsSpeak);
        nibLhGcsSpeakFragSs.setItemBeans(lnHosGcsSpeak);
        // 住院GCS评分  运动反应
        List<NihssItemBar.ItemBean> lnHosGcsSport = new ArrayList<>(inHosGcsSport);
        nibLhGcsSportFragSs.setItemBeans(lnHosGcsSport);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
