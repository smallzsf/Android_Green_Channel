package com.xyj.strokeaid.bean;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.base.BaseBean;
import com.xyj.strokeaid.http.gson.GsonUtils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class EmergencyCenterChestpainHospitalData  extends BaseBean<EmergencyCenterChestpainHospitalData> {

    /**
     *
     */
    private String recordId;

    /**
     * 溶栓核查（"cpc_rsscjg_hs": "合适",
     * "cpc_rsscjg_bhs": "不合适",
     * "cpc_rsscjg_wsc": "未筛查"）
     */
    private String thrombolysisscreenresult;

    /**
     * 溶栓核查-合适-溶栓治疗（"cpc_exist_true": "有",
     * "cpc_exist_false": "无"）
     */
    private String afteracsisdonethrombolysis;

    /**
     * 溶栓治疗-有-直达溶栓场所（"cpc_bool_true": "是",
     * "cpc_bool_false": "否"）
     */
    private String afteristhroughthrombolysisto;

    /**
     * 溶栓场所（"cpc_ynrscs_byjzk": "本院急诊科",
     * "cpc_ynrscs_byxnk": "本院心内科",
     * "cpc_ynrscs_qtks": "其他科室"）
     */
    private String afterthrombolysisroom;

    /**
     * 开始知情同意
     */
    private String afterthrombolysispatientcommunicationsbegintime;

    /**
     * 签署知情同意书
     */
    private String afterthrombolysispatientcommunicationsendtime;

    /**
     * 溶栓开始时间
     */
    private String afterthrombolysisbegintime;

    /**
     * 溶栓结束时间
     */
    private String afterthrombolysisendtime;

    /**
     * 药物（"cpc_rsywv2_dyd": "第一代",
     * "cpc_rsywv2_ded": "第二代",
     * "cpc_rsywv2_dsd": "第三代"）
     */
    private String afterthrombolysisdrug;

    /**
     * 剂量（"cpc_rsywjl_ql": "全量",
     * "cpc_rsywjl_bl": "半量"）
     */
    private String afterthrombolysisdrugdosage;

    /**
     * 溶栓再通（"cpc_bool_true": "是",
     * "cpc_bool_false": "否"）
     */
    private String afterthrombolysisreuslt;

    /**
     * 溶栓核查-不合适-存在禁忌症("cpc_bool_true": "是",
     * "cpc_bool_false": "否")
     */
    private String afterthrombolysiscontraindication;



    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getThrombolysisscreenresult() {
        return thrombolysisscreenresult;
    }

    public void setThrombolysisscreenresult(String thrombolysisscreenresult) {
        this.thrombolysisscreenresult = thrombolysisscreenresult;
    }

    public String getAfteracsisdonethrombolysis() {
        return afteracsisdonethrombolysis;
    }

    public void setAfteracsisdonethrombolysis(String afteracsisdonethrombolysis) {
        this.afteracsisdonethrombolysis = afteracsisdonethrombolysis;
    }

    public String getAfteristhroughthrombolysisto() {
        return afteristhroughthrombolysisto;
    }

    public void setAfteristhroughthrombolysisto(String afteristhroughthrombolysisto) {
        this.afteristhroughthrombolysisto = afteristhroughthrombolysisto;
    }

    public String getAfterthrombolysisroom() {
        return afterthrombolysisroom;
    }

    public void setAfterthrombolysisroom(String afterthrombolysisroom) {
        this.afterthrombolysisroom = afterthrombolysisroom;
    }

    public String getAfterthrombolysispatientcommunicationsbegintime() {
        return afterthrombolysispatientcommunicationsbegintime;
    }

    public void setAfterthrombolysispatientcommunicationsbegintime(String afterthrombolysispatientcommunicationsbegintime) {
        this.afterthrombolysispatientcommunicationsbegintime = afterthrombolysispatientcommunicationsbegintime;
    }

    public String getAfterthrombolysispatientcommunicationsendtime() {
        return afterthrombolysispatientcommunicationsendtime;
    }

    public void setAfterthrombolysispatientcommunicationsendtime(String afterthrombolysispatientcommunicationsendtime) {
        this.afterthrombolysispatientcommunicationsendtime = afterthrombolysispatientcommunicationsendtime;
    }

    public String getAfterthrombolysisbegintime() {
        return afterthrombolysisbegintime;
    }

    public void setAfterthrombolysisbegintime(String afterthrombolysisbegintime) {
        this.afterthrombolysisbegintime = afterthrombolysisbegintime;
    }

    public String getAfterthrombolysisendtime() {
        return afterthrombolysisendtime;
    }

    public void setAfterthrombolysisendtime(String afterthrombolysisendtime) {
        this.afterthrombolysisendtime = afterthrombolysisendtime;
    }

    public String getAfterthrombolysisdrug() {
        return afterthrombolysisdrug;
    }

    public void setAfterthrombolysisdrug(String afterthrombolysisdrug) {
        this.afterthrombolysisdrug = afterthrombolysisdrug;
    }

    public String getAfterthrombolysisdrugdosage() {
        return afterthrombolysisdrugdosage;
    }

    public void setAfterthrombolysisdrugdosage(String afterthrombolysisdrugdosage) {
        this.afterthrombolysisdrugdosage = afterthrombolysisdrugdosage;
    }

    public String getAfterthrombolysisreuslt() {
        return afterthrombolysisreuslt;
    }

    public void setAfterthrombolysisreuslt(String afterthrombolysisreuslt) {
        this.afterthrombolysisreuslt = afterthrombolysisreuslt;
    }

    public String getAfterthrombolysiscontraindication() {
        return afterthrombolysiscontraindication;
    }

    public void setAfterthrombolysiscontraindication(String afterthrombolysiscontraindication) {
        this.afterthrombolysiscontraindication = afterthrombolysiscontraindication;
    }

    public RequestBody getResuestBody(@NonNull EmergencyCenterChestpainHospitalData t) {
        String request = GsonUtils.getGson().toJson(t);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
    }
}
