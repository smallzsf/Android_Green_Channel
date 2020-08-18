package com.xyj.strokeaid.contract;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;

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
        /**
         * 获取患者信息
         *
         * @param diseaseType 疾病类型
         * @param patientType 患者类型
         * @param name        患者姓名（为空则搜索全部）
         */
        Observable<BaseObjectBean<HomePatientBean>> getPatientData(int diseaseType, int patientType, String name);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(String errMessage);

        void showData(BaseObjectBean<HomePatientBean> bean);

    }

    interface Presenter {

        /**
         * 获取患者信息
         *
         * @param diseaseType 疾病类型
         * @param patientType 患者类型
         * @param name        患者姓名（为空则搜索全部）
         */
        void getPatientData(int diseaseType, int patientType, String name);
    }
}
