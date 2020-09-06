package com.xyj.strokeaid.bean.dist;

/**
 * 狭窄程度
 *
 "FieldName": "DegreeOfArteryStenosis",
 "FieldLabel": "狭窄程度"
 */
@IDistFieldName(value = "DegreeOfArteryStenosis")
public class DisttStenosisDegreeBean  extends DistItemBaseBean{


    /**
     * cpc_xzcd_xy50 : <50%
     * cpc_xzcd_50z69 : 50~69%
     * cpc_xzcd_70z89 : 70~89%
     * cpc_xzcd_90z99 : 90~99%
     * cpc_xzcd_100 : 100%
     */

    private String cpc_xzcd_xy50;
    private String cpc_xzcd_50z69;
    private String cpc_xzcd_70z89;
    private String cpc_xzcd_90z99;
    private String cpc_xzcd_100;

    public String getCpc_xzcd_xy50() {
        return cpc_xzcd_xy50;
    }

    public void setCpc_xzcd_xy50(String cpc_xzcd_xy50) {
        this.cpc_xzcd_xy50 = cpc_xzcd_xy50;
    }

    public String getCpc_xzcd_50z69() {
        return cpc_xzcd_50z69;
    }

    public void setCpc_xzcd_50z69(String cpc_xzcd_50z69) {
        this.cpc_xzcd_50z69 = cpc_xzcd_50z69;
    }

    public String getCpc_xzcd_70z89() {
        return cpc_xzcd_70z89;
    }

    public void setCpc_xzcd_70z89(String cpc_xzcd_70z89) {
        this.cpc_xzcd_70z89 = cpc_xzcd_70z89;
    }

    public String getCpc_xzcd_90z99() {
        return cpc_xzcd_90z99;
    }

    public void setCpc_xzcd_90z99(String cpc_xzcd_90z99) {
        this.cpc_xzcd_90z99 = cpc_xzcd_90z99;
    }

    public String getCpc_xzcd_100() {
        return cpc_xzcd_100;
    }

    public void setCpc_xzcd_100(String cpc_xzcd_100) {
        this.cpc_xzcd_100 = cpc_xzcd_100;
    }
}
