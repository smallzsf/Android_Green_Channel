package com.xyj.strokeaid.activity.stroke;


import java.io.Serializable;
import java.util.Date;

/**
 * 卒中记录表-动脉瘤手术
 */
public class EmergencyCenterStrokeAneurysmSurgeryPoBean implements Serializable {
    public EmergencyCenterStrokeAneurysmSurgeryPoBean() {
        super();
    }

    public EmergencyCenterStrokeAneurysmSurgeryPoBean(String recordId, String aneurysmpart, String aneurysmica, String aneurysmaca, String aneurysmmca, String aneurysmva, String aneurysmpca, String aneurysmba, String aneurysmotherpart, String aneurysmlength, String aneurysmwidth, String aneurysmheight, String aneurysmradius, String aneurysmtype, String aneurysmoperationisdone, String aneurysmoperationtype, String aneurysmoperationtime, String aneurysmoperationisdelay, String aneurysmoperationdelayreason, String aneurysmside) {
        this.recordId = recordId;
        this.aneurysmpart = aneurysmpart;
        this.aneurysmica = aneurysmica;
        this.aneurysmaca = aneurysmaca;
        this.aneurysmmca = aneurysmmca;
        this.aneurysmva = aneurysmva;
        this.aneurysmpca = aneurysmpca;
        this.aneurysmba = aneurysmba;
        this.aneurysmotherpart = aneurysmotherpart;
        this.aneurysmlength = aneurysmlength;
        this.aneurysmwidth = aneurysmwidth;
        this.aneurysmheight = aneurysmheight;
        this.aneurysmradius = aneurysmradius;
        this.aneurysmtype = aneurysmtype;
        this.aneurysmoperationisdone = aneurysmoperationisdone;
        this.aneurysmoperationtype = aneurysmoperationtype;
        this.aneurysmoperationtime = aneurysmoperationtime;
        this.aneurysmoperationisdelay = aneurysmoperationisdelay;
        this.aneurysmoperationdelayreason = aneurysmoperationdelayreason;
        this.aneurysmside = aneurysmside;
    }

    /**
     * 记录ID
     */
    //@TableField(value = "RECORD_ID")
    private String recordId;

    /**
     * 动脉瘤手术-部位
     */
    //@TableField(value = "ANEURYSMPART")
    private String aneurysmpart;

    /**
     * 动脉瘤手术-颈内动脉ICA
     */
    //@TableField(value = "ANEURYSMICA")
    private String aneurysmica;

    /**
     * 动脉瘤手术-大脑前动脉ACA
     */
    //@TableField(value = "ANEURYSMACA")
    private String aneurysmaca;

    /**
     * 动脉瘤手术-大脑中动脉MCA
     */
    //@TableField(value = "ANEURYSMMCA")
    private String aneurysmmca;

    /**
     * 动脉瘤手术-椎动脉VA
     */
    //@TableField(value = "ANEURYSMVA")
    private String aneurysmva;

    /**
     * 动脉瘤手术-大脑后动脉PCA
     */
    //@TableField(value = "ANEURYSMPCA")
    private String aneurysmpca;

    /**
     * 动脉瘤手术-基底动脉BA
     */
    //@TableField(value = "ANEURYSMBA")
    private String aneurysmba;

    /**
     * 动脉瘤手术-其他具体部位
     */
    //@TableField(value = "ANEURYSMOTHERPART")
    private String aneurysmotherpart;

    /**
     * 动脉瘤手术-长
     */
    //@TableField(value = "ANEURYSMLENGTH")
    private String aneurysmlength;

    /**
     * 动脉瘤手术-宽
     */
    //@TableField(value = "ANEURYSMWIDTH")
    private String aneurysmwidth;

    /**
     * 动脉瘤手术-高
     */
    //@TableField(value = "ANEURYSMHEIGHT")
    private String aneurysmheight;

    /**
     * 动脉瘤手术-瘤颈
     */
    //@TableField(value = "ANEURYSMRADIUS")
    private String aneurysmradius;

    /**
     * 动脉瘤手术-类型
     */
    //@TableField(value = "ANEURYSMTYPE")
    private String aneurysmtype;

    /**
     * 动脉瘤手术-是否手术
     */
    //@TableField(value = "ANEURYSMOPERATIONISDONE")
    private String aneurysmoperationisdone;

    /**
     * 动脉瘤手术-手术类型
     */
    //@TableField(value = "ANEURYSMOPERATIONTYPE")
    private String aneurysmoperationtype;

