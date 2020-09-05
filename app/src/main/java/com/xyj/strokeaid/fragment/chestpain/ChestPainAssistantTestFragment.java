package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ChestPainDiseaseRecordFragment
 * description:  辅助检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainAssistantTestFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_od)
    SegmentTabLayout stlTitleFragOd;
    @BindView(R.id.et_major_complaint_frag)
    EditText etMajorComplaintFrag;
    @BindView(R.id.tfl_action_in_chief)
    TagFlowLayout tflActionInChief;
    @BindView(R.id.ll_emergency_ct)
    LinearLayout llEmergencyCt;
    @BindView(R.id.ll_ultrasound_color)
    LinearLayout llUltrasoundColor;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_vital_signs)
    LinearLayout llVitalSigns;
    private String mPatientId;
    private String mDocId;
    private List<String> list;

    private int titlePosition = 0;


    public ChestPainAssistantTestFragment() {

    }

    public static ChestPainAssistantTestFragment newInstance(String patientId, String docId) {
        ChestPainAssistantTestFragment fragment = new ChestPainAssistantTestFragment();
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
        return R.layout.fragment_assistant_test;
    }

    @Override
    protected void initView(@NonNull View view) {


        loadData();

        refrashTitleData();

    }

    private void refrashTitleData() {
        if (titlePosition == 0) {
            llEmergencyCt.setVisibility(View.VISIBLE);
            llUltrasoundColor.setVisibility(View.GONE);
        } else {
            llEmergencyCt.setVisibility(View.GONE);
            llUltrasoundColor.setVisibility(View.VISIBLE);
        }
    }


    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("清醒");
        list.add("对语言有反应");
        list.add("对刺激有反应");
        list.add("对任何刺激无反应");
//        esVitalSignAware.setItemData(list);
    }


    @Override
    protected void initListener() {
        stlTitleFragOd.setTabData(Constants.CHEST_OTHER_DISPOSAL_TITLES);
        stlTitleFragOd.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Log.e("zhangshifu", "" + position);
                titlePosition = position;
                refrashTitleData();
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

}