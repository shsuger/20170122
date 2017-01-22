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

public class CommentFilter2 implements Filter{
	private FilterConfig config;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("filter2's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		//读初始化参数
		String size = config.getInitParameter("size");
		if(content.length() > Integer.parseInt(size)){
			out.println("<h1>字数过多</h1>");
		}else{
			arg2.doFilter(request, response);
		}
		System.out.println("filter2's doFilter end.");
	}
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
