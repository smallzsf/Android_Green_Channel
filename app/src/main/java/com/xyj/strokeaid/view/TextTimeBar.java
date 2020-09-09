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

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.helper.CalendarUtils;

import java.util.Calendar;
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

    /**
     * 时间显示类型
     */
    private int timeType = CalendarUtils.TYPE_ALL;
    private TimePickerView mTimePickerView;

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

        tvTimeViewTtb.setOnClickListener(v -> {
            Calendar startTime = Calendar.getInstance();
            startTime.set(1900, 0, 1);
            if (mTimePickerView == null) {
                mTimePickerView = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String time = CalendarUtils.parseDate(timeType, date);
                        LogUtils.d(time);
                        tvTimeViewTtb.setText(time);
                    }
                })
                        .isDialog(false)
                        .setType(new boolean[]{true, true, true, true, true, true})
                        .setRangDate(startTime, Calendar.getInstance())
                        .setOutSideCancelable(true)
                        .build();
            }
            if (mTimePickerView.isShowing()) {
                mTimePickerView.dismiss();
            }
            mTimePickerView.show();
        });
    }

    public void setTimeZoneClickListener(OnClickListener listener) {
        if (listener != null) {
            tvTimeViewTtb.setOnClickListener(listener);
        }
    }

    public void setTime(String time) {
        if (tvTimeViewTtb != null) {
            if (TextUtils.isEmpty(time)) {
                tvTimeViewTtb.setText("");
            } else {
                tvTimeViewTtb.setText(time);
            }
        }
    }

    /**
     * 设置转换的时间戳格式， 默认显示 yyyy-MM-dd HH:mm:ss
     * @param type
     */
    public void setTimeType(@CalendarUtils.FormatType int type) {
        this.timeType = type;
    }

    public String getTime() {
        String time = "";
        if (tvTimeViewTtb != null) {
            if (!TextUtils.isEmpty(tvTimeViewTtb.getText().toString())) {
                return tvTimeViewTtb.getText().toString();
            }
        }
        return time;
    }

    public void setTitle(String title) {
        tvTitleViewTtb.setText(title);
    }

    public void setTitle(CharSequence sequence) {
        tvTitleViewTtb.setText(sequence);
    }

    public void setTopLineVisible(boolean visible) {
        if (viewTopLineViewTtb != null) {
            viewTopLineViewTtb.setVisibility(visible ? VISIBLE : GONE);
        }
    }

    public void setBottomLineVisible(boolean visible) {
        if (viewBottomLineViewTtb != null) {
            viewBottomLineViewTtb.setVisibility(visible ? VISIBLE : GONE);
        }
    }
}

    
    
       
    