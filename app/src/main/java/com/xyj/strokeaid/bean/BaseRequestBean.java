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
public abstract class BaseRequestBean<T extends Object> extends BaseBean<BaseRequestBean> {


    private String recordId;
    private List<String> listString;
    private T data;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public List<String> getListString() {
        this.listString = new ArrayList<>();
        Field[] declaredFields = data.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            listString.add(declaredField.getName());
        }
        return listString;
    }

}

    
    
       
    