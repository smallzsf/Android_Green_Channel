package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;

import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordBean;
import com.xyj.strokeaid.bean.ChestPainDiseaseRecordRequest;
import com.xyj.strokeaid.bean.RecordIdBean;
import com.xyj.strokeaid.fragment.BaseStrokeFragment;
import com.xyj.strokeaid.helper.KeyValueHelper;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  病情信息
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainDiseaseRecordFragment extends BaseStrokeFragment {

    @BindView(R.id.rb_persistent_chest_pain)
    RadioButton rbPersistentChestPain;
    @BindView(R.id.rb_intermittent_chest_pain)
    RadioButton rbIntermittentChestPain;
    @BindView(R.id.rb_relieved_chest_pain)
    RadioButton rbRelievedChestPain;
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
    @BindView(R.id.sl_content)
    NestedScrollView slContent;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.cb_non_acs_1)
    CheckBox cbNonAcs1;
    @BindView(R.id.cb_non_acs_2)
    CheckBox cbNonAcs2;
    @BindView(R.id.cb_non_acs_3)
    CheckBox cbNonAcs3;
    @BindView(R.id.cb_non_acs_4)
    CheckBox cbNonAcs4;
    @BindView(R.id.cb_non_acs_5)
    CheckBox cbNonAcs5;
    @BindView(R.id.cb_non_acs_6)
    CheckBox cbNonAcs6;
    @BindView(R.id.cb_non_acs_7)
    CheckBox cbNonAcs7;
    @BindView(R.id.cb_non_acs_8)
    CheckBox cbNonAcs8;
    @BindView(R.id.cb_non_acs_9)
    CheckBox cbNonAcs9;
    @BindView(R.id.cb_non_acs_10)
    CheckBox cbNonAcs10;
    @BindView(R.id.cb_non_acs_11)
    CheckBox cbNonAcs11;
    @BindView(R.id.cb_non_acs_12)
    CheckBox cbNonAcs12;
    @BindView(R.id.cb_non_acs_13)
    CheckBox cbNonAcs13;
    @BindView(R.id.cb_non_acs_14)
    CheckBox cbNonAcs14;
    @BindView(R.id.cb_non_acs_15)
    CheckBox cbNonAcs15;
    @BindView(R.id.ll_non_acs)
    LinearLayout llNonAcs;

    private ChestPainDiseaseRecordRequest chestPainDiseaseRecordRequest = null;


    public static ChestPainDiseaseRecordFragment newInstance(String recordId) {
        ChestPainDiseaseRecordFragment fragment = new ChestPainDiseaseRecordFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.chest_pain_fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {
    }

    @Override
    public void onResume() {
        super.onResume();
        queryData();
    }

    /*
    private void refrashAdapter(boolean b) {

        if (b || adapter == null) {
            adapter = new MyAdapter();
            gvDetailed.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }*/

    @OnClick({R.id.rb_persistent_chest_pain, R.id.rb_intermittent_chest_pain, R.id.rb_relieved_chest_pain, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_persistent_chest_pain:
                break;
            case R.id.rb_intermittent_chest_pain:
                break;
            case R.id.rb_relieved_chest_pain:
                break;
            case R.id.btn_save:
                //保存数据
                saveData();
                break;
        }
    }

/*
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
            viewHolder.cbSelect.setChecked(isSelect);
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
    }*/

 /*   private void loadData() {
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
    }*/


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

    /**
     * 保存数据
     */
    private void saveData() {
        if (chestPainDiseaseRecordRequest == null) {
            chestPainDiseaseRecordRequest = new ChestPainDiseaseRecordRequest();
        }

        chestPainDiseaseRecordRequest.setRecordId(mRecordId);


        /**
         * 病情评估
         *                 "cpc_bqpg_cxxxm": "持续性胸闷/胸痛",
         *                 "cpc_bqpg_jxxxm": "间歇性胸闷/胸痛",
         *                 "cpc_bqpg_zzyhj": "症状已缓解"
         */
        if (rbIntermittentChestPain.isChecked()) {
            chestPainDiseaseRecordRequest.setConditionassessment("cpc_bqpg_cxxxm");
        } else if (rbPersistentChestPain.isChecked()) {
            chestPainDiseaseRecordRequest.setConditionassessment("cpc_bqpg_jxxxm");
        } else {
            chestPainDiseaseRecordRequest.setConditionassessment("cpc_bqpg_zzyhj");
        }

        /**
         * 病情评估  病情评估明细
         */
        String checkBoxValue = KeyValueHelper.getCheckboxsKey(cbNonAcs1, cbNonAcs2, cbNonAcs3, cbNonAcs4, cbNonAcs5,
                cbNonAcs6, cbNonAcs7, cbNonAcs8, cbNonAcs9, cbNonAcs10, cbNonAcs11, cbNonAcs12, cbNonAcs13
                , cbNonAcs14, cbNonAcs15);
        chestPainDiseaseRecordRequest.setConditionassessmentdetail(checkBoxValue);

        //病情评估主诉  chiefcomplaint
        chestPainDiseaseRecordRequest.setChiefcomplaint(etMajorComplaintFrag.getText().toString());
        //病情评估备注 conditionassessmentremark
        chestPainDiseaseRecordRequest.setConditionassessmentremark(etSymptom.getText().toString());
        //保存
        chestPainDiseaseRecordSave(chestPainDiseaseRecordRequest);

    }


    /**
     * 查询数据
     */
    private void queryData() {
        //调用获取数据接口
        showLoadingDialog();
        RecordIdBean recordIdBean = new RecordIdBean(mRecordId);
        RetrofitClient
                .getInstance()
                .getApi()
                .getChestPainDiseaseRecord(recordIdBean.getResuestBody(recordIdBean))
                .enqueue(new Callback<BaseObjectBean<ChestPainDiseaseRecordBean>>() {

                    @Override
                    public void onResponse(Call<BaseObjectBean<ChestPainDiseaseRecordBean>> call, Response<BaseObjectBean<ChestPainDiseaseRecordBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("获取数据成功");
                                if (response.body().getData() != null) {
                                    ChestPainDiseaseRecordBean chestPainDiseaseRecordBean = response.body().getData();
                                    //胸痛病情记录获取的数据
                                    queryDataChestPainDiseaseRecord(chestPainDiseaseRecordBean);
                                }

                            } else {
                                     showToast(TextUtils.isEmpty(response.body().getMessage())
                                            ? getString(R.string.http_tip_data_save_error)
                                            : response.body().getMessage());

                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<BaseObjectBean<ChestPainDiseaseRecordBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }


    /**
     * 胸痛 病情记录保存
     */
    private void chestPainDiseaseRecordSave(ChestPainDiseaseRecordRequest request) {
        if (request == null){
            return;
        }
        showLoadingDialog();
        RetrofitClient
                .getInstance()
                .getApi()
                .saveChestPainDiseaseRecord(request.getResuestBody(request))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                            } else {
                                showToast(response.body().getMessage());
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


    /**
     * 查询数据
     *
     * @param chestPainDiseaseRecordBean
     */
    private void queryDataChestPainDiseaseRecord(ChestPainDiseaseRecordBean chestPainDiseaseRecordBean) {

        /**
         * 病情评估
         *   "cpc_bqpg_cxxxm": "持续性胸闷/胸痛",
         *  "cpc_bqpg_jxxxm": "间歇性胸闷/胸痛",
         *   "cpc_bqpg_zzyhj": "症状已缓解"
         */
        if (!TextUtils.isEmpty(chestPainDiseaseRecordBean.getConditionassessment())){
            if (chestPainDiseaseRecordBean.getConditionassessment().contains("cpc_bqpg_cxxxm")) {
                rbIntermittentChestPain.setChecked(true);
            } else if (chestPainDiseaseRecordBean.getConditionassessment().contains("cpc_bqpg_jxxxm")) {
                rbPersistentChestPain.setChecked(true);
            } else {
                rbRelievedChestPain.setChecked(true);
            }

        }


        /**
         * 病情评估明细
         */

        String dischargedunacs = chestPainDiseaseRecordBean.getConditionassessmentdetail();
        if (!TextUtils.isEmpty(dischargedunacs)) {
            cbNonAcs1.setChecked(dischargedunacs.contains("cpc_bqpgmx_hxkn"));
            cbNonAcs2.setChecked(dischargedunacs.contains("cpc_bqpgmx_ft"));
            cbNonAcs3.setChecked(dischargedunacs.contains("cpc_bqpgmx_ct"));
            cbNonAcs4.setChecked(dischargedunacs.contains("cpc_bqpgmx_jbt"));
            cbNonAcs5.setChecked(dischargedunacs.contains("cpc_bqpgmx_hbcx"));
            cbNonAcs6.setChecked(dischargedunacs.contains("cpc_bqpgmx_hbxs"));
            cbNonAcs7.setChecked(dischargedunacs.contains("cpc_bqpgmx_hbexxlsc"));
            cbNonAcs8.setChecked(dischargedunacs.contains("cpc_bqpgmx_bmyydhj"));
            cbNonAcs9.setChecked(dischargedunacs.contains("cpc_bqpgmx_zh"));
            cbNonAcs10.setChecked(dischargedunacs.contains("cpc_bqpgmx_xhxj"));
            cbNonAcs11.setChecked(dischargedunacs.contains("cpc_bqpgmx_fzba"));
            cbNonAcs12.setChecked(dischargedunacs.contains("cpc_bqpgmx_jqbsfg"));
            cbNonAcs13.setChecked(dischargedunacs.contains("cpc_bqpgmx_fl"));
            cbNonAcs14.setChecked(dischargedunacs.contains("cpc_bqpgmx_qc"));
            cbNonAcs15.setChecked(dischargedunacs.contains("cpc_bqpgmx_qt"));
        }


        /**
         * 主诉
         */
        etMajorComplaintFrag.setText(chestPainDiseaseRecordBean.getChiefcomplaint());


        /**
         * 备注
         */
        etSymptom.setText(chestPainDiseaseRecordBean.getConditionassessmentremark());

    }


/*
    private   String getCheckBoxValue(CheckBox... checkBoxes) {
        if (checkBoxes != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked()) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(checkBox.getTag().toString());
                }
            }
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

*/

}