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

    }

    private void initEvent() {

        mEsTitleSelect.setItemData(titles);
        mEsTitleSelect.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {

                switch (text) {
                    case "STEMI":

                        break;
                    case "NSTEMI":
                        break;
                    case "UA":
                        break;
                    case "主动脉夹层":
                        break;
                    case "肺动脉拴塞":
                        break;
                    case "非ACS心源性胸痛":
                        break;
                    case "其他非心源性胸痛":
                        break;
                    case "待查":
                        break;


                }
            }
        });
    }

    @Override
    protected void initListener() {

    }

 
}
