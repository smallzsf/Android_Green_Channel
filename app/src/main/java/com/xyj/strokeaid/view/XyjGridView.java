package com.xyj.strokeaid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * XyjGridView
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/7
 * email ：licy3051@qq.com
 */
public class XyjGridView extends GridView {
    public XyjGridView(Context context) {
        super(context);
    }

    public XyjGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XyjGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public XyjGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

    
    
       
    