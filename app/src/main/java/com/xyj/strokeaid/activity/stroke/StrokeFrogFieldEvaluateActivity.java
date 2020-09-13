package com.xyj.strokeaid.activity.stroke;
;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ChangePasswordPostBean;
import com.xyj.strokeaid.bean.RequestFieldEvaluaScoreBeanData;
import com.xyj.strokeaid.bean.SendAddStrokeSwallowBean;
import com.xyj.strokeaid.bean.SendFieldEvaluateScoreBean;
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
 * @Description: 洼田吞咽评定
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */

@Route(path = RouteUrl.Stroke.STROKE_FROG_FIELD_EVALUATE)
public class StrokeFrogFieldEvaluateActivity extends BaseActivity {
    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActStrokeMain;


    @BindView(R.id.nib_wada_swallowing_frag_ss)
    NihssItemBar nibWadaSwallowingFragSs;

    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_frog_field_scores;
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
                    SendAddStrokeSwallowBean sendAddStrokeSwallowBean = new SendAddStrokeSwallowBean();
                    sendAddStrokeSwallowBean.setEat(nibWadaSwallowingFragSs.getScore());
                    sendAddStrokeSwallowBean.setScore(nibWadaSwallowingFragSs.getScore());
                    addStrokeSwallow(sendAddStrokeSwallowBean);
                });

    }

    @Override
    public void initListener() {

    }

    /**
     * 初始化评分选项
     */
    private void initNihssBars() {

        // 洼田吞咽评定
        List<NihssItemBar.ItemBean> wada = new ArrayList<>();
        wada.add(new NihssItemBar.ItemBean("1级：任何条件下均有吞咽困难和不能吞咽", 1, "1级", false));
        wada.add(new NihssItemBar.ItemBean("2级：3个条件均具备则误吸减少", 2, "2级", false));
        wada.add(new NihssItemBar.ItemBean("3级：具备2个条件则误吸减少", 3, "3级", false));
        wada.add(new NihssItemBar.ItemBean("4级：若选择适当食物，则基本上无误吸", 4, "4级", false));
        wada.add(new NihssItemBar.ItemBean("5级：若注意进食方法和时间基本上无误吸", 5, "5级", false));
        wada.add(new NihssItemBar.ItemBean("6级：吞咽正常", 6, "6级", false));
        nibWadaSwallowingFragSs.setItemBeans(wada);

    }

    /**
     * 洼田吞咽评定
     */
    private void addStrokeSwallow(SendAddStrokeSwallowBean sendAddStrokeMrsBean) {
        String request = GsonUtils.getGson().toJson(sendAddStrokeMrsBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .addSwallow(requestBody)
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




//    /**
//     * 保存数据
//     *
//     * @param sendFieldEvaluateScoreBean 数据
//     */
//    private void addFieldEvaluateScore(SendFieldEvaluateScoreBean sendFieldEvaluateScoreBean) {
//        String request = GsonUtils.getGson().toJson(sendFieldEvaluateScoreBean);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
//        RetrofitClient
//                .getInstance()
//                .getApi()
//                .addFieldEvaluateScore(requestBody)
//                .enqueue(new Callback<RequestFieldEvaluaScoreBeanData>() {
//                    @Override
//                    public void onResponse(Call<RequestFieldEvaluaScoreBeanData> call, Response<RequestFieldEvaluaScoreBeanData> response) {
//                        if (response.body() != null) {
//                            if (response.body().getResult() == 1) {
//                                showToast("修改成功");
//                            } else {
//                                showToast(response.body().getMessage());
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<RequestFieldEvaluaScoreBeanData> call, Throwable t) {
//
//                    }
//                });
//    }

}
