package com.xyj.strokeaid.fragment.chestpain;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.dist.RecordIdUtil;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ChestPainDiseaseRecordFragment
 * description:  血液检查
 *
 * @author : 张世福
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class ChestPainBloodTestFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.rb_troponin_tnt_first)
    RadioButton rbTroponinTntFirst;
    @BindView(R.id.rb_troponin_tnl_first)
    RadioButton rbTroponinTnlFirst;
    @BindView(R.id.ll_troponin_first)
    LinearLayout llTroponinFirst;
    @BindView(R.id.rb_troponin_tnt_two)
    RadioButton rbTroponinTntTwo;
    @BindView(R.id.rb_troponin_tnl_two)
    RadioButton rbTroponinTnlTwo;
    @BindView(R.id.ll_troponin_two)
    LinearLayout llTroponinTwo;
    @BindView(R.id.rb_troponin_tnt_three)
    RadioButton rbTroponinTntThree;
    @BindView(R.id.rb_troponin_tnl_three)
    RadioButton rbTroponinTnlThree;
    @BindView(R.id.ll_troponin_three)
    LinearLayout llTroponinThree;
    @BindView(R.id.ll_troponin_data)
    LinearLayout llTroponinData;
    @BindView(R.id.ll_preoperative_anticoagulation_data)
    LinearLayout llPreoperativeAnticoagulationData;
    @BindView(R.id.ll_dimer_title)
    LinearLayout llDimerTitle;
    @BindView(R.id.eds_preoperative_anticoagulation)
    EditSpinner edsPreoperativeAnticoagulation;
    @BindView(R.id.ll_dimer_data)
    LinearLayout llDimerData;
    @BindView(R.id.ll_bnp_title)
    LinearLayout llBnpTitle;
    @BindView(R.id.ll_bnp_data)
    LinearLayout llBnpData;
    @BindView(R.id.ll_nt_probnp_title)
    LinearLayout llNtProbnpTitle;
    @BindView(R.id.ll_nt_probnp_data)
    LinearLayout llNtProbnpData;
    @BindView(R.id.ll_myo_title)
    LinearLayout llMyoTitle;
    @BindView(R.id.ll_myo_data)
    LinearLayout llMyoData;
    @BindView(R.id.ll_ckmb_title)
    LinearLayout llCkmbTitle;
    @BindView(R.id.ll_ckmb_data)
    LinearLayout llCkmbData;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;
    @BindView(R.id.iv_add_troponin)
    ImageView ivAddTroponin;
    @BindView(R.id.iv_delete_troponin_1)
    ImageView ivDeleteTroponin1;
    @BindView(R.id.iv_delete_troponin_2)
    ImageView ivDeleteTroponin2;
    @BindView(R.id.sv_troponin)
    SwitchCompat svTroponin;
    @BindView(R.id.sv_preoperative_anticoagulation)
    SwitchCompat svPreoperativeAnticoagulation;
    @BindView(R.id.sv_dimer)
    SwitchCompat svDimer;
    @BindView(R.id.sv_bnp)
    SwitchCompat svBnp;
    @BindView(R.id.sv_nt_probnp)
    SwitchCompat svNtProbnp;
    @BindView(R.id.sv_myo)
    SwitchCompat svMyo;
    @BindView(R.id.sv_ckmb)
    SwitchCompat svCkmb;
    private int troponinDataNum = 1;

    private String mRecordId;

    private ChestPainBloodTestFragment() {

    }

    public static ChestPainBloodTestFragment newInstance(String recordId) {
        ChestPainBloodTestFragment fragment = new ChestPainBloodTestFragment();
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
        return R.layout.fragment_chest_pain_blood_test;
    }

    @Override
    protected void initView(@NonNull View view) {
        loadData();
    }


    private void loadData() {
        RecordIdUtil src = new RecordIdUtil();
        src.setRecordId(RecordIdUtil.RECORD_ID);
        String request = GsonUtils.getGson().toJson(src);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getCPApi()
                .getChestPainBloodText(requestBody)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("zhangshifu", "onResponse");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("zhangshifu", "onFailure");
                    }
                });
    }


    @Override
    protected void initListener() {
        svTroponin.setOnClickListener(this);
        svPreoperativeAnticoagulation.setOnClickListener(this);
        svDimer.setOnClickListener(this);
        svBnp.setOnClickListener(this);
        svNtProbnp.setOnClickListener(this);
        svMyo.setOnClickListener(this);
        svCkmb.setOnClickListener(this);
        llBnpTitle.setOnClickListener(this);
        llMyoTitle.setOnClickListener(this);
        llNtProbnpTitle.setOnClickListener(this);
        llDimerTitle.setOnClickListener(this);
        llCkmbTitle.setOnClickListener(this);
        ivAddTroponin.setOnClickListener(this);
        ivDeleteTroponin1.setOnClickListener(this);
        ivDeleteTroponin2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sv_troponin:
                refrashItemVis(llTroponinData, svTroponin);
                break;
            case R.id.sv_preoperative_anticoagulation:
                refrashItemVis(llPreoperativeAnticoagulationData, svPreoperativeAnticoagulation);
                break;
            case R.id.sv_bnp:
                refrashItemVis(llBnpData, svBnp);
                break;
            case R.id.sv_myo:
                refrashItemVis(llMyoData, svMyo);
                break;
            case R.id.sv_nt_probnp:
                refrashItemVis(llNtProbnpData, svNtProbnp);
                break;
            case R.id.sv_dimer:
                refrashItemVis(llDimerData, svDimer);
                break;
            case R.id.sv_ckmb:
                refrashItemVis(llCkmbData, svCkmb);
                break;
            case R.id.iv_add_troponin:
                troponinDataNum++;
                refrashRecordItem();
                break;
            case R.id.iv_delete_troponin_1:
                troponinDataNum--;
               // refrashRecordItem();
                llTroponinTwo.setVisibility(View.GONE);
                break;
            case R.id.iv_delete_troponin_2:
                troponinDataNum--;
             //   refrashRecordItem();
                llTroponinThree.setVisibility(View.GONE);
                break;

            default:
                break;
        }
    }

    private void refrashItemVis(View view, SwitchCompat switchCompat) {
       /* if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
            //  imageView.setImageResource(R.drawable.ic_arrow_up_blue);
        } else {
            view.setVisibility(View.VISIBLE);
            //  imageView.setImageResource(R.drawable.ic_arrow_down_blue);
        }*/

         if (switchCompat.isChecked()){
             view.setVisibility(View.VISIBLE);
         }else {
             view.setVisibility(View.GONE);
         }
    }

    private void refrashRecordItem() {
      //   refrashRecordItem(llTroponinFirst, 1);
        refrashRecordItem(llTroponinTwo, 2);
        refrashRecordItem(llTroponinThree, 3);
    }

    private void refrashRecordItem(View view, int maxValue) {
        if (troponinDataNum >= maxValue) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}