package com.xyj.strokeaid.bean;

/**
 * 溶栓治疗
 */
public class ThrombolysisTreatmentBean {

    /**
     * 静脉溶栓-谈话医生
     */
    private String talkdoctorJmrs;

    /**
     * 静脉溶栓-静脉溶栓开始知情同意时间
     */
    // @ApiModelProperty(dataType = "date", example = "yyyy-MM-dd HH:mm:ss")
    private String thrombolyticpatientcommunicationsbegintime;

    /**
     * 静脉溶栓-静脉溶栓签署知情同意时间
     */
    //@ApiModelProperty(dataType = "date", example = "yyyy-MM-dd HH:mm:ss")
    private String thrombolyticpatientcommunicationsendtime;

    /**
     * 静脉溶栓-静脉溶栓家属意见
     */
    private String thrombolyticpatientopinion;

    /**
     * 静脉溶栓-静脉溶栓拒绝原因
     */
    private String thrombolyticpatientrefusereason;

    /**
     * 静脉溶栓-静脉溶栓其他拒绝原因
     */
    private String thrombolyticotherrefusereason;

    /**
     * 静脉溶栓-静脉溶栓知情同意书
     */
    private String thrombolyticinformedconsent;

    /**
     * 静脉溶栓-THRIVE评分
     */
    private String thrive;

    /**
     * 静脉溶栓-THRIVE评分关联ID
     */
    private String thriverelationid;

    /**
     * 静脉溶栓-溶栓前NIHSS
     */
    private String prethrombolyticnihss;

    /**
     * 静脉溶栓-溶栓前NIHSS的评分关联Id
     */
    private String prethrombolyticnihssrelationid;

    /**
     * 静脉溶栓-溶栓地点
     */
    private String thrombolyticaddress;

    /**
     * 静脉溶栓-静脉溶栓护士
     */
    private String emergencynurseJmrs;

    /**
     * 静脉溶栓-静脉溶栓溶栓药物
     */
    private String thrombolyticdrug;

    /**
     * 静脉溶栓-静脉溶栓使用方式和剂量
     */
    private String thrombolyticdruguser;

    /**
     * 静脉溶栓-静脉溶栓静推时间
     */
    //@ApiModelProperty(dataType = "date", example = "yyyy-MM-dd HH:mm:ss")
    private String thrombolyticstaticpushtime;

    /**
     * 静脉溶栓-静脉溶栓发病至溶栓时间时间差
     */
    private String thrombolyticont;

    /**
     * 静脉溶栓-静脉溶栓入门至溶栓时间时间差
     */
    private String thrombolyticdnt;

    /**
     * 静脉溶栓-是否血管再通
     */
    private String isthrombolyticrecanalization;

    /**
     * 静脉溶栓-溶栓并发症
     */
    private String thrombolyticcomplication;

    /**
     * 静脉溶栓-其他溶栓并发症
     */
    private String otherthrombolyticcomplication;

    /**
     * 静脉溶栓-溶栓结束后即刻NIHSS
     */
    private String postthrombolyticnihss;

    /**
     * 静脉溶栓-溶栓结束后即刻NIHSS的评分关联Id
     */
    private String postthrombolyticnihssrelationid;

    /**
     * 静脉溶栓-溶栓后24h NIHSS
     */
    private String afterdaythrombolyticnihss;

    /**
     * 静脉溶栓-溶栓后24h NIHSS的评分关联Id
     */
    private String afterdaythrombolyticnihssrelationid;

    /**
     * 静脉溶栓-7±2天 NIHSS
     */
    private String afterweekthrombolyticnihss;

    /**
     * 静脉溶栓-7±2天 NIHSS的评分关联Id
     */
    private String afterweekthrombolyticnihssrelationid;

    /**
     * 静脉溶栓-救治是否延误
     */
    private String thrombolyticisdelay;

    /**
     * 静脉溶栓-静脉溶栓延误原因
     */
    private String thrombolyticdelayreason;

    /**
     * 静脉溶栓-未给予血管内治疗的原因
     */
    private String notembolectomyreason;

    /**
     * 静脉溶栓-开始静脉溶栓
     */
    private String thrombolysisstarttime;

    /**
     * 静脉溶栓-剂量类型
     */
    private String thrombolyticdosetype;

    /**
     * 静脉溶栓-预计剂量
     */
    private String THROMBOLYSISESTIMATEDDRUGDOSE;

    /**
     * 静脉溶栓-实际静推剂量
     */
    private String thrombolyticactualintravenousdose;

    /**
     * 静脉溶栓-实际滴注剂量
     */
    private String thrombolyticactualinfusiondose;

    /**
     * 静脉溶栓-实际用药总量
     */
    private String actualtotalmedication;

    /**
     * 静脉溶栓-实际剂量标准
     */
    private String thrombolyticactualdosestandard;

    /**
     * 静脉溶栓-使用剂量
     */
    private String thrombolysisdrugdose;

    /**
     * 静脉溶栓-未在CT室溶栓原因
     */
    private String thrombolyticaddressnotinctreason;

