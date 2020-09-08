package com.xyj.strokeaid.bean.chestpain;

/**
 * PrehospitalThrombolyticBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/8
 * email ：licy3051@qq.com
 */
public class PrehospitalThrombolyticBean {


    /**
     *
     */
    private String id;

    /**
     *
     */
    private String recordId;

    /**
     * 溶栓核查（"cpc_rsscjg_hs": "合适",
     "cpc_rsscjg_bhs": "不合适",
     "cpc_rsscjg_wsc": "未筛查"）
     */
    private String beforethrombolysisscreenresult;

    /**
     * 溶栓核查-合适-溶栓治疗（"cpc_exist_true": "有",
     "cpc_exist_false": "无"）
     */
    private String beforeisdonethrombolysis;

    /**
     * 溶栓治疗-有-直达溶栓场所（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String beforeisthroughthrombolysisto;

    /**
     * 溶栓场所（"cpc_yqrscs_jhc": "救护车",
     "cpc_yqrscs_qtyy": "其它医院"）
     */
    private String beforethrombolysisroom;

    /**
     * 开始知情同意
     */
    private String beforethrombolysispatientcommunicationsbegintime;

    /**
     * 签署知情同意
     */
    private String beforethrombolysispatientcommunicationsendtime;

    /**
     * 溶栓开始时间
     */
    private String beforethrombolysisbegintime;

    /**
     * 溶栓结束时间
     */
    private String beforethrombolysisendtime;

    /**
     * 药物（"cpc_rsywv2_dyd": "第一代",
     "cpc_rsywv2_ded": "第二代",
     "cpc_rsywv2_dsd": "第三代"）
     */
    private String beforethrombolysisdrug;

    /**
     * 剂量（"cpc_rsywjl_ql": "全量",
     "cpc_rsywjl_bl": "半量"）
     */
    private String beforethrombolysisdrugdosage;

    /**
     * 溶栓再通（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String beforethrombolysisreuslt;

    /**
     * 溶栓再通-是-溶栓后造影时间（）
     */
    private String radiographictime;

    /**
     * 溶栓再通-否-补救PCI（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String remedypci;

    /**
     * 手术场所（"cpc_sscs_by": "本院",
     "cpc_sscs_wy": "外院"）
     */
    private String operatingplace;

    /**
     * 实际手术时间
     */
    private String operativetime;

    /**
     * 溶栓核查-不合适-存在禁忌症("cpc_bool_true": "是",
     "cpc_bool_false": "否")
     */
    private String beforethrombolysiscontraindication;

}

    
    
       
    