package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

import java.util.List;

public class ChestpainEcgDetailBean extends BaseBean<ChestpainEcgDetailBean> {

    private String ecgisexist;
    private String ecgnotexistreason;
    private String ecgisremotetransmission;
    private String ecgremotetransmissiontime;
    private String ecgremotetransmissionway;
    private List<EcgarrayBean> ecgarray;


    public String getEcgisexist() {
        return ecgisexist;
    }

    public void setEcgisexist(String ecgisexist) {
        this.ecgisexist = ecgisexist;
    }

    public String getEcgnotexistreason() {
        return ecgnotexistreason;
    }

    public void setEcgnotexistreason(String ecgnotexistreason) {
        this.ecgnotexistreason = ecgnotexistreason;
    }

    public String getEcgisremotetransmission() {
        return ecgisremotetransmission;
    }

    public void setEcgisremotetransmission(String ecgisremotetransmission) {
        this.ecgisremotetransmission = ecgisremotetransmission;
    }

    public String getEcgremotetransmissiontime() {
        return ecgremotetransmissiontime;
    }

    public void setEcgremotetransmissiontime(String ecgremotetransmissiontime) {
        this.ecgremotetransmissiontime = ecgremotetransmissiontime;
    }

    public String getEcgremotetransmissionway() {
        return ecgremotetransmissionway;
    }

    public void setEcgremotetransmissionway(String ecgremotetransmissionway) {
        this.ecgremotetransmissionway = ecgremotetransmissionway;
    }

    public List<EcgarrayBean> getEcgarray() {
        return ecgarray;
    }

    public void setEcgarray(List<EcgarrayBean> ecgarray) {
        this.ecgarray = ecgarray;
    }

    public static class EcgarrayBean {

        private String ecgtime;
        private String ecgfile;
        private String ecgdiagnosistime;
        private String ecgdiagnosed;
        private String ecgrepguid;


        public String getEcgtime() {
            return ecgtime;
        }

        public void setEcgtime(String ecgtime) {
            this.ecgtime = ecgtime;
        }

        public String getEcgfile() {
            return ecgfile;
        }

        public void setEcgfile(String ecgfile) {
            this.ecgfile = ecgfile;
        }

        public String getEcgdiagnosistime() {
            return ecgdiagnosistime;
        }

        public void setEcgdiagnosistime(String ecgdiagnosistime) {
            this.ecgdiagnosistime = ecgdiagnosistime;
        }

        public String getEcgdiagnosed() {
            return ecgdiagnosed;
        }

        public void setEcgdiagnosed(String ecgdiagnosed) {
            this.ecgdiagnosed = ecgdiagnosed;
        }

        public String getEcgrepguid() {
            return ecgrepguid;
        }

        public void setEcgrepguid(String ecgrepguid) {
            this.ecgrepguid = ecgrepguid;
        }
    }
}
