package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.RequestBloodDataBean;
import com.xyj.strokeaid.bean.RequestCTDataBean;
import com.xyj.strokeaid.bean.RequestImageExaminteDataBean;
import com.xyj.strokeaid.bean.SendCTDataBean;
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
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_SEND_CT)
    Call<RequestCTDataBean> sendCT(@Body RequestBody info);

    /**
     * 添加CT 数据
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_CT)
    Call<BaseObjectBean> addCT(@Body RequestBody info);

    /**
     * 获取影像数据
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_IMAGE_EXAMINATE)
    Call<RequestImageExaminteDataBean> getImgeExaminate(@Body RequestBody info);

    /**
     * 上传影像数据
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_IMAGE_EXAMINATE)
    Call<BaseObjectBean> addImgeExaminate(@Body RequestBody info);

    /**
     * 获取血液数据
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_GET_BLOOD_DATA)
    Call<RequestBloodDataBean> getBloodData(@Body RequestBody info);

    /**
     * 上传血液数据
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_ADD_BLOOD_DATA)
    Call<RequestBloodDataBean> addBloodData(@Body RequestBody info);

    /**
     * mRS评分
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_MRS)
    Call<BaseObjectBean> addMrs(@Body RequestBody info);

    /**
     * CGS评分
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_CGS)
    Call<BaseObjectBean> addCgs(@Body RequestBody info);

    /**
     * 洼田吞咽评定
     * */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_SWALLOW)
    Call<BaseObjectBean> addSwallow(@Body RequestBody info);

    /**
     * 病情记录添加
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DISEASE_RECORD_ADD)
    Call<BaseObjectBean> diseaseRecordAdd(@Body RequestBody info);

    /**
     * 病情记录修改
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_UPDATE)
    Call<BaseObjectBean> diseaseRecordUpdate(@Body RequestBody info);


    /**
     * 病情评估根据recordId删除
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_DELETE_BY_RECORDID)
    Call<BaseObjectBean> diseaseRecordDeleteByRecordid(@Body RequestBody info);

    /**
     * 病情评估先删后插
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_EDIT)
    Call<BaseObjectBean> diseaseRecordEdit(@Body RequestBody info);



    /**
     * 病情评估获取
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GET)
    Call<BaseObjectBean> diseaseRecordGet(@Body RequestBody info);


    /**
     *  病情评估根据recordid获取
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_STROKE_DOSEASE_RECORD_GETBYRECORDID)
    Call<BaseObjectBean> diseaseRecordGetByRecordid(@Body RequestBody info);

    /**
     * 新建患者信息
     * @param info
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_NEW_PATIENMEDICAL_RECORD)
    Call<BaseObjectBean> newPatienMedical(@Body RequestBody info);
}
