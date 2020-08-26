package com.xyj.strokeaid.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.NihssItemBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * StrokeScoresFragment
 * description: 卒中 评分工具
 *
 * @author : Licy
 * @date : 2020/8/25
 * email ：licy3051@qq.com
 */
public class StrokeScoresFragment extends BaseFragment {

    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.nib_before_disease_mrs_frag_ss)
    NihssItemBar nibBeforeDiseaseMrsFragSs;
    @BindView(R.id.nib_in_hos_mrs_frag_ss)
    NihssItemBar nibInHosMrsFragSs;
    @BindView(R.id.nib_24_mrs_frag_ss)
    NihssItemBar nib24MrsFragSs;
    @BindView(R.id.tv_ih_title_frag_ss)
    TextView tvIhTitleFragSs;
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
    @BindView(R.id.nib_lh_gcs_eye_frag_ss)
    NihssItemBar nibLhGcsEyeFragSs;
    @BindView(R.id.nib_lh_gcs_speak_frag_ss)
    NihssItemBar nibLhGcsSpeakFragSs;
    @BindView(R.id.nib_lh_gcs_sport_frag_ss)
    NihssItemBar nibLhGcsSportFragSs;
    @BindView(R.id.ll_lh_contain_frag_ss)
    LinearLayout llLhContainFragSs;
    @BindView(R.id.nib_in_hos_fisher_frag_ss)
    NihssItemBar nibInHosFisherFragSs;
    @BindView(R.id.nib_live_hunt_hess_frag_ss)
    NihssItemBar nibLiveHuntHessFragSs;
    @BindView(R.id.nib_live_chads2_frag_ss)
    NihssItemBar nibLiveChads2FragSs;
    @BindView(R.id.nib_has_bled_frag_ss)
    NihssItemBar nibHasBledFragSs;
    @BindView(R.id.nib_wada_swallowing_frag_ss)
    NihssItemBar nibWadaSwallowingFragSs;
    @BindView(R.id.tv_sm_title_frag_ss)
    TextView tvSmTitleFragSs;
    @BindView(R.id.nib_sm_volume_frag_ss)
    NihssItemBar nibSmVolumeFragSs;
    @BindView(R.id.nib_sm_position_frag_ss)
    NihssItemBar nibSmPositionFragSs;
    @BindView(R.id.nib_sm_deep_frag_ss)
    NihssItemBar nibSmDeepFragSs;
    @BindView(R.id.ll_sm_contain_frag_ss)
    LinearLayout llSmContainFragSs;
    @BindView(R.id.tv_ih_score_title_frag_ss)
    TextView tvIhScoreTitleFragSs;
    @BindView(R.id.iv_ih_arrow_frag_ss)
    ImageView ivIhArrowFragSs;
    @BindView(R.id.tv_lh_score_title_frag_ss)
    TextView tvLhScoreTitleFragSs;
    @BindView(R.id.iv_lh_arrow_frag_ss)
    ImageView ivLhArrowFragSs;
    @BindView(R.id.tv_sm_score_title_frag_ss)
    TextView tvSmScoreTitleFragSs;
    @BindView(R.id.iv_sm_arrow_frag_ss)
    ImageView ivSmArrowFragSs;
    private String mPatientId;
    private String mDocId;

    public StrokeScoresFragment() {
        // Required empty public constructor
    }

    public static StrokeScoresFragment newInstance(String patientId, String docId) {
        StrokeScoresFragment fragment = new StrokeScoresFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    protected void initView(@NonNull View view) {
        initNihssBars();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stroke_scores;
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_get_data, R.id.btn_confirm,
            R.id.iv_ih_arrow_frag_ss, R.id.iv_lh_arrow_frag_ss, R.id.iv_sm_arrow_frag_ss})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_data:

                break;
            case R.id.btn_confirm:

                break;
            case R.id.iv_ih_arrow_frag_ss:
                parseHasSubItemScores(llIhContainFragSs, ivIhArrowFragSs);
                break;
            case R.id.iv_lh_arrow_frag_ss:
                parseHasSubItemScores(llLhContainFragSs, ivLhArrowFragSs);
                break;
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
        // 入院mRS评分
        List<NihssItemBar.ItemBean> inHosMrs = new ArrayList<>(beforeDisMrs);
        nibInHosMrsFragSs.setItemBeans(inHosMrs);
        // 溶栓后24hmRS评分
        List<NihssItemBar.ItemBean> after24Mrs = new ArrayList<>(beforeDisMrs);
        nib24MrsFragSs.setItemBeans(after24Mrs);
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
        // 入院Fisher分级
        List<NihssItemBar.ItemBean> fisher = new ArrayList<>();
        fisher.add(new NihssItemBar.ItemBean("0级：未见出血或仅脑室内出血或实质内出血（3%）", 0, "0级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅰ级：仅见基底池出血（14%）", 1, "Ⅰ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅱ级：仅见周边脑池或侧裂池出血（38%）", 2, "Ⅱ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅲ级：广泛蛛网膜下腔出血伴脑实质内血肿（57%）", 3, "Ⅲ级", false));
        fisher.add(new NihssItemBar.ItemBean("Ⅳ级：基底池和周边脑池、侧裂池较厚积血（57%）", 4, "Ⅳ级", false));
        nibInHosFisherFragSs.setItemBeans(fisher);
        // 住院Hunt-Hess评分
        List<NihssItemBar.ItemBean> huntHess = new ArrayList<>();
        huntHess.add(new NihssItemBar.ItemBean("未破裂动脉瘤", 0, "0级", false));
        huntHess.add(new NihssItemBar.ItemBean("无症状或轻微头痛", 1, "Ⅰ级", false));
        huntHess.add(new NihssItemBar.ItemBean("中一重度头痛，脑膜刺激征，颅神经麻痹", 2, "Ⅱ级", false));
        huntHess.add(new NihssItemBar.ItemBean("嗜睡，意识浑浊，轻度局灶神经体征", 3, "Ⅲ级", false));
        huntHess.add(new NihssItemBar.ItemBean("昏迷，中或重度偏瘫，有早起去脑强直或自主神经功能紊乱", 4, "Ⅳ级", false));
        huntHess.add(new NihssItemBar.ItemBean("深昏迷，去大脑强直，濒死状态", 5, "Ⅴ级", false));
        nibLiveHuntHessFragSs.setItemBeans(huntHess);
        // 住院CHADS2评分
        List<NihssItemBar.ItemBean> chads = new ArrayList<>();
        chads.add(new NihssItemBar.ItemBean("既往充血性心力衰竭（CHF）病史", 1, false));
        chads.add(new NihssItemBar.ItemBean("高血压", 1, false));
        chads.add(new NihssItemBar.ItemBean("年龄≥75岁", 1, false));
        chads.add(new NihssItemBar.ItemBean("糖尿病", 1, false));
        chads.add(new NihssItemBar.ItemBean("TIA或卒中病史", 2, false));
        nibLiveChads2FragSs.setMultipleItemBeans(chads);
        // HAS-BLED评分
        List<NihssItemBar.ItemBean> hasBled = new ArrayList<>();
        hasBled.add(new NihssItemBar.ItemBean("高血压", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("肾功能异常", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("肝功能异常", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("先前有过卒中", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("有出血史或出血倾向", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("有过INR值不稳定历史", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("老年 年龄≥65岁", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("合用阿司匹林或NSAIDs药物", 1, false));
        hasBled.add(new NihssItemBar.ItemBean("酗酒", 1, false));
        nibHasBledFragSs.setMultipleItemBeans(hasBled);
        // 洼田吞咽评定
        List<NihssItemBar.ItemBean> wada = new ArrayList<>();
        wada.add(new NihssItemBar.ItemBean("1级：任何条件下均有吞咽困难和不能吞咽", 1, "1级", false));
        wada.add(new NihssItemBar.ItemBean("2级：3个条件均具备则误吸减少", 2, "2级", false));
        wada.add(new NihssItemBar.ItemBean("3级：具备2个条件则误吸减少", 3, "3级", false));
        wada.add(new NihssItemBar.ItemBean("4级：若选择适当食物，则基本上无误吸", 4, "4级", false));
        wada.add(new NihssItemBar.ItemBean("5级：若注意进食方法和时间基本上无误吸", 5, "5级", false));
        wada.add(new NihssItemBar.ItemBean("6级：吞咽正常", 6, "6级", false));
        nibWadaSwallowingFragSs.setItemBeans(wada);
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

    
    
       
    