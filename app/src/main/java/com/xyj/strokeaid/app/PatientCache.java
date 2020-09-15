package com.xyj.strokeaid.app;

import com.xyj.strokeaid.bean.MainListBean;

public class PatientCache {

    /**
     *
     */
    public static String id = "";


    private static MainListBean infoBean;

    public static MainListBean getInfoBean() {
        return infoBean;
    }

    public static void setInfoBean(MainListBean infoBean) {
        PatientCache.infoBean = infoBean;
    }

    public static String getRecordId(){
        if (infoBean == null){
            return "";
        }
        return infoBean.getId();
    }



}
