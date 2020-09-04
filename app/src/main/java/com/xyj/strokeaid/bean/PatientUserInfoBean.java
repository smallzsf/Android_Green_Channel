package com.xyj.strokeaid.bean;

/**
 * PatientUserInfoBean
 * description: 患者基本信息
 *
 * @author : Licy
 * @String : 2020/9/3
 * email ：licy3051@qq.com
 */
public class PatientUserInfoBean {
    /**
     * ID
     */
    private String id;

    /**
     * 操作人ID
     */
    private String operationid;

    /**
     * 1、卒中 2、胸痛 3、创伤 4、
     */
    private Integer emergencyType;

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
    private Integer age;

    /**
     * 基本信息-性别
     */
    private String gender;

    /**
     * 基本信息-身份证号
     */
    private String idcardno;

    /**
     * 基本信息-无法获取身份证号
     */
    private Integer unablegetidcardno;

    /**
     * 基本信息-出生日期
     */
    private String birthString;

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
    private Integer height;

    /**
     * 基本信息-体重
     */
    private Double weight;

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
    private String medicarecardno;

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
     * 来院方式-来院方式
     */
    private String comingway;

    /**
     * 来院方式-出车单位
     */
    private String helporganization;

    /**
     * 来院方式-患者到院时间(到达医院大门时间)
     */
    private String arrivegatetime;

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
    private String emergencynursereception;

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
     * 来院方式-接诊护士
     */
    private String emergencynurse;

    /**
     * 来院方式-接诊医生
     */
    private String emergencydoctor;

    /**
     * 备注
     */
    private String notes;

    /**
     * 更新人
     */
    private String upStringdBy;

    /**
     * 更新人姓名
     */
    private String upStringdByName;

    /**
     * 更新时间
     */
    private String upStringdByString;

    /**
     * 租户
     */
    private String tenantId;

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
    private Integer behospitalizedway;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    public Integer getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(Integer emergencyType) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Integer getUnablegetidcardno() {
        return unablegetidcardno;
    }

    public void setUnablegetidcardno(Integer unablegetidcardno) {
        this.unablegetidcardno = unablegetidcardno;
    }

    public String getBirthString() {
        return birthString;
    }

    public void setBirthString(String birthString) {
        this.birthString = birthString;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

    public String getMedicarecardno() {
        return medicarecardno;
    }

    public void setMedicarecardno(String medicarecardno) {
        this.medicarecardno = medicarecardno;
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

    public String getArrivegatetime() {
        return arrivegatetime;
    }

    public void setArrivegatetime(String arrivegatetime) {
        this.arrivegatetime = arrivegatetime;
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

    public String getEmergencynursereception() {
        return emergencynursereception;
    }

    public void setEmergencynursereception(String emergencynursereception) {
        this.emergencynursereception = emergencynursereception;
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

    public String getEmergencynurse() {
        return emergencynurse;
    }

    public void setEmergencynurse(String emergencynurse) {
        this.emergencynurse = emergencynurse;
    }

    public String getEmergencydoctor() {
        return emergencydoctor;
    }

    public void setEmergencydoctor(String emergencydoctor) {
        this.emergencydoctor = emergencydoctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUpStringdBy() {
        return upStringdBy;
    }

    public void setUpStringdBy(String upStringdBy) {
        this.upStringdBy = upStringdBy;
    }

    public String getUpStringdByName() {
        return upStringdByName;
    }

    public void setUpStringdByName(String upStringdByName) {
        this.upStringdByName = upStringdByName;
    }

    public String getUpStringdByString() {
        return upStringdByString;
    }

    public void setUpStringdByString(String upStringdByString) {
        this.upStringdByString = upStringdByString;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public Integer getBehospitalizedway() {
        return behospitalizedway;
    }

    public void setBehospitalizedway(Integer behospitalizedway) {
        this.behospitalizedway = behospitalizedway;
    }
}

    
    
       
    