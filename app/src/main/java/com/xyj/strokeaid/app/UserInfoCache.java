package com.xyj.strokeaid.app;

import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.http.gson.GsonUtils;

/**
 * UserInfoCache
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/30
 * email ：licy3051@qq.com
 */
public class UserInfoCache {


    private static final String TAG = "UserInfoCache";
    private LoginBean mUserInfo;

    public static UserInfoCache getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static UserInfoCache INSTANCE = new UserInfoCache();
    }

    private UserInfoCache() {
        mUserInfo = GsonUtils.getGson().fromJson(MMKV.defaultMMKV().decodeString(MmkvKey.LOGIN_USER_INFO), LoginBean.class);
    }

    public LoginBean getUserInfo() {
        return mUserInfo;
    }
}

    
    
       
    