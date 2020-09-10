package com.xyj.strokeaid.bean;

import java.util.List;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：数组
 */
public class BaseArrayBean<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : [] 数组
     */

    private int result;
    private String message;
    private List<T> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
