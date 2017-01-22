package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter1 implements Filter{
	public CommentFilter1(){
		System.out.println("filter1's constructor...");
	}
	public void destroy() {
		
	}
	
	/*
	 * ������ִ�����������init����֮�󣬻����
	 * doFilter��������������
	 * �����Ὣrequest,response��Ϊ�������ݹ�����
	 * ��������(FilterChain)�ṩ��һ��doFilter������
	 * ���ִ���˸÷������������������ִ�С�
	 */
	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("filter1's doFilter begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		if(content.indexOf("��") != -1){
			//������������
			out.println("<h1>���۷Ƿ�</h1>");
		}else{
			//���ú����Ĺ���������servlet
			arg2.doFilter(request, response);
		}
		System.out.println("filter1's doFilter end.");
	}
	
	/*
	 * ��������֮�󣬻���������������ʵ����
	 * ����������������ù�������init����(
	 * ֻ�����һ��)��
	 * FilterConfig������ȡ��ʼ��������
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter1's init...");
	}

}
