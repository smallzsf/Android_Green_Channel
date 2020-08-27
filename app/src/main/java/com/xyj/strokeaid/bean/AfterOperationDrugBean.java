package com.xyj.strokeaid.bean;

/**
 * AfterOperationDrugBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/27
 * email ：licy3051@qq.com
 */
public class AfterOperationDrugBean {

    private boolean checked;
    private String name;
    private String note;

    public AfterOperationDrugBean(boolean checked, String name, String note) {
        this.checked = checked;
        this.name = name;
        this.note = note;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "AfterOperationDrugBean{" +
                "checked=" + checked +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

    
    
       
    