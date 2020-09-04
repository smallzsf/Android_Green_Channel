package com.xyj.strokeaid.bean;

/**
 * @Description: 验证码
 * @Author: crq
 * @CreateDate: 2020/9/3 18:55
 */
public class SendSmsBean {
     /**
     * expire : 5
     */

    private String expire;

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }
}
