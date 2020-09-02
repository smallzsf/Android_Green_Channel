package com.xyj.strokeaid.app;

/**
 * IntentKey
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public final class IntentKey {
    public static final String PATIENT_ID = "PATIENT_ID";
    public static final String DOC_ID = "DOC_ID";
    public static final String DIALOG_MSG = "DIALOG_MSG";
    /**
     * NIHSS 评分 类型
     * 1、  首次
     * 2、  溶栓前
     * 3、  溶栓后即刻
     */
    public static final String NIHSS_TYPE = "NIHSS_TYPE";

    /**
     * 患者类型
     * 1、 卒中
     * 2、 胸痛
     * 3、 创伤
     * 4、 危重孕产妇
     * 5、 危重儿童和新生儿
     */
    public static final String PATIENT_TYPE = "PATIENT_TYPE";

    /**
     * 查看类型
     * 1、 新建
     * 2、 查看
     */
    public static final String VIEW_TYPE = "VIEW_TYPE";
}