package com.xyj.strokeaid.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blankj.utilcode.util.LogUtils;
import com.eid.reader.EIDReader;
import com.eid.reader.IIDDataCallback;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;
import butterknife.OnClick;

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

    @Autowired(name = IntentKey.VIEW_TYPE)
    int mViewType;
    @Autowired(name = IntentKey.PATIENT_ID)
    String mPatientId;
    @Autowired(name = IntentKey.DOC_ID)
    String mDocId;

    @BindView(R.id.title_bar_act_npmr)
    BaseTitleBar titleBarActNpmr;
    @BindView(R.id.ieb_outpatient_id_act_npmr)
    ItemEditBar iebOutpatientIdActNpmr;
    @BindView(R.id.ieb_wristband_act_npmr)
    ItemEditBar iebWristbandActNpmr;
    @BindView(R.id.ieb_dis_addr_act_npmr)
    ItemEditBar iebDisAddrActNpmr;
    @BindView(R.id.ttb_dis_start_act_npmr)
    TextTimeBar ttbDisStartActNpmr;
    @BindView(R.id.ieb_name_act_npmr)
    ItemEditBar iebNameActNpmr;
    @BindView(R.id.ieb_idcard_act_npmr)
    ItemEditBar iebIdcardActNpmr;
    @BindView(R.id.sb_sex_act_npmr)
    SettingBar sbSexActNpmr;
    @BindView(R.id.ieb_weight_act_npmr)
    ItemEditBar iebWeightActNpmr;
    @BindView(R.id.ieb_height_act_npmr)
    ItemEditBar iebHeightActNpmr;
    @BindView(R.id.ieb_bmi_act_npmr)
    ItemEditBar iebBmiActNpmr;
    @BindView(R.id.sb_birth_act_npmr)
    SettingBar sbBirthActNpmr;
    @BindView(R.id.ieb_come_type_act_npmr)
    SettingBar iebComeTypeActNpmr;
    @BindView(R.id.ll_come_hos_act_npmr)
    LinearLayout llComeHosActNpmr;
    @BindView(R.id.sb_in_hos_type_act_npmr)
    SettingBar sbInHosTypeActNpmr;
    @BindView(R.id.sb_nation_act_npmr)
    SettingBar sbNationActNpmr;
    @BindView(R.id.ieb_medicare_act_npmr)
    ItemEditBar iebMedicareActNpmr;
    @BindView(R.id.ieb_domicile_addr_act_npmr)
    ItemEditBar iebDomicileAddrActNpmr;
    @BindView(R.id.ieb_contact_name_act_npmr)
    ItemEditBar iebContactNameActNpmr;
    @BindView(R.id.ieb_contact_phone_act_npmr)
    ItemEditBar iebContactPhoneActNpmr;
    @BindView(R.id.btn_save_act_npmr)
    Button btnSaveActNpmr;


    private EIDReader idReader;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private AMapLocationListener locationListener = null;

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
        initLocation();
    }

    @Override
    public void initListener() {
        titleBarActNpmr
                .setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    // TODO: 2020/9/2 快速建档
                });


    }

    private void initLocation() {
        //初始化client
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = getDefaultOption();
        // 定位监听
        locationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation location) {
                if (null != location) {
                    // errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                    if (location.getErrorCode() == 0) {
                        iebDisAddrActNpmr.setEditContent(location.getAddress());
                    } else {
                        //定位失败
                        showToast("定位失败~");
                    }
                } else {
                    showToast("定位失败~");
                }
                stopLocation();
            }
        };
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
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
            // 恢复NFC适配到正常模式
            idReader.disableReaderMode();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (idReader != null) {
            idReader.release();
        }
        destroyLocation();
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
        if (TextUtils.equals("00", result)) {
            // 读取成功
            IdCardBean idCardBean = GsonUtils.getGson().fromJson(idData, IdCardBean.class);
            if (idCardBean != null) {
                // 姓名
                iebNameActNpmr.setEditContent(idCardBean.getName());
                // 身份证
                iebIdcardActNpmr.setEditContent(idCardBean.getIdnum());
                // 性别
                sbSexActNpmr.setRightText(idCardBean.getSex());
                // 出生日期
                sbBirthActNpmr.setRightText(idCardBean.getBirthDate());
                // 民族
                sbNationActNpmr.setRightText(idCardBean.getNation());
                // 户籍地址
                iebDomicileAddrActNpmr.setEditContent(idCardBean.getAddress());
            }


        }
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {

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

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        //可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setGpsFirst(false);
        //可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setHttpTimeOut(30000);
        //可选，设置定位间隔。默认为2秒
        mOption.setInterval(2000);
        //可选，设置是否返回逆地理地址信息。默认是true
        mOption.setNeedAddress(true);
        //可选，设置是否单次定位。默认是false
        mOption.setOnceLocation(false);
        //可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        mOption.setOnceLocationLatest(false);
        //可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
        //可选，设置是否使用传感器。默认是false
        mOption.setSensorEnable(true);
        //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setWifiScan(true);
        //可选，设置是否使用缓存定位，默认为true
        mOption.setLocationCacheEnable(true);
        //可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
        mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);
        return mOption;
    }

    /**
     * 开始定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void startLocation() {
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    /**
     * 停止定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void stopLocation() {
        // 停止定位
        locationClient.stopLocation();
    }

    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.ieb_idcard_act_npmr, R.id.sb_sex_act_npmr, R.id.sb_birth_act_npmr,
            R.id.ieb_come_type_act_npmr, R.id.ieb_medicare_act_npmr, R.id.sb_nation_act_npmr,
            R.id.sb_in_hos_type_act_npmr, R.id.ieb_domicile_addr_act_npmr, R.id.btn_save_act_npmr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ieb_idcard_act_npmr:
                break;
            case R.id.sb_sex_act_npmr:
                showActionSheet(sbSexActNpmr, "男", "女");
                break;
            case R.id.sb_birth_act_npmr:
                break;
            case R.id.ieb_come_type_act_npmr:
                break;
            case R.id.sb_in_hos_type_act_npmr:
                break;
            case R.id.sb_nation_act_npmr:
                break;
            case R.id.ieb_medicare_act_npmr:
                break;
            case R.id.ieb_domicile_addr_act_npmr:
                break;
            case R.id.btn_save_act_npmr:

                break;
            default:
                break;
        }
    }

    private void showActionSheet(SettingBar settingBar, String... strings) {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles(strings)
                .setCancelableOnTouchOutside(true)
                .setListener(new ActionSheet.ActionSheetListener() {
                    @Override
                    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                    }

                    @Override
                    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                        if (index == 0) {
                            settingBar.setRightText("男");
                        } else if (index == 1) {
                            settingBar.setRightText("女");
                        }
                    }
                }).show();
    }

    private class IdCardBean {

        /**
         * classify : 1
         * idType : 01
         * birthDate : 19920609
         * address : 河南省延津县城关镇大潭村迎宾路４２号
         * nation : 汉
         * sex : 男
         * signingOrganization : 延津县公安局
         * endTime : 20390308
         * name : 李承扬
         * beginTime : 20190308
         * idnum : 410726199206093417
         */

        private String classify;
        private String idType;
        private String birthDate;
        private String address;
        private String nation;
        private String sex;
        private String signingOrganization;
        private String endTime;
        private String name;
        private String beginTime;
        private String idnum;

        public String getClassify() {
            return classify;
        }

        public void setClassify(String classify) {
            this.classify = classify;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSigningOrganization() {
            return signingOrganization;
        }

        public void setSigningOrganization(String signingOrganization) {
            this.signingOrganization = signingOrganization;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getIdnum() {
            return idnum;
        }

        public void setIdnum(String idnum) {
            this.idnum = idnum;
        }
    }
}