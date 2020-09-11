package com.xyj.strokeaid.distutil;

import java.util.ArrayList;
import java.util.List;

public class ViewDistListUtil {

    private List<ViewDistUtils> viewDistUtils = new ArrayList<>();

    public ViewDistUtils getViewDistUtils(String tag) {
        for (int i = 0; i < viewDistUtils.size(); i++) {
            ViewDistUtils viewDistUtils = this.viewDistUtils.get(i);
            if (viewDistUtils == null) {
                continue;
            }
            if (tag.equals(viewDistUtils.getTag())) {
                return viewDistUtils;
            }
        }
        return null;
    }

    public void addViewDistUtils(ViewDistUtils util) {
        viewDistUtils.add(util);
    }

}
