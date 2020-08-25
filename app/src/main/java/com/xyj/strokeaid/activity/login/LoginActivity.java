package com.xyj.strokeaid.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.MainActivity;
import com.xyj.strokeaid.activity.set.SetActivity;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.LoginBean;
import com.xyj.strokeaid.contract.LoginContract;
import com.xyj.strokeaid.fragment.stroke.StrokeBiologyTagFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodBiochemistryFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodExaminationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeBloodRoutineExaminationFragment;
import com.xyj.strokeaid.fragment.stroke.StrokeCruoragFunctionFragment;
import com.xyj.strokeaid.presenter.LoginPresenter;

import butterknife.BindView;

/**
 * LoginActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    EditText etUsernameLogin;
    EditText etPasswordLogin;
    Button btnSigninLogin;
    SharedPreferences sp = null;
    CheckBox cbRememberPassword;
    private ImageView ivSetting;


    @BindView(R.id.tl_title_act_stroke_main)
    TabLayout tlTitleActStrokeMain;
    @BindView(R.id.vp_content_act_stroke_main)
    ViewPager2 vpContentActStrokeMain;
    public static final String[] STROKE_TAB_TITLES = new String[]{"密码登录", "验证码登录"};


    @Override
    public int getLayoutId() {
        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return R.layout.activity_login_new;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

        for (String strokeTabTitle :STROKE_TAB_TITLES) {
            tlTitleActStrokeMain.addTab(tlTitleActStrokeMain.newTab().setText(strokeTabTitle));
        }

        // 禁止滑动
        vpContentActStrokeMain.setUserInputEnabled(false);
        vpContentActStrokeMain.setOffscreenPageLimit(STROKE_TAB_TITLES.length);
        vpContentActStrokeMain.setAdapter(new StrokeViewPageAdapter(this));

  /*      etUsernameLogin = findViewById(R.id.et_name);
        etPasswordLogin = findViewById(R.id.et_password);
        btnSigninLogin = findViewById(R.id.btn_login);
        ivSetting = findViewById(R.id.iv_setting);
        cbRememberPassword = findViewById(R.id.cb_remember_password);
        sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        //对uname 和 upswd 的操作
        if (sp.getBoolean("checkboxBoolean", false)) {
            etUsernameLogin.setText(sp.getString("uname", null));
            etPasswordLogin.setText(sp.getString("upswd", null));
            cbRememberPassword.setChecked(true);

        }


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
        });*/

   /*     ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SetActivity.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void initListener() {
        tlTitleActStrokeMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpContentActStrokeMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    private static class StrokeViewPageAdapter extends FragmentStateAdapter {

        String patientId;
        String docId;

        public StrokeViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeViewPageAdapter(@NonNull Fragment fragment, String patientId, String docId) {
            super(fragment);
            this.patientId = patientId;
            this.docId = docId;
        }

        public StrokeViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, String patientId, String docId) {
            super(fragmentManager, lifecycle);
            this.patientId = patientId;
            this.docId = docId;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new LoginFragment();
                case 1:
                    return  new LoginFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return STROKE_TAB_TITLES.length;
        }

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
//        Toast.makeText(this, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();

     /*   if (bean.getResult() == null && bean.getErrorCode() == 0) {

            //通过
            boolean CheckBoxLogin = cbRememberPassword.isChecked();
            //按钮被选中，下次进入时会显示账号和密码
            if (CheckBoxLogin) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("uname", getUsername());
                editor.putString("upswd", getPassword());
                editor.putBoolean("checkboxBoolean", true);
                editor.commit();
            } else {    //按钮被选中，清空账号和密码，下次进入时会显示账号和密码
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("uname", null);
                editor.putString("upswd", null);
                editor.putBoolean("checkboxBoolean", false);
                editor.commit();
            }


            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }*/
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

    
    
       
    