package com.xyj.strokeaid.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Checkable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.xyj.strokeaid.R;

/**
 * XyjCheckedTextView
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/28
 * email ：licy3051@qq.com
 */
public class XyjCheckedTextView extends AppCompatTextView implements Checkable {

    private boolean checked = false;

    public XyjCheckedTextView(@NonNull Context context) {
        super(context);
    }

    public XyjCheckedTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XyjCheckedTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setChecked(boolean checked) {
        if (this.checked == checked) {
            return;
        }
        if (checked) {
            this.checked = true;
            this.setBackground(new ColorDrawable(Color.WHITE));
            this.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            this.checked = false;
            this.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.color_EEEEEE)));
            this.setTextColor(getContext().getResources().getColor(R.color.color_222222));
        }
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}

    
    
       
    