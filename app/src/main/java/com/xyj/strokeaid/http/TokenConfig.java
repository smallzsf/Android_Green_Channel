package com.xyj.strokeaid.http;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.app.MmkvKey;


/**
 * TokenConfig
 * description: token 相关操作 增删改查
 *
 * @author : Licy
 * @date : 2019/7/10
 * email ：licy3051@qq.com
 */
public class TokenConfig {

    public static String sToken;

    /**
     * 存储 token
     *
     * @param token 登录验证
     */
    public static void saveToken(String token) {

        if (TextUtils.isEmpty(token)){
            return;
        }
        LogUtils.d("TokenConfig", token);
        sToken = token;
        MMKV.defaultMMKV().encode(MmkvKey.TOKEN, token);
    }

    /**
     * 清除 token
     */
    public static void clearToken() {
        MMKV.defaultMMKV().remove(MmkvKey.TOKEN);
        sToken = null;
    }

    /**
     * 是否持有token
     *
     * @return true 持有
     *         false 未持有
     */
    public static boolean isHaveToken() {
        return !TextUtils.isEmpty(MMKV.defaultMMKV().decodeString(MmkvKey.TOKEN));
    }

    public static String getToken() {
        if (TextUtils.isEmpty(sToken)) {
            sToken = MMKV.defaultMMKV().decodeString(MmkvKey.TOKEN);
        }
        if (TextUtils.isEmpty(sToken)) {
            return "";
        } else {
            return sToken;
        }
    }
}
