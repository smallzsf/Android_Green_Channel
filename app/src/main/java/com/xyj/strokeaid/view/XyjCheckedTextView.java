package com.xyj.strokeaid.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RadioButton;

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
    private OnCheckedChangeListener mOnCheckedChangeListener;

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
            this.setBackground(new ColorDrawable(getContext().getResources().getColor(R.color.colorPrimary22)));
            this.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            this.checked = false;
            this.setBackground(new ColorDrawable(Color.WHITE));
            this.setTextColor(getContext().getResources().getColor(R.color.color_222222));
        }
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, this.checked);
        }
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
    }

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return mOnCheckedChangeListener;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        mOnCheckedChangeListener = onCheckedChangeListener;
    }

    /**
     * Interface definition for a callback to be invoked when the checked state
     * of a compound button changed.
     */
    public interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        void onCheckedChanged(AppCompatTextView buttonView, boolean isChecked);
    }
}

    
    
       
    