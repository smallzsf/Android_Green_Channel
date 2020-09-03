package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;

/**
 * @ClassName: OriginalStatus1
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/3 0:05
 */
public class OriginalStatusFragment1 extends BaseFragment {

    public static OriginalStatusFragment1 newInstance() {
        OriginalStatusFragment1 fragment = new OriginalStatusFragment1();
//        Bundle args = new Bundle();
//        args.putString(IntentKey.PATIENT_ID, patientId);
//        args.putString(IntentKey.DOC_ID, docId);
//        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_status_1;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}
