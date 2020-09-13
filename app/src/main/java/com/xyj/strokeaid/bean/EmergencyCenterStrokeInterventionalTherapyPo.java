package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * 卒中-介入治疗评估
 */
//@TableName("EMERGENCY_CENTER_STROKE_INTERVENTIONAL_THERAPY")
public class EmergencyCenterStrokeInterventionalTherapyPo   {


    /**
     * 介入治疗评估-介入医生接诊
     */
    //@TableField(value = "JRZLINTERVENTDOCTORRECEPTIONTIME")
    private String jrzlinterventdoctorreceptiontime;

    /**
     * 介入治疗评估-介入医生
     */
    //@TableField(value = "JRZLINTERVENTDOCTOR")
    private String jrzlinterventdoctor;

    /**
     * 介入治疗评估-会诊地点
     */
    //@TableField(value = "JRZLDEPARTMENT")
    private String jrzldepartment;

    /**
     * 介入治疗评估-适应症评估
     */
    //@TableField(value = "JRZLINDICATIONEVALUTETIME")
    private String jrzlindicationevalutetime;

    /**
     * 介入治疗评估-适应症评估结果
     */
    //@TableField(value = "JRZLINDICATIONEVALUTERESULT")
    private String jrzlindicationevaluteresult;

    /**
     * 介入治疗评估-适应症评估结果的评分关联Id
     */
    //@TableField(value = "JRZLINDICATIONEVALUTERESULTRELATIONID")
    private String jrzlindicationevaluteresultrelationid;

    /**
     * 介入治疗评估-禁忌症评估
     */
    //@TableField(value = "JRZLCONTRAINDICATIONSEVALUTETIME")
    private String jrzlcontraindicationsevalutetime;

    /**
     * 介入治疗评估-禁忌症评估结果
     */
    //@TableField(value = "JRZLCONTRAINDICATIONSEVALUTERESULT")
    private String jrzlcontraindicationsevaluteresult;

    /**
     * 介入治疗评估-禁忌症评估结果的评分关联Id
     */
    //@TableField(value = "JRZLCONTRAINDICATIONSEVALUTERESULTRELATIONID")
    private String jrzlcontraindicationsevaluteresultrelationid;

    /**
     * 介入治疗评估-手术预警时间
     */
    //@TableField(value = "JRZLALERTTIME")
    private String jrzlalerttime;

    /**
     * 介入治疗评估-急诊术前准备完成
     */
    //@TableField(value = "JRZLOPERATIONPRECOMPLETEDTIME")
    private String jrzloperationprecompletedtime;


    public String getJrzlinterventdoctorreceptiontime() {
        return jrzlinterventdoctorreceptiontime;
    }

    public void setJrzlinterventdoctorreceptiontime(String jrzlinterventdoctorreceptiontime) {
        this.jrzlinterventdoctorreceptiontime = jrzlinterventdoctorreceptiontime;
    }

    public String getJrzlinterventdoctor() {
        return jrzlinterventdoctor;
    }

    public void setJrzlinterventdoctor(String jrzlinterventdoctor) {
        this.jrzlinterventdoctor = jrzlinterventdoctor;
    }

    public String getJrzldepartment() {
        return jrzldepartment;
    }

    public void setJrzldepartment(String jrzldepartment) {
        this.jrzldepartment = jrzldepartment;
    }

    public String getJrzlindicationevalutetime() {
        return jrzlindicationevalutetime;
    }

    public void setJrzlindicationevalutetime(String jrzlindicationevalutetime) {
        this.jrzlindicationevalutetime = jrzlindicationevalutetime;
    }

    public String getJrzlindicationevaluteresult() {
        return jrzlindicationevaluteresult;
    }

    public void setJrzlindicationevaluteresult(String jrzlindicationevaluteresult) {
        this.jrzlindicationevaluteresult = jrzlindicationevaluteresult;
    }

    public String getJrzlindicationevaluteresultrelationid() {
        return jrzlindicationevaluteresultrelationid;
    }

    public void setJrzlindicationevaluteresultrelationid(String jrzlindicationevaluteresultrelationid) {
        this.jrzlindicationevaluteresultrelationid = jrzlindicationevaluteresultrelationid;
    }

    public String getJrzlcontraindicationsevalutetime() {
        return jrzlcontraindicationsevalutetime;
    }

    public void setJrzlcontraindicationsevalutetime(String jrzlcontraindicationsevalutetime) {
        this.jrzlcontraindicationsevalutetime = jrzlcontraindicationsevalutetime;
    }

    public String getJrzlcontraindicationsevaluteresult() {
        return jrzlcontraindicationsevaluteresult;
    }

    public void setJrzlcontraindicationsevaluteresult(String jrzlcontraindicationsevaluteresult) {
        this.jrzlcontraindicationsevaluteresult = jrzlcontraindicationsevaluteresult;
    }

    public String getJrzlcontraindicationsevaluteresultrelationid() {
        return jrzlcontraindicationsevaluteresultrelationid;
    }

    public void setJrzlcontraindicationsevaluteresultrelationid(String jrzlcontraindicationsevaluteresultrelationid) {
        this.jrzlcontraindicationsevaluteresultrelationid = jrzlcontraindicationsevaluteresultrelationid;
    }

    public String getJrzlalerttime() {
        return jrzlalerttime;
    }

    public void setJrzlalerttime(String jrzlalerttime) {
        this.jrzlalerttime = jrzlalerttime;
    }

    public String getJrzloperationprecompletedtime() {
        return jrzloperationprecompletedtime;
    }

    public void setJrzloperationprecompletedtime(String jrzloperationprecompletedtime) {
        this.jrzloperationprecompletedtime = jrzloperationprecompletedtime;
    }
}