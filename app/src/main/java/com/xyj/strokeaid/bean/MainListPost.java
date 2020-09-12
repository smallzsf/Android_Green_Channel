package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * @author ck
 * 卒中、胸痛、创伤列表查询
 */
public class MainListPost extends BaseBean<MainListPost> {

    private int page;
    private int pageSize;

    private int emergencyType; //  1、卒中 2、胸痛 3、创伤
    private String fullname; // 姓名或身份证号

    public int getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(int emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
