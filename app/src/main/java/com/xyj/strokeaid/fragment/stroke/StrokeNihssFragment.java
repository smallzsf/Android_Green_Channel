package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.NihssItemBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * NihssFragment
 * description: NIHSS评分
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
public class StrokeNihssFragment extends BaseFragment {

    @BindView(R.id.tv_score_frag_nihss)
    TextView tvScoreFragNihss;
    @BindView(R.id.es_opinion_frag_nihss)
    EditSpinner esOpinionFragNihss;
    @BindView(R.id.ll_score_frag_nihss)
    LinearLayout llScoreFragNihss;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.nib_1a_frag_nihss)
    NihssItemBar nib1aFragNihss;
    @BindView(R.id.nib_1b_frag_nihss)
    NihssItemBar nib1bFragNihss;
    @BindView(R.id.nib_1c_frag_nihss)
    NihssItemBar nib1cFragNihss;
    @BindView(R.id.nib_2_frag_nihss)
    NihssItemBar nib2FragNihss;
    @BindView(R.id.nib_3_frag_nihss)
    NihssItemBar nib3FragNihss;
    @BindView(R.id.nib_4_frag_nihss)
    NihssItemBar nib4FragNihss;
    @BindView(R.id.nib_5a_frag_nihss)
    NihssItemBar nib5aFragNihss;
    @BindView(R.id.nib_5b_frag_nihss)
    NihssItemBar nib5bFragNihss;
    @BindView(R.id.nib_6a_frag_nihss)
    NihssItemBar nib6aFragNihss;
    @BindView(R.id.nib_6b_frag_nihss)
    NihssItemBar nib6bFragNihss;
    @BindView(R.id.nib_7_frag_nihss)
    NihssItemBar nib7FragNihss;
    @BindView(R.id.nib_8_frag_nihss)
    NihssItemBar nib8FragNihss;
    @BindView(R.id.nib_9_frag_nihss)
    NihssItemBar nib9FragNihss;
    @BindView(R.id.nib_10_frag_nihss)
    NihssItemBar nib10FragNihss;
    @BindView(R.id.nib_11_frag_nihss)
    NihssItemBar nib11FragNihss;


    private String mRecordId;

    public StrokeNihssFragment() {
    }

    public static StrokeNihssFragment newInstance(String recordId) {
        StrokeNihssFragment fragment = new StrokeNihssFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected void initView(@NonNull View view) {
        initSpinner();
        initNihssBars();
    }

    private void initSpinner() {
        String[] stringArray = getResources().getStringArray(R.array.nihss_titles);
        esOpinionFragNihss.setItemData(Arrays.asList(stringArray));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nihss;
    }

    @Override
    protected void initListener() {

    }


    @OnClick({R.id.btn_confirm, R.id.btn_get_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                break;
            case R.id.btn_get_data:
                break;
            default:
                break;
        }
    }

    /**
     * 初始化评分选项
     */
    private void initNihssBars() {
        List<NihssItemBar.ItemBean> oneA = new ArrayList<>();
        oneA.add(new NihssItemBar.ItemBean("清醒，反映灵敏", 0, false));
        oneA.add(new NihssItemBar.ItemBean("嗜睡，轻微刺激能唤醒，可回答问题，执行指令", 1, false));
        oneA.add(new NihssItemBar.ItemBean("昏睡或反应迟钝，需反复刺激、强烈或疼痛刺激才有非刻板的反应", 2, false));
        oneA.add(new NihssItemBar.ItemBean("昏迷，仅有反射性活动或自发性反映或完全无反应、软瘫、无反射", 3, false));
        nib1aFragNihss.setItemBeans(oneA);

        List<NihssItemBar.ItemBean> oneB = new ArrayList<>();
        oneB.add(new NihssItemBar.ItemBean("两项均正确", 0, false));
        oneB.add(new NihssItemBar.ItemBean("一项正确", 1, false));
        oneB.add(new NihssItemBar.ItemBean("两项均不正确", 2, false));
        nib1bFragNihss.setItemBeans(oneB);

        List<NihssItemBar.ItemBean> oneC = new ArrayList<>();
        oneC.add(new NihssItemBar.ItemBean("两项均正确", 0, false));
        oneC.add(new NihssItemBar.ItemBean("一项正确", 1, false));
        oneC.add(new NihssItemBar.ItemBean("两项均不正确", 2, false));
        nib1cFragNihss.setItemBeans(oneC);

        List<NihssItemBar.ItemBean> two = new ArrayList<>();
        two.add(new NihssItemBar.ItemBean("正常", 0, false));
        two.add(new NihssItemBar.ItemBean("部分凝视麻痹（单眼或双眼凝视异常，但无强迫凝视或凝视麻痹）", 1, false));
        two.add(new NihssItemBar.ItemBean("强迫凝视或完全凝视麻痹（不能被头眼反射克服）", 2, false));
        nib2FragNihss.setItemBeans(two);

        List<NihssItemBar.ItemBean> three = new ArrayList<>();
        three.add(new NihssItemBar.ItemBean("无视野缺损", 0, false));
        three.add(new NihssItemBar.ItemBean("部分偏盲", 1, false));
        three.add(new NihssItemBar.ItemBean("完全偏盲", 2, false));
        three.add(new NihssItemBar.ItemBean("双侧偏盲（包括皮质盲）", 3, false));
        nib3FragNihss.setItemBeans(three);

        List<NihssItemBar.ItemBean> four = new ArrayList<>();
        four.add(new NihssItemBar.ItemBean("正常", 0, false));
        four.add(new NihssItemBar.ItemBean("轻微（微笑时鼻唇沟变平、不对称）", 1, false));
        four.add(new NihssItemBar.ItemBean("部分（下面部完全或几乎完全瘫痪）", 2, false));
        four.add(new NihssItemBar.ItemBean("完全（单或双侧瘫痪，上下面部缺乏运动）", 3, false));
        nib4FragNihss.setItemBeans(four);

        List<NihssItemBar.ItemBean> fiveA = new ArrayList<>();
        fiveA.add(new NihssItemBar.ItemBean("上肢于要求位置坚持10秒，无下落", 0, false));
        fiveA.add(new NihssItemBar.ItemBean("上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物", 1, false));
        fiveA.add(new NihssItemBar.ItemBean("能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上", 2, false));
        fiveA.add(new NihssItemBar.ItemBean("不能抗重力，上肢快速下落", 3, false));
        fiveA.add(new NihssItemBar.ItemBean("无运动", 4, false));
        fiveA.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib5aFragNihss.setItemBeans(fiveA);

        List<NihssItemBar.ItemBean> fiveB = new ArrayList<>();
        fiveB.add(new NihssItemBar.ItemBean("上肢于要求位置坚持10秒，无下落", 0, false));
        fiveB.add(new NihssItemBar.ItemBean("上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物", 1, false));
        fiveB.add(new NihssItemBar.ItemBean("能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上", 2, false));
        fiveB.add(new NihssItemBar.ItemBean("不能抗重力，上肢快速下落", 3, false));
        fiveB.add(new NihssItemBar.ItemBean("无运动", 4, false));
        fiveB.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib5bFragNihss.setItemBeans(fiveB);

        List<NihssItemBar.ItemBean> sixA = new ArrayList<>();
        sixA.add(new NihssItemBar.ItemBean("下肢于要求位置坚持5秒，无下落", 0, false));
        sixA.add(new NihssItemBar.ItemBean("在5秒末下落，不撞击床", 1, false));
        sixA.add(new NihssItemBar.ItemBean("5秒内较快下落到床上，但可抗重力", 2, false));
        sixA.add(new NihssItemBar.ItemBean("快速下落，不能抗重力", 3, false));
        sixA.add(new NihssItemBar.ItemBean("无运动", 4, false));
        sixA.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib6aFragNihss.setItemBeans(sixA);

        List<NihssItemBar.ItemBean> sixB = new ArrayList<>();
        sixB.add(new NihssItemBar.ItemBean("下肢于要求位置坚持5秒，无下落", 0, false));
        sixB.add(new NihssItemBar.ItemBean("在5秒末下落，不撞击床", 1, false));
        sixB.add(new NihssItemBar.ItemBean("5秒内较快下落到床上，但可抗重力", 2, false));
        sixB.add(new NihssItemBar.ItemBean("快速下落，不能抗重力", 3, false));
        sixB.add(new NihssItemBar.ItemBean("无运动", 4, false));
        sixB.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib6bFragNihss.setItemBeans(sixB);

        List<NihssItemBar.ItemBean> seven = new ArrayList<>();
        seven.add(new NihssItemBar.ItemBean("无共济失调", 0, false));
        seven.add(new NihssItemBar.ItemBean("一个肢体有", 1, false));
        seven.add(new NihssItemBar.ItemBean("两个肢体有", 2, false));
        seven.add(new NihssItemBar.ItemBean("截肢或关节融合", 9, false));
        nib7FragNihss.setItemBeans(seven);

        List<NihssItemBar.ItemBean> eight = new ArrayList<>();
        eight.add(new NihssItemBar.ItemBean("正常，没有感觉缺失", 0, false));
        eight.add(new NihssItemBar.ItemBean("轻到中度，患侧针刺感不明显或为钝性或仅有触觉", 1, false));
        eight.add(new NihssItemBar.ItemBean("严重到完全感觉缺失，面、上肢、下肢无触觉", 2, false));
        nib8FragNihss.setItemBeans(eight);

        List<NihssItemBar.ItemBean> nine = new ArrayList<>();
        nine.add(new NihssItemBar.ItemBean("正常，无失语", 0, false));
        nine.add(new NihssItemBar.ItemBean("轻到中度，流利程度和理解能力有一些缺损，但表达无明显受损", 1, false));
        nine.add(new NihssItemBar.ItemBean("严重失语，交流是通过病人破碎的语言表达，交流困难", 2, false));
        nine.add(new NihssItemBar.ItemBean("哑或完全失语，不能讲或不能理解", 3, false));
        nib9FragNihss.setItemBeans(nine);

        List<NihssItemBar.ItemBean> ten = new ArrayList<>();
        ten.add(new NihssItemBar.ItemBean("正常", 0, false));
        ten.add(new NihssItemBar.ItemBean("轻到中度，至少有一些发音不清，虽有困难，但能被理解", 1, false));
        ten.add(new NihssItemBar.ItemBean("言语不清，不能被理解", 2, false));
        ten.add(new NihssItemBar.ItemBean("气管插管或其他物理障碍", 9, false));
        nib10FragNihss.setItemBeans(ten);

        List<NihssItemBar.ItemBean> eleven = new ArrayList<>();
        eleven.add(new NihssItemBar.ItemBean("正常", 0, false));
        eleven.add(new NihssItemBar.ItemBean("视、触、听、空间觉或个人的忽视；或对任何一种感觉的双侧同时刺激消失", 1, false));
        eleven.add(new NihssItemBar.ItemBean("严重的偏侧忽视；超过一种形式的偏侧忽视；不认识自己的手；只能对一侧空间定位", 2, false));
        nib11FragNihss.setItemBeans(eleven);
    }
}