package com.xyj.strokeaid.fragment.setting;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.xyj.strokeaid.R;

public final class AssistFunctionPrefFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //有同样引入了一个xml
        addPreferencesFromResource(R.xml.pref_assist_function);
        //...
    }

}