package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xyj.strokeaid.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * ItemEditBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/5/16
 * email ：licy3051@qq.com
 */
public class ItemEditBar extends RelativeLayout {


    @BindView(R.id.view_top_line_view_ieb)
    View viewTopLineViewIeb;
    @BindView(R.id.view_bottom_line_view_ieb)
    View viewBottomLineViewIeb;
    @BindView(R.id.tv_title_view_ieb)
    TextView tvTitleViewIeb;
    @BindView(R.id.tv_unit_view_ieb)
    TextView tvUnitViewIeb;
    @BindView(R.id.et_content_view_ieb)
    EditText etContentViewIeb;
    @BindView(R.id.tv_content_view_ieb)
    TextView tvContentViewIeb;
    @BindView(R.id.rl_root_item_edit_bar)
    RelativeLayout rlRootItemEditBar;
    @BindView(R.id.iv_right_view_ieb)
    ImageView ivRightViewIeb;

    private boolean mEditEnable;

    public ItemEditBar(Context context) {
        this(context, null);
    }

    public ItemEditBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemEditBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.view_item_edit_bar, this, true);
        ButterKnife.bind(this, view);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ItemEditBar);

        // 设置title
        // 是否必填
        boolean mustFill = array.getBoolean(R.styleable.ItemEditBar_ieb_must_fill, false);
        if (mustFill) {
            tvTitleViewIeb.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_manda, 0);
        } else {
            tvTitleViewIeb.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_manda_no, 0);
        }
        // 填充标题
        if (array.hasValue(R.styleable.ItemEditBar_ieb_title)) {
            tvTitleViewIeb.setText(array.getString(R.styleable.ItemEditBar_ieb_title));
        }

        // 设置edit text
        // 是否可以编辑
        mEditEnable = array.getBoolean(R.styleable.ItemEditBar_ieb_edit_enable, true);
        if (mEditEnable) {
            tvContentViewIeb.setVisibility(GONE);
            etContentViewIeb.setVisibility(VISIBLE);
        } else {
            tvContentViewIeb.setVisibility(VISIBLE);
            etContentViewIeb.setVisibility(GONE);
        }
        // 设置提示文字
        if (array.hasValue(R.styleable.ItemEditBar_ieb_edit_hint)) {
            tvContentViewIeb.setHint(array.getString(R.styleable.ItemEditBar_ieb_edit_hint));
            etContentViewIeb.setHint(array.getString(R.styleable.ItemEditBar_ieb_edit_hint));
        }
        // 设置内容
        if (array.hasValue(R.styleable.ItemEditBar_ieb_edit_content)) {
            tvContentViewIeb.setText(array.getString(R.styleable.ItemEditBar_ieb_edit_content));
            etContentViewIeb.setText(array.getString(R.styleable.ItemEditBar_ieb_edit_content));
        }

        // unit
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_unit_visible, false)) {
            tvUnitViewIeb.setVisibility(VISIBLE);
            if (array.hasValue(R.styleable.ItemEditBar_ieb_unit_text)) {
                tvUnitViewIeb.setText(array.getString(R.styleable.ItemEditBar_ieb_unit_text));
            }
        } else {
            tvUnitViewIeb.setVisibility(GONE);
        }

        // 顶部分割线
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_top_line_visible, false)) {
            viewTopLineViewIeb.setVisibility(VISIBLE);
        } else {
            viewTopLineViewIeb.setVisibility(GONE);
        }
        // 底部分割线
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_bottom_line_visible, false)) {
            viewBottomLineViewIeb.setVisibility(VISIBLE);
        } else {
            viewBottomLineViewIeb.setVisibility(GONE);
        }

        // 右侧图标
        if (array.getBoolean(R.styleable.ItemEditBar_ieb_right_icon_visible, false)) {
            Drawable drawable = array.getDrawable(R.styleable.ItemEditBar_ieb_right_icon);
            if (drawable != null) {
                ivRightViewIeb.setVisibility(VISIBLE);
                ivRightViewIeb.setImageDrawable(drawable);
            } else {
                ivRightViewIeb.setVisibility(GONE);
            }
        } else {
            ivRightViewIeb.setVisibility(GONE);
        }

        array.recycle();

    }

    public ItemEditBar setTitle(String title) {
        tvTitleViewIeb.setText(title);
        return this;
    }

    public ItemEditBar setEditContent(String content) {
        etContentViewIeb.setText(content);
        tvContentViewIeb.setText(content);
        return this;
    }

    public ItemEditBar setEditEnable(boolean enable) {
        mEditEnable = enable;
        if (mEditEnable) {
            tvContentViewIeb.setVisibility(GONE);
            etContentViewIeb.setVisibility(VISIBLE);
        } else {
            tvContentViewIeb.setVisibility(VISIBLE);
            etContentViewIeb.setVisibility(GONE);
        }
        return this;
    }

    public ItemEditBar setRootOnClickListener(OnClickListener listener) {
        if (rlRootItemEditBar != null) {
            rlRootItemEditBar.setOnClickListener(listener);
        }
        return this;
    }

    public ItemEditBar setEditHint(String hint) {
        etContentViewIeb.setHint(hint);
        tvContentViewIeb.setHint(hint);
        return this;
    }

    public EditText getEtRoot() {
        return etContentViewIeb;
    }


    public boolean getEditEnable() {
        return mEditEnable;
    }

    public String getEditContent() {
        if (mEditEnable) {
            return etContentViewIeb.getText().toString().trim();
        } else {
            return tvContentViewIeb.getText().toString().trim();
        }

    }

    public void setTopLineVisible(boolean visible) {
        if (viewTopLineViewIeb != null) {
            viewTopLineViewIeb.setVisibility(visible ? VISIBLE : GONE);
        }
    }

    public void setBottomLineVisible(boolean visible) {
        if (viewBottomLineViewIeb != null) {
            viewBottomLineViewIeb.setVisibility(visible ? VISIBLE : GONE);
        }
    }

    public void setRightIvOnClickerListener(View.OnClickListener listener) {
        if (ivRightViewIeb != null) {
            ivRightViewIeb.setOnClickListener(listener);
        }
    }
}
