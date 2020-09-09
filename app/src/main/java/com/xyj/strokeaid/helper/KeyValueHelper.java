package com.xyj.strokeaid.helper;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.ArrayRes;

import com.blankj.utilcode.util.Utils;

import java.util.HashMap;
import java.util.List;

/**
 * KeyValueHelper
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public final class KeyValueHelper {

    public static String getKeyByValue(List<String> keys, List<String> values, String checkValue) {
        if (keys == null || values == null) {
            return "";
        }
        if (keys.size() != values.size()) {
            return "";
        }
        int index = -1;
        for (int i = 0; i < keys.size(); i++) {
            if (TextUtils.equals(keys.get(i), checkValue)) {
                index = i;
            }
        }
        if (index == -1) {
            return "";
        } else {
            return values.get(index);
        }

    }

    public static String getValueByKey(List<String> keys, List<String> values, String checkKey) {
        if (keys == null || values == null) {
            return "";
        }
        if (keys.size() != values.size()) {
            return "";
        }
        int index = -1;
        for (int i = 0; i < values.size(); i++) {
            if (TextUtils.equals(values.get(i), checkKey)) {
                index = i;
            }
        }
        if (index == -1) {
            return "";
        } else {
            return keys.get(index);
        }
    }

    public static String getKeyByValue(@ArrayRes int res, String value) {
        String[] stringArray = Utils.getApp().getResources().getStringArray(res);
        // 前面是value， 文字说明
        // 后面是key，用于接口传参
        HashMap<String, String> map = new HashMap<>(stringArray.length);
        for (int i = 0; i < stringArray.length; i++) {
            String[] split = stringArray[i].split(":");
            map.put(split[0], split[1]);
        }
        return map.get(value);
    }

    public static String getValueByKey(@ArrayRes int res, String key) {
        String[] stringArray = Utils.getApp().getResources().getStringArray(res);
        // 后面是value， 文字说明
        // 前面是key，用于接口传参
        HashMap<String, String> map = new HashMap<>(stringArray.length);
        for (int i = 0; i < stringArray.length; i++) {
            String[] split = stringArray[i].split(":");
            map.put(split[1], split[0]);
        }
        return map.get(key);
    }

    /**
     * 获取radio button中被选中的button的tag
     *
     * @param radioButtons 设置过tag的buttons
     * @return
     */
    public static String getRadioGroupsKey(RadioButton... radioButtons) {
        if (radioButtons != null && radioButtons.length > 0) {
            for (RadioButton radioButton : radioButtons) {
                if (radioButton.isChecked()) {
                    return radioButton.getTag().toString();
                }
            }
        }

        return "";
    }

    /**
     * 获取radio button中被选中的button的tag
     *
     * @param radioGroup 含有设置过tag的buttons
     * @return
     */
    public static String getRadioGroupsKey(RadioGroup radioGroup) {
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton viewById = radioGroup.findViewById(checkedRadioButtonId);
        return viewById.getTag().toString();
    }

    /**
     * 获取checkBoxes中被选中的 checkbox 的tag
     *
     * @param checkBoxes 设置过tag的checkBoxes
     * @return
     */
    public static String getCheckboxsKey(CheckBox... checkBoxes) {
        if (checkBoxes != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked()) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(checkBox.getTag().toString());
                }
            }
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

}

    
    
       
    