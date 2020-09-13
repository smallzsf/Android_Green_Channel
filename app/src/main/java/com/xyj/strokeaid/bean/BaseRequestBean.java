package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseRequestBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class BaseRequestBean<T extends Object> extends BaseBean<BaseRequestBean> {


    /**
     * 患者主表id
     */
    private String recordId;
    /**
     * 疾病类型   2 胸痛
     */
    private int emergencyType;
    private List<String> keyList;
    private T data;

    public BaseRequestBean(String recordId, int emergencyType, T data) {
        this.recordId = recordId;
        this.emergencyType = emergencyType;
        this.data = data;
        this.keyList = new ArrayList<>();
        Field[] declaredFields = data.getClass().getFields();
        for (Field declaredField : declaredFields) {
            keyList.add(declaredField.getName());
        }
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

}

    
    
       
    