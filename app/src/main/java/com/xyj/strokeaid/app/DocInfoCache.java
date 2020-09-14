package com.xyj.strokeaid.app;

import android.text.TextUtils;

import com.tencent.mmkv.MMKV;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.hospital.HospitalStaffBean;
import com.xyj.strokeaid.http.CommonService;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * DocInfoCache
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/14
 * email ：licy3051@qq.com
 */
public class DocInfoCache {

    private static List<HospitalStaffBean.DataBean> mAllDatas;

    public static DocInfoCache getInstance() {
        return DocInfoCache.InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static DocInfoCache INSTANCE = new DocInfoCache();
    }

    private DocInfoCache() {

    }


    /**
     * 获取所有的人员信息
     */
    public void getAllDocAndNurseInfo() {
        RetrofitClient.getInstance()
                .create(CommonService.class)
                .getAllEmergencyCenterPerson(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}"))
                .enqueue(new Callback<HospitalStaffBean>() {
                    @Override
                    public void onResponse(Call<HospitalStaffBean> call, Response<HospitalStaffBean> response) {
                        if (response.body() != null) {
                            List<HospitalStaffBean.DataBean> data = response.body().getData();
                            if (data != null) {
                                mAllDatas = data;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<HospitalStaffBean> call, Throwable t) {

                    }
                });


    }

    public List<HospitalStaffBean.DataBean> getPersionByKey(String key) {
        if (mAllDatas != null) {
            List<HospitalStaffBean.DataBean> selectedData = new ArrayList<>();
            for (HospitalStaffBean.DataBean allData : mAllDatas) {
                if (TextUtils.equals(allData.getTypeKey(), key)) {
                    selectedData.add(allData);
                }
            }
            return selectedData;
        } else {
            getAllDocAndNurseInfo();
            return null;
        }

    }

}
