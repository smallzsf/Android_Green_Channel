package com.xyj.strokeaid.fragment.stroke;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
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
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.dist.CeaCesBean;
import com.xyj.strokeaid.bean.dist.StrokeSangguineousBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: ECA
 * @Author: 陈奕嘉
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokCeaCesFragment extends BaseStrokeFragment {
    //    @BindView(R.id.rb_symptom_no_fgm_cea)
//    RadioButton rbSymptomNoFgmCea;
//    @BindView(R.id.rb_symptom_yes_fgm_cea)
//    RadioButton rbSymptomYesFgmCea;
    @BindView(R.id.ttb_start_time_fgm_cea)
    TextTimeBar ttb_start_time_fgm_cea;
    @BindView(R.id.ck_local_lica_fgm_cea)
    CheckBox ck_local_lica_fgm_cea;
    @BindView(R.id.ck_local_rica_fgm_cea)
    CheckBox ck_local_rica_fgm_cea;
    @BindView(R.id.rb_all_anaesthesia_fgm_cea)
    RadioButton rbAllAnaesthesiaFgmCea;
    @BindView(R.id.rb_local_anaesthesia_fgm_cea)
    RadioButton rbLocalAnaesthesiaFgmCea;
    @BindView(R.id.ck_tcd_fgm_cea)
    CheckBox ck_tcd_fgm_cea;
    @BindView(R.id.ck_ndt_fgm_cea)
    CheckBox ck_ndt_fgm_cea;
    @BindView(R.id.ck_other_fgm_cea)
    CheckBox ck_other_fgm_cea;
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
    CheckBox cb_fluid_infusion;
    @BindView(R.id.cb_ventilation_way)
    CheckBox cb_ventilation_way;
    @BindView(R.id.cb_ventilation_bandage)
    CheckBox cb_ventilation_bandage;
    @BindView(R.id.cb_ventilation_limbs)
    CheckBox cb_ventilation_limbs;
    @BindView(R.id.cb_ventilation_chest)
    CheckBox cb_ventilation_chest;
    @BindView(R.id.cb_ventilation_pelvis)
    CheckBox cb_ventilation_pelvis;
    @BindView(R.id.cb_ventilation_neck)
    CheckBox cb_ventilation_neck;
    @BindView(R.id.cb_ventilation_vertebra)
    CheckBox cb_ventilation_vertebra;
    @BindView(R.id.cb_ventilation_fracture_out)
    CheckBox cb_ventilation_fracture_out;
    @BindView(R.id.cb_ventilation_other)
    CheckBox cb_ventilation_other;
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
    CheckBox ck_bmzd_yw_cea;
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
        ceacasisdelay = "-1";//救治是否延误
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

    @Override
    public void onResume() {
        super.onResume();
        if (!stringIsEmpty(mRecordId)) {
            Log.e("==>mRecordId", mRecordId);
            loadData(mRecordId);
        } else {
            showToast("recordId为空！");
        }
    }

    /**
     * 初始化参数
     */
    CeaCesBean ceaCesBean;

    private void initParameters() {
        //手术开始时间
        ceacasoperationtime = ttb_start_time_fgm_cea.getTime();
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
            if (ceaCesBean == null)
                ceaCesBean = new CeaCesBean();
            ceaCesBean.setCeacasnarcosisway(ceacasnarcosisway);
            ceaCesBean.setCeacaschooseway(ceacaschooseway);
            ceaCesBean.setCeacasischoosepatch(ceacasischoosepatch);
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
        showLoadingDialog();
        BaseRequestBean<CeaCesBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, ceaCesBean);
        RetrofitClient.getInstance().getApi()
                .saveStrokeCeaCesInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        Log.e("==>ceaces", "Response" + response);
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 获取脑出血数据
     *
     * @param recordId
     */
    private void loadData(String recordId) {
        showLoadingDialog();
        BaseRequestBean<CeaCesBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 1, new CeaCesBean());
        RetrofitClient.getInstance()
                .getApi()
                .getStrokeCeaCesInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<CeaCesBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<CeaCesBean>> call, Response<BaseResponseBean<CeaCesBean>> response) {
                        hideLoadingDialog();
                        Log.e("==>sangguineousBean", "reponse:" + response);
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                ceaCesBean = response.body().getData().getData();
                                if (ceaCesBean != null) {
                                    Log.e("==>ceaCesBean", ceaCesBean.toString());
                                    // 请求成功
                                    // 填充页面
                                    getDatatoViews(ceaCesBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<CeaCesBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 数据回显 填充控件
     *
     * @param ceaCesBean
     */
    private void getDatatoViews(CeaCesBean ceaCesBean) {
        ttb_start_time_fgm_cea.setTime(ceaCesBean.getCeacasoperationtime());
        //手术部位
        clearOperationpart();
        String ceacasoperationpart = ceaCesBean.getCeacasoperationpart();
        if (ceacasoperationpart.indexOf(",") != -1) {
            //包含逗号
            List<String> strings = splitString(ceacasoperationpart);
            for (int i = 0; i < strings.size(); i++) {
                String tagStr = strings.get(i);
                judgeOperationpart(tagStr);
            }
        } else {
            judgeOperationpart(ceacasoperationpart);
        }
        //麻醉方式
        String ceacasnarcosisway = ceaCesBean.getCeacasnarcosisway();
        if ("cpc_mzfs_qm".equals(ceacasnarcosisway)) {
            rbAllAnaesthesiaFgmCea.setChecked(true);
        } else if ("cpc_mzfs_jm".equals(ceacasnarcosisway)) {
            rbLocalAnaesthesiaFgmCea.setChecked(true);
        }
        //检测手段
        clearMonitoringmeans();
        String monitoringmeans = ceaCesBean.getCeacasmonitoringmeans();
        if (monitoringmeans.indexOf(",") != -1) {
            //包含逗号
            List<String> strings = splitString(monitoringmeans);
            for (int i = 0; i < strings.size(); i++) {
                String tagStr = strings.get(i);
                judgeMonitoringmeans(tagStr);
            }
        } else {
            judgeMonitoringmeans(monitoringmeans);
        }
        //手术方式
        String chooseway = ceaCesBean.getCeacaschooseway();
        if ("cpc_sscqfs_bzscea".equals(chooseway)) {
            rbBzceaFgmCea.setChecked(true);
        } else if ("cpc_sscqfs_wfscea".equals(chooseway)) {
            rbWfceaFgmCea.setChecked(true);
        } else if ("cpc_sscqfs_cas".equals(chooseway)) {
            rbCesFgmCea.setChecked(true);
        } else if ("cpc_sscqfs_fhss".equals(chooseway)) {
            rbFhssFgmCea.setChecked(true);
        }
        //是否采用补片
        String ceacasischoosepatch = ceaCesBean.getCeacasischoosepatch();
        if ("cpc_bool_true".equals(ceacasischoosepatch)) {
            rb_sfcybp_yes_cea.setChecked(true);
        } else if ("cpc_bool_false".equals(ceacasischoosepatch)) {
            rb_sfcybp_no_cea.setChecked(true);
        }
        //并发症
        cleareComplication();
        String complication = ceaCesBean.getCeacascomplication();
        if (complication.indexOf(",") != -1) {
            //包含逗号
            List<String> strings = splitString(complication);
            for (int i = 0; i < strings.size(); i++) {
                String tagStr = strings.get(i);
                judgeComplication(tagStr);
            }
        } else {
            judgeComplication(complication);
        }
        //是否延误
        String ceacasisdelay = ceaCesBean.getCeacasisdelay();
        if ("1".equals(ceacasisdelay)) {
            rbSfcybpYes.setChecked(true);
            llYangwuCea.setVisibility(View.VISIBLE);
        } else if ("-1".equals(ceacasisdelay)) {
            rbSfcybpNo.setChecked(true);
            llYangwuCea.setVisibility(View.GONE);
        }
        //延误原因
        clearDelayreason();
        if ("1".equals(ceacasisdelay)) {
            String ceacasdelayreason = ceaCesBean.getCeacasdelayreason();
            if (ceacasdelayreason.indexOf(",") != -1) {
                //包含逗号
                List<String> strings = splitString(ceacasdelayreason);
                for (int i = 0; i < strings.size(); i++) {
                    String tagStr = strings.get(i);
                    judgeDelayreason(tagStr);
                }
            } else {
                judgeDelayreason(ceacasdelayreason);
            }
        }
    }

    /**
     * 手术部位字符串
     */
    private String combineOperationpart() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ck_local_lica_fgm_cea.isChecked()) {
            paramsList.add((String) ck_local_lica_fgm_cea.getTag());
        }
        if (ck_local_rica_fgm_cea.isChecked()) {
            paramsList.add((String) ck_local_rica_fgm_cea.getTag());
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
        if (ck_tcd_fgm_cea.isChecked()) {
            paramsList.add((String) ck_tcd_fgm_cea.getTag());
        }
        if (ck_ndt_fgm_cea.isChecked()) {
            paramsList.add((String) ck_ndt_fgm_cea.getTag());
        }
        if (ck_other_fgm_cea.isChecked()) {
            paramsList.add((String) ck_other_fgm_cea.getTag());
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
        if (cb_fluid_infusion.isChecked()) {
            paramsList.add((String) cb_fluid_infusion.getTag());
        }
        if (cb_ventilation_way.isChecked()) {
            paramsList.add((String) cb_ventilation_way.getTag());
        }
        if (cb_ventilation_bandage.isChecked()) {
            paramsList.add((String) cb_ventilation_bandage.getTag());
        }

        if (cb_ventilation_limbs.isChecked()) {
            paramsList.add((String) cb_ventilation_limbs.getTag());
        }
        if (cb_ventilation_chest.isChecked()) {
            paramsList.add((String) cb_ventilation_chest.getTag());
        }
        if (cb_ventilation_pelvis.isChecked()) {
            paramsList.add((String) cb_ventilation_pelvis.getTag());
        }
        if (cb_ventilation_neck.isChecked()) {
            paramsList.add((String) cb_ventilation_neck.getTag());
        }
        if (cb_ventilation_vertebra.isChecked()) {
            paramsList.add((String) cb_ventilation_vertebra.getTag());
        }
        if (cb_ventilation_fracture_out.isChecked()) {
            paramsList.add((String) cb_ventilation_fracture_out.getTag());
        }
        if (cb_ventilation_other.isChecked()) {
            paramsList.add((String) cb_ventilation_other.getTag());
        }
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
        if (ck_bmzd_yw_cea.isChecked()) {
            paramsList.add((String) ck_bmzd_yw_cea.getTag());
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
     * 清除手术部位类型
     */
    private void clearOperationpart() {
        ck_local_lica_fgm_cea.setChecked(false);
        ck_local_rica_fgm_cea.setChecked(false);
    }

    /**
     * 判断手术部位类型
     *
     * @param tagStr
     */
    private void judgeOperationpart(String tagStr) {
        if ("cpc_ssbw_lica".equals(tagStr)) {
            ck_local_lica_fgm_cea.setChecked(true);
        }
        if ("cpc_ssbw_rica".equals(tagStr)) {
            ck_local_rica_fgm_cea.setChecked(true);
        }
    }

    /**
     * 清除检测手段类型
     */
    private void clearMonitoringmeans() {
        ck_tcd_fgm_cea.setChecked(false);
        ck_ndt_fgm_cea.setChecked(false);
        ck_other_fgm_cea.setChecked(false);
    }

    /**
     * 判断检测手段类型
     *
     * @param tagStr
     */
    private void judgeMonitoringmeans(String tagStr) {
        if ("cpc_jcsd_tcd".equals(tagStr)) {
            ck_tcd_fgm_cea.setChecked(true);
        }
        if ("cpc_jcsd_ndt".equals(tagStr)) {
            ck_ndt_fgm_cea.setChecked(true);
        }
        if ("cpc_jcsd_qt".equals(tagStr)) {
            ck_other_fgm_cea.setChecked(true);
        }
    }

    /**
     * 清除并发症类型
     */
    private void cleareComplication() {
        cb_fluid_infusion.setChecked(false);
        cb_ventilation_way.setChecked(false);
        cb_ventilation_bandage.setChecked(false);
        cb_ventilation_limbs.setChecked(false);
        cb_ventilation_chest.setChecked(false);
        cb_ventilation_pelvis.setChecked(false);
        cb_ventilation_neck.setChecked(false);
        cb_ventilation_vertebra.setChecked(false);
        cb_ventilation_fracture_out.setChecked(false);
        cb_ventilation_other.setChecked(false);
    }

    /**
     * 判断并发症类型
     *
     * @param tagStr
     */
    private void judgeComplication(String tagStr) {
        if ("cpc_bfz_none".equals(tagStr)) {
            cb_fluid_infusion.setChecked(true);
        }
        if ("cpc_bfz_ngs".equals(tagStr)) {
            cb_ventilation_way.setChecked(true);
        }
        if ("cpc_bfz_ggz".equals(tagStr)) {
            cb_ventilation_bandage.setChecked(true);
        }
        if ("cpc_bfz_ncx".equals(tagStr)) {
            cb_ventilation_limbs.setChecked(true);
        }
        if ("cpc_bfz_zwsjss".equals(tagStr)) {
            cb_ventilation_chest.setChecked(true);
        }
        if ("cpc_bfz_qkgr".equals(tagStr)) {
            cb_ventilation_pelvis.setChecked(true);
        }
        if ("cpc_bfz_jfxdx".equals(tagStr)) {
            cb_ventilation_neck.setChecked(true);
        }
        if ("cpc_bfz_fbgr".equals(tagStr)) {
            cb_ventilation_vertebra.setChecked(true);
        }
        if ("cpc_bfz_mnxgr".equals(tagStr)) {
            cb_ventilation_fracture_out.setChecked(true);
        }
        if ("cpc_bfz_qt".equals(tagStr)) {
            cb_ventilation_other.setChecked(true);
        }
    }

    /**
     * 清除延误原因类型
     */
    private void clearDelayreason() {
        ck_bmzd_yw_cea.setChecked(false);
        ck_jswd_yw_cea.setChecked(false);
        ck_jcsw_yw_cea.setChecked(false);
        ck_pdgc_yw_cea.setChecked(false);
        ck_jsgc_yw_cea.setChecked(false);
        ck_bfz_yw_cea.setChecked(false);
        ck_rxjz_yw_cea.setChecked(false);
        ck_dgwd_yw_cea.setChecked(false);
        ck_zqtygc_yw_cea.setChecked(false);
        ck_bqbw_yw_cea.setChecked(false);
    }

    /**
     * 判断延误原因类型
     *
     * @param tagStr
     */
    private void judgeDelayreason(String tagStr) {
        if ("cpc_ywyy_zzbmxywzd".equals(tagStr)) {
            ck_bmzd_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_jswdc".equals(tagStr)) {
            ck_jswd_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_ysjcyw".equals(tagStr)) {
            ck_jcsw_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_pdghsc".equals(tagStr)) {
            ck_pdgc_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_jzkclsc".equals(tagStr)) {
            ck_jsgc_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_ssqjcxbfz".equals(tagStr)) {
            ck_bfz_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_wssrxjzfa".equals(tagStr)) {
            ck_rxjz_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_dgsrywdw".equals(tagStr)) {
            ck_dgwd_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_zqtysjgc".equals(tagStr)) {
            ck_zqtygc_yw_cea.setChecked(true);
        }
        if ("cpc_ywyy_bqbwd".equals(tagStr)) {
            ck_bqbw_yw_cea.setChecked(true);
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
            StringBuffer paramString = new StringBuffer("");
            for (String param : paramsList) {
                paramString.append(",");
                paramString.append(param);
            }
            String substring = paramString.toString().substring(1);
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
                !stringIsEmpty(ceacasoperationtime) &&
                !stringIsEmpty(ceacascomplication)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 以逗号分割字符串
     *
     * @param paramsStr
     * @return
     */
    private List<String> splitString(String paramsStr) {
        String str2 = paramsStr.replace(" ", "");//去掉所用空格
        List<String> list = Arrays.asList(str2.split(","));
        return list;
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
