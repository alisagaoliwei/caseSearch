package com.greatsoft.casecheck.dto.resource;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/9 2:22 PM
 */
public class RequestResourceDTO {
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
    private int serialNo;
    /**
     * 是否第三程序地址(0不是，1是)
     */
    private int isOtherProgram;
    /**
     * 菜单级别
     */
    private int leve;

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

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
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

    @Override
    public String toString() {
        return "RequestResourceDTO{" +
                "id='" + id + '\'' +
                ", lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", serialNo=" + serialNo +
                ", isOtherProgram=" + isOtherProgram +
                ", leve=" + leve +
                '}';
    }
}
