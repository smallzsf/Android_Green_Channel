package com.xyj.strokeaid.bean.trauma;

/**
 * author : 王成玉
 */
public class TraumaOutcomeBean {
    /**
     * 患者转归 1 出院   2转送其它医院  3转送其它科室 4死亡
     */
    public String outcomepatients;
    public String outcomelengthstay;//住院天数
    public String outcomeicudays;//住ICU天数
    public String outcomerespiratorduration;//呼吸机使用时长（小时）
    public String outcomeallincost;//总费用
    public String outcomedischargetime;//出院时间
    public String outcometherapeuticoutcome;//治疗结果 1治愈 2好转 3自动离院 4其它原因离院
    public String outcometransferleaveourcollegetime;//转送其它医院-离开本院大门时间
    public String outcometransferhospitalname;//转送其它医院-医院名称
    public String outcomenetworkhospital;//网络医院 1是  -1否
    public String outcometransferdepartmenttime;//转送其它科室-转科时间
    public String outcomereceivingdepartment;//接诊科室
    public String transferdepartmentreason;//转科原因
    public String outcomeplacedeath;//死亡-死亡地点
    public String outcomedeathtime;//死亡时间
    public String outcomedeathreason;//死亡原因

    public String getOutcomepatients() {
        return outcomepatients;
    }

    public void setOutcomepatients(String outcomepatients) {
        this.outcomepatients = outcomepatients;
    }

    public String getOutcomelengthstay() {
        return outcomelengthstay;
    }

    public void setOutcomelengthstay(String outcomelengthstay) {
        this.outcomelengthstay = outcomelengthstay;
    }

    public String getOutcomeicudays() {
        return outcomeicudays;
    }

    public void setOutcomeicudays(String outcomeicudays) {
        this.outcomeicudays = outcomeicudays;
    }

    public String getOutcomerespiratorduration() {
        return outcomerespiratorduration;
    }

    public void setOutcomerespiratorduration(String outcomerespiratorduration) {
        this.outcomerespiratorduration = outcomerespiratorduration;
    }

    public String getOutcomeallincost() {
        return outcomeallincost;
    }

    public void setOutcomeallincost(String outcomeallincost) {
        this.outcomeallincost = outcomeallincost;
    }

    public String getOutcomedischargetime() {
        return outcomedischargetime;
    }

    public void setOutcomedischargetime(String outcomedischargetime) {
        this.outcomedischargetime = outcomedischargetime;
    }

    public String getOutcometherapeuticoutcome() {
        return outcometherapeuticoutcome;
    }

    public void setOutcometherapeuticoutcome(String outcometherapeuticoutcome) {
        this.outcometherapeuticoutcome = outcometherapeuticoutcome;
    }

    public String getOutcometransferleaveourcollegetime() {
        return outcometransferleaveourcollegetime;
    }

    public void setOutcometransferleaveourcollegetime(String outcometransferleaveourcollegetime) {
        this.outcometransferleaveourcollegetime = outcometransferleaveourcollegetime;
    }

    public String getOutcometransferhospitalname() {
        return outcometransferhospitalname;
    }

    public void setOutcometransferhospitalname(String outcometransferhospitalname) {
        this.outcometransferhospitalname = outcometransferhospitalname;
    }

    public String getOutcomenetworkhospital() {
        return outcomenetworkhospital;
    }

    public void setOutcomenetworkhospital(String outcomenetworkhospital) {
        this.outcomenetworkhospital = outcomenetworkhospital;
    }

    public String getOutcometransferdepartmenttime() {
        return outcometransferdepartmenttime;
    }

    public void setOutcometransferdepartmenttime(String outcometransferdepartmenttime) {
        this.outcometransferdepartmenttime = outcometransferdepartmenttime;
    }

    public String getOutcomereceivingdepartment() {
        return outcomereceivingdepartment;
    }

    public void setOutcomereceivingdepartment(String outcomereceivingdepartment) {
        this.outcomereceivingdepartment = outcomereceivingdepartment;
    }

    public String getTransferdepartmentreason() {
        return transferdepartmentreason;
    }

    public void setTransferdepartmentreason(String transferdepartmentreason) {
        this.transferdepartmentreason = transferdepartmentreason;
    }

    public String getOutcomeplacedeath() {
        return outcomeplacedeath;
    }

    public void setOutcomeplacedeath(String outcomeplacedeath) {
        this.outcomeplacedeath = outcomeplacedeath;
    }

    public String getOutcomedeathtime() {
        return outcomedeathtime;
    }

    public void setOutcomedeathtime(String outcomedeathtime) {
        this.outcomedeathtime = outcomedeathtime;
    }

    public String getOutcomedeathreason() {
        return outcomedeathreason;
    }

    public void setOutcomedeathreason(String outcomedeathreason) {
        this.outcomedeathreason = outcomedeathreason;
    }
}
