package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.xyj.strokeaid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TextSwitchBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
public class TextSwitchBar extends LinearLayout {

    @BindView(R.id.tv_content_view_tsb)
    TextView tvContentViewTsb;
    @BindView(R.id.sc_view_tsb)
    SwitchCompat scViewTsb;

    public TextSwitchBar(Context context) {
        this(context, null);

    }

    public TextSwitchBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextSwitchBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TextSwitchBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_text_switch_bar, this);
        ButterKnife.bind(this, view);

        parseStyle(context, attrs);
    }

    private void parseStyle(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextSwitchBar);

            String title = ta.getString(R.styleable.TextSwitchBar_tsb_title);
            tvContentViewTsb.setText(title);
            boolean scStatus = ta.getBoolean(R.styleable.TextSwitchBar_tsb_switch, false);
            scViewTsb.setChecked(scStatus);

            ta.recycle();
        }
    }

    public void setSwitch(boolean status) {
        if (scViewTsb != null) {
            scViewTsb.setChecked(status);
        }
    }

    public void setContent(String content) {
        if (tvContentViewTsb != null && content != null) {
            tvContentViewTsb.setText(content);
        }
    }

    public void setSwitchClickListener(CompoundButton.OnCheckedChangeListener listener){
        if (scViewTsb != null) {
            scViewTsb.setOnCheckedChangeListener(listener);
        }
    }

}

    
    
       
    