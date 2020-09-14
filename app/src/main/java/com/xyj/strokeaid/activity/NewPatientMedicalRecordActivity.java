package com.xyj.strokeaid.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.didichuxing.doraemonkit.widget.tableview.utils.DensityUtils;
import com.eid.reader.EIDReader;
import com.eid.reader.IIDDataCallback;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.DeviceBindBean;
import com.xyj.strokeaid.bean.PatientMedicalRecordBean;
import com.xyj.strokeaid.bean.RequestIdBean;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.NfcUtils;
import com.xyj.strokeaid.http.DeviceService;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.ActionSheet;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    /**
     * 查看类型
     * 1、 新建
     * 2、 查看
     */
    @Autowired(name = IntentKey.VIEW_TYPE)
    int mViewType;
    /**
     * 患者类型
     * 1、 卒中
     * 2、 胸痛
     * 3、 创伤
     * 4、 危重孕产妇
     * 5、 危重儿童和新生儿
     */
    @Autowired(name = IntentKey.DISEASE_VIEW_TYPE)
    int mDiseaseType;
    /**
     * 患者主表id
     */
    @Autowired(name = IntentKey.RECORD_ID)
    String mRecordId;

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
    @BindView(R.id.sb_come_type_act_npmr)
    SettingBar sbComeTypeActNpmr;
    @BindView(R.id.ll_come_hos_act_npmr)
    LinearLayout llComeHosActNpmr;
    @BindView(R.id.sb_in_hos_type_act_npmr)
    SettingBar sbInHosTypeActNpmr;
    @BindView(R.id.sb_nation_act_npmr)
    SettingBar sbNationActNpmr;
    @BindView(R.id.ieb_medicare_num_act_npmr)
    ItemEditBar iebMedicareNumActNpmr;
    @BindView(R.id.ieb_domicile_addr_act_npmr)
    ItemEditBar iebDomicileAddrActNpmr;
    @BindView(R.id.ieb_contact_name_act_npmr)
    ItemEditBar iebContactNameActNpmr;
    @BindView(R.id.ieb_contact_phone_act_npmr)
    ItemEditBar iebContactPhoneActNpmr;
    @BindView(R.id.btn_save_act_npmr)
    Button btnSaveActNpmr;
    @BindView(R.id.sb_medicare_type_act_npmr)
    SettingBar sbMedicareTypeActNpmr;
    @BindView(R.id.sb_serious_medicare_act_npmr)
    SettingBar sbSeriousMedicareActNpmr;
    @BindView(R.id.ieb_live_hos_id_act_npmr)
    ItemEditBar iebLiveHosIdActNpmr;
    @BindView(R.id.sb_dis_start_range_act_npmr)
    SettingBar sbDisStartRangeActNpmr;
    @BindView(R.id.ieb_age_act_npmr)
    ItemEditBar iebAgeActNpmr;
    @BindView(R.id.rb_dis_time_exact_act_npmr)
    RadioButton rbDisTimeExactActNpmr;
    @BindView(R.id.rb_dis_time_inaccuracy_act_npmr)
    RadioButton rbDisTimeInaccuracyActNpmr;
    @BindView(R.id.rg_dis_time_act_npmr)
    RadioGroup rgDisTimeActNpmr;

    private EIDReader idReader;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private AMapLocationListener locationListener = null;
    private List<ComeHosBean> mComeHosBeans = null;
    private PatientMedicalRecordBean mPatinetBean = null;
    private String[] OPTION = new String[]{"汉族", "蒙古族", "回族", "藏族", "维吾尔族", "苗族", "彝族", "壮族", "布依族", "朝鲜族", "满族", "侗族", "瑶族", "白族", "土家族", "哈尼族", "哈萨克族", "傣族", "黎族", "傈僳族", "佤族", "畲族", "高山族", "拉祜族", "水族", "东乡族", "纳西族", "景颇族", "柯尔克孜族", "土族", "达斡尔族", "仫佬族", "羌族", "布朗族", "撒拉族", "毛难族"
            , "仡佬族", "锡伯族", "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族", "俄罗斯族", "鄂温克族", "崩龙族", "保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族", "赫哲族", "门巴族", "珞巴族", "基诺族", "其他", "外国血统"};


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

        LogUtils.d("new patient ~~  mDiseaseType is "  + mDiseaseType);

        requestPerms("获取授权成功", "获取授权失败，", Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE);
        if (idReader == null) {
            idReader = new EIDReader(this);
        }
        idReader.setIidDataCallback(this);
        initLocation();
        iebAgeActNpmr.getEtRoot().setInputType(InputType.TYPE_CLASS_NUMBER);
        iebWeightActNpmr.getEtRoot().setInputType(InputType.TYPE_CLASS_NUMBER);
        iebHeightActNpmr.getEtRoot().setInputType(InputType.TYPE_CLASS_NUMBER);
        NfcUtils nfcUtils = new NfcUtils(this);
        NfcUtils.NfcInit(this);
    }

    @Override
    public void initListener() {
        titleBarActNpmr
                .setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    quickCreatPatient();
                });
        rgDisTimeActNpmr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_dis_time_exact_act_npmr) {
                    // 发病时间精确就不显示区间
                    sbDisStartRangeActNpmr.setVisibility(View.GONE);
                    ttbDisStartActNpmr.setTimeType(CalendarUtils.TYPE_ALL);
                } else {
                    ttbDisStartActNpmr.setTimeType(CalendarUtils.TYPE_YEAR_MONTH_DAY);
                    sbDisStartRangeActNpmr.setVisibility(View.VISIBLE);
                }
            }
        });
        // 地址
        iebDisAddrActNpmr.setRightIvOnClickerListener(v -> {
            startLocation();
        });
        // 身份证
        iebIdcardActNpmr.setRightIvOnClickerListener(v -> {
            if (idReader != null) {
                // 将NFC设置为读卡器模式
                idReader.enableReaderMode(this);
            }
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
        if (NfcUtils.mNfcAdapter != null) {
            NfcUtils.mNfcAdapter.enableForegroundDispatch(this, NfcUtils.mPendingIntent, null, null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent);
        if (TextUtils.equals("android.nfc.action.TAG_DISCOVERED", intent.getAction())) {
            if (idReader != null) {
                idReader.enableReaderMode(this);
            }
        } else {
            if (idReader != null) {
                idReader.disableReaderMode();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (NfcUtils.mNfcAdapter != null) {
            NfcUtils.mNfcAdapter.disableForegroundDispatch(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (idReader != null) {
            idReader.release();
        }
        NfcUtils.mNfcAdapter = null;
        destroyLocation();
    }


    public void processIntent(Intent intent) {
        Parcelable[] rawmsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        if (rawmsgs == null) {
            LogUtils.e("--------------NFC-------------数据为空");
            return;
        }
        NdefMessage msg = (NdefMessage) rawmsgs[0];
        NdefRecord[] records = msg.getRecords();
        String resultStr = new String(records[0].getPayload());
        iebWristbandActNpmr.setEditContent(resultStr);
        showToast(resultStr);
        // 返回的是NFC检查到卡中的数据
        LogUtils.e("processIntent: " + resultStr);
        try {
            // 检测卡的id
            String id = NfcUtils.readNFCId(intent);
            LogUtils.e("processIntent--id: " + id);
            // NfcUtils中获取卡中数据的方法
            String result = NfcUtils.readNFCFromTag(intent);
            LogUtils.e("processIntent--result: " + result);
            // 往卡中写数据
//
//            String data = "this.is.write";
//            NfcUtils.writeNFCToTag(data,intent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onIDCardState(int i, String s) {
        showLoadingDialog();
    }

    @Override
    public void onGetIDData(String result, String resultDetail, String idData, Bitmap pic) {
        hideLoadingDialog();
        if (idReader != null) {
            // 恢复NFC适配到正常模式
            idReader.disableReaderMode();
        }
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
        } else {
            // 读取失败
            showToast("读取失败，错误码：" + result);
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

    @OnClick({R.id.sb_sex_act_npmr, R.id.sb_birth_act_npmr, R.id.sb_dis_start_range_act_npmr,
            R.id.sb_come_type_act_npmr, R.id.ieb_medicare_num_act_npmr, R.id.sb_nation_act_npmr,
            R.id.sb_in_hos_type_act_npmr, R.id.ieb_domicile_addr_act_npmr, R.id.btn_save_act_npmr, R.id.sb_medicare_type_act_npmr, R.id.sb_serious_medicare_act_npmr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_sex_act_npmr:
                showActionSheet(sbSexActNpmr, "男", "女");
                break;
            case R.id.sb_birth_act_npmr:
                showBirthPickView(sbBirthActNpmr);
                break;
            case R.id.sb_come_type_act_npmr:
                showComeHosActionSheet(sbComeTypeActNpmr, "本院急救车", "当地120", "外院转院", "自行来院", "在院发病");
                break;
            case R.id.sb_in_hos_type_act_npmr:
                showActionSheet(sbInHosTypeActNpmr, "急诊", "门诊", "其他医疗机构转入", "其他");
                break;
            case R.id.sb_nation_act_npmr:
                //民族
                showPickerView();

                break;
            case R.id.sb_dis_start_range_act_npmr:
                showActionSheet(sbDisStartRangeActNpmr,
                        "凌晨(0点到6点)", "清晨(6到8点)", "上午(8到12点)", "中午(12到14点)", "傍晚(17到19点)", "晚上(19到24点)");
                break;
            case R.id.sb_medicare_type_act_npmr:

                showActionSheet(sbMedicareTypeActNpmr, "城镇职工基本医疗保险", "新型农村合作医疗", "城镇居民基本医疗保险", "自费", "军免");

                break;
            case R.id.sb_serious_medicare_act_npmr:

                showActionSheet(sbSeriousMedicareActNpmr, "是", "否");

                break;
            case R.id.btn_save_act_npmr:
                preSave();
                break;
            default:
                break;
        }
    }


    /**
     * 获取数据
     */
    private void getData(String recordId) {
        showLoadingDialog();
        RequestIdBean requestIdBean = new RequestIdBean(recordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getPatientInfo(requestIdBean.getResuestBody(requestIdBean))
                .enqueue(new Callback<BaseObjectBean<PatientMedicalRecordBean>>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean<PatientMedicalRecordBean>> call, Response<BaseObjectBean<PatientMedicalRecordBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mPatinetBean = response.body().getData();
                                refreshView(mPatinetBean);
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                        hideLoadingDialog();
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean<PatientMedicalRecordBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }


    /**
     * 刷新页面
     */
    private void refreshView(PatientMedicalRecordBean bean) {
        if (bean == null) {
            return;
        }
        // 就诊号
        iebOutpatientIdActNpmr.setEditContent(bean.getPatientidofambulant());
        // 住院号
        iebLiveHosIdActNpmr.setEditContent(bean.getPatientidofhospitalization());
        // 腕带编号
        iebWristbandActNpmr.setEditContent(bean.getTimecollectorcode());
        // 发病地址
        iebDisAddrActNpmr.setEditContent(bean.getAttackaddress());
        // 发病时间
        ttbDisStartActNpmr.setTime(bean.getAttacktime());
        // 姓名
        iebNameActNpmr.setEditContent(bean.getFullname());
        // 身份证号
        iebIdcardActNpmr.setEditContent(bean.getIdcardno());
        // 性别
        if (!TextUtils.isEmpty(bean.getGender())) {
            if (TextUtils.equals("1", bean.getGender())) {
                sbSexActNpmr.setRightText("男");
            } else if (TextUtils.equals("2", bean.getGender())) {
                sbSexActNpmr.setRightText("女");
            } else {
                sbSexActNpmr.setRightText("未知");
            }
        } else {
            sbSexActNpmr.setRightText("未知");
        }
        // 年龄
        iebAgeActNpmr.setEditContent(bean.getAge());
        // 体重
        iebWeightActNpmr.setEditContent(bean.getWeight());
        // 身高
        iebHeightActNpmr.setEditContent(bean.getHeight());
        // bmi
        iebBmiActNpmr.setEditContent(bean.getBmi());
        // 出生日期
        sbBirthActNpmr.setRightText(bean.getBirthdate());
        // 来院方式
        String comingway = bean.getComingway();
        if ("cpc_lyfsv2_hj120".equals(comingway)) {

            String helporganization = bean.getHelporganization();
            if (!TextUtils.isEmpty(helporganization)) {
                if (TextUtils.equals("cpc_hj120v2_cc_zx", helporganization)) {
                    sbComeTypeActNpmr.setRightText("120急救车");
                } else {
                    sbComeTypeActNpmr.setRightText("本院救护车");
                }
            }
            List<ComeHosBean> comeHosBeanList = new ArrayList<>();
            comeHosBeanList.add(new ComeHosBean("呼救时间", "", bean.getTimeofcall(), false));
            comeHosBeanList.add(new ComeHosBean("120出车时间", "", bean.getDepart120time(), false));
            comeHosBeanList.add(new ComeHosBean("到达现场时间", "", bean.getArrivescenetime(), false));
            comeHosBeanList.add(new ComeHosBean("首次医疗接触", "", bean.getFmctime(), false));
            comeHosBeanList.add(new ComeHosBean("离开现场时间", "", bean.getLevavescenetime(), false));
            comeHosBeanList.add(new ComeHosBean("到达医院大门", "", bean.getArrivehospitaltime(), false));
            comeHosBeanList.add(new ComeHosBean("院内接诊时间", "", bean.getFirstdoctorreceptiontime(), false));
            showViews(comeHosBeanList);
        } else if ("cpc_lyfsv2_zy120".equals(comingway)) {
            sbComeTypeActNpmr.setRightText("转院");
            List<ComeHosBean> comeHosBeanList = new ArrayList<>();
            comeHosBeanList.add(new ComeHosBean("转出医院入门", "", bean.getHospitaltransferfromarrivedtime(), false));
            comeHosBeanList.add(new ComeHosBean("首次医疗接触", "", bean.getFmctime(), false));
            comeHosBeanList.add(new ComeHosBean("转运救护车到达", "", bean.getTransferambulancearrivaltime(), false));
            comeHosBeanList.add(new ComeHosBean("离开转出医院", "", bean.getHospitaltransferfromleavetime(), false));
            comeHosBeanList.add(new ComeHosBean("到达医院大门", "", bean.getArrivehospitaltime(), false));
            comeHosBeanList.add(new ComeHosBean("院内接诊时间", "", bean.getFirstdoctorreceptiontime(), false));
            comeHosBeanList.add(new ComeHosBean("决定转院时间", "", bean.getDecidetranstime(), false));
            comeHosBeanList.add(new ComeHosBean("医院名称", bean.getHospitalnametransfrom(), "", false));
            showViews(comeHosBeanList);
        } else if ("cpc_lyfsv2_zxly".equals(comingway)) {
            sbComeTypeActNpmr.setRightText("自行来院");
            List<ComeHosBean> comeHosBeanList = new ArrayList<>();
            comeHosBeanList.add(new ComeHosBean("到达医院大门", "", bean.getArrivehospitaltime(), false));
            comeHosBeanList.add(new ComeHosBean("首次医疗接触", "", bean.getFmctime(), false));
            comeHosBeanList.add(new ComeHosBean("院内接诊时间", "", bean.getFirstdoctorreceptiontime(), false));
            showViews(comeHosBeanList);
        } else if ("cpc_lyfsv2_ynfb".equals(comingway)) {
            sbComeTypeActNpmr.setRightText("院内发病");
            List<ComeHosBean> comeHosBeanList = new ArrayList<>();
            comeHosBeanList.add(new ComeHosBean("首次医疗接触", "", bean.getFmctime(), false));
            comeHosBeanList.add(new ComeHosBean("发病科室", bean.getAttackdepartment(), "", true));
            comeHosBeanList.add(new ComeHosBean("会诊时间", "", bean.getEmergencytime(), false));
            comeHosBeanList.add(new ComeHosBean("离开科室", "", bean.getLeaveattackdepartmenttime(), false));
            showViews(comeHosBeanList);
        }
        // 发病时间
        ttbDisStartActNpmr.setTime(bean.getAttacktime());
        // 发病区间
        String attacktimeisinaccurate = bean.getAttacktimeisinaccurate();
        if (TextUtils.equals(attacktimeisinaccurate, "-1")) {
            // 不精确
            rgDisTimeActNpmr.check(R.id.rb_dis_time_inaccuracy_act_npmr);
            // 发病日期
            ttbDisStartActNpmr.setTime(bean.getAttackdate());
            // 发病区间
            String attacktimeinterval = bean.getAttacktimeinterval();
            if (!TextUtils.isEmpty(attacktimeinterval)) {
                if (attacktimeinterval.contains("cpc_fbsjfw_0-6")) {
                    sbDisStartRangeActNpmr.setRightText("凌晨(0点到6点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_6-8")) {
                    sbDisStartRangeActNpmr.setRightText("清晨(6到8点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_8-12")) {
                    sbDisStartRangeActNpmr.setRightText("上午(8到12点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_12-14")) {
                    sbDisStartRangeActNpmr.setRightText("中午(12到14点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_14-17")) {
                    sbDisStartRangeActNpmr.setRightText("下午(14到17点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_17-19")) {
                    sbDisStartRangeActNpmr.setRightText("傍晚(17到19点)");
                } else if (attacktimeinterval.contains("cpc_fbsjfw_19-24")) {
                    sbDisStartRangeActNpmr.setRightText("晚上(19到24点)");
                }
            }
        } else if (TextUtils.equals(attacktimeisinaccurate, "1")) {
            // 精确
            rgDisTimeActNpmr.check(R.id.rb_dis_time_exact_act_npmr);
            ttbDisStartActNpmr.setTime(bean.getAttacktime());
        }
    }

    /**
     * 保存前校验数据
     */
    private void preSave() {

        if (mPatinetBean == null) {
            mPatinetBean = new PatientMedicalRecordBean();
        }

        if (iebNameActNpmr.getEditContent().equals("")) {
            ToastUtils.showShort("姓名不能为空");
            return;
        }
        // 疾病类型
        mPatinetBean.setEmergencyType(String.valueOf(mDiseaseType));

        //edit 14
        String editIebOutpatientIdActNpmr = iebOutpatientIdActNpmr.getEditContent();//就诊id
        String editIebLiveHosIdActNpmr = iebLiveHosIdActNpmr.getEditContent();//入院id
        String editIebWristbandActNpmr = iebWristbandActNpmr.getEditContent();//时间采集器腕带编号
        String editIebDisAddrActNpmr = iebDisAddrActNpmr.getEditContent();
        String editIebNameActNpmr = iebNameActNpmr.getEditContent();
        String editIebIdcardActNpmr = iebIdcardActNpmr.getEditContent();
        String editIebAgeActNpmr = iebAgeActNpmr.getEditContent();
        String editIebWeightActNpmr = iebWeightActNpmr.getEditContent();
        String editIebHeightActNpmr = iebHeightActNpmr.getEditContent();
        String editIebBmiActNpmr = iebBmiActNpmr.getEditContent();
        String editIebMedicareNumActNpmr = iebMedicareNumActNpmr.getEditContent();
        String editIebDomicileAddrActNpmr = iebDomicileAddrActNpmr.getEditContent();
        String editIebContactNameActNpmr = iebContactNameActNpmr.getEditContent();
        String editIebContactPhoneActNpmr = iebContactPhoneActNpmr.getEditContent();
        //time  1
        String disStarTime = ttbDisStartActNpmr.getTime();
        //14+1
        mPatinetBean.setFullname(editIebNameActNpmr);
        mPatinetBean.setAge(editIebAgeActNpmr);
        mPatinetBean.setIdcardno(editIebIdcardActNpmr);
        mPatinetBean.setContactname(editIebContactNameActNpmr);
        mPatinetBean.setContactnumber(editIebContactPhoneActNpmr);
        mPatinetBean.setAttacktime(disStarTime);
        mPatinetBean.setAttackaddress(editIebDisAddrActNpmr);
        mPatinetBean.setHeight(editIebHeightActNpmr);
        mPatinetBean.setWeight(editIebWeightActNpmr);
        mPatinetBean.setBmi(editIebBmiActNpmr);
        mPatinetBean.setRegisteraddress(editIebDomicileAddrActNpmr);
        mPatinetBean.setMedicarecardcode(editIebMedicareNumActNpmr);
        mPatinetBean.setPatientidofambulant(editIebOutpatientIdActNpmr);
        mPatinetBean.setPatientidofhospitalization(editIebLiveHosIdActNpmr);
        mPatinetBean.setTimecollectorcode(editIebWristbandActNpmr);

        if (rgDisTimeActNpmr.getCheckedRadioButtonId() == R.id.rb_dis_time_exact_act_npmr) {
            mPatinetBean.setAttacktime(disStarTime);
        } else {
            mPatinetBean.setAttackdate(disStarTime);
            /**
             * 发病区间
             */
            String disStartRange = sbDisStartRangeActNpmr.getRightText().toString();
            if (disStartRange.contains("凌晨(0点到6点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_0-6");
            } else if (disStartRange.contains("清晨(6到8点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_6-8");
            } else if (disStartRange.contains("上午(8到12点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_8-12");
            } else if (disStartRange.contains("中午(12到14点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_12-14");
            } else if (disStartRange.contains("下午(14到17点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_14-17");
            } else if (disStartRange.contains("傍晚(17到19点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_17-19");
            } else if (disStartRange.contains("晚上(19到24点)")) {
                mPatinetBean.setAttacktimeinterval("cpc_fbsjfw_19-24");
            }
        }


        String sex = sbSexActNpmr.getRightText().toString();
        if (sex.equals("男")) {
            mPatinetBean.setGender("cpc_gender_1");
        } else {
            mPatinetBean.setGender("cpc_gender_2");
        }

        String birth = sbBirthActNpmr.getRightText().toString();
        if (!birth.equals("请选择出生日期")) {
            mPatinetBean.setBirthdate(birth);
        }

        /**
         * 来院方式
         */
        String comeType = sbComeTypeActNpmr.getRightText().toString();
        if (comeType.equals("本院急救车") || comeType.equals("当地120")) {
            mPatinetBean.setComingway("cpc_lyfsv2_hj120");
        } else if (comeType.equals("外院转院")) {
            mPatinetBean.setComingway("cpc_lyfsv2_zy120");
        } else if (comeType.equals("自行来院")) {
            mPatinetBean.setComingway("cpc_lyfsv2_zxly");
        } else {
            mPatinetBean.setComingway("cpc_lyfsv2_ynfb");
        }
        // 不同来院方式返回集合
        ArrayList<String> getComeHosList = getComeHosType(comeType);
        LogUtils.d(getComeHosList);
        if (comeType.contains("本院急救车") || comeType.contains("当地120")) {
            //呼救时间 timeofcall
            mPatinetBean.setTimeofcall(getComeHosList.get(0));
            // 120出车
            mPatinetBean.setDepart120time(getComeHosList.get(1));
            //到达现场时间  arrive120time
            mPatinetBean.setArrivescenetime(getComeHosList.get(2));
            //首次医疗接触时间  fmctime
            mPatinetBean.setFmctime(getComeHosList.get(3));
            //离开现场时间  fmctime
            mPatinetBean.setLevavescenetime(getComeHosList.get(4));
            //到达医院大门时间 arrivegatetime
            mPatinetBean.setArrivehospitaltime(getComeHosList.get(5));
            //院内接诊时间  firstdoctorreceptiontime
            mPatinetBean.setFirstdoctorreceptiontime(getComeHosList.get(6));
        } else if (comeType.contains("外院转院")) {
            //转出医院入门时间 hospitaltransferfromarrivedtime
            mPatinetBean.setHospitaltransferfromarrivedtime(getComeHosList.get(0));
            ////首次医疗接触时间  fmctime
            mPatinetBean.setFmctime(getComeHosList.get(1));
            //转运救护车到达时间 transferambulancearrivaltime
            mPatinetBean.setTransferambulancearrivaltime(getComeHosList.get(2));
            //离开转出医院时间  hospitaltransferfromleavetime
            mPatinetBean.setHospitaltransferfromleavetime(getComeHosList.get(3));
            //到达医院大门时间     arrivegatetime
            mPatinetBean.setArrivehospitaltime(getComeHosList.get(4));
            //院内接诊时间 firstdoctorreceptiontime
            mPatinetBean.setFirstdoctorreceptiontime(getComeHosList.get(5));
            //决定转院时间  decidetranstime
            mPatinetBean.setDecidetranstime(getComeHosList.get(6));
            //医院名称  hospitalnametransfrom
            mPatinetBean.setHospitalnametransfrom(getComeHosList.get(7));
        } else if (comeType.contains("自行来院")) {
            ////到达医院大门时间  arrivegatetime
            mPatinetBean.setArrivehospitaltime(getComeHosList.get(0));
            //首次医疗接触时间  fmctime
            mPatinetBean.setFmctime(getComeHosList.get(1));
            //院内接诊时间  firstdoctorreceptiontime
            mPatinetBean.setFirstdoctorreceptiontime(getComeHosList.get(2));
        } else if (comeType.contains("在院发病")) {
            //首次医疗接触时间    fmctime
            mPatinetBean.setFmctime(getComeHosList.get(0));
            //发病科室  attackdepartment
            mPatinetBean.setAttackdepartment((getComeHosList.get(1)));
            //会诊时间      emergencytime
            mPatinetBean.setEmergencytime((getComeHosList.get(2)));
            //离开科室  leaveattackdepartmenttime
            mPatinetBean.setLeaveattackdepartmenttime((getComeHosList.get(3)));
        }


        /**
         * 1急诊 2门诊 3其他医疗机构转入4其他
         */
        String inHosType = sbInHosTypeActNpmr.getRightText().toString();
        if (inHosType.equals("急诊")) {
            mPatinetBean.setBehospitalizedway("1");
        } else if (inHosType.equals("门诊")) {
            mPatinetBean.setBehospitalizedway("2");
        } else if (inHosType.equals("其他医疗机构转入")) {
            mPatinetBean.setBehospitalizedway("3");
        } else if (inHosType.equals("其他")) {
            mPatinetBean.setBehospitalizedway("4");
        }


        /**
         * 民族
         */
        String nation = sbNationActNpmr.getRightText().toString();
        for (int i = 0; i < OPTION.length; i++) {
            if (nation.equals(OPTION[i])) {
                mPatinetBean.setNation(i + 1 + "");
            }

        }

        /**
         *  医保类型
         *  "cpc_yblx_czzgjbylbx": "城镇职工基本医疗保险",
         *  "cpc_yblx_xxnchzyl": "新型农村合作医疗",
         *  "cpc_yblx_czjmjbylbx": "城镇居民基本医疗保险",
         *  "cpc_yblx_zf": "自费",
         *  "cpc_yblx_jm": "军免"
         */
        String medicareType = sbMedicareTypeActNpmr.getRightText().toString();
        if (medicareType.contains("城镇职工基本医疗保险")) {
            mPatinetBean.setMedicaretype("cpc_yblx_czzgjbylbx");
        } else if (comeType.contains("城镇居民基本医疗保险")) {
            mPatinetBean.setMedicaretype("cpc_yblx_czjmjbylbx");
        } else if (comeType.contains("自费")) {
            mPatinetBean.setMedicaretype("cpc_yblx_zf");
        } else if (comeType.contains("军免")) {
            mPatinetBean.setMedicaretype("cpc_yblx_jm");
        }

        /**
         * 大病医保
         */
        String seriousMedicare = sbSeriousMedicareActNpmr.getRightText().toString();
        if (seriousMedicare.contains("是")) {
            mPatinetBean.setSeriousillnessmedicare("1");
        } else if (seriousMedicare.contains("否")) {
            mPatinetBean.setSeriousillnessmedicare("-1");
        }


        /**
         * 调用新建接口
         */
        newPatientMedicalRecord(mPatinetBean);


    }

    /**
     * 获得来院方式的时间和Edit值
     *
     * @param comeType
     * @return
     */
    private ArrayList<String> getComeHosType(String comeType) {
        switch (comeType) {
            case "本院急救车":
                return getTimeAndEdit();
            case "当地120":
                return getTimeAndEdit();
            case "外院转院":
                return getTimeAndEdit();
            case "自行来院":
                return getTimeAndEdit();
            case "在院发病":
                return getTimeAndEdit();
        }
        return null;
    }

    /**
     * 获得时间和输入值集合
     *
     * @return ArrayList<String>
     */
    private ArrayList<String> getTimeAndEdit() {

        ArrayList<String> times = new ArrayList<>();
        for (int i = 0; i < llComeHosActNpmr.getChildCount(); i++) {
            View v = llComeHosActNpmr.getChildAt(i);
            if (v instanceof ItemEditBar) {
                ItemEditBar ItemEditBar = (ItemEditBar) llComeHosActNpmr.getChildAt(i);
                times.add(ItemEditBar.getEditContent());

            } else if (v instanceof TextTimeBar) {
                TextTimeBar textTimeBar = (TextTimeBar) llComeHosActNpmr.getChildAt(i);
                times.add(textTimeBar.getTime());
            }
        }

        return times;

    }


    private void quickCreatPatient() {
        PatientMedicalRecordBean patientMedicalRecordBean = new PatientMedicalRecordBean();
        patientMedicalRecordBean.setFullname("患者" + System.currentTimeMillis());
        patientMedicalRecordBean.setEmergencyType(String.valueOf(mDiseaseType));
        newPatientMedicalRecord(patientMedicalRecordBean);
    }


    /**
     * 展示民族
     */
    private void showPickerView() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < OPTION.length; i++) {
            strings.add(OPTION[i]);
        }

        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                ToastUtils.showShort(strings.get(options1) + "**" + options1);
                sbNationActNpmr.setRightText(strings.get(options1));
            }
        }).build();
        pvOptions.setPicker(strings, null, null);
        pvOptions.show();
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

                        settingBar.setRightText(strings[index]);

                    }
                }).show();
    }

    private void showComeHosActionSheet(SettingBar settingBar, String... strings) {
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
                        settingBar.setRightText(strings[index]);
                        showComeHosType(index);
                    }
                }).show();
    }

    private void showComeHosType(int type) {
        llComeHosActNpmr.setVisibility(View.VISIBLE);
        llComeHosActNpmr.removeAllViews();
        if (type == 0) {
            // 本院急救车
            mComeHosBeans = getOwnAmbulanceContent();
        } else if (type == 1) {
            // 外院急救车
            mComeHosBeans = getOwnAmbulanceContent();
        } else if (type == 2) {
            // 外院转院
            mComeHosBeans = getOtherHosContent();
        } else if (type == 3) {
            // 自行来院
            mComeHosBeans = getComeHosSelfContent();
        } else if (type == 4) {
            // 在院发病
            mComeHosBeans = getInHosStrokeContent();
        } else {
            mComeHosBeans = new ArrayList<>();
        }
        showViews(mComeHosBeans);
    }

    private void showViews(List<ComeHosBean> comeHosBeans) {
        for (ComeHosBean comeHosBean : comeHosBeans) {
            if (comeHosBean.isEditable()) {
                ItemEditBar itemEditBar = new ItemEditBar(mContext);
                llComeHosActNpmr.addView(itemEditBar);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) itemEditBar.getLayoutParams();
                layoutParams.height = DensityUtils.dp2px(mContext, 40);
                itemEditBar.setLayoutParams(layoutParams);
                itemEditBar.setTitle(comeHosBean.getTitel());
                itemEditBar.setBottomLineVisible(true);
            } else {
                TextTimeBar textTimeBar = new TextTimeBar(mContext);
                llComeHosActNpmr.addView(textTimeBar);
                textTimeBar.setTitle(comeHosBean.getTitel());
                textTimeBar.setBottomLineVisible(true);
            }
        }
    }

    private List<ComeHosBean> getInHosStrokeContent() {
        ArrayList<ComeHosBean> list = new ArrayList<>();
        list.add(new ComeHosBean("首次医疗接触", false));
        list.add(new ComeHosBean("发病科室", true));
        list.add(new ComeHosBean("会诊时间", false));
        list.add(new ComeHosBean("离开科室", false));
        return list;
    }

    private List<ComeHosBean> getComeHosSelfContent() {
        ArrayList<ComeHosBean> list = new ArrayList<>();
        list.add(new ComeHosBean("到达医院大门", false));
        list.add(new ComeHosBean("首次医疗接触", false));
        list.add(new ComeHosBean("院内接诊时间", false));
        return list;
    }

    private List<ComeHosBean> getOtherHosContent() {
        ArrayList<ComeHosBean> list = new ArrayList<>();
        list.add(new ComeHosBean("转出医院入门", false));
        list.add(new ComeHosBean("首次医疗接触", false));
        list.add(new ComeHosBean("转运救护车到达", false));
        list.add(new ComeHosBean("离开转出医院", false));
        list.add(new ComeHosBean("到达医院大门", false));
        list.add(new ComeHosBean("院内接诊时间", false));
        list.add(new ComeHosBean("决定转院时间", false));
        list.add(new ComeHosBean("医院名称", true));
        return list;
    }

    private List<ComeHosBean> getOwnAmbulanceContent() {
        ArrayList<ComeHosBean> list = new ArrayList<>();
        list.add(new ComeHosBean("呼救时间", false));
        list.add(new ComeHosBean("120出车时间", false));
        list.add(new ComeHosBean("到达现场时间", false));
        list.add(new ComeHosBean("首次医疗接触", false));
        list.add(new ComeHosBean("离开现场时间", false));
        list.add(new ComeHosBean("到达医院大门", false));
        list.add(new ComeHosBean("院内接诊时间", false));
        return list;
    }

    /**
     * 新建患者信息
     */
    private void newPatientMedicalRecord(PatientMedicalRecordBean newPatientMedicalRecordBean) {
        RetrofitClient
                .getInstance()
                .getApi()
                .newPatienMedical(newPatientMedicalRecordBean.getResuestBody(newPatientMedicalRecordBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功" + response.body().getResult() + "***" + response.body().getMessage() + "***" + response.body().getData());
                                // TODO
                                finish();
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        showToast(call.toString());
                    }
                });
    }


    /**
     * 获得腕带编号， 生成流水号并绑定给当前用户
     *
     * @param wristbandNum
     */
    private void bindWristbandId(String wristbandNum) {
        if (TextUtils.isEmpty(wristbandNum)) {
            showToast("腕带编号不能为空~");
            return;
        }
        DeviceBindBean deviceBindBean = new DeviceBindBean(wristbandNum);
        RetrofitClient.getInstance()
                .create(DeviceService.class)
                .bindWristband(deviceBindBean.getResuestBody(deviceBindBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mPatinetBean.setTimecollectorcode(wristbandNum);
                                mPatinetBean.setTimecollectorserialnumber(response.body().getData().toString());
                                preSave();
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    private static class ComeHosBean {
        private String titel;
        private String content;
        private String time;
        private boolean editable;

        public ComeHosBean(String titel, boolean editable) {
            this.titel = titel;
            this.editable = editable;
        }

        public ComeHosBean(String titel, String content, String time, boolean editable) {
            this.titel = titel;
            this.content = content;
            this.time = time;
            this.editable = editable;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }

        public String getTitel() {
            return titel;
        }

        public void setTitel(String titel) {
            this.titel = titel;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    private static class IdCardBean {

        /**
         * classify :
         * idType :
         * birthDate :
         * address :
         * nation :
         * sex :
         * signingOrganization :
         * endTime :
         * name :
         * beginTime :
         * idnum :
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