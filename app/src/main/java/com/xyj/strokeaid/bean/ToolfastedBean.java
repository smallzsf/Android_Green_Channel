package com.xyj.strokeaid.bean;

import java.util.Date;

/**
 * FAST-ED
 */

//@TableName("EMERGENCY_CENTER_STROKE_TOOL_FASTED")
public class ToolfastedBean {

    /**
     * ID
     */
    //@TableField(value = "ID")
    private String id;
    
    /**
     * 1.面瘫（
0=正常或轻微面瘫，1=部分或完全面瘫）
     */
    //@TableField(value = "FAST_FACIALPARALYSIS")
    private Integer fastFacialparalysis;
    
    /**
     * 2.上肢无力（0=无瘫痪，1=有瘫痪/抗部分重力，2=不能抗重力/无活动）
     */
    //@TableField(value = "FAST_WEAKNESS")
    private Integer fastWeakness;
    
    /**
     * 3.言语障碍（0=无语言障碍，1=轻-中度，2=严重，全面失语，缄默）
     */
    //@TableField(value = "FAST_LANGUAGEBARRIER")
    private Integer fastLanguagebarrier;
    
    /**
     * 4.眼球凝视（0=无，1=部分，2=强迫凝视）
     */
    //@TableField(value = "FAST_EYEBALLGAZE")
    private Integer fastEyeballgaze;
    
    /**
     * 5.失认/忽视（0=无，1=不能感知双侧同时的1种感觉刺激，2=不能识别自己的手或仅能感知一侧肢体）
     */
    //@TableField(value = "FAST_AGNOSIA")
    private Integer fastAgnosia;
    
    /**
     * 总分
     */
    //@TableField(value = "SCORE")
    private Integer score;
    
    /**
     * 等级说明
     */
    //@TableField(value = "LEVEL_DESC")
    private String levelDesc;
    
    /**
     * 评分世间
     */
    //@TableField(value = "CREATE_TIME")
    private Date createTime;
    
    /**
     * 评分人
     */
    //@TableField(value = "CREATE_BY")
    private String createBy;
    
    /**
     * 
     */
    //@TableField(value = "CREATE_BY_NAME")
    private String createByName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFastFacialparalysis() {
        return fastFacialparalysis;
    }

    public void setFastFacialparalysis(Integer fastFacialparalysis) {
        this.fastFacialparalysis = fastFacialparalysis;
    }

    public Integer getFastWeakness() {
        return fastWeakness;
    }

    public void setFastWeakness(Integer fastWeakness) {
        this.fastWeakness = fastWeakness;
    }

    public Integer getFastLanguagebarrier() {
        return fastLanguagebarrier;
    }

    public void setFastLanguagebarrier(Integer fastLanguagebarrier) {
        this.fastLanguagebarrier = fastLanguagebarrier;
    }

    public Integer getFastEyeballgaze() {
        return fastEyeballgaze;
    }

    public void setFastEyeballgaze(Integer fastEyeballgaze) {
        this.fastEyeballgaze = fastEyeballgaze;
    }

    public Integer getFastAgnosia() {
        return fastAgnosia;
    }

    public void setFastAgnosia(Integer fastAgnosia) {
        this.fastAgnosia = fastAgnosia;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    @Override
    public String toString() {
        return "ToolfastedPo{" +
                "fastFacialparalysis=" + fastFacialparalysis +
                ", fastWeakness=" + fastWeakness +
                ", fastLanguagebarrier=" + fastLanguagebarrier +
                ", fastEyeballgaze=" + fastEyeballgaze +
                ", fastAgnosia=" + fastAgnosia +
                '}';
    }
}