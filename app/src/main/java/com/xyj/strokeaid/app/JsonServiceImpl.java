package com.xyj.strokeaid.app;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * JsonServiceImpl
 * description: Arouter  json解析工具
 *
 * @author : Licy
 * @date : 2020/4/18
 * email ：licy3051@qq.com
 */
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {

    Gson mGson;

    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return mGson.fromJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return mGson.fromJson(input, clazz);
    }

    @Override
    public void init(Context context) {
        mGson = new Gson();
    }
}
