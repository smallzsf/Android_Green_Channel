package com.xyj.strokeaid.bean;

/**
 * StrokeProcessBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/20
 * email ：licy3051@qq.com
 */
public class StrokeProcessBean {

    private String name;
    private String code;
    /**
     * 1  未完成
     * 2  部分完成
     * 3  已完成
     */
    private int status;
    private String desc;
    private String destination;
    private boolean mustFill;

    public StrokeProcessBean(String name, String code, int status, String desc, String destination, boolean mustFill) {
        this.name = name;
        this.code = code;
        this.status = status;
        this.desc = desc;
        this.destination = destination;
        this.mustFill = mustFill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isMustFill() {
        return mustFill;
    }

    public void setMustFill(boolean mustFill) {
        this.mustFill = mustFill;
    }
}

    
    
       
    