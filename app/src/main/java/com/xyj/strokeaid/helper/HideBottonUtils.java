package com.xyj.strokeaid.helper;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;

import com.xyj.strokeaid.http.RetrofitClient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Description:公共底部button显示隐藏
 * @Author: crq
 * @CreateDate: 2020/9/1 11:04
 */
public class HideBottonUtils {


    private static volatile HideBottonUtils instance;

    private HideBottonUtils() {
    }

    public static HideBottonUtils getInstance() {
        if (instance == null) {
            synchronized (HideBottonUtils.class) {
                if (instance == null) {
                    instance = new HideBottonUtils();
                }
            }
        }
        return instance;
    }


    /**
     * 设置点击输入框显示隐藏底部bottom
     *
     * @return
     */
    public void getHideBotton(View view, View view1) {
        if (view!=null&&view1!=null){
            view.getViewTreeObserver().

                    addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                        private int mMaxSrollHeight;

                        @Override
                        public void onGlobalLayout() {
                            Rect rect = new Rect();
                            //1、获取main在窗体的可视区域
                            view.getWindowVisibleDisplayFrame(rect);
                            //2、获取main在窗体的不可视区域高度，在键盘没有弹起时，main.getRootView().getHeight()调节度应该和rect.bottom高度一样
                            int mainInvisibleHeight = view.getRootView().getHeight() - rect.bottom;
                            int screenHeight = view.getRootView().getHeight();//屏幕高度
                            //3、不可见区域大于屏幕本身高度的1/4：说明键盘弹起了
                            int[] location = new int[2];
                            view.getLocationInWindow(location);
                            View slContentActLogin;
                            if (mainInvisibleHeight > screenHeight / 4) {
                 /*   // 4､获取Scroll的窗体坐标，算出main需要滚动的高度
                    int srollHeight = (location[1] + llVitalSigns.getHeight()) - rect.bottom;
                    mMaxSrollHeight = Math.max(mMaxSrollHeight, screenHeight);
                    //5､让界面整体上移键盘的高度
                    llBottom.scrollTo(0, 0);
                    llBottom.setOnTouchListener((v, event) -> true);*/
                                view1.setVisibility(View.GONE);
                            } else {
                /*    boolean isSoftKeyBoradShow = false;
                    //3、不可见区域小于屏幕高度1/4时,说明键盘隐藏了，把界面下移，移回到原有高度
                    llBottom.scrollTo(0, 0);
                    llBottom.setOnTouchListener((v, event) -> false);*/
                                view1.setVisibility(View.VISIBLE);
                            }
                        }
                    });
        }


    }

}
