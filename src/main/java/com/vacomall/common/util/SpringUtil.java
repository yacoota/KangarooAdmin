package com.vacomall.common.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * Spring 工具类
 * @author gaojun.zhou
 * @date 2016年8月23日
 *
 */
@Component
@WebListener
public class SpringUtil implements ServletContextListener {

	private static WebApplicationContext springContext;

	public void contextInitialized(ServletContextEvent event) {
		springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent event) {
		
	}

	public static ApplicationContext getApplicationContext() {
		return springContext;
	}

	public SpringUtil() {
	}
	
	
	public static <T> T getBean(Class<T> requiredType){
		
		if(springContext == null){
			
			throw new RuntimeException("springContext is null.");
		}
		return springContext.getBean(requiredType);
	}
	
}
