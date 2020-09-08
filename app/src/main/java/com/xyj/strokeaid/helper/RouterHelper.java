package com.xyj.strokeaid.helper;

import android.app.Activity;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.app.IntentKey;

/**
 * RouterHelper
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/5/7
 * email ：licy3051@qq.com
 */
public final class RouterHelper {

    public static void navigation(String navigation) {
        if (TextUtils.isEmpty(navigation)) {
            LogUtils.e("navigation is null!!!");
            return;
        }
        ARouter.getInstance()
                .build(navigation)
                .navigation();
    }

    public static void navigation(String navigation, @NonNull Activity mFrom, int requestCode) {
        if (TextUtils.isEmpty(navigation)) {
            LogUtils.e("navigation is null!!!");
            return;
        }
        ARouter.getInstance()
                .build(navigation)
                .navigation(mFrom, requestCode);
    }

    public static void navWithPatient(String navigation, String patientId) {
        if (TextUtils.isEmpty(navigation) || TextUtils.isEmpty(patientId)) {
            LogUtils.e("navigation or patientId is null!!!");
            return;
        }
        ARouter.getInstance()
                .build(navigation)
                .withString(IntentKey.PATIENT_ID, patientId)
                .navigation();
    }


    public static void navWithRecordId(String navigation, String recordId) {
        if (TextUtils.isEmpty(navigation) || TextUtils.isEmpty(recordId)) {
            LogUtils.e("navigation or recordId is null!!!");
            return;
        }
        ARouter.getInstance()
                .build(navigation)
                .withString(IntentKey.RECORD_ID, recordId)
                .navigation();
    }

}
