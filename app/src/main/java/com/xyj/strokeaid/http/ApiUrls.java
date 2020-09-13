package com.xyj.strokeaid.http;

import com.xyj.strokeaid.BuildConfig;

/**
 * ApiUrls
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public class ApiUrls {

    public static final String PRODUCTION_ENVIRONMENT_FOR_API = "https://ykj.yjjk.net.cn/";
    public static final String PRODUCTION_ENVIRONMENT_FOR_FILE = "https://ykj.yjjk.net.cn/";

    public static final String DEVELOP_ENVIRONMENT_FOR_API = "http://ykj.yjjk366.com/";
    public static final String DEVELOP_ENVIRONMENT_FOR_FILE = "http://ykj.yjjk366.com/";

    /**
     * PRODUCTION_ENVIRONMENT_FILE_SERVER
     */
    public static final String FILE_URL = BuildConfig.DEBUG ? DEVELOP_ENVIRONMENT_FOR_FILE : PRODUCTION_ENVIRONMENT_FOR_FILE;
    /**
     * PRODUCTION_ENVIRONMENT
     */
    public static final String BASE_URL = BuildConfig.DEBUG ? DEVELOP_ENVIRONMENT_FOR_API : PRODUCTION_ENVIRONMENT_FOR_API;

    /**
     * 登陆
     */
    public static final String NET_URL_LOGIN = "yjjk-gateway/yjjk-pt-api/v1/user/mobileLogin";
    /**
     * 请求验证码
     */
    public static final String NET_URL_SEND_SMS_FOR_LOGIN = "yjjk-gateway/yjjk-pt-api/v1/common/sms/authcode/send";
    /**
     * 使用手机号密码登录
     */
    public static final String NET_URL_LOGIN_BY_PHONE = "yjjk-gateway/yjjk-pt-api/v1/user/loginByAuthcode";

    /**
     * 文件上传
     */
    public static final String NET_URL_COMMON_FILE_UPLOAD = "yjjk-gateway/yjjk-pt-api/v1/common/upload";


    /**
     * 修改用户密码
     */
    public static final String NET_URL_USER_UPDATE_PASSWORD = "yjjk-gateway/yjjk-pt-api/v1/user/updatePassword";
    /**
     * 腕带设备绑定
     * {
     *    "deviceType": 5,
     *    "deviceNo": "f2fc"
     * }
     * deviceType固定为5
     */
    public static final String NET_URL_WRISTBAND_BIND = "yjjk-gateway/yjjk-pt-api/v1/devices/bind";
    /**
     * 腕带设备解绑定
     * 同上
     */
    public static final String NET_URL_WRISTBAND_UNBIND = "yjjk-gateway/yjjk-pt-api/v1/devices/unbind";


    /**
     * 通用获取接口
     */
    public static final String NET_URL_COMMON_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/recordJson/getByKeyList";
    /**
     * 通用保存接口
     */
    public static final String NET_URL_COMMON_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/recordJson/editForApp";
    /**
     * 新建患者信息
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_RECORD = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/record/addForApp";
    /**
     * 查询患者信息
     */
    public static final String NET_URL_PATIENMEDICAL_RECORD_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/record/get";

    /**
     * 获取CT信息
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_SEND_CT = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeCTExam/select";

    /**
     * 添加CT信息
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_ADD_CT = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeCTExam/add";

    /**
     * 影像检查
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_IMAGE_EXAMINATE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeImageExam/select";

    /**
     * 上传检查
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_ADD_IMAGE_EXAMINATE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeImageExam/add";

    /**
     * 获取血液数据
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_GET_BLOOD_DATA = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeExaminationDetail/select";

    /**
     * 上传血液数据
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_ADD_BLOOD_DATA = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeExaminationDetail/add";

    /**
     * MRS评分
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_MRS = "yjjk-gateway/yjjk-cdm-api/v1/mrs/add";

    /**
     * CGS评分
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_CGS = "yjjk-gateway/yjjk-cdm-api/v1/gcs/add";

    /**
     * 吞咽评定
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_SWALLOW = "yjjk-gateway/yjjk-cdm-api/v1/eat/add";


    /**
     * 病情评估添加
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DISEASE_RECORD_ADD = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/add";


    /**
     * 病情评估修改
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_UPDATE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/update";


    /**
     * 病情评估根据recordId删除
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_DELETE_BY_RECORDID = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/deleteByRecordId";


    /**
     * 病情评估先删后插
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_EDIT = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/edit";

    /**
     * 病情评估获取
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/get";

    /**
     * 病情评估根据recordid获取
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GETBYRECORDID = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokePathography/getByRecordId";

    /**
     * 胸痛 血液检查
     */
    public static class ChestPain {

        /**
         * 胸痛 血液检查获取
         */
        public static final String NET_URL_CHEST_PAIN_BLOOD_TEST_GET = "yjjk-gateway/yjjk-cdm-api/v1/chestpainLaboratoryExamination/get";


        /**
         * 胸痛 影像检查 信息获取
         */
        public static final String NET_URL_CHEST_PAIN_IMAGING_EXAMINATION_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainImagingExamination/get";

        /**
         * 胸痛 影像检查 信息上传
         */
        public static final String NET_URL_CHEST_PAIN_IMAGING_EXAMINATION_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainImagingExamination/edit";

        /**
         * 胸痛 病情记录保存
         */
        public static final String NET_URL_CHEST_PAIN_DISEASERECORD_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/chestpain/editForApp";

        /**
         *  卒中 诊断评估 保存
         */
        public static final String NET_URL_DIAGNOSTICEVALUATION_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeDiagnosis/edit";


        /**
         *  卒中 诊断评估 查询
         */
        public static final String NET_URL_DIAGNOSTICEVALUATION_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterStrokeDiagnosis/getByRecordId";

        /**
         * 胸痛 病情记录查询
         */
        public static final String NET_URL_CHEST_PAIN_DISEASERECORD_GET = "yjjk-gateway/yjjk-cdm-api/v1/chestpain/get";


        /**
         * 胸痛 会诊信息 获取
         */
        public static final String NET_URL_CHEST_PAIN_INTRA_CONSULT_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainHeartConsultation/get";
        /**
         * 胸痛 会诊信息 保存
         */
        public static final String NET_URL_CHEST_PAIN_INTRA_CONSULT_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainHeartConsultation/edit";

        /**
         * 胸痛 患者转归 获取
         */
        public static final String NET_URL_CHEST_PAIN_PATIENT_OUTCOME_GET = "yjjk-gateway/yjjk-cdm-api/v1/dischargeDdiagnosis/get";
        /**
         * 胸痛 患者转归 保存
         */
        public static final String NET_URL_CHEST_PAIN_PATIENT_OUTCOME_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/dischargeDdiagnosis/edit";

        /**
         * 胸痛 其他处置 获取
         */
        public static final String NET_URL_CHEST_PAIN_OTHER_TRETMENT_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDischargedInformation/getByRecordId";
        /**
         * 胸痛 其他处置 保存
         */
        public static final String NET_URL_CHEST_PAIN_OTHER_TRETMENT_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDischargedInformation/edit";

        /**
         * 胸痛中心-静脉溶栓
         */
        public static final String NET_URL_CHEST_PAIN_GET_INTRAVENOUS_THROMBOLYSIS = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainHospitalThrombolyticTherapy/get";

        /**
         * 胸痛中心-静脉溶栓保存
         */
        public static final String NET_URL_CHEST_PAIN_INTRAVENOUS_THROMBOLYSIS_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainHospitalThrombolyticTherapy/edit";


        /**
         * 胸痛中心-手术信息-结果保存
         */
        public static final String NET_URL_CHEST_PAIN_OPERATION_RESULT_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/chestpainOperationResult/edit";


        /**
         * 胸痛中心-手术信息-结果获取
         * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/chestpainOperationResultCoronaryAngiography/get
         */
        public static final String NET_URL_CHEST_PAIN_OPERATION_RESULT_GET = "yjjk-gateway/yjjk-cdm-api/v1/chestpainOperationResultCoronaryAngiography/get";
        /**
         * 胸痛--初始药物--保存 胸痛中心-初步诊断
         */
        public static final String NET_URL_CHEST_PAIN_EMERGENCY_CENTER_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDrug/edit";
        /**
         * 胸痛--初始药物--获取 胸痛中心-初步诊断
         */
        public static final String NET_URL_CHEST_PAIN_EMERGENCY_CENTER_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDrug/getByRecordId";
        /**
         * yjjk-gateway/yjjk-cdm-api/v1/chestpainLaboratoryExamination/edit
         */
        public static final String NET_URL_CHEST_PAIN_LABORATORY_EXAMINATION_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/chestpainLaboratoryExamination/edit";


        /**
         * 胸痛中心-手术信息-保存
         */
        public static final String NET_URL_CHEST_PAIN_OPERATION_INFO_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/room/edit";


        /**
         * 胸痛中心-手术信息-获取
         */
        public static final String NET_URL_CHEST_PAIN_OPERATION_INFO_GET = "yjjk-gateway/yjjk-cdm-api/v1/room/get";

        /**
         * 胸痛中心-胸痛诊疗-心电图-详情获取
         */
        public static final String NET_URL_CHEST_PAIN_ECG_DETAIL_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainEcgDetail/getByRecordId";

        /**
         * 胸痛中心-胸痛诊疗-心电图 主表添加
         */
        public static final String NET_URL_CHEST_PAIN_ECG_DETAIL_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainEcg/edit";

        /**
         * 胸痛--初始诊断--Grace--保存
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GRACE_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainGraceScore/edit";

        /**
         * 胸痛--初始诊断--Grace--获取
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GRACE_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainGraceScore/get";

        /**
         * 胸痛--初始诊断--查询
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GET = "yjjk-gateway/yjjk-cdm-api/v1/chestpainDiagnosis/get";

        /**
         * 胸痛--初始诊断--保存
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_SAVE = "yjjk-gateway/yjjk-cdm-api/v1/chestpainDiagnosis/edit";

        /**
         * 胸痛--初始诊断--患者绕行--编辑
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_PATIENTS_DETOUR_EDIT = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/chestpain/patientsDetour/edit";

        /**
         * 胸痛--初始诊断--患者绕行--查询
         */
        public static final String NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_PATIENTS_DETOUR_GET = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/chestpain/patientsDetour/getByRecordId";

    }

    /**
     * 生命体征查询
     */
    public static final String NET_URL_CHEST_PAIN_GET_VITALSIGNS = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/chestpain/vitalSigns/getByRecordId";

    /**
     * 生命体征编辑
     */
    public static final String NET_URL_CHEST_PAIN_GET_EDIT_VITALSIGNS = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/chestpain/vitalSigns/edit";

    /**
     * 胸痛中心-胸痛诊疗-心电图主表 查询
     */
    public static final String NET_URL_CHEST_PAIN_GET_ECG_INQUIIRY = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainEcg/getByRecordId";

    /**
     * 胸痛中心-胸痛诊疗-心电图主表 添加
     */
    public static final String NET_URL_CHEST_PAIN_GET_ECG_EDIT = "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainEcg/edit";

    /**
     * 主页 卒中、胸痛、创伤列表查询
     */
    public static final String NET_URL_CHEST_EMERGENCYCENTER_RECORD_SELECT= "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/record/select";

    /**
     * 获取时间线
     */
    public static final String NET_URL_EMERGENCYCENTER_RECORDJSON_GETTIMELINE= "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/recordJson/getTimeLine";


    /**
     * -卒中--手术治疗--介入--适应症评估--获取
     */
    public static final String NET_URL_GET_MYINDICATION= "yjjk-gateway/yjjk-cdm-api/v1/myindication/get";

    /**
     * -卒中--手术治疗--介入--适应症评估--保存
     */
    public static final String NET_URL_SAVE_MYINDICATION= "yjjk-gateway/yjjk-cdm-api/v1/myindication/add";

}

    
    
       
    