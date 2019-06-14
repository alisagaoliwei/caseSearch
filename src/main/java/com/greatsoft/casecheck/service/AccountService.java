package com.greatsoft.casecheck.service;

import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 10:42
 */
@Service
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    public int updateAccount(Account account) {
        log.info("传入的Account值为={}", account.toString());
        int result = 0;

        try {
            result = accountMapper.updateByLid(account);
        } catch (Exception e) {
            log.error("更新失败，失败原因：{}", e.getMessage());
            return result;
        }

        log.info("更改后返回的值reslut={}", result);
        return result;
    }
}
