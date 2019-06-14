package com.greatsoft.casecheck.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.common.Const;
import com.greatsoft.casecheck.dto.account.AccountRequestDTO;
import com.greatsoft.casecheck.dto.account.AccountResponseDTO;
import com.greatsoft.casecheck.dto.account.UpdateResponseDTO;
import com.greatsoft.casecheck.dto.role.RoleResponseDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.Role;
import com.greatsoft.casecheck.mapper.AccountMapper;
import com.greatsoft.casecheck.mapper.RoleMapper;
import com.greatsoft.casecheck.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:人员管理
 * @Author: lijiahe
 * @CreateDate: 2019/5/6 13:06
 */
@RestController
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/accounts/{lid}")
    public AjaxResponse findAccount(@PathVariable String lid) {
        log.info("查询的lid={}", lid);
        if (StringUtils.isEmpty(lid)) {
            log.info("传入的lid为空");
            return AjaxResponse.failed("传入的信息为空");
        }

        List<Account> accounts = null;
        try {
            accounts = accountMapper.findAccountsByLid(lid);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (accounts == null || accounts.size() == 0 || accounts.size() > 1) {
            log.warn("查询成功，但未找到数据");
            return AjaxResponse.failed("未找到此角色信息");
        }

        Account account = accounts.get(0);
        List<Role> roles = null;
        try {
            roles = roleMapper.findRolesNotByLid(Const.ROLE_GXSOFT_ADMIN);
        } catch (Exception e) {
            log.error("查询所有角色失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        List<RoleResponseDTO> roleResponses = new ArrayList<>();
        for (Role role : roles) {
            roleResponses.add(new RoleResponseDTO(role.getLid(), role.getName()));
        }

        if (roleResponses.size() != roles.size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", roles.size(), roleResponses.size());
            return AjaxResponse.failed("转换失败");
        }

        log.info("查询成功，数据量为：{}", roleResponses.size());
        UpdateResponseDTO updateResponse = new UpdateResponseDTO(account.getLid(), account.getAccount(), account.getName(), account.getRoleName(), account.getRoleLid(), roleResponses);
        return AjaxResponse.success("操作成功", updateResponse);

    }

    @GetMapping("/accounts/pages")
    public AjaxResponse findAccounts(String account, String name, String roleName, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        log.info("传入参数：account={}，name={}，roleName={}，pageNo={}，pageSize={}", account, name, roleName, pageNo, pageSize);
        Page<Account> accounts = null;
        try {
            PageHelper.startPage(pageNo, pageSize);
            accounts = accountMapper.findAccounts(account, name, roleName);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (accounts.getResult() == null || accounts.getResult().size() == 0) {
            log.info("查询成功，但未查到数据");
            return AjaxResponse.success("操作成功", 1);
        }

        List<AccountResponseDTO> accountResponses = new ArrayList<>();
        for (Account ac : accounts.getResult()) {
            accountResponses.add(new AccountResponseDTO(ac.getLid(), ac.getAccount(), ac.getName(), ac.getRoleName()));
        }

        if (accountResponses.size() != accounts.getResult().size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", accounts.getResult().size(), accountResponses.size());
            return AjaxResponse.failed("转换失败");
        }

        log.info("查询成功，数据量为：{}", accountResponses.size());
        return AjaxResponse.success("操作成功", pageNo, accounts.getPages(), accounts.getTotal(), accountResponses);
    }

    @PutMapping("/accounts")
    @ResponseBody
    public AjaxResponse updateAccount(@RequestBody AccountRequestDTO accountRequest) {
        log.info("AccountRequestDto需修改值={}", accountRequest.toString());

        Account account = new Account();
        account.setLid(accountRequest.getLid());
        account.setRoleLid(accountRequest.getRoleLid());
        account.setPassword(accountRequest.getPassword());
        account.setModified(new Date());

        int result = accountService.updateAccount(account);
        if (result != 1) {
            return AjaxResponse.failed("更新失败");
        }

        return AjaxResponse.success();
    }

    @DeleteMapping("/accounts/{lid}")
    @ResponseBody
    public AjaxResponse deleteAccount(@PathVariable String lid) {
        log.info("AccountRequestDto需删除的lid={}", lid);

        Account account = new Account();
        account.setLid(lid);
        account.setIsDelete(1);
        account.setModified(new Date());

        int result = accountService.updateAccount(account);
        if (result != 1) {
            return AjaxResponse.failed("删除失败");
        }

        return AjaxResponse.success();
    }

}
