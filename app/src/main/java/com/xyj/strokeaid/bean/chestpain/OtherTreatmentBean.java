package com.xyj.strokeaid.bean.chestpain;

/**
 * OtherTreatmentBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/8
 * email ：licy3051@qq.com
 */
public class OtherTreatmentBean {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String recordId;

    /**
     * 住院天数
     */
    private String numberofdaysinhospital;

    /**
     * 总费用
     */
    private String totalcostinhospital;

    /**
     * 患者转归（"cpc_hzzgv2_cy": "出院",
     "cpc_hzzgv2_qtyy": "转送其它医院",
     "cpc_hzzgv2_qtks": "转送其它科室",
     "cpc_hzzgv2_sw": "死亡"）
     */
    private String prognosisresult;

    /**
     * 离院宣教（"cpc_missioneducation_jy": "戒烟",
     "cpc_missioneducation_gljcfy": "规律坚持服药",
     "cpc_missioneducation_jyzsfzl": "遵医嘱随访治疗",
     "cpc_missioneducation_shqjth": "生活起居调护",
     "cpc_missioneducation_xxgwxyskz": "心血管危险因素控制（降压、调脂、血糖控制、限酒、控制体重）",
     "cpc_missioneducation_wxj": "未宣教"）
     */
    private String missioneducation;

    /**
     * 出院时间
     */
    private String dischargedtime;

    /**
     * 治疗结果（"cpc_zljgv2_zy": "治愈",
     "cpc_zljgv2_hz": "好转",
     "cpc_zljgv2_auto": "自动离院",
     "cpc_zljgv2_qtyy": "其它原因离院"）
     */
    private String treatmentresult;

    /**
     * 离开本院大门时间
     */
    private String leavehospitaltime;

    /**
     * 医院名称
     */
    private String hospitalnametransto;

    /**
     * 是否是网络医院（ "cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String isgriddinghospitaltransto;

    /**
     * 转运PCI（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String istransforpci;

    /**
     * 直达导管室（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String istranstopciroom;

    /**
     * 实际介入手术开始时间
     */
    private String zypcibegintime;

    /**
     * 远程心电图传输（"cpc_remoteecgtrans_xzdw": "传输心电图至协作单位(转出患者时)",
     "cpc_remoteecgtrans_none": "无"）
     */
    private String remoteecgtrans;

    /**
     * 传输心电图至协作单位时间
     */
    private String zypciremotetransmissiontime;

    /**
     * 传输方式（"cpc_transway_timemonitor": "实时监控",
     "cpc_transway_wechat": "微信群",
     "cpc_transway_other": "其他"）
     */
    private String zypciremotetransmissionwaynew;

    /**
     * 溶栓后24h内造影（"cpc_bool_true": "是",
     "cpc_bool_false": "否"）
     */
    private String angiographyafter24hthrombolysis;

    /**
     * 造影开始时间
     */
    private String angiographybegintime;

    /**
     * 转科时间
     */
    private String transdepartmenttime;

    /**
     * 接诊科室不能超过40个字符且不允许录入特殊字符！
     */
    private String departmenttransto;

    /**
     * 转科原因描述（）
     */
    private String transdepartmentreason;

    /**
     * 死亡时间
     */
    private String deathtime;

    /**
     * 死亡原因（"cpc_swyy_xyx": "心源性",
     "cpc_swyy_fxyx": "非心源性"）
     */
    private String deathreason;

    /**
     * 死亡描述（）
     */
    private String deathdecriptioin;

    /**
     * 住院期间降糖药物（cpc_bool_true：是，cpc_bool_false：否）
     */
    private String isinhospitalhypoglycemicdrug;

    /**
     * 住院期间用药-降糖药物名称（
     cpc_jtyw_hnl：磺脲类，
     cpc_jtyw_sgl：双胍类，
     cpc_jtyw_alphatgmyzj：α糖苷酶抑制剂，
     cpc_jtyw_dpp4yzj：DPP-4抑制剂，
     cpc_jtyw_glp1stjdj：GLP-1受体激动剂，
     cpc_jtyw_sglt2yzj：SGLT-2抑制剂，
     cpc_jtyw_ydsjydslsw：胰岛素及胰岛素类似物，
     cpc_jtyw_qt：其他
     ）
     */
    private String inhospitalhypoglycemicdrugname;

