package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseObjectBean;
import com.xyj.strokeaid.bean.BaseRequestBean;
import com.xyj.strokeaid.bean.BaseResponseBean;
import com.xyj.strokeaid.bean.DiseaseRecordRequest;
import com.xyj.strokeaid.bean.RequestGetDiseaseRecordBean;
import com.xyj.strokeaid.distutil.DistListUtil;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.http.RetrofitClient;
import com.xyj.strokeaid.http.gson.GsonUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * DiseaseRecordFragment
 * description: 病情记录
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class DiseaseRecordFragment extends BaseFragment {
    @BindView(R.id.et_major_complaint_frag)
    EditText etMajorComplaintFrag;
    @BindView(R.id.tfl_action_in_chief)
    TagFlowLayout tflActionInChief;
    @BindView(R.id.app_tv_conditon_record)
    TextView appTvConditonRecord;
    @BindView(R.id.et_symptom)
    EditText etSymptom;
    @BindView(R.id.id_flow_layout)
    TagFlowLayout idFlowLayout;
    @BindView(R.id.et_medical_history)
    EditText etMedicalHistory;
    @BindView(R.id.tfl_medical_history)
    TagFlowLayout tflMedicalHistory;
    @BindView(R.id.tfl_anticoagulant_drug)
    TagFlowLayout tflAnticoagulantDrug;
    @BindView(R.id.tfl_anticoagulant_drug1)
    TagFlowLayout tflAnticoagulantDrug1;
    @BindView(R.id.tfl_anticoagulant_drug2)
    TagFlowLayout tflAnticoagulantDrug2;
    @BindView(R.id.tfl_anticoagulant_drug3)
    TagFlowLayout tflAnticoagulantDrug3;
    @BindView(R.id.tfl_anticoagulant_drug4)
    TagFlowLayout tflAnticoagulantDrug4;
    @BindView(R.id.et_drugallergy)
    EditText etDrugallergy;
    @BindView(R.id.et_conditionre_mark)
    EditText etConditionreMark;
    @BindView(R.id.btn_get_data)
    AppCompatButton btnGetData;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.llVitalSigns)
    LinearLayout llVitalSigns;

    //主诉值
    private String[] mVals = new String[]{"发现", "突发", "被发现", "右侧肢体无力", "左侧肢体无力", "人事不清", "头晕、行走不稳", "言语障碍", "（）小时", "（）天", "加重（）小时"};
    //既往史值
    private String[] mVals1 = new String[]{"TIA（）", "脑梗死", "脑出血", "蛛网膜下腔出血", "高血压（）年", "血压最高（）mmHg", "糖尿病（）年", "血脂异常", "冠心病", "先天性心脏病", "瓣膜性心脏病", "扩张型心肌病", "心律失常", "心房纤颤", "外周动脉疾病", "手术史（）", "颅外伤史（）", "肿瘤病史（）", "生育史（）子女", "吸烟（ ）年", "（）包/天", "饮酒（ ）年", "白酒/啤酒", "（）两/瓶/天"};
    //既往病史值
    private String[] mVals2 = new String[]{"阿司匹林", "氯吡格雷", "替格普洛", "西洛他唑"};
    private String[] mVals3 = new String[]{"华法林", "利伐沙班", "达比加群"};
    private String[] mVals4 = new String[]{"利尿剂", "β受体阻滞剂", "钙拮抗剂", "ACEI", "ARB"};
    private String[] mVals5 = new String[]{"胰岛素", "磺酰脲类", "双胍类", "α糖苷酶抑制剂", "胰岛素增敏剂", "非磺酰脲类促胰岛素分泌剂"};
    private String[] mVals6 = new String[]{"他汀类", "烟酸及其衍生物", "贝特类", "胆固醇吸收抑制剂"};

    private String mRecordId;
    RequestGetDiseaseRecordBean mRequestGetDiseaseRecordBean;
    private List<String> selectMedicaldrughistory = new ArrayList<>();;
    TagAdapter<String> adapter;
    public DiseaseRecordFragment() {
    }

    public static DiseaseRecordFragment newInstance(String recordId) {
        DiseaseRecordFragment fragment = new DiseaseRecordFragment();
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
    public int getLayoutId() {
        return R.layout.fragment_disease_record;
    }

    @Override
    protected void initView(@NonNull View view) {
        getDiseaseRecord(mRecordId);
    }


    @Override
    public void onResume() {
        super.onResume();
        View llBottom = getActivity().findViewById(R.id.ll_bottom);
        HideBottonUtils.getInstance().getHideBotton(llVitalSigns, llBottom);
    }
    List<String> kxxbyKeyDataList;
    List<String> knyKeyDataList;
    List<String> JjyKeyDataList;
    List<String> JtyKeyDataList;
    List<String> JzyKeyDataList;

    List<String> kxxbyValueDataList;
    List<String> knyValueDataList;
    List<String> JjyValueDataList;
    List<String> JtyValueDataList;
    List<String> JzyValueDataList;
    @Override
    public void initListener() {
        //设置主诉值
        getEtTransferReason(tflActionInChief, etMajorComplaintFrag, mVals, null);
        //设置既往值
        getEtTransferReason(tflMedicalHistory, etMedicalHistory, mVals1, null);
        //抗血小板药、抗凝药、降压药、降糖药、降脂药
//        getEtTransferReason(tflAnticoagulantDrug, null, mVals2);
        DistListUtil distListUtilKxxby = new DistListUtil(context);
        distListUtilKxxby.initGenderMap(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kxxby);
        kxxbyKeyDataList = distListUtilKxxby.getKeyDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kxxby);
        kxxbyValueDataList = distListUtilKxxby.getValueDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kxxby);
        String[] kxxbyKey = new String[kxxbyKeyDataList.size()];
        getEtTransferReason(tflAnticoagulantDrug, null,kxxbyKeyDataList.toArray(kxxbyKey) ,kxxbyValueDataList);

        DistListUtil distListUtilKny = new DistListUtil(context);
        distListUtilKny.initGenderMap(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kny);
        knyKeyDataList = distListUtilKny.getKeyDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kny);
        knyValueDataList = distListUtilKny.getValueDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_kny);
        String[] knyKey = new String[knyKeyDataList.size()];
        getEtTransferReason(tflAnticoagulantDrug1, null,knyKeyDataList.toArray(knyKey), knyValueDataList);

        DistListUtil distListUtilJjy = new DistListUtil(context);
        distListUtilJjy.initGenderMap(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jyy);
        JjyKeyDataList = distListUtilJjy.getKeyDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jyy);
        JjyValueDataList = distListUtilJjy.getValueDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jyy);
        String[] JjyKey = new String[JjyKeyDataList.size()];
        getEtTransferReason(tflAnticoagulantDrug2, null, JjyKeyDataList.toArray(JjyKey), JjyValueDataList);

        DistListUtil distListUtilJty = new DistListUtil(context);
        distListUtilJty.initGenderMap(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jty);
        JtyKeyDataList = distListUtilJty.getKeyDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jty);
        JtyValueDataList = distListUtilJty.getValueDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jty);
        String[] JtyKey = new String[JtyKeyDataList.size()];
        getEtTransferReason(tflAnticoagulantDrug3, null, JtyKeyDataList.toArray(JtyKey), JtyValueDataList);

        DistListUtil distListUtilJzy = new DistListUtil(context);
        distListUtilJzy.initGenderMap(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jzy);
        JzyKeyDataList = distListUtilJzy.getKeyDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jzy);
        JzyValueDataList = distListUtilJzy.getValueDataList(R.array.stroke_medicaldrughistory_cpc_jwyysbxx_jzy);
        String[] JzyKey = new String[JzyKeyDataList.size()];
        getEtTransferReason(tflAnticoagulantDrug4, null,  JzyKeyDataList.toArray(JzyKey), JzyValueDataList);
        btnGetData.setOnClickListener(v -> {
            getDiseaseRecord(mRecordId);
        });

        btnConfirm.setOnClickListener(v -> {
            Log.e("TAG", "btnConfirm: "+new Gson().toJson(selectMedicaldrughistory));
            RequestGetDiseaseRecordBean requestGetDiseaseRecordBean = new RequestGetDiseaseRecordBean();
            requestGetDiseaseRecordBean.setRecordId(mRecordId);
            requestGetDiseaseRecordBean.setChiefcomplaint(etMajorComplaintFrag.getText().toString());
            requestGetDiseaseRecordBean.setSymptom(etSymptom.getText().toString());
            requestGetDiseaseRecordBean.setMedicalhistory(etMedicalHistory.getText().toString());
            requestGetDiseaseRecordBean.setMedicaldrughistory(listToString(selectMedicaldrughistory));
            requestGetDiseaseRecordBean.setDrugallergy(etDrugallergy.getText().toString());
            requestGetDiseaseRecordBean.setConditionremark(etConditionreMark.getText().toString());

            saveDiseaseRecord(requestGetDiseaseRecordBean);
        });
    }

    public static String listToString(List<String> stringList){
        if (stringList==null) {
            return "";
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

    /**
     * 病情记录保存
     * @param requestGetDiseaseRecordBean
     */
    private void saveDiseaseRecord(RequestGetDiseaseRecordBean requestGetDiseaseRecordBean) {
        BaseRequestBean<RequestGetDiseaseRecordBean> baseRequestBean =
                new BaseRequestBean<>(mRecordId, 1, requestGetDiseaseRecordBean);

        RetrofitClient.getInstance()
                .getApi()
                .editStrokeVitalSigns(baseRequestBean.getResuestBody(baseRequestBean))
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

    /**
     * 获取病理记录数据
     */
    private void getDiseaseRecord(String mRecordId) {
        showLoadingDialog();
        BaseRequestBean<RequestGetDiseaseRecordBean> baseRequestBean = new BaseRequestBean<>(
                mRecordId, 1, new RequestGetDiseaseRecordBean());

        RetrofitClient.getInstance()
                .getApi()
                .GetDiseaseRecordInfo(baseRequestBean.getResuestBody(baseRequestBean))
                .enqueue(new Callback<BaseResponseBean<RequestGetDiseaseRecordBean>>() {
                    @Override
                    public void onResponse(Call<BaseResponseBean<RequestGetDiseaseRecordBean>> call,
                                           Response<BaseResponseBean<RequestGetDiseaseRecordBean>> response) {
                        hideLoadingDialog();
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                mRequestGetDiseaseRecordBean = response.body().getData().getData();
                                if (mRequestGetDiseaseRecordBean != null) {
                                    etMajorComplaintFrag.setText(mRequestGetDiseaseRecordBean.getChiefcomplaint());
                                    etSymptom.setText(mRequestGetDiseaseRecordBean.getSymptom());
                                    etMedicalHistory.setText(mRequestGetDiseaseRecordBean.getMedicalhistory());

                                    //既往用药史回显
                                    if (!TextUtils.isEmpty(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                        //先判断是不是多个选项
                                        if (mRequestGetDiseaseRecordBean.getMedicaldrughistory().contains(",")){
                                            String[] medicaldrughistory = mRequestGetDiseaseRecordBean.getMedicaldrughistory().split(",");
                                            for (int i = 0; i < medicaldrughistory.length; i++) {
                                                selectMedicaldrughistory.add(medicaldrughistory[i]);
                                            }
                                            //拆分成数组准备循环
                                            String[] medicaldrughistoryStr =  mRequestGetDiseaseRecordBean.getMedicaldrughistory().split(",");
                                            //声明list准备记录哪些被选择了

                                            List<Integer> kxxbyList = new ArrayList<>();
                                            List<Integer> knyList = new ArrayList<>();
                                            List<Integer> JjyList = new ArrayList<>();
                                            List<Integer> JtyList = new ArrayList<>();
                                            List<Integer> JzyList = new ArrayList<>();
                                            //通过选择的字段和本地所有字段去对比，得到本地的位置
                                            for (int i = 0; i < medicaldrughistoryStr.length; i++) {
                                                if (kxxbyValueDataList.contains(medicaldrughistoryStr[i])){
                                                    for (int i1 = 0; i1 < kxxbyValueDataList.size(); i1++) {
                                                        if ( medicaldrughistoryStr[i].equals(kxxbyValueDataList.get(i1))){
                                                            kxxbyList.add(i1);
                                                        }
                                                    }
//
                                                }else if (knyValueDataList.contains(medicaldrughistoryStr[i])){
                                                    for (int i1 = 0; i1 < knyValueDataList.size(); i1++) {
                                                        if (medicaldrughistoryStr[i].equals(knyValueDataList.get(i1))){
                                                            knyList.add(i1);
                                                        }
                                                    }
                                                }else if (JjyValueDataList.contains(medicaldrughistoryStr[i])){
                                                    for (int i1 = 0; i1 < JjyValueDataList.size(); i1++) {
                                                        if (medicaldrughistoryStr[i].equals(JjyValueDataList.get(i1))){
                                                            JjyList.add(i1);
                                                        }
                                                    }
                                                }else if (JtyValueDataList.contains(medicaldrughistoryStr[i])){

                                                    for (int i1 = 0; i1 < JtyValueDataList.size(); i1++) {
                                                        if (medicaldrughistoryStr[i].equals(JtyValueDataList.get(i1))){
                                                            JtyList.add(i1);
                                                        }

                                                    }
                                                }else if (JzyValueDataList.contains(medicaldrughistoryStr[i])){
                                                    for (int i1 = 0; i1 < JzyValueDataList.size(); i1++) {
                                                        if ( medicaldrughistoryStr[i].equals(JzyValueDataList.get(i1))){
                                                            JzyList.add(i1);
                                                        }
                                                    }
                                                }
                                            }
                                            //将list转成int数组
                                            int[] kxxbyarr =new int[kxxbyList.size()];
                                            int[] knyarr =new int[knyList.size()];
                                            int[] Jjyarr =new int[JjyList.size()];
                                            int[] Jtyarr =new int[JtyList.size()];
                                            int[] jzyarr =new int[JzyList.size()];

                                            for (int i = 0; i < kxxbyList.size(); i++) {
                                                kxxbyarr[i] = kxxbyList.get(i);
                                            }
                                            for (int i = 0; i < knyList.size(); i++) {
                                                knyarr[i] = knyList.get(i);
                                            }
                                            for (int i = 0; i < JjyList.size(); i++) {
                                                Jjyarr[i] = JjyList.get(i);
                                            }
                                            for (int i = 0; i < JtyList.size(); i++) {
                                                Jtyarr[i] = JtyList.get(i);
                                            }
                                            for (int i = 0; i < JzyList.size(); i++) {
                                                jzyarr[i] = JzyList.get(i);
                                            }
                                            //回显
                                            tflAnticoagulantDrug.getAdapter().setSelectedList(kxxbyarr);
                                            tflAnticoagulantDrug1.getAdapter().setSelectedList(knyarr);
                                            tflAnticoagulantDrug2.getAdapter().setSelectedList(Jjyarr);
                                            tflAnticoagulantDrug3.getAdapter().setSelectedList(Jtyarr);
                                            tflAnticoagulantDrug4.getAdapter().setSelectedList(jzyarr);
                                        }else {
                                            selectMedicaldrughistory.add(mRequestGetDiseaseRecordBean.getMedicaldrughistory());
                                            //通过选择的字段和本地所有字段去对比，得到本地的位置

                                            if (kxxbyValueDataList.contains(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                                int kxxbyint=0 ;
                                                for (int i1 = 0; i1 < kxxbyValueDataList.size(); i1++) {
                                                    if ( mRequestGetDiseaseRecordBean.getMedicaldrughistory().equals(kxxbyValueDataList.get(i1))){
                                                        kxxbyint=i1;
                                                    }
                                                }
                                                //回显
                                                tflAnticoagulantDrug.getAdapter().setSelectedList(kxxbyint);

                                            }else if (knyValueDataList.contains(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                                int knyint = 0 ;
                                                for (int i1 = 0; i1 < knyValueDataList.size(); i1++) {
                                                    if ( mRequestGetDiseaseRecordBean.getMedicaldrughistory().equals(knyValueDataList.get(i1))){
                                                        knyint=i1;
                                                    }
                                                }
                                                tflAnticoagulantDrug1.getAdapter().setSelectedList(knyint);

                                            }else if (JjyValueDataList.contains(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                                int Jjyint =0;
                                                for (int i1 = 0; i1 < JjyValueDataList.size(); i1++) {
                                                    if (mRequestGetDiseaseRecordBean.getMedicaldrughistory().equals(JjyValueDataList.get(i1))){
                                                        Jjyint=i1;
                                                    }
                                                }
                                                tflAnticoagulantDrug2.getAdapter().setSelectedList(Jjyint);

                                            } else if (JtyValueDataList.contains(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                                int Jtyint = 0;
                                                for (int i1 = 0; i1 < JtyValueDataList.size(); i1++) {
                                                    if (mRequestGetDiseaseRecordBean.getMedicaldrughistory().equals(JtyValueDataList.get(i1))){
                                                        Jtyint=i1;
                                                    }

                                                }
                                                tflAnticoagulantDrug3.getAdapter().setSelectedList(Jtyint);

                                            }else if (JzyValueDataList.contains(mRequestGetDiseaseRecordBean.getMedicaldrughistory())){
                                                int jzyint = 0;
                                                for (int i1 = 0; i1 < JzyValueDataList.size(); i1++) {
                                                    if (mRequestGetDiseaseRecordBean.getMedicaldrughistory().equals(JzyValueDataList.get(i1))){
                                                        jzyint=i1;
                                                    }
                                                }
                                                tflAnticoagulantDrug4.getAdapter().setSelectedList(jzyint);
                                            }

                                        }
                                    }
                                    selectMedicaldrughistory =  delRepeat(selectMedicaldrughistory);
                                    etDrugallergy.setText(mRequestGetDiseaseRecordBean.getDrugallergy());
                                    etConditionreMark.setText(mRequestGetDiseaseRecordBean.getConditionremark());

                                }
                            } else {
                                showToast(TextUtils.isEmpty(response.body().getMessage())
                                        ? getString(R.string.http_tip_data_save_error)
                                        : response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponseBean<RequestGetDiseaseRecordBean>> call, Throwable t) {
                        hideLoadingDialog();
                        showToast(R.string.http_tip_server_error);
                    }
                });
    }

    // 遍历后判断赋给另一个list集合，保持原来顺序
    public static List<String> delRepeat(List<String> list) {
        List<String> listNew = new ArrayList<String>();
        for (String str : list) {
            if (!listNew.contains(str)) {
                listNew.add(str);
            }
        }
        return listNew ;
    }
    private void getEtTransferReason(TagFlowLayout tfl, EditText et, String[] mVals, List<String> valueDataList) {


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
                    selectMedicaldrughistory.add(valueDataList.get(position));
                }

                @Override
                public void unSelected(int position, View view) {
                    super.unSelected(position, view);
                    view.setBackground(getResources().getDrawable(R.drawable.selector_flow_layout_nomal_bg));
                    selectMedicaldrughistory.remove(valueDataList.get(position));

                }
            });


        }

    }


    /**
     * 病情记录添加add
     */
    private void diseaseRecordAdd(DiseaseRecordRequest.DiseaseRecordAdd diseaseRecordAdd) {
        String request = GsonUtils.getGson().toJson(diseaseRecordAdd);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordAdd(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }

    /**
     * 病情记录修改
     */
    private void diseaseRecordUpate(DiseaseRecordRequest.DiseaseRecordUpdate diseaseRecordUpdate) {
        String request = GsonUtils.getGson().toJson(diseaseRecordUpdate);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordUpdate(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }

    /**
     * 病情评估根据recordId删除
     */
    private void diseaseRecordDeleteByRecordId(DiseaseRecordRequest.DiseaseRecordDeleteByRecordId diseaseRecordDeleteByRecordId) {
        String request = GsonUtils.getGson().toJson(diseaseRecordDeleteByRecordId);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordDeleteByRecordid(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }


    /**
     * 病情评估先删后插
     */
    private void diseaseRecordEdit(DiseaseRecordRequest.DiseaseRecordEdit diseaseRecordEdit) {
        String request = GsonUtils.getGson().toJson(diseaseRecordEdit);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordEdit(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }


    /**
     * 病情评估获取
     */
    private void diseaseRecordGet(DiseaseRecordRequest.DiseaseRecordGet diseaseRecordGet) {
        String request = GsonUtils.getGson().toJson(diseaseRecordGet);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordGet(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }


    /**
     * 病情评估根据recordid获取
     */
    private void diseaseRecordGetByRecordid(DiseaseRecordRequest.DiseaseRecordGetByRecordId diseaseRecordGetByRecordid) {
        String request = GsonUtils.getGson().toJson(diseaseRecordGetByRecordid);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
        RetrofitClient
                .getInstance()
                .getApi()
                .diseaseRecordGetByRecordid(requestBody)
                .enqueue(new Callback<BaseObjectBean>() {
                    @Override
                    public void onResponse(Call<BaseObjectBean> call, Response<BaseObjectBean> response) {
                        if (response.body() != null) {
                            if (response.body().getResult() == 1) {
                                showToast("保存数据成功");
                                // TODO
                            } else {
                                showToast(response.body().getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseObjectBean> call, Throwable t) {

                    }
                });
    }


}