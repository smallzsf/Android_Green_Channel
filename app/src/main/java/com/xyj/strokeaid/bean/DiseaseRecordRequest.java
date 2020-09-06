package com.xyj.strokeaid.bean;

/**
 * @Description: 病情记录请求类
 * @Author: crq
 * @CreateDate: 2020/9/5 17:41
 */
public class DiseaseRecordRequest {
    /**
     * 添加
     */
    public static class DiseaseRecordAdd {
        private String chiefcomplaint;
        private String conditionremark;
        private String drugallergy;
        private String medicaldrughistory;
        private String medicalhistory;
        private String symptom;
        private String recordId;

        public DiseaseRecordAdd(String chiefcomplaint, String conditionremark, String drugallergy, String medicaldrughistory, String medicalhistory, String symptom, String recordId) {
            this.chiefcomplaint = chiefcomplaint;
            this.conditionremark = conditionremark;
            this.drugallergy = drugallergy;
            this.medicaldrughistory = medicaldrughistory;
            this.medicalhistory = medicalhistory;
            this.symptom = symptom;
            this.recordId = recordId;
        }
    }

    /**
     * 修改
     */
    public static class DiseaseRecordUpdate {
        private String id;
        private String chiefcomplaint;
        private String conditionremark;
        private String drugallergy;
        private String medicaldrughistory;
        private String medicalhistory;
        private String symptom;
        private String recordId;

        public DiseaseRecordUpdate(String id, String chiefcomplaint, String conditionremark, String drugallergy, String medicaldrughistory, String medicalhistory, String symptom, String recordId) {
            this.id = id;
            this.chiefcomplaint = chiefcomplaint;
            this.conditionremark = conditionremark;
            this.drugallergy = drugallergy;
            this.medicaldrughistory = medicaldrughistory;
            this.medicalhistory = medicalhistory;
            this.symptom = symptom;
            this.recordId = recordId;
        }
    }

    /**
     * 根据recordId删除
     */
    public static class DiseaseRecordDeleteByRecordId {
        private String recordId;

        public DiseaseRecordDeleteByRecordId(String recordId) {
            this.recordId = recordId;
        }
    }


    /**
     * 先删后插
     */
    public static class DiseaseRecordEdit {
        private String id;
        private String chiefcomplaint;
        private String conditionremark;
        private String drugallergy;
        private String medicaldrughistory;
        private String medicalhistory;
        private String symptom;

        public DiseaseRecordEdit(String id, String chiefcomplaint, String conditionremark, String drugallergy, String medicaldrughistory, String medicalhistory, String symptom) {
            this.id = id;
            this.chiefcomplaint = chiefcomplaint;
            this.conditionremark = conditionremark;
            this.drugallergy = drugallergy;
            this.medicaldrughistory = medicaldrughistory;
            this.medicalhistory = medicalhistory;
            this.symptom = symptom;
        }
    }

    /**
     * 获取
     */
    public static class DiseaseRecordGet {
        private String id;

        public DiseaseRecordGet(String id) {
            this.id = id;
        }
    }

    /**
     * 根据recordid获取
     */
    public static class DiseaseRecordGetByRecordId {
        private String recordId;

        public DiseaseRecordGetByRecordId(String recordId) {
            this.recordId = recordId;
        }
    }


}
