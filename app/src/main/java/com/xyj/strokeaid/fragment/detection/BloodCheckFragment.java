package com.xyj.strokeaid.fragment.detection;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeAngioplastyFragment;

/**
  * @Package:        com.xyj.strokeaid.fragment.detection
  * @ClassName:      BloodCheckFragment
  * @Description:    血夜检查Fragment
  * @Autho:          王水雷
  * @Time:           2020/8/25
 */
public class BloodCheckFragment extends BaseFragment {

    public BloodCheckFragment() {
    }
    public static BloodCheckFragment newInstance( ) {
        BloodCheckFragment fragment = new BloodCheckFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dection_blood_check;
    }

    @Override
    protected void initView(@NonNull View view) {

    }

    @Override
    protected void initListener() {

    }
}