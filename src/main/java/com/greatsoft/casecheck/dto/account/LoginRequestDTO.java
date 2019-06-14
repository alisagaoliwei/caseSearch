package com.greatsoft.casecheck.dto.account;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 18:46
 */
public class LoginRequestDTO {
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
