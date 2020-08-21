package com.xyj.strokeaid.bean;

import com.chad.library.adapter.base.entity.JSectionEntity;
import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * StrokeTCBean
 * description: 卒中溶栓禁忌症的 item bean
 *
 * @author : Licy
 * @date : 2020/8/21
 * email ：licy3051@qq.com
 */
public class StrokeTCBean extends JSectionEntity {

    private boolean header;
    private String content;
    private boolean checked;
    private String id;

    public StrokeTCBean(boolean header, String content, boolean checked, String id) {
        this.header = header;
        this.content = content;
        this.checked = checked;
        this.id = id;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isHeader() {
        return header;
    }
}

    
    
       
    