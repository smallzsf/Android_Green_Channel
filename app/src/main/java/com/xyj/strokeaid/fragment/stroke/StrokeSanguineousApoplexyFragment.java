package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.dist.CeaCesBean;
import com.xyj.strokeaid.bean.dist.StrokeSangguineousBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.MyRadioGroup;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 脑出血
 * @Author: crq
 * @CreateDate: 2020/8/29 9:57
 */
public class StrokeSanguineousApoplexyFragment extends BaseStrokeFragment {
    /**
     * 开始时间
     */
    @BindView(R.id.ttb_start_time_fgm_apoplexy)
    TextTimeBar ttb_start_time_fgm_apoplexy;
    /**
     * 全麻
     */
    @BindView(R.id.rb_all_anaesthesia_fgm_sang)
    RadioButton rb_all_anaesthesia_fgm_sang;
    /**
     * 局麻
     */
    @BindView(R.id.rb_local_anaesthesia_fgm_sang)
    RadioButton rb_local_anaesthesia_fgm_sang;
    /**
     * 手术方式 多选  开颅血肿清除术
     */
    @BindView(R.id.ck_klxzqcs_fgm_apoplexy)
    CheckBox ck_klxzqcs_fgm_apoplexy;
    /**
     * 手术方式 多选  去骨瓣减压术
     */
    @BindView(R.id.ck_qgbjys_fgm_apoplexy)
    CheckBox ck_qgbjys_fgm_apoplexy;
    /**
     * 手术方式 多选  脑室镜下血肿抽吸术
     */
    @BindView(R.id.ck_nsjxxzcxs_fgm_apoplexy)
    CheckBox ck_nsjxxzcxs_fgm_apoplexy;
    /**
     * 手术方式 多选  钻孔血肿抽吸术
     */
    @BindView(R.id.ck_zkxzcxs_fgm_apoplexy)
    CheckBox ck_zkxzcxs_fgm_apoplexy;
    /**
     * 手术方式 多选  复合手术
     */
    @BindView(R.id.ck_recombine_fgm_apoplexy)
    CheckBox ck_recombine_fgm_apoplexy;
    /**
     * 手术方式 多选  其他
     */
    @BindView(R.id.ck_qt_fgm_apoplexy)
    CheckBox ck_qt_fgm_apoplexy;
    /**
     * 手术方式 多选  其他 输入
     */
    @BindView(R.id.ck_qt_content_fgm_apoplexy)
    EditText ck_qt_content_fgm_apoplexy;
    /**
     * 脑部并发症 多选  无
     */
    @BindView(R.id.ck_nothing_fgm_apoplexy)
    CheckBox ck_nothing_fgm_apoplexy;
    /**
     * 脑部并发症 多选  手术部位再次脑出血
     */
    @BindView(R.id.ck_ssbwzcncx_fgm_apoplexy)
    CheckBox ck_ssbwzcncx_fgm_apoplexy;
    /**
     * 脑部并发症 多选  手术远离部位再次血
     */
    @BindView(R.id.ck_ssylbwzccx_fgm_apoplexy)
    CheckBox ck_ssylbwzccx_fgm_apoplexy;
    /**
     * 脑部并发症 多选  脑梗死
     */
    @BindView(R.id.ck_ngs_fgm_apoplexy)
    CheckBox ck_ngs_fgm_apoplexy;
    /**
     * 脑部并发症 多选  继发性癫痫
     */
    @BindView(R.id.ck_jfxdx_fgm_apoplexy)
    CheckBox ck_jfxdx_fgm_apoplexy;

