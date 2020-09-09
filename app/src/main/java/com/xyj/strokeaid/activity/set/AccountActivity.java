package com.xyj.strokeaid.activity.set;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.bugly.beta.Beta;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.login.LoginActivity;
import com.xyj.strokeaid.app.MmkvKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.app.UserInfoCache;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.ActivityStackManager;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.SettingBar;

import butterknife.BindView;

/**
 * MainActivity
 * description: app 主页
 *
 * @author : Licy
 * @date : 2019/8/19
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.PERSONAL_INFO)
public class AccountActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_account)
    BaseTitleBar titleBarActAccount;
    @BindView(R.id.tv_name_act_account)
    TextView tvNameActAccount;
    @BindView(R.id.tv_department_act_account)
    TextView tvDepartmentActAccount;
    @BindView(R.id.sb_change_pwd_act_account)
    SettingBar sbChangePwdActAccount;
    @BindView(R.id.sb_version_pwd_act_account)
    SettingBar sbVersionPwdActAccount;
    @BindView(R.id.sb_exit_pwd_act_account)
    SettingBar sbExitPwdActAccount;
    private String name;
    private String orgName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {

        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            if (packageInfo != null) {
                sbVersionPwdActAccount.setLeftText(getString(R.string.current_version, packageInfo.versionName));
            } else {
                sbVersionPwdActAccount.setLeftText(getString(R.string.current_version, "1.0"));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            sbVersionPwdActAccount.setLeftText(getString(R.string.current_version, "1.0"));
        }

        // 初始化用户信息
        if (UserInfoCache.getInstance().getUserInfo() != null) {
            name = UserInfoCache.getInstance().getUserInfo().getName();
            orgName = UserInfoCache.getInstance().getUserInfo().getOrgName();
        }

        if (TextUtils.isEmpty(name)) {
            tvNameActAccount.setText("--");
        } else {
            tvNameActAccount.setText(name);
        }
        if (TextUtils.isEmpty(orgName)) {
            tvDepartmentActAccount.setText("--");
        } else {
            tvDepartmentActAccount.setText(orgName);
        }
    }

    @Override
    public void initListener() {
        titleBarActAccount.setLeftLayoutClickListener(v -> finish());
        sbExitPwdActAccount.setOnClickListener(v -> logout());
        sbChangePwdActAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ChangePasswordActivity.class));
            }
        });
        sbVersionPwdActAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Beta.checkUpgrade();
            }
        });
    }

    /**
     * 退出登录
     */
    private void logout() {
        // 清除token
        mDefaultMMKV.remove(MmkvKey.TOKEN);
        UserInfoCache.clearUserInfoCache();
        // 退出所有Activity，启动login页面
        ActivityStackManager.getInstance().finishAllActivities(LoginActivity.class);
        Intent exitIntent = new Intent(mContext, LoginActivity.class);
        startActivity(exitIntent);
    }
}