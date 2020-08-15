package com.xyj.strokeaid.model;


import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.http.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }
}
