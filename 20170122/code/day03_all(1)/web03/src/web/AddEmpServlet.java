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
		//��Ա����Ϣ���뵽���ݿ�
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
			//out.println("����ɹ�");
			response.sendRedirect("list");
		} catch (Exception e) {
			/*
			 * step1,��¼��־
			 */
			e.printStackTrace();
			/*
			 * step2,���쳣�ܷ�ָ�������ܹ�
			 * �ָ���Ҫ�����ָ����������
			 * �ܹ��ָ�(���磬���ݿ����ֹͣ,
			 * �����жϵȵ��µ��쳣��һ���֮
			 * Ϊϵͳ�쳣),����ʾ�û��Ժ����ԡ�
			 */
			out.println("ϵͳ��æ���Ժ�����");
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
