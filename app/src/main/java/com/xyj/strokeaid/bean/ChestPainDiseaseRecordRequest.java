package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * @Description: 胸痛病情记录
 * @Author: crq
 * @CreateDate: 2020/9/9 9:36
 */
public class ChestPainDiseaseRecordRequest extends BaseBean<ChestPainDiseaseRecordRequest> {
    /**
     * recordId : 751546854738628608
     * conditionassessment : cpc_bqpg_cxxxm
     * conditionassessmentdetail : cpc_bqpgmx_hxkn
     * chiefcomplaint : 1
     * conditionassessmentremark : 2
     */

    private String recordId;
    private String conditionassessment;
    private String conditionassessmentdetail;
    private String chiefcomplaint;
    private String conditionassessmentremark;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getConditionassessment() {
        return conditionassessment;
    }

    public void setConditionassessment(String conditionassessment) {
        this.conditionassessment = conditionassessment;
    }

    public String getConditionassessmentdetail() {
        return conditionassessmentdetail;
    }

    public void setConditionassessmentdetail(String conditionassessmentdetail) {
        this.conditionassessmentdetail = conditionassessmentdetail;
    }

    public String getChiefcomplaint() {
        return chiefcomplaint;
    }

    public void setChiefcomplaint(String chiefcomplaint) {
        this.chiefcomplaint = chiefcomplaint;
    }

    public String getConditionassessmentremark() {
        return conditionassessmentremark;
    }

    public void setConditionassessmentremark(String conditionassessmentremark) {
        this.conditionassessmentremark = conditionassessmentremark;
    }
}
