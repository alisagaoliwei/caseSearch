package com.greatsoft.casecheck.dto.role;

import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 12:50
 */
public class RoleRequestDTO {
    /**
     * 业务id
     */
    private String lid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 修改后的权限
     */
    private List<String> resouceLids;

    public RoleRequestDTO() {
    }

    public RoleRequestDTO(String lid, String name) {
        this.lid = lid;
        this.name = name;
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

    public List<String> getResouceLids() {
        return resouceLids;
    }

    public void setResouceLids(List<String> resouceLids) {
        this.resouceLids = resouceLids;
    }

    @Override
    public String toString() {
        return "RoleRequestDTO{" +
                "lid='" + lid + '\'' +
                ", name='" + name + '\'' +
                ", resouceLids=" + resouceLids +
                '}';
    }
}
