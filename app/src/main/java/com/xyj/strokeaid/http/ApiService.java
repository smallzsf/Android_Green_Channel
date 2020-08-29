package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
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
}
