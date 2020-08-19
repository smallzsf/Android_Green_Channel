package com.xyj.strokeaid.activity.set;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.login.LoginActivity;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.ActivityStackManager;
import com.xyj.strokeaid.view.BaseTitleBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MainActivity
 * description: app 主页
 *
 * @author : Licy
 * @date : 2019/8/19
 * email ：licy3051@qq.com
 */
public class AccountActivity extends BaseActivity {


    @BindView(R.id.title_bar_act_account)
    BaseTitleBar titleBarActAccount;
    @BindView(R.id.tv_name_act_account)
    TextView tvNameActAccount;
    @BindView(R.id.tv_department_act_account)
    TextView tvDepartmentActAccount;
    @BindView(R.id.tv_change_pwd_act_account)
    TextView tvChangePwdActAccount;
    @BindView(R.id.tv_version_act_account)
    TextView tvVersionActAccount;
    @BindView(R.id.tv_exit_act_account)
    TextView tvExitActAccount;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    public void initView() {

        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            if (packageInfo != null) {
                tvVersionActAccount.setText(getString(R.string.current_version, packageInfo.versionName));
            } else {
                tvVersionActAccount.setText(getString(R.string.current_version, "1.0"));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            tvVersionActAccount.setText(getString(R.string.current_version, "1.0"));
        }
    }

    @Override
    public void initListener() {
        titleBarActAccount.setLeftLayoutClickListener(v -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.tv_change_pwd_act_account, R.id.tv_version_act_account, R.id.tv_exit_act_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_change_pwd_act_account:
                // TODO: 2020/8/19 修改密码
                break;
            case R.id.tv_version_act_account:
                // TODO: 2020/8/19 检查更新 
                break;
            case R.id.tv_exit_act_account:
                logout();
                break;
            default:
                break;
        }
    }

    /**
     * 退出登录
     */
    private void logout() {
        // TODO: 2020/8/19 退出登录

        ActivityStackManager.getInstance().finishAllActivities(LoginActivity.class);
        Intent exitIntent = new Intent(mContext, LoginActivity.class);
        startActivity(exitIntent);
    }
}