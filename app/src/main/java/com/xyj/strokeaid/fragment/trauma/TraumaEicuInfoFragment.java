package com.xyj.strokeaid.fragment.trauma;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;

/**
 * StrokeScoresFragment
 * description: EICU/ICU 信息
 *
 * @author : Licy
 * @date : 2020/8/25
 * email ：licy3051@qq.com
 */
public class TraumaEicuInfoFragment extends BaseStrokeFragment {

    public static TraumaEicuInfoFragment newInstance(String recordId) {
        TraumaEicuInfoFragment fragment = new TraumaEicuInfoFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(@NonNull View view) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trauma_eicu_info;
    }

    @Override
    protected void initListener() {

    }


}

    
    
       
    