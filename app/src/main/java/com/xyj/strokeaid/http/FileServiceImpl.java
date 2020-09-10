package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;

import java.io.File;

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

    public static void uploadFile(String tableName,  String filePath, Callback<BaseArrayBean<FileInfoBean>> callback) {

        File file = new File(filePath);
        RequestBody fileRb = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part part = MultipartBody.Part.createFormData("picture", file.getName(), fileRQ);
        RequestBody body = new MultipartBody.Builder()
                .addFormDataPart("tableName", tableName)
                .addFormDataPart("upload", file.getName(), fileRb)
                .build();
        RetrofitClient
                .getInstance()
                .create(FileService.class)
                .uplaodFile(body)
                .enqueue(callback);
    }
}

    
    
       
    