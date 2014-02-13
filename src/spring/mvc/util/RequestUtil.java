package spring.mvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 保存 Http 信息
 * 
 * @version 1.0 20140208
 *
 */
public class RequestUtil {
	/**
	 * 取得 session
	 * 
	 * @return session
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * 从 session 中取值
	 * 
	 * @param key key
	 * @return session 中的值
	 */
	public static Object getSessionAttribute(String key) {
		return getSession().getAttribute(key);
	}
	
	/**
	 * 取得 request
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 从 request 中取值
	 * 
	 * @param key key
	 * @return request 中的值
	 */
	public static Object getRequestAttribute(String key) {
		return getRequest().getAttribute(key);
	}
	
	/**
	 * 从parameter中取值
	 * 
	 * @param key key
	 * @return Param 中的值
	 */
	public static String getParamValue(String key) {
		return getRequest().getParameter(key);
	}
}
