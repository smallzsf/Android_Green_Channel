package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.XyjGridView;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ChestPainDiseaseRecordFragment
 * description:  病情信息
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainDiseaseRecordFragment extends BaseFragment {

    @BindView(R.id.rb_persistent_chest_pain)
    RadioButton rbPersistentChestPain;
    @BindView(R.id.rb_intermittent_chest_pain)
    RadioButton rbIntermittentChestPain;
    @BindView(R.id.rb_relieved_chest_pain)
    RadioButton rbRelievedChestPain;
    @BindView(R.id.gv_detailed)
    XyjGridView gvDetailed;
    @BindView(R.id.et_major_complaint_frag)
    EditText etMajorComplaintFrag;
    @BindView(R.id.tfl_action_in_chief)
    TagFlowLayout tflActionInChief;
    @BindView(R.id.app_tv_conditon_record)
    TextView appTvConditonRecord;
    @BindView(R.id.et_symptom)
    EditText etSymptom;
    @BindView(R.id.ll_remark)
    LinearLayout llRemark;
    List<String> detailedDataList = new ArrayList<>();
    @BindView(R.id.sl_content)
    NestedScrollView slContent;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;

    private Map<Integer, Boolean> mapDataSelect = new HashMap<>();
    private MyAdapter adapter;
    private int mMaxSrollHeight = 0;

    private String mRecordId;

    public ChestPainDiseaseRecordFragment() {

    }

    public static ChestPainDiseaseRecordFragment newInstance(String recordId) {
        ChestPainDiseaseRecordFragment fragment = new ChestPainDiseaseRecordFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.chest_pain_fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {

        loadData();

        refrashAdapter(true);


    }

    private void refrashAdapter(boolean b) {

        if (b || adapter == null) {
            adapter = new MyAdapter();
            gvDetailed.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return detailedDataList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.adapter_chest_pain_disease_record, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            boolean isSelect = false;
            if (mapDataSelect.containsKey(position)) {
                isSelect = mapDataSelect.get(position);
            }
            viewHolder.cbSelect.setSelected(isSelect);
            MyClickListener onClickListener = new MyClickListener(position);
            viewHolder.cbSelect.setOnClickListener(onClickListener);
            viewHolder.text.setOnClickListener(onClickListener);
            viewHolder.text.setText(detailedDataList.get(position));
            return view;
        }
    }

    static class ViewHolder {
        @BindView(R.id.cb_select)
        CheckBox cbSelect;
        @BindView(R.id.text)
        TextView text;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class MyClickListener implements View.OnClickListener {
        private int position;

        public MyClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            boolean isSelect = false;
            if (mapDataSelect.containsKey(position)) {
                isSelect = mapDataSelect.get(position);
            }
            mapDataSelect.put(position, !isSelect);
            refrashAdapter(false);
        }
    }

    private void loadData() {
        detailedDataList.add("呼吸困难");
        detailedDataList.add("胸痛");
        detailedDataList.add("齿痛");
        detailedDataList.add("肩背痛");
        detailedDataList.add("合并出血");
        detailedDataList.add("合并心衰");
        detailedDataList.add("合并恶性心律失常");
        detailedDataList.add("不明原因的昏厥");
        detailedDataList.add("自汗、大汗淋漓");
        detailedDataList.add("心慌心悸");
        detailedDataList.add("烦躁不安");
        detailedDataList.add("颈前部束缚感");
        detailedDataList.add("乏力");
        detailedDataList.add("气喘");
        detailedDataList.add("其他");
    }


    @Override
    protected void initListener() {

        rbPersistentChestPain.setOnClickListener(onClickListener);
        rbIntermittentChestPain.setOnClickListener(onClickListener);
        rbRelievedChestPain.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.rb_persistent_chest_pain
                    || view.getId() == R.id.rb_intermittent_chest_pain
                    || view.getId() == R.id.rb_relieved_chest_pain) {
                RadioButton rb = (RadioButton) view;
                boolean checked = rb.isChecked();

                rbPersistentChestPain.setChecked(false);
                rbIntermittentChestPain.setChecked(false);
                rbRelievedChestPain.setChecked(false);
                rb.setChecked(checked);
            }

        }
    };
}