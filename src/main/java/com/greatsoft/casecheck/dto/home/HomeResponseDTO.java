package com.greatsoft.casecheck.dto.home;

import com.greatsoft.casecheck.entiry.ResourceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:home页菜单栏展示实体
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/11 9:47 AM
 */
public class HomeResponseDTO {

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
     * 是否选中标志位(0不是，1是)
     */
    private int isChoose;
    /**
     * extend 跳转页面全路径
     */
    private String totalUrl;
    /**
     * 子类菜单集合
     */
    private List<HomeResponseDTO> childrenList = new ArrayList<>();

    public HomeResponseDTO() {
    }

    public HomeResponseDTO(ResourceInfo resourceInfo) {
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
        this.isChoose = resourceInfo.getIsChoose();
        this.totalUrl = resourceInfo.getTotalUrl();
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

    public List<HomeResponseDTO> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<HomeResponseDTO> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "HomeResponseDTO{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", isLeaf=" + isLeaf +
                ", isOtherProgram=" + isOtherProgram +
                ", leve=" + leve +
                ", isChoose=" + isChoose +
                ", totalUrl='" + totalUrl + '\'' +
                ", childrenList=" + childrenList +
                '}';
    }
}
