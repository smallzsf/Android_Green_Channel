package com.xyj.strokeaid.fragment.chestpain;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.view.editspinner.EditSpinner;

import java.util.Arrays;

import butterknife.BindView;


/**
 * @ClassName: OriginalDiagnoseFragment
 * @Description:
 * @Author: 小黑
 * @Date: 2020/9/2 19:09
 */
public class OriginalDiagnoseFragment extends BaseFragment {

    @BindView(R.id.es_title_select)
    EditSpinner esTitleSelect;
    @BindView(R.id.fl_content_frag_od)
    FrameLayout flContentFragOd;

    private DiagnoseStemiFragment mStemiFragment;
    private DiagnoseNstemiAndUaFragment mNstemiFragment;
    private DiagnoseNstemiAndUaFragment mUaFragment;
    private DiagnoseZdmjcFragment mZdmjcFragment;
    private DiagnoseFdmssFragment mFdmssFragment;
    private DiagnoseNonAcsFragment mNonAcsFragment;
    private DiagnoseNonHeartPainFragment mNonHeartPainFragment;
    private DiagnoseWaitDiagnoseFragment mWaitDiagnoseFragment;
    private BaseFragment mCurrentFragment;

    private String mRecordId;

    public OriginalDiagnoseFragment() {

    }

    public static OriginalDiagnoseFragment newInstance(String recordId) {
        OriginalDiagnoseFragment fragment = new OriginalDiagnoseFragment();
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
        return R.layout.fragment_original_diagnose;
    }

    @Override
    protected void initView(@NonNull View view) {

        esTitleSelect.setItemData(Arrays.asList(getResources().getStringArray(R.array.original_diagnose)));
    }

    @Override
    protected void initListener() {
        esTitleSelect.setOnSelectIndexAndStringLitner(new EditSpinner.OnSelectIndexAndStringLitner() {
            @Override
            public void getSeletedStringAndIndex(String text, int position) {
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                if (mCurrentFragment != null) {
                    fragmentTransaction.hide(mCurrentFragment);
                }
                switch (position) {
                    case 0:
                        // STEMI
                        if (mStemiFragment == null) {
                            mStemiFragment = DiagnoseStemiFragment.newInstance(mRecordId, "cpc_cbzdv2_stemi");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mStemiFragment);
                        break;
                    case 1:
                        // NSTEMI
                        if (mNstemiFragment == null) {
                            mNstemiFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_nstemi");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNstemiFragment);
                        break;
                    case 2:
                        // UA
                        if (mUaFragment == null) {
                            mUaFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_ua");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mUaFragment);
                        break;
                    case 3:
                        // NSTEMI
                        if (mZdmjcFragment == null) {
                            mZdmjcFragment = DiagnoseZdmjcFragment.newInstance(mRecordId, "cpc_cbzdv2_zdmjc");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mZdmjcFragment);
                        break;
                    case 4:
                        // NSTEMI
                        if (mFdmssFragment == null) {
                            mFdmssFragment = DiagnoseFdmssFragment.newInstance(mRecordId, "cpc_cbzdv2_fdmss");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mFdmssFragment);
                        break;
                    case 5:
                        // NSTEMI
                        if (mNonAcsFragment == null) {
                            mNonAcsFragment = DiagnoseNonAcsFragment.newInstance(mRecordId, "cpc_cbzdv2_facsxyxxt");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNonAcsFragment);
                        break;
                    case 6:
                        // NSTEMI
                        if (mNonHeartPainFragment == null) {
                            mNonHeartPainFragment = DiagnoseNonHeartPainFragment.newInstance(mRecordId, "cpc_cbzdv2_facsxyxxt");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mNonHeartPainFragment);
                        break;
                    case 7:
                        // NSTEMI
                        if (mWaitDiagnoseFragment == null) {
                            mWaitDiagnoseFragment = DiagnoseWaitDiagnoseFragment.newInstance(mRecordId, "cpc_cbzdv2_dc");
                        }
                        fragmentTransaction.replace(R.id.fl_content_frag_od, mWaitDiagnoseFragment);
                        break;
                    default:
                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }

}
