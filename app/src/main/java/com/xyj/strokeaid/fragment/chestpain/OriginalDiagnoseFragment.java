package com.xyj.strokeaid.fragment.chestpain;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ClassName: OriginalDiagnoseFragment
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/2 19:09
 */
public class OriginalDiagnoseFragment extends BaseFragment {


    @BindView(R.id.awareness)
    TextView mAwareness;
    @BindView(R.id.es_title_select)
    EditSpinner mEsTitleSelect;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    List<String> titles = new ArrayList<>();

    private OriginalStatusFragment1 mOriginalStatusFragment1 = null;
    private OriginalStatusFragment2 mOriginalStatusFragment2 = null;
    private OriginalStatusFragment3 mOriginalStatusFragment3 = null;
    private OriginalStatusFragment4 mOriginalStatusFragment4 = null;
    private OriginalStatusFragment5 mOriginalStatusFragment5 = null;
    private OriginalStatusFragment6 mOriginalStatusFragment6 = null;
    private OriginalStatusFragment7 mOriginalStatusFragment7 = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_diagnose;
    }

    @Override
    protected void initView(@NonNull View view) {

        initview();
        initData();
        initEvent();

    }

    private void initview() {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        mOriginalStatusFragment1 = OriginalStatusFragment1.newInstance("STEMI");
        ft.add(R.id.fl_main, mOriginalStatusFragment1).commitNow();
    }

    private void initData() {
        titles.add("STEMI");
        titles.add("NSTEMI");
        titles.add("UA");
        titles.add("主动脉夹层");
        titles.add("肺动脉拴塞");
        titles.add("非ACS心源性胸痛");
        titles.add("其他非心源性胸痛");
        titles.add("待查");
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

    //根据ID选择碎片的方法
    private void selectFragment(String type){
        //创建碎片事务管理  每一次碎片的显示与隐藏都要通过事务管理来操作
        FragmentTransaction ft=getChildFragmentManager().beginTransaction();
        //操作：碎片为空 创建添加
        //     碎片不为空，直接显示
        hideFragment(ft);
        switch (type) {
            case "STEMI":
                if(mOriginalStatusFragment1==null){//为空，创建
                    mOriginalStatusFragment1=OriginalStatusFragment1.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment1);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment1);//不为空，直接显示
                }
                break;
            case "NSTEMI":
                if(mOriginalStatusFragment2==null){//为空，创建
                    mOriginalStatusFragment2=OriginalStatusFragment2.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment2);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment2);//不为空，直接显示
                }
                break;
            case "UA":
                if(mOriginalStatusFragment3==null){//为空，创建
                    mOriginalStatusFragment3=OriginalStatusFragment3.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment3);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment3);//不为空，直接显示
                }
                break;
            case "主动脉夹层":
                if(mOriginalStatusFragment4==null){//为空，创建
                    mOriginalStatusFragment4=OriginalStatusFragment4.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment4);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment4);//不为空，直接显示
                }
                break;
            case "肺动脉拴塞":
                if(mOriginalStatusFragment5==null){//为空，创建
                    mOriginalStatusFragment5=OriginalStatusFragment5.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment5);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment5);//不为空，直接显示
                }
                break;
            case "非ACS心源性胸痛":
                if(mOriginalStatusFragment6==null){//为空，创建
                    mOriginalStatusFragment6=OriginalStatusFragment6.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment6);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment6);//不为空，直接显示
                }
                break;
            case "其他非心源性胸痛":
                if(mOriginalStatusFragment7==null){//为空，创建
                    mOriginalStatusFragment7=OriginalStatusFragment7.newInstance(type);//创建
                    ft.add(R.id.fl_main, mOriginalStatusFragment7);//将碎片添加到专门存放碎片的容器中
                }else{
                    ft.show(mOriginalStatusFragment7);//不为空，直接显示
                }
                break;
            case "待查":
//                if(mOriginalStatusFragment1==null){//为空，创建
//                    mOriginalStatusFragment1=new OriginalStatusFragment1();//创建
//                    ft.add(R.id.fl_main, mOriginalStatusFragment1);//将碎片添加到专门存放碎片的容器中
//                }else{
//                    ft.show(mOriginalStatusFragment1);//不为空，直接显示
//                }
                break;
            default:
                break;
        }

        ft.commitAllowingStateLoss();//提交
    }

    //隐藏所有碎片的方法
    private void hideFragment(FragmentTransaction ft){
//        FragmentTransaction ft=getChildFragmentManager().beginTransaction();
        if(mOriginalStatusFragment1!=null){
            ft.hide(mOriginalStatusFragment1);
        }
        if(mOriginalStatusFragment2!=null){
            ft.hide(mOriginalStatusFragment2);
        }
        if(mOriginalStatusFragment3!=null){
            ft.hide(mOriginalStatusFragment3);
        }
        if(mOriginalStatusFragment4!=null){
            ft.hide(mOriginalStatusFragment4);
        }
        if(mOriginalStatusFragment5!=null){
            ft.hide(mOriginalStatusFragment5);
        }
        if(mOriginalStatusFragment6!=null){
            ft.hide(mOriginalStatusFragment6);
        }
        if(mOriginalStatusFragment7!=null){
            ft.hide(mOriginalStatusFragment7);
        }
        ft.commitAllowingStateLoss();
    }
}
