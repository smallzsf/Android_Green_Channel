package com.xyj.strokeaid.bean;

/**
 * ASPECT
 */
public class AspectPo {

    /**
     * ID
     */
    //@TableField(value = "ID")
    public String id;
    
    /**
     * 1-CT，2-MRI
     */
    //@TableField(value = "TYPE")
    public String type;
    
    /**
     * 尾状核（C） 0、1
     */
    //@TableField(value = "ASPECT_BEFORE_C")
    public String aspectBeforeC;
    
    /**
     * 豆状核（L） 0、1
     */
    //@TableField(value = "ASPECT_BEFORE_L")
    public String aspectBeforeL;
    
    /**
     * 内囊（IC） 0、1
     */
    //@TableField(value = "ASPECT_BEFORE_IC")
    public String aspectBeforeIc;
    
    /**
     * 大脑中动脉前皮质区（M1）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M1")
    public String aspectBeforeM1;
    
    /**
     * 岛叶皮质（I）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_I")
    public String aspectBeforeI;
    
    /**
     * 大脑中动脉岛叶外侧皮质区（M2）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M2")
    public String aspectBeforeM2;
    
    /**
     * 大脑中动脉后皮层区（M3）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M3")
    public String aspectBeforeM3;
    
    /**
     * M1上方的大脑中动脉皮层（M4）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M4")
    public String aspectBeforeM4;
    
    /**
     * M2上方的大脑中动脉皮层（M5）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M5")
    public String aspectBeforeM5;
    
    /**
     * M3上方的大脑中动脉皮层（M6）0、1
     */
    //@TableField(value = "ASPECT_BEFORE_M6")
    public String aspectBeforeM6;
    
    /**
     * 以上区域均无异常
     */
    //@TableField(value = "ASPECT_BEFORE_NONE")
    public String aspectBeforeNone;
    
    /**
     * 脑桥任何部位 0、2
     */
    //@TableField(value = "ASPECT_AFTER_PONS")
    public String aspectAfterPons;
    
    /**
     * 中脑任何部位 0、2
     */
    //@TableField(value = "ASPECT_AFTER_MIDBRAIN")
    public String aspectAfterMidbrain;
    
    /**
     * 左侧小脑0、1
     */
    //@TableField(value = "ASPECT_AFTER_CEREBELLUMLEFT")
    public String aspectAfterCerebellumleft;
    
    /**
     * 右侧小脑0、1
     */
    //@TableField(value = "ASPECT_AFTER_CEREBELLUMRIGHT")
    public String aspectAfterCerebellumright;
    
    /**
     * 左侧丘脑0、1
     */
    //@TableField(value = "ASPECT_AFTER_MIDBRAINLEFT")
    public String aspectAfterMidbrainleft;
    
    /**
     * 右侧丘脑0、1
     */
    //@TableField(value = "ASPECT_AFTER_MIDBRAINRIGHT")
    public String aspectAfterMidbrainright;
    
    /**
     * 左侧大脑后动脉供血区
     */
    //@TableField(value = "ASPECT_AFTER_BRAINARTERYLEFT")
    public String aspectAfterBrainarteryleft;
    
    /**
     * 右侧大脑后动脉供血区
     */
    //@TableField(value = "ASPECT_AFTER_BRAINARTERYRIGHT")
    public String aspectAfterBrainarteryright;
    
    /**
     * 以上区域均无异常
     */
    //@TableField(value = "ASPECT_AFTER_NONE")
    public String aspectAfterNone;
    
    /**
     * 前循环得分
     */
    //@TableField(value = "SCORE_BEFORE")
    public String scoreBefore;
    
    /**
     * 后循环得分
     */
    //@TableField(value = "SCORE_AFTER")
    public String scoreAfter;
    
    /**
     * 评分时间
     */
    //@TableField(value = "CREATE_TIME")
    public String createTime;
    
    /**
     * 评分人
     */
    //@TableField(value = "CREATE_BY")
    public String createBy;
    
    /**
     * 
     */
    //@TableField(value = "CREATE_BY_NAME")
    public String createByName;


}