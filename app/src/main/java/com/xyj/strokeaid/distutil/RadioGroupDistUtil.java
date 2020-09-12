package com.xyj.strokeaid.distutil;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class RadioGroupDistUtil extends RadioButtonDistUtil {
    public RadioGroupDistUtil(Context context) {

        super(context);
    }


    public void addView(RadioGroup radioGroup) {
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = radioGroup.getChildAt(i);
            if (childAt instanceof RadioButton){
                RadioButton radioButton = (RadioButton) childAt;
                super.addView(radioButton);
            }
        }


    }
}
