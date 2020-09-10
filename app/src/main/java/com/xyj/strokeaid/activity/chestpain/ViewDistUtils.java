package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewDistUtils<T extends CompoundButton> {

    DistListUtil distListUtil = null;

    private int dataRrrayId;

    private List<T> viewList;

    private T selectView;
    private String selectViewKey;

    private Map<String, T> mapTextToView = new HashMap<>();
    private String tag;

    public ViewDistUtils(Context context) {
        distListUtil = new DistListUtil(context);
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public List<T> getViewList() {
        return viewList;
    }

    public void setViewList(List<T> list) {
        this.viewList = list;
        this.setViewText();
    }

    public void addView(T t) {
        if (viewList == null) {
            viewList = new ArrayList<>();
        }
        viewList.add(t);
        this.setViewText();
    }


    public void setStringArrayId(int id) {
        dataRrrayId = id;
        distListUtil.initGenderMap(id);
        this.setViewText();
    }

    private void setViewText() {
        List<String> keyDataList = distListUtil.getKeyDataList(dataRrrayId);
        if (keyDataList == null || keyDataList.isEmpty()) {
            return;
        }
        if (viewList == null || viewList.isEmpty()) {
            return;
        }
        String text = "";
        for (int i = 0; i < viewList.size(); i++) {
            T view = viewList.get(i);
            if (view == null) {
                continue;
            }
            if (i < keyDataList.size() - 1) {
                text = keyDataList.get(i);
            }
            mapTextToView.put(text, view);
            view.setText(text);
            view.setOnClickListener(clickListener);
        }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            List<T> viewList = getViewList();
            if (viewList == null) {
                return;
            }
            for (int i = 0; i < viewList.size(); i++) {
                T viewItem = viewList.get(i);
                viewItem.setChecked(false);
            }
            setSelectView((T) view);
        }
    };

    public void setSelectView(T t) {
        if (distListUtil == null) {
            return;
        }
        selectView = t;
        String selectText = String.valueOf(t.getText());
        selectViewKey = distListUtil.getValueDataToStringKey(dataRrrayId, selectText);
        t.setChecked(true);
        if (listener != null) {
            listener.onClick(t);
        }
    }

    public void setStringArrayNormalKey(String keyData) {
        if (distListUtil == null) {
            return;
        }
        String data = distListUtil.getKeyDataToStringKey(dataRrrayId, keyData);
        if (!mapTextToView.containsKey(data)) {
            return;
        }
        T t = mapTextToView.get(data);
        this.setSelectView(t);
    }

    public T getSelectView() {
        return selectView;
    }

    public String getSelectViewKey() {
        return selectViewKey;
    }
    private ViewClickListener listener;

    private void setViewClickListener(ViewClickListener listener) {
        this.listener = listener;
    }

    private interface ViewClickListener<T> {
        void onClick(T view);
    }


}
