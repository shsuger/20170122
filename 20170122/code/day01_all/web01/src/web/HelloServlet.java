package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public void serivce(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		/*
		 * 依据请求参数名("name")获得请求参数值。
		 */
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		int salary2 = Integer.parseInt(salary) * 2;
		/*
		 * 设置content-type消息头，告诉
		 * 浏览器，返回的数据类型。
		 */
		response.setContentType("text/html");
		/*
		 * 获得输出流。
		 */
		PrintWriter out = response.getWriter();
		/*
		 * 输出。
		 */
		out.println(
				"<h1 style='font-size:60px;'>Hello " 
				+ name + "</h1>");
		out.close();
	}
}
