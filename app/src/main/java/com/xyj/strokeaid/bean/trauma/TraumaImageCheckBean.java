package com.xyj.strokeaid.bean.trauma;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * TraumaImageCheckBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/11
 * email ：licy3051@qq.com
 */
public class TraumaImageCheckBean {

    /**
     * 记录id
     */
    private String recordId;

    /**
     * 检查项目逗号隔开 1 CT平扫 2 增强CT 3 三维重建 4 CTA 5 CTP 6 MRI  7 彩超  8 DR  9 DSA 10 其他
     */
    private String inspectionitems;

    private List<TraumaImageCheckDetailBean> inspectionitemarray;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getInspectionitems() {
        return inspectionitems;
    }

    public void setInspectionitems(String inspectionitems) {
        this.inspectionitems = inspectionitems;
    }

    public List<TraumaImageCheckDetailBean> getInspectionitemarray() {
        return inspectionitemarray;
    }

    public void setInspectionitemarray(List<TraumaImageCheckDetailBean> inspectionitemarray) {
        this.inspectionitemarray = inspectionitemarray;
    }

    public static class TraumaImageCheckDetailBean implements Parcelable {

        /**
         * 记录id
         */
        private String recordId;

        /**
         * 检查项目 1 CT平扫 2 增强CT 3 三维重建 4 CTA 5 CTP 6 MRI  7 彩超  8 DR  9 DSA 10 其他
         */
        private String inspectionitem;

        /**
         * 医嘱开立时间
         */
        private String indoctoradvicetime;

        /**
         * 患者到达时间
         */
        private String inpatientarrivaltime;

        /**
         * 患者离开时间
         */
        private String inpatientleavetime;

        /**
         * 检查完成时间
         */
        private String incheckcompletedtime;

        /**
         * 检查报告时间
         */
        private String incheckreporttime;

        /**
         * 诊断结果
         */
        private String indiagnosisresult;

        /**
         * 检查片子
         */
        private String incheckfilm;

        /**
         * 检查报告
         */
        private String incheckreport;

        public TraumaImageCheckDetailBean(String inspectionitem) {
            this.inspectionitem = inspectionitem;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getInspectionitem() {
            return inspectionitem;
        }

        public void setInspectionitem(String inspectionitem) {
            this.inspectionitem = inspectionitem;
        }

        public String getIndoctoradvicetime() {
            return indoctoradvicetime;
        }

        public void setIndoctoradvicetime(String indoctoradvicetime) {
            this.indoctoradvicetime = indoctoradvicetime;
        }

        public String getInpatientarrivaltime() {
            return inpatientarrivaltime;
        }

        public void setInpatientarrivaltime(String inpatientarrivaltime) {
            this.inpatientarrivaltime = inpatientarrivaltime;
        }

        public String getInpatientleavetime() {
            return inpatientleavetime;
        }

        public void setInpatientleavetime(String inpatientleavetime) {
            this.inpatientleavetime = inpatientleavetime;
        }

        public String getIncheckcompletedtime() {
            return incheckcompletedtime;
        }

        public void setIncheckcompletedtime(String incheckcompletedtime) {
            this.incheckcompletedtime = incheckcompletedtime;
        }

        public String getIncheckreporttime() {
            return incheckreporttime;
        }

        public void setIncheckreporttime(String incheckreporttime) {
            this.incheckreporttime = incheckreporttime;
        }

        public String getIndiagnosisresult() {
            return indiagnosisresult;
        }

        public void setIndiagnosisresult(String indiagnosisresult) {
            this.indiagnosisresult = indiagnosisresult;
        }

        public String getIncheckfilm() {
            return incheckfilm;
        }

        public void setIncheckfilm(String incheckfilm) {
            this.incheckfilm = incheckfilm;
        }

        public String getIncheckreport() {
            return incheckreport;
        }

        public void setIncheckreport(String incheckreport) {
            this.incheckreport = incheckreport;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.recordId);
            dest.writeString(this.inspectionitem);
            dest.writeString(this.indoctoradvicetime);
            dest.writeString(this.inpatientarrivaltime);
            dest.writeString(this.inpatientleavetime);
            dest.writeString(this.incheckcompletedtime);
            dest.writeString(this.incheckreporttime);
            dest.writeString(this.indiagnosisresult);
            dest.writeString(this.incheckfilm);
            dest.writeString(this.incheckreport);
        }

        public TraumaImageCheckDetailBean() {
        }

        protected TraumaImageCheckDetailBean(Parcel in) {
            this.recordId = in.readString();
            this.inspectionitem = in.readString();
            this.indoctoradvicetime = in.readString();
            this.inpatientarrivaltime = in.readString();
            this.inpatientleavetime = in.readString();
            this.incheckcompletedtime = in.readString();
            this.incheckreporttime = in.readString();
            this.indiagnosisresult = in.readString();
            this.incheckfilm = in.readString();
            this.incheckreport = in.readString();
        }

        public static final Parcelable.Creator<TraumaImageCheckDetailBean> CREATOR = new Parcelable.Creator<TraumaImageCheckDetailBean>() {
            @Override
            public TraumaImageCheckDetailBean createFromParcel(Parcel source) {
                return new TraumaImageCheckDetailBean(source);
            }

            @Override
            public TraumaImageCheckDetailBean[] newArray(int size) {
                return new TraumaImageCheckDetailBean[size];
            }
        };
    }
}

    
    
       
    