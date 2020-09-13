package com.xyj.strokeaid.bean.score;

import com.xyj.strokeaid.bean.BaseResponseBean;

import java.util.Date;

/**
 * 介入治疗适应症评估
 */
//@TableName("EMERGENCY_CENTER_STROKE_TOOL_EMBOLECTOMY_INDICATION")
public class MyindicationPo extends BaseResponseBean<MyindicationPo> {

    /**
     * 1.年龄在18岁以上。
     */
    //@TableField(value = "EMBOLECTOMY_INDICATION_AGE")
    private Integer embolectomyIndicationAge;
    
    /**
     * 2.大血管闭塞卒中患者应尽早实施血管内介入治疗。前循环闭塞发病6h以内，推荐血管介入治疗；前循环闭塞发病在6~24h，经过严格的影像学筛选，推荐血管介入治疗；后循环大血管闭塞发病在24h以内，可行血管介入治疗。
     */
    //@TableField(value = "EMBOLECTOMY_INDICATION_TIME")
    private Integer embolectomyIndicationTime;
    
    /**
     * 3.CT排除颅内出血、蛛网膜下腔出血。
     */
    //@TableField(value = "EMBOLECTOMY_INDICATION_EXCLUDE")
    private Integer embolectomyIndicationExclude;
    
    /**
     * 4.急性缺血性脑卒中，影像学检查证实为大血管闭塞。
     */
    //@TableField(value = "EMBOLECTOMY_INDICATION_DXGBS")
    private Integer embolectomyIndicationDxgbs;
    
    /**
     * 5.患者或法定代理人签署知情同意书。
     */
    //@TableField(value = "EMBOLECTOMY_INDICATION_AGREE")
    private Integer embolectomyIndicationAgree;
    
    /**
     * 总分
     */
    //@TableField(value = "SCORE")
    private Integer score;
    
    /**
     * 
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


    public Integer getEmbolectomyIndicationAge() {
        return embolectomyIndicationAge;
    }

    public void setEmbolectomyIndicationAge(Integer embolectomyIndicationAge) {
        this.embolectomyIndicationAge = embolectomyIndicationAge;
    }

    public Integer getEmbolectomyIndicationTime() {
        return embolectomyIndicationTime;
    }

    public void setEmbolectomyIndicationTime(Integer embolectomyIndicationTime) {
        this.embolectomyIndicationTime = embolectomyIndicationTime;
    }

    public Integer getEmbolectomyIndicationExclude() {
        return embolectomyIndicationExclude;
    }

    public void setEmbolectomyIndicationExclude(Integer embolectomyIndicationExclude) {
        this.embolectomyIndicationExclude = embolectomyIndicationExclude;
    }

    public Integer getEmbolectomyIndicationDxgbs() {
        return embolectomyIndicationDxgbs;
    }

    public void setEmbolectomyIndicationDxgbs(Integer embolectomyIndicationDxgbs) {
        this.embolectomyIndicationDxgbs = embolectomyIndicationDxgbs;
    }

    public Integer getEmbolectomyIndicationAgree() {
        return embolectomyIndicationAgree;
    }

    public void setEmbolectomyIndicationAgree(Integer embolectomyIndicationAgree) {
        this.embolectomyIndicationAgree = embolectomyIndicationAgree;
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
}