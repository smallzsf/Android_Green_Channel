package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.Constants;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.TextTimeBar;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ImageExamFragment
 * description: 辅助检查
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class AuxiliaryExamFragment extends BaseFragment {

    @BindView(R.id.stl_title_frag_ae)
    SegmentTabLayout stlTitleFragAe;
    @BindView(R.id.rb_blood_frag_ae)
    RadioButton rbBloodFragAe;
    @BindView(R.id.rb_ct_frag_ae)
    RadioButton rbCtFragAe;
    @BindView(R.id.rb_cta_frag_ae)
    RadioButton rbCtaFragAe;
    @BindView(R.id.rb_ctp_frag_ae)
    RadioButton rbCtpFragAe;
    @BindView(R.id.rb_mri_frag_ae)
    RadioButton rbMriFragAe;
    @BindView(R.id.rb_mra_frag_ae)
    RadioButton rbMraFragAe;
    @BindView(R.id.rb_cemra_frag_ae)
    RadioButton rbCemraFragAe;
    @BindView(R.id.rb_cvus_frag_ae)
    RadioButton rbCvusFragAe;
    @BindView(R.id.rb_tcd_frag_ae)
    RadioButton rbTcdFragAe;
    @BindView(R.id.ttb_complete_time_frag_ae)
    TextTimeBar ttbCompleteTimeFragAe;
    @BindView(R.id.ttb_report_time_frag_ae)
    TextTimeBar ttbReportTimeFragAe;
    @BindView(R.id.et_result_frag_ae)
    EditText etResultFragAe;
    @BindView(R.id.tv_result_length_frag_ae)
    TextView tvResultLengthFragAe;
    @BindView(R.id.ll_result_frag_ae)
    LinearLayout llResultFragAe;
    @BindView(R.id.tv_photo_frag_ae)
    TextView tvPhotoFragAe;
    @BindView(R.id.iv_photo_frag_ae)
    ImageView ivPhotoFragAe;
    @BindView(R.id.ll_photo_frag_ae)
    LinearLayout llPhotoFragAe;
    @BindView(R.id.tv_report_frag_ae)
    TextView tvReportFragAe;
    @BindView(R.id.iv_report_frag_ae)
    ImageView ivReportFragAe;
    @BindView(R.id.ll_report_frag_ae)
    LinearLayout llReportFragAe;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_auxiliary_exam)
    LinearLayout llAuxiliaryExam;

    private String mPatientId;
    private String mDocId;
    protected TimePickerView mTimePickerView;

    public AuxiliaryExamFragment() {
        // Required empty public constructor
    }

    public static AuxiliaryExamFragment newInstance(String patientId, String docId) {
        AuxiliaryExamFragment fragment = new AuxiliaryExamFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.PATIENT_ID, patientId);
        args.putString(IntentKey.DOC_ID, docId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPatientId = getArguments().getString(IntentKey.PATIENT_ID);
            mDocId = getArguments().getString(IntentKey.DOC_ID);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llAuxiliaryExam, llBottom);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_auxiliary_exam;
    }

    @Override
    protected void initView(@NonNull View view) {
        stlTitleFragAe.setTabData(Constants.AUXILIARY_EXAM_TITLES);
        setViewShowType(0);
    }

    /**
     * 设置显示内容, tablayout 切换时调用
     *
     * @param type 0、默认状态（血液检查）
     *             1、 CT检查
     *             2、 核磁检查
     *             3、 超声检查
     */
    private void setViewShowType(int type) {
        if (type == 1) {
            // CT检查
            rbBloodFragAe.setVisibility(View.GONE);
            rbCtFragAe.setVisibility(View.VISIBLE);
            rbCtaFragAe.setVisibility(View.VISIBLE);
            rbCtpFragAe.setVisibility(View.VISIBLE);
            rbMraFragAe.setVisibility(View.GONE);
            rbMriFragAe.setVisibility(View.GONE);
            rbCemraFragAe.setVisibility(View.GONE);
            rbCvusFragAe.setVisibility(View.GONE);
            rbTcdFragAe.setVisibility(View.GONE);
            // 报告显示
            llPhotoFragAe.setVisibility(View.VISIBLE);
            llReportFragAe.setVisibility(View.VISIBLE);
            tvReportFragAe.setText("查看CT平扫报告");
            tvPhotoFragAe.setText("查看CT平扫片子");
        } else if (type == 2) {
            // 核磁检查
            rbBloodFragAe.setVisibility(View.GONE);
            rbCtFragAe.setVisibility(View.GONE);
            rbCtaFragAe.setVisibility(View.GONE);
            rbCtpFragAe.setVisibility(View.GONE);
            rbMraFragAe.setVisibility(View.VISIBLE);
            rbMriFragAe.setVisibility(View.VISIBLE);
            rbCemraFragAe.setVisibility(View.VISIBLE);
            rbCvusFragAe.setVisibility(View.GONE);
            rbTcdFragAe.setVisibility(View.GONE);
            // 报告显示
            llPhotoFragAe.setVisibility(View.VISIBLE);
            llReportFragAe.setVisibility(View.VISIBLE);
            tvReportFragAe.setText("查看MRI报告");
            tvPhotoFragAe.setText("查看MRI片子");
        } else if (type == 3) {
            // 超声检查
            rbBloodFragAe.setVisibility(View.GONE);
            rbCtFragAe.setVisibility(View.GONE);
            rbCtaFragAe.setVisibility(View.GONE);
            rbCtpFragAe.setVisibility(View.GONE);
            rbMraFragAe.setVisibility(View.GONE);
            rbMriFragAe.setVisibility(View.GONE);
            rbCemraFragAe.setVisibility(View.GONE);
            rbCvusFragAe.setVisibility(View.VISIBLE);
            rbTcdFragAe.setVisibility(View.VISIBLE);
            // 报告显示
            llPhotoFragAe.setVisibility(View.VISIBLE);
            llReportFragAe.setVisibility(View.VISIBLE);
            tvReportFragAe.setText("查看颈部血管超声报告");
            tvPhotoFragAe.setText("查看颈部血管超声片子");
        } else {
            // 默认状态
            rbBloodFragAe.setVisibility(View.VISIBLE);
            rbCtFragAe.setVisibility(View.GONE);
            rbCtaFragAe.setVisibility(View.GONE);
            rbCtpFragAe.setVisibility(View.GONE);
            rbMraFragAe.setVisibility(View.GONE);
            rbMriFragAe.setVisibility(View.GONE);
            rbCemraFragAe.setVisibility(View.GONE);
            rbCvusFragAe.setVisibility(View.GONE);
            rbTcdFragAe.setVisibility(View.GONE);
            // 报告显示
            llPhotoFragAe.setVisibility(View.GONE);
            llReportFragAe.setVisibility(View.VISIBLE);
            tvReportFragAe.setText("查看血检报告");
        }
        // 清除数据
        ttbReportTimeFragAe.setTime("");
        ttbCompleteTimeFragAe.setTime("");
        etResultFragAe.setText("");
    }

    @Override
    protected void initListener() {
        initRadioButtonCheckListener();
        ttbCompleteTimeFragAe.setTimeZoneClickListener(v -> showTimePickView(ttbCompleteTimeFragAe));
        ttbReportTimeFragAe.setTimeZoneClickListener(v -> showTimePickView(ttbReportTimeFragAe));
        stlTitleFragAe.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                setViewShowType(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    /**
     * 设置radio button的点击事件
     * 清除之前的内容，并替换相应的文字
     */
    private void initRadioButtonCheckListener() {
        // CT
        rbCtFragAe.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看CT平扫报告", "查看CT平扫片子");
            }
        });
        rbCtaFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看CTA报告", "查看CTA片子");
            }
        }));
        rbCtpFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看CTP报告", "查看CTP片子");
            }
        }));
        // 核磁
        rbMriFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看MRI报告", "查看MRI片子");
            }
        }));
        rbMraFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看MRA报告", "查看MRA片子");
            }
        }));
        rbCemraFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看CE-MRA报告", "查看CE-MRA片子");
            }
        }));
        // 超声
        rbCvusFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看颈部血管超声报告", "查看颈部血管超声片子");
            }
        }));
        rbTcdFragAe.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                setRadioView("查看TCD报告", "查看TCD片子");
            }
        }));
    }

    /**
     * 设置radio button 切换后的内容
     *
     * @param reportTitle 片子的标题
     * @param photoTitle  报告的标题
     */
    private void setRadioView(String reportTitle, String photoTitle) {
        // 清除数据
        ttbReportTimeFragAe.setTime("");
        ttbCompleteTimeFragAe.setTime("");
        etResultFragAe.setText("");
        // 设置内容
        tvReportFragAe.setText(reportTitle);
        tvPhotoFragAe.setText(photoTitle);
        // TODO: 2020/8/28  如果有数据，则需要清除对应的跳转链接, 并设置当前需要的链接
        //  tvReportFragAe.setOnClickListener(null);
        // 或者 修改listener中对应的跳转链接

    }

    @OnClick({R.id.tv_photo_frag_ae, R.id.iv_photo_frag_ae, R.id.tv_report_frag_ae,
            R.id.iv_report_frag_ae, R.id.btn_get_data, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_photo_frag_ae:
                break;
            case R.id.iv_photo_frag_ae:
                break;
            case R.id.tv_report_frag_ae:
                break;
            case R.id.iv_report_frag_ae:
                break;
            case R.id.btn_get_data:
                break;
            case R.id.btn_confirm:
                break;
            default:
                break;
        }
    }

    /**
     * 显示时间选择控件
     *
     * @param textTimeBar 要显示时间的控件
     */
    protected void showTimePickView(TextTimeBar textTimeBar) {
        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    String time = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date);
                    textTimeBar.setTime(time);
                }
            })
                    .isDialog(false)
                    .setType(new boolean[]{true, true, true, true, true, true})
                    .setOutSideCancelable(true)
                    .build();
        }
        if (mTimePickerView.isShowing()) {
            mTimePickerView.dismiss();
        }
        mTimePickerView.show();
    }
}