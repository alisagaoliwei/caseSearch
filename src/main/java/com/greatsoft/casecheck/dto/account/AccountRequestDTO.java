package com.greatsoft.casecheck.dto.account;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 13:17
 */
public class AccountRequestDTO {
    /**
     * 业务主键
     */
    private String lid;
    /**
     * 更改后的角色lid
     */
    private String roleLid;
    /**
     * 密码
     */
    private String password;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getRoleLid() {
        return roleLid;
    }

    public void setRoleLid(String roleLid) {
        this.roleLid = roleLid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountRequestDTO{" +
                "lid='" + lid + '\'' +
                ", roleLid='" + roleLid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
