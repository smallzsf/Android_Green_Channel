package com.xyj.strokeaid.bean.chestpain;

import java.util.List;

/**
 * ChestPainTriageInfoBean
 * description: 胸痛 -- 分诊信息  -- bean
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class ChestPainTriageInfoBean {

    /**
     * app
     * 患者到院时间
     * 后台
     * 来院方式-患者到院时间(到达医院大门时间)
     */
    private String arrivegatetime;
    /**
     * app
     * 患者到达急诊
     * 后台
     * 来院方式-患者到达急诊时间
     */
    private String arrivedertime;
    /**
     * app
     * 急诊分诊时间
     * 后台
     * 来院方式-接诊时间
     */
    private String receptiontime;

    /**
     * app
     * 急诊分诊护士
     * 后台
     * 来院方式-接诊护士
     */
    private String emergencynursereception;
    /**
     * app
     * 接诊地点
     * 后台
     * 来院方式-接诊地点
     */
    private String receptionlocation;
    /**
     * app
     * 急诊医生接诊
     * 后台
     * 来院方式-急诊医生接诊
     */
    private String emergencydoctorreceptiontime;
    /**
     * app
     * 急诊医生
     * 后台
     * 来院方式-急诊医生
     */
    private String emergencydoctorreception;

}

    
    
       
    