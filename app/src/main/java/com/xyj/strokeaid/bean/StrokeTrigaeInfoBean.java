package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;

/**
 * StrokeTrigaeInfoBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class StrokeTrigaeInfoBean extends ChestPainTriageInfoBean {

    public StrokeTrigaeInfoBean() {
        super();
    }

    /**
     * 卒中医生接诊
     */
    public String strokedoctorreceptiontime;
    /**
     * 卒中医生
     */
    public String strokedoctorreception;

    public String getStrokedoctorreceptiontime() {
        return strokedoctorreceptiontime;
    }

    public void setStrokedoctorreceptiontime(String strokedoctorreceptiontime) {
        this.strokedoctorreceptiontime = strokedoctorreceptiontime;
    }

    public String getStrokedoctorreception() {
        return strokedoctorreception;
    }

    public void setStrokedoctorreception(String strokedoctorreception) {
        this.strokedoctorreception = strokedoctorreception;
    }

}

    
    
       
    