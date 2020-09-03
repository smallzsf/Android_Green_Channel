package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyj.strokeaid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * SettingBar
 * description: 自定义控件  设置条
 *
 * @author : Licy
 * @date : 2019/8/2
 * email ：licy3051@qq.com
 */
public class SettingBar extends RelativeLayout {


    @BindView(R.id.view_top_line_view_sb)
    View viewTopLineViewSb;
    @BindView(R.id.view_bottom_line_view_sb)
    View viewBottomLineViewSb;
    @BindView(R.id.iv_left_view_sb)
    ImageView ivLeftViewSb;
    @BindView(R.id.tv_title_view_sb)
    TextView tvTitleViewSb;
    @BindView(R.id.iv_right_view_sb)
    ImageView ivRightViewSb;
    @BindView(R.id.tv_right_view_sb)
    TextView tvRightViewSb;

    public SettingBar(@NonNull Context context) {
        this(context, null);
    }

    public SettingBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View inflate = LayoutInflater.from(context).inflate(R.layout.view_setting_bar, this);
        ButterKnife.bind(this, inflate);

        final TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SettingBar);

        // 根据xml中的设置初始化控件
        // 左边 -- 标题
        if (array.hasValue(R.styleable.SettingBar_bar_leftText)) {
            tvTitleViewSb.setText(array.getString(R.styleable.SettingBar_bar_leftText));
        }
        // 左边 -- 标题颜色
        if (array.hasValue(R.styleable.SettingBar_bar_leftTextColor)) {
            tvTitleViewSb.setTextColor(array.getColor(R.styleable.SettingBar_bar_leftTextColor, Color.BLACK));
        }
        // 左边 -- icon
        if (array.hasValue(R.styleable.SettingBar_bar_leftIconVisible)) {
            if (array.getBoolean(R.styleable.SettingBar_bar_leftIconVisible, false)) {
                if (array.hasValue(R.styleable.SettingBar_bar_leftIcon)) {
                    ivLeftViewSb.setVisibility(VISIBLE);
                    ivLeftViewSb.setImageResource(array.getResourceId(R.styleable.SettingBar_bar_leftIcon, 0));
                } else {
                    ivLeftViewSb.setVisibility(GONE);
                }
            } else {
                ivLeftViewSb.setVisibility(GONE);
            }
        } else {
            ivLeftViewSb.setVisibility(GONE);
        }
        // 右边 -- 显示
        if (array.getBoolean(R.styleable.SettingBar_bar_rightTextVisible, true)) {
            tvRightViewSb.setVisibility(VISIBLE);
            // 右边 -- 标题
            if (array.hasValue(R.styleable.SettingBar_bar_rightText)) {
                tvRightViewSb.setText(array.getString(R.styleable.SettingBar_bar_rightText));
            }
            // 右边 -- 标题颜色
            if (array.hasValue(R.styleable.SettingBar_bar_rightTextColor)) {
                tvRightViewSb.setTextColor(array.getColor(R.styleable.SettingBar_bar_rightTextColor, 0));
            }

        } else {
            tvRightViewSb.setVisibility(GONE);
        }

        // 右边 -- icon
        if (array.getBoolean(R.styleable.SettingBar_bar_rightIconVisible, true)) {
            ivRightViewSb.setVisibility(VISIBLE);
            if (array.hasValue(R.styleable.SettingBar_bar_rightIcon)) {
                ivRightViewSb.setImageResource(array.getResourceId(R.styleable.SettingBar_bar_rightIcon, R.drawable.common_icon_right_arrow_222222));
            } else {
                ivRightViewSb.setImageResource(R.drawable.common_icon_right_arrow_222222);
            }
        } else {
            ivRightViewSb.setVisibility(INVISIBLE);
        }
        // 分割线 -- top
        if (array.hasValue(R.styleable.SettingBar_bar_topLineVisible)) {
            if (array.getBoolean(R.styleable.SettingBar_bar_topLineVisible, false)) {
                viewTopLineViewSb.setVisibility(VISIBLE);
            } else {
                viewTopLineViewSb.setVisibility(GONE);
            }
        }
        // 分割线 -- bottom
        if (array.hasValue(R.styleable.SettingBar_bar_bottomLineVisible)) {
            if (array.getBoolean(R.styleable.SettingBar_bar_bottomLineVisible, false)) {
                viewBottomLineViewSb.setVisibility(VISIBLE);
            } else {
                viewBottomLineViewSb.setVisibility(GONE);
            }
        }

        // 回收TypedArray
        array.recycle();

    }

    public CharSequence getLeftText() {
        return tvTitleViewSb.getText();
    }

    /**
     * 设置左边的标题
     */
    public SettingBar setLeftText(int stringId) {
        return setLeftText(getResources().getString(stringId));
    }

    public SettingBar setLeftText(CharSequence text) {
        tvTitleViewSb.setText(text);
        return this;
    }

    public ImageView getLeftImage() {
        return ivLeftViewSb;
    }

    public CharSequence getRightText() {
        return tvRightViewSb.getText();
    }

    /**
     * 设置右边的标题
     */
    public SettingBar setRightText(int stringId) {
        setRightText(getResources().getString(stringId));
        return this;
    }

    /**
     * 设置右边的标题
     */
    public SettingBar setRightTextColor(@ColorInt int color) {
        if (tvRightViewSb != null) {
            tvRightViewSb.setTextColor(color);
        }
        return this;
    }

    public SettingBar setRightText(CharSequence text) {
        tvRightViewSb.setText(text);
        return this;
    }

    public Drawable getLeftIcon() {
        return ivLeftViewSb.getDrawable();
    }

    /**
     * 设置左边的图标
     */
    public SettingBar setLeftIcon(int iconId) {
        if (iconId > 0) {
            setLeftIcon(getContext().getResources().getDrawable(iconId));
        }
        return this;
    }

    public SettingBar setLeftIcon(Drawable drawable) {
        ivLeftViewSb.setImageDrawable(drawable);
        return this;
    }

    public Drawable getRightIcon() {
        return ivRightViewSb.getDrawable();
    }

    /**
     * 设置右边的图标
     */
    public SettingBar setRightIcon(int iconId) {
        if (iconId > 0) {
            setRightIcon(getContext().getResources().getDrawable(iconId));
        }
        return this;
    }

    public SettingBar setRightIcon(Drawable drawable) {
        ivRightViewSb.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置左标题颜色
     */
    public SettingBar setLeftColor(int color) {
        tvTitleViewSb.setTextColor(color);
        return this;
    }

    /**
     * 设置右标题颜色
     */
    public SettingBar setRightColor(int color) {
        tvRightViewSb.setTextColor(color);
        return this;
    }

    public void setRightImageClickListener(OnClickListener listener) {
        ivRightViewSb.setOnClickListener(listener);
    }
}
