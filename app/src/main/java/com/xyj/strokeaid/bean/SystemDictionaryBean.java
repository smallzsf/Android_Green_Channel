package com.xyj.strokeaid.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * SystemDictionaryBean
 * description: 系统字典类，解析字典
 *
 * @author : Licy
 * @date : 2020/9/3
 * email ：licy3051@qq.com
 */
@Entity
public class SystemDictionaryBean {

    @Id(autoincrement = true)
    private Long id;
    @Index(unique = true)
    private String perNo;
    private String name;
    private String sex;

    @Generated(hash = 199660747)
    public SystemDictionaryBean(Long id, String perNo, String name, String sex) {
        this.id = id;
        this.perNo = perNo;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 1583954083)
    public SystemDictionaryBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPerNo() {
        return this.perNo;
    }
    public void setPerNo(String perNo) {
        this.perNo = perNo;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

}

    
    
       
    