    /**
     * 住院期间用药-是否使用口服抗凝药物（
     cpc_bool_true：是，
     cpc_bool_false：否，
     ）
     */
    private String isinhospitaloralanticoagulant;

    /**
     * 住院期间用药-口服抗凝药物（
     cpc_kfknyw_hfl：华法林，
     cpc_kfknyw_dbjqz：达比加群酯，
     cpc_kfknyw_lfsb：利伐沙班，
     cpc_kfknyw_apsb：阿哌沙班，
     cpc_kfknyw_qt：其他
     ）
     */
    private String inhospitaloralanticoagulantname;

    /**
     * 住院期间用药-是否使用PCSK9（
     cpc_bool_true：是，
     cpc_bool_false：否，

     ）
     */
    private String isinhospitalpcsk9;

    /**
     * 住院期间用药-PCSK9名称（
     cpc_pcsk9_alxydk：阿利西尤单抗，
     cpc_pcsk9_ylydk：依洛尤单抗，
     ）
     */
    private String inhospitalpcsk9name;

    /**
     * 住院期间用药-PCSK9药物单次剂量（mg）
     */
    private String inhospitalpcsk9singledose;

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

    public String getNumberofdaysinhospital() {
        return numberofdaysinhospital;
    }

    public void setNumberofdaysinhospital(String numberofdaysinhospital) {
        this.numberofdaysinhospital = numberofdaysinhospital;
    }

    public String getTotalcostinhospital() {
        return totalcostinhospital;
    }

    public void setTotalcostinhospital(String totalcostinhospital) {
        this.totalcostinhospital = totalcostinhospital;
    }

    public String getPrognosisresult() {
        return prognosisresult;
    }

    public void setPrognosisresult(String prognosisresult) {
        this.prognosisresult = prognosisresult;
    }

    public String getMissioneducation() {
        return missioneducation;
    }

    public void setMissioneducation(String missioneducation) {
        this.missioneducation = missioneducation;
    }

    public String getDischargedtime() {
        return dischargedtime;
    }

    public void setDischargedtime(String dischargedtime) {
        this.dischargedtime = dischargedtime;
    }

    public String getTreatmentresult() {
        return treatmentresult;
    }

    public void setTreatmentresult(String treatmentresult) {
        this.treatmentresult = treatmentresult;
    }

    public String getLeavehospitaltime() {
        return leavehospitaltime;
    }

    public void setLeavehospitaltime(String leavehospitaltime) {
        this.leavehospitaltime = leavehospitaltime;
    }

    public String getHospitalnametransto() {
        return hospitalnametransto;
    }

    public void setHospitalnametransto(String hospitalnametransto) {
        this.hospitalnametransto = hospitalnametransto;
    }

    public String getIsgriddinghospitaltransto() {
        return isgriddinghospitaltransto;
    }

    public void setIsgriddinghospitaltransto(String isgriddinghospitaltransto) {
        this.isgriddinghospitaltransto = isgriddinghospitaltransto;
    }

    public String getIstransforpci() {
        return istransforpci;
    }

    public void setIstransforpci(String istransforpci) {
        this.istransforpci = istransforpci;
    }

    public String getIstranstopciroom() {
        return istranstopciroom;
    }

    public void setIstranstopciroom(String istranstopciroom) {
        this.istranstopciroom = istranstopciroom;
    }

    public String getZypcibegintime() {
        return zypcibegintime;
    }

    public void setZypcibegintime(String zypcibegintime) {
        this.zypcibegintime = zypcibegintime;
    }

    public String getRemoteecgtrans() {
        return remoteecgtrans;
    }

    public void setRemoteecgtrans(String remoteecgtrans) {
        this.remoteecgtrans = remoteecgtrans;
    }

    public String getZypciremotetransmissiontime() {
        return zypciremotetransmissiontime;
    }

