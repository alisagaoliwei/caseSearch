package com.greatsoft.casecheck.entiry;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:基准地址表对应的实体
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/13 9:36
 */
public class UrlBasePath implements Serializable {
    private static final long serialVersionUID = -7746470002155438905L;
    private String id;
    /**
     * 业务主键
     */
    private String lid;
    /**
     * 基准地址名称
     */
    private String name;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 基准地址ip
     */
    private String ip;
    /**
     * 基准地址端口号
     */
    private int port;
    /**
     * 基准地址路径
     */
    private String path;
    /**
     * 状态(0正常)
     */
    private int status;
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
     * 创建时间
     */
    private Date create;
    /**
     * 更新时间
     */
    private Date modified;

    /**
     * extend 基准地址全拼
     * @return
     */
    private String totalBasePath;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getTotalBasePath() {
        return totalBasePath;
    }

    public void setTotalBasePath(String totalBasePath) {
        this.totalBasePath = totalBasePath;
    }

    @Override
    public String toString() {
        return "UrlBasePath{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", path='" + path + '\'' +
                ", status=" + status +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", modifierId='" + modifierId + '\'' +
                ", modifier='" + modifier + '\'' +
                ", create=" + create +
                ", modified=" + modified +
                ", totalBasePath='" + totalBasePath + '\'' +
                '}';
    }
}