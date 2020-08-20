package com.xyj.strokeaid.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.xyj.strokeaid.app.IntentKey;

/**
 * TipsDialogFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/20
 * email ：licy3051@qq.com
 */
public class TipsDialogFragment extends DialogFragment {

    private String mDialogMsg;
    private Context mContext;
    private onButtonClickListener mOnButtonClickListener;

    public void setOnButtonClickListener(onButtonClickListener onButtonClickListener) {
        mOnButtonClickListener = onButtonClickListener;
    }

    private TipsDialogFragment() {
        super();
    }

    public static TipsDialogFragment newInstance(String tips) {
        TipsDialogFragment fragment = new TipsDialogFragment();
        Bundle args = new Bundle();
        args.putString(IntentKey.DIALOG_MSG, tips);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDialogMsg = getArguments().getString(IntentKey.DIALOG_MSG);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog alertDialog;

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mOnButtonClickListener != null) {
                            mOnButtonClickListener.onConfirmClicked();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mOnButtonClickListener != null) {
                            mOnButtonClickListener.onCancelClicked();
                        }
                        dialog.dismiss();
                    }
                })
                .setMessage(mDialogMsg);

        alertDialog = builder.create();

        return alertDialog;
    }

    /**
     *
     */
    public interface onButtonClickListener {
        /**
         *
         */
        void onConfirmClicked();

        /**
         *
         */
        void onCancelClicked();
    }
}

    
    
       
    