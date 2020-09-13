package com.xyj.strokeaid.distutil;

import android.content.Context;
import android.widget.RadioButton;

import java.util.List;

public class RadioButtonDistUtil extends ViewDistUtils<RadioButton> {
    public RadioButtonDistUtil(Context context) {

        super(context);
    }

    public RadioButton getSelectView() {
        List<RadioButton> selectViews = super.getSelectViews();
        if (selectViews != null && selectViews.isEmpty()) {
            return selectViews.get(0);
        }
        return null;
    }


}
