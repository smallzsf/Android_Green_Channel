package com.xyj.strokeaid.bean;

import android.util.Log;

import com.xyj.strokeaid.base.BaseBean;
import com.xyj.strokeaid.helper.Base64Util;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.MD5;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * RequestSmsBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/6/29
 * email ：licy3051@qq.com
 */
public class RecordIdBean  extends BaseBean<RecordIdBean> {

    private String recordId;

    public RecordIdBean(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }
}

    
    
       
    