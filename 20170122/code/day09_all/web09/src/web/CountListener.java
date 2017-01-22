package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class CountListener implements 
HttpSessionListener{

	/**
	 * 容器创建session对象之后，会调用该方法。
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count = (Integer)sctx.getAttribute("count");
		if(count == null){
			count = 1;
		}else{
			count ++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * 容器销毁session对象之后，会调用该方法。
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed...");
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		Integer count = (Integer)sctx.getAttribute("count");
		if(count == null){
			count = 1;
		}else{
			count --;
		}
		sctx.setAttribute("count", count);
	}
	
}
