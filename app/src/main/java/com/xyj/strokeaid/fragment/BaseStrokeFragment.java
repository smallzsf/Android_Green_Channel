package com.xyj.strokeaid.fragment;

import android.os.Bundle;

import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeThrombolysisFragment;

/**
 * BaseStrokeFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/10
 * email ：licy3051@qq.com
 */
public abstract class BaseStrokeFragment extends BaseFragment {

    protected String mRecordId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }
}

    
    
       
    