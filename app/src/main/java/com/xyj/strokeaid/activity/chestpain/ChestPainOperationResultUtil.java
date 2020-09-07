package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChestPainOperationResultUtil {
    private Context context;
    public  ChestPainOperationResultUtil(Context context){
        this.context = context;
    }

    Map<String, List<String>> mapGenderDataList = new ArrayMap<>();
    private String MAP_DATA_KEY="key";
    private String MAP_DATA_VALUE="value";

    /**
     * 初始化数据
     * @param id
     */
    public void initGenderMap(int id) {
        List<String> dataList = Arrays.asList(context.getResources().getStringArray(id));
        mapGenderDataList.put(getGenderMapKey(id),new ArrayList<>());
        mapGenderDataList.put(getGenderMapValueKey(id),new ArrayList<>());
        for (int i = 0; i < dataList.size(); i++) {
            String s = dataList.get(i);
            String[] split = s.split(":");
            if (split.length < 1){
                continue;
            }
            String key = split[0];
            String value  = split[1];
            List<String> keyList = mapGenderDataList.get(getGenderMapKey(id));
            keyList.add(key);
            mapGenderDataList.put(MAP_DATA_KEY,keyList);

            List<String> valueList = mapGenderDataList.get(getGenderMapValueKey(id));
            valueList.add(value);
            mapGenderDataList.put(MAP_DATA_VALUE,valueList);
        }
    }


    public String getGenderMapKey(int id){
        return MAP_DATA_KEY+id;
    }

    public String getGenderMapValueKey(int id){
        return MAP_DATA_VALUE+id;
    }

    public Map<String, List<String>> getMapGenderDataList() {
        return mapGenderDataList;
    }
}
