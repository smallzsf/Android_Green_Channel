package com.xyj.strokeaid.bean;

import java.util.Date;

/**
 * MRS
 */
//@TableName("EMERGENCY_CENTER_STROKE_TOOL_MRS")
public class MrsBean {

    /**
     * ID
     */
    //@TableField(value = "ID")
    private String id;
    
    /**
     * 0-6
     */
    //@TableField(value = "MRS")
    private Integer mrs;
    
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
    
}