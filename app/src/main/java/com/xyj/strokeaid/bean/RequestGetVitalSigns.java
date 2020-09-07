package com.xyj.strokeaid.bean;

public class RequestGetVitalSigns {

    private String recordId;//记录ID

    private String consciousness; //意识

    private String breathrate;//呼吸

    private String pulserate;//脉搏

    private String heartrate;//心率

    private String bloodpressure;//左上肢血压

    private String rightbloodpressure;//右上肢血压

    private String temperature;//温度

    private String percentageofoxygensaturation;//血氧饱和度

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(String consciousness) {
        this.consciousness = consciousness;
    }

    public String getBreathrate() {
        return breathrate;
    }

    public void setBreathrate(String breathrate) {
        this.breathrate = breathrate;
    }

    public String getPulserate() {
        return pulserate;
    }

    public void setPulserate(String pulserate) {
        this.pulserate = pulserate;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public String getRightbloodpressure() {
        return rightbloodpressure;
    }

    public void setRightbloodpressure(String rightbloodpressure) {
        this.rightbloodpressure = rightbloodpressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPercentageofoxygensaturation() {
        return percentageofoxygensaturation;
    }

    public void setPercentageofoxygensaturation(String percentageofoxygensaturation) {
        this.percentageofoxygensaturation = percentageofoxygensaturation;
    }
}
