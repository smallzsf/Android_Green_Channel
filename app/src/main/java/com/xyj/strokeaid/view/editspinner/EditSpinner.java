package com.xyj.strokeaid.view.editspinner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;


import com.xyj.strokeaid.R;

import java.util.List;

/**
 * Created by WrBug on 2017/2/26 0026.
 * https://gitee.com/wrbug/EditSpinner/tree/master
 */
public class EditSpinner extends RelativeLayout implements View.OnClickListener, AdapterView.OnItemClickListener, TextWatcher {
    private EditText editText;
    private ImageView mRightIv;
    private View mRightImageTopView;
    private Context mContext;
    private ListPopupWindow popupWindow;
    BaseEditSpinnerAdapter adapter;
    private TypedArray tArray;
    private boolean isPopupWindowShowing;
    private Animation mAnimation;
    private Animation mResetAnimation;

    public EditSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView(attrs);
        initAnimation();
    }


    public void setItemData(List<String> data) {
        adapter = new SimpleAdapter(mContext, data);
        setAdapter(adapter);
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void setTextColor(@ColorInt int color) {
        editText.setTextColor(color);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setHint(String hint) {
        editText.setHint(hint);
    }

    public void setRightImageDrawable(Drawable drawable) {
        mRightIv.setImageDrawable(drawable);
    }

    public void setRightImageResource(@DrawableRes int res) {
        mRightIv.setImageResource(res);
    }

    public void setAdapter(BaseEditSpinnerAdapter adapter) {
        this.adapter = adapter;
        setBaseAdapter(this.adapter);
    }

    private void initAnimation() {
        mAnimation = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mAnimation.setDuration(300);
        mAnimation.setFillAfter(true);
        mResetAnimation = new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mResetAnimation.setDuration(300);
        mResetAnimation.setFillAfter(true);
    }

    private void initView(AttributeSet attrs) {
        LayoutInflater.from(mContext).inflate(R.layout.edit_spinner, this);
        editText = (EditText) findViewById(R.id.edit_sipnner_edit);
        mRightIv = (ImageView) findViewById(R.id.edit_spinner_expand);
        mRightImageTopView = findViewById(R.id.edit_spinner_expand_above);
        mRightImageTopView.setOnClickListener(this);
        mRightImageTopView.setClickable(false);
        mRightIv.setOnClickListener(this);
        mRightIv.setRotation(0);
        editText.addTextChangedListener(this);
        tArray = mContext.obtainStyledAttributes(attrs,
                R.styleable.EditSpinner);
        editText.setHint(tArray.getString(R.styleable.EditSpinner_hint));
        int imageId = tArray.getResourceId(R.styleable.EditSpinner_rightImage, 0);
        if (imageId != 0) {
            mRightIv.setImageResource(imageId);
        }
        int bg = tArray.getResourceId(R.styleable.EditSpinner_Background, 0);
        if (bg != 0) {
            editText.setBackgroundResource(bg);
        }
        tArray.recycle();
    }

    private final void setBaseAdapter(BaseAdapter adapter) {
        if (popupWindow == null) {
            initPopupWindow();
        }
        popupWindow.setAdapter(adapter);
    }

    private void initPopupWindow() {
        popupWindow = new ListPopupWindow(mContext) {
            @Override
            public boolean isShowing() {
                return isPopupWindowShowing;
            }

            @Override
            public void show() {
                super.show();
                isPopupWindowShowing = true;
                mRightImageTopView.setClickable(true);
                mRightIv.startAnimation(mAnimation);
            }
        };
        popupWindow.setOnItemClickListener(this);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setPromptPosition(ListPopupWindow.POSITION_PROMPT_BELOW);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setAnchorView(editText);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                isPopupWindowShowing = false;
                mRightIv.startAnimation(mResetAnimation);
            }
        });
    }


    @Override
    public final void onClick(View v) {
        if (adapter == null || popupWindow == null) {
            return;
        }
        if (v.getId() == R.id.edit_spinner_expand_above) {
            v.setClickable(false);
            return;
        }
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        } else {
//            cacheData.clear();
//            cacheData.addAll(data);
            showFilterData("");
        }
    }

    @Override
    public final void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        editText.setText(((BaseEditSpinnerAdapter) parent.getAdapter()).getItemString(position));
        mRightImageTopView.setClickable(false);
        popupWindow.dismiss();
    }

    @Override
    public final void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public final void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public final void afterTextChanged(Editable s) {
        String key = s.toString();
        editText.setSelection(key.length());
        if (!TextUtils.isEmpty(key)) {
            showFilterData(key);
        } else {
            popupWindow.dismiss();
        }
    }

    private void showFilterData(String key) {
        if (popupWindow == null || adapter == null || adapter.getEditSpinnerFilter() == null) {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            return;
        }
        if (adapter.getEditSpinnerFilter().onFilter(key)) {
            popupWindow.dismiss();
        } else {
            popupWindow.show();
        }

    }
}
