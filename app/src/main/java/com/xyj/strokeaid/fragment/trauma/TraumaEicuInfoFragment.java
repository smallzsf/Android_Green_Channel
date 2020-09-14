package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RequestFieldEvaluaScoreBeanData;
import com.xyj.strokeaid.bean.TraumaEicuInfoBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * StrokeScoresFragment
 * description: EICU/ICU 信息
 *
 * @author : Licy
 * @date : 2020/8/25
 * email ：licy3051@qq.com
 */
public class TraumaEicuInfoFragment extends BaseStrokeFragment {

    /**
     * 开始时间
     */
    @BindView(R.id.ttb_start_time)
    TextTimeBar ttbStartTime;

    /**
     * 意识
     */
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esSignAware;

    /**
     * 紧急处置 心肺复苏
     */
    @BindView(R.id.other_set_xffs)
    CheckBox ckOtherSetXffs;

    /**
     * 紧急处置 气管插管
     */
    @BindView(R.id.other_set_qgcg)
    CheckBox ckOtherSetQgcg;

    /**
     * 紧急处置 呼吸机支持
     */
    @BindView(R.id.other_set_hxjzc)
    CheckBox ckOtherSetHxjzc;

    /**
     * 紧急处置 闭式引流
     */
    @BindView(R.id.other_set_bsyl)
    CheckBox ckOtherSetBsyl;

    /**
     * 紧急处置 气管切管
     */
    @BindView(R.id.other_set_qgqg)
    CheckBox ckOtherSetQgqg;

    /**
     * 紧急处置 深静脉置入
     */
    @BindView(R.id.other_set_sjmcz)
    CheckBox ckOtherSetSjmcz;

    /**
     * 紧急处置 心包穿刺
     */
    @BindView(R.id.other_set_xbcc)
    CheckBox ckOtherSetXbcc;

    /**
     * 紧急处置 腹穿
     */
    @BindView(R.id.other_set_fc)
    CheckBox ckOtherSetXfc;

    /**
     * 紧急处置 胸穿
     */
    @BindView(R.id.other_set_xc)
    CheckBox ckOtherSetXc;

    /**
     * 紧急处置  输血量
     */
    @BindView(R.id.take_out_blood)
    ItemEditBar ckOtherTakeBlood;

    /**
     * 紧急处置  血
     */
    @BindView(R.id.rg_blood)
    RadioGroup rgOtherTakeBlood;

    /**
     * 紧急处置  鲜红
     */
    @BindView(R.id.rb_blood_red)
    RadioButton rgOtherBloodRed;

    /**
     * 紧急处置  其他
     */
    @BindView(R.id.rb_blood_other)
    RadioButton rgOtherBlood;

    /**
     * 血液标本采集 配血
     */
    @BindView(R.id.take_blood_px)
    CheckBox ckTakeBloodPx;

    /**
     * 血液标本采集 凝血功能
     */
    @BindView(R.id.take_blood_nxgn)
    CheckBox ckTakeBloodNxgn;

    /**
     * 血液标本采集 血常规
     */
    @BindView(R.id.take_blood_xcg)
    CheckBox ckTakeBloodXcg;

    /**
     * 血液标本采集 血生化
     */
    @BindView(R.id.take_blood_xsh)
    CheckBox ckTakeBloodXsh;

    /**
     * 血液标本采集 肝肾功能
     */
    @BindView(R.id.take_blood_gsgn)
    CheckBox ckTakeBloodGsgn;

    /**
     * 血液标本采集 血糖
     */
    @BindView(R.id.take_blood_xt)
    CheckBox ckTakeBloodXt;

    /**
     * 血液标本采集 传染病
     */
    @BindView(R.id.take_blood_crb)
    CheckBox ckTakeBloodCrb;

    /**
     * 离开时间
     */
    @BindView(R.id.rrb_go_out_time)
    TextTimeBar ttbGoOutTime;

    /**
     * 离开意识
     */
    @BindView(R.id.go_out_eicuicuconsciousness)
    EditSpinner esbGoOutSignAware;

    /**
     * 病人去向
     */
    @BindView(R.id.where_to_go)
    EditSpinner esWhereToGo;

    /**
     * 保存
     */
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    /**
     * 血液设置
     */
    @BindView(R.id.ll_chest_puncture)
    LinearLayout llBloodLayout;

    String bloodSelect = "";

    String bloodSelectOther = "";

    boolean selectSetBooldXfc = false;

    boolean selectSetBooldXc = false;

