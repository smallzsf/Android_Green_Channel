package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ClassName: PatientSumFragment
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/2 19:10
 */
public class PatientSumFragment extends BaseFragment {


    List<String> titles = new ArrayList<>();
    @BindView(R.id.awareness)
    TextView mAwareness;
    @BindView(R.id.es_title_select)
    EditSpinner mEsTitleSelect;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;

    private PatientStatusFragment1 mPatientFragment1 = null;
    private PatientStatusFragment2 mPatientFragment2 = null;
    private PatientStatusFragment3 mPatientFragment3 = null;
    private PatientStatusFragment4 mPatientFragment4 = null;

    public static PatientSumFragment newInstance(String patientId, String docId) {
        PatientSumFragment fragment = new PatientSumFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_patient_sum;
    }

    @Override
    protected void initView(@NonNull View view) {

        initview();
        initData();
        initEvent();

    }

    private void initview() {
        // 默认显示第一个
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        mPatientFragment1 = PatientStatusFragment1.newInstance("STEMI");
        ft.add(R.id.fl_main, mPatientFragment1).commitNow();
    }

    private void initData() {
        titles.add("STEMI");
        titles.add("NSTEMI");
        titles.add("UA");
        titles.add("主动脉夹层");
        titles.add("肺动脉栓塞");
        titles.add("非ACS心源性胸痛");
        titles.add("其他非心源性胸痛");
        mEsTitleSelect.setItemData(titles);
    }

    private void initEvent() {


        mEsTitleSelect.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                selectFragment(text);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    /**
     * 根据ID选择碎片的方法
     *
     * @param type
     */
    private void selectFragment(String type) {
        //创建碎片事务管理  每一次碎片的显示与隐藏都要通过事务管理来操作
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        //操作：碎片为空 创建添加
        //     碎片不为空，直接显示
        hideFragment(ft);
        switch (type) {
            case "STEMI":
            case "NSTEMI":
            case "UA":
                if (mPatientFragment1 == null) {//为空，创建
                    mPatientFragment1 = PatientStatusFragment1.newInstance(type);//创建
                    ft.add(R.id.fl_main, mPatientFragment1);//将碎片添加到专门存放碎片的容器中
                } else {
                    ft.show(mPatientFragment1);//不为空，直接显示
                }
                break;
            case "主动脉夹层":
            case "肺动脉栓塞":
                if (mPatientFragment2 == null) {//为空，创建
                    mPatientFragment2 = PatientStatusFragment2.newInstance(type);//创建
                    ft.add(R.id.fl_main, mPatientFragment2);//将碎片添加到专门存放碎片的容器中
                } else {
                    ft.show(mPatientFragment2);//不为空，直接显示
                }
                break;
            case "非ACS心源性胸痛":
                if (mPatientFragment3 == null) {//为空，创建
                    mPatientFragment3 = PatientStatusFragment3.newInstance(type);//创建
                    ft.add(R.id.fl_main, mPatientFragment3);//将碎片添加到专门存放碎片的容器中
                } else {
                    ft.show(mPatientFragment3);//不为空，直接显示
                }
                break;
            case "其他非心源性胸痛":
                if (mPatientFragment4 == null) {//为空，创建
                    mPatientFragment4 = PatientStatusFragment4.newInstance(type);//创建
                    ft.add(R.id.fl_main, mPatientFragment4);//将碎片添加到专门存放碎片的容器中
                } else {
                    ft.show(mPatientFragment4);//不为空，直接显示
                }
                break;
            default:
                break;
        }
        ft.commitAllowingStateLoss();//提交
    }

    /**
     * 隐藏所有碎片的方法
     *
     * @param ft
     */
    private void hideFragment(FragmentTransaction ft) {
        if (mPatientFragment1 != null) {
            ft.hide(mPatientFragment1);
        }
        if (mPatientFragment2 != null) {
            ft.hide(mPatientFragment2);
        }
        if (mPatientFragment3 != null) {
            ft.hide(mPatientFragment3);
        }
        if (mPatientFragment4 != null) {
            ft.hide(mPatientFragment4);
        }
        ft.commitNow();
    }
}
