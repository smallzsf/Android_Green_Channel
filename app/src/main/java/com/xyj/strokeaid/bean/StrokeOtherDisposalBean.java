package com.xyj.strokeaid.bean;

/**
 * @Description: 其它处置bean类
 * @Author: crq
 * @CreateDate: 2020/9/13 10:39
 */
public class StrokeOtherDisposalBean {

    /**
     * 是否接受康复治疗
     */
    private String recoveringtreatmentisaccept;
    /**
     * 康复治疗场所
     */
    private String recoveringtreatmentplace;
    /**
     * 康复治疗方式
     */
    private String recoveringtreatmentways;

    /**
     * 健康教育-健康宣教
     */
    private String educationway;

    /**
     * 健康教育-宣教方式
     */
    private String healtheducation;


    public String getRecoveringtreatmentisaccept() {
        return recoveringtreatmentisaccept;
    }

    public void setRecoveringtreatmentisaccept(String recoveringtreatmentisaccept) {
        this.recoveringtreatmentisaccept = recoveringtreatmentisaccept;
    }

    public String getRecoveringtreatmentplace() {
        return recoveringtreatmentplace;
    }

    public void setRecoveringtreatmentplace(String recoveringtreatmentplace) {
        this.recoveringtreatmentplace = recoveringtreatmentplace;
    }

    public String getRecoveringtreatmentways() {
        return recoveringtreatmentways;
    }

    public void setRecoveringtreatmentways(String recoveringtreatmentways) {
        this.recoveringtreatmentways = recoveringtreatmentways;
    }

    public String getEducationway() {
        return educationway;
    }

    public void setEducationway(String educationway) {
        this.educationway = educationway;
    }

    public String getHealtheducation() {
        return healtheducation;
    }

    public void setHealtheducation(String healtheducation) {
        this.healtheducation = healtheducation;
    }
}
