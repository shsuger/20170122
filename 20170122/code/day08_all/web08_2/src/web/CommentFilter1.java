package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter1 implements Filter{
	public CommentFilter1(){
		System.out.println("filter1's constructor...");
	}
	public void destroy() {
		
	}
	
	/*
	 * 容器在执行完过滤器的init方法之后，会调用
	 * doFilter方法来处理请求。
	 * 容器会将request,response作为参数传递过来。
	 * 过滤器链(FilterChain)提供了一个doFilter方法，
	 * 如果执行了该方法，容器会继续向下执行。
	 */
	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("filter1's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		if(content.indexOf("狗") != -1){
			//包含了敏感字
			out.println("<h1>评论非法</h1>");
		}else{
			//调用后续的过滤器或者servlet
			arg2.doFilter(request, response);
		}
		System.out.println("filter1's doFilter end.");
	}
	
	/*
	 * 容器启动之后，会立即创建过滤器实例。
	 * 接下来，容器会调用过滤器的init方法(
	 * 只会调用一次)。
	 * FilterConfig用来读取初始化参数。
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter1's init...");
	}

}
