package com.greatsoft.casecheck.dto.resource;

import com.greatsoft.casecheck.entiry.ResourceInfo;
import com.greatsoft.casecheck.entiry.UrlBasePath;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/8 3:10 PM
 */
public class ResourceResponseDTO {
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
    private String create;
    /**
     * 更新时间
     */
    private String modified;
    /**
     * 创建人账号
     */
    private String creator;
    /**
     * 更新人账号
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
     * 父id菜单名称
     */
    private String perentName;
    /**
     * 基准地址的业务主键
     */
    private String urlLid;

    private List<UrlBasePath> urlBasePaths = new ArrayList<>();

    public ResourceResponseDTO() {

    }

    public ResourceResponseDTO(ResourceInfo resourceInfo) {
        this.id = resourceInfo.getId();
        this.lid = resourceInfo.getLid();
        this.name = resourceInfo.getName();
        this.pid = resourceInfo.getPid();
        this.url = resourceInfo.getUrl();
        this.icon = resourceInfo.getIcon();
        this.serialNo = resourceInfo.getSerialNo();
        this.isLeaf = resourceInfo.getIsLeaf();
        this.isOtherProgram = resourceInfo.getIsOtherProgram();
        this.leve = resourceInfo.getLeve();
        this.creator = resourceInfo.getCreator();
        this.modifier = resourceInfo.getModifier();
        this.urlLid = resourceInfo.getUrlLid();
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

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getPerentName() {
        return perentName;
    }

    public void setPerentName(String perentName) {
        this.perentName = perentName;
    }

    public String getUrlLid() {
        return urlLid;
    }

    public void setUrlLid(String urlLid) {
        this.urlLid = urlLid;
    }

    public List<UrlBasePath> getUrlBasePaths() {
        return urlBasePaths;
    }

    public void setUrlBasePaths(List<UrlBasePath> urlBasePaths) {
        this.urlBasePaths = urlBasePaths;
    }

    @Override
    public String toString() {
        return "ResourceResponseDTO{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", create='" + create + '\'' +
                ", modified='" + modified + '\'' +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", isLeaf=" + isLeaf +
                ", isOtherProgram=" + isOtherProgram +
                ", leve=" + leve +
                ", perentName='" + perentName + '\'' +
                ", urlLid='" + urlLid + '\'' +
                ", urlBasePaths=" + urlBasePaths +
                '}';
    }
}
