package com.xyj.strokeaid.base;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.JsonSyntaxException;
import com.xyj.strokeaid.http.gson.GsonUtils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * BaseBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public abstract class BaseBean<T> {

    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            T t = GsonUtils.getGson().fromJson(json, clazz);
            return t;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getJson(T t) {
        if (t == null) {
            return "";
        }
        return GsonUtils.getGson().toJson(t);
    }

    public RequestBody getResuestBody(@NonNull T t) {
        String request = GsonUtils.getGson().toJson(t);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
    }

    /**
     * 判断值
     *
     * @param value 输入为 “-1”  或者  “1”
     * @return -1 为false
     * 1  为true
     */
    public static boolean judgeValue(String value) {
        return TextUtils.equals(value, "1");
    }

}

    
    
       
    