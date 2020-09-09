package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DistListUtil {
    private Context context;

    public DistListUtil(Context context) {
        this.context = context;
    }

    Map<String, List<String>> mapGenderDataList = new ArrayMap<>();
    private String MAP_DATA_KEY = "key";
    private String MAP_DATA_VALUE = "value";

    /**
     * 初始化数据
     *
     * @param id
     */
    public void initGenderMap(int id) {
        List<String> dataList = Arrays.asList(context.getResources().getStringArray(id));
        mapGenderDataList.put(getGenderMapKey(id), new ArrayList<>());
        mapGenderDataList.put(getGenderMapValueKey(id), new ArrayList<>());
        for (int i = 0; i < dataList.size(); i++) {
            String s = dataList.get(i);
            String[] split = s.split(":");
            if (split.length < 1) {
                continue;
            }
            String key = split[0];
            String value = split[1];
            List<String> keyList = mapGenderDataList.get(getGenderMapKey(id));
            keyList.add(key);
            mapGenderDataList.put(MAP_DATA_KEY, keyList);

            List<String> valueList = mapGenderDataList.get(getGenderMapValueKey(id));
            valueList.add(value);
            mapGenderDataList.put(MAP_DATA_VALUE, valueList);
        }
    }


    public String getGenderMapKey(int id) {
        return MAP_DATA_KEY + id;
    }

    public String getGenderMapValueKey(int id) {
        return MAP_DATA_VALUE + id;
    }

    public Map<String, List<String>> getMapGenderDataList() {
        return mapGenderDataList;
    }

    public List<String> getKeyDataList(int id) {
        String genderMapKey = getGenderMapKey(id);
        if (mapGenderDataList.containsKey(genderMapKey)) {
            return getMapGenderDataList().get(genderMapKey);
        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getValueDataList(int id) {
        String genderMapKey = getGenderMapValueKey(id);
        if (mapGenderDataList.containsKey(genderMapKey)) {
            return getMapGenderDataList().get(genderMapKey);
        } else {
            return new ArrayList<>();
        }
    }


    /**
     * @param arrayId  array 字符串文件id
     * @param data 字符串 冒号之后的文字
     * @return 冒号之前文字对照的角标
     */
    public int getValueDataToPosition(int arrayId, String data) {
        List<String> valueDataList = getValueDataList(arrayId);
        for (int i = 0; i < valueDataList.size(); i++) {
            if (TextUtils.equals(data, valueDataList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param arrayId  array 字符串文件id
     * @param data 冒号之后的文字
     * @return 冒号之后的文字
     */
    public String getKeyDataToStringKey(int arrayId, String data) {
        int keyDataToPosition = getValueDataToPosition(arrayId, data);
        List<String> keyDataList = getKeyDataList(arrayId);
        if (keyDataList.size() <= keyDataToPosition) {
            return "";
        }
        if (keyDataToPosition == -1) {
            return "";
        }
        return keyDataList.get(keyDataToPosition);
    }

    /**
     * @param arrayId  array 字符串文件id
     * @param data 字符串 冒号之前的文字
     * @return 冒号之前文字对照的角标
     */
    public int getKeyDataToPosition(int arrayId, String data) {
        List<String> keyDataList = getKeyDataList(arrayId);
        for (int i = 0; i < keyDataList.size(); i++) {
            if (TextUtils.equals(data, keyDataList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param arrayId  array 字符串文件id
     * @param data 冒号之前的文字
     * @return 冒号之后的文字
     */
    public String getValueDataToStringKey(int arrayId, String data) {
        int keyDataToPosition = getKeyDataToPosition(arrayId, data);
        List<String> valueDataList = getValueDataList(arrayId);
        if (valueDataList.size() <= keyDataToPosition) {
            return "";
        }
        if (keyDataToPosition == -1) {
            return "";
        }
        return valueDataList.get(keyDataToPosition);
    }
}
