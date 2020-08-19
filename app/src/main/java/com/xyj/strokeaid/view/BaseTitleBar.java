package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.xyj.strokeaid.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 标题栏
 *
 * @author licy
 * @date 2020/03/01
 */
public class BaseTitleBar extends RelativeLayout {


    @BindView(R.id.iv_left_base_title_bar)
    ImageView ivLeftBaseTitleBar;
    @BindView(R.id.tv_title_base_title_bar)
    TextView tvTitleBaseTitleBar;
    @BindView(R.id.iv_right_base_title_bar)
    ImageView ivRightBaseTitleBar;
    @BindView(R.id.tv_right_base_title_bar)
    TextView tvRightBaseTitleBar;
    @BindView(R.id.view_bottom_line_title_bar)
    View viewBottomLineTitleBar;
    @BindView(R.id.cl_root_title_bar)
    ConstraintLayout clRootTitleBar;
    @BindView(R.id.iv_close_base_title_bar)
    ImageView ivCloseBaseTitleBar;

    public BaseTitleBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    public BaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseTitleBar(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_base_title_bar, this);
        ButterKnife.bind(this, view);

        parseStyle(context, attrs);
    }

    private void parseStyle(Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BaseTitleBar);

            String title = ta.getString(R.styleable.BaseTitleBar_title);
            if (!TextUtils.isEmpty(title)) {
                tvTitleBaseTitleBar.setText(title);
            }
            if (ta.hasValue(R.styleable.BaseTitleBar_titleColor)) {
                tvTitleBaseTitleBar.setTextColor(ta.getColor(R.styleable.BaseTitleBar_titleColor, 0));
            }

            if (ta.getBoolean(R.styleable.BaseTitleBar_btb_closeIconVisible, false)) {
                ivCloseBaseTitleBar.setVisibility(VISIBLE);
            } else {
                ivCloseBaseTitleBar.setVisibility(GONE);
            }

            if (ta.getBoolean(R.styleable.BaseTitleBar_leftIconVisible, true)) {
                // 默认true
                ivLeftBaseTitleBar.setVisibility(VISIBLE);
                if (ta.hasValue(R.styleable.BaseTitleBar_leftIcon)) {
                    ivLeftBaseTitleBar.setImageResource(ta.getResourceId(R.styleable.BaseTitleBar_leftIcon, R.drawable.common_icon_left_arrow_white));
                } else {
                    ivLeftBaseTitleBar.setImageResource(R.drawable.common_icon_left_arrow_white);
                }
            } else {
                // 不显示
                ivLeftBaseTitleBar.setVisibility(INVISIBLE);
            }


            if (ta.getBoolean(R.styleable.BaseTitleBar_rightIconVisible, false)) {
                ivRightBaseTitleBar.setVisibility(VISIBLE);
                if (ta.hasValue(R.styleable.BaseTitleBar_rightIcon)) {
                    ivRightBaseTitleBar.setImageResource(ta.getResourceId(R.styleable.BaseTitleBar_rightIcon, R.drawable.common_icon_right_more));
                } else {
                    ivRightBaseTitleBar.setImageResource(R.drawable.common_icon_right_more);
                }
            } else {
                ivRightBaseTitleBar.setVisibility(GONE);
            }

            if (ta.getBoolean(R.styleable.BaseTitleBar_rightTextVisible, false)) {
                // 右侧文字显示
                if (!ta.getBoolean(R.styleable.BaseTitleBar_rightIconVisible, false)) {
                    // 右侧图标不显示，在显示文字，否则不显示文字
                    tvRightBaseTitleBar.setVisibility(VISIBLE);
                    if (ta.hasValue(R.styleable.BaseTitleBar_rightText)) {
                        tvRightBaseTitleBar.setText(ta.getString(R.styleable.BaseTitleBar_rightText));
                    } else {
                        tvRightBaseTitleBar.setText("");
                    }
                } else {
                    tvRightBaseTitleBar.setVisibility(GONE);
                }
            } else {
                tvRightBaseTitleBar.setVisibility(GONE);
            }

            Drawable background = ta.getDrawable(R.styleable.BaseTitleBar_titleBackground);
            if (null != background) {
                clRootTitleBar.setBackgroundDrawable(background);
            }

            if (ta.getBoolean(R.styleable.BaseTitleBar_bottomLineVisible, false)) {
                viewBottomLineTitleBar.setVisibility(VISIBLE);
            } else {
                viewBottomLineTitleBar.setVisibility(GONE);
            }

            ta.recycle();
        }
    }

    public void setLeftImageResource(@DrawableRes int resId) {
        ivLeftBaseTitleBar.setImageResource(resId);
    }


    public void setRightImageResource(@DrawableRes int resId) {
        ivRightBaseTitleBar.setImageResource(resId);
    }

    public BaseTitleBar setLeftLayoutClickListener(@NonNull OnClickListener listener) {
        ivLeftBaseTitleBar.setOnClickListener(listener);
        return this;
    }

    public BaseTitleBar setOnTitleClickListener(@NonNull OnClickListener listener) {
        tvTitleBaseTitleBar.setOnClickListener(listener);
        return this;
    }

    public BaseTitleBar setRightLayoutClickListener(@NonNull OnClickListener listener) {
        ivRightBaseTitleBar.setOnClickListener(listener);
        tvRightBaseTitleBar.setOnClickListener(listener);
        return this;
    }

    public BaseTitleBar setCloseIconClickListener(@NonNull OnClickListener listener) {
        ivCloseBaseTitleBar.setOnClickListener(listener);
        return this;
    }

    public void setLeftLayoutVisibility(int visibility) {
        ivLeftBaseTitleBar.setVisibility(visibility);
    }

    public void setRightLayoutVisibility(int visibility) {
        ivRightBaseTitleBar.setVisibility(visibility);
        tvRightBaseTitleBar.setVisibility(visibility);
    }

    public void setTitle(String title) {
        tvTitleBaseTitleBar.setText(title);
    }

    @Override
    public void setBackgroundColor(int color) {
        clRootTitleBar.setBackgroundColor(color);
    }

}