    public static TraumaEicuInfoFragment newInstance(String recordId) {
        TraumaEicuInfoFragment fragment = new TraumaEicuInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(@NonNull View view) {
        esSignAware.setItemData(Arrays.asList(getResources().getStringArray(R.array.traumaEicuInfoBean_eicuicuconsciousness)));
        esbGoOutSignAware.setItemData(Arrays.asList(getResources().getStringArray(R.array.traumaEicuInfoBean_eicuicuconsciousness)));
        esWhereToGo.setItemData(Arrays.asList(getResources().getStringArray(R.array.traumaEicuInfoBean_where_to_go)));
        btnSave.setOnClickListener(v -> {
            setData();
        });

        ckOtherSetXfc.setOnClickListener(v -> {
            if (ckOtherSetXfc.isChecked()) {
                selectSetBooldXfc = true;
                llBloodLayout.setVisibility(View.VISIBLE);
            } else {
                selectSetBooldXfc = false;
                if (!selectSetBooldXc)
                    llBloodLayout.setVisibility(View.GONE);
            }
        });

        ckOtherSetXc.setOnClickListener(v -> {
            if (ckOtherSetXc.isChecked()) {
                selectSetBooldXc = true;
                llBloodLayout.setVisibility(View.VISIBLE);
            } else {
                selectSetBooldXc = false;
                if (!selectSetBooldXfc)
                    llBloodLayout.setVisibility(View.GONE);
            }
        });

        rgOtherTakeBlood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_blood_red) {
                    bloodSelect = rgOtherBloodRed.getText().toString();
                } else if (i == R.id.rb_blood_other) {
                    bloodSelectOther = rgOtherBlood.getText().toString();
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_eicu_info;
    }

    @Override
    protected void initListener() {

    }

    /**
     * 数据赋值
     */
    private void setData() {
        TraumaEicuInfoBean traumaEicuInfoBean = new TraumaEicuInfoBean();
        traumaEicuInfoBean.setEicuicupatientarrivaltime(ttbStartTime.getTime());
        traumaEicuInfoBean.setEicuicuconsciousness(esSignAware.getText());

        StringBuffer sbSetData = new StringBuffer();
        if (ckOtherSetHxjzc.isChecked()) {
            sbSetData.append(ckOtherSetHxjzc.getText().toString() + ",");
        }
        if (ckOtherSetBsyl.isChecked()) {
            sbSetData.append(ckOtherSetBsyl.getText().toString() + ",");
        }
        if (ckOtherSetQgqg.isChecked()) {
            sbSetData.append(ckOtherSetQgqg.getText().toString() + ",");
        }
        if (ckOtherSetXbcc.isChecked()) {
            sbSetData.append(ckOtherSetXbcc.getText().toString() + ",");
        }
        if (ckOtherSetSjmcz.isChecked()) {
            sbSetData.append(ckOtherSetSjmcz.getText().toString() + ",");
        }
        if (ckOtherSetXffs.isChecked()) {
            sbSetData.append(ckOtherSetXffs.getText().toString() + ",");
        }
        if (ckOtherSetQgcg.isChecked()) {
            sbSetData.append(ckOtherSetQgcg.getText().toString() + ",");
        }
        if (ckOtherSetXfc.isChecked()) {
            sbSetData.append(ckOtherSetXfc.getText().toString() + ",");
        }
        if (ckOtherSetXc.isChecked()) {
            sbSetData.append(ckOtherSetXc.getText().toString() + ",");
        }
        traumaEicuInfoBean.setEicuicuthoracentesisbloodvolume(ckOtherTakeBlood.getEditContent());
        traumaEicuInfoBean.setEicuicuperitoneocentesisbloodcolor(bloodSelect);
        traumaEicuInfoBean.setOthereicuicuperitoneocentesisbloodcolor(bloodSelectOther);

        StringBuffer sbTakeBloodData = new StringBuffer();

        if (ckTakeBloodNxgn.isChecked()) {
            sbSetData.append(ckTakeBloodNxgn.getText().toString() + ",");
        }
        if (ckTakeBloodXcg.isChecked()) {
            sbSetData.append(ckTakeBloodXcg.getText().toString() + ",");
        }
        if (ckTakeBloodXsh.isChecked()) {
            sbSetData.append(ckTakeBloodXsh.getText().toString() + ",");
        }
        if (ckTakeBloodGsgn.isChecked()) {
            sbSetData.append(ckTakeBloodGsgn.getText().toString() + ",");
        }
        if (ckTakeBloodXt.isChecked()) {
            sbSetData.append(ckTakeBloodXt.getText().toString() + ",");
        }
        if (ckTakeBloodCrb.isChecked()) {
            sbSetData.append(ckTakeBloodCrb.getText().toString() + ",");
        }
        if (ckTakeBloodPx.isChecked()) {
            sbSetData.append(ckTakeBloodPx.getText().toString() + ",");
        }
        traumaEicuInfoBean.setEiuciuccheckoutitems(sbTakeBloodData.toString());
        traumaEicuInfoBean.setEicuicuoutcomeinfomation(esWhereToGo.getText());
        traumaEicuInfoBean.setEicuicuemergencyprocessway(sbSetData.toString());
        traumaEicuInfoBean.setEicuiculeavetime(ttbGoOutTime.getTime());
        traumaEicuInfoBean.setEicuiculeaveconsciousness(esbGoOutSignAware.getText());
        traumaEicuInfoBean.setRecordId("1111");
        addFieldEvaluateScore(traumaEicuInfoBean);
    }


    /**
     * 保存数据
     *
     * @param traumaEicuInfoBean 数据
     */
    private void addFieldEvaluateScore(TraumaEicuInfoBean traumaEicuInfoBean) {
        String request = GsonUtils.getGson().toJson(traumaEicuInfoBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .addTraumaEicuInfo(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("修改成功");
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

    
    
       
    