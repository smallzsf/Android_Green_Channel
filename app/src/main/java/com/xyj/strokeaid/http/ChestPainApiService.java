package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ChestpainEcgDetailBean;
import com.xyj.strokeaid.bean.chestpain.EmergencyCenterChestpainDrugPo;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;
import com.xyj.strokeaid.bean.dist.ChestPainOperationRsultBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ChestPainApiService {

    /**
     * 胸痛 血液检查获取
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_BLOOD_TEST_GET)
    Call<String> getChestPainBloodText(@Body RequestBody info);

    /**
     * 胸痛 影像检查获取
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_IMAGING_EXAMINATION_GET)
    Call<ChestPainImageExaminationBean> getChestPainImageExamination(@Body RequestBody info);

    /**
     * 胸痛 影像检查保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_IMAGING_EXAMINATION_SAVE)
    Call<BaseObjectBean> saveChestPainImageExamination(@Body RequestBody info);

    /**
     * 手术信息，结果信息 保存
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OPERATION_RESULT_SAVE)
    Call<BaseObjectBean> saveChestPainOpeationResult(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_OPERATION_RESULT_GET)
    Call<BaseObjectBean<ChestPainOperationRsultBean>> getChestPainOpeationResult(@Body RequestBody info);


    /**
     * 手术信息，结果信息 保存
     * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDrug/edit
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_EMERGENCY_CENTER_SAVE)
    Call<BaseObjectBean> saveChestPainsuEmergencyCenter(@Body RequestBody info);

    /**
     *
     * 手术信息，结果信息 获取
     * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDrug/getByRecordId   */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_EMERGENCY_CENTER_GET)
    Call<BaseObjectBean<EmergencyCenterChestpainDrugPo>> getChestPainsuEmergencyCenter(@Body RequestBody info);

    /**
     * App--胸痛--血液检查--保存
     http://localhost/yjjk-gateway/yjjk-cdm-api/v1/chestpainLaboratoryExamination/edit
     *    */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_LABORATORY_EXAMINATION_SAVE)
    Call<BaseObjectBean> postChestPainLaboraoryExamination(@Body RequestBody info);


    /**
     * 胸痛中心-胸痛诊疗-心电图 主表获取
     * http://localhost/yjjk-gateway/yjjk-cdm-api/v1/emergencyCenterChestpainDrug/getByRecordId   */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<ChestpainEcgDetailBean>> getChestPainsuEcgDetail(@Body RequestBody info);

    /**
     * 胸痛中心-胸痛诊疗-心电图 主表添加
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseObjectBean> saveChestPainsuEcgDetail(@Body RequestBody info);


    /**
     * App--胸痛--治疗决策--直接PCI--保存 胸痛中心-初步诊断-
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.ChestPain.NET_URL_CHEST_PAIN_ECG_DETAIL_SAVE)
    Call<BaseObjectBean> saveReperfusionmeasures(@Body RequestBody info);
}
