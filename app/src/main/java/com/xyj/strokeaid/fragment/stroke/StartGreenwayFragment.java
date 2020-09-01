package com.xyj.strokeaid.fragment.stroke;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.adapter.StrokeHosRvAdapter;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.StrokeHosBean;
import com.xyj.strokeaid.helper.HideBottonUtils;
import com.xyj.strokeaid.view.SelectDataDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * StartGreenwayFragment
 * description: 启动绿道
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StartGreenwayFragment extends BaseFragment {

    @BindView(R.id.btn_start_frag_sg)
    AppCompatButton btnStartFragSg;
    @BindView(R.id.ll_start_greenway)
    LinearLayout llStartGreenway;
    @BindView(R.id.tv_emergency_ward)
    TextView tvEmergencyWard;
    @BindView(R.id.tv_neurology)
    TextView tvNeurology;
    @BindView(R.id.tv_duct_branch)
    TextView tvDuctBranch;
    @BindView(R.id.tv_ct)
    TextView tvCt;
    @BindView(R.id.tv_electrocardiographic_room)
    TextView tvElectrocardiographicRoom;
    @BindView(R.id.tv_clinical_lab)
    TextView tvClinicalLab;
    @BindView(R.id.et_emergency_ward)
    EditText etEmergencyWard;
    @BindView(R.id.et_neurology)
    EditText etNeurology;
    @BindView(R.id.et_duct_branch)
    EditText etDuctBranch;
    @BindView(R.id.et_ct)
    EditText etCt;
    @BindView(R.id.et_electrocardiographic_room)
    EditText etElectrocardiographicRoom;
    @BindView(R.id.et_clinical_lab)
    EditText etClinicalLab;
    /* @BindView(R.id.rv_hos_frag_sg)
         RecyclerView rvHosFragSg;
         @BindView(R.id.btn_start_frag_sg)
         AppCompatButton btnStart;
     */
    private String mPatientId;
    private String mDocId;

    private StrokeHosRvAdapter mStrokeHosRvAdapter;
    private List<StrokeHosBean> mStrokeHosBeans;

    public StartGreenwayFragment() {
        // Required empty public constructor
    }

    public static StartGreenwayFragment newInstance(String patientId, String docId) {
        StartGreenwayFragment fragment = new StartGreenwayFragment();
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

        HideBottonUtils.getInstance().getHideBotton(llStartGreenway, btnStartFragSg);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_start_greenway;
    }

    @Override
    protected void initView(@NonNull View view) {
  /*      mStrokeHosBeans = new ArrayList<>();
        mStrokeHosBeans.add(new StrokeHosBean("郑州卒中中心医院", "0371-99986666"));
        mStrokeHosBeans.add(new StrokeHosBean("安阳卒中中心医院", "0372-99986666"));
        mStrokeHosBeans.add(new StrokeHosBean("新乡卒中中心医院", "0373-99986666"));

        mStrokeHosRvAdapter = new StrokeHosRvAdapter(R.layout.adapter_rv_stroke_hos_item, mStrokeHosBeans);

        rvHosFragSg.setLayoutManager(new LinearLayoutManager(mActivity));
        rvHosFragSg.setAdapter(mStrokeHosRvAdapter);
        mStrokeHosRvAdapter.setEmptyView(R.layout.view_empty_for_rv);*/


    }

    @Override
    protected void initListener() {
       /* btnStart.setOnClickListener(v -> {
            showToast("发送成功~");
        });

        mStrokeHosRvAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                if (view.getId() == R.id.iv_call_item_stroke_hos) {
                    CallUtils.callPhone(mStrokeHosBeans.get(position).getPhone(), mActivity);
                }
            }
        });

        mStrokeHosRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                for (StrokeHosBean strokeHosBean : mStrokeHosBeans) {
                    strokeHosBean.setChecked(false);
                }
                mStrokeHosBeans.get(position).setChecked(!mStrokeHosBeans.get(position).isChecked());
                mStrokeHosRvAdapter.notifyDataSetChanged();
            }
        });*/
    }

    @OnClick({R.id.tv_emergency_ward, R.id.tv_neurology, R.id.tv_duct_branch, R.id.tv_ct, R.id.tv_electrocardiographic_room, R.id.btn_start_frag_sg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_emergency_ward:

                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etEmergencyWard.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.tv_neurology:

                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etNeurology.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.tv_duct_branch:

                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etDuctBranch.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.tv_ct:
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etCt.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.tv_electrocardiographic_room:
                new SelectDataDialog(getContext(), null, new SelectDataDialog.getSelectDataInterFace() {
                    @Override
                    public void getSelectData(String data) {
                        etElectrocardiographicRoom.setText(data);
                    }
                }).showDialog();

                break;
            case R.id.btn_start_frag_sg:

                break;
        }
    }
}