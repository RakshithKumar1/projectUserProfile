package com.dxc.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.dxc.project.filter.JWTValidationFilter;

@Configuration
public class FilterConfig {
	public static final String CONTACTS_PATH = "/user/*";
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		filterRegistrationBean.addUrlPatterns(CONTACTS_PATH);
		return filterRegistrationBean;
	}
	
}
