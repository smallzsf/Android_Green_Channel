package com.xyj.strokeaid.activity.stroke;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.RouteUrl;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.PreoperativePreparationInfoBean;
import com.xyj.strokeaid.bean.PreoperativePreparationInfoRequestBean;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.SelectDataDialog;
import com.xyj.strokeaid.view.TextTimeBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * StrokeOperationBeforeActivity
 * description: TODO
 *
 * @date : 2020/8/30
 */
@Route(path = RouteUrl.Stroke.STROKE_INVOLVED_OPERATION_BEFORE)
public class StrokeOperationBeforeActivity extends BaseActivity {

    @BindView(R.id.title_bar_act_stroke_before)
    BaseTitleBar titleBarActStrokeMain;

    /**
     * 启动导室管
     */
    @BindView(R.id.ttb_start_cath_act_stroke)
    TextTimeBar tvStartCatheter;

    /**
     * 选择导室管
     */
    @BindView(R.id.es_cath_act_stroke)
    EditSpinner tvSelectCatheter;

    /**
     * 介入医生
     */
    @BindView(R.id.ieb_intervene_doctor)
    ItemEditBar iebInterveneDoctor;
    /**
     * 介入护士
     */
    @BindView(R.id.ieb_intervene_nurse)
    ItemEditBar iebInterveneNurse;
    /**
     * 到院至到达导管室
     */
    @BindView(R.id.ttb_arrive_to_arrived)
    TextTimeBar ttbArriveToArrived;
    /**
     * 手术备注信息
     */
    @BindView(R.id.ieb_remark)
    ItemEditBar iebRemark;
    /**
     * 是否直达导管室
     */
    @BindView(R.id.rg_directdsaroom)
    RadioGroup rgDirectdsaroom;
    @BindView(R.id.ttb_activation_cath_act_stroke)
    TextTimeBar ttbActivationCathActStroke;
    @BindView(R.id.ttb_patient_arrival_act_stroke)
    TextTimeBar ttbPatientArrivalActStroke;


    private PreoperativePreparationInfoBean data;
    //TODO 修改mRecordId
    private String mRecordId = "1111";


    @Override
    public int getLayoutId() {
        return R.layout.stroke_act_before;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        getData();
    }


    @Override
    public void initListener() {
        titleBarActStrokeMain.setLeftLayoutClickListener(v -> finish())
                .setRightLayoutClickListener(v -> {
                    saveData();
                });

        iebInterveneDoctor.setRightIvOnClickerListener(v -> {

            new SelectDataDialog(this, null, new SelectDataDialog.getSelectDataInterFace() {
                @Override
                public void getSelectData(String data) {
                    if (!TextUtils.isEmpty(data)) {
                        iebInterveneDoctor.setEditContent(data.substring(0, data.length() - 1));
                    } else {
                        iebInterveneDoctor.setEditContent("");
                    }
                }
            }).showDialog();
        });

        iebInterveneNurse.setRightIvOnClickerListener(v -> {

            new SelectDataDialog(this, null, new SelectDataDialog.getSelectDataInterFace() {
                @Override
                public void getSelectData(String data) {
                    if (!TextUtils.isEmpty(data)) {
                        iebInterveneNurse.setEditContent(data.substring(0, data.length() - 1));
                    } else {
                        iebInterveneNurse.setEditContent("");
                    }
                }
            }).showDialog();
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    private void showData() {
        if (data == null) {
            return;
        }
        tvStartCatheter.setTime(data.getEnabledsaroombegintime());
        rgDirectdsaroom.check("1".equals(data.getDirectdsaroom()) ? R.id.rb_directdsaroom_yes : R.id.rb_directdsaroom_no);
        tvSelectCatheter.setText(data.getEmbolectomyroom());
        iebInterveneDoctor.setEditContent(data.getEmbolectomypatientsurgerydoctor());
        iebInterveneNurse.setEditContent(data.getEmbolectomypatientsurgerynurse());
        ttbActivationCathActStroke.setTime(data.getActivedsaroomtime());
        ttbPatientArrivalActStroke.setTime(data.getPatientarriveddsaroomtime());
        ttbArriveToArrived.setTime(data.getArrivetoarriveddsaroomtime());
        ttbArriveToArrived.setVisibility(TextUtils.isEmpty(data.getArrivetoarriveddsaroomtime()) ? View.GONE : View.VISIBLE);
        iebRemark.setEditContent(data.getEmbolectomyremark());

    }

    private PreoperativePreparationInfoRequestBean getSavedData() {
        PreoperativePreparationInfoRequestBean savedData = new PreoperativePreparationInfoRequestBean();
        //启动导管室
        savedData.setEnabledsaroombegintime(tvStartCatheter.getTime());
        //直达导管室
        savedData.setDirectdsaroom(rgDirectdsaroom.getCheckedRadioButtonId() == R.id.rb_directdsaroom_yes ? "1" : "-1");
        //TODO 手术室修改
        savedData.setEmbolectomyroom("卒中介入手术室");
        //介入医生
        savedData.setEmbolectomypatientsurgerydoctor(iebInterveneDoctor.getEditContent());
        //介入护士
        savedData.setEmbolectomypatientsurgerynurse(iebInterveneNurse.getEditContent());
        //激活导管室
        savedData.setActivedsaroomtime(ttbActivationCathActStroke.getTime());
        //患者到达导管室
        savedData.setPatientarriveddsaroomtime(ttbPatientArrivalActStroke.getTime());
        //到院至到达导管室
        //        savedData.setArrivetoarriveddsaroomtime(ttbArriveToArrived.getTime());
        //手术备注信息
        savedData.setEmbolectomyremark(iebRemark.getEditContent());

        return savedData;
    }

    private void saveData() {
        BaseRequestBean<PreoperativePreparationInfoRequestBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, getSavedData());

        RetrofitClient.getInstance().getApi()
                .savePreoperativePreparation(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast(R.string.http_tip_data_save_success);
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


    private void getData() {
        BaseRequestBean<PreoperativePreparationInfoBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new PreoperativePreparationInfoBean());

        RetrofitClient.getInstance()
                .getApi()
                .getPreoperativePreparation(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<PreoperativePreparationInfoBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<PreoperativePreparationInfoBean>> call, Response<BaseResponseBean<PreoperativePreparationInfoBean>> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("获取数据成功");
                                if (response.body().getData() != null) {
                                    data = response.body().getData().getData();
                                    showData();
                                }

                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<PreoperativePreparationInfoBean>> call, Throwable t) {
                        LogUtils.d(call.toString());
                        showToast(call.toString());
                    }
                });
    }


}

    
    
       
