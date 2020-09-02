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

    /**
     * 新建患者
     */
    public static final String NEW_PATIENT = "/app/add/patient";

    /**
     * 个人中心
     */
    public static final String PERSONAL_INFO = "/app/personal/info";

    public static final class Stroke {
        /**
         * 卒中患者病历页面
         */
        public static final String STROKE_HOME = "/app/stroke/home";
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

        /**
         * FAST评分
         */
        public static final String STROKE_FAST_ED__SCORE = "/app/stroke/fast_ed_score";

        /**
         * ASPECT评分
         */
        public static final String STROKE_ASPECT_SCORE = "/app/stroke/aspect_score";


        /**
         * mRS评分
         */
        public static final String STROKE_MRS_SCORE = "/app/stroke/mrs_score";


        /**
         * GCS评分
         */
        public static final String STROKE_GCS_SCORE = "/app/stroke/gcs_score";


        /**
         * Fisher分级
         */
        public static final String STROKE_FiISHEER_SCORE = "/app/stroke/fisher_score";

        /**
         * Hunt-Hess评分
         */
        public static final String STROKE_HUNT_HESS_SCORE = "/app/stroke/hunt_hess_score";


        /**
         * CHADS2评分
         */
        public static final String STROKE_CHADS2_SCORE = "/app/stroke/chads2_score";

        /**
         * HAS-BLED评分
         */
        public static final String STROKE_HAS_BLED_SCORE = "/app/stroke/has_bled_score";

        /**
         * 洼田吞咽评定
         */
        public static final String STROKE_FROG_FIELD_EVALUATE = "/app/stroke/frog_field_evaluate_score";

        /**
         * Spetzler-Marin评分
         */
        public static final String STROKE_SPETZLER_MARINSCORE = "/app/stroke/spetzler_marin_score";


    }

    public static final class ChestPain {
        /**
         * 胸痛患者病历页面
         */
        public static final String CHEST_PAIN_HOME = "/app/chestpain/home";
    }

    public static final class Trauma {
        /**
         * 创伤患者病历页面
         */
        public static final String TRAUMA_HOME = "/app/trauma/home";
    }

    public static final class MaternalTreat {
        /**
         * 危重孕产妇患者病历页面
         */
        public static final String MATERNAL_TREAT_HOME = "/app/maternal/home";
    }

    public static final class ChildTreat {
        /**
         * 危重儿童患者病历页面
         */
        public static final String CHILD_TREAT_HOME = "/app/child/home";
    }

    public static final class Detection {
        /**
         * 病情记录
         */
        public static final String ILLNESS_RECORD = "/app/detection/illness";

        /**
         * 患者到达CT室
         */
        public static final String PATIENT_ARRIVAL = "/app/detection/patientArrival";
    }
}

    
    
       
    