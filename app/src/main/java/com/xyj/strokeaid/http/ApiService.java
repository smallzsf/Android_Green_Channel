package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.SendSmsBean;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
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

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(ApiUrls.NET_URL_LOGIN)
    Observable<BaseObjectBean<LoginBean>> login(@Body RequestBody info);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(ApiUrls.NET_URL_USER_UPDATE_PASSWORD)
    Observable<BaseObjectBean> changePassword(@Body RequestBody info);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(ApiUrls.NET_URL_USER_UPDATE_PASSWORD)
    Call<BaseObjectBean> changePasswordnor(@Body RequestBody info);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(ApiUrls.NET_URL_LOGIN_BY_PHONE)
    Observable<BaseObjectBean<LoginBean>> phoneLoign(@Body RequestBody info);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST(ApiUrls.NET_URL_SEND_SMS_FOR_LOGIN)
    Observable<BaseObjectBean<SendSmsBean>>  sendSms(@Body RequestBody info);
}
