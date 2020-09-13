package com.xyj.strokeaid.distutil;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.view.MyRadioGroup;

import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RadioGroupDistUtil extends RadioButtonDistUtil {
    public RadioGroupDistUtil(Context context) {

        super(context);
    }

    @Override
    public List<String> getSelectViewKeys() {
        return super.getSelectViewKeys();
    }

    public void addView(RadioGroup radioGroup) {
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = radioGroup.getChildAt(i);
            if (childAt instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) childAt;
                super.addView(radioButton);
            }
        }


    }

    public static List<RadioButton> getAllRadioButton(ViewGroup radioGroup) {
        List<RadioButton> btns = new ArrayList<RadioButton>();
        int childCount = radioGroup.getChildCount();
        if (childCount == 0) {
            return btns;
        }
        for (int i = 0; i < childCount; i++) {
            View child = radioGroup.getChildAt(i);
            if (child instanceof RadioButton) {
                btns.add((RadioButton) child);
            } else if (child instanceof ViewGroup) {
                btns.addAll(getAllRadioButton((ViewGroup) child));
            }
        }
        return btns;
    }

    /**
     * 获取radioGroup中选中的文字
     */
    public static String getSelectRadioButtonText(ViewGroup radioGroup) {
        if (radioGroup == null || !(radioGroup instanceof RadioGroup || radioGroup instanceof MyRadioGroup)) {
            return "";
        }
        if (radioGroup instanceof RadioGroup) {
            RadioButton radioButton = radioGroup.findViewById(((RadioGroup) radioGroup).getCheckedRadioButtonId());
            return radioButton == null ? "" : radioButton.getText().toString();
        } else {
            RadioButton radioButton = radioGroup.findViewById(((MyRadioGroup) radioGroup).getCheckedRadioButtonId());
            return radioButton == null ? "" : radioButton.getText().toString();
        }
    }

    /**
     * 获取radioGroup中选中的文字
     */
    public static String getSelectRadioButtonTag(ViewGroup radioGroup, Map<String, String> map) {
        String txt = getSelectRadioButtonText(radioGroup);
        return getKeyOfMap(map,txt);
    }


    /**
     * 根绝文字选中radioButtom
     */
    public static void selectRadioButtonByText(ViewGroup radioGroup, String text) {
        if (!(radioGroup instanceof RadioGroup || radioGroup instanceof MyRadioGroup)) {
            return;
        }
        if (TextUtils.isEmpty(text)) {
            return;
        }
        List<RadioButton> allRadioButton = getAllRadioButton(radioGroup);
        for (RadioButton radioButton : allRadioButton) {
            if (text.equals(radioButton.getText())) {
                if (radioGroup instanceof RadioGroup) {
                    ((RadioGroup) radioGroup).check(radioButton.getId());
                } else {
                    ((MyRadioGroup) radioGroup).check(radioButton.getId());
                }
                return;
            }
        }
    }

    /**
     * 根绝文字选中radioButtom
     */
    public static void selectRadioButtonByMap(ViewGroup radioGroup, String key, Map<String, String> map) {
        selectRadioButtonByText(radioGroup, map.get(key));
    }

    private static String getKeyOfMap(Map<String, String> map, String value) {
        Set<String> strings = map.keySet();
        for (String key : strings) {
            if (TextUtils.equals(map.get(key), value)) {
                return key;
            }
        }
        return "";
    }
}
