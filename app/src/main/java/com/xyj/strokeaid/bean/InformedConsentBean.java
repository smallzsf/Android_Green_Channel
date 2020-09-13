package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;

import java.util.Date;

public class InformedConsentBean {
    private String talkdoctorJrzt;//介入再通谈话医生
    private String embolectomypatientcommunicationsbegintime;//介入再通开始知情同意
    private String embolectomypatientcommunicationsendtime;//介入再通签署知情同意
    private String embolectomypatientopinion;//介入再通家属意见

    public String getTalkdoctorJrzt() {
        return talkdoctorJrzt;
    }

    public void setTalkdoctorJrzt(String talkdoctorJrzt) {
        this.talkdoctorJrzt = talkdoctorJrzt;
    }

    public String getEmbolectomypatientcommunicationsbegintime() {
        return embolectomypatientcommunicationsbegintime;
    }

    public void setEmbolectomypatientcommunicationsbegintime(String embolectomypatientcommunicationsbegintime) {
        this.embolectomypatientcommunicationsbegintime = embolectomypatientcommunicationsbegintime;
    }

    public String getEmbolectomypatientcommunicationsendtime() {
        return embolectomypatientcommunicationsendtime;
    }

    public void setEmbolectomypatientcommunicationsendtime(String embolectomypatientcommunicationsendtime) {
        this.embolectomypatientcommunicationsendtime = embolectomypatientcommunicationsendtime;
    }

    public String getEmbolectomypatientopinion() {
        return embolectomypatientopinion;
    }

    public void setEmbolectomypatientopinion(String embolectomypatientopinion) {
        this.embolectomypatientopinion = embolectomypatientopinion;
    }

}
