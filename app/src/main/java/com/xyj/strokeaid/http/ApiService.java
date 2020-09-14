package com.xyj.strokeaid.http;

import com.xyj.strokeaid.activity.stroke.EmergencyCenterStrokeAneurysmSurgeryData;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordBean;
import com.xyj.strokeaid.bean.DiagnosticEvaluationBean;
import com.xyj.strokeaid.bean.InformedConsentBean;
import com.xyj.strokeaid.bean.EmergencyCenterStrokeInterventionalTherapyPo;
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
import com.xyj.strokeaid.bean.SiscontraindicationBean;
import com.xyj.strokeaid.bean.StrokeInHosDrugBean;
import com.xyj.strokeaid.bean.StrokeBloodExaminationBean;
import com.xyj.strokeaid.bean.StrokeOperationOnInfoBean;
import com.xyj.strokeaid.bean.StrokeOtherDisposalBean;
import com.xyj.strokeaid.bean.ThrombolysisAssessmentBean;
import com.xyj.strokeaid.bean.ThrombolysisTreatmentBean;
import com.xyj.strokeaid.bean.StrokeTransferBean;
import com.xyj.strokeaid.bean.TimeNodeBean;
import com.xyj.strokeaid.bean.StrokeTrigaeInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainDiagnosisBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainPatientsDetourBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;
import com.xyj.strokeaid.bean.chestpain.ChestpainGraceScoreBean;
import com.xyj.strokeaid.bean.chestpain.OperationInfoBean;
import com.xyj.strokeaid.bean.chestpain.OtherTreatmentBean;
import com.xyj.strokeaid.bean.chestpain.PatientOutcomeBean;
import com.xyj.strokeaid.bean.trauma.TraumaEcgCheckBean;
import com.xyj.strokeaid.bean.trauma.TraumaOperationInfoBean;
import com.xyj.strokeaid.bean.dist.CeaCesBean;
import com.xyj.strokeaid.bean.dist.StrokeSangguineousBean;
import com.xyj.strokeaid.bean.score.ContraindicationPo;
import com.xyj.strokeaid.bean.score.MyindicationPo;

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
    Call<BaseObjectBean> saveAneurysm(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<EmergencyCenterStrokeAneurysmSurgeryData>> getAneurysm(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveStrokeSangguineousInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeSangguineousBean>> getStrokeSangguineousInfo(@Body RequestBody info);

    /**
     * 溶栓治疗
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<ThrombolysisTreatmentBean>> getThrombolysisTreatmentInfo(@Body RequestBody info);

    /**
     * 溶栓评估
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<ThrombolysisAssessmentBean>> getThrombolysisAssessment(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> editStrokeVitalSigns(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<RequestGetVitalSigns>> getStrokeVitalSignsInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveStrokeCeaCesInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<CeaCesBean>> getStrokeCeaCesInfo(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<RequestGetDiseaseRecordBean>> GetDiseaseRecordInfo(@Body RequestBody info);


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
     * fast评分
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_FAST)
    Call<BaseObjectBean> getFastEdScoreSave(@Body RequestBody info);

    /**
     * Nihss评分
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_NIHSS)
    Call<BaseObjectBean> addNihss(@Body RequestBody info);

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
     * 卒中 其它处置 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveOtherDisposalData(@Body RequestBody info);

    /**
     * 卒中 其它处置 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeOtherDisposalBean>> getOtherDisposalData(@Body RequestBody info);


    /**
     * 卒中 血液检查  保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveBloodExaminationInfo(@Body RequestBody info);


    /**
     * 卒中 血液检查  获取
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeBloodExaminationBean>> getBloodExaminationInfo(@Body RequestBody info);


    /**
     * 卒中 转归交接 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveStrokeTransferInfo(@Body RequestBody info);


    /**
     * 卒中 转归交接  获取
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeTransferBean>> getStrokeTransferInfo(@Body RequestBody info);

    /**
     * 卒中 诊断评估 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<DiagnosticEvaluationBean>> getDiagnosticEvaluation(@Body RequestBody info);

    /**
     * 创伤 手术信息 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<TraumaOperationInfoBean>> getTraumaOperationInfo(@Body RequestBody info);

    /**
     * 创伤 手术信息 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveTraumaOperationInfo(@Body RequestBody info);

    /**
     * 创伤 心电检查 查询
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<TraumaEcgCheckBean>> getTraumaEcgCheck(@Body RequestBody info);


    /**
     * 创伤 心电检查 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveTraumaEcgCheck(@Body RequestBody info);
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
    Call<BaseObjectBean<ChestPainPatientsDetourBean.ChestPainResponsePatientsDetourBean>> getChestPainDiagnosePatientsDetourGet(@Body RequestBody info);





    /**
     *-卒中--手术治疗--介入--适应症评估--获取
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_GET_MYINDICATION)
    Call<BaseObjectBean<MyindicationPo>> getMyindication(@Body RequestBody info);

    /**
     * -卒中--手术治疗--介入--适应症评估--保存
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_SAVE_MYINDICATION)
    Call<BaseObjectBean<MyindicationPo>> saveMyindication(@Body RequestBody info);

    /**
     *  -卒中--手术治疗--介入--禁忌症评估- 获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_GET_CONTRAINDICATION)
    Call<BaseObjectBean<ContraindicationPo>> getContraindication(@Body RequestBody info);
    /**
     *  -卒中--手术治疗--介入--禁忌症评估- 获取
     *
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_SAVE_CONTRAINDICATION)
    Call<BaseObjectBean<ContraindicationPo>> saveContraindication(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveEcsitherapy(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<EmergencyCenterStrokeInterventionalTherapyPo>> getEcsitherapy(@Body RequestBody info);

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

    /**
     * 录入术中治疗信息
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveStrokeOperationOnInfo(@Body RequestBody info);

    /**
     * 获取录中治疗信息
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<StrokeOperationOnInfoBean>> getStrokeOperationOnInfo(@Body RequestBody info);


    /**
     * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/siscontraindication/add
     POST
     静脉溶栓禁忌症评估
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_SAVE_SISCONTRAINDICATION)
    Call<BaseResponseBean<SiscontraindicationBean>> saveSiscontraindication(@Body RequestBody info);

    /**
     * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/siscontraindication/add
     POST
     静脉溶栓禁忌症评估
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_SAVE_SISCONTRAINDICATION)
    Call<BaseResponseBean<SiscontraindicationBean>> getSiscontraindication(@Body RequestBody info);


}
