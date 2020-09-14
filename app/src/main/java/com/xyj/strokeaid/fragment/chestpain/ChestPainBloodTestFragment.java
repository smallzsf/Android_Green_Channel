package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainBloodTestBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  血液检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainBloodTestFragment extends BaseStrokeFragment implements View.OnClickListener {


    @BindView(R.id.rb_troponin_tnt_first)
    RadioButton rbTroponinTntFirst;
    @BindView(R.id.rb_troponin_tnl_first)
    RadioButton rbTroponinTnlFirst;
    @BindView(R.id.ll_troponin_first)
    LinearLayout llTroponinFirst;
    @BindView(R.id.rb_troponin_tnt_two)
    RadioButton rbTroponinTntTwo;
    @BindView(R.id.rb_troponin_tnl_two)
    RadioButton rbTroponinTnlTwo;
    @BindView(R.id.ll_troponin_two)
    LinearLayout llTroponinTwo;
    @BindView(R.id.rb_troponin_tnt_three)
    RadioButton rbTroponinTntThree;
    @BindView(R.id.rb_troponin_tnl_three)
    RadioButton rbTroponinTnlThree;
    @BindView(R.id.ll_troponin_three)
    LinearLayout llTroponinThree;
    @BindView(R.id.ll_troponin_data)
    LinearLayout llTroponinData;
    @BindView(R.id.ll_dimer_title)
    LinearLayout llDimerTitle;
    @BindView(R.id.ll_dimer_data)
    LinearLayout llDimerData;
    @BindView(R.id.ll_bnp_title)
    LinearLayout llBnpTitle;
    @BindView(R.id.ll_bnp_data)
    LinearLayout llBnpData;
    @BindView(R.id.ll_nt_probnp_title)
    LinearLayout llNtProbnpTitle;
    @BindView(R.id.ll_nt_probnp_data)
    LinearLayout llNtProbnpData;
    @BindView(R.id.ll_myo_title)
    LinearLayout llMyoTitle;
    @BindView(R.id.ll_myo_data)
    LinearLayout llMyoData;
    @BindView(R.id.ll_ckmb_title)
    LinearLayout llCkmbTitle;
    @BindView(R.id.ll_ckmb_data)
    LinearLayout llCkmbData;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;
    @BindView(R.id.iv_add_troponin)
    ImageView ivAddTroponin;
    @BindView(R.id.iv_delete_troponin_1)
    ImageView ivDeleteTroponin1;
    @BindView(R.id.iv_delete_troponin_2)
    ImageView ivDeleteTroponin2;
    @BindView(R.id.sv_troponin)
    SwitchCompat svTroponin;
    @BindView(R.id.sv_dimer)
    SwitchCompat svDimer;
    @BindView(R.id.sv_bnp)
    SwitchCompat svBnp;
    @BindView(R.id.sv_nt_probnp)
    SwitchCompat svNtProbnp;
    @BindView(R.id.sv_myo)
    SwitchCompat svMyo;
    @BindView(R.id.sv_ckmb)
    SwitchCompat svCkmb;
    @BindView(R.id.et_troponin_first)
    EditText etTroponinFirst;
    @BindView(R.id.eds_troponin_unit_first)
    EditSpinner edsTroponinUnitFirst;
    @BindView(R.id.eds_yin_yang_first)
    EditSpinner edsYinYangFirst;
    @BindView(R.id.ttb_draw_blood_time_first)
    TextTimeBar ttbDrawBloodTimeFirst;
    @BindView(R.id.ttb_report_time_first)
    TextTimeBar ttbReportTimeFirst;
    @BindView(R.id.et_troponin_two)
    EditText etTroponinTwo;
    @BindView(R.id.eds_troponin_unit_two)
    EditSpinner edsTroponinUnitTwo;
    @BindView(R.id.eds_yin_yang_two)
    EditSpinner edsYinYangTwo;
    @BindView(R.id.ttb_draw_blood_time_two)
    TextTimeBar ttbDrawBloodTimeTwo;
    @BindView(R.id.ttb_report_time_two)
    TextTimeBar ttbReportTimeTwo;
    @BindView(R.id.et_troponin_three)
    EditText etTroponinThree;
    @BindView(R.id.eds_troponin_unit_three)
    EditSpinner edsTroponinUnitThree;
    @BindView(R.id.eds_yin_yang_three)
    EditSpinner edsYinYangThree;
    @BindView(R.id.ttb_draw_blood_time_three)
    TextTimeBar ttbDrawBloodTimeThree;
    @BindView(R.id.ttb_report_time_three)
    TextTimeBar ttbReportTimeThree;
    @BindView(R.id.et_dimer_value)
    EditText etDimerValue;
    @BindView(R.id.eds_dimer)
    EditSpinner edsDimer;
    @BindView(R.id.et_bnp)
    EditText etBnp;
    @BindView(R.id.et_nt_probnp)
    EditText etNtProbnp;
    @BindView(R.id.et_myo_value)
    EditText etMyoValue;
    @BindView(R.id.eds_myo_unit)
    EditSpinner edsMyoUnit;
    @BindView(R.id.et_ckmb_value)
    EditText etCkmbValue;
    @BindView(R.id.eds_ckmb_unit)
    EditSpinner edsCkmbUnit;
    @BindView(R.id.sv_serum_creatinine)
    SwitchCompat svSerumCreatinine;
    @BindView(R.id.et_serum_creatinine)
    EditText etSerumCreatinine;
    @BindView(R.id.ll_serum_creatinine_data)
    LinearLayout llSerumCreatinineData;
    private int troponinDataNum = 1;

    public static ChestPainBloodTestFragment newInstance(String recordId) {
        ChestPainBloodTestFragment fragment = new ChestPainBloodTestFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chest_pain_blood_test;
    }

    @Override
    protected void initView(@NonNull View view) {
        initSpinner();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void initSpinner() {

        edsCkmbUnit.setStringArrayId(R.array.ckmb_unit);
        edsMyoUnit.setStringArrayId(R.array.myo_unit);
        edsDimer.setStringArrayId(R.array.ddimer_unit);

        edsYinYangFirst.setStringArrayId(R.array.tn_status);
        edsTroponinUnitFirst.setStringArrayId(R.array.tn_unit);

        edsYinYangThree.setStringArrayId(R.array.tn_status);
        edsTroponinUnitThree.setStringArrayId(R.array.tn_unit);

        edsYinYangTwo.setStringArrayId(R.array.tn_status);
        edsTroponinUnitTwo.setStringArrayId(R.array.tn_unit);

    }

    private void loadData() {
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(mRecordId);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainBloodText(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("zhangshifu", "onResponse");
                        hideLoadingDialog();

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    @Override
    protected void initListener() {
        svTroponin.setOnClickListener(this);
        svSerumCreatinine.setOnClickListener(this);
        svDimer.setOnClickListener(this);
        svBnp.setOnClickListener(this);
        svNtProbnp.setOnClickListener(this);
        svMyo.setOnClickListener(this);
        svCkmb.setOnClickListener(this);
        llBnpTitle.setOnClickListener(this);
        llMyoTitle.setOnClickListener(this);
        llNtProbnpTitle.setOnClickListener(this);
        llDimerTitle.setOnClickListener(this);
        llCkmbTitle.setOnClickListener(this);
        ivAddTroponin.setOnClickListener(this);
        ivDeleteTroponin1.setOnClickListener(this);
        ivDeleteTroponin2.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sv_troponin:
                refrashItemVis(llTroponinData, svTroponin);
                break;
            case R.id.sv_serum_creatinine:
                refrashItemVis(llSerumCreatinineData, svSerumCreatinine);
                break;
            case R.id.sv_bnp:
                refrashItemVis(llBnpData, svBnp);
                break;
            case R.id.sv_myo:
                refrashItemVis(llMyoData, svMyo);
                break;
            case R.id.sv_nt_probnp:
                refrashItemVis(llNtProbnpData, svNtProbnp);
                break;
            case R.id.sv_dimer:
                refrashItemVis(llDimerData, svDimer);
                break;
            case R.id.sv_ckmb:
                refrashItemVis(llCkmbData, svCkmb);
                break;
            case R.id.iv_add_troponin:
                troponinDataNum++;
                refrashRecordItem();
                break;
            case R.id.iv_delete_troponin_1:
                troponinDataNum--;
                llTroponinTwo.setVisibility(View.GONE);
                break;
            case R.id.iv_delete_troponin_2:
                troponinDataNum--;
                llTroponinThree.setVisibility(View.GONE);
                break;
            case R.id.btn_get_data:

                break;
            case R.id.btn_confirm:// 确定
                save();
                break;
        }
    }

    public void save() {
        ChestPainBloodTestBean bean = new ChestPainBloodTestBean();
        if (svCkmb.isChecked()) {
            List<ChestPainBloodTestBean.TnarrayBean> tnarray = bean.getTnarray();

            if (tnarray == null) {
                tnarray = new ArrayList<>();
            }
            ChestPainBloodTestBean.TnarrayBean tnarrayBean = null;
            if (troponinDataNum > 0) {
                tnarrayBean = new ChestPainBloodTestBean.TnarrayBean();
                // 抽血完成时间
                tnarrayBean.setPoctdrawbloodtime(ttbDrawBloodTimeFirst.getTime());
                // 报告完成时间
                tnarrayBean.setPoctreporttime(ttbReportTimeFirst.getTime());
                tnarrayBean.setTnunit(edsTroponinUnitFirst.getSelectData()[0]);
                tnarrayBean.setTnstatus(edsYinYangFirst.getSelectData()[0]);
                if (rbTroponinTnlFirst.isChecked()) {
                    tnarrayBean.setTnunit("cpc_tntype_tni");
                } else {
                    tnarrayBean.setTnunit("cpc_tntype_tnt");
                }
                tnarray.add(tnarrayBean);
            }
            if (troponinDataNum > 1) {
                tnarrayBean = new ChestPainBloodTestBean.TnarrayBean();
                // 抽血完成时间
                tnarrayBean.setPoctdrawbloodtime(ttbDrawBloodTimeTwo.getTime());
                // 报告完成时间
                tnarrayBean.setPoctreporttime(ttbReportTimeTwo.getTime());
                tnarrayBean.setTnunit(edsTroponinUnitTwo.getSelectData()[0]);
                tnarrayBean.setTnstatus(edsYinYangTwo.getSelectData()[0]);
                if (rbTroponinTnlTwo.isChecked()) {
                    tnarrayBean.setTnunit("cpc_tntype_tni");
                } else {
                    tnarrayBean.setTnunit("cpc_tntype_tnt");
                }
                tnarray.add(tnarrayBean);
            }
            if (troponinDataNum > 2) {
                tnarrayBean = new ChestPainBloodTestBean.TnarrayBean();
                // 抽血完成时间
                tnarrayBean.setPoctdrawbloodtime(ttbDrawBloodTimeThree.getTime());
                // 报告完成时间
                tnarrayBean.setPoctreporttime(ttbReportTimeThree.getTime());
                tnarrayBean.setTnunit(edsTroponinUnitThree.getSelectData()[0]);
                tnarrayBean.setTnstatus(edsYinYangThree.getSelectData()[0]);
                if (rbTroponinTnlThree.isChecked()) {
                    tnarrayBean.setTnunit("cpc_tntype_tni");
                } else {
                    tnarrayBean.setTnunit("cpc_tntype_tnt");
                }
                tnarray.add(tnarrayBean);
            }
            bean.setTnarray(tnarray);
        }
//        血清肌酐
        if (svSerumCreatinine.isChecked()) {
            String trim = etSerumCreatinine.getText().toString().trim();
            bean.setIscr(Constants.BOOL_TRUE);
            bean.setCrvalue(trim);
        } else {
            bean.setIscr(Constants.BOOL_FALSE);
        }
        // 二聚体
        if (svDimer.isChecked()) {
            bean.setIsddimer(Constants.BOOL_TRUE);
            String trim = etDimerValue.getText().toString().trim();
            bean.setDdimervalue(trim);
            bean.setDdimerunit(edsDimer.getSelectData()[0]);
        } else {
            bean.setIsddimer(Constants.BOOL_FALSE);
        }

        if (svBnp.isChecked()) {
            bean.setIsbnp(Constants.BOOL_TRUE);
            String trim = etBnp.getText().toString().trim();
            bean.setBnpvalue(trim);
        } else {
            bean.setIsbnp(Constants.BOOL_FALSE);
        }

        if (svNtProbnp.isChecked()) {
            bean.setIsntprobnp(Constants.BOOL_TRUE);
            String trim = etBnp.getText().toString().trim();
            bean.setNtprobnpvalue(trim);
        } else {
            bean.setIsntprobnp(Constants.BOOL_FALSE);
        }

        if (svMyo.isChecked()) {
            bean.setIsmyo(Constants.BOOL_TRUE);
            String trim = etMyoValue.getText().toString().trim();
            bean.setMyovalue(trim);
            bean.setMyounit(edsMyoUnit.getSelectData()[0]);
        } else {
            bean.setIsmyo(Constants.BOOL_FALSE);
        }
        if (svCkmb.isChecked()) {
            bean.setIsckmb(Constants.BOOL_TRUE);
            String trim = etCkmbValue.getText().toString().trim();
            bean.setCkmbvalue(trim);
            bean.setCkmbunit(edsCkmbUnit.getSelectData()[0]);
        } else {
            bean.setIsckmb(Constants.BOOL_FALSE);
        }
        this.save(bean);
    }

    /**
     * 保存数据接口调用成功
     *
     * @param bean
     */
    public void save(ChestPainBloodTestBean bean) {
        showLoadingDialog();
        bean.setRecordId(mRecordId);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .postChestPainLaboraoryExamination(bean.getResuestBody(bean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response != null && response.body() != null) {
                            BaseObjectBean body = response.body();
                            if (body.getResult() == 1) {
                                showToast("数据保存成功");
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


    private void refrashItemVis(View view, SwitchCompat switchCompat) {
        if (switchCompat.isChecked()) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    private void refrashRecordItem() {
        refrashRecordItem(llTroponinTwo, 2);
        refrashRecordItem(llTroponinThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (troponinDataNum >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}