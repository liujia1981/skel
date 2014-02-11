package spring.mvc.util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 保存 session 的 listener
 * 
 * @version 1.0 20140208
 *
 */
public class HttpInfoHolderListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpInfoHolder.destroy();
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		HttpInfoHolder.init(request);
	}
}
