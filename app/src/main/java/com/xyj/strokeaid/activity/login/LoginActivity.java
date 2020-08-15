package com.xyj.strokeaid.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.MainActivity;
import com.xyj.strokeaid.activity.SplashActivity;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.contract.MainContract;
import com.xyj.strokeaid.presenter.LoginPresenter;
import com.xyj.strokeaid.presenter.MainPresenter;

/**
 * LoginActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View{

    TextInputEditText etUsernameLogin;
    TextInputEditText etPasswordLogin;
    Button btnSigninLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etUsernameLogin = findViewById(R.id.et_username_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        btnSigninLogin = findViewById(R.id.btn_signin_login);

        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
        btnSigninLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getUsername().isEmpty() || getPassword().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(getUsername(), getPassword());
            }
        });
    }


    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        Toast.makeText(this, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();

        if (bean.getResult()==null&&bean.getErrorCode()==0){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
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

    
    
       
    