package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * RequestSmsBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/6/29
 * email ：licy3051@qq.com
 */
public class RequestIdBean extends BaseBean<RequestIdBean> {

    private String id;

    public RequestIdBean(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

    
    
       
    