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

import com.umeng.commonsdk.debug.D;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.activity.chestpain.DistListUtil;

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
    public OnSelectStringLitner onSelectStringLitner;
    public OnSelectIndexAndStringLitner mOnSelectIndexAndStringLitner;
    private List<String> mData;
    private boolean isSplite = false;

    private int selectPosition = 0;

    DistListUtil distListUtil;
    private int dataRrrayId;

    public EditSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView(attrs);
        initAnimation();
    }

    public void setStringArrayId(int id) {
        this.dataRrrayId = id;
        distListUtil = new DistListUtil(this.mContext);
        distListUtil.initGenderMap(id);
        List<String> keyDataList = distListUtil.getKeyDataList(id);
        setItemData(keyDataList);
    }

    public boolean checkLastItem() {
        return (this.getItemSize() - 1) == this.getSelectPosition();
    }

    public boolean checkFirstItem() {
        return 0 == this.getSelectPosition();
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setStringArrayNormalKey(String keyData) {
        if (distListUtil == null) {
            return;
        }
        String data = distListUtil.getKeyDataToStringKey(dataRrrayId, keyData);
        setText(data);
    }

    public int getItemSize() {
        if (mData != null) {
            return mData.size();
        }
        return -1;
    }

    public void setItemData(List<String> data) {
        mData = data;
        adapter = new SimpleAdapter(mContext, data);
        setAdapter(adapter);
    }

    public String[] getSelectData() {
        if (distListUtil == null) {
            return new String[]{"",""};
        }
        // 第一个是key 第二个是value
        String text = getText();
        String valueDataToStringKey =
                distListUtil.getValueDataToStringKey(dataRrrayId, text);
        if (TextUtils.isEmpty(valueDataToStringKey)) {
            valueDataToStringKey = "";
        }
        return new String[]{text, valueDataToStringKey};
    }

    public void setSelectPosition(int position) {
        if (mData.size() < position || position == 0) {
            return;
        }
        String s = mData.get(position);
        setText(s);
    }

    public void setText(String text) {
        selectPosition = -1;
        for (int i = 0; i < mData.size(); i++) {
            if (TextUtils.equals(mData.get(i), text)) {
                selectPosition = i;
            }
        }
        editText.setText(text);
        if (popupWindow != null && popupWindow.isShowing()){
            popupWindow.dismiss();
        }
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

    public String getHint() {
        return editText.getHint().toString();
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

    private void setBaseAdapter(BaseAdapter adapter) {
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
        String selectText = mData.get(position);
        setText(selectText);
        mRightImageTopView.setClickable(false);
        if (mOnSelectIndexAndStringLitner != null) {
            mOnSelectIndexAndStringLitner.getSeletedStringAndIndex(selectText, position);
        }
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
        if (onSelectStringLitner != null) {
            onSelectStringLitner.getSeletedString(key);
        }
        editText.setSelection(0);
        if (!TextUtils.isEmpty(key)) {
            showFilterData(key);
        } else {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
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

    public interface OnSelectStringLitner {
        void getSeletedString(String text);
    }

    public void setOnSelectStringLitner(OnSelectStringLitner onSelectStringLitner) {
        this.onSelectStringLitner = onSelectStringLitner;
    }

    public interface OnSelectIndexAndStringLitner {
        void getSeletedStringAndIndex(String text, int position);
    }

    public void setOnSelectIndexAndStringLitner(OnSelectIndexAndStringLitner onSelectIndexAndStringLitner) {
        mOnSelectIndexAndStringLitner = onSelectIndexAndStringLitner;
    }
}
