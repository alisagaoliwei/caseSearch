package com.greatsoft.casecheck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

/**
 * @Description:跳转
 * @Author: lijiahe
 * @CreateDate: 2019/3/29 15:19
 */
@Controller
public class CatalogController {
    private static final Logger log = LoggerFactory.getLogger(CatalogController.class);
    @Value("${ui.theme.style}")
    private String templatesFormwork;

    @Value("${ui.skin.style}")
    private String staticFormwork;


    @GetMapping("/{path}")
    public ModelAndView findCatalog(@PathVariable String path) {
        ModelAndView model = new ModelAndView();
        String url;
        switch (path) {
            case "home":
                url = templatesFormwork + File.separator + "navigation" + File.separator + path;
                break;
            case "welcome":
            	url = templatesFormwork + File.separator + "navigation" + File.separator + path;
            	break;
            case "menu-maintenance":
            	url = templatesFormwork + File.separator + "navigation" + File.separator + path;
            	break;
            case "personnel-management":
            	url = templatesFormwork + File.separator + "navigation" + File.separator + path;
            	break;
            case "role-management":
            	url = templatesFormwork + File.separator + "navigation" + File.separator + path;
            	break;
            case "urlbase-path-management":
                url = templatesFormwork + File.separator + "navigation" + File.separator + path;
                break;
            default:
                url = templatesFormwork + File.separator + "common" + File.separator + "signin";
                break;
        }
        log.info("请求url:{}", url);
        model.addObject("staticFormwork", staticFormwork);
        model.setViewName(url);
        return model;
    }

}
