package com.xyj.strokeaid.app;

import android.Manifest;

/**
 * Constants
 * description: app 常量保存
 *
 * @author : Licy
 * @date : 2020/8/12
 * email ：licy3051@qq.com
 */
public class Constants {

    public static final String[] HOME_TAB_TITLES = new String[]{"急救中", "已转归", "已上报"};
    public static final String[] LOGIN_TAB_TITLE = new String[]{"密码登录", "验证码登录"};
    public static final String[] STROKE_MEDICATION_TITLES = new String[]{"静脉溶栓", "住院用药"};
    public static final String[] AUXILIARY_EXAM_TITLES = new String[]{"心电", "CT", "核磁", "超声"};
    public static final String[] GREEN_CHANNEL_STROKE_MENU_TITLES = new String[]{
            "分诊信息",
            "生命体征",
            "病情记录",
            "卒中评估",
            "启动绿道",
            "血液检查",
            "辅助检查",
            "诊断评估",
            "药物治疗",
            "手术治疗",
            "其他处置",
            "转归交接",
            "时间节点"
    };

    public static final String[] GREEN_CHANNEL_CHEST_PAIN_MENU_TITLES = new String[]{
            "分诊信息",
            "生命体征",
            "病情记录",
            "心电检查",
            "会诊信息",
            "血液检查",
            "影像检查",
            "初始诊断",
            "初始药物",
            "治疗决策",
            "静脉溶栓",
            "手术治疗",
            "其他处置",
            "患者转归",
            "时间节点"};

    public static final String[] GREEN_CHANNEL_TRAUMA_MENU_TITLES = new String[]{
            "发病现场",
            "急诊救治",
            "检验信息",
            "心电检查",
            "影像检查",
            "会诊信息",
            "EICU/ICU",
            "手术信息",
            "患者转归"};

    public static final String[] GREEN_CHANNEL_MATERNAL_MENU_TITLES = new String[]{
            "生命体征",
            "危重孕产妇"};

    public static final String[] GREEN_CHANNEL_CHILD_MENU_TITLES = new String[]{
            "生命体征",
            "危重儿童"};

    public static final String[] CHEST_OTHER_DISPOSAL_TITLES = new String[]{"急诊CT", "彩超"};
    public static final String[] CHEST_HEART_IN_OUT_TITLES = new String[]{"心内会诊", "外科会诊"};

    /**
     * 基本权限管理
     */
    public static final String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET,
//            Manifest.permission.MODIFY_AUDIO_SETTINGS,
//            Manifest.permission.WRITE_SETTINGS,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.REQUEST_INSTALL_PACKAGES
    };

    public static final String[] CHEST_PAIN_DIAGNOSE_CONTENT = new String[]{
            "STEMI", "NSTEMI", "UA", "主动脉夹层", "肺动脉栓塞", "非ACS心源性胸痛", "其他非心源性胸痛"
    };

    public static final String BOOL_TRUE = "cpc_bool_true";
    public static final String BOOL_FALSE = "cpc_bool_false";
}

    
    
       
    