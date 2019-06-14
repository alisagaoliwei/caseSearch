package com.greatsoft.casecheck.dto.account;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 13:17
 */
public class UpdateResponseDTO {
    /**
     * 业务主键
     */
    private String lid;

    /**
     * 账号
     */
    private String account;
    /**
     * 人员姓名
     */
    private String name;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色业务id
     */
    private String roleLid;
    /**
     * 角色集合
     */
    private Object object;

    public UpdateResponseDTO() {
    }

    public UpdateResponseDTO(String lid, String account, String name, String roleName, String roleLid, Object object) {
        this.lid = lid;
        this.account = account;
        this.name = name;
        this.roleName = roleName;
        this.roleLid = roleLid;
        this.object = object;
    }
    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleLid() {
        return roleLid;
    }

    public void setRoleLid(String roleLid) {
        this.roleLid = roleLid;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "UpdateResponseDTO{" +
                "lid='" + lid + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleLid='" + roleLid + '\'' +
                ", object=" + object +
                '}';
    }
}
