package com.xyj.strokeaid.http;

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
}
