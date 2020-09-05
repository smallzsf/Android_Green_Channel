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
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RequestBloodDataBean;
import com.xyj.strokeaid.bean.SendAddStrokeCgsBean;
import com.xyj.strokeaid.bean.SendAddStrokeMrsBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: Gcs评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_GCS_SCORE)
public class StrokeGcsScoreActivity extends BaseActivity {
    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActStrokeMain;
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
    @BindView(R.id.nib_sm_volume_frag_ss)
    NihssItemBar nibSmVolumeFragSs;
    @BindView(R.id.nib_sm_position_frag_ss)
    NihssItemBar nibSmPositionFragSs;
    @BindView(R.id.nib_sm_deep_frag_ss)
    NihssItemBar nibSmDeepFragSs;
    @BindView(R.id.ll_sm_contain_frag_ss)
    LinearLayout llSmContainFragSs;

    @BindView(R.id.ll_ih_title_frag_ss)
    LinearLayout llIhTitleFragSs;


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
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    SendAddStrokeCgsBean sendAddStrokeMrsBean = new SendAddStrokeCgsBean();
                    int nGcsEye = nibIhGcsEyeFragSs.getScore();
                    int nGcsSpeak = nibIhGcsSpeakFragSs.getScore();
                    int nGcsSport = nibIhGcsSportFragSs.getScore();
                    sendAddStrokeMrsBean.setGcsEye(nGcsEye + "");
                    sendAddStrokeMrsBean.setGcsSpeech(nGcsEye + "");
                    sendAddStrokeMrsBean.setGcsSport(nGcsSport + "");
                    sendAddStrokeMrsBean.setScore(nGcsEye + nGcsSpeak + nGcsSport);
                    addStrokeMrs(sendAddStrokeMrsBean);
                });
    }

    @Override
    public void initListener() {

    }


    @OnClick({R.id.iv_ih_arrow_frag_ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_ih_arrow_frag_ss:
                parseHasSubItemScores(llIhContainFragSs, ivIhArrowFragSs);
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
        linearLayout.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.drawable.ic_arrow_up_blue);
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

    }

    /**
     * 上传CGS评分
     */
    private void addStrokeMrs(SendAddStrokeCgsBean sendAddStrokeCgsBean) {
        String request = GsonUtils.getGson().toJson(sendAddStrokeCgsBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .addCgs(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }

}
