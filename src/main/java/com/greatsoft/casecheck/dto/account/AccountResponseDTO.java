package com.greatsoft.casecheck.dto.account;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 13:17
 */
public class AccountResponseDTO {
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


    public AccountResponseDTO() {
    }

    public AccountResponseDTO(String lid, String account, String name, String roleName) {
        this.lid = lid;
        this.account = account;
        this.name = name;
        this.roleName = roleName;
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

    @Override
    public String toString() {
        return "AccountResponseDTO{" +
                "lid='" + lid + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