    public void setZypciremotetransmissiontime(String zypciremotetransmissiontime) {
        this.zypciremotetransmissiontime = zypciremotetransmissiontime;
    }

    public String getZypciremotetransmissionwaynew() {
        return zypciremotetransmissionwaynew;
    }

    public void setZypciremotetransmissionwaynew(String zypciremotetransmissionwaynew) {
        this.zypciremotetransmissionwaynew = zypciremotetransmissionwaynew;
    }

    public String getAngiographyafter24hthrombolysis() {
        return angiographyafter24hthrombolysis;
    }

    public void setAngiographyafter24hthrombolysis(String angiographyafter24hthrombolysis) {
        this.angiographyafter24hthrombolysis = angiographyafter24hthrombolysis;
    }

    public String getAngiographybegintime() {
        return angiographybegintime;
    }

    public void setAngiographybegintime(String angiographybegintime) {
        this.angiographybegintime = angiographybegintime;
    }

    public String getTransdepartmenttime() {
        return transdepartmenttime;
    }

    public void setTransdepartmenttime(String transdepartmenttime) {
        this.transdepartmenttime = transdepartmenttime;
    }

    public String getDepartmenttransto() {
        return departmenttransto;
    }

    public void setDepartmenttransto(String departmenttransto) {
        this.departmenttransto = departmenttransto;
    }

    public String getTransdepartmentreason() {
        return transdepartmentreason;
    }

    public void setTransdepartmentreason(String transdepartmentreason) {
        this.transdepartmentreason = transdepartmentreason;
    }

    public String getDeathtime() {
        return deathtime;
    }

    public void setDeathtime(String deathtime) {
        this.deathtime = deathtime;
    }

    public String getDeathreason() {
        return deathreason;
    }

    public void setDeathreason(String deathreason) {
        this.deathreason = deathreason;
    }

    public String getDeathdecriptioin() {
        return deathdecriptioin;
    }

    public void setDeathdecriptioin(String deathdecriptioin) {
        this.deathdecriptioin = deathdecriptioin;
    }

    public String getIsinhospitalhypoglycemicdrug() {
        return isinhospitalhypoglycemicdrug;
    }

    public void setIsinhospitalhypoglycemicdrug(String isinhospitalhypoglycemicdrug) {
        this.isinhospitalhypoglycemicdrug = isinhospitalhypoglycemicdrug;
    }

    public String getInhospitalhypoglycemicdrugname() {
        return inhospitalhypoglycemicdrugname;
    }

    public void setInhospitalhypoglycemicdrugname(String inhospitalhypoglycemicdrugname) {
        this.inhospitalhypoglycemicdrugname = inhospitalhypoglycemicdrugname;
    }

    public String getIsinhospitaloralanticoagulant() {
        return isinhospitaloralanticoagulant;
    }

    public void setIsinhospitaloralanticoagulant(String isinhospitaloralanticoagulant) {
        this.isinhospitaloralanticoagulant = isinhospitaloralanticoagulant;
    }

    public String getInhospitaloralanticoagulantname() {
        return inhospitaloralanticoagulantname;
    }

    public void setInhospitaloralanticoagulantname(String inhospitaloralanticoagulantname) {
        this.inhospitaloralanticoagulantname = inhospitaloralanticoagulantname;
    }

    public String getIsinhospitalpcsk9() {
        return isinhospitalpcsk9;
    }

    public void setIsinhospitalpcsk9(String isinhospitalpcsk9) {
        this.isinhospitalpcsk9 = isinhospitalpcsk9;
    }

    public String getInhospitalpcsk9name() {
        return inhospitalpcsk9name;
    }

    public void setInhospitalpcsk9name(String inhospitalpcsk9name) {
        this.inhospitalpcsk9name = inhospitalpcsk9name;
    }

    public String getInhospitalpcsk9singledose() {
        return inhospitalpcsk9singledose;
    }

    public void setInhospitalpcsk9singledose(String inhospitalpcsk9singledose) {
        this.inhospitalpcsk9singledose = inhospitalpcsk9singledose;
    }
}

    
    
       
    