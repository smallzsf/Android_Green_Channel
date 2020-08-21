package com.xyj.strokeaid.activity.newapoplexy;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseMvpActivity;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.NewAppplexyInfoBean;
import com.xyj.strokeaid.contract.NewApoplexyInfoContract;
import com.xyj.strokeaid.presenter.LoginPresenter;
import com.xyj.strokeaid.presenter.NewApoplexyInfoPresenter;
import com.xyj.strokeaid.view.BaseTitleBar;
import com.xyj.strokeaid.view.editspinner.EditSpinner;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
/**
 * @Package:     com.xyj.strokeaid.activity.newapoplexy
 * @ClassName:   NewApoplexyInfoActivity
 * @Description: 新建卒中患者信息界面
 * @Autho:       王水雷
 * @Time: 2020/8/19
 */

public class NewApoplexyInfoActivity extends BaseMvpActivity<NewApoplexyInfoPresenter> implements NewApoplexyInfoContract.View {

    @BindView(R.id.bt_title)
    BaseTitleBar btTitle;
    @BindView(R.id.btn_connect_patient_info)
    Button btnConnectPatientInfo;//关联患者信息
    @BindView(R.id.et_patient_no)
    EditText etPatientNo;//腕带编号
    @BindView(R.id.et_patient_name)
    TextView etPatientName;//病人名字
    @BindView(R.id.et_patient_age)
    EditText etPatientAge;//患者年龄
    @BindView(R.id.et_patient_height)
    EditText etPatientHeight; //身高
    @BindView(R.id.et_patient_weight)
    EditText etPatientWeight; //重量
    @BindView(R.id.et_patient_identity)
    EditText etPatientIdentity;//身份证号
    @BindView(R.id.et_medical_card_num)
    EditText etMedicalCardNum; //医保卡号
    @BindView(R.id.et_see_doctor_id)
    EditText etSeeDoctorId;//就诊ID
    @BindView(R.id.et_contract_name)
    EditText etContractName;//联系人姓名
    @BindView(R.id.et_contract_phone)
    EditText etContractPhone;//联系人手机号
    @BindView(R.id.btn_save_join)
    Button btnSaveJoin;//保存并加入路径
    @BindView(R.id.es_nation)
    EditSpinner esNation;//民族
    @BindView(R.id.rg_sex)
    RadioGroup radioGroup;//性别
    String mCurrentSex="1";//1男 2女
    @Override
    public int getLayoutId() {
        return R.layout.activity_new_apoplexy_info;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView(){

        mPresenter = new NewApoplexyInfoPresenter();
        mPresenter.attachView(this);

        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("EditSpinner");
        list.add("WrBug");
        list.add("Test");
        list.add("123456789");
        list.add("123456788");
        list.add("123456777");
        list.add("123456666");
        list.add("123455555");
        list.add("123444444");
        list.add("123333333");
        list.add("122222222");
        esNation.setItemData(list);
    }
    @Override
    public void initListener() {
        btTitle.setCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.rb_sex_normal:
                        mCurrentSex = "1";
                        break;
                    case R.id.rb_sex_male:
                        mCurrentSex = "2";
                        break;
                }
            }
        });
    }
    @Override
    public void showData(BaseObjectBean<NewAppplexyInfoBean> bean) {

    }

    @Override
    public void onLoadSaveSuccess(String msg) {
        if(!StringUtils.isEmpty(msg)){
            ToastUtils.showLong(msg);
            finish();
        }
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @Override
    public void onError(String errMessage) {

    }
    @OnClick({R.id.btn_connect_patient_info, R.id.btn_save_join})
    public void onViewClicked(View view) {
        switch (view.getId()){
            //关联患者信息
            case R.id.btn_connect_patient_info:
                startActivity(new Intent(mContext,RelationPatientInfoActivity.class));
                break;
            //保存并加入路径
            case R.id.btn_save_join:
                getNewApoplexyInfoItemStr();
                break;
        }
    }
    /**
     *  获取新建卒中条目内容
     */
    private void getNewApoplexyInfoItemStr(){
        String patientNo = etPatientNo.getText().toString().trim();
        String name = etPatientName.getText().toString().trim();
        String age = etPatientAge.getText().toString().trim();
        String height = etPatientHeight.getText().toString().trim();
        String weight= etPatientWeight.getText().toString().trim();
        String identity = etPatientIdentity.getText().toString().trim();
        String medicalCardNum= etMedicalCardNum.getText().toString().trim();//医保卡号
        String seeDoctorId= etSeeDoctorId.getText().toString().trim();//就诊ID
        String contractName = etContractName.getText().toString().trim();//联系人
        String contractPhone = etContractPhone.getText().toString().trim();//联系人电话
        if(StringUtils.isEmpty(patientNo)){
            ToastUtils.showLong("腕带编号不能为空");
            return;
        }
        if(StringUtils.isEmpty(name)){
            ToastUtils.showLong("姓名不能为空");
            return;
        }
        if(StringUtils.isEmpty(age)){
            ToastUtils.showLong("年龄不能为空");
            return;
        }
        if(StringUtils.isEmpty(height)){
            ToastUtils.showLong("身高不能为空");
            return;
        }
        if(StringUtils.isEmpty(weight)){
            ToastUtils.showLong("体重不能为空");
            return;
        }
        if(StringUtils.isEmpty(identity)){
            ToastUtils.showLong("身份证号不能为空");
            return;
        }

        if(StringUtils.isEmpty(medicalCardNum)){
            ToastUtils.showLong("医保卡号不能为空");
            return;
        }
        if(StringUtils.isEmpty(seeDoctorId)){
            ToastUtils.showLong("就诊ID不能为空");
            return;
        }
        if(StringUtils.isEmpty(contractName)){
            ToastUtils.showLong("联系人不能为空");
            return;
        }
        if(StringUtils.isEmpty(contractPhone)){
            ToastUtils.showLong("联系人电话不能为空");
            return;
        }
        mPresenter.saveAndJoinData(patientNo,name,age,mCurrentSex,height,weight,"",identity,medicalCardNum,seeDoctorId,contractName,contractPhone);
    }
}