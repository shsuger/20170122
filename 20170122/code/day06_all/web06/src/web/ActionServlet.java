package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String action =
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		if("/list".equals(action)){
			try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = 
					dao.findAll();
				//step1,绑订数据到request
				request.setAttribute("employees", employees);
				//step2,获得转发器
				RequestDispatcher rd = 
					request.getRequestDispatcher("listEmp.jsp");
				//step3,转发
				rd.forward(request, response);
				}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/add".equals(action)){
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			//将员工信息插入到数据库
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name); 
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/del".equals(action)){
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				response.sendRedirect("list.do");
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/load".equals(action)){
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = dao.findById(id);
				request.setAttribute("e", e);
				request.getRequestDispatcher("updateEmp.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if("/modify".equals(action)){
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.modify(e);
				response.sendRedirect("list.do");
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

}
