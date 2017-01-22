package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if("/login".equals(action)){
			String username = 
				request.getParameter("username");
			String pwd = 
				request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.find(username);
				if(user != null 
						&& user.getPwd().equals(pwd)){
					//登录成功
					response.sendRedirect("main.jsp");
				}else{
					//登录失败
					request.setAttribute("login_failed", 
							"用户名或密码错误");
					request.getRequestDispatcher("login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
	}

}
