package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//将员工信息插入到数据库
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsd1410db",
					"root","1234");
			prep = conn.prepareStatement(
					"INSERT INTO emp(name,salary,age) " +
					"VALUES(?,?,?)");
			prep.setString(1, name);
			prep.setDouble(2, Double.parseDouble(salary));
			prep.setInt(3, Integer.parseInt(age));
			prep.executeUpdate();
			//out.println("插入成功");
			response.sendRedirect("list");
		} catch (Exception e) {
			/*
			 * step1,记录日志
			 */
			e.printStackTrace();
			/*
			 * step2,看异常能否恢复，如果能够
			 * 恢复，要立即恢复处理；如果不
			 * 能够恢复(比如，数据库服务停止,
			 * 网络中断等导致的异常，一般称之
			 * 为系统异常),则提示用户稍后重试。
			 */
			out.println("系统繁忙，稍后重试");
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		out.close();
	}
}
