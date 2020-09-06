package com.xyj.strokeaid.bean;

public class GenderSelectBean {

    private int position;
    private int type;   //0-第一个集合  1-更多集合
    private String name;

    private String netType;

    public GenderSelectBean(int position, int type, String name, String netType) {
        this.position = position;
        this.type = type;
        this.name = name;
        this.netType = netType;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenderSelectBean{" +
                "position=" + position +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