    /**
     * 脑部并发症 多选  颅内感染
     */
    @BindView(R.id.ck_lngr_fgm_apoplexy)
    CheckBox ck_lngr_fgm_apoplexy;
    /**
     * 脑部并发症 多选  其他
     */
    @BindView(R.id.ck_nb_qt_fgm_apoplexy)
    CheckBox ck_nb_qt_fgm_apoplexy;
    /**
     * 脑部并发症 多选  其他 输入
     */
    @BindView(R.id.ck_nb_qt_content_fgm_apoplexy)
    EditText ck_nb_qt_content_fgm_apoplexy;
    /**
     * 预后 单选  其他 治愈
     */
    @BindView(R.id.rb_zy_fgm_apoplexy)
    RadioButton rb_zy_fgm_apoplexy;
    /**
     * 预后 单选  其他 好转
     */
    @BindView(R.id.rb_hz_fgm_apoplexy)
    RadioButton rb_hz_fgm_apoplexy;
    /**
     * 预后 单选  其他 加重
     */
    @BindView(R.id.rb_jz_fgm_apoplexy)
    RadioButton rb_jz_fgm_apoplexy;
    /**
     * 预后 单选  其他 死亡
     */
    @BindView(R.id.rb_sw_fgm_apoplexy)
    RadioButton rb_sw_fgm_apoplexy;
    /**
     * 是否延误布局
     */
    @BindView(R.id.ck_yanwu_ll_apoplexy)
    LinearLayout ck_yanwu_ll_apoplexy;
    /**
     * 救治是否延后 是
     */
    @BindView(R.id.rb_jzsfyh_yes)
    RadioButton rb_jzsfyh_yes;
    /**
     * 救治是否延后 否
     */
    @BindView(R.id.rb_jzsfyh_no)
    RadioButton rb_jzsfyh_no;
    /**
     * 延误原因 症状不明显延误诊断
     */
    @BindView(R.id.ck_bmzd_yw)
    CheckBox ck_bmzd_yw;
    /**
     * 延误原因 家属未到场
     */
    @BindView(R.id.ck_jswd_yw)
    CheckBox ck_jswd_yw;

    /**
     * 延误原因 家属未到场
     */
    @BindView(R.id.ck_ysjcsw_yw)
    CheckBox ck_ysjcsw_yw;
    /**
     * 延误原因 排队挂号、缴费、办住院时间长
     */
    @BindView(R.id.ck_pdgc_yw)
    CheckBox ck_pdgc_yw;
    /**
     * 延误原因 急诊科处理时间长
     */
    @BindView(R.id.ck_jsgc_yw)
    CheckBox ck_jsgc_yw;
    /**
     * 延误原因 手术期间出现并发症
     */
    @BindView(R.id.ck_bfz_yw)
    CheckBox ck_bfz_yw;

    /**
     * 延误原因 未实施绕行急诊方案
     */
    @BindView(R.id.ck_wssjsfa_yw)
    CheckBox ck_wssjsfa_yw;
    /**
     * 延误原因 导管室人员未到位
     */
    @BindView(R.id.ck_dgwd_yw)
    CheckBox ck_dgwd_yw;
    /**
     * 延误原因 知情同意时间过长
     */
    @BindView(R.id.ck_zqtygc_yw)
    CheckBox ck_zqtygc_yw;
    /**
     * 延误原因 病情不稳定
     */
    @BindView(R.id.ck_bqbw_yw)
    CheckBox ck_bqbw_yw;
    /**
     * 保存bt
     */
    @BindView(R.id.btn_apoplexy_save)
    AppCompatButton btn_apoplexy_save;
    /**
     * 是否延误 单选
     */
    @BindView(R.id.rg_jzsfyh_apoplexy)
    RadioGroup rg_jzsfyh_apoplexy;

    /**
     * 麻醉方式
     */
    @BindView(R.id.rg_anaesthesia_fgm_sang)
    RadioGroup rg_anaesthesia_fgm_sang;

    /**
     * 预后RG
     */
    @BindView(R.id.rg_zy_fgm)
    MyRadioGroup rg_zy_fgm;

    private String arrivetohemorrhageoperationbegintime;//脑出血手术到院至开始手术时间
    private String attacktohemorrhageoperationbegintime;//脑出血手术发病至开始手术时间
    private String hemorrhageoperationbegintime;//脑出血手术手术开始时间
    private String hemorrhageoperationcomplication;//脑出血手术脑部并发症
    private String hemorrhageoperationmode;//脑出血手术手术方式
    private String hemorrhageoperationprognosis;//脑出血手术预后
    private String operationanesthesiamode;//脑出血手术麻醉方式
    private String operationdelayreason;//脑出血手术延误原因
    private String operationisdelay;//脑出血手术是否延误
    private String otherhemorrhageoperationcomplication;//脑出血手术其他脑部并发症
    private String otherhemorrhageoperationmode;//脑出血手术其他手术方式


