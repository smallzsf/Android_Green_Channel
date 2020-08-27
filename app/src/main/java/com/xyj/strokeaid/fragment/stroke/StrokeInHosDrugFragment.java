package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.AfterOperationDrugRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.AfterOperationDrugBean;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * StrokeMedicationFragment
 * description: 卒中 药物治疗 -- 住院用药
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeInHosDrugFragment extends BaseFragment {


    @BindView(R.id.tv_antiplatelet_frag_sihd)
    TextView tvAntiplateletFragSihd;
    @BindView(R.id.tv_antiplatelet_short_frag_sihd)
    TextView tvAntiplateletShortFragSihd;
    @BindView(R.id.iv_antiplatelet_frag_sihd)
    ImageView ivAntiplateletFragSihd;
    @BindView(R.id.ll_antiplatelet_frag_sihd)
    LinearLayout llAntiplateletFragSihd;
    @BindView(R.id.rv_antiplatelet_frag_sihd)
    RecyclerView rvAntiplateletFragSihd;
    @BindView(R.id.tv_anticoagulants_frag_sihd)
    TextView tvAnticoagulantsFragSihd;
    @BindView(R.id.tv_anticoagulants_short_frag_sihd)
    TextView tvAnticoagulantsShortFragSihd;
    @BindView(R.id.iv_anticoagulants_frag_sihd)
    ImageView ivAnticoagulantsFragSihd;
    @BindView(R.id.ll_anticoagulants_frag_sihd)
    LinearLayout llAnticoagulantsFragSihd;
    @BindView(R.id.rv_anticoagulants_frag_sihd)
    RecyclerView rvAnticoagulantsFragSihd;
    @BindView(R.id.tv_pressure_frag_sihd)
    TextView tvPressureFragSihd;
    @BindView(R.id.tv_pressure_short_frag_sihd)
    TextView tvPressureShortFragSihd;
    @BindView(R.id.iv_pressure_frag_sihd)
    ImageView ivPressureFragSihd;
    @BindView(R.id.ll_pressure_frag_sihd)
    LinearLayout llPressureFragSihd;
    @BindView(R.id.rv_pressure_frag_sihd)
    RecyclerView rvPressureFragSihd;
    @BindView(R.id.tv_fat_frag_sihd)
    TextView tvFatFragSihd;
    @BindView(R.id.tv_fat_short_frag_sihd)
    TextView tvFatShortFragSihd;
    @BindView(R.id.iv_fat_frag_sihd)
    ImageView ivFatFragSihd;
    @BindView(R.id.ll_fat_frag_sihd)
    LinearLayout llFatFragSihd;
    @BindView(R.id.rv_fat_frag_sihd)
    RecyclerView rvFatFragSihd;
    @BindView(R.id.tv_sugar_frag_sihd)
    TextView tvSugarFragSihd;
    @BindView(R.id.tv_sugar_short_frag_sihd)
    TextView tvSugarShortFragSihd;
    @BindView(R.id.iv_sugar_frag_sihd)
    ImageView ivSugarFragSihd;
    @BindView(R.id.ll_sugar_frag_sihd)
    LinearLayout llSugarFragSihd;
    @BindView(R.id.rv_sugar_frag_sihd)
    RecyclerView rvSugarFragSihd;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    private RadioGroup rgAntiplatelet;
    private RadioButton rbAntiplateletYes;
    private RadioButton rbAntiplateletNo;
    private TextTimeBar ttbAntiplatelet;

    private RadioGroup rgAnticoagulants;
    private RadioButton rbAnticoagulantsYes;
    private RadioButton rbAnticoagulantsNo;
    private TextTimeBar ttbAnticoagulants;

    private String mPatientId;
    private String mDocId;

    private AfterOperationDrugRvAdapter mAnticoagulantsRvAdapter;
    private List<AfterOperationDrugBean> mAnticoagulantsBeans;
    private AfterOperationDrugRvAdapter mAntiplateletRvAdapter;
    private List<AfterOperationDrugBean> mAntiplateletBeans;
    private AfterOperationDrugRvAdapter mFatRvAdapter;
    private List<AfterOperationDrugBean> mFatBeans;
    private AfterOperationDrugRvAdapter mPressureRvAdapter;
    private List<AfterOperationDrugBean> mPressureBeans;
    private AfterOperationDrugRvAdapter mSugarRvAdapter;
    private List<AfterOperationDrugBean> mSugarBeans;

    public StrokeInHosDrugFragment() {
        // Required empty public constructor
    }

    public static StrokeInHosDrugFragment newInstance(String patientId, String docId) {
        StrokeInHosDrugFragment fragment = new StrokeInHosDrugFragment();
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
    protected int getLayoutId() {
        return R.layout.fragment_stroke_in_hos_drug;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.ll_antiplatelet_frag_sihd, R.id.ll_anticoagulants_frag_sihd,
            R.id.ll_pressure_frag_sihd, R.id.ll_fat_frag_sihd,
            R.id.ll_sugar_frag_sihd, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_antiplatelet_frag_sihd:
                if (rvAntiplateletFragSihd.getVisibility() == View.VISIBLE) {
                    rvAntiplateletFragSihd.setVisibility(View.GONE);
                    ivAntiplateletFragSihd.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    ivAntiplateletFragSihd.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (rvAntiplateletFragSihd.getAdapter() == null) {
                        // 还未初始化
                        mAnticoagulantsBeans = getAnticoagulantsBeans();
                        mAnticoagulantsRvAdapter = new AfterOperationDrugRvAdapter(mAnticoagulantsBeans);
                        rvAntiplateletFragSihd.setLayoutManager(new LinearLayoutManager(mActivity));
                        rvAntiplateletFragSihd.setAdapter(mAnticoagulantsRvAdapter);
                        mAnticoagulantsRvAdapter.addHeaderView(getHeaderViewForAntiplatelet());
                    }
                    rvAntiplateletFragSihd.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_anticoagulants_frag_sihd:
                if (rvAnticoagulantsFragSihd.getVisibility() == View.VISIBLE) {
                    rvAnticoagulantsFragSihd.setVisibility(View.GONE);
                    ivAnticoagulantsFragSihd.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    ivAnticoagulantsFragSihd.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (rvAnticoagulantsFragSihd.getAdapter() == null) {
                        // 还未初始化
                        mAntiplateletBeans = getAntiplateletBeans();
                        mAntiplateletRvAdapter = new AfterOperationDrugRvAdapter(mAntiplateletBeans);
                        rvAnticoagulantsFragSihd.setLayoutManager(new LinearLayoutManager(mActivity));
                        rvAnticoagulantsFragSihd.setAdapter(mAntiplateletRvAdapter);
                        mAntiplateletRvAdapter.addHeaderView(getHeaderViewForAnticoagulants());
                    }
                    rvAnticoagulantsFragSihd.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_pressure_frag_sihd:
                if (rvPressureFragSihd.getVisibility() == View.VISIBLE) {
                    rvPressureFragSihd.setVisibility(View.GONE);
                    ivPressureFragSihd.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    ivPressureFragSihd.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (rvPressureFragSihd.getAdapter() == null) {
                        // 还未初始化
                        mPressureBeans = getPressureBeans();
                        mPressureRvAdapter = new AfterOperationDrugRvAdapter(mPressureBeans);
                        rvPressureFragSihd.setLayoutManager(new LinearLayoutManager(mActivity));
                        rvPressureFragSihd.setAdapter(mPressureRvAdapter);
                    }
                    rvPressureFragSihd.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_fat_frag_sihd:
                if (rvFatFragSihd.getVisibility() == View.VISIBLE) {
                    rvFatFragSihd.setVisibility(View.GONE);
                    ivFatFragSihd.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    ivFatFragSihd.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (rvFatFragSihd.getAdapter() == null) {
                        // 还未初始化
                        mFatBeans = getFatBeans();
                        mFatRvAdapter = new AfterOperationDrugRvAdapter(mFatBeans);
                        rvFatFragSihd.setLayoutManager(new LinearLayoutManager(mActivity));
                        rvFatFragSihd.setAdapter(mFatRvAdapter);
                    }
                    rvFatFragSihd.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_sugar_frag_sihd:
                if (rvSugarFragSihd.getVisibility() == View.VISIBLE) {
                    rvSugarFragSihd.setVisibility(View.GONE);
                    ivSugarFragSihd.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    ivSugarFragSihd.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (rvSugarFragSihd.getAdapter() == null) {
                        // 还未初始化
                        mSugarBeans = getSugarBeans();
                        mSugarRvAdapter = new AfterOperationDrugRvAdapter(mSugarBeans);
                        rvSugarFragSihd.setLayoutManager(new LinearLayoutManager(mActivity));
                        rvSugarFragSihd.setAdapter(mSugarRvAdapter);
                    }
                    rvSugarFragSihd.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_get_data:
                getAllData();
                break;
            case R.id.btn_confirm:
                break;
            default:
                break;
        }
    }

    private void getAllData() {
        List<AfterOperationDrugBean> data = mAnticoagulantsRvAdapter.getData();
        LogUtils.d(data.toString());
    }

    private List<AfterOperationDrugBean> getAntiplateletBeans() {
        ArrayList<AfterOperationDrugBean> list = new ArrayList<>();
        list.add(new AfterOperationDrugBean(false, "阿司匹林", ""));
        list.add(new AfterOperationDrugBean(true, "氯吡格雷", "氯吡格雷氯吡格雷"));
        list.add(new AfterOperationDrugBean(false, "奥扎格雷", ""));
        list.add(new AfterOperationDrugBean(false, "双嘧达莫", ""));
        list.add(new AfterOperationDrugBean(false, "塞氯吡啶", ""));
        list.add(new AfterOperationDrugBean(false, "西洛他唑", ""));
        list.add(new AfterOperationDrugBean(false, "其他", ""));
        return list;
    }

    private List<AfterOperationDrugBean> getAnticoagulantsBeans() {
        ArrayList<AfterOperationDrugBean> list = new ArrayList<>();
        list.add(new AfterOperationDrugBean(false, "华法令", ""));
        list.add(new AfterOperationDrugBean(true, "利伐沙班", "利伐沙班"));
        list.add(new AfterOperationDrugBean(false, "达比加群", ""));
        list.add(new AfterOperationDrugBean(true, "阿哌沙班", "阿哌沙班"));
        list.add(new AfterOperationDrugBean(false, "依度沙班", "依度沙班"));
        list.add(new AfterOperationDrugBean(false, "低分子肝素", ""));
        list.add(new AfterOperationDrugBean(false, "普通肝素", ""));
        list.add(new AfterOperationDrugBean(true, "其他", "其他"));
        return list;
    }

    private List<AfterOperationDrugBean> getPressureBeans() {
        ArrayList<AfterOperationDrugBean> list = new ArrayList<>();
        list.add(new AfterOperationDrugBean(false, "ACEI", ""));
        list.add(new AfterOperationDrugBean(true, "ARB", "利伐沙班"));
        list.add(new AfterOperationDrugBean(false, "利尿剂", ""));
        list.add(new AfterOperationDrugBean(true, "β受体阻滞剂", "阿哌沙班"));
        list.add(new AfterOperationDrugBean(false, "钙拮抗剂", "依度沙班"));
        list.add(new AfterOperationDrugBean(true, "其他", "其他"));
        return list;
    }

    private List<AfterOperationDrugBean> getFatBeans() {
        ArrayList<AfterOperationDrugBean> list = new ArrayList<>();
        list.add(new AfterOperationDrugBean(false, "他汀类", ""));
        list.add(new AfterOperationDrugBean(true, "烟酸及其衍生物", "利伐沙班"));
        list.add(new AfterOperationDrugBean(false, "贝特类", ""));
        list.add(new AfterOperationDrugBean(true, "胆固醇吸收抑制剂", "阿哌沙班"));
        list.add(new AfterOperationDrugBean(false, "其他", "依度沙班"));
        return list;
    }

    private List<AfterOperationDrugBean> getSugarBeans() {
        ArrayList<AfterOperationDrugBean> list = new ArrayList<>();
        list.add(new AfterOperationDrugBean(false, "胰岛素", ""));
        list.add(new AfterOperationDrugBean(true, "磺酰脲类", "利伐沙班"));
        list.add(new AfterOperationDrugBean(false, "双胍类", ""));
        list.add(new AfterOperationDrugBean(true, "α糖苷酶抑制剂", "阿哌沙班"));
        list.add(new AfterOperationDrugBean(false, "胰岛素增敏剂", "依度沙班"));
        list.add(new AfterOperationDrugBean(false, "非磺酰脲类促胰岛素分泌剂", ""));
        list.add(new AfterOperationDrugBean(true, "其他", "其他"));
        return list;
    }

    public View getHeaderViewForAnticoagulants() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.adapter_header_stroke_drug, rvAnticoagulantsFragSihd, false);
        rgAnticoagulants = view.findViewById(R.id.rg_time_header);
        rbAnticoagulantsYes = view.findViewById(R.id.rb_time_confirm_frag_sihd);
        rbAnticoagulantsNo = view.findViewById(R.id.rb_time_no_frag_sihd);
        ttbAnticoagulants = view.findViewById(R.id.ttb_first_drug_frag_sihd);
        return view;
    }

    public View getHeaderViewForAntiplatelet() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.adapter_header_stroke_drug, rvAntiplateletFragSihd, false);
        rgAnticoagulants = view.findViewById(R.id.rg_time_header);
        rbAnticoagulantsYes = view.findViewById(R.id.rb_time_confirm_frag_sihd);
        rbAnticoagulantsNo = view.findViewById(R.id.rb_time_no_frag_sihd);
        ttbAnticoagulants = view.findViewById(R.id.ttb_first_drug_frag_sihd);
        return view;
    }

}