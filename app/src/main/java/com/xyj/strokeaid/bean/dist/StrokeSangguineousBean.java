package com.xyj.strokeaid.bean.dist;

import com.xyj.strokeaid.base.BaseBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;

/**
 * 脑出血实体类
 */
public class StrokeSangguineousBean extends BaseBean {
    public String arrivetohemorrhageoperationbegintime;//脑出血手术到院至开始手术时间
    public String attacktohemorrhageoperationbegintime;//脑出血手术发病至开始手术时间
    public String hemorrhageoperationbegintime;//脑出血手术手术开始时间
    public String hemorrhageoperationcomplication;//脑出血手术脑部并发症
    public String hemorrhageoperationmode;//脑出血手术手术方式
    public String hemorrhageoperationprognosis;//脑出血手术预后
    public String operationanesthesiamode;//脑出血手术麻醉方式
    public String operationdelayreason;//脑出血手术延误原因
    public String operationisdelay;//脑出血手术是否延误
    public String otherhemorrhageoperationcomplication;//脑出血手术其他脑部并发症
    public String otherhemorrhageoperationmode;//脑出血手术其他手术方式

    public String getArrivetohemorrhageoperationbegintime() {
        return arrivetohemorrhageoperationbegintime;
    }

    public void setArrivetohemorrhageoperationbegintime(String arrivetohemorrhageoperationbegintime) {
        this.arrivetohemorrhageoperationbegintime = arrivetohemorrhageoperationbegintime;
    }

    public String getAttacktohemorrhageoperationbegintime() {
        return attacktohemorrhageoperationbegintime;
    }

    public void setAttacktohemorrhageoperationbegintime(String attacktohemorrhageoperationbegintime) {
        this.attacktohemorrhageoperationbegintime = attacktohemorrhageoperationbegintime;
    }

    public String getHemorrhageoperationbegintime() {
        return hemorrhageoperationbegintime;
    }

    public void setHemorrhageoperationbegintime(String hemorrhageoperationbegintime) {
        this.hemorrhageoperationbegintime = hemorrhageoperationbegintime;
    }

    public String getHemorrhageoperationcomplication() {
        return hemorrhageoperationcomplication;
    }

    public void setHemorrhageoperationcomplication(String hemorrhageoperationcomplication) {
        this.hemorrhageoperationcomplication = hemorrhageoperationcomplication;
    }

    public String getHemorrhageoperationmode() {
        return hemorrhageoperationmode;
    }

    public void setHemorrhageoperationmode(String hemorrhageoperationmode) {
        this.hemorrhageoperationmode = hemorrhageoperationmode;
    }

    public String getHemorrhageoperationprognosis() {
        return hemorrhageoperationprognosis;
    }

    public void setHemorrhageoperationprognosis(String hemorrhageoperationprognosis) {
        this.hemorrhageoperationprognosis = hemorrhageoperationprognosis;
    }

    public String getOperationanesthesiamode() {
        return operationanesthesiamode;
    }

    public void setOperationanesthesiamode(String operationanesthesiamode) {
        this.operationanesthesiamode = operationanesthesiamode;
    }

    public String getOperationdelayreason() {
        return operationdelayreason;
    }

    public void setOperationdelayreason(String operationdelayreason) {
        this.operationdelayreason = operationdelayreason;
    }

    public String getOperationisdelay() {
        return operationisdelay;
    }

    public void setOperationisdelay(String operationisdelay) {
        this.operationisdelay = operationisdelay;
    }

    public String getOtherhemorrhageoperationcomplication() {
        return otherhemorrhageoperationcomplication;
    }

    public void setOtherhemorrhageoperationcomplication(String otherhemorrhageoperationcomplication) {
        this.otherhemorrhageoperationcomplication = otherhemorrhageoperationcomplication;
    }

    public String getOtherhemorrhageoperationmode() {
        return otherhemorrhageoperationmode;
    }

    public void setOtherhemorrhageoperationmode(String otherhemorrhageoperationmode) {
        this.otherhemorrhageoperationmode = otherhemorrhageoperationmode;
    }

    @Override
    public String toString() {
        return "StrokeSangguineousBean{" +
                "arrivetohemorrhageoperationbegintime='" + arrivetohemorrhageoperationbegintime + '\'' +
                ", attacktohemorrhageoperationbegintime='" + attacktohemorrhageoperationbegintime + '\'' +
                ", hemorrhageoperationbegintime='" + hemorrhageoperationbegintime + '\'' +
                ", hemorrhageoperationcomplication='" + hemorrhageoperationcomplication + '\'' +
                ", hemorrhageoperationmode='" + hemorrhageoperationmode + '\'' +
                ", hemorrhageoperationprognosis='" + hemorrhageoperationprognosis + '\'' +
                ", operationanesthesiamode='" + operationanesthesiamode + '\'' +
                ", operationdelayreason='" + operationdelayreason + '\'' +
                ", operationisdelay='" + operationisdelay + '\'' +
                ", otherhemorrhageoperationcomplication='" + otherhemorrhageoperationcomplication + '\'' +
                ", otherhemorrhageoperationmode='" + otherhemorrhageoperationmode + '\'' +
                '}';
    }
}
