package com.xyj.strokeaid.distutil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.List;

public class RadioButtonDistUtil extends ViewDistUtils<RadioButton> {
    public RadioButtonDistUtil(Context context) {

        super(context);
    }

    public void addView(ViewGroup viewGroup){
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof RadioButton){
                addView((RadioButton) childAt);
            }else if (childAt instanceof ViewGroup){
                addView((ViewGroup) childAt);
            }
        }
    }


    public RadioButton getSelectView() {
        List<RadioButton> selectViews = super.getSelectViews();
        if (selectViews != null && selectViews.isEmpty()) {
            return selectViews.get(0);
        }
        return null;
    }


}
