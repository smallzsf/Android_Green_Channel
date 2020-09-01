package com.xyj.strokeaid.activity.login;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.MainActivity;
import com.xyj.strokeaid.activity.set.SetActivity;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.MmkvKey;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.helper.CodeTimer;
import com.xyj.strokeaid.http.TokenConfig;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.presenter.LoginPresenter;
import com.xyj.strokeaid.view.BaseTitleBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * LoginActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.iv_launch)
    ImageView ivLaunch;
    @BindView(R.id.title_bar_act_login)
    BaseTitleBar titleBarActLogin;
    @BindView(R.id.tl_title_act_login)
    TabLayout tlTitleActLogin;
    @BindView(R.id.et_name_act_login)
    EditText etNameActLogin;
    @BindView(R.id.et_pwd_act_login)
    EditText etPwdActLogin;
    @BindView(R.id.cb_remembre_act_login)
    CheckBox cbRemembreActLogin;
    @BindView(R.id.ll_pwd_act_login)
    LinearLayout llPwdActLogin;
    @BindView(R.id.et_phone_act_login)
    EditText etPhoneActLogin;
    @BindView(R.id.et_code_act_login)
    EditText etCodeActLogin;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.ll_phone_act_login)
    LinearLayout llPhoneActLogin;
    @BindView(R.id.btn_login_act_login)
    AppCompatButton btnLoginActLogin;
    @BindView(R.id.tb_ensure_pwd_act_login)
    ToggleButton tbEnsurePwdActLogin;

    CodeTimer codeTimer;
    @BindView(R.id.ll_content_act_login)
    LinearLayout llContentActLogin;
    @BindView(R.id.cl_root_act_login)
    ConstraintLayout clRootActLogin;
    @BindView(R.id.sl_content_act_login)
    ScrollView slContentActLogin;

    /**
     * 0  帐号密码登录
     * 1  手机号验证码登录
     */
    private int mLoginType = 0;
    private boolean isSoftKeyBoradShow = false;
    private int mMaxSrollHeight = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void initImmersionBar() {
        // 初始化沉浸式状态栏
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .fitsSystemWindows(true)
                .keyboardEnable(false)
                .init();
    }

    @Override
    public void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);

        for (String tabTitle : Constants.LOGIN_TAB_TITLE) {
            tlTitleActLogin.addTab(tlTitleActLogin.newTab().setText(tabTitle));
        }

        codeTimer = new CodeTimer(tvCode, 60 * 1000, 1000);

        tvCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        etNameActLogin.setText(mDefaultMMKV.decodeString(MmkvKey.LOGIN_NAME));
        etPwdActLogin.setText(mDefaultMMKV.decodeString(MmkvKey.LOGIN_PWD));
        cbRemembreActLogin.setChecked(mDefaultMMKV.decodeBool(MmkvKey.LOGIN_REMEMBRE));

        etPhoneActLogin.setText(mDefaultMMKV.decodeString(MmkvKey.LOGIN_PHONE));


    }

    @Override
    protected void onResume() {
        super.onResume();
        clRootActLogin.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                //1、获取main在窗体的可视区域
                clRootActLogin.getWindowVisibleDisplayFrame(rect);
                //2、获取main在窗体的不可视区域高度，在键盘没有弹起时，main.getRootView().getHeight()调节度应该和rect.bottom高度一样
                int mainInvisibleHeight = clRootActLogin.getRootView().getHeight() - rect.bottom;
                int screenHeight = clRootActLogin.getRootView().getHeight();//屏幕高度
                //3、不可见区域大于屏幕本身高度的1/4：说明键盘弹起了
                int[] location = new int[2];
                llContentActLogin.getLocationInWindow(location);
                if (mainInvisibleHeight > screenHeight / 4) {
                    // 4､获取Scroll的窗体坐标，算出main需要滚动的高度
                    int srollHeight = (location[1] + llContentActLogin.getHeight()) - rect.bottom;
                    mMaxSrollHeight = Math.max(mMaxSrollHeight, screenHeight);
                    //5､让界面整体上移键盘的高度
                    slContentActLogin.scrollTo(0, mMaxSrollHeight);
                    slContentActLogin.setOnTouchListener((v, event) -> true);
                } else {
                    isSoftKeyBoradShow = false;
                    //3、不可见区域小于屏幕高度1/4时,说明键盘隐藏了，把界面下移，移回到原有高度
                    slContentActLogin.scrollTo(0, 0);
                    slContentActLogin.setOnTouchListener((v, event) -> false);
                }
            }
        });
    }

    @Override
    public void initListener() {
        cbRemembreActLogin.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                buttonView.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                buttonView.setTextColor(getResources().getColor(R.color.color_999999));
            }
        });

        tbEnsurePwdActLogin.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // 密码可见
                etPwdActLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                // 密码不可见
                etPwdActLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        titleBarActLogin.setRightLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SetActivity.class);
                startActivity(intent);
            }
        });

        tlTitleActLogin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mLoginType = tab.getPosition();
                if (tab.getPosition() == 0) {
                    llPwdActLogin.setVisibility(View.VISIBLE);
                    llPhoneActLogin.setVisibility(View.GONE);
                } else {
                    llPwdActLogin.setVisibility(View.GONE);
                    llPhoneActLogin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (codeTimer != null) {
            codeTimer.cancel();
        }
    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etNameActLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPwdActLogin.getText().toString().trim();
    }


    /**
     * @return 手机号
     */
    private String getPhone() {
        return etPhoneActLogin.getText().toString().trim();
    }

    /**
     * @return 验证码
     */
    private String getVerifyCode() {
        return etCodeActLogin.getText().toString().trim();
    }


    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean, int flag) {

        if (bean.getResult() == 1) {
            if (flag == 0) {
                // 帐号密码登录 登录成功
                // 保存登录信息
                mDefaultMMKV.encode(MmkvKey.LOGIN_USER_INFO, GsonUtils.getGson().toJson(bean.getData()));
                mDefaultMMKV.encode(MmkvKey.TOKEN, bean.getData().getPassword());
                mDefaultMMKV.encode(MmkvKey.LOGIN_NAME, etNameActLogin.getText().toString().trim());
                boolean isRememberPwd = cbRemembreActLogin.isChecked();
                mDefaultMMKV.encode(MmkvKey.LOGIN_REMEMBRE, isRememberPwd);
                TokenConfig.saveToken(bean.getData().getPassword());
                if (isRememberPwd) {
                    // 按钮被选中，退出再登录时会自动填充帐号密码
                    mDefaultMMKV.encode(MmkvKey.LOGIN_PWD, etPwdActLogin.getText().toString().trim());
                } else {
                    // 按钮未被选中，清空账号和密码，下次进入时会显示账号和密码
                    mDefaultMMKV.encode(MmkvKey.LOGIN_PWD, "");
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                // 手机号验证码登陆  登录成功
                mDefaultMMKV.encode(MmkvKey.LOGIN_PHONE, etPhoneActLogin.getText().toString().trim());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            finish();
        } else {
            showToast(TextUtils.isEmpty(bean.getMessage()) ? "登录失败~" : bean.getMessage());
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.tv_code, R.id.btn_login_act_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                tvCode.setClickable(false);
                codeTimer.start();
                break;
            case R.id.btn_login_act_login:
                if (mLoginType == 0) {
                    mPresenter.login(getUsername(), getPassword(), mLoginType);
                } else {
                    // TODO: 2020/8/29 验证码登录
                }
                break;
            default:
                break;
        }
    }
}

    
    
       
    