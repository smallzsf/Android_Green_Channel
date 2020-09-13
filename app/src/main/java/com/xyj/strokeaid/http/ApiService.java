package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordBean;
import com.xyj.strokeaid.bean.DiagnosticEvaluationBean;
import com.xyj.strokeaid.bean.InformedConsentBean;
import com.xyj.strokeaid.bean.IntraConsultBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.MainBean;
import com.xyj.strokeaid.bean.PatientMedicalRecordBean;
import com.xyj.strokeaid.bean.PreoperativePreparationInfoBean;
import com.xyj.strokeaid.bean.RequestBloodDataBean;
import com.xyj.strokeaid.bean.RequestCTDataBean;
import com.xyj.strokeaid.bean.RequestElectrocardiogramDataBean;
import com.xyj.strokeaid.bean.RequestEmergencyCenterChestpainDataBean;
import com.xyj.strokeaid.bean.RequestGetDiseaseRecordBean;
import com.xyj.strokeaid.bean.RequestGetVitalSigns;
import com.xyj.strokeaid.bean.RequestGetVitalSignsBean;
import com.xyj.strokeaid.bean.RequestImageExaminteDataBean;
import com.xyj.strokeaid.bean.RequestThriveDataBean;
import com.xyj.strokeaid.bean.SendSmsBean;
import com.xyj.strokeaid.bean.StrokeInHosDrugBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.TimeNodeBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBena;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.bean.chestpain.OperationInfoBean;
import com.xyj.strokeaid.bean.chestpain.OtherTreatmentBean;
import com.xyj.strokeaid.bean.chestpain.PatientOutcomeBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * ApiService
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public interface ApiService {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveChestPainTriageInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<ChestPainTriageInfoBean>> getChestPainTriageInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveStrokeTrigaeInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeTrigaeInfoBean>> getStrokeTrigaeInfo(@Body RequestBody info);


    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> editStrokeVitalSigns(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<RequestGetVitalSigns>> getStrokeVitalSignsInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<RequestGetDiseaseRecordBean>> GetDiseaseRecordInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_LOGIN)
    Observable<BaseObjectBean<LoginBean>> login(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_USER_UPDATE_PASSWORD)
    Observable<BaseObjectBean> changePassword(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_USER_UPDATE_PASSWORD)
    Call<BaseObjectBean> changePasswordnor(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_LOGIN_BY_PHONE)
    Observable<BaseObjectBean<LoginBean>> phoneLoign(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_SEND_SMS_FOR_LOGIN)
    Observable<BaseObjectBean<SendSmsBean>> sendSms(@Body RequestBody info);

    /**
     * 获取CT 数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_SEND_CT)
    Call<RequestCTDataBean> sendCT(@Body RequestBody info);

    /**
     * 添加CT 数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_CT)
    Call<BaseObjectBean> addCT(@Body RequestBody info);

    /**
     * 获取影像数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_IMAGE_EXAMINATE)
    Call<RequestImageExaminteDataBean> getImgeExaminate(@Body RequestBody info);

    /**
     * 上传影像数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_IMAGE_EXAMINATE)
    Call<BaseObjectBean> addImgeExaminate(@Body RequestBody info);

    /**
     * 获取血液数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_GET_BLOOD_DATA)
    Call<RequestBloodDataBean> getBloodData(@Body RequestBody info);

    /**
     * 上传血液数据
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_BLOOD_DATA)
    Call<RequestBloodDataBean> addBloodData(@Body RequestBody info);

    /**
     * mRS评分
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_MRS)
    Call<BaseObjectBean> addMrs(@Body RequestBody info);

    /**
     * CGS评分
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_CGS)
    Call<BaseObjectBean> addCgs(@Body RequestBody info);

    /**
     * 洼田吞咽评定
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_SWALLOW)
    Call<BaseObjectBean> addSwallow(@Body RequestBody info);

    /**
     * 病情记录添加
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DISEASE_RECORD_ADD)
    Call<BaseObjectBean> diseaseRecordAdd(@Body RequestBody info);

    /**
     * 病情记录修改
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_UPDATE)
    Call<BaseObjectBean> diseaseRecordUpdate(@Body RequestBody info);


    /**
     * 病情评估根据recordId删除
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_DELETE_BY_RECORDID)
    Call<BaseObjectBean> diseaseRecordDeleteByRecordid(@Body RequestBody info);

    /**
     * 病情评估先删后插
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_EDIT)
    Call<BaseObjectBean> diseaseRecordEdit(@Body RequestBody info);


    /**
     * 病情评估获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GET)
    Call<BaseObjectBean> diseaseRecordGet(@Body RequestBody info);


    /**
     * 病情评估根据recordid获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GETBYRECORDID)
    Call<BaseObjectBean> diseaseRecordGetByRecordid(@Body RequestBody info);


    /**
     * 新建患者信息
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_RECORD)
    Call<BaseObjectBean> newPatienMedical(@Body RequestBody info);

    /**
     * 查询患者信息
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_PATIENMEDICAL_RECORD_GET)
    Call<BaseObjectBean<PatientMedicalRecordBean>> getPatientInfo(@Body RequestBody info);

    /**
     * 生命体征查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_CHEST_PAIN_GET_VITALSIGNS)
    Call<RequestGetVitalSignsBean> getVitalSigns(@Body RequestBody info);


    /**
     * 生命体征编辑
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_CHEST_PAIN_GET_EDIT_VITALSIGNS)
    Call<BaseObjectBean> editVitalSigns(@Body RequestBody info);

    /**
     * 胸痛中心-胸痛诊疗-心电图主表 查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_CHEST_PAIN_GET_ECG_INQUIIRY)
    Call<RequestElectrocardiogramDataBean> getECGInquiry(@Body RequestBody info);


    /**
     * 胸痛 病情记录保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_DISEASERECORD_SAVE)
    Call<BaseObjectBean> saveChestPainDiseaseRecord(@Body RequestBody info);

    /**
     * 卒中 诊断评估 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveDiagnosticEvaluation(@Body RequestBody info);

    /**
     * 卒中 诊断评估 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<DiagnosticEvaluationBean>> getDiagnosticEvaluation(@Body RequestBody info);


    /**
     * 胸痛 病情记录查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_DISEASERECORD_GET)
    Call<BaseObjectBean<ChestPainDiseaseRecordBean>> getChestPainDiseaseRecord(@Body RequestBody info);

    /**
     * 胸痛--会诊信息 查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_INTRA_CONSULT_GET)
    Call<BaseObjectBean<IntraConsultBean>> getChestPainIntraConsult(@Body RequestBody info);

    /**
     * 胸痛--会诊信息 保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_INTRA_CONSULT_SAVE)
    Call<BaseObjectBean> saveChestPainIntraConsult(@Body RequestBody info);


    /**
     * 胸痛--患者转归 查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_PATIENT_OUTCOME_GET)
    Call<BaseObjectBean<PatientOutcomeBean>> getChestPainPatientOutcome(@Body RequestBody info);

    /**
     * 胸痛--患者转归 保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_PATIENT_OUTCOME_SAVE)
    Call<BaseObjectBean> saveChestPainPatientOutcome(@Body RequestBody info);


    /**
     * 胸痛--其他处置 查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OTHER_TRETMENT_GET)
    Call<BaseObjectBean<OtherTreatmentBean>> getChestPainOtherTreatment(@Body RequestBody info);

    /**
     * 胸痛--其他处置 保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OTHER_TRETMENT_SAVE)
    Call<BaseObjectBean> saveChestPainOtherTreatment(@Body RequestBody info);

    /**
     * 胸痛--静脉溶栓
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_GET_INTRAVENOUS_THROMBOLYSIS)
    Call<RequestEmergencyCenterChestpainDataBean> getIntravenousThrombolysis(@Body RequestBody info);

    /**
     * 胸痛--静脉溶栓 保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_INTRAVENOUS_THROMBOLYSIS_SAVE)
    Call<BaseObjectBean> saveIntravenousThrombolysis(@Body RequestBody info);


    /**
     * 胸痛中心-手术信息-保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OPERATION_INFO_SAVE)
    Call<BaseObjectBean> saveChestPainOperationInfo(@Body RequestBody info);


    /**
     * 胸痛中心-手术信息-获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OPERATION_INFO_GET)
    Call<BaseObjectBean<OperationInfoBean>> getChestPainOperationInfo(@Body RequestBody info);


    /**
     * 胸痛--初始诊断--Grace--保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GRACE_SAVE)
    Call<BaseObjectBean> getChestPainDiagnoseGraceSave(@Body RequestBody info);


    /**
     * 胸痛--初始诊断--Grace--获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GRACE_GET)
    Call<BaseObjectBean<ChestpainGraceScoreBean.ChestpainResponseGraceScoreBean>> getChestPainDiagnoseGraceGet(@Body RequestBody info);


    /**
     * 胸痛--初始诊断--查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_GET)
    Call<BaseObjectBean<ChestPainDiagnosisBean.ChestPainResponseBean>> getChestPainDiagnoseGet(@Body RequestBody info);


    /**
     * 胸痛--初始诊断--保存
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_SAVE)
    Call<BaseObjectBean> getChestPainDiagnoseSave(@Body RequestBody info);

    /**
     * 胸痛--初始诊断--患者绕行--编辑
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_PATIENTS_DETOUR_EDIT)
    Call<BaseObjectBean> getChestPainDiagnosePatientsDetourEdit(@Body RequestBody info);

    /**
     * 胸痛--初始诊断--患者绕行--查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ORIGINAL_DIAGNOSE_PATIENTS_DETOUR_GET)
    Call<BaseObjectBean<ChestPainPatientsDetourBena.ChestPainResponsePatientsDetourBean>> getChestPainDiagnosePatientsDetourGet(@Body RequestBody info);


    /**
     * 主页 卒中、胸痛、创伤列表查询
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_CHEST_EMERGENCYCENTER_RECORD_SELECT)
    Call<BaseObjectBean<MainBean>> getMainList(@Body RequestBody info);

    /**
     * 获取时间线
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_EMERGENCYCENTER_RECORDJSON_GETTIMELINE)
    Call<BaseObjectBean<List<TimeNodeBean>>> getTimerLine(@Body RequestBody info);

    /**
     * 录入术前准备
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> savePreoperativePreparation(@Body RequestBody info);

    /**
     * 获取术前准备
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<PreoperativePreparationInfoBean>> getPreoperativePreparation(@Body RequestBody info);

    /**
     * THRIVE 评分
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_CHEST_EMERGENCYCENTER_THRIVE)
    Call<BaseObjectBean<RequestThriveDataBean>> addThriveScore(@Body RequestBody info);

    /**
     * 卒中 药物治疗 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeInHosDrugBean>> getStrokeInHosDrug(@Body RequestBody info);


    /**
     * 介入知情同意
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseObjectBean<InformedConsentBean>> getFamilyOpinion(@Body RequestBody info);

    /**
     * 介入知情同意
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseResponseBean> saveFamilyOpinion(@Body RequestBody info);

}
