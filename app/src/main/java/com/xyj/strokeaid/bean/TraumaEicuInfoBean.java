package com.xyj.strokeaid.bean;

public class TraumaEicuInfoBean {

    private String recordId;
    /**
     * 患者到达时间
     */
    private String eicuicupatientarrivaltime;

    /**
     * 意识（1.清醒，2。嗜睡，3.意识模糊，4。昏睡，5。谵妄）
     */
    private String eicuicuconsciousness;

    /**
     * 处置方式  1.心肺复苏，2。气管插管，3.呼吸及支持，4。闭式引流，5。气管切管，6.深静脉置入，7。心包穿刺
     */
    private String eicuicuemergencyprocessway;

    /**
     * 胸穿血液量ml
     */
    private String eicuicuthoracentesisbloodvolume;

    /**
     * 胸穿血液颜色
     */
    private String eicuicuthoracentesbloodcolor;

    /**
     * 其他胸穿血液颜色
     */
    private String othereicuicuthoracentesbloodcolor;

    /**
     * 腹穿血液量ml
     */
    private String eicuicuperitoneocentesisbloodvolume;

    /**
     * 腹穿血液颜色
     */
    private String eicuicuperitoneocentesisbloodcolor;

    /**
     * 其他腹穿血液颜色
     */
    private String othereicuicuperitoneocentesisbloodcolor;

    /**
     * 1配血，2凝血四项，3血常规，4血生化，5肝肾功能，6血糖，7传染病9项
     */
    private String eiuciuccheckoutitems;

    /**
     * eicu/icu-转出信息（1手术室，2.专科病房）
     */
    private String eicuicuoutcomeinfomation;

    /**
     * 离开icu时间
     */
    private String eicuiculeavetime;

    /**
     * 离开时患者意识（1.清醒，2。嗜睡，3.意识模糊，4。昏睡，5。谵妄）
     */
    private String eicuiculeaveconsciousness;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getEicuicupatientarrivaltime() {
        return eicuicupatientarrivaltime;
    }

    public void setEicuicupatientarrivaltime(String eicuicupatientarrivaltime) {
        this.eicuicupatientarrivaltime = eicuicupatientarrivaltime;
    }

    public String getEicuicuconsciousness() {
        return eicuicuconsciousness;
    }

    public void setEicuicuconsciousness(String eicuicuconsciousness) {
        this.eicuicuconsciousness = eicuicuconsciousness;
    }

    public String getEicuicuemergencyprocessway() {
        return eicuicuemergencyprocessway;
    }

    public void setEicuicuemergencyprocessway(String eicuicuemergencyprocessway) {
        this.eicuicuemergencyprocessway = eicuicuemergencyprocessway;
    }

    public String getEicuicuthoracentesisbloodvolume() {
        return eicuicuthoracentesisbloodvolume;
    }

    public void setEicuicuthoracentesisbloodvolume(String eicuicuthoracentesisbloodvolume) {
        this.eicuicuthoracentesisbloodvolume = eicuicuthoracentesisbloodvolume;
    }

    public String getEicuicuthoracentesbloodcolor() {
        return eicuicuthoracentesbloodcolor;
    }

    public void setEicuicuthoracentesbloodcolor(String eicuicuthoracentesbloodcolor) {
        this.eicuicuthoracentesbloodcolor = eicuicuthoracentesbloodcolor;
    }

    public String getOthereicuicuthoracentesbloodcolor() {
        return othereicuicuthoracentesbloodcolor;
    }

    public void setOthereicuicuthoracentesbloodcolor(String othereicuicuthoracentesbloodcolor) {
        this.othereicuicuthoracentesbloodcolor = othereicuicuthoracentesbloodcolor;
    }

    public String getEicuicuperitoneocentesisbloodvolume() {
        return eicuicuperitoneocentesisbloodvolume;
    }

    public void setEicuicuperitoneocentesisbloodvolume(String eicuicuperitoneocentesisbloodvolume) {
        this.eicuicuperitoneocentesisbloodvolume = eicuicuperitoneocentesisbloodvolume;
    }

    public String getEicuicuperitoneocentesisbloodcolor() {
        return eicuicuperitoneocentesisbloodcolor;
    }

    public void setEicuicuperitoneocentesisbloodcolor(String eicuicuperitoneocentesisbloodcolor) {
        this.eicuicuperitoneocentesisbloodcolor = eicuicuperitoneocentesisbloodcolor;
    }

    public String getOthereicuicuperitoneocentesisbloodcolor() {
        return othereicuicuperitoneocentesisbloodcolor;
    }

    public void setOthereicuicuperitoneocentesisbloodcolor(String othereicuicuperitoneocentesisbloodcolor) {
        this.othereicuicuperitoneocentesisbloodcolor = othereicuicuperitoneocentesisbloodcolor;
    }

    public String getEiuciuccheckoutitems() {
        return eiuciuccheckoutitems;
    }

    public void setEiuciuccheckoutitems(String eiuciuccheckoutitems) {
        this.eiuciuccheckoutitems = eiuciuccheckoutitems;
    }

    public String getEicuicuoutcomeinfomation() {
        return eicuicuoutcomeinfomation;
    }

    public void setEicuicuoutcomeinfomation(String eicuicuoutcomeinfomation) {
        this.eicuicuoutcomeinfomation = eicuicuoutcomeinfomation;
    }

    public String getEicuiculeavetime() {
        return eicuiculeavetime;
    }

    public void setEicuiculeavetime(String eicuiculeavetime) {
        this.eicuiculeavetime = eicuiculeavetime;
    }

    public String getEicuiculeaveconsciousness() {
        return eicuiculeaveconsciousness;
    }

    public void setEicuiculeaveconsciousness(String eicuiculeaveconsciousness) {
        this.eicuiculeaveconsciousness = eicuiculeaveconsciousness;
    }
}