    public String getTalkdoctorJmrs() {
        return talkdoctorJmrs;
    }

    public void setTalkdoctorJmrs(String talkdoctorJmrs) {
        this.talkdoctorJmrs = talkdoctorJmrs;
    }

    public String getThrombolyticpatientcommunicationsbegintime() {
        return thrombolyticpatientcommunicationsbegintime;
    }

    public void setThrombolyticpatientcommunicationsbegintime(String thrombolyticpatientcommunicationsbegintime) {
        this.thrombolyticpatientcommunicationsbegintime = thrombolyticpatientcommunicationsbegintime;
    }

    public String getThrombolyticpatientcommunicationsendtime() {
        return thrombolyticpatientcommunicationsendtime;
    }

    public void setThrombolyticpatientcommunicationsendtime(String thrombolyticpatientcommunicationsendtime) {
        this.thrombolyticpatientcommunicationsendtime = thrombolyticpatientcommunicationsendtime;
    }

    public String getThrombolyticpatientopinion() {
        return thrombolyticpatientopinion;
    }

    public void setThrombolyticpatientopinion(String thrombolyticpatientopinion) {
        this.thrombolyticpatientopinion = thrombolyticpatientopinion;
    }

    public String getThrombolyticpatientrefusereason() {
        return thrombolyticpatientrefusereason;
    }

    public void setThrombolyticpatientrefusereason(String thrombolyticpatientrefusereason) {
        this.thrombolyticpatientrefusereason = thrombolyticpatientrefusereason;
    }

    public String getThrombolyticotherrefusereason() {
        return thrombolyticotherrefusereason;
    }

    public void setThrombolyticotherrefusereason(String thrombolyticotherrefusereason) {
        this.thrombolyticotherrefusereason = thrombolyticotherrefusereason;
    }

    public String getThrombolyticinformedconsent() {
        return thrombolyticinformedconsent;
    }

    public void setThrombolyticinformedconsent(String thrombolyticinformedconsent) {
        this.thrombolyticinformedconsent = thrombolyticinformedconsent;
    }

    public String getThrive() {
        return thrive;
    }

    public void setThrive(String thrive) {
        this.thrive = thrive;
    }

    public String getThriverelationid() {
        return thriverelationid;
    }

    public void setThriverelationid(String thriverelationid) {
        this.thriverelationid = thriverelationid;
    }

    public String getPrethrombolyticnihss() {
        return prethrombolyticnihss;
    }

    public void setPrethrombolyticnihss(String prethrombolyticnihss) {
        this.prethrombolyticnihss = prethrombolyticnihss;
    }

    public String getPrethrombolyticnihssrelationid() {
        return prethrombolyticnihssrelationid;
    }

    public void setPrethrombolyticnihssrelationid(String prethrombolyticnihssrelationid) {
        this.prethrombolyticnihssrelationid = prethrombolyticnihssrelationid;
    }

    public String getThrombolyticaddress() {
        return thrombolyticaddress;
    }

    public void setThrombolyticaddress(String thrombolyticaddress) {
        this.thrombolyticaddress = thrombolyticaddress;
    }

    public String getEmergencynurseJmrs() {
        return emergencynurseJmrs;
    }

    public void setEmergencynurseJmrs(String emergencynurseJmrs) {
        this.emergencynurseJmrs = emergencynurseJmrs;
    }

    public String getThrombolyticdrug() {
        return thrombolyticdrug;
    }

    public void setThrombolyticdrug(String thrombolyticdrug) {
        this.thrombolyticdrug = thrombolyticdrug;
    }

    public String getThrombolyticdruguser() {
        return thrombolyticdruguser;
    }

    public void setThrombolyticdruguser(String thrombolyticdruguser) {
        this.thrombolyticdruguser = thrombolyticdruguser;
    }

    public String getThrombolyticstaticpushtime() {
        return thrombolyticstaticpushtime;
    }

    public void setThrombolyticstaticpushtime(String thrombolyticstaticpushtime) {
        this.thrombolyticstaticpushtime = thrombolyticstaticpushtime;
    }

    public String getThrombolyticont() {
        return thrombolyticont;
    }

    public void setThrombolyticont(String thrombolyticont) {
        this.thrombolyticont = thrombolyticont;
    }

    public String getThrombolyticdnt() {
        return thrombolyticdnt;
    }

    public void setThrombolyticdnt(String thrombolyticdnt) {
        this.thrombolyticdnt = thrombolyticdnt;
    }

    public String getIsthrombolyticrecanalization() {
        return isthrombolyticrecanalization;
    }

    public void setIsthrombolyticrecanalization(String isthrombolyticrecanalization) {
        this.isthrombolyticrecanalization = isthrombolyticrecanalization;
    }

    public String getThrombolyticcomplication() {
        return thrombolyticcomplication;
    }

    public void setThrombolyticcomplication(String thrombolyticcomplication) {
        this.thrombolyticcomplication = thrombolyticcomplication;
    }

    public String getOtherthrombolyticcomplication() {
        return otherthrombolyticcomplication;
    }

