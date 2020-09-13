package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

/**
 * @Description: 患者信息传参类
 * @Author: crq
 * @CreateDate: 2020/9/4 20:15
 */
public class PatientMedicalRecordBean extends BaseBean<PatientMedicalRecordBean> {


    /**
     * 操作人ID
     */
    private String operationid;

    /**
     * 1、卒中 2、胸痛 3、创伤 4、
     */
    private String emergencyType;

    /**
     * emp_id
     */
    private String empId;

    /**
     * 基本信息-姓名
     */
    private String fullname;

    /**
     * 基本信息-年龄
     */
    private String age;

    /**
     * 基本信息-性别 1男2女
     */
    private String gender;

    /**
     * 基本信息-身份证号
     */
    private String idcardno;

    /**
     * 基本信息-无法获取身份证号
     */
    private String unablegetidcardno;

    /**
     * 基本信息-出生日期
     */
    private String birthdate;

    /**
     * 基本信息-民族
     */
    private String nation;

    /**
     * 基本信息-联系人
     */
    private String contactname;

    /**
     * 基本信息-联系人电话
     */
    private String contactnumber;

    /**
     * 基本信息-发病时间
     */
    private String attacktime;

    /**
     * 基本信息-发病地点
     */
    private String attackaddress;

    /**
     * 基本信息-身高
     */
    private String height;

    /**
     * 基本信息-体重
     */
    private String weight;

    /**
     * 基本信息-BMI
     */
    private String bmi;

    /**
     * 户籍所在地
     */
    private String registeraddress;

    /**
     * 基本信息-医保卡号
     */
    private String medicarecardcode;

    /**
     * 基本信息-就诊ID
     */
    private String patientidofambulant;

    /**
     * 基本信息-基本信息-住院ID
     */
    private String patientidofhospitalization;

    /**
     * 基本信息-时间采集器腕带编号
     */
    private String timecollectorcode;

    /**
     * 基本信息-时间采集器使用记录流水号
     */
    private String timecollectorserialnumber;

    /**
     * 基本信息-时间采集器上线时间
     */
    private String timecollectorontime;

    /**
     * 基本信息-时间采集器下线时间
     */
    private String timecollectorofftime;

    /**
     * 来院方式-出车单位
     */
    private String comingway;

    /**
     * 来院方式-出车单位
     */
    private String helporganization;

    /**
     * 来院方式-患者到院时间(到达医院大门时间)
     */
    private String arrivehospitaltime;

    /**
     * 来院方式-患者到达急诊时间
     */
    private String arrivedertime;

    /**
     * 来院方式-发病到入门
     */
    private String fromattacktoarrivegate;

    /**
     * 来院方式-接诊时间
     */
    private String receptiontime;

    /**
     * 来院方式-接诊护士
     */
    private String receptionnurseid;

    /**
     * 来院方式-接诊地点
     */
    private String receptionlocation;

    /**
     * 来院方式-急诊医生接诊
     */
    private String emergencydoctorreceptiontime;

    /**
     * 来院方式-急诊医生
     */
    private String emergencydoctorreception;

    /**
     * 来院方式-来源医院是否网络医院
     */
    private String isgriddinghospitaltransfrom;

    /**
     * 来院方式-来源医院
     */
    private String hospitalnametransfrom;

    /**
     * 来院方式-发病科室
     */
    private String attackdepartment;

    /**
     * 来院方式-接诊时间
     */
    private String emergencytime;

    /**
     * 来院方式-接诊医生
     */
    private String receptiondoctorid;

    /**
     * 呼救时间
     */
    private String timeofcall;

    /**
     * 120派车时间
     */
    private String dispatch120time;

    /**
     * 120出车时间
     */
    private String depart120time;

    /**
     * 120到达时间
     */
    private String arrive120time;

    /**
     * 首次医疗接触时间
     */
    private String fmctime;

    /**
     * 院内医师接诊时间
     */
    private String firstdoctorreceptiontime;

    /**
     * 转出医院入门时间
     */
    private String hospitaltransferfromarrivedtime;

    /**
     * 转运救护车到达时间
     */
    private String transferambulancearrivaltime;

    /**
     * 离开转出医院时间(转出医院出门时间)
     */
    private String hospitaltransferfromleavetime;

    /**
     * 决定转院时间
     */
    private String decidetranstime;

    /**
     * 离开科室时间
     */
    private String leaveattackdepartmenttime;

    /**
     * 入院途径1急诊 2门诊 3其他医疗机构转入4其他
     */
    private String behospitalizedway;

    /**
     * 医保类型(cpc_yblx_czzgjbylbx:城镇职工基本医疗保险
     * cpc_yblx_xxnchzyl:新型农村合作医疗 cpc_yblx_czjmjbylbx:城镇居民基本医疗保险 cpc_yblx_zf:自费cpc_yblx_jm:军免 )
     */
    private String medicaretype;

    /**
     * 大病医保 -1 否 1 是
     */
    private String seriousillnessmedicare;

