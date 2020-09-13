package com.xyj.strokeaid.fragment.stroke;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.dist.CeaCesBean;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: ECA
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokCeaCesFragment extends BaseFragment {


    @BindView(R.id.rb_symptom_no_fgm_cea)
    RadioButton rbSymptomNoFgmCea;
    @BindView(R.id.rb_symptom_yes_fgm_cea)
    RadioButton rbSymptomYesFgmCea;
    @BindView(R.id.ttb_start_time_fgm_cea)
    TextTimeBar ttbStartTimeFgmCea;
    @BindView(R.id.ck_local_lica_fgm_cea)
    CheckBox ckLocalLicaFgmCea;
    @BindView(R.id.ck_local_rica_fgm_cea)
    CheckBox ckLocalRicaFgmCea;
    @BindView(R.id.rb_all_anaesthesia_fgm_cea)
    RadioButton rbAllAnaesthesiaFgmCea;
    @BindView(R.id.rb_local_anaesthesia_fgm_cea)
    RadioButton rbLocalAnaesthesiaFgmCea;
    @BindView(R.id.ck_tcd_fgm_cea)
    CheckBox ckTcdFgmCea;
    @BindView(R.id.ck_ndt_fgm_cea)
    CheckBox ckNdtFgmCea;
    @BindView(R.id.ck_other_fgm_cea)
    CheckBox ckOtherFgmCea;
    @BindView(R.id.rb_bzcea_fgm_cea)
    RadioButton rbBzceaFgmCea;
    @BindView(R.id.rb_wfcea_fgm_cea)
    RadioButton rbWfceaFgmCea;
    @BindView(R.id.rb_ces_fgm_cea)
    RadioButton rbCesFgmCea;
    @BindView(R.id.rb_fhss_fgm_cea)
    RadioButton rbFhssFgmCea;
    @BindView(R.id.rb_jzsfyh_yes_cea)
    RadioButton rbSfcybpYes;
    @BindView(R.id.rb_jzsfyh_no_cea)
    RadioButton rbSfcybpNo;
    @BindView(R.id.cb_fluid_infusion)
    CheckBox cbFluidInfusion;
    @BindView(R.id.cb_ventilation_way)
    CheckBox cbVentilationWay;
    @BindView(R.id.cb_ventilation_bandage)
    CheckBox cbVentilationBandage;
    @BindView(R.id.cb_ventilation_limbs)
    CheckBox cbVentilationLimbs;
    @BindView(R.id.cb_ventilation_chest)
    CheckBox cbVentilationChest;
    @BindView(R.id.cb_ventilation_pelvis)
    CheckBox cbVentilationPelvis;
    @BindView(R.id.cb_ventilation_neck)
    CheckBox cbVentilationNeck;
    @BindView(R.id.cb_ventilation_vertebra)
    CheckBox cbVentilationVertebra;
    @BindView(R.id.cb_ventilation_fracture_out)
    CheckBox cbVentilationFractureOut;
    @BindView(R.id.cb_ventilation_other)
    CheckBox cbVentilationOther;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.rg_yangwu_cea)
    RadioGroup rgYangwucea;
    @BindView(R.id.ll_yangwu_cea)
    LinearLayout llYangwuCea;
    @BindView(R.id.rg_cpc_mzfs_qm)
    RadioGroup rg_cpc_mzfs_qm;
    @BindView(R.id.rg_shoushu_fgm_cea)
    MyRadioGroup rg_shoushu_fgm_cea;
    @BindView(R.id.rg_sfcybp_cea)
    RadioGroup rg_sfcybp_cea;
    @BindView(R.id.rb_sfcybp_yes_cea)
    RadioButton rb_sfcybp_yes_cea;
    @BindView(R.id.rb_sfcybp_no_cea)
    RadioButton rb_sfcybp_no_cea;

    /**
     * 症状不明显延误诊断
     */
    @BindView(R.id.ck_bmzd_yw_cea)
    CheckBox ckBmzd_yw_cea;
    /**
     * 家属未到场
     */
    @BindView(R.id.ck_jswd_yw_cea)
    CheckBox ck_jswd_yw_cea;
    /**
     * 医生决策延误
     */
    @BindView(R.id.ck_jcsw_yw_cea)
    CheckBox ck_jcsw_yw_cea;
    /**
     * 排队挂号、缴费、办住院时长
     */
    @BindView(R.id.ck_pdgc_yw_cea)
    CheckBox ck_pdgc_yw_cea;
    /**
     * 急诊科处理时间长
     */
    @BindView(R.id.ck_jsgc_yw_cea)
    CheckBox ck_jsgc_yw_cea;
    /**
     * 手术期间出现并发症
     */
    @BindView(R.id.ck_bfz_yw_cea)
    CheckBox ck_bfz_yw_cea;
    /**
     * 未实施绕行急诊方案
     */
    @BindView(R.id.ck_rxjz_yw_cea)
    CheckBox ck_rxjz_yw_cea;
    /**
     * 导管室人员未到位
     */
    @BindView(R.id.ck_dgwd_yw_cea)
    CheckBox ck_dgwd_yw_cea;
    /**
     * 知情同意时间过长
     */
    @BindView(R.id.ck_zqtygc_yw_cea)
    CheckBox ck_zqtygc_yw_cea;
    /**
     * 病情不稳定
     */
    @BindView(R.id.ck_bqbw_yw_cea)
    CheckBox ck_bqbw_yw_cea;

    public StrokCeaCesFragment() {
        // Required empty public constructor
    }

    private String ceacaschooseway;//手术采取方式
    private String ceacascomplication;//并发症
    private String ceacasdelayreason;//延误原因
    private String ceacasischoosepatch;//是否采用补片
    private String ceacasisdelay;//救治是否延误
    private String ceacasmonitoringmeans;//实施的监测手段
    private String ceacasnarcosisway;//麻醉方式
    private String ceacasoperationpart;//手术部位
    private String ceacasoperationtime;//手术开始时间

    public static StrokCeaCesFragment newInstance(String recordId) {
        StrokCeaCesFragment fragment = new StrokCeaCesFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.stroke_fragment_cea_ces;
    }

    @Override
    protected void initView(@NonNull View view) {
        ceacaschooseway = "";//手术采取方式
        ceacascomplication = "";//并发症
        ceacasdelayreason = "";//延误原因
        ceacasischoosepatch = "";//是否采用补片
        ceacasisdelay = "";//救治是否延误
        ceacasmonitoringmeans = "";//实施的监测手段
        ceacasnarcosisway = "";//麻醉方式
        ceacasoperationpart = "";//手术部位
        ceacasoperationtime = "";//手术开始时间
    }

    @Override
    protected void initListener() {
        //麻醉方式
        initNarcosisway();
        //手术采取方式
        initCeacaschooseway();
        //是否采用补片
        initChoosepatch();
        //救治是否延误
        initIsdelay();

        /**
         * CEA保存点击事件
         */
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initParameters();
            }
        });
    }

    /**
     * 初始化参数
     */
    private void initParameters() {
        //手术开始时间
        ceacasoperationtime = ttbStartTimeFgmCea.getTime();
        //手术部位
        ceacasoperationpart = combineOperationpart();
        //实施的监测手段
        ceacasmonitoringmeans = combineCeacasmonitoringmeans();
        //并发症
        ceacascomplication = conbineComplication();
        //延误原因
        ceacasdelayreason = conbineDelayreason();
        Log.e("==>ceacasnarcosisway", ceacasnarcosisway);
        Log.e("==>ceacaschooseway", ceacaschooseway);
        Log.e("==>ceacasischoosepatch", ceacasischoosepatch);
        Log.e("==>ceacasisdelay", ceacasisdelay);
        Log.e("==>ceacasoperationtime", ceacasoperationtime);
        Log.e("==>ceacasoperationpart", ceacasoperationpart);
        Log.e("==>ceacasmonitoring", ceacasmonitoringmeans);
        Log.e("==>ceacascomplication", ceacascomplication);
        Log.e("==>ceacasdelayreason", ceacasdelayreason);
        if (verifyParameters()) {
            //参数规范正确
            Log.e("==>verifyParameters", "参数正确");
            CeaCesBean ceaCesBean = new CeaCesBean();
            ceaCesBean.setCeacasnarcosisway(ceacasnarcosisway);
            ceaCesBean.setCeacaschooseway(ceacaschooseway);
            ceaCesBean.setCeacaschooseway(ceacasischoosepatch);
            ceaCesBean.setCeacasisdelay(ceacasisdelay);
            ceaCesBean.setCeacasoperationtime(ceacasoperationtime);
            ceaCesBean.setCeacasoperationpart(ceacasoperationpart);
            ceaCesBean.setCeacasmonitoringmeans(ceacasmonitoringmeans);
            ceaCesBean.setCeacascomplication(ceacascomplication);
            ceaCesBean.setCeacasdelayreason(ceacasdelayreason);
            doSave(ceaCesBean);
        } else {
            //参数规范错误
            showToast("存在未填选项，请检查！");
        }
    }

    /**
     * 保存CEACES
     */
    private void doSave(CeaCesBean ceaCesBean) {
//        ceaCesBean.setRecordId("1111");
//        String request = GsonUtils.getGson().toJson(ceaCesBean);
//        Log.e("==>ceaRequest", request);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
//        RetrofitClient
//                .getInstance()
//                .getCPApi()
//                .saveStrokeCeaCesDetail(requestBody)
//                .enqueue(new Callback<BaseObjectBean>() {
//                    @Override
//                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
//                        Log.e("==>ceaces", "onResponse" + response);
//                        if (response != null && response.body() != null) {
//                            BaseObjectBean body = response.body();
//                            if (body.getResult() == 1) {
//                                showToast("数据保存成功");
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
//                        Log.e("zhangshifu", "onFailure");
//                    }
//                });
    }

    /**
     * 手术部位字符串
     */
    private String combineOperationpart() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ckLocalLicaFgmCea.isChecked()) {
            paramsList.add((String) ckLocalLicaFgmCea.getTag());
        }
        if (ckLocalRicaFgmCea.isChecked()) {
            paramsList.add((String) ckLocalRicaFgmCea.getTag());
        }
        return combineString(paramsList);
    }

    /**
     * 麻醉方式字符串
     */
    private void initNarcosisway() {
        final String[] narcosiswayString = {""};
        rg_cpc_mzfs_qm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rbAllAnaesthesiaFgmCea.getId()) {
                    Log.e("==>rg", "1");
                    ceacasnarcosisway = (String) rbAllAnaesthesiaFgmCea.getTag();
                } else if (i == rbLocalAnaesthesiaFgmCea.getId()) {
                    Log.e("==>rg", "2");
                    ceacasnarcosisway = (String) rbLocalAnaesthesiaFgmCea.getTag();
                }
            }
        });
    }

    /**
     * 实施检测手段字符串
     */
    private String combineCeacasmonitoringmeans() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ckTcdFgmCea.isChecked()) {
            paramsList.add((String) ckTcdFgmCea.getTag());
        }
        if (ckNdtFgmCea.isChecked()) {
            paramsList.add((String) ckNdtFgmCea.getTag());
        }
        if (ckOtherFgmCea.isChecked()) {
            paramsList.add((String) ckOtherFgmCea.getTag());
        }
        return combineString(paramsList);
    }

    /**
     * 手术方式字符串
     */
    private void initCeacaschooseway() {
        rg_shoushu_fgm_cea.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                if (checkedId == rbBzceaFgmCea.getId()) {
                    ceacaschooseway = (String) rbBzceaFgmCea.getTag();
                } else if (checkedId == rbWfceaFgmCea.getId()) {
                    ceacaschooseway = (String) rbWfceaFgmCea.getTag();
                } else if (checkedId == rbCesFgmCea.getId()) {
                    ceacaschooseway = (String) rbCesFgmCea.getTag();
                } else if (checkedId == rbFhssFgmCea.getId()) {
                    ceacaschooseway = (String) rbFhssFgmCea.getTag();
                }
            }
        });
    }

    /**
     * 是否补片字符串
     */
    private void initChoosepatch() {
        rg_sfcybp_cea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rb_sfcybp_yes_cea.getId()) {
                    ceacasischoosepatch = (String) rb_sfcybp_yes_cea.getTag();
                } else if (i == rb_sfcybp_no_cea.getId()) {
                    ceacasischoosepatch = (String) rb_sfcybp_no_cea.getTag();
                }
            }
        });
    }

    /**
     * 并发症字符串
     */
    private String conbineComplication() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (cbFluidInfusion.isChecked()) {
            paramsList.add((String) cbFluidInfusion.getTag());
        }
        if (cbVentilationWay.isChecked()) {
            paramsList.add((String) cbVentilationWay.getTag());
        }
        if (cbVentilationBandage.isChecked()) {
            paramsList.add((String) cbVentilationBandage.getTag());
        }

        if (cbVentilationLimbs.isChecked()) {
            paramsList.add((String) cbVentilationLimbs.getTag());
        }
        if (cbVentilationChest.isChecked()) {
            paramsList.add((String) cbVentilationChest.getTag());
        }
        if (cbVentilationPelvis.isChecked()) {
            paramsList.add((String) cbVentilationPelvis.getTag());
        }
        if (cbVentilationNeck.isChecked()) {
            paramsList.add((String) cbVentilationNeck.getTag());
        }
        if (cbVentilationVertebra.isChecked()) {
            paramsList.add((String) cbVentilationVertebra.getTag());
        }
        if (cbVentilationFractureOut.isChecked()) {
            paramsList.add((String) cbVentilationFractureOut.getTag());
        }
        Log.e("==>Complication", combineString(paramsList));
        return combineString(paramsList);
    }

    /**
     * 是否延后字符串
     */
    private void initIsdelay() {
        rgYangwucea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rbSfcybpYes.getId()) {
                    //延后救治
                    llYangwuCea.setVisibility(View.VISIBLE);
                    ceacasisdelay = (String) rbSfcybpYes.getTag();
                } else if (i == rbSfcybpNo.getId()) {
                    ceacasisdelay = (String) rbSfcybpNo.getTag();
                    //选择没有延误，延误原因清空
                    //未延后救治
                    llYangwuCea.setVisibility(View.GONE);
                    ceacasdelayreason = "";
                }
            }
        });
    }

    /**
     * 延误原因字符串
     */
    private String conbineDelayreason() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ckBmzd_yw_cea.isChecked()) {
            paramsList.add((String) ckBmzd_yw_cea.getTag());
        }
        if (ck_jswd_yw_cea.isChecked()) {
            paramsList.add((String) ck_jswd_yw_cea.getTag());
        }
        if (ck_jcsw_yw_cea.isChecked()) {
            paramsList.add((String) ck_jcsw_yw_cea.getTag());
        }

        if (ck_pdgc_yw_cea.isChecked()) {
            paramsList.add((String) ck_pdgc_yw_cea.getTag());
        }
        if (ck_jsgc_yw_cea.isChecked()) {
            paramsList.add((String) ck_jsgc_yw_cea.getTag());
        }
        if (ck_bfz_yw_cea.isChecked()) {
            paramsList.add((String) ck_bfz_yw_cea.getTag());
        }
        if (ck_rxjz_yw_cea.isChecked()) {
            paramsList.add((String) ck_rxjz_yw_cea.getTag());
        }
        if (ck_dgwd_yw_cea.isChecked()) {
            paramsList.add((String) ck_dgwd_yw_cea.getTag());
        }
        if (ck_zqtygc_yw_cea.isChecked()) {
            paramsList.add((String) ck_zqtygc_yw_cea.getTag());
        }
        if (ck_bqbw_yw_cea.isChecked()) {
            paramsList.add((String) ck_bqbw_yw_cea.getTag());
        }
        if ("-1".equals(ceacasisdelay)) {
            return "";
        } else {
            return combineString(paramsList);
        }
    }

    /**
     * 合并字符串
     *
     * @param paramsList
     * @return
     */
    private String combineString(ArrayList<String> paramsList) {
        if (paramsList.size() > 0) {
            String paramString = "";
            for (String param : paramsList) {
                paramString = paramString + "," + param;
            }
            String substring = paramString.substring(1);
            return substring;
        } else {
            return "";
        }
    }

    /**
     * 校验参数是否合规 字段不能为空
     *
     * @return
     */
    private boolean verifyParameters() {
        if (!stringIsEmpty(ceacaschooseway) &&
                !stringIsEmpty(ceacasischoosepatch) &&
                !stringIsEmpty(ceacasisdelay) &&
                !stringIsEmpty(ceacasmonitoringmeans) &&
                !stringIsEmpty(ceacasnarcosisway) &&
                !stringIsEmpty(ceacasoperationpart) &&
                !stringIsEmpty(ceacasoperationtime)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断string是否为空
     *
     * @param contengStr
     * @return
     */
    public static boolean stringIsEmpty(String contengStr) {
        if (contengStr != null) {
            if (contengStr.length() > 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}
