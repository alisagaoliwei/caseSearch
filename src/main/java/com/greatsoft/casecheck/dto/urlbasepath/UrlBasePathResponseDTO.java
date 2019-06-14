package com.greatsoft.casecheck.dto.urlbasepath;

import com.greatsoft.casecheck.entiry.UrlBasePath;
import com.greatsoft.casecheck.util.DateUtil;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/13 9:53 AM
 */
public class UrlBasePathResponseDTO {
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
    private Integer port;
    /**
     * 基准地址路径
     */
    private String path;
    /**
     * 创建时间
     */
    private String create;

    public UrlBasePathResponseDTO() {
    }

    public UrlBasePathResponseDTO(UrlBasePath urlBasePath) {
        this.lid = urlBasePath.getLid();
        this.name = urlBasePath.getName();
        this.ip = urlBasePath.getIp();
        this.port = urlBasePath.getPort();
        this.path = urlBasePath.getPath();
        this.create = DateUtil.format(urlBasePath.getCreate(), "yyyy-MM-dd");
        this.prefix= urlBasePath.getPrefix();
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }
}