    public void setOtherthrombolyticcomplication(String otherthrombolyticcomplication) {
        this.otherthrombolyticcomplication = otherthrombolyticcomplication;
    }

    public String getPostthrombolyticnihss() {
        return postthrombolyticnihss;
    }

    public void setPostthrombolyticnihss(String postthrombolyticnihss) {
        this.postthrombolyticnihss = postthrombolyticnihss;
    }

    public String getPostthrombolyticnihssrelationid() {
        return postthrombolyticnihssrelationid;
    }

    public void setPostthrombolyticnihssrelationid(String postthrombolyticnihssrelationid) {
        this.postthrombolyticnihssrelationid = postthrombolyticnihssrelationid;
    }

    public String getAfterdaythrombolyticnihss() {
        return afterdaythrombolyticnihss;
    }

    public void setAfterdaythrombolyticnihss(String afterdaythrombolyticnihss) {
        this.afterdaythrombolyticnihss = afterdaythrombolyticnihss;
    }

    public String getAfterdaythrombolyticnihssrelationid() {
        return afterdaythrombolyticnihssrelationid;
    }

    public void setAfterdaythrombolyticnihssrelationid(String afterdaythrombolyticnihssrelationid) {
        this.afterdaythrombolyticnihssrelationid = afterdaythrombolyticnihssrelationid;
    }

    public String getAfterweekthrombolyticnihss() {
        return afterweekthrombolyticnihss;
    }

    public void setAfterweekthrombolyticnihss(String afterweekthrombolyticnihss) {
        this.afterweekthrombolyticnihss = afterweekthrombolyticnihss;
    }

    public String getAfterweekthrombolyticnihssrelationid() {
        return afterweekthrombolyticnihssrelationid;
    }

    public void setAfterweekthrombolyticnihssrelationid(String afterweekthrombolyticnihssrelationid) {
        this.afterweekthrombolyticnihssrelationid = afterweekthrombolyticnihssrelationid;
    }

    public String getThrombolyticisdelay() {
        return thrombolyticisdelay;
    }

    public void setThrombolyticisdelay(String thrombolyticisdelay) {
        this.thrombolyticisdelay = thrombolyticisdelay;
    }

    public String getThrombolyticdelayreason() {
        return thrombolyticdelayreason;
    }

    public void setThrombolyticdelayreason(String thrombolyticdelayreason) {
        this.thrombolyticdelayreason = thrombolyticdelayreason;
    }

    public String getNotembolectomyreason() {
        return notembolectomyreason;
    }

    public void setNotembolectomyreason(String notembolectomyreason) {
        this.notembolectomyreason = notembolectomyreason;
    }

    public String getThrombolysisstarttime() {
        return thrombolysisstarttime;
    }

    public void setThrombolysisstarttime(String thrombolysisstarttime) {
        this.thrombolysisstarttime = thrombolysisstarttime;
    }

    public String getThrombolyticdosetype() {
        return thrombolyticdosetype;
    }

    public void setThrombolyticdosetype(String thrombolyticdosetype) {
        this.thrombolyticdosetype = thrombolyticdosetype;
    }

    public String getTHROMBOLYSISESTIMATEDDRUGDOSE() {
        return THROMBOLYSISESTIMATEDDRUGDOSE;
    }

    public void setTHROMBOLYSISESTIMATEDDRUGDOSE(String THROMBOLYSISESTIMATEDDRUGDOSE) {
        this.THROMBOLYSISESTIMATEDDRUGDOSE = THROMBOLYSISESTIMATEDDRUGDOSE;
    }

    public String getThrombolyticactualintravenousdose() {
        return thrombolyticactualintravenousdose;
    }

    public void setThrombolyticactualintravenousdose(String thrombolyticactualintravenousdose) {
        this.thrombolyticactualintravenousdose = thrombolyticactualintravenousdose;
    }

    public String getThrombolyticactualinfusiondose() {
        return thrombolyticactualinfusiondose;
    }

    public void setThrombolyticactualinfusiondose(String thrombolyticactualinfusiondose) {
        this.thrombolyticactualinfusiondose = thrombolyticactualinfusiondose;
    }

    public String getActualtotalmedication() {
        return actualtotalmedication;
    }

    public void setActualtotalmedication(String actualtotalmedication) {
        this.actualtotalmedication = actualtotalmedication;
    }

    public String getThrombolyticactualdosestandard() {
        return thrombolyticactualdosestandard;
    }

    public void setThrombolyticactualdosestandard(String thrombolyticactualdosestandard) {
        this.thrombolyticactualdosestandard = thrombolyticactualdosestandard;
    }

    public String getThrombolysisdrugdose() {
        return thrombolysisdrugdose;
    }

    public void setThrombolysisdrugdose(String thrombolysisdrugdose) {
        this.thrombolysisdrugdose = thrombolysisdrugdose;
    }

    public String getThrombolyticaddressnotinctreason() {
        return thrombolyticaddressnotinctreason;
    }

    public void setThrombolyticaddressnotinctreason(String thrombolyticaddressnotinctreason) {
        this.thrombolyticaddressnotinctreason = thrombolyticaddressnotinctreason;
    }
}
