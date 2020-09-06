package com.xyj.strokeaid.bean;

/**
 * @Description: 新建患者信息传参类
 * @Author: crq
 * @CreateDate: 2020/9/4 20:15
 */
public class NewPatientMedicalRecordBean {

    /**
     * id :
     * operationid :
     * emergencyType :
     * empId :
     * fullname :
     * age :
     * gender :
     * idcardno :
     * unablegetidcardno :
     * birthdate :
     * nation :
     * contactname :
     * contactnumber :
     * attacktime :
     * attackaddress :
     * height :
     * weight :
     * bmi :
     * registeraddress :
     * medicarecardno :
     * patientidofambulant :
     * patientidofhospitalization :
     * timecollectorcode :
     * timecollectorserialnumber :
     * timecollectorontime :
     * timecollectorofftime :
     * comingway :
     * helporganization :
     * arrivegatetime :
     * arrivedertime :
     * fromattacktoarrivegate :来院方式-发病到入门
     * receptiontime :来院方式-接诊时间
     * emergencynursereception : 来院方式-接诊护士
     * receptionlocation :          来院方式-接诊地点
     * emergencydoctorreceptiontime : 来院方式-急诊医生接诊
     * emergencydoctorreception : 来院方式-急诊医生
     * isgriddinghospitaltransfrom : 来院方式-来源医院是否网络医院
     * hospitalnametransfrom : 来院方式-来源医院
     * attackdepartment :来院方式-发病科室
     * emergencytime :来院方式-接诊时间
     * emergencynurse :来院方式-接诊护士
     * emergencydoctor :来院方式-接诊医生
     * notes :          备注
     * updatedBy :     更新人
     * updatedByName : 更新人姓名
     * updatedByDate : 更新时间
     * tenantId :    租户
     * timeofcall :  呼救时间
     * dispatch120time :120派车时间
     * depart120time : 120出车时间
     * arrive120time : 120到达时间
     * fmctime :首次医疗接触时间
     * firstdoctorreceptiontime :院内医师接诊时间
     * hospitaltransferfromarrivedtime : 转出医院入门时间
     * transferambulancearrivaltime :转运救护车到达时间
     * hospitaltransferfromleavetime : 离开转出医院时间(转出医院出门时间)
     * decidetranstime :决定转院时间
     * leaveattackdepartmenttime : 离开科室时间
     * behospitalizedway :  入院途径1急诊 2门诊 3其他医疗机构转入4其他
     */




    private String id;
    private String operationid;
    private String emergencyType;
    private String empId;
    private String fullname;
    private String age;
    private String gender;
    private String idcardno;
    private String unablegetidcardno;
    private String birthdate;
    private String nation;
    private String contactname;
    private String contactnumber;
    private String attacktime;
    private String attackaddress;
    private String height;
    private String weight;
    private String bmi;
    private String registeraddress;
    private String medicarecardno;
    private String patientidofambulant;
    private String patientidofhospitalization;
    private String timecollectorcode;
    private String timecollectorserialnumber;
    private String timecollectorontime;
    private String timecollectorofftime;
    private String comingway;
    private String helporganization;
    private String arrivegatetime;
    private String arrivedertime;
    private String fromattacktoarrivegate;
    private String receptiontime;
    private String emergencynursereception;
    private String receptionlocation;
    private String emergencydoctorreceptiontime;
    private String emergencydoctorreception;
    private String isgriddinghospitaltransfrom;
    private String hospitalnametransfrom;
    private String attackdepartment;
    private String emergencytime;
    private String emergencynurse;
    private String emergencydoctor;
    private String notes;
    private String updatedBy;
    private String updatedByName;
    private String updatedByDate;
    private String tenantId;
    private String timeofcall;
    private String dispatch120time;
    private String depart120time;
    private String arrive120time;
    private String fmctime;
    private String firstdoctorreceptiontime;
    private String hospitaltransferfromarrivedtime;
    private String transferambulancearrivaltime;
    private String hospitaltransferfromleavetime;
    private String decidetranstime;
    private String leaveattackdepartmenttime;
    private String behospitalizedway;

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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public String getUpdatedByDate() {
        return updatedByDate;
    }

    public void setUpdatedByDate(String updatedByDate) {
        this.updatedByDate = updatedByDate;
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

    public String getBehospitalizedway() {
        return behospitalizedway;
    }

    public void setBehospitalizedway(String behospitalizedway) {
        this.behospitalizedway = behospitalizedway;
    }
}
