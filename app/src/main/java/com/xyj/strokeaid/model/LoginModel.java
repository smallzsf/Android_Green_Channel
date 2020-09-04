package com.xyj.strokeaid.model;


import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.RequestSmsBean;
import com.xyj.strokeaid.bean.SendSmsBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;


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
        RequestLoginBean requestLoginBean = new RequestLoginBean(username, password, "1");
        String request = GsonUtils.getGson().toJson(requestLoginBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        return RetrofitClient.getInstance().getApi().login(requestBody);
    }

    @Override
    public Observable<BaseObjectBean<LoginBean>> phoneLogin(String phone, String code) {
        RequestLoginBean requestLoginBean = new RequestLoginBean(phone, code, "");
        String request = GsonUtils.getGson().toJson(requestLoginBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        return RetrofitClient.getInstance().getApi().phoneLoign(requestBody);
    }



    @Override
    public Observable<BaseObjectBean<SendSmsBean>> sendSms(String phone) {
        RequestSmsBean requestSmsBean = new RequestSmsBean(phone);
        String request = GsonUtils.getGson().toJson(requestSmsBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        return RetrofitClient.getInstance().getApi().sendSms(requestBody);
    }

    private static class RequestLoginBean {
        private String account;
        private String password;
        private String encryption;

        public RequestLoginBean(String account, String password, String encryption) {
            this.account = account;
            this.password = password;
            this.encryption = encryption;
        }

        @Override
        public String toString() {
            return "LoginRequestBean{" +
                    "account='" + account + '\'' +
                    ", password='" + password + '\'' +
                    ", encryption='" + encryption + '\'' +
                    '}';
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEncryption() {
            return encryption;
        }

        public void setEncryption(String encryption) {
            this.encryption = encryption;
        }
    }
}
