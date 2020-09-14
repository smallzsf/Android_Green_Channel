package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.MainBean;
import com.xyj.strokeaid.bean.PatientMedicalRecordBean;
import com.xyj.strokeaid.bean.SendSmsBean;
import com.xyj.strokeaid.bean.TimeNodeBean;
import com.xyj.strokeaid.bean.chestpain.ChestPainTriageInfoBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * PatientService
 * description: 用户操作相关api
 *
 * @author : Licy
 * @date : 2020/9/14
 * email ：licy3051@qq.com
 */
public interface PatientService {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_SAVE)
    Call<BaseResponseBean> saveNewPatient(@Body RequestBody info);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(ApiUrls.NET_URL_COMMON_GET)
    Call<BaseResponseBean<PatientMedicalRecordBean>> getPatientInfo(@Body RequestBody info);

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
}
