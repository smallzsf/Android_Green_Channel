package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.xyj.strokeaid.R;


/**
 * EditBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/4/15
 * email ：licy3051@qq.com
 */
public class ImageEditBar extends RelativeLayout {

    private ImageView mIvLeft;
    private ImageView mIvRight;
    private EditText mEtRoot;
    private View mTopLine;
    private View mBottomLine;
    private RelativeLayout mRlRoot;

    private static final int MIN_HEIGHT = 40;

    public ImageEditBar(@NonNull Context context) {
        this(context, null);
    }

    public ImageEditBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageEditBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mRlRoot = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.widget_edit_bar, this, true);

        mIvLeft = mRlRoot.findViewById(R.id.iv_left_edit_bar);
        mIvRight = mRlRoot.findViewById(R.id.iv_right_edit_bar);
        mEtRoot = mRlRoot.findViewById(R.id.et_edit_bar);
        mTopLine = mRlRoot.findViewById(R.id.view_top_line_edit_bar);
        mBottomLine = mRlRoot.findViewById(R.id.view_bottom_line_edit_bar);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ImageEditBar);

        if (array.getBoolean(R.styleable.ImageEditBar_eb_top_line_visible, false)) {
            mTopLine.setVisibility(VISIBLE);
        } else {
            mTopLine.setVisibility(GONE);
        }

        if (array.getBoolean(R.styleable.ImageEditBar_eb_bottom_line_visible, false)) {
            mBottomLine.setVisibility(VISIBLE);
        } else {
            mBottomLine.setVisibility(GONE);
        }

        if (array.getBoolean(R.styleable.ImageEditBar_eb_left_icon_visible, false)) {
            mIvLeft.setVisibility(VISIBLE);
            if (array.hasValue(R.styleable.ImageEditBar_eb_left_icon)) {
                mIvLeft.setImageResource(array.getResourceId(R.styleable.ImageEditBar_eb_left_icon,
                        R.drawable.icon_defalut));
            } else {
                mIvLeft.setVisibility(GONE);
            }
        } else {
            mIvLeft.setVisibility(GONE);
        }

        if (array.getBoolean(R.styleable.ImageEditBar_eb_right_icon_visible, false)) {
            mIvRight.setVisibility(VISIBLE);
            if (array.hasValue(R.styleable.ImageEditBar_eb_right_icon)) {
                mIvRight.setImageResource(array.getResourceId(R.styleable.ImageEditBar_eb_right_icon,
                        R.drawable.icon_defalut));
            } else {
                mIvRight.setVisibility(GONE);
            }
        } else {
            mIvRight.setVisibility(GONE);
        }

        mEtRoot.setHint(array.getString(R.styleable.ImageEditBar_eb_et_hint));
        mEtRoot.setText(array.getString(R.styleable.ImageEditBar_eb_et_content));

        if (array.getBoolean(R.styleable.ImageEditBar_eb_et_enable, true)) {
            mEtRoot.setEnabled(true);
        } else {
            mEtRoot.setEnabled(false);
        }

        array.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ImageEditBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ImageEditBar setLeftImage(@DrawableRes int res) {
        mIvLeft.setImageResource(res);
        return this;
    }

    public ImageEditBar setLeftImage(Drawable drawable) {
        mIvLeft.setImageDrawable(drawable);
        return this;
    }

    public ImageEditBar setRightImage(@DrawableRes int res) {
        mIvRight.setImageResource(res);
        return this;
    }

    public ImageEditBar setRightImage(Drawable drawable) {
        mIvRight.setImageDrawable(drawable);
        return this;
    }

    public ImageEditBar setRightImageClickListener(OnClickListener listener) {
        mIvRight.setOnClickListener(listener);
        return this;
    }

    public ImageEditBar setTopLineVisible(boolean status) {
        mTopLine.setVisibility(status ? VISIBLE : GONE);
        return this;
    }

    public ImageEditBar setBottomLineVisible(boolean status) {
        mBottomLine.setVisibility(status ? VISIBLE : GONE);
        return this;
    }


    public EditText getEditText() {
        return mEtRoot;
    }

    public ImageEditBar setEditHint(String hint) {
        mEtRoot.setHint(hint);
        return this;
    }

    public ImageEditBar setEditContent(String content) {
        mEtRoot.setText(content);
        return this;
    }

    public ImageEditBar setEditEnable(boolean enable) {
        mEtRoot.setEnabled(enable);
        return this;
    }

    public String getEditContent() {
        return mEtRoot.getText().toString().trim();
    }

}
