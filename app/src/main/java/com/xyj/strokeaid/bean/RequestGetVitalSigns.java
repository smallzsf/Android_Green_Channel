package com.xyj.strokeaid.bean;

public class RequestGetVitalSigns {
    
    public String recordId;//记录ID

    public String consciousness; //意识

    public String breathrate;//呼吸

    public String pulserate;//脉搏

    public String heartrate;//心率

    public String bloodpressure;//左上肢血压

    public String rightbloodpressure;//右上肢血压

    public String systolicpressure;//收缩压

    public String diastolicpressure;//舒张压

    public String temperature;//温度

    public String percentageofoxygensaturation;//血氧饱和度

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

    public String getSystolicpressure() {
        return systolicpressure;
    }

    public void setSystolicpressure(String systolicpressure) {
        this.systolicpressure = systolicpressure;
    }

    public String getDiastolicpressure() {
        return diastolicpressure;
    }

    public void setDiastolicpressure(String diastolicpressure) {
        this.diastolicpressure = diastolicpressure;
    }
}
