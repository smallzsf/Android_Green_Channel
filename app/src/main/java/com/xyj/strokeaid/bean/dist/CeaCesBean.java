package com.xyj.strokeaid.bean.dist;

/**
 * CeaCes网络请求实体类
 */
public class CeaCesBean {
    private String recordId;
    private String ceacaschooseway;//手术采取方式
    private String ceacascomplication;//并发症
    private String ceacasdelayreason;//延误原因
    private String ceacasischoosepatch;//是否采用补片
    private String ceacasisdelay;//救治是否延误
    private String ceacasmonitoringmeans;//实施的监测手段
    private String ceacasnarcosisway;//麻醉方式
    private String ceacasoperationpart;//手术部位
    private String ceacasoperationtime;//手术开始时间

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCeacaschooseway() {
        return ceacaschooseway;
    }

    public void setCeacaschooseway(String ceacaschooseway) {
        this.ceacaschooseway = ceacaschooseway;
    }

    public String getCeacascomplication() {
        return ceacascomplication;
    }

    public void setCeacascomplication(String ceacascomplication) {
        this.ceacascomplication = ceacascomplication;
    }

    public String getCeacasdelayreason() {
        return ceacasdelayreason;
    }

    public void setCeacasdelayreason(String ceacasdelayreason) {
        this.ceacasdelayreason = ceacasdelayreason;
    }

    public String getCeacasischoosepatch() {
        return ceacasischoosepatch;
    }

    public void setCeacasischoosepatch(String ceacasischoosepatch) {
        this.ceacasischoosepatch = ceacasischoosepatch;
    }

    public String getCeacasisdelay() {
        return ceacasisdelay;
    }

    public void setCeacasisdelay(String ceacasisdelay) {
        this.ceacasisdelay = ceacasisdelay;
    }

    public String getCeacasmonitoringmeans() {
        return ceacasmonitoringmeans;
    }

    public void setCeacasmonitoringmeans(String ceacasmonitoringmeans) {
        this.ceacasmonitoringmeans = ceacasmonitoringmeans;
    }

    public String getCeacasnarcosisway() {
        return ceacasnarcosisway;
    }

    public void setCeacasnarcosisway(String ceacasnarcosisway) {
        this.ceacasnarcosisway = ceacasnarcosisway;
    }

    public String getCeacasoperationpart() {
        return ceacasoperationpart;
    }

    public void setCeacasoperationpart(String ceacasoperationpart) {
        this.ceacasoperationpart = ceacasoperationpart;
    }

    public String getCeacasoperationtime() {
        return ceacasoperationtime;
    }

    public void setCeacasoperationtime(String ceacasoperationtime) {
        this.ceacasoperationtime = ceacasoperationtime;
    }
}
