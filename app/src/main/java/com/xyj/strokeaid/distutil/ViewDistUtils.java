package com.xyj.strokeaid.distutil;

import android.content.Context;
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

    private List<T> selectViews = new ArrayList<>();
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
            try {
                boolean isChecked = ((CompoundButton)view).isChecked();

                List<T> viewList = getViewList();
                if (viewList == null) {
                    return;
                }
                for (int i = 0; i < viewList.size(); i++) {
                    T viewItem = viewList.get(i);
                    if (viewItem.getId() == view.getId()){
                        continue;
                    }
                    if (viewItem instanceof RadioButton) {
                        viewItem.setChecked(false);
                    }
                }
                setSelectViews((T) view,isChecked);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void setSelectViews(T t,boolean isChecked) {
        if (distListUtil == null) {
            return;
        }
        if (t instanceof RadioButton) {
            selectViews.clear();
        }
        if (isChecked) {
            selectViews.add(t);
        } else if (selectViews != null &&  selectViews.contains(t)) {
            selectViews.remove(t);
        }
        t.setChecked(isChecked);
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
        this.setSelectViews(t,true);
    }

    protected List<T> getSelectViews() {
        return selectViews;
    }

    protected List<String> getSelectViewKeys() {
        List<String> selectViewKeys = new ArrayList<>();
        for (int i = 0; i < selectViews.size(); i++) {
            T t = selectViews.get(i);

            String selectText = String.valueOf(t.getText());
            String selectViewKey = distListUtil.getValueDataToStringKey(dataRrrayId, selectText);
            selectViewKeys.add(selectViewKey);
        }


        return selectViewKeys;
    }

    private ViewClickListener listener;

    private void setViewClickListener(ViewClickListener listener) {
        this.listener = listener;
    }

    private interface ViewClickListener<T> {
        void onClick(T view);
    }


}
