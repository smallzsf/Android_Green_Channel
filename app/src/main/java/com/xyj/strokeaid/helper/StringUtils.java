package com.xyj.strokeaid.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
  * @Package:        com.xyj.strokeaid.helper
  * @ClassName:      StringUtils
  * @Description:    字符串工具类
  * @Autho:          王水雷
  * @Time:           2020/8/21
 */
public class StringUtils {

    // 判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0 || str.equalsIgnoreCase("null");
    }

    //是否是图片地址
    public static boolean isPhoto(String str) {
        if (!isEmpty(str)) {
            return str.endsWith(".bmp") ||str.endsWith(".BMP") ||
                    str.endsWith(".jpg")||str.endsWith(".JPG")||
                    str.endsWith(".png")||str.endsWith(".PNG");
        }
        return false;
    }

    //是否是视频地址
    public static boolean isVideo(String str) {
        if (!isEmpty(str)) {
            return str.endsWith(".MP4") ||str.endsWith(".mp4") ||
                    str.endsWith(".rmvb")||str.endsWith(".RMVB")||
                    str.endsWith(".avi")||str.endsWith(".AVI")||
                    str.endsWith(".3gp")||str.endsWith(".3GP")||
                    str.endsWith(".flv")||str.endsWith(".FLV");
        }
        return false;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumer(String str) {
        if (isEmpty(str)) return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
}
