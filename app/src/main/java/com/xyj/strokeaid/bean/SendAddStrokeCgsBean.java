package com.xyj.strokeaid.bean;

public class SendAddStrokeCgsBean {

    private String id;

    private int mrs;

    private String gcsEye;

    private String gcsSpeech;

    private String gcsSport;

    private int score;

    private String levelDesc;

    private String createTime;

    private String createBy;

    private String createByName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMrs() {
        return mrs;
    }

    public void setMrs(int mrs) {
        this.mrs = mrs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getGcsEye() {
        return gcsEye;
    }

    public void setGcsEye(String gcsEye) {
        this.gcsEye = gcsEye;
    }

    public String getGcsSpeech() {
        return gcsSpeech;
    }

    public void setGcsSpeech(String gcsSpeech) {
        this.gcsSpeech = gcsSpeech;
    }

    public String getGcsSport() {
        return gcsSport;
    }

    public void setGcsSport(String gcsSport) {
        this.gcsSport = gcsSport;
    }
}
