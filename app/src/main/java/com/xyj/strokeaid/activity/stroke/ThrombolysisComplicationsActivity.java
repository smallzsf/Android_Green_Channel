package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.TextSwitchBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ThrombolysisComplicationsActivity
 * description: 溶栓并发症
 *
 * @author : Licy
 * @date : 2020/8/24
 * email ：licy3051@qq.com
 */
@Route(path = RouteUrl.Stroke.STROKE_THROMBOLYSIS_COMPLICATIONS)
public class ThrombolysisComplicationsActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stc)
    BaseTitleBar titleBarActStc;
    @BindView(R.id.tsb_age_act_stc)
    TextSwitchBar tsbAgeActStc;
    @BindView(R.id.tfl_complication_act_stc)
    TagFlowLayout tflComplicationActStc;
    @BindView(R.id.ll_have_act_stc)
    LinearLayout llHaveActStc;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_thrombolysis_complications;
    }

    @Override
    protected void initInject() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        tsbAgeActStc.setSwitch(false);
        llHaveActStc.setVisibility(View.GONE);
        List<String> strings = Arrays.asList(getResources().getStringArray(R.array.stroke_complications));
        tflComplicationActStc.setAdapter(new TagAdapter<String>(strings) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(mContext)
                        .inflate(R.layout.adapter_tag_item, tflComplicationActStc, false);
                view.setText(o);
                return view;
            }
        });
    }

    @Override
    public void initListener() {
        titleBarActStc.setLeftLayoutClickListener(v -> finish());
        tsbAgeActStc.setSwitchClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                llHaveActStc.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

    }

    private String getSelectedString() {
        List<String> strings = Arrays.asList(getResources().getStringArray(R.array.stroke_complications));
        Set<Integer> selectedList = tflComplicationActStc.getSelectedList();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : selectedList) {
            stringBuilder.append(strings.get(integer));
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_confirm, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                // TODO: 2020/8/24 保存信息
                Toast.makeText(mContext, "选中标签有： "+getSelectedString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }
}

    
    
       
    