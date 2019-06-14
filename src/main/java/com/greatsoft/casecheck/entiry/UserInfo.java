package com.greatsoft.casecheck.entiry;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:人员信息表对应实体
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 9:53
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 154029451683536069L;

    private String id;
    /**
     * 业务id
     */
    private String lid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件类型
     */
    private String idType;
    /**
     * 证件号
     */
    private String idNo;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 创建时间
     */
    private Date create;
    /**
     * 更新时间
     */
    private Date modified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", idType='" + idType + '\'' +
                ", idNo='" + idNo + '\'' +
                ", phone='" + phone + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                '}';
    }
}
