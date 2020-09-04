package com.xyj.strokeaid.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.xyj.strokeaid.R;

/**
 * LoadingDialogFragment
 * description: 通用加载中dialog
 *
 * @author : Licy
 * @date : 2020/9/2
 * email ：licy3051@qq.com
 */
public class LoadingDialogFragment extends DialogFragment {

    public LoadingDialogFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_loading, container, false);
        if (getDialog() != null) {
            getDialog().setCancelable(false);
            getDialog().setCanceledOnTouchOutside(false);
        }
        return view;
    }
}

    
    
       
    