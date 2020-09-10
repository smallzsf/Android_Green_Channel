package com.xyj.strokeaid.activity.chestpain;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewDistUtils<T extends CompoundButton> {

    DistListUtil distListUtil = null;

    private int dataRrrayId;

    private List<T> viewList;

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

    public void setStringArrayId(int id) {
        dataRrrayId = id;
        distListUtil.initGenderMap(id);
        this.setViewText();
    }

    private void setViewText() {
        List<String> keyDataList = distListUtil.getKeyDataList(dataRrrayId);
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
//            setViewData(view, text);
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
            T viewButton = (T) view;
            viewButton.setChecked(true);
        }
    };


    public void setStringArrayNormalKey(String keyData) {
        if (distListUtil == null) {
            return;
        }
        String data = distListUtil.getKeyDataToStringKey(dataRrrayId, keyData);
        if (!mapTextToView.containsKey(data)) {
            return;
        }
        T t = mapTextToView.get(data);
        t.setText(data);
        t.setChecked(true);
    }


}
