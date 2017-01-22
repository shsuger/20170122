package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if("/login".equals(action)){
			/*
			 * �ȱȽ���֤���Ƿ���ȷ,���
			 * ��֤���������û���Ӧ��ʾ��
			 * ���򣬽�����һ���ıȽ�
			 */
			String number1 = 
				request.getParameter("number");
			HttpSession session = request.getSession();
			String number2 =
				(String)session.getAttribute("number");
			if(!number1.equalsIgnoreCase(number2)){
				//��֤�����
				request.setAttribute("number_error", 
						"��֤�����");
				request.getRequestDispatcher("login.jsp")
				.forward(request, response);
				return;
			}
			String username = 
				request.getParameter("username");
			String pwd = 
				request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.find(username);
				if(user != null 
						&& user.getPwd().equals(pwd)){
					//��¼�ɹ�
					session.setAttribute("user", user);
					response.sendRedirect("main.jsp");
				}else{
					//��¼ʧ��
					request.setAttribute("login_failed", 
							"�û������������");
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
