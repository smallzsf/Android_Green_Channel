package com.xyj.strokeaid.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Nullable;


/**
 * 自定义弹框
 */
public class SelectDataDialog extends Dialog {
    private Context context;
    private AlertDialog.Builder builder;
    private static String[] data = {"Aa", "Bb", "Cc", "Dd", "Ee"};
    private boolean[] state = {false, false, false, false, false};
    private String selectData = "";
    private getSelectDataInterFace interFace;

    /**
     * 初始化数据
     *
     * @param context                上下文对象
     * @param data                   数据
     * @param getSelectDataInterFace 返回数据的接口
     */
    public SelectDataDialog(Context context, String[] data, getSelectDataInterFace getSelectDataInterFace) {
        super(context);
        this.context = context;
        interFace = getSelectDataInterFace;
        if (data != null && data.length > 0) {
            this.data = data;
            initDataState(data);
        }
    }

    public SelectDataDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    /**
     * 初始化数据状态
     *
     * @param data 数据
     */
    private void initDataState(String[] data) {
        state = new boolean[data.length];
        for (int i = 0, sum = data.length; i < sum; i++) {
            state[i] = false;
        }
    }


    public void showDialog() {
        builder = new AlertDialog.Builder(context);
        builder.setTitle("请选择");
        builder.setMultiChoiceItems(data, state, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    selectData += data[which].toString() + ",";
                }
            }
        });
        builder.setPositiveButton("提交", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (interFace != null) {
                    interFace.getSelectData(selectData);
                }
            }
        });
        builder.create().show();
    }

    public interface getSelectDataInterFace {
        void getSelectData(String data);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        super.setOnDismissListener(listener);

    }

//    private void startAnimation() {
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.umcsdk_anim_loading);
//        ivProgress.startAnimation(animation);
//    }
//
//    private void endAnimation() {
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.umcsdk_anim_loading);
//        animation.cancel();
//    }
}