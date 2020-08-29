package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
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
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * StrokeThriveActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/24
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THRIVE_SCORE)
public class StrokeThriveActivity extends BaseActivity {
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
 /*   @BindView(R.id.nib_4_act_nihss)
    NihssItemBar nib4ActNihss;
    @BindView(R.id.nib_5a_act_nihss)
    NihssItemBar nib5aActNihss;
    @BindView(R.id.nib_5b_act_nihss)
    NihssItemBar nib5bActNihss;
    @BindView(R.id.nib_6a_act_nihss)
    NihssItemBar nib6aActNihss;
    @BindView(R.id.nib_6b_act_nihss)
    NihssItemBar nib6bActNihss;
    @BindView(R.id.nib_7_act_nihss)
    NihssItemBar nib7ActNihss;
    @BindView(R.id.nib_8_act_nihss)
    NihssItemBar nib8ActNihss;
    @BindView(R.id.nib_9_act_nihss)
    NihssItemBar nib9ActNihss;
    @BindView(R.id.nib_10_act_nihss)
    NihssItemBar nib10ActNihss;
    @BindView(R.id.nib_11_act_nihss)
    NihssItemBar nib11ActNihss;*/

    @Autowired(name = IntentKey.NIHSS_TYPE)
    int mNihssType;
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;
    @BindView(R.id.tv_result_score)
    TextView tvResultScore;


    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrive;
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

