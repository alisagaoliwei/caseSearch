package com.greatsoft.casecheck.entiry;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:角色表对应实体
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:36
 */
public class  Role implements Serializable{
    private static final long serialVersionUID = 154029451683536069L;

    private String id;
    /**
     * 业务id
     */
    private String lid;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否删除(0正常)
     */
    private int status;
    /**
     * 状态(0正常)
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date create;
    /**
     * 更新时间
     */
    private Date modified;
    /**
     * 创建人id(取账号表id)
     */
    private String creatorId;
    /**
     * 创建人姓名
     */
    private String creator;
    /**
     * 更新人id(取账号表id)
     */
    private String modifierId;
    /**
     * 创建人姓名
     */
    private String modifier;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", create=" + create +
                ", modified=" + modified +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", modifierId='" + modifierId + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
