package com.xyj.strokeaid.bean.chestpain;

import com.xyj.strokeaid.base.BaseBean;

/**
 * PatientOutcomeBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/8
 * email ：licy3051@qq.com
 */
public class PatientOutcomeBean extends BaseBean<PatientOutcomeBean> {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String recordId;

    /**
     * 出院诊断（"cpc_cyzdv2_stemi": "STEMI",
     * "cpc_cyzdv2_nstemi": "NSTEMI",
     * "cpc_cyzdv2_ua": "UA",
     * "cpc_cyzdv2_zdmjc": "主动脉夹层",
     * "cpc_cyzdv2_fdmss": "肺动脉栓塞",
     * "cpc_cyzdv2_facs": "非ACS心源性胸痛",
     * "cpc_cyzdv2_otherxyxt": "其它非心源性胸痛"）
     */
    private String dischargeddiagnosis;

    /**
     * 确诊时间
     */
    private String dischargeddiagnosistime;

    /**
     * CCU治疗开始时间
     */
    private String ccustarttime;

    /**
     * CCU治疗结束时间
     */
    private String ccuendtime;

    /**
     * 院内新发心力衰竭（"cpc_bool_true": "是",
     * "cpc_bool_false": "否"）
     */
    private String isheartfailureinhospital;

    /**
     * 并发症（"cpc_complication_xk": "休克",
     * "cpc_complication_jxxbfz": "机械性并发症",
     * "cpc_complication_gr": "感染",
     * "cpc_complication_zfxg": "再发心梗",
     * "cpc_complication_xs": "血栓",
     * "cpc_complication_cz": "缺血性卒中",
     * "cpc_complication_tia": "TIA",
     * "cpc_complication_cx": "出血",
     * "cpc_complication_hxsj": "呼吸衰竭",
     * "cpc_complication_ssj": "肾衰竭",
     * "cpc_complication_sw": "死亡",
     * "cpc_complication_exxlsc": "恶性心律失常",
     * "cpc_complication_wu": "无"）
     */
    private String complication;

    /**
     * 非ACS心源性胸痛类型（参考字典）
     * ("cpc_unacs_xlsc": "心律失常",
     * "cpc_unacs_kzxxjb": "扩张性心肌病",
     * "cpc_unacs_qxxxjb": "缺血性心肌病",
     * "cpc_unacs_fhxxjb": "肥厚型心肌病",
     * "cpc_unacs_xjb": "心肌炎",
     * "cpc_unacs_gxb": "冠心病",
     * "cpc_unacs_bmxxjb": "瓣膜性心脏病",
     * "cpc_unacs_cjxxjgs": "陈旧性心肌梗死",
     * "cpc_unacs_xjt": "心绞痛",
     * "cpc_unacs_xj": "心悸",
     * "cpc_unacs_fc": "房颤",
     * "cpc_unacs_gxy": "高血压",
     * "cpc_unacs_xs": "心衰",
     * "cpc_unacs_fp": "房扑",
     * "cpc_unacs_sz": "室早",
     * "cpc_unacs_fz": "房早",
     * "cpc_unacs_sss": "室上速",
     * "cpc_unacs_xby": "心包炎",
     * "cpc_unacs_xjq": "心肌桥",
     * "cpc_unacs_xbjy": "心包积液",
     * "cpc_unacs_zdmgbjxz": "主动脉管壁间血肿",
     * "cpc_unacs_tbxdmzyyhxky": "透壁性动脉粥样硬化性溃疡",
     * "cpc_unacs_zdml": "主动脉瘤",
     * "cpc_unacs_zlxqx":"张力性气胸"
     */
    private String dischargedunacs;

    /**
     * 其它非心源性胸痛类型（
     * "cpc_otherunacs_hxxtb": "呼吸系统病",
     * "cpc_otherunacs_xhxtb": "消化系统病",
     * "cpc_otherunacs_sjxtb": "神经系统病",
     * "cpc_otherunacs_jsxtb": "精神系统病",
     * "cpc_otherunacs_jrggb": "肌肉骨骼病",
     * "cpc_otherunacs_pfxtb": "皮肤系统病",
     * "cpc_otherunacs_qt": "其他"）
     */
    private String dischargedotheracs;

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

    public String getDischargeddiagnosis() {
        return dischargeddiagnosis;
    }

    public void setDischargeddiagnosis(String dischargeddiagnosis) {
        this.dischargeddiagnosis = dischargeddiagnosis;
    }

    public String getDischargeddiagnosistime() {
        return dischargeddiagnosistime;
    }

    public void setDischargeddiagnosistime(String dischargeddiagnosistime) {
        this.dischargeddiagnosistime = dischargeddiagnosistime;
    }

    public String getCcustarttime() {
        return ccustarttime;
    }

    public void setCcustarttime(String ccustarttime) {
        this.ccustarttime = ccustarttime;
    }

    public String getCcuendtime() {
        return ccuendtime;
    }

    public void setCcuendtime(String ccuendtime) {
        this.ccuendtime = ccuendtime;
    }

    public String getIsheartfailureinhospital() {
        return isheartfailureinhospital;
    }

    public void setIsheartfailureinhospital(String isheartfailureinhospital) {
        this.isheartfailureinhospital = isheartfailureinhospital;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getDischargedunacs() {
        return dischargedunacs;
    }

    public void setDischargedunacs(String dischargedunacs) {
        this.dischargedunacs = dischargedunacs;
    }

    public String getDischargedotheracs() {
        return dischargedotheracs;
    }

    public void setDischargedotheracs(String dischargedotheracs) {
        this.dischargedotheracs = dischargedotheracs;
    }
}

    
    
       
    