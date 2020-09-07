package com.xyj.strokeaid.activity.set;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.MmkvKey;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ChangePasswordPostBean;
import com.xyj.strokeaid.helper.Base64Util;
import com.xyj.strokeaid.helper.RsaUitl;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.regex.Pattern;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 重置密码
 *
 * @author licy
 * @date 2020/09/01
 */
public class ChangePasswordActivity extends BaseActivity {

    private static final String regex = "^(?![0-9|#@!~%^&*]+$)(?![a-zA-Z|#@!~%^&*]+$)[0-9A-Za-z#@!~%^&*]{6,20}$";

    @BindView(R.id.title_bar_act_cp)
    BaseTitleBar titleBarActCp;
    @BindView(R.id.et_old_act_cp)
    EditText etOldActCp;
    @BindView(R.id.et_new_act_cp)
    EditText etNewActCp;
    @BindView(R.id.et_new_repeat_act_cp)
    EditText etNewRepeatActCp;
    @BindView(R.id.btn_save_act_cp)
    AppCompatButton btnSaveActCp;

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        titleBarActCp.setLeftLayoutClickListener(v -> finish());

        btnSaveActCp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPwd = etOldActCp.getText().toString().trim();
                String newPwd = etNewActCp.getText().toString().trim();
                String repeatPwd = etNewRepeatActCp.getText().toString().trim();


                String phone = mDefaultMMKV.decodeString(MmkvKey.LOGIN_PHONE);
                if (TextUtils.isEmpty(phone)) {
                    // 帐号密码登陆
                    if (TextUtils.isEmpty(oldPwd)) {
                        showToast("请您填写旧密码");
                        return;
                    }
                }

                if (TextUtils.isEmpty(newPwd)) {
                    showToast("请您填写新密码");
                    return;
                }
                if (TextUtils.isEmpty(repeatPwd)) {
                    showToast("请您填写确认密码");
                    return;
                }
                if (!newPwd.equals(repeatPwd)) {
                    showToast("两次输入的密码不一致，请重新输入~");
                    return;
                }
//                if (!Pattern.matches(regex, newPwd)) {
//                    showToast("密码长度6~20位，必须包含数字、字母、特殊符号中的两种或两种以上");
//                    return;
//                }

                // 修改密码
                changePass(oldPwd, newPwd);
            }
        });
    }


    /**
     * 修改密码
     *
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     */
    private void changePass(String oldPwd, final String newPwd) {
        ChangePasswordPostBean updatePassPostBean = getRequestBean(oldPwd, newPwd);
        if (updatePassPostBean == null) {
            return;
        }
        String request = GsonUtils.getGson().toJson(updatePassPostBean);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .changePasswordnor(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("修改成功");
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }



    private ChangePasswordPostBean getRequestBean(String oldPwd, String newPwd) {

        ChangePasswordPostBean updatePassPostBean = new ChangePasswordPostBean();
        String oldPassword;
        String newPassword;
        try {
            if (TextUtils.isEmpty(oldPwd)) {
                oldPassword = "";
            } else {
                oldPassword = Base64Util.encode(RsaUitl.encryptByPublicKey(oldPwd.getBytes(),
                        Base64Util.decode(RsaUitl.STROKE_PUBLIC_KEY)));
            }
            newPassword = Base64Util.encode(RsaUitl.encryptByPublicKey(newPwd.getBytes(),
                    Base64Util.decode(RsaUitl.STROKE_PUBLIC_KEY)));
        } catch (Exception e) {
            e.printStackTrace();
            showToast("密码输入不正确，请重试~");
            return null;
        }

        updatePassPostBean.setId(getUserId());
        updatePassPostBean.setName(oldPassword);
        updatePassPostBean.setPassword(newPassword);
        return updatePassPostBean;
    }

}
