package com.xyj.strokeaid.bean;

/**
 * 获取血液数据请求参数
 */
public class SendBloodDataBean {
    private String id;

    private String rdcord_id;

    public String getId() {
        return id;
    }

    public String getRdcord_id() {
        return rdcord_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRdcord_id(String rdcord_id) {
        this.rdcord_id = rdcord_id;
    }
}
