package com.xyj.strokeaid.bean;

/**
 * @author ck
 *  主页 列表数据  卒中、胸痛、创伤
 */
public class MainListBean {

    private String id;// 记录ID
    private String empId; // 居民ID
    private String emergencyType;//1、卒中 2、胸痛
    private String fullname; // 姓名
    private String age; // 年龄
    private String gender; // 性别 1男2女
    private String idcardno; // 身份证号
    private String attacktime; // 发病时间yyyy-MM-dd

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
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
        if (gender == null) {
            gender = "未知";
        }
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

    public String getAttacktime() {
        return attacktime;
    }

    public void setAttacktime(String attacktime) {
        this.attacktime = attacktime;
    }

    @Override
    public String toString() {
        return "MainListBean{" +
                "id='" + id + '\'' +
                ", empId='" + empId + '\'' +
                ", emergencyType='" + emergencyType + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", idcardno='" + idcardno + '\'' +
                ", attacktime='" + attacktime + '\'' +
                '}';
    }
}
