package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;


/**
 * ItemEditBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/5/16
 * email ：licy3051@qq.com
 */
public class ItemEditBar extends LinearLayout {

    private TextView mTvLeft;
    private TextView mTvUnit;
    private EditText mEtRoot;
    private TextView mTvSpace;
    private LinearLayout mLlRoot;
    private Context mContext;
    private boolean haveMark;
    private boolean mClickStatus;

    private boolean mEnable = true;

    public ItemEditBar(Context context) {
        this(context, null);
    }

    public ItemEditBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemEditBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.widget_item_edit_bar, this, true);

        mTvLeft = view.findViewById(R.id.tv_widget_item_edit_bar);
        mTvUnit = view.findViewById(R.id.tv_unit_item_edit_bar);
        mTvSpace = view.findViewById(R.id.tv_space_widget_item_edit_bar);
        mEtRoot = view.findViewById(R.id.et_widget_item_edit_bar);
        mLlRoot = view.findViewById(R.id.ll_root_item_edit_bar);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ItemEditBar);

        // 设置title
        // 是否必填
        haveMark = array.getBoolean(R.styleable.ItemEditBar_ieb_must_fill, false);
        if (haveMark) {
            mTvLeft.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_manda), null, null, null);
        } else {
            mTvLeft.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.icon_manda_no), null, null, null);
        }
        // 填充内容
        if (array.hasValue(R.styleable.ItemEditBar_ieb_title)) {
            mTvLeft.setText(array.getString(R.styleable.ItemEditBar_ieb_title));
        }

        // 设置edit text
        // 是否可以编辑
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_edit_enable, true)) {
            mEnable = true;
            mTvSpace.setVisibility(GONE);
            mEtRoot.setVisibility(VISIBLE);
        } else {
            mEnable = false;
            mTvSpace.setVisibility(VISIBLE);
            mEtRoot.setVisibility(GONE);
        }


        if (array.hasValue(R.styleable.ItemEditBar_ieb_edit_hint)) {
            mEtRoot.setHint(array.getString(R.styleable.ItemEditBar_ieb_edit_hint));
        }
        if (array.hasValue(R.styleable.ItemEditBar_ieb_edit_content)) {
            mEtRoot.setText(array.getString(R.styleable.ItemEditBar_ieb_edit_content));
        }
        if (array.hasValue(R.styleable.ItemEditBar_android_inputType)) {
            mEtRoot.setInputType(array.getInteger(R.styleable.ItemEditBar_android_inputType, InputType.TYPE_CLASS_TEXT));
        }

        // unit
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_unit_visible, false)) {
            mTvUnit.setVisibility(VISIBLE);
            if (array.hasValue(R.styleable.ItemEditBar_ieb_unit_text)) {
                mTvUnit.setText(array.getString(R.styleable.ItemEditBar_ieb_unit_text));
            }
        } else {
            mTvUnit.setVisibility(GONE);
        }

        mClickStatus = array.getBoolean(R.styleable.ItemEditBar_ieb_click_status, false);

        array.recycle();

    }

    public ItemEditBar setTitle(String title) {
        mTvLeft.setText(title);
        return this;
    }

    public ItemEditBar setEditContent(String content) {
        if (mEnable) {
            mEtRoot.setText(content);
        } else {
            mTvSpace.setText(content);
        }
        return this;
    }

    public ItemEditBar setEditEnable(boolean enable) {
        if (mClickStatus) {
            mTvSpace.setVisibility(VISIBLE);
            mEtRoot.setVisibility(GONE);

            if (enable) {
                if (haveMark) {
                    mTvLeft.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.icon_manda), null, null, null);
                }
            } else {
                if (haveMark) {
                    mTvLeft.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.icon_manda_no), null, null, null);
                }
            }

            return this;
        }

        if (enable) {
            mTvSpace.setVisibility(GONE);
            mEtRoot.setVisibility(VISIBLE);
            if (haveMark) {
                mTvLeft.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.icon_manda), null, null, null);
            }
        } else {
            mTvSpace.setVisibility(VISIBLE);
            mEtRoot.setVisibility(GONE);
            if (haveMark) {
                mTvLeft.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(R.drawable.icon_manda_no), null, null, null);
            }
        }

        return this;
    }

    public ItemEditBar setEditHint(String hint) {
        mEtRoot.setHint(hint);
        return this;
    }

    public EditText getEtRoot() {
        return mEtRoot;
    }


    public boolean getEditEnable() {
        return mEnable;
    }

    public String getEditContent() {
        if (mEnable) {
            return mEtRoot.getText().toString().trim();
        } else {
            return mTvSpace.getText().toString().trim();
        }

    }

    public void setRootOnClickListener(OnClickListener listener) {
        mLlRoot.setOnClickListener(listener);
    }
}
