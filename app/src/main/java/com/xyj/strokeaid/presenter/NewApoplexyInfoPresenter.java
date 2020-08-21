package com.xyj.strokeaid.presenter;


import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.HomePatientBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.http.RxScheduler;
import com.xyj.strokeaid.model.MainModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class NewApoplexyInfoPresenter extends BasePresenter<NewApoplexyInfoContract.View> implements NewApoplexyInfoContract.Presenter {

    private MainContract.Model model;
    public NewApoplexyInfoPresenter(){
        model = new MainModel();
    }
    /**
     * @param patient_no
     * @param name
     * @param age
     * @param sex
     * @param height
     * @param weight
     * @param nation
     * @param identity
     * @param medicalCardNum
     * @param id
     * @param contract
     * @param contractPhone
     */
    @Override
    public void saveAndJoinData(String patient_no, String name, String age, String sex, String height,
                                String weight, String nation, String identity, String medicalCardNum,
                                String id,   String contract, String contractPhone) {
        mView.onLoadSaveSuccess("保存并加入成功");

    }
}

