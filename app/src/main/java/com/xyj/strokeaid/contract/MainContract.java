package com.xyj.strokeaid.contract;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface MainContract {


    interface Model {

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(String errMessage);

    }

    interface Presenter {

    }
}
