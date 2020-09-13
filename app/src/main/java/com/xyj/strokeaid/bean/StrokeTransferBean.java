package com.xyj.strokeaid.bean;

/**
 * @Description: 卒中转归
 * @Author: crq
 * @CreateDate: 2020/9/13 14:01
 */
public class StrokeTransferBean {

    /**
     * 出院诊断-诊断结果
     */
    private String diagnosticresultleave;

    /**
     * 出院诊断-诊断时间
     */
    private String diagnostictimeleave;

    /**
     * 出院诊断-出血性卒中
     */
    private String hemorrhagicstrokeleave;

    /**
     * 出院诊断-住院时间
     */
    private String hospitalstaytime;

    /**
     * 出院诊断-缺血性卒中
     */
    private String ischemicstrokeleave;


    /**
     * 出院诊断-出院时GCS
     */
    private String leavegcs;

    /**
     * 出院诊断-出院时GCS的评分关联Id
     */
    private String leavegcsrelationid;

    /**
     * 出院诊断-出院时mRS
     */
    private String leavemrs;

    /**
     * 出院诊断-出院时mRS的评分关联Id
     */
    private String leavemrsrelationid;

    /**
     * 出院诊断-出院NIHSS评分
     */
    private String leavenihss;

    /**
     * 出院诊断-出院NIHSS评分的评分关联Id
     */
    private String leavenihssrelationid;

    /**
     * 出院诊断-住院天数
     */
    private String numberofdaysinhospital;

    /**
     * 出院诊断-其他
     */
    private String otherdiagnosticresultleave;

    /**
     * 出院诊断-动脉瘤破裂
     */
    private String ruptureofaneurysmleave;


    /**
     * 出院诊断-非动脉瘤破裂
     */
    private String ruptureofnonaneurysmleave;


    /**
     * 出院诊断-总费用
     */
    private String totalcostinhospital;



    /**
     * 其他(死亡原因描述)
     */
    private String deathdecriptioin;

    /**
     * 死亡原因
     */
    private String deathreason;

    /**
     * 死亡时间
     */
    private String deathtime;

    /**
     * 接诊科室
     */
    private String departmenttransto;

    /**
     *出院时间
     */
    private String dischargedtime;

    /**
     * 离院方式
     */
    private String leaveway;

    /**
     * 出院带药
     */
    private String leavewithmedicine;

    /**
     * 患者转归
     */
    private String prognosisresult;

    /**
     * 转科原因描述
     */
    private String transdepartmentreason;


    /**
     * 转科时间
     */
    private String transdepartmenttime;


    /**
     * 治疗结果
     */
    private String treatmentresult;





    public String getDiagnosticresultleave() {
        return diagnosticresultleave;
    }

    public void setDiagnosticresultleave(String diagnosticresultleave) {
        this.diagnosticresultleave = diagnosticresultleave;
    }

    public String getDiagnostictimeleave() {
        return diagnostictimeleave;
    }

    public void setDiagnostictimeleave(String diagnostictimeleave) {
        this.diagnostictimeleave = diagnostictimeleave;
    }

    public String getHemorrhagicstrokeleave() {
        return hemorrhagicstrokeleave;
    }

    public void setHemorrhagicstrokeleave(String hemorrhagicstrokeleave) {
        this.hemorrhagicstrokeleave = hemorrhagicstrokeleave;
    }

    public String getHospitalstaytime() {
        return hospitalstaytime;
    }

    public void setHospitalstaytime(String hospitalstaytime) {
        this.hospitalstaytime = hospitalstaytime;
    }

    public String getIschemicstrokeleave() {
        return ischemicstrokeleave;
    }

    public void setIschemicstrokeleave(String ischemicstrokeleave) {
        this.ischemicstrokeleave = ischemicstrokeleave;
    }

    public String getLeavegcs() {
        return leavegcs;
    }

    public void setLeavegcs(String leavegcs) {
        this.leavegcs = leavegcs;
    }

    public String getLeavegcsrelationid() {
        return leavegcsrelationid;
    }

