package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    /**
     * 登陆
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseObjectBean<LoginBean>> login(@Field("username") String username,
                                                @Field("password") String password);
}
