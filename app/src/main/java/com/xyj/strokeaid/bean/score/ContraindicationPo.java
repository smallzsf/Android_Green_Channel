package com.xyj.strokeaid.bean.score;

/**
 * 介入治疗禁忌症评估
 */
//@TableName("EMERGENCY_CENTER_STROKE_TOOL_EMBOLECTOMY_CONTRAINDICATION")
public class ContraindicationPo   {

    /**

    /**
     * 1. 若进行动脉溶栓，参考静脉溶栓禁忌症标准
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_REFERENCE")
    private Integer embolectomyContraindicationReference;

    /**
     * 2. 活动性出血或已知有明显出血倾向者
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_HEMORRHAGE")
    private Integer embolectomyContraindicationHemorrhage;

    /**
     * 3. 严重心、肝、肾功能不全
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_DYSFUNCTION")
    private Integer embolectomyContraindicationDysfunction;

    /**
     * 4. 血糖<2.7mmol/L或> 22.2mmol/L
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_BLOODSUGAR")
    private Integer embolectomyContraindicationBloodsugar;

    /**
     * 5. 药物无法控制的严重高血压
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_UNCONTROL")
    private Integer embolectomyContraindicationUncontrol;

    /**
     * 6. 无以上禁忌症
     */
    //@TableField(value = "EMBOLECTOMY_CONTRAINDICATION_NONE")
    private Integer embolectomyContraindicationNone;

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
    private String createTime;

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

    public Integer getEmbolectomyContraindicationReference() {
        return embolectomyContraindicationReference;
    }

    public void setEmbolectomyContraindicationReference(Integer embolectomyContraindicationReference) {
        this.embolectomyContraindicationReference = embolectomyContraindicationReference;
    }

    public Integer getEmbolectomyContraindicationHemorrhage() {
        return embolectomyContraindicationHemorrhage;
    }

    public void setEmbolectomyContraindicationHemorrhage(Integer embolectomyContraindicationHemorrhage) {
        this.embolectomyContraindicationHemorrhage = embolectomyContraindicationHemorrhage;
    }

    public Integer getEmbolectomyContraindicationDysfunction() {
        return embolectomyContraindicationDysfunction;
    }

    public void setEmbolectomyContraindicationDysfunction(Integer embolectomyContraindicationDysfunction) {
        this.embolectomyContraindicationDysfunction = embolectomyContraindicationDysfunction;
    }

    public Integer getEmbolectomyContraindicationBloodsugar() {
        return embolectomyContraindicationBloodsugar;
    }

    public void setEmbolectomyContraindicationBloodsugar(Integer embolectomyContraindicationBloodsugar) {
        this.embolectomyContraindicationBloodsugar = embolectomyContraindicationBloodsugar;
    }

    public Integer getEmbolectomyContraindicationUncontrol() {
        return embolectomyContraindicationUncontrol;
    }

    public void setEmbolectomyContraindicationUncontrol(Integer embolectomyContraindicationUncontrol) {
        this.embolectomyContraindicationUncontrol = embolectomyContraindicationUncontrol;
    }

    public Integer getEmbolectomyContraindicationNone() {
        return embolectomyContraindicationNone;
    }

    public void setEmbolectomyContraindicationNone(Integer embolectomyContraindicationNone) {
        this.embolectomyContraindicationNone = embolectomyContraindicationNone;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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