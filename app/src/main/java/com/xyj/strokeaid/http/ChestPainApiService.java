package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.dist.ChestPainImageExaminationBean;

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
    Call<BaseObjectBean> getChestPainOpeationResult(@Body RequestBody info);


}
