package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ToolfastedBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: FAST-ED评分
 * @Author: crq
 * @CreateDate: 2020/8/24 9:59
 */
@Route(path = RouteUrl.Stroke.STROKE_FAST_ED__SCORE)
public class FastEdActivity extends BaseActivity implements NihssItemBar.OnScoreChangedListener {
    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActNihss;
    @BindView(R.id.ll_score_act_nihss)
    LinearLayout llScoreActNihss;
    @BindView(R.id.nib_1a_act_nihss)
    NihssItemBar nib1aActNihss;
    @BindView(R.id.nib_1b_act_nihss)
    NihssItemBar nib1bActNihss;
    @BindView(R.id.nib_1c_act_nihss)
    NihssItemBar nib1cActNihss;
    @BindView(R.id.nib_2_act_nihss)
    NihssItemBar nib2ActNihss;
    @BindView(R.id.nib_3_act_nihss)
    NihssItemBar nib3ActNihss;

    @Autowired(name = IntentKey.NIHSS_TYPE)
    int mNihssType;
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;
    @BindView(R.id.tv_result_score)
    TextView tvResultScore;
    /**
     * 总分
     */
    private int mTotalScore = 0;

    /**
     * Fast分数实体类
     */
    private ToolfastedBean toolfastedBean;


    @Override
    public int getLayoutId() {
        return R.layout.activity_fast_ed;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        initTitle();
        initNihssBars();
        //显示隐藏
        ArrayList<NihssItemBar> nihssItemBars = new ArrayList<>();
        nihssItemBars.add(nib1aActNihss);
        nihssItemBars.add(nib1bActNihss);
        nihssItemBars.add(nib1cActNihss);
        nihssItemBars.add(nib2ActNihss);
        nihssItemBars.add(nib3ActNihss);
        initVisibleGone(nihssItemBars);
    }

    @Override
    public void initListener() {
        //上传分数
        titleBarActNihss.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    if (toolfastedBean == null)
                        toolfastedBean = new ToolfastedBean();
                    if (-2 != nib1aActNihss.getScore() &&
                            -2 != nib1bActNihss.getScore() &&
                            -2 != nib1cActNihss.getScore() &&
                            -2 != nib2ActNihss.getScore() &&
                            -2 != nib3ActNihss.getScore()) {
                        toolfastedBean.setFastFacialparalysis(nib1aActNihss.getScore());
                        toolfastedBean.setFastWeakness(nib1bActNihss.getScore());
                        toolfastedBean.setFastLanguagebarrier(nib1cActNihss.getScore());
                        toolfastedBean.setFastEyeballgaze(nib2ActNihss.getScore());
                        toolfastedBean.setFastAgnosia(nib3ActNihss.getScore());
                        Log.e("==>toolfastedPo", toolfastedBean.toString());
                        saveChestPainDiagnosis(toolfastedBean);
                    } else {
                        showToast("存在未选择选项，请检查！");
                    }
                });
    }

    /**
     * FAST-ED 评分保存
     */
    public void saveChestPainDiagnosis(ToolfastedBean toolfastedBean) {
        showLoadingDialog();
        String request = GsonUtils.getGson().toJson(toolfastedBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .getFastEdScoreSave(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("评分提交成功！");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());
                    }
                });
    }

    private void initVisibleGone(ArrayList<NihssItemBar> nihssItemBars) {
        for (int i = 0; i < nihssItemBars.size(); i++) {
            nihssItemBars.get(i).findViewById(R.id.rv_scores_view_nib).setVisibility(View.GONE);
            nihssItemBars.get(i).findViewById(R.id.rv_content_view_nib).setVisibility(View.VISIBLE);
        }
    }

    private void initTitle() {
        //FAST-ED评分
        titleBarActNihss.setTitle("FAST-ED评分");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化评分选项
     */
    private void initNihssBars() {
        List<NihssItemBar.ItemBean> oneA = new ArrayList<>();
        oneA.add(new NihssItemBar.ItemBean("0=正常或轻微面瘫", -1, false));
        oneA.add(new NihssItemBar.ItemBean("1=部分或完全面瘫", 1, false));
        nib1aActNihss.setItemBeans(oneA);
        nib1aActNihss.setOnScoreChangedListener(this);


        List<NihssItemBar.ItemBean> oneB = new ArrayList<>();
        oneB.add(new NihssItemBar.ItemBean("0=无瘫痪", -1, false));
        oneB.add(new NihssItemBar.ItemBean("1=有瘫痪/抗部分重力", 1, false));
        oneB.add(new NihssItemBar.ItemBean("2=不能抗重力/无活动", 2, false));
        nib1bActNihss.setItemBeans(oneB);
        nib1bActNihss.setOnScoreChangedListener(this);

        List<NihssItemBar.ItemBean> oneC = new ArrayList<>();
        oneC.add(new NihssItemBar.ItemBean("0=无语言障碍", -1, false));
        oneC.add(new NihssItemBar.ItemBean("1=轻-中度", 1, false));
        oneC.add(new NihssItemBar.ItemBean("2=严重，全面失语，缄默", 2, false));
        nib1cActNihss.setItemBeans(oneC);
        nib1cActNihss.setOnScoreChangedListener(this);

        List<NihssItemBar.ItemBean> two = new ArrayList<>();
        two.add(new NihssItemBar.ItemBean("0=无", -1, false));
        two.add(new NihssItemBar.ItemBean("1=部分", 1, false));
        two.add(new NihssItemBar.ItemBean("2=强迫凝视", 2, false));
        nib2ActNihss.setItemBeans(two);
        nib2ActNihss.setOnScoreChangedListener(this);

        List<NihssItemBar.ItemBean> three = new ArrayList<>();
        three.add(new NihssItemBar.ItemBean("0=无", -1, false));
        three.add(new NihssItemBar.ItemBean("1=不能感知双侧同时的1种感觉刺激", 1, false));
        three.add(new NihssItemBar.ItemBean("2=不能识别自己的手或仅能感知一侧肢体", 2, false));
        nib3ActNihss.setItemBeans(three);
        nib3ActNihss.setOnScoreChangedListener(this);
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
