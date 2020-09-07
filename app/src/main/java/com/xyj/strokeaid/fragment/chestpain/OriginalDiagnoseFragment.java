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

    private FragmentTransaction mFragmentTransaction = null;
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
        mFragmentTransaction = getChildFragmentManager().beginTransaction();
        esTitleSelect.setItemData(Arrays.asList(getResources().getStringArray(R.array.original_diagnose)));
    }

    @Override
    protected void initListener() {
        esTitleSelect.setOnSelectIndexAndStringLitner(new EditSpinner.OnSelectIndexAndStringLitner() {
            @Override
            public void getSeletedStringAndIndex(String text, int position) {
                switch (position) {
                    case 0:
                        // STEMI
                        if (mStemiFragment == null) {
                            mStemiFragment = DiagnoseStemiFragment.newInstance(mRecordId, "cpc_cbzdv2_stemi");
                        }
                        if (mCurrentFragment == null) {
                            mCurrentFragment = mStemiFragment;
                            mFragmentTransaction.add(R.id.fl_content_frag_od, mStemiFragment).commitNow();
                        } else {
                            mFragmentTransaction.hide(mCurrentFragment).show(mStemiFragment).commitNow();;
                            mCurrentFragment = mStemiFragment;
                        }
                        break;

                    case 1:
                        // NSTEMI
                        if (mNstemiFragment == null) {
                            mNstemiFragment = DiagnoseNstemiAndUaFragment.newInstance(mRecordId, "cpc_cbzdv2_nstemi");
                        }
                        if (mCurrentFragment == null) {
                            mCurrentFragment = mNstemiFragment;
                            mFragmentTransaction.add(R.id.fl_content_frag_od, mNstemiFragment).commitNow();
                        } else {
                            mFragmentTransaction.hide(mCurrentFragment).show(mNstemiFragment).commitNow();
                            mCurrentFragment = mNstemiFragment;
                        }
                        break;

                    default:
                        break;
                }
            }
        });
    }

}
