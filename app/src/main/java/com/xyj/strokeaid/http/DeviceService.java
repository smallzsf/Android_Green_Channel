package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * DeviceService
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/12
 * email ：licy3051@qq.com
 */
public interface DeviceService {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_WRISTBAND_BIND)
    Call<BaseObjectBean> bindWristband(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_WRISTBAND_BIND)
    Call<BaseObjectBean> unbindWristband(@Body RequestBody info);
}

    
    
       
    