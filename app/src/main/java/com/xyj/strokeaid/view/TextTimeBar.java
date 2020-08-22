package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;
import com.xyj.strokeaid.helper.CalendarUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TextTimeBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
public class TextTimeBar extends RelativeLayout {

    @BindView(R.id.tv_title_view_ttb)
    TextView tvTitleViewTtb;
    @BindView(R.id.tv_time_view_ttb)
    TextView tvTimeViewTtb;
    @BindView(R.id.iv_refresh_view_ttb)
    ImageView ivRefreshViewTtb;
    @BindView(R.id.view_top_line_view_ttb)
    View viewTopLineViewTtb;
    @BindView(R.id.view_bottom_line_view_ttb)
    View viewBottomLineViewTtb;

    public TextTimeBar(Context context) {
        this(context, null);
    }

    public TextTimeBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextTimeBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TextTimeBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_text_time_bar, this);
        ButterKnife.bind(this, view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextTimeBar);

        boolean topLine = typedArray.getBoolean(R.styleable.TextTimeBar_topLineVisible, false);
        boolean bottomLine = typedArray.getBoolean(R.styleable.TextTimeBar_bottomLineVisible, false);
        viewTopLineViewTtb.setVisibility(topLine ? VISIBLE : GONE);
        viewBottomLineViewTtb.setVisibility(bottomLine ? VISIBLE : GONE);

        String title = typedArray.getString(R.styleable.TextTimeBar_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitleViewTtb.setText(title);
        }
        String hint = typedArray.getString(R.styleable.TextTimeBar_ttb_time_hint);
        if (!TextUtils.isEmpty(hint)) {
            tvTimeViewTtb.setHint(hint);
        }
        String time = typedArray.getString(R.styleable.TextTimeBar_ttb_time);
        if (!TextUtils.isEmpty(time)) {
            tvTimeViewTtb.setText(time);
        }
        typedArray.recycle();

        ivRefreshViewTtb.setOnClickListener(v -> {
            String now = CalendarUtils.parseDate(CalendarUtils.TYPE_ALL, new Date());
            tvTimeViewTtb.setText(now);
        });

    }

    public void setTimeZoneClickListener(OnClickListener listener) {
        if (listener != null) {
            tvTitleViewTtb.setOnClickListener(listener);
        }
    }

}

    
    
       
    