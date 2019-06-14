package com.greatsoft.casecheck.entiry;

import java.io.Serializable;

/**
 * @Description:角色菜单关系表对应实体
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:36
 */
public class RoleResourceInfo implements Serializable{
    private static final long serialVersionUID = -6836366681042695594L;

    private String id;
    /**
     * 角色lid
     */
    private String roleLid;
    /**
     * 菜单lid
     */
    private String resourceLid;

    public RoleResourceInfo(){}

    public RoleResourceInfo(String id,String roleLid,String resourceLid){
        this.id=id;
        this.roleLid=roleLid;
        this.resourceLid=resourceLid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleLid() {
        return roleLid;
    }

    public void setRoleLid(String roleLid) {
        this.roleLid = roleLid;
    }

    public String getResourceLid() {
        return resourceLid;
    }

    public void setResourceLid(String resourceLid) {
        this.resourceLid = resourceLid;
    }

    @Override
    public String toString() {
        return "RoleResourceInfo{" +
                "id='" + id + '\'' +
                ", roleLid='" + roleLid + '\'' +
                ", resourceLid='" + resourceLid + '\'' +
                '}';
    }
}
