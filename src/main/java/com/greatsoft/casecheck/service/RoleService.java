package com.greatsoft.casecheck.service;

import com.greatsoft.casecheck.dto.role.RoleRequestDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.Role;
import com.greatsoft.casecheck.entiry.RoleResourceInfo;
import com.greatsoft.casecheck.mapper.RoleMapper;
import com.greatsoft.casecheck.mapper.RoleResourceInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 16:33
 */
@Service
public class RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceInfoMapper roleResourceInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    public int deleteRole(String lid) {
        log.info("role的lid={}", lid);

        List<Role> roles = null;
        try {
            roles = roleMapper.findRolesByLid(lid);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return 0;
        }

        if (roles == null || roles.size() == 0 || roles.size() > 1) {
            log.error("查询成功，但未找到此人数据");
            return 0;
        }

        try {
            roleResourceInfoMapper.deleteByRoleLid(lid);
        } catch (Exception e) {
            log.error("删除失败，失败原因：{}", e.getMessage());
            return 0;
        }

        try {
            roleMapper.deleteRolesByLid(lid);
            return 1;
        } catch (Exception e) {
            log.error("删除失败，失败原因：{}", e.getMessage());
            return 0;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public int insertRole(RoleRequestDTO roleRequest, HttpServletRequest request) {
        if (roleRequest == null) {
            return 0;
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return 0;
        }
        Role role = new Role();
        role.setId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        role.setLid(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        role.setCreate(new Date());
        role.setCreatorId(account.getId());
        role.setCreator(account.getAccount());
        role.setModifier(account.getAccount());
        role.setModifierId(account.getId());
        role.setModified(new Date());
        role.setName(roleRequest.getName());
        try {
            roleMapper.insert(role);
        } catch (Exception e) {
            log.error("插入异常，异常原因{}", e.getMessage());
            return 0;
        }
        //向关系表中新增
        if (roleRequest.getResouceLids() != null && !roleRequest.getResouceLids().isEmpty()) {
            try {
                roleResourceInfoMapper.insertList(switchRoleResource(roleRequest, role.getLid()));
                return 1;
            } catch (Exception e) {
                log.error("插入异常,异常原因{}", e.getMessage());
                return 0;
            }
        } else {
            return 1;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public int updateRole(RoleRequestDTO roleRequest, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return 0;
        }
        Role role = new Role();
        role.setLid(roleRequest.getLid());
        role.setModified(new Date());
        role.setModifierId(account.getId());
        role.setModifier(account.getAccount());
        role.setName(roleRequest.getName());
        try {
            roleMapper.updateRolesByLid(role);
        } catch (Exception e) {
            log.error("修改异常,异常原因{}", e.getMessage());
            return 1;
        }
        try {
            roleResourceInfoMapper.deleteByRoleLid(roleRequest.getLid());
        } catch (Exception e) {
            log.error("删除异常{}", e.getMessage());
            return 0;
        }
        if (roleRequest.getResouceLids() != null && !roleRequest.getResouceLids().isEmpty()) {
            try {
                roleResourceInfoMapper.insertList(switchRoleResource(roleRequest, roleRequest.getLid()));
                return 1;
            } catch (Exception e) {
                log.error("插入异常,异常原因{}", e.getMessage());
                return 0;
            }
        }else {
            return 1;
        }
    }

    private List<RoleResourceInfo> switchRoleResource(RoleRequestDTO roleRequest, String roleLid){
        List<RoleResourceInfo> roleResourceInfos = new ArrayList<>();
        for (String str : roleRequest.getResouceLids()) {
            roleResourceInfos.add(new RoleResourceInfo(UUID.randomUUID().toString().toUpperCase().replace("-", ""), roleLid, str));
        }
        return roleResourceInfos;
    }

}
