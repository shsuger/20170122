package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sctx = getServletContext();
		sctx.setAttribute("company", "北京达内科技");
		String version = 
			sctx.getInitParameter("version");
		out.println(version);
		out.close();
	}

}
