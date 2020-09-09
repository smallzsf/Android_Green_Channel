package com.xyj.strokeaid.bean.chestpain;


import com.xyj.strokeaid.base.BaseBean;

/**
 * 
 */
public class EmergencyCenterChestpainDrugPo extends BaseBean<EmergencyCenterChestpainDrugPo> {

    /**
     * 
     */
    private String id;
    
    /**
     * 
     */
    private String recordId;
    
    /**
     * 抗血小板治疗（"cpc_bool_true": "是",
                "cpc_bool_false": "否"）
     */
    private String isacsantiplateletmedicine;
    
    /**
     * 抗血小板治疗-（是）-阿司匹林（"cpc_aspirindosage_0mg": "0mg",
                "cpc_aspirindosage_100mg": "100mg",
                "cpc_aspirindosage_300mg": "300mg",
                "cpc_aspirindosage_other": "其它剂量"）
     */
    private String acsaspirindosage;
    
    /**
     * 阿司匹林-（其他剂量）-阿司匹林其他剂量
     */
    private String otheracsaspirindosage;
    
    /**
     * 阿司匹林服用时间
     */
    private String acsaspirintime;
    
    /**
     * 氯吡格雷（"cpc_chlorpyridindosage_0mg": "0mg",
                "cpc_chlorpyridindosage_300mg": "300mg",
                "cpc_chlorpyridindosage_600mg": "600mg",
                "cpc_chlorpyridindosage_other": "其它剂量"）
     */
    private String acschlorpyridindosage;
    
    /**
     * 氯吡格雷-（其他剂量）-氯吡格雷其他剂量
     */
    private String otheracschlorpyridindosage;
    
    /**
     * 氯呲格雷服用时间
     */
    private String acschlorpyridintime;
    
    /**
     * 替格瑞洛（"cpc_tigrilodosage_0mg": "0mg",
                "cpc_tigrilodosage_90mg": "90mg",
                "cpc_tigrilodosage_180mg": "180mg",
                "cpc_tigrilodosage_other": "其它剂量"）
     */
    private String acstigrilodosage;
    
    /**
     * 替格瑞洛-（其他剂量）-替格瑞洛其他剂量
     */
    private String otheracstigrilodosage;
    
    /**
     * 替格瑞洛服用时间
     */
    private String acstigrilotime;
    
    /**
     * 抗凝（"cpc_bool_true": "是",
                "cpc_bool_false": "否"）
     */
    private String acsisanticoagulantmedicine;
    
    /**
     * 抗凝-（是）-抗凝给药（"cpc_knyw_ptgs": "普通肝素",
                "cpc_knyw_dfzgs": "低分子肝素",
                "cpc_knyw_bfrd": "比伐卢定",
                "cpc_knyw_hdgkn": "磺达肝癸钠"）
     */
    private String acsanticoagulationdrug;
    
    /**
     * 抗凝剂量
     */
    private String acsanticoagulationdrugdosage;
    
    /**
     * 康宁单位
     */
    private String acsanticoagulationdrugunit;
    
    /**
     * 抗凝给药时间
     */
    private String acsanticoagulantmedicinetime;
    
    /**
     * 他汀治疗（"cpc_bool_true": "是",
                "cpc_bool_false": "否"）
     */
    private String is24intensivestatin;
    
    /**
     * 他汀治疗-（是）阿托伐他汀（剂量）
     */
    private String acsatorvastatindosage;
    
    /**
     * 瑞舒伐他汀（剂量）
     */
    private String acsrosuvastatindosage;
    
    /**
     * β受体阻滞剂（"cpc_bool_true": "是",
                "cpc_bool_false": "否"）
     */
    private String isusebetablocker;
    
    /**
     * ACEI/ARB（"cpc_bool_true": "是",
                "cpc_bool_false": "否"）
     */
    private String acsisaceiarb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getIsacsantiplateletmedicine() {
        return isacsantiplateletmedicine;
    }

    public void setIsacsantiplateletmedicine(String isacsantiplateletmedicine) {
        this.isacsantiplateletmedicine = isacsantiplateletmedicine;
    }

    public String getAcsaspirindosage() {
        return acsaspirindosage;
    }

    public void setAcsaspirindosage(String acsaspirindosage) {
        this.acsaspirindosage = acsaspirindosage;
    }

