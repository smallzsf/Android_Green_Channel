package com.xyj.strokeaid.bean.chestpain;

import com.xyj.strokeaid.base.BaseBean;

/**
 * OperationInfoBean
 * description: 手术信息
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class OperationInfoBean  extends BaseBean<OperationInfoBean> {

    private String id;
    private String recordId;


    /**
     * 介入医师
     */
    private String pcimedicalstaffid;

    /**
     * 手术记录人
     */
    private String operationfillerid;

    /**
     * 再次知情同意
     */
    private String pcipatientcommunicationagainendtime;

    /**
     * 导管室激活时间
     */
    private String activedsaroomtime;

    /**
     * 患者到达导管室
     */
    private String patientarriveddsaroomtime;

    /**
     * 开始穿刺时间
     */
    private String puncturebegintime;

    /**
     * 造影开始时间
     */
    private String cagbegintime;

    /**
     * 导丝通过时间
     */
    private String siroperationguidewirepasstime;

    /**
     * 手术结束时间
     */
    private String pciendtime;

    /**
     * 术中抗凝给药时间
     */
    private String ssanticoagulantmedicinetime;

    /**
     * 术中抗凝药物（"cpc_knyw_ptgs": "普通肝素",
     "cpc_knyw_dfzgs": "低分子肝素",
     "cpc_knyw_bfrd": "比伐卢定",
     "cpc_knyw_hdgkn": "磺达肝癸钠"）
     */
    private String ssanticoagulationdrug;

    /**
     * 术中抗凝药物剂量
     */
    private String sssanticoagulationdrugdosage;

    /**
     * 术中抗凝药物剂量(单位)
     */
    private String sssanticoagulationdrugunit;

    /**
     * 造影结果提示
     */
    private String cagresult;


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

    public String getPcimedicalstaffid() {
        return pcimedicalstaffid;
    }

    public void setPcimedicalstaffid(String pcimedicalstaffid) {
        this.pcimedicalstaffid = pcimedicalstaffid;
    }

    public String getOperationfillerid() {
        return operationfillerid;
    }

    public void setOperationfillerid(String operationfillerid) {
        this.operationfillerid = operationfillerid;
    }

    public String getPcipatientcommunicationagainendtime() {
        return pcipatientcommunicationagainendtime;
    }

    public void setPcipatientcommunicationagainendtime(String pcipatientcommunicationagainendtime) {
        this.pcipatientcommunicationagainendtime = pcipatientcommunicationagainendtime;
    }

    public String getActivedsaroomtime() {
        return activedsaroomtime;
    }

    public void setActivedsaroomtime(String activedsaroomtime) {
        this.activedsaroomtime = activedsaroomtime;
    }

    public String getPatientarriveddsaroomtime() {
        return patientarriveddsaroomtime;
    }

    public void setPatientarriveddsaroomtime(String patientarriveddsaroomtime) {
        this.patientarriveddsaroomtime = patientarriveddsaroomtime;
    }

    public String getPuncturebegintime() {
        return puncturebegintime;
    }

    public void setPuncturebegintime(String puncturebegintime) {
        this.puncturebegintime = puncturebegintime;
    }

    public String getCagbegintime() {
        return cagbegintime;
    }

    public void setCagbegintime(String cagbegintime) {
        this.cagbegintime = cagbegintime;
    }

    public String getSiroperationguidewirepasstime() {
        return siroperationguidewirepasstime;
    }

    public void setSiroperationguidewirepasstime(String siroperationguidewirepasstime) {
        this.siroperationguidewirepasstime = siroperationguidewirepasstime;
    }

    public String getPciendtime() {
        return pciendtime;
    }

    public void setPciendtime(String pciendtime) {
        this.pciendtime = pciendtime;
    }

    public String getSsanticoagulantmedicinetime() {
        return ssanticoagulantmedicinetime;
    }

    public void setSsanticoagulantmedicinetime(String ssanticoagulantmedicinetime) {
        this.ssanticoagulantmedicinetime = ssanticoagulantmedicinetime;
    }

    public String getSsanticoagulationdrug() {
        return ssanticoagulationdrug;
    }

    public void setSsanticoagulationdrug(String ssanticoagulationdrug) {
        this.ssanticoagulationdrug = ssanticoagulationdrug;
    }

    public String getSssanticoagulationdrugdosage() {
        return sssanticoagulationdrugdosage;
    }

    public void setSssanticoagulationdrugdosage(String sssanticoagulationdrugdosage) {
        this.sssanticoagulationdrugdosage = sssanticoagulationdrugdosage;
    }

    public String getSssanticoagulationdrugunit() {
        return sssanticoagulationdrugunit;
    }

    public void setSssanticoagulationdrugunit(String sssanticoagulationdrugunit) {
        this.sssanticoagulationdrugunit = sssanticoagulationdrugunit;
    }

    public String getCagresult() {
        return cagresult;
    }

    public void setCagresult(String cagresult) {
        this.cagresult = cagresult;
    }
}

    
    
       
    