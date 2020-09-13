package com.xyj.strokeaid.fragment.stroke;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.stroke.EmergencyCenterStrokeAneurysmSurgeryPoBean;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.view.ItemEditBar;
import com.xyj.strokeaid.view.MyRadioGroup;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 动脉瘤新增弹窗
 */
public class StrokeAneurysmAddDialogFragment extends DialogFragment {

    @BindView(R.id.rb_left)
    RadioButton rbLeft;
    @BindView(R.id.rb_right)
    RadioButton rbRight;
    @BindView(R.id.rg_side)
    RadioGroup rgSide;
    @BindView(R.id.rb_ica)
    RadioButton rbIca;
    @BindView(R.id.rb_pcoma)
    RadioButton rbPcoma;
    @BindView(R.id.rb_acha)
    RadioButton rbAcha;
    @BindView(R.id.rb_aca)
    RadioButton rbAca;
    @BindView(R.id.rb_acoma)
    RadioButton rbAcoma;
    @BindView(R.id.rb_mca)
    RadioButton rbMca;
    @BindView(R.id.rb_va)
    RadioButton rbVa;
    @BindView(R.id.rb_ba)
    RadioButton rbBa;
    @BindView(R.id.rb_pca)
    RadioButton rbPca;
    @BindView(R.id.rb_aica)
    RadioButton rbAica;
    @BindView(R.id.rb_pica)
    RadioButton rbPica;
    @BindView(R.id.rb_sca)
    RadioButton rbSca;
    @BindView(R.id.rb_other)
    RadioButton rbOther;
    @BindView(R.id.ieb_other)
    ItemEditBar iebOther;
    @BindView(R.id.rg_position)
    MyRadioGroup rgPosition;
    @BindView(R.id.rb_ica_jd)
    RadioButton rbIcaJd;
    @BindView(R.id.rb_ica_yd)
    RadioButton rbIcaYd;
    @BindView(R.id.rb_ica_plkd)
    RadioButton rbIcaPlkd;
    @BindView(R.id.rb_ica_hmdd)
    RadioButton rbIcaHmdd;
    @BindView(R.id.rb_ica_ctd)
    RadioButton rbIcaCtd;
    @BindView(R.id.rb_ica_ydmd)
    RadioButton rbIcaYdmd;
    @BindView(R.id.rb_ica_jtdmd)
    RadioButton rbIcaJtdmd;
    @BindView(R.id.rg_ica)
    MyRadioGroup rgIca;
    @BindView(R.id.ll_ica)
    LinearLayout llIca;
    @BindView(R.id.rb_aca_a1)
    RadioButton rbAcaA1;
    @BindView(R.id.rb_aca_a2)
    RadioButton rbAcaA2;
    @BindView(R.id.rb_aca_a3)
    RadioButton rbAcaA3;
    @BindView(R.id.rb_aca_a4)
    RadioButton rbAcaA4;
    @BindView(R.id.rb_aca_a5)
    RadioButton rbAcaA5;
    @BindView(R.id.rg_aca)
    MyRadioGroup rgAca;
    @BindView(R.id.ll_aca)
    LinearLayout llAca;
    @BindView(R.id.rb_mca_m1)
    RadioButton rbMcaM1;
    @BindView(R.id.rb_mca_m2)
    RadioButton rbMcaM2;
    @BindView(R.id.rb_mca_m3)
    RadioButton rbMcaM3;
    @BindView(R.id.rb_mca_m4)
    RadioButton rbMcaM4;
    @BindView(R.id.rb_mca_m5)
    RadioButton rbMcaM5;
    @BindView(R.id.rb_mca_dnzdm)
    RadioButton rbMcaDnzdm;
    @BindView(R.id.rg_mca)
    MyRadioGroup rgMca;
    @BindView(R.id.ll_mca)
    LinearLayout llMca;
    @BindView(R.id.rb_va_v1)
    RadioButton rbVaV1;
    @BindView(R.id.rb_va_v2)
    RadioButton rbVaV2;
    @BindView(R.id.rb_va_v3)
    RadioButton rbVaV3;
    @BindView(R.id.rb_va_v4)
    RadioButton rbVaV4;
    @BindView(R.id.rb_va_v5)
    RadioButton rbVaV5;
    @BindView(R.id.rg_va)
    MyRadioGroup rgVa;
    @BindView(R.id.ll_va)
    LinearLayout llVa;
    @BindView(R.id.rb_ba_dd)
    RadioButton rbBaDd;
    @BindView(R.id.rb_ba_zg)
    RadioButton rbBaZg;
    @BindView(R.id.rg_ba)
    MyRadioGroup rgBa;
    @BindView(R.id.ll_ba)
    LinearLayout llBa;
    @BindView(R.id.rb_pca_p1)
    RadioButton rbPcaP1;
    @BindView(R.id.rb_pca_p2)
    RadioButton rbPcaP2;
    @BindView(R.id.rb_pca_p3)
    RadioButton rbPcaP3;
    @BindView(R.id.rb_pca_p4)
    RadioButton rbPcaP4;
    @BindView(R.id.rg_pca)
    MyRadioGroup rgPca;
    @BindView(R.id.ll_pca)
    LinearLayout llPca;
    @BindView(R.id.ieb_length)
    ItemEditBar iebLength;
    @BindView(R.id.ieb_width)
    ItemEditBar iebWidth;
    @BindView(R.id.ieb_height)
    ItemEditBar iebHeight;
    @BindView(R.id.ieb_radius)
    ItemEditBar iebRadius;
    @BindView(R.id.rb_type_sx)
    RadioButton rbTypeSx;
    @BindView(R.id.rb_type_nz)
    RadioButton rbTypeNz;
    @BindView(R.id.rb_type_jc)
    RadioButton rbTypeJc;
    @BindView(R.id.rb_type_jjxdml)
    RadioButton rbTypeJjxdml;
    @BindView(R.id.rg_type)
    MyRadioGroup rgType;
    @BindView(R.id.ll_type)
    LinearLayout llType;
    @BindView(R.id.btn_save)
    AppCompatButton btnSave;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;