    /**
     * 发病区间("cpc_fbsjfw_0-6": "凌晨(0点到6点)","cpc_fbsjfw_6-8": "清晨(6到8点)","cpc_fbsjfw_8-12": "上午(8到12点)","cpc_fbsjfw_12-14": "中午(12到14点)","cpc_fbsjfw_14-17": "下午(14到17点)","cpc_fbsjfw_17-19": "傍晚(17到19点)","cpc_fbsjfw_19-24": "晚上(19到24点)")
     */
    private String attacktimeinterval;

    /**
     * 发病日期
     */
    private String attackdate;

    /**
     * 发病时间是否确定(1是 -1否)
     */
    private String attacktimeisinaccurate;

    /**
     * 备注
     */
    private String notes;

    /**
     * 急诊分诊护士
     */
    private String emergencynursereception;

    /**
     * 到达现场时间
     */
    private String arrivescenetime;

    /**
     * 离开现场时间
     */
    private String levavescenetime;

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getUnablegetidcardno() {
        return unablegetidcardno;
    }

    public void setUnablegetidcardno(String unablegetidcardno) {
        this.unablegetidcardno = unablegetidcardno;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getAttacktime() {
        return attacktime;
    }

    public void setAttacktime(String attacktime) {
        this.attacktime = attacktime;
    }

    public String getAttackaddress() {
        return attackaddress;
    }

    public void setAttackaddress(String attackaddress) {
        this.attackaddress = attackaddress;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getRegisteraddress() {
        return registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress;
    }

    public String getMedicarecardcode() {
        return medicarecardcode;
    }

    public void setMedicarecardcode(String medicarecardcode) {
        this.medicarecardcode = medicarecardcode;
    }

    public String getPatientidofambulant() {
        return patientidofambulant;
    }

    public void setPatientidofambulant(String patientidofambulant) {
        this.patientidofambulant = patientidofambulant;
    }

    public String getPatientidofhospitalization() {
        return patientidofhospitalization;
    }

    public void setPatientidofhospitalization(String patientidofhospitalization) {
        this.patientidofhospitalization = patientidofhospitalization;
    }

    public String getTimecollectorcode() {
        return timecollectorcode;
    }

    public void setTimecollectorcode(String timecollectorcode) {
        this.timecollectorcode = timecollectorcode;
    }

    public String getTimecollectorserialnumber() {
        return timecollectorserialnumber;
    }

    public void setTimecollectorserialnumber(String timecollectorserialnumber) {
        this.timecollectorserialnumber = timecollectorserialnumber;
    }

    public String getTimecollectorontime() {
        return timecollectorontime;
    }

    public void setTimecollectorontime(String timecollectorontime) {
        this.timecollectorontime = timecollectorontime;
    }

    public String getTimecollectorofftime() {
        return timecollectorofftime;
    }

    public void setTimecollectorofftime(String timecollectorofftime) {
        this.timecollectorofftime = timecollectorofftime;
    }

    public String getComingway() {
        return comingway;
    }

    public void setComingway(String comingway) {
        this.comingway = comingway;
    }

    public String getHelporganization() {
        return helporganization;
    }

    public void setHelporganization(String helporganization) {
        this.helporganization = helporganization;
    }

    public String getArrivehospitaltime() {
        return arrivehospitaltime;
    }

    public void setArrivehospitaltime(String arrivehospitaltime) {
        this.arrivehospitaltime = arrivehospitaltime;
    }

    public String getArrivedertime() {
        return arrivedertime;
    }

    public void setArrivedertime(String arrivedertime) {
        this.arrivedertime = arrivedertime;
    }

    public String getFromattacktoarrivegate() {
        return fromattacktoarrivegate;
    }

    public void setFromattacktoarrivegate(String fromattacktoarrivegate) {
        this.fromattacktoarrivegate = fromattacktoarrivegate;
    }

    public String getReceptiontime() {
        return receptiontime;
    }

    public void setReceptiontime(String receptiontime) {
        this.receptiontime = receptiontime;
    }

    public String getReceptionnurseid() {
        return receptionnurseid;
    }

    public void setReceptionnurseid(String receptionnurseid) {
        this.receptionnurseid = receptionnurseid;
    }

    public String getReceptionlocation() {
        return receptionlocation;
    }

    public void setReceptionlocation(String receptionlocation) {
        this.receptionlocation = receptionlocation;
    }

    public String getEmergencydoctorreceptiontime() {
        return emergencydoctorreceptiontime;
    }

    public void setEmergencydoctorreceptiontime(String emergencydoctorreceptiontime) {
        this.emergencydoctorreceptiontime = emergencydoctorreceptiontime;
    }

    public String getEmergencydoctorreception() {
        return emergencydoctorreception;
    }

    public void setEmergencydoctorreception(String emergencydoctorreception) {
        this.emergencydoctorreception = emergencydoctorreception;
    }

    public String getIsgriddinghospitaltransfrom() {
        return isgriddinghospitaltransfrom;
    }

    public void setIsgriddinghospitaltransfrom(String isgriddinghospitaltransfrom) {
        this.isgriddinghospitaltransfrom = isgriddinghospitaltransfrom;
    }

    public String getHospitalnametransfrom() {
        return hospitalnametransfrom;
    }

    public void setHospitalnametransfrom(String hospitalnametransfrom) {
        this.hospitalnametransfrom = hospitalnametransfrom;
    }

    public String getAttackdepartment() {
        return attackdepartment;
    }

    public void setAttackdepartment(String attackdepartment) {
        this.attackdepartment = attackdepartment;
    }

    public String getEmergencytime() {
        return emergencytime;
    }

    public void setEmergencytime(String emergencytime) {
        this.emergencytime = emergencytime;
    }

    public String getReceptiondoctorid() {
        return receptiondoctorid;
    }

    public void setReceptiondoctorid(String receptiondoctorid) {
        this.receptiondoctorid = receptiondoctorid;
    }

    public String getTimeofcall() {
        return timeofcall;
    }

    public void setTimeofcall(String timeofcall) {
        this.timeofcall = timeofcall;
    }

    public String getDispatch120time() {
        return dispatch120time;
    }

    public void setDispatch120time(String dispatch120time) {
        this.dispatch120time = dispatch120time;
    }

    public String getDepart120time() {
        return depart120time;
    }

    public void setDepart120time(String depart120time) {
        this.depart120time = depart120time;
    }

    public String getArrive120time() {
        return arrive120time;
    }

    public void setArrive120time(String arrive120time) {
        this.arrive120time = arrive120time;
    }

    public String getFmctime() {
        return fmctime;
    }

    public void setFmctime(String fmctime) {
        this.fmctime = fmctime;
    }

    public String getFirstdoctorreceptiontime() {
        return firstdoctorreceptiontime;
    }

    public void setFirstdoctorreceptiontime(String firstdoctorreceptiontime) {
        this.firstdoctorreceptiontime = firstdoctorreceptiontime;
    }

    public String getHospitaltransferfromarrivedtime() {
        return hospitaltransferfromarrivedtime;
    }

    public void setHospitaltransferfromarrivedtime(String hospitaltransferfromarrivedtime) {
        this.hospitaltransferfromarrivedtime = hospitaltransferfromarrivedtime;
    }

    public String getTransferambulancearrivaltime() {
        return transferambulancearrivaltime;
    }

    public void setTransferambulancearrivaltime(String transferambulancearrivaltime) {
        this.transferambulancearrivaltime = transferambulancearrivaltime;
    }

    public String getHospitaltransferfromleavetime() {
        return hospitaltransferfromleavetime;
    }

    public void setHospitaltransferfromleavetime(String hospitaltransferfromleavetime) {
        this.hospitaltransferfromleavetime = hospitaltransferfromleavetime;
    }

    public String getDecidetranstime() {
        return decidetranstime;
    }

    public void setDecidetranstime(String decidetranstime) {
        this.decidetranstime = decidetranstime;
    }

    public String getLeaveattackdepartmenttime() {
        return leaveattackdepartmenttime;
    }

    public void setLeaveattackdepartmenttime(String leaveattackdepartmenttime) {
        this.leaveattackdepartmenttime = leaveattackdepartmenttime;
    }

    public String getBehospitalizedway() {
        return behospitalizedway;
    }

    public void setBehospitalizedway(String behospitalizedway) {
        this.behospitalizedway = behospitalizedway;
    }

    public String getMedicaretype() {
        return medicaretype;
    }

    public void setMedicaretype(String medicaretype) {
        this.medicaretype = medicaretype;
    }

    public String getSeriousillnessmedicare() {
        return seriousillnessmedicare;
    }

    public void setSeriousillnessmedicare(String seriousillnessmedicare) {
        this.seriousillnessmedicare = seriousillnessmedicare;
    }

    public String getAttacktimeinterval() {
        return attacktimeinterval;
    }

    public void setAttacktimeinterval(String attacktimeinterval) {
        this.attacktimeinterval = attacktimeinterval;
    }

    public String getAttackdate() {
        return attackdate;
    }

    public void setAttackdate(String attackdate) {
        this.attackdate = attackdate;
    }

    public String getAttacktimeisinaccurate() {
        return attacktimeisinaccurate;
    }

    public void setAttacktimeisinaccurate(String attacktimeisinaccurate) {
        this.attacktimeisinaccurate = attacktimeisinaccurate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEmergencynursereception() {
        return emergencynursereception;
    }

    public void setEmergencynursereception(String emergencynursereception) {
        this.emergencynursereception = emergencynursereception;
    }

    public String getArrivescenetime() {
        return arrivescenetime;
    }

    public void setArrivescenetime(String arrivescenetime) {
        this.arrivescenetime = arrivescenetime;
    }

    public String getLevavescenetime() {
        return levavescenetime;
    }

    public void setLevavescenetime(String levavescenetime) {
        this.levavescenetime = levavescenetime;
    }
}
