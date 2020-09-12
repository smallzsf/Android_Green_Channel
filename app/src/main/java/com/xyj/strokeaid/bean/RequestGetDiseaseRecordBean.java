package com.xyj.strokeaid.bean;

public class RequestGetDiseaseRecordBean {
    
    public String recordId;//记录ID

    public String chiefcomplaint;//病情记录-主诉

    public String symptom;//病情记录-症状

    public String medicalhistory;//病情记录-既往病史

    public String medicaldrughistory;//病情记录-既往用药史 :

    public String drugallergy;//病情记录-药物过敏史

    public String conditionremark;//病情记录-备注

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getChiefcomplaint() {
        return chiefcomplaint;
    }

    public void setChiefcomplaint(String chiefcomplaint) {
        this.chiefcomplaint = chiefcomplaint;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public String getMedicaldrughistory() {
        return medicaldrughistory;
    }

    public void setMedicaldrughistory(String medicaldrughistory) {
        this.medicaldrughistory = medicaldrughistory;
    }

    public String getDrugallergy() {
        return drugallergy;
    }

    public void setDrugallergy(String drugallergy) {
        this.drugallergy = drugallergy;
    }

    public String getConditionremark() {
        return conditionremark;
    }

    public void setConditionremark(String conditionremark) {
        this.conditionremark = conditionremark;
    }
}
