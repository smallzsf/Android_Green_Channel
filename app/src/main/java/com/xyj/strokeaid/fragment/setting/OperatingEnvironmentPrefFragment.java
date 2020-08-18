package com.xyj.strokeaid.fragment.setting;


import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.xyj.strokeaid.R;

public final class OperatingEnvironmentPrefFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //有同样引入了一个xml
        addPreferencesFromResource(R.xml.preferences_operating_environment);

    }

}