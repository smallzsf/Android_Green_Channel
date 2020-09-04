package com.xyj.strokeaid.contract;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.SendSmsBean;

import io.reactivex.rxjava3.core.Observable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface LoginContract {


    interface Model {
        Observable<BaseObjectBean<LoginBean>> login(String username, String password);
        Observable<BaseObjectBean<LoginBean>> phoneLogin(String phone, String code);
        Observable<BaseObjectBean<SendSmsBean>> sendSms(String phone);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(String errMessage);

        void onSuccess(BaseObjectBean<LoginBean> bean, int flag);

        void onSendSms(BaseObjectBean<SendSmsBean> bean);

    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password, int flag);


        /**
         *
         *
         * @param phone
         * @param code
         */
        void phoneLogin(String phone, String code, int flag);

        /**

         * @param phone
         */
        void sendSMS(String phone);
    }
}
