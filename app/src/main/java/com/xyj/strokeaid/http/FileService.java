package com.xyj.strokeaid.http;

import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * FileService
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/10
 * email ：licy3051@qq.com
 */
public interface FileService {


    /**
     * 文件上传
     */
    @POST(ApiUrls.NET_URL_COMMON_FILE_UPLOAD)
    Call<BaseArrayBean<FileInfoBean>> uplaodFile(@Body RequestBody info);
}

    
    
       
    