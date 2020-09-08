package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * IntraConsultBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/8
 * email ：licy3051@qq.com
 */
public class IntraConsultBean extends BaseBean<IntraConsultBean> {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String recordId;

    /**
     * 心内科会诊（"cpc_internalMedicine_no": "否",
     * "cpc_internalMedicine_scene": "现场会诊",
     * "cpc_internalMedicine_longDistance": "远程会诊"）
     */
    private String internalmedicineconsultation;

    /**
     * 申请人
     */
    private String internalmedicineconsultationapplicantid;

    /**
     * 通知心内科会诊时间
     */
    private String internalmedicinenotifiedconsultationtime;

    /**
     * 会诊医生
     */
    private String internalmedicineconsultationdoctorid;

    /**
     * 心内科会诊时间
     */
    private String internalmedicineconsultationtime;

    /**
     * 心外科会诊( "cpc_surgery_no": "否",
     * "cpc_surgery_scene": "现场会诊",
     * "cpc_surgery_longDistance": "远程会诊")
     */
    private String surgeryconsultation;

    /**
     * 申请人
     */
    private String surgeryconsultationapplicantid;

    /**
     * 通知心外科会诊时间
     */
    private String surgerynotifiedconsultationtime;

    /**
     * 会诊医生
     */
    private String surgeryconsultationdoctorid;

    /**
     * 心外科会诊时间
     */
    private String surgeryconsultationtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getInternalmedicineconsultation() {
        return internalmedicineconsultation;
    }

    public void setInternalmedicineconsultation(String internalmedicineconsultation) {
        this.internalmedicineconsultation = internalmedicineconsultation;
    }

    public String getInternalmedicineconsultationapplicantid() {
        return internalmedicineconsultationapplicantid;
    }

    public void setInternalmedicineconsultationapplicantid(String internalmedicineconsultationapplicantid) {
        this.internalmedicineconsultationapplicantid = internalmedicineconsultationapplicantid;
    }

    public String getInternalmedicinenotifiedconsultationtime() {
        return internalmedicinenotifiedconsultationtime;
    }

    public void setInternalmedicinenotifiedconsultationtime(String internalmedicinenotifiedconsultationtime) {
        this.internalmedicinenotifiedconsultationtime = internalmedicinenotifiedconsultationtime;
    }

    public String getInternalmedicineconsultationdoctorid() {
        return internalmedicineconsultationdoctorid;
    }

    public void setInternalmedicineconsultationdoctorid(String internalmedicineconsultationdoctorid) {
        this.internalmedicineconsultationdoctorid = internalmedicineconsultationdoctorid;
    }

    public String getInternalmedicineconsultationtime() {
        return internalmedicineconsultationtime;
    }

    public void setInternalmedicineconsultationtime(String internalmedicineconsultationtime) {
        this.internalmedicineconsultationtime = internalmedicineconsultationtime;
    }

    public String getSurgeryconsultation() {
        return surgeryconsultation;
    }

    public void setSurgeryconsultation(String surgeryconsultation) {
        this.surgeryconsultation = surgeryconsultation;
    }

    public String getSurgeryconsultationapplicantid() {
        return surgeryconsultationapplicantid;
    }

    public void setSurgeryconsultationapplicantid(String surgeryconsultationapplicantid) {
        this.surgeryconsultationapplicantid = surgeryconsultationapplicantid;
    }

    public String getSurgerynotifiedconsultationtime() {
        return surgerynotifiedconsultationtime;
    }

    public void setSurgerynotifiedconsultationtime(String surgerynotifiedconsultationtime) {
        this.surgerynotifiedconsultationtime = surgerynotifiedconsultationtime;
    }

    public String getSurgeryconsultationdoctorid() {
        return surgeryconsultationdoctorid;
    }

    public void setSurgeryconsultationdoctorid(String surgeryconsultationdoctorid) {
        this.surgeryconsultationdoctorid = surgeryconsultationdoctorid;
    }

    public String getSurgeryconsultationtime() {
        return surgeryconsultationtime;
    }

    public void setSurgeryconsultationtime(String surgeryconsultationtime) {
        this.surgeryconsultationtime = surgeryconsultationtime;
    }
}

    
    
       
    