package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.IntraConsultBean;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  心内会诊
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainIntraConsultFragment extends BaseFragment {

    @BindView(R.id.rb_cardiology_site)
    RadioButton rbCardiologySite;
    @BindView(R.id.rb_cardiology_remote)
    RadioButton rbCardiologyRemote;
    @BindView(R.id.rb_cardiology_no)
    RadioButton rbCardiologyNo;
    @BindView(R.id.rg_cardiology)
    RadioGroup rgCardiology;
    @BindView(R.id.es_cardiology_proposer)
    EditSpinner esCardiologyProposer;
    @BindView(R.id.ttb_cardiology_proposer_time)
    TextTimeBar ttbCardiologyProposerTime;
    @BindView(R.id.es_cardiology_doc)
    EditSpinner esCardiologyDoc;
    @BindView(R.id.ttb_cardiology_doc_arrive)
    TextTimeBar ttbCardiologyDocArrive;
    @BindView(R.id.ll_cardiology)
    LinearLayout llCardiology;
    @BindView(R.id.rb_cardial_surgery_site)
    RadioButton rbCardialSurgerySite;
    @BindView(R.id.rb_cardial_surgery_remote)
    RadioButton rbCardialSurgeryRemote;
    @BindView(R.id.rb_cardial_surgery_no)
    RadioButton rbCardialSurgeryNo;
    @BindView(R.id.rg_cardial_surgery)
    RadioGroup rgCardialSurgery;
    @BindView(R.id.es_cardial_surgery_proposer)
    EditSpinner esCardialSurgeryProposer;
    @BindView(R.id.ttb_cardial_surgery_proposer_time)
    TextTimeBar ttbCardialSurgeryProposerTime;
    @BindView(R.id.es_cardial_surgery_doc)
    EditSpinner esCardialSurgeryDoc;
    @BindView(R.id.ttb_cardial_surgery_doc_arrive)
    TextTimeBar ttbCardialSurgeryDocArrive;
    @BindView(R.id.ll_cardial_surgery)
    LinearLayout llCardialSurgery;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    private String mRecordId;
    private IntraConsultBean mIntraConsultBean;

    public ChestPainIntraConsultFragment() {

    }

    public static ChestPainIntraConsultFragment newInstance(String recordId) {
        ChestPainIntraConsultFragment fragment = new ChestPainIntraConsultFragment();
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
    protected int getLayoutId() {
        return R.layout.fragment_intrac_consult;
    }

    @Override
    protected void initView(@NonNull View view) {
        showLoadingDialog();
        loadDocData();
        loadRecordData(mRecordId);
    }


    private void loadDocData() {
        // 获取心内科医生列表
        // 获取心外科医生列表
        // 获取护士列表
        // TODO: 2020/9/8 测试用假数据
        ArrayList<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("张三丰");
        names.add("小昭");
        esCardialSurgeryDoc.setItemData(names);
        esCardialSurgeryProposer.setItemData(names);
        esCardiologyDoc.setItemData(names);
        esCardiologyProposer.setItemData(names);
    }

    private void loadRecordData(String recordId) {
        if (TextUtils.isEmpty(recordId)) {
            return;
        }
        RecordIdBean recordIdBean = new RecordIdBean(recordId);
        RetrofitClient.getInstance().getApi()
                .getChestPainIntraConsult(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<IntraConsultBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<IntraConsultBean>> call, Response<BaseObjectBean<IntraConsultBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mIntraConsultBean = response.body().getData();
                                if (mIntraConsultBean != null) {
                                    // 请求成功
                                    // 填充页面
                                    setDataToView(mIntraConsultBean);
                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<IntraConsultBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    private void setDataToView(IntraConsultBean intraConsultBean) {
        if (intraConsultBean == null) {
            return;
        }
        // 心内科
        if (!TextUtils.isEmpty(intraConsultBean.getInternalmedicineconsultation())) {
            if (intraConsultBean.getInternalmedicineconsultation().contains("cpc_internalMedicine_no")) {
                llCardiology.setVisibility(View.GONE);
                rgCardiology.check(R.id.rb_cardiology_no);
            } else {
                llCardiology.setVisibility(View.VISIBLE);
                if (intraConsultBean.getInternalmedicineconsultation().contains("cpc_internalMedicine_scene")) {
                    // 现场
                    rgCardiology.check(R.id.rb_cardiology_site);
                } else if (intraConsultBean.getInternalmedicineconsultation().contains("cpc_internalMedicine_longDistance")) {
                    // 远程
                    rgCardiology.check(R.id.rb_cardiology_remote);
                }
                // 申请人
                esCardiologyProposer.setText(mIntraConsultBean.getInternalmedicineconsultationapplicantid());
                // 申请时间
                ttbCardiologyProposerTime.setTime(mIntraConsultBean.getInternalmedicinenotifiedconsultationtime());
                // 心内科医生
                esCardiologyDoc.setText(mIntraConsultBean.getInternalmedicineconsultationdoctorid());
                // 会诊时间
                ttbCardiologyDocArrive.setTime(mIntraConsultBean.getInternalmedicineconsultationtime());
            }
        }
        if (!TextUtils.isEmpty(intraConsultBean.getSurgeryconsultation())) {
            // 心外科
            if (intraConsultBean.getSurgeryconsultation().contains("cpc_surgery_no")) {
                llCardialSurgery.setVisibility(View.GONE);
                rgCardialSurgery.check(R.id.rb_cardial_surgery_no);
            } else {
                llCardialSurgery.setVisibility(View.VISIBLE);
                if (intraConsultBean.getSurgeryconsultation().contains("cpc_surgery_scene")) {
                    // 现场
                    rgCardialSurgery.check(R.id.rb_cardial_surgery_site);
                } else if (intraConsultBean.getSurgeryconsultation().contains("cpc_surgery_longDistance")) {
                    // 远程
                    rgCardialSurgery.check(R.id.rb_cardial_surgery_remote);
                }

                // 申请人
                esCardialSurgeryProposer.setText(mIntraConsultBean.getSurgeryconsultationapplicantid());
                // 申请时间
                ttbCardialSurgeryProposerTime.setTime(mIntraConsultBean.getSurgerynotifiedconsultationtime());
                // 心外科医生
                esCardialSurgeryDoc.setText(mIntraConsultBean.getSurgeryconsultationdoctorid());
                // 会诊时间
                ttbCardialSurgeryDocArrive.setTime(mIntraConsultBean.getSurgeryconsultationtime());
            }
        }
    }


    @Override
    protected void initListener() {
        rgCardiology.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_cardiology_no) {
                    llCardiology.setVisibility(View.GONE);
                } else {
                    llCardiology.setVisibility(View.VISIBLE);
                }
            }
        });

        rgCardialSurgery.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_cardial_surgery_no) {
                    llCardialSurgery.setVisibility(View.GONE);
                } else {
                    llCardialSurgery.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preSave();
            }

        });
    }


    private void preSave() {
        if (mIntraConsultBean == null) {
            mIntraConsultBean = new IntraConsultBean();
        }
        mIntraConsultBean.setRecordId(mRecordId);
        // 心内科
        if (rgCardiology.getCheckedRadioButtonId() == R.id.rb_cardiology_no) {
            // 无会诊
            mIntraConsultBean.setInternalmedicineconsultation("cpc_internalMedicine_no");
        } else {
            if (rgCardiology.getCheckedRadioButtonId() == R.id.rb_cardiology_site) {
                // 现场
                mIntraConsultBean.setInternalmedicineconsultation("cpc_internalMedicine_scene");
            } else if (rgCardiology.getCheckedRadioButtonId() == R.id.rb_cardiology_remote) {
                // 远程
                mIntraConsultBean.setInternalmedicineconsultation("cpc_internalMedicine_longDistance");
            }
            // 申请人
            mIntraConsultBean.setInternalmedicineconsultationapplicantid(esCardiologyProposer.getText());
            // 申请时间
            mIntraConsultBean.setInternalmedicinenotifiedconsultationtime(ttbCardiologyProposerTime.getTime());
            // 心内科医生
            mIntraConsultBean.setInternalmedicineconsultationdoctorid(esCardiologyDoc.getText());
            // 会诊时间
            mIntraConsultBean.setInternalmedicineconsultationtime(ttbCardiologyDocArrive.getTime());
        }
        // 心外科
        if (rgCardialSurgery.getCheckedRadioButtonId() == R.id.rb_cardial_surgery_no) {
            // 无会诊
            mIntraConsultBean.setSurgeryconsultation("cpc_surgery_no");
        } else {
            if (rgCardialSurgery.getCheckedRadioButtonId() == R.id.rb_cardial_surgery_site) {
                // 现场
                mIntraConsultBean.setSurgeryconsultation("cpc_surgery_scene");
            } else if (rgCardialSurgery.getCheckedRadioButtonId() == R.id.rb_cardial_surgery_remote) {
                // 远程
                mIntraConsultBean.setSurgeryconsultation("cpc_surgery_longDistance");
            }
            // 申请人
            mIntraConsultBean.setSurgeryconsultationapplicantid(esCardialSurgeryProposer.getText());
            // 申请时间
            mIntraConsultBean.setSurgerynotifiedconsultationtime(ttbCardialSurgeryProposerTime.getTime());
            // 心外科医生
            mIntraConsultBean.setSurgeryconsultationdoctorid(esCardialSurgeryDoc.getText());
            // 会诊时间
            mIntraConsultBean.setSurgeryconsultationtime(ttbCardialSurgeryDocArrive.getTime());
        }
        doSave();
    }

    /**
     * 保存
     */
    private void doSave() {
        showLoadingDialog();
        RetrofitClient.getInstance()
                .getApi()
                .saveChestPainIntraConsult(mIntraConsultBean.getResuestBody(mIntraConsultBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
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

}