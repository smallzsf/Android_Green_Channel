package com.xyj.strokeaid.fragment.stroke;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.TextTimeBar;

import butterknife.BindView;

/**
 * @Description: 卒中血脂四项页面
 * @Author: crq
 * @CreateDate: 2020/8/26 17:21
 */
public class StrokeBloodFatFragment extends BaseFragment {


    @BindView(R.id.ttb_awareness_time)
    TextTimeBar ttbAwarenessTime;
    @BindView(R.id.ttb_draw_blood_time)
    TextTimeBar ttbDrawBloodTime;
    @BindView(R.id.tv_triglyceride)
    TextView tvTriglyceride;
    @BindView(R.id.et_triglyceride)
    EditText etTriglyceride;
    @BindView(R.id.tv_cholesterol)
    TextView tvCholesterol;
    @BindView(R.id.et_cholesterol)
    EditText etCholesterol;
    @BindView(R.id.tv_low_density_lipoprotein_cholesterin)
    TextView tvLowDensityLipoproteinCholesterin;
    @BindView(R.id.et_low_density_lipoprotein_cholesterin)
    EditText etLowDensityLipoproteinCholesterin;
    @BindView(R.id.tv_high_density_lipoprotein_cholesterol)
    TextView tvHighDensityLipoproteinCholesterol;
    @BindView(R.id.et_high_density_lipoprotein_cholesterol)
    EditText etHighDensityLipoproteinCholesterol;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.ll_stroke_blood_fat)
    LinearLayout llStrokeBloodFat;
    private View llBottom;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blood_fat;
    }

    @Override
    protected void initView(@NonNull View view) {
        btnGetData.setText("获取数据");
        btnConfirm.setText("确定");
        llBottom = getActivity().findViewById(R.id.ll_bottom);

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onResume() {
        super.onResume();
        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llStrokeBloodFat, llBottom);
    }


}

