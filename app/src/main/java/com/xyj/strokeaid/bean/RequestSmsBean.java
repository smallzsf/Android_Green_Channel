package com.xyj.strokeaid.bean;

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
public class RequestSmsBean {

    private String mobile;
    private String template = "SMS_192532713";
    private String msgAuth = "裕康健";
    private String auth;
    private String sign;

    public RequestSmsBean(String mobile) {
        this.mobile = mobile;
        String[] strings = getSignAndAuth();
        this.auth = strings[0];
        this.sign = strings[1];
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static String[] getSignAndAuth() {
        String date = CalendarUtils.parseDate(CalendarUtils.TYPE_YYYYMMDDHHMMSS, new Date());
        String auth = Base64Util.encode(("xyjtech:" + date).getBytes(StandardCharsets.UTF_8));
        String signMd5 = MD5.getStringMD5("xyjtechXyj@20202019" + date);

        String[] strings = new String[2];
        strings[0] = auth;
        strings[1] = signMd5;
        return strings;
    }
}

    
    
       
    