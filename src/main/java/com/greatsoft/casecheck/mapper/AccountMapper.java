package com.greatsoft.casecheck.mapper;

import com.github.pagehelper.Page;
import com.greatsoft.casecheck.entiry.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/4/30 16:39
 */
@Mapper
public interface AccountMapper {
    /**
     * 根据业务id查
     *
     * @param lid
     * @return
     */
    List<Account> findAccountsByLid(@Param("lid") String lid);

    /**
     * 根据账号密码查询
     *
     * @param account
     * @param password
     * @return
     */
    List<Account> findAccountsByAccountAndAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 根据账号或姓名或角色名称查询
     *
     * @param account
     * @param name
     * @param roleName
     * @return
     */
    Page<Account> findAccounts(@Param("account") String account, @Param("name") String name, @Param("roleName") String roleName);

    /**
     * 更新（通用方法）
     *
     * @param account
     * @return
     */
    int updateByLid(Account account);
}
