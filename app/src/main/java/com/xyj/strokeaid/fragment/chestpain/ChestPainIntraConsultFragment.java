package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  心内会诊
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainIntraConsultFragment extends BaseFragment {
/*
    @BindView(R.id.stl_title_frag_od)
    SegmentTabLayout stlTitleFragOd;*/
    @BindView(R.id.es_vital_sign_aware)
    EditSpinner esVitalSignAware;
    @BindView(R.id.rb_on_site_consultation)
    RadioButton rbOnSiteConsultation;
    @BindView(R.id.rb_remote_consultation)
    RadioButton rbRemoteConsultation;
    @BindView(R.id.rg_consultation)
    RadioGroup rgConsultation;
    @BindView(R.id.ttb_arrival_time)
    TextTimeBar ttbArrivalTime;
    @BindView(R.id.ll_intrac_consult_in)
    LinearLayout llIntracConsultIn;
    @BindView(R.id.es_vital_sign_aware_out)
    EditSpinner esVitalSignAwareOut;
    @BindView(R.id.rb_on_site_consultation_out)
    RadioButton rbOnSiteConsultationOut;
    @BindView(R.id.rb_remote_consultation_out)
    RadioButton rbRemoteConsultationOut;
    @BindView(R.id.rg_consultation_out)
    RadioGroup rgConsultationOut;
    @BindView(R.id.ttb_arrival_time_out)
    TextTimeBar ttbArrivalTimeOut;
    @BindView(R.id.ll_intrac_consult_out)
    LinearLayout llIntracConsultOut;
  /*  @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;*/
    @BindView(R.id.ll_auxiliary_exam)
    LinearLayout llAuxiliaryExam;
    private String mPatientId;
    private String mDocId;

    private int titlePosition = 0;

    public ChestPainIntraConsultFragment() {

    }

    public static ChestPainIntraConsultFragment newInstance(String patientId, String docId) {
        ChestPainIntraConsultFragment fragment = new ChestPainIntraConsultFragment();
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
        return R.layout.fragment_intrac_consult;
    }

    @Override
    protected void initView(@NonNull View view) {
        refrashArrivalTimeVis();
        loadData();
    }


    private void loadData() {

       /* btnConfirm.setText("保存");
        btnCancel.setText("一键启动绿色通道");*/

        ArrayList<String> itemData = new ArrayList<>();
        itemData.add("1");
        itemData.add("2");
        itemData.add("3");
        esVitalSignAware.setItemData(itemData);
        esVitalSignAwareOut.setItemData(itemData);
       // refrashTitleData();
    }


    @Override
    protected void initListener() {
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                refrashArrivalTimeVis();
            }
        };
        rgConsultation.setOnCheckedChangeListener(onCheckedChangeListener);
        rgConsultationOut.setOnCheckedChangeListener(onCheckedChangeListener);


      /*  stlTitleFragOd.setTabData(Constants.CHEST_HEART_IN_OUT_TITLES);
        stlTitleFragOd.setCurrentTab(titlePosition);
        stlTitleFragOd.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Log.e("zhangshifu", "" + position);
                titlePosition = position;
                refrashTitleData();
                refrashArrivalTimeVis();
            }


            @Override
            public void onTabReselect(int position) {

            }
        });
*/
    }

    private void refrashTitleData() {
        if (titlePosition == 0) {
            llIntracConsultIn.setVisibility(View.VISIBLE);
            llIntracConsultOut.setVisibility(View.GONE);
        } else {
            llIntracConsultIn.setVisibility(View.GONE);
            llIntracConsultOut.setVisibility(View.VISIBLE);
        }
    }

    private void refrashArrivalTimeVis() {
        boolean isChecked = false;
        View view;
        if (titlePosition == 0) {
            isChecked = rbOnSiteConsultation.isChecked();
            view = ttbArrivalTime;
        } else {
            isChecked = rbOnSiteConsultationOut.isChecked();
            view = ttbArrivalTimeOut;
        }
        if (isChecked) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}