    public StrokeSanguineousApoplexyFragment() {
        // Required empty public constructor
    }

    public static StrokeSanguineousApoplexyFragment newInstance(String recordId) {
        StrokeSanguineousApoplexyFragment fragment = new StrokeSanguineousApoplexyFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sanguineous_apoplexy;
    }

    @Override
    protected void initView(@NonNull View view) {
        arrivetohemorrhageoperationbegintime = "";//脑出血手术到院至开始手术时间
        attacktohemorrhageoperationbegintime = "";//脑出血手术发病至开始手术时间
        hemorrhageoperationbegintime = "";//脑出血手术手术开始时间
        hemorrhageoperationcomplication = "";//脑出血手术脑部并发症
        hemorrhageoperationmode = "";//脑出血手术手术方式
        hemorrhageoperationprognosis = "";//脑出血手术预后
        operationanesthesiamode = "";//脑出血手术麻醉方式
        operationdelayreason = "";//脑出血手术延误原因
        operationisdelay = "-1";//脑出血手术是否延误
        otherhemorrhageoperationcomplication = "";//脑出血手术其他脑部并发症
        otherhemorrhageoperationmode = "";//脑出血手术其他手术方式
    }

    @Override
    protected void initListener() {
        ck_qt_fgm_apoplexy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ck_qt_content_fgm_apoplexy.setVisibility(View.VISIBLE);
                } else {
                    ck_qt_content_fgm_apoplexy.setVisibility(View.GONE);
                }
            }
        });
        ck_nb_qt_fgm_apoplexy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ck_nb_qt_content_fgm_apoplexy.setVisibility(View.VISIBLE);
                } else {
                    ck_nb_qt_content_fgm_apoplexy.setVisibility(View.GONE);
                }
            }
        });
        //麻醉方式
        initNarcosisway();
        //预后
        initHemorrhageoperationprognosis();
        //是否延误
        initIsdelay();
        btn_apoplexy_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initParameters();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /**
         * 每次进入页面自动读取
         */
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
    StrokeSangguineousBean sangguineousBean;

    private void initParameters() {
//        //手术开始时间
        hemorrhageoperationbegintime = ttb_start_time_fgm_apoplexy.getTime();
        //手术方式
        hemorrhageoperationmode = combineHemorrhageoperationmode();
        //脑部并发症
        hemorrhageoperationcomplication = combineHemorrhageoperationcomplication();
        //延误原因字符串
        operationdelayreason = conbineDelayreason();
        Log.e("==>arrivebegintime", arrivetohemorrhageoperationbegintime);
        Log.e("==>attackbegintime", attacktohemorrhageoperationbegintime);
        Log.e("==>begintime", hemorrhageoperationbegintime);
        Log.e("==>anesthesiamode", operationanesthesiamode);
        Log.e("==>mode", hemorrhageoperationmode);
        Log.e("==>othermode", otherhemorrhageoperationmode);
        Log.e("==>complication", hemorrhageoperationcomplication);
        Log.e("==>othercomplication", otherhemorrhageoperationcomplication);
        Log.e("==>prognosis", hemorrhageoperationprognosis);
        Log.e("==>operationisdelay", operationisdelay);
        Log.e("==>operationdelayreason", operationdelayreason);
        if (verifyParameters()) {
            //参数规范正确
            Log.e("==>verifyParameters", "参数正确");
            if (sangguineousBean == null)
                sangguineousBean = new StrokeSangguineousBean();
            sangguineousBean.setArrivetohemorrhageoperationbegintime(arrivetohemorrhageoperationbegintime);
            sangguineousBean.setAttacktohemorrhageoperationbegintime(attacktohemorrhageoperationbegintime);
            sangguineousBean.setHemorrhageoperationbegintime(hemorrhageoperationbegintime);
            sangguineousBean.setOperationanesthesiamode(operationanesthesiamode);
            sangguineousBean.setHemorrhageoperationmode(hemorrhageoperationmode);
            sangguineousBean.setOtherhemorrhageoperationmode(otherhemorrhageoperationmode);
            sangguineousBean.setHemorrhageoperationcomplication(hemorrhageoperationcomplication);
            sangguineousBean.setOtherhemorrhageoperationcomplication(otherhemorrhageoperationcomplication);
            sangguineousBean.setHemorrhageoperationprognosis(hemorrhageoperationprognosis);
            sangguineousBean.setOperationisdelay(operationisdelay);
            sangguineousBean.setOperationdelayreason(operationdelayreason);
            saveData(sangguineousBean);
        } else {
            //参数规范错误
            showToast("存在未填选项，请检查！");
        }
    }

    /**
     * 脑出血数据提交
     *
     * @param sangguineousBean
     */
    private void saveData(StrokeSangguineousBean sangguineousBean) {
        showLoadingDialog();
        BaseRequestBean<StrokeSangguineousBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, sangguineousBean);
        RetrofitClient.getInstance().getApi()
                .saveStrokeSangguineousInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        Log.e("==>sangguineous", "Response" + response);
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
        BaseRequestBean<StrokeSangguineousBean> baseRequestBean = new BaseRequestBean<>(
                recordId, 1, new StrokeSangguineousBean());
        RetrofitClient.getInstance()
                .getApi()
                .getStrokeSangguineousInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<StrokeSangguineousBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<StrokeSangguineousBean>> call, Response<BaseResponseBean<StrokeSangguineousBean>> response) {
                        hideLoadingDialog();
                        Log.e("==>sangguineousBean", "reponse:" + response);
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                sangguineousBean = response.body().getData().getData();
                                if (sangguineousBean != null) {
                                    Log.e("==>sangguineousBean", sangguineousBean.toString());
                                    // 请求成功
                                    // 填充页面
                                    getDatatoViews(sangguineousBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<StrokeSangguineousBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    /**
     * 控件回显数据
     *
     * @param sangguineousBean
     */
    private void getDatatoViews(StrokeSangguineousBean sangguineousBean) {
        //开始时间
        ttb_start_time_fgm_apoplexy.setTime(sangguineousBean.getHemorrhageoperationbegintime());
        //麻醉方式
        if ("cpc_ncxmzfs_qm".equals(sangguineousBean.getOperationanesthesiamode())) {
            rb_all_anaesthesia_fgm_sang.setChecked(true);
        } else if ("cpc_ncxmzfs_jm".equals(sangguineousBean.getOperationanesthesiamode())) {
            rb_local_anaesthesia_fgm_sang.setChecked(true);
        }
        //手术方式
        clearSanguineousOperationmode();
        String operationmode = sangguineousBean.getHemorrhageoperationmode();
        if (operationmode.indexOf(",") != -1) {
            //包含逗号
            List<String> strings = splitString(operationmode);
            for (int i = 0; i < strings.size(); i++) {
                String tagStr = strings.get(i);
                judgeSanguineousOperationmode(tagStr);
            }
        } else {
            judgeSanguineousOperationmode(operationmode);
        }
        if (operationmode.contains("cpc_ncxssfs_qt")) {
            ck_qt_content_fgm_apoplexy.setVisibility(View.VISIBLE);
            ck_qt_content_fgm_apoplexy.setText(sangguineousBean.getOtherhemorrhageoperationmode());
        } else {
            ck_qt_content_fgm_apoplexy.setVisibility(View.GONE);
        }

        //脑部并发症
        clearSanguineousComplication();
        String complications = sangguineousBean.getHemorrhageoperationcomplication();
        if (complications.indexOf(",") != -1) {
            //包含逗号
            List<String> strings = splitString(complications);
            for (int i = 0; i < strings.size(); i++) {
                String tagStr = strings.get(i);
                judgeSanguineousComplication(tagStr);
            }
        } else {
            judgeSanguineousComplication(complications);
        }
        if (complications.contains("cpc_nbbfz_qt")) {
            ck_nb_qt_content_fgm_apoplexy.setVisibility(View.VISIBLE);
            ck_nb_qt_content_fgm_apoplexy.setText(sangguineousBean.getOtherhemorrhageoperationcomplication());
        } else {
            ck_nb_qt_content_fgm_apoplexy.setVisibility(View.GONE);
        }

        //预后
        String prognosis = sangguineousBean.getHemorrhageoperationprognosis();
        if ("cpc_ncxssyh_zy".equals(prognosis)) {
            rb_zy_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssyh_hz".equals(prognosis)) {
            rb_hz_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssyh_jz".equals(prognosis)) {
            rb_jz_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssyh_sw".equals(prognosis)) {
            rb_sw_fgm_apoplexy.setChecked(true);
        }

        //是否延后
        String operationisdelay = sangguineousBean.getOperationisdelay();
        if ("-1".equals(operationisdelay)) {
            rb_jzsfyh_no.setChecked(true);
            ck_yanwu_ll_apoplexy.setVisibility(View.GONE);
            operationdelayreason = "";
        } else if ("1".equals(operationisdelay)) {
            rb_jzsfyh_yes.setChecked(true);
            ck_yanwu_ll_apoplexy.setVisibility(View.VISIBLE);
        }

        //延后原因
        clearSanguineousReason();
        if ("1".equals(operationisdelay)) {
            String delayreason = sangguineousBean.getOperationdelayreason();
            if (delayreason.indexOf(",") != -1) {
                //包含逗号
                List<String> delayreasons = splitString(delayreason);
                for (int i = 0; i < delayreasons.size(); i++) {
                    String tagStr = delayreasons.get(i);
                    judgeSanguineousReason(tagStr);
                }
            } else {
                judgeSanguineousReason(delayreason);
            }
        }
    }

    /**
     * 麻醉方式
     */
    private void initNarcosisway() {
        rg_anaesthesia_fgm_sang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rb_all_anaesthesia_fgm_sang.getId()) {
                    operationanesthesiamode = (String) rb_all_anaesthesia_fgm_sang.getTag();
                } else if (i == rb_local_anaesthesia_fgm_sang.getId()) {
                    operationanesthesiamode = (String) rb_local_anaesthesia_fgm_sang.getTag();
                }
            }
        });
    }

    /**
     * 手术方式
     *
     * @return
     */
    private String combineHemorrhageoperationmode() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ck_klxzqcs_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_klxzqcs_fgm_apoplexy.getTag());
        }
        if (ck_qgbjys_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_qgbjys_fgm_apoplexy.getTag());
        }
        if (ck_nsjxxzcxs_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_nsjxxzcxs_fgm_apoplexy.getTag());
        }
        if (ck_zkxzcxs_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_zkxzcxs_fgm_apoplexy.getTag());
        }
        if (ck_recombine_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_recombine_fgm_apoplexy.getTag());
        }
        if (ck_qt_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_qt_fgm_apoplexy.getTag());
            otherhemorrhageoperationmode = ck_qt_content_fgm_apoplexy.getText().toString().trim();
        } else {
            otherhemorrhageoperationmode = "";
        }
        return combineString(paramsList);
    }


    /**
     * 脑部并发症
     *
     * @return
     */
    private String combineHemorrhageoperationcomplication() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ck_nothing_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_nothing_fgm_apoplexy.getTag());
        }
        if (ck_ssbwzcncx_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_ssbwzcncx_fgm_apoplexy.getTag());
        }
        if (ck_ssylbwzccx_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_ssylbwzccx_fgm_apoplexy.getTag());
        }
        if (ck_ngs_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_ngs_fgm_apoplexy.getTag());
        }
        if (ck_jfxdx_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_jfxdx_fgm_apoplexy.getTag());
        }
        if (ck_lngr_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_lngr_fgm_apoplexy.getTag());
        }
        if (ck_nb_qt_fgm_apoplexy.isChecked()) {
            paramsList.add((String) ck_nb_qt_fgm_apoplexy.getTag());
            otherhemorrhageoperationcomplication = ck_nb_qt_content_fgm_apoplexy.getText().toString().trim();
        } else {
            otherhemorrhageoperationcomplication = "";
        }
        return combineString(paramsList);
    }

    /**
     * 预后
     */
    private void initHemorrhageoperationprognosis() {
        rg_zy_fgm.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                if (checkedId == rb_zy_fgm_apoplexy.getId()) {
                    Log.e("==>rg", "1");
                    hemorrhageoperationprognosis = (String) rb_zy_fgm_apoplexy.getTag();
                } else if (checkedId == rb_hz_fgm_apoplexy.getId()) {
                    Log.e("==>rg", "2");
                    hemorrhageoperationprognosis = (String) rb_hz_fgm_apoplexy.getTag();
                } else if (checkedId == rb_jz_fgm_apoplexy.getId()) {
                    Log.e("==>rg", "2");
                    hemorrhageoperationprognosis = (String) rb_jz_fgm_apoplexy.getTag();
                } else if (checkedId == rb_sw_fgm_apoplexy.getId()) {
                    Log.e("==>rg", "2");
                    hemorrhageoperationprognosis = (String) rb_sw_fgm_apoplexy.getTag();
                }
            }
        });
    }

    /**
     * 是否延后字符串
     */
    private void initIsdelay() {
        rg_jzsfyh_apoplexy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == rb_jzsfyh_yes.getId()) {
                    //延后救治
                    ck_yanwu_ll_apoplexy.setVisibility(View.VISIBLE);
                    operationisdelay = (String) rb_jzsfyh_yes.getTag();
                } else if (i == rb_jzsfyh_no.getId()) {
                    operationisdelay = (String) rb_jzsfyh_no.getTag();
                    //选择没有延误，延误原因清空
                    //未延后救治
                    ck_yanwu_ll_apoplexy.setVisibility(View.GONE);
                    operationdelayreason = "";
                }
            }
        });
    }

    /**
     * 延误原因字符串
     */
    private String conbineDelayreason() {
        ArrayList<String> paramsList = new ArrayList<>();
        if (ck_bmzd_yw.isChecked()) {
            paramsList.add((String) ck_bmzd_yw.getTag());
        }
        if (ck_jswd_yw.isChecked()) {
            paramsList.add((String) ck_jswd_yw.getTag());
        }
        if (ck_ysjcsw_yw.isChecked()) {
            paramsList.add((String) ck_ysjcsw_yw.getTag());
        }

        if (ck_pdgc_yw.isChecked()) {
            paramsList.add((String) ck_pdgc_yw.getTag());
        }
        if (ck_jsgc_yw.isChecked()) {
            paramsList.add((String) ck_jsgc_yw.getTag());
        }
        if (ck_bfz_yw.isChecked()) {
            paramsList.add((String) ck_bfz_yw.getTag());
        }
        if (ck_wssjsfa_yw.isChecked()) {
            paramsList.add((String) ck_wssjsfa_yw.getTag());
        }
        if (ck_dgwd_yw.isChecked()) {
            paramsList.add((String) ck_dgwd_yw.getTag());
        }
        if (ck_zqtygc_yw.isChecked()) {
            paramsList.add((String) ck_zqtygc_yw.getTag());
        }
        if (ck_bqbw_yw.isChecked()) {
            paramsList.add((String) ck_bqbw_yw.getTag());
        }
        if ("-1".equals(ck_bqbw_yw)) {
            return "";
        } else {
            return combineString(paramsList);
        }
    }

    /**
     * 清除手术类型选择状态
     */
    private void clearSanguineousOperationmode() {
        ck_klxzqcs_fgm_apoplexy.setChecked(false);
        ck_qgbjys_fgm_apoplexy.setChecked(false);
        ck_nsjxxzcxs_fgm_apoplexy.setChecked(false);
        ck_recombine_fgm_apoplexy.setChecked(false);
        ck_klxzqcs_fgm_apoplexy.setChecked(false);
        ck_qt_fgm_apoplexy.setChecked(false);
    }

    /**
     * 判断手术类型
     *
     * @param tagStr
     */
    private void judgeSanguineousOperationmode(String tagStr) {
        if ("cpc_ncxssfs_klxzqcs".equals(tagStr)) {
            ck_klxzqcs_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssfs_qgbjys".equals(tagStr)) {
            ck_qgbjys_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssfs_nsjxxzcxs".equals(tagStr)) {
            ck_nsjxxzcxs_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssfs_zkxzcxs".equals(tagStr)) {
            ck_zkxzcxs_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssfs_fhss".equals(tagStr)) {
            ck_recombine_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_ncxssfs_qt".equals(tagStr)) {
            ck_qt_fgm_apoplexy.setChecked(true);
        }
    }

    /**
     * 清除并发症选择类型
     */
    private void clearSanguineousComplication() {
        ck_nothing_fgm_apoplexy.setChecked(false);
        ck_ssbwzcncx_fgm_apoplexy.setChecked(false);
        ck_ssylbwzccx_fgm_apoplexy.setChecked(false);
        ck_ngs_fgm_apoplexy.setChecked(false);
        ck_jfxdx_fgm_apoplexy.setChecked(false);
        ck_lngr_fgm_apoplexy.setChecked(false);
        ck_nb_qt_fgm_apoplexy.setChecked(false);
    }

    /**
     * 判断并发症类型
     *
     * @param tagStr
     */
    private void judgeSanguineousComplication(String tagStr) {
        if ("cpc_nbbfz_w".equals(tagStr)) {
            ck_nothing_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_ssbwzcncx".equals(tagStr)) {
            ck_ssbwzcncx_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_ssygbwzcx".equals(tagStr)) {
            ck_ssylbwzccx_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_ngs".equals(tagStr)) {
            ck_ngs_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_jfxdx".equals(tagStr)) {
            ck_jfxdx_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_lngr".equals(tagStr)) {
            ck_lngr_fgm_apoplexy.setChecked(true);
        }
        if ("cpc_nbbfz_qt".equals(tagStr)) {
            ck_nb_qt_fgm_apoplexy.setChecked(true);
        }
    }

    private void clearSanguineousReason() {
        ck_bmzd_yw.setChecked(false);
        ck_jswd_yw.setChecked(false);
        ck_ysjcsw_yw.setChecked(false);
        ck_pdgc_yw.setChecked(false);
        ck_jsgc_yw.setChecked(false);
        ck_bfz_yw.setChecked(false);
        ck_wssjsfa_yw.setChecked(false);
        ck_dgwd_yw.setChecked(false);
        ck_zqtygc_yw.setChecked(false);
        ck_bqbw_yw.setChecked(false);
    }

    /**
     * 判断延误原因类型
     *
     * @param tagStr
     */
    private void judgeSanguineousReason(String tagStr) {
        if ("cpc_ywyy_zzbmxywzd".equals(tagStr)) {
            ck_bmzd_yw.setChecked(true);
        }
        if ("cpc_ywyy_jswdc".equals(tagStr)) {
            ck_jswd_yw.setChecked(true);
        }
        if ("cpc_ywyy_ysjcyw".equals(tagStr)) {
            ck_ysjcsw_yw.setChecked(true);
        }
        if ("cpc_ywyy_pdghsc".equals(tagStr)) {
            ck_pdgc_yw.setChecked(true);
        }
        if ("cpc_ywyy_jzkclsc".equals(tagStr)) {
            ck_jsgc_yw.setChecked(true);
        }
        if ("cpc_ywyy_ssqjcxbfz".equals(tagStr)) {
            ck_bfz_yw.setChecked(true);
        }
        if ("cpc_ywyy_wssrxjzfa".equals(tagStr)) {
            ck_wssjsfa_yw.setChecked(true);
        }
        if ("cpc_ywyy_dgsrywdw".equals(tagStr)) {
            ck_dgwd_yw.setChecked(true);
        }
        if ("cpc_ywyy_zqtysjgc".equals(tagStr)) {
            ck_zqtygc_yw.setChecked(true);
        }
        if ("cpc_ywyy_bqbwd".equals(tagStr)) {
            ck_bqbw_yw.setChecked(true);
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
     * 校验参数是否合规 字段不能为空
     *
     * @return
     */
    private boolean verifyParameters() {
        if (!stringIsEmpty(hemorrhageoperationbegintime) &&
                !stringIsEmpty(hemorrhageoperationmode) &&
                !stringIsEmpty(hemorrhageoperationprognosis) &&
                !stringIsEmpty(operationanesthesiamode) &&
                !stringIsEmpty(operationisdelay)) {
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

    public static String timeStamp2Date(String timeStr) {
        if (!stringIsEmpty(timeStr)){
            long timeLong = Long.valueOf(timeStr).longValue();
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date(timeLong));
        }
        return "";
    }

}
