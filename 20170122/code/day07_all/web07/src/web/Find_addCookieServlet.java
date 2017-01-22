package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_addCookieServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for(int i = 0;i < cookies.length; i ++){
				Cookie c = cookies[i];
				String name = c.getName();
				if("items".equals(name)){
					out.println(
							"找到了名称为items的cookie:" 
							+ c.getValue());
					flag = true;
				}
			}
			if(!flag){
				//添加cookie
				Cookie c = new Cookie("items","1,2,3");
				response.addCookie(c);
			}
		}else{
			//添加cookie
			Cookie c = new Cookie("items","1,2,3");
			response.addCookie(c);
		}
		out.close();
	}

}
