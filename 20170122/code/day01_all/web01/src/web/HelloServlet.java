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
		 * �������������("name")����������ֵ��
		 */
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		int salary2 = Integer.parseInt(salary) * 2;
		/*
		 * ����content-type��Ϣͷ������
		 * ����������ص��������͡�
		 */
		response.setContentType("text/html");
		/*
		 * ����������
		 */
		PrintWriter out = response.getWriter();
		/*
		 * �����
		 */
		out.println(
				"<h1 style='font-size:60px;'>Hello " 
				+ name + "</h1>");
		out.close();
	}
}
