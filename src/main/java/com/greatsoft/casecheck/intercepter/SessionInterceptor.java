package com.greatsoft.casecheck.intercepter;

import com.greatsoft.casecheck.entiry.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

		// 无需登录，允许访问的地址
		String[] allowUrls = new String[] {"/signin"};
		// 获取请求地址
		String url = request.getRequestURL().toString();

		for (String strUrl : allowUrls) {
			if (url.contains(strUrl)) {
				return true;
			}
		}

		if (account == null) {
			log.info("您尚未登陆");
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()) + path;
			response.sendRedirect(basePath + "/signin");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
