package com.greatsoft.casecheck.dto.role;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 12:50
 */
public class RoleResponseDTO {
    /**
     * 业务id
     */
    private String lid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 权限树
     */
    private Object object;
    public RoleResponseDTO() {
    }

    public RoleResponseDTO(String lid, String name) {
        this.lid = lid;
        this.name = name;
    }

    public RoleResponseDTO(String lid, String name, Object object) {
        this.lid = lid;
        this.name = name;
        this.object = object;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "RoleResponseDTO{" +
                "lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", object=" + object +
                '}';
    }
}
