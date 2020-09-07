package com.xyj.strokeaid.bean.dist;

/**
 * "FieldName": "TIMIBefore",
 * "FieldLabel": "造影时TIMI血流",
 */

@IDistFieldName(value = "TIMIBefore")
public class DistTIMIBeforeBean extends DistItemBaseBean{


    /**
     * cpc_timi_0 : 0级
     * cpc_timi_1 : 1级
     * cpc_timi_2 : 2级
     * cpc_timi_3 : 3级
     */

    private String cpc_timi_0;
    private String cpc_timi_1;
    private String cpc_timi_2;
    private String cpc_timi_3;

    public String getCpc_timi_0() {
        return cpc_timi_0;
    }

    public void setCpc_timi_0(String cpc_timi_0) {
        this.cpc_timi_0 = cpc_timi_0;
    }

    public String getCpc_timi_1() {
        return cpc_timi_1;
    }

    public void setCpc_timi_1(String cpc_timi_1) {
        this.cpc_timi_1 = cpc_timi_1;
    }

    public String getCpc_timi_2() {
        return cpc_timi_2;
    }

    public void setCpc_timi_2(String cpc_timi_2) {
        this.cpc_timi_2 = cpc_timi_2;
    }

    public String getCpc_timi_3() {
        return cpc_timi_3;
    }

    public void setCpc_timi_3(String cpc_timi_3) {
        this.cpc_timi_3 = cpc_timi_3;
    }
}
