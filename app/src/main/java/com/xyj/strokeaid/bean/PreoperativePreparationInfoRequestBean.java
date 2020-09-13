package com.xyj.strokeaid.bean;

/**
 * 术前准备信息  提交用
 */
public class PreoperativePreparationInfoRequestBean {

    //启动导管室
    public String enabledsaroombegintime;
    //直达导管室
    public String directdsaroom;
    //手术室
    public String embolectomyroom;
    //介入医生
    public String embolectomypatientsurgerydoctor;
    //介入护士
    public String embolectomypatientsurgerynurse;
    //激活导管室
    public String activedsaroomtime;
    //患者到达导管室
    public String patientarriveddsaroomtime;
    //手术备注信息
    public String embolectomyremark;

    public String getEnabledsaroombegintime() {
        return enabledsaroombegintime;
    }

    public void setEnabledsaroombegintime(String enabledsaroombegintime) {
        this.enabledsaroombegintime = enabledsaroombegintime;
    }

    public String getDirectdsaroom() {
        return directdsaroom;
    }

    public void setDirectdsaroom(String directdsaroom) {
        this.directdsaroom = directdsaroom;
    }

    public String getEmbolectomyroom() {
        return embolectomyroom;
    }

    public void setEmbolectomyroom(String embolectomyroom) {
        this.embolectomyroom = embolectomyroom;
    }

    public String getEmbolectomypatientsurgerydoctor() {
        return embolectomypatientsurgerydoctor;
    }

    public void setEmbolectomypatientsurgerydoctor(String embolectomypatientsurgerydoctor) {
        this.embolectomypatientsurgerydoctor = embolectomypatientsurgerydoctor;
    }

    public String getEmbolectomypatientsurgerynurse() {
        return embolectomypatientsurgerynurse;
    }

    public void setEmbolectomypatientsurgerynurse(String embolectomypatientsurgerynurse) {
        this.embolectomypatientsurgerynurse = embolectomypatientsurgerynurse;
    }

    public String getActivedsaroomtime() {
        return activedsaroomtime;
    }

    public void setActivedsaroomtime(String activedsaroomtime) {
        this.activedsaroomtime = activedsaroomtime;
    }

    public String getPatientarriveddsaroomtime() {
        return patientarriveddsaroomtime;
    }

    public void setPatientarriveddsaroomtime(String patientarriveddsaroomtime) {
        this.patientarriveddsaroomtime = patientarriveddsaroomtime;
    }


    public String getEmbolectomyremark() {
        return embolectomyremark;
    }

    public void setEmbolectomyremark(String embolectomyremark) {
        this.embolectomyremark = embolectomyremark;
    }
}
