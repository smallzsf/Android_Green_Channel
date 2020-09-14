package com.xyj.strokeaid.bean;

public class TraumaConsultationInfoBean {
    //会诊科室
    public String consultationdepartmentid;

    //会诊医生
    public String consultationdoctorid;
    //会诊医生到达时间
    public String consultationdoctorarrivetime;

    public TraumaConsultationInfoBean(String consultationdepartmentid, String consultationdoctorid, String consultationdoctorarrivetime) {
        this.consultationdepartmentid = consultationdepartmentid;
        this.consultationdoctorid = consultationdoctorid;
        this.consultationdoctorarrivetime = consultationdoctorarrivetime;
    }

    public String getConsultationdepartmentid() {
        return consultationdepartmentid;
    }

    public void setConsultationdepartmentid(String consultationdepartmentid) {
        this.consultationdepartmentid = consultationdepartmentid;
    }

    public String getConsultationdoctorid() {
        return consultationdoctorid;
    }

    public void setConsultationdoctorid(String consultationdoctorid) {
        this.consultationdoctorid = consultationdoctorid;
    }

    public String getConsultationdoctorarrivetime() {
        return consultationdoctorarrivetime;
    }

    public void setConsultationdoctorarrivetime(String consultationdoctorarrivetime) {
        this.consultationdoctorarrivetime = consultationdoctorarrivetime;
    }
}
