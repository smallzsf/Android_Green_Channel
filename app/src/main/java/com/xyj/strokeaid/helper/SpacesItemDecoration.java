package com.xyj.strokeaid.helper;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.IntDef;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * SpacesItemDecoration
 * description: recycle view 间隔
 *
 * @author : Licy
 * @date : 2019/8/2
 * email ：licy3051@qq.com
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int left = 0;
    private int top = 0;
    private int right = 0;
    private int bottom = 0;
    private int orientation;

    @Documented
    @IntDef({LinearLayout.HORIZONTAL, LinearLayout.VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {

    }


    public SpacesItemDecoration(int left, int top, int right, int bottom, @OrientationMode int orientation) {
        this.left = SizeUtils.dp2px(left);
        this.top = SizeUtils.dp2px(top);
        this.right = SizeUtils.dp2px(right);
        this.bottom = SizeUtils.dp2px(bottom);
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // Add top margin only for the first item to avoid double space between items
        if (orientation == LinearLayout.HORIZONTAL) {
            // 横向
            outRect.top = top;
            outRect.bottom = bottom;
            outRect.right = right / 2;
            if (parent.getChildAdapterPosition(view) != 0) {
                // 后面的
                outRect.left = left / 2;
            } else {
                // 第一个
                outRect.left = left;
            }
        } else {
            // 纵向
            outRect.left = left;
            outRect.right = right;
            outRect.bottom = bottom / 2;
            if (parent.getChildAdapterPosition(view) != 0) {
                // 后面的
                outRect.top = top / 2;
            } else {
                // 第一个
                outRect.top = top;
            }
        }
    }
}
