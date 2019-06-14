package com.greatsoft.casecheck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatsoft.casecheck.common.AjaxResponse;
import com.greatsoft.casecheck.common.Const;
import com.greatsoft.casecheck.dto.home.HomeResponseDTO;
import com.greatsoft.casecheck.entiry.Account;
import com.greatsoft.casecheck.entiry.ResourceInfo;
import com.greatsoft.casecheck.mapper.ResourceInfoMapper;
import com.greatsoft.casecheck.service.ResourceInfoService;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/10 3:18 PM
 */
@RestController
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ResourceInfoMapper resourceInfoMapper;

	@Autowired
	private ResourceInfoService resourcesService;

	@Value("${ui.home.logo.uri}")
	private String logoUri;

	@Value("${ui.home.primary.label}")
	private String primaryLabel;

	@Value("${ui.home.secondary.label}")
	private String secondaryLabel;

	/***
	 * 根据登录用户获得权限下的菜单树
	 * 
	 * @param request
	 * @return
	 *
	 */
	@GetMapping("/homes")
	public AjaxResponse findMenuTrees(HttpServletRequest request) {
		List<HomeResponseDTO> parents = null;
		String roleLid = null;
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

		if (account == null) {
			return AjaxResponse.failed("用户未登录！");
		}

		roleLid = account.getRoleLid();

		List<ResourceInfo> resources = null;
		try {
			resources = resourceInfoMapper.findResourcesByRoleLid(roleLid);
		} catch (Exception e) {
			logger.error("查询失败，失败原因{}", e.getMessage());
			return AjaxResponse.failed("查询失败");
		}

		if (resources == null) {
			resources = new ArrayList<>();
		}

		try {
			parents = resourcesService.getMenuTrees(resources, null);
		} catch (Exception e) {
			logger.info("查询失败，失败原因{}", e.getMessage());
			return AjaxResponse.failed("查询失败");
		}

		// 如果用户是管理员，内置导航管理
		if (Const.ROLE_GXSOFT_ADMIN.equals(account.getRoleLid())) {
			HomeResponseDTO homeResponse = new HomeResponseDTO();
			homeResponse.setName("导航管理");

			HomeResponseDTO menu = new HomeResponseDTO();
			menu.setName("菜单管理");
			menu.setTotalUrl("menu-maintenance");

			HomeResponseDTO role = new HomeResponseDTO();
			role.setName("角色管理");
			role.setTotalUrl("role-management");

			HomeResponseDTO personnel = new HomeResponseDTO();
			personnel.setName("人员管理");
			personnel.setTotalUrl("personnel-management");

			HomeResponseDTO urlbase = new HomeResponseDTO();
			urlbase.setName("基准地址管理");
			urlbase.setTotalUrl("urlbase-path-management");

			homeResponse.getChildrenList().add(menu);
			homeResponse.getChildrenList().add(role);
			homeResponse.getChildrenList().add(personnel);
			homeResponse.getChildrenList().add(urlbase);

			parents.add(homeResponse);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("parents", parents);
		map.put("iconUrl", logoUri);
		map.put("topText", primaryLabel);
		map.put("downText", secondaryLabel);
		map.put("name", account.getName());
		return AjaxResponse.success("操作成功", map);
	}

}
