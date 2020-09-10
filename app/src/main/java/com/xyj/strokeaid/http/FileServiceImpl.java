package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * FileServiceImpl
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/10
 * email ：licy3051@qq.com
 */
public class FileServiceImpl {

    public static void uploadImage(String tableName,  String filePath, Callback<BaseArrayBean<FileInfoBean>> callback) {

        File file = new File(filePath);
        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);

        // MultipartBody.Part  和后端约定好Key，这里的partName是用file
        MultipartBody.Part body = MultipartBody.Part.createFormData("upload", file.getName(), requestFile);

        // 添加描述
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), tableName);
        RetrofitClient
                .getInstance()
                .create(FileService.class)
                .uplaodFile(description,body )
                .enqueue(callback);
    }
}

    
    
       
    