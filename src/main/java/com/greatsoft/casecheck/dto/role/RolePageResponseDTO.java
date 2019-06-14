package com.greatsoft.casecheck.dto.role;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 12:50
 */
public class RolePageResponseDTO {
    /**
     * 业务id
     */
    private String lid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 操作人姓名
     */
    private String creator;
    /**
     * 操作时间
     */
    private String create;

    public RolePageResponseDTO() {
    }

    public RolePageResponseDTO(String lid, String name, String creator, String create) {
        this.lid = lid;
        this.name = name;
        if (StringUtils.isEmpty(creator)) {
            this.creator = "";
        } else {
            this.creator = creator;
        }

        this.create = create;
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

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "RolePageResponseDTO{" +
                "lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", create='" + create + '\'' +
                '}';
    }
}
