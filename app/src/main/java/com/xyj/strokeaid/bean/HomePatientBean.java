package com.xyj.strokeaid.bean;

/**
 * HomePatientBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/17
 * email ：licy3051@qq.com
 */
public class HomePatientBean {

    private int id = 100;
    private String name;
    private int age;
    private int sex;
    private int diseaseType;
    private String startDiseaseTime;
    private String startGreenChannelTime;
    private String nurseName;
    private String docName;
    private int status;

    public HomePatientBean(String name, int age, int sex, int diseaseType, String startDiseaseTime, String startGreenChannelTime, String nurseName, String docName, int status) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.diseaseType = diseaseType;
        this.startDiseaseTime = startDiseaseTime;
        this.startGreenChannelTime = startGreenChannelTime;
        this.nurseName = nurseName;
        this.docName = docName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(int diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getStartDiseaseTime() {
        return startDiseaseTime;
    }

    public void setStartDiseaseTime(String startDiseaseTime) {
        this.startDiseaseTime = startDiseaseTime;
    }

    public String getStartGreenChannelTime() {
        return startGreenChannelTime;
    }

    public void setStartGreenChannelTime(String startGreenChannelTime) {
        this.startGreenChannelTime = startGreenChannelTime;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

    
    
       
    