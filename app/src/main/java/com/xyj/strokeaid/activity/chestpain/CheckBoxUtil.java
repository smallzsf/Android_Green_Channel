package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.widget.CheckBox;

public class CheckBoxUtil extends ViewDistUtils<CheckBox> {
    public CheckBoxUtil(Context context) {
        super(context);
    }

    @Override
    public void setSelectView(CheckBox view) {
        view.setChecked(true);
    }

    @Override
    public void setViewData(CheckBox view, String text) {
        view.setText(text);
    }
}
