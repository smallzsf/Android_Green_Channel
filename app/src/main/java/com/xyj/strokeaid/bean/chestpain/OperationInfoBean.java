package com.xyj.strokeaid.bean.chestpain;

/**
 * OperationInfoBean
 * description: 手术信息
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class OperationInfoBean {

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

}

    
    
       
    