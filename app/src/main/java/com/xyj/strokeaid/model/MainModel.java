package com.xyj.strokeaid.model;


import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.http.ApiService;
import com.xyj.strokeaid.http.ApiUrls;
import com.xyj.strokeaid.http.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<BaseObjectBean<HomePatientBean>> getPatientData(int diseaseType, int patientType, String name) {
        return null;
    }
}