    public String getOtheracsaspirindosage() {
        return otheracsaspirindosage;
    }

    public void setOtheracsaspirindosage(String otheracsaspirindosage) {
        this.otheracsaspirindosage = otheracsaspirindosage;
    }

    public String getAcsaspirintime() {
        return acsaspirintime;
    }

    public void setAcsaspirintime(String acsaspirintime) {
        this.acsaspirintime = acsaspirintime;
    }

    public String getAcschlorpyridindosage() {
        return acschlorpyridindosage;
    }

    public void setAcschlorpyridindosage(String acschlorpyridindosage) {
        this.acschlorpyridindosage = acschlorpyridindosage;
    }

    public String getOtheracschlorpyridindosage() {
        return otheracschlorpyridindosage;
    }

    public void setOtheracschlorpyridindosage(String otheracschlorpyridindosage) {
        this.otheracschlorpyridindosage = otheracschlorpyridindosage;
    }

    public String getAcschlorpyridintime() {
        return acschlorpyridintime;
    }

    public void setAcschlorpyridintime(String acschlorpyridintime) {
        this.acschlorpyridintime = acschlorpyridintime;
    }

    public String getAcstigrilodosage() {
        return acstigrilodosage;
    }

    public void setAcstigrilodosage(String acstigrilodosage) {
        this.acstigrilodosage = acstigrilodosage;
    }

    public String getOtheracstigrilodosage() {
        return otheracstigrilodosage;
    }

    public void setOtheracstigrilodosage(String otheracstigrilodosage) {
        this.otheracstigrilodosage = otheracstigrilodosage;
    }

    public String getAcstigrilotime() {
        return acstigrilotime;
    }

    public void setAcstigrilotime(String acstigrilotime) {
        this.acstigrilotime = acstigrilotime;
    }

    public String getAcsisanticoagulantmedicine() {
        return acsisanticoagulantmedicine;
    }

    public void setAcsisanticoagulantmedicine(String acsisanticoagulantmedicine) {
        this.acsisanticoagulantmedicine = acsisanticoagulantmedicine;
    }

    public String getAcsanticoagulationdrug() {
        return acsanticoagulationdrug;
    }

    public void setAcsanticoagulationdrug(String acsanticoagulationdrug) {
        this.acsanticoagulationdrug = acsanticoagulationdrug;
    }

    public String getAcsanticoagulationdrugdosage() {
        return acsanticoagulationdrugdosage;
    }

    public void setAcsanticoagulationdrugdosage(String acsanticoagulationdrugdosage) {
        this.acsanticoagulationdrugdosage = acsanticoagulationdrugdosage;
    }

    public String getAcsanticoagulationdrugunit() {
        return acsanticoagulationdrugunit;
    }

    public void setAcsanticoagulationdrugunit(String acsanticoagulationdrugunit) {
        this.acsanticoagulationdrugunit = acsanticoagulationdrugunit;
    }

    public String getAcsanticoagulantmedicinetime() {
        return acsanticoagulantmedicinetime;
    }

    public void setAcsanticoagulantmedicinetime(String acsanticoagulantmedicinetime) {
        this.acsanticoagulantmedicinetime = acsanticoagulantmedicinetime;
    }

    public String getIs24intensivestatin() {
        return is24intensivestatin;
    }

    public void setIs24intensivestatin(String is24intensivestatin) {
        this.is24intensivestatin = is24intensivestatin;
    }

    public String getAcsatorvastatindosage() {
        return acsatorvastatindosage;
    }

    public void setAcsatorvastatindosage(String acsatorvastatindosage) {
        this.acsatorvastatindosage = acsatorvastatindosage;
    }

    public String getAcsrosuvastatindosage() {
        return acsrosuvastatindosage;
    }

    public void setAcsrosuvastatindosage(String acsrosuvastatindosage) {
        this.acsrosuvastatindosage = acsrosuvastatindosage;
    }

    public String getIsusebetablocker() {
        return isusebetablocker;
    }

    public void setIsusebetablocker(String isusebetablocker) {
        this.isusebetablocker = isusebetablocker;
    }

    public String getAcsisaceiarb() {
        return acsisaceiarb;
    }

    public void setAcsisaceiarb(String acsisaceiarb) {
        this.acsisaceiarb = acsisaceiarb;
    }
}