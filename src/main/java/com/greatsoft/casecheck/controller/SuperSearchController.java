package com.greatsoft.casecheck.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author haoyunr
 * @Description: 超级查询接口
 * @date 2019/6/11 14:34
 */
@RestController
public class SuperSearchController {

	@Value("${ui.theme.style}")
	private String templatesFormwork;

	@Value("${ui.skin.style}")
	private String staticFormwork;

	@GetMapping("/case")
	public ModelAndView findMenuTrees() {
		ModelAndView model = new ModelAndView();
		String path = "super-search";
		String url = templatesFormwork + File.separator + "navigation" + File.separator + path;
		model.addObject("staticFormwork", staticFormwork);
		model.setViewName(url);
		return model;
	}

	@GetMapping("/query/case")
	public ModelAndView findMenuinfo() {
		ModelAndView model = new ModelAndView();
		String path = "caseSearch";
		String url = templatesFormwork + File.separator + "navigation" + File.separator + path;
		model.addObject("staticFormwork", staticFormwork);
		model.setViewName(url);
		return model;
	}

}