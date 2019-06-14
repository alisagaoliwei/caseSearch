package com.greatsoft.casecheck.controller;

import com.alibaba.fastjson.JSON;
import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.dto.resource.ResourceResponseDTO;
import com.greatsoft.casecheck.dto.resource.ResourcesInfoUpdateDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.ResourceInfo;
import com.greatsoft.casecheck.entiry.UrlBasePath;
import com.greatsoft.casecheck.mapper.ResourceInfoMapper;
import com.greatsoft.casecheck.mapper.UrlBasePathMapper;
import com.greatsoft.casecheck.service.ResourceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Description: 菜单
 * @Author: yangzhanbiao
 * @CreateDate: 2019年05月06日10:40:54
 */
@RestController
public class ResourceController {
    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);
    @Autowired
    private ResourceInfoService resourcesService;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;
    @Autowired
    private UrlBasePathMapper urlBasePathMapper;

    /**
     * 菜单管理列表展示
     *
     * @param request
     * @param pid
     * @return
     */
    @GetMapping("/menus")
    public AjaxResponse findMenuTables(HttpServletRequest request, String pid) {
        logger.info("入参{}", pid);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        List<ResourceInfo> resources = null;
        try {
            resources = resourceInfoMapper.findResourcesByRoleLidAndPid(account.getRoleLid(), pid);
        } catch (Exception e) {
            logger.error("查询异常");
            return AjaxResponse.failed("查询异常");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<ResourceResponseDTO> responseDtos = new ArrayList<>();
        for (ResourceInfo resourceInfo : resources) {
            ResourceResponseDTO dto = new ResourceResponseDTO(resourceInfo);

            if (resourceInfo.getCreate() != null) {
                dto.setCreate(format.format(resourceInfo.getCreate()));
            }

            if (resourceInfo.getModified() != null) {
                dto.setModified(format.format(resourceInfo.getModified()));
            }

            responseDtos.add(dto);
        }
        return AjaxResponse.success("查询成功", responseDtos);

    }

    /**
     * 修改返显接口
     *
     * @param id
     * @return
     */
    @GetMapping("/menus/{id}")
    public AjaxResponse detail(@PathVariable String id) {
        logger.info("入参{}", id);
        if (StringUtils.isBlank(id)) {
            return AjaxResponse.failed("参数缺失");
        }

        List<UrlBasePath> urlBasePaths = null;
        try {
            urlBasePaths = urlBasePathMapper.findUrlBasePaths();
        } catch (Exception e) {
            logger.error("查询基准地址异常,异常原因{}", e.getMessage());
            return AjaxResponse.failed("查询基准地址异常");
        }

        if("oneleve".equals(id)){
            return AjaxResponse.success("操作成功", urlBasePaths);
        }

        ResourceInfo resource = null;
        try {
            resource = resourceInfoMapper.findResourceById(id);
        } catch (Exception e) {
            logger.error("查询异常", e.getMessage());
            return AjaxResponse.failed("查询异常");
        }

        if (resource == null) {
            return AjaxResponse.failed("未找到数据");
        }

        ResourceInfo parent = null;
        if (StringUtils.isNotBlank(resource.getPid())) {
            try {
                parent = resourceInfoMapper.findResourceById(resource.getPid());
            } catch (Exception e) {
                logger.error("查询异常,失败原因{}", e.getMessage());
                return AjaxResponse.failed("查询异常");
            }
        }

        ResourceResponseDTO detail = new ResourceResponseDTO(resource);
        if (parent != null) {
            detail.setPerentName(parent.getName());
        }

        detail.setUrlBasePaths(urlBasePaths);
        return AjaxResponse.success("查询成功", detail);
    }

    /**
     * 新增菜单
     *
     * @param resources
     * @return
     */
    @PostMapping("/menus")
    @ResponseBody
    public AjaxResponse insertResource(@RequestBody ResourceInfo resources, HttpServletRequest request) {
        logger.info("新增入参{}", JSON.toJSON(resources));
        if (resources == null) {
            return AjaxResponse.failed("参数缺失");
        }

        if("0".equals(resources.getUrlLid())){
            resources.setUrlLid(null);
        }

        List<String> resourcesByName = null;
        try {
            resourcesByName = resourceInfoMapper.findIdsByPidAndName(resources.getPid(), resources.getName());
        } catch (Exception e) {
            logger.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询菜单名字报错");
        }

        if (resourcesByName != null && !resourcesByName.isEmpty()) {
            return AjaxResponse.failed("该级别下菜单名字重复");
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        resources.setCreator(account.getAccount());
        resources.setCreatorId(account.getLid());
        resources.setModifier(account.getAccount());
        resources.setModifierId(account.getLid());
        resources.setCreate(new Date());
        resources.setModified(new Date());

        int count = resourcesService.insertResource(resources, account);

        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("插入失败");

    }

    /**
     * 修改菜单
     *
     * @param resources
     * @return
     */
    @PutMapping("/menus")
    @ResponseBody
    public AjaxResponse updateResource(@RequestBody ResourceInfo resources, HttpServletRequest request) {
        logger.info("修改入参{}", JSON.toJSON(resources));
        if (resources == null) {
            return AjaxResponse.failed("参数缺失");
        }

        List<String> resourcesByName = null;
        try {
            resourcesByName = resourceInfoMapper.findIdsByPidAndName(resources.getPid(), resources.getName());
        } catch (Exception e) {
            logger.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询菜单名字报错");
        }

        if (resourcesByName != null && !resourcesByName.isEmpty() && !resourcesByName.contains(resources.getId())) {
            return AjaxResponse.failed("该级别下菜单名字重复");
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        resources.setModifier(account.getAccount());
        resources.setModifierId(account.getLid());
        resources.setModified(new Date());

        int count = resourcesService.updateResourceInfo(resources);

        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("修改失败");


    }

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/menus/{id}")
    @ResponseBody
    public AjaxResponse deleteResource(@PathVariable String id) {
        logger.info("删除入参{}", id);
        if (StringUtils.isBlank(id)) {
            return AjaxResponse.failed("参数缺失");
        }

        ResourceInfo resourceInfo = resourceInfoMapper.findResourceById(id);
        if (resourceInfo == null) {
            return AjaxResponse.failed("该条信息不存在");
        }

        List<ResourceInfo> resourceInfos = resourceInfoMapper.findResourcesByPid(id);
        if (resourceInfos != null && !resourceInfos.isEmpty()) {
            return AjaxResponse.failed("该菜单下有子菜单不能删除");
        }

        int count = resourcesService.delete(resourceInfo.getLid());
        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("删除失败");
    }

    /**
     * 菜单移动位置
     *
     * @param dto
     * @return
     */
    @PutMapping("/move")
    @ResponseBody
    public AjaxResponse moveResource(@RequestBody ResourcesInfoUpdateDTO dto, HttpServletRequest request) {
        logger.info("入参{}", JSON.toJSON(dto));
        if (dto == null) {
            return AjaxResponse.failed("参数缺失");
        }

        ResourceInfo source = null;
        try {
            source = resourceInfoMapper.findResourceById(dto.getSourceId());
        } catch (Exception e) {
            logger.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (source == null) {
            return AjaxResponse.failed("该菜单不存在");
        }

        ResourceInfo target = null;
        try {
            target = resourceInfoMapper.findResourceByNoAndPid(dto.getTargetNo(), source.getPid());
        } catch (Exception e) {
            logger.error("查询失败，失败原因{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (target == null) {
            return AjaxResponse.failed("目标菜单不存在");
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        int count = resourcesService.moveResource(source.getId(), target.getId(), source.getSerialNo(), target.getSerialNo(), null);

        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("修改失败");
    }


}
