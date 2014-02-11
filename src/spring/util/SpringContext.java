package spring.util;import java.util.Locale;import java.util.Map;import org.springframework.beans.BeansException;import org.springframework.context.ApplicationContext;import org.springframework.core.io.Resource;/** * spring 工具类 *  * @author 刘佳 * @version 1.0 20070424 初版 * @version 1.1 20140208 修改为给予Listener启动 *  */public class SpringContext {	/**	 * Spring的ApplicationContext	 */	protected static ApplicationContext appContext;	/**	 * 设置ApplicationContext	 * 	 * @param ac	 *            ApplicationContext	 * @throws BeansException	 */	public static void setApplicationContext(ApplicationContext ac)			throws BeansException {		SpringContext.appContext = ac;	}	/**	 * 取得ApplicationContext	 * 	 * @return ApplicationContext	 */	public static ApplicationContext getAppContext() {		return appContext;	}	/**	 * 取得Bean	 * 	 * @param beanName	 *            bean的名字	 * 	 * @return Object	 */	@SuppressWarnings("unchecked")	public static <E> E getBean(String beanName) {		return (E)appContext.getBean(beanName);	}		public static <T> T getBean(Class<T> cls) {		Map<String, T> map =  appContext.getBeansOfType(cls);		if(map == null) {			return null;		}		T result = null;		for (T model : map.values()) {			result = model;			break;		}		return result;	}	/**	 * 取得message	 * 	 * @param name	 * @return String	 */	public static String getMessage(String name) {		return appContext.getMessage(name, new Object[] {},				Locale.SIMPLIFIED_CHINESE);	}	/**	 * 取得message	 * 	 * @param name	 * @param para	 * @return String	 */	public static String getMessage(String name, Object[] para) {		return appContext.getMessage(name, para, Locale.SIMPLIFIED_CHINESE);	}	/**	 * 获得外部文件	 * 	 * @param path	 * @return Resource	 */	public static Resource getResource(String path) {		return appContext.getResource(path);	}		/**	 * 取得给定locale下的message	 * @param name	 * @param local	 * @return	 */	public static String getMessage(String name ,Locale local){		if(local==null){			local = Locale.SIMPLIFIED_CHINESE;		}		return appContext.getMessage(name, new Object[] {},				local);	}}