    private String mRecordId;
    private String mType;
    EmergencyCenterStrokeAneurysmSurgeryPoBean emergencyCenterStrokeAneurysmSurgeryPoBean;



    public static StrokeAneurysmAddDialogFragment newInstance(String recordId, String tag,EmergencyCenterStrokeAneurysmSurgeryPoBean emergencyCenterStrokeAneurysmSurgeryPoBean) {
        StrokeAneurysmAddDialogFragment fragment = new StrokeAneurysmAddDialogFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.RECORD_ID, recordId);
        args.putString(IntentKey.ANEURYSMTYPE, tag);
        args.putSerializable(IntentKey.ANEURYSM,emergencyCenterStrokeAneurysmSurgeryPoBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
            mType = getArguments().getString(IntentKey.ANEURYSMTYPE);
            Log.e("TAG", "onCreate: "+mType );
            if (TextUtils.equals(mType,"add")){

            }else if (TextUtils.equals(mType,"edit")){
                if ( getArguments().getSerializable(IntentKey.ANEURYSM)!=null){
                    emergencyCenterStrokeAneurysmSurgeryPoBean = (EmergencyCenterStrokeAneurysmSurgeryPoBean) getArguments().getSerializable(IntentKey.ANEURYSM);
                }
            }

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        final Window window = getDialog().getWindow();
        //需要用android.R.id.content这个view
        View inflate = inflater.inflate(R.layout.pop_add_aneurysmoperationpart, container, false);
        ButterKnife.bind(this, inflate);
        initListener();
        if (TextUtils.equals(mType,"edit")){
            setViewData();
        }else {
            emergencyCenterStrokeAneurysmSurgeryPoBean = new EmergencyCenterStrokeAneurysmSurgeryPoBean(mRecordId,"","","","","","","","","","","","","","","","","","","");
        }
        return inflate;
    }

