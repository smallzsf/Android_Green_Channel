package com.xyj.strokeaid.contract;

import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;

import io.reactivex.rxjava3.core.Observable;

/**
 * @Package: com.xyj.strokeaid.contract
 * @ClassName: NewApoplexyInfoContract
 * @Description: 新建卒中信息Contract
 * @Autho: 王水雷
 * @Time: 2020/8/19
 */
public interface NewApoplexyInfoContract {


    interface Model {
        /**
         * 获取列表数据
         *
         * @param diseaseType 疾病类型
         * @param patientType 患者类型
         * @param name        患者姓名（为空则搜索全部）
         * @return
         */
        Observable<BaseObjectBean<NewAppplexyInfoBean>> getPatientData(int diseaseType, int patientType, String name);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();


        @Override
        void onError(String errMessage);

        /**
         * @param bean
         */
        void showData(BaseObjectBean<NewAppplexyInfoBean> bean);

    }

    interface Presenter {

        /**
         * 获取卒中列表数据
         */
        void getApoplexyInfoList();
    }
}