    public void setLeavegcsrelationid(String leavegcsrelationid) {
        this.leavegcsrelationid = leavegcsrelationid;
    }

    public String getLeavemrs() {
        return leavemrs;
    }

    public void setLeavemrs(String leavemrs) {
        this.leavemrs = leavemrs;
    }

    public String getLeavemrsrelationid() {
        return leavemrsrelationid;
    }

    public void setLeavemrsrelationid(String leavemrsrelationid) {
        this.leavemrsrelationid = leavemrsrelationid;
    }

    public String getLeavenihss() {
        return leavenihss;
    }

    public void setLeavenihss(String leavenihss) {
        this.leavenihss = leavenihss;
    }

    public String getLeavenihssrelationid() {
        return leavenihssrelationid;
    }

    public void setLeavenihssrelationid(String leavenihssrelationid) {
        this.leavenihssrelationid = leavenihssrelationid;
    }

    public String getNumberofdaysinhospital() {
        return numberofdaysinhospital;
    }

    public void setNumberofdaysinhospital(String numberofdaysinhospital) {
        this.numberofdaysinhospital = numberofdaysinhospital;
    }

    public String getOtherdiagnosticresultleave() {
        return otherdiagnosticresultleave;
    }

    public void setOtherdiagnosticresultleave(String otherdiagnosticresultleave) {
        this.otherdiagnosticresultleave = otherdiagnosticresultleave;
    }

    public String getRuptureofaneurysmleave() {
        return ruptureofaneurysmleave;
    }

    public void setRuptureofaneurysmleave(String ruptureofaneurysmleave) {
        this.ruptureofaneurysmleave = ruptureofaneurysmleave;
    }

    public String getRuptureofnonaneurysmleave() {
        return ruptureofnonaneurysmleave;
    }

    public void setRuptureofnonaneurysmleave(String ruptureofnonaneurysmleave) {
        this.ruptureofnonaneurysmleave = ruptureofnonaneurysmleave;
    }

    public String getTotalcostinhospital() {
        return totalcostinhospital;
    }

    public void setTotalcostinhospital(String totalcostinhospital) {
        this.totalcostinhospital = totalcostinhospital;
    }


    public String getDeathdecriptioin() {
        return deathdecriptioin;
    }

    public void setDeathdecriptioin(String deathdecriptioin) {
        this.deathdecriptioin = deathdecriptioin;
    }

    public String getDeathreason() {
        return deathreason;
    }

    public void setDeathreason(String deathreason) {
        this.deathreason = deathreason;
    }

    public String getDeathtime() {
        return deathtime;
    }

    public void setDeathtime(String deathtime) {
        this.deathtime = deathtime;
    }

    public String getDepartmenttransto() {
        return departmenttransto;
    }

    public void setDepartmenttransto(String departmenttransto) {
        this.departmenttransto = departmenttransto;
    }

    public String getDischargedtime() {
        return dischargedtime;
    }

    public void setDischargedtime(String dischargedtime) {
        this.dischargedtime = dischargedtime;
    }

    public String getLeaveway() {
        return leaveway;
    }

    public void setLeaveway(String leaveway) {
        this.leaveway = leaveway;
    }

    public String getLeavewithmedicine() {
        return leavewithmedicine;
    }

    public void setLeavewithmedicine(String leavewithmedicine) {
        this.leavewithmedicine = leavewithmedicine;
    }

    public String getPrognosisresult() {
        return prognosisresult;
    }

    public void setPrognosisresult(String prognosisresult) {
        this.prognosisresult = prognosisresult;
    }

    public String getTransdepartmentreason() {
        return transdepartmentreason;
    }

    public void setTransdepartmentreason(String transdepartmentreason) {
        this.transdepartmentreason = transdepartmentreason;
    }

    public String getTransdepartmenttime() {
        return transdepartmenttime;
    }

    public void setTransdepartmenttime(String transdepartmenttime) {
        this.transdepartmenttime = transdepartmenttime;
    }

    public String getTreatmentresult() {
        return treatmentresult;
    }

    public void setTreatmentresult(String treatmentresult) {
        this.treatmentresult = treatmentresult;
    }
}
