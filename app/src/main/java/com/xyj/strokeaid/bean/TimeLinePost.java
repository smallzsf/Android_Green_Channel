package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * 获取时间线
 * @author ck
 */
public class TimeLinePost extends BaseBean<TimeLinePost> {

    private String recordId;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }
}
