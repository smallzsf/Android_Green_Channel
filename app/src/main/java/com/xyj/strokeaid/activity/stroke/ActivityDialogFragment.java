package com.xyj.strokeaid.activity.stroke;

import android.os.Build;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * ActivityDialogFragment
 * description: TODO
 *
 * @author : crq
 * @date : 2020/8/20
 */
public class ActivityDialogFragment extends DialogFragment {

    @Override
    public void show(FragmentManager manager, String tag) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            if (manager.isDestroyed()) {
                return;
            }
        }
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager.beginTransaction().remove(this).commit();
            super.show(manager, tag);
        } catch (Exception e) {
            //同一实例使用不同的tag会异常，这里捕获一下
            e.printStackTrace();
        }
    }
}