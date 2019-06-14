package com.greatsoft.casecheck.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.dto.urlbasepath.UrlBasePathResponseDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.UrlBasePath;
import com.greatsoft.casecheck.mapper.ResourceInfoMapper;
import com.greatsoft.casecheck.mapper.UrlBasePathMapper;
import com.greatsoft.casecheck.service.UrlBasePathService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: lijiahe
 * @CreateDate: 2019/5/11 9:27
 */
@RestController
public class UrlBasePathController {
    private static final Logger log = LoggerFactory.getLogger(UrlBasePathController.class);

    @Autowired
    private UrlBasePathMapper urlBasePathMapper;
    @Autowired
    private UrlBasePathService urlBasePathService;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @GetMapping("/url-base-paths")
    public AjaxResponse findUrlBasePaths() {
        log.info("查询全部的基准地址信息");
        List<UrlBasePath> urlBasePaths = null;
        try {
            urlBasePaths = urlBasePathMapper.findUrlBasePaths();
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (urlBasePaths == null || urlBasePaths.size() == 0) {
            log.info("查询成功，但未查到数据");
            return AjaxResponse.success("操作成功", urlBasePaths);
        }

        List<UrlBasePathResponseDTO> urlBasePathResponses = new ArrayList<>();
        for (UrlBasePath ubp : urlBasePaths) {
            urlBasePathResponses.add(new UrlBasePathResponseDTO(ubp));
        }

        if (urlBasePathResponses.size() != urlBasePaths.size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", urlBasePaths.size(), urlBasePathResponses.size());
            return AjaxResponse.failed("转换失败");
        }

        log.info("查询成功，数据量为：{}", urlBasePathResponses.size());
        return AjaxResponse.success("操作成功", urlBasePathResponses);
    }

    @GetMapping("/url-base-paths/pages")
    public AjaxResponse findUrlBasePaths(String name, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        log.info("传入参数：name={}，pageNo={}，pageSize={}", name, pageNo, pageSize);
        Page<UrlBasePath> urlBasePaths = null;
        try {
            PageHelper.startPage(pageNo, pageSize);
            urlBasePaths = urlBasePathMapper.findUrlBasePaths(name);
        } catch (Exception e) {
            log.error("查询失败，失败原因：{}", e.getMessage());
            return AjaxResponse.failed("查询失败");
        }

        if (urlBasePaths.getResult() == null || urlBasePaths.getResult().size() == 0) {
            log.info("查询成功，但未查到数据");
            return AjaxResponse.success("操作成功", 1);
        }

        List<com.greatsoft.casecheck.dto.urlbasepath.UrlBasePathResponseDTO> urlBasePathResponses = new ArrayList<>();
        for (UrlBasePath ubp : urlBasePaths.getResult()) {
            urlBasePathResponses.add(new UrlBasePathResponseDTO(ubp));
        }

        if (urlBasePathResponses.size() != urlBasePaths.getResult().size()) {
            log.error("查询成功，转换dto失败,原长度={}，现长度={}", urlBasePaths.getResult().size(), urlBasePathResponses.size());
            return AjaxResponse.failed("转换失败");
        }

        log.info("查询成功，数据量为：{}", urlBasePathResponses.size());
        return AjaxResponse.success("操作成功", pageNo, urlBasePaths.getPages(), urlBasePaths.getTotal(), urlBasePathResponses);
    }

    /**
     * 修改返现
     *
     * @return
     */
    @GetMapping("/url-base-paths/{lid}")
    public AjaxResponse findUrlBasePath(@PathVariable String lid) {
        log.info("查询入参{}", lid);
        if (StringUtils.isBlank(lid)) {
            return AjaxResponse.failed("参数缺失");
        }

        UrlBasePath urlBasePath = null;
        try {
            urlBasePath = urlBasePathMapper.findUrlBasePathByLid(lid);
            return AjaxResponse.success("查询成功", urlBasePath);
        } catch (Exception e) {
            log.error("查询异常{}", e.getMessage());
            return AjaxResponse.failed("查询异常");
        }
    }

    /**
     * 新增
     *
     * @param urlBasePath
     * @return
     */
    @PostMapping("/url-base-paths")
    @ResponseBody
    public AjaxResponse insertUrlBasePath(@RequestBody UrlBasePath urlBasePath, HttpServletRequest request) {
        log.info("新增入参{}", JSON.toJSON(urlBasePath));
        if (urlBasePath == null) {
            return AjaxResponse.failed("参数缺失");
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        List<String> lidsByName = null;
        try {
            lidsByName = urlBasePathMapper.findLidsByName(urlBasePath.getName());
        } catch (Exception e) {
            log.error("查询异常,异常原因{}", e.getMessage());
            return AjaxResponse.failed("查询名称异常");
        }

        if (lidsByName != null && !lidsByName.isEmpty()) {
            return AjaxResponse.failed("基本地址名称重复");
        }

        urlBasePath.setCreator(account.getAccount());
        urlBasePath.setCreatorId(account.getLid());
        urlBasePath.setModifier(account.getAccount());
        urlBasePath.setModifierId(account.getLid());
        urlBasePath.setCreate(new Date());
        urlBasePath.setModified(new Date());

        int count = urlBasePathService.insertUrlBasePath(urlBasePath);

        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("新增失败");

    }

    /**
     * 修改
     *
     * @param urlBasePath
     * @return
     */
    @PutMapping("/url-base-paths")
    @ResponseBody
    public AjaxResponse updateUrlBasePath(@RequestBody UrlBasePath urlBasePath, HttpServletRequest request) {
        log.info("修改入参{}", urlBasePath.toString());
        if (urlBasePath == null) {
            return AjaxResponse.failed("参数缺失");
        }

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return AjaxResponse.failed("用户未登录！");
        }

        List<String> lidsByName = null;
        try {
            lidsByName = urlBasePathMapper.findLidsByName(urlBasePath.getName());
        } catch (Exception e) {
            log.error("查询异常,异常原因{}", e.getMessage());
            return AjaxResponse.failed("查询名称异常");
        }

        if (lidsByName != null && !lidsByName.isEmpty() && !lidsByName.contains(urlBasePath.getLid())) {
            return AjaxResponse.failed("基本地址名称重复");
        }

        urlBasePath.setModifier(account.getAccount());
        urlBasePath.setModifierId(account.getLid());
        urlBasePath.setModified(new Date());

        int count = urlBasePathService.updateUrlBasePath(urlBasePath);

        if (count != 0) {
            return AjaxResponse.success();
        }
        return AjaxResponse.failed("修改失败");
    }

    /**
     * 删除
     *
     * @param lid
     * @return
     */
    @DeleteMapping("/url-base-paths/{lid}")
    @ResponseBody
    public AjaxResponse deleteUrlBasePath(@PathVariable String lid) {
        log.info("删除入参{}", lid);
        if (StringUtils.isBlank(lid)) {
            return AjaxResponse.failed("参数缺失");
        }

        int byUrlLid = 0;

        try {
            byUrlLid = resourceInfoMapper.countByUrlLid(lid);
        } catch (Exception e) {
            log.error("根据业务主键查询失败{}", e.getMessage());
        }

        if (byUrlLid != 0) {
            return AjaxResponse.failed("该基本地址已经被菜单使用,不能删除");
        }

        int count = urlBasePathService.deleteByLid(lid);

        if (count != 0) {
            return AjaxResponse.success();
        }

        return AjaxResponse.failed("删除失败");
    }
}
