package com.xyj.strokeaid.bean;

/**
 * GreenChannelTabBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/25
 * email ：licy3051@qq.com
 */
public class PatientMenuBean {

    private String title;
    private boolean checked;

    public PatientMenuBean(String title, boolean checked) {
        this.title = title;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

    
    
       
    