    private void setViewData() {
        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmside(),"cpc_aneurysmSide_left")){
            rbLeft.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmside(),"cpc_aneurysmSide_right")){
            rbRight.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_jndm")){
            rbIca.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_hjtdm")){
            rbPcoma.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_mlmqdm")){
            rbAcha.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_dnqdm")){
            rbAca.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_qjtdm")){
            rbAcoma.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_dnzdm")){
            rbMca.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_zdm")){
            rbVa.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_jddm")){
            rbBa.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_dnhdmpca")){
            rbPca.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_xnqxdm")){
            rbAica.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_xnhxdm")){
            rbPica.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_xnsdm")){
            rbSca.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpart(),"cpc_aneurysmPart_qt")){
            rbOther.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_jd")){
            rbIcaJd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_yd")){
            rbIcaYd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_plkd")){
            rbIcaPlkd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_hmdd")){
            rbIcaHmdd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_ctd")){
            rbIcaCtd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_ydmd")){
            rbIcaYdmd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmica(),"cpc_aneurysmPartICA_jtdmd")){
            rbIcaJtdmd.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmaca(),"cpc_aneurysmPartACA_a1")){
            rbAcaA1.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmaca(),"cpc_aneurysmPartACA_a2")){
            rbAcaA2.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmaca(),"cpc_aneurysmPartACA_a3")){
            rbAcaA3.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmaca(),"cpc_aneurysmPartACA_a4")){
            rbAcaA4.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmaca(),"cpc_aneurysmPartACA_a5")){
            rbAcaA5.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmmca(),"cpc_aneurysmPartMCA_m1")){
            rbMcaM1.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmmca(),"cpc_aneurysmPartMCA_m2")){
            rbMcaM2.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmmca(),"cpc_aneurysmPartMCA_m3")){
            rbMcaM3.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmmca(),"cpc_aneurysmPartMCA_m4")){
            rbMcaM4.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmmca(),"cpc_aneurysmPartMCA_m5")){
            rbMcaM5.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmva(),"cpc_aneurysmPartVA_v1")){
            rbVaV1.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmva(),"cpc_aneurysmPartVA_v2")){
            rbVaV2.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmva(),"cpc_aneurysmPartVA_v3")){
            rbVaV3.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmva(),"cpc_aneurysmPartVA_v4")){
            rbVaV4.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmva(),"cpc_aneurysmPartVA_v5")){
            rbVaV5.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmba(),"cpc_aneurysmPartBA_dd")){
            rbBaDd.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmba(),"cpc_aneurysmPartBA_zg")){
            rbBaZg.setChecked(true);
        }
        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpca(),"cpc_aneurysmPartPCA_p1")){
            rbPcaP1.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpca(),"cpc_aneurysmPartPCA_p2")){
            rbPcaP2.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpca(),"cpc_aneurysmPartPCA_p3")){
            rbPcaP3.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmpca(),"cpc_aneurysmPartPCA_p4")){
            rbPcaP4.setChecked(true);
        }

        if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmtype(),"cpc_aneurysmType_sx")){
            rbTypeSx.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmtype(),"cpc_aneurysmType_nz")){
            rbTypeNz.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmtype(),"cpc_aneurysmType_jc")){
            rbTypeJc.setChecked(true);
        }else if (TextUtils.equals(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmtype(),"cpc_aneurysmType_jxdml")){
            rbTypeJjxdml.setChecked(true);
        }

        iebOther.setEditContent(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmotherpart());
        iebLength.setEditContent(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmlength());
        iebWidth.setEditContent(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmwidth());
        iebHeight.setEditContent(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmheight());
        iebRadius.setEditContent(emergencyCenterStrokeAneurysmSurgeryPoBean.getAneurysmradius());


    }

    private void initListener() {
        rgSide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_left:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmside("cpc_aneurysmSide_left");
                        break;
                    case R.id.rb_right:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmside("cpc_aneurysmSide_right");
                        break;
                }
            }
        });
        rgPosition.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_ica://"颈内动脉ICA
                        llIca.setVisibility(View.VISIBLE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_jndm");

                        break;
                    case R.id.rb_pcoma://后交通动脉PComA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_hjtdm");
                        break;
                    case R.id.rb_acha://脉络膜前动脉AChA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_mlmqdm");
                        break;
                    case R.id.rb_aca://大脑前动脉ACA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.VISIBLE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_dnqdm");
                        break;
                    case R.id.rb_acoma://前交通动脉AcomA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_qjtdm");
                        break;
                    case R.id.rb_mca://大脑中动脉MCA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.VISIBLE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_dnzdm");
                        break;
                    case R.id.rb_va://椎动脉VA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.VISIBLE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_zdm");
                        break;
                    case R.id.rb_ba://基底动脉BA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.VISIBLE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_jddm");
                        break;
                    case R.id.rb_pca://大脑后动脉PCA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.VISIBLE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_dnhdmpca");
                        break;
                    case R.id.rb_aica://小脑前下动脉AICA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_xnqxdm");
                        break;
                    case R.id.rb_pica://小脑后下动脉PICA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_xnhxdm");
                        break;
                    case R.id.rb_sca://小脑上动脉SCA
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_xnsdm");
                        break;
                    case R.id.rb_other://其他
                        llIca.setVisibility(View.GONE);
                        llAca.setVisibility(View.GONE);
                        llMca.setVisibility(View.GONE);
                        llVa.setVisibility(View.GONE);
                        llBa.setVisibility(View.GONE);
                        llPca.setVisibility(View.GONE);
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpart("cpc_aneurysmPart_qt");
                        break;
                }
            }
        });
        rgIca.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_ica_jd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_jd");
                        break;
                    case R.id.rb_ica_yd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_yd");
                        break;
                    case R.id.rb_ica_plkd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_plkd");
                        break;
                    case R.id.rb_ica_hmdd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_hmdd");
                        break;
                    case R.id.rb_ica_ctd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_ctd");
                        break;
                    case R.id.rb_ica_ydmd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_ydmd");
                        break;
                    case R.id.rb_ica_jtdmd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmica("cpc_aneurysmPartICA_jtdmd");
                        break;
                }
            }
        });
        rgAca.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_aca_a1:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmaca("cpc_aneurysmPartACA_a1");
                        break;
                    case R.id.rb_aca_a2:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmaca("cpc_aneurysmPartACA_a2");
                        break;
                    case R.id.rb_aca_a3:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmaca("cpc_aneurysmPartACA_a3");
                        break;
                    case R.id.rb_aca_a4:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmaca("cpc_aneurysmPartACA_a4");
                        break;
                    case R.id.rb_aca_a5:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmaca("cpc_aneurysmPartACA_a5");
                        break;
                }
            }
        });
        rgMca.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_mca_m1:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("cpc_aneurysmPartMCA_m1");
                        break;
                    case R.id.rb_mca_m2:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("cpc_aneurysmPartMCA_m2");
                        break;
                    case R.id.rb_mca_m3:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("cpc_aneurysmPartMCA_m3");
                        break;
                    case R.id.rb_mca_m4:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("cpc_aneurysmPartMCA_m4");
                        break;
                    case R.id.rb_mca_m5:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("cpc_aneurysmPartMCA_m5");
                        break;
                    default:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmmca("");
                        break;
                }
            }
        });
        rgVa.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_va_v1:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmva("cpc_aneurysmPartVA_v1");
                        break;
                    case R.id.rb_va_v2:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmva("cpc_aneurysmPartVA_v2");
                        break;
                    case R.id.rb_va_v3:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmva("cpc_aneurysmPartVA_v3");
                        break;
                    case R.id.rb_va_v4:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmva("cpc_aneurysmPartVA_v4");
                        break;
                    case R.id.rb_va_v5:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmva("cpc_aneurysmPartVA_v5");
                        break;
                }
            }
        });
        rgBa.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_ba_dd:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmba("cpc_aneurysmPartBA_dd");
                        break;
                    case R.id.rb_ba_zg:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmba("cpc_aneurysmPartBA_zg");
                        break;
                }
            }
        });
        rgPca.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pca_p1:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpca("cpc_aneurysmPartPCA_p1");
                        break;
                    case R.id.rb_pca_p2:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpca("cpc_aneurysmPartPCA_p2");
                        break;
                    case R.id.rb_pca_p3:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpca("cpc_aneurysmPartPCA_p3");
                        break;
                    case R.id.rb_pca_p4:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmpca("cpc_aneurysmPartPCA_p4");
                        break;
                }
            }
        });
        rgType.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_type_sx:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmtype("cpc_aneurysmType_sx");
                        break;
                    case R.id.rb_type_nz:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmtype("cpc_aneurysmType_nz");
                        break;
                    case R.id.rb_type_jc:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmtype("cpc_aneurysmType_jc");
                        break;
                    case R.id.rb_type_jjxdml:
                        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmtype("cpc_aneurysmType_jxdml");
                        break;
                }
            }
        });
        btnSave.setOnClickListener(v -> {
            getViewData();
        });
        btnCancel.setOnClickListener(v -> {
           dismiss();
        });

    }
    private void getViewData() {
        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmlength(iebLength.getEditContent());
        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmheight(iebHeight.getEditContent());
        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmwidth(iebWidth.getEditContent());
        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmradius(iebRadius.getEditContent());
        emergencyCenterStrokeAneurysmSurgeryPoBean.setAneurysmotherpart(iebOther.getEditContent());
        if (getTargetFragment()==null){
            return ;
        }
        Intent intent = new Intent();
        if (TextUtils.equals(mType,"add")){
            intent.putExtra("ADD", (Serializable) emergencyCenterStrokeAneurysmSurgeryPoBean);
            //获得目标Fragment,并将数据通过onActivityResult放入到intent中进行传值
            getTargetFragment().onActivityResult(StrokArterialAneurysmFragment.REUEST_CODDE_ADD, Activity.RESULT_OK, intent);
        }else if (TextUtils.equals(mType,"edit")){
            intent.putExtra("EDIT", (Serializable) emergencyCenterStrokeAneurysmSurgeryPoBean);
            //获得目标Fragment,并将数据通过onActivityResult放入到intent中进行传值
            getTargetFragment().onActivityResult(StrokArterialAneurysmFragment.REUEST_CODDE_EDIT, Activity.RESULT_OK, intent);
        }

        dismiss();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}
