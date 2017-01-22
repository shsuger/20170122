package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username:" + username);
//		response.sendRedirect(
//				request.getContextPath() 
//				+ "/biz03/aaa/b4.jsp");
		request.getRequestDispatcher("/biz03/aaa/b4.jsp")
		.forward(request, response);
	}

}
