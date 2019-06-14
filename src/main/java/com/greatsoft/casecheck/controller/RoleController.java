package com.greatsoft.casecheck.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.dto.home.HomeResponseDTO;
import com.greatsoft.casecheck.dto.role.RolePageResponseDTO;
import com.greatsoft.casecheck.dto.role.RoleRequestDTO;
import com.greatsoft.casecheck.dto.role.RoleResponseDTO;
import com.greatsoft.casecheck.entiry.ResourceInfo;
import com.greatsoft.casecheck.entiry.Role;
import com.greatsoft.casecheck.mapper.ResourceInfoMapper;
import com.greatsoft.casecheck.mapper.RoleMapper;
import com.greatsoft.casecheck.mapper.RoleResourceInfoMapper;
import com.greatsoft.casecheck.service.ResourceInfoService;
import com.greatsoft.casecheck.service.RoleService;
import com.greatsoft.casecheck.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/7 10:00
 */
@RestController
public class RoleController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleResourceInfoMapper roleResourceInfoMapper;

    @Autowired
    private ResourceInfoService resourceInfoService;

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @GetMapping("/roles")
    public AjaxResponse findAll() {
        List<Role> roles = null;
        try {
            roles = roleMapper.findRoles();
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }


        if (roles == null || roles.size() == 0) {
            log.info("查询成功，但未查到数据");
            return AjaxResponse.success();
        }

        List<RoleResponseDTO> roleAllResponses = new ArrayList<>();
        for (Role role : roles) {
            roleAllResponses.add(new RoleResponseDTO(role.getLid(), role.getName()));
        }
        if (roleAllResponses.size() != roles.size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", roles.size(), roleAllResponses.size());
            return AjaxResponse.failed("转换失败");
        }
        return AjaxResponse.success("操作成功", roleAllResponses);
    }

    @GetMapping("/roles/pages")
    public AjaxResponse findPages(String name, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        log.info("传入参数：name={}，pageNo={}，pageSize={}", name, pageNo, pageSize);
        Page<Role> roles = null;
        try {
            PageHelper.startPage(pageNo, pageSize);
            roles = roleMapper.findRoles(name);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (roles.getResult() == null || roles.getResult().size() == 0) {
            log.info("查询成功，但未查到数据");
            return AjaxResponse.success("操作成功", 1);
        }

        List<RolePageResponseDTO> rolePageResponses = new ArrayList<>();
        for (Role role : roles.getResult()) {
            rolePageResponses.add(new RolePageResponseDTO(role.getLid(), role.getName(), role.getCreator(), DateUtil.format(role.getCreate(), "yyyy-MM-dd")));
        }

        if (rolePageResponses.size() != roles.getResult().size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", roles.getResult().size(), rolePageResponses.size());
            return AjaxResponse.failed("转换失败");
        }

        log.info("查询成功，数据量为：{}", rolePageResponses.size());
        return AjaxResponse.success("操作成功", pageNo, roles.getPages(), roles.getTotal(), rolePageResponses);
    }

    @GetMapping("/roles/{lid}")
    public AjaxResponse findRole(@PathVariable String lid) {
        log.info("查询的lid={}", lid);
        if (StringUtils.isEmpty(lid)) {
            log.info("传入的lid为空");
            return AjaxResponse.failed("传入的信息为空");
        }

        List<Role> roles = null;
        try {
            roles = roleMapper.findRolesByLid(lid);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (roles == null || roles.size() == 0 || roles.size() > 1) {
            log.error("查询成功，但未找到数据");
            return AjaxResponse.failed("未找到此角色信息");
        }

        Role role = roles.get(0);
        List<String> resourceLids = null;
        try {
            resourceLids = roleResourceInfoMapper.findResourceLidByRoleLid(role.getLid());
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        List<ResourceInfo> resources = null;
        try {
            resources = resourceInfoMapper.findResources();
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (resources == null || resources.size() == 0) {
            log.error("查询成功，但未找到数据");
            return AjaxResponse.failed("未找到菜单信息");
        }
        List<HomeResponseDTO> menuTrees = resourceInfoService.getMenuTrees(resources, resourceLids);
        return AjaxResponse.success("操作成功", new RoleResponseDTO(role.getLid(), role.getName(), menuTrees));
    }

    @GetMapping("/roles/trees")
    public AjaxResponse findTrees() {
        List<ResourceInfo> resources = null;
        try {
            resources = resourceInfoMapper.findResources();
        } catch (Exception e) {
            log.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }
        try {
            List<HomeResponseDTO> parents = resourceInfoService.getMenuTrees(resources, null);
            return AjaxResponse.success("操作成功", parents);
        } catch (Exception e) {
            log.info("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

    }

    @PostMapping("/roles")
    @ResponseBody
    public AjaxResponse insertRole(@RequestBody RoleRequestDTO roleRequest, HttpServletRequest request) {
        log.info("角色新增入参{}", JSON.toJSON(roleRequest));
        List<String> lids = null;
        try {
            lids = roleMapper.findLidsByName(roleRequest.getName());
        } catch (Exception e) {
            log.error("查询异常,异常原因{}", e.getMessage());
            return AjaxResponse.failed("查询异常");
        }
        if (lids != null && !lids.isEmpty()) {
            return AjaxResponse.failed("角色名称重复");
        }
        int count = roleService.insertRole(roleRequest, request);
        if (count != 0) {
            return AjaxResponse.success();
        } else {
            return AjaxResponse.failed("新增失败");
        }
    }

    @PutMapping("/roles")
    @ResponseBody
    public AjaxResponse updateRole(@RequestBody RoleRequestDTO roleRequest, HttpServletRequest request) {
        log.info("角色修改入参{}", JSON.toJSON(roleRequest));
        List<String> lids = null;
        try {
            lids = roleMapper.findLidsByName(roleRequest.getName());
            if (lids != null && lids.size() > 0 && !lids.contains(roleRequest.getLid())) {
                return AjaxResponse.failed("修改的角色名称已经存在");
            }
        } catch (Exception e) {
            log.error("查询异常,异常原因{}", e.getMessage());
            return AjaxResponse.failed("查询异常");
        }
        int count = roleService.updateRole(roleRequest, request);
        if (count != 0) {
            return AjaxResponse.success();
        } else {
            return AjaxResponse.failed("修改失败");
        }
    }

    @DeleteMapping("/roles/{lid}")
    @ResponseBody
    public AjaxResponse deleteRole(@PathVariable String lid) {
        log.info("待删除角色lid={}", lid);
        if (StringUtils.isEmpty(lid)) {
            log.error("删除失败，lid为空");
            return AjaxResponse.failed("删除失败，传入的信息为空");
        }

        int result = roleService.deleteRole(lid);
        if (result != 1) {
            log.error("删除失败");
            return AjaxResponse.failed("删除失败");
        }
        return AjaxResponse.success();
    }
}
