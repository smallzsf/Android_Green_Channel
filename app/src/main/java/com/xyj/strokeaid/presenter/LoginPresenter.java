package com.xyj.strokeaid.presenter;


import androidx.annotation.NonNull;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.bean.SendSmsBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.helper.Base64Util;
import com.xyj.strokeaid.helper.RsaUitl;
import com.xyj.strokeaid.http.RxScheduler;
import com.xyj.strokeaid.model.LoginModel;

import java.nio.charset.StandardCharsets;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.Model model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    @Override
    public void login(String username, String password, int flag) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }

        String pwd = null;
        String user = null;
        try {
            pwd = Base64Util.encode(RsaUitl.encryptByPublicKey(password.getBytes(StandardCharsets.UTF_8), Base64Util.decode(RsaUitl.STROKE_PUBLIC_KEY)));
            user = Base64Util.encode(RsaUitl.encryptByPublicKey(username.getBytes(StandardCharsets.UTF_8), Base64Util.decode(RsaUitl.STROKE_PUBLIC_KEY)));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        model.login(user, pwd)
                .compose(RxScheduler.Obs_io_main())
                //解决内存泄漏
                .to(mView.bindAutoDispose())
                .subscribe(new Observer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull BaseObjectBean<LoginBean> loginBeanBaseObjectBean) {
                        mView.onSuccess(loginBeanBaseObjectBean, flag);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onError(e.getMessage());
                        mView.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });

    }


    @Override
    public void phoneLogin(String phone, String code, int flag) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)) {
            ToastUtils.showShort("不能为空");
        } else {
            if (RegexUtils.isMobileExact(phone)) {
                model.phoneLogin(phone, code)
                        .compose(RxScheduler.Obs_io_main())
                        .to(mView.bindAutoDispose())
                        .subscribe(new Observer<BaseObjectBean<LoginBean>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                mView.showLoading();
                            }

                            @Override
                            public void onNext(@NonNull BaseObjectBean<LoginBean> loginBeanBaseObjectBean) {
                                mView.onSuccess(loginBeanBaseObjectBean, flag);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                mView.onError(e.getMessage());
                                mView.hideLoading();
                            }

                            @Override
                            public void onComplete() {
                                mView.hideLoading();
                            }
                        });

            } else {
                ToastUtils.showShort("请输入正确手机号");
            }
        }

    }


    @Override
    public void sendSMS(String phone) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }

        model.sendSms(phone)
                .compose(RxScheduler.Obs_io_main())
                .to(mView.bindAutoDispose())
                .subscribe(new Observer<BaseObjectBean<SendSmsBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull BaseObjectBean<SendSmsBean> sendSmsBean) {
                        mView.onSendSms(sendSmsBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onError(e.getMessage());
                        mView.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });
    }


}

