package com.xyj.strokeaid.activity;




import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.DetailPageAdapter;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.presenter.MainPresenter;

/**
 * MainActivity
 * description: app 主页
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View{



    @Override
    public int getLayoutId() {
        return  R.layout.activity_main;
    }

    @Override
    public void initView() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);

        FragmentManager fm = getSupportFragmentManager();

        //为viewpager设置适配器
        mViewPager.setAdapter(new DetailPageAdapter(MainActivity.this, fm));

        mTabLayout.setupWithViewPager(mViewPager);



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