   /*     nihssItemBars.add(nib4ActNihss);
        nihssItemBars.add(nib5aActNihss);
        nihssItemBars.add(nib5bActNihss);
        nihssItemBars.add(nib6aActNihss);
        nihssItemBars.add(nib6bActNihss);
        nihssItemBars.add(nib7ActNihss);
        nihssItemBars.add(nib8ActNihss);
        nihssItemBars.add(nib9ActNihss);
        nihssItemBars.add(nib10ActNihss);
        nihssItemBars.add(nib11ActNihss);*/
        // initVisibleGone(nihssItemBars);
    }

    @Override
    public void initListener() {
        titleBarActNihss.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    int scores = getAllScores();
                });


    }

    private void initVisibleGone(ArrayList<NihssItemBar> nihssItemBars) {
        for (int i = 0; i < nihssItemBars.size(); i++) {
            nihssItemBars.get(i).findViewById(R.id.rv_scores_view_nib).setVisibility(View.GONE);
            nihssItemBars.get(i).findViewById(R.id.rv_content_view_nib).setVisibility(View.VISIBLE);
        }

    }


    private void initTitle() {
        if (mNihssType == 1) {
            // 首次NIHSS评分
            titleBarActNihss.setTitle("首次NIHSS评分");
        } else if (mNihssType == 2) {
            // 溶栓前NIHSS评分
            titleBarActNihss.setTitle("溶栓前NIHSS评分");
        } else if (mNihssType == 3) {
            // 溶栓后即刻NIHSS评分
            titleBarActNihss.setTitle("溶栓后即刻NIHSS评分");
        } else {
            // NIHSS评分
            titleBarActNihss.setTitle("THRIVE评分");
        }
    }


    private int getAllScores() {
        return 0;
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
        oneA.add(new NihssItemBar.ItemBean("≥80岁", 2, false));
        oneA.add(new NihssItemBar.ItemBean("60-80岁", 1, false));
        oneA.add(new NihssItemBar.ItemBean("＜60岁", 0, false));
        nib1aActNihss.setItemBeans(oneA);

        List<NihssItemBar.ItemBean> oneB = new ArrayList<>();
        oneB.add(new NihssItemBar.ItemBean("≥21分", 4, false));
        oneB.add(new NihssItemBar.ItemBean("11-20分", 2, false));
        oneB.add(new NihssItemBar.ItemBean("＜11分", 0, false));
        nib1bActNihss.setItemBeans(oneB);

        List<NihssItemBar.ItemBean> oneC = new ArrayList<>();
        oneC.add(new NihssItemBar.ItemBean("有", 1, false));
        oneC.add(new NihssItemBar.ItemBean("无", 0, false));
        nib1cActNihss.setItemBeans(oneC);

        List<NihssItemBar.ItemBean> two = new ArrayList<>();
        two.add(new NihssItemBar.ItemBean("有", 1, false));
        two.add(new NihssItemBar.ItemBean("无", 0, false));
        nib2ActNihss.setItemBeans(two);

        List<NihssItemBar.ItemBean> three = new ArrayList<>();
        three.add(new NihssItemBar.ItemBean("有", 1, false));
        three.add(new NihssItemBar.ItemBean("无", 0, false));
        nib3ActNihss.setItemBeans(three);

    /*    List<NihssItemBar.ItemBean> four = new ArrayList<>();
        four.add(new NihssItemBar.ItemBean("正常", 0, false));
        four.add(new NihssItemBar.ItemBean("轻微（微笑时鼻唇沟变平、不对称）", 1, false));
        four.add(new NihssItemBar.ItemBean("部分（下面部完全或几乎完全瘫痪）", 2, false));
        four.add(new NihssItemBar.ItemBean("完全（单或双侧瘫痪，上下面部缺乏运动）", 3, false));
        nib4ActNihss.setItemBeans(four);

        List<NihssItemBar.ItemBean> fiveA = new ArrayList<>();
        fiveA.add(new NihssItemBar.ItemBean("上肢于要求位置坚持10秒，无下落", 0, false));
        fiveA.add(new NihssItemBar.ItemBean("上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物", 1, false));
        fiveA.add(new NihssItemBar.ItemBean("能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上", 2, false));
        fiveA.add(new NihssItemBar.ItemBean("不能抗重力，上肢快速下落", 3, false));
        fiveA.add(new NihssItemBar.ItemBean("无运动", 4, false));
        fiveA.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib5aActNihss.setItemBeans(fiveA);

        List<NihssItemBar.ItemBean> fiveB = new ArrayList<>();
        fiveB.add(new NihssItemBar.ItemBean("上肢于要求位置坚持10秒，无下落", 0, false));
        fiveB.add(new NihssItemBar.ItemBean("上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物", 1, false));
        fiveB.add(new NihssItemBar.ItemBean("能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上", 2, false));
        fiveB.add(new NihssItemBar.ItemBean("不能抗重力，上肢快速下落", 3, false));
        fiveB.add(new NihssItemBar.ItemBean("无运动", 4, false));
        fiveB.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib5bActNihss.setItemBeans(fiveB);

        List<NihssItemBar.ItemBean> sixA = new ArrayList<>();
        sixA.add(new NihssItemBar.ItemBean("下肢于要求位置坚持5秒，无下落", 0, false));
        sixA.add(new NihssItemBar.ItemBean("在5秒末下落，不撞击床", 1, false));
        sixA.add(new NihssItemBar.ItemBean("5秒内较快下落到床上，但可抗重力", 2, false));
        sixA.add(new NihssItemBar.ItemBean("快速下落，不能抗重力", 3, false));
        sixA.add(new NihssItemBar.ItemBean("无运动", 4, false));
        sixA.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib6aActNihss.setItemBeans(sixA);

        List<NihssItemBar.ItemBean> sixB = new ArrayList<>();
        sixB.add(new NihssItemBar.ItemBean("下肢于要求位置坚持5秒，无下落", 0, false));
        sixB.add(new NihssItemBar.ItemBean("在5秒末下落，不撞击床", 1, false));
        sixB.add(new NihssItemBar.ItemBean("5秒内较快下落到床上，但可抗重力", 2, false));
        sixB.add(new NihssItemBar.ItemBean("快速下落，不能抗重力", 3, false));
        sixB.add(new NihssItemBar.ItemBean("无运动", 4, false));
        sixB.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib6bActNihss.setItemBeans(sixB);

        List<NihssItemBar.ItemBean> seven = new ArrayList<>();
        seven.add(new NihssItemBar.ItemBean("无共济失调", 0, false));
        seven.add(new NihssItemBar.ItemBean("一个肢体有", 1, false));
        seven.add(new NihssItemBar.ItemBean("两个肢体有", 2, false));
        seven.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib7ActNihss.setItemBeans(seven);

        List<NihssItemBar.ItemBean> eight = new ArrayList<>();
        eight.add(new NihssItemBar.ItemBean("正常，没有感觉缺失", 0, false));
        eight.add(new NihssItemBar.ItemBean("轻到中度，患侧针刺感不明显或为钝性或仅有触觉", 1, false));
        eight.add(new NihssItemBar.ItemBean("严重到完全感觉缺失，面、上肢、下肢无触觉", 2, false));
        nib8ActNihss.setItemBeans(eight);

        List<NihssItemBar.ItemBean> nine = new ArrayList<>();
        nine.add(new NihssItemBar.ItemBean("正常，无失语", 0, false));
        nine.add(new NihssItemBar.ItemBean("轻到中度，流利程度和理解能力有一些缺损，但表达无明显受损", 1, false));
        nine.add(new NihssItemBar.ItemBean("严重失语，交流是通过病人破碎的语言表达，交流困难", 2, false));
        nine.add(new NihssItemBar.ItemBean("哑或完全失语，不能讲或不能理解", 3, false));
        nib9ActNihss.setItemBeans(nine);

        List<NihssItemBar.ItemBean> ten = new ArrayList<>();
        ten.add(new NihssItemBar.ItemBean("正常", 0, false));
        ten.add(new NihssItemBar.ItemBean("轻到中度，至少有一些发音不清，虽有困难，但能被理解", 1, false));
        ten.add(new NihssItemBar.ItemBean("言语不清，不能被理解", 2, false));
        ten.add(new NihssItemBar.ItemBean("气管插管或其他物理障碍", 9, false));
        nib10ActNihss.setItemBeans(ten);

        List<NihssItemBar.ItemBean> eleven = new ArrayList<>();
        eleven.add(new NihssItemBar.ItemBean("正常", 0, false));
        eleven.add(new NihssItemBar.ItemBean("视、触、听、空间觉或个人的忽视；或对任何一种感觉的双侧同时刺激消失", 1, false));
        eleven.add(new NihssItemBar.ItemBean("严重的偏侧忽视；超过一种形式的偏侧忽视；不认识自己的手；只能对一侧空间定位", 2, false));
        nib11ActNihss.setItemBeans(eleven);*/
    }


}

    
    
       
    