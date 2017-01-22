package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

public class ListUsers extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		for(int i = 0 ; i < 8; i ++){
			User user = new User();
			user.setName("user0" + (i + 1));
			user.setAge(22);
			users.add(user);
		}
		request.setAttribute("users",users);
		request.getRequestDispatcher("a3.jsp")
		.forward(request, response);
	}

}
