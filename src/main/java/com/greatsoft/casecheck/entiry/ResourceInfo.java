package com.greatsoft.casecheck.entiry;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:菜单表对应的实体
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:36
 */
public class ResourceInfo implements Serializable {
    private static final long serialVersionUID = -1498222730550823591L;

    private String id;
    /**
     * 业务id
     */
    private String lid;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 父id（取id）
     */
    private String pid;
    /**
     * 访问url
     */
    private String url;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 创建时间
     */
    private Date create;
    /**
     * 更新时间
     */
    private Date modified;
    /**
     * 状态(0正常)
     */
    private int status;
    /**
     * 是否删除(0正常)
     */
    private int isDelete;
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
     * 更新人姓名
     */
    private String modifier;
    /**
     * 菜单位置序号
     */
    private String serialNo;
    /**
     * 是否是叶子节点
     */
    private int isLeaf;
    /**
     * 是否第三程序地址(0不是，1是)
     */
    private int isOtherProgram;
    /**
     * 菜单级别
     */
    private int leve;
    /**
     * 基准地址的业务主键
     */
    private String urlLid;
    /**
     * extend 是否选中标志位(0不是，1是)
     */
    private int isChoose;
    /**
     * extend 跳转页面全路径
     */
    private String totalUrl;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int getIsOtherProgram() {
        return isOtherProgram;
    }

    public void setIsOtherProgram(int isOtherProgram) {
        this.isOtherProgram = isOtherProgram;
    }

    public int getLeve() {
        return leve;
    }

    public void setLeve(int leve) {
        this.leve = leve;
    }

    public String getUrlLid() {
        return urlLid;
    }

    public void setUrlLid(String urlLid) {
        this.urlLid = urlLid;
    }

    public int getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(int isChoose) {
        this.isChoose = isChoose;
    }

    public String getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(String totalUrl) {
        this.totalUrl = totalUrl;
    }

    @Override
    public String toString() {
        return "ResourceInfo{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", modifierId='" + modifierId + '\'' +
                ", modifier='" + modifier + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", isLeaf=" + isLeaf +
                ", isOtherProgram=" + isOtherProgram +
                ", leve=" + leve +
                ", urlLid='" + urlLid + '\'' +
                ", isChoose=" + isChoose +
                ", totalUrl='" + totalUrl + '\'' +
                '}';
    }
}
