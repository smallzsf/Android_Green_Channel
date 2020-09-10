package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.widget.RadioButton;

public class RadioButtonDistUtil extends ViewDistUtils<RadioButton> {
    public RadioButtonDistUtil(Context context) {
        super(context);
    }

    @Override
    public void setSelectView(RadioButton view) {
        view.setChecked(true);
    }

    @Override
    public void setViewData(RadioButton view, String text) {
        view.setText(text);
    }
}
