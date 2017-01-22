<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>   
<html>
	<head></head>
	<body style="font-size:30px;">
		<%
			User user = new User();
			user.setName("张三");
			user.setAge(32);
			request.setAttribute("user",user);
		 %>
		  ${user.name}<br/>
		  <c:if test="${user.age > 18}" 
		  var="rs" scope="page">成年人</c:if>
		  <c:if test="${!rs}">未成年</c:if>
	</body>
</html> 