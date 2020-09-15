package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.PhotoViewActivity;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.ChestpainEcgDetailBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.SettingBar;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainEcgExaminFragment
 * description:  心电检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainEcgExaminFragment extends BaseStrokeFragment {


    @BindView(R.id.rb_electrocardiogram_has)
    RadioButton rbElectrocardiogramHas;
    @BindView(R.id.rb_electrocardiogram_none)
    RadioButton rbElectrocardiogramNone;
    @BindView(R.id.rg_electrocardiogram)
    RadioGroup rgElectrocardiogram;
    @BindView(R.id.iv_add_ecg_record)
    ImageView ivAddEcgRecord;
    @BindView(R.id.ttbl_ecg_check_time)
    TextTimeBar ttblEcgCheckTime;
    @BindView(R.id.ttbl_ecg_diagnosis_time)
    TextTimeBar ttblEcgDiagnosisTime;
    @BindView(R.id.ed_ecg_diagnosis_conclusion)
    EditText edEcgDiagnosisConclusion;
    @BindView(R.id.sb_ecg_report_first)
    SettingBar sbEcgReportFirst;
    @BindView(R.id.ll_ecg_record_one)
    LinearLayout llEcgRecordOne;
    @BindView(R.id.iv_ecg_record_close_two)
    ImageView ivEcgRecordCloseTwo;
    @BindView(R.id.ttbl_ecg_check_time1)
    TextTimeBar ttblEcgCheckTime1;
    @BindView(R.id.ttbl_ecg_diagnosis_time1)
    TextTimeBar ttblEcgDiagnosisTime1;
    @BindView(R.id.ed_ecg_diagnosis_conclusion1)
    EditText edEcgDiagnosisConclusion1;
    @BindView(R.id.sb_ecg_report_second)
    SettingBar sbEcgReportSecond;
    @BindView(R.id.ll_ecg_record_two)
    LinearLayout llEcgRecordTwo;
    @BindView(R.id.iv_ecg_record_close_three)
    ImageView ivEcgRecordCloseThree;
    @BindView(R.id.ttbl_ecg_check_time2)
    TextTimeBar ttblEcgCheckTime2;
    @BindView(R.id.ttbl_ecg_diagnosis_time2)
    TextTimeBar ttblEcgDiagnosisTime2;
    @BindView(R.id.ed_ecg_diagnosis_conclusion2)
    EditText edEcgDiagnosisConclusion2;
    @BindView(R.id.sb_ecg_report_three)
    SettingBar sbEcgReportThree;
    @BindView(R.id.ll_ecg_record_three)
    LinearLayout llEcgRecordThree;
    @BindView(R.id.rb_ecg_transmission_120)
    RadioButton rbEcgTransmission120;
    @BindView(R.id.rb_ecg_transmission_none)
    RadioButton rbEcgTransmissionNone;
    @BindView(R.id.rg_ecg_transmission)
    RadioGroup rgEcgTransmission;
    @BindView(R.id.rtb_ecg_receiving_time)
    TextTimeBar rtbEcgReceivingTime;
    @BindView(R.id.es_transfer_type)
    EditSpinner esTransferType;
    @BindView(R.id.ll_ecg_trans)
    LinearLayout llEcgTrans;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;

    private int ecgRecordItem = 0;
    SparseArray<String> mEcgFilePaths;
    private final int ECG_File_0 = 0;
    private final int ECG_File_1 = 1;
    private final int ECG_File_2 = 2;


    public static ChestPainEcgExaminFragment newInstance(String recordId) {
        ChestPainEcgExaminFragment fragment = new ChestPainEcgExaminFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.chest_fragment_ecg_examin;
    }

    @Override
    protected void initView(@NonNull View view) {
        mEcgFilePaths = new SparseArray<>();
        esTransferType.setStringArrayId(R.array.chest_pain_heart_tansfer_way);
        refrashRecordItem();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    /**
     * 加载数据
     */
    private void loadData() {
        showLoadingDialog();
        BaseRequestBean<ChestpainEcgDetailBean> requestBean =
                new BaseRequestBean<>(mRecordId, 2, new ChestpainEcgDetailBean());
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainsuEcgDetail(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseResponseBean<ChestpainEcgDetailBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<ChestpainEcgDetailBean>> call, Response<BaseResponseBean<ChestpainEcgDetailBean>> response) {
                        hideLoadingDialog();
                        Log.e("zhangshifu", "onResponse: " + response.toString());
                        if (response.body() != null && response.body().getResult() == 1) {
                            if (response.body().getData() != null) {
                                resetShowData(response.body().getData().getData());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<ChestpainEcgDetailBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });

    }

    /**
     * 重新绘制界面使用
     */
    private void resetShowData(ChestpainEcgDetailBean bean) {

        if (bean == null) {
            return;
        }
//         设置远程心电传输
//        rb_ecg_transmission_120
        String ecgisremotetransmission = bean.getEcgisremotetransmission();
        if (!TextUtils.isEmpty(ecgisremotetransmission)) {
            if ("cpc_ycxdtcsfs_120".equals(ecgisremotetransmission)) {
                rbEcgTransmission120.setChecked(true);
            } else if ("cpc_ycxdtcsfs_wcs".equals(ecgisremotetransmission)) {
                rbEcgTransmissionNone.setChecked(true);
            }
        }
        rtbEcgReceivingTime.setTime(bean.getEcgremotetransmissiontime());
        esTransferType.setStringArrayNormalKey(bean.getEcgremotetransmissionway());

        // 设置心电图
        if (Constants.BOOL_TRUE.equals(bean.getEcgisexist())) {
            rbElectrocardiogramHas.setChecked(true);

            List<ChestpainEcgDetailBean.EcgarrayBean> ecgarray = bean.getEcgarray();
            if (ecgarray != null) {
                ecgRecordItem = ecgarray.size();
            }
            ChestpainEcgDetailBean.EcgarrayBean ecgarrayBean = null;
            if (ecgRecordItem > 0) {
                ecgarrayBean = ecgarray.get(0);
                ttblEcgCheckTime.setTime(ecgarrayBean.getEcgtime());
                ttblEcgDiagnosisTime.setTime(ecgarrayBean.getEcgdiagnosistime());
                edEcgDiagnosisConclusion.setText(ecgarrayBean.getEcgdiagnosed());
                if (TextUtils.isEmpty(ecgarrayBean.getEcgfile())) {
                    sbEcgReportFirst.setRightText("上传");
                } else {
                    sbEcgReportFirst.setRightText("查看");
                    sbEcgReportFirst.setRightIcon(R.drawable.picture_icon_black_delete);
                    mEcgFilePaths.put(ECG_File_0, ecgarrayBean.getEcgfile());
                }
            }

            if (ecgRecordItem > 1) {
                ecgarrayBean = ecgarray.get(1);
                ttblEcgCheckTime1.setTime(ecgarrayBean.getEcgtime());
                ttblEcgDiagnosisTime1.setTime(ecgarrayBean.getEcgdiagnosistime());
                edEcgDiagnosisConclusion1.setText(ecgarrayBean.getEcgdiagnosed());
                if (TextUtils.isEmpty(ecgarrayBean.getEcgfile())) {
                    sbEcgReportSecond.setRightText("上传");
                } else {
                    sbEcgReportSecond.setRightText("查看");
                    sbEcgReportSecond.setRightIcon(R.drawable.picture_icon_black_delete);
                    mEcgFilePaths.put(ECG_File_1, ecgarrayBean.getEcgfile());
                }
            }

            if (ecgRecordItem > 2) {
                ecgarrayBean = ecgarray.get(2);
                ttblEcgCheckTime2.setTime(ecgarrayBean.getEcgtime());
                ttblEcgDiagnosisTime2.setTime(ecgarrayBean.getEcgdiagnosistime());
                edEcgDiagnosisConclusion2.setText(ecgarrayBean.getEcgdiagnosed());
                if (TextUtils.isEmpty(ecgarrayBean.getEcgfile())) {
                    sbEcgReportThree.setRightText("上传");
                } else {
                    sbEcgReportThree.setRightText("查看");
                    sbEcgReportThree.setRightIcon(R.drawable.picture_icon_black_delete);
                    mEcgFilePaths.put(ECG_File_2, ecgarrayBean.getEcgfile());
                }
            }
        } else if (Constants.BOOL_FALSE.equals(bean.getEcgisexist())) {
            rbElectrocardiogramNone.setChecked(true);
        }
    }

    private void refrashRecordItem() {
        refrashRecordItem(llEcgRecordOne, 1);
        refrashRecordItem(llEcgRecordTwo, 2);
        refrashRecordItem(llEcgRecordThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (ecgRecordItem >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initListener() {
        rgElectrocardiogram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_electrocardiogram_none) {
                    ecgRecordItem = 0;
                    ivAddEcgRecord.setVisibility(View.GONE);
                } else if (checkedId == R.id.rb_electrocardiogram_has) {
                    ivAddEcgRecord.setVisibility(View.VISIBLE);
                    ecgRecordItem = 1;
                }
                refrashRecordItem();
            }
        });

        rgEcgTransmission.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_ecg_transmission_120) {
                    llEcgTrans.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.rb_ecg_transmission_none) {
                    llEcgTrans.setVisibility(View.GONE);
                }
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.iv_add_ecg_record:
                        if (ecgRecordItem >= 3) {
                            showToast("最多只能添加三条心电记录");
                            return;
                        }
                        ecgRecordItem++;
                        refrashRecordItem();
                        break;
                    case R.id.iv_ecg_record_close_three:
                    case R.id.iv_ecg_record_close_two:
                        ecgRecordItem--;
                        refrashRecordItem();
                        break;
                    case R.id.btn_confirm:
                        save();
                        break;
                    default:
                        break;
                }
            }
        };
        rbElectrocardiogramHas.setOnClickListener(onClickListener);
        rbElectrocardiogramNone.setOnClickListener(onClickListener);
        ivAddEcgRecord.setOnClickListener(onClickListener);
        ivEcgRecordCloseTwo.setOnClickListener(onClickListener);
        ivEcgRecordCloseThree.setOnClickListener(onClickListener);
        btnConfirm.setOnClickListener(onClickListener);

        initUploadFileListener();
    }

    private void initUploadFileListener() {
        sbEcgReportFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals("上传", sbEcgReportFirst.getRightText().toString())) {
                    dealUploadListener(ECG_File_0, sbEcgReportFirst, mEcgFilePaths);
                } else if (TextUtils.equals("查看", sbEcgReportFirst.getRightText().toString())) {
                    PhotoViewActivity.launch(mActivity, mEcgFilePaths.get(ECG_File_0));
                }

            }
        });

        sbEcgReportFirst.setRightImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals("查看", sbEcgReportFirst.getRightText().toString())) {
                    // 删除已上传的数据
                    mEcgFilePaths.remove(ECG_File_0);
                    sbEcgReportFirst.setRightText("上传");
                    sbEcgReportFirst.setRightIcon(R.drawable.common_icon_right_arrow_222222);
                }
            }
        });

        sbEcgReportSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dealUploadListener(ECG_File_1, sbEcgReportSecond, mEcgFilePaths);
            }
        });

        sbEcgReportThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dealUploadListener(ECG_File_2, sbEcgReportThree, mEcgFilePaths);
            }
        });
    }

    private void save() {

        ChestpainEcgDetailBean bean = new ChestpainEcgDetailBean();

        // 设置远程心电传输
        if (rbEcgTransmission120.isChecked()) {
            bean.setEcgisremotetransmission("cpc_ycxdtcsfs_120");
            // 接收时间
            bean.setEcgremotetransmissiontime(rtbEcgReceivingTime.getTime());
            // 传输方式
            String[] selectData = esTransferType.getSelectData();
            bean.setEcgremotetransmissionway(selectData[1]);
        } else if (rbEcgTransmissionNone.isChecked()) {
            bean.setEcgisremotetransmission("cpc_ycxdtcsfs_wcs");
        }
        // 设置心电图
        if (rbElectrocardiogramHas.isChecked()) {
            bean.setEcgisexist(Constants.BOOL_TRUE);
            List<ChestpainEcgDetailBean.EcgarrayBean> ecgarray = bean.getEcgarray();
            if (ecgarray == null) {
                ecgarray = new ArrayList<>();
                bean.setEcgarray(ecgarray);
            }
            ChestpainEcgDetailBean.EcgarrayBean ecgarrayBean = null;
            if (ecgRecordItem > 0) {
                ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
                String time = ttblEcgCheckTime.getTime();
                ecgarrayBean.setEcgtime(time);
                String diagnosisTimeTime = ttblEcgDiagnosisTime.getTime();
                ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
                String trim = edEcgDiagnosisConclusion.getText().toString().trim();
                ecgarrayBean.setEcgdiagnosed(trim);
                ecgarrayBean.setEcgfile(mEcgFilePaths.get(ECG_File_0));
                ecgarray.add(ecgarrayBean);
            }

            if (ecgRecordItem > 1) {
                ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
                String time = ttblEcgCheckTime1.getTime();
                ecgarrayBean.setEcgtime(time);
                String diagnosisTimeTime = ttblEcgDiagnosisTime1.getTime();
                ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
                String trim = edEcgDiagnosisConclusion1.getText().toString().trim();
                ecgarrayBean.setEcgdiagnosed(trim);
                ecgarrayBean.setEcgfile(mEcgFilePaths.get(ECG_File_1));
                ecgarray.add(ecgarrayBean);
            }

            if (ecgRecordItem > 2) {
                ecgarrayBean = new ChestpainEcgDetailBean.EcgarrayBean();
                String time = ttblEcgCheckTime2.getTime();
                ecgarrayBean.setEcgtime(time);
                String diagnosisTimeTime = ttblEcgDiagnosisTime2.getTime();
                ecgarrayBean.setEcgdiagnosistime(diagnosisTimeTime);
                String trim = edEcgDiagnosisConclusion2.getText().toString().trim();
                ecgarrayBean.setEcgdiagnosed(trim);
                ecgarrayBean.setEcgfile(mEcgFilePaths.get(ECG_File_2));
                ecgarray.add(ecgarrayBean);
            }

        } else if (rbElectrocardiogramNone.isChecked()) {
            bean.setEcgisexist(Constants.BOOL_FALSE);
        }
        // 调用保存接口
        save(bean);
    }


    /**
     * 保存数据
     *
     * @param bean
     */
    public void save(ChestpainEcgDetailBean bean) {
        if (bean == null) {
            return;
        }
        showLoadingDialog();
        BaseRequestBean<ChestpainEcgDetailBean> requestBean =
                new BaseRequestBean<>(mRecordId, 2, bean);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .saveChestPainsuEcgDetail(requestBean.getResuestBody(requestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        Log.e("zhangshifu", "onResponse" + response);
                        if (response.body() != null && response.body().getResult() == 1) {
                            showToast(R.string.http_tip_data_save_success);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }
}