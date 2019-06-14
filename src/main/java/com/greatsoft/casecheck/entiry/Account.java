package com.greatsoft.casecheck.entiry;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:账号表对应的实体
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:35
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 7557866667766941196L;

    private String id;
    /**
     * 业务id
     */
    private String lid;
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态（0正常）
     */
    private int status;
    /**
     * 是否删除（0未删除）
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date create;
    /**
     * 修改时间
     */
    private Date modified;
    /**
     * 创建人id（账号表中id）
     */
    private String creatorId;
    /**
     * 创建人姓名
     */
    private String creator;
    /**
     * 修改人id（账号表中id）
     */
    private String modifierId;
    /**
     * 修改人姓名
     */
    private String modifier;
    /**
     * 用户lid
     */
    private String userLid;
    /**
     * 角色lid
     */
    private String roleLid;

    /**
     * 账户所属人姓名
     */
    private String name;
    /**
     * 账号对应权限
     */
    private String roleName;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUserLid() {
        return userLid;
    }

    public void setUserLid(String userLid) {
        this.userLid = userLid;
    }

    public String getRoleLid() {
        return roleLid;
    }

    public void setRoleLid(String roleLid) {
        this.roleLid = roleLid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", create=" + create +
                ", modified=" + modified +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", modifierId='" + modifierId + '\'' +
                ", modifier='" + modifier + '\'' +
                ", userLid='" + userLid + '\'' +
                ", roleLid='" + roleLid + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
