package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import butterknife.BindView;

/**
 * TransferFragment
 * description: 转归交接
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class TransferFragment extends BaseFragment {

    @BindView(R.id.es_transformation)
    EditSpinner esTransformation;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.et_transfer_reason)
    EditText etTransferReason;
    @BindView(R.id.tfl_transfer_reason)
    TagFlowLayout tflTransferReason;
    @BindView(R.id.et_state_of_illness_dispose)
    EditText etStateOfIllnessDispose;
    @BindView(R.id.tfl_state_of_illness_dispose)
    TagFlowLayout tflStateOfIllnessDispose;
    @BindView(R.id.sv_to_transfe_hospital)
    ScrollView svToTransfeHospital;
    @BindView(R.id.sv_leave_hospital)
    ScrollView svLeaveHospital;
    @BindView(R.id.rg_departure_hospital)
    RadioGroup rgDepartureHospital;
    @BindView(R.id.rg_die_reason)
    RadioGroup rgDieReason;
    @BindView(R.id.ll_die)
    LinearLayout llDie;
    @BindView(R.id.tv_time_item_time_node)
    TextView tvTimeItemTimeNode;
    @BindView(R.id.iv_refresh_item_time_node)
    ImageView ivRefreshItemTimeNode;
    TimePickerView mTimePickerView;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_transfer)
    LinearLayout llTransfer;

    private String[] mVals = new String[]{"无溶栓能力", "无介入能力", "家属意愿"};
    private String[] mVals1 = new String[]{"未给溶栓药物", "已给溶栓药物"};


    private String mPatientId;
    private String mDocId;
    private ArrayList<String> list;

    public TransferFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();

        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llTransfer, llBottom);
    }


    public static TransferFragment newInstance(String patientId, String docId) {
        TransferFragment fragment = new TransferFragment();
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
    protected int getLayoutId() {
        return R.layout.fragment_transfer;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();


        esTransformation.setOnSelectStringLitner(new EditSpinner.OnSelectStringLitner() {
            @Override
            public void getSeletedString(String text) {
                if (text.contains("转院")) {
                    svToTransfeHospital.setVisibility(View.VISIBLE);
                    llDie.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.GONE);
                } else if (text.contains("离院")) {
                    svToTransfeHospital.setVisibility(View.GONE);
                    llDie.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.VISIBLE);
                } else if (text.contains("死亡")) {
                    llDie.setVisibility(View.VISIBLE);
                    svToTransfeHospital.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.GONE);
                } else {
                    llDie.setVisibility(View.GONE);
                    svToTransfeHospital.setVisibility(View.GONE);
                    svLeaveHospital.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    protected void initListener() {
        //设置输入框值
        getEtTransferReason(tflTransferReason, etTransferReason, mVals);
        //设置输入框值
        getEtTransferReason(tflStateOfIllnessDispose, etStateOfIllnessDispose, mVals1);

        rgDepartureHospital.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobutton = (RadioButton) group.findViewById(group.getCheckedRadioButtonId());

                //Toast.makeText(getActivity(),"选中的内容是"+ radiobutton.getText().toString(),Toast.LENGTH_LONG).show();
                switch (checkedId) {
                    case R.id.rb_leave_hospital:
                        llDie.setVisibility(View.GONE);
                        break;

                    case R.id.rb_transform_hospital:
                        llDie.setVisibility(View.GONE);

                        break;

                    case R.id.rb_township_health_center:

                        llDie.setVisibility(View.GONE);
                        break;

                    case R.id.rb_no_leave_hospital:
                        llDie.setVisibility(View.GONE);

                        break;

                    case R.id.rb_die:
                        llDie.setVisibility(View.VISIBLE);


                        break;

                    case R.id.rb_other:
                        llDie.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }


    private void getEtTransferReason(TagFlowLayout tfl, EditText et, String[] mVals) {


        if (et != null) {
            tfl.setAdapter(new TagAdapter<String>(mVals) {

                private TextView tv;

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                            tfl, false);
                    tv.setText(s);
                    return tv;
                }

                @Override
                public void onSelected(int position, View view) {
                    super.onSelected(position, view);

                }

                @Override
                public void unSelected(int position, View view) {
                    super.unSelected(position, view);
                }
            });

            et.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 解决scrollView中嵌套EditText导致不能上下滑动的问题
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }

                    return false;
                }
            });

            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (s.length() > 100) { //判断EditText中输入的字符数是不是已经大于6
                        et.setText(s.toString().substring(0, 100)); //设置EditText只显示前面6位字符
                        et.setSelection(100);
                        return;
                    }


                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {

                    if (!et.getText().toString().isEmpty()) {

                        et.setText(et.getText().toString() + "，" + mVals[position]);

                    } else {
                        et.setText(mVals[position]);
                    }

                    return true;
                }
            });

            tfl.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
                @Override
                public void onSelected(Set<Integer> selectPosSet) {
                    getActivity().setTitle("choose:" + selectPosSet.toString());
                }
            });

        } else {


            tfl.setAdapter(new TagAdapter<String>(mVals) {

                private TextView tv;

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    tv = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.adpter_flow_layout_tv_tag,
                            tfl, false);
                    tv.setText(s);
                    return tv;
                }

                @Override
                public void onSelected(int position, View view) {
                    super.onSelected(position, view);
                    //  view.setBackgroundColor(getResources().getColor(R.color.app_00aaff));
                    view.setBackground(getResources().getDrawable(R.drawable.selector_flow_layout_checked_bg));
                }

                @Override
                public void unSelected(int position, View view) {
                    super.unSelected(position, view);
                    view.setBackground(getResources().getDrawable(R.drawable.selector_flow_layout_nomal_bg));
                }
            });


        }

    }

    private void loadData() {
        list = new ArrayList<>();
        list.add("请选择");
        list.add("急诊留观");
        list.add("收入急诊重症");
        list.add("收入急诊病房");
        list.add("收入神经重症");
        list.add("收入神经内科一病区");
        list.add("收入神经内科二病区");
        list.add("收入神经外科病区");
        list.add("转院");
        list.add("死亡");
        list.add("离院");
        list.add("其他");
        esTransformation.setItemData(list);
    }


    /**
     * 显示时间选择控件
     *
     * @param
     */
    protected void showTimePickView() {

        if (mTimePickerView == null) {
            mTimePickerView = new TimePickerBuilder(mActivity, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    String time = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, date);
                    tvTimeItemTimeNode.setText(time);
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