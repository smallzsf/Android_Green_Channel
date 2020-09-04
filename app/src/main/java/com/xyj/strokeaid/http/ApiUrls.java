package com.xyj.strokeaid.http;

import com.xyj.strokeaid.BuildConfig;

/**
 * ApiUrls
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public class ApiUrls {

    public static final String PRODUCTION_ENVIRONMENT_FOR_API = "https://ykj.yjjk.net.cn/";
    public static final String PRODUCTION_ENVIRONMENT_FOR_FILE = "https://ykj.yjjk.net.cn/";

    public static final String DEVELOP_ENVIRONMENT_FOR_API = "https://ykj.yjjk366.com/";
    public static final String DEVELOP_ENVIRONMENT_FOR_FILE = "https://ykj.yjjk366.com/";

    /**
     * PRODUCTION_ENVIRONMENT_FILE_SERVER
     */
    public static final String FILE_URL = BuildConfig.DEBUG ? DEVELOP_ENVIRONMENT_FOR_FILE : PRODUCTION_ENVIRONMENT_FOR_FILE;
    /**
     * PRODUCTION_ENVIRONMENT
     */
    public static final String BASE_URL = BuildConfig.DEBUG ? DEVELOP_ENVIRONMENT_FOR_API : PRODUCTION_ENVIRONMENT_FOR_API;

    /**
     * 登陆
     */
    public static final String NET_URL_LOGIN = "yjjk-gateway/yjjk-pt-api/v1/user/mobileLogin";
    /**
     * 请求验证码
     */
    public static final String NET_URL_SEND_SMS_FOR_LOGIN = "yjjk-gateway/yjjk-pt-api/v1/common/sms/authcode/send";
    /**
     * 使用手机号密码登录
     */
    public static final String NET_URL_LOGIN_BY_PHONE = "yjjk-gateway/yjjk-pt-api/v1/user/loginByAuthcode";

    /**
     * 文件上传
     */
    public static final String NET_URL_COMMON_FILE_UPLOAD = "yjjk-gateway/yjjk-pt-api/v1/common/upload";


    /**
     * 修改用户密码
     */
    public static final String NET_URL_USER_UPDATE_PASSWORD = "yjjk-gateway/yjjk-pt-api/v1/user/updatePassword";

    /**
     * 新建患者信息
     */
    public static final String NET_URL_NEW_PATIENMEDICAL_RECORD= "yjjk-gateway/yjjk-cdm-api/v1/emergencyCenter/record/addForApp";





}

    
    
       
    