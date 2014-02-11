package spring.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 保存 WebApplicationContext 到 SpringContext 类中
 * 
 * @author 刘佳
 * @version 1.0 20140208
 *
 */
public class SpringInitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		SpringContext.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}