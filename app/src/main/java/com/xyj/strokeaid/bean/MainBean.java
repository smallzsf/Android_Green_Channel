package com.xyj.strokeaid.bean;

import java.util.List;

/**
 * @author ck
 *  主页 列表数据  卒中、胸痛、创伤
 */
public class MainBean {

    private int total;
    private List<MainListBean> records;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MainListBean> getRecords() {
        return records;
    }

    public void setRecords(List<MainListBean> records) {
        this.records = records;
    }
}