    /**
     * 动脉瘤手术-手术时间
     */
    //@TableField(value = "ANEURYSMOPERATIONTIME")
    private String aneurysmoperationtime;

    /**
     * 动脉瘤手术-救治是否延误
     */
    //@TableField(value = "ANEURYSMOPERATIONISDELAY")
    private String aneurysmoperationisdelay;

    /**
     * 动脉瘤手术-动脉瘤手术延误原因
     */
    //@TableField(value = "ANEURYSMOPERATIONDELAYREASON")
    private String aneurysmoperationdelayreason;

    /**
     * 动脉瘤手术-侧别
     */
    //@TableField(value = "ANEURYSMSIDE")
    private String aneurysmside;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getAneurysmpart() {
        return aneurysmpart;
    }

    public void setAneurysmpart(String aneurysmpart) {
        this.aneurysmpart = aneurysmpart;
    }

    public String getAneurysmica() {
        return aneurysmica;
    }

    public void setAneurysmica(String aneurysmica) {
        this.aneurysmica = aneurysmica;
    }

    public String getAneurysmaca() {
        return aneurysmaca;
    }

    public void setAneurysmaca(String aneurysmaca) {
        this.aneurysmaca = aneurysmaca;
    }

    public String getAneurysmmca() {
        return aneurysmmca;
    }

    public void setAneurysmmca(String aneurysmmca) {
        this.aneurysmmca = aneurysmmca;
    }

    public String getAneurysmva() {
        return aneurysmva;
    }

    public void setAneurysmva(String aneurysmva) {
        this.aneurysmva = aneurysmva;
    }

    public String getAneurysmpca() {
        return aneurysmpca;
    }

    public void setAneurysmpca(String aneurysmpca) {
        this.aneurysmpca = aneurysmpca;
    }

    public String getAneurysmba() {
        return aneurysmba;
    }

    public void setAneurysmba(String aneurysmba) {
        this.aneurysmba = aneurysmba;
    }

    public String getAneurysmotherpart() {
        return aneurysmotherpart;
    }

    public void setAneurysmotherpart(String aneurysmotherpart) {
        this.aneurysmotherpart = aneurysmotherpart;
    }

    public String getAneurysmlength() {
        return aneurysmlength;
    }

    public void setAneurysmlength(String aneurysmlength) {
        this.aneurysmlength = aneurysmlength;
    }

    public String getAneurysmwidth() {
        return aneurysmwidth;
    }

    public void setAneurysmwidth(String aneurysmwidth) {
        this.aneurysmwidth = aneurysmwidth;
    }

    public String getAneurysmheight() {
        return aneurysmheight;
    }

    public void setAneurysmheight(String aneurysmheight) {
        this.aneurysmheight = aneurysmheight;
    }

    public String getAneurysmradius() {
        return aneurysmradius;
    }

    public void setAneurysmradius(String aneurysmradius) {
        this.aneurysmradius = aneurysmradius;
    }

    public String getAneurysmtype() {
        return aneurysmtype;
    }

    public void setAneurysmtype(String aneurysmtype) {
        this.aneurysmtype = aneurysmtype;
    }

    public String getAneurysmoperationisdone() {
        return aneurysmoperationisdone;
    }

    public void setAneurysmoperationisdone(String aneurysmoperationisdone) {
        this.aneurysmoperationisdone = aneurysmoperationisdone;
    }

    public String getAneurysmoperationtype() {
        return aneurysmoperationtype;
    }

    public void setAneurysmoperationtype(String aneurysmoperationtype) {
        this.aneurysmoperationtype = aneurysmoperationtype;
    }

    public String getAneurysmoperationtime() {
        return aneurysmoperationtime;
    }

    public void setAneurysmoperationtime(String aneurysmoperationtime) {
        this.aneurysmoperationtime = aneurysmoperationtime;
    }

    public String getAneurysmoperationisdelay() {
        return aneurysmoperationisdelay;
    }

    public void setAneurysmoperationisdelay(String aneurysmoperationisdelay) {
        this.aneurysmoperationisdelay = aneurysmoperationisdelay;
    }

    public String getAneurysmoperationdelayreason() {
        return aneurysmoperationdelayreason;
    }

    public void setAneurysmoperationdelayreason(String aneurysmoperationdelayreason) {
        this.aneurysmoperationdelayreason = aneurysmoperationdelayreason;
    }

    public String getAneurysmside() {
        return aneurysmside;
    }

    public void setAneurysmside(String aneurysmside) {
        this.aneurysmside = aneurysmside;
    }
}
