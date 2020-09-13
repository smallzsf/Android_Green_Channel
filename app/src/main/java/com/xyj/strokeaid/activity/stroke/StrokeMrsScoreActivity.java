package com.xyj.strokeaid.activity.stroke;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.SendAddStrokeMrsBean;
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
 * @Description: mrs评分
 * @Author: crq
 * @CreateDate: 2020/9/2 14:41
 */
@Route(path = RouteUrl.Stroke.STROKE_MRS_SCORE)
public class StrokeMrsScoreActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_nihss)
    BaseTitleBar titleBarActStrokeMain;

    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.nib_before_disease_mrs_frag_ss)
    NihssItemBar nibBeforeDiseaseMrsFragSs;


    @Override
    public int getLayoutId() {
        return R.layout.activity_stroke_mrs_scores;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    SendAddStrokeMrsBean sendAddStrokeMrsBean = new SendAddStrokeMrsBean();
                    sendAddStrokeMrsBean.setMrs(nibBeforeDiseaseMrsFragSs.getScore());
                    sendAddStrokeMrsBean.setScore(nibBeforeDiseaseMrsFragSs.getScore());
                    if (-2 != nibBeforeDiseaseMrsFragSs.getScore()) {
                        addStrokeMrs(sendAddStrokeMrsBean);
                    } else {
                        showToast("存在未选择选项，请检查！");
                    }
                });
        initNihssBars();
    }

    @Override
    public void initListener() {

    }


    /**
     * 初始化评分选项
     */
    private void initNihssBars() {
        // 发病前mRS评分
        List<NihssItemBar.ItemBean> beforeDisMrs = new ArrayList<>();
        beforeDisMrs.add(new NihssItemBar.ItemBean("完全无症状", 0, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("尽管有症状，但未见明显残障；能完成所有经常从事的职责和活动", 1, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("轻度残障；不能完成所有以前从事的活动，但能处理个人事务而不需要帮助", 2, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("中度残障；需要一些协助，但行动不需要协助", 3, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("重度残障；离开他人协助不能行走，以及不能照顾自己的身体需要", 4, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("严重残障；卧床不起、大小便失禁、须持续护理和照顾", 5, false));
        beforeDisMrs.add(new NihssItemBar.ItemBean("死亡", 6, false));
        nibBeforeDiseaseMrsFragSs.setItemBeans(beforeDisMrs);
    }

    /**
     * 上传MRS评分
     */
    private void addStrokeMrs(SendAddStrokeMrsBean sendAddStrokeMrsBean) {
        String request = GsonUtils.getGson().toJson(sendAddStrokeMrsBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .addMrs(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
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

                    }
                });
    }
}
