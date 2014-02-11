package spring.mvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 保存 Http 信息
 * 
 * @version 1.0 20140208
 *
 */
public class HttpInfoHolder {
	private static ThreadLocal<HttpSession> sessionHolder;
	private static ThreadLocal<HttpServletRequest> requestHolder;
	
	/**
	 * 初始化 holder
	 * 
	 * @param req HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public static void init(HttpServletRequest req) {
		sessionHolder = new ThreadLocal<HttpSession>();
		requestHolder = new ThreadLocal<HttpServletRequest>();
		
		requestHolder.set(req);
		sessionHolder.set(req.getSession());
	}
	
	/**
	 * 清空 holder
	 */
	public static void destroy() {
		sessionHolder.remove();
		requestHolder.remove();
	}
	
	/**
	 * 取得 session
	 * 
	 * @return session
	 */
	public static HttpSession getSession() {
		return sessionHolder.get();
	}
	
	/**
	 * 从 session 中取值
	 * 
	 * @param key key
	 * @return session 中的值
	 */
	public static Object getValue(String key) {
		return getSession().getAttribute(key);
	}
	
	/**
	 * 取得 request
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		return requestHolder.get();
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
