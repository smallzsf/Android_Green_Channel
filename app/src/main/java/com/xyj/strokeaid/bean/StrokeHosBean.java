package com.xyj.strokeaid.bean;

/**
 * StrokeHosBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/26
 * email ：licy3051@qq.com
 */
public class StrokeHosBean {

    private String name;
    private String phone;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public StrokeHosBean(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

    
    
       
    