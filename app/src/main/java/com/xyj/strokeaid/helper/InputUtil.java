package com.xyj.strokeaid.helper;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DG on 2017/8/16.
 */

public class InputUtil {

    static Toast toast;

    //隐藏软键盘
    public static void hideinpput(Activity activity) {
        try {
            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }

    public static void limitEditArea(final Context context, EditText editText, final int min, final int max) {
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                try {
                    int input = Integer.parseInt(dest.toString() + source.toString());
                    if (isInRange(min, max, input))
                        return null;
                    else {
                        showshowToast(context, "超出输入范围：" + min + "~" + max);
                        return "";
                    }
                } catch (NumberFormatException nfe) {
                }
                return "";
            }

            private boolean isInRange(int a, int b, int c) {
                return b > a ? c >= a && c <= b : c >= b && c <= a;
            }
        }
        });
    }

    /**
     * @param editText          输入框
     * @param maxZhengshulength 最大整数长度
     * @param maxXiaoshulength  最大小数长度
     */
    public static void limitEdit(final Context context, EditText editText, final int maxZhengshulength, final int maxXiaoshulength) {
        if (maxXiaoshulength == 0) {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        } else {
            editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
        }


        editText.setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // source 即将被显示到输入框上的单个字符，每次是一个长度
                // dest 是现有的值
                // return 值将被拼接于现有dest 上
                // 删除等特殊字符，直接返回
                Log.e("limitEdit", "source=" + source + " start=" + start + " end=" + end);
                Log.e("limitEdit", "dest=" + dest + " dstart=" + dstart + " dend=" + dend);
                if ("".equals(source.toString())) {
                    return null;
                }
                //要求，
                //1，首字符输入.时候，自动补0
                //2，整数部分最大X位
                //3，小数部分最大Y位
                StringBuilder sb = new StringBuilder(dest.toString());
                sb.insert(dstart, source.toString());
                String str = sb.toString();
                if (str.startsWith(".") && maxXiaoshulength == 0) {
                    return "";
                }
                if (str.startsWith(".") && maxXiaoshulength != 0)
                    return "0.";
                String[] values = str.split("\\.");


                if (values.length > 1) {
                    String dotvalues = values[1];
                    String intvalues = values[0];
                    if (dotvalues.length() > maxXiaoshulength || intvalues.length() > maxZhengshulength) {
                        //提示最大小数位长度
                        showshowToast(context, "最多输入" + maxZhengshulength + "位整数" + maxXiaoshulength + "位小数");
                        return "";
                    } else {
                        return source;
                    }
                } else {
                    String intvalues = values[0];
                    if (intvalues.length() > maxZhengshulength) {
                        //提示最大整数位长度
                        showshowToast(context, "最多输入" + maxZhengshulength + "位整数");
                        return "";
                    } else {
                        return source;
                    }
                }


            }
        }
                , new DigitsKeyListener(false, true)});

    }


    private static void showshowToast(Context context, String text) {

        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * @param textView          输入框
     * @param maxZhengshulength 最大整数长度
     * @param maxXiaoshulength  最大小数长度
     */
    public static void limitText(final Context context, TextView textView, final int maxZhengshulength, final int maxXiaoshulength) {
        textView.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);

        textView.setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // source 即将被显示到输入框上的单个字符，每次是一个长度
                // dest 是现有的值
                // return 值将被拼接于现有dest 上
                // 删除等特殊字符，直接返回
//                Log.e("limitEdit","source="+source+" start="+start+" end="+end);
//                Log.e("limitEdit","dest="+dest+" dstart="+dstart+" dend="+dend);
                if ("".equals(source.toString())) {
                    return null;
                }
                //要求，
                //1，首字符输入.时候，自动补0
                //2，整数部分最大X位
                //3，小数部分最大Y位
                String str = dest.toString() + source.toString();
                if (str.startsWith("."))
                    return "0.";
                String[] values = str.split("\\.");
                if (values.length > 1) {
                    String dotvalues = values[1];
                    if (dotvalues.length() > maxXiaoshulength) {
                        //提示最大小数位长度
                        showshowToast(context, "最多输入" + maxXiaoshulength + "位小数");
                        return "";
                    } else {
                        return source;
                    }
                } else {
                    String intvalues = values[0];
                    if (intvalues.length() > maxZhengshulength) {
                        //提示最大整数位长度
                        showshowToast(context, "最多输入" + maxZhengshulength + "位整数");
                        return "";
                    } else {
                        return source;
                    }
                }
            }
        }
                , new DigitsKeyListener(false, true)});
    }
}
