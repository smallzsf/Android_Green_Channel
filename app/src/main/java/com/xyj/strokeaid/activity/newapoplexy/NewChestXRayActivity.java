package com.xyj.strokeaid.activity.newapoplexy;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;

/**
  * @Package:        com.xyj.strokeaid.activity.newapoplexy
  * @ClassName:      NewChestXRayActivity
  * @Description:    新建胸透页面
  * @Autho:          王水雷
  * @Time:           2020/8/21
 */
public class NewChestXRayActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View{

    @BindView(R.id.rg_sex)
    RadioGroup radioGroupSex;
    //1男 2女
    String mCurrentSex="1";
    @Override
    public int getLayoutId() {
        return R.layout.activity_new_chest_x_ray;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.rb_sex_normal:
                        mCurrentSex = "1";
                        break;
                    case R.id.rb_sex_male:
                        mCurrentSex = "2";
                        break;
                }
            }
        });
    }

    @Override
    public void showData(BaseObjectBean<NewAppplexyInfoBean> bean) {

    }

    @Override
    public void onLoadSaveSuccess(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String errMessage) {

    }
}