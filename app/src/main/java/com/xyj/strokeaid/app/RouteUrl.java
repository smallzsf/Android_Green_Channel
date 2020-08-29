package com.xyj.strokeaid.app;

/**
 * RouteUrl
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/20
 * email ：licy3051@qq.com
 */
public final class RouteUrl {

    public static final class Stroke {
        /**
         * 急诊绿道转归
         */
        public static final String STROKE_GREEN_CHANNEL_OUTCOME = "/app/stroke/outcome";
        /**
         * 溶栓医生接诊时间
         */
        public static final String STROKE_THROMBOLYSIS_DOC_RECEIVE = "/app/stroke/t/dr";
        /**
         * 溶栓适应症
         */
        public static final String STROKE_THROMBOLYSIS_INDICATIONS = "/app/stroke/t/indications";
        /**
         * 溶栓禁忌症
         */
        public static final String STROKE_THROMBOLYSIS_CONTRAINDICATIONS = "/app/stroke/t/contraindications";
        /**
         * 溶栓知情同意
         */
        public static final String STROKE_THROMBOLYSIS_INFORMED_CONSENT = "/app/stroke/t/informedconsent";
        /**
         * 溶栓NIHSS评分
         */
        public static final String STROKE_NIHSS = "/app/stroke/nihss";
        /**
         * THRIVE评分
         */
        public static final String STROKE_THRIVE_SCORE = "/app/stroke/thrive";
        /**
         * 静脉溶栓
         */
        public static final String STROKE_THROMBOLYSIS_INTRAVENOU = "/app/stroke/t/intravenou";
        /**
         * 溶栓并发症
         */
        public static final String STROKE_THROMBOLYSIS_COMPLICATIONS = "/app/stroke/t/complication";
        /**
         * 溶栓延误分析
         */
        public static final String STROKE_THROMBOLYSIS_DELAY = "/app/stroke/t/delay";
        public static final String STROKE_INTRAVENOU_THROMBOLYSIS = "/app/stroke/sit";

        /**
         * 介入适应症
         */
        public static final String STROKE_GET_INVOLVED_INDICATIONS = "/app/stroke/involved_indications";
        /**
         * 介入禁忌症
         */
        public static final String STROKE_GET_INVOLVED_CONTRAINDICATIONS = "/app/stroke/involved_icontraindications";
        /**
         * 介入知情同意
         */
        public static final String STROKE_GET_INVOLVED_INFORMED_CONSENT = "/app/stroke/informedconsent";
        public static final String STROKE_INVOLVED_OPERATION_AFTER = "/app/stroke/involved/operationafter";
        public static final String STROKE_INVOLVED_OPERATION_BEFORE = "/app/stroke/involved/operationbefore";
        public static final String STROKE_INVOLVED_OPERATION_ON = "/app/stroke/involved/operationon";


    }
    public static final class Detection {
        /**
         * 病情记录
         */
        public static final String ILLNESS_RECORD="/app/detection/illness";

        /**
         * 患者到达CT室
         */
        public static final String PATIENT_ARRIVAL="/app/detection/patientArrival";
    }
}

    
    
       
    