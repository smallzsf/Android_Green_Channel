package com.xyj.strokeaid.presenter;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.http.RxScheduler;
import com.xyj.strokeaid.model.MainModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }


}

