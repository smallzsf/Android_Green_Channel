package com.xyj.strokeaid.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * CallUtils
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/13
 * email ：licy3051@qq.com
 */
public final class CallUtils {

    /**
     * 拨打电话
     *
     * @param phoneNumber 电话号码
     * @param from 上下文
     */
    public static void callPhone(String phoneNumber, Activity from) {

        try {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            from.startActivity(call);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(from, "未检测到电话应用，请安装电话应用后后重试", Toast.LENGTH_LONG).show();
        }
    }

}
