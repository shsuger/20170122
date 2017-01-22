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
			user.setName("公孙止");
			user.setAge(13);
			user.setGender("m");
			request.setAttribute("user",user);
		 %>
		 <c:choose>
		 	<c:when test="${user.age > 60}">老年人</c:when>
		 	<c:when test="${user.age <=60 && user.age > 20}">青壮年</c:when>
		 	<c:otherwise>未成人</c:otherwise>
		 </c:choose>
		 <c:choose>
		 	<c:when test="${user.gender =='m'}">男</c:when>
		 	<c:when test="${user.gender =='f'}">女</c:when>
		 	<c:otherwise>未知</c:otherwise>
		 </c:choose>
		 
	</body>
</html> 