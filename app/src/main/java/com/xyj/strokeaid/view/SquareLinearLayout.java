package com.xyj.strokeaid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * SquareLinearLayout
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/5
 * email ：licy3051@qq.com
 */
public class SquareLinearLayout extends LinearLayout {

    public SquareLinearLayout(Context context) {
        super(context);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));
        // 设置布局的高度跟宽度相同
        int childWidthSize = getMeasuredWidth();
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

    
    
       
    