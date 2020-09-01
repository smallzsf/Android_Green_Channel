package com.xyj.strokeaid.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.eid.reader.EIDReader;
import com.eid.reader.IIDDataCallback;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;

/**
 * NewPatientMedicalRecordActivity
 * description: 新建患者病历  （卒中 、 胸痛 、 创伤）
 *
 * @author : Licy
 * @date : 2019/8/12
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.NEW_PATIENT)
public class NewPatientMedicalRecordActivity extends BaseActivity implements IIDDataCallback {

    private EIDReader idReader;

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_patient_medical_record;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        requestPermission();
        if (idReader == null) {
            idReader = new EIDReader(this);
        }
        idReader.setIidDataCallback(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (idReader != null) {
            // 将NFC设置为读卡器模式
            idReader.enableReaderMode(this);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (idReader != null) {
            idReader.nfcReadCard(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (idReader != null) {
            idReader.disableReaderMode(); // 恢复NFC适配到正常模式
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (idReader != null) {
            idReader.release();
        }
    }


    @Override
    public void onIDCardState(int i, String s) {
        showToast("errCode  is " + i + "message  is " + s);
        LogUtils.d("errCode  is " + i);
        LogUtils.d("message  is " + s);
    }

    @Override
    public void onGetIDData(String result, String resultDetail, String idData, Bitmap pic) {
        LogUtils.d("result  is " + result);
        LogUtils.d("resultDetail  is " + resultDetail);
        LogUtils.d("idData  is " + idData);
    }

    private void requestPermission() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},
                        81);
            } else {
            }
        } else {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 81) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {// Permission Granted
//                finish();
                Toast.makeText(this, "无所需权限,请在设置中添加权限", Toast.LENGTH_LONG).show();
            } else {
            }
        } else {

        }
    }
}