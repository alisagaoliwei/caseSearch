package com.greatsoft.casecheck.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.greatsoft.casecheck.intercepter.SessionInterceptor;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 可添加多个
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("/signin", "/",
				"/default/**", "/case");
	}

}
