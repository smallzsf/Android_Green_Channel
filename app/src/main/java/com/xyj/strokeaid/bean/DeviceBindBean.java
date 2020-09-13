package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * DeviceBindBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/12
 * email ：licy3051@qq.com
 */
public class DeviceBindBean extends BaseBean<DeviceBindBean> {


    /**
     * deviceType : 5
     * deviceNo : f2fc
     */

    private int deviceType;
    private String deviceNo;

    public DeviceBindBean(String deviceNo) {
        this.deviceType = 5;
        this.deviceNo = deviceNo;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
}

    
